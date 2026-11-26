package com.tencent.connect.auth;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;
    private static android.content.SharedPreferences g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f468a;
    private java.lang.String b;
    private java.lang.String c;
    private int d = 1;
    private long e = -1;
    private com.tencent.open.utils.a f;

    public QQToken(java.lang.String str) {
        this.f468a = str;
    }

    @android.annotation.TargetApi(11)
    private static synchronized android.content.SharedPreferences a() {
        if (g == null) {
            g = com.tencent.open.utils.f.a().getSharedPreferences("[REDACTED]", 0);
        }
        return g;
    }

    private static java.lang.String a(java.lang.String str) {
        return android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str), 2) + "_aes_google";
    }

    private static synchronized org.json.JSONObject a(java.lang.String str, com.tencent.open.utils.a aVar) {
        java.lang.String strB;
        if (com.tencent.open.utils.f.a() == null) {
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
            return null;
        }
        if (str == null) {
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
            return null;
        }
        java.lang.String string = a().getString(a(str), "");
        if (android.text.TextUtils.isEmpty(string)) {
            if (!com.tencent.open.web.security.JniInterface.isJniOk) {
                com.tencent.open.utils.i.a(com.tencent.connect.auth.AuthAgent.SECURE_LIB_FILE_NAME, com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME, 5);
                com.tencent.open.web.security.JniInterface.loadSo();
            }
            if (!com.tencent.open.web.security.JniInterface.isJniOk) {
                com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
                return null;
            }
            java.lang.String strC = c(str);
            java.lang.String string2 = a().getString(strC, "");
            try {
                if (android.text.TextUtils.isEmpty(string2)) {
                    strC = b(str);
                    java.lang.String string3 = a().getString(strC, "");
                    try {
                        if (android.text.TextUtils.isEmpty(string3)) {
                            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
                            return null;
                        }
                        try {
                            strB = com.tencent.open.web.security.JniInterface.d1(string3);
                            if (android.text.TextUtils.isEmpty(strB)) {
                                com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
                                a().edit().remove(strC).apply();
                                return null;
                            }
                            a(str, new org.json.JSONObject(strB), aVar);
                            a().edit().remove(strC).apply();
                        } catch (java.lang.Exception e) {
                            com.tencent.open.log.SLog.e("[REDACTED]", "[REDACTED]", e);
                            a().edit().remove(strC).apply();
                            return null;
                        }
                    } catch (java.lang.Throwable th) {
                        a().edit().remove(strC).apply();
                        throw th;
                    }
                } else {
                    try {
                        strB = com.tencent.open.web.security.JniInterface.d2(string2);
                        a(str, new org.json.JSONObject(strB), aVar);
                        a().edit().remove(strC).apply();
                    } catch (java.lang.Exception e2) {
                        com.tencent.open.log.SLog.e("[REDACTED]", "[REDACTED]", e2);
                        a().edit().remove(strC).apply();
                        return null;
                    }
                }
            } catch (java.lang.Throwable th2) {
                a().edit().remove(strC).apply();
                throw th2;
            }
        } else {
            strB = aVar.b(string);
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(strB);
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
            return jSONObject;
        } catch (java.lang.Exception e3) {
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]" + e3.toString());
            return null;
        }
    }

    private static synchronized boolean a(java.lang.String str, org.json.JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        if (com.tencent.open.utils.f.a() == null) {
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
            return false;
        }
        if (str == null || jSONObject == null) {
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
            return false;
        }
        try {
            java.lang.String string = jSONObject.getString(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN);
            if (android.text.TextUtils.isEmpty(string)) {
                com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
                return false;
            }
            jSONObject.put(com.tencent.connect.common.Constants.PARAM_EXPIRES_TIME, java.lang.System.currentTimeMillis() + (java.lang.Long.parseLong(string) * 1000));
            java.lang.String strA = a(str);
            java.lang.String strA2 = aVar.a(jSONObject.toString());
            if (strA.length() > 6 && strA2 != null) {
                a().edit().putString(strA, strA2).commit();
                com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
                return true;
            }
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
            return false;
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("[REDACTED]", "[REDACTED]" + e.toString());
            return false;
        }
    }

    @java.lang.Deprecated
    private static java.lang.String b(java.lang.String str) {
        return android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str), 2);
    }

    @java.lang.Deprecated
    private static java.lang.String c(java.lang.String str) {
        return android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str), 2) + "_spkey";
    }

    public java.lang.String getAccessToken() {
        return this.b;
    }

    public java.lang.String getAppId() {
        return this.f468a;
    }

    public int getAuthSource() {
        return this.d;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public java.lang.String getOpenId() {
        return this.c;
    }

    public java.lang.String getOpenIdWithCache() {
        java.lang.String str;
        java.lang.StringBuilder sb;
        java.lang.String openId = getOpenId();
        try {
            if (android.text.TextUtils.isEmpty(openId)) {
                org.json.JSONObject jSONObjectLoadSession = loadSession(this.f468a);
                if (jSONObjectLoadSession != null) {
                    openId = jSONObjectLoadSession.getString("openid");
                    if (!android.text.TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                str = "[REDACTED]";
                sb = new java.lang.StringBuilder();
                sb.append("getOpenId from Session openId = ");
                sb.append(openId);
                sb.append(" appId = ");
                sb.append(this.f468a);
            } else {
                str = "[REDACTED]";
                sb = new java.lang.StringBuilder();
                sb.append("getOpenId from field openId = ");
                sb.append(openId);
                sb.append(" appId = ");
                sb.append(this.f468a);
            }
            com.tencent.open.log.SLog.i(str, sb.toString());
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]" + e.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.b != null && java.lang.System.currentTimeMillis() < this.e;
    }

    public org.json.JSONObject loadSession(java.lang.String str) {
        try {
            if (this.f == null) {
                this.f = new com.tencent.open.utils.a(com.tencent.open.utils.f.a());
            }
            return a(str, this.f);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]" + e.toString());
            return null;
        }
    }

    public void removeSession(java.lang.String str) {
        android.content.SharedPreferences.Editor editorEdit = a().edit();
        editorEdit.remove(c(str));
        editorEdit.remove(c(str));
        editorEdit.remove(a(str));
        editorEdit.apply();
        com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
    }

    public boolean saveSession(org.json.JSONObject jSONObject) {
        try {
            if (this.f == null) {
                this.f = new com.tencent.open.utils.a(com.tencent.open.utils.f.a());
            }
            return a(this.f468a, jSONObject, this.f);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]" + e.toString());
            return false;
        }
    }

    public void setAccessToken(java.lang.String str, java.lang.String str2) {
        this.b = str;
        this.e = 0L;
        if (str2 != null) {
            this.e = java.lang.System.currentTimeMillis() + (java.lang.Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(java.lang.String str) {
        this.f468a = str;
    }

    public void setAuthSource(int i) {
        this.d = i;
    }

    public void setOpenId(java.lang.String str) {
        this.c = str;
    }
}
