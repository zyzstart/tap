package com.tencent.midas.comm.log.processor;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APLogWriter {
    private java.nio.channels.FileChannel fileChannel = null;
    private java.nio.MappedByteBuffer mappedByteBuffer = null;
    private java.io.RandomAccessFile randomAccessFile = null;

    public static com.tencent.midas.comm.log.processor.APLogWriter create() {
        com.tencent.midas.comm.log.processor.APLogWriter aPLogWriter = new com.tencent.midas.comm.log.processor.APLogWriter();
        aPLogWriter.openLogFile();
        return aPLogWriter;
    }

    private void openLogFile() {
        try {
            android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, "open log file: " + com.tencent.midas.comm.log.APLogFileInfo.fileName);
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(com.tencent.midas.comm.log.APLogFileInfo.fileName, "rw");
            this.randomAccessFile = randomAccessFile;
            this.fileChannel = randomAccessFile.getChannel();
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private long refreshFileChannel(long j) {
        long size;
        try {
            size = this.fileChannel.size();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, "get file channel size error");
            com.tencent.midas.comm.log.APLogFileInfo.updateFileName();
            openLogFile();
            size = 0;
        }
        long j2 = com.tencent.midas.comm.log.util.APLogFileUtil.maxLogFileSizeMB * 1024 * 1024;
        long j3 = (j + size) - j2;
        android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "size to write: %d, channel size: %d, limit: %d", java.lang.Long.valueOf(j), java.lang.Long.valueOf(size), java.lang.Long.valueOf(j2)));
        if (j3 <= 0) {
            return size;
        }
        android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, "should refresh file name");
        com.tencent.midas.comm.log.APLogFileInfo.updateFileName();
        openLogFile();
        return 0L;
    }

    public void close() {
        try {
            if (this.fileChannel != null) {
                this.fileChannel.close();
            }
            if (this.randomAccessFile != null) {
                this.randomAccessFile.close();
            }
            if (this.mappedByteBuffer != null) {
                this.mappedByteBuffer.force();
                this.mappedByteBuffer.clear();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void flush() {
        java.nio.MappedByteBuffer mappedByteBuffer = this.mappedByteBuffer;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.force();
        }
    }

    public void write(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            long jRefreshFileChannel = refreshFileChannel(bArr.length);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            this.mappedByteBuffer = this.fileChannel.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, jRefreshFileChannel, bArr.length + bArr2.length + bArr3.length);
            long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
            long jCurrentTimeMillis3 = java.lang.System.currentTimeMillis();
            this.mappedByteBuffer.put(bArr2);
            this.mappedByteBuffer.put(bArr);
            this.mappedByteBuffer.put(bArr3);
            this.mappedByteBuffer.force();
            android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, "write map time: " + jCurrentTimeMillis2 + ", sync time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis3));
            com.tencent.midas.comm.log.util.APLogFileUtil.deleteOldFileToday(com.tencent.midas.comm.log.APLogFileInfo.dirName);
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "cache log to file error: <%s>%s", th.getClass().getName(), th.getMessage()));
        }
    }
}
