package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.bugly.opengame.proguard.p f401a = null;
    private static com.tencent.bugly.opengame.proguard.q b = null;
    private static boolean c = false;

    class a extends java.lang.Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f402a;
        private com.tencent.bugly.opengame.proguard.o b;
        private java.lang.String c;
        private android.content.ContentValues d;
        private boolean e;
        private java.lang.String[] f;
        private java.lang.String g;
        private java.lang.String[] h;
        private java.lang.String i;
        private java.lang.String j;
        private java.lang.String k;
        private java.lang.String l;
        private java.lang.String m;
        private java.lang.String[] n;
        private int o;
        private java.lang.String p;
        private byte[] q;

        public a(int i, com.tencent.bugly.opengame.proguard.o oVar) {
            this.f402a = i;
            this.b = oVar;
        }

        public final void a(int i, java.lang.String str, byte[] bArr) {
            this.o = i;
            this.p = str;
            this.q = bArr;
        }

        public final void a(boolean z, java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
            this.e = z;
            this.c = str;
            this.f = strArr;
            this.g = str2;
            this.h = strArr2;
            this.i = str3;
            this.j = str4;
            this.k = str5;
            this.l = str6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f402a) {
                case 1:
                    com.tencent.bugly.opengame.proguard.p.this.a(this.c, this.d, this.b);
                    break;
                case 2:
                    com.tencent.bugly.opengame.proguard.p.this.a(this.c, this.m, this.n, this.b);
                    break;
                case 3:
                    android.database.Cursor cursorA = com.tencent.bugly.opengame.proguard.p.this.a(this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    break;
                case 4:
                    com.tencent.bugly.opengame.proguard.p.this.a(this.o, this.p, this.q, this.b);
                    break;
                case 5:
                    com.tencent.bugly.opengame.proguard.p.this.a(this.o, this.b);
                    break;
                case 6:
                    com.tencent.bugly.opengame.proguard.p.this.a(this.o, this.p, this.b);
                    break;
            }
        }
    }

    private p(android.content.Context context, java.util.List list) {
        b = new com.tencent.bugly.opengame.proguard.q(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(java.lang.String str, java.lang.String str2, java.lang.String[] strArr, com.tencent.bugly.opengame.proguard.o oVar) {
        int iDelete;
        iDelete = 0;
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                iDelete = writableDatabase.delete(str, str2, strArr);
            }
        } catch (java.lang.Throwable th) {
            try {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
        return iDelete;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0037 -> B:21:0x0038). Please report as a decompilation issue!!! */
    public synchronized long a(java.lang.String str, android.content.ContentValues contentValues, com.tencent.bugly.opengame.proguard.o oVar) {
        long jReplace;
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase == null || contentValues == null) {
                jReplace = 0;
            } else {
                jReplace = writableDatabase.replace(str, "_id", contentValues);
                if (jReplace >= 0) {
                    com.tencent.bugly.opengame.proguard.x.c("[Database] insert %s success.", str);
                } else {
                    com.tencent.bugly.opengame.proguard.x.d("[Database] replace %s error.", str);
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
        return jReplace;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized android.database.Cursor a(boolean z, java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, com.tencent.bugly.opengame.proguard.o oVar) {
        android.database.Cursor cursorQuery;
        cursorQuery = null;
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                cursorQuery = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } catch (java.lang.Throwable th) {
            try {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
        return cursorQuery;
    }

    public static synchronized com.tencent.bugly.opengame.proguard.p a() {
        return f401a;
    }

    public static synchronized com.tencent.bugly.opengame.proguard.p a(android.content.Context context, java.util.List list) {
        if (f401a == null) {
            f401a = new com.tencent.bugly.opengame.proguard.p(context, list);
        }
        return f401a;
    }

    private static com.tencent.bugly.opengame.proguard.r a(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            com.tencent.bugly.opengame.proguard.r rVar = new com.tencent.bugly.opengame.proguard.r();
            rVar.f404a = cursor.getLong(cursor.getColumnIndex("_id"));
            rVar.b = cursor.getInt(cursor.getColumnIndex("_tp"));
            rVar.c = cursor.getString(cursor.getColumnIndex("_pc"));
            rVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            rVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.util.Map a(int i, com.tencent.bugly.opengame.proguard.o oVar) {
        java.util.HashMap map = null;
        try {
            java.util.List<com.tencent.bugly.opengame.proguard.r> listC = c(i);
            if (listC == null) {
                return null;
            }
            java.util.HashMap map2 = new java.util.HashMap();
            try {
                for (com.tencent.bugly.opengame.proguard.r rVar : listC) {
                    byte[] bArr = rVar.g;
                    if (bArr != null) {
                        map2.put(rVar.f, bArr);
                    }
                }
                return map2;
            } catch (java.lang.Throwable th) {
                th = th;
                map = map2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        if (com.tencent.bugly.opengame.proguard.x.a(th)) {
            return map;
        }
        th.printStackTrace();
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i, java.lang.String str, com.tencent.bugly.opengame.proguard.o oVar) {
        boolean z;
        java.lang.StringBuilder sb;
        z = false;
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                if (com.tencent.bugly.opengame.proguard.z.a(str)) {
                    sb = new java.lang.StringBuilder("_id = ");
                    sb.append(i);
                } else {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("_id = ");
                    sb2.append(i);
                    sb2.append(" and _tp");
                    sb2.append(" = \"");
                    sb2.append(str);
                    sb2.append("\"");
                    sb = sb2;
                }
                int iDelete = writableDatabase.delete("t_pf", sb.toString(), null);
                com.tencent.bugly.opengame.proguard.x.c("[Database] deleted %s data %d", "t_pf", java.lang.Integer.valueOf(iDelete));
                if (iDelete > 0) {
                    z = true;
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, java.lang.String str, byte[] bArr, com.tencent.bugly.opengame.proguard.o oVar) {
        try {
            com.tencent.bugly.opengame.proguard.r rVar = new com.tencent.bugly.opengame.proguard.r();
            rVar.f404a = i;
            rVar.f = str;
            rVar.e = java.lang.System.currentTimeMillis();
            rVar.g = bArr;
            return b(rVar);
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    private static com.tencent.bugly.opengame.proguard.r b(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            com.tencent.bugly.opengame.proguard.r rVar = new com.tencent.bugly.opengame.proguard.r();
            rVar.f404a = cursor.getLong(cursor.getColumnIndex("_id"));
            rVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.f = cursor.getString(cursor.getColumnIndex("_tp"));
            rVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private synchronized boolean b(com.tencent.bugly.opengame.proguard.r rVar) {
        android.content.ContentValues contentValuesD;
        if (rVar == null) {
            return false;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase == null || (contentValuesD = d(rVar)) == null) {
                return false;
            }
            long jReplace = writableDatabase.replace("t_pf", "_id", contentValuesD);
            if (jReplace < 0) {
                return false;
            }
            com.tencent.bugly.opengame.proguard.x.c("[Database] insert %s success.", "t_pf");
            rVar.f404a = jReplace;
            return true;
        } catch (java.lang.Throwable th) {
            try {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
    }

    private static android.content.ContentValues c(com.tencent.bugly.opengame.proguard.r rVar) {
        if (rVar == null) {
            return null;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            if (rVar.f404a > 0) {
                contentValues.put("_id", java.lang.Long.valueOf(rVar.f404a));
            }
            contentValues.put("_tp", java.lang.Integer.valueOf(rVar.b));
            contentValues.put("_pc", rVar.c);
            contentValues.put("_th", rVar.d);
            contentValues.put("_tm", java.lang.Long.valueOf(rVar.e));
            if (rVar.g != null) {
                contentValues.put("_dt", rVar.g);
            }
            return contentValues;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized java.util.List c(int i) {
        android.database.Cursor cursorQuery;
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                java.lang.String str = "_id = " + i;
                cursorQuery = writableDatabase.query("t_pf", null, str, null, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    while (cursorQuery.moveToNext()) {
                        com.tencent.bugly.opengame.proguard.r rVarB = b(cursorQuery);
                        if (rVarB != null) {
                            arrayList.add(rVarB);
                        } else {
                            try {
                                java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex("_tp"));
                                sb.append(" or _tp");
                                sb.append(" = ");
                                sb.append(string);
                            } catch (java.lang.Throwable unused) {
                                com.tencent.bugly.opengame.proguard.x.d("[Database] unknown id.", new java.lang.Object[0]);
                            }
                        }
                    }
                    if (sb.length() > 0) {
                        sb.append(" and _id");
                        sb.append(" = ");
                        sb.append(i);
                        com.tencent.bugly.opengame.proguard.x.d("[Database] deleted %s illegal data %d.", "t_pf", java.lang.Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                            th.printStackTrace();
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    } catch (java.lang.Throwable th2) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th2;
                    }
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
        return null;
    }

    private static android.content.ContentValues d(com.tencent.bugly.opengame.proguard.r rVar) {
        if (rVar != null && !com.tencent.bugly.opengame.proguard.z.a(rVar.f)) {
            try {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                if (rVar.f404a > 0) {
                    contentValues.put("_id", java.lang.Long.valueOf(rVar.f404a));
                }
                contentValues.put("_tp", rVar.f);
                contentValues.put("_tm", java.lang.Long.valueOf(rVar.e));
                if (rVar.g != null) {
                    contentValues.put("_dt", rVar.g);
                }
                return contentValues;
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public final int a(java.lang.String str, java.lang.String str2, java.lang.String[] strArr, com.tencent.bugly.opengame.proguard.o oVar, boolean z) {
        return a(str, str2, (java.lang.String[]) null, (com.tencent.bugly.opengame.proguard.o) null);
    }

    public final long a(java.lang.String str, android.content.ContentValues contentValues, com.tencent.bugly.opengame.proguard.o oVar, boolean z) {
        return a(str, contentValues, (com.tencent.bugly.opengame.proguard.o) null);
    }

    public final android.database.Cursor a(java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, com.tencent.bugly.opengame.proguard.o oVar, boolean z) {
        return a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a8 A[Catch: all -> 0x00b1, TRY_LEAVE, TryCatch #0 {all -> 0x00b1, blocks: (B:39:0x00a2, B:41:0x00a8), top: B:54:0x00a2, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ad A[Catch: all -> 0x00ba, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0001, B:14:0x0032, B:35:0x009c, B:43:0x00ad, B:46:0x00b4, B:47:0x00b7, B:39:0x00a2, B:41:0x00a8), top: B:60:0x0001, inners: #0 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized java.util.List a(int i) {
        java.lang.String str;
        java.lang.Throwable th;
        android.database.Cursor cursorQuery;
        android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = " + i;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                    try {
                        if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                            th.printStackTrace();
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    } catch (java.lang.Throwable th3) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th3;
                    }
                }
            } else {
                str = null;
            }
            cursorQuery = writableDatabase.query("t_lr", null, str, null, null, null, null);
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                while (cursorQuery.moveToNext()) {
                    com.tencent.bugly.opengame.proguard.r rVarA = a(cursorQuery);
                    if (rVarA != null) {
                        arrayList.add(rVarA);
                    } else {
                        try {
                            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                            sb.append(" or _id");
                            sb.append(" = ");
                            sb.append(j);
                        } catch (java.lang.Throwable unused) {
                            com.tencent.bugly.opengame.proguard.x.d("[Database] unknown id.", new java.lang.Object[0]);
                        }
                    }
                }
                java.lang.String string = sb.toString();
                if (string.length() > 0) {
                    com.tencent.bugly.opengame.proguard.x.d("[Database] deleted %s illegal data %d", "t_lr", java.lang.Integer.valueOf(writableDatabase.delete("t_lr", string.substring(4), null)));
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (java.lang.Throwable th4) {
                th = th4;
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
        }
        return null;
    }

    public final java.util.Map a(int i, com.tencent.bugly.opengame.proguard.o oVar, boolean z) {
        return a(i, (com.tencent.bugly.opengame.proguard.o) null);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0076 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a(java.util.List r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L79
            int r0 = r5.size()     // Catch: java.lang.Throwable -> L76
            if (r0 != 0) goto La
            goto L79
        La:
            com.tencent.bugly.opengame.proguard.q r0 = com.tencent.bugly.opengame.proguard.p.b     // Catch: java.lang.Throwable -> L76
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L76
            if (r0 == 0) goto L74
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L76
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L76
        L1b:
            boolean r2 = r5.hasNext()     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto L37
            java.lang.Object r2 = r5.next()     // Catch: java.lang.Throwable -> L76
            com.tencent.bugly.opengame.proguard.r r2 = (com.tencent.bugly.opengame.proguard.r) r2     // Catch: java.lang.Throwable -> L76
            java.lang.String r3 = " or _id"
            r1.append(r3)     // Catch: java.lang.Throwable -> L76
            java.lang.String r3 = " = "
            r1.append(r3)     // Catch: java.lang.Throwable -> L76
            long r2 = r2.f404a     // Catch: java.lang.Throwable -> L76
            r1.append(r2)     // Catch: java.lang.Throwable -> L76
            goto L1b
        L37:
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L76
            int r2 = r5.length()     // Catch: java.lang.Throwable -> L76
            if (r2 <= 0) goto L46
            r2 = 4
            java.lang.String r5 = r5.substring(r2)     // Catch: java.lang.Throwable -> L76
        L46:
            r2 = 0
            r1.setLength(r2)     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "t_lr"
            r3 = 0
            int r5 = r0.delete(r1, r5, r3)     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = "[Database] deleted %s data %d"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = "t_lr"
            r1[r2] = r3     // Catch: java.lang.Throwable -> L66
            r2 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L66
            r1[r2] = r5     // Catch: java.lang.Throwable -> L66
            com.tencent.bugly.opengame.proguard.x.c(r0, r1)     // Catch: java.lang.Throwable -> L66
            monitor-exit(r4)
            return
        L66:
            r5 = move-exception
            boolean r0 = com.tencent.bugly.opengame.proguard.x.a(r5)     // Catch: java.lang.Throwable -> L72
            if (r0 != 0) goto L70
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L72
        L70:
            monitor-exit(r4)
            return
        L72:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L76
        L74:
            monitor-exit(r4)
            return
        L76:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L79:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.opengame.proguard.p.a(java.util.List):void");
    }

    public final boolean a(int i, java.lang.String str, com.tencent.bugly.opengame.proguard.o oVar, boolean z) {
        return a(555, str, (com.tencent.bugly.opengame.proguard.o) null);
    }

    public final boolean a(int i, java.lang.String str, byte[] bArr, com.tencent.bugly.opengame.proguard.o oVar, boolean z) {
        if (z) {
            return a(i, str, bArr, (com.tencent.bugly.opengame.proguard.o) null);
        }
        com.tencent.bugly.opengame.proguard.p.a aVar = new com.tencent.bugly.opengame.proguard.p.a(4, null);
        aVar.a(i, str, bArr);
        com.tencent.bugly.opengame.proguard.w.a().a(aVar);
        return true;
    }

    public final synchronized boolean a(com.tencent.bugly.opengame.proguard.r rVar) {
        android.content.ContentValues contentValuesC;
        if (rVar == null) {
            return false;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase == null || (contentValuesC = c(rVar)) == null) {
                return false;
            }
            long jReplace = writableDatabase.replace("t_lr", "_id", contentValuesC);
            if (jReplace < 0) {
                return false;
            }
            com.tencent.bugly.opengame.proguard.x.c("[Database] insert %s success.", "t_lr");
            rVar.f404a = jReplace;
            return true;
        } catch (java.lang.Throwable th) {
            try {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized void b(int i) {
        java.lang.String str;
        android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = " + i;
                } catch (java.lang.Throwable th) {
                    if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            } else {
                str = null;
            }
            com.tencent.bugly.opengame.proguard.x.c("[Database] deleted %s data %d", "t_lr", java.lang.Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }
}
