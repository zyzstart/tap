package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.common.l f1496a;
    private final com.unisound.common.p b;
    private boolean c;

    private n(com.unisound.common.l lVar, com.unisound.common.p pVar) {
        this.f1496a = lVar;
        this.b = pVar;
    }

    /* synthetic */ n(com.unisound.common.l lVar, com.unisound.common.p pVar, com.unisound.common.m mVar) {
        this(lVar, pVar);
    }

    public java.io.InputStream a(int i) {
        synchronized (this.f1496a) {
            if (this.b.e != this) {
                throw new java.lang.IllegalStateException();
            }
            if (!this.b.d) {
                return null;
            }
            return new java.io.FileInputStream(this.b.a(i));
        }
    }

    public void a() {
        if (!this.c) {
            this.f1496a.a(this, true);
        } else {
            this.f1496a.a(this, false);
            this.f1496a.c(this.b.b);
        }
    }

    public void a(int i, java.lang.String str) throws java.lang.Throwable {
        java.io.OutputStreamWriter outputStreamWriter = null;
        try {
            java.io.OutputStreamWriter outputStreamWriter2 = new java.io.OutputStreamWriter(c(i), com.unisound.common.l.j);
            try {
                outputStreamWriter2.write(str);
                com.unisound.common.l.a(outputStreamWriter2);
            } catch (java.lang.Throwable th) {
                th = th;
                outputStreamWriter = outputStreamWriter2;
                com.unisound.common.l.a(outputStreamWriter);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public java.lang.String b(int i) {
        java.io.InputStream inputStreamA = a(i);
        if (inputStreamA != null) {
            return com.unisound.common.l.c(inputStreamA);
        }
        return null;
    }

    public void b() {
        this.f1496a.a(this, false);
    }

    public java.io.OutputStream c(int i) {
        com.unisound.common.o oVar;
        synchronized (this.f1496a) {
            if (this.b.e != this) {
                throw new java.lang.IllegalStateException();
            }
            oVar = new com.unisound.common.o(this, new java.io.FileOutputStream(this.b.b(i)), null);
        }
        return oVar;
    }
}
