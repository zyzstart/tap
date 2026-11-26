package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class cn extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1553a = 153600;
    private java.lang.String b = "";
    private boolean c = false;
    private com.unisound.sdk.cl d;
    private com.unisound.sdk.cm e;

    public cn(com.unisound.sdk.cm cmVar) {
        this.e = cmVar;
    }

    private void b(int i) {
        com.unisound.sdk.cl clVar = this.d;
        if (clVar != null) {
            clVar.a(i);
        }
    }

    private void b(java.lang.String str) {
        com.unisound.sdk.cl clVar = this.d;
        if (clVar != null) {
            clVar.a(str);
        }
    }

    private void c(int i) {
        com.unisound.sdk.cl clVar = this.d;
        if (clVar != null) {
            clVar.b(i);
        }
    }

    private boolean c(java.lang.String str) {
        return str == null || str.length() == 0;
    }

    private com.unisound.sdk.ae e() {
        com.unisound.sdk.cm cmVar = this.e;
        if (cmVar == null) {
            return null;
        }
        com.unisound.sdk.ae aeVar = new com.unisound.sdk.ae(cmVar.b(), this.e.c());
        aeVar.f(this.e.g());
        return aeVar;
    }

    private java.lang.String f() {
        if (c(this.b)) {
            return null;
        }
        com.unisound.common.y.c("NLU processing begin");
        com.unisound.sdk.ae aeVarE = e();
        aeVarE.a(this.e.t());
        aeVarE.h(this.e.i());
        aeVarE.i(this.e.j());
        aeVarE.e(this.e.f());
        aeVarE.k(this.e.n());
        aeVarE.b(java.lang.System.currentTimeMillis());
        aeVarE.o(this.e.r());
        aeVarE.d(this.e.d());
        aeVarE.g(this.b);
        return new com.unisound.sdk.ck().c(aeVarE);
    }

    public void a() {
        this.c = true;
    }

    public void a(int i) {
        c();
        if (isAlive()) {
            try {
                join(i);
                com.unisound.common.y.c("USCNluThread::waitEnd()");
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(com.unisound.sdk.cl clVar) {
        this.d = clVar;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public boolean b() {
        return this.c;
    }

    public void c() {
        a();
        this.d = null;
    }

    public boolean d() {
        return this.d == null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (this.c) {
            return;
        }
        try {
            b(1002);
            java.lang.String strF = f();
            if (strF == "") {
                c(com.unisound.client.ErrorCode.NLU_REQUEST_EMPTY);
            } else if (strF.equals("{}")) {
                c(com.unisound.client.ErrorCode.NLU_SERVER_ERROR);
            } else if (strF.equals("Error")) {
                c(com.unisound.client.ErrorCode.NLU_OTHER_ERROR);
            } else {
                b(strF);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            c(com.unisound.client.ErrorCode.NLU_OTHER_ERROR);
        }
        b(1001);
    }
}
