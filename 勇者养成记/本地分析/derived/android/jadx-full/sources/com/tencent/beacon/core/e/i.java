package com.tencent.beacon.core.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.util.concurrent.atomic.AtomicBoolean f160a = new java.util.concurrent.atomic.AtomicBoolean(false);

    public static void a(android.content.Context context) {
        if (f160a.get()) {
            if (com.tencent.beacon.core.e.d.a()) {
                throw new java.lang.IllegalStateException("[strict] 实时联调未关闭!正式发布后必须关闭实时联调！");
            }
            com.tencent.beacon.core.info.b bVarB = com.tencent.beacon.core.info.b.b(context);
            if (bVarB.a().equals(bVarB.b())) {
                throw new java.lang.IllegalStateException("[REDACTED]" + bVarB.a());
            }
            if (com.tencent.beacon.core.e.j.b(bVarB.b((java.lang.String) null))) {
                throw new java.lang.IllegalStateException("[strict] Channel未设置！");
            }
            if (com.tencent.beacon.core.info.a.b(context, com.unisound.client.SpeechConstants.PERMISSION_INTERNET) && com.tencent.beacon.core.info.a.b(context, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE)) {
                return;
            }
            a("当前无网络相关权限！");
        }
    }

    public static void a(java.lang.String str) {
        com.tencent.beacon.core.e.d.b("[strict] " + str, new java.lang.Object[0]);
        if (f160a.get()) {
            throw new java.lang.RuntimeException("[strict] " + str);
        }
    }

    public static void a(java.util.Map map) {
        if (!f160a.get() || map == null) {
            return;
        }
        java.util.HashMap map2 = new java.util.HashMap(map);
        for (java.lang.Object obj : map2.keySet()) {
            if (!(obj instanceof java.lang.String)) {
                a("Key必须为String类型!");
            }
            if (!(map2.get(obj) instanceof java.lang.String)) {
                a("Value必须为String类型!");
            }
            if (((java.lang.String) map2.get(obj)).getBytes(java.nio.charset.Charset.forName("UTF-8")).length >= 10240) {
                a("key: " + obj + "的Value长度超过10K,将被截断!");
            }
        }
    }
}
