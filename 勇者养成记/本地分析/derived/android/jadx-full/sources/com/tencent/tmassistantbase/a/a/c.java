package com.tencent.tmassistantbase.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements com.tencent.tmassistantbase.a.a.a {
    public c() {
    }

    public c(android.content.Context context) {
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String a() {
        return "CREATE TABLE if not exists setting (_id INTEGER PRIMARY KEY AUTOINCREMENT,uin TEXT,key TEXT,value TEXT,data BLOB);";
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void a(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public void a(java.util.Map map) {
        android.database.Cursor cursorA = null;
        try {
            cursorA = b().d().a("setting", new java.lang.String[]{"uin, key, value"}, null, null, null, null, null);
            if (cursorA != null && cursorA.moveToFirst()) {
                do {
                    java.lang.String string = cursorA.getString(0);
                    java.lang.String string2 = cursorA.getString(1);
                    java.lang.String string3 = cursorA.getString(2);
                    if (string3 != null) {
                        map.put(string + "_" + string2, string3);
                    }
                } while (cursorA.moveToNext());
            }
        } catch (java.lang.Exception unused) {
        } finally {
            if (cursorA != null) {
                cursorA.close();
            }
        }
    }

    public boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return a(str, str2, str3, null);
    }

    public boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr) {
        com.tencent.tmassistantbase.a.b bVarC = b().c();
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, str3);
        if (bArr != null) {
            contentValues.put(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, bArr);
        }
        return bVarC.a("setting", contentValues, "uin=? and key=?", new java.lang.String[]{str, str2}) > 0;
    }

    public byte[] a(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        android.database.Cursor cursorA;
        android.database.Cursor cursor = null;
        if (b() != null) {
            try {
                cursorA = b().d().a("setting", new java.lang.String[]{com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA}, "uin=? and key=?", new java.lang.String[]{str, str2}, null, null, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToFirst()) {
                            byte[] blob = cursorA.getBlob(0);
                            if (cursorA != null) {
                                cursorA.close();
                            }
                            return blob;
                        }
                    } catch (java.lang.Exception unused) {
                        if (cursorA != null) {
                        }
                        return null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        cursor = cursorA;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorA != null) {
                    cursorA.close();
                }
            } catch (java.lang.Exception unused2) {
                cursorA = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String[] a(int i, int i2) {
        if (i == 6 && i2 == 7) {
            return new java.lang.String[]{"alter table setting add column data BLOB;"};
        }
        return null;
    }

    public com.tencent.tmassistantbase.a.c b() {
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB == null) {
            return null;
        }
        android.util.Log.i("getHelper", "getHelper SDKHelper.get");
        return com.tencent.tmassistantbase.a.a.a(contextB);
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void b(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public boolean b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return b(str, str2, str3, null);
    }

    public boolean b(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr) {
        com.tencent.tmassistantbase.a.b bVarC = b().c();
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("uin", str);
        contentValues.put("key", str2);
        contentValues.put(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, str3);
        if (bArr != null) {
            contentValues.put(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, bArr);
        }
        return bVarC.a("setting", null, contentValues) > 0;
    }
}
