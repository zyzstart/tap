package com.qq.gdt.action;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.qq.gdt.action.e f104a = null;
    private static volatile boolean b = false;
    private static java.util.concurrent.Executor g;
    private static android.os.Handler h;
    private static final java.util.regex.Pattern l = java.util.regex.Pattern.compile("^[a-zA-Z0-9_]{1,32}$", 2);
    private volatile android.content.Context c;
    private volatile java.lang.String d;
    private volatile java.lang.String e;
    private volatile javax.crypto.SecretKey f;
    private volatile java.lang.String k;
    private volatile java.lang.String m;
    private java.lang.String r;
    private final java.lang.String i = java.util.UUID.randomUUID().toString().replaceAll("-", "");
    private java.lang.String j = "";
    private long n = -1;
    private long o = -1;
    private boolean p = true;
    private long q = -1;

    private e() {
        g = java.util.concurrent.Executors.newCachedThreadPool();
        h = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.qq.gdt.action.e.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 1) {
                    com.qq.gdt.action.e.this.r();
                    com.qq.gdt.action.GDTAction.logAction("TICKET", com.qq.gdt.action.e.this.q());
                    com.qq.gdt.action.e.this.q = android.os.SystemClock.elapsedRealtime();
                }
            }
        };
    }

    public static com.qq.gdt.action.e a() {
        if (f104a == null) {
            synchronized (com.qq.gdt.action.e.class) {
                if (f104a == null) {
                    f104a = new com.qq.gdt.action.e();
                }
            }
        }
        return f104a;
    }

    private org.json.JSONObject a(boolean z) {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j = z ? this.o : this.n;
        long j2 = j < 0 ? -1L : (jElapsedRealtime - j) / 1000;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("duration", java.lang.Long.valueOf(j2));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void a(android.content.Context context) {
        this.j = com.qq.gdt.action.h.d.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.qq.gdt.action.GDTAction.a aVar) {
        com.qq.gdt.action.h.l.a("GDTAction初始化成功");
        if (aVar != null) {
            h.post(new java.lang.Runnable() { // from class: com.qq.gdt.action.e.3
                @Override // java.lang.Runnable
                public void run() {
                    aVar.a();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.qq.gdt.action.GDTAction.a aVar, final java.lang.String str) {
        com.qq.gdt.action.h.l.c(str);
        if (aVar != null) {
            h.post(new java.lang.Runnable() { // from class: com.qq.gdt.action.e.4
                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(str);
                }
            });
        }
    }

    private void a(final java.lang.String str, final com.qq.gdt.action.GDTAction.a aVar) {
        g.execute(new java.lang.Runnable() { // from class: com.qq.gdt.action.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.qq.gdt.action.e eVar = com.qq.gdt.action.e.this;
                eVar.b(eVar.c);
                com.qq.gdt.action.h.e.a();
                com.qq.gdt.action.e.this.o();
                try {
                    com.qq.gdt.action.e.this.f = com.qq.gdt.action.h.a.a(str);
                    com.qq.gdt.action.h.l.a("aesKey = " + com.qq.gdt.action.h.r.c(com.qq.gdt.action.e.this.f.getEncoded()), new java.lang.Object[0]);
                    com.qq.gdt.action.b.a(com.qq.gdt.action.e.this.c);
                    com.qq.gdt.action.e.this.a(aVar);
                    com.qq.gdt.action.e.this.n();
                } catch (java.lang.Exception e) {
                    com.qq.gdt.action.h.l.c("GDTAction初始化失败，ErrorCode:01，请联系广点通运营" + e.getMessage());
                    com.qq.gdt.action.e.this.a(aVar, "GDTAction初始化失败，ErrorCode:01，请联系广点通运营" + e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(android.content.Context context) {
        java.lang.String strJ = j();
        if (com.qq.gdt.action.h.t.a(j())) {
            strJ = java.util.UUID.randomUUID().toString().replaceAll("-", "");
            android.content.SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0).edit();
            editorEdit.putString("device_id", strJ);
            editorEdit.apply();
        }
        com.qq.gdt.action.h.l.a("Set device id: " + strJ, new java.lang.Object[0]);
    }

    private void c(com.qq.gdt.action.a.a aVar) {
        android.content.Context contextC = a().c();
        if (aVar.d() == null) {
            aVar.a(new org.json.JSONObject());
        }
        try {
            long jE = com.qq.gdt.action.h.q.e(contextC);
            long jF = com.qq.gdt.action.h.q.f(contextC);
            long jD = com.qq.gdt.action.h.q.d(contextC);
            if (jE > 0) {
                aVar.d().putOpt("ams_reserved_last_start_time", java.lang.Long.valueOf(jE));
            }
            if (jF > 0) {
                aVar.d().putOpt("ams_reserved_last_revised_start_time", java.lang.Long.valueOf(jF));
            }
            if (jD > 0) {
                aVar.d().putOpt("ams_reserved_last_revised_activate_time", java.lang.Long.valueOf(jD));
            }
        } catch (org.json.JSONException e) {
            com.qq.gdt.action.h.l.a("JSON exception while add last start time info.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.qq.gdt.action.d.f fVarA = com.qq.gdt.action.g.b.a();
        com.qq.gdt.action.a.a(this.c).a(fVarA != null && fVarA.a() == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            com.tencent.turingfd.sdk.ams.ad.TuringDIDService.init(com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig.newBuilder(this.c).appid("").build());
        } catch (java.lang.Throwable unused) {
            com.qq.gdt.action.h.l.b("GDTAction初始化失败，ErrorCode:02，请联系广点通运营");
        }
    }

    private void p() {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            if (this.c.getApplicationContext() instanceof android.app.Application) {
                ((android.app.Application) this.c.getApplicationContext()).registerActivityLifecycleCallbacks(new com.qq.gdt.action.g(this));
            } else {
                com.qq.gdt.action.h.l.c("init方法传入的Context对象不是Application类的实例，请参考接入文档");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public org.json.JSONObject q() {
        long jElapsedRealtime = (android.os.SystemClock.elapsedRealtime() - this.q) / 1000;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("begin_time", java.lang.Long.valueOf(this.o));
            jSONObject.putOpt("duration", java.lang.Long.valueOf(jElapsedRealtime));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (h.hasMessages(1) || !this.p) {
            return;
        }
        h.sendEmptyMessageDelayed(1, com.qq.gdt.action.b.a(this.c).d());
    }

    public synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        a(context, str, str2, str3, null);
    }

    public synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.gdt.action.GDTAction.a aVar) {
        if (b) {
            com.qq.gdt.action.h.l.b("GDTAction已经初始化过，不需要再次初始化");
            return;
        }
        if (context == null) {
            a(aVar, "GDTAction初始化失败，init方法的context参数不能为null");
            return;
        }
        this.c = context.getApplicationContext();
        if (com.qq.gdt.action.h.t.a(str)) {
            a(aVar, "GDTAction初始化失败，init方法的userActionSetId参数不能为空");
            return;
        }
        this.d = str;
        if (com.qq.gdt.action.h.t.a(str2)) {
            a(aVar, "[REDACTED]");
            return;
        }
        this.e = str2;
        if (!com.qq.gdt.action.h.t.a(str3) && !l.matcher(str3).matches()) {
            a(aVar, "GDTAction初始化失败，init方法的channelId参数格式不正确");
            return;
        }
        this.k = str3;
        if (!com.qq.gdt.action.h.n.a(this.c)) {
            a(aVar, "GDTAction初始化失败，请确保AndroidManifest.xml文件中添加了SDK需要的所有权限");
            return;
        }
        if (!com.qq.gdt.action.h.s.a()) {
            a(aVar, "GDTAction初始化失败，init方法必须在'android.app.Application'子类的onCreate方法中调用。请参考接入文档");
            return;
        }
        a(this.c);
        com.qq.gdt.action.h.q.g(context);
        p();
        a(str2, aVar);
        b = true;
    }

    protected void a(com.qq.gdt.action.a.a aVar) {
        c(aVar);
        if (!com.qq.gdt.action.h.c.a(this.c)) {
            com.qq.gdt.action.a.a(this.c).a(aVar);
        } else {
            com.qq.gdt.action.a.a(this.c).a(com.qq.gdt.action.d.a("ACTIVATE_APP", aVar.d()), aVar);
        }
    }

    public void a(java.lang.String str) {
        if (com.qq.gdt.action.h.t.a(str) || l.matcher(str).matches()) {
            this.m = str;
        } else {
            com.qq.gdt.action.h.l.c("userUniqueId参数格式不正确");
        }
    }

    protected void b(com.qq.gdt.action.a.a aVar) {
        com.qq.gdt.action.a.a(a().c()).a(aVar);
    }

    public boolean b() {
        return b;
    }

    public android.content.Context c() {
        return this.c;
    }

    public java.lang.String d() {
        return this.d;
    }

    public java.lang.String e() {
        return this.e;
    }

    public javax.crypto.SecretKey f() {
        return this.f;
    }

    public void g() {
        this.p = true;
        this.o = android.os.SystemClock.elapsedRealtime();
        com.qq.gdt.action.GDTAction.logAction("ENTER_FOREGROUND", a(false));
        com.qq.gdt.action.h.q.a(this.c, java.lang.System.currentTimeMillis());
        this.q = android.os.SystemClock.elapsedRealtime();
        r();
        com.qq.gdt.action.f.d.b();
    }

    public void h() {
        this.p = false;
        this.n = android.os.SystemClock.elapsedRealtime();
        com.qq.gdt.action.GDTAction.logAction("ENTER_BACKGROUND", a(true));
        com.qq.gdt.action.h.q.b(this.c, java.lang.System.currentTimeMillis());
        com.qq.gdt.action.a.a(this.c).a();
        com.qq.gdt.action.GDTAction.logAction("TICKET", q());
        h.removeMessages(1);
        com.qq.gdt.action.f.d.c();
    }

    public java.lang.String i() {
        return this.i;
    }

    public java.lang.String j() {
        if (com.qq.gdt.action.h.t.a(this.r)) {
            this.r = this.c.getApplicationContext().getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0).getString("device_id", "");
        }
        return this.r;
    }

    public java.lang.String k() {
        return this.j;
    }

    public java.lang.String l() {
        return this.k;
    }

    public java.lang.String m() {
        return this.m;
    }
}
