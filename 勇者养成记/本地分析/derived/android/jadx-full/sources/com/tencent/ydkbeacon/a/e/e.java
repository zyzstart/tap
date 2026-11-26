package com.tencent.ydkbeacon.a.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.util.concurrent.atomic.AtomicBoolean f1201a = new java.util.concurrent.atomic.AtomicBoolean(false);

    public static void a(android.content.Context context) {
        if (f1201a.get()) {
            if (com.tencent.ydkbeacon.a.c.b.b(context, com.unisound.client.SpeechConstants.PERMISSION_INTERNET) && com.tencent.ydkbeacon.a.c.b.b(context, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE)) {
                return;
            }
            a("当前无网络相关权限！");
        }
    }

    public static void a(java.lang.String str) {
        com.tencent.ydkbeacon.a.e.c.b("[strict]  " + str, new java.lang.Object[0]);
        if (f1201a.get()) {
            throw new java.lang.IllegalStateException("[strict] " + str);
        }
    }

    public static void a(java.util.Map map) {
        if (!f1201a.get() || map == null) {
            return;
        }
        for (java.lang.Object obj : map.keySet()) {
            if (!(obj instanceof java.lang.String)) {
                a("Key必须为String类型!");
            }
            if (!(map.get(obj) instanceof java.lang.String)) {
                a("Value必须为String类型!");
            }
        }
    }

    public static boolean a(java.lang.String str, java.lang.Object obj) {
        boolean zIsEmpty;
        if (obj instanceof java.lang.String) {
            zIsEmpty = android.text.TextUtils.isEmpty((java.lang.String) obj);
        } else {
            zIsEmpty = obj == null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(" ");
        sb.append(obj == null ? "=" : "!");
        sb.append("= null!");
        com.tencent.ydkbeacon.a.e.c.a(sb.toString(), new java.lang.Object[0]);
        if (!zIsEmpty || !f1201a.get()) {
            return zIsEmpty;
        }
        throw new java.lang.NullPointerException(str + " == null!");
    }
}
