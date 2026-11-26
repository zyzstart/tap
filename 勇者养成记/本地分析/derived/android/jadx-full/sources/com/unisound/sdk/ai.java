package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1515a = true;
    private boolean b = true;

    public void a() {
        this.b = true;
    }

    public boolean a(byte[] bArr, int i, int i2) {
        if (this.b && f1515a) {
            int i3 = 0;
            while (i < i2) {
                if (bArr[i] != 0) {
                    i3++;
                }
                i++;
            }
            if (i3 > 1) {
                this.b = false;
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return (this.b && f1515a) ? false : true;
    }
}
