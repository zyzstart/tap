package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class u {
    private static com.tencent.bugly.proguard.u b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f448a;
    private final android.content.Context d;
    private long f;
    private long g;
    private java.lang.String k;
    private java.util.Map<java.lang.Integer, java.lang.Long> e = new java.util.HashMap();
    private java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> h = new java.util.concurrent.LinkedBlockingQueue<>();
    private java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> i = new java.util.concurrent.LinkedBlockingQueue<>();
    private final java.lang.Object j = new java.lang.Object();
    private byte[] l = null;
    private long m = 0;
    private byte[] n = null;
    private long o = 0;
    private java.lang.String p = null;
    private long q = 0;
    private final java.lang.Object r = new java.lang.Object();
    private boolean s = false;
    private final java.lang.Object t = new java.lang.Object();
    private int u = 0;
    private final com.tencent.bugly.proguard.p c = com.tencent.bugly.proguard.p.a();

    /* JADX INFO: compiled from: BUGLY */
    class a implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final android.content.Context f451a;
        private final java.lang.Runnable b;
        private final long c;

        public a(android.content.Context context) {
            this.f451a = context;
            this.b = null;
            this.c = 0L;
        }

        public a(android.content.Context context, java.lang.Runnable runnable, long j) {
            this.f451a = context;
            this.b = runnable;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!com.tencent.bugly.proguard.z.a(this.f451a, "security_info", 30000L)) {
                com.tencent.bugly.proguard.x.c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                com.tencent.bugly.proguard.z.b(5000L);
                if (com.tencent.bugly.proguard.z.a(this, "BUGLY_ASYNC_UPLOAD") == null) {
                    com.tencent.bugly.proguard.x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new java.lang.Object[0]);
                    com.tencent.bugly.proguard.w wVarA = com.tencent.bugly.proguard.w.a();
                    if (wVarA != null) {
                        wVarA.a(this);
                        return;
                    } else {
                        com.tencent.bugly.proguard.x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new java.lang.Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!com.tencent.bugly.proguard.u.this.e()) {
                com.tencent.bugly.proguard.x.d("[UploadManager] Failed to load security info from database", new java.lang.Object[0]);
                com.tencent.bugly.proguard.u.this.b(false);
            }
            if (com.tencent.bugly.proguard.u.this.p != null) {
                if (com.tencent.bugly.proguard.u.this.b()) {
                    com.tencent.bugly.proguard.x.c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                    java.lang.Runnable runnable = this.b;
                    if (runnable != null) {
                        com.tencent.bugly.proguard.u.this.a(runnable, this.c);
                    }
                    com.tencent.bugly.proguard.u.this.c(0);
                    com.tencent.bugly.proguard.z.b(this.f451a, "security_info");
                    synchronized (com.tencent.bugly.proguard.u.this.t) {
                        com.tencent.bugly.proguard.u.a(com.tencent.bugly.proguard.u.this, false);
                    }
                    return;
                }
                com.tencent.bugly.proguard.x.a("[UploadManager] Session ID is expired, drop it.", new java.lang.Object[0]);
                com.tencent.bugly.proguard.u.this.b(true);
            }
            byte[] bArrA = com.tencent.bugly.proguard.z.a(128);
            if (bArrA == null || (bArrA.length << 3) != 128) {
                com.tencent.bugly.proguard.x.d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                com.tencent.bugly.proguard.u.this.b(false);
                com.tencent.bugly.proguard.z.b(this.f451a, "security_info");
                synchronized (com.tencent.bugly.proguard.u.this.t) {
                    com.tencent.bugly.proguard.u.a(com.tencent.bugly.proguard.u.this, false);
                }
                return;
            }
            com.tencent.bugly.proguard.u.this.n = bArrA;
            com.tencent.bugly.proguard.x.c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            java.lang.Runnable runnable2 = this.b;
            if (runnable2 != null) {
                com.tencent.bugly.proguard.u.this.a(runnable2, this.c);
            } else {
                com.tencent.bugly.proguard.u.this.c(1);
            }
        }
    }

    private u(android.content.Context context) {
        this.k = null;
        this.f448a = true;
        this.d = context;
        try {
            java.lang.Class.forName("android.util.Base64");
        } catch (java.lang.ClassNotFoundException unused) {
            com.tencent.bugly.proguard.x.a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new java.lang.Object[0]);
            this.f448a = false;
        }
        if (this.f448a) {
            this.k = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB";
        }
    }

    public static synchronized com.tencent.bugly.proguard.u a() {
        return b;
    }

    public static synchronized com.tencent.bugly.proguard.u a(android.content.Context context) {
        if (b == null) {
            b = new com.tencent.bugly.proguard.u(context);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.Runnable runnable, long j) {
        if (runnable == null) {
            com.tencent.bugly.proguard.x.d("[UploadManager] Upload task should not be null", new java.lang.Object[0]);
            return;
        }
        com.tencent.bugly.proguard.x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        java.lang.Thread threadA = com.tencent.bugly.proguard.z.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (threadA == null) {
            com.tencent.bugly.proguard.x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new java.lang.Object[0]);
            a(runnable, true);
            return;
        }
        try {
            threadA.join(j);
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            c(0);
        }
    }

    private void a(java.lang.Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            com.tencent.bugly.proguard.x.d("[UploadManager] Upload task should not be null", new java.lang.Object[0]);
        }
        com.tencent.bugly.proguard.x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        if (this.p != null) {
            if (b()) {
                com.tencent.bugly.proguard.x.c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                if (z2) {
                    a(runnable, j);
                    return;
                } else {
                    a(runnable, z);
                    c(0);
                    return;
                }
            }
            com.tencent.bugly.proguard.x.a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            b(false);
        }
        synchronized (this.t) {
            if (this.s) {
                a(runnable, z);
                return;
            }
            this.s = true;
            com.tencent.bugly.proguard.x.c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            if (z2) {
                a(new com.tencent.bugly.proguard.u.a(this.d, runnable, j), 0L);
                return;
            }
            a(runnable, z);
            com.tencent.bugly.proguard.u.a aVar = new com.tencent.bugly.proguard.u.a(this.d);
            com.tencent.bugly.proguard.x.a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", "BUGLY_ASYNC_UPLOAD");
            if (com.tencent.bugly.proguard.z.a(aVar, "BUGLY_ASYNC_UPLOAD") == null) {
                com.tencent.bugly.proguard.x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new java.lang.Object[0]);
                com.tencent.bugly.proguard.w wVarA = com.tencent.bugly.proguard.w.a();
                if (wVarA != null) {
                    wVarA.a(aVar);
                    return;
                }
                com.tencent.bugly.proguard.x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new java.lang.Object[0]);
                synchronized (this.t) {
                    this.s = false;
                }
            }
        }
    }

    static /* synthetic */ boolean a(com.tencent.bugly.proguard.u uVar, boolean z) {
        uVar.s = false;
        return false;
    }

    private boolean a(java.lang.Runnable runnable, boolean z) {
        if (runnable == null) {
            com.tencent.bugly.proguard.x.a("[UploadManager] Upload task should not be null", new java.lang.Object[0]);
            return false;
        }
        try {
            com.tencent.bugly.proguard.x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            synchronized (this.j) {
                try {
                    if (z) {
                        this.h.put(runnable);
                    } else {
                        this.i.put(runnable);
                    }
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            }
            return true;
        } catch (java.lang.Throwable th2) {
            com.tencent.bugly.proguard.x.e("[UploadManager] Failed to add upload task to queue: %s", th2.getMessage());
            return false;
        }
    }

    static /* synthetic */ int b(com.tencent.bugly.proguard.u uVar) {
        int i = uVar.u - 1;
        uVar.u = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x005f  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void c(int i) {
        final int i2;
        if (i < 0) {
            com.tencent.bugly.proguard.x.a("[UploadManager] Number of task to execute should >= 0", new java.lang.Object[0]);
            return;
        }
        com.tencent.bugly.proguard.w wVarA = com.tencent.bugly.proguard.w.a();
        java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue();
        final java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue2 = new java.util.concurrent.LinkedBlockingQueue();
        synchronized (this.j) {
            com.tencent.bugly.proguard.x.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            int size = this.h.size();
            int size2 = this.i.size();
            if (size == 0 && size2 == 0) {
                com.tencent.bugly.proguard.x.c("[UploadManager] There is no upload task in queue.", new java.lang.Object[0]);
                return;
            }
            if (i == 0) {
                i2 = size2;
            } else if (i < size) {
                size = i;
                i2 = 0;
            } else if (i < size + size2) {
                i2 = i - size;
            } else {
                i2 = size2;
            }
            if (wVarA == null || !wVarA.c()) {
                i2 = 0;
            }
            for (int i3 = 0; i3 < size; i3++) {
                java.lang.Runnable runnablePeek = this.h.peek();
                if (runnablePeek == null) {
                    break;
                }
                try {
                    linkedBlockingQueue.put(runnablePeek);
                    this.h.poll();
                } catch (java.lang.Throwable th) {
                    com.tencent.bugly.proguard.x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
                }
                throw th;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                java.lang.Runnable runnablePeek2 = this.i.peek();
                if (runnablePeek2 == null) {
                    break;
                }
                try {
                    linkedBlockingQueue2.put(runnablePeek2);
                    this.i.poll();
                } catch (java.lang.Throwable th2) {
                    com.tencent.bugly.proguard.x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th2.getMessage());
                }
            }
            if (size > 0) {
                com.tencent.bugly.proguard.x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", java.lang.Integer.valueOf(size), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            }
            for (int i5 = 0; i5 < size; i5++) {
                final java.lang.Runnable runnable = (java.lang.Runnable) linkedBlockingQueue.poll();
                if (runnable == null) {
                    break;
                }
                synchronized (this.j) {
                    if (this.u < 2 || wVarA == null) {
                        com.tencent.bugly.proguard.x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                        if (com.tencent.bugly.proguard.z.a(new java.lang.Runnable() { // from class: com.tencent.bugly.proguard.u.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                runnable.run();
                                synchronized (com.tencent.bugly.proguard.u.this.j) {
                                    com.tencent.bugly.proguard.u.b(com.tencent.bugly.proguard.u.this);
                                }
                            }
                        }, "BUGLY_ASYNC_UPLOAD") != null) {
                            synchronized (this.j) {
                                this.u++;
                            }
                        } else {
                            com.tencent.bugly.proguard.x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new java.lang.Object[0]);
                            a(runnable, true);
                        }
                    } else {
                        wVarA.a(runnable);
                    }
                }
            }
            if (i2 > 0) {
                com.tencent.bugly.proguard.x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            }
            if (wVarA != null) {
                wVarA.a(new java.lang.Runnable(this) { // from class: com.tencent.bugly.proguard.u.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        java.lang.Runnable runnable2;
                        for (int i6 = 0; i6 < i2 && (runnable2 = (java.lang.Runnable) linkedBlockingQueue2.poll()) != null; i6++) {
                            runnable2.run();
                        }
                    }
                });
            }
        }
    }

    private static boolean c() {
        com.tencent.bugly.proguard.x.c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        try {
            com.tencent.bugly.proguard.p pVarA = com.tencent.bugly.proguard.p.a();
            if (pVarA != null) {
                return pVarA.a(555, "security_info", (com.tencent.bugly.proguard.o) null, true);
            }
            com.tencent.bugly.proguard.x.d("[UploadManager] Failed to get Database", new java.lang.Object[0]);
            return false;
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.a(th);
            return false;
        }
    }

    private boolean d() {
        com.tencent.bugly.proguard.x.c("[UploadManager] Record security info to database (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        try {
            com.tencent.bugly.proguard.p pVarA = com.tencent.bugly.proguard.p.a();
            if (pVarA == null) {
                com.tencent.bugly.proguard.x.d("[UploadManager] Failed to get database", new java.lang.Object[0]);
                return false;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (this.n == null) {
                com.tencent.bugly.proguard.x.c("[UploadManager] AES key is null, will not record", new java.lang.Object[0]);
                return false;
            }
            sb.append(android.util.Base64.encodeToString(this.n, 0));
            sb.append("#");
            if (this.o != 0) {
                sb.append(java.lang.Long.toString(this.o));
            } else {
                sb.append("null");
            }
            sb.append("#");
            if (this.p != null) {
                sb.append(this.p);
            } else {
                sb.append("null");
            }
            sb.append("#");
            if (this.q != 0) {
                sb.append(java.lang.Long.toString(this.q));
            } else {
                sb.append("null");
            }
            pVarA.a(555, "security_info", sb.toString().getBytes(), (com.tencent.bugly.proguard.o) null, true);
            return true;
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.a(th);
            c();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        boolean z;
        com.tencent.bugly.proguard.x.c("[UploadManager] Load security info from database (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        try {
            com.tencent.bugly.proguard.p pVarA = com.tencent.bugly.proguard.p.a();
            if (pVarA == null) {
                com.tencent.bugly.proguard.x.d("[UploadManager] Failed to get database", new java.lang.Object[0]);
                return false;
            }
            java.util.Map<java.lang.String, byte[]> mapA = pVarA.a(555, (com.tencent.bugly.proguard.o) null, true);
            if (mapA != null && mapA.containsKey("security_info")) {
                java.lang.String str = new java.lang.String(mapA.get("security_info"));
                java.lang.String[] strArrSplit = str.split("#");
                if (strArrSplit.length != 4) {
                    com.tencent.bugly.proguard.x.a("SecurityInfo = %s, Strings.length = %d", str, java.lang.Integer.valueOf(strArrSplit.length));
                    z = true;
                } else if (strArrSplit[0].isEmpty() || strArrSplit[0].equals("null")) {
                    z = false;
                    if (!z && !strArrSplit[1].isEmpty() && !strArrSplit[1].equals("null")) {
                        try {
                            this.o = java.lang.Long.parseLong(strArrSplit[1]);
                        } catch (java.lang.Throwable th) {
                            com.tencent.bugly.proguard.x.a(th);
                            z = true;
                        }
                    }
                    if (!z && !strArrSplit[2].isEmpty() && !strArrSplit[2].equals("null")) {
                        this.p = strArrSplit[2];
                    }
                    if (!z && !strArrSplit[3].isEmpty() && !strArrSplit[3].equals("null")) {
                        try {
                            this.q = java.lang.Long.parseLong(strArrSplit[3]);
                        } catch (java.lang.Throwable th2) {
                            com.tencent.bugly.proguard.x.a(th2);
                            z = true;
                        }
                    }
                } else {
                    try {
                        this.n = android.util.Base64.decode(strArrSplit[0], 0);
                        z = false;
                    } catch (java.lang.Throwable th3) {
                        com.tencent.bugly.proguard.x.a(th3);
                        z = true;
                    }
                    if (!z) {
                        this.o = java.lang.Long.parseLong(strArrSplit[1]);
                    }
                    if (!z) {
                        this.p = strArrSplit[2];
                    }
                    if (!z) {
                        this.q = java.lang.Long.parseLong(strArrSplit[3]);
                    }
                }
                if (z) {
                    c();
                }
            }
            return true;
        } catch (java.lang.Throwable th4) {
            com.tencent.bugly.proguard.x.a(th4);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized long a(int i) {
        long j = 0;
        if (i >= 0) {
            java.lang.Long l = this.e.get(java.lang.Integer.valueOf(i));
            if (l != null) {
                return l.longValue();
            }
            java.util.List<com.tencent.bugly.proguard.r> listA = this.c.a(i);
            if (listA != null && listA.size() > 0) {
                if (listA.size() > 1) {
                    for (com.tencent.bugly.proguard.r rVar : listA) {
                        if (rVar.e > j) {
                            j = rVar.e;
                        }
                    }
                    this.c.b(i);
                } else {
                    try {
                        j = listA.get(0).e;
                    } catch (java.lang.Throwable th) {
                        com.tencent.bugly.proguard.x.a(th);
                    }
                }
            }
        } else {
            com.tencent.bugly.proguard.x.e("[UploadManager] Unknown upload ID: %d", java.lang.Integer.valueOf(i));
        }
        return j;
    }

    public final long a(boolean z) {
        long jC;
        long jB = com.tencent.bugly.proguard.z.b();
        int i = z ? 5 : 3;
        java.util.List<com.tencent.bugly.proguard.r> listA = this.c.a(i);
        if (listA == null || listA.size() <= 0) {
            jC = z ? this.g : this.f;
        } else {
            jC = 0;
            try {
                com.tencent.bugly.proguard.r rVar = listA.get(0);
                if (rVar.e >= jB) {
                    jC = com.tencent.bugly.proguard.z.c(rVar.g);
                    if (i == 3) {
                        this.f = jC;
                    } else {
                        this.g = jC;
                    }
                    listA.remove(rVar);
                }
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.proguard.x.a(th);
            }
            if (listA.size() > 0) {
                this.c.a(listA);
            }
        }
        com.tencent.bugly.proguard.x.c("[UploadManager] Local network consume: %d KB", java.lang.Long.valueOf(jC / 1024));
        return jC;
    }

    public final void a(int i, int i2, byte[] bArr, java.lang.String str, java.lang.String str2, com.tencent.bugly.proguard.t tVar, int i3, int i4, boolean z, java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            a(new com.tencent.bugly.proguard.v(this.d, i, i2, bArr, str, str2, tVar, this.f448a, i3, i4, false, map), z, false, 0L);
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final synchronized void a(int i, long j) {
        try {
            if (i < 0) {
                com.tencent.bugly.proguard.x.e("[UploadManager] Unknown uploading ID: %d", java.lang.Integer.valueOf(i));
                return;
            }
            this.e.put(java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j));
            com.tencent.bugly.proguard.r rVar = new com.tencent.bugly.proguard.r();
            rVar.b = i;
            rVar.e = j;
            rVar.c = "";
            rVar.d = "";
            rVar.g = new byte[0];
            this.c.b(i);
            this.c.a(rVar);
            com.tencent.bugly.proguard.x.c("[UploadManager] Uploading(ID:%d) time: %s", java.lang.Integer.valueOf(i), com.tencent.bugly.proguard.z.a(j));
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    public final void a(int i, com.tencent.bugly.proguard.ap apVar, java.lang.String str, java.lang.String str2, com.tencent.bugly.proguard.t tVar, long j, boolean z) {
        try {
            a(new com.tencent.bugly.proguard.v(this.d, i, apVar.g, com.tencent.bugly.proguard.a.a((java.lang.Object) apVar), str, str2, tVar, this.f448a, z), true, true, j);
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(int i, com.tencent.bugly.proguard.ap apVar, java.lang.String str, java.lang.String str2, com.tencent.bugly.proguard.t tVar, boolean z) {
        a(i, apVar.g, com.tencent.bugly.proguard.a.a((java.lang.Object) apVar), str, str2, tVar, 0, 0, z, null);
    }

    public final void a(int i, com.tencent.bugly.proguard.aq aqVar) {
        if (this.f448a) {
            boolean z = true;
            if (i == 2) {
                com.tencent.bugly.proguard.x.c("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                b(true);
            } else {
                synchronized (this.t) {
                    if (!this.s) {
                        return;
                    }
                    if (aqVar != null) {
                        com.tencent.bugly.proguard.x.c("[UploadManager] Record security context (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                        try {
                            java.util.Map<java.lang.String, java.lang.String> map = aqVar.g;
                            if (map != null && map.containsKey("S1") && map.containsKey("S2")) {
                                this.m = aqVar.e - java.lang.System.currentTimeMillis();
                                com.tencent.bugly.proguard.x.c("[UploadManager] Time lag of server is: %d", java.lang.Long.valueOf(this.m));
                                this.p = map.get("S1");
                                com.tencent.bugly.proguard.x.c("[UploadManager] Session ID from server is: %s", this.p);
                                if (this.p.length() > 0) {
                                    try {
                                        this.q = java.lang.Long.parseLong(map.get("S2"));
                                        com.tencent.bugly.proguard.x.c("[UploadManager] Session expired time from server is: %d(%s)", java.lang.Long.valueOf(this.q), new java.util.Date(this.q).toString());
                                        if (this.q < 1000) {
                                            com.tencent.bugly.proguard.x.d("[UploadManager] Session expired time from server is less than 1 second, will set to default value", new java.lang.Object[0]);
                                            this.q = 259200000L;
                                        }
                                    } catch (java.lang.NumberFormatException unused) {
                                        com.tencent.bugly.proguard.x.d("[UploadManager] Session expired time is invalid, will set to default value", new java.lang.Object[0]);
                                        this.q = 259200000L;
                                    }
                                    if (d()) {
                                        z = false;
                                    } else {
                                        com.tencent.bugly.proguard.x.c("[UploadManager] Failed to record database", new java.lang.Object[0]);
                                    }
                                    c(0);
                                } else {
                                    com.tencent.bugly.proguard.x.c("[UploadManager] Session ID from server is invalid, try next time", new java.lang.Object[0]);
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            com.tencent.bugly.proguard.x.a(th);
                        }
                        if (z) {
                            b(false);
                        }
                    } else {
                        com.tencent.bugly.proguard.x.c("[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                        b(false);
                    }
                }
            }
            synchronized (this.t) {
                if (this.s) {
                    this.s = false;
                    com.tencent.bugly.proguard.z.b(this.d, "security_info");
                }
            }
        }
    }

    protected final synchronized void a(long j, boolean z) {
        int i = z ? 5 : 3;
        com.tencent.bugly.proguard.r rVar = new com.tencent.bugly.proguard.r();
        rVar.b = i;
        rVar.e = com.tencent.bugly.proguard.z.b();
        rVar.c = "";
        rVar.d = "";
        rVar.g = com.tencent.bugly.proguard.z.c(j);
        this.c.b(i);
        this.c.a(rVar);
        if (z) {
            this.g = j;
        } else {
            this.f = j;
        }
        com.tencent.bugly.proguard.x.c("[UploadManager] Network total consume: %d KB", java.lang.Long.valueOf(j / 1024));
    }

    public final boolean a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return false;
        }
        com.tencent.bugly.proguard.x.c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        java.lang.String str = this.p;
        if (str != null) {
            map.put("secureSessionId", str);
            return true;
        }
        byte[] bArr = this.n;
        if (bArr == null || (bArr.length << 3) != 128) {
            com.tencent.bugly.proguard.x.d("[UploadManager] AES key is invalid", new java.lang.Object[0]);
            return false;
        }
        if (this.l == null) {
            this.l = android.util.Base64.decode(this.k, 0);
            if (this.l == null) {
                com.tencent.bugly.proguard.x.d("[UploadManager] Failed to decode RSA public key", new java.lang.Object[0]);
                return false;
            }
        }
        byte[] bArrB = com.tencent.bugly.proguard.z.b(1, this.n, this.l);
        if (bArrB == null) {
            com.tencent.bugly.proguard.x.d("[UploadManager] Failed to encrypt AES key", new java.lang.Object[0]);
            return false;
        }
        java.lang.String strEncodeToString = android.util.Base64.encodeToString(bArrB, 0);
        if (strEncodeToString == null) {
            com.tencent.bugly.proguard.x.d("[UploadManager] Failed to encode AES key", new java.lang.Object[0]);
            return false;
        }
        map.put("raKey", strEncodeToString);
        return true;
    }

    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = this.n;
        if (bArr2 != null && (bArr2.length << 3) == 128) {
            return com.tencent.bugly.proguard.z.a(1, bArr, bArr2);
        }
        com.tencent.bugly.proguard.x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        return null;
    }

    protected final void b(boolean z) {
        synchronized (this.r) {
            com.tencent.bugly.proguard.x.c("[UploadManager] Clear security context (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            this.n = null;
            this.p = null;
            this.q = 0L;
        }
        if (z) {
            c();
        }
    }

    protected final boolean b() {
        if (this.p == null || this.q == 0) {
            return false;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() + this.m;
        long j = this.q;
        if (j >= jCurrentTimeMillis) {
            return true;
        }
        com.tencent.bugly.proguard.x.c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", java.lang.Long.valueOf(j), new java.util.Date(this.q).toString(), java.lang.Long.valueOf(jCurrentTimeMillis), new java.util.Date(jCurrentTimeMillis).toString());
        return false;
    }

    public final boolean b(int i) {
        if (com.tencent.bugly.b.c) {
            com.tencent.bugly.proguard.x.c("Uploading frequency will not be checked if SDK is in debug mode.", new java.lang.Object[0]);
            return true;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - a(i);
        com.tencent.bugly.proguard.x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", java.lang.Long.valueOf(jCurrentTimeMillis / 1000), java.lang.Integer.valueOf(i));
        if (jCurrentTimeMillis >= 30000) {
            return true;
        }
        com.tencent.bugly.proguard.x.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    public final byte[] b(byte[] bArr) {
        byte[] bArr2 = this.n;
        if (bArr2 != null && (bArr2.length << 3) == 128) {
            return com.tencent.bugly.proguard.z.a(2, bArr, bArr2);
        }
        com.tencent.bugly.proguard.x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        return null;
    }
}
