package com.tencent.tmassistantbase.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    private static volatile com.tencent.tmassistantbase.common.e b;
    private java.util.concurrent.ConcurrentHashMap c = new java.util.concurrent.ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.tmassistantbase.a.a.c f1023a = new com.tencent.tmassistantbase.a.a.c(com.tencent.tmassistantbase.util.k.a().b());

    private e() {
        b();
    }

    public static synchronized com.tencent.tmassistantbase.common.e a() {
        if (b == null) {
            b = new com.tencent.tmassistantbase.common.e();
        }
        return b;
    }

    public int a(java.lang.String str, int i) {
        return a("", str, i);
    }

    public int a(java.lang.String str, java.lang.String str2, int i) {
        try {
            return java.lang.Integer.valueOf(a(str + "_" + str2, java.lang.Integer.valueOf(i))).intValue();
        } catch (java.lang.NumberFormatException unused) {
            return i;
        }
    }

    public java.lang.String a(java.lang.String str, java.lang.Object obj) {
        return this.c.containsKey(str) ? (java.lang.String) this.c.get(str) : java.lang.String.valueOf(obj);
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        return a("_" + str, (java.lang.Object) str2);
    }

    public void a(int i) {
        b("server_address", java.lang.Integer.valueOf(i));
    }

    public void a(java.lang.String str, byte[] bArr) {
        if (this.f1023a.a("", str, "", bArr)) {
            return;
        }
        this.f1023a.b("", str, "", bArr);
    }

    public void a(byte[] bArr) {
        a("report_config", bArr);
    }

    public boolean a(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        this.c.put(str + "_" + str2, java.lang.String.valueOf(obj));
        if (this.f1023a.a(str, str2, java.lang.String.valueOf(obj))) {
            return true;
        }
        return this.f1023a.b(str, str2, java.lang.String.valueOf(obj));
    }

    public byte[] a(java.lang.String str) {
        return this.f1023a.a("", str);
    }

    public void b() {
        this.f1023a.a(this.c);
    }

    public void b(byte[] bArr) {
        a("black_list", bArr);
    }

    public boolean b(java.lang.String str, java.lang.Object obj) {
        return a("", str, obj);
    }

    public int c() {
        return a("server_address", 0);
    }

    public void c(byte[] bArr) {
        a("log_config", bArr);
    }

    public com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BatchReportConfig d() {
        byte[] bArrA = a("report_config");
        if (bArrA != null) {
            return (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BatchReportConfig) com.tencent.tmassistantbase.common.d.b(bArrA, com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BatchReportConfig.class);
        }
        return null;
    }

    public java.util.List e() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            return ((com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BlackListConfig) com.tencent.tmassistantbase.common.d.b(a("black_list"), com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BlackListConfig.class)).blackList;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }
}
