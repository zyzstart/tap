package com.tencent.hlyyb;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HalleyAgent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f516a = false;

    private HalleyAgent() {
    }

    public static int getCurAppid() {
        return com.tencent.hlyyb.common.a.c();
    }

    public static com.tencent.hlyyb.downloader.Downloader getDownloader(com.tencent.hlyyb.a aVar) {
        if (!f516a) {
            init(aVar);
        }
        return com.tencent.hlyyb.downloader.c.a.a();
    }

    public static synchronized void init(com.tencent.hlyyb.a aVar) {
        java.lang.String str;
        if (f516a) {
            return;
        }
        java.lang.System.currentTimeMillis();
        android.os.SystemClock.elapsedRealtime();
        if (aVar == null) {
            throw new com.tencent.hlyyb.HalleyRuntimeException("initParam null");
        }
        java.lang.String packageName = aVar.a().getPackageName();
        java.lang.String strA = com.tencent.hlyyb.common.d.j.a(aVar.a());
        boolean zF = aVar.f();
        int iG = aVar.g();
        int iE = aVar.d() ? aVar.e() : com.tencent.hlyyb.common.d.j.a(aVar.a(), packageName);
        if (iE <= 0) {
            throw new com.tencent.hlyyb.HalleyRuntimeException("appid illegal:" + iE);
        }
        if (zF && iG <= 0) {
            throw new com.tencent.hlyyb.HalleyRuntimeException("testAppid illegal:" + iG);
        }
        int i = 0;
        if (!aVar.d()) {
            com.tencent.hlyyb.common.d.k kVarA = com.tencent.hlyyb.common.d.j.a(iE, aVar.a(), packageName, "com.tencent.halley.common.platform.service.PlatformService");
            if (kVarA == null) {
                throw new com.tencent.hlyyb.HalleyRuntimeException("need set PlatformService in manifest for halley");
            }
            java.lang.String str2 = kVarA.d;
            if (str2 != null && (str = kVarA.f592a) != null) {
                com.tencent.hlyyb.common.a.h = !str2.equals(str);
            }
            if (kVarA.c) {
                throw new com.tencent.hlyyb.HalleyRuntimeException("need set PlatformService exported to false");
            }
            if (!kVarA.b) {
                throw new com.tencent.hlyyb.HalleyRuntimeException("need set PlatformService enabled to true");
            }
            com.tencent.hlyyb.common.d.k kVarA2 = com.tencent.hlyyb.common.d.j.a(iE, aVar.a(), packageName, "com.tencent.halley.common.platform.service.ActivateService");
            if (kVarA2 != null) {
                if (!kVarA2.c) {
                    throw new com.tencent.hlyyb.HalleyRuntimeException("need set ActivateService exported to true");
                }
                android.os.Bundle bundle = kVarA2.e;
                if (bundle == null) {
                    throw new com.tencent.hlyyb.HalleyRuntimeException("need set security_version for ActivateService");
                }
                i = bundle.getInt("security_version");
                if (i <= 0) {
                    throw new com.tencent.hlyyb.HalleyRuntimeException("need set valid security_version for ActivateService");
                }
            }
        }
        if (!zF) {
            iG = iE;
        }
        com.tencent.hlyyb.common.a.a(zF, iG, aVar, strA, i);
        com.tencent.hlyyb.common.a.b.a();
        com.tencent.hlyyb.common.a.e.a(aVar.h());
        com.tencent.hlyyb.common.d.f.d().g();
        f516a = true;
        android.os.SystemClock.elapsedRealtime();
    }

    public static boolean isInit() {
        return f516a;
    }

    public static boolean isTestMode() {
        return com.tencent.hlyyb.common.a.b();
    }

    public static void keepPlatformAlive() {
    }

    public static void setAppisBackground(boolean z) {
        if (f516a) {
            com.tencent.hlyyb.common.d.f.d().a(z);
        }
    }

    public static void setChannelId(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.hlyyb.common.a.e = str;
    }

    public static void setCustomVersionCode(int i) {
        com.tencent.hlyyb.common.a.c = i;
    }

    public static void setCustomVersionName(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.hlyyb.common.a.f518a = str;
    }

    public static void setFileLog(boolean z, boolean z2) {
    }

    public static void updateUuid(java.lang.String str) {
        if (!f516a || str == null || str.equals(com.tencent.hlyyb.common.a.d)) {
            return;
        }
        com.tencent.hlyyb.common.a.d = str;
        com.tencent.hlyyb.common.d.f.d();
        java.lang.String str2 = com.tencent.hlyyb.common.a.d;
    }
}
