package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    private static final java.lang.Object f = new java.lang.Object();
    private static final java.lang.Object g = new java.lang.Object();
    private static oicq.wlogin_sdk.request.b h;
    private static oicq.wlogin_sdk.request.b i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.content.Context f1678a;
    oicq.wlogin_sdk.request.WloginLastLoginInfo b = new oicq.wlogin_sdk.request.WloginLastLoginInfo();
    java.util.TreeMap c = new java.util.TreeMap();
    java.util.TreeMap d;
    public int e;

    public d(android.content.Context context) throws java.lang.Throwable {
        this.d = new java.util.TreeMap();
        this.f1678a = context;
        java.util.TreeMap treeMapA = a(context, "name_file", 0L);
        this.d = treeMapA;
        if (treeMapA == null) {
            this.d = new java.util.TreeMap();
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0148  */
    /* JADX WARN: Code duplicated, block: B:64:0x0153  */
    /* JADX WARN: Code duplicated, block: B:75:? A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static int a(android.content.Context context, java.lang.String str, byte[] bArr) throws java.lang.Throwable {
        java.lang.Throwable th;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase2;
        android.database.Cursor cursorQuery;
        java.lang.Throwable th2;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase3;
        android.database.sqlite.SQLiteDatabase writableDatabase;
        android.database.Cursor cursor = null;
        try {
            if (str.equals("tk_file")) {
                if (h == null) {
                    h = new oicq.wlogin_sdk.request.b(context, str, null, 1);
                }
                writableDatabase = h.getWritableDatabase();
            } else {
                if (i == null) {
                    i = new oicq.wlogin_sdk.request.b(context, str, null, 1);
                }
                writableDatabase = i.getWritableDatabase();
            }
            try {
                c(writableDatabase.getPath());
                writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (ID INTEGER PRIMARY KEY, " + str + " BLOB);");
                cursorQuery = writableDatabase.query(str, new java.lang.String[]{"ID"}, "ID=0", null, null, null, null);
                try {
                    if (cursorQuery.getCount() == 0) {
                        writableDatabase.execSQL("insert into " + str + " (ID, " + str + ") values (?,?);", new java.lang.Object[]{0, new byte[1]});
                    }
                    writableDatabase.execSQL("update " + str + " set " + str + " =? where ID=0", new java.lang.Object[]{bArr});
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    if (writableDatabase != null && true == writableDatabase.isOpen()) {
                        oicq.wlogin_sdk.tools.util.LOGI("write_to_db db closed", "");
                        writableDatabase.close();
                    }
                    return 0;
                } catch (java.lang.Exception e) {
                    e = e;
                    java.lang.Exception exc = e;
                    sQLiteDatabase2 = writableDatabase;
                    e = exc;
                    try {
                        if (str.equals("tk_file")) {
                            h = null;
                        } else {
                            i = null;
                        }
                        oicq.wlogin_sdk.tools.util.printException(e, "");
                        oicq.wlogin_sdk.tools.util.LOGI("save ticket to file failed " + e.getMessage(), "");
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        if (sQLiteDatabase2 != null && true == sQLiteDatabase2.isOpen()) {
                            oicq.wlogin_sdk.tools.util.LOGI("write_to_db db closed", "");
                            sQLiteDatabase2.close();
                        }
                        return oicq.wlogin_sdk.tools.util.E_SAVE_TICKET_ERROR;
                    } catch (java.lang.Throwable th3) {
                        th2 = th3;
                        sQLiteDatabase3 = sQLiteDatabase2;
                        th = th2;
                        sQLiteDatabase = sQLiteDatabase3;
                        cursor = cursorQuery;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null || true != sQLiteDatabase.isOpen()) {
                            throw th;
                        }
                        oicq.wlogin_sdk.tools.util.LOGI("write_to_db db closed", "");
                        sQLiteDatabase.close();
                        throw th;
                    }
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    sQLiteDatabase3 = writableDatabase;
                    th2 = th;
                    th = th2;
                    sQLiteDatabase = sQLiteDatabase3;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        throw th;
                    }
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                cursorQuery = null;
            } catch (java.lang.Throwable th5) {
                th = th5;
                cursorQuery = null;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            sQLiteDatabase2 = null;
            cursorQuery = null;
        } catch (java.lang.Throwable th6) {
            th = th6;
            sQLiteDatabase = null;
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                throw th;
            }
            throw th;
        }
    }

    public static int a(byte[] bArr, int i2, byte[] bArr2) {
        for (int i3 = i2; i3 < (bArr.length - bArr2.length) - i2; i3++) {
            boolean z = false;
            int i4 = 0;
            while (true) {
                if (i4 >= bArr2.length) {
                    z = true;
                    break;
                }
                if (bArr[i3 + i4] != bArr2[i4]) {
                    break;
                }
                i4++;
            }
            if (z) {
                return i3;
            }
        }
        return -1;
    }

    public static java.util.TreeMap a(android.content.Context context, java.lang.String str, long j) throws java.lang.Throwable {
        oicq.wlogin_sdk.tools.util.LOGI("loadTKTreeMap sigfile " + str, "");
        byte[] bArrA = a(context, str);
        if (bArrA != null) {
            oicq.wlogin_sdk.tools.util.LOGI("loadTKTreeMap len:" + bArrA.length + " at " + oicq.wlogin_sdk.request.t.l(), "");
            try {
                byte[] bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArrA, 0, bArrA.length, oicq.wlogin_sdk.request.t.B);
                if (bArrDecrypt != null) {
                    java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArrDecrypt);
                    java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
                    java.util.TreeMap treeMap = (java.util.TreeMap) objectInputStream.readObject();
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    if (treeMap == null) {
                        oicq.wlogin_sdk.tools.util.LOGI("tree is null", "");
                        return null;
                    }
                    oicq.wlogin_sdk.tools.util.LOGI("loadTKTreeMap tree size: " + treeMap.size(), "");
                    if ("tk_file".equals(str)) {
                        try {
                            if (0 == j) {
                                for (java.lang.Object obj : treeMap.keySet()) {
                                    oicq.wlogin_sdk.tools.util.LOGI(obj + " allsig: " + ((oicq.wlogin_sdk.request.WloginAllSigInfo) treeMap.get(obj))._tk_map, "" + obj);
                                }
                            } else {
                                oicq.wlogin_sdk.tools.util.LOGI(j + " allsig: " + ((oicq.wlogin_sdk.request.WloginAllSigInfo) treeMap.get(java.lang.Long.valueOf(j)))._tk_map, "" + j);
                            }
                        } catch (java.lang.Exception unused) {
                        }
                    } else {
                        for (java.lang.Object obj2 : treeMap.keySet()) {
                            oicq.wlogin_sdk.request.UinInfo uinInfo = (oicq.wlogin_sdk.request.UinInfo) treeMap.get(obj2);
                            if (uinInfo != null) {
                                oicq.wlogin_sdk.tools.util.LOGI(obj2 + " is uin: " + uinInfo._uin, "");
                            }
                        }
                    }
                    return treeMap;
                }
                javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(oicq.wlogin_sdk.request.t.B, "[REDACTED]");
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
                cipher.init(2, secretKeySpec);
                java.io.ByteArrayInputStream byteArrayInputStream2 = new java.io.ByteArrayInputStream(bArrA);
                java.io.ObjectInputStream objectInputStream2 = new java.io.ObjectInputStream(new javax.crypto.CipherInputStream(byteArrayInputStream2, cipher));
                java.util.TreeMap treeMap2 = (java.util.TreeMap) objectInputStream2.readObject();
                if (treeMap2 != null) {
                    objectInputStream2.close();
                    byteArrayInputStream2.close();
                    return treeMap2;
                }
            } catch (java.lang.Throwable th) {
                oicq.wlogin_sdk.tools.util.printThrowable(th, "");
            }
        } else {
            oicq.wlogin_sdk.tools.util.LOGI("dbdata is null", "");
        }
        return b(context, str);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0160  */
    /* JADX WARN: Code duplicated, block: B:111:0x016b  */
    public static byte[] a(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        java.lang.Exception e;
        android.database.sqlite.SQLiteDatabase readableDatabase;
        android.database.Cursor cursorRawQuery;
        java.lang.Throwable th;
        java.lang.Boolean bool = java.lang.Boolean.FALSE;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        cursor = null;
        android.database.Cursor cursor = null;
        try {
            try {
                try {
                    if (str.equals("tk_file")) {
                        if (h == null) {
                            h = new oicq.wlogin_sdk.request.b(context, str, null, 1);
                        }
                        readableDatabase = h.getReadableDatabase();
                    } else {
                        if (i == null) {
                            i = new oicq.wlogin_sdk.request.b(context, str, null, 1);
                        }
                        readableDatabase = i.getReadableDatabase();
                    }
                    try {
                        c(readableDatabase.getPath());
                        cursorRawQuery = readableDatabase.rawQuery("select count(*) from sqlite_master where type ='table' and name ='" + str + "' ", null);
                        try {
                            if (cursorRawQuery.moveToNext() && cursorRawQuery.getInt(0) > 0) {
                                bool = java.lang.Boolean.TRUE;
                            }
                            if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                                cursorRawQuery.close();
                            }
                            if (!bool.booleanValue()) {
                                if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                                    cursorRawQuery.close();
                                }
                                if (readableDatabase != null && true == readableDatabase.isOpen()) {
                                    oicq.wlogin_sdk.tools.util.LOGI("get_from_db db closed", "");
                                    readableDatabase.close();
                                }
                                return null;
                            }
                            android.database.Cursor cursorQuery = readableDatabase.query(str, new java.lang.String[]{str}, "ID=0", null, null, null, null);
                            if (cursorQuery == null) {
                                if (cursorQuery != null && !cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                                if (readableDatabase != null && true == readableDatabase.isOpen()) {
                                    oicq.wlogin_sdk.tools.util.LOGI("get_from_db db closed", "");
                                    readableDatabase.close();
                                }
                                return null;
                            }
                            try {
                                if (!cursorQuery.moveToFirst()) {
                                    cursorQuery.close();
                                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                                        cursorQuery.close();
                                    }
                                    if (readableDatabase != null && true == readableDatabase.isOpen()) {
                                        oicq.wlogin_sdk.tools.util.LOGI("get_from_db db closed", "");
                                        readableDatabase.close();
                                    }
                                    return null;
                                }
                                byte[] blob = cursorQuery.getBlob(0);
                                cursorQuery.close();
                                if (cursorQuery != null && !cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                                if (readableDatabase != null && true == readableDatabase.isOpen()) {
                                    oicq.wlogin_sdk.tools.util.LOGI("get_from_db db closed", "");
                                    readableDatabase.close();
                                }
                                return blob;
                            } catch (java.lang.Exception e2) {
                                cursorRawQuery = cursorQuery;
                                e = e2;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                cursor = cursorQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (readableDatabase != null) {
                                    oicq.wlogin_sdk.tools.util.LOGI("get_from_db db closed", "");
                                    readableDatabase.close();
                                }
                                throw th;
                            }
                        } catch (java.lang.Exception e3) {
                            e = e3;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (readableDatabase != null) {
                                oicq.wlogin_sdk.tools.util.LOGI("get_from_db db closed", "");
                                readableDatabase.close();
                            }
                            throw th;
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        cursorRawQuery = null;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    readableDatabase = null;
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                cursorRawQuery = null;
                th = th;
                readableDatabase = sQLiteDatabase;
                cursor = cursorRawQuery;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                if (readableDatabase != null && true == readableDatabase.isOpen()) {
                    oicq.wlogin_sdk.tools.util.LOGI("get_from_db db closed", "");
                    readableDatabase.close();
                }
                throw th;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            readableDatabase = null;
            cursorRawQuery = null;
        }
        try {
            if (str.equals("tk_file")) {
                h = null;
            } else {
                i = null;
            }
            oicq.wlogin_sdk.tools.util.printException(e, "");
            if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                cursorRawQuery.close();
            }
            if (readableDatabase != null && true == readableDatabase.isOpen()) {
                oicq.wlogin_sdk.tools.util.LOGI("get_from_db db closed", "");
                readableDatabase.close();
            }
            return null;
        } catch (java.lang.Throwable th7) {
            sQLiteDatabase = readableDatabase;
            th = th7;
            th = th;
            readableDatabase = sQLiteDatabase;
            cursor = cursorRawQuery;
            if (cursor != null) {
                cursor.close();
            }
            if (readableDatabase != null) {
                oicq.wlogin_sdk.tools.util.LOGI("get_from_db db closed", "");
                readableDatabase.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:159:0x029f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x010f  */
    private static java.util.TreeMap b(android.content.Context context, java.lang.String str) {
        java.io.ObjectInputStream objectInputStream;
        java.io.ObjectInputStream objectInputStream2;
        java.io.ObjectInputStream objectInputStream3;
        java.util.TreeMap treeMap;
        java.io.ObjectInputStream objectInputStream4;
        byte[] bytes;
        int iA;
        java.util.TreeMap treeMap2;
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(oicq.wlogin_sdk.request.t.B, "[REDACTED]");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
            cipher.init(2, secretKeySpec);
            objectInputStream = new java.io.ObjectInputStream(new javax.crypto.CipherInputStream(context.openFileInput(str), cipher));
            try {
                treeMap = (java.util.TreeMap) objectInputStream.readObject();
                treeMap2 = treeMap;
            } catch (java.lang.Throwable th) {
                th = th;
                int i2 = 256;
                byte b = 0;
                if (!(th instanceof java.io.FileNotFoundException)) {
                    try {
                        byte[] bArr = new byte[256];
                        java.io.FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
                        while (true) {
                            int i3 = fileInputStreamOpenFileInput.read(bArr, 0, 256);
                            if (i3 <= 0) {
                                break;
                            }
                            oicq.wlogin_sdk.tools.util.LOGI(oicq.wlogin_sdk.tools.util.buf_to_string(bArr, i3));
                        }
                        fileInputStreamOpenFileInput.close();
                    } catch (java.lang.Exception unused) {
                    }
                }
                try {
                    javax.crypto.spec.SecretKeySpec secretKeySpec2 = new javax.crypto.spec.SecretKeySpec(new java.lang.String("[REDACTED]").getBytes(), "[REDACTED]");
                    javax.crypto.Cipher cipher2 = javax.crypto.Cipher.getInstance("DESede");
                    cipher2.init(2, secretKeySpec2);
                    objectInputStream2 = new java.io.ObjectInputStream(new javax.crypto.CipherInputStream(context.openFileInput(str), cipher2));
                    try {
                        objectInputStream = objectInputStream2;
                        treeMap2 = (java.util.TreeMap) objectInputStream2.readObject();
                    } catch (java.lang.Throwable unused2) {
                        try {
                            byte[] bArr2 = new byte[256];
                            int i4 = 40;
                            int i5 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_ERROR;
                            java.io.FileInputStream fileInputStreamOpenFileInput2 = context.openFileInput(str);
                            java.io.FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("tmp_tk_file", 0);
                            try {
                                while (true) {
                                    int i6 = fileInputStreamOpenFileInput2.read(bArr2, i4, i5);
                                    if (i6 <= 0) {
                                        break;
                                    }
                                    for (int i7 = i4 + i6; i7 < i2; i7++) {
                                        bArr2[i7] = b;
                                    }
                                    int length = 0;
                                    while (length >= 0 && (iA = a(bArr2, length, (bytes = new java.lang.String("WloginAllSigInfo").getBytes()))) >= 0) {
                                        length = iA + bytes.length;
                                        if (length + 8 <= i2) {
                                            int i8 = length + 0;
                                            if (bArr2[i8] == -127) {
                                                int i9 = length + 1;
                                                if (bArr2[i9] == 64) {
                                                    int i10 = length + 2;
                                                    if (bArr2[i10] == 1) {
                                                        int i11 = length + 3;
                                                        if (bArr2[i11] == 111) {
                                                            int i12 = length + 4;
                                                            if (bArr2[i12] == -111) {
                                                                int i13 = length + 5;
                                                                if (bArr2[i13] == -44) {
                                                                    int i14 = length + 6;
                                                                    if (bArr2[i14] == 26) {
                                                                        int i15 = length + 7;
                                                                        objectInputStream3 = objectInputStream2;
                                                                        if (bArr2[i15] == -101) {
                                                                            try {
                                                                                bArr2[i8] = 0;
                                                                                bArr2[i9] = 0;
                                                                                bArr2[i10] = 0;
                                                                                bArr2[i11] = 0;
                                                                                bArr2[i12] = 0;
                                                                                bArr2[i13] = 0;
                                                                                bArr2[i14] = 0;
                                                                                bArr2[i15] = 1;
                                                                            } catch (java.lang.Exception unused3) {
                                                                                objectInputStream4 = objectInputStream3;
                                                                                objectInputStream = objectInputStream4;
                                                                                treeMap = null;
                                                                                context.deleteFile("tmp_tk_file");
                                                                                treeMap2 = treeMap;
                                                                                if (treeMap2 != null) {
                                                                                    try {
                                                                                        objectInputStream.close();
                                                                                    } catch (java.lang.Exception unused4) {
                                                                                        return null;
                                                                                    }
                                                                                }
                                                                                return treeMap2;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        objectInputStream3 = objectInputStream2;
                                                                    }
                                                                } else {
                                                                    objectInputStream3 = objectInputStream2;
                                                                }
                                                            } else {
                                                                objectInputStream3 = objectInputStream2;
                                                            }
                                                        } else {
                                                            objectInputStream3 = objectInputStream2;
                                                        }
                                                    } else {
                                                        objectInputStream3 = objectInputStream2;
                                                    }
                                                } else {
                                                    objectInputStream3 = objectInputStream2;
                                                }
                                            } else {
                                                objectInputStream3 = objectInputStream2;
                                            }
                                        } else {
                                            objectInputStream3 = objectInputStream2;
                                        }
                                        objectInputStream2 = objectInputStream3;
                                        i2 = 256;
                                    }
                                    java.io.ObjectInputStream objectInputStream5 = objectInputStream2;
                                    int length2 = 0;
                                    while (length2 >= 0) {
                                        byte[] bytes2 = new java.lang.String("WloginSigInfo").getBytes();
                                        int iA2 = a(bArr2, length2, bytes2);
                                        if (iA2 < 0) {
                                            break;
                                        }
                                        length2 = iA2 + bytes2.length;
                                        if (length2 + 8 <= 256) {
                                            int i16 = length2 + 0;
                                            if (bArr2[i16] == 0) {
                                                int i17 = length2 + 1;
                                                if (bArr2[i17] == 0) {
                                                    int i18 = length2 + 2;
                                                    if (bArr2[i18] == 0) {
                                                        int i19 = length2 + 3;
                                                        if (bArr2[i19] == 0) {
                                                            int i20 = length2 + 4;
                                                            if (bArr2[i20] == 0) {
                                                                int i21 = length2 + 5;
                                                                if (bArr2[i21] == 0) {
                                                                    int i22 = length2 + 6;
                                                                    if (bArr2[i22] == 0) {
                                                                        int i23 = length2 + 7;
                                                                        if (bArr2[i23] == 0) {
                                                                            bArr2[i16] = 0;
                                                                            bArr2[i17] = 0;
                                                                            bArr2[i18] = 0;
                                                                            bArr2[i19] = 0;
                                                                            bArr2[i20] = 0;
                                                                            bArr2[i21] = 0;
                                                                            bArr2[i22] = 0;
                                                                            bArr2[i23] = 1;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    int length3 = 0;
                                    while (length3 >= 0) {
                                        byte[] bytes3 = new java.lang.String("WloginSimpleInfo").getBytes();
                                        int iA3 = a(bArr2, length3, bytes3);
                                        if (iA3 < 0) {
                                            break;
                                        }
                                        length3 = iA3 + bytes3.length;
                                        if (length3 + 8 <= 256) {
                                            int i24 = length3 + 0;
                                            if (bArr2[i24] == 57) {
                                                int i25 = length3 + 1;
                                                if (bArr2[i25] == -69) {
                                                    int i26 = length3 + 2;
                                                    if (bArr2[i26] == -84) {
                                                        int i27 = length3 + 3;
                                                        if (bArr2[i27] == 110) {
                                                            int i28 = length3 + 4;
                                                            if (bArr2[i28] == -46) {
                                                                int i29 = length3 + 5;
                                                                if (bArr2[i29] == 98) {
                                                                    int i30 = length3 + 6;
                                                                    if (bArr2[i30] == -31) {
                                                                        int i31 = length3 + 7;
                                                                        if (bArr2[i31] == -113) {
                                                                            bArr2[i24] = 0;
                                                                            bArr2[i25] = 0;
                                                                            bArr2[i26] = 0;
                                                                            bArr2[i27] = 0;
                                                                            bArr2[i28] = 0;
                                                                            bArr2[i29] = 0;
                                                                            bArr2[i30] = 0;
                                                                            bArr2[i31] = 1;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    int length4 = 0;
                                    while (length4 >= 0) {
                                        byte[] bytes4 = new java.lang.String("UinInfo").getBytes();
                                        int iA4 = a(bArr2, length4, bytes4);
                                        if (iA4 < 0) {
                                            break;
                                        }
                                        length4 = iA4 + bytes4.length;
                                        if (length4 + 8 <= 256) {
                                            int i32 = length4 + 0;
                                            if (bArr2[i32] == -118) {
                                                int i33 = length4 + 1;
                                                if (bArr2[i33] == -23) {
                                                    int i34 = length4 + 2;
                                                    if (bArr2[i34] == -128) {
                                                        int i35 = length4 + 3;
                                                        if (bArr2[i35] == -19) {
                                                            int i36 = length4 + 4;
                                                            if (bArr2[i36] == -26) {
                                                                int i37 = length4 + 5;
                                                                if (bArr2[i37] == 99) {
                                                                    int i38 = length4 + 6;
                                                                    if (bArr2[i38] == 41) {
                                                                        int i39 = length4 + 7;
                                                                        if (bArr2[i39] == 14) {
                                                                            bArr2[i32] = 0;
                                                                            bArr2[i33] = 0;
                                                                            bArr2[i34] = 0;
                                                                            bArr2[i35] = 0;
                                                                            bArr2[i36] = 0;
                                                                            bArr2[i37] = 0;
                                                                            bArr2[i38] = 0;
                                                                            bArr2[i39] = 1;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    fileOutputStreamOpenFileOutput.write(bArr2, 40, i6);
                                    if (i6 > 40) {
                                        java.lang.System.arraycopy(bArr2, i6, bArr2, 0, 40);
                                    }
                                    objectInputStream2 = objectInputStream5;
                                    i4 = 40;
                                    i2 = 256;
                                    b = 0;
                                    i5 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_ERROR;
                                    objectInputStream4 = objectInputStream3;
                                    objectInputStream = objectInputStream4;
                                    treeMap = null;
                                    context.deleteFile("tmp_tk_file");
                                    treeMap2 = treeMap;
                                }
                                treeMap = (java.util.TreeMap) objectInputStream4.readObject();
                                objectInputStream = objectInputStream4;
                            } catch (java.lang.Exception unused5) {
                                objectInputStream = objectInputStream4;
                                treeMap = null;
                                context.deleteFile("tmp_tk_file");
                                treeMap2 = treeMap;
                                if (treeMap2 != null) {
                                    objectInputStream.close();
                                }
                                return treeMap2;
                            }
                            objectInputStream3 = objectInputStream2;
                            fileInputStreamOpenFileInput2.close();
                            fileOutputStreamOpenFileOutput.close();
                            objectInputStream4 = new java.io.ObjectInputStream(context.openFileInput("tmp_tk_file"));
                        } catch (java.lang.Exception unused6) {
                            objectInputStream3 = objectInputStream2;
                        }
                        context.deleteFile("tmp_tk_file");
                        treeMap2 = treeMap;
                    }
                } catch (java.lang.Throwable unused7) {
                    objectInputStream2 = objectInputStream;
                }
                if (treeMap2 != null) {
                    objectInputStream.close();
                }
                return treeMap2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            objectInputStream = null;
        }
        if (treeMap2 != null) {
            objectInputStream.close();
        }
        return treeMap2;
    }

    private static void c(java.lang.String str) {
        oicq.wlogin_sdk.tools.util.LOGI("file " + str + " last update stample " + new java.io.File(str).lastModified(), "");
    }

    public synchronized int a(long j, long j2) {
        oicq.wlogin_sdk.tools.util.LOGI("start clear_da2 " + j2, "" + j);
        int i2 = 0;
        if (this.f1678a != null) {
            synchronized (f) {
                java.util.TreeMap treeMapA = a(this.f1678a, "tk_file", j);
                if (treeMapA != null) {
                    oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) treeMapA.get(java.lang.Long.valueOf(j));
                    if (wloginAllSigInfo == null) {
                        return -1;
                    }
                    oicq.wlogin_sdk.tools.util.LOGI("clear_da2 clear DA2 in file", "" + j);
                    wloginAllSigInfo.put_da2(j2, new byte[0]);
                    int iA = a(treeMapA, "tk_file");
                    this.c = treeMapA;
                    i2 = iA;
                }
            }
        }
        oicq.wlogin_sdk.tools.util.LOGI("end clear_da2 ret " + i2, "" + j);
        return i2;
    }

    public synchronized int a(long j, long j2, long j3, long j4, byte[] bArr, byte[] bArr2) {
        oicq.wlogin_sdk.tools.util.LOGI("start put_siginfo " + j2, "" + j);
        oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) this.c.get(java.lang.Long.valueOf(j));
        if (wloginAllSigInfo == null) {
            return -1;
        }
        int iPut_siginfo = wloginAllSigInfo.put_siginfo(j2, j3, j4, bArr, bArr2);
        if (this.f1678a != null) {
            synchronized (f) {
                java.util.TreeMap treeMapA = a(this.f1678a, "tk_file", j);
                if (treeMapA == null) {
                    treeMapA = new java.util.TreeMap();
                }
                treeMapA.put(java.lang.Long.valueOf(j), wloginAllSigInfo.get_clone());
                a(treeMapA, "tk_file");
            }
        }
        return iPut_siginfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int a(long j, long j2, byte[][] bArr, long j3, long j4, long j5, long j6, long j7, oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[][] bArr14, long[] jArr, int i2) {
        int iA;
        byte[] bArr15;
        byte[] bArr16;
        byte[] bArr17;
        byte[] bArr18;
        byte[] bArr19;
        byte[] bArr20;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo;
        oicq.wlogin_sdk.tools.util.LOGI("start put_siginfo skey " + oicq.wlogin_sdk.tools.util.getMaskBytes(bArr10, 2, 2), "" + j);
        iA = 0;
        if (this.f1678a != null) {
            synchronized (f) {
                oicq.wlogin_sdk.tools.util.LOGI("put_siginfo load file", "" + j);
                java.util.TreeMap treeMapA = a(this.f1678a, "tk_file", j);
                if (treeMapA == null) {
                    treeMapA = new java.util.TreeMap();
                }
                oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) this.c.get(java.lang.Long.valueOf(j));
                if (wloginAllSigInfo == null && (wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) treeMapA.get(java.lang.Long.valueOf(j))) == null) {
                    wloginAllSigInfo = new oicq.wlogin_sdk.request.WloginAllSigInfo();
                }
                oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo2 = wloginAllSigInfo;
                oicq.wlogin_sdk.tools.util.LOGI("mainSigMap 0x" + java.lang.Integer.toHexString(this.e), "" + j);
                wloginAllSigInfo2.mainSigMap = this.e;
                byte[] bArr21 = new byte[0];
                byte[] bArr22 = new byte[0];
                byte[] bArr23 = new byte[0];
                byte[] bArr24 = new byte[0];
                byte[] bArr25 = new byte[0];
                byte[] bArr26 = new byte[0];
                byte[] bArr27 = new byte[0];
                oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo2 = (oicq.wlogin_sdk.sharemem.WloginSigInfo) wloginAllSigInfo2._tk_map.get(java.lang.Long.valueOf(j2));
                if (wloginSigInfo2 != null) {
                    if (wloginSigInfo2._en_A1 != null) {
                        bArr21 = (byte[]) wloginSigInfo2._en_A1.clone();
                        if (wloginSigInfo2._noPicSig != null) {
                            bArr22 = (byte[]) wloginSigInfo2._noPicSig.clone();
                        }
                    }
                    if (wloginSigInfo2._G != null) {
                        bArr23 = (byte[]) wloginSigInfo2._G.clone();
                    }
                    if (wloginSigInfo2._dpwd != null) {
                        bArr24 = (byte[]) wloginSigInfo2._dpwd.clone();
                    }
                    if (wloginSigInfo2._randseed != null) {
                        bArr25 = (byte[]) wloginSigInfo2._randseed.clone();
                    }
                    bArr26 = wloginSigInfo2._psKey;
                    bArr20 = wloginSigInfo2._pt4Token;
                    bArr15 = bArr21;
                    bArr16 = bArr22;
                    bArr17 = bArr23;
                    bArr18 = bArr24;
                    bArr19 = bArr25;
                } else {
                    bArr15 = bArr21;
                    bArr16 = bArr22;
                    bArr17 = bArr23;
                    bArr18 = bArr24;
                    bArr19 = bArr25;
                    bArr20 = bArr27;
                }
                if (bArr14[6] != null && bArr14[6].length > 2) {
                    java.util.HashMap map = new java.util.HashMap();
                    java.util.HashMap map2 = new java.util.HashMap();
                    java.util.HashMap map3 = new java.util.HashMap();
                    java.util.HashMap map4 = new java.util.HashMap();
                    oicq.wlogin_sdk.request.Ticket.parsePsBuf(bArr26, j5, map, map2);
                    oicq.wlogin_sdk.request.Ticket.parsePsBuf(bArr20, j5, map3, map4);
                    oicq.wlogin_sdk.tools.util.LOGI("current pskey size:" + map.size() + ":" + map2.size(), "");
                    java.util.Iterator it = map2.entrySet().iterator();
                    while (it.hasNext()) {
                        java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
                        java.lang.String str = (java.lang.String) entry.getKey();
                        if (oicq.wlogin_sdk.request.Ticket.isPskeyStorageExpired(((java.lang.Long) entry.getValue()).longValue())) {
                            it.remove();
                            map.remove(str);
                            oicq.wlogin_sdk.tools.util.LOGI("delete expired pskey from file,key:" + str, "");
                        }
                    }
                    java.util.Iterator it2 = map4.entrySet().iterator();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("[REDACTED]");
                    sb.append(map3.size());
                    sb.append(":");
                    sb.append(map4.size());
                    loop1: while (true) {
                        oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "");
                        while (true) {
                            if (!it2.hasNext()) {
                                break loop1;
                            }
                            java.util.Map.Entry entry2 = (java.util.Map.Entry) it2.next();
                            java.lang.String str2 = (java.lang.String) entry2.getKey();
                            if (oicq.wlogin_sdk.request.Ticket.isPskeyStorageExpired(((java.lang.Long) entry2.getValue()).longValue())) {
                                it2.remove();
                                map3.remove(str2);
                                sb = new java.lang.StringBuilder();
                                sb.append("[REDACTED]");
                                sb.append(str2);
                            }
                        }
                    }
                    oicq.wlogin_sdk.request.Ticket.parseSvrPs(bArr14[6], j5, map, map2, map3, map4);
                    try {
                        bArr14[6] = oicq.wlogin_sdk.request.Ticket.packPsBuf(map, j5, map2);
                        bArr14[12] = oicq.wlogin_sdk.request.Ticket.packPsBuf(map3, j5, map4);
                    } catch (java.nio.BufferOverflowException unused) {
                        oicq.wlogin_sdk.tools.util.LOGI("map size " + map.size() + "is too large", "" + j);
                        a(java.lang.Long.valueOf(j));
                        return oicq.wlogin_sdk.tools.util.E_BUFFER_OVERFLOW;
                    }
                }
                wloginAllSigInfo2.put_simpleinfo(wloginSimpleInfo);
                wloginAllSigInfo2.put_siginfo(j3, j4, j5, j6, j7, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, jArr, i2);
                wloginAllSigInfo2.put_siginfo(j2, bArr, j5);
                java.util.TreeMap treeMap = treeMapA;
                treeMap.put(java.lang.Long.valueOf(j), wloginAllSigInfo2.get_clone());
                iA = a(treeMap, "tk_file");
                oicq.wlogin_sdk.tools.util.LOGI("save key result:tk_file:" + iA, "");
                if (iA != 0 && (wloginSigInfo = (oicq.wlogin_sdk.sharemem.WloginSigInfo) wloginAllSigInfo2._tk_map.get(java.lang.Long.valueOf(j2))) != null) {
                    wloginSigInfo._en_A1 = (byte[]) bArr15.clone();
                    wloginSigInfo._noPicSig = (byte[]) bArr16.clone();
                    wloginSigInfo._G = (byte[]) bArr17.clone();
                    wloginSigInfo._dpwd = (byte[]) bArr18.clone();
                    wloginSigInfo._randseed = (byte[]) bArr19.clone();
                }
                oicq.wlogin_sdk.tools.util.LOGI("sig in memory changed", "" + j);
                this.c.put(java.lang.Long.valueOf(j), wloginAllSigInfo2.get_clone());
            }
        }
        return iA;
    }

    public synchronized int a(java.util.TreeMap treeMap, java.lang.String str) {
        return ("tk_file".equals(str) || "name_file".equals(str)) ? b(treeMap, str) : 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized java.util.List a(boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.Context context = this.f1678a;
        if (context != null) {
            java.util.TreeMap treeMapA = a(context, "tk_file", 0L);
            if (treeMapA == null) {
                return arrayList;
            }
            java.util.Iterator it = treeMapA.keySet().iterator();
            while (it.hasNext()) {
                java.lang.Long l = (java.lang.Long) it.next();
                oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) this.c.get(l);
                if (wloginAllSigInfo == null) {
                    wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) treeMapA.get(l);
                    if (wloginAllSigInfo != null) {
                        this.c.put(l, wloginAllSigInfo);
                    }
                }
                for (java.lang.Long l2 : wloginAllSigInfo._tk_map.keySet()) {
                    oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo = (oicq.wlogin_sdk.sharemem.WloginSigInfo) wloginAllSigInfo._tk_map.get(l2);
                    if (wloginSigInfo != null) {
                        java.lang.String strB = b(l);
                        if (strB == null) {
                            strB = java.lang.String.valueOf(l);
                        }
                        java.lang.String str = strB;
                        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = wloginAllSigInfo._useInfo;
                        if (wloginSimpleInfo._img_url == null) {
                            wloginSimpleInfo._img_url = new byte[0];
                        }
                        java.util.TreeMap treeMap = treeMapA;
                        java.util.Iterator it2 = it;
                        arrayList.add(new oicq.wlogin_sdk.sharemem.WloginLoginInfo(str, l.longValue(), l2.longValue(), new java.lang.String(wloginAllSigInfo._useInfo._img_url), wloginSigInfo._create_time, z ? oicq.wlogin_sdk.sharemem.WloginLoginInfo.TYPE_LOACL : oicq.wlogin_sdk.sharemem.WloginLoginInfo.TYPE_REMOTE, wloginSigInfo._login_bitmap));
                        treeMapA = treeMap;
                        it = it2;
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized oicq.wlogin_sdk.request.UinInfo a(java.lang.String str, boolean z) {
        if (z) {
            oicq.wlogin_sdk.request.UinInfo uinInfo = (oicq.wlogin_sdk.request.UinInfo) this.d.get(str);
            if (uinInfo != null) {
                oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + str + "[REDACTED]" + uinInfo._uin + "[REDACTED]" + uinInfo.getHasPassword(), "[REDACTED]");
                return uinInfo;
            }
        }
        android.content.Context context = this.f1678a;
        if (context == null) {
            return null;
        }
        java.util.TreeMap treeMapA = a(context, "name_file", 0L);
        if (treeMapA == null) {
            return null;
        }
        oicq.wlogin_sdk.request.UinInfo uinInfo2 = (oicq.wlogin_sdk.request.UinInfo) treeMapA.get(str);
        if (uinInfo2 == null) {
            return null;
        }
        this.d.put(str, uinInfo2);
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + str + "[REDACTED]" + uinInfo2._uin + "[REDACTED]" + uinInfo2.getHasPassword(), "[REDACTED]");
        return uinInfo2;
    }

    public synchronized oicq.wlogin_sdk.request.WloginAllSigInfo a(long j) {
        oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) this.c.get(java.lang.Long.valueOf(j));
        if (wloginAllSigInfo != null) {
            oicq.wlogin_sdk.tools.util.LOGI("get_all_siginfo got in mem", "");
            return wloginAllSigInfo;
        }
        android.content.Context context = this.f1678a;
        if (context == null) {
            return null;
        }
        java.util.TreeMap treeMapA = a(context, "tk_file", j);
        if (treeMapA == null) {
            return null;
        }
        oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo2 = (oicq.wlogin_sdk.request.WloginAllSigInfo) treeMapA.get(java.lang.Long.valueOf(j));
        if (wloginAllSigInfo2 == null) {
            return null;
        }
        oicq.wlogin_sdk.tools.util.LOGI("got in file", "");
        this.c.put(java.lang.Long.valueOf(j), wloginAllSigInfo2);
        return wloginAllSigInfo2;
    }

    public synchronized void a() {
        oicq.wlogin_sdk.tools.util.LOGI("refresh_all_siginfo ...", "");
        java.util.TreeMap treeMapA = a(this.f1678a, "tk_file", 0L);
        this.c = treeMapA;
        if (treeMapA == null) {
            this.c = new java.util.TreeMap();
        }
    }

    public synchronized void a(long j, long j2, byte[] bArr) {
        oicq.wlogin_sdk.tools.util.LOGI("start put_randseed " + j2, "" + j);
        if (this.f1678a != null) {
            synchronized (f) {
                java.util.TreeMap treeMapA = a(this.f1678a, "tk_file", j);
                if (treeMapA != null) {
                    oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) treeMapA.get(java.lang.Long.valueOf(j));
                    if (wloginAllSigInfo == null) {
                        oicq.wlogin_sdk.tools.util.LOGI("fileInfo is null " + j2, "" + j);
                        return;
                    }
                    wloginAllSigInfo.put_randseed(j2, bArr);
                    int iA = a(treeMapA, "tk_file");
                    if (iA != 0) {
                        oicq.wlogin_sdk.tools.util.LOGI("put_randseed refreshTKTreeMap failed ret " + iA + " appid " + j2, "" + j);
                        return;
                    }
                    this.c = treeMapA;
                    oicq.wlogin_sdk.tools.util.LOGI("end put_randseed", "" + j);
                }
            }
        }
    }

    public synchronized void a(java.lang.Long l) {
        oicq.wlogin_sdk.tools.util.LOGI("start clear_sig", "" + l);
        this.c.remove(l);
        if (this.f1678a != null) {
            synchronized (f) {
                java.util.TreeMap treeMapA = a(this.f1678a, "tk_file", l.longValue());
                if (treeMapA == null) {
                    return;
                }
                treeMapA.remove(l);
                a(treeMapA, "tk_file");
            }
        }
    }

    public synchronized void a(java.lang.Long l, java.lang.Long l2) {
        oicq.wlogin_sdk.tools.util.LOGI("start clear_sig", "" + l);
        oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) this.c.get(l);
        if (wloginAllSigInfo != null) {
            wloginAllSigInfo._tk_map.remove(l2);
            oicq.wlogin_sdk.tools.util.LOGI("uin " + l + " appid " + l2 + " sig has been cleared");
        }
        if (this.f1678a != null) {
            synchronized (f) {
                java.util.TreeMap treeMapA = a(this.f1678a, "tk_file", l.longValue());
                if (treeMapA == null) {
                    return;
                }
                oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo2 = (oicq.wlogin_sdk.request.WloginAllSigInfo) treeMapA.get(l);
                if (wloginAllSigInfo2 == null) {
                    return;
                }
                wloginAllSigInfo2._tk_map.remove(l2);
                a(treeMapA, "tk_file");
            }
        }
    }

    public synchronized void a(java.lang.String str) {
        this.d.remove(str);
        if (this.f1678a != null) {
            synchronized (g) {
                java.util.TreeMap treeMapA = a(this.f1678a, "name_file", 0L);
                if (treeMapA == null) {
                    treeMapA = new java.util.TreeMap();
                }
                treeMapA.remove(str);
                a(treeMapA, "name_file");
            }
        }
    }

    public synchronized void a(java.lang.String str, java.lang.Long l, boolean z) {
        oicq.wlogin_sdk.tools.util.LOGI("put account " + str, "" + l);
        java.lang.String strB = b(l);
        if (strB != null) {
            this.d.remove(strB);
        }
        oicq.wlogin_sdk.request.UinInfo uinInfo = new oicq.wlogin_sdk.request.UinInfo(l, z);
        this.d.put(str, uinInfo);
        if (this.f1678a != null) {
            synchronized (g) {
                java.util.TreeMap treeMapA = a(this.f1678a, "name_file", 0L);
                if (treeMapA == null) {
                    treeMapA = new java.util.TreeMap();
                }
                if (strB != null) {
                    treeMapA.remove(strB);
                }
                treeMapA.put(str, uinInfo);
                a(treeMapA, "name_file");
            }
        }
    }

    public synchronized int b(java.util.TreeMap treeMap, java.lang.String str) {
        int iA;
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(treeMap);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            iA = a(this.f1678a, str, oicq.wlogin_sdk.tools.cryptor.encrypt(byteArray, 0, byteArray.length, oicq.wlogin_sdk.request.t.B));
            objectOutputStream.close();
            byteArrayOutputStream.close();
        } catch (java.lang.Throwable th) {
            oicq.wlogin_sdk.tools.util.LOGI("saveTKTreeMap failed " + th.getStackTrace().toString(), "");
            oicq.wlogin_sdk.tools.util.printThrowable(th, "");
            iA = oicq.wlogin_sdk.tools.util.E_SAVE_TICKET_ERROR;
        }
        return iA;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized java.lang.String b(java.lang.Long l) {
        for (java.lang.String str : this.d.keySet()) {
            oicq.wlogin_sdk.request.UinInfo uinInfo = (oicq.wlogin_sdk.request.UinInfo) this.d.get(str);
            if (uinInfo != null && uinInfo._uin.equals(l)) {
                return str;
            }
        }
        return null;
    }

    public synchronized oicq.wlogin_sdk.sharemem.WloginSimpleInfo b(long j) {
        oicq.wlogin_sdk.tools.util.LOGI("start get_simpleinfo", "uin=" + j);
        oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfoA = a(j);
        if (wloginAllSigInfoA == null) {
            return null;
        }
        return wloginAllSigInfoA._useInfo.get_clone();
    }

    public synchronized void b(long j, long j2) {
        oicq.wlogin_sdk.tools.util.LOGI("start clearNewST " + j2, "" + j);
        int i2 = 0;
        if (this.f1678a != null) {
            synchronized (f) {
                java.util.TreeMap treeMapA = a(this.f1678a, "tk_file", j);
                if (treeMapA != null) {
                    oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) treeMapA.get(java.lang.Long.valueOf(j));
                    if (wloginAllSigInfo == null) {
                        return;
                    }
                    oicq.wlogin_sdk.tools.util.LOGI("clearNewST clear newST in file", "" + j);
                    wloginAllSigInfo.putNewST(j2, new byte[0], new byte[0]);
                    int iA = a(treeMapA, "tk_file");
                    this.c = treeMapA;
                    i2 = iA;
                }
            }
        }
        oicq.wlogin_sdk.tools.util.LOGI("end clearNewST ret " + i2, "" + j);
    }

    public synchronized void b(java.lang.String str) {
        this.d.remove(str);
        oicq.wlogin_sdk.tools.util.LOGI("clear_account " + str, "");
        if (this.f1678a != null) {
            synchronized (g) {
                java.util.TreeMap treeMapA = a(this.f1678a, "name_file", 0L);
                if (treeMapA == null) {
                    return;
                }
                treeMapA.remove(str);
                a(treeMapA, "name_file");
            }
        }
    }

    public synchronized void c(long j, long j2) {
        oicq.wlogin_sdk.tools.util.LOGI("clear_pskey " + j2, "" + j);
        oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) this.c.get(java.lang.Long.valueOf(j));
        if (wloginAllSigInfo == null) {
            return;
        }
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo = (oicq.wlogin_sdk.sharemem.WloginSigInfo) wloginAllSigInfo._tk_map.get(java.lang.Long.valueOf(j2));
        if (wloginSigInfo == null) {
            return;
        }
        wloginSigInfo._pt4Token = new byte[0];
        wloginSigInfo._psKey = new byte[0];
        wloginSigInfo.cacheTickets = null;
        wloginSigInfo.cacheUpdateStamp = 0L;
        wloginAllSigInfo._tk_map.put(java.lang.Long.valueOf(j), wloginSigInfo);
        if (this.f1678a != null) {
            synchronized (f) {
                java.util.TreeMap treeMapA = a(this.f1678a, "tk_file", j);
                if (treeMapA != null) {
                    treeMapA.put(java.lang.Long.valueOf(j), wloginAllSigInfo);
                    a(treeMapA, "tk_file");
                    this.c = treeMapA;
                }
            }
        }
    }

    public synchronized oicq.wlogin_sdk.sharemem.WloginSigInfo d(long j, long j2) {
        oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfoA = a(j);
        if (wloginAllSigInfoA == null) {
            return null;
        }
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo = (oicq.wlogin_sdk.sharemem.WloginSigInfo) wloginAllSigInfoA._tk_map.get(java.lang.Long.valueOf(j2));
        if (wloginSigInfo == null) {
            return null;
        }
        return wloginSigInfo;
    }
}
