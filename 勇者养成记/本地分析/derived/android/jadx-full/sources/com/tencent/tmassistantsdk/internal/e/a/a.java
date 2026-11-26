package com.tencent.tmassistantsdk.internal.e.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a implements com.tencent.tmassistantbase.a.a.a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.tencent.tmassistantbase.a.c] */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v3 */
    public com.tencent.tmassistantsdk.internal.e.a.b a(int i) throws java.lang.Throwable {
        java.lang.String str;
        android.database.Cursor cursorQuery;
        com.tencent.tmassistantsdk.internal.e.a.b bVar = new com.tencent.tmassistantsdk.internal.e.a.b();
        bVar.f1075a = new java.util.ArrayList();
        bVar.b = new java.util.ArrayList();
        if (i > 0) {
            str = "0," + i;
        } else {
            str = null;
        }
        ?? B = b();
        android.database.sqlite.SQLiteDatabase readableDatabase = B.getReadableDatabase();
        try {
            if (readableDatabase != null) {
                try {
                    cursorQuery = readableDatabase.query(c(), null, null, null, null, null, "_id asc", str);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                do {
                                    bVar.f1075a.add(java.lang.Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("_id"))));
                                    bVar.b.add(cursorQuery.getBlob(cursorQuery.getColumnIndex("logData")));
                                } while (cursorQuery.moveToNext());
                            }
                        } catch (java.lang.Exception e) {
                            e = e;
                            com.tencent.tmassistantbase.util.TMLog.e("BaseLogTable", "exception: ", e);
                            e.printStackTrace();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return null;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    cursorQuery = null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    B = 0;
                    if (B != 0) {
                        B.close();
                    }
                    throw th;
                }
            }
            return bVar;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String a() {
        return d();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean a(java.util.List list) {
        android.database.sqlite.SQLiteDatabase writableDatabase = b().getWritableDatabase();
        try {
            if (writableDatabase != null) {
                try {
                    writableDatabase.beginTransaction();
                    android.database.sqlite.SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement(e());
                    java.util.Iterator it = list.iterator();
                    while (it.hasNext()) {
                        sQLiteStatementCompileStatement.bindBlob(1, (byte[]) it.next());
                        sQLiteStatementCompileStatement.executeInsert();
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    com.tencent.tmassistantbase.util.TMLog.e("BaseLogTable", "exception: ", e);
                    writableDatabase.endTransaction();
                    return false;
                }
            }
        } catch (java.lang.Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
        return true;
    }

    public synchronized boolean a(byte[] bArr) {
        android.content.ContentValues contentValues;
        contentValues = new android.content.ContentValues();
        contentValues.put("logData", bArr);
        return b().getWritableDatabase().insert(c(), null, contentValues) > 0;
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String[] a(int i, int i2) {
        return b(i2);
    }

    public com.tencent.tmassistantbase.a.c b() {
        return com.tencent.tmdownloader.internal.b.a.a.e();
    }

    public synchronized boolean b(java.util.List list) {
        if (list != null) {
            if (list.size() > 0) {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("(");
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    stringBuffer.append((java.lang.Long) it.next());
                    stringBuffer.append(",");
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                stringBuffer.append(")");
                android.database.sqlite.SQLiteDatabase writableDatabase = b().getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.delete(c(), "_id in " + ((java.lang.Object) stringBuffer), null);
                }
                return true;
            }
        }
        return false;
    }

    protected abstract java.lang.String[] b(int i);

    protected abstract java.lang.String c();

    protected abstract java.lang.String d();

    protected abstract java.lang.String e();
}
