package com.qq.gdt.action.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f66a;
    private final java.lang.String b;
    private final java.lang.String c;
    private final java.lang.String d;
    private final long e;
    private final long f;
    private org.json.JSONObject g;
    private final int h;

    public a(long j, java.lang.String str, java.lang.String str2, java.lang.String str3, long j2, long j3, org.json.JSONObject jSONObject, int i) {
        this.f66a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j2;
        this.f = j3;
        this.g = jSONObject;
        this.h = i;
    }

    public a(java.lang.String str, java.lang.String str2, long j, org.json.JSONObject jSONObject) {
        this.b = str;
        this.c = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        this.d = str2;
        this.e = j;
        this.g = jSONObject;
        this.f = com.qq.gdt.action.h.u.b();
        this.h = 0;
    }

    public java.lang.String a() {
        return this.c;
    }

    public void a(long j) {
        this.f66a = j;
    }

    public void a(org.json.JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public java.lang.String b() {
        return this.d;
    }

    public long c() {
        return this.e;
    }

    public org.json.JSONObject d() {
        return this.g;
    }

    public long e() {
        return this.f66a;
    }

    public java.lang.String f() {
        return this.b;
    }

    public long g() {
        return this.f;
    }

    public int h() {
        return this.h;
    }

    public java.lang.String toString() {
        return "Action{actionId=" + this.f66a + ", sessionId='" + this.b + "', actionUniqueId='" + this.c + "', actionType='" + this.d + "', actionTimeMillis=" + this.e + ", revisedActionTimeMillis=" + this.f + ", actionParam=" + this.g + ", status=" + this.h + '}';
    }
}
