package com.tencent.beaconselfupdate.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static java.util.Map f253a = null;
    private static android.content.Context b = null;
    private static java.lang.String c = "";
    private static java.lang.String d = "10000";
    private static java.lang.String e = "";
    private static java.lang.Runnable f = new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.event.UserAction.1
        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.beaconselfupdate.c.a.b(" db events to up on app call", new java.lang.Object[0]);
            try {
                com.tencent.beaconselfupdate.event.j.d(false);
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.a(th);
            }
        }
    };

    private static void a(android.content.Context context, com.tencent.beaconselfupdate.upload.UploadHandleListener uploadHandleListener, boolean z, long j) {
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.c(" the context is null! init beacon sdk failed!", new java.lang.Object[0]);
            return;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            b = applicationContext;
        } else {
            b = context;
        }
        if (j > 0) {
            if (j > 10000) {
                j = 10000;
            }
            com.tencent.beaconselfupdate.a.b.c.a(j);
        }
        long time = new java.util.Date().getTime();
        if (java.lang.Integer.valueOf(android.os.Build.VERSION.SDK).intValue() >= 14) {
            ((android.app.Application) b).registerActivityLifecycleCallbacks(new com.tencent.beaconselfupdate.a.f());
        }
        com.tencent.beaconselfupdate.c.a.a("initUserAction t1:" + (new java.util.Date().getTime() - time), new java.lang.Object[0]);
        com.tencent.beaconselfupdate.event.j.a(b, com.tencent.beaconselfupdate.event.j.a(b, a(z)), uploadHandleListener);
        com.tencent.beaconselfupdate.c.a.a("initUserAction t1:" + (new java.util.Date().getTime() - time), new java.lang.Object[0]);
    }

    private static boolean a(boolean z) {
        if (!z) {
            return false;
        }
        java.lang.String strB = com.tencent.beaconselfupdate.a.a.b(b, "pid_stat", "");
        int iMyPid = android.os.Process.myPid();
        if ("".equals(strB)) {
            com.tencent.beaconselfupdate.a.a.c(b, java.lang.String.valueOf(iMyPid));
            return true;
        }
        int iIntValue = -1;
        try {
            iIntValue = java.lang.Integer.valueOf(strB).intValue();
        } catch (java.lang.Exception unused) {
        }
        if (iIntValue == iMyPid) {
            return true;
        }
        if (com.tencent.beaconselfupdate.a.a.a(b, iIntValue)) {
            return false;
        }
        com.tencent.beaconselfupdate.a.a.c(b, strB);
        return true;
    }

    public static void doUploadRecords() {
        com.tencent.beaconselfupdate.a.b.a().a(f);
    }

    public static void flushObjectsToDB(boolean z) {
        com.tencent.beaconselfupdate.event.j.c(z);
    }

    public static java.lang.String getAPN() {
        android.content.Context context = b;
        if (context != null) {
            return com.tencent.beaconselfupdate.a.e.n(context);
        }
        com.tencent.beaconselfupdate.c.a.d("please initUserAction first!", new java.lang.Object[0]);
        return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static java.util.Map getAdditionalInfo() {
        return f253a;
    }

    public static java.lang.String getAppkey() {
        return e;
    }

    public static java.lang.String getBeaconSDKVersion() {
        return "1.7.2";
    }

    public static java.lang.String getCloudParas(java.lang.String str) {
        java.util.Map mapD = com.tencent.beaconselfupdate.a.b.d.a().d();
        if (mapD != null) {
            return (java.lang.String) mapD.get(str);
        }
        return null;
    }

    public static java.lang.String getNetWorkType() {
        android.content.Context context = b;
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d("please initUserAction first!", new java.lang.Object[0]);
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        com.tencent.beaconselfupdate.a.e.a(context);
        return com.tencent.beaconselfupdate.a.e.g(b);
    }

    public static java.lang.String getQIMEI() {
        if (b != null && com.tencent.beaconselfupdate.event.j.d() != null) {
            return com.tencent.beaconselfupdate.event.c.a(b).e();
        }
        com.tencent.beaconselfupdate.c.a.d("please initUserAction first!", new java.lang.Object[0]);
        android.content.Context context = b;
        if (context == null) {
            return "";
        }
        try {
            com.tencent.beaconselfupdate.a.e.a(context);
            java.lang.String strB = com.tencent.beaconselfupdate.a.e.b(b);
            if (!"".equals(strB)) {
                return strB;
            }
            com.tencent.beaconselfupdate.a.e.a(b);
            return com.tencent.beaconselfupdate.a.e.d(b);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String getQQ() {
        return c;
    }

    public static java.lang.String getUserID() {
        return d;
    }

    public static void initUserAction(android.content.Context context) {
        a(context, null, true, 0L);
    }

    public static void initUserAction(android.content.Context context, boolean z) {
        a(context, null, z, 0L);
    }

    public static void initUserAction(android.content.Context context, boolean z, long j) {
        a(context, null, z, j);
    }

    public static void initUserAction(android.content.Context context, boolean z, long j, com.tencent.beaconselfupdate.upload.UploadHandleListener uploadHandleListener) {
        a(context, uploadHandleListener, z, j);
    }

    public static boolean onUserAction(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        return onUserAction(str, z, j, j2, map, z2, false);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x006c  */
    public static boolean onUserAction(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        java.lang.String str2;
        if (str == null || "".equals(str.trim())) {
            com.tencent.beaconselfupdate.c.a.c("param eventName is null or \"\", please check it, return false! ", new java.lang.Object[0]);
            return false;
        }
        java.lang.String strTrim = str.replace('|', '_').trim();
        if (strTrim.length() != 0) {
            if (com.tencent.beaconselfupdate.a.e.d(strTrim)) {
                if (strTrim.length() > 128) {
                    com.tencent.beaconselfupdate.c.a.c("eventName is invalid!! eventName length should be less than 128! eventName:" + str, new java.lang.Object[0]);
                    strTrim = strTrim.substring(0, 128);
                }
                str2 = strTrim;
            } else {
                com.tencent.beaconselfupdate.c.a.c("eventName is invalid!! eventName should be ASCII code in 32-126! eventName:" + str, new java.lang.Object[0]);
            }
            if (str2 == null) {
                return false;
            }
            return com.tencent.beaconselfupdate.event.j.a(str2, z, j, j2, map, z2, z3);
        }
        com.tencent.beaconselfupdate.c.a.c("eventName is invalid!! eventName length == 0!", new java.lang.Object[0]);
        str2 = null;
        if (str2 == null) {
            return false;
        }
        return com.tencent.beaconselfupdate.event.j.a(str2, z, j, j2, map, z2, z3);
    }

    public static void setAdditionalInfo(java.util.Map map) {
        if (map == null || map.size() > 20) {
            return;
        }
        if (f253a == null) {
            f253a = new java.util.HashMap();
        }
        f253a.putAll(map);
    }

    public static void setAppkey(java.lang.String str) {
        if (str == null || str.equals("")) {
            return;
        }
        e = str;
    }

    public static void setChannelID(java.lang.String str) {
        com.tencent.beaconselfupdate.a.c cVarM = com.tencent.beaconselfupdate.a.c.m();
        if (cVarM == null) {
            com.tencent.beaconselfupdate.a.c.a(b);
            cVarM = com.tencent.beaconselfupdate.a.c.m();
        }
        if (cVarM == null) {
            com.tencent.beaconselfupdate.c.a.d("please set the channelID after call initUserAction!", new java.lang.Object[0]);
        } else {
            cVarM.c(com.tencent.beaconselfupdate.a.e.c(str));
        }
    }

    public static void setLogAble(boolean z, boolean z2) {
        com.tencent.beaconselfupdate.c.a.f247a = z;
        com.tencent.beaconselfupdate.c.a.b = z2;
    }

    public static void setQQ(java.lang.String str) {
        java.lang.Object[] objArr;
        java.lang.String str2;
        if (str != null) {
            try {
                if (java.lang.Long.parseLong(str) > 10000) {
                    c = str;
                    return;
                }
                return;
            } catch (java.lang.Exception unused) {
                objArr = new java.lang.Object[0];
                str2 = " setQQ: set qq is not available !";
            }
        } else {
            objArr = new java.lang.Object[0];
            str2 = " setQQ: set qq is null !";
        }
        com.tencent.beaconselfupdate.c.a.c(str2, objArr);
    }

    public static void setSDKVersion(java.lang.String str) {
        if (str == null || str.trim().equals("")) {
            return;
        }
        com.tencent.beaconselfupdate.a.a.a(str);
    }

    public static void setUploadMode(boolean z) {
        com.tencent.beaconselfupdate.event.j jVarD = com.tencent.beaconselfupdate.event.j.d();
        if (jVarD != null) {
            jVarD.b(z);
        } else {
            com.tencent.beaconselfupdate.c.a.c(" UserActionRecord.getInstance is null, please initUserAction first!", new java.lang.Object[0]);
        }
    }

    public static void setUserActionUsable(boolean z) {
        com.tencent.beaconselfupdate.event.j jVarD = com.tencent.beaconselfupdate.event.j.d();
        if (jVarD != null) {
            jVarD.a(z);
        } else {
            com.tencent.beaconselfupdate.c.a.c(" UserActionRecord.getInstance is null, please initUserAction first!", new java.lang.Object[0]);
        }
    }

    public static void setUserID(java.lang.String str) {
        com.tencent.beaconselfupdate.c.a.a(" setUserID:" + str, new java.lang.Object[0]);
        if (str == null || str.trim().length() <= 0 || "10000".equals(str) || "10000".equals(com.tencent.beaconselfupdate.a.e.b(str))) {
            return;
        }
        d = str;
        if (f253a == null) {
            f253a = new java.util.HashMap();
        }
        f253a.put("A1", str);
    }
}
