package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f398a = java.lang.System.currentTimeMillis();
    private static com.tencent.bugly.opengame.proguard.n b;
    private android.content.Context c;
    private android.content.SharedPreferences f;
    private java.util.Map e = new java.util.HashMap();
    private java.lang.String d = com.tencent.bugly.opengame.crashreport.common.info.a.b().d;

    private n(android.content.Context context) {
        this.c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized com.tencent.bugly.opengame.proguard.n a() {
        return b;
    }

    public static synchronized com.tencent.bugly.opengame.proguard.n a(android.content.Context context) {
        if (b == null) {
            b = new com.tencent.bugly.opengame.proguard.n(context);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x004c A[Catch: all -> 0x0050, Exception -> 0x0052, TRY_ENTER, TryCatch #5 {Exception -> 0x0052, blocks: (B:7:0x0006, B:11:0x002d, B:29:0x004c, B:30:0x004f), top: B:39:0x0006, outer: #0 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void a(int i, java.util.List list) {
        java.io.ObjectOutputStream objectOutputStream;
        java.io.IOException e;
        if (list == null) {
            return;
        }
        try {
            ?? dir = this.c.getDir("crashrecord", 0);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(i);
            ?? r5 = 0;
            try {
                try {
                    objectOutputStream = new java.io.ObjectOutputStream(new java.io.FileOutputStream(new java.io.File((java.io.File) dir, sb.toString())));
                    try {
                        objectOutputStream.writeObject(list);
                        dir = objectOutputStream;
                    } catch (java.io.IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        com.tencent.bugly.opengame.proguard.x.a("open record file error", new java.lang.Object[0]);
                        dir = objectOutputStream;
                        if (objectOutputStream == null) {
                            return;
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    r5 = dir;
                    if (r5 != 0) {
                        r5.close();
                    }
                    throw th;
                }
            } catch (java.io.IOException e3) {
                objectOutputStream = null;
                e = e3;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (r5 != 0) {
                    r5.close();
                }
                throw th;
            }
            dir.close();
        } catch (java.lang.Exception unused) {
            com.tencent.bugly.opengame.proguard.x.e("writeCrashRecord error", new java.lang.Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean b(int i) {
        try {
            java.util.List<com.tencent.bugly.opengame.proguard.m> listC = c(i);
            if (listC == null) {
                return false;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (com.tencent.bugly.opengame.proguard.m mVar : listC) {
                if (mVar.b != null && mVar.b.equalsIgnoreCase(this.d) && mVar.d > 0) {
                    arrayList.add(mVar);
                }
                if (mVar.c + 86400000 < jCurrentTimeMillis) {
                    arrayList2.add(mVar);
                }
            }
            java.util.Collections.sort(arrayList);
            if (arrayList.size() < 2) {
                listC.removeAll(arrayList2);
                a(i, listC);
                return false;
            }
            if (arrayList.size() <= 0 || ((com.tencent.bugly.opengame.proguard.m) arrayList.get(arrayList.size() - 1)).c + 86400000 >= jCurrentTimeMillis) {
                return true;
            }
            listC.clear();
            a(i, listC);
            return false;
        } catch (java.lang.Exception unused) {
            com.tencent.bugly.opengame.proguard.x.e("isFrequentCrash failed", new java.lang.Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x0051 A[Catch: all -> 0x005f, Exception -> 0x0061, PHI: r7
  0x0051: PHI (r7v11 java.io.ObjectInputStream) = (r7v10 java.io.ObjectInputStream), (r7v12 java.io.ObjectInputStream) binds: [B:18:0x0044, B:23:0x004f] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #6 {Exception -> 0x0061, blocks: (B:4:0x0003, B:10:0x0034, B:24:0x0051, B:28:0x005b, B:29:0x005e), top: B:40:0x0003, outer: #7 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean] */
    public synchronized java.util.List c(int i) {
        java.io.ObjectInputStream objectInputStream;
        java.lang.Throwable th;
        java.io.ObjectInputStream objectInputStream2;
        try {
            java.io.File dir = this.c.getDir("crashrecord", 0);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(i);
            java.io.File file = new java.io.File(dir, sb.toString());
            ?? Exists = file.exists();
            try {
                if (Exists == 0) {
                    return null;
                }
                try {
                    objectInputStream2 = new java.io.ObjectInputStream(new java.io.FileInputStream(file));
                    try {
                        java.util.List list = (java.util.List) objectInputStream2.readObject();
                        objectInputStream2.close();
                        return list;
                    } catch (java.io.IOException unused) {
                        com.tencent.bugly.opengame.proguard.x.a("open record file error", new java.lang.Object[0]);
                        if (objectInputStream2 != null) {
                            objectInputStream2.close();
                        }
                        return null;
                    } catch (java.lang.ClassNotFoundException unused2) {
                        com.tencent.bugly.opengame.proguard.x.a("get object error", new java.lang.Object[0]);
                        if (objectInputStream2 != null) {
                            objectInputStream2.close();
                        }
                        return null;
                    }
                } catch (java.io.IOException unused3) {
                    objectInputStream2 = null;
                } catch (java.lang.ClassNotFoundException unused4) {
                    objectInputStream2 = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    objectInputStream = 0;
                    if (objectInputStream == 0) {
                        throw th;
                    }
                    objectInputStream.close();
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                objectInputStream = Exists;
                th = th3;
            }
        } catch (java.lang.Exception unused5) {
            com.tencent.bugly.opengame.proguard.x.e("readCrashRecord error", new java.lang.Object[0]);
        }
    }

    public final void a(int i, final int i2) {
        final int i3 = 1004;
        com.tencent.bugly.opengame.proguard.w.a().a(new java.lang.Runnable() { // from class: com.tencent.bugly.opengame.proguard.n.1
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.bugly.opengame.proguard.m mVar;
                try {
                    if (android.text.TextUtils.isEmpty(com.tencent.bugly.opengame.proguard.n.this.d)) {
                        return;
                    }
                    java.util.List<com.tencent.bugly.opengame.proguard.m> listC = com.tencent.bugly.opengame.proguard.n.this.c(i3);
                    if (listC == null) {
                        listC = new java.util.ArrayList();
                    }
                    if (com.tencent.bugly.opengame.proguard.n.this.e.get(java.lang.Integer.valueOf(i3)) == null) {
                        com.tencent.bugly.opengame.proguard.n.this.e.put(java.lang.Integer.valueOf(i3), new java.util.HashMap());
                    }
                    if (((java.util.Map) com.tencent.bugly.opengame.proguard.n.this.e.get(java.lang.Integer.valueOf(i3))).get(com.tencent.bugly.opengame.proguard.n.this.d) == null) {
                        mVar = new com.tencent.bugly.opengame.proguard.m();
                        mVar.f397a = i3;
                        mVar.g = com.tencent.bugly.opengame.proguard.n.f398a;
                        mVar.b = com.tencent.bugly.opengame.proguard.n.this.d;
                        mVar.f = com.tencent.bugly.opengame.crashreport.common.info.a.b().j;
                        com.tencent.bugly.opengame.crashreport.common.info.a.b().getClass();
                        mVar.e = "3.0.0";
                        mVar.c = java.lang.System.currentTimeMillis();
                        mVar.d = i2;
                        ((java.util.Map) com.tencent.bugly.opengame.proguard.n.this.e.get(java.lang.Integer.valueOf(i3))).put(com.tencent.bugly.opengame.proguard.n.this.d, mVar);
                    } else {
                        mVar = (com.tencent.bugly.opengame.proguard.m) ((java.util.Map) com.tencent.bugly.opengame.proguard.n.this.e.get(java.lang.Integer.valueOf(i3))).get(com.tencent.bugly.opengame.proguard.n.this.d);
                        mVar.d = i2;
                    }
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    boolean z = false;
                    for (com.tencent.bugly.opengame.proguard.m mVar2 : listC) {
                        if (mVar2.g == mVar.g && mVar2.b != null && mVar2.b.equalsIgnoreCase(mVar.b)) {
                            z = true;
                            mVar2.d = mVar.d;
                        }
                        if ((mVar2.e != null && !mVar2.e.equalsIgnoreCase(mVar.e)) || ((mVar2.f != null && !mVar2.f.equalsIgnoreCase(mVar.f)) || mVar2.d <= 0)) {
                            arrayList.add(mVar2);
                        }
                    }
                    listC.removeAll(arrayList);
                    if (!z) {
                        listC.add(mVar);
                    }
                    com.tencent.bugly.opengame.proguard.n.this.a(i3, listC);
                } catch (java.lang.Exception unused) {
                    com.tencent.bugly.opengame.proguard.x.e("saveCrashRecord failed", new java.lang.Object[0]);
                }
            }
        });
    }

    public final synchronized boolean a(final int i) {
        boolean z;
        z = true;
        try {
            z = this.f.getBoolean(i + "_" + this.d, true);
            com.tencent.bugly.opengame.proguard.w.a().a(new java.lang.Runnable() { // from class: com.tencent.bugly.opengame.proguard.n.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean zB = com.tencent.bugly.opengame.proguard.n.this.b(i);
                    com.tencent.bugly.opengame.proguard.n.this.f.edit().putBoolean(i + "_" + com.tencent.bugly.opengame.proguard.n.this.d, !zB).commit();
                }
            });
        } catch (java.lang.Exception unused) {
            com.tencent.bugly.opengame.proguard.x.e("canInit error", new java.lang.Object[0]);
            return z;
        }
        return z;
    }
}
