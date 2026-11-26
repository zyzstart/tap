package com.tencent.beaconselfupdate.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f223a;
    public java.lang.String b;
    public long c;
    private int d;
    private int e;
    private long f;

    public a() {
        this.f223a = -1L;
        this.d = -1;
        this.e = -1;
        this.f = -1L;
        this.b = null;
        this.c = 0L;
    }

    public a(long j, java.lang.String str, int i) {
        this.f223a = -1L;
        this.d = -1;
        this.e = -1;
        this.f = -1L;
        this.b = null;
        this.c = 0L;
        this.d = 1;
        this.e = 3;
        this.f = j;
        this.b = str;
        if (str != null) {
            this.c = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized int a(android.content.Context context, int[] iArr) {
        int iDelete;
        com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.delete() start", new java.lang.Object[0]);
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.a(" delete() context is null arg", new java.lang.Object[0]);
            return -1;
        }
        java.lang.String str = "_time >= -1 and _time <= 9223372036854775807";
        if (iArr != null && iArr.length > 0) {
            java.lang.String str2 = "";
            for (int i : iArr) {
                str2 = str2 + " or _type = " + i;
            }
            str = "_time >= -1 and _time <= 9223372036854775807 and ( " + str2.substring(4) + " )";
        }
        com.tencent.beaconselfupdate.c.a.b(" delete where: " + str, new java.lang.Object[0]);
        try {
            iDelete = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase().delete("t_event", str, null);
            com.tencent.beaconselfupdate.c.a.b(" deleted num: " + iDelete, new java.lang.Object[0]);
            com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.delete() end", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            try {
                com.tencent.beaconselfupdate.c.a.b(th.getMessage(), new java.lang.Object[0]);
                com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.delete() end", new java.lang.Object[0]);
                iDelete = -1;
            } catch (java.lang.Throwable th2) {
                com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.delete() end", new java.lang.Object[0]);
                throw th2;
            }
        }
        return iDelete;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized int a(android.content.Context context, java.lang.Long[] lArr) {
        int iDelete;
        int iDelete2;
        com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.deleteList() start!", new java.lang.Object[0]);
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d(" deleteList() have null args!", new java.lang.Object[0]);
            return -1;
        }
        if (lArr == null || lArr.length <= 0) {
            return 0;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            iDelete = 0;
            for (int i = 0; i < lArr.length; i++) {
                try {
                    stringBuffer.append(" or  _id = " + lArr[i].longValue());
                    if (i > 0 && i % 25 == 0) {
                        com.tencent.beaconselfupdate.c.a.b(" current " + i, new java.lang.Object[0]);
                        iDelete += writableDatabase.delete("t_event", stringBuffer.substring(4), null);
                        stringBuffer.setLength(0);
                        com.tencent.beaconselfupdate.c.a.b(" current deleteNum: " + iDelete, new java.lang.Object[0]);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            }
            if (stringBuffer.length() > 0) {
                iDelete2 = writableDatabase.delete("t_event", stringBuffer.substring(4), null) + iDelete;
                try {
                    stringBuffer.setLength(0);
                } catch (java.lang.Throwable th2) {
                    iDelete = iDelete2;
                    th = th2;
                    try {
                        com.tencent.beaconselfupdate.c.a.d(th.getMessage(), new java.lang.Object[0]);
                        com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.deleteList() end!", new java.lang.Object[0]);
                        iDelete2 = iDelete;
                    } catch (java.lang.Throwable th3) {
                        com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.deleteList() end!", new java.lang.Object[0]);
                        throw th3;
                    }
                }
            } else {
                iDelete2 = iDelete;
            }
            com.tencent.beaconselfupdate.c.a.a(" total deleteNum: " + iDelete2, new java.lang.Object[0]);
            com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.deleteList() end!", new java.lang.Object[0]);
        } catch (java.lang.Throwable th4) {
            th = th4;
            iDelete = 0;
        }
        return iDelete2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized java.util.List a(android.content.Context context) {
        java.lang.Throwable th;
        android.database.Cursor cursorQuery;
        java.lang.Object[] objArr;
        java.lang.String str;
        com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.queryReqData() start", new java.lang.Object[0]);
        java.util.ArrayList arrayList = null;
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d(" AnalyticsDAO.queryReqData() context null ", new java.lang.Object[0]);
            return null;
        }
        try {
            cursorQuery = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase().query("t_req_data", null, null, null, null, null, "_time DESC ", "1");
            try {
                try {
                    if (cursorQuery.moveToNext()) {
                        java.util.ArrayList arrayList2 = new java.util.ArrayList();
                        try {
                            arrayList2.add(java.lang.Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                            arrayList2.add(cursorQuery.getString(cursorQuery.getColumnIndex("_rid")));
                            arrayList2.add(java.lang.Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("_time"))));
                            arrayList2.add(cursorQuery.getBlob(cursorQuery.getColumnIndex("_datas")));
                            arrayList2.add(java.lang.Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_cnt"))));
                            arrayList = arrayList2;
                        } catch (java.lang.Exception unused) {
                            arrayList = arrayList2;
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                            objArr = new java.lang.Object[0];
                            str = " AnalyticsDAO.queryReqData() end";
                        }
                    }
                    if (arrayList != null) {
                        com.tencent.beaconselfupdate.c.a.a("queryReqData: 1", new java.lang.Object[0]);
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    objArr = new java.lang.Object[0];
                    str = " AnalyticsDAO.queryReqData() end";
                } catch (java.lang.Exception unused2) {
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.queryReqData() end", new java.lang.Object[0]);
                throw th;
            }
        } catch (java.lang.Exception unused3) {
            cursorQuery = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
        com.tencent.beaconselfupdate.c.a.b(str, objArr);
        return arrayList;
    }

    public static synchronized java.util.List a(android.content.Context context, int[] iArr, int i) {
        return b(context, iArr, i);
    }

    private static java.util.List a(android.database.Cursor cursor) {
        com.tencent.beaconselfupdate.c.a.b(" in AnalyticsDAO.paserCursor() start", new java.lang.Object[0]);
        if (cursor == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("_prority");
        int columnIndex3 = cursor.getColumnIndex("_time");
        int columnIndex4 = cursor.getColumnIndex("_type");
        int columnIndex5 = cursor.getColumnIndex("_datas");
        int columnIndex6 = cursor.getColumnIndex("_length");
        while (cursor.moveToNext()) {
            com.tencent.beaconselfupdate.a.a.a aVar = new com.tencent.beaconselfupdate.a.a.a();
            aVar.f223a = cursor.getLong(columnIndex);
            aVar.b = cursor.getString(columnIndex5);
            aVar.e = cursor.getInt(columnIndex2);
            aVar.f = cursor.getLong(columnIndex3);
            aVar.d = cursor.getInt(columnIndex4);
            aVar.c = cursor.getLong(columnIndex6);
            arrayList.add(aVar);
        }
        com.tencent.beaconselfupdate.c.a.b(" in AnalyticsDAO.paserCursor() end", new java.lang.Object[0]);
        return arrayList;
    }

    public static synchronized boolean a(android.content.Context context, java.lang.String str) {
        boolean z;
        com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.deleteReqData() start", new java.lang.Object[0]);
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.a(" delete() context is null arg", new java.lang.Object[0]);
            return false;
        }
        if (str != null && !str.trim().equals("")) {
            java.lang.String str2 = "_rid = '" + str + "' ";
            com.tencent.beaconselfupdate.c.a.b(" delete where: " + str2, new java.lang.Object[0]);
            try {
                int iDelete = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase().delete("t_req_data", str2, null);
                com.tencent.beaconselfupdate.c.a.b(" deleted num: " + iDelete, new java.lang.Object[0]);
                z = iDelete == 1;
                com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.deleteReqData() end", new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                try {
                    com.tencent.beaconselfupdate.c.a.b(th.getMessage(), new java.lang.Object[0]);
                    com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.deleteReqData() end", new java.lang.Object[0]);
                    z = false;
                } catch (java.lang.Throwable th2) {
                    com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.deleteReqData() end", new java.lang.Object[0]);
                    throw th2;
                }
            }
            return z;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized boolean a(android.content.Context context, java.util.List list) {
        boolean z = false;
        com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.insert() start", new java.lang.Object[0]);
        if (context != null && list != null) {
            if (list.size() <= 0) {
                com.tencent.beaconselfupdate.c.a.b(" list size == 0 return true", new java.lang.Object[0]);
                return true;
            }
            android.database.sqlite.SQLiteDatabase writableDatabase = null;
            try {
                writableDatabase = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (int i = 0; i < list.size(); i++) {
                    com.tencent.beaconselfupdate.a.a.a aVar = (com.tencent.beaconselfupdate.a.a.a) list.get(i);
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    if (aVar.f223a > 0) {
                        contentValues.put("_id", java.lang.Long.valueOf(aVar.f223a));
                    }
                    contentValues.put("_prority", java.lang.Integer.valueOf(aVar.e));
                    contentValues.put("_time", java.lang.Long.valueOf(aVar.f));
                    contentValues.put("_type", java.lang.Integer.valueOf(aVar.d));
                    contentValues.put("_datas", aVar.b);
                    contentValues.put("_length", java.lang.Long.valueOf(aVar.c));
                    long jInsert = writableDatabase.insert("t_event", "_id", contentValues);
                    if (jInsert < 0) {
                        com.tencent.beaconselfupdate.c.a.d(" AnalyticsDAO.insert() failure! return", new java.lang.Object[0]);
                    }
                    aVar.f223a = jInsert;
                }
                writableDatabase.setTransactionSuccessful();
                try {
                    writableDatabase.endTransaction();
                } catch (java.lang.Exception unused) {
                    com.tencent.beaconselfupdate.c.a.b("AnalyticsDao db.endTransaction() error.", new java.lang.Object[0]);
                }
                com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.insert() end", new java.lang.Object[0]);
                z = true;
            } catch (java.lang.Throwable unused2) {
                try {
                    com.tencent.beaconselfupdate.c.a.b("AnalyticsDAO.insert() failure!", new java.lang.Object[0]);
                    try {
                        writableDatabase.endTransaction();
                    } catch (java.lang.Exception unused3) {
                        com.tencent.beaconselfupdate.c.a.b("AnalyticsDao db.endTransaction() error.", new java.lang.Object[0]);
                    }
                    com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.insert() end", new java.lang.Object[0]);
                } catch (java.lang.Throwable th) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (java.lang.Exception unused4) {
                        com.tencent.beaconselfupdate.c.a.b("AnalyticsDao db.endTransaction() error.", new java.lang.Object[0]);
                    }
                    com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.insert() end", new java.lang.Object[0]);
                    throw th;
                }
            }
            return z;
        }
        com.tencent.beaconselfupdate.c.a.d(" AnalyticsDAO.insert() have null args", new java.lang.Object[0]);
        return false;
    }

    public static synchronized boolean a(android.content.Context context, byte[] bArr, java.lang.String str, int i) {
        boolean z;
        com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.insertReqData() start", new java.lang.Object[0]);
        if (context == null || bArr == null || str == null) {
            com.tencent.beaconselfupdate.c.a.d(" AnalyticsDAO.insertReqData() have null args", new java.lang.Object[0]);
            return false;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("_rid", str);
            contentValues.put("_time", java.lang.Long.valueOf(new java.util.Date().getTime()));
            contentValues.put("_cnt", java.lang.Integer.valueOf(i));
            contentValues.put("_datas", bArr);
            if (writableDatabase.insert("t_req_data", null, contentValues) < 0) {
                com.tencent.beaconselfupdate.c.a.d(" AnalyticsDAO.insertReqData() failure! return", new java.lang.Object[0]);
                z = false;
            } else {
                z = true;
            }
            com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.insertReqData() end", new java.lang.Object[0]);
        } catch (java.lang.Throwable unused) {
            try {
                com.tencent.beaconselfupdate.c.a.b("AnalyticsDAO.insertReqData() failure!", new java.lang.Object[0]);
                com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.insertReqData() end", new java.lang.Object[0]);
                z = false;
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.insertReqData() end", new java.lang.Object[0]);
                throw th;
            }
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized int b(android.content.Context context, int[] iArr) {
        int i;
        com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.querySum() start", new java.lang.Object[0]);
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.a(" querySum() context is null arg", new java.lang.Object[0]);
            return -1;
        }
        java.lang.String str = "_time >= -1 and _time <= 9223372036854775807";
        if (iArr != null && iArr.length > 0) {
            java.lang.String str2 = "";
            for (int i2 : iArr) {
                str2 = str2 + " or _type = " + i2;
            }
            str = "_time >= -1 and _time <= 9223372036854775807 and ( " + str2.substring(4) + " )";
        }
        java.lang.String str3 = str;
        com.tencent.beaconselfupdate.c.a.b(" query where: " + str3, new java.lang.Object[0]);
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase().query("t_event", new java.lang.String[]{"count(*) as sum"}, str3, null, null, null, null);
            cursorQuery.moveToNext();
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("sum"));
            com.tencent.beaconselfupdate.c.a.b(" query sum: " + i, new java.lang.Object[0]);
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.querySum() end", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            try {
                com.tencent.beaconselfupdate.c.a.b(th.getMessage(), new java.lang.Object[0]);
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.querySum() end", new java.lang.Object[0]);
                i = -1;
            } catch (java.lang.Throwable th2) {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                com.tencent.beaconselfupdate.c.a.b(" AnalyticsDAO.querySum() end", new java.lang.Object[0]);
                throw th2;
            }
        }
        return i;
    }

    private static synchronized java.util.List b(android.content.Context context, int[] iArr, int i) {
        return c(context, iArr, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized java.util.List c(android.content.Context context, int[] iArr, int i) {
        java.lang.Throwable th;
        android.database.Cursor cursorQuery;
        java.lang.Object[] objArr;
        java.lang.String str;
        com.tencent.beaconselfupdate.c.a.b(" in AnalyticsDAO.query() start", new java.lang.Object[0]);
        java.util.List listA = null;
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d(" query() args context == null || timeStart > timeEnd || miniCount > maxCount || miniUploadCount > maxUploadCount ,pls check", new java.lang.Object[0]);
            return null;
        }
        java.lang.String str2 = "";
        if (iArr != null && iArr.length > 0) {
            java.lang.String str3 = "";
            for (int i2 : iArr) {
                str3 = str3 + " or _type = " + i2;
            }
            str2 = "" + str3.substring(4);
        }
        java.lang.String str4 = str2.length() > 0 ? " ( " + str2 + " ) " : "";
        java.lang.String strSubstring = ("_prority ASC , ") + "_time DESC ";
        if (strSubstring.endsWith(" , ")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 3);
        }
        java.lang.String str5 = strSubstring;
        com.tencent.beaconselfupdate.c.a.b(" query:%s", str4);
        try {
            cursorQuery = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase().query("t_event", null, str4, null, null, null, str5, i >= 0 ? java.lang.String.valueOf(i) : null);
            try {
                com.tencent.beaconselfupdate.c.a.a("result num: " + cursorQuery.getCount(), new java.lang.Object[0]);
                listA = cursorQuery.getCount() > 0 ? a(cursorQuery) : null;
                if (listA != null) {
                    com.tencent.beaconselfupdate.c.a.a(" total num: " + listA.size(), new java.lang.Object[0]);
                }
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                objArr = new java.lang.Object[0];
                str = " in AnalyticsDAO.query() end";
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    com.tencent.beaconselfupdate.c.a.b(th.getMessage(), new java.lang.Object[0]);
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    objArr = new java.lang.Object[0];
                    str = " in AnalyticsDAO.query() end";
                } catch (java.lang.Throwable th3) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    com.tencent.beaconselfupdate.c.a.b(" in AnalyticsDAO.query() end", new java.lang.Object[0]);
                    throw th3;
                }
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            cursorQuery = null;
        }
        com.tencent.beaconselfupdate.c.a.b(str, objArr);
        return listA;
    }
}
