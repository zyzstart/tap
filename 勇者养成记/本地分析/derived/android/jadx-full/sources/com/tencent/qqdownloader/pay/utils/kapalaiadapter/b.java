package com.tencent.qqdownloader.pay.utils.kapalaiadapter;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f798a = true;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean f = true;
    public static int[] e = new int[2];
    public static int[] g = new int[2];
    public static int[] h = {-1, 1};
    public static int[] i = {-1, 1};
    public static int[] j = {-1, 0, 1, 2};

    static {
        java.lang.String lowerCase = android.os.Build.MODEL.toLowerCase();
        java.lang.String lowerCase2 = android.os.Build.MANUFACTURER.toLowerCase();
        if (lowerCase2.indexOf("htc") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().b(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("samsung") >= 0 || lowerCase2.indexOf("samsng") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().a(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("motorola") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().c(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("huawei") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().d(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("hisense") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().f(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("xiaomi") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().g(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("zte") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().e(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("meizu") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().h(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("alps") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().i(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("oppo") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().o(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("k-touch") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().j(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("yulong") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().q(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("coolpad") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().k(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("lenovo") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().l(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("bbk") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().m(lowerCase);
        } else if (lowerCase2.indexOf("gionee") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().p(lowerCase);
        } else if (lowerCase2.indexOf("sony ericsson") >= 0) {
            com.tencent.qqdownloader.pay.utils.kapalaiadapter.c.a().n(lowerCase);
        }
    }
}
