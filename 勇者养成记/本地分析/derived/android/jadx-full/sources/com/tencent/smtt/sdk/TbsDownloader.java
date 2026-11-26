package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final java.lang.String LOGTAG = "TbsDownload";
    public static final java.lang.String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f858a = false;
    private static java.lang.String b = null;
    private static android.content.Context c = null;
    private static android.os.Handler d = null;
    private static java.lang.String e = null;
    private static java.lang.Object f = new byte[0];
    private static com.tencent.smtt.sdk.j g = null;
    private static android.os.HandlerThread h = null;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static long l = -1;

    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i);
    }

    protected static java.io.File a(int i2) {
        java.lang.String str;
        java.lang.String str2;
        java.io.File file = null;
        for (java.lang.String str3 : com.tencent.smtt.sdk.TbsShareManager.getCoreProviderAppList()) {
            if (!str3.equals(c.getApplicationInfo().packageName)) {
                file = new java.io.File(com.tencent.smtt.utils.f.a(c, str3, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
                if (!file.exists()) {
                    str = LOGTAG;
                    str2 = "can not find local backup core file";
                } else {
                    if (com.tencent.smtt.utils.a.a(c, file) == i2) {
                        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                        break;
                    }
                    str = LOGTAG;
                    str2 = "version is not match";
                }
                com.tencent.smtt.utils.TbsLog.i(str, str2);
            }
        }
        return file;
    }

    private static java.lang.String a(java.lang.String str) {
        return str == null ? "" : str;
    }

    private static org.json.JSONArray a(boolean z) {
        boolean z2;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (java.lang.String str : com.tencent.smtt.sdk.TbsShareManager.getCoreProviderAppList()) {
            java.io.File file = z ? new java.io.File(com.tencent.smtt.utils.f.a(c, str, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : getBackupFileName(false)) : new java.io.File(com.tencent.smtt.utils.f.a(c, str, 4, false), "x5.tbs.decouple");
            if (file.exists()) {
                long jA = com.tencent.smtt.utils.a.a(c, file);
                if (jA > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        }
                        if (jSONArray.optInt(i2) == jA) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z2) {
                        jSONArray.put(jA);
                    }
                }
            }
        }
        return jSONArray;
    }

    private static org.json.JSONObject a(boolean z, boolean z2, boolean z3) throws java.lang.Throwable {
        int i2;
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c);
        java.lang.Object objB = b(c);
        java.lang.String strE = com.tencent.smtt.utils.b.e(c);
        java.lang.String strD = com.tencent.smtt.utils.b.d(c);
        java.lang.String strG = com.tencent.smtt.utils.b.g(c);
        java.lang.Object id = java.util.TimeZone.getDefault().getID();
        java.lang.Object obj = id != null ? id : "";
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) c.getSystemService("phone");
            if (telephonyManager != null) {
                id = telephonyManager.getSimCountryIso();
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        java.lang.Object obj2 = id != null ? id : "";
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (com.tencent.smtt.sdk.k.a(c).c("tpatch_num") < 5) {
                jSONObject.put("REQUEST_TPATCH", 1);
            } else {
                jSONObject.put("REQUEST_TPATCH", 0);
            }
            jSONObject.put("TIMEZONEID", obj);
            jSONObject.put("COUNTRYISO", obj2);
            if (com.tencent.smtt.utils.b.c()) {
                jSONObject.put("REQUEST_64", 1);
            }
            jSONObject.put("PROTOCOLVERSION", 1);
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                i2 = com.tencent.smtt.sdk.QbSdk.c ? com.tencent.smtt.sdk.TbsShareManager.a(c, false) : com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            } else {
                i2 = z3 ? com.tencent.smtt.sdk.m.a().i(c) : com.tencent.smtt.sdk.m.a().m(c);
                if (i2 == 0 && com.tencent.smtt.sdk.m.a().l(c)) {
                    i2 = -1;
                    if ("com.tencent.mobileqq".equals(c.getApplicationInfo().packageName)) {
                        com.tencent.smtt.sdk.TbsDownloadUpload.clear();
                        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                        tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_LOCAL_CORE_VERSION, -1);
                        tbsDownloadUpload.commit();
                        com.tencent.smtt.sdk.TbsPVConfig.releaseInstance();
                        if (com.tencent.smtt.sdk.TbsPVConfig.getInstance(c).getLocalCoreVersionMoreTimes() == 1) {
                            i2 = com.tencent.smtt.sdk.m.a().i(c);
                        }
                    }
                }
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + i2 + " isDownloadForeground=" + z2);
                if (z2 && !com.tencent.smtt.sdk.m.a().l(c)) {
                    i2 = 0;
                }
            }
            if (z) {
                jSONObject.put("FUNCTION", 2);
            } else {
                jSONObject.put("FUNCTION", i2 == 0 ? 0 : 1);
            }
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                org.json.JSONArray jSONArrayG = g();
                jSONObject.put("TBSVLARR", jSONArrayG);
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, jSONArrayG.toString());
                tbsDownloadConfig.commit();
                if (com.tencent.smtt.sdk.QbSdk.c) {
                    jSONObject.put("THIRDREQ", 1);
                }
            } else {
                org.json.JSONArray jSONArrayA = a(z3);
                if (com.tencent.smtt.utils.Apn.getApnType(c) != 3 && jSONArrayA.length() != 0 && i2 == 0 && z) {
                    jSONObject.put("TBSBACKUPARR", jSONArrayA);
                }
            }
            jSONObject.put("APPN", c.getPackageName());
            jSONObject.put("APPVN", a(tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null)));
            jSONObject.put("APPVC", tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0));
            jSONObject.put("APPMETA", a(tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null)));
            jSONObject.put("TBSSDKV", 43903);
            jSONObject.put("TBSV", i2);
            jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, java.lang.Integer.valueOf(z3 ? 1 : 0));
            tbsDownloadConfig.commit();
            if (i2 != 0) {
                jSONObject.put("TBSBACKUPV", g.b(z3));
            }
            jSONObject.put("CPU", e);
            jSONObject.put(com.tencent.beacon.core.event.RDBean.TP_UA, objB);
            jSONObject.put("IMSI", a(strE));
            jSONObject.put("IMEI", a(strD));
            jSONObject.put("ANDROID_ID", a(strG));
            jSONObject.put("GUID", com.tencent.smtt.utils.b.c(c));
            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                if (i2 != 0) {
                    jSONObject.put("STATUS", !com.tencent.smtt.sdk.QbSdk.a(c, i2) ? 1 : 0);
                } else {
                    jSONObject.put("STATUS", 0);
                }
                jSONObject.put("TBSDV", com.tencent.smtt.sdk.m.a().h(c));
            }
            boolean z4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
            java.lang.Object objA = com.tencent.smtt.sdk.QbSdk.a(c, "can_unlzma", (android.os.Bundle) null);
            if ((objA == null || !(objA instanceof java.lang.Boolean)) ? false : ((java.lang.Boolean) objA).booleanValue() ? !z4 : false) {
                jSONObject.put("REQUEST_LZMA", 1);
            }
            if (getOverSea(c)) {
                jSONObject.put("OVERSEA", 1);
            }
            if (z2) {
                jSONObject.put("DOWNLOAD_FOREGROUND", 1);
            }
        } catch (java.lang.Exception unused) {
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    private static void a(org.json.JSONArray jSONArray) {
        boolean z;
        java.lang.String[] strArrF = f();
        int length = strArrF.length;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                break;
            }
            java.lang.String str = strArrF[i2];
            int sharedTbsCoreVersion = com.tencent.smtt.sdk.TbsShareManager.getSharedTbsCoreVersion(c, str);
            if (sharedTbsCoreVersion > 0) {
                android.content.Context packageContext = com.tencent.smtt.sdk.TbsShareManager.getPackageContext(c, str, true);
                if (packageContext != null && !com.tencent.smtt.sdk.m.a().f(packageContext)) {
                    com.tencent.smtt.utils.TbsLog.e(LOGTAG, "host check failed,packageName = " + str);
                } else if (a(c, sharedTbsCoreVersion)) {
                    com.tencent.smtt.utils.TbsLog.i(LOGTAG, "add CoreVersionToJsonData,version+" + sharedTbsCoreVersion + " is in black list");
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (jSONArray.optInt(i3) == sharedTbsCoreVersion) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                }
            }
            i2++;
        }
        for (java.lang.String str2 : f()) {
            int coreShareDecoupleCoreVersion = com.tencent.smtt.sdk.TbsShareManager.getCoreShareDecoupleCoreVersion(c, str2);
            if (coreShareDecoupleCoreVersion > 0) {
                android.content.Context packageContext2 = com.tencent.smtt.sdk.TbsShareManager.getPackageContext(c, str2, true);
                if (packageContext2 == null || com.tencent.smtt.sdk.m.a().f(packageContext2)) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else {
                            if (jSONArray.optInt(i4) == coreShareDecoupleCoreVersion) {
                                z = true;
                                break;
                            }
                            i4++;
                        }
                    }
                    if (!z) {
                        jSONArray.put(coreShareDecoupleCoreVersion);
                    }
                } else {
                    com.tencent.smtt.utils.TbsLog.e(LOGTAG, "host check failed,packageName = " + str2);
                }
            }
        }
    }

    private static void a(boolean z, com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback tbsDownloaderCallback, boolean z2) {
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.queryConfig]");
        d.removeMessages(100);
        android.os.Message messageObtain = android.os.Message.obtain(d, 100);
        if (tbsDownloaderCallback != null) {
            messageObtain.obj = tbsDownloaderCallback;
        }
        messageObtain.arg1 = 0;
        messageObtain.arg1 = z ? 1 : 0;
        messageObtain.arg2 = z2 ? 1 : 0;
        messageObtain.sendToTarget();
    }

    static boolean a(android.content.Context context) {
        return com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1;
    }

    static boolean a(android.content.Context context, int i2) {
        return android.os.Build.VERSION.SDK_INT > 28 && context.getApplicationInfo().targetSdkVersion > 28 && i2 > 0 && i2 < 45114;
    }

    private static boolean a(android.content.Context context, boolean z) {
        int i2;
        int i3;
        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context);
        if (android.os.Build.VERSION.SDK_INT < 8) {
            i2 = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_ILLEGAL_ARG;
        } else {
            if (!com.tencent.smtt.sdk.QbSdk.c && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c) && !c()) {
                return false;
            }
            if (!tbsDownloadConfig.mPreferences.contains(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                    com.tencent.smtt.utils.TbsLog.i(LOGTAG, "needDownload-oversea is true, but not WX");
                    z = false;
                }
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, java.lang.Boolean.valueOf(z));
                tbsDownloadConfig.commit();
                j = z;
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "needDownload-first-called--isoversea = " + z);
            }
            if (!getOverSea(context) || (i3 = android.os.Build.VERSION.SDK_INT) == 16 || i3 == 17 || i3 == 18) {
                java.util.regex.Matcher matcher = null;
                java.lang.String string = tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, null);
                e = string;
                if (android.text.TextUtils.isEmpty(string)) {
                    return true;
                }
                try {
                    matcher = java.util.regex.Pattern.compile("i686|mips|x86_64").matcher(e);
                } catch (java.lang.Exception unused) {
                }
                if (matcher == null || !matcher.find()) {
                    return true;
                }
                com.tencent.smtt.utils.TbsLog.e(LOGTAG, "can not support x86 devices!!");
                i2 = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_INIT_LOAD;
            } else {
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "needDownload- return false,  because of  version is " + android.os.Build.VERSION.SDK_INT + ", and overea");
                i2 = -103;
            }
        }
        tbsDownloadConfig.setDownloadInterruptCode(i2);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x01f1  */
    private static boolean a(android.content.Context context, boolean z, boolean z2) throws java.io.IOException {
        java.lang.String str;
        boolean z3;
        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context);
        if (z) {
            str = null;
            z3 = true;
        } else {
            java.lang.String string = tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            java.lang.String string2 = tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null);
            java.lang.String strA = com.tencent.smtt.utils.b.a(c);
            int iB = com.tencent.smtt.utils.b.b(c);
            java.lang.String strA2 = com.tencent.smtt.utils.b.a(c, TBS_METADATA);
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + strA + " oldAppVersionName=" + string + " appVersionCode=" + iB + " oldAppVersionCode=" + i2 + " appMetadata=" + strA2 + " oldAppVersionMetadata=" + string2);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            long j2 = tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[TbsDownloader.needSendQueryRequest] timeLastCheck=");
            sb.append(j2);
            sb.append(" timeNow=");
            sb.append(jCurrentTimeMillis);
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, sb.toString());
            if (z2) {
                boolean zContains = tbsDownloadConfig.mPreferences.contains(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK);
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + zContains);
                if (zContains && j2 == 0) {
                    j2 = jCurrentTimeMillis;
                }
            }
            long j3 = tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, 0L);
            long j4 = tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
            long retryInterval = tbsDownloadConfig.getRetryInterval();
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "retryInterval = " + retryInterval + " s");
            com.tencent.smtt.sdk.TbsPVConfig.releaseInstance();
            int emergentCoreVersion = com.tencent.smtt.sdk.TbsPVConfig.getInstance(c).getEmergentCoreVersion();
            int i3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            long j5 = jCurrentTimeMillis - j2;
            long j6 = retryInterval * 1000;
            if (j5 <= j6 && ((emergentCoreVersion <= com.tencent.smtt.sdk.m.a().i(c) || emergentCoreVersion <= i3) && (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c) || j3 <= 0 || jCurrentTimeMillis - j3 <= j6 || j4 >= 11))) {
                if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c) && com.tencent.smtt.sdk.TbsShareManager.findCoreForThirdPartyApp(c) == 0 && !e()) {
                    com.tencent.smtt.sdk.m.a().d(c);
                } else {
                    if (strA == null || iB == 0 || strA2 == null) {
                        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                            str = "timeNow - timeLastCheck is " + j5 + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + com.tencent.smtt.sdk.TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + e() + " appVersionName is " + strA + " appVersionCode is " + iB + " appMetadata is " + strA2 + " oldAppVersionName is " + string + " oldAppVersionCode is " + i2 + " oldAppVersionMetadata is " + string2;
                        }
                        z3 = false;
                    } else if (!strA.equals(string) || iB != i2 || !strA2.equals(string2)) {
                    }
                    str = null;
                    z3 = false;
                }
                str = null;
                z3 = true;
            } else {
                str = null;
                z3 = true;
            }
        }
        if (!z3 && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
            com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = com.tencent.smtt.sdk.TbsLogReport.getInstance(c).tbsLogInfo();
            tbsLogInfo.setErrorCode(-119);
            tbsLogInfo.setFailDetail(str);
            com.tencent.smtt.sdk.TbsLogReport.getInstance(c).eventReport(com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
        }
        return z3;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x028f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x029d  */
    /* JADX WARN: Code duplicated, block: B:116:0x02a5 A[Catch: all -> 0x07a5, TryCatch #4 {, blocks: (B:112:0x0291, B:114:0x029f, B:116:0x02a5, B:118:0x02ad, B:119:0x02cc), top: B:310:0x0291 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x02d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:124:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:127:0x02de  */
    /* JADX WARN: Code duplicated, block: B:128:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:131:0x02fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:134:0x0303  */
    /* JADX WARN: Code duplicated, block: B:137:0x0309  */
    /* JADX WARN: Code duplicated, block: B:139:0x0310  */
    /* JADX WARN: Code duplicated, block: B:142:0x0325  */
    /* JADX WARN: Code duplicated, block: B:145:0x032d  */
    /* JADX WARN: Code duplicated, block: B:149:0x0336  */
    /* JADX WARN: Code duplicated, block: B:153:0x0341  */
    /* JADX WARN: Code duplicated, block: B:156:0x0352 A[Catch: Exception -> 0x036a, TRY_ENTER, TryCatch #7 {Exception -> 0x036a, blocks: (B:156:0x0352, B:158:0x035a), top: B:316:0x0350 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x035a A[Catch: Exception -> 0x036a, TRY_LEAVE, TryCatch #7 {Exception -> 0x036a, blocks: (B:156:0x0352, B:158:0x035a), top: B:316:0x0350 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x037e  */
    /* JADX WARN: Code duplicated, block: B:171:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:172:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:177:0x03ea A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:183:0x0401  */
    /* JADX WARN: Code duplicated, block: B:193:0x0441  */
    /* JADX WARN: Code duplicated, block: B:195:0x0457  */
    /* JADX WARN: Code duplicated, block: B:196:0x0465  */
    /* JADX WARN: Code duplicated, block: B:199:0x0480  */
    /* JADX WARN: Code duplicated, block: B:202:0x048c  */
    /* JADX WARN: Code duplicated, block: B:204:0x049d  */
    /* JADX WARN: Code duplicated, block: B:207:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:209:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:210:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:212:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:214:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:217:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:221:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:223:0x0505  */
    /* JADX WARN: Code duplicated, block: B:225:0x0513 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:226:0x0515  */
    /* JADX WARN: Code duplicated, block: B:227:0x051a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:228:0x051c  */
    /* JADX WARN: Code duplicated, block: B:229:0x0521  */
    /* JADX WARN: Code duplicated, block: B:230:0x0526  */
    /* JADX WARN: Code duplicated, block: B:232:0x052e  */
    /* JADX WARN: Code duplicated, block: B:233:0x0531 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:234:0x0533  */
    /* JADX WARN: Code duplicated, block: B:235:0x0536 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:236:0x0538  */
    /* JADX WARN: Code duplicated, block: B:242:0x058b  */
    /* JADX WARN: Code duplicated, block: B:245:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:247:0x05cc  */
    /* JADX WARN: Code duplicated, block: B:248:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:252:0x065e  */
    /* JADX WARN: Code duplicated, block: B:255:0x0669 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:262:0x06a6  */
    /* JADX WARN: Code duplicated, block: B:264:0x06aa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:279:0x070e  */
    /* JADX WARN: Code duplicated, block: B:281:0x0720  */
    /* JADX WARN: Code duplicated, block: B:288:0x0777 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:289:0x0779  */
    /* JADX WARN: Code duplicated, block: B:293:0x0798  */
    /* JADX WARN: Code duplicated, block: B:310:0x0291 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:328:0x03ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:142:0x0325, please report this as an issue */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.annotation.TargetApi(11)
    private static boolean a(java.lang.String str, int i2, boolean z, boolean z2, boolean z3) throws java.lang.Throwable {
        int i3;
        int i4;
        boolean z4;
        java.lang.String string;
        int i5;
        int i6;
        boolean z5;
        java.lang.String str2;
        java.lang.String str3;
        boolean z6;
        boolean z7;
        int i7;
        int i8;
        long j2;
        long retryIntervalInSeconds;
        int iH;
        int i9;
        int i10;
        boolean z8;
        int i11;
        java.util.Map map;
        int i12;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport;
        com.tencent.smtt.sdk.TbsLogReport.EventType eventType;
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport2;
        com.tencent.smtt.sdk.TbsLogReport.EventType eventType2;
        int iE;
        boolean z9;
        int i13;
        int i14;
        boolean z10;
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] response=" + str + "isNeedInstall=" + z3);
        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c);
        if (android.text.TextUtils.isEmpty(str)) {
            tbsDownloadConfig.setDownloadInterruptCode(z ? com.tencent.safecloud.device.openlib.DeviceConfig.ERR_REQ_DATA : -208);
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #1,response is empty...");
            return false;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
        int i15 = jSONObject.getInt("RET");
        if (i15 != 0) {
            tbsDownloadConfig.setDownloadInterruptCode(z ? com.tencent.safecloud.device.openlib.DeviceConfig.ERR_REQ_OVER : -209);
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #2,returnCode=" + i15);
            return false;
        }
        int i16 = jSONObject.getInt("RESPONSECODE");
        java.lang.String string2 = jSONObject.getString("DOWNLOADURL");
        java.lang.String strOptString = jSONObject.optString("URLLIST", "");
        int i17 = jSONObject.getInt("TBSAPKSERVERVERSION");
        int i18 = jSONObject.getInt("DOWNLOADMAXFLOW");
        int i19 = jSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
        int i20 = jSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
        int i21 = jSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
        long j3 = jSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
        long j4 = jSONObject.getLong("TBSAPKFILESIZE");
        long jOptLong = jSONObject.optLong("RETRY_INTERVAL", 0L);
        int iOptInt = jSONObject.optInt("FLOWCTR", -1);
        try {
            i3 = jSONObject.getInt("USEBBACKUPVER");
        } catch (java.lang.Exception unused) {
            i3 = 0;
        }
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, java.lang.Integer.valueOf(i3));
        if (z && com.tencent.smtt.sdk.QbSdk.i && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
            try {
                i4 = i21;
                try {
                    com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, com.tencent.smtt.sdk.TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME, jSONObject.optInt("BUGLY", 0) == 1);
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.tencent.smtt.utils.TbsLog.i("qbsdk", "throwable:" + th.toString());
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                i4 = i21;
            }
        } else {
            i4 = i21;
        }
        if (z) {
            try {
                int iOptInt2 = jSONObject.optInt("TEMPLATESWITCH", 0);
                boolean z11 = (iOptInt2 & 1) != 0;
                com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, com.tencent.smtt.sdk.TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME, z11);
                com.tencent.smtt.utils.TbsLog.w(LOGTAG, "useCookieCompatiable:" + z11);
                boolean z12 = (iOptInt2 & 2) != 0;
                com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, com.tencent.smtt.sdk.TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME, z12);
                com.tencent.smtt.utils.TbsLog.w(LOGTAG, "disableGetApkVersionByReadFile:" + z12);
                boolean z13 = (iOptInt2 & 4) != 0;
                com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, com.tencent.smtt.sdk.TbsExtensionFunctionManager.DISABLE_UNPREINIT, z13);
                com.tencent.smtt.sdk.QbSdk.setDisableUnpreinitBySwitch(z13);
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "disableUnpreinitBySwitch:" + z13);
                boolean z14 = (iOptInt2 & 8) != 0;
                com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, com.tencent.smtt.sdk.TbsExtensionFunctionManager.DISABLE_USE_HOST_BACKUP_CORE, z14);
                com.tencent.smtt.sdk.QbSdk.setDisableUseHostBackupCoreBySwitch(z14);
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "disableUseHostBackupCoreBySwitch:" + z14);
            } catch (java.lang.Throwable th3) {
                com.tencent.smtt.utils.TbsLog.i("qbsdk", "throwable:" + th3.toString());
            }
        }
        java.lang.String string3 = "";
        try {
            try {
                string = jSONObject.getString("PKGMD5");
                try {
                    i5 = jSONObject.getInt("RESETX5");
                    try {
                        i6 = jSONObject.getInt("UPLOADLOG");
                        try {
                            z4 = jSONObject.has("[REDACTED]") && jSONObject.getInt("[REDACTED]") != 0;
                            try {
                                string3 = jSONObject.has("[REDACTED]") ? jSONObject.getString("[REDACTED]") : "[REDACTED]";
                                z5 = (jSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK") && jSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK") == 0) ? false : true;
                                try {
                                    if (jSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT") && jSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT") == 0) {
                                        str2 = string;
                                        str3 = string3;
                                        z6 = z5;
                                        z7 = false;
                                    } else {
                                        str2 = string;
                                        str3 = string3;
                                        z6 = z5;
                                        z7 = true;
                                    }
                                } catch (java.lang.Exception unused2) {
                                }
                            } catch (java.lang.Exception unused3) {
                                z5 = true;
                            }
                        } catch (java.lang.Exception unused4) {
                            string3 = "";
                            z4 = false;
                        }
                    } catch (java.lang.Exception unused5) {
                        string3 = "";
                        z4 = false;
                        i6 = 0;
                        z5 = true;
                        str2 = string;
                        str3 = string3;
                        z6 = z5;
                        z7 = true;
                        i7 = jSONObject.getInt("RESETDECOUPLECORE");
                        i8 = jSONObject.getInt("RESETTODECOUPLECORE");
                        synchronized (f) {
                            if (z4) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "[REDACTED]");
                            }
                            if (!android.text.TextUtils.isEmpty(str3)) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, str3 + "[REDACTED]" + com.tencent.smtt.utils.h.c());
                            }
                            if (i5 == 1) {
                                if (z) {
                                    i14 = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_RESULT_PARSE;
                                } else {
                                    i14 = -210;
                                }
                                tbsDownloadConfig.setDownloadInterruptCode(i14);
                                android.content.Context context = c;
                                if (i8 == 1) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                com.tencent.smtt.sdk.QbSdk.reset(context, z10);
                                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=" + z);
                                return false;
                            }
                            if (!z6) {
                                tbsDownloadConfig.setTbsCoreLoadRenameFileLockEnable(z6);
                            }
                            if (!z7) {
                                tbsDownloadConfig.setTbsCoreLoadRenameFileLockWaitEnable(z7);
                            }
                            if (i7 == 1) {
                                com.tencent.smtt.sdk.QbSdk.resetDecoupleCore(c);
                            }
                            if (i6 == 1) {
                                d.removeMessages(104);
                                android.os.Message.obtain(d, 104).sendToTarget();
                            }
                            try {
                                try {
                                    if (iOptInt == 1) {
                                        retryIntervalInSeconds = jOptLong <= 604800 ? jOptLong : 604800L;
                                        j2 = 0;
                                        if (retryIntervalInSeconds <= 0) {
                                        }
                                        if (getRetryIntervalInSeconds() >= j2) {
                                            retryIntervalInSeconds = getRetryIntervalInSeconds();
                                        }
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, java.lang.Long.valueOf(retryIntervalInSeconds));
                                        if (z) {
                                            i13 = jSONObject.getInt("DECOUPLECOREVERSION");
                                        } else {
                                            i13 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                                        }
                                        iH = i13;
                                        i9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
                                        if (z) {
                                            iH = com.tencent.smtt.sdk.m.a().h(c);
                                        }
                                        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response decoupleCoreVersion is " + iH);
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, java.lang.Integer.valueOf(iH));
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, java.lang.Integer.valueOf(i9));
                                        if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                                            if (iH <= 0) {
                                                if (iH == 0) {
                                                    try {
                                                        com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
                                                    } catch (java.lang.Throwable unused6) {
                                                    }
                                                }
                                            } else if (iH == 0) {
                                                com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
                                            }
                                        }
                                        if (!android.text.TextUtils.isEmpty(string2)) {
                                        }
                                        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response responseCode is " + i16);
                                        if (i16 == 0) {
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                                            if (z) {
                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_CONNECT));
                                            } else {
                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -211);
                                                tbsDownloadConfig.setDownloadInterruptCode(-211);
                                            }
                                            tbsDownloadConfig.commit();
                                            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                                                startDecoupleCoreIfNeeded();
                                            }
                                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
                                            return false;
                                        }
                                        i10 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                                        if (i10 > i17) {
                                            g.c();
                                            com.tencent.smtt.sdk.m.a().o(c);
                                        }
                                        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                                            z8 = false;
                                        } else {
                                            iE = com.tencent.smtt.sdk.m.a().e(c, 0);
                                            if (iE >= i17) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "tmpCoreVersion is " + iE + " tbsDownloadVersion is" + i17);
                                        }
                                        if (i2 < i17) {
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                                            if (z) {
                                                if (android.text.TextUtils.isEmpty(string2)) {
                                                    map = tbsDownloadConfig.mSyncMap;
                                                    i12 = -124;
                                                } else if (i17 <= 0) {
                                                    map = tbsDownloadConfig.mSyncMap;
                                                    i12 = -125;
                                                } else if (i2 >= i17) {
                                                    map = tbsDownloadConfig.mSyncMap;
                                                    i12 = -127;
                                                } else {
                                                    map = tbsDownloadConfig.mSyncMap;
                                                    i12 = -112;
                                                }
                                                map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
                                            } else {
                                                i11 = -212;
                                                if (android.text.TextUtils.isEmpty(string2)) {
                                                    i11 = -217;
                                                } else if (i17 <= 0) {
                                                    i11 = -218;
                                                } else if (i2 >= i17) {
                                                    i11 = -219;
                                                }
                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
                                                tbsDownloadConfig.setDownloadInterruptCode(i11);
                                            }
                                            tbsDownloadConfig.commit();
                                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
                                            return false;
                                        }
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                                        if (z) {
                                            if (android.text.TextUtils.isEmpty(string2)) {
                                                map = tbsDownloadConfig.mSyncMap;
                                                i12 = -124;
                                            } else if (i17 <= 0) {
                                                map = tbsDownloadConfig.mSyncMap;
                                                i12 = -125;
                                            } else if (i2 >= i17) {
                                                map = tbsDownloadConfig.mSyncMap;
                                                i12 = -127;
                                            } else {
                                                map = tbsDownloadConfig.mSyncMap;
                                                i12 = -112;
                                            }
                                            map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
                                        } else {
                                            i11 = -212;
                                            if (android.text.TextUtils.isEmpty(string2)) {
                                                i11 = -217;
                                            } else if (i17 <= 0) {
                                                i11 = -218;
                                            } else if (i2 >= i17) {
                                                i11 = -219;
                                            }
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
                                            tbsDownloadConfig.setDownloadInterruptCode(i11);
                                        }
                                        tbsDownloadConfig.commit();
                                        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
                                        return false;
                                        if (!string2.equals(tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
                                            g.c();
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0);
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0);
                                        }
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, java.lang.Integer.valueOf(i17));
                                        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is " + i17);
                                        if (i17 > 0) {
                                            if (i9 == 1) {
                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 1);
                                            } else {
                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0);
                                            }
                                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V_TYPE is " + i9);
                                        }
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string2);
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, strOptString);
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, java.lang.Integer.valueOf(i18));
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, java.lang.Integer.valueOf(i19));
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, java.lang.Integer.valueOf(i20));
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, java.lang.Integer.valueOf(i4));
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, java.lang.Long.valueOf(j3));
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, java.lang.Long.valueOf(j4));
                                        tbsDownloadConfig.commit();
                                        str4 = str2;
                                        if (str4 != null) {
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, str4);
                                        }
                                        if (!z2) {
                                            if (!z2) {
                                                if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                                    if (!z) {
                                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                                    }
                                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                                    str5 = LOGTAG;
                                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                                } else {
                                                    if (!z) {
                                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                                    }
                                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                                    str5 = LOGTAG;
                                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                                }
                                            } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                                if (!z) {
                                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                                }
                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                                str5 = LOGTAG;
                                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                            } else {
                                                if (!z) {
                                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                                }
                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                                str5 = LOGTAG;
                                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                            }
                                        } else if (!z2) {
                                            if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                                if (!z) {
                                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                                }
                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                                str5 = LOGTAG;
                                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                            } else {
                                                if (!z) {
                                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                                }
                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                                str5 = LOGTAG;
                                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                            }
                                        } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                            if (!z) {
                                                tbsDownloadConfig.setDownloadInterruptCode(-216);
                                            }
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                            str5 = LOGTAG;
                                            str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                        } else {
                                            if (!z) {
                                                tbsDownloadConfig.setDownloadInterruptCode(-216);
                                            }
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                            str5 = LOGTAG;
                                            str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                        }
                                        com.tencent.smtt.utils.TbsLog.i(str5, str6);
                                        if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, java.lang.Boolean.TRUE);
                                        }
                                        tbsDownloadConfig.commit();
                                        return true;
                                    }
                                    j2 = 0;
                                    i9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
                                } catch (java.lang.Exception unused7) {
                                    i9 = 0;
                                }
                                if (z) {
                                    i13 = jSONObject.getInt("DECOUPLECOREVERSION");
                                } else {
                                    i13 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                                }
                                iH = i13;
                            } catch (java.lang.Exception unused8) {
                                iH = 0;
                            }
                            retryIntervalInSeconds = 86400;
                            if (getRetryIntervalInSeconds() >= j2) {
                                retryIntervalInSeconds = getRetryIntervalInSeconds();
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, java.lang.Long.valueOf(retryIntervalInSeconds));
                            if (z) {
                                iH = com.tencent.smtt.sdk.m.a().h(c);
                            }
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response decoupleCoreVersion is " + iH);
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, java.lang.Integer.valueOf(iH));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, java.lang.Integer.valueOf(i9));
                            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                                if (iH <= 0) {
                                    if (iH == 0) {
                                        com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
                                    }
                                } else if (iH == 0) {
                                    com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
                                }
                            }
                            if (!android.text.TextUtils.isEmpty(string2)) {
                            }
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response responseCode is " + i16);
                            if (i16 == 0) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                                if (z) {
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_CONNECT));
                                } else {
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -211);
                                    tbsDownloadConfig.setDownloadInterruptCode(-211);
                                }
                                tbsDownloadConfig.commit();
                                if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                                    startDecoupleCoreIfNeeded();
                                }
                                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
                                return false;
                            }
                            i10 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                            if (i10 > i17) {
                                g.c();
                                com.tencent.smtt.sdk.m.a().o(c);
                            }
                            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                                iE = com.tencent.smtt.sdk.m.a().e(c, 0);
                                if (iE >= i17) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "tmpCoreVersion is " + iE + " tbsDownloadVersion is" + i17);
                            } else {
                                z8 = false;
                            }
                            if (i2 < i17) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                                if (z) {
                                    if (android.text.TextUtils.isEmpty(string2)) {
                                        map = tbsDownloadConfig.mSyncMap;
                                        i12 = -124;
                                    } else if (i17 <= 0) {
                                        map = tbsDownloadConfig.mSyncMap;
                                        i12 = -125;
                                    } else if (i2 >= i17) {
                                        map = tbsDownloadConfig.mSyncMap;
                                        i12 = -127;
                                    } else {
                                        map = tbsDownloadConfig.mSyncMap;
                                        i12 = -112;
                                    }
                                    map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
                                } else {
                                    i11 = -212;
                                    if (android.text.TextUtils.isEmpty(string2)) {
                                        i11 = -217;
                                    } else if (i17 <= 0) {
                                        i11 = -218;
                                    } else if (i2 >= i17) {
                                        i11 = -219;
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
                                    tbsDownloadConfig.setDownloadInterruptCode(i11);
                                }
                                tbsDownloadConfig.commit();
                                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
                                return false;
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                            if (z) {
                                if (android.text.TextUtils.isEmpty(string2)) {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -124;
                                } else if (i17 <= 0) {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -125;
                                } else if (i2 >= i17) {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -127;
                                } else {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -112;
                                }
                                map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
                            } else {
                                i11 = -212;
                                if (android.text.TextUtils.isEmpty(string2)) {
                                    i11 = -217;
                                } else if (i17 <= 0) {
                                    i11 = -218;
                                } else if (i2 >= i17) {
                                    i11 = -219;
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
                                tbsDownloadConfig.setDownloadInterruptCode(i11);
                            }
                            tbsDownloadConfig.commit();
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
                            return false;
                            if (!string2.equals(tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
                                g.c();
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0);
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0);
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, java.lang.Integer.valueOf(i17));
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is " + i17);
                            if (i17 > 0) {
                                if (i9 == 1) {
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 1);
                                } else {
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0);
                                }
                                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V_TYPE is " + i9);
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string2);
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, strOptString);
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, java.lang.Integer.valueOf(i18));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, java.lang.Integer.valueOf(i19));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, java.lang.Integer.valueOf(i20));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, java.lang.Integer.valueOf(i4));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, java.lang.Long.valueOf(j3));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, java.lang.Long.valueOf(j4));
                            tbsDownloadConfig.commit();
                            str4 = str2;
                            if (str4 != null) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, str4);
                            }
                            if (!z2) {
                                if (!z2) {
                                    if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                        if (!z) {
                                            tbsDownloadConfig.setDownloadInterruptCode(-216);
                                        }
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                        str5 = LOGTAG;
                                        str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                    } else {
                                        if (!z) {
                                            tbsDownloadConfig.setDownloadInterruptCode(-216);
                                        }
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                        str5 = LOGTAG;
                                        str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                    }
                                } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                    if (!z) {
                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    str5 = LOGTAG;
                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                } else {
                                    if (!z) {
                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    str5 = LOGTAG;
                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                }
                            } else if (!z2) {
                                if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                    if (!z) {
                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    str5 = LOGTAG;
                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                } else {
                                    if (!z) {
                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    str5 = LOGTAG;
                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                }
                            } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                if (!z) {
                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                str5 = LOGTAG;
                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                            } else {
                                if (!z) {
                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                str5 = LOGTAG;
                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                            }
                            com.tencent.smtt.utils.TbsLog.i(str5, str6);
                            if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, java.lang.Boolean.TRUE);
                            }
                            tbsDownloadConfig.commit();
                            return true;
                        }
                    }
                } catch (java.lang.Exception unused9) {
                    z4 = false;
                    i5 = 0;
                    i6 = 0;
                    z5 = true;
                    str2 = string;
                    str3 = string3;
                    z6 = z5;
                    z7 = true;
                    i7 = jSONObject.getInt("RESETDECOUPLECORE");
                    i8 = jSONObject.getInt("RESETTODECOUPLECORE");
                    synchronized (f) {
                        if (z4) {
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "[REDACTED]");
                        }
                        if (!android.text.TextUtils.isEmpty(str3)) {
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, str3 + "[REDACTED]" + com.tencent.smtt.utils.h.c());
                        }
                        if (i5 == 1) {
                            if (z) {
                                i14 = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_RESULT_PARSE;
                            } else {
                                i14 = -210;
                            }
                            tbsDownloadConfig.setDownloadInterruptCode(i14);
                            android.content.Context context2 = c;
                            if (i8 == 1) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            com.tencent.smtt.sdk.QbSdk.reset(context2, z10);
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=" + z);
                            return false;
                        }
                        if (!z6) {
                            tbsDownloadConfig.setTbsCoreLoadRenameFileLockEnable(z6);
                        }
                        if (!z7) {
                            tbsDownloadConfig.setTbsCoreLoadRenameFileLockWaitEnable(z7);
                        }
                        if (i7 == 1) {
                            com.tencent.smtt.sdk.QbSdk.resetDecoupleCore(c);
                        }
                        if (i6 == 1) {
                            d.removeMessages(104);
                            android.os.Message.obtain(d, 104).sendToTarget();
                        }
                        if (iOptInt == 1) {
                            if (jOptLong <= 604800) {
                            }
                            j2 = 0;
                            if (retryIntervalInSeconds <= 0) {
                            }
                            if (getRetryIntervalInSeconds() >= j2) {
                                retryIntervalInSeconds = getRetryIntervalInSeconds();
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, java.lang.Long.valueOf(retryIntervalInSeconds));
                            if (z) {
                                i13 = jSONObject.getInt("DECOUPLECOREVERSION");
                            } else {
                                i13 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                            }
                            iH = i13;
                            i9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
                            if (z) {
                                iH = com.tencent.smtt.sdk.m.a().h(c);
                            }
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response decoupleCoreVersion is " + iH);
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, java.lang.Integer.valueOf(iH));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, java.lang.Integer.valueOf(i9));
                            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                                if (iH <= 0) {
                                    if (iH == 0) {
                                        com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
                                    }
                                } else if (iH == 0) {
                                    com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
                                }
                            }
                            if (!android.text.TextUtils.isEmpty(string2)) {
                            }
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response responseCode is " + i16);
                            if (i16 == 0) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                                if (z) {
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_CONNECT));
                                } else {
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -211);
                                    tbsDownloadConfig.setDownloadInterruptCode(-211);
                                }
                                tbsDownloadConfig.commit();
                                if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                                    startDecoupleCoreIfNeeded();
                                }
                                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
                                return false;
                            }
                            i10 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                            if (i10 > i17) {
                                g.c();
                                com.tencent.smtt.sdk.m.a().o(c);
                            }
                            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                                iE = com.tencent.smtt.sdk.m.a().e(c, 0);
                                if (iE >= i17) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "tmpCoreVersion is " + iE + " tbsDownloadVersion is" + i17);
                            } else {
                                z8 = false;
                            }
                            if (i2 < i17) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                                if (z) {
                                    if (android.text.TextUtils.isEmpty(string2)) {
                                        map = tbsDownloadConfig.mSyncMap;
                                        i12 = -124;
                                    } else if (i17 <= 0) {
                                        map = tbsDownloadConfig.mSyncMap;
                                        i12 = -125;
                                    } else if (i2 >= i17) {
                                        map = tbsDownloadConfig.mSyncMap;
                                        i12 = -127;
                                    } else {
                                        map = tbsDownloadConfig.mSyncMap;
                                        i12 = -112;
                                    }
                                    map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
                                } else {
                                    i11 = -212;
                                    if (android.text.TextUtils.isEmpty(string2)) {
                                        i11 = -217;
                                    } else if (i17 <= 0) {
                                        i11 = -218;
                                    } else if (i2 >= i17) {
                                        i11 = -219;
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
                                    tbsDownloadConfig.setDownloadInterruptCode(i11);
                                }
                                tbsDownloadConfig.commit();
                                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
                                return false;
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                            if (z) {
                                if (android.text.TextUtils.isEmpty(string2)) {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -124;
                                } else if (i17 <= 0) {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -125;
                                } else if (i2 >= i17) {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -127;
                                } else {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -112;
                                }
                                map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
                            } else {
                                i11 = -212;
                                if (android.text.TextUtils.isEmpty(string2)) {
                                    i11 = -217;
                                } else if (i17 <= 0) {
                                    i11 = -218;
                                } else if (i2 >= i17) {
                                    i11 = -219;
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
                                tbsDownloadConfig.setDownloadInterruptCode(i11);
                            }
                            tbsDownloadConfig.commit();
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
                            return false;
                            if (!string2.equals(tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
                                g.c();
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0);
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0);
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, java.lang.Integer.valueOf(i17));
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is " + i17);
                            if (i17 > 0) {
                                if (i9 == 1) {
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 1);
                                } else {
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0);
                                }
                                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V_TYPE is " + i9);
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string2);
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, strOptString);
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, java.lang.Integer.valueOf(i18));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, java.lang.Integer.valueOf(i19));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, java.lang.Integer.valueOf(i20));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, java.lang.Integer.valueOf(i4));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, java.lang.Long.valueOf(j3));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, java.lang.Long.valueOf(j4));
                            tbsDownloadConfig.commit();
                            str4 = str2;
                            if (str4 != null) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, str4);
                            }
                            if (!z2) {
                                if (!z2) {
                                    if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                        if (!z) {
                                            tbsDownloadConfig.setDownloadInterruptCode(-216);
                                        }
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                        str5 = LOGTAG;
                                        str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                    } else {
                                        if (!z) {
                                            tbsDownloadConfig.setDownloadInterruptCode(-216);
                                        }
                                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                        str5 = LOGTAG;
                                        str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                    }
                                } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                    if (!z) {
                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    str5 = LOGTAG;
                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                } else {
                                    if (!z) {
                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    str5 = LOGTAG;
                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                }
                            } else if (!z2) {
                                if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                    if (!z) {
                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    str5 = LOGTAG;
                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                } else {
                                    if (!z) {
                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    str5 = LOGTAG;
                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                }
                            } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                if (!z) {
                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                str5 = LOGTAG;
                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                            } else {
                                if (!z) {
                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                str5 = LOGTAG;
                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                            }
                            com.tencent.smtt.utils.TbsLog.i(str5, str6);
                            if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, java.lang.Boolean.TRUE);
                            }
                            tbsDownloadConfig.commit();
                            return true;
                        }
                        j2 = 0;
                        retryIntervalInSeconds = 86400;
                        if (getRetryIntervalInSeconds() >= j2) {
                            retryIntervalInSeconds = getRetryIntervalInSeconds();
                        }
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, java.lang.Long.valueOf(retryIntervalInSeconds));
                        if (z) {
                            i13 = jSONObject.getInt("DECOUPLECOREVERSION");
                        } else {
                            i13 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                        }
                        iH = i13;
                        i9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
                        if (z) {
                            iH = com.tencent.smtt.sdk.m.a().h(c);
                        }
                        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response decoupleCoreVersion is " + iH);
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, java.lang.Integer.valueOf(iH));
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, java.lang.Integer.valueOf(i9));
                        if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                            if (iH <= 0) {
                                if (iH == 0) {
                                    com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
                                }
                            } else if (iH == 0) {
                                com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
                            }
                        }
                        if (!android.text.TextUtils.isEmpty(string2)) {
                        }
                        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response responseCode is " + i16);
                        if (i16 == 0) {
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                            if (z) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_CONNECT));
                            } else {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -211);
                                tbsDownloadConfig.setDownloadInterruptCode(-211);
                            }
                            tbsDownloadConfig.commit();
                            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                                startDecoupleCoreIfNeeded();
                            }
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
                            return false;
                        }
                        i10 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                        if (i10 > i17) {
                            g.c();
                            com.tencent.smtt.sdk.m.a().o(c);
                        }
                        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                            iE = com.tencent.smtt.sdk.m.a().e(c, 0);
                            if (iE >= i17) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "tmpCoreVersion is " + iE + " tbsDownloadVersion is" + i17);
                        } else {
                            z8 = false;
                        }
                        if (i2 < i17) {
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                            if (z) {
                                if (android.text.TextUtils.isEmpty(string2)) {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -124;
                                } else if (i17 <= 0) {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -125;
                                } else if (i2 >= i17) {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -127;
                                } else {
                                    map = tbsDownloadConfig.mSyncMap;
                                    i12 = -112;
                                }
                                map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
                            } else {
                                i11 = -212;
                                if (android.text.TextUtils.isEmpty(string2)) {
                                    i11 = -217;
                                } else if (i17 <= 0) {
                                    i11 = -218;
                                } else if (i2 >= i17) {
                                    i11 = -219;
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
                                tbsDownloadConfig.setDownloadInterruptCode(i11);
                            }
                            tbsDownloadConfig.commit();
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
                            return false;
                        }
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                        if (z) {
                            if (android.text.TextUtils.isEmpty(string2)) {
                                map = tbsDownloadConfig.mSyncMap;
                                i12 = -124;
                            } else if (i17 <= 0) {
                                map = tbsDownloadConfig.mSyncMap;
                                i12 = -125;
                            } else if (i2 >= i17) {
                                map = tbsDownloadConfig.mSyncMap;
                                i12 = -127;
                            } else {
                                map = tbsDownloadConfig.mSyncMap;
                                i12 = -112;
                            }
                            map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
                        } else {
                            i11 = -212;
                            if (android.text.TextUtils.isEmpty(string2)) {
                                i11 = -217;
                            } else if (i17 <= 0) {
                                i11 = -218;
                            } else if (i2 >= i17) {
                                i11 = -219;
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
                            tbsDownloadConfig.setDownloadInterruptCode(i11);
                        }
                        tbsDownloadConfig.commit();
                        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
                        return false;
                        if (!string2.equals(tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
                            g.c();
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0);
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0);
                        }
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, java.lang.Integer.valueOf(i17));
                        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is " + i17);
                        if (i17 > 0) {
                            if (i9 == 1) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 1);
                            } else {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0);
                            }
                            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V_TYPE is " + i9);
                        }
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string2);
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, strOptString);
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, java.lang.Integer.valueOf(i18));
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, java.lang.Integer.valueOf(i19));
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, java.lang.Integer.valueOf(i20));
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, java.lang.Integer.valueOf(i4));
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, java.lang.Long.valueOf(j3));
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, java.lang.Long.valueOf(j4));
                        tbsDownloadConfig.commit();
                        str4 = str2;
                        if (str4 != null) {
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, str4);
                        }
                        if (!z2) {
                            if (!z2) {
                                if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                    if (!z) {
                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    str5 = LOGTAG;
                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                } else {
                                    if (!z) {
                                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                                    }
                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    str5 = LOGTAG;
                                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                                }
                            } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                if (!z) {
                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                str5 = LOGTAG;
                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                            } else {
                                if (!z) {
                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                str5 = LOGTAG;
                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                            }
                        } else if (!z2) {
                            if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                if (!z) {
                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                str5 = LOGTAG;
                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                            } else {
                                if (!z) {
                                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                                }
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                str5 = LOGTAG;
                                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                            }
                        } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                            if (!z) {
                                tbsDownloadConfig.setDownloadInterruptCode(-216);
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                            str5 = LOGTAG;
                            str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                        } else {
                            if (!z) {
                                tbsDownloadConfig.setDownloadInterruptCode(-216);
                            }
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                            str5 = LOGTAG;
                            str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                        }
                        com.tencent.smtt.utils.TbsLog.i(str5, str6);
                        if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, java.lang.Boolean.TRUE);
                        }
                        tbsDownloadConfig.commit();
                        return true;
                    }
                }
            } catch (java.lang.Exception unused10) {
                z4 = false;
                string = null;
            }
            i8 = jSONObject.getInt("RESETTODECOUPLECORE");
        } catch (java.lang.Exception unused11) {
            i8 = 0;
        }
        try {
            i7 = jSONObject.getInt("RESETDECOUPLECORE");
        } catch (java.lang.Exception unused12) {
            i7 = 0;
        }
        synchronized (f) {
            if (z4) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "[REDACTED]");
            }
            if (!android.text.TextUtils.isEmpty(str3) && str3.length() == 96) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, str3 + "[REDACTED]" + com.tencent.smtt.utils.h.c());
            }
        }
        if (i5 == 1) {
            if (z) {
                i14 = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_RESULT_PARSE;
            } else {
                i14 = -210;
            }
            tbsDownloadConfig.setDownloadInterruptCode(i14);
            android.content.Context context3 = c;
            if (i8 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.tencent.smtt.sdk.QbSdk.reset(context3, z10);
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=" + z);
            return false;
        }
        if (!z6) {
            tbsDownloadConfig.setTbsCoreLoadRenameFileLockEnable(z6);
        }
        if (!z7) {
            tbsDownloadConfig.setTbsCoreLoadRenameFileLockWaitEnable(z7);
        }
        if (i7 == 1) {
            com.tencent.smtt.sdk.QbSdk.resetDecoupleCore(c);
        }
        if (i6 == 1) {
            d.removeMessages(104);
            android.os.Message.obtain(d, 104).sendToTarget();
        }
        if (iOptInt == 1) {
            if (jOptLong <= 604800) {
            }
            j2 = 0;
            if (retryIntervalInSeconds <= 0) {
            }
            if (getRetryIntervalInSeconds() >= j2) {
                retryIntervalInSeconds = getRetryIntervalInSeconds();
            }
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, java.lang.Long.valueOf(retryIntervalInSeconds));
            if (z) {
                i13 = jSONObject.getInt("DECOUPLECOREVERSION");
            } else {
                i13 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
            }
            iH = i13;
            i9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
            if (z && !com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c) && iH == 0) {
                iH = com.tencent.smtt.sdk.m.a().h(c);
            }
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response decoupleCoreVersion is " + iH);
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, java.lang.Integer.valueOf(iH));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, java.lang.Integer.valueOf(i9));
            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                if (iH <= 0 && iH != com.tencent.smtt.sdk.m.a().h(c) && iH == com.tencent.smtt.sdk.m.a().i(c)) {
                    com.tencent.smtt.sdk.m.a().n(c);
                } else if (iH == 0) {
                    com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
                }
            }
            if (!android.text.TextUtils.isEmpty(string2) && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                tbsDownloadConfig.commit();
                if (z) {
                    z9 = false;
                    com.tencent.smtt.sdk.TbsShareManager.writeCoreInfoForThirdPartyApp(c, i17, false);
                } else {
                    z9 = false;
                }
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #4,current app is third app...");
                return z9;
            }
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response responseCode is " + i16);
            if (i16 == 0) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                if (z) {
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_CONNECT));
                } else {
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -211);
                    tbsDownloadConfig.setDownloadInterruptCode(-211);
                }
                tbsDownloadConfig.commit();
                if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                    startDecoupleCoreIfNeeded();
                }
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
                return false;
            }
            i10 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            if (i10 > i17) {
                g.c();
                com.tencent.smtt.sdk.m.a().o(c);
            }
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                iE = com.tencent.smtt.sdk.m.a().e(c, 0);
                if (iE >= i17) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "tmpCoreVersion is " + iE + " tbsDownloadVersion is" + i17);
            } else {
                z8 = false;
            }
            if ((i2 < i17 || android.text.TextUtils.isEmpty(string2) || z8) && i9 != 1) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                if (z) {
                    if (android.text.TextUtils.isEmpty(string2)) {
                        map = tbsDownloadConfig.mSyncMap;
                        i12 = -124;
                    } else if (i17 <= 0) {
                        map = tbsDownloadConfig.mSyncMap;
                        i12 = -125;
                    } else if (i2 >= i17) {
                        map = tbsDownloadConfig.mSyncMap;
                        i12 = -127;
                    } else {
                        map = tbsDownloadConfig.mSyncMap;
                        i12 = -112;
                    }
                    map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
                } else {
                    i11 = -212;
                    if (android.text.TextUtils.isEmpty(string2)) {
                        i11 = -217;
                    } else if (i17 <= 0) {
                        i11 = -218;
                    } else if (i2 >= i17) {
                        i11 = -219;
                    }
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
                    tbsDownloadConfig.setDownloadInterruptCode(i11);
                }
                tbsDownloadConfig.commit();
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
                return false;
            }
            if (!string2.equals(tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
                g.c();
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0);
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0);
            }
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, java.lang.Integer.valueOf(i17));
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is " + i17);
            if (i17 > 0) {
                if (i9 == 1) {
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 1);
                } else {
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0);
                }
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V_TYPE is " + i9);
            }
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string2);
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, strOptString);
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, java.lang.Integer.valueOf(i18));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, java.lang.Integer.valueOf(i19));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, java.lang.Integer.valueOf(i20));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, java.lang.Integer.valueOf(i4));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, java.lang.Long.valueOf(j3));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, java.lang.Long.valueOf(j4));
            tbsDownloadConfig.commit();
            str4 = str2;
            if (str4 != null) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, str4);
            }
            if (!z2 && z3 && com.tencent.smtt.sdk.m.a().b(c, i17)) {
                if (z) {
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_SERVER_NET));
                } else {
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -213);
                    tbsDownloadConfig.setDownloadInterruptCode(-213);
                }
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                str5 = LOGTAG;
                str6 = "[TbsDownloader.readResponse] ##6 set needDownload=false";
            } else if (!z2 && z3) {
                if (g.a(z2, i16 == 1 || i16 == 2)) {
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                    com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = com.tencent.smtt.sdk.TbsLogReport.getInstance(c).tbsLogInfo();
                    tbsLogInfo.setErrorCode(100);
                    tbsLogInfo.setFailDetail("use local backup apk in needDownload" + g.f931a);
                    if (a(c)) {
                        tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(c);
                        eventType2 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
                    } else {
                        tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(c);
                        eventType2 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
                    }
                    tbsLogReport2.eventReport(eventType2, tbsLogInfo);
                    str5 = LOGTAG;
                    str6 = "[TbsDownloader.readResponse] ##7 set needDownload=false";
                } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                    if (!z) {
                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                    }
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                    str5 = LOGTAG;
                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                } else {
                    if (!z) {
                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                    }
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                    str5 = LOGTAG;
                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                }
            } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1 || !g.a()) {
                if (!z) {
                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                }
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                str5 = LOGTAG;
                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
            } else {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
                com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(c).tbsLogInfo();
                tbsLogInfo2.setErrorCode(100);
                tbsLogInfo2.setFailDetail("installDecoupleCoreFromBackup" + g.f931a);
                if (a(c)) {
                    tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(c);
                    eventType = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
                } else {
                    tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(c);
                    eventType = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
                }
                tbsLogReport.eventReport(eventType, tbsLogInfo2);
                str5 = LOGTAG;
                str6 = "[TbsDownloader.readResponse] ##8 set needDownload=false";
            }
            com.tencent.smtt.utils.TbsLog.i(str5, str6);
            if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, java.lang.Boolean.TRUE);
            }
            tbsDownloadConfig.commit();
            return true;
        }
        j2 = 0;
        retryIntervalInSeconds = 86400;
        if (getRetryIntervalInSeconds() >= j2) {
            retryIntervalInSeconds = getRetryIntervalInSeconds();
        }
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, java.lang.Long.valueOf(retryIntervalInSeconds));
        if (z) {
            i13 = jSONObject.getInt("DECOUPLECOREVERSION");
        } else {
            i13 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        }
        iH = i13;
        i9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
        if (z) {
            iH = com.tencent.smtt.sdk.m.a().h(c);
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response decoupleCoreVersion is " + iH);
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, java.lang.Integer.valueOf(iH));
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, java.lang.Integer.valueOf(i9));
        if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
            if (iH <= 0) {
                if (iH == 0) {
                    com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
                }
            } else if (iH == 0) {
                com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(c));
            }
        }
        if (!android.text.TextUtils.isEmpty(string2)) {
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "in response responseCode is " + i16);
        if (i16 == 0) {
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
            if (z) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_CONNECT));
            } else {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -211);
                tbsDownloadConfig.setDownloadInterruptCode(-211);
            }
            tbsDownloadConfig.commit();
            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                startDecoupleCoreIfNeeded();
            }
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
            return false;
        }
        i10 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        if (i10 > i17) {
            g.c();
            com.tencent.smtt.sdk.m.a().o(c);
        }
        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
            iE = com.tencent.smtt.sdk.m.a().e(c, 0);
            if (iE >= i17) {
                z8 = true;
            } else {
                z8 = false;
            }
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "tmpCoreVersion is " + iE + " tbsDownloadVersion is" + i17);
        } else {
            z8 = false;
        }
        if (i2 < i17) {
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
            if (z) {
                if (android.text.TextUtils.isEmpty(string2)) {
                    map = tbsDownloadConfig.mSyncMap;
                    i12 = -124;
                } else if (i17 <= 0) {
                    map = tbsDownloadConfig.mSyncMap;
                    i12 = -125;
                } else if (i2 >= i17) {
                    map = tbsDownloadConfig.mSyncMap;
                    i12 = -127;
                } else {
                    map = tbsDownloadConfig.mSyncMap;
                    i12 = -112;
                }
                map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
            } else {
                i11 = -212;
                if (android.text.TextUtils.isEmpty(string2)) {
                    i11 = -217;
                } else if (i17 <= 0) {
                    i11 = -218;
                } else if (i2 >= i17) {
                    i11 = -219;
                }
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
                tbsDownloadConfig.setDownloadInterruptCode(i11);
            }
            tbsDownloadConfig.commit();
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
            return false;
        }
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
        if (z) {
            if (android.text.TextUtils.isEmpty(string2)) {
                map = tbsDownloadConfig.mSyncMap;
                i12 = -124;
            } else if (i17 <= 0) {
                map = tbsDownloadConfig.mSyncMap;
                i12 = -125;
            } else if (i2 >= i17) {
                map = tbsDownloadConfig.mSyncMap;
                i12 = -127;
            } else {
                map = tbsDownloadConfig.mSyncMap;
                i12 = -112;
            }
            map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i12));
        } else {
            i11 = -212;
            if (android.text.TextUtils.isEmpty(string2)) {
                i11 = -217;
            } else if (i17 <= 0) {
                i11 = -218;
            } else if (i2 >= i17) {
                i11 = -219;
            }
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, java.lang.Integer.valueOf(i11));
            tbsDownloadConfig.setDownloadInterruptCode(i11);
        }
        tbsDownloadConfig.commit();
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i2 + " tbsDownloadVersion=" + i17 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string2);
        return false;
        if (!string2.equals(tbsDownloadConfig.mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
            g.c();
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0);
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0);
        }
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, java.lang.Integer.valueOf(i17));
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is " + i17);
        if (i17 > 0) {
            if (i9 == 1) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 1);
            } else {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0);
            }
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V_TYPE is " + i9);
        }
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string2);
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, strOptString);
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, java.lang.Integer.valueOf(i16));
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, java.lang.Integer.valueOf(i18));
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, java.lang.Integer.valueOf(i19));
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, java.lang.Integer.valueOf(i20));
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, java.lang.Integer.valueOf(i4));
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, java.lang.Long.valueOf(j3));
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, java.lang.Long.valueOf(j4));
        tbsDownloadConfig.commit();
        str4 = str2;
        if (str4 != null) {
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, str4);
        }
        if (!z2) {
            if (!z2) {
                if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                    if (!z) {
                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                    }
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                    str5 = LOGTAG;
                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                } else {
                    if (!z) {
                        tbsDownloadConfig.setDownloadInterruptCode(-216);
                    }
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                    str5 = LOGTAG;
                    str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
                }
            } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                if (!z) {
                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                }
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                str5 = LOGTAG;
                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
            } else {
                if (!z) {
                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                }
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                str5 = LOGTAG;
                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
            }
        } else if (!z2) {
            if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                if (!z) {
                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                }
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                str5 = LOGTAG;
                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
            } else {
                if (!z) {
                    tbsDownloadConfig.setDownloadInterruptCode(-216);
                }
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                str5 = LOGTAG;
                str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
            }
        } else if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
            if (!z) {
                tbsDownloadConfig.setDownloadInterruptCode(-216);
            }
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
            str5 = LOGTAG;
            str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
        } else {
            if (!z) {
                tbsDownloadConfig.setDownloadInterruptCode(-216);
            }
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
            str5 = LOGTAG;
            str6 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
        }
        com.tencent.smtt.utils.TbsLog.i(str5, str6);
        if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, java.lang.Boolean.TRUE);
        }
        tbsDownloadConfig.commit();
        return true;
    }

    protected static java.io.File b(int i2) {
        java.lang.StringBuilder sb;
        java.lang.String[] coreProviderAppList = com.tencent.smtt.sdk.TbsShareManager.getCoreProviderAppList();
        int length = coreProviderAppList.length;
        java.io.File file = null;
        int i3 = 0;
        while (i3 < length) {
            java.lang.String str = coreProviderAppList[i3];
            java.io.File file2 = new java.io.File(com.tencent.smtt.utils.f.a(c, str, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            if (file2.exists() && com.tencent.smtt.utils.a.a(c, file2) == i2) {
                sb = new java.lang.StringBuilder();
            } else {
                file2 = new java.io.File(com.tencent.smtt.utils.f.a(c, str, 4, false), "x5.tbs.decouple");
                if (file2.exists() && com.tencent.smtt.utils.a.a(c, file2) == i2) {
                    sb = new java.lang.StringBuilder();
                } else {
                    i3++;
                    file = file2;
                }
            }
            sb.append("local tbs version fond,path = ");
            sb.append(file2.getAbsolutePath());
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, sb.toString());
            return file2;
        }
        return file;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0064  */
    /* JADX WARN: Code duplicated, block: B:28:0x0076  */
    /* JADX WARN: Code duplicated, block: B:30:0x007c  */
    /* JADX WARN: Code duplicated, block: B:32:0x0082  */
    /* JADX WARN: Code duplicated, block: B:35:0x008c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0098  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a9  */
    static java.lang.String b(android.content.Context context) {
        java.lang.String lowerCase;
        java.lang.String str;
        java.lang.String strReplaceAll;
        java.lang.String str2;
        if (!android.text.TextUtils.isEmpty(b)) {
            return b;
        }
        java.util.Locale locale = java.util.Locale.getDefault();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String str3 = android.os.Build.VERSION.RELEASE;
        try {
            str3 = new java.lang.String(str3.getBytes("UTF-8"), "ISO8859-1");
        } catch (java.lang.Exception unused) {
        }
        if (str3 == null || str3.length() <= 0) {
            str3 = "1.0";
        }
        stringBuffer.append(str3);
        stringBuffer.append("; ");
        java.lang.String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            java.lang.String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                lowerCase = country.toLowerCase();
            }
            if ("REL".equals(android.os.Build.VERSION.CODENAME)) {
                str2 = android.os.Build.MODEL;
                try {
                    str2 = new java.lang.String(str2.getBytes("UTF-8"), "ISO8859-1");
                } catch (java.lang.Exception unused2) {
                }
                if (str2 == null) {
                    str2 = "; ";
                } else if (str2.length() > 0) {
                    stringBuffer.append("; ");
                }
                stringBuffer.append(str2);
            }
            str = android.os.Build.ID;
            if (str == null) {
                str = "";
            }
            strReplaceAll = str.replaceAll("[一-龥]", "");
            if (strReplaceAll == null) {
                if (strReplaceAll.length() > 0) {
                    stringBuffer.append(" Build/");
                }
                java.lang.String str4 = java.lang.String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
                b = str4;
                return str4;
            }
            stringBuffer.append(" Build/");
            strReplaceAll = "00";
            stringBuffer.append(strReplaceAll);
            java.lang.String str5 = java.lang.String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
            b = str5;
            return str5;
        }
        lowerCase = "en";
        stringBuffer.append(lowerCase);
        if ("REL".equals(android.os.Build.VERSION.CODENAME)) {
            str2 = android.os.Build.MODEL;
            str2 = new java.lang.String(str2.getBytes("UTF-8"), "ISO8859-1");
            if (str2 == null) {
                str2 = "; ";
            } else if (str2.length() > 0) {
                stringBuffer.append("; ");
            }
            stringBuffer.append(str2);
        }
        str = android.os.Build.ID;
        if (str == null) {
            str = "";
        }
        strReplaceAll = str.replaceAll("[一-龥]", "");
        if (strReplaceAll == null) {
            if (strReplaceAll.length() > 0) {
                stringBuffer.append(" Build/");
            }
            java.lang.String str6 = java.lang.String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
            b = str6;
            return str6;
        }
        stringBuffer.append(" Build/");
        strReplaceAll = "00";
        stringBuffer.append(strReplaceAll);
        java.lang.String str7 = java.lang.String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
        b = str7;
        return str7;
    }

    private static void b(org.json.JSONArray jSONArray) throws java.lang.Throwable {
        if (com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() != null) {
            int iA = com.tencent.smtt.sdk.m.a().a(com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined());
            boolean z = false;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.optInt(i2) == iA) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            jSONArray.put(iA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:111:0x032a A[Catch: all -> 0x0399, TRY_LEAVE, TryCatch #2 {all -> 0x0399, blocks: (B:107:0x0308, B:109:0x0314, B:111:0x032a, B:113:0x0336, B:115:0x0342, B:116:0x0350, B:123:0x037d, B:118:0x0356, B:120:0x0362, B:122:0x036e), top: B:137:0x0308 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0354 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x0356 A[Catch: all -> 0x0399, TRY_LEAVE, TryCatch #2 {all -> 0x0399, blocks: (B:107:0x0308, B:109:0x0314, B:111:0x032a, B:113:0x0336, B:115:0x0342, B:116:0x0350, B:123:0x037d, B:118:0x0356, B:120:0x0362, B:122:0x036e), top: B:137:0x0308 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:27:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:30:0x00df  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:36:0x0111  */
    /* JADX WARN: Code duplicated, block: B:37:0x0114  */
    /* JADX WARN: Code duplicated, block: B:40:0x012c  */
    /* JADX WARN: Code duplicated, block: B:41:0x012f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0147  */
    /* JADX WARN: Code duplicated, block: B:45:0x014a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0157  */
    /* JADX WARN: Code duplicated, block: B:50:0x015d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0161  */
    /* JADX WARN: Code duplicated, block: B:53:0x0167  */
    /* JADX WARN: Code duplicated, block: B:54:0x016b  */
    /* JADX WARN: Code duplicated, block: B:56:0x0171  */
    /* JADX WARN: Code duplicated, block: B:59:0x0178  */
    /* JADX WARN: Code duplicated, block: B:62:0x0190  */
    /* JADX WARN: Code duplicated, block: B:78:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:85:0x0231  */
    /* JADX WARN: Code duplicated, block: B:87:0x023d  */
    /* JADX WARN: Code duplicated, block: B:89:0x025f  */
    /* JADX WARN: Code duplicated, block: B:93:0x02a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:96:0x02c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x02c4  */
    /* JADX WARN: Instruction removed from duplicated block: B:87:0x023d, please report this as an issue */
    public static boolean b(final boolean z, boolean z2, boolean z3, boolean z4) throws java.lang.Throwable {
        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload;
        java.util.Map map;
        java.lang.Integer numValueOf;
        java.lang.String str;
        java.util.Map map2;
        final com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig;
        java.io.File file;
        java.lang.String backupFileName;
        java.io.File file2;
        java.lang.String backupFileName2;
        java.io.File file3;
        java.lang.String backupFileName3;
        java.io.File file4;
        java.lang.String backupFileName4;
        boolean z5;
        int i2;
        long jCurrentTimeMillis;
        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload2;
        java.util.Map map3;
        java.lang.Integer numValueOf2;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload3;
        java.util.Map map4;
        java.lang.Integer numValueOf3;
        java.lang.String str5;
        java.util.regex.Matcher matcher;
        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload4;
        java.util.Map map5;
        java.lang.Integer numValueOf4;
        java.lang.String str6;
        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload5;
        java.util.Map map6;
        java.lang.Integer numValueOf5;
        java.lang.String str7;
        if (!z) {
            if (!z3) {
                tbsDownloadUpload = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                map = tbsDownloadUpload.f857a;
                numValueOf = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_5);
                str = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
            }
            map2 = com.tencent.smtt.sdk.QbSdk.n;
            if (map2 == null && map2.containsKey(com.tencent.smtt.sdk.QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && com.tencent.smtt.sdk.QbSdk.n.get(com.tencent.smtt.sdk.QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
                if (!z) {
                    if (!z3) {
                        tbsDownloadUpload5 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                        map6 = tbsDownloadUpload5.f857a;
                        numValueOf5 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_6);
                        str7 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
                    }
                    return false;
                }
                tbsDownloadUpload5 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                map6 = tbsDownloadUpload5.f857a;
                numValueOf5 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_6);
                str7 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
                map6.put(str7, numValueOf5);
                tbsDownloadUpload5.commit();
                return false;
            }
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest]isQuery: " + z + " forDecoupleCore is " + z3);
            if (com.tencent.smtt.sdk.m.a().c(c)) {
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
                if (z) {
                    if (!z3) {
                        tbsDownloadUpload4 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                        map5 = tbsDownloadUpload4.f857a;
                        numValueOf4 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_7);
                        str6 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
                    }
                    return false;
                }
                tbsDownloadUpload4 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                map5 = tbsDownloadUpload4.f857a;
                numValueOf4 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_7);
                str6 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
                map5.put(str6, numValueOf4);
                tbsDownloadUpload4.commit();
                return false;
            }
            tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c);
            java.lang.String strA = com.tencent.smtt.utils.f.a(c, 1);
            if (getOverSea(c)) {
                backupFileName = "x5.oversea.tbs.org";
            } else {
                backupFileName = getBackupFileName(false);
            }
            file = new java.io.File(strA, backupFileName);
            java.lang.String strA2 = com.tencent.smtt.utils.f.a(c, 2);
            if (getOverSea(c)) {
                backupFileName2 = "x5.oversea.tbs.org";
            } else {
                backupFileName2 = getBackupFileName(false);
            }
            file2 = new java.io.File(strA2, backupFileName2);
            java.lang.String strA3 = com.tencent.smtt.utils.f.a(c, 3);
            if (getOverSea(c)) {
                backupFileName3 = "x5.oversea.tbs.org";
            } else {
                backupFileName3 = getBackupFileName(false);
            }
            file3 = new java.io.File(strA3, backupFileName3);
            java.lang.String strA4 = com.tencent.smtt.utils.f.a(c, 4);
            if (getOverSea(c)) {
                backupFileName4 = "x5.oversea.tbs.org";
            } else {
                backupFileName4 = getBackupFileName(false);
            }
            file4 = new java.io.File(strA4, backupFileName4);
            if (!file4.exists()) {
                if (file3.exists()) {
                    file3.renameTo(file4);
                } else if (file2.exists()) {
                    file2.renameTo(file4);
                } else if (file.exists()) {
                    file.renameTo(file4);
                }
            }
            if (e == null) {
                java.lang.String strA5 = com.tencent.smtt.utils.b.a();
                e = strA5;
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, strA5);
                tbsDownloadConfig.commit();
            }
            if (android.text.TextUtils.isEmpty(e)) {
                z5 = false;
            } else {
                matcher = null;
                try {
                    matcher = java.util.regex.Pattern.compile("i686|mips|x86_64").matcher(e);
                } catch (java.lang.Exception unused) {
                }
                if (matcher == null && matcher.find()) {
                    if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                        com.tencent.smtt.utils.TbsLog.e(LOGTAG, "don't support x86 devices,skip send request");
                        com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = com.tencent.smtt.sdk.TbsLogReport.getInstance(c).tbsLogInfo();
                        if (z) {
                            tbsDownloadConfig.setDownloadInterruptCode(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_INIT_LOAD);
                            tbsLogInfo.setErrorCode(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_INIT_LOAD);
                        } else {
                            tbsDownloadConfig.setDownloadInterruptCode(-205);
                            tbsLogInfo.setErrorCode(-205);
                        }
                        tbsLogInfo.setFailDetail("mycpu is " + e);
                        com.tencent.smtt.sdk.TbsLogReport.getInstance(c).eventReport(com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    } else if (z) {
                        tbsDownloadConfig.setDownloadInterruptCode(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_INIT_LOAD);
                    } else {
                        tbsDownloadConfig.setDownloadInterruptCode(-205);
                    }
                    z5 = true;
                } else {
                    z5 = false;
                }
            }
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, com.tencent.smtt.utils.b.a(c));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, java.lang.Integer.valueOf(com.tencent.smtt.utils.b.b(c)));
            tbsDownloadConfig.commit();
            org.json.JSONObject jSONObjectA = a(z, z2, z3);
            try {
                i2 = jSONObjectA.getInt("TBSV");
            } catch (java.lang.Exception unused2) {
                i2 = -1;
            }
            if (z5 || i2 != -1) {
                jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, java.lang.Long.valueOf(jCurrentTimeMillis - tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L) < tbsDownloadConfig.getRetryInterval() * 1000 ? tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L) + 1 : 1L));
                }
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, java.lang.Long.valueOf(jCurrentTimeMillis));
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, com.tencent.smtt.utils.b.a(c));
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, java.lang.Integer.valueOf(com.tencent.smtt.utils.b.b(c)));
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, com.tencent.smtt.utils.b.a(c, TBS_METADATA));
                tbsDownloadConfig.commit();
                if (z5) {
                    if (!z) {
                        if (!z3) {
                            tbsDownloadUpload2 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                            map3 = tbsDownloadUpload2.f857a;
                            numValueOf2 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_8);
                            str2 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
                        }
                        return false;
                    }
                    tbsDownloadUpload2 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                    map3 = tbsDownloadUpload2.f857a;
                    numValueOf2 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_8);
                    str2 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
                    map3.put(str2, numValueOf2);
                    tbsDownloadUpload2.commit();
                    return false;
                }
            }
            if (i2 != -1 && !z3) {
                if (z) {
                    tbsDownloadUpload3 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                    map4 = tbsDownloadUpload3.f857a;
                    numValueOf3 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_10);
                    str5 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
                } else {
                    if (z3) {
                        return false;
                    }
                    tbsDownloadUpload3 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                    map4 = tbsDownloadUpload3.f857a;
                    numValueOf3 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_10);
                    str5 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
                }
                map4.put(str5, numValueOf3);
                tbsDownloadUpload3.commit();
                return false;
            }
            try {
                java.lang.String strD = com.tencent.smtt.utils.n.a(c).d();
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=" + strD);
                if (z) {
                    if (!z3) {
                        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload6 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                        tbsDownloadUpload6.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_9));
                        tbsDownloadUpload6.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 1);
                        tbsDownloadUpload6.commit();
                        str3 = LOGTAG;
                        str4 = "sendRequest download 168";
                    }
                    return a(com.tencent.smtt.utils.g.a(strD, jSONObjectA.toString().getBytes(com.unisound.b.f.b), new com.tencent.smtt.utils.g.a() { // from class: com.tencent.smtt.sdk.TbsDownloader.2
                        @Override // com.tencent.smtt.utils.g.a
                        public void a(int i3) {
                            com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig2;
                            int i4;
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                            tbsDownloadConfig.commit();
                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=" + i3);
                            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(com.tencent.smtt.sdk.TbsDownloader.c) && i3 == 200) {
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L);
                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
                                tbsDownloadConfig.commit();
                            }
                            if (i3 >= 300) {
                                if (z) {
                                    tbsDownloadConfig2 = tbsDownloadConfig;
                                    i4 = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_SCAN;
                                } else {
                                    tbsDownloadConfig2 = tbsDownloadConfig;
                                    i4 = -207;
                                }
                                tbsDownloadConfig2.setDownloadInterruptCode(i4);
                            }
                        }
                    }, false), i2, z, z2, z4);
                }
                com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload7 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                tbsDownloadUpload7.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_9));
                tbsDownloadUpload7.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 1);
                tbsDownloadUpload7.commit();
                str3 = LOGTAG;
                str4 = "sendRequest query 148";
                com.tencent.smtt.utils.TbsLog.i(str3, str4);
                return a(com.tencent.smtt.utils.g.a(strD, jSONObjectA.toString().getBytes(com.unisound.b.f.b), new com.tencent.smtt.utils.g.a() { // from class: com.tencent.smtt.sdk.TbsDownloader.2
                    @Override // com.tencent.smtt.utils.g.a
                    public void a(int i3) {
                        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig2;
                        int i4;
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                        tbsDownloadConfig.commit();
                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=" + i3);
                        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(com.tencent.smtt.sdk.TbsDownloader.c) && i3 == 200) {
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L);
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
                            tbsDownloadConfig.commit();
                        }
                        if (i3 >= 300) {
                            if (z) {
                                tbsDownloadConfig2 = tbsDownloadConfig;
                                i4 = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_SCAN;
                            } else {
                                tbsDownloadConfig2 = tbsDownloadConfig;
                                i4 = -207;
                            }
                            tbsDownloadConfig2.setDownloadInterruptCode(i4);
                        }
                    }
                }, false), i2, z, z2, z4);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                tbsDownloadConfig.setDownloadInterruptCode(z ? com.tencent.safecloud.device.openlib.DeviceConfig.ERR_NOT_INIT : com.tencent.safecloud.device.openlib.DeviceConfig.W_TIMEOUT);
                return false;
            }
        }
        tbsDownloadUpload = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
        map = tbsDownloadUpload.f857a;
        numValueOf = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_5);
        str = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
        map.put(str, numValueOf);
        tbsDownloadUpload.commit();
        map2 = com.tencent.smtt.sdk.QbSdk.n;
        if (map2 == null) {
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest]isQuery: " + z + " forDecoupleCore is " + z3);
        if (com.tencent.smtt.sdk.m.a().c(c)) {
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
            if (z) {
                if (!z3) {
                    tbsDownloadUpload4 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                    map5 = tbsDownloadUpload4.f857a;
                    numValueOf4 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_7);
                    str6 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
                }
                return false;
            }
            tbsDownloadUpload4 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
            map5 = tbsDownloadUpload4.f857a;
            numValueOf4 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_7);
            str6 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
            map5.put(str6, numValueOf4);
            tbsDownloadUpload4.commit();
            return false;
        }
        tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c);
        java.lang.String strA6 = com.tencent.smtt.utils.f.a(c, 1);
        if (getOverSea(c)) {
            backupFileName = "x5.oversea.tbs.org";
        } else {
            backupFileName = getBackupFileName(false);
        }
        file = new java.io.File(strA6, backupFileName);
        java.lang.String strA7 = com.tencent.smtt.utils.f.a(c, 2);
        if (getOverSea(c)) {
            backupFileName2 = "x5.oversea.tbs.org";
        } else {
            backupFileName2 = getBackupFileName(false);
        }
        file2 = new java.io.File(strA7, backupFileName2);
        java.lang.String strA8 = com.tencent.smtt.utils.f.a(c, 3);
        if (getOverSea(c)) {
            backupFileName3 = "x5.oversea.tbs.org";
        } else {
            backupFileName3 = getBackupFileName(false);
        }
        file3 = new java.io.File(strA8, backupFileName3);
        java.lang.String strA9 = com.tencent.smtt.utils.f.a(c, 4);
        if (getOverSea(c)) {
            backupFileName4 = "x5.oversea.tbs.org";
        } else {
            backupFileName4 = getBackupFileName(false);
        }
        file4 = new java.io.File(strA9, backupFileName4);
        if (!file4.exists()) {
            if (file3.exists()) {
                file3.renameTo(file4);
            } else if (file2.exists()) {
                file2.renameTo(file4);
            } else if (file.exists()) {
                file.renameTo(file4);
            }
        }
        if (e == null) {
            java.lang.String strA10 = com.tencent.smtt.utils.b.a();
            e = strA10;
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, strA10);
            tbsDownloadConfig.commit();
        }
        if (android.text.TextUtils.isEmpty(e)) {
            matcher = null;
            matcher = java.util.regex.Pattern.compile("i686|mips|x86_64").matcher(e);
            if (matcher == null) {
                z5 = false;
            } else {
                z5 = false;
            }
        } else {
            z5 = false;
        }
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, com.tencent.smtt.utils.b.a(c));
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, java.lang.Integer.valueOf(com.tencent.smtt.utils.b.b(c)));
        tbsDownloadConfig.commit();
        org.json.JSONObject jSONObjectA2 = a(z, z2, z3);
        i2 = jSONObjectA2.getInt("TBSV");
        if (z5) {
            jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, java.lang.Long.valueOf(jCurrentTimeMillis - tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L) < tbsDownloadConfig.getRetryInterval() * 1000 ? tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L) + 1 : 1L));
            }
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, java.lang.Long.valueOf(jCurrentTimeMillis));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, com.tencent.smtt.utils.b.a(c));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, java.lang.Integer.valueOf(com.tencent.smtt.utils.b.b(c)));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, com.tencent.smtt.utils.b.a(c, TBS_METADATA));
            tbsDownloadConfig.commit();
            if (z5) {
                if (!z) {
                    if (!z3) {
                        tbsDownloadUpload2 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                        map3 = tbsDownloadUpload2.f857a;
                        numValueOf2 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_8);
                        str2 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
                    }
                    return false;
                }
                tbsDownloadUpload2 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                map3 = tbsDownloadUpload2.f857a;
                numValueOf2 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_8);
                str2 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
                map3.put(str2, numValueOf2);
                tbsDownloadUpload2.commit();
                return false;
            }
        } else {
            jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, java.lang.Long.valueOf(jCurrentTimeMillis - tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L) < tbsDownloadConfig.getRetryInterval() * 1000 ? tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L) + 1 : 1L));
            }
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, java.lang.Long.valueOf(jCurrentTimeMillis));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, com.tencent.smtt.utils.b.a(c));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, java.lang.Integer.valueOf(com.tencent.smtt.utils.b.b(c)));
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, com.tencent.smtt.utils.b.a(c, TBS_METADATA));
            tbsDownloadConfig.commit();
            if (z5) {
                if (!z) {
                    if (!z3) {
                        tbsDownloadUpload2 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                        map3 = tbsDownloadUpload2.f857a;
                        numValueOf2 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_8);
                        str2 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
                    }
                    return false;
                }
                tbsDownloadUpload2 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                map3 = tbsDownloadUpload2.f857a;
                numValueOf2 = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_8);
                str2 = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
                map3.put(str2, numValueOf2);
                tbsDownloadUpload2.commit();
                return false;
            }
        }
        if (i2 != -1) {
        }
        java.lang.String strD2 = com.tencent.smtt.utils.n.a(c).d();
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=" + strD2);
        if (z) {
            if (!z3) {
                com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload8 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
                tbsDownloadUpload8.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_9));
                tbsDownloadUpload8.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 1);
                tbsDownloadUpload8.commit();
                str3 = LOGTAG;
                str4 = "sendRequest download 168";
            }
            return a(com.tencent.smtt.utils.g.a(strD2, jSONObjectA2.toString().getBytes(com.unisound.b.f.b), new com.tencent.smtt.utils.g.a() { // from class: com.tencent.smtt.sdk.TbsDownloader.2
                @Override // com.tencent.smtt.utils.g.a
                public void a(int i3) {
                    com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig2;
                    int i4;
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                    tbsDownloadConfig.commit();
                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=" + i3);
                    if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(com.tencent.smtt.sdk.TbsDownloader.c) && i3 == 200) {
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L);
                        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
                        tbsDownloadConfig.commit();
                    }
                    if (i3 >= 300) {
                        if (z) {
                            tbsDownloadConfig2 = tbsDownloadConfig;
                            i4 = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_SCAN;
                        } else {
                            tbsDownloadConfig2 = tbsDownloadConfig;
                            i4 = -207;
                        }
                        tbsDownloadConfig2.setDownloadInterruptCode(i4);
                    }
                }
            }, false), i2, z, z2, z4);
        }
        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload9 = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(c);
        tbsDownloadUpload9.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_9));
        tbsDownloadUpload9.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 1);
        tbsDownloadUpload9.commit();
        str3 = LOGTAG;
        str4 = "sendRequest query 148";
        com.tencent.smtt.utils.TbsLog.i(str3, str4);
        return a(com.tencent.smtt.utils.g.a(strD2, jSONObjectA2.toString().getBytes(com.unisound.b.f.b), new com.tencent.smtt.utils.g.a() { // from class: com.tencent.smtt.sdk.TbsDownloader.2
            @Override // com.tencent.smtt.utils.g.a
            public void a(int i3) {
                com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig2;
                int i4;
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                tbsDownloadConfig.commit();
                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=" + i3);
                if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(com.tencent.smtt.sdk.TbsDownloader.c) && i3 == 200) {
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L);
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
                    tbsDownloadConfig.commit();
                }
                if (i3 >= 300) {
                    if (z) {
                        tbsDownloadConfig2 = tbsDownloadConfig;
                        i4 = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_SCAN;
                    } else {
                        tbsDownloadConfig2 = tbsDownloadConfig;
                        i4 = -207;
                    }
                    tbsDownloadConfig2.setDownloadInterruptCode(i4);
                }
            }
        }, false), i2, z, z2, z4);
    }

    @android.annotation.TargetApi(11)
    static void c(android.content.Context context) {
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).clear();
        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).clear();
        com.tencent.smtt.sdk.j.c(context);
        (android.os.Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (android.os.Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b4 A[LOOP:2: B:35:0x00a7->B:40:0x00b4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:50:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00b8 A[EDGE_INSN: B:55:0x00b8->B:42:0x00b8 BREAK  A[LOOP:2: B:35:0x00a7->B:40:0x00b4], SYNTHETIC] */
    private static void c(org.json.JSONArray jSONArray) {
        int backupDecoupleCoreVersion;
        android.content.Context packageContext;
        int i2;
        java.lang.StringBuilder sb;
        boolean z;
        if (com.tencent.smtt.sdk.TbsPVConfig.getInstance(c).isDisableHostBackupCore()) {
            return;
        }
        for (java.lang.String str : f()) {
            int backupCoreVersion = com.tencent.smtt.sdk.TbsShareManager.getBackupCoreVersion(c, str);
            boolean z2 = true;
            if (backupCoreVersion <= 0) {
                backupDecoupleCoreVersion = com.tencent.smtt.sdk.TbsShareManager.getBackupDecoupleCoreVersion(c, str);
                if (backupDecoupleCoreVersion <= 0) {
                    packageContext = com.tencent.smtt.sdk.TbsShareManager.getPackageContext(c, str, false);
                    if (packageContext != null || com.tencent.smtt.sdk.m.a().f(packageContext)) {
                        i2 = 0;
                        while (true) {
                            if (i2 < jSONArray.length()) {
                                z2 = false;
                                break;
                            } else if (jSONArray.optInt(i2) == backupDecoupleCoreVersion) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!z2) {
                            jSONArray.put(backupDecoupleCoreVersion);
                        }
                    } else {
                        sb = new java.lang.StringBuilder();
                        sb.append("host check failed,packageName = ");
                        sb.append(str);
                        com.tencent.smtt.utils.TbsLog.e(LOGTAG, sb.toString());
                    }
                }
            } else {
                android.content.Context packageContext2 = com.tencent.smtt.sdk.TbsShareManager.getPackageContext(c, str, false);
                if (packageContext2 != null && !com.tencent.smtt.sdk.m.a().f(packageContext2)) {
                    sb = new java.lang.StringBuilder();
                    sb.append("host check failed,packageName = ");
                    sb.append(str);
                    com.tencent.smtt.utils.TbsLog.e(LOGTAG, sb.toString());
                } else if (a(c, backupCoreVersion)) {
                    com.tencent.smtt.utils.TbsLog.i(LOGTAG, "add addBackupVersionToJsonData,version+" + backupCoreVersion + " is in black list");
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else {
                            if (jSONArray.optInt(i3) == backupCoreVersion) {
                                z = true;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (!z) {
                        jSONArray.put(backupCoreVersion);
                    }
                    backupDecoupleCoreVersion = com.tencent.smtt.sdk.TbsShareManager.getBackupDecoupleCoreVersion(c, str);
                    if (backupDecoupleCoreVersion <= 0) {
                        packageContext = com.tencent.smtt.sdk.TbsShareManager.getPackageContext(c, str, false);
                        if (packageContext != null) {
                        }
                        i2 = 0;
                        while (true) {
                            if (i2 < jSONArray.length()) {
                                z2 = false;
                                break;
                            } else {
                                if (jSONArray.optInt(i2) == backupDecoupleCoreVersion) {
                                    break;
                                    break;
                                }
                                i2++;
                            }
                        }
                        if (!z2) {
                            jSONArray.put(backupDecoupleCoreVersion);
                        }
                    }
                }
            }
        }
    }

    private static boolean c() {
        try {
            for (java.lang.String str : com.tencent.smtt.sdk.TbsShareManager.getCoreProviderAppList()) {
                if (com.tencent.smtt.sdk.TbsShareManager.getSharedTbsCoreVersion(c, str) > 0) {
                    return true;
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private static synchronized void d() {
        if (h == null) {
            h = com.tencent.smtt.sdk.l.a();
            try {
                g = new com.tencent.smtt.sdk.j(c);
                d = new android.os.Handler(h.getLooper()) { // from class: com.tencent.smtt.sdk.TbsDownloader.1
                    /* JADX WARN: Code duplicated, block: B:82:0x023e  */
                    @Override // android.os.Handler
                    public void handleMessage(android.os.Message message) throws java.lang.Throwable {
                        java.io.FileOutputStream fileOutputStreamB;
                        java.lang.String str;
                        java.lang.String str2;
                        int i2 = message.what;
                        if (i2 != 108) {
                            switch (i2) {
                                case 100:
                                    boolean z = message.arg1 == 1;
                                    boolean zB = com.tencent.smtt.sdk.TbsDownloader.b(true, false, false, message.arg2 == 1);
                                    java.lang.Object obj = message.obj;
                                    if (obj != null && (obj instanceof com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback)) {
                                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=" + zB);
                                        java.lang.String str3 = "";
                                        if (com.tencent.smtt.sdk.TbsDownloader.c != null && com.tencent.smtt.sdk.TbsDownloader.c.getApplicationContext() != null && com.tencent.smtt.sdk.TbsDownloader.c.getApplicationContext().getApplicationInfo() != null) {
                                            str3 = com.tencent.smtt.sdk.TbsDownloader.c.getApplicationContext().getApplicationInfo().packageName;
                                        }
                                        if (!zB || z) {
                                            ((com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback) message.obj).onNeedDownloadFinish(zB, com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(com.tencent.smtt.sdk.TbsDownloader.c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                        } else if ("com.tencent.mm".equals(str3) || "com.tencent.mobileqq".equals(str3)) {
                                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = " + zB);
                                            ((com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback) message.obj).onNeedDownloadFinish(zB, com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(com.tencent.smtt.sdk.TbsDownloader.c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                        }
                                    }
                                    if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(com.tencent.smtt.sdk.TbsDownloader.c) && zB) {
                                        com.tencent.smtt.sdk.TbsDownloader.startDownload(com.tencent.smtt.sdk.TbsDownloader.c);
                                        break;
                                    }
                                    break;
                                case 102:
                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                    int iA = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(com.tencent.smtt.sdk.TbsDownloader.c) ? com.tencent.smtt.sdk.TbsShareManager.a(com.tencent.smtt.sdk.TbsDownloader.c, false) : com.tencent.smtt.sdk.m.a().m(com.tencent.smtt.sdk.TbsDownloader.c);
                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=" + iA);
                                    com.tencent.smtt.sdk.TbsDownloader.g.a(iA);
                                    com.tencent.smtt.sdk.TbsLogReport.getInstance(com.tencent.smtt.sdk.TbsDownloader.c).dailyReport();
                                    break;
                                case 103:
                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                    if (message.arg1 != 0) {
                                        com.tencent.smtt.sdk.m.a().a((android.content.Context) message.obj, false);
                                    } else {
                                        com.tencent.smtt.sdk.m.a().a((android.content.Context) message.obj, true);
                                    }
                                    break;
                                case 104:
                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                                    com.tencent.smtt.sdk.TbsLogReport.getInstance(com.tencent.smtt.sdk.TbsDownloader.c).reportTbsLog();
                                    break;
                            }
                        }
                        java.nio.channels.FileLock fileLockA = null;
                        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(com.tencent.smtt.sdk.TbsDownloader.c)) {
                            fileOutputStreamB = null;
                        } else {
                            fileOutputStreamB = com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.TbsDownloader.c, false, "tbs_download_lock_file" + com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(com.tencent.smtt.sdk.TbsDownloader.c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + ".txt");
                            if (fileOutputStreamB != null) {
                                fileLockA = com.tencent.smtt.utils.f.a(com.tencent.smtt.sdk.TbsDownloader.c, fileOutputStreamB);
                                if (fileLockA == null) {
                                    com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(com.tencent.smtt.sdk.TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "file lock locked,wx or qq is downloading");
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(com.tencent.smtt.sdk.TbsDownloader.c).setDownloadInterruptCode(-203);
                                    str = com.tencent.smtt.sdk.TbsDownloader.LOGTAG;
                                    str2 = "MSG_START_DOWNLOAD_DECOUPLECORE return #1";
                                    com.tencent.smtt.utils.TbsLog.i(str, str2);
                                    return;
                                }
                            } else if (com.tencent.smtt.utils.f.a(com.tencent.smtt.sdk.TbsDownloader.c)) {
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(com.tencent.smtt.sdk.TbsDownloader.c).setDownloadInterruptCode(-204);
                                str = com.tencent.smtt.sdk.TbsDownloader.LOGTAG;
                                str2 = "MSG_START_DOWNLOAD_DECOUPLECORE return #2";
                                com.tencent.smtt.utils.TbsLog.i(str, str2);
                                return;
                            }
                        }
                        boolean z2 = message.arg1 == 1;
                        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(com.tencent.smtt.sdk.TbsDownloader.c);
                        if (!com.tencent.smtt.sdk.TbsDownloader.b(false, z2, 108 == message.what, true)) {
                            com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(110);
                        } else if (z2 && com.tencent.smtt.sdk.m.a().b(com.tencent.smtt.sdk.TbsDownloader.c, com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(com.tencent.smtt.sdk.TbsDownloader.c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                            com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(com.tencent.smtt.sdk.TbsListener.ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR);
                            tbsDownloadConfig.setDownloadInterruptCode(-213);
                        } else if (tbsDownloadConfig.mPreferences.getBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(com.tencent.smtt.sdk.TbsDownloader.c).setDownloadInterruptCode(-215);
                            com.tencent.smtt.sdk.TbsDownloader.g.b(z2, 108 == message.what);
                        } else {
                            com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(110);
                        }
                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "------freeFileLock called :");
                        com.tencent.smtt.utils.f.a(fileLockA, fileOutputStreamB);
                    }
                };
            } catch (java.lang.Exception unused) {
                i = true;
                com.tencent.smtt.utils.TbsLog.e(LOGTAG, "TbsApkDownloader init has Exception");
            }
        }
    }

    private static boolean e() throws java.lang.Throwable {
        try {
            return com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(g().toString());
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static java.lang.String[] f() {
        if (com.tencent.smtt.sdk.QbSdk.getOnlyDownload()) {
            return new java.lang.String[]{c.getApplicationContext().getPackageName()};
        }
        java.lang.String[] coreProviderAppList = com.tencent.smtt.sdk.TbsShareManager.getCoreProviderAppList();
        java.lang.String packageName = c.getApplicationContext().getPackageName();
        if (!packageName.equals(com.tencent.smtt.sdk.TbsShareManager.f(c))) {
            return coreProviderAppList;
        }
        int length = coreProviderAppList.length;
        java.lang.String[] strArr = new java.lang.String[length + 1];
        java.lang.System.arraycopy(coreProviderAppList, 0, strArr, 0, length);
        strArr[length] = packageName;
        return strArr;
    }

    private static org.json.JSONArray g() throws java.lang.Throwable {
        if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
            return null;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        a(jSONArray);
        c(jSONArray);
        b(jSONArray);
        return jSONArray;
    }

    public static java.lang.String getBackupFileName(boolean z) {
        if (z) {
            return com.tencent.smtt.utils.b.c() ? "x5.tbs.decouple.64" : "x5.tbs.decouple";
        }
        return com.tencent.smtt.utils.b.c() ? "x5.tbs.org.64" : "x5.tbs.org";
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return com.tencent.smtt.sdk.m.a().h(c);
    }

    public static int getCoreShareDecoupleCoreVersionByContext(android.content.Context context) {
        return com.tencent.smtt.sdk.m.a().h(context);
    }

    public static synchronized boolean getOverSea(android.content.Context context) {
        if (!k) {
            k = true;
            com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context);
            if (tbsDownloadConfig.mPreferences.contains(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                j = tbsDownloadConfig.mPreferences.getBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, false);
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + j);
            }
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + j);
        }
        return j;
    }

    public static long getRetryIntervalInSeconds() {
        return l;
    }

    public static android.os.HandlerThread getsTbsHandlerThread() {
        return h;
    }

    private static boolean h() {
        int i2;
        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c);
        if (tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadSuccessMaxRetrytimes()) {
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            i2 = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_GET_DATA;
        } else if (tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            i2 = -116;
        } else {
            if (com.tencent.smtt.utils.f.b(c)) {
                if (java.lang.System.currentTimeMillis() - tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0L) <= 86400000) {
                    long j2 = tbsDownloadConfig.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0L);
                    com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j2);
                    if (j2 >= tbsDownloadConfig.getDownloadMaxflow()) {
                        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                        i2 = -120;
                    }
                }
                return true;
            }
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            i2 = -117;
        }
        tbsDownloadConfig.setDownloadInterruptCode(i2);
        return false;
    }

    public static boolean isDownloadForeground() {
        com.tencent.smtt.sdk.j jVar = g;
        return jVar != null && jVar.d();
    }

    public static synchronized boolean isDownloading() {
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.isDownloading] is " + f858a);
        return f858a;
    }

    public static boolean needDownload(android.content.Context context, boolean z) {
        return needDownload(context, z, false, true, null);
    }

    public static boolean needDownload(android.content.Context context, boolean z, boolean z2, com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback tbsDownloaderCallback) {
        return needDownload(context, z, z2, true, tbsDownloaderCallback);
    }

    public static boolean needDownload(android.content.Context context, boolean z, boolean z2, boolean z3, com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback tbsDownloaderCallback) throws java.lang.Throwable {
        boolean zContains;
        boolean z4;
        int i2;
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "needDownload,process=" + com.tencent.smtt.sdk.QbSdk.getCurrentProcessName(context) + "stack=" + android.util.Log.getStackTraceString(new java.lang.Throwable()));
        com.tencent.smtt.sdk.TbsDownloadUpload.clear();
        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(context);
        tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_1));
        tbsDownloadUpload.commit();
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z + ",isDownloadForeground=" + z2);
        com.tencent.smtt.utils.TbsLog.initIfNeed(context);
        if (com.tencent.smtt.sdk.m.b) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#1,return false");
            tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1));
            tbsDownloadUpload.commit();
            return false;
        }
        com.tencent.smtt.utils.TbsLog.app_extra(LOGTAG, context);
        android.content.Context applicationContext = context.getApplicationContext();
        c = applicationContext;
        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(applicationContext);
        tbsDownloadConfig.setDownloadInterruptCode(-100);
        if (!a(c, z)) {
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#2,return false");
            tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_2));
            tbsDownloadUpload.commit();
            tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2));
            tbsDownloadUpload.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        d();
        if (i) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            tbsDownloadConfig.setDownloadInterruptCode(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_INIT);
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#3,return false");
            tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_3));
            tbsDownloadUpload.commit();
            tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3));
            tbsDownloadUpload.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        boolean zA = a(c, z2, false);
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=" + zA);
        if (zA) {
            a(z2, tbsDownloaderCallback, z3);
            tbsDownloadConfig.setDownloadInterruptCode(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_SERVER_OTHER);
        } else {
            tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_4));
            tbsDownloadUpload.commit();
        }
        d.removeMessages(102);
        android.os.Message.obtain(d, 102).sendToTarget();
        if (com.tencent.smtt.sdk.QbSdk.c || !com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
            zContains = tbsDownloadConfig.mPreferences.contains(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=" + zContains);
            z4 = (zContains || com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) ? tbsDownloadConfig.mPreferences.getBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
        } else {
            z4 = false;
            zContains = false;
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z4 + ",hasNeedDownloadKey=" + zContains);
        if (!z4) {
            int iM = com.tencent.smtt.sdk.m.a().m(c);
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + iM + ",needSendRequest=" + zA);
            if (zA || iM <= 0) {
                d.removeMessages(103);
                ((iM > 0 || zA) ? android.os.Message.obtain(d, 103, 1, 0, c) : android.os.Message.obtain(d, 103, 0, 0, c)).sendToTarget();
                i2 = -121;
            } else {
                i2 = -119;
            }
            tbsDownloadConfig.setDownloadInterruptCode(i2);
        } else if (h()) {
            tbsDownloadConfig.setDownloadInterruptCode(-118);
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#6");
        } else {
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
            z4 = false;
        }
        if (!zA && tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] needDownload=" + z4);
        tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, java.lang.Integer.valueOf(z4 ? com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE : com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4));
        tbsDownloadUpload.commit();
        return z4;
    }

    public static boolean needDownloadDecoupleCore() {
        int i2;
        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c) || a(c)) {
            return false;
        }
        return java.lang.System.currentTimeMillis() - com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) >= com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).getRetryInterval() * 1000 && (i2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0)) > 0 && i2 != com.tencent.smtt.sdk.m.a().h(c) && com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i2;
    }

    public static boolean needSendRequest(android.content.Context context, boolean z) throws java.lang.Throwable {
        c = context.getApplicationContext();
        com.tencent.smtt.utils.TbsLog.initIfNeed(context);
        if (!a(c, z)) {
            return false;
        }
        int iM = com.tencent.smtt.sdk.m.a().m(context);
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] localTbsVersion=" + iM);
        if (iM > 0) {
            return false;
        }
        if (a(c, false, true)) {
            return true;
        }
        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c);
        boolean zContains = tbsDownloadConfig.mPreferences.contains(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + zContains);
        boolean z2 = !zContains ? true : tbsDownloadConfig.mPreferences.getBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] needDownload=" + z2);
        boolean z3 = z2 && h();
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] ret=" + z3);
        return z3;
    }

    public static void setAppContext(android.content.Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        c = context.getApplicationContext();
    }

    public static void setRetryIntervalInSeconds(android.content.Context context, long j2) {
        if (context == null) {
            return;
        }
        if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
            l = j2;
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "mRetryIntervalInSeconds is " + l);
    }

    public static boolean startDecoupleCoreIfNeeded() throws java.lang.Throwable {
        java.lang.StringBuilder sb;
        int iH;
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(c)) {
            return false;
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        if (a(c) || d == null) {
            return false;
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #2");
        long j2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L);
        if (java.lang.System.currentTimeMillis() - j2 < com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).getRetryInterval() * 1000) {
            return false;
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #3");
        int i2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        if (i2 <= 0 || i2 == com.tencent.smtt.sdk.m.a().h(c)) {
            sb = new java.lang.StringBuilder();
            sb.append("startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is ");
            sb.append(i2);
            sb.append(" getTbsCoreShareDecoupleCoreVersion is ");
            iH = com.tencent.smtt.sdk.m.a().h(c);
        } else {
            if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i2 || com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                com.tencent.smtt.utils.TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #4");
                f858a = true;
                d.removeMessages(108);
                android.os.Message messageObtain = android.os.Message.obtain(d, 108, com.tencent.smtt.sdk.QbSdk.m);
                messageObtain.arg1 = 0;
                messageObtain.sendToTarget();
                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                return true;
            }
            sb = new java.lang.StringBuilder();
            sb.append("startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is ");
            sb.append(com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
            sb.append(" deCoupleCoreVersion is ");
            sb.append(i2);
            sb.append(" KEY_TBS_DOWNLOAD_V_TYPE is ");
            iH = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0);
        }
        sb.append(iH);
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, sb.toString());
        return false;
    }

    public static void startDownload(android.content.Context context) {
        startDownload(context, false);
    }

    public static synchronized void startDownload(android.content.Context context, boolean z) {
        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(context);
        tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 160);
        tbsDownloadUpload.commit();
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + c);
        if (com.tencent.smtt.sdk.m.b) {
            tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_2));
            tbsDownloadUpload.commit();
            return;
        }
        f858a = true;
        android.content.Context applicationContext = context.getApplicationContext();
        c = applicationContext;
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(applicationContext).setDownloadInterruptCode(-200);
        if (android.os.Build.VERSION.SDK_INT < 8) {
            com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(110);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-201);
            tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_3));
            tbsDownloadUpload.commit();
            return;
        }
        d();
        if (i) {
            com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(com.tencent.smtt.sdk.TbsListener.ErrorCode.THREAD_INIT_ERROR);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-202);
            tbsDownloadUpload.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_4));
            tbsDownloadUpload.commit();
            return;
        }
        if (z) {
            stopDownload();
        }
        d.removeMessages(101);
        d.removeMessages(100);
        android.os.Message messageObtain = android.os.Message.obtain(d, 101, com.tencent.smtt.sdk.QbSdk.m);
        messageObtain.arg1 = z ? 1 : 0;
        messageObtain.sendToTarget();
    }

    public static void stopDownload() {
        if (i) {
            return;
        }
        com.tencent.smtt.utils.TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
        com.tencent.smtt.sdk.j jVar = g;
        if (jVar != null) {
            jVar.b();
        }
        android.os.Handler handler = d;
        if (handler != null) {
            handler.removeMessages(100);
            d.removeMessages(101);
            d.removeMessages(108);
        }
    }
}
