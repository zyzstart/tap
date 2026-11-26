package com.tencent.ydkqmsp.sdk.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k implements com.tencent.ydkqmsp.sdk.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.HashMap f1328a = new java.util.HashMap();

    public void a(com.tencent.ydkqmsp.sdk.c.d dVar) {
        java.lang.String strA = dVar.a();
        if (strA == null || this.f1328a.containsKey(strA)) {
            return;
        }
        this.f1328a.put(strA, dVar);
    }

    @Override // com.tencent.ydkqmsp.sdk.c.b
    public java.lang.Object getApplicationContext() {
        return com.tencent.ydkqmsp.sdk.app.a.getContext();
    }

    @Override // com.tencent.ydkqmsp.sdk.c.b
    public int getRuntimeVersion() {
        return 512;
    }

    @Override // com.tencent.ydkqmsp.sdk.c.b
    public com.tencent.ydkqmsp.sdk.c.d queryRuntimeInterface(java.lang.String str) {
        if (str == null) {
            return null;
        }
        com.tencent.ydkqmsp.sdk.c.d dVar = (com.tencent.ydkqmsp.sdk.c.d) this.f1328a.get(str);
        if (dVar == null || str.equals(dVar.a())) {
            return dVar;
        }
        return null;
    }
}
