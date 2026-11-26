package com.tencent.ydkqmsp.sdk.app;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a {
    private static boolean isLogin = false;
    private static java.lang.String mAppID;
    private static android.content.Context mContext;
    private static java.lang.String mDevID;
    private static java.lang.String mQImeiVer;
    private static java.lang.String mUid;
    private static volatile java.util.concurrent.atomic.AtomicInteger atomCbTimeout = new java.util.concurrent.atomic.AtomicInteger(com.tencent.ydkqmsp.sdk.c.h.f1317a);
    private static volatile java.util.concurrent.atomic.AtomicInteger atomConnTimeOut = new java.util.concurrent.atomic.AtomicInteger(com.tencent.ydkqmsp.sdk.c.h.b);
    private static volatile java.util.concurrent.atomic.AtomicInteger atomReadTimeOut = new java.util.concurrent.atomic.AtomicInteger(com.tencent.ydkqmsp.sdk.c.h.c);
    private static volatile java.util.concurrent.atomic.AtomicInteger atomUpdateInterval = new java.util.concurrent.atomic.AtomicInteger(com.tencent.ydkqmsp.sdk.c.h.d);
    private static byte[] LOGTag = {20, 96, -3, 98, 31, 8};
    private static byte[] Txt1 = {23, 117, -93, 69, 47, 47, 114, -7, 101, 121, -67, 73, 58, 122};
    private static boolean isTaskRuning = false;

    a() {
    }

    private static int checkParam(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (context != null && str != null && !android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str3) && !android.text.TextUtils.isEmpty(str4)) {
            return 0;
        }
        com.tencent.ydkqmsp.sdk.f.g.a(com.tencent.ydkqmsp.sdk.f.k.a(LOGTag), 0, com.tencent.ydkqmsp.sdk.f.k.a(com.tencent.ydkqmsp.sdk.f.k.f1349a));
        return -1;
    }

    public static java.lang.String getAppID() {
        return mAppID;
    }

    public static java.util.concurrent.atomic.AtomicInteger getAtomCbTimeout() {
        return atomCbTimeout;
    }

    public static java.util.concurrent.atomic.AtomicInteger getAtomConnTimeOut() {
        return atomConnTimeOut;
    }

    public static java.util.concurrent.atomic.AtomicInteger getAtomReadTimeOut() {
        return atomReadTimeOut;
    }

    public static java.util.concurrent.atomic.AtomicInteger getAtomUpdateInterval() {
        return atomUpdateInterval;
    }

    public static android.content.Context getContext() {
        return mContext;
    }

    public static java.lang.String getDevId() {
        return mDevID;
    }

    public static java.lang.String getQImeiVer() {
        return mQImeiVer;
    }

    public static boolean getTaskStatus() {
        return isTaskRuning & isLogin;
    }

    public static java.lang.String getUid() {
        return mUid;
    }

    private static void init(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        mContext = context;
        mUid = str;
        mDevID = str2;
        mAppID = str3;
        mQImeiVer = str4;
    }

    protected static int login(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        try {
            if (checkParam(context, str, str2, str3, str4) != 0) {
                return 1;
            }
            if (isLogin) {
                com.tencent.ydkqmsp.sdk.f.g.d(com.tencent.ydkqmsp.sdk.f.k.a(LOGTag), 0, com.tencent.ydkqmsp.sdk.f.k.a(Txt1));
                return 2;
            }
            setTaskStatus(true);
            init(context, str, str2, str3, str4);
            com.tencent.ydkqmsp.sdk.b.g.b().a();
            com.tencent.ydkqmsp.sdk.c.f.i().f();
            com.tencent.ydkqmsp.sdk.a.a.a(2, 4);
            return 0;
        } catch (java.lang.Exception e) {
            com.tencent.ydkqmsp.sdk.a.a.a(2, 5);
            logout();
            e.printStackTrace();
            return 3;
        }
    }

    protected static int login(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.tencent.ydkqmsp.sdk.b.f fVar) {
        try {
            if (checkParam(context, str, str2, str3, str4) != 0) {
                return 1;
            }
            if (isLogin) {
                com.tencent.ydkqmsp.sdk.f.g.d(com.tencent.ydkqmsp.sdk.f.k.a(LOGTag), 0, com.tencent.ydkqmsp.sdk.f.k.a(Txt1));
                return 2;
            }
            setTaskStatus(true);
            init(context, str, str2, str3, str4);
            com.tencent.ydkqmsp.sdk.b.g.b().a(fVar);
            com.tencent.ydkqmsp.sdk.c.f.i().f();
            com.tencent.ydkqmsp.sdk.a.a.a(2, 4);
            return 0;
        } catch (java.lang.Exception e) {
            com.tencent.ydkqmsp.sdk.a.a.a(2, 5);
            logout();
            e.printStackTrace();
            return 3;
        }
    }

    protected static void logout() {
        try {
            setTaskStatus(false);
            com.tencent.ydkqmsp.sdk.app.b.e().d();
            com.tencent.ydkqmsp.sdk.c.f.i().a();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static void reset() {
        mContext = null;
        mUid = null;
        mDevID = null;
        mAppID = null;
        isLogin = false;
        mQImeiVer = null;
    }

    private static void setTaskStatus(boolean z) {
        isTaskRuning = z;
        isLogin = z;
    }

    public static void setmUid(java.lang.String str) {
        mUid = str;
    }
}
