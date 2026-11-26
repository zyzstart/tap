package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k extends java.lang.Thread {
    protected static long h = 30;
    protected com.unisound.sdk.w l;
    protected cn.yunzhisheng.asrfix.JniAsrFix m;
    protected java.lang.String p;
    public android.content.Context t;
    protected java.util.concurrent.BlockingQueue<byte[]> i = new java.util.concurrent.LinkedBlockingQueue();
    protected com.unisound.sdk.aj j = null;
    protected com.unisound.sdk.ak k = null;
    protected boolean n = false;
    protected boolean o = false;
    protected java.lang.String q = "";
    public java.util.List<byte[]> r = new java.util.LinkedList();
    public java.util.concurrent.BlockingQueue<byte[]> s = new java.util.concurrent.LinkedBlockingQueue();

    public k(cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix, java.lang.String str, com.unisound.sdk.w wVar, android.content.Context context) {
        this.l = null;
        this.m = null;
        this.p = "";
        this.t = context;
        this.m = jniAsrFix;
        this.p = str;
        this.l = wVar;
    }

    protected void a(int i) {
        com.unisound.common.y.c("RecognitionThreadInterface:doRecognitionError=", java.lang.Integer.valueOf(i));
        com.unisound.sdk.ak akVar = this.k;
        if (akVar != null) {
            akVar.a(i);
        }
    }

    protected void a(int i, int i2, java.lang.Object obj) {
        com.unisound.sdk.ak akVar = this.k;
        if (akVar != null) {
            akVar.a(i, i2, obj);
        }
    }

    public void a(com.unisound.sdk.aj ajVar) {
        this.j = ajVar;
    }

    public void a(com.unisound.sdk.ak akVar) {
        this.k = akVar;
    }

    protected void a(java.lang.String str, boolean z, int i, int i2) {
        com.unisound.common.y.c("RecognitionThreadInterface:doRecognitionResult partial=", str + ", utteranceStartTime = " + i + ", utteranceEndTime = " + i2);
        com.unisound.sdk.ak akVar = this.k;
        if (akVar != null) {
            com.unisound.sdk.al alVar = new com.unisound.sdk.al();
            alVar.a(str);
            alVar.a(z);
            alVar.a(i);
            alVar.b(i2);
            akVar.a(alVar);
        }
    }

    protected void a(java.lang.String str, boolean z, int i, long j, long j2, int i2, int i3) {
        com.unisound.common.y.c("RecognitionThreadInterface:doRecognitionResult partial=", str);
        com.unisound.sdk.ak akVar = this.k;
        if (akVar != null) {
            akVar.a(str, true, i, j, j2, i2, i3);
        }
    }

    public void a(boolean z) {
        if (z) {
            c();
        }
        if (isAlive()) {
            try {
                join(3900L);
                com.unisound.common.y.c(getName(), "waitEnd()");
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean a() {
        return !this.i.isEmpty();
    }

    protected void b(int i) {
        com.unisound.common.y.c("RecognitionThreadInterface: onRecognitionEvent event = " + i);
        com.unisound.sdk.ak akVar = this.k;
        if (akVar != null) {
            akVar.k(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void b(long j) {
        com.unisound.common.y.c("dropTime =>", java.lang.Long.valueOf(j));
        long jI = this.l.i(j);
        com.unisound.common.y.c("dropCacheByteLength =>", java.lang.Long.valueOf(jI));
        long j2 = 0;
        long length = 0;
        for (int i = 0; i < this.r.size(); i++) {
            length += (long) this.r.get(i).length;
            if (length >= jI) {
                j2 = i;
                break;
            }
        }
        for (int i2 = 0; i2 < j2; i2++) {
            this.r.remove(0);
        }
    }

    public void b(byte[] bArr) {
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("FixRecognitionThread::addData size =", java.lang.Integer.valueOf(bArr.length), " first byte ", java.lang.Byte.valueOf(bArr[0]));
        }
        this.i.add(bArr);
    }

    public void c() {
        if (l()) {
            return;
        }
        com.unisound.common.y.c("RecognitionThreadInterface::cancel");
        this.k = null;
        this.n = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void c(long j) {
        com.unisound.common.y.c("dropPcmFromByteLength =>", java.lang.Long.valueOf(j));
        long j2 = 0;
        long length = 0;
        for (int i = 0; i < this.r.size(); i++) {
            length += (long) this.r.get(i).length;
            if (length >= j) {
                j2 = i;
                break;
            }
        }
        for (int i2 = 0; i2 < j2; i2++) {
            this.r.remove(0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected synchronized void c(byte[] bArr) {
        this.r.add(bArr);
        int size = this.r.size() - 1;
        int length = 0;
        while (true) {
            if (size < 0) {
                size = 0;
                break;
            }
            length += this.r.get(size).length;
            if (length >= this.l.J()) {
                break;
            } else {
                size--;
            }
        }
        for (int i = 0; i < size; i++) {
            this.r.remove(0);
        }
    }

    public void d() {
        if (this.n) {
            return;
        }
        com.unisound.common.y.c("RecognitionThreadInterface::stopRecognition");
        this.n = true;
    }

    public void f() {
        this.j = null;
        this.k = null;
    }

    public boolean g() {
        return this.n;
    }

    protected byte[] h() {
        return this.i.poll(h, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    protected void i() {
        com.unisound.common.y.c("RecognitionThreadInterface:doRecognitionMaxSpeechTimeout");
        com.unisound.sdk.ak akVar = this.k;
        if (akVar != null) {
            akVar.m();
        }
    }

    protected void j() {
        com.unisound.common.y.c("RecognitionThreadInterface:onRecognitionVADTimeout");
        com.unisound.sdk.ak akVar = this.k;
        if (akVar != null) {
            akVar.l();
        }
    }

    protected void k() {
        com.unisound.common.y.c("RecognitionThreadInterface:doOneshotStart");
        com.unisound.sdk.ak akVar = this.k;
        if (akVar == null || !(akVar instanceof com.unisound.sdk.m)) {
            return;
        }
        ((com.unisound.sdk.m) akVar).c();
    }

    protected boolean l() {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = this.m;
        return (jniAsrFix != null && jniAsrFix.c()) || this.k == null;
    }

    protected void m() throws java.lang.Throwable {
        if (com.unisound.common.y.s) {
            com.unisound.common.j.a("/sdcard/asrtest/" + this.q + ".wav", 1, this.l.be());
        }
        com.unisound.sdk.ak akVar = this.k;
        if (akVar != null) {
            akVar.i();
        }
    }

    protected int n() {
        com.unisound.sdk.aj ajVar = this.j;
        if (ajVar != null) {
            return ajVar.a();
        }
        return 0;
    }

    public void o() {
        if (!this.l.A() || this.l.B()) {
            return;
        }
        this.r.clear();
    }

    public void p() {
        if (!this.l.A() || this.r.size() <= 0) {
            return;
        }
        long size = this.r.size();
        com.unisound.sdk.w wVar = this.l;
        if (size <= wVar.i(wVar.O())) {
            this.s.add(com.unisound.common.j.a(this.t));
        }
        this.s.addAll(this.r);
        this.s.addAll(this.i);
        this.r.clear();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
    }

    @Override // java.lang.Thread
    public void start() {
        super.start();
    }
}
