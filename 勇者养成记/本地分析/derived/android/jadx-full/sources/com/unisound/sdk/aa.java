package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class aa extends java.lang.Thread {
    protected static long g = 30;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile boolean f1511a;
    protected com.unisound.sdk.au b;
    protected cn.yunzhisheng.asr.a c;
    protected cn.yunzhisheng.asr.VAD d;
    protected java.util.concurrent.BlockingQueue<byte[]> e;
    byte[] f;
    private android.content.Context h;

    public aa(android.content.Context context, cn.yunzhisheng.asr.a aVar, com.unisound.sdk.au auVar) {
        this.f1511a = false;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = new java.util.concurrent.LinkedBlockingQueue();
        this.h = context;
        this.c = aVar;
        this.b = auVar;
        com.unisound.common.y.c("InputVadThread::VAD new");
        this.d = new cn.yunzhisheng.asr.VAD(aVar, auVar);
        this.d.b();
    }

    public aa(android.content.Context context, cn.yunzhisheng.asr.a aVar, com.unisound.sdk.au auVar, boolean z) {
        this.f1511a = false;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = new java.util.concurrent.LinkedBlockingQueue();
        this.h = context;
        this.c = aVar;
        this.b = auVar;
    }

    public void a() {
        if (b()) {
            return;
        }
        com.unisound.common.y.c("InputVadThread::stopVad");
        this.f1511a = true;
    }

    public void a(java.util.Collection<byte[]> collection) {
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("inputVADThread::addAll");
        }
        com.unisound.common.y.c("inputVADThread::addAll");
        this.e.addAll(collection);
    }

    public void a(byte[] bArr) {
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("inputVADThread::addData size =", java.lang.Integer.valueOf(bArr.length), " first byte ", java.lang.Byte.valueOf(bArr[0]), " thread = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
        }
        this.e.add(bArr);
    }

    public boolean b() {
        return this.f1511a;
    }

    public boolean c() {
        return this.b == null;
    }

    public void d() {
        if (c()) {
            return;
        }
        a();
        com.unisound.common.y.c("InputVadThread::cancel");
        this.e.clear();
        this.b = null;
    }

    public boolean e() {
        return this.f1511a;
    }

    public void f() {
        d();
        if (isAlive()) {
            try {
                join(4000L);
                com.unisound.common.y.c("InputVadThread::waitEnd()");
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void g() {
        if (this.c.T()) {
            return;
        }
        if (!this.e.isEmpty()) {
            this.e.clear();
        }
        if (this.d.g.isEmpty()) {
            return;
        }
        this.d.g.clear();
    }

    public void h() {
        com.unisound.common.y.c("InputVadThread setVadEnable = " + this.c.am());
        this.d.a(this.c.am());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        java.lang.Object[] objArr;
        com.unisound.common.y.g("InputVadThread start");
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("InputVadThread -> run ThreadName = ", java.lang.Thread.currentThread().getName(), ", ThreadId = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
        }
        while (true) {
            try {
                try {
                    if ((b() && this.e.isEmpty()) || c()) {
                        break;
                    }
                    if (this.c.B() || this.d.g.size() <= 0 || !this.d.h) {
                        byte[] bArrPoll = this.e.poll(g, java.util.concurrent.TimeUnit.MILLISECONDS);
                        this.f = bArrPoll;
                        if (bArrPoll == null) {
                            java.lang.Thread.sleep(20L);
                        } else {
                            if (this.f.length == 1 && this.f[0] == 100) {
                                d();
                                break;
                            }
                            if (this.f.length == 2 && this.f[0] == -56 && this.f[1] == -56) {
                                if (this.c.z()) {
                                    com.unisound.common.j.b(true, this.c.c());
                                    com.unisound.common.j.b(true, this.c.c());
                                    com.unisound.common.j.b(true, this.c.c());
                                }
                                this.c.S();
                            } else {
                                if (com.unisound.common.y.l) {
                                    com.unisound.common.y.d("inputVADThread::write size =", java.lang.Integer.valueOf(this.f.length), " first byte ", java.lang.Byte.valueOf(this.f[0]), " thread = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
                                }
                                this.d.a(this.f, 0, this.f.length);
                            }
                        }
                    } else {
                        byte[] bArrRemove = this.d.g.remove(0);
                        this.d.a(this.d.h, bArrRemove, 0, bArrRemove.length);
                        if (com.unisound.common.y.l) {
                            com.unisound.common.y.d("inputVADThread::ondata size=", java.lang.Integer.valueOf(bArrRemove.length), " first byte ", java.lang.Byte.valueOf(bArrRemove[0]), " thread = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.unisound.common.y.c("InputVadThread::" + e.getMessage());
                    e.printStackTrace();
                    this.b.k();
                    objArr = new java.lang.Object[]{"InputVadThread::VAD destory"};
                }
            } catch (java.lang.Throwable th) {
                com.unisound.common.y.c("InputVadThread::VAD destory");
                this.d.d();
                this.e.clear();
                throw th;
            }
        }
        if (this.b != null) {
            this.d.e();
        }
        objArr = new java.lang.Object[]{"InputVadThread::VAD destory"};
        com.unisound.common.y.c(objArr);
        this.d.d();
        this.e.clear();
        com.unisound.common.y.g("InputVadThread stop");
    }
}
