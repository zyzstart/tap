package com.tencent.midas.comm.log.internal;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APLogAppender {
    private static final int AUTO_FLUSH_INTERVAL = 15000;
    private static final int BUFFER_BLOCK_SIZE = 153600;
    private static final int POSITION_INIT = 12;
    private static boolean stopAutoFlush = false;
    private com.tencent.midas.comm.log.processor.APLogCompressor mCompressor = null;
    private com.tencent.midas.comm.log.processor.APLogEncryptor mEncryptor = null;
    private com.tencent.midas.comm.log.processor.APLogWriter mWriter = null;
    private java.io.RandomAccessFile randomAccessFile = null;
    private java.nio.channels.FileChannel fileChannel = null;
    private java.nio.MappedByteBuffer mappedByteBuffer = null;
    private java.lang.Thread autoFlushThread = null;
    private volatile long seq = 12;
    private final byte[] _bytes = new byte[0];
    private final java.lang.String SPACE = " ";
    private byte[] EMPTY_BUFFER = new byte[BUFFER_BLOCK_SIZE];
    private java.lang.String FLAG_BEGIN = "============mmap cache begin===========\r\n";
    private java.lang.String FLAG_END = "============mmap cache end=============\r\n";

    private APLogAppender() {
    }

    private synchronized void checkAndFlushBuffer() {
        try {
            if (this.mappedByteBuffer == null) {
                return;
            }
            int i = (int) this.mappedByteBuffer.getLong(0);
            if (i <= 12) {
                this.seq = 12L;
            } else {
                flushBuffer(i - 12);
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "check and flush buffer error: <%s>%s", th.getClass().getName(), th.getMessage()));
        }
    }

    private void createBufferProcessor() {
        if (com.tencent.midas.comm.APLog.getLogInfo() != null && com.tencent.midas.comm.APLog.getLogInfo().isCompressLog()) {
            this.mCompressor = com.tencent.midas.comm.log.processor.APLogCompressor.create();
        }
        if (com.tencent.midas.comm.APLog.getLogInfo() != null && com.tencent.midas.comm.APLog.getLogInfo().isEncryptLog()) {
            this.mEncryptor = com.tencent.midas.comm.log.processor.APLogEncryptor.create();
        }
        this.mWriter = com.tencent.midas.comm.log.processor.APLogWriter.create();
    }

    private void flushBuffer(int i) {
        if (this.mappedByteBuffer == null) {
            return;
        }
        if (i > BUFFER_BLOCK_SIZE) {
            i = BUFFER_BLOCK_SIZE;
        }
        byte[] bArr = new byte[i];
        this.mappedByteBuffer.position(12);
        this.mappedByteBuffer.get(bArr);
        android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, "__flush and write data size: " + i);
        this.mWriter.write(bArr, process(this.FLAG_BEGIN), process(this.FLAG_END));
        this.mappedByteBuffer.position(12);
        this.mappedByteBuffer.put(this.EMPTY_BUFFER, 12, i);
        this.mappedByteBuffer.putLong(0, 0L);
        resetPosAndSeq();
    }

    private void initMmap() {
        if (this.mappedByteBuffer == null) {
            return;
        }
        checkAndFlushBuffer();
        this.mappedByteBuffer.putLong(0, 12L);
        this.mappedByteBuffer.putInt(8, 39);
        resetPosAndSeq();
    }

    public static com.tencent.midas.comm.log.internal.APLogAppender open() {
        android.util.Log.w(com.tencent.midas.comm.APLogInfo.LOG_TAG, "open log appender");
        com.tencent.midas.comm.log.internal.APLogAppender aPLogAppender = new com.tencent.midas.comm.log.internal.APLogAppender();
        aPLogAppender.createBufferProcessor();
        aPLogAppender.openMmapFile();
        aPLogAppender.initMmap();
        aPLogAppender.startAutoFlush();
        return aPLogAppender;
    }

    private void openMmapFile() {
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(com.tencent.midas.comm.log.APLogFileInfo.mmapName, "rw");
            this.randomAccessFile = randomAccessFile;
            java.nio.channels.FileChannel channel = randomAccessFile.getChannel();
            this.fileChannel = channel;
            this.mappedByteBuffer = channel.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0L, 153600L);
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "open log mmap file error: <%s>%s", th.getClass().getName(), th.getMessage()));
            th.printStackTrace();
        }
    }

    private synchronized byte[] process(java.lang.String str) {
        byte[] bytes;
        try {
            bytes = (java.lang.System.currentTimeMillis() + " " + str).getBytes();
            if (this.mCompressor != null) {
                bytes = this.mCompressor.compress(bytes);
            }
            if (this.mEncryptor != null) {
                bytes = this.mEncryptor.encrypt(bytes);
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "process log error: <%s>%s", th.getClass().getName(), th.getMessage()));
            return this._bytes;
        }
        return bytes;
    }

    private void resetPosAndSeq() {
        java.nio.MappedByteBuffer mappedByteBuffer = this.mappedByteBuffer;
        if (mappedByteBuffer == null) {
            return;
        }
        this.seq = 12L;
        mappedByteBuffer.position(12);
    }

    private void startAutoFlush() {
        if (com.tencent.midas.comm.APLog.getLogInfo() != null && com.tencent.midas.comm.APLog.getLogInfo().isAutoFlush() && this.autoFlushThread == null) {
            java.lang.Thread thread = new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.midas.comm.log.internal.APLogAppender.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            java.lang.Thread.sleep(15000L);
                        } catch (java.lang.InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (com.tencent.midas.comm.log.internal.APLogAppender.stopAutoFlush) {
                            android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, "stop auto flush");
                            return;
                        }
                        com.tencent.midas.comm.log.internal.APLogAppender.this.flushAndWrite();
                    }
                }
            });
            this.autoFlushThread = thread;
            thread.start();
        }
    }

    private void stopAutoFlush() {
        stopAutoFlush = true;
    }

    public void append(java.lang.String str) {
        try {
            updateMmap(process(str));
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "append log error: <%s> %s", th.getClass().getName(), th.getMessage()));
        }
    }

    public void flushAndWrite() {
        try {
            checkAndFlushBuffer();
            if (this.mWriter != null) {
                this.mWriter.flush();
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "flush buffer and write error: <%s>%s", th.getClass().getName(), th.getMessage()));
        }
    }

    public synchronized void updateMmap(byte[] bArr) {
        if (this.seq + ((long) bArr.length) > 102400) {
            checkAndFlushBuffer();
        }
        java.nio.MappedByteBuffer mappedByteBuffer = this.mappedByteBuffer;
        if (mappedByteBuffer == null) {
            return;
        }
        mappedByteBuffer.put(bArr);
        this.seq += (long) bArr.length;
        this.mappedByteBuffer.putLong(0, this.seq);
    }
}
