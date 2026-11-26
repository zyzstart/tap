package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1562a = 1024;
    private short[] b = new short[1024];
    private int c;

    /* JADX WARN: Multi-variable type inference failed */
    public java.util.ArrayList<short[]> a(short[] sArr, int i) {
        java.util.ArrayList<short[]> arrayList = new java.util.ArrayList<>(4);
        int i2 = 0;
        while (i > 0) {
            int i3 = this.c;
            if (i <= 1024 - i3) {
                java.lang.System.arraycopy(sArr, i2, this.b, i3, i);
                this.c += i;
                i2 += i;
                i -= i;
            } else {
                int i4 = 1024 - i3;
                java.lang.System.arraycopy(sArr, i2, this.b, i3, i4);
                arrayList.add(this.b.clone());
                this.c = 0;
                i2 += i4;
                i -= i4;
            }
        }
        return arrayList;
    }

    public short[] a() {
        int i = this.c;
        if (i <= 0) {
            return null;
        }
        short[] sArr = new short[i];
        java.lang.System.arraycopy(this.b, 0, sArr, 0, i);
        return sArr;
    }
}
