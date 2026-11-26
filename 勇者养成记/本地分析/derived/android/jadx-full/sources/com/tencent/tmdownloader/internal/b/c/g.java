package com.tencent.tmdownloader.internal.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g implements com.tencent.tmassistantbase.a.a.a {
    private static int a(com.tencent.tmdownloader.internal.downloadservice.d dVar, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (dVar == null) {
            return -1;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            com.tencent.tmdownloader.internal.downloadservice.d.a(contentValues, dVar);
            int iUpdate = sQLiteDatabase.update("downloadInfo", contentValues, "taskUrl = ?", new java.lang.String[]{dVar.b});
            if (iUpdate > 0) {
                return iUpdate;
            }
            return 0;
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("DownloadInfoTable", "exception: ", e);
            e.printStackTrace();
            return -2;
        }
    }

    public static void a(com.tencent.tmdownloader.internal.downloadservice.d dVar) {
        if (dVar != null) {
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getWritableDatabase();
                if (writableDatabase == null || a(dVar, writableDatabase) > 0) {
                    return;
                }
                android.content.ContentValues contentValues = new android.content.ContentValues();
                com.tencent.tmdownloader.internal.downloadservice.d.a(contentValues, dVar);
                writableDatabase.insert("downloadInfo", null, contentValues);
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.e("DownloadInfoTable", "exception: ", e);
                e.printStackTrace();
            }
        }
    }

    public static void a(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("downloadInfo", "taskUrl = ?", new java.lang.String[]{str});
            }
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("DownloadInfoTable", "exception: ", e);
            e.printStackTrace();
        }
    }

    public static void a(java.util.ArrayList arrayList) {
        android.database.sqlite.SQLiteDatabase writableDatabase;
        if (arrayList == null || (writableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getWritableDatabase()) == null) {
            return;
        }
        try {
            try {
                writableDatabase.beginTransaction();
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.tmdownloader.internal.downloadservice.d dVar = (com.tencent.tmdownloader.internal.downloadservice.d) it.next();
                    if (a(dVar, writableDatabase) <= 0) {
                        android.content.ContentValues contentValues = new android.content.ContentValues();
                        com.tencent.tmdownloader.internal.downloadservice.d.a(contentValues, dVar);
                        writableDatabase.insert("downloadInfo", null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.e("DownloadInfoTable", "exception: ", e);
            }
        } finally {
            try {
                writableDatabase.endTransaction();
            } catch (java.lang.Exception e2) {
                com.tencent.tmassistantbase.util.TMLog.e("DownloadInfoTable", "exception: ", e2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0050  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.database.Cursor] */
    public static com.tencent.tmdownloader.internal.downloadservice.d b(java.lang.String str) throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase readableDatabase;
        java.lang.Throwable th;
        android.database.Cursor cursorRawQuery;
        if (str != 0 && str.length() > 0 && (readableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getReadableDatabase()) != null) {
            try {
                try {
                    cursorRawQuery = readableDatabase.rawQuery("select * from downloadInfo where taskUrl = ?", new java.lang.String[]{str});
                    if (cursorRawQuery != null) {
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                com.tencent.tmdownloader.internal.downloadservice.d dVarA = com.tencent.tmdownloader.internal.downloadservice.d.a(cursorRawQuery);
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                return dVarA;
                            }
                        } catch (java.lang.Exception e) {
                            e = e;
                            com.tencent.tmassistantbase.util.TMLog.e("DownloadInfoTable", "exception: ", e);
                            e.printStackTrace();
                            if (cursorRawQuery != null) {
                            }
                            return null;
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (str != 0) {
                        str.close();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                str = 0;
                if (str != 0) {
                    str.close();
                }
                throw th;
            }
        }
        return null;
    }

    public static java.util.ArrayList b() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.sqlite.SQLiteDatabase readableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getReadableDatabase();
        if (readableDatabase != null) {
            android.database.Cursor cursorRawQuery = null;
            try {
                try {
                    cursorRawQuery = readableDatabase.rawQuery("select * from downloadInfo", null);
                    if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                        do {
                            arrayList.add(com.tencent.tmdownloader.internal.downloadservice.d.a(cursorRawQuery));
                        } while (cursorRawQuery.moveToNext());
                    }
                } catch (java.lang.Exception e) {
                    com.tencent.tmassistantbase.util.TMLog.e("DownloadInfoTable", "exception: ", e);
                    e.printStackTrace();
                    return arrayList;
                }
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.database.Cursor] */
    public static com.tencent.tmdownloader.internal.downloadservice.d c(java.lang.String str) throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase readableDatabase;
        java.lang.Throwable th;
        android.database.Cursor cursorRawQuery;
        com.tencent.tmassistantbase.util.TMLog.i("DownloadInfoTable", "queryByPackageName: " + str);
        if (str != 0 && str.length() > 0 && (readableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getReadableDatabase()) != null) {
            try {
                try {
                    cursorRawQuery = readableDatabase.rawQuery("select * from downloadInfo where taskPakcageName = ?", new java.lang.String[]{str});
                    if (cursorRawQuery != null) {
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                com.tencent.tmdownloader.internal.downloadservice.d dVarA = com.tencent.tmdownloader.internal.downloadservice.d.a(cursorRawQuery);
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                return dVarA;
                            }
                        } catch (java.lang.Exception e) {
                            e = e;
                            com.tencent.tmassistantbase.util.TMLog.e("DownloadInfoTable", "exception: ", e);
                            e.printStackTrace();
                            if (cursorRawQuery != null) {
                            }
                            return null;
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (str != 0) {
                        str.close();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                str = 0;
                if (str != 0) {
                    str.close();
                }
                throw th;
            }
        }
        return null;
    }

    public static java.util.ArrayList c() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.sqlite.SQLiteDatabase readableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getReadableDatabase();
        if (readableDatabase != null) {
            android.database.Cursor cursorRawQuery = null;
            try {
                try {
                    cursorRawQuery = readableDatabase.rawQuery("select a.taskUrl,a.status,b.clientId from downloadInfo as a left outer join clientinfo as b on a.taskUrl = b.taskUrl where b.clientId is not null and (a.status = 2 or a.status = 1)", null);
                    if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                        do {
                            java.lang.String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("clientId"));
                            java.lang.String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("taskUrl"));
                            int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("status"));
                            com.tencent.tmdownloader.internal.downloadservice.a.b bVar = new com.tencent.tmdownloader.internal.downloadservice.a.b(string, string2);
                            bVar.c = i;
                            arrayList.add(bVar);
                        } while (cursorRawQuery.moveToNext());
                    }
                } catch (java.lang.Exception e) {
                    com.tencent.tmassistantbase.util.TMLog.e("DownloadInfoTable", "exception: ", e);
                    e.printStackTrace();
                    return arrayList;
                }
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String a() {
        return "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, bakUrl TEXT,finalUrl TEXT, fileName TEXT, contentType TEXT, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER, netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT,appId INTEGER,taskPakcageName TEXT,taskVersioncode TEXT,clientIp TEXT,startTime INTEGER,endTime INTEGER,downloadType INTEGER,uin INTEGER,uintype TEXT,via TEXT,channelId TEXT,traceId TEXT,extraData TEXT,fileSize INTEGER);";
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void a(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String[] a(int i, int i2) {
        if (i == 1 && i2 == 2) {
            return new java.lang.String[]{"alter table downloadInfo add column headerParams TEXT;"};
        }
        if (i == 2 && i2 == 3) {
            return new java.lang.String[]{"alter table downloadInfo add column appId INTEGER;", "alter table downloadInfo add column taskPakcageName TEXT;", "alter table downloadInfo add column taskVersioncode TEXT;", "alter table downloadInfo add column clientIp TEXT;", "alter table downloadInfo add column startTime INTEGER;", "alter table downloadInfo add column endTime INTEGER;", "alter table downloadInfo add column downloadType INTEGER;", "alter table downloadInfo add column uin INTEGER;", "alter table downloadInfo add column uintype TEXT;", "alter table downloadInfo add column via TEXT;", "alter table downloadInfo add column channelId TEXT;", "alter table downloadInfo add column traceId TEXT;", "alter table downloadInfo add column extraData TEXT;"};
        }
        if (i == 3 && i2 == 4) {
            return new java.lang.String[]{"alter table downloadInfo add column fileSize INTEGER;"};
        }
        if (i == 2 && i2 == 4) {
            return new java.lang.String[]{"alter table downloadInfo add column appId INTEGER;", "alter table downloadInfo add column taskPakcageName TEXT;", "alter table downloadInfo add column taskVersioncode TEXT;", "alter table downloadInfo add column clientIp TEXT;", "alter table downloadInfo add column startTime INTEGER;", "alter table downloadInfo add column endTime INTEGER;", "alter table downloadInfo add column downloadType INTEGER;", "alter table downloadInfo add column uin INTEGER;", "alter table downloadInfo add column uintype TEXT;", "alter table downloadInfo add column via TEXT;", "alter table downloadInfo add column channelId TEXT;", "alter table downloadInfo add column traceId TEXT;", "alter table downloadInfo add column extraData TEXT;", "alter table downloadInfo add column fileSize INTEGER;"};
        }
        return (i == 1 && i2 == 4) ? new java.lang.String[]{"alter table downloadInfo add column headerParams TEXT;", "alter table downloadInfo add column appId INTEGER;", "alter table downloadInfo add column taskPakcageName TEXT;", "alter table downloadInfo add column taskVersioncode TEXT;", "alter table downloadInfo add column clientIp TEXT;", "alter table downloadInfo add column startTime INTEGER;", "alter table downloadInfo add column endTime INTEGER;", "alter table downloadInfo add column downloadType INTEGER;", "alter table downloadInfo add column uin INTEGER;", "alter table downloadInfo add column uintype TEXT;", "alter table downloadInfo add column via TEXT;", "alter table downloadInfo add column channelId TEXT;", "alter table downloadInfo add column traceId TEXT;", "alter table downloadInfo add column extraData TEXT;", "alter table downloadInfo add column fileSize INTEGER;"} : new java.lang.String[]{"alter table downloadInfo add column netType TEXT;", "alter table downloadInfo add column downloadFailedErrCode INTEGER;", "alter table downloadInfo add column downloadFailedTime INTEGER;"};
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void b(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }
}
