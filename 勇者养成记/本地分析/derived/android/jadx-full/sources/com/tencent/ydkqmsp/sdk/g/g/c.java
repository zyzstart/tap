package com.tencent.ydkqmsp.sdk.g.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements com.tencent.ydkqmsp.sdk.base.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1375a = null;
    private com.tencent.ydkqmsp.sdk.base.IVendorCallback b = null;

    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.Thread.sleep(1000L);
                if (com.tencent.ydkqmsp.sdk.g.g.c.this.b != null) {
                    com.tencent.ydkqmsp.sdk.g.g.c.this.b.onResult(com.tencent.ydkqmsp.sdk.g.g.b.a(), com.tencent.ydkqmsp.sdk.g.g.b.a(com.tencent.ydkqmsp.sdk.g.g.c.this.f1375a), com.tencent.ydkqmsp.sdk.g.g.b.b(com.tencent.ydkqmsp.sdk.g.g.c.this.f1375a));
                }
            } catch (java.lang.Exception e) {
                if (com.tencent.ydkqmsp.sdk.g.g.c.this.b != null) {
                    com.tencent.ydkqmsp.sdk.g.g.c.this.b.onResult(false, null, null);
                }
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String a() {
        return "";
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void a(android.content.Context context, com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        this.f1375a = context;
        this.b = iVendorCallback;
        com.tencent.ydkqmsp.sdk.g.g.b.c(context);
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String b() {
        return "";
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void c() {
        new java.lang.Thread(new com.tencent.ydkqmsp.sdk.g.g.c.a()).start();
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean e() {
        return com.tencent.ydkqmsp.sdk.g.g.b.a();
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void f() {
    }
}
