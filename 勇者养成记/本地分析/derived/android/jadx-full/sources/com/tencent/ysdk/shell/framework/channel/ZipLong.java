package com.tencent.ysdk.shell.framework.channel;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ZipLong implements java.lang.Cloneable {
    private long value;

    public ZipLong(long j) {
        this.value = j;
    }

    public ZipLong(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipLong(byte[] bArr, int i) {
        this.value = ((long) (bArr[i + 3] << 24)) & 4278190080L;
        this.value += (long) ((bArr[i + 2] << 16) & 16711680);
        this.value += (long) ((bArr[i + 1] << 8) & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        this.value += (long) (bArr[i] & 255);
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.tencent.ysdk.shell.framework.channel.ZipLong) && this.value == ((com.tencent.ysdk.shell.framework.channel.ZipLong) obj).getValue();
    }

    public byte[] getBytes() {
        long j = this.value;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return (int) this.value;
    }
}
