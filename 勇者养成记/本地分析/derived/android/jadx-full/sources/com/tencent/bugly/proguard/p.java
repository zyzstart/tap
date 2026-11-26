package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.bugly.proguard.p f443a = null;
    private static com.tencent.bugly.proguard.q b = null;
    private static boolean c = false;

    /* JADX INFO: compiled from: BUGLY */
    class a extends java.lang.Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f444a;
        private com.tencent.bugly.proguard.o b;
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

        public a(int i, com.tencent.bugly.proguard.o oVar) {
            this.f444a = i;
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
            switch (this.f444a) {
                case 1:
                    com.tencent.bugly.proguard.p.this.a(this.c, this.d, this.b);
                    break;
                case 2:
                    com.tencent.bugly.proguard.p.this.a(this.c, this.m, this.n, this.b);
                    break;
                case 3:
                    android.database.Cursor cursorA = com.tencent.bugly.proguard.p.this.a(this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    break;
                case 4:
                    com.tencent.bugly.proguard.p.this.a(this.o, this.p, this.q, this.b);
                    break;
                case 5:
                    com.tencent.bugly.proguard.p.this.a(this.o, this.b);
                    break;
                case 6:
                    com.tencent.bugly.proguard.p.this.a(this.o, this.p, this.b);
                    break;
            }
        }
    }

    private p(android.content.Context context, java.util.List<com.tencent.bugly.a> list) {
        b = new com.tencent.bugly.proguard.q(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int a(java.lang.String str, java.lang.String str2, java.lang.String[] strArr, com.tencent.bugly.proguard.o oVar) {
        int iDelete;
        iDelete = 0;
        try {
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
                iDelete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
                if (oVar != null) {
                    java.lang.Integer.valueOf(iDelete);
                }
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.proguard.x.a(th)) {
                    th.printStackTrace();
                }
                if (oVar != null) {
                }
            }
        } catch (java.lang.Throwable th2) {
            if (oVar != null) {
                java.lang.Integer.valueOf(0);
            }
            throw th2;
        }
        return iDelete;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized long a(java.lang.String str, android.content.ContentValues contentValues, com.tencent.bugly.proguard.o oVar) {
        long j;
        j = 0;
        try {
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase != null && contentValues != null) {
                    long jReplace = writableDatabase.replace(str, "_id", contentValues);
                    if (jReplace >= 0) {
                        com.tencent.bugly.proguard.x.c("[Database] insert %s success.", str);
                    } else {
                        com.tencent.bugly.proguard.x.d("[Database] replace %s error.", str);
                    }
                    j = jReplace;
                }
                if (oVar != null) {
                    java.lang.Long.valueOf(j);
                }
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.proguard.x.a(th)) {
                    th.printStackTrace();
                }
                if (oVar != null) {
                }
            }
        } catch (java.lang.Throwable th2) {
            if (oVar != null) {
                java.lang.Long.valueOf(0L);
            }
            throw th2;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized android.database.Cursor a(boolean z, java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, com.tencent.bugly.proguard.o oVar) {
        android.database.Cursor cursorQuery;
        cursorQuery = null;
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                cursorQuery = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
        }
        return cursorQuery;
    }

    public static synchronized com.tencent.bugly.proguard.p a() {
        return f443a;
    }

    public static synchronized com.tencent.bugly.proguard.p a(android.content.Context context, java.util.List<com.tencent.bugly.a> list) {
        if (f443a == null) {
            f443a = new com.tencent.bugly.proguard.p(context, list);
        }
        return f443a;
    }

    private static com.tencent.bugly.proguard.r a(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            com.tencent.bugly.proguard.r rVar = new com.tencent.bugly.proguard.r();
            rVar.f446a = cursor.getLong(cursor.getColumnIndex("_id"));
            rVar.b = cursor.getInt(cursor.getColumnIndex("_tp"));
            rVar.c = cursor.getString(cursor.getColumnIndex("_pc"));
            rVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            rVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.util.Map<java.lang.String, byte[]> a(int i, com.tencent.bugly.proguard.o oVar) {
        java.util.HashMap map = null;
        try {
            java.util.List<com.tencent.bugly.proguard.r> listC = c(i);
            if (listC == null) {
                return null;
            }
            java.util.HashMap map2 = new java.util.HashMap();
            try {
                for (com.tencent.bugly.proguard.r rVar : listC) {
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
        if (com.tencent.bugly.proguard.x.a(th)) {
            return map;
        }
        th.printStackTrace();
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean a(int i, java.lang.String str, com.tencent.bugly.proguard.o oVar) {
        boolean z;
        java.lang.String str2;
        z = false;
        try {
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase != null) {
                    if (com.tencent.bugly.proguard.z.a(str)) {
                        str2 = "_id = " + i;
                    } else {
                        str2 = "_id = " + i + " and _tp = \"" + str + "\"";
                    }
                    int iDelete = writableDatabase.delete("t_pf", str2, null);
                    com.tencent.bugly.proguard.x.c("[Database] deleted %s data %d", "t_pf", java.lang.Integer.valueOf(iDelete));
                    if (iDelete > 0) {
                        z = true;
                    }
                }
                if (oVar != null) {
                    java.lang.Boolean.valueOf(z);
                }
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.proguard.x.a(th)) {
                    th.printStackTrace();
                }
                if (oVar != null) {
                }
            }
        } catch (java.lang.Throwable th2) {
            if (oVar != null) {
                java.lang.Boolean.valueOf(false);
            }
            throw th2;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean a(int i, java.lang.String str, byte[] bArr, com.tencent.bugly.proguard.o oVar) {
        boolean zB = false;
        try {
            com.tencent.bugly.proguard.r rVar = new com.tencent.bugly.proguard.r();
            rVar.f446a = i;
            rVar.f = str;
            rVar.e = java.lang.System.currentTimeMillis();
            rVar.g = bArr;
            zB = b(rVar);
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
        } finally {
            if (oVar != null) {
                java.lang.Boolean.valueOf(false);
            }
        }
        return zB;
    }

    private static com.tencent.bugly.proguard.r b(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            com.tencent.bugly.proguard.r rVar = new com.tencent.bugly.proguard.r();
            rVar.f446a = cursor.getLong(cursor.getColumnIndex("_id"));
            rVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.f = cursor.getString(cursor.getColumnIndex("_tp"));
            rVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private synchronized boolean b(com.tencent.bugly.proguard.r rVar) {
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
            com.tencent.bugly.proguard.x.c("[Database] insert %s success.", "t_pf");
            rVar.f446a = jReplace;
            return true;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    private static android.content.ContentValues c(com.tencent.bugly.proguard.r rVar) {
        if (rVar == null) {
            return null;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            if (rVar.f446a > 0) {
                contentValues.put("_id", java.lang.Long.valueOf(rVar.f446a));
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
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00bb A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #5 {all -> 0x00bf, blocks: (B:9:0x0029, B:26:0x009c, B:39:0x00b3, B:44:0x00bb, B:45:0x00be), top: B:55:0x0002 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized java.util.List<com.tencent.bugly.proguard.r> c(int i) {
        android.database.Cursor cursorQuery;
        try {
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
                        try {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            java.util.ArrayList arrayList = new java.util.ArrayList();
                            while (cursorQuery.moveToNext()) {
                                com.tencent.bugly.proguard.r rVarB = b(cursorQuery);
                                if (rVarB != null) {
                                    arrayList.add(rVarB);
                                } else {
                                    try {
                                        java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex("_tp"));
                                        sb.append(" or _tp");
                                        sb.append(" = ");
                                        sb.append(string);
                                    } catch (java.lang.Throwable unused) {
                                        com.tencent.bugly.proguard.x.d("[Database] unknown id.", new java.lang.Object[0]);
                                    }
                                }
                            }
                            if (sb.length() > 0) {
                                sb.append(" and _id");
                                sb.append(" = ");
                                sb.append(i);
                                com.tencent.bugly.proguard.x.d("[Database] deleted %s illegal data %d.", "t_pf", java.lang.Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return arrayList;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (!com.tencent.bugly.proguard.x.a(th)) {
                                th.printStackTrace();
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return null;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th3) {
                throw th3;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            cursorQuery = null;
        }
        return null;
    }

    private static android.content.ContentValues d(com.tencent.bugly.proguard.r rVar) {
        if (rVar == null || com.tencent.bugly.proguard.z.a(rVar.f)) {
            return null;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            if (rVar.f446a > 0) {
                contentValues.put("_id", java.lang.Long.valueOf(rVar.f446a));
            }
            contentValues.put("_tp", rVar.f);
            contentValues.put("_tm", java.lang.Long.valueOf(rVar.e));
            if (rVar.g != null) {
                contentValues.put("_dt", rVar.g);
            }
            return contentValues;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final int a(java.lang.String str, java.lang.String str2, java.lang.String[] strArr, com.tencent.bugly.proguard.o oVar, boolean z) {
        return a(str, str2, (java.lang.String[]) null, (com.tencent.bugly.proguard.o) null);
    }

    public final long a(java.lang.String str, android.content.ContentValues contentValues, com.tencent.bugly.proguard.o oVar, boolean z) {
        return a(str, contentValues, (com.tencent.bugly.proguard.o) null);
    }

    public final android.database.Cursor a(java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, com.tencent.bugly.proguard.o oVar, boolean z) {
        return a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00ad A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #1 {all -> 0x00b6, blocks: (B:19:0x003c, B:20:0x0046, B:22:0x004d, B:24:0x0053, B:26:0x0057, B:28:0x006f, B:29:0x0077, B:31:0x0081, B:37:0x00a7, B:39:0x00ad), top: B:54:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b2 A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #5 {, blocks: (B:3:0x0001, B:16:0x0037, B:33:0x00a1, B:41:0x00b2, B:44:0x00b9, B:45:0x00bc), top: B:57:0x0001 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized java.util.List<com.tencent.bugly.proguard.r> a(int i) {
        java.lang.String str;
        java.lang.Throwable th;
        android.database.Cursor cursorQuery;
        android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
        if (writableDatabase != null) {
            try {
                if (i >= 0) {
                    try {
                        str = "_tp = " + ((int) i);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        i = 0;
                        if (i != 0) {
                            i.close();
                        }
                        throw th;
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
                        com.tencent.bugly.proguard.r rVarA = a(cursorQuery);
                        if (rVarA != null) {
                            arrayList.add(rVarA);
                        } else {
                            try {
                                long j = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                                sb.append(" or _id");
                                sb.append(" = ");
                                sb.append(j);
                            } catch (java.lang.Throwable unused) {
                                com.tencent.bugly.proguard.x.d("[Database] unknown id.", new java.lang.Object[0]);
                            }
                        }
                    }
                    java.lang.String string = sb.toString();
                    if (string.length() > 0) {
                        com.tencent.bugly.proguard.x.d("[Database] deleted %s illegal data %d", "t_lr", java.lang.Integer.valueOf(writableDatabase.delete("t_lr", string.substring(4), null)));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    if (!com.tencent.bugly.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        }
        return null;
    }

    public final java.util.Map<java.lang.String, byte[]> a(int i, com.tencent.bugly.proguard.o oVar, boolean z) {
        return a(i, (com.tencent.bugly.proguard.o) null);
    }

    public final synchronized void a(java.util.List<com.tencent.bugly.proguard.r> list) {
        if (list != null) {
            if (list.size() != 0) {
                android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase != null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (com.tencent.bugly.proguard.r rVar : list) {
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(rVar.f446a);
                    }
                    java.lang.String string = sb.toString();
                    if (string.length() > 0) {
                        string = string.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        com.tencent.bugly.proguard.x.c("[Database] deleted %s data %d", "t_lr", java.lang.Integer.valueOf(writableDatabase.delete("t_lr", string, null)));
                    } catch (java.lang.Throwable th) {
                        if (com.tencent.bugly.proguard.x.a(th)) {
                            return;
                        }
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public final boolean a(int i, java.lang.String str, com.tencent.bugly.proguard.o oVar, boolean z) {
        return a(555, str, (com.tencent.bugly.proguard.o) null);
    }

    public final boolean a(int i, java.lang.String str, byte[] bArr, com.tencent.bugly.proguard.o oVar, boolean z) {
        if (z) {
            return a(i, str, bArr, (com.tencent.bugly.proguard.o) null);
        }
        com.tencent.bugly.proguard.p.a aVar = new com.tencent.bugly.proguard.p.a(4, null);
        aVar.a(i, str, bArr);
        com.tencent.bugly.proguard.w.a().a(aVar);
        return true;
    }

    public final synchronized boolean a(com.tencent.bugly.proguard.r rVar) {
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
            com.tencent.bugly.proguard.x.c("[Database] insert %s success.", "t_lr");
            rVar.f446a = jReplace;
            return true;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized void b(int i) {
        java.lang.String str;
        android.database.sqlite.SQLiteDatabase writableDatabase = b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    try {
                        str = "_tp = " + i;
                    } catch (java.lang.Throwable th) {
                        if (com.tencent.bugly.proguard.x.a(th)) {
                            return;
                        }
                        th.printStackTrace();
                        return;
                    }
                } catch (java.lang.Throwable th2) {
                    throw th2;
                }
            } else {
                str = null;
            }
            com.tencent.bugly.proguard.x.c("[Database] deleted %s data %d", "t_lr", java.lang.Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }
}
