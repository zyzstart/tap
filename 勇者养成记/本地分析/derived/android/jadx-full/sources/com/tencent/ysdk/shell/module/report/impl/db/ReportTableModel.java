package com.tencent.ysdk.shell.module.report.impl.db;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ReportTableModel extends com.tencent.ysdk.shell.framework.database.BaseTableModel {
    private static final java.lang.String COL_BLOB = "blob";
    private static final java.lang.String COL_TYPE = "type";
    protected static final int REPORT_MAX_DB_SIZE = 20;
    public static final java.lang.String TABLE_CREATE_SQL = "CREATE TABLE IF NOT EXISTS [report_cgi] ([ _id ] INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);";
    public static final java.lang.String TABLE_DROP_SQL = "DROP TABLE IF EXISTS report_cgi";
    public static final java.lang.String TABLE_NAME = "report_cgi";
    public static final java.lang.String TAG = "YSDK_ReportTableModel";
    private static final java.lang.String COL_KEY = "key";
    protected static final java.lang.String[] COLS_SIZE = {COL_KEY};

    public static synchronized void clearReportItem(java.lang.String str) {
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return;
        }
        try {
            com.tencent.ysdk.shell.module.report.impl.db.ReportDBHelper.getInstance().delete("report_cgi", "type = ?", new java.lang.String[]{str});
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x009e A[Catch: all -> 0x00a2, TRY_ENTER, TryCatch #3 {, blocks: (B:4:0x0003, B:34:0x0086, B:47:0x009e, B:48:0x00a1), top: B:54:0x0003 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized java.util.List<java.io.Serializable> getReportItemFromDB(java.lang.String str) {
        java.lang.Exception e;
        android.database.Cursor cursorQueryInfo;
        java.io.ObjectInputStream objectInputStream;
        java.lang.Throwable th;
        java.io.Serializable serializable;
        java.util.List<java.io.Serializable> listSynchronizedList = java.util.Collections.synchronizedList(new java.util.ArrayList());
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return listSynchronizedList;
        }
        try {
            try {
                com.tencent.ysdk.shell.framework.database.DBQueryParams dBQueryParams = new com.tencent.ysdk.shell.framework.database.DBQueryParams();
                dBQueryParams.setTable("report_cgi");
                dBQueryParams.setSelection("type = ?");
                dBQueryParams.setSelectionArgs(new java.lang.String[]{str});
                cursorQueryInfo = com.tencent.ysdk.shell.module.report.impl.db.ReportDBHelper.getInstance().queryInfo(dBQueryParams);
                if (cursorQueryInfo != null) {
                    try {
                        if (cursorQueryInfo.getCount() > 0) {
                            cursorQueryInfo.moveToFirst();
                            do {
                                java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(cursorQueryInfo.getBlob(cursorQueryInfo.getColumnIndex(COL_BLOB)));
                                try {
                                    objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
                                    try {
                                        serializable = (java.io.Serializable) objectInputStream.readObject();
                                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(objectInputStream);
                                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(byteArrayInputStream);
                                    } catch (java.lang.Exception unused) {
                                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(objectInputStream);
                                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(byteArrayInputStream);
                                        serializable = null;
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(objectInputStream);
                                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(byteArrayInputStream);
                                        throw th;
                                    }
                                } catch (java.lang.Exception unused2) {
                                    objectInputStream = null;
                                } catch (java.lang.Throwable th3) {
                                    objectInputStream = null;
                                    th = th3;
                                }
                                if (serializable != null) {
                                    listSynchronizedList.add(serializable);
                                }
                            } while (cursorQueryInfo.moveToNext());
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
                        if (cursorQueryInfo != null) {
                        }
                        return listSynchronizedList;
                    }
                }
                if (cursorQueryInfo != null) {
                    cursorQueryInfo.close();
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                if (str != 0) {
                    str.close();
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            cursorQueryInfo = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            str = 0;
            if (str != 0) {
                str.close();
            }
            throw th;
        }
        return listSynchronizedList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized int getReportSize(java.lang.String str) {
        int count = 0;
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return 0;
        }
        android.database.Cursor cursorQueryInfo = null;
        try {
            try {
                com.tencent.ysdk.shell.framework.database.DBQueryParams dBQueryParams = new com.tencent.ysdk.shell.framework.database.DBQueryParams();
                dBQueryParams.setTable("report_cgi");
                dBQueryParams.setColumns(COLS_SIZE);
                dBQueryParams.setSelection("type = ?");
                dBQueryParams.setSelectionArgs(new java.lang.String[]{str});
                cursorQueryInfo = com.tencent.ysdk.shell.module.report.impl.db.ReportDBHelper.getInstance().queryInfo(dBQueryParams);
                count = cursorQueryInfo != null ? cursorQueryInfo.getCount() : 0;
                if (cursorQueryInfo != null) {
                    cursorQueryInfo.close();
                }
            } catch (java.lang.Exception e) {
                com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
                if (cursorQueryInfo != null) {
                }
            }
            return count;
        } catch (java.lang.Throwable th) {
            if (cursorQueryInfo != null) {
                cursorQueryInfo.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void saveReportItemToDB(java.lang.String str, java.util.List<java.io.Serializable> list) {
        java.io.ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseCkIsEmpty = com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str);
        if (sQLiteDatabaseCkIsEmpty != 0) {
            return;
        }
        try {
            clearReportItem(str);
            sQLiteDatabaseCkIsEmpty = com.tencent.ysdk.shell.module.report.impl.db.ReportDBHelper.getInstance().getWritableDatabase();
            sQLiteDatabaseCkIsEmpty.beginTransaction();
            try {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                for (int i = 0; i < size; i++) {
                    java.io.Serializable serializable = list.get(i);
                    if (serializable != null) {
                        contentValues.put("type", str);
                        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(512);
                        java.io.ObjectOutputStream objectOutputStream2 = null;
                        try {
                            objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
                            try {
                                objectOutputStream.writeObject(serializable);
                                com.tencent.ysdk.shell.libware.file.Closer.closeStream(objectOutputStream);
                            } catch (java.io.IOException unused) {
                                com.tencent.ysdk.shell.libware.file.Closer.closeStream(objectOutputStream);
                            } catch (java.lang.Throwable th) {
                                th = th;
                                objectOutputStream2 = objectOutputStream;
                                com.tencent.ysdk.shell.libware.file.Closer.closeStream(objectOutputStream2);
                                com.tencent.ysdk.shell.libware.file.Closer.closeStream(byteArrayOutputStream);
                                throw th;
                            }
                        } catch (java.io.IOException unused2) {
                            objectOutputStream = null;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(byteArrayOutputStream);
                        contentValues.put(COL_BLOB, byteArrayOutputStream.toByteArray());
                        sQLiteDatabaseCkIsEmpty.insert("report_cgi", null, contentValues);
                    }
                    contentValues.clear();
                }
                sQLiteDatabaseCkIsEmpty.setTransactionSuccessful();
            } catch (java.lang.Exception e) {
                com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
            }
            sQLiteDatabaseCkIsEmpty.endTransaction();
        } catch (java.lang.Throwable th3) {
            sQLiteDatabaseCkIsEmpty.endTransaction();
            throw th3;
        }
    }
}
