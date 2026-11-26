package com.tencent.ydkqmsp.sdk.g.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    private static java.lang.String e = "LXOP";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1361a;
    public com.tencent.ydkqmsp.sdk.g.c.a b;
    private android.content.ServiceConnection c;
    public com.tencent.ydkqmsp.sdk.g.c.c.b d;

    class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            synchronized (this) {
                com.tencent.ydkqmsp.sdk.g.c.c.this.b = com.tencent.ydkqmsp.sdk.g.c.a.AbstractBinderC0056a.a(iBinder);
                if (com.tencent.ydkqmsp.sdk.g.c.c.this.d != null) {
                    com.tencent.ydkqmsp.sdk.g.c.c.this.d.a(com.tencent.ydkqmsp.sdk.g.c.c.this);
                }
                com.tencent.ydkqmsp.sdk.g.c.c.this.b("Service onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.tencent.ydkqmsp.sdk.g.c.c cVar = com.tencent.ydkqmsp.sdk.g.c.c.this;
            cVar.b = null;
            cVar.b("Service onServiceDisconnected");
        }
    }

    public interface b {
        void a(com.tencent.ydkqmsp.sdk.g.c.c cVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public c(android.content.Context context, com.tencent.ydkqmsp.sdk.g.c.c.b bVar) {
        java.lang.String str;
        this.f1361a = null;
        this.d = null;
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.f1361a = context;
        this.d = bVar;
        this.c = new com.tencent.ydkqmsp.sdk.g.c.c.a();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f1361a.bindService(intent, this.c, 1)) {
            str = "bindService Successful!";
        } else {
            com.tencent.ydkqmsp.sdk.g.c.c.b bVar2 = this.d;
            if (bVar2 != null) {
                bVar2.a(this);
            }
            str = "bindService Failed!!!";
        }
        b(str);
    }

    private void a(java.lang.String str) {
        com.tencent.ydkqmsp.sdk.base.c.b(e + " " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str) {
        com.tencent.ydkqmsp.sdk.base.c.a(e + " " + str);
    }

    public java.lang.String a() {
        if (this.f1361a == null) {
            a("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.b != null) {
                return this.b.g();
            }
            return null;
        } catch (java.lang.Exception e2) {
            a("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public boolean b() {
        try {
            if (this.b == null) {
                return false;
            }
            b("Device support opendeviceid");
            return this.b.c();
        } catch (java.lang.Exception unused) {
            a("isSupport error, RemoteException!");
            return false;
        }
    }

    public java.lang.String c() {
        android.content.Context context = this.f1361a;
        if (context == null) {
            b("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        java.lang.String packageName = context.getPackageName();
        b("liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            b("input package is null!");
            return null;
        }
        try {
            if (this.b != null) {
                return this.b.b(packageName);
            }
            return null;
        } catch (java.lang.Exception unused) {
            a("getAAID error, RemoteException!");
            return null;
        }
    }

    public void d() {
        try {
            this.f1361a.unbindService(this.c);
            b("unBind Service successful");
        } catch (java.lang.IllegalArgumentException unused) {
            a("unBind Service exception");
        }
        this.b = null;
    }
}
