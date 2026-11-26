package com.tencent.hlyyb.downloader.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class h implements com.tencent.hlyyb.downloader.DownloaderTask, com.tencent.hlyyb.downloader.a.b, com.tencent.hlyyb.downloader.b.a, com.tencent.hlyyb.downloader.e.a.d, java.lang.Comparable, java.lang.Runnable {
    private com.tencent.hlyyb.downloader.e.d.c E;
    private com.tencent.hlyyb.downloader.e.g M;
    private com.tencent.hlyyb.downloader.e.a.a N;
    private java.io.File O;
    private java.io.RandomAccessFile P;
    private java.io.File Q;
    private java.io.RandomAccessFile R;
    private com.tencent.hlyyb.downloader.e.a V;
    private java.lang.Object ab;
    private com.tencent.hlyyb.downloader.e.c.a ae;
    private com.tencent.hlyyb.common.a.m af;
    private boolean ak;
    private java.util.List al;
    private java.util.Map am;
    private java.util.Map an;
    private volatile long ao;
    private java.util.concurrent.atomic.AtomicInteger ap;
    private java.util.concurrent.atomic.AtomicInteger aq;
    private java.lang.Object ar;
    private com.tencent.hlyyb.downloader.b.b as;
    private long at;
    private long au;
    private int av;
    public long f;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String n;
    public java.lang.String y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f634a = -1;
    public java.lang.String b = "";
    public java.lang.String c = "";
    public java.lang.String d = "";
    private com.tencent.hlyyb.downloader.DownloaderTaskCategory F = com.tencent.hlyyb.downloader.DownloaderTaskCategory.Cate_DefaultMass;
    private boolean G = true;
    public java.util.Map e = new java.util.HashMap();
    private volatile com.tencent.hlyyb.downloader.DownloaderTaskPriority H = com.tencent.hlyyb.downloader.DownloaderTaskPriority.NORMAL;
    public volatile long g = -1;
    private volatile long I = 0;
    private java.lang.String J = "";
    public volatile long j = 0;
    public volatile boolean k = true;
    public java.lang.String l = "";
    public java.lang.String m = "";
    public java.util.concurrent.atomic.AtomicLong o = new java.util.concurrent.atomic.AtomicLong(0);
    public java.util.concurrent.atomic.AtomicLong p = new java.util.concurrent.atomic.AtomicLong(0);
    public volatile int q = 0;
    private boolean K = false;
    public volatile int r = 0;
    public java.lang.String s = "";
    private long L = -1;
    public long t = -1;
    public long u = -1;
    public long v = -1;
    private volatile boolean S = false;
    private com.tencent.hlyyb.downloader.e.c T = new com.tencent.hlyyb.downloader.e.c(this);
    private boolean U = false;
    private int W = 0;
    private volatile boolean X = false;
    private java.util.concurrent.atomic.AtomicInteger Y = new java.util.concurrent.atomic.AtomicInteger(0);
    private java.lang.Object Z = new java.lang.Object();
    private volatile boolean aa = false;
    public boolean w = false;
    public java.lang.String x = "";
    private boolean ac = false;
    private com.tencent.hlyyb.downloader.e.j ad = new com.tencent.hlyyb.downloader.e.j(this, 0);
    public int z = -1;
    public long A = 0;
    private long ag = 0;
    public boolean B = true;
    private java.lang.String ah = "";
    private boolean ai = false;
    public boolean C = false;
    public boolean D = false;
    private volatile java.util.HashMap aj = new java.util.LinkedHashMap();

    public h(com.tencent.hlyyb.downloader.e.d.c cVar, java.lang.String str, java.lang.String str2, com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener, long j, java.lang.String str3) {
        this.f = -1L;
        this.h = "";
        this.i = "";
        this.n = null;
        this.ak = com.tencent.hlyyb.common.a.e.a("down_use_multi_thread", 0, 1, 1) == 1;
        this.al = java.util.Collections.synchronizedList(new java.util.ArrayList());
        this.am = new java.util.concurrent.ConcurrentHashMap();
        this.an = new java.util.concurrent.ConcurrentHashMap();
        this.ao = -1L;
        this.ap = new java.util.concurrent.atomic.AtomicInteger(0);
        this.aq = new java.util.concurrent.atomic.AtomicInteger(0);
        com.tencent.hlyyb.common.a.e.a("down_hijack_use_per_if_less", 0, 1073741824, 20971520);
        com.tencent.hlyyb.common.a.e.a("down_hijack_max_back_length", 0, 1073741824, 10485760);
        com.tencent.hlyyb.common.a.e.a("down_hijack_max_back_percent", 0, 100, 50);
        this.ar = new java.lang.Object();
        this.as = new com.tencent.hlyyb.downloader.b.b();
        this.at = 0L;
        this.au = 0L;
        this.av = -1;
        this.E = cVar;
        this.h = str;
        this.i = str2;
        this.T.a(downloaderTaskListener);
        this.f = j > 0 ? j : -1L;
        android.text.TextUtils.isEmpty(str3);
        this.n = com.tencent.hlyyb.common.f.a.a("" + com.tencent.hlyyb.common.f.c.b() + com.tencent.hlyyb.common.f.c.d() + java.lang.System.currentTimeMillis() + this.E.f628a.f626a + com.tencent.hlyyb.common.f.c.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean A() {
        java.lang.String message;
        java.lang.String message2;
        java.lang.String str;
        java.lang.String str2;
        synchronized (com.tencent.hlyyb.downloader.e.h.class) {
            this.aj.put("point0", 0L);
            java.lang.Long lValueOf = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
            new java.io.File(this.h).mkdirs();
            if (com.tencent.hlyyb.downloader.a.a.g(this.i)) {
                this.J = this.i;
            } else {
                this.J = com.tencent.hlyyb.common.a.e.a(this.E.f628a.f626a, this.l, this.m, "");
                java.io.File file = new java.io.File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J));
                java.io.File file2 = new java.io.File(this.h, this.J);
                if (file.exists() || file2.exists()) {
                    int iLastIndexOf = this.J.lastIndexOf(".");
                    java.lang.String strSubstring = "";
                    if (iLastIndexOf <= 0 || this.J.length() <= iLastIndexOf + 1) {
                        str = this.J;
                    } else {
                        java.lang.String strSubstring2 = this.J.substring(0, iLastIndexOf);
                        strSubstring = this.J.substring(iLastIndexOf);
                        str = strSubstring2;
                    }
                    int i = 2;
                    while (true) {
                        str2 = str + "(" + i + ")" + strSubstring;
                        java.io.File file3 = new java.io.File(this.h, com.tencent.hlyyb.downloader.a.a.f(str2));
                        java.io.File file4 = new java.io.File(this.h, str2);
                        if (!file3.exists() && !file4.exists()) {
                            break;
                        }
                        i++;
                    }
                    this.J = str2;
                }
            }
            this.aj.put("point1", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - lValueOf.longValue()));
            java.lang.Long lValueOf2 = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
            this.O = this.G ? new java.io.File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J)) : new java.io.File(this.h, this.J);
            this.Q = new java.io.File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.J));
            boolean z = true;
            try {
                this.R = new com.tencent.hlyyb.downloader.e.i(this.Q, "rw");
                this.aj.put("point2", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - lValueOf2.longValue()));
                java.lang.Long lValueOf3 = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
                try {
                    this.P = new com.tencent.hlyyb.downloader.e.i(this.O, "rw");
                    this.aj.put("point3", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - lValueOf3.longValue()));
                    this.aj.put("point4", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - java.lang.Long.valueOf(java.lang.System.currentTimeMillis()).longValue()));
                    java.lang.System.currentTimeMillis();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    this.r = -49;
                    this.s = "initFileOnDetected...create RandomAccessFile of path:" + this.O.getAbsolutePath() + " fail.|" + e;
                    if (com.tencent.hlyyb.common.a.e.a(e)) {
                        this.r = -12;
                    } else {
                        if (!(e instanceof java.io.IOException) || (message2 = e.getMessage()) == null || !message2.contains("Read-only file system")) {
                            z = false;
                        }
                        if (z) {
                            this.r = -13;
                        }
                    }
                    E();
                    return false;
                }
            } catch (java.lang.Exception e2) {
                this.r = -49;
                this.s = "initFileOnDetected...create RandomAccessFile of path:" + this.Q.getAbsolutePath() + " fail.|" + e2;
                if (com.tencent.hlyyb.common.a.e.a(e2)) {
                    this.r = -12;
                } else {
                    if (!(e2 instanceof java.io.IOException) || (message = e2.getMessage()) == null || !message.contains("Read-only file system")) {
                        z = false;
                    }
                    if (z) {
                        this.r = -13;
                    }
                }
                E();
                return false;
            }
        }
        return true;
    }

    private void B() {
        try {
            synchronized (this.Z) {
                this.Z.notifyAll();
                this.aa = false;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void C() {
        boolean zRenameTo;
        try {
            this.P.getChannel().force(true);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        I();
        synchronized (this.T) {
            if (this.T.a() != com.tencent.hlyyb.downloader.DownloaderTaskStatus.PAUSED) {
                if (this.G) {
                    zRenameTo = false;
                    for (int i = 0; i < 3; i++) {
                        java.io.File file = new java.io.File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J));
                        java.io.File file2 = new java.io.File(this.h, this.J);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        zRenameTo = file.renameTo(file2);
                        if (zRenameTo) {
                            break;
                        }
                        android.os.SystemClock.sleep(50L);
                    }
                } else {
                    zRenameTo = true;
                }
                if (zRenameTo) {
                    x();
                    J();
                    this.T.a(com.tencent.hlyyb.downloader.DownloaderTaskStatus.COMPLETE);
                } else {
                    a(false, -72, "", com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED);
                }
            }
        }
    }

    private synchronized void D() {
        java.io.File file;
        com.tencent.hlyyb.downloader.e.g gVar = this.M;
        if (gVar != null && (file = this.O) != null && this.Q != null) {
            gVar.b = file.lastModified();
            this.M.c = this.j;
            this.M.d = this.o.get();
            a(this.M.c());
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0014 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private synchronized void E() {
        java.io.RandomAccessFile randomAccessFile;
        java.io.RandomAccessFile randomAccessFile2 = this.P;
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            this.P = null;
            randomAccessFile = this.R;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                }
                this.R = null;
            }
        } else {
            randomAccessFile = this.R;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.R = null;
            }
        }
        throw th;
    }

    private java.lang.String F() {
        java.lang.String utf = "";
        try {
            if (this.ah == null || this.ah.length() == 0) {
                this.R.seek(0L);
                utf = this.R.readUTF();
            } else {
                utf = this.ah;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return android.text.TextUtils.isEmpty(utf) ? "" : utf;
    }

    private void G() {
        this.am.clear();
        synchronized (this.al) {
            this.al.clear();
        }
        this.an.clear();
    }

    private void H() {
        I();
        com.tencent.hlyyb.downloader.e.b.c cVar = this.ad.f635a;
        if (cVar != null) {
            cVar.a(false);
        }
        com.tencent.hlyyb.downloader.e.b.c cVar2 = this.ad.b;
        if (cVar2 != null) {
            cVar2.a(false);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void I() {
        synchronized (this.al) {
            java.util.Iterator it = this.al.iterator();
            while (it.hasNext()) {
                ((com.tencent.hlyyb.downloader.b.c) it.next()).a();
            }
        }
    }

    private void J() {
        java.util.List<com.tencent.hlyyb.downloader.d.a> listD = this.E.d();
        if (this.E.a() < 0) {
            this.av = -2;
            return;
        }
        if (listD == null || listD.size() <= 0) {
            this.av = -3;
            return;
        }
        if (android.text.TextUtils.isEmpty(this.E.c())) {
            this.av = -3;
            return;
        }
        android.os.SystemClock.elapsedRealtime();
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(new java.io.File(this.h, this.J), "r");
            for (com.tencent.hlyyb.downloader.d.a aVar : listD) {
                long j = aVar.f610a;
                int i = aVar.b;
                byte[] bArr = new byte[i];
                randomAccessFile.seek(j);
                randomAccessFile.read(bArr, 0, i);
                byteArrayOutputStream.write(bArr, 0, i);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (com.tencent.hlyyb.common.f.c.a(byteArray)) {
                this.av = -4;
            }
            java.lang.String strA = com.tencent.hlyyb.common.f.a.a(byteArray);
            if (android.text.TextUtils.isEmpty(strA)) {
                this.av = -5;
            } else if (strA.toLowerCase().equals(this.E.c().toLowerCase())) {
                this.av = 1;
            } else {
                this.av = 0;
            }
            try {
                byteArrayOutputStream.close();
                randomAccessFile.close();
            } catch (java.io.IOException unused) {
            }
        } catch (java.io.IOException e) {
            this.av = -4;
            e.printStackTrace();
        }
        android.os.SystemClock.elapsedRealtime();
    }

    private int K() {
        if (com.tencent.hlyyb.common.a.f.h() != 1) {
            return 20971520;
        }
        if (this.g > 0) {
            double d = this.g;
            java.lang.Double.isNaN(d);
            int i = (int) (d * 0.2d);
            if (i > 41943040) {
                return i;
            }
        }
        return 41943040;
    }

    static /* synthetic */ boolean a(com.tencent.hlyyb.downloader.e.h hVar, boolean z) {
        hVar.X = true;
        return true;
    }

    private boolean a(java.lang.String str) {
        try {
            this.ah = str;
            this.R.seek(0L);
            this.R.writeUTF(str);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ boolean b(com.tencent.hlyyb.downloader.e.h hVar, boolean z) {
        hVar.aa = true;
        return true;
    }

    private boolean v() {
        try {
            java.io.File file = new java.io.File(getSavePath());
            if (file.exists()) {
                return file.delete();
            }
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private boolean w() {
        try {
            java.io.File file = new java.io.File(getSaveDir(), com.tencent.hlyyb.downloader.a.a.f(this.J));
            if (file.exists()) {
                return file.delete();
            }
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private boolean x() {
        try {
            java.io.File file = new java.io.File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.J));
            if (file.exists()) {
                return file.delete();
            }
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private boolean y() {
        java.lang.String message;
        java.lang.String message2;
        try {
            this.R = new com.tencent.hlyyb.downloader.e.i(this.Q, "rw");
            try {
                this.P = new com.tencent.hlyyb.downloader.e.i(this.O, "rw");
                return true;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                this.r = -49;
                this.s = "initFileOnStart...create RandomAccessFile of path:" + this.O.getAbsolutePath() + " fail.|" + e;
                if (com.tencent.hlyyb.common.a.e.a(e)) {
                    this.r = -12;
                } else {
                    if ((e instanceof java.io.IOException) && (message2 = e.getMessage()) != null && message2.contains("Read-only file system")) {
                        this.r = -13;
                    }
                }
                E();
                return false;
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            this.r = -49;
            this.s = "initFileOnStart...create RandomAccessFile of path:" + this.Q.getAbsolutePath() + " fail.|" + e2;
            if (com.tencent.hlyyb.common.a.e.a(e2)) {
                this.r = -12;
            } else {
                if ((e2 instanceof java.io.IOException) && (message = e2.getMessage()) != null && message.contains("Read-only file system")) {
                    this.r = -13;
                }
            }
            E();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0095 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:28:0x0097  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:64:0x014e  */
    private boolean z() {
        boolean z;
        int i;
        java.lang.String strF;
        boolean z2;
        try {
            new java.io.File(this.h).mkdirs();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        this.O = null;
        this.Q = null;
        com.tencent.hlyyb.downloader.e.g gVar = this.M;
        if (gVar == null) {
            if (com.tencent.hlyyb.downloader.a.a.g(this.i)) {
                this.O = this.G ? new java.io.File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.i)) : new java.io.File(this.h, this.i);
                this.Q = new java.io.File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.i));
                z = false;
                i = 1;
            }
            if (!z) {
                if (!y()) {
                    return false;
                }
                strF = F();
                this.M = new com.tencent.hlyyb.downloader.e.g(strF);
                if (android.text.TextUtils.isEmpty(strF)) {
                }
                this.x = "resume failed. cfg:" + strF;
                z2 = false;
            } else {
                if (!y()) {
                    return false;
                }
                strF = F();
                this.M = new com.tencent.hlyyb.downloader.e.g(strF);
                if (android.text.TextUtils.isEmpty(strF)) {
                }
                this.x = "resume failed. cfg:" + strF;
                z2 = false;
            }
            if (!z2) {
                E();
                this.g = -1L;
                this.J = "";
                this.j = 0L;
                this.o.set(0L);
                this.k = true;
                this.l = "";
                this.m = "";
                this.q = 0;
                this.K = false;
                this.r = 0;
                this.s = "";
                this.M = new com.tencent.hlyyb.downloader.e.g("");
                this.w = false;
            }
            this.ac = z2;
            return true;
        }
        if (gVar.d() > 0 && !android.text.TextUtils.isEmpty(this.J)) {
            this.O = this.G ? new java.io.File(this.h, com.tencent.hlyyb.downloader.a.a.f(this.J)) : new java.io.File(this.h, this.J);
            this.Q = new java.io.File(this.h, com.tencent.hlyyb.downloader.a.a.e(this.J));
            z = true;
        }
        i = 0;
        if ((!z && i == 0) || !this.O.exists()) {
            z2 = false;
        } else {
            if (!y()) {
                return false;
            }
            strF = F();
            this.M = new com.tencent.hlyyb.downloader.e.g(strF);
            if (android.text.TextUtils.isEmpty(strF) && this.M.e) {
                long jLastModified = this.O.lastModified();
                if (i != 0 && jLastModified >= this.M.b) {
                    com.tencent.hlyyb.downloader.e.g gVar2 = this.M;
                    if (gVar2.f633a <= 0 || gVar2.d() > this.M.f633a) {
                        if (z) {
                        }
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else if (z || jLastModified < this.M.b) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    if (android.text.TextUtils.isEmpty(this.J)) {
                        this.J = this.i;
                    }
                    this.j = this.M.c;
                    this.o.set(this.M.d);
                    if (i != 0 && this.M.f633a > 0) {
                        this.w = true;
                    }
                } else {
                    this.x = "resume failed. cfg:" + strF + ",flm:" + jLastModified + ",from:" + (i ^ 1);
                }
            } else {
                this.x = "resume failed. cfg:" + strF;
                z2 = false;
            }
        }
        if (!z2) {
            E();
            this.g = -1L;
            this.J = "";
            this.j = 0L;
            this.o.set(0L);
            this.k = true;
            this.l = "";
            this.m = "";
            this.q = 0;
            this.K = false;
            this.r = 0;
            this.s = "";
            this.M = new com.tencent.hlyyb.downloader.e.g("");
            this.w = false;
        }
        this.ac = z2;
        return true;
        z = false;
        i = 0;
        if (!z) {
            if (!y()) {
                return false;
            }
            strF = F();
            this.M = new com.tencent.hlyyb.downloader.e.g(strF);
            if (android.text.TextUtils.isEmpty(strF)) {
            }
            this.x = "resume failed. cfg:" + strF;
            z2 = false;
        } else {
            if (!y()) {
                return false;
            }
            strF = F();
            this.M = new com.tencent.hlyyb.downloader.e.g(strF);
            if (android.text.TextUtils.isEmpty(strF)) {
            }
            this.x = "resume failed. cfg:" + strF;
            z2 = false;
        }
        if (!z2) {
            E();
            this.g = -1L;
            this.J = "";
            this.j = 0L;
            this.o.set(0L);
            this.k = true;
            this.l = "";
            this.m = "";
            this.q = 0;
            this.K = false;
            this.r = 0;
            this.s = "";
            this.M = new com.tencent.hlyyb.downloader.e.g("");
            this.w = false;
        }
        this.ac = z2;
        return true;
    }

    public final void a(int i) {
        if (this.W < i) {
            this.W = i;
        }
    }

    public final void a(int i, java.lang.String str) {
        if (!isRunning() || this.ae == null) {
            return;
        }
        this.ae.a(new com.tencent.hlyyb.downloader.e.c.b(java.lang.System.currentTimeMillis() - this.t, i, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.hlyyb.downloader.b.a
    public final void a(long j) {
        synchronized (this.ad) {
            if (this.g != -1) {
                long j2 = this.g;
                long j3 = this.g;
                if (j <= 0) {
                    j = this.f > 0 ? this.f : j2;
                }
                if (this.g != j) {
                    this.g = -1L;
                    this.ao = j;
                    if (this.M != null) {
                        synchronized (this.ar) {
                            long jH = this.M.h();
                            int i = this.M.i();
                            this.as.f605a = 1;
                            this.as.d = this.z;
                            this.as.c = j3;
                            this.as.b = this.o.get();
                            if (this.ad.f635a != null) {
                                this.as.e = this.ad.f635a.k();
                                java.lang.String strL = this.ad.f635a.l();
                                if (!android.text.TextUtils.isEmpty(strL)) {
                                    this.as.f = com.tencent.hlyyb.common.f.c.b(strL);
                                }
                            }
                            this.M = new com.tencent.hlyyb.downloader.e.g("");
                            if (this.ad.f635a != null && this.ad.f635a.c) {
                                this.ad.f635a.e();
                            }
                            G();
                            this.M.a(jH, i);
                            if (this.N != null) {
                                this.N.c();
                            }
                        }
                    }
                }
            } else if (j > 0) {
                this.ao = j;
            } else if (this.f > 0) {
                j = this.f;
                this.ao = j;
            }
        }
    }

    @Override // com.tencent.hlyyb.downloader.b.a
    public final void a(com.tencent.hlyyb.downloader.e.d.a aVar, com.tencent.hlyyb.downloader.b.c cVar) {
        if (this.M != null) {
            java.util.List list = (java.util.List) this.an.get(aVar);
            if (list != null && list.size() > 0) {
                long jD = this.M.d();
                char c = 1;
                boolean z = jD > ((long) K());
                if (z) {
                    this.at = jD;
                    H();
                    cVar.c();
                }
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    java.lang.String[] strArrSplit = ((java.lang.String) it.next()).split(",");
                    if (strArrSplit.length == 2) {
                        long j = java.lang.Long.parseLong(strArrSplit[0]);
                        long j2 = java.lang.Long.parseLong(strArrSplit[c]);
                        java.lang.String str = j + "-" + j2;
                        com.tencent.hlyyb.downloader.e.b.a aVar2 = new com.tencent.hlyyb.downloader.e.b.a(this.M, j, j, j, j2);
                        if (z) {
                            cVar.b(str);
                        } else {
                            this.M.a(aVar2);
                            cVar.a(str);
                        }
                        c = 1;
                    }
                }
            }
            this.an.remove(aVar);
        }
    }

    public final void a(boolean z) {
        if (isDeleted()) {
            return;
        }
        if (!isRunning() && z) {
            x();
            v();
            if (this.G) {
                w();
            }
        }
        if (z) {
            this.U = z;
        }
        a(true, 0, "", com.tencent.hlyyb.downloader.DownloaderTaskStatus.DELETED);
    }

    public final void a(boolean z, int i, java.lang.String str, com.tencent.hlyyb.downloader.DownloaderTaskStatus downloaderTaskStatus) {
        this.S = true;
        this.K = z;
        if (!z) {
            this.r = i;
            this.s = str;
        }
        this.T.a(downloaderTaskStatus);
        I();
        com.tencent.hlyyb.downloader.e.j jVar = this.ad;
        try {
            if (jVar.f635a != null) {
                jVar.f635a.f();
            }
            if (jVar.b != null) {
                jVar.b.f();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.tencent.hlyyb.downloader.a.b
    public final boolean a() {
        return this.S;
    }

    @Override // com.tencent.hlyyb.downloader.b.a
    public final boolean a(com.tencent.hlyyb.downloader.e.b.a aVar, com.tencent.hlyyb.downloader.b.c cVar) {
        com.tencent.hlyyb.downloader.e.g gVar = this.M;
        if (gVar != null) {
            long jD = gVar.d();
            boolean z = jD > ((long) K());
            long j = aVar.d;
            long j2 = aVar.f;
            java.lang.String str = j + "-" + j2;
            if (!z) {
                this.M.a(new com.tencent.hlyyb.downloader.e.b.a(this.M, j, j, j, j2));
                cVar.a(str);
                return true;
            }
            this.at = jD;
            H();
            cVar.c();
            cVar.b(str);
        }
        return false;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void addHeader(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || str.equalsIgnoreCase("range")) {
            return;
        }
        this.e.put(str, str2);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void addListener(com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener) {
        this.T.a(downloaderTaskListener);
    }

    public final boolean b() {
        boolean z;
        java.lang.StringBuilder sb;
        java.lang.String message;
        if (this.S || isPaused() || isDeleted() || isCompleted() || isFailed()) {
            com.tencent.hlyyb.downloader.e.a.a aVar = this.N;
            if (aVar != null) {
                aVar.c();
            }
            E();
            return false;
        }
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        int i = 0;
        while (true) {
            z = true;
            if (!this.S && !isPaused() && !isDeleted() && !isCompleted() && !isFailed()) {
                if (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime <= com.tencent.hlyyb.downloader.a.a.d) {
                    synchronized (this.ar) {
                        com.tencent.hlyyb.downloader.e.a.b bVarB = this.N.b();
                        if (bVarB != null) {
                            com.tencent.hlyyb.downloader.e.b.a aVarA = this.M.a(bVarB.f615a);
                            if (aVarA == null) {
                                sb = new java.lang.StringBuilder("inner error: getRange null for sectionId:");
                            } else if (aVarA.e != bVarB.b) {
                                sb = new java.lang.StringBuilder("inner error: check offset fail for section:");
                                sb.append(aVarA);
                                sb.append(",buffer offset:");
                                sb.append(bVarB.b);
                                sb.append(",sectionId:");
                            } else {
                                try {
                                    if (this.P.getFilePointer() != bVarB.b) {
                                        this.P.seek(bVarB.b);
                                    }
                                    this.P.write(bVarB.c, 0, (int) bVarB.d);
                                    aVarA.e = bVarB.b + bVarB.d;
                                    i = (int) (((long) i) + bVarB.d);
                                    bVarB.c = null;
                                    if (this.aa) {
                                        if (com.tencent.hlyyb.downloader.c.b.a().f() < 2097152) {
                                            B();
                                        }
                                    }
                                } catch (java.lang.Exception e) {
                                    e.printStackTrace();
                                    if (!(e instanceof java.lang.NullPointerException)) {
                                        int i2 = -50;
                                        if (!this.O.exists()) {
                                            i2 = -14;
                                        } else if (com.tencent.hlyyb.common.a.e.a(e)) {
                                            i2 = -12;
                                        } else {
                                            if ((e instanceof java.io.IOException) && (message = e.getMessage()) != null && message.contains("Read-only file system")) {
                                                i2 = -17;
                                            }
                                        }
                                        a(false, i2, "saveData fail.|" + e, com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED);
                                    }
                                }
                            }
                            sb.append(bVarB.f615a);
                            a(false, -42, sb.toString(), com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED);
                            return false;
                        }
                        z = false;
                        break;
                    }
                }
                this.Y.getAndIncrement();
                break;
            }
            com.tencent.hlyyb.downloader.e.a.a aVar2 = this.N;
            if (aVar2 != null) {
                aVar2.c();
            }
            z = false;
            break;
        }
        if (!z) {
            B();
        }
        long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
        com.tencent.hlyyb.downloader.e.a aVar3 = this.V;
        if (aVar3 != null) {
            aVar3.a(i, (int) (jElapsedRealtime2 - jElapsedRealtime));
        }
        if (i > 0) {
            D();
        }
        if (this.S || isPaused() || isDeleted() || isCompleted() || isFailed()) {
            E();
        } else if (this.g > 0) {
            long jD = this.M.d();
            if (jElapsedRealtime2 - this.ag > com.tencent.hlyyb.downloader.a.a.e() || jD == this.g) {
                if (i > 0 && !this.B) {
                    try {
                        this.P.getFD().sync();
                    } catch (java.lang.Throwable unused) {
                    }
                }
                this.I = jD;
                this.M.a(this.I, getPercentage());
                this.T.a(com.tencent.hlyyb.downloader.DownloaderTaskStatus.DOWNLOADING);
                this.ag = jElapsedRealtime2;
            }
            if (jD == this.g) {
                this.V.c();
                this.v = jElapsedRealtime2;
                C();
            } else if (jD > this.g) {
                a(false, -42, "inner error: receivedLength > detectLength:" + jD + " > " + this.g, com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED);
                x();
            }
        }
        return z;
    }

    public final void c() throws com.tencent.hlyyb.common.HalleyException {
        this.L = android.os.SystemClock.elapsedRealtime();
        try {
            this.T.a(com.tencent.hlyyb.downloader.DownloaderTaskStatus.PENDING);
            this.af = com.tencent.hlyyb.downloader.f.a.a().a(this, this.F);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e);
            throw new com.tencent.hlyyb.common.HalleyException(sb.toString());
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(java.lang.Object obj) {
        com.tencent.hlyyb.downloader.e.h hVar = (com.tencent.hlyyb.downloader.e.h) obj;
        int iOrdinal = hVar.H.ordinal() - this.H.ordinal();
        return iOrdinal == 0 ? (int) (this.L - hVar.L) : iOrdinal;
    }

    public final int d() {
        return this.T.f();
    }

    @Override // com.tencent.hlyyb.downloader.e.a.d
    public final boolean e() {
        if (isRunning()) {
            return b();
        }
        return false;
    }

    public final int f() {
        return this.W;
    }

    public final boolean g() {
        return this.X;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final int getAverageSpeed() {
        long j = this.j;
        if (j <= 10 || this.g <= 0) {
            return -1;
        }
        return (int) ((getReceivedLength() * 1000) / j);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final com.tencent.hlyyb.downloader.DownloaderTaskCategory getCategory() {
        return this.F;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.String getContentDisposition() {
        return this.m;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.String getContentType() {
        return this.l;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final long getCostTime() {
        return this.j;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final int getFailCode() {
        return this.r;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final synchronized java.lang.String getFailInfo() {
        return this.s;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.String getHtmlUrl() {
        return this.s;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.String getId() {
        return this.b;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.String getInitSaveName() {
        return this.i;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final long getKnownSize() {
        return this.f;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final int getPercentage() {
        com.tencent.hlyyb.downloader.e.g gVar;
        long totalLength = getTotalLength();
        if (totalLength == -1 && (gVar = this.M) != null) {
            totalLength = gVar.f633a;
        }
        com.tencent.hlyyb.downloader.e.g gVar2 = this.M;
        int i = gVar2 != null ? gVar2.i() : 0;
        int receivedLength = totalLength > 0 ? (int) ((getReceivedLength() * 100) / totalLength) : 0;
        return i > receivedLength ? i : receivedLength;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final com.tencent.hlyyb.downloader.DownloaderTaskPriority getPriority() {
        return this.H;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.String getRealSaveName() {
        return this.J;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final int getRealTimeSpeed() {
        if (this.T.a() == com.tencent.hlyyb.downloader.DownloaderTaskStatus.STARTED || this.T.a() == com.tencent.hlyyb.downloader.DownloaderTaskStatus.DOWNLOADING) {
            return this.q;
        }
        return 0;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final long getReceivedLength() {
        com.tencent.hlyyb.downloader.e.g gVar = this.M;
        if (gVar != null) {
            long jH = gVar.h();
            if (jH > this.I && jH <= this.M.f633a) {
                return jH;
            }
        }
        return this.I;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.String getSaveDir() {
        return this.h;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.String getSavePath() {
        java.lang.String absolutePath = "";
        try {
            absolutePath = new java.io.File(this.h, this.J).getAbsolutePath();
        } catch (java.lang.Exception unused) {
        }
        if (!android.text.TextUtils.isEmpty(absolutePath)) {
            return absolutePath;
        }
        return this.h + "/" + this.J;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final long getStartTime() {
        return this.t;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final com.tencent.hlyyb.downloader.DownloaderTaskStatus getStatus() {
        return this.T.a();
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.Object getTag() {
        return this.ab;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final long getTotalLength() {
        if (this.E.a() > 0) {
            return this.E.a();
        }
        long j = this.f;
        if (j > 0) {
            return j;
        }
        if (this.g > 0) {
            return this.g;
        }
        try {
            return this.M.f633a;
        } catch (java.lang.Exception unused) {
            return 0L;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final int getType() {
        return this.f634a;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.String getUniqueKey() {
        return this.n;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final java.lang.String getUrl() {
        return this.E.f628a.f626a;
    }

    public final long h() {
        com.tencent.hlyyb.downloader.e.a aVar = this.V;
        if (aVar != null) {
            return aVar.d();
        }
        return -1L;
    }

    public final long i() {
        com.tencent.hlyyb.downloader.e.a.a aVar = this.N;
        if (aVar != null) {
            return aVar.a();
        }
        return 0L;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isCompleted() {
        return this.T.a() == com.tencent.hlyyb.downloader.DownloaderTaskStatus.COMPLETE;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isDeleted() {
        return this.T.a() == com.tencent.hlyyb.downloader.DownloaderTaskStatus.DELETED;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isEaseTask() {
        return this.F == com.tencent.hlyyb.downloader.DownloaderTaskCategory.Cate_DefaultEase;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isFailed() {
        return this.T.a() == com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isPaused() {
        return this.T.a() == com.tencent.hlyyb.downloader.DownloaderTaskStatus.PAUSED;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isPausedOnMobile() {
        return this.D;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isRunning() {
        return this.T.a() == com.tencent.hlyyb.downloader.DownloaderTaskStatus.STARTED || this.T.a() == com.tencent.hlyyb.downloader.DownloaderTaskStatus.DOWNLOADING;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isSupportRange() {
        return this.k;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isUsingTempFile() {
        return this.G;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isWaiting() {
        return this.T.a() == com.tencent.hlyyb.downloader.DownloaderTaskStatus.PENDING;
    }

    public final long j() {
        com.tencent.hlyyb.downloader.e.g gVar = this.M;
        if (gVar != null) {
            return gVar.g();
        }
        return 0L;
    }

    public final java.lang.String k() {
        com.tencent.hlyyb.downloader.e.c.a aVar = this.ae;
        return aVar != null ? aVar.a() : "";
    }

    public final java.lang.String l() {
        com.tencent.hlyyb.downloader.e.d.c cVar = this.E;
        return cVar != null ? cVar.i() : "";
    }

    public final java.lang.String m() {
        com.tencent.hlyyb.downloader.e.j jVar = this.ad;
        if (jVar == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.tencent.hlyyb.downloader.e.b.c cVar = jVar.f635a;
        if (cVar != null) {
            sb.append(cVar.h());
        }
        com.tencent.hlyyb.downloader.e.b.c cVar2 = jVar.b;
        if (cVar2 != null) {
            sb.append(cVar2.h());
        }
        return sb.toString();
    }

    public final java.lang.String n() {
        com.tencent.hlyyb.downloader.e.j jVar = this.ad;
        if (jVar == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.tencent.hlyyb.downloader.e.b.c cVar = jVar.f635a;
        if (cVar != null) {
            sb.append(cVar.i());
        }
        com.tencent.hlyyb.downloader.e.b.c cVar2 = jVar.b;
        if (cVar2 != null) {
            sb.append(cVar2.i());
        }
        return sb.toString();
    }

    public final java.lang.String o() {
        com.tencent.hlyyb.downloader.e.j jVar = this.ad;
        if (jVar == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.tencent.hlyyb.downloader.e.b.c cVar = jVar.f635a;
        if (cVar != null) {
            sb.append(cVar.j());
        }
        com.tencent.hlyyb.downloader.e.b.c cVar2 = jVar.b;
        if (cVar2 != null) {
            sb.append(cVar2.j());
        }
        return sb.toString();
    }

    public final java.lang.String p() {
        java.lang.String string;
        java.lang.String str = this.E.h() ? "1" : "0";
        if (this.E.a() > 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.E.a());
            string = sb.toString();
        } else {
            string = "0";
        }
        java.util.List listD = this.E.d();
        return str + "," + string + "," + ((listD == null || listD.size() <= 0 || android.text.TextUtils.isEmpty(this.E.c())) ? "0" : "1") + "," + (!android.text.TextUtils.isEmpty(this.E.b()) ? "1" : "0");
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void pause() {
        com.tencent.hlyyb.downloader.DownloaderTaskStatus downloaderTaskStatusA = this.T.a();
        if (downloaderTaskStatusA == com.tencent.hlyyb.downloader.DownloaderTaskStatus.PENDING || downloaderTaskStatusA == com.tencent.hlyyb.downloader.DownloaderTaskStatus.STARTED || downloaderTaskStatusA == com.tencent.hlyyb.downloader.DownloaderTaskStatus.DOWNLOADING) {
            com.tencent.hlyyb.downloader.e.g gVar = this.M;
            if (gVar != null) {
                long jF = gVar.f();
                if (jF > 0 && jF == gVar.f633a) {
                    return;
                }
            }
            a(true, 0, "", com.tencent.hlyyb.downloader.DownloaderTaskStatus.PAUSED);
            try {
                if (this.af != null) {
                    this.af.a();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final java.lang.String q() {
        boolean z;
        com.tencent.hlyyb.downloader.b.b bVar = this.as;
        com.tencent.hlyyb.downloader.e.g gVar = this.M;
        java.util.List list = this.al;
        int i = this.av;
        long j = this.at;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(bVar.f605a);
        sb.append(",");
        sb.append(bVar.b);
        sb.append(",");
        sb.append(bVar.d);
        sb.append(",");
        sb.append(bVar.c);
        sb.append(",");
        sb.append(bVar.e);
        sb.append(",");
        sb.append(bVar.f);
        sb.append(",");
        boolean z2 = false;
        int iA = com.tencent.hlyyb.common.a.e.a("down_hijack_force_feature", 0, 1, 0);
        java.util.Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.tencent.hlyyb.downloader.b.c cVar = (com.tencent.hlyyb.downloader.b.c) it.next();
            if (cVar.c) {
                bVar.g = cVar.i;
                z = true;
                break;
            }
        }
        if (list.size() > 0) {
            java.util.Iterator it2 = list.iterator();
            do {
                if (!it2.hasNext()) {
                    z2 = true;
                    break;
                }
            } while (((com.tencent.hlyyb.downloader.b.c) it2.next()).c);
        }
        int iB = gVar.b();
        sb.append(iA);
        sb.append(",");
        sb.append(z ? "1" : "0");
        sb.append(",");
        sb.append(z2 ? "1" : "0");
        sb.append(",");
        sb.append(iB);
        sb.append(",");
        sb.append(j > 0 ? java.lang.Long.valueOf(j) : "0");
        sb.append(",");
        sb.append(i);
        sb.append(",");
        sb.append(bVar.g);
        return sb.toString();
    }

    public final java.lang.String r() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.al.size() > 0) {
            java.util.Iterator it = this.al.iterator();
            while (it.hasNext()) {
                sb.append(((com.tencent.hlyyb.downloader.b.c) it.next()).g.toString());
                sb.append(";");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void removeAllListeners() {
        this.T.b();
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void removeListener(com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener) {
        this.T.b(downloaderTaskListener);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean resume() {
        synchronized (this.T) {
            com.tencent.hlyyb.downloader.DownloaderTaskStatus downloaderTaskStatusA = this.T.a();
            if (downloaderTaskStatusA != com.tencent.hlyyb.downloader.DownloaderTaskStatus.STARTED && downloaderTaskStatusA != com.tencent.hlyyb.downloader.DownloaderTaskStatus.DOWNLOADING && downloaderTaskStatusA != com.tencent.hlyyb.downloader.DownloaderTaskStatus.COMPLETE && downloaderTaskStatusA != com.tencent.hlyyb.downloader.DownloaderTaskStatus.PENDING) {
                if (downloaderTaskStatusA != com.tencent.hlyyb.downloader.DownloaderTaskStatus.DELETED && !this.T.e()) {
                    this.K = false;
                    this.S = false;
                    this.k = true;
                    this.q = 0;
                    this.D = false;
                    c();
                    return true;
                }
                return false;
            }
            return true;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.r = 0;
        this.s = "";
        this.t = java.lang.System.currentTimeMillis();
        this.u = android.os.SystemClock.elapsedRealtime();
        this.at = 0L;
        this.al.clear();
        this.am.clear();
        this.an.clear();
        this.ap.set(0);
        this.aq.set(0);
        this.as = new com.tencent.hlyyb.downloader.b.b();
        this.ag = 0L;
        synchronized (this.ad) {
            this.g = -1L;
        }
        this.w = false;
        this.z = -1;
        this.p.set(0L);
        if (this.S) {
            return;
        }
        this.T.c();
        this.N = new com.tencent.hlyyb.downloader.e.a.a();
        com.tencent.hlyyb.downloader.e.a aVar = new com.tencent.hlyyb.downloader.e.a(this);
        this.V = aVar;
        aVar.a();
        boolean z = z();
        this.T.a(com.tencent.hlyyb.downloader.DownloaderTaskStatus.STARTED);
        this.ae = new com.tencent.hlyyb.downloader.e.c.a();
        a(com.tencent.hlyyb.common.a.f.h(), com.tencent.hlyyb.common.a.f.b());
        if (!z) {
            a(false, this.r, this.s, com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED);
        } else if (this.M.e()) {
            this.I = this.M.f633a;
            C();
        } else {
            com.tencent.hlyyb.common.f.b bVarB = this.ad.b();
            int i = bVarB.f595a;
            if (i != 0) {
                a(false, i, bVarB.b, com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED);
            }
        }
        this.T.d();
        com.tencent.hlyyb.downloader.e.a.a aVar2 = this.N;
        if (aVar2 != null) {
            aVar2.c();
        }
        E();
        if (this.U) {
            x();
            v();
            if (this.G) {
                w();
            }
        } else if (isCompleted() || this.r == -75) {
            x();
        }
        G();
        this.p.set(0L);
        this.ae = null;
        com.tencent.hlyyb.downloader.e.j jVar = this.ad;
        jVar.f635a = null;
        jVar.b = null;
    }

    public final java.lang.String s() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.al.size() > 0) {
            java.util.Iterator it = this.al.iterator();
            while (it.hasNext()) {
                java.lang.String strB = ((com.tencent.hlyyb.downloader.b.c) it.next()).b();
                if (!android.text.TextUtils.isEmpty(strB)) {
                    sb.append(strB);
                    sb.append(";");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setApkId(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        this.d = str;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setAppId(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        this.c = str;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setAppScene(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        this.y = str;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setBakUrl(java.lang.String str) {
        this.E.a(str);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setCategory(com.tencent.hlyyb.downloader.DownloaderTaskCategory downloaderTaskCategory) {
        if (downloaderTaskCategory != null) {
            this.F = downloaderTaskCategory;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setFullApkSize(long j) {
        this.A = j;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setId(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        this.b = str;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setMultiSectionOn(boolean z) {
        this.B = z;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setNotPreOccupySpace() {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setNotUseTempFile() {
        this.G = false;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setOcUrlList(java.util.List list) {
        if (list != null) {
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                this.E.a(com.tencent.hlyyb.common.a.f.b(), (java.lang.String) it.next(), com.tencent.hlyyb.downloader.e.d.b.c);
            }
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setPauseTaskOnMobile(boolean z) {
        this.C = z;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setPriority(com.tencent.hlyyb.downloader.DownloaderTaskPriority downloaderTaskPriority) {
        if (this.H != downloaderTaskPriority) {
            this.H = downloaderTaskPriority;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setReportMd5(boolean z) {
        this.ai = z;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setTag(java.lang.Object obj) {
        this.ab = obj;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setType(int i) {
        this.f634a = i;
    }

    public final void t() {
        if (this.ai) {
            java.io.File file = new java.io.File(this.h, this.J);
            if (file.exists()) {
                try {
                    com.tencent.hlyyb.common.f.a.a(file);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final int u() {
        return this.E.c;
    }
}
