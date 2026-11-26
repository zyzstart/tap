package com.youme.voice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WAVHeadInfo {
    private byte[] riffID = {82, 73, 70, 70};
    private int fileSize = 0;
    private byte[] riffFormat = {87, 65, 86, 69};
    private byte[] fmtID = {102, 109, 116, 32};
    private int fmtSize = 16;
    private short formatTag = 1;
    private short channels = 1;
    private int sampleRate = 16000;
    private int byteRate = 0;
    private short blockAlign = 0;
    private short sampleBitSize = 16;
    private byte[] dataID = {100, 97, 116, 97};
    private int dataChunkSize = 0;

    public void SetAudioProperty(int i, int i2, int i3) {
        this.channels = (short) i2;
        this.sampleRate = i;
        this.sampleBitSize = (short) i3;
        this.byteRate = ((i * this.channels) * i3) / 8;
        this.blockAlign = (short) ((i2 * i3) / 8);
    }

    public boolean WriteHeadInfo(java.lang.String str) {
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "rwd");
            int length = (int) randomAccessFile.length();
            this.fileSize = length - 8;
            this.dataChunkSize = length - 44;
            java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(44);
            byteBufferAllocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.put(this.riffID);
            byteBufferAllocate.putInt(this.fileSize);
            byteBufferAllocate.put(this.riffFormat);
            byteBufferAllocate.put(this.fmtID);
            byteBufferAllocate.putInt(this.fmtSize);
            byteBufferAllocate.putShort(this.formatTag);
            byteBufferAllocate.putShort(this.channels);
            byteBufferAllocate.putInt(this.sampleRate);
            byteBufferAllocate.putInt(this.byteRate);
            byteBufferAllocate.putShort(this.blockAlign);
            byteBufferAllocate.putShort(this.sampleBitSize);
            byteBufferAllocate.put(this.dataID);
            byteBufferAllocate.putInt(this.dataChunkSize);
            randomAccessFile.write(byteBufferAllocate.array(), 0, 44);
            randomAccessFile.close();
            return true;
        } catch (java.lang.Exception e) {
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "write wav head failed");
            e.printStackTrace();
            return false;
        }
    }
}
