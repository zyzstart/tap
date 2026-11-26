package com.tencent.midas.comm.log.util.compressor;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GzipCompressorOutputStream extends java.io.OutputStream {
    private boolean closed;
    private final java.io.OutputStream out;
    private final byte[] deflateBuffer = new byte[512];
    private final java.util.zip.CRC32 crc = new java.util.zip.CRC32();
    private final byte[] _header = {31, -117, 8, 0, 0, 0, 0, 0, 0, 0};
    private final java.util.zip.Deflater deflater = new java.util.zip.Deflater(-1, true);

    public GzipCompressorOutputStream(java.io.OutputStream outputStream) {
        this.out = outputStream;
    }

    private void deflate() throws java.io.IOException {
        java.util.zip.Deflater deflater = this.deflater;
        byte[] bArr = this.deflateBuffer;
        int iDeflate = deflater.deflate(bArr, 0, bArr.length);
        if (iDeflate > 0) {
            this.out.write(this.deflateBuffer, 0, iDeflate);
        }
    }

    private void writeTrailer() throws java.io.IOException {
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(8);
        byteBufferAllocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt((int) this.crc.getValue());
        byteBufferAllocate.putInt(this.deflater.getTotalIn());
        this.out.write(byteBufferAllocate.array());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.closed) {
            return;
        }
        finish();
        this.deflater.end();
        this.out.close();
        this.closed = true;
    }

    public void continued() {
        this.crc.reset();
        this.deflater.reset();
    }

    public void finish() throws java.io.IOException {
        if (this.deflater.finished()) {
            return;
        }
        this.deflater.finish();
        while (!this.deflater.finished()) {
            deflate();
        }
        writeTrailer();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) (i & 255)}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.deflater.finished()) {
            throw new java.io.IOException("Cannot write more data, the end of the compressed data stream has been reached");
        }
        if (i2 > 0) {
            this.deflater.setInput(bArr, i, i2);
            while (!this.deflater.needsInput()) {
                deflate();
            }
            this.crc.update(bArr, i, i2);
        }
    }

    public void writeHeader() throws java.io.IOException {
        this.out.write(this._header);
    }
}
