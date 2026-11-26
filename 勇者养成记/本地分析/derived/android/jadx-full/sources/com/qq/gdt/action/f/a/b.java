package com.qq.gdt.action.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends com.qq.gdt.action.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private org.json.JSONObject f112a;

    public b() {
    }

    public b(int i, org.json.JSONObject jSONObject) {
        this.f112a = jSONObject == null ? new org.json.JSONObject() : jSONObject;
        try {
            this.f112a.putOpt("eventId", java.lang.Integer.valueOf(i));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.qq.gdt.action.c.a
    public com.qq.gdt.action.c.c a() {
        return c().a(this.f112a);
    }

    @Override // com.qq.gdt.action.c.a
    public void a(com.qq.gdt.action.c.c cVar) {
        this.f112a = cVar.b();
    }

    public org.json.JSONObject d() {
        return this.f112a;
    }

    public java.lang.String toString() {
        return "Event{content=" + this.f112a + '}';
    }
}
