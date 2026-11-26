package com.tencent.msdk.dns.core.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f663a;

    public a(android.content.Context context) {
        this.f663a = context;
    }

    public java.util.Map a() {
        java.util.HashMap map = new java.util.HashMap(6);
        map.put("sdk_Version", "3.0.9a");
        map.put("appID", com.tencent.msdk.dns.core.config.b.b());
        map.put("id", com.tencent.msdk.dns.core.config.b.c());
        map.put("userID", com.tencent.msdk.dns.core.config.b.f());
        map.put("netType", com.tencent.msdk.dns.base.c.b.a(this.f663a));
        map.put("ssid", com.tencent.msdk.dns.base.c.b.c(this.f663a));
        return map;
    }
}
