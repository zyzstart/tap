package com.tencent.ydkqmsp.sdk.g.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    public android.content.Context b;
    public com.tencent.ydkqmsp.sdk.g.a.a c;
    public com.tencent.ydkqmsp.sdk.g.a.b d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1352a = false;
    public android.content.ServiceConnection e = new com.tencent.ydkqmsp.sdk.g.a.d.a();

    class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.tencent.ydkqmsp.sdk.base.c.a("HSDID did service binded");
            com.tencent.ydkqmsp.sdk.g.a.d.this.c = com.tencent.ydkqmsp.sdk.g.a.a.AbstractBinderC0052a.a(iBinder);
            com.tencent.ydkqmsp.sdk.g.a.d.this.a(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.tencent.ydkqmsp.sdk.g.a.d.this.a(false);
        }
    }

    public d(android.content.Context context) {
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (!z) {
            this.d.g();
            return;
        }
        try {
            this.d.a(this.c);
        } catch (java.lang.Exception e) {
            com.tencent.ydkqmsp.sdk.base.c.b("HSDID notify did bind status error :" + e.getMessage());
        }
    }

    public void a() {
        try {
            if (!this.f1352a || this.e == null || this.b == null) {
                return;
            }
            com.tencent.ydkqmsp.sdk.base.c.a("HSDID start to unbind did service");
            this.f1352a = false;
            this.b.unbindService(this.e);
        } catch (java.lang.Exception e) {
            com.tencent.ydkqmsp.sdk.base.c.b("HSDID error:" + e.getMessage());
        }
    }

    public void a(com.tencent.ydkqmsp.sdk.g.a.b bVar) {
        try {
            this.d = bVar;
            android.content.Intent intent = new android.content.Intent("com.asus.msa.action.ACCESS_DID");
            android.content.ComponentName componentName = new android.content.ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            android.content.Intent intent2 = new android.content.Intent(intent);
            intent2.setComponent(componentName);
            com.tencent.ydkqmsp.sdk.base.c.a("HSDID start to bind did service");
            boolean zBindService = this.b.bindService(intent2, this.e, 1);
            this.f1352a = zBindService;
            if (zBindService) {
                return;
            }
            this.d.g();
        } catch (java.lang.Exception unused) {
            a(false);
        }
    }
}
