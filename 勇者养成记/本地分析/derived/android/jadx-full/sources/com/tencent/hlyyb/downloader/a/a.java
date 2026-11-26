package com.tencent.hlyyb.downloader.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f600a = "";
    public static java.lang.String b = "";
    public static java.lang.String c = "";
    public static int d = 50;
    private static java.lang.String e = ".temp";
    private static volatile int f = 500;
    private static int g = 6000;

    public static int a() {
        return com.tencent.hlyyb.common.a.e.a("down_conn_timeout", com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING, com.youme.im.CommonConst.SPEECH_DURATION_MAX, cn.yunzhisheng.asr.a.b);
    }

    public static void a(int i) {
        f = java.lang.Math.min(java.lang.Math.max(i, 200), 1000);
    }

    public static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        f600a = str;
    }

    public static int b() {
        return com.tencent.hlyyb.common.a.e.a("down_read_timeout", com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING, com.youme.im.CommonConst.SPEECH_DURATION_MAX, cn.yunzhisheng.asr.a.b);
    }

    public static void b(int i) {
        g = java.lang.Math.min(java.lang.Math.max(i, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING), 30000);
    }

    public static void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        b = str;
    }

    public static int c() {
        int iH = com.tencent.hlyyb.common.a.f.h();
        return (iH == 2 || iH != 3) ? 1048576 : 524288;
    }

    public static void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        c = str;
    }

    public static java.lang.String d() {
        java.lang.String string;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if ("mounted".equals(android.os.Environment.getExternalStorageState())) {
            string = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + com.tencent.hlyyb.common.f.c.e() + "/HalleyDownload";
        } else {
            string = "";
        }
        if (android.text.TextUtils.isEmpty(string)) {
            string = com.tencent.hlyyb.common.a.a().getFilesDir().toString();
        }
        sb.append(string);
        return sb.toString();
    }

    public static void d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        e = str;
    }

    public static int e() {
        return f;
    }

    public static java.lang.String e(java.lang.String str) {
        return str + ".bdcfg";
    }

    public static int f() {
        return g;
    }

    public static java.lang.String f(java.lang.String str) {
        return str + e;
    }

    public static boolean g(java.lang.String str) {
        return !com.tencent.hlyyb.common.f.c.a(str);
    }
}
