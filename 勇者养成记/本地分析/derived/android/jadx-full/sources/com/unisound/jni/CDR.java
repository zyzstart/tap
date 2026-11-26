package com.unisound.jni;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CDR {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1506a = init();

    static {
        java.lang.System.loadLibrary("cdr");
    }

    public native int init();

    public native byte[] process(byte[] bArr);

    public void release() {
        release(this.f1506a);
    }

    public native void release(int i);

    public byte[] write(byte[] bArr) {
        return process(bArr);
    }
}
