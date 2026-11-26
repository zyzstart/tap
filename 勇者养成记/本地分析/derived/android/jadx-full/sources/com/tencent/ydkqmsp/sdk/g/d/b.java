package com.tencent.ydkqmsp.sdk.g.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    private static java.lang.String e = "com.mdid.msa";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.ydkqmsp.sdk.g.d.c f1364a;
    private android.content.ServiceConnection b;
    private android.content.Context c;
    private com.tencent.ydkqmsp.sdk.g.d.a d;

    class a implements android.content.ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.tencent.ydkqmsp.sdk.g.d.c f1365a;

        a(com.tencent.ydkqmsp.sdk.g.d.b bVar, com.tencent.ydkqmsp.sdk.g.d.c cVar) {
            this.f1365a = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            synchronized (this) {
                com.tencent.ydkqmsp.sdk.g.d.b.this.d = com.tencent.ydkqmsp.sdk.g.d.a.AbstractBinderC0058a.a(iBinder);
                new com.tencent.ydkqmsp.sdk.g.d.d(com.tencent.ydkqmsp.sdk.g.d.b.this.d, this.f1365a).executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.tencent.ydkqmsp.sdk.g.d.b.this.d = null;
            com.tencent.ydkqmsp.sdk.g.d.b.this.d = null;
        }
    }

    public b(android.content.Context context, com.tencent.ydkqmsp.sdk.g.d.c cVar) {
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.c = context;
        this.f1364a = cVar;
        this.b = new com.tencent.ydkqmsp.sdk.g.d.b.a(this, cVar);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(e, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (context.startService(intent) != null) {
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static boolean a(android.content.Context context) {
        try {
            context.getPackageManager().getPackageInfo(e, 0);
            return true;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public java.lang.String a() {
        try {
            return this.d == null ? "" : this.d.b();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public void a(java.lang.String str) {
        com.tencent.ydkqmsp.sdk.g.d.c cVar;
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        if (this.c.bindService(intent, this.b, 1) || (cVar = this.f1364a) == null) {
            return;
        }
        cVar.g();
    }

    public java.lang.String b() {
        try {
            return this.d == null ? "" : this.d.a();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public boolean c() {
        try {
            if (this.d == null) {
                return false;
            }
            return this.d.d();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public void d() {
        com.tencent.ydkqmsp.sdk.g.d.a aVar = this.d;
        if (aVar != null) {
            try {
                aVar.e();
                if (this.b != null) {
                    this.c.unbindService(this.b);
                }
            } catch (java.lang.Exception unused) {
            }
            this.b = null;
            this.d = null;
        }
    }
}
