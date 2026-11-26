package com.tencent.ydkqmsp.sdk.g.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    public static volatile com.tencent.ydkqmsp.sdk.g.e.c g;
    public java.lang.Boolean e;
    public android.content.BroadcastReceiver f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tencent.ydkqmsp.sdk.g.e.b f1369a = new com.tencent.ydkqmsp.sdk.g.e.b("udid");
    public com.tencent.ydkqmsp.sdk.g.e.b b = new com.tencent.ydkqmsp.sdk.g.e.b(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_OAID);
    public com.tencent.ydkqmsp.sdk.g.e.b d = new com.tencent.ydkqmsp.sdk.g.e.b("vaid");
    public com.tencent.ydkqmsp.sdk.g.e.b c = new com.tencent.ydkqmsp.sdk.g.e.b("aaid");

    public static final com.tencent.ydkqmsp.sdk.g.e.c a() {
        if (g == null) {
            synchronized (com.tencent.ydkqmsp.sdk.g.e.c.class) {
                g = new com.tencent.ydkqmsp.sdk.g.e.c();
            }
        }
        return g;
    }

    public static com.tencent.ydkqmsp.sdk.g.e.e a(android.database.Cursor cursor) {
        java.lang.String str;
        com.tencent.ydkqmsp.sdk.g.e.e eVar = new com.tencent.ydkqmsp.sdk.g.e.e(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT);
                if (columnIndex >= 0) {
                    eVar.c = cursor.getString(columnIndex);
                } else {
                    b("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    eVar.f1370a = cursor.getInt(columnIndex2);
                } else {
                    b("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    eVar.b = cursor.getLong(columnIndex3);
                } else {
                    str = "parseExpired fail, index < 0.";
                }
                return eVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        b(str);
        return eVar;
    }

    public static void b(java.lang.String str) {
        com.tencent.ydkqmsp.sdk.base.c.a("MzOpenIdManager " + str);
    }

    public com.tencent.ydkqmsp.sdk.g.e.b a(java.lang.String str) {
        if (com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_OAID.equals(str)) {
            return this.b;
        }
        if ("vaid".equals(str)) {
            return this.d;
        }
        if ("aaid".equals(str)) {
            return this.c;
        }
        if ("udid".equals(str)) {
            return this.f1369a;
        }
        return null;
    }

    public final java.lang.String a(android.content.Context context, com.tencent.ydkqmsp.sdk.g.e.b bVar) throws java.lang.Throwable {
        android.database.Cursor cursorQuery;
        if (bVar == null) {
            return null;
        }
        if (bVar.a()) {
            return bVar.d;
        }
        b("queryId : " + bVar.c);
        try {
            cursorQuery = context.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{bVar.c}, null);
            try {
                if (cursorQuery == null) {
                    try {
                        a(context, false);
                        boolean zA = a(context, true);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("forceQuery isSupported : ");
                        sb.append(zA);
                        b(sb.toString());
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    } catch (java.lang.Exception unused) {
                        if (cursorQuery == null) {
                            return null;
                        }
                        cursorQuery.close();
                        return null;
                    }
                }
                try {
                    com.tencent.ydkqmsp.sdk.g.e.e eVarA = a(cursorQuery);
                    java.lang.String str = eVarA.c;
                    try {
                        bVar.a(str);
                        bVar.a(eVarA.b);
                        bVar.a(eVarA.f1370a);
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append(bVar.c);
                        sb2.append(" errorCode : ");
                        sb2.append(bVar.f1368a);
                        b(sb2.toString());
                        if (eVarA.f1370a == 1000) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return str;
                        }
                        a(context);
                        if (a(context, false)) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return str;
                        }
                        boolean zA2 = a(context, true);
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("not support, forceQuery isSupported: ");
                        sb3.append(zA2);
                        b(sb3.toString());
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return str;
                    } catch (java.lang.Exception unused2) {
                        if (cursorQuery == null) {
                            return null;
                        }
                        cursorQuery.close();
                        return null;
                    }
                } catch (java.lang.Exception unused3) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (java.lang.Exception unused4) {
            cursorQuery = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    public final void a(android.content.Context context) {
        synchronized (this) {
            if (this.f == null) {
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                com.tencent.ydkqmsp.sdk.g.e.a aVar = new com.tencent.ydkqmsp.sdk.g.e.a();
                this.f = aVar;
                context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0010  */
    public final boolean a(android.content.Context context, boolean z) {
        boolean z2;
        java.lang.Boolean bool = this.e;
        if (bool != null && !z) {
            return bool.booleanValue();
        }
        if (context != null) {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            z2 = packageManager != null;
            if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (!z2) {
            b("is not Supported, for isLegalProvider : false");
            this.e = java.lang.Boolean.FALSE;
            return false;
        }
        android.net.Uri uri = android.net.Uri.parse("content://com.meizu.flyme.openidsdk/");
        android.database.Cursor cursorQuery = null;
        try {
            try {
                android.content.ContentResolver contentResolver = context.getContentResolver();
                java.lang.String[] strArr = new java.lang.String[1];
                strArr[0] = "supported";
                cursorQuery = contentResolver.query(uri, null, null, strArr, null);
                if (cursorQuery == null) {
                    this.e = java.lang.Boolean.FALSE;
                }
                try {
                    java.lang.String str = a(cursorQuery).c;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("querySupport, result : ");
                    sb.append(str);
                    b(sb.toString());
                    java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf("0".equals(str));
                    this.e = boolValueOf;
                    return boolValueOf.booleanValue();
                } catch (java.lang.Exception unused) {
                    if (cursorQuery == null) {
                        return false;
                    }
                    return false;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (java.lang.Exception unused2) {
            if (cursorQuery == null) {
                return false;
            }
        }
    }
}
