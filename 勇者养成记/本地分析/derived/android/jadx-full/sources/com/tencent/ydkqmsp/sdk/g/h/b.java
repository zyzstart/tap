package com.tencent.ydkqmsp.sdk.g.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    private static java.lang.String e = "SDI";
    public static java.lang.String f = "SI";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tencent.ydkqmsp.sdk.g.h.b.InterfaceC0063b f1381a;
    private android.content.ServiceConnection b;
    private android.content.Context c;
    public com.tencent.ydkqmsp.sdk.g.h.a d;

    class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            synchronized (this) {
                com.tencent.ydkqmsp.sdk.g.h.b.this.d = com.tencent.ydkqmsp.sdk.g.h.a.AbstractBinderC0061a.a(iBinder);
                if (com.tencent.ydkqmsp.sdk.g.h.b.this.f1381a != null) {
                    com.tencent.ydkqmsp.sdk.g.h.b.this.f1381a.a(com.tencent.ydkqmsp.sdk.g.h.b.this);
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.tencent.ydkqmsp.sdk.g.h.b.f);
                sb.append(" Service onServiceConnected");
                com.tencent.ydkqmsp.sdk.base.c.c(sb.toString());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.tencent.ydkqmsp.sdk.g.h.b.this.d = null;
            com.tencent.ydkqmsp.sdk.base.c.c(com.tencent.ydkqmsp.sdk.g.h.b.f + " Service onServiceDisconnected");
        }
    }

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.h.b$b, reason: collision with other inner class name */
    public interface InterfaceC0063b {
        void a(com.tencent.ydkqmsp.sdk.g.h.b bVar);
    }

    public b(android.content.Context context, com.tencent.ydkqmsp.sdk.g.h.b.InterfaceC0063b interfaceC0063b) {
        this.f1381a = null;
        this.c = null;
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.c = context;
        this.f1381a = interfaceC0063b;
        this.b = new com.tencent.ydkqmsp.sdk.g.h.b.a();
    }

    public java.lang.String a() {
        java.lang.StringBuilder sb;
        java.lang.String str;
        android.content.Context context = this.c;
        if (context == null) {
            com.tencent.ydkqmsp.sdk.base.c.c(f + " Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new SxCore first");
        }
        java.lang.String packageName = context.getPackageName();
        com.tencent.ydkqmsp.sdk.base.c.a(f + "apackage：" + packageName);
        if (packageName == null || packageName.equals("")) {
            sb = new java.lang.StringBuilder();
            sb.append(f);
            str = " input package is null!";
        } else {
            try {
                if (this.d == null) {
                    return null;
                }
                java.lang.String strA = this.d.a(packageName);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(f);
                sb2.append(" getAAID Package: ");
                sb2.append(packageName);
                com.tencent.ydkqmsp.sdk.base.c.a(sb2.toString());
                return strA;
            } catch (java.lang.Exception unused) {
                sb = new java.lang.StringBuilder();
                sb.append(f);
                str = " geta error, RemoteException!";
            }
        }
        sb.append(str);
        com.tencent.ydkqmsp.sdk.base.c.c(sb.toString());
        return null;
    }

    public java.lang.String b() {
        if (this.c == null) {
            com.tencent.ydkqmsp.sdk.base.c.c(f + " Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new SxCore first");
        }
        try {
            if (this.d == null) {
                return null;
            }
            java.lang.String strA = this.d.a();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e);
            sb.append(" geto call");
            com.tencent.ydkqmsp.sdk.base.c.c(sb.toString());
            return strA;
        } catch (java.lang.Exception e2) {
            com.tencent.ydkqmsp.sdk.base.c.c(f + " geto error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public void c() {
        java.lang.StringBuilder sb;
        java.lang.String str;
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.c.bindService(intent, this.b, 1)) {
            sb = new java.lang.StringBuilder();
            sb.append(f);
            str = " bindService Successful!";
        } else {
            this.f1381a.a(this);
            sb = new java.lang.StringBuilder();
            sb.append(f);
            str = " bindService Failed!";
        }
        sb.append(str);
        com.tencent.ydkqmsp.sdk.base.c.c(sb.toString());
    }

    public boolean d() {
        try {
            if (this.d == null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(f);
                sb.append(" Device not support opendeviceid");
                com.tencent.ydkqmsp.sdk.base.c.c(sb.toString());
                return false;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(f);
            sb2.append(" Device support opendeviceid");
            com.tencent.ydkqmsp.sdk.base.c.c(sb2.toString());
            return true;
        } catch (java.lang.Exception unused) {
            com.tencent.ydkqmsp.sdk.base.c.c(f + " isSupport error, RemoteException!");
            return false;
        }
    }

    public void e() {
        try {
            this.c.unbindService(this.b);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(f);
            sb.append(" unBind Service successful");
            com.tencent.ydkqmsp.sdk.base.c.c(sb.toString());
        } catch (java.lang.IllegalArgumentException unused) {
            com.tencent.ydkqmsp.sdk.base.c.c(f + " unBind Service exception");
        }
        this.d = null;
    }
}
