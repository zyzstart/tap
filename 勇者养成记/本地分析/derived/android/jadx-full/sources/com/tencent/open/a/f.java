package com.tencent.open.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f extends android.database.sqlite.SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final java.lang.String[] f690a = {"key"};
    protected static com.tencent.open.a.f b;

    public f(android.content.Context context) {
        super(context, "sdk_report.db", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized com.tencent.open.a.f a() {
        if (b == null) {
            b = new com.tencent.open.a.f(com.tencent.open.utils.f.a());
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x009a A[Catch: all -> 0x00aa, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:7:0x0012, B:46:0x0082, B:56:0x009a, B:60:0x00a1, B:62:0x00a6, B:63:0x00a9, B:54:0x0095), top: B:79:0x0001 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized java.util.List a(java.lang.String str) {
        android.database.Cursor cursorQuery;
        java.lang.Throwable th;
        java.io.ObjectInputStream objectInputStream;
        java.io.Serializable serializable;
        java.util.List listSynchronizedList = java.util.Collections.synchronizedList(new java.util.ArrayList());
        if (android.text.TextUtils.isEmpty(str)) {
            return listSynchronizedList;
        }
        android.database.sqlite.SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return listSynchronizedList;
        }
        android.database.Cursor cursor = null;
        try {
            try {
                cursorQuery = readableDatabase.query("via_cgi_report", null, "type = ?", new java.lang.String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            do {
                                java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(cursorQuery.getBlob(cursorQuery.getColumnIndex("blob")));
                                try {
                                    objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
                                    try {
                                        serializable = (java.io.Serializable) objectInputStream.readObject();
                                        try {
                                            objectInputStream.close();
                                        } catch (java.io.IOException unused) {
                                        }
                                    } catch (java.lang.Exception unused2) {
                                        if (objectInputStream != null) {
                                            try {
                                                objectInputStream.close();
                                            } catch (java.io.IOException unused3) {
                                            }
                                        }
                                        serializable = null;
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        if (objectInputStream != null) {
                                            try {
                                                objectInputStream.close();
                                            } catch (java.io.IOException unused4) {
                                            }
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                            throw th;
                                        } catch (java.io.IOException unused5) {
                                            throw th;
                                        }
                                    }
                                } catch (java.lang.Exception unused6) {
                                    objectInputStream = null;
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    objectInputStream = null;
                                }
                                try {
                                    byteArrayInputStream.close();
                                } catch (java.io.IOException unused7) {
                                }
                                if (serializable != null) {
                                    listSynchronizedList.add(serializable);
                                }
                            } while (cursorQuery.moveToNext());
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        cursor = cursorQuery;
                        com.tencent.open.log.SLog.e("openSDK_LOG.ReportDatabaseHelper", "getReportItemFromDB has exception.", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (readableDatabase != null) {
                            readableDatabase.close();
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (readableDatabase != null) {
                            readableDatabase.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
            return listSynchronizedList;
        } catch (java.lang.Throwable th5) {
            th = th5;
            cursorQuery = cursor;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x008e A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #6 {, blocks: (B:3:0x0001, B:11:0x0010, B:15:0x0018, B:19:0x0023, B:45:0x007a, B:53:0x008e, B:56:0x0093, B:58:0x0098, B:59:0x009b, B:51:0x0089, B:20:0x0026, B:22:0x002e, B:24:0x0036, B:28:0x004b, B:40:0x0060, B:42:0x0065, B:34:0x0055, B:35:0x0058, B:36:0x005b, B:43:0x0071, B:44:0x0077, B:50:0x0082), top: B:76:0x0001, inners: #0 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void a(java.lang.String str, java.util.List list) {
        java.io.ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        b(str);
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        writableDatabase.beginTransaction();
        try {
            try {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                for (int i = 0; i < size; i++) {
                    java.io.Serializable serializable = (java.io.Serializable) list.get(i);
                    if (serializable != null) {
                        contentValues.put(com.tencent.open.SocialConstants.PARAM_TYPE, str);
                        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(512);
                        java.io.ObjectOutputStream objectOutputStream2 = null;
                        try {
                            try {
                                try {
                                    objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
                                    try {
                                        objectOutputStream.writeObject(serializable);
                                    } catch (java.io.IOException unused) {
                                        if (objectOutputStream != null) {
                                        }
                                        byteArrayOutputStream.close();
                                        contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                        writableDatabase.insert("via_cgi_report", null, contentValues);
                                        contentValues.clear();
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        objectOutputStream2 = objectOutputStream;
                                        if (objectOutputStream2 != null) {
                                            try {
                                                objectOutputStream2.close();
                                            } catch (java.io.IOException unused2) {
                                            }
                                        }
                                        try {
                                            byteArrayOutputStream.close();
                                            throw th;
                                        } catch (java.io.IOException unused3) {
                                            throw th;
                                        }
                                    }
                                } catch (java.io.IOException unused4) {
                                    objectOutputStream = null;
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                }
                                objectOutputStream.close();
                            } catch (java.io.IOException unused5) {
                            }
                            byteArrayOutputStream.close();
                        } catch (java.io.IOException unused6) {
                        }
                        contentValues.put("blob", byteArrayOutputStream.toByteArray());
                        writableDatabase.insert("via_cgi_report", null, contentValues);
                    }
                    contentValues.clear();
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
            } catch (java.lang.Throwable th3) {
                writableDatabase.endTransaction();
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
                throw th3;
            }
        } catch (java.lang.Exception unused7) {
            com.tencent.open.log.SLog.e("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
            writableDatabase.endTransaction();
            if (writableDatabase != null) {
                writableDatabase.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002d A[Catch: all -> 0x0038, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:7:0x0009, B:21:0x002d, B:25:0x0034, B:26:0x0037, B:13:0x0016, B:19:0x0024), top: B:32:0x0001, inners: #0 }] */
    public synchronized void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        try {
            try {
                writableDatabase.delete("via_cgi_report", "type = ?", new java.lang.String[]{str});
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e);
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        } catch (java.lang.Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }
}
