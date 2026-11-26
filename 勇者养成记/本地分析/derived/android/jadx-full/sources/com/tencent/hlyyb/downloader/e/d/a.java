package com.tencent.hlyyb.downloader.e.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {
    private static int[] g = {com.tencent.hlyyb.downloader.e.d.b.c, com.tencent.hlyyb.downloader.e.d.b.b, com.tencent.hlyyb.downloader.e.d.b.f, com.tencent.hlyyb.downloader.e.d.b.e, com.tencent.hlyyb.downloader.e.d.b.j, com.tencent.hlyyb.downloader.e.d.b.d, com.tencent.hlyyb.downloader.e.d.b.h, com.tencent.hlyyb.downloader.e.d.b.i, com.tencent.hlyyb.downloader.e.d.b.g};
    private static int[] h = {com.tencent.hlyyb.downloader.e.d.b.f, com.tencent.hlyyb.downloader.e.d.b.c, com.tencent.hlyyb.downloader.e.d.b.e, com.tencent.hlyyb.downloader.e.d.b.d, com.tencent.hlyyb.downloader.e.d.b.j, com.tencent.hlyyb.downloader.e.d.b.b, com.tencent.hlyyb.downloader.e.d.b.h, com.tencent.hlyyb.downloader.e.d.b.i, com.tencent.hlyyb.downloader.e.d.b.g};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f626a;
    public int b;
    public int c = 0;
    public boolean d = false;
    public java.lang.String e = "";
    public boolean f = false;

    public a(java.lang.String str, int i) {
        this.f626a = str;
        this.b = i;
    }

    public static int a(int i, boolean z) {
        int[] iArr = z ? g : h;
        int i2 = iArr[0];
        if (i == 0) {
            return i2;
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (i == iArr[i3] && i3 != iArr.length - 1) {
                return iArr[i3 + 1];
            }
        }
        return i2;
    }

    public static boolean a(int i) {
        return i == com.tencent.hlyyb.downloader.e.d.b.c || i == com.tencent.hlyyb.downloader.e.d.b.d || i == com.tencent.hlyyb.downloader.e.d.b.e || i == com.tencent.hlyyb.downloader.e.d.b.f || i == com.tencent.hlyyb.downloader.e.d.b.h || i == com.tencent.hlyyb.downloader.e.d.b.i || i == com.tencent.hlyyb.downloader.e.d.b.j;
    }

    public static boolean b(int i) {
        return i == com.tencent.hlyyb.downloader.e.d.b.c || i == com.tencent.hlyyb.downloader.e.d.b.e || i == com.tencent.hlyyb.downloader.e.d.b.f || i == com.tencent.hlyyb.downloader.e.d.b.h || i == com.tencent.hlyyb.downloader.e.d.b.j;
    }

    public final java.lang.String toString() {
        int i = this.b;
        return this.c + ":" + (this.b - 1) + ":" + com.tencent.hlyyb.common.f.c.a(this.f626a, i == com.tencent.hlyyb.downloader.e.d.b.e || i == com.tencent.hlyyb.downloader.e.d.b.f || i == com.tencent.hlyyb.downloader.e.d.b.j || i == com.tencent.hlyyb.downloader.e.d.b.c || i == com.tencent.hlyyb.downloader.e.d.b.h);
    }
}
