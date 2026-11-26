package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f440a = java.lang.System.currentTimeMillis();
    private static com.tencent.bugly.proguard.n b;
    private android.content.Context c;
    private android.content.SharedPreferences f;
    private java.util.Map<java.lang.Integer, java.util.Map<java.lang.String, com.tencent.bugly.proguard.m>> e = new java.util.HashMap();
    private java.lang.String d = com.tencent.bugly.crashreport.common.info.a.b().d;

    private n(android.content.Context context) {
        this.c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized com.tencent.bugly.proguard.n a() {
        return b;
    }

    public static synchronized com.tencent.bugly.proguard.n a(android.content.Context context) {
        if (b == null) {
            b = new com.tencent.bugly.proguard.n(context);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized <T extends java.util.List<?>> void a(int i, T t) {
        if (t == null) {
            return;
        }
        try {
            java.io.File dir = this.c.getDir("crashrecord", 0);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(i);
            java.io.ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    java.io.ObjectOutputStream objectOutputStream2 = new java.io.ObjectOutputStream(new java.io.FileOutputStream(new java.io.File(dir, sb.toString())));
                    try {
                        objectOutputStream2.writeObject(t);
                        objectOutputStream2.close();
                    } catch (java.io.IOException e) {
                        e = e;
                        objectOutputStream = objectOutputStream2;
                        e.printStackTrace();
                        com.tencent.bugly.proguard.x.a("open record file error", new java.lang.Object[0]);
                        if (objectOutputStream == null) {
                        } else {
                            objectOutputStream.close();
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.io.IOException e2) {
                e = e2;
            }
        } catch (java.lang.Exception unused) {
            com.tencent.bugly.proguard.x.e("writeCrashRecord error", new java.lang.Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean b(int i) {
        try {
            java.util.List<com.tencent.bugly.proguard.m> listC = c(i);
            if (listC == null) {
                return false;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (com.tencent.bugly.proguard.m mVar : listC) {
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
            if (arrayList.size() <= 0 || ((com.tencent.bugly.proguard.m) arrayList.get(arrayList.size() - 1)).c + 86400000 >= jCurrentTimeMillis) {
                return true;
            }
            listC.clear();
            a(i, listC);
            return false;
        } catch (java.lang.Exception unused) {
            com.tencent.bugly.proguard.x.e("isFrequentCrash failed", new java.lang.Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x0046 A[Catch: all -> 0x005c, Exception -> 0x005e, PHI: r6
  0x0046: PHI (r6v10 java.io.ObjectInputStream) = (r6v9 java.io.ObjectInputStream), (r6v11 java.io.ObjectInputStream) binds: [B:17:0x0044, B:22:0x0052] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x005e, blocks: (B:4:0x0003, B:10:0x0034, B:18:0x0046, B:26:0x0058, B:27:0x005b), top: B:38:0x0003, outer: #4 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized <T extends java.util.List<?>> T c(int i) {
        java.io.ObjectInputStream objectInputStream;
        try {
            java.io.File dir = this.c.getDir("crashrecord", 0);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(i);
            java.io.File file = new java.io.File(dir, sb.toString());
            java.io.ObjectInputStream objectInputStreamExists = file.exists();
            try {
                if (objectInputStreamExists == 0) {
                    return null;
                }
                try {
                    objectInputStream = new java.io.ObjectInputStream(new java.io.FileInputStream(file));
                    try {
                        T t = (T) objectInputStream.readObject();
                        objectInputStream.close();
                        return t;
                    } catch (java.io.IOException unused) {
                        com.tencent.bugly.proguard.x.a("open record file error", new java.lang.Object[0]);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    } catch (java.lang.ClassNotFoundException unused2) {
                        com.tencent.bugly.proguard.x.a("get object error", new java.lang.Object[0]);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    }
                } catch (java.io.IOException unused3) {
                    objectInputStream = null;
                } catch (java.lang.ClassNotFoundException unused4) {
                    objectInputStream = null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    objectInputStreamExists = 0;
                    if (objectInputStreamExists != 0) {
                        objectInputStreamExists.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception unused5) {
            com.tencent.bugly.proguard.x.e("readCrashRecord error", new java.lang.Object[0]);
        }
    }

    public final void a(int i, final int i2) {
        final int i3 = 1004;
        com.tencent.bugly.proguard.w.a().a(new java.lang.Runnable() { // from class: com.tencent.bugly.proguard.n.1
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.bugly.proguard.m mVar;
                try {
                    if (android.text.TextUtils.isEmpty(com.tencent.bugly.proguard.n.this.d)) {
                        return;
                    }
                    java.util.List<com.tencent.bugly.proguard.m> listC = com.tencent.bugly.proguard.n.this.c(i3);
                    if (listC == null) {
                        listC = new java.util.ArrayList();
                    }
                    if (com.tencent.bugly.proguard.n.this.e.get(java.lang.Integer.valueOf(i3)) == null) {
                        com.tencent.bugly.proguard.n.this.e.put(java.lang.Integer.valueOf(i3), new java.util.HashMap());
                    }
                    if (((java.util.Map) com.tencent.bugly.proguard.n.this.e.get(java.lang.Integer.valueOf(i3))).get(com.tencent.bugly.proguard.n.this.d) == null) {
                        mVar = new com.tencent.bugly.proguard.m();
                        mVar.f439a = i3;
                        mVar.g = com.tencent.bugly.proguard.n.f440a;
                        mVar.b = com.tencent.bugly.proguard.n.this.d;
                        mVar.f = com.tencent.bugly.crashreport.common.info.a.b().j;
                        com.tencent.bugly.crashreport.common.info.a.b().getClass();
                        mVar.e = "3.0.0";
                        mVar.c = java.lang.System.currentTimeMillis();
                        mVar.d = i2;
                        ((java.util.Map) com.tencent.bugly.proguard.n.this.e.get(java.lang.Integer.valueOf(i3))).put(com.tencent.bugly.proguard.n.this.d, mVar);
                    } else {
                        mVar = (com.tencent.bugly.proguard.m) ((java.util.Map) com.tencent.bugly.proguard.n.this.e.get(java.lang.Integer.valueOf(i3))).get(com.tencent.bugly.proguard.n.this.d);
                        mVar.d = i2;
                    }
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    boolean z = false;
                    for (com.tencent.bugly.proguard.m mVar2 : listC) {
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
                    com.tencent.bugly.proguard.n.this.a(i3, listC);
                } catch (java.lang.Exception unused) {
                    com.tencent.bugly.proguard.x.e("saveCrashRecord failed", new java.lang.Object[0]);
                }
            }
        });
    }

    public final synchronized boolean a(final int i) {
        boolean z;
        z = true;
        try {
            z = this.f.getBoolean(i + "_" + this.d, true);
            com.tencent.bugly.proguard.w.a().a(new java.lang.Runnable() { // from class: com.tencent.bugly.proguard.n.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean zB = com.tencent.bugly.proguard.n.this.b(i);
                    com.tencent.bugly.proguard.n.this.f.edit().putBoolean(i + "_" + com.tencent.bugly.proguard.n.this.d, !zB).commit();
                }
            });
        } catch (java.lang.Exception unused) {
            com.tencent.bugly.proguard.x.e("canInit error", new java.lang.Object[0]);
            return z;
        }
        return z;
    }
}
