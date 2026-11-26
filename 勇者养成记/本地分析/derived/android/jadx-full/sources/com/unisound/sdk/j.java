package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j extends com.unisound.sdk.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    cn.yunzhisheng.asr.VAD f1566a;
    com.unisound.sdk.aa b;
    boolean c;
    boolean d;
    public java.util.List<byte[]> e;
    boolean f;
    int g;
    private boolean u;
    private int v;
    private int w;
    private java.lang.String x;

    public j(cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix, java.lang.String str, com.unisound.sdk.w wVar, android.content.Context context) {
        super(jniAsrFix, str, wVar, context);
        this.c = false;
        this.d = false;
        this.u = true;
        this.f = true;
        this.g = 0;
        this.v = 200;
        this.w = 3000;
        this.x = "";
    }

    public j(cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix, java.lang.String str, com.unisound.sdk.w wVar, com.unisound.sdk.aa aaVar, android.content.Context context) {
        super(jniAsrFix, str, wVar, context);
        this.c = false;
        this.d = false;
        this.u = true;
        this.f = true;
        this.g = 0;
        this.v = 200;
        this.w = 3000;
        this.x = "";
        this.f1566a = aaVar.d;
        this.b = aaVar;
        this.e = new java.util.ArrayList();
    }

    private java.util.List<byte[]> a(java.util.concurrent.BlockingQueue<byte[]> blockingQueue) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long jAk = this.l.ak();
        while (!blockingQueue.isEmpty()) {
            byte[] bArrPoll = blockingQueue.poll();
            if (bArrPoll != null) {
                a(arrayList, bArrPoll, (int) jAk);
            }
        }
        return arrayList;
    }

    private void a(java.lang.String str, boolean z) {
        int i;
        if (str == null || str.length() < 0) {
            return;
        }
        if (com.unisound.sdk.l.d(str) < this.l.E()) {
            q();
            return;
        }
        if (this.l.z()) {
            com.unisound.common.j.a(false, this.l.c());
        }
        java.lang.String strE = com.unisound.sdk.l.e(str);
        this.l.d(strE);
        int iL = this.m.l();
        int iQ = this.m.q();
        int i2 = iQ - iL;
        int iA = this.l.A(this.l.ag()) - iQ;
        com.unisound.common.y.c("utteranceEndTime = ", java.lang.Integer.valueOf(iQ));
        com.unisound.common.y.c("utteranceStartTime = ", java.lang.Integer.valueOf(iL));
        com.unisound.common.y.c("utteranceTime = ", java.lang.Integer.valueOf(i2));
        com.unisound.common.y.c("delayTime = ", java.lang.Integer.valueOf(iA));
        this.l.j(iL);
        this.l.k(i2);
        long jU = this.l.U();
        long jR = this.l.R();
        long jH = this.l.h(jR - jU) + ((long) iL);
        com.unisound.common.y.c("wakeupLength = " + this.l.h(jU));
        com.unisound.common.y.c("outCacheLength = " + this.l.h(jR));
        this.l.l(true);
        com.unisound.common.ba baVarA = com.unisound.common.ba.a();
        com.unisound.common.bd bdVar = new com.unisound.common.bd();
        bdVar.a(this.l.aZ());
        bdVar.b(com.unisound.c.a.a(this.l.aZ()));
        bdVar.c(this.l.bu());
        bdVar.a(com.unisound.sdk.l.d(str));
        bdVar.e(strE);
        bdVar.f(java.lang.System.currentTimeMillis() + "");
        bdVar.g(i2 + "");
        bdVar.a(this.l.be());
        e();
        java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue();
        com.unisound.common.y.c("dropWakeup end wakeupCacheList.size() =>", java.lang.Integer.valueOf(this.e.size()));
        linkedBlockingQueue.addAll(this.e);
        q();
        baVarA.a(this.t, bdVar, linkedBlockingQueue);
        if (this.l.c == null || !this.l.c.a()) {
            i = iA;
        } else {
            if (this.l.ab()) {
                i = iA;
            } else if (this.l.c.s()) {
                i = iA;
                this.l.c.g(i);
                this.l.c.d(i2);
            } else {
                i = iA;
                this.l.c.f(i);
                this.l.c.c(i2);
            }
            if (!this.l.aa()) {
                this.l.p(1);
            }
            if (this.l.A()) {
                this.l.n(false);
                this.b.g();
                if (!this.l.T() && !this.i.isEmpty()) {
                    this.i.clear();
                }
                this.l.a(this.l.u(), this.l.W());
            }
        }
        if (this.l.A()) {
            this.f = false;
        }
        a(str, z, i2, jH, i, iL, iQ);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void a(java.util.List<byte[]> list, byte[] bArr, int i) {
        list.add(bArr);
        int size = list.size() - 1;
        int length = 0;
        while (true) {
            if (size < 0) {
                size = 0;
                break;
            }
            length += list.get(size).length;
            if (length >= i) {
                break;
            } else {
                size--;
            }
        }
        for (int i2 = 0; i2 < size; i2++) {
            list.remove(0);
        }
    }

    private void b(boolean z) {
        com.unisound.sdk.aa aaVar;
        this.o = true;
        java.lang.String strL = this.l.L();
        int iA = this.l.A(this.l.ag()) - this.m.q();
        this.g = 0;
        this.f = true;
        if (!this.l.j(strL) || !z) {
            com.unisound.common.y.c("continue wakeup");
            this.l.k(false);
            this.l.e("");
            this.l.l(false);
            o();
            if (this.l.c == null || !this.l.c.a() || this.l.aa()) {
                return;
            }
            this.l.p(0);
            return;
        }
        com.unisound.common.y.c("continue oneshot");
        p();
        this.l.k(true);
        this.l.z(this.v + this.l.O() + iA);
        if (this.u) {
            this.u = false;
            if (!this.s.isEmpty() && (aaVar = this.b) != null) {
                aaVar.h();
                this.b.a(a(this.s));
            }
        }
        this.l.e(strL);
        this.l.d(this.l.k());
        this.l.h(false);
        if (this.l.c != null && this.l.c.a()) {
            if (this.l.c.s()) {
                this.l.c.g(true);
                this.l.c.l(this.l.A(this.l.c.m()) - (this.l.O() + iA));
            } else {
                this.l.c.f(true);
                this.l.c.k(this.l.A(this.l.c.m()) - (this.l.O() + iA));
            }
            this.l.n(true);
        }
        this.l.F(this.l.ay());
        k();
    }

    /* JADX WARN: Code duplicated, block: B:68:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x01bf  */
    private int d(byte[] bArr) throws java.lang.Throwable {
        java.lang.Object[] objArr;
        if (bArr.length == 1 && (bArr[0] == 100 || bArr[0] == 99)) {
            this.o = true;
            return -1;
        }
        com.unisound.common.y.f("Before recognize");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("FixRecognitionThread::BF_recognize ; current Time =", java.lang.Long.valueOf(jCurrentTimeMillis));
        }
        a(1, 3, bArr);
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("FixRecognitionThread::read size =", java.lang.Integer.valueOf(bArr.length), " first byte ", java.lang.Byte.valueOf(bArr[0]));
        }
        this.l.c.e(bArr.length);
        if ((com.unisound.common.y.r || com.unisound.common.y.s) && !android.text.TextUtils.isEmpty(this.q)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("/sdcard/asrtest/");
            sb.append(this.q);
            sb.append(com.unisound.common.y.s ? ".wav" : ".pcm");
            com.unisound.common.j.a(bArr, sb.toString());
        }
        int iB = this.m.b(bArr, bArr.length);
        this.l.w(bArr.length);
        if (this.l.A()) {
            if (!this.l.B() && (this.l.c == null || !this.l.c.a())) {
                this.l.g(bArr.length);
                c(bArr);
            }
            if (!this.l.B() && this.l.D()) {
                this.g += bArr.length;
                int iU = this.m.u();
                com.unisound.common.y.c("Wakeupsuccess check oneshotdata status = " + iU);
                if (iU == 4) {
                    b(true);
                } else if (this.g >= this.l.i(this.l.aK())) {
                    b(com.unisound.client.SpeechConstants.ASR_EVENT_ONESHOT_CHECK_END_TIMEOUT);
                    b(false);
                }
            }
        }
        com.unisound.common.y.f("queueHeadBuffer = ", java.lang.Integer.valueOf(bArr.length));
        com.unisound.common.y.f("After recognize ");
        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("FixRecognitionThread::AF_recognize ; current Time =", java.lang.Long.valueOf(jCurrentTimeMillis2));
        }
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("FixRecognitionThread::recognize_process_time =", java.lang.Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis));
        }
        if (this.x.equals(com.unisound.sdk.cx.f1560a)) {
            a(bArr);
        }
        if (iB == 2) {
            if (this.l.z()) {
                com.unisound.common.j.a(false, 16000, this.l.c());
            }
            java.lang.String strF = this.m.f();
            int iL = this.m.l();
            int iQ = this.m.q();
            if (this.l.A()) {
                if (!this.l.y()) {
                    a(strF, false, iL, iQ);
                } else if (!this.l.D()) {
                    a(strF, false);
                }
            } else if (this.l.y()) {
                a(strF, false);
            } else {
                a(strF, false, iL, iQ);
            }
            if (this.l.A() && this.l.B()) {
                this.c = true;
            }
            com.unisound.common.y.c("FixRecognitionThread:recognize=", java.lang.Integer.valueOf(iB));
            com.unisound.common.y.c("FixRecognitionThread:partial = ", strF);
            a(3, 2, strF);
        } else {
            if (iB == 3) {
                j();
                objArr = new java.lang.Object[]{"FixRecognitionThread:onRecognitionVADTimeout"};
            } else if (iB == -6) {
                i();
                objArr = new java.lang.Object[]{"FixRecognitionThread:max timeout"};
            } else if (iB != 1 && iB < 0) {
                d();
                a(cn.yunzhisheng.asrfix.JniAsrFix.a(iB));
                this.d = true;
                return -1;
            }
            com.unisound.common.y.c(objArr);
        }
        boolean z = this.o;
        return 0;
    }

    private void q() {
        this.e.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void a(long j) {
        com.unisound.common.y.c("dropWakeupPcmFromByteLength =>", java.lang.Long.valueOf(j));
        com.unisound.common.y.c("dropWakeup wakeupCacheList.size() =>", java.lang.Integer.valueOf(this.e.size()));
        long j2 = 0;
        long length = 0;
        for (int size = this.e.size() - 1; size >= 0; size--) {
            length += (long) this.e.get(size).length;
            if (length >= j) {
                j2 = size;
                break;
            }
        }
        com.unisound.common.y.c("dropWakeup enabled = " + j2);
        for (int i = 0; i < j2; i++) {
            this.e.remove(0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected synchronized void a(byte[] bArr) {
        this.e.add(bArr);
        int iBe = (this.l.be() / 1000) * this.w * 2;
        int size = this.e.size() - 1;
        int length = 0;
        while (true) {
            if (size < 0) {
                size = 0;
                break;
            }
            length += this.e.get(size).length;
            if (length >= iBe) {
                break;
            } else {
                size--;
            }
        }
        for (int i = 0; i < size; i++) {
            this.e.remove(0);
        }
    }

    @Override // com.unisound.sdk.k
    protected boolean a() {
        if (this.i.isEmpty()) {
            return (this.b.e.isEmpty() || this.b.b()) ? false : true;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x02c2 A[Catch: all -> 0x02cf, TryCatch #1 {, blocks: (B:8:0x0010, B:10:0x0016, B:12:0x0020, B:13:0x0027, B:15:0x0040, B:17:0x0048, B:19:0x0061, B:20:0x0096, B:22:0x0098, B:24:0x00bb, B:26:0x00c5, B:28:0x00f4, B:29:0x010b, B:36:0x0189, B:37:0x018d, B:39:0x0193, B:41:0x019a, B:43:0x01a4, B:45:0x01b2, B:47:0x01b8, B:49:0x01c2, B:51:0x01ca, B:52:0x01d2, B:55:0x01d9, B:58:0x01df, B:68:0x01ff, B:70:0x0203, B:72:0x0207, B:74:0x020d, B:59:0x01e3, B:61:0x01f1, B:64:0x01f8, B:77:0x021b, B:79:0x024a, B:81:0x0257, B:84:0x0260, B:86:0x0268, B:88:0x0272, B:91:0x0283, B:93:0x0291, B:97:0x02a2, B:99:0x02aa, B:101:0x02b2, B:103:0x02ba, B:105:0x02c2, B:106:0x02c8, B:107:0x02cd, B:94:0x0295, B:96:0x029f, B:76:0x0218, B:30:0x0121, B:32:0x0135, B:33:0x016a, B:35:0x016c), top: B:115:0x0010, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x02c8 A[Catch: all -> 0x02cf, TryCatch #1 {, blocks: (B:8:0x0010, B:10:0x0016, B:12:0x0020, B:13:0x0027, B:15:0x0040, B:17:0x0048, B:19:0x0061, B:20:0x0096, B:22:0x0098, B:24:0x00bb, B:26:0x00c5, B:28:0x00f4, B:29:0x010b, B:36:0x0189, B:37:0x018d, B:39:0x0193, B:41:0x019a, B:43:0x01a4, B:45:0x01b2, B:47:0x01b8, B:49:0x01c2, B:51:0x01ca, B:52:0x01d2, B:55:0x01d9, B:58:0x01df, B:68:0x01ff, B:70:0x0203, B:72:0x0207, B:74:0x020d, B:59:0x01e3, B:61:0x01f1, B:64:0x01f8, B:77:0x021b, B:79:0x024a, B:81:0x0257, B:84:0x0260, B:86:0x0268, B:88:0x0272, B:91:0x0283, B:93:0x0291, B:97:0x02a2, B:99:0x02aa, B:101:0x02b2, B:103:0x02ba, B:105:0x02c2, B:106:0x02c8, B:107:0x02cd, B:94:0x0295, B:96:0x029f, B:76:0x0218, B:30:0x0121, B:32:0x0135, B:33:0x016a, B:35:0x016c), top: B:115:0x0010, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x020d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x01ff A[Catch: all -> 0x02cf, TRY_ENTER, TryCatch #1 {, blocks: (B:8:0x0010, B:10:0x0016, B:12:0x0020, B:13:0x0027, B:15:0x0040, B:17:0x0048, B:19:0x0061, B:20:0x0096, B:22:0x0098, B:24:0x00bb, B:26:0x00c5, B:28:0x00f4, B:29:0x010b, B:36:0x0189, B:37:0x018d, B:39:0x0193, B:41:0x019a, B:43:0x01a4, B:45:0x01b2, B:47:0x01b8, B:49:0x01c2, B:51:0x01ca, B:52:0x01d2, B:55:0x01d9, B:58:0x01df, B:68:0x01ff, B:70:0x0203, B:72:0x0207, B:74:0x020d, B:59:0x01e3, B:61:0x01f1, B:64:0x01f8, B:77:0x021b, B:79:0x024a, B:81:0x0257, B:84:0x0260, B:86:0x0268, B:88:0x0272, B:91:0x0283, B:93:0x0291, B:97:0x02a2, B:99:0x02aa, B:101:0x02b2, B:103:0x02ba, B:105:0x02c2, B:106:0x02c8, B:107:0x02cd, B:94:0x0295, B:96:0x029f, B:76:0x0218, B:30:0x0121, B:32:0x0135, B:33:0x016a, B:35:0x016c), top: B:115:0x0010, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0203 A[Catch: all -> 0x02cf, TryCatch #1 {, blocks: (B:8:0x0010, B:10:0x0016, B:12:0x0020, B:13:0x0027, B:15:0x0040, B:17:0x0048, B:19:0x0061, B:20:0x0096, B:22:0x0098, B:24:0x00bb, B:26:0x00c5, B:28:0x00f4, B:29:0x010b, B:36:0x0189, B:37:0x018d, B:39:0x0193, B:41:0x019a, B:43:0x01a4, B:45:0x01b2, B:47:0x01b8, B:49:0x01c2, B:51:0x01ca, B:52:0x01d2, B:55:0x01d9, B:58:0x01df, B:68:0x01ff, B:70:0x0203, B:72:0x0207, B:74:0x020d, B:59:0x01e3, B:61:0x01f1, B:64:0x01f8, B:77:0x021b, B:79:0x024a, B:81:0x0257, B:84:0x0260, B:86:0x0268, B:88:0x0272, B:91:0x0283, B:93:0x0291, B:97:0x02a2, B:99:0x02aa, B:101:0x02b2, B:103:0x02ba, B:105:0x02c2, B:106:0x02c8, B:107:0x02cd, B:94:0x0295, B:96:0x029f, B:76:0x0218, B:30:0x0121, B:32:0x0135, B:33:0x016a, B:35:0x016c), top: B:115:0x0010, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0291 A[Catch: all -> 0x02cf, TryCatch #1 {, blocks: (B:8:0x0010, B:10:0x0016, B:12:0x0020, B:13:0x0027, B:15:0x0040, B:17:0x0048, B:19:0x0061, B:20:0x0096, B:22:0x0098, B:24:0x00bb, B:26:0x00c5, B:28:0x00f4, B:29:0x010b, B:36:0x0189, B:37:0x018d, B:39:0x0193, B:41:0x019a, B:43:0x01a4, B:45:0x01b2, B:47:0x01b8, B:49:0x01c2, B:51:0x01ca, B:52:0x01d2, B:55:0x01d9, B:58:0x01df, B:68:0x01ff, B:70:0x0203, B:72:0x0207, B:74:0x020d, B:59:0x01e3, B:61:0x01f1, B:64:0x01f8, B:77:0x021b, B:79:0x024a, B:81:0x0257, B:84:0x0260, B:86:0x0268, B:88:0x0272, B:91:0x0283, B:93:0x0291, B:97:0x02a2, B:99:0x02aa, B:101:0x02b2, B:103:0x02ba, B:105:0x02c2, B:106:0x02c8, B:107:0x02cd, B:94:0x0295, B:96:0x029f, B:76:0x0218, B:30:0x0121, B:32:0x0135, B:33:0x016a, B:35:0x016c), top: B:115:0x0010, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0295 A[Catch: all -> 0x02cf, TryCatch #1 {, blocks: (B:8:0x0010, B:10:0x0016, B:12:0x0020, B:13:0x0027, B:15:0x0040, B:17:0x0048, B:19:0x0061, B:20:0x0096, B:22:0x0098, B:24:0x00bb, B:26:0x00c5, B:28:0x00f4, B:29:0x010b, B:36:0x0189, B:37:0x018d, B:39:0x0193, B:41:0x019a, B:43:0x01a4, B:45:0x01b2, B:47:0x01b8, B:49:0x01c2, B:51:0x01ca, B:52:0x01d2, B:55:0x01d9, B:58:0x01df, B:68:0x01ff, B:70:0x0203, B:72:0x0207, B:74:0x020d, B:59:0x01e3, B:61:0x01f1, B:64:0x01f8, B:77:0x021b, B:79:0x024a, B:81:0x0257, B:84:0x0260, B:86:0x0268, B:88:0x0272, B:91:0x0283, B:93:0x0291, B:97:0x02a2, B:99:0x02aa, B:101:0x02b2, B:103:0x02ba, B:105:0x02c2, B:106:0x02c8, B:107:0x02cd, B:94:0x0295, B:96:0x029f, B:76:0x0218, B:30:0x0121, B:32:0x0135, B:33:0x016a, B:35:0x016c), top: B:115:0x0010, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x029f A[Catch: all -> 0x02cf, TryCatch #1 {, blocks: (B:8:0x0010, B:10:0x0016, B:12:0x0020, B:13:0x0027, B:15:0x0040, B:17:0x0048, B:19:0x0061, B:20:0x0096, B:22:0x0098, B:24:0x00bb, B:26:0x00c5, B:28:0x00f4, B:29:0x010b, B:36:0x0189, B:37:0x018d, B:39:0x0193, B:41:0x019a, B:43:0x01a4, B:45:0x01b2, B:47:0x01b8, B:49:0x01c2, B:51:0x01ca, B:52:0x01d2, B:55:0x01d9, B:58:0x01df, B:68:0x01ff, B:70:0x0203, B:72:0x0207, B:74:0x020d, B:59:0x01e3, B:61:0x01f1, B:64:0x01f8, B:77:0x021b, B:79:0x024a, B:81:0x0257, B:84:0x0260, B:86:0x0268, B:88:0x0272, B:91:0x0283, B:93:0x0291, B:97:0x02a2, B:99:0x02aa, B:101:0x02b2, B:103:0x02ba, B:105:0x02c2, B:106:0x02c8, B:107:0x02cd, B:94:0x0295, B:96:0x029f, B:76:0x0218, B:30:0x0121, B:32:0x0135, B:33:0x016a, B:35:0x016c), top: B:115:0x0010, inners: #0 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void b() {
        int iL;
        int iQ;
        byte[] bArrPoll;
        java.lang.String str;
        int iN = n();
        if (iN != 0) {
            a(iN);
            this.d = true;
            return;
        }
        synchronized (this.m) {
            if (this.l.c != null && this.l.c.a()) {
                this.l.c.g();
            }
            this.l.V();
            this.l.ah();
            q();
            if (!this.l.A() || this.l.B()) {
                this.x = this.p;
                int iA = this.m.a(this.p, this.l.aB());
                if (iA < 0) {
                    com.unisound.common.y.a("FixRecognitionThread:jac::start error=" + iA + ",model=" + this.p + ",modelId=" + this.l.aB());
                    a(cn.yunzhisheng.asrfix.JniAsrFix.a(iA));
                    this.d = true;
                    return;
                }
                com.unisound.common.y.c("FixRecognitionThread:jac::start model=", this.p, ",modelId=", java.lang.Integer.valueOf(this.l.aB()));
            } else {
                this.l.l(false);
                this.x = com.unisound.sdk.cx.f1560a;
                int iA2 = this.m.a(com.unisound.sdk.cx.f1560a, this.l.aB());
                if (iA2 < 0) {
                    com.unisound.common.y.a("FixRecognitionThread:jac::start error=" + iA2 + ",model=" + this.p + ",modelId=" + this.l.aB());
                    a(cn.yunzhisheng.asrfix.JniAsrFix.a(iA2));
                    this.d = true;
                    return;
                }
                com.unisound.common.y.c("FixRecognitionThread:jac::start model=", com.unisound.sdk.cx.f1560a, ",modelId=", java.lang.Integer.valueOf(this.l.aB()));
                if (this.l.c != null && this.l.c.a()) {
                    int size = this.b.e.size() * this.l.ai();
                    int size2 = this.i.size() * this.l.ai();
                    this.l.c.n();
                    if (this.l.c.s()) {
                        this.l.c.g(false);
                        this.l.c.j(this.l.A(size + size2));
                    } else {
                        this.l.c.f(false);
                        this.l.c.i(this.l.A(size + size2));
                    }
                }
            }
            a(0, 0, (java.lang.Object) null);
            while (!l()) {
                try {
                    if (this.l.c != null && this.l.c.a()) {
                        bArrPoll = this.i.poll(h, java.util.concurrent.TimeUnit.MILLISECONDS);
                        if (bArrPoll != null) {
                            if (this.l.c != null && this.l.c.a() && this.l.A()) {
                                this.l.c.p(bArrPoll.length);
                            }
                            if (d(bArrPoll) == -1) {
                                break;
                            }
                            if (com.unisound.common.y.q) {
                                str = "/sdcard/asrtest/oneshotofflineFourMic.pcm";
                                com.unisound.common.j.a(bArrPoll, str);
                            }
                            if (!this.o) {
                            }
                            com.unisound.common.y.b("FixRecognitionThread:recog break");
                            break;
                        }
                        if (!this.o) {
                        }
                        com.unisound.common.y.b("FixRecognitionThread:recog break");
                        break;
                    }
                    bArrPoll = this.i.poll(h, java.util.concurrent.TimeUnit.MILLISECONDS);
                    if (bArrPoll != null) {
                        if (d(bArrPoll) == -1) {
                            break;
                        }
                        if (com.unisound.common.y.q) {
                            str = "/sdcard/asrtest/offline.pcm";
                            com.unisound.common.j.a(bArrPoll, str);
                        }
                        if (!this.o) {
                        }
                        com.unisound.common.y.b("FixRecognitionThread:recog break");
                        break;
                    }
                    if (!this.o || (this.n && !a())) {
                        com.unisound.common.y.b("FixRecognitionThread:recog break");
                        break;
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            this.m.e();
            com.unisound.common.y.b("FixRecognitionThread:recog stopped");
            java.lang.String strF = this.m.f();
            com.unisound.common.y.b("FixRecognitionThread:partial: ", strF);
            if (this.l.ag() < this.l.g() * 32) {
                com.unisound.common.y.b("FixRecognitionThread:Give Up Result:");
                strF = "";
            }
            if (strF != null && !strF.equals("")) {
                if (this.l.aO() && !this.x.equals(com.unisound.sdk.cx.f1560a)) {
                    iL = this.m.l();
                    iQ = this.m.q();
                }
                a(4, 2, strF);
                a(2, 0, (java.lang.Object) null);
                if (this.l.y()) {
                    a(strF, true);
                } else if (!this.x.equals(com.unisound.sdk.cx.f1560a)) {
                    a(strF, false, iL, iQ);
                }
                if (this.l.Y() == 0 && this.l.A() && this.l.B()) {
                    if (this.m.t()) {
                        this.m.b(2);
                    } else {
                        this.m.b(1);
                    }
                }
            }
            strF = "\n-20.0";
            iL = 0;
            iQ = 0;
            a(4, 2, strF);
            a(2, 0, (java.lang.Object) null);
            if (this.l.y()) {
                a(strF, true);
            } else if (!this.x.equals(com.unisound.sdk.cx.f1560a)) {
                a(strF, false, iL, iQ);
            }
            if (this.l.Y() == 0) {
                if (this.m.t()) {
                    this.m.b(2);
                } else {
                    this.m.b(1);
                }
            }
        }
    }

    @Override // com.unisound.sdk.k
    public void c() {
        super.c();
    }

    @Override // com.unisound.sdk.k
    public void d() {
        super.d();
    }

    public void e() {
        if (this.e.size() > 0) {
            com.unisound.common.y.c("handleWakeupWordBuffer UtteranceTime = " + this.l.O());
            a(this.l.i((long) (this.l.O() + 200)));
        }
    }

    @Override // com.unisound.sdk.k, java.lang.Thread, java.lang.Runnable
    public void run() {
        this.u = true;
        this.l.ah();
        this.l.k(false);
        this.c = false;
        com.unisound.common.y.c("modelTag =>", this.p);
        if (this.l.A()) {
            this.m.i(this.l.aK());
        }
        if (this.l.c != null && this.l.c.a() && ((this.p.equals(com.unisound.sdk.cx.f1560a) || this.l.A()) && !this.l.aa())) {
            this.l.p(0);
        }
        com.unisound.common.y.g("FixRecognitionThread start");
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("FixRecognitionThread ::run ThreadName = ", java.lang.Thread.currentThread().getName(), ", ThreadId = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
        }
        if (l() || this.m == null) {
            return;
        }
        this.d = false;
        boolean z = true;
        while (!l() && ((!this.n || a()) && !this.d)) {
            if (com.unisound.common.y.r || com.unisound.common.y.s) {
                this.q = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            }
            if (!z) {
                this.o = false;
            }
            if (this.l.A() && this.l.B()) {
                this.c = true;
            }
            if (this.l.c == null || !this.l.c.a()) {
                if (this.l.A() && !this.f) {
                    try {
                        java.lang.Thread.sleep(1L);
                    } catch (java.lang.InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                b();
                if (z) {
                    z = false;
                }
                if (this.l.A()) {
                    this.l.B();
                }
                if (this.c) {
                    break;
                }
            } else if (this.l.T()) {
                b();
                if (z) {
                    z = false;
                }
                if (this.l.A()) {
                    this.l.B();
                }
                if (this.c) {
                    break;
                }
            } else {
                try {
                    java.lang.Thread.sleep(1L);
                } catch (java.lang.InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        m();
        this.i.clear();
        com.unisound.common.y.g("FixRecognitionThread stop");
    }
}
