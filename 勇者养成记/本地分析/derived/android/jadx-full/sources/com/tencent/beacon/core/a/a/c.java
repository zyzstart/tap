package com.tencent.beacon.core.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    public static boolean a(android.content.Context context, java.lang.String str, java.lang.Object[] objArr) {
        java.lang.String strA = com.tencent.beacon.core.info.b.b(context).a();
        synchronized (com.tencent.beacon.core.a.a.e.a(strA)) {
            boolean z = false;
            if (context != null && str != null && objArr != null) {
                if (objArr.length != 0) {
                    try {
                        android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beacon.core.a.a.e.a(context, strA).getWritableDatabase();
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("_key = '");
                        sb.append(str);
                        sb.append("'");
                        writableDatabase.delete("t_conf", sb.toString(), null);
                        android.content.ContentValues contentValues = new android.content.ContentValues();
                        contentValues.put("_key", str);
                        contentValues.put("_value", (java.lang.String) objArr[0]);
                        contentValues.put("_vdate", (java.lang.Long) objArr[1]);
                        contentValues.put("_time", java.lang.Long.valueOf(new java.util.Date().getTime()));
                        long jInsert = writableDatabase.insert("t_conf", null, contentValues);
                        if (jInsert < 0) {
                            com.tencent.beacon.core.d.i iVarA = com.tencent.beacon.core.d.i.a(context);
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            sb2.append("TB: t_conf insert fail! cid: ");
                            sb2.append(jInsert);
                            iVarA.a("503", sb2.toString());
                            com.tencent.beacon.core.e.d.b("[db] insertOrUpdateByKey failure! return false!", new java.lang.Object[0]);
                        } else {
                            z = true;
                        }
                    } catch (java.lang.Exception unused) {
                    }
                    return z;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static java.lang.Object[] a(android.content.Context context, java.lang.String str) {
        android.database.Cursor cursorQuery;
        ?? A = com.tencent.beacon.core.info.b.b(context).a();
        synchronized (com.tencent.beacon.core.a.a.e.a((java.lang.String) A)) {
            try {
                if (context == null) {
                    com.tencent.beacon.core.e.d.b("[db] context == null ", new java.lang.Object[0]);
                    return null;
                }
                try {
                    if (str == null) {
                        com.tencent.beacon.core.e.d.b("[db] key == null ", new java.lang.Object[0]);
                        return null;
                    }
                    try {
                        android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beacon.core.a.a.e.a(context, A).getWritableDatabase();
                        if (writableDatabase == null) {
                            com.tencent.beacon.core.e.d.b("[db] getWritableDatabase fail! ", new java.lang.Object[0]);
                            return null;
                        }
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("_key = '");
                        sb.append(str);
                        sb.append("'");
                        cursorQuery = writableDatabase.query("t_conf", null, sb.toString(), null, null, null, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.moveToNext()) {
                                    java.lang.Object[] objArr = new java.lang.Object[3];
                                    objArr[0] = str;
                                    objArr[1] = cursorQuery.getString(cursorQuery.getColumnIndex("_value"));
                                    objArr[2] = java.lang.Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("_vdate")));
                                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                                        cursorQuery.close();
                                    }
                                    return objArr;
                                }
                            } catch (java.lang.Exception e) {
                                e = e;
                                com.tencent.beacon.core.d.i.a(context).a("503", "TB: t_conf query fail! ", e);
                                if (cursorQuery != null && !cursorQuery.isClosed()) {
                                }
                                return null;
                            }
                        }
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        return null;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        cursorQuery = null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        A = 0;
                        if (A != 0 && !A.isClosed()) {
                            A.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Throwable th3) {
                throw th3;
            }
        }
    }
}
