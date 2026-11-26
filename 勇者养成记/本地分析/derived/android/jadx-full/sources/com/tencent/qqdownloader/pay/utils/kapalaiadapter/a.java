package com.tencent.qqdownloader.pay.utils.kapalaiadapter;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.j[] f787a = {new com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.a(), new com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.b(), new com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.c(), new com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.d(), new com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.e(), new com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.f(), new com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.g(), new com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.h(), new com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.i()};

    /* JADX INFO: renamed from: com.tencent.qqdownloader.pay.utils.kapalaiadapter.a$a, reason: collision with other inner class name */
    public static class C0035a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.tencent.qqdownloader.pay.utils.kapalaiadapter.a f788a = new com.tencent.qqdownloader.pay.utils.kapalaiadapter.a();
    }

    public static com.tencent.qqdownloader.pay.utils.kapalaiadapter.a a() {
        return com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.C0035a.f788a;
    }

    public java.lang.String[] a(android.content.Context context) {
        java.lang.String[] strArr = new java.lang.String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = f787a[com.tencent.qqdownloader.pay.utils.kapalaiadapter.b.g[i]].b(com.tencent.qqdownloader.pay.utils.kapalaiadapter.b.i[i], context);
        }
        return strArr;
    }

    public java.lang.String[] b(android.content.Context context) {
        java.lang.String[] strArr = new java.lang.String[2];
        int length = com.tencent.qqdownloader.pay.utils.kapalaiadapter.b.j.length;
        int i = 0;
        for (int i2 = 0; i2 < length && i < 2; i2++) {
            int length2 = f787a.length;
            for (int i3 = 0; i3 < length2; i3++) {
                java.lang.String strB = f787a[i3].b(com.tencent.qqdownloader.pay.utils.kapalaiadapter.b.j[i2], context);
                if (strB != null && strB.length() != 0 && !strB.equals(strArr[0])) {
                    strArr[i] = strB;
                    i++;
                    break;
                }
            }
        }
        return strArr;
    }
}
