package com.tencent.beacon.core.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized int a(android.content.Context context, java.lang.String str, int[] iArr, long j, long j2) {
        int iDelete;
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[db] delete context is null arg", new java.lang.Object[0]);
            return -1;
        }
        if (j > j2) {
            return 0;
        }
        java.lang.String str2 = "_time >= " + j + " and _time <= " + j2;
        if (iArr != null && iArr.length > 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i : iArr) {
                sb.append(" or _type = ");
                sb.append(i);
            }
            str2 = str2 + " and ( " + new java.lang.StringBuilder(sb.substring(4)).toString() + " )";
        }
        com.tencent.beacon.core.e.d.a("[db] delete where: " + str2, new java.lang.Object[0]);
        try {
            iDelete = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase().delete("t_event", str2, null);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("[db] deleted num: ");
            sb2.append(iDelete);
            com.tencent.beacon.core.e.d.a(sb2.toString(), new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a("[db] delete end", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            try {
                com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_event delete fail!", th);
                com.tencent.beacon.core.e.d.a(th.getMessage(), new java.lang.Object[0]);
                com.tencent.beacon.core.e.d.a("[db] delete end", new java.lang.Object[0]);
                iDelete = -1;
            } catch (java.lang.Throwable th2) {
                com.tencent.beacon.core.e.d.a("[db] delete end", new java.lang.Object[0]);
                throw th2;
            }
        }
        return iDelete;
    }

    public static synchronized int a(android.content.Context context, java.lang.String str, java.lang.Long[] lArr) {
        int iDelete;
        int iDelete2;
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[db] deleteList have null args!", new java.lang.Object[0]);
            return -1;
        }
        if (lArr == null || lArr.length <= 0) {
            return 0;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            iDelete = 0;
            for (int i = 0; i < lArr.length; i++) {
                try {
                    long jLongValue = lArr[i].longValue();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(" or  _id = ");
                    sb.append(jLongValue);
                    stringBuffer.append(sb.toString());
                    if (i > 0 && i % 25 == 0) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("[db] current position: ");
                        sb2.append(i);
                        com.tencent.beacon.core.e.d.a(sb2.toString(), new java.lang.Object[0]);
                        iDelete += writableDatabase.delete("t_event", stringBuffer.substring(4), null);
                        stringBuffer.setLength(0);
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("[db] current deleteNum: ");
                        sb3.append(iDelete);
                        com.tencent.beacon.core.e.d.a(sb3.toString(), new java.lang.Object[0]);
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
                        com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_event deleteList fail!", th);
                        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                        sb4.append("[db] ");
                        sb4.append(th.getMessage());
                        com.tencent.beacon.core.e.d.b(sb4.toString(), new java.lang.Object[0]);
                        com.tencent.beacon.core.e.d.a("[db] deleteList end!", new java.lang.Object[0]);
                        iDelete2 = iDelete;
                    } catch (java.lang.Throwable th3) {
                        com.tencent.beacon.core.e.d.a("[db] deleteList end!", new java.lang.Object[0]);
                        throw th3;
                    }
                }
            } else {
                iDelete2 = iDelete;
            }
            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
            sb5.append("[db] total deleteNum: ");
            sb5.append(iDelete2);
            com.tencent.beacon.core.e.d.d(sb5.toString(), new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a("[db] deleteList end!", new java.lang.Object[0]);
        } catch (java.lang.Throwable th4) {
            th = th4;
            iDelete = 0;
        }
        return iDelete2;
    }

    public static android.content.ContentValues a(com.tencent.beacon.core.a.a.a aVar) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        long j = aVar.f126a;
        if (j > 0) {
            contentValues.put("_id", java.lang.Long.valueOf(j));
        }
        contentValues.put("_prority", java.lang.Integer.valueOf(aVar.c));
        contentValues.put("_time", java.lang.Long.valueOf(aVar.d));
        contentValues.put("_type", java.lang.Integer.valueOf(aVar.b));
        contentValues.put("_datas", aVar.e);
        contentValues.put("_length", java.lang.Long.valueOf(aVar.f));
        return contentValues;
    }

    public static synchronized java.util.List a(android.content.Context context, java.lang.String str) {
        android.database.Cursor cursorQuery;
        android.database.Cursor cursor;
        java.util.ArrayList arrayList;
        android.database.Cursor cursor2 = null;
        java.util.ArrayList arrayList2 = null;
        try {
            if (context == null) {
                com.tencent.beacon.core.e.d.b("[db] queryReqData context null ", new java.lang.Object[0]);
                return null;
            }
            try {
                try {
                    cursorQuery = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase().query("t_req_data", null, null, null, null, null, "_time DESC ", "1");
                    try {
                        try {
                            if (cursorQuery.moveToNext()) {
                                arrayList = new java.util.ArrayList();
                                try {
                                    arrayList.add(java.lang.Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                                    arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("_rid")));
                                    arrayList.add(java.lang.Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("_time"))));
                                    arrayList.add(cursorQuery.getBlob(cursorQuery.getColumnIndex("_datas")));
                                    arrayList.add(java.lang.Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_cnt"))));
                                    com.tencent.beacon.core.e.d.d("[db] queryReqData get +1", new java.lang.Object[0]);
                                    arrayList2 = arrayList;
                                } catch (java.lang.Exception e) {
                                    cursor2 = cursorQuery;
                                    e = e;
                                    com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_req_data query fail!", e);
                                    if (cursor2 != null && !cursor2.isClosed()) {
                                        cursor2.close();
                                    }
                                    com.tencent.beacon.core.e.d.a("[db] queryReqData end", new java.lang.Object[0]);
                                    arrayList2 = arrayList;
                                }
                            }
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                            com.tencent.beacon.core.e.d.a("[db] queryReqData end", new java.lang.Object[0]);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                            com.tencent.beacon.core.e.d.a("[db] queryReqData end", new java.lang.Object[0]);
                            throw th;
                        }
                    } catch (java.lang.Exception e2) {
                        cursor = cursorQuery;
                        e = e2;
                        android.database.Cursor cursor3 = cursor;
                        arrayList = null;
                        cursor2 = cursor3;
                        com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_req_data query fail!", e);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        com.tencent.beacon.core.e.d.a("[db] queryReqData end", new java.lang.Object[0]);
                        arrayList2 = arrayList;
                        return arrayList2;
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    cursor = null;
                }
                return arrayList2;
            } catch (java.lang.Throwable th2) {
                th = th2;
                cursorQuery = cursor2;
            }
        } catch (java.lang.Throwable th3) {
            throw th3;
        }
    }

    public static synchronized java.util.List a(android.content.Context context, java.lang.String str, int[] iArr, int i, int i2, int i3) {
        return a(context, str, iArr, i, i2, i3, -1, -1, -1, -1, -1L, -1L);
    }

    public static synchronized java.util.List a(android.content.Context context, java.lang.String str, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2) {
        return a(context, str, iArr, i, i2, i3, i4, i5, i6, i7, j, j2, -1);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x01af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x010a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x010c  */
    /* JADX WARN: Code duplicated, block: B:51:0x010d A[Catch: all -> 0x022f, TryCatch #4 {, blocks: (B:18:0x0031, B:20:0x0034, B:22:0x003d, B:23:0x004c, B:24:0x0060, B:26:0x0066, B:30:0x0085, B:34:0x0098, B:36:0x00b3, B:40:0x00c6, B:54:0x012d, B:56:0x0135, B:58:0x0143, B:83:0x01cf, B:85:0x01d5, B:86:0x01d8, B:87:0x01dd, B:97:0x01fe, B:99:0x0204, B:100:0x0207, B:106:0x0212, B:108:0x0218, B:109:0x021b, B:110:0x0223, B:51:0x010d, B:52:0x011a, B:53:0x011f, B:45:0x00e8, B:46:0x00f5, B:47:0x00fa, B:111:0x0224, B:93:0x01e7, B:95:0x01ef), top: B:127:0x0013, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x011f A[Catch: all -> 0x022f, TryCatch #4 {, blocks: (B:18:0x0031, B:20:0x0034, B:22:0x003d, B:23:0x004c, B:24:0x0060, B:26:0x0066, B:30:0x0085, B:34:0x0098, B:36:0x00b3, B:40:0x00c6, B:54:0x012d, B:56:0x0135, B:58:0x0143, B:83:0x01cf, B:85:0x01d5, B:86:0x01d8, B:87:0x01dd, B:97:0x01fe, B:99:0x0204, B:100:0x0207, B:106:0x0212, B:108:0x0218, B:109:0x021b, B:110:0x0223, B:51:0x010d, B:52:0x011a, B:53:0x011f, B:45:0x00e8, B:46:0x00f5, B:47:0x00fa, B:111:0x0224, B:93:0x01e7, B:95:0x01ef), top: B:127:0x0013, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0135 A[Catch: all -> 0x022f, TryCatch #4 {, blocks: (B:18:0x0031, B:20:0x0034, B:22:0x003d, B:23:0x004c, B:24:0x0060, B:26:0x0066, B:30:0x0085, B:34:0x0098, B:36:0x00b3, B:40:0x00c6, B:54:0x012d, B:56:0x0135, B:58:0x0143, B:83:0x01cf, B:85:0x01d5, B:86:0x01d8, B:87:0x01dd, B:97:0x01fe, B:99:0x0204, B:100:0x0207, B:106:0x0212, B:108:0x0218, B:109:0x021b, B:110:0x0223, B:51:0x010d, B:52:0x011a, B:53:0x011f, B:45:0x00e8, B:46:0x00f5, B:47:0x00fa, B:111:0x0224, B:93:0x01e7, B:95:0x01ef), top: B:127:0x0013, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0141  */
    /* JADX WARN: Code duplicated, block: B:63:0x015c A[Catch: all -> 0x01e4, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x01e4, blocks: (B:59:0x014c, B:63:0x015c, B:65:0x0163, B:67:0x016f), top: B:121:0x014c }] */
    /* JADX WARN: Code duplicated, block: B:66:0x016e  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a6 A[Catch: all -> 0x01e1, TRY_LEAVE, TryCatch #0 {all -> 0x01e1, blocks: (B:68:0x0185, B:70:0x018c, B:72:0x01a6), top: B:119:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:83:0x01cf A[Catch: all -> 0x022f, TRY_ENTER, TryCatch #4 {, blocks: (B:18:0x0031, B:20:0x0034, B:22:0x003d, B:23:0x004c, B:24:0x0060, B:26:0x0066, B:30:0x0085, B:34:0x0098, B:36:0x00b3, B:40:0x00c6, B:54:0x012d, B:56:0x0135, B:58:0x0143, B:83:0x01cf, B:85:0x01d5, B:86:0x01d8, B:87:0x01dd, B:97:0x01fe, B:99:0x0204, B:100:0x0207, B:106:0x0212, B:108:0x0218, B:109:0x021b, B:110:0x0223, B:51:0x010d, B:52:0x011a, B:53:0x011f, B:45:0x00e8, B:46:0x00f5, B:47:0x00fa, B:111:0x0224, B:93:0x01e7, B:95:0x01ef), top: B:127:0x0013, inners: #3 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized java.util.List a(android.content.Context context, java.lang.String str, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2, int i8) {
        java.lang.StringBuilder sb;
        java.lang.StringBuilder sb2;
        char c;
        java.lang.String strSubstring;
        java.util.List listA;
        android.database.Cursor cursorQuery;
        java.lang.Object[] objArr;
        java.lang.String str2;
        java.lang.String string;
        if (context == null || ((j2 > 0 && j > j2) || ((i5 > 0 && i4 > i5) || (i7 > 0 && i6 > i7)))) {
            com.tencent.beacon.core.e.d.b("[db] query args context == null || timeStart > timeEnd || miniCount > maxCount || miniUploadCount > maxUploadCount ,pls check", new java.lang.Object[0]);
            return null;
        }
        java.lang.String str3 = "";
        if (iArr != null && iArr.length > 0) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            for (int i9 : iArr) {
                sb3.append(" or _type = ");
                sb3.append(i9);
            }
            str3 = "" + sb3.substring(4);
        }
        java.lang.String string2 = str3.length() > 0 ? " ( " + str3 + " ) " : "";
        if (j >= 0) {
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append(string2);
            sb4.append(string2.length() > 0 ? " and " : "");
            sb4.append("_time");
            sb4.append(" >= ");
            sb4.append(j);
            sb4.append(" ");
            string2 = sb4.toString();
        }
        if (j2 >= 0) {
            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
            sb5.append(string2);
            sb5.append(string2.length() > 0 ? " and " : "");
            sb5.append("_time");
            sb5.append(" <= ");
            sb5.append(j2);
            sb5.append(" ");
            string2 = sb5.toString();
        }
        java.lang.String string3 = "";
        try {
            try {
                if (i != 1) {
                    if (i == 2) {
                        sb = new java.lang.StringBuilder();
                        sb.append("");
                        sb.append("_prority DESC , ");
                    }
                    if (i2 != 1) {
                        if (i2 != 2) {
                            sb2 = new java.lang.StringBuilder();
                            sb2.append(string3);
                            sb2.append("_time DESC ");
                        }
                        if (string3.endsWith(" , ")) {
                            c = 0;
                            strSubstring = string3.substring(0, string3.length() - 3);
                        } else {
                            c = 0;
                            strSubstring = string3;
                        }
                        java.lang.Object[] objArr2 = new java.lang.Object[1];
                        objArr2[c] = string2;
                        com.tencent.beacon.core.e.d.a("[db] where:%s", objArr2);
                        android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase();
                        if (i3 >= 0) {
                            java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                            sb6.append("");
                            sb6.append(i3);
                            string = sb6.toString();
                        } else {
                            string = null;
                        }
                        cursorQuery = writableDatabase.query("t_event", null, string2, null, null, null, strSubstring, string);
                        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                        sb7.append("[db] result num: ");
                        sb7.append(cursorQuery.getCount());
                        com.tencent.beacon.core.e.d.a(sb7.toString(), new java.lang.Object[0]);
                        if (cursorQuery.getCount() >= 1) {
                            listA = a(cursorQuery);
                        } else {
                            listA = null;
                        }
                        if (listA != null) {
                            try {
                                java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                                sb8.append("[db] total num: ");
                                sb8.append(listA.size());
                                com.tencent.beacon.core.e.d.a(sb8.toString(), new java.lang.Object[0]);
                            } catch (java.lang.Throwable th) {
                                th = th;
                                try {
                                    com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_event query fail!", th);
                                    com.tencent.beacon.core.e.d.b(th.getMessage(), new java.lang.Object[0]);
                                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                                        cursorQuery.close();
                                    }
                                    objArr = new java.lang.Object[0];
                                    str2 = "[db] in query end";
                                } catch (java.lang.Throwable th2) {
                                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                                        cursorQuery.close();
                                    }
                                    com.tencent.beacon.core.e.d.a("[db] in query end", new java.lang.Object[0]);
                                    throw th2;
                                }
                            }
                        }
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        objArr = new java.lang.Object[0];
                        str2 = "[db] in query end";
                        com.tencent.beacon.core.e.d.a(str2, objArr);
                        return listA;
                    }
                    sb2 = new java.lang.StringBuilder();
                    sb2.append(string3);
                    sb2.append("_time ASC ");
                    string3 = sb2.toString();
                    if (string3.endsWith(" , ")) {
                        c = 0;
                        strSubstring = string3.substring(0, string3.length() - 3);
                    } else {
                        c = 0;
                        strSubstring = string3;
                    }
                    java.lang.Object[] objArr3 = new java.lang.Object[1];
                    objArr3[c] = string2;
                    com.tencent.beacon.core.e.d.a("[db] where:%s", objArr3);
                    android.database.sqlite.SQLiteDatabase writableDatabase2 = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase();
                    if (i3 >= 0) {
                        java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
                        sb9.append("");
                        sb9.append(i3);
                        string = sb9.toString();
                    } else {
                        string = null;
                    }
                    cursorQuery = writableDatabase2.query("t_event", null, string2, null, null, null, strSubstring, string);
                    java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
                    sb10.append("[db] result num: ");
                    sb10.append(cursorQuery.getCount());
                    com.tencent.beacon.core.e.d.a(sb10.toString(), new java.lang.Object[0]);
                    if (cursorQuery.getCount() >= 1) {
                        listA = a(cursorQuery);
                    } else {
                        listA = null;
                    }
                    if (listA != null) {
                        java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
                        sb11.append("[db] total num: ");
                        sb11.append(listA.size());
                        com.tencent.beacon.core.e.d.a(sb11.toString(), new java.lang.Object[0]);
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    objArr = new java.lang.Object[0];
                    str2 = "[db] in query end";
                    com.tencent.beacon.core.e.d.a(str2, objArr);
                    return listA;
                }
                sb = new java.lang.StringBuilder();
                sb.append("");
                sb.append("_prority ASC , ");
                if (i2 != 1) {
                    if (i2 != 2) {
                        sb2 = new java.lang.StringBuilder();
                        sb2.append(string3);
                        sb2.append("_time DESC ");
                    }
                    if (string3.endsWith(" , ")) {
                        c = 0;
                        strSubstring = string3.substring(0, string3.length() - 3);
                    } else {
                        c = 0;
                        strSubstring = string3;
                    }
                    java.lang.Object[] objArr4 = new java.lang.Object[1];
                    objArr4[c] = string2;
                    com.tencent.beacon.core.e.d.a("[db] where:%s", objArr4);
                    android.database.sqlite.SQLiteDatabase writableDatabase3 = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase();
                    if (i3 >= 0) {
                        java.lang.StringBuilder sb12 = new java.lang.StringBuilder();
                        sb12.append("");
                        sb12.append(i3);
                        string = sb12.toString();
                    } else {
                        string = null;
                    }
                    cursorQuery = writableDatabase3.query("t_event", null, string2, null, null, null, strSubstring, string);
                    java.lang.StringBuilder sb13 = new java.lang.StringBuilder();
                    sb13.append("[db] result num: ");
                    sb13.append(cursorQuery.getCount());
                    com.tencent.beacon.core.e.d.a(sb13.toString(), new java.lang.Object[0]);
                    if (cursorQuery.getCount() >= 1) {
                        listA = a(cursorQuery);
                    } else {
                        listA = null;
                    }
                    if (listA != null) {
                        java.lang.StringBuilder sb14 = new java.lang.StringBuilder();
                        sb14.append("[db] total num: ");
                        sb14.append(listA.size());
                        com.tencent.beacon.core.e.d.a(sb14.toString(), new java.lang.Object[0]);
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    objArr = new java.lang.Object[0];
                    str2 = "[db] in query end";
                    com.tencent.beacon.core.e.d.a(str2, objArr);
                    return listA;
                }
                sb2 = new java.lang.StringBuilder();
                sb2.append(string3);
                sb2.append("_time ASC ");
                java.lang.StringBuilder sb15 = new java.lang.StringBuilder();
                sb15.append("[db] result num: ");
                sb15.append(cursorQuery.getCount());
                com.tencent.beacon.core.e.d.a(sb15.toString(), new java.lang.Object[0]);
                if (cursorQuery.getCount() >= 1) {
                    listA = a(cursorQuery);
                } else {
                    listA = null;
                }
                if (listA != null) {
                    java.lang.StringBuilder sb16 = new java.lang.StringBuilder();
                    sb16.append("[db] total num: ");
                    sb16.append(listA.size());
                    com.tencent.beacon.core.e.d.a(sb16.toString(), new java.lang.Object[0]);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                objArr = new java.lang.Object[0];
                str2 = "[db] in query end";
            } catch (java.lang.Throwable th3) {
                th = th3;
                listA = null;
            }
            android.database.sqlite.SQLiteDatabase writableDatabase4 = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase();
            if (i3 >= 0) {
                java.lang.StringBuilder sb17 = new java.lang.StringBuilder();
                sb17.append("");
                sb17.append(i3);
                string = sb17.toString();
            } else {
                string = null;
            }
            cursorQuery = writableDatabase4.query("t_event", null, string2, null, null, null, strSubstring, string);
        } catch (java.lang.Throwable th4) {
            th = th4;
            listA = null;
            cursorQuery = null;
        }
        string3 = sb.toString();
        string3 = sb2.toString();
        if (string3.endsWith(" , ")) {
            c = 0;
            strSubstring = string3.substring(0, string3.length() - 3);
        } else {
            c = 0;
            strSubstring = string3;
        }
        java.lang.Object[] objArr5 = new java.lang.Object[1];
        objArr5[c] = string2;
        com.tencent.beacon.core.e.d.a("[db] where:%s", objArr5);
        com.tencent.beacon.core.e.d.a(str2, objArr);
        return listA;
    }

    protected static java.util.List a(android.database.Cursor cursor) {
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
            com.tencent.beacon.core.a.a.a aVar = new com.tencent.beacon.core.a.a.a();
            aVar.f126a = cursor.getLong(columnIndex);
            aVar.e = cursor.getBlob(columnIndex5);
            aVar.c = cursor.getInt(columnIndex2);
            aVar.d = cursor.getLong(columnIndex3);
            aVar.b = cursor.getInt(columnIndex4);
            aVar.f = cursor.getLong(columnIndex6);
            arrayList.add(aVar);
        }
        com.tencent.beacon.core.e.d.a("[db] in parseCursor end", new java.lang.Object[0]);
        return arrayList;
    }

    public static synchronized boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        boolean z;
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[db] deleteReqData context is null", new java.lang.Object[0]);
            return false;
        }
        if (str2 != null && !str2.trim().equals("")) {
            java.lang.String str3 = "_rid = '" + str2 + "' ";
            com.tencent.beacon.core.e.d.a("[db] deleteReqData where: " + str3, new java.lang.Object[0]);
            try {
                int iDelete = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase().delete("t_req_data", str3, null);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("[db] deleteReqData num: ");
                sb.append(iDelete);
                com.tencent.beacon.core.e.d.a(sb.toString(), new java.lang.Object[0]);
                z = iDelete == 1;
                com.tencent.beacon.core.e.d.a("[db] deleteReqData end", new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                try {
                    com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_req_data delete fail!", th);
                    com.tencent.beacon.core.e.d.a(th.getMessage(), new java.lang.Object[0]);
                    com.tencent.beacon.core.e.d.a("[db] deleteReqData end", new java.lang.Object[0]);
                    z = false;
                } catch (java.lang.Throwable th2) {
                    com.tencent.beacon.core.e.d.a("[db] deleteReqData end", new java.lang.Object[0]);
                    throw th2;
                }
            }
            return z;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized boolean a(android.content.Context context, java.lang.String str, java.util.List list) {
        boolean z = false;
        if (context == null || list == null) {
            com.tencent.beacon.core.e.d.b("[db] insert have null args", new java.lang.Object[0]);
            return false;
        }
        if (list.size() <= 0) {
            com.tencent.beacon.core.e.d.a("[db] insert list size == 0 return true", new java.lang.Object[0]);
            return true;
        }
        android.database.sqlite.SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase();
            writableDatabase.beginTransaction();
            for (int i = 0; i < list.size(); i++) {
                com.tencent.beacon.core.a.a.a aVar = (com.tencent.beacon.core.a.a.a) list.get(i);
                long jInsert = writableDatabase.insert("t_event", "_id", a(aVar));
                if (jInsert < 0) {
                    com.tencent.beacon.core.d.i iVarA = com.tencent.beacon.core.d.i.a(context);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("[db] TB: t_event insert fail! cid: ");
                    sb.append(jInsert);
                    iVarA.a("503", sb.toString());
                    com.tencent.beacon.core.e.d.b("[db] insert failure! return", new java.lang.Object[0]);
                }
                aVar.f126a = jInsert;
            }
            writableDatabase.setTransactionSuccessful();
            try {
                writableDatabase.endTransaction();
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_event take transaction end fail!", e);
                com.tencent.beacon.core.e.d.a("[db] db.endTransaction() error.", new java.lang.Object[0]);
            }
            com.tencent.beacon.core.e.d.a("[db] insert events to [%s] end", "t_event");
            z = true;
        } catch (java.lang.Throwable th) {
            try {
                com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_event insert fail!", th);
                com.tencent.beacon.core.e.d.a("[db] insert failure!", new java.lang.Object[0]);
                try {
                    writableDatabase.endTransaction();
                } catch (java.lang.Exception e2) {
                    com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_event take transaction end fail!", e2);
                    com.tencent.beacon.core.e.d.a("[db] db.endTransaction() error.", new java.lang.Object[0]);
                }
                com.tencent.beacon.core.e.d.a("[db] insert events to [%s] end", "t_event");
            } catch (java.lang.Throwable th2) {
                try {
                    writableDatabase.endTransaction();
                } catch (java.lang.Exception e3) {
                    com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_event take transaction end fail!", e3);
                    com.tencent.beacon.core.e.d.a("[db] db.endTransaction() error.", new java.lang.Object[0]);
                }
                com.tencent.beacon.core.e.d.a("[db] insert events to [%s] end", "t_event");
                throw th2;
            }
        }
        return z;
    }

    public static synchronized boolean a(android.content.Context context, java.lang.String str, byte[] bArr, java.lang.String str2, int i) {
        boolean z;
        if (context == null || bArr == null || str2 == null) {
            com.tencent.beacon.core.e.d.b("[db] AnalyticsDAO.insertReqData() have null args", new java.lang.Object[0]);
            return false;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("_rid", str2);
            contentValues.put("_time", java.lang.Long.valueOf(new java.util.Date().getTime()));
            contentValues.put("_cnt", java.lang.Integer.valueOf(i));
            contentValues.put("_datas", bArr);
            long jInsert = writableDatabase.insert("t_req_data", null, contentValues);
            if (jInsert < 0) {
                com.tencent.beacon.core.d.i iVarA = com.tencent.beacon.core.d.i.a(context);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("[db] TB: t_req_datainsert fail! cid: ");
                sb.append(jInsert);
                iVarA.a("503", sb.toString());
                com.tencent.beacon.core.e.d.b("[db] insertReqData failure! return", new java.lang.Object[0]);
                z = false;
            } else {
                z = true;
            }
            com.tencent.beacon.core.e.d.a("[db] insertReqData end", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            try {
                com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_req_datainsert fail!", th);
                com.tencent.beacon.core.e.d.a("[db] insertReqData failure!", new java.lang.Object[0]);
                com.tencent.beacon.core.e.d.a("[db] insertReqData end", new java.lang.Object[0]);
                z = false;
            } catch (java.lang.Throwable th2) {
                com.tencent.beacon.core.e.d.a("[db] insertReqData end", new java.lang.Object[0]);
                throw th2;
            }
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized int b(android.content.Context context, java.lang.String str, int[] iArr, long j, long j2) {
        int i;
        if (context == null) {
            com.tencent.beacon.core.e.d.d("[db] querySum context is null arg", new java.lang.Object[0]);
            return -1;
        }
        if (j > j2) {
            return 0;
        }
        java.lang.String str2 = "_time >= " + j + " and _time <= " + j2;
        if (iArr != null && iArr.length > 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i2 : iArr) {
                sb.append(" or _type = ");
                sb.append(i2);
            }
            str2 = str2 + " and ( " + new java.lang.StringBuilder(sb.substring(4)).toString() + " )";
        }
        java.lang.String str3 = str2;
        com.tencent.beacon.core.e.d.a("[db] query where: " + str3, new java.lang.Object[0]);
        android.database.Cursor cursorQuery = null;
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beacon.core.a.a.e.a(context, str).getWritableDatabase();
            java.lang.String[] strArr = new java.lang.String[1];
            strArr[0] = "count(*) as sum";
            cursorQuery = writableDatabase.query("t_event", strArr, str3, null, null, null, null);
            cursorQuery.moveToNext();
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("sum"));
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("[db] query sum: ");
            sb2.append(i);
            com.tencent.beacon.core.e.d.a(sb2.toString(), new java.lang.Object[0]);
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            com.tencent.beacon.core.e.d.a("[db] querySum end", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            try {
                com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_event querySum fail!", th);
                com.tencent.beacon.core.e.d.a(th.getMessage(), new java.lang.Object[0]);
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                com.tencent.beacon.core.e.d.a("[db] querySum end", new java.lang.Object[0]);
                i = -1;
            } catch (java.lang.Throwable th2) {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                com.tencent.beacon.core.e.d.a("[db] querySum end", new java.lang.Object[0]);
                throw th2;
            }
        }
        return i;
    }
}
