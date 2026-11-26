package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class z extends java.lang.Thread {
    private static boolean h = false;
    private static boolean i = false;
    protected com.unisound.sdk.au b;
    protected cn.yunzhisheng.asr.a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile boolean f1576a = false;
    protected byte[] d = {100};
    private boolean e = false;
    private boolean f = false;
    private java.util.ArrayList<byte[]> g = new java.util.ArrayList<>();

    public z(cn.yunzhisheng.asr.a aVar, com.unisound.sdk.au auVar) {
        this.b = null;
        this.c = null;
        this.c = aVar;
        this.b = auVar;
    }

    public z(cn.yunzhisheng.asr.a aVar, com.unisound.sdk.au auVar, boolean z) {
        this.b = null;
        this.c = null;
        this.c = aVar;
        this.b = auVar;
    }

    public static void b(boolean z) {
        h = z;
    }

    public static void c(boolean z) {
        i = z;
    }

    public static boolean l() {
        return h;
    }

    public static boolean m() {
        return i;
    }

    protected void a(boolean z) {
        com.unisound.sdk.au auVar = this.b;
        if (auVar != null) {
            auVar.b(z);
        }
    }

    protected void a(boolean z, byte[] bArr, int i2, int i3) {
        com.unisound.sdk.au auVar = this.b;
        if (auVar != null) {
            auVar.a(z, bArr, i2, i3);
        }
    }

    protected void a(byte[] bArr) {
        this.g.add(bArr);
        int iX = this.c.x();
        int length = 0;
        for (int size = this.g.size() - 1; size >= 0; size--) {
            length += this.g.get(size).length;
            if (length >= iX) {
                this.e = true;
                return;
            }
        }
    }

    protected abstract boolean a();

    protected abstract void b();

    protected abstract byte[] c();

    public void d() {
        if (e()) {
            return;
        }
        com.unisound.common.y.c("InputSourceThread::stopRecording");
        this.f1576a = true;
    }

    public boolean e() {
        return this.f1576a;
    }

    public boolean f() {
        return this.b == null;
    }

    public void g() {
        if (f()) {
            return;
        }
        d();
        com.unisound.common.y.c("InputSourceThread::cancel");
        this.b = null;
    }

    protected void h() throws java.lang.Throwable {
        boolean zB = com.unisound.common.j.b(this.c.c());
        if (this.c.b() && zB) {
            com.unisound.common.y.c("add wav header to recordingfile!");
            com.unisound.common.j.a(this.c.c(), 1, this.c.au());
        }
        com.unisound.sdk.au auVar = this.b;
        if (auVar != null) {
            auVar.j();
        }
    }

    protected void i() {
        com.unisound.sdk.au auVar = this.b;
        if (auVar != null) {
            auVar.k();
        }
    }

    public boolean j() {
        return this.f1576a;
    }

    public void k() {
        g();
        if (isAlive()) {
            try {
                join(4000L);
                com.unisound.common.y.c("InputSourceThread::waitEnd()");
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws java.lang.Throwable {
        java.lang.Object[] objArr;
        com.unisound.common.y.g("Recording InputSource Thread start");
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("InputSourceThread -> ThreadName = ", java.lang.Thread.currentThread().getName(), ", ThreadId = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
        }
        android.os.Process.setThreadPriority(-19);
        try {
            try {
                if (a()) {
                    if (this.c.b() && this.c.z()) {
                        com.unisound.common.j.b(false, this.c.c());
                        com.unisound.common.j.b(false, this.c.c());
                        com.unisound.common.j.b(false, this.c.c());
                    }
                    a(true);
                    while (!e() && !f()) {
                        byte[] bArrC = c();
                        if (bArrC != null) {
                            if (com.unisound.common.y.l) {
                                com.unisound.common.y.d("InputSourceThread::read size =", java.lang.Integer.valueOf(bArrC.length), " first byte ", java.lang.Byte.valueOf(bArrC[0]), "thread = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
                            }
                            if (this.c.a() && !this.f) {
                                this.f = true;
                                if (bArrC.length > 44) {
                                    java.lang.System.arraycopy(new byte[44], 0, bArrC, 0, 43);
                                    com.unisound.common.y.c("InputSourceThread ignore wav header!");
                                }
                            }
                            if (!this.e) {
                                a(bArrC);
                            }
                            if (this.e) {
                                a(true, bArrC, 0, bArrC.length);
                            }
                        }
                    }
                } else {
                    a(false);
                }
                byte[] bArr = this.d;
                a(true, java.util.Arrays.copyOfRange(bArr, 0, bArr.length), 0, 1);
                b();
                this.g.clear();
                h();
                com.unisound.common.y.c("recording stopped");
                objArr = new java.lang.Object[]{"InputSourceThread::recording destory"};
            } catch (java.lang.Throwable th) {
                com.unisound.common.y.c("recording error");
                th.printStackTrace();
                byte[] bArr2 = this.d;
                a(true, java.util.Arrays.copyOfRange(bArr2, 0, bArr2.length), 0, 1);
                b();
                this.g.clear();
                i();
                com.unisound.common.y.c("recording error");
                objArr = new java.lang.Object[]{"InputSourceThread::recording destory"};
            }
            com.unisound.common.y.c(objArr);
            com.unisound.common.y.g("Recording InputSource Thread stop");
        } catch (java.lang.Throwable th2) {
            byte[] bArr3 = this.d;
            a(true, java.util.Arrays.copyOfRange(bArr3, 0, bArr3.length), 0, 1);
            b();
            this.g.clear();
            h();
            com.unisound.common.y.c("recording stopped");
            com.unisound.common.y.c("InputSourceThread::recording destory");
            throw th2;
        }
    }
}
