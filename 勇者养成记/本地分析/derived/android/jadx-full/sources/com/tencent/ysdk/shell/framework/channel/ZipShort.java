package com.tencent.ysdk.shell.framework.channel;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ZipShort implements java.lang.Cloneable {
    private int value;

    public ZipShort(int i) {
        this.value = i;
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i) {
        this.value = (bArr[i + 1] << 8) & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.value += bArr[i] & 255;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.tencent.ysdk.shell.framework.channel.ZipShort) && this.value == ((com.tencent.ysdk.shell.framework.channel.ZipShort) obj).getValue();
    }

    public byte[] getBytes() {
        int i = this.value;
        return new byte[]{(byte) (i & 255), (byte) ((i & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
