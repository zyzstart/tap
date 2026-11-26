package com.tencent.yybsdk.apkpatch.e.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements com.tencent.yybsdk.apkpatch.e.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public android.content.Context f1413a;
    private final java.lang.String b = "oldApkPath";
    private final java.lang.String c = "patchPath";
    private final java.lang.String d = "newApkPath";
    private final java.lang.String e = "alorithms";
    private final java.lang.String f = "process";
    private final java.lang.String g = "successFileIndex";
    private final java.lang.String h = "successFilePosition";
    private final java.lang.String i = "bspatchNewPointer";
    private final java.lang.String j = "bspatchOldPointer";
    private final java.lang.String k = "bspatchReadedBytes";
    private final java.lang.String l = "successInflateCount";
    private final java.lang.String m = "successDeflateCount";
    private final java.lang.String n = "status";
    private final java.lang.String o = "updateTime";

    public a() {
    }

    public a(android.content.Context context) {
        this.f1413a = context;
    }

    private int a(com.tencent.yybsdk.apkpatch.v vVar, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (vVar == null) {
            return -1;
        }
        try {
            int iUpdate = sQLiteDatabase.update("apkpatchtask", b(vVar), "oldApkPath = ? and patchPath = ? and newApkPath=? and alorithms=?", new java.lang.String[]{vVar.f1443a, vVar.b, vVar.c, ((int) vVar.d) + ""});
            if (iUpdate > 0) {
                return iUpdate;
            }
            return 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -2;
        }
    }

    private com.tencent.yybsdk.apkpatch.v a(android.database.Cursor cursor) {
        com.tencent.yybsdk.apkpatch.v vVar = new com.tencent.yybsdk.apkpatch.v();
        vVar.f1443a = cursor.getString(cursor.getColumnIndex("oldApkPath"));
        vVar.b = cursor.getString(cursor.getColumnIndex("patchPath"));
        vVar.c = cursor.getString(cursor.getColumnIndex("newApkPath"));
        vVar.d = java.lang.Short.valueOf(cursor.getString(cursor.getColumnIndex("alorithms"))).shortValue();
        vVar.h = cursor.getLong(cursor.getColumnIndex("successFileIndex"));
        vVar.i = cursor.getLong(cursor.getColumnIndex("successFilePosition"));
        vVar.e = cursor.getInt(cursor.getColumnIndex("status"));
        vVar.f = cursor.getLong(cursor.getColumnIndex("updateTime"));
        vVar.n = cursor.getInt(cursor.getColumnIndex("successDeflateCount"));
        vVar.m = cursor.getInt(cursor.getColumnIndex("successInflateCount"));
        vVar.j = cursor.getInt(cursor.getColumnIndex("bspatchNewPointer"));
        vVar.l = cursor.getInt(cursor.getColumnIndex("bspatchReadedBytes"));
        vVar.k = cursor.getInt(cursor.getColumnIndex("bspatchOldPointer"));
        vVar.g = cursor.getInt(cursor.getColumnIndex("process"));
        return vVar;
    }

    private android.content.ContentValues b(com.tencent.yybsdk.apkpatch.v vVar) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("oldApkPath", vVar.f1443a);
        contentValues.put("patchPath", vVar.b);
        contentValues.put("newApkPath", vVar.c);
        contentValues.put("alorithms", ((int) vVar.d) + "");
        contentValues.put("successFileIndex", java.lang.Long.valueOf(vVar.h));
        contentValues.put("successFilePosition", java.lang.Long.valueOf(vVar.i));
        contentValues.put("process", java.lang.Integer.valueOf(vVar.g));
        contentValues.put("successDeflateCount", java.lang.Integer.valueOf(vVar.n));
        contentValues.put("successInflateCount", java.lang.Integer.valueOf(vVar.m));
        contentValues.put("bspatchNewPointer", java.lang.Integer.valueOf(vVar.j));
        contentValues.put("bspatchOldPointer", java.lang.Integer.valueOf(vVar.k));
        contentValues.put("bspatchReadedBytes", java.lang.Integer.valueOf(vVar.l));
        contentValues.put("status", java.lang.Integer.valueOf(vVar.e));
        contentValues.put("updateTime", java.lang.Long.valueOf(vVar.f));
        return contentValues;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x007f  */
    public com.tencent.yybsdk.apkpatch.v a(com.tencent.yybsdk.apkpatch.u uVar) throws java.lang.Throwable {
        android.database.Cursor cursorRawQuery;
        android.database.Cursor cursor = null;
        if (!android.text.TextUtils.isEmpty(uVar.b) && !android.text.TextUtils.isEmpty(uVar.d.b()) && !android.text.TextUtils.isEmpty(uVar.c)) {
            try {
                cursorRawQuery = c().getReadableDatabase().rawQuery("select * from apkpatchtask where oldApkPath = ? and patchPath = ? and newApkPath = ? and alorithms = ?", new java.lang.String[]{uVar.b, uVar.d.b(), uVar.c, ((int) uVar.f) + ""});
                if (cursorRawQuery != null) {
                    try {
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                com.tencent.yybsdk.apkpatch.v vVarA = a(cursorRawQuery);
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                return vVarA;
                            }
                        } catch (java.lang.Exception e) {
                            e = e;
                            e.printStackTrace();
                            if (cursorRawQuery != null) {
                            }
                            return null;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return null;
    }

    @Override // com.tencent.yybsdk.apkpatch.e.b.b
    public java.lang.String a() {
        return "apkpatchtask";
    }

    @Override // com.tencent.yybsdk.apkpatch.e.b.b
    public void a(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public boolean a(com.tencent.yybsdk.apkpatch.v vVar) {
        if (vVar == null) {
            return true;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = c().getWritableDatabase();
            if (a(vVar, writableDatabase) > 0) {
                return true;
            }
            writableDatabase.insert("apkpatchtask", null, b(vVar));
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.yybsdk.apkpatch.e.b.b
    public java.lang.String[] a(int i, int i2) {
        if (i == 5 && i2 == 6) {
            return new java.lang.String[]{"ALTER TABLE apkpatchtask ADD alorithms INTEGER;", "ALTER TABLE apkpatchtask ADD process INTEGER;", "ALTER TABLE apkpatchtask ADD successInflateCount INTEGER;", "ALTER TABLE apkpatchtask ADD successDeflateCount INTEGER;", "ALTER TABLE apkpatchtask ADD bspatchNewPointer INTEGER;", "ALTER TABLE apkpatchtask ADD bspatchOldPointer INTEGER;", "ALTER TABLE apkpatchtask ADD bspatchReadedBytes INTEGER;"};
        }
        return null;
    }

    @Override // com.tencent.yybsdk.apkpatch.e.b.b
    public java.lang.String b() {
        return "CREATE TABLE if not exists apkpatchtask( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , oldApkPath TEXT, patchPath TEXT, successFileIndex INTEGER, alorithms TEXT, successFilePosition INTEGER , newApkPath TEXT, status INTEGER, updateTime INTEGER, process INTEGER, bspatchNewPointer INTEGER, bspatchOldPointer INTEGER, bspatchReadedBytes INTEGER, successInflateCount INTEGER, successDeflateCount INTEGER);";
    }

    @Override // com.tencent.yybsdk.apkpatch.e.b.b
    public void b(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public boolean b(com.tencent.yybsdk.apkpatch.u uVar) {
        if (!android.text.TextUtils.isEmpty(uVar.b) && !android.text.TextUtils.isEmpty(uVar.d.b()) && !android.text.TextUtils.isEmpty(uVar.c)) {
            try {
                c().getWritableDatabase().delete("apkpatchtask", "oldApkPath = ? and patchPath = ? and newApkPath = ? and alorithms = ?", new java.lang.String[]{uVar.b, uVar.d.b(), uVar.c, ((int) uVar.f) + ""});
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public com.tencent.yybsdk.apkpatch.e.a.b c() {
        return com.tencent.yybsdk.apkpatch.e.a.a.a(this.f1413a);
    }

    @Override // com.tencent.yybsdk.apkpatch.e.b.b
    public void d() {
    }

    public boolean e() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("status");
            sb.append(">");
            sb.append(4);
            sb.append(" or ");
            sb.append("updateTime");
            sb.append("<");
            sb.append(java.lang.System.currentTimeMillis() - 2592000000L);
            return c().getWritableDatabase().delete("apkpatchtask", sb.toString(), null) > 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
