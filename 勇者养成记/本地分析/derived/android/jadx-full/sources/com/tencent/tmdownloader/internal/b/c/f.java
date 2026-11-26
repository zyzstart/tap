package com.tencent.tmdownloader.internal.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f implements com.tencent.tmassistantbase.a.a.a {
    public static com.tencent.tmdownloader.internal.protocol.jce.DownloadNewChunkLogInfo a(android.database.Cursor cursor) {
        com.tencent.tmdownloader.internal.protocol.jce.DownloadNewChunkLogInfo downloadNewChunkLogInfo = new com.tencent.tmdownloader.internal.protocol.jce.DownloadNewChunkLogInfo();
        downloadNewChunkLogInfo.segId = cursor.getLong(cursor.getColumnIndex("_id"));
        downloadNewChunkLogInfo.taskId = cursor.getString(cursor.getColumnIndex("taskId"));
        downloadNewChunkLogInfo.downUrl = cursor.getString(cursor.getColumnIndex("downUrl"));
        downloadNewChunkLogInfo.jumpUrl = cursor.getString(cursor.getColumnIndex("jumpUrl"));
        downloadNewChunkLogInfo.finalDownloadUrl = cursor.getString(cursor.getColumnIndex("finalDownloadUrl"));
        downloadNewChunkLogInfo.contentType = cursor.getString(cursor.getColumnIndex("contentType"));
        downloadNewChunkLogInfo.networkType = cursor.getString(cursor.getColumnIndex("netType"));
        downloadNewChunkLogInfo.down_Size = cursor.getLong(cursor.getColumnIndex("down_Size"));
        downloadNewChunkLogInfo.costTime = cursor.getLong(cursor.getColumnIndex("costTime"));
        downloadNewChunkLogInfo.startTime = cursor.getLong(cursor.getColumnIndex("startTime"));
        downloadNewChunkLogInfo.endTime = cursor.getLong(cursor.getColumnIndex("endTime"));
        downloadNewChunkLogInfo.taskResult = cursor.getInt(cursor.getColumnIndex("taskResult"));
        downloadNewChunkLogInfo.result = (byte) cursor.getInt(cursor.getColumnIndex("result"));
        return downloadNewChunkLogInfo;
    }

    public static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("downloadChunkInfo", "taskId = ?", new java.lang.String[]{str});
            }
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("DownloadChunkInfoTable", "exception: ", e);
            e.printStackTrace();
        }
    }

    public static java.util.ArrayList b(java.lang.String str) {
        android.database.Cursor cursorRawQuery = null;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.sqlite.SQLiteDatabase readableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getReadableDatabase();
        if (readableDatabase != null) {
            try {
                try {
                    cursorRawQuery = readableDatabase.rawQuery("select * from downloadChunkInfo where taskId = ?", new java.lang.String[]{str});
                    if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                        do {
                            arrayList.add(a(cursorRawQuery));
                        } while (cursorRawQuery.moveToNext());
                    }
                } catch (java.lang.Exception e) {
                    com.tencent.tmassistantbase.util.TMLog.e("DownloadChunkInfoTable", "exception: ", e);
                    e.printStackTrace();
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
        return "CREATE TABLE if not exists downloadChunkInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId TEXT, downUrl TEXT, jumpUrl TEXT, finalDownloadUrl TEXT, contentType TEXT, netType TEXT, down_Size INTEGER, costTime INTEGER, startTime INTEGER, endTime INTEGER, taskResult INTEGER, result INTEGER);";
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void a(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String[] a(int i, int i2) {
        return null;
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void b(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }
}
