package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f928a = com.tencent.smtt.sdk.CookieManager.LOGTAG;
    static java.io.File b;

    public static java.io.File a(android.content.Context context) {
        if (b == null && context != null) {
            b = new java.io.File(context.getDir("webview", 0), "Cookies");
        }
        if (b == null) {
            b = new java.io.File("/data/data/" + context.getPackageName() + java.io.File.separator + "app_webview" + java.io.File.separator + "Cookies");
        }
        return b;
    }

    private static java.lang.String a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str) {
        android.database.Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        int count = cursorRawQuery.getCount();
        int columnCount = cursorRawQuery.getColumnCount();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("raws:" + count + ",columns:" + columnCount + "\n");
        if (count > 0 && cursorRawQuery.moveToFirst()) {
            do {
                sb.append("\n");
                for (int i = 0; i < columnCount; i++) {
                    try {
                        sb.append(cursorRawQuery.getString(i));
                        sb.append(",");
                    } catch (java.lang.Exception unused) {
                    }
                }
                sb.append("\n");
            } while (cursorRawQuery.moveToNext());
        }
        return sb.toString();
    }

    public static java.util.ArrayList a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursorRawQuery = null;
        if (sQLiteDatabase == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
            if (cursorRawQuery.moveToFirst()) {
                do {
                    java.lang.String string = cursorRawQuery.getString(1);
                    cursorRawQuery.getString(4);
                    arrayList.add(string);
                    a(sQLiteDatabase, string);
                } while (cursorRawQuery.moveToNext());
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (java.lang.Throwable unused) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x005e A[Catch: all -> 0x00c1, TryCatch #0 {all -> 0x00c1, blocks: (B:18:0x0029, B:20:0x0035, B:22:0x003b, B:24:0x0049, B:26:0x004e, B:29:0x0058, B:33:0x00ad, B:32:0x005e), top: B:74:0x0029 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x005e, please report this as an issue */
    public static void a(android.content.Context context, com.tencent.smtt.sdk.CookieManager.a aVar, java.lang.String str, boolean z, boolean z2) {
        java.lang.String[] strArrSplit;
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC;
        if (context == null) {
            return;
        }
        if ((aVar == com.tencent.smtt.sdk.CookieManager.a.MODE_KEYS && android.text.TextUtils.isEmpty(str)) || (strArrSplit = str.split(",")) == null || strArrSplit.length < 1 || (sQLiteDatabaseC = c(context)) == null) {
            return;
        }
        java.util.HashMap map = new java.util.HashMap();
        android.database.Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabaseC.rawQuery("select * from cookies", null);
            if (cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                do {
                    java.lang.String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("host_key"));
                    if (aVar == com.tencent.smtt.sdk.CookieManager.a.MODE_KEYS) {
                        boolean z3 = false;
                        for (java.lang.String str2 : strArrSplit) {
                            if (string.equals(str2)) {
                                z3 = true;
                                break;
                            }
                        }
                        if (z3) {
                            map.put(string, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT)) + ";" + cursorRawQuery.getString(cursorRawQuery.getColumnIndex("name")) + ";" + cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("expires_utc")) + ";" + cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("priority")));
                        }
                    } else {
                        map.put(string, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT)) + ";" + cursorRawQuery.getString(cursorRawQuery.getColumnIndex("name")) + ";" + cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("expires_utc")) + ";" + cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("priority")));
                    }
                } while (cursorRawQuery.moveToNext());
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            if (sQLiteDatabaseC != null && sQLiteDatabaseC.isOpen()) {
                sQLiteDatabaseC.close();
            }
        } catch (java.lang.Throwable th) {
            try {
                android.util.Log.e(f928a, "getCookieDBVersion exception:" + th.toString());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (sQLiteDatabaseC != null && sQLiteDatabaseC.isOpen()) {
                }
            } catch (java.lang.Throwable th2) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (sQLiteDatabaseC != null && sQLiteDatabaseC.isOpen()) {
                    sQLiteDatabaseC.close();
                }
                throw th2;
            }
        }
        if (map.isEmpty()) {
            return;
        }
        b(context);
        for (java.util.Map.Entry entry : map.entrySet()) {
            com.tencent.smtt.sdk.CookieManager.getInstance().setCookie((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue(), true);
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            com.tencent.smtt.sdk.CookieManager.getInstance().flush();
        } else {
            com.tencent.smtt.sdk.CookieSyncManager.getInstance().sync();
        }
        if (z) {
            a(c(context));
            int iD = d(context);
            if (iD != -1) {
                com.tencent.smtt.sdk.CookieManager.getInstance();
                com.tencent.smtt.sdk.CookieManager.setROMCookieDBVersion(context, iD);
            }
        }
    }

    public static boolean b(android.content.Context context) {
        if (context == null) {
            return false;
        }
        com.tencent.smtt.utils.f.a(a(context), false);
        return true;
    }

    public static android.database.sqlite.SQLiteDatabase c(android.content.Context context) {
        java.io.File fileA;
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseOpenDatabase = null;
        if (context == null || (fileA = a(context)) == null) {
            return null;
        }
        try {
            sQLiteDatabaseOpenDatabase = android.database.sqlite.SQLiteDatabase.openDatabase(fileA.getAbsolutePath(), null, 0);
        } catch (java.lang.Exception unused) {
        }
        if (sQLiteDatabaseOpenDatabase == null) {
            com.tencent.smtt.utils.TbsLog.i(f928a, "dbPath is not exist!");
        }
        return sQLiteDatabaseOpenDatabase;
    }

    public static int d(android.content.Context context) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC;
        java.lang.System.currentTimeMillis();
        int i = 0;
        android.database.Cursor cursorRawQuery = null;
        try {
            sQLiteDatabaseC = c(context);
            if (sQLiteDatabaseC == null) {
                if (sQLiteDatabaseC != null && sQLiteDatabaseC.isOpen()) {
                    sQLiteDatabaseC.close();
                }
                return -1;
            }
            try {
                cursorRawQuery = sQLiteDatabaseC.rawQuery("select * from meta", null);
                int count = cursorRawQuery.getCount();
                cursorRawQuery.getColumnCount();
                if (count > 0 && cursorRawQuery.moveToFirst()) {
                    do {
                        if (cursorRawQuery.getString(0).equals(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION)) {
                            i = java.lang.Integer.parseInt(cursorRawQuery.getString(1));
                            break;
                        }
                    } while (cursorRawQuery.moveToNext());
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (sQLiteDatabaseC != null && sQLiteDatabaseC.isOpen()) {
                    sQLiteDatabaseC.close();
                }
            } catch (java.lang.Throwable unused) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (sQLiteDatabaseC != null && sQLiteDatabaseC.isOpen()) {
                }
                return i;
            }
            return i;
        } catch (java.lang.Throwable unused2) {
            sQLiteDatabaseC = null;
        }
    }
}
