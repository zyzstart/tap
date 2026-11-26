package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class by extends com.unisound.sdk.bt {
    public static final int c = 50;
    int e;
    int f;
    private java.util.concurrent.BlockingQueue<byte[]> i;
    private com.unisound.sdk.bz j;
    private boolean k;
    private volatile int l;
    private volatile int m;
    private com.unisound.sdk.BlockingAudioTrack n;
    private boolean o;
    private boolean p;
    private java.lang.Object q;
    private java.lang.Boolean r;
    private java.lang.Boolean s;
    private com.unisound.client.IAudioSource t;
    private com.unisound.sdk.bx u;
    private java.lang.String v;
    private static final java.text.SimpleDateFormat g = new java.text.SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", java.util.Locale.getDefault());
    private static int h = 50;
    public static boolean d = false;

    public by(com.unisound.sdk.bx bxVar) {
        super(bxVar.v().booleanValue(), bxVar.q());
        this.i = new java.util.concurrent.LinkedBlockingQueue();
        this.k = false;
        this.l = 0;
        this.m = 0;
        this.n = null;
        this.o = false;
        this.p = false;
        this.q = new java.lang.Object();
        this.r = true;
        this.s = true;
        this.v = "";
        this.e = 0;
        this.f = 0;
        this.u = bxVar;
        this.e = ((bxVar.B() * bxVar.C()) * 2) / 1000;
        this.f = bxVar.L();
        this.v = java.lang.System.currentTimeMillis() + "";
    }

    private synchronized void a(int i, int i2) {
        try {
            switch (i) {
                case 0:
                    this.l += i2;
                    break;
                case 1:
                    this.l -= i2;
                    break;
                case 2:
                    this.l = i2;
                    break;
                default:
                    break;
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    public static byte[] a(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        byte[] bArr = new byte[sArr.length * 2];
        for (int i = 0; i < sArr.length; i++) {
            short s = sArr[i];
            int i2 = i * 2;
            bArr[i2] = (byte) (s & 255);
            bArr[i2 + 1] = (byte) ((s & 65280) >> 8);
        }
        return bArr;
    }

    public static void b(boolean z) {
        d = z;
    }

    private void c(boolean z) {
        com.unisound.sdk.bz bzVar = this.j;
        if (bzVar != null) {
            bzVar.a(z);
        }
    }

    private void d(int i) {
        com.unisound.sdk.bz bzVar = this.j;
        if (bzVar != null) {
            bzVar.b(i);
        }
        this.p = false;
    }

    private synchronized void e(int i) {
        try {
            switch (i) {
                case 0:
                    this.m++;
                    break;
                case 1:
                    this.m--;
                    break;
                case 2:
                    this.m = 0;
                    break;
                default:
                    break;
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    public static boolean l() {
        return d;
    }

    private boolean m() {
        return this.k;
    }

    private void n() {
        com.unisound.sdk.bz bzVar = this.j;
        if (bzVar != null) {
            bzVar.a();
        }
    }

    private void o() {
        com.unisound.sdk.bz bzVar = this.j;
        if (bzVar != null) {
            bzVar.b();
        }
    }

    private void p() {
        com.unisound.sdk.bz bzVar = this.j;
        if (bzVar != null) {
            bzVar.c();
        }
    }

    private void q() {
        this.p = false;
        com.unisound.sdk.bz bzVar = this.j;
        if (bzVar != null) {
            bzVar.e();
        }
    }

    private void r() {
        com.unisound.sdk.bz bzVar = this.j;
        if (bzVar != null) {
            bzVar.f();
        }
    }

    private void s() throws java.lang.Throwable {
        if (com.unisound.common.y.s) {
            com.unisound.common.j.a("/sdcard/asrtest/" + this.v + ".wav", 1, this.u.C());
        }
        com.unisound.sdk.bz bzVar = this.j;
        if (bzVar != null) {
            bzVar.g();
        }
        this.p = false;
    }

    private java.lang.String t() {
        return g.format(new java.util.Date(java.lang.System.currentTimeMillis())) + ".pcm";
    }

    private boolean u() {
        if (this.u.K()) {
            return this.m > 0;
        }
        return this.l > 0;
    }

    private void v() {
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("TTSPlayThread->playThreadNotify begin");
        }
        synchronized (this.q) {
            if (this.o) {
                this.o = false;
                com.unisound.common.y.c("lockObject notify..");
                this.q.notify();
                r();
            }
        }
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("TTSPlayThread->playThreadNotify end");
        }
    }

    private void w() {
        this.o = true;
    }

    public void a(com.unisound.client.IAudioSource iAudioSource) {
        this.t = iAudioSource;
        if (this.t == null) {
            this.t = new com.unisound.common.e(this.u);
        }
    }

    public void a(com.unisound.sdk.bz bzVar) {
        this.j = bzVar;
    }

    public void a(java.lang.Boolean bool) {
        this.r = bool;
    }

    public void a(byte[] bArr) {
        if (this.u.K()) {
            e(0);
            if (this.m >= this.f) {
                c(true);
            } else {
                c(false);
            }
        } else {
            a(0, bArr.length);
        }
        this.i.add(bArr);
        if (this.s.booleanValue()) {
            n();
            this.s = false;
        }
    }

    @Override // com.unisound.sdk.bt
    public void b() {
        java.lang.Object[] objArr;
        super.b();
        if (this.t != null) {
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("TTSPlayThread->reqStop AudioSource 1");
            }
            v();
            synchronized (this.q) {
                if (this.t != null) {
                    if (com.unisound.common.y.l) {
                        com.unisound.common.y.d("TTSPlayThread->AudioSource.closeAudioOut begin");
                    }
                    this.t.closeAudioOut();
                    if (com.unisound.common.y.l) {
                        com.unisound.common.y.d("TTSPlayThread->AudioSource.closeAudioOut end");
                    }
                    this.t = null;
                }
            }
            if (!com.unisound.common.y.l) {
                return;
            } else {
                objArr = new java.lang.Object[]{"TTSPlayThread->reqStop AudioSource 2"};
            }
        } else {
            com.unisound.sdk.BlockingAudioTrack blockingAudioTrack = this.n;
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("TTSPlayThread->reqStop AudioTrack 1");
            }
            if (blockingAudioTrack != null) {
                v();
                if (com.unisound.common.y.l) {
                    com.unisound.common.y.d("TTSPlayThread->audioTrack.stop() begin");
                }
                blockingAudioTrack.stop();
                if (com.unisound.common.y.l) {
                    com.unisound.common.y.d("TTSPlayThread->audioTrack.stop() end");
                }
            }
            if (!com.unisound.common.y.l) {
                return;
            } else {
                objArr = new java.lang.Object[]{"TTSPlayThread->reqStop AudioTrack 2"};
            }
        }
        com.unisound.common.y.d(objArr);
    }

    public void b(int i) throws java.lang.Throwable {
        if (com.unisound.common.y.s) {
            com.unisound.common.j.a("/sdcard/asrtest/" + this.v + ".wav", 1, this.u.C());
        }
        com.unisound.sdk.bz bzVar = this.j;
        if (bzVar != null) {
            bzVar.a(i);
        }
    }

    public void c(int i) {
        if (isAlive()) {
            j();
            try {
                super.join(i);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.unisound.sdk.bt
    public void d() {
        super.d();
        w();
    }

    @Override // com.unisound.sdk.bt
    public void f() {
        super.f();
        v();
    }

    public com.unisound.sdk.bz g() {
        return this.j;
    }

    public void h() {
        this.k = true;
    }

    public boolean i() {
        return this.j == null;
    }

    public void j() {
        this.j = null;
        this.r = true;
        this.k = true;
    }

    public boolean k() {
        return this.p;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unisound.common.f, java.lang.Thread, java.lang.Runnable
    public void run() throws java.lang.Throwable {
        java.io.BufferedOutputStream bufferedOutputStream;
        super.run();
        com.unisound.common.y.b("TTSPlayThread run(): play start");
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("TTSPlayThread -> ThreadName = ", java.lang.Thread.currentThread().getName(), ", ThreadId = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
        }
        if (!c() || android.text.TextUtils.isEmpty(this.u.w())) {
            bufferedOutputStream = null;
        } else {
            java.io.File file = new java.io.File(this.u.w(), t());
            java.io.File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file, true));
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
                bufferedOutputStream = null;
            }
        }
        com.unisound.client.IAudioSource iAudioSource = this.t;
        if (iAudioSource == null) {
            this.n = new com.unisound.sdk.BlockingAudioTrack(this.u.E(), this.u.C(), 2, 1);
            this.n.init();
            this.n.start();
        } else {
            if (iAudioSource.openAudioOut() != 0) {
                d(com.unisound.client.ErrorCode.TTS_ERROR_AUDIOSOURCE_OPEN);
                return;
            }
            b(true);
        }
        int iC = ((this.u.C() * 2) / 1000) * 50;
        while (!this.r.booleanValue()) {
            try {
                try {
                    try {
                        if (com.unisound.common.y.l) {
                            com.unisound.common.y.d("TTSPlayThread :: pause 1 ");
                        }
                        java.lang.Thread.sleep(50L);
                    } catch (java.lang.Throwable th) {
                        if (this.t != null) {
                            if (com.unisound.common.y.l) {
                                com.unisound.common.y.d("TTSPlayThread ->reqStop--1--");
                            }
                            synchronized (this.q) {
                                if (com.unisound.common.y.l) {
                                    com.unisound.common.y.d("TTSPlayThread ->reqStop--2--");
                                }
                                if (this.t != null) {
                                    if (com.unisound.common.y.l) {
                                        com.unisound.common.y.d("TTSPlayThread->run:AudioSource.closeAudioOut() begin");
                                    }
                                    this.t.closeAudioOut();
                                    if (com.unisound.common.y.l) {
                                        com.unisound.common.y.d("TTSPlayThread->run:AudioSource.closeAudioOut() end");
                                    }
                                    this.t = null;
                                }
                            }
                        } else {
                            if (com.unisound.common.y.l) {
                                com.unisound.common.y.d("TTSPlayThread ->reqStop--3--");
                            }
                            com.unisound.sdk.BlockingAudioTrack blockingAudioTrack = this.n;
                            if (blockingAudioTrack != null) {
                                blockingAudioTrack.stop();
                                this.n.waitAndRelease();
                                this.n = null;
                            }
                        }
                        this.o = false;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                }
            } catch (java.lang.Exception e4) {
                e4.printStackTrace();
                d(com.unisound.client.ErrorCode.TTS_ERROR_PLAYING_EXCEPTION);
                if (this.t != null) {
                    if (com.unisound.common.y.l) {
                        com.unisound.common.y.d("TTSPlayThread ->reqStop--1--");
                    }
                    synchronized (this.q) {
                        if (com.unisound.common.y.l) {
                            com.unisound.common.y.d("TTSPlayThread ->reqStop--2--");
                        }
                        if (this.t != null) {
                            if (com.unisound.common.y.l) {
                                com.unisound.common.y.d("TTSPlayThread->run:AudioSource.closeAudioOut() begin");
                            }
                            this.t.closeAudioOut();
                            if (com.unisound.common.y.l) {
                                com.unisound.common.y.d("TTSPlayThread->run:AudioSource.closeAudioOut() end");
                            }
                            this.t = null;
                        }
                    }
                } else {
                    if (com.unisound.common.y.l) {
                        com.unisound.common.y.d("TTSPlayThread ->reqStop--3--");
                    }
                    com.unisound.sdk.BlockingAudioTrack blockingAudioTrack2 = this.n;
                    if (blockingAudioTrack2 != null) {
                        blockingAudioTrack2.stop();
                        this.n.waitAndRelease();
                        this.n = null;
                    }
                }
                this.o = false;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                }
            }
        }
        if (this.u.K()) {
            while (!a() && !m() && this.m < 1) {
                if (com.unisound.common.y.l) {
                    com.unisound.common.y.d("TTSPlayThread :: pause 2 ");
                }
                java.lang.Thread.sleep(50L);
            }
        } else {
            while (!a() && !m() && this.l < this.e) {
                if (com.unisound.common.y.l) {
                    com.unisound.common.y.d("TTSPlayThread :: pause 2 ");
                }
                java.lang.Thread.sleep(50L);
            }
        }
        o();
        if (u()) {
            p();
            while (!a()) {
                byte[] bArrPoll = this.i.poll(h, java.util.concurrent.TimeUnit.MILLISECONDS);
                if (bArrPoll != null) {
                    if (com.unisound.common.y.l) {
                        com.unisound.common.y.d("TTSPlayThread :: buffersize =", java.lang.Integer.valueOf(bArrPoll.length), " first byte = ", java.lang.Byte.valueOf(bArrPoll[0]));
                    }
                    int length = bArrPoll.length;
                    if ((com.unisound.common.y.r || com.unisound.common.y.s) && !android.text.TextUtils.isEmpty(this.v)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("/sdcard/asrtest/");
                        sb.append(this.v);
                        sb.append(com.unisound.common.y.s ? ".wav" : ".pcm");
                        com.unisound.common.j.a(bArrPoll, sb.toString());
                    }
                    if (this.u.K()) {
                        com.unisound.common.y.a("TTSPlay bufferDataTime = " + this.m);
                        if (this.m >= this.f) {
                            c(true);
                        } else {
                            c(false);
                        }
                        e(1);
                    } else {
                        if (this.l >= this.e) {
                            c(true);
                        } else {
                            c(false);
                        }
                        a(1, length);
                    }
                    int i = 0;
                    while (length > 0 && !a()) {
                        synchronized (this.q) {
                            if (this.o) {
                                com.unisound.common.y.c("TTSPlayThread run(): lockObject wait...");
                                q();
                                this.q.wait();
                            } else {
                                this.p = true;
                            }
                        }
                        int i2 = iC > length ? length : iC;
                        if (this.t != null) {
                            byte[] bArr = new byte[i2];
                            java.lang.System.arraycopy(bArrPoll, i, bArr, 0, i2);
                            com.unisound.common.y.f("TTSPlayThread run : before writeData ");
                            if (com.unisound.common.y.l) {
                                com.unisound.common.y.d("TTSPlayThread :: writeData ", java.lang.Integer.valueOf(i2));
                            }
                            this.t.writeData(bArr, i2);
                            com.unisound.common.y.f("TTSPlayThread run : after writeData ");
                        } else {
                            this.n.write(bArrPoll, i, i2);
                        }
                        i += i2;
                        length -= i2;
                    }
                    if (bufferedOutputStream != null && c()) {
                        bufferedOutputStream.write(bArrPoll, 0, bArrPoll.length);
                    }
                } else if (m()) {
                    break;
                } else {
                    c(false);
                }
            }
            s();
        }
        if (this.t != null) {
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("TTSPlayThread ->reqStop--1--");
            }
            synchronized (this.q) {
                if (com.unisound.common.y.l) {
                    com.unisound.common.y.d("TTSPlayThread ->reqStop--2--");
                }
                if (this.t != null) {
                    if (com.unisound.common.y.l) {
                        com.unisound.common.y.d("TTSPlayThread->run:AudioSource.closeAudioOut() begin");
                    }
                    this.t.closeAudioOut();
                    if (com.unisound.common.y.l) {
                        com.unisound.common.y.d("TTSPlayThread->run:AudioSource.closeAudioOut() end");
                    }
                    this.t = null;
                }
            }
        } else {
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("TTSPlayThread ->reqStop--3--");
            }
            com.unisound.sdk.BlockingAudioTrack blockingAudioTrack3 = this.n;
            if (blockingAudioTrack3 != null) {
                blockingAudioTrack3.stop();
                this.n.waitAndRelease();
                this.n = null;
            }
        }
        this.o = false;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }
        b(false);
        b(0);
        if (this.u.K()) {
            e(2);
        } else {
            a(2, 0);
        }
        com.unisound.common.y.b("TTSPlayThread run(): play end");
    }
}
