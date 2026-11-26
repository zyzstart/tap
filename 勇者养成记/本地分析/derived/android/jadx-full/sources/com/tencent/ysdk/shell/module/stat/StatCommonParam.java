package com.tencent.ysdk.shell.module.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class StatCommonParam {
    private static final java.lang.String DEFAULT_VAL = "-1";
    private static final java.lang.String YSDK_STAT_CONFIG = "YSDK_STAT_CONFIG";
    private static final java.lang.String YSDK_UUID = "uuid";
    private static android.content.Context mApplicationContext = null;
    private static int mParamSequence = 1;
    private static java.lang.String mUUID = "";

    protected static java.util.Map<java.lang.String, java.lang.String> addAppLogParams(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_APP_PARAM_PACKAGE_NAME, getApplicationContext().getPackageName());
        map.put("channel_id", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
        map.put("app_name", com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppName(getApplicationContext()));
        map.put("app_version", com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_GAME_VERSION_NAME, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getGameVersionName());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_GAME_VERSION_CODE, java.lang.String.valueOf(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getGameVersionCode()));
        return map;
    }

    protected static java.util.Map<java.lang.String, java.lang.String> addBizId(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_BIZ_ID, com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_YSDK);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_OPEN_PLATFORM_ID, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId());
        return map;
    }

    protected static java.util.Map<java.lang.String, java.lang.String> addDeviceLogParams(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        try {
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_SDK_VERSION, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_SDK_ORIGINAL_VERSION, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE, com.tencent.ysdk.shell.libware.device.DeviceUtils.getAndroidId(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_SDCARD, com.tencent.ysdk.shell.libware.device.DeviceUtils.getAndroidIdInSdCard(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_IP, DEFAULT_VAL);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_LOCALE, java.util.Locale.getDefault().toString());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_NEWWORK_TYPE, com.tencent.ysdk.shell.libware.device.APNUtil.getNetworkType(getApplicationContext()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_WIFI_BSSID, DEFAULT_VAL);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_BRAND, com.tencent.ysdk.shell.libware.device.DeviceUtils.getBrand());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MODEL, com.tencent.ysdk.shell.libware.device.DeviceUtils.getModel());
            map.put("resolution", com.tencent.ysdk.shell.libware.device.DeviceUtils.getAbsolutelyResolution(getApplicationContext()));
            map.put("dpi", java.lang.String.valueOf(com.tencent.ysdk.shell.libware.device.DeviceUtils.getDpi(getApplicationContext())));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_OS_TYPE, "android");
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_OS_VERSION, com.tencent.ysdk.shell.libware.device.DeviceUtils.getSystemVersion());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_YSDK_VERSION, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_TYPE, com.tencent.ysdk.shell.libware.apk.PackageUtils.getPackageName(getApplicationContext()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_VERSION, com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(getApplicationContext()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID, com.tencent.ysdk.shell.framework.YSDKLifeCycle.getSessionId());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_START_TIME, com.tencent.ysdk.shell.framework.YSDKLifeCycle.getSessionStartTime());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_LAST_SESSION_ID, com.tencent.ysdk.shell.framework.YSDKLifeCycle.getLastSessionId());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SN, com.tencent.ysdk.shell.module.stat.StatApi.getSN());
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(map, th);
        }
        return map;
    }

    protected static java.util.Map<java.lang.String, java.lang.String> addEventLogParams(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, long j, int i, java.lang.String str2, int i2, java.util.Map<java.lang.String, java.lang.String> map2) {
        java.lang.String qQAppId;
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        try {
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_CODE, str);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_TIME, java.lang.String.valueOf(j));
            if (map2 == null) {
                map2 = new java.util.HashMap<>();
            }
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_ARCHITECTURE, com.tencent.ysdk.shell.libware.device.DeviceUtils.getCPUArchitecture());
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_IS_64BIT, java.lang.String.valueOf(com.tencent.ysdk.shell.libware.device.DeviceUtils.getIs64bit()));
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_CPU_MODEL, com.tencent.ysdk.shell.libware.device.DeviceUtils.getCpuName());
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_CPU_CORE_NUMBER, java.lang.String.valueOf(com.tencent.ysdk.shell.libware.device.DeviceUtils.getCpuCoreNumber()));
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_ERRORCODE, "" + i);
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_DETAILMSG, str2);
            if (2 == i2) {
                qQAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId();
            } else {
                qQAppId = 1 == i2 ? com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId() : com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
            }
            map2.put("appid", qQAppId);
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_OPEN_PLATFORM_ID, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId());
            addAppLogParams(map2);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_VALUE, generateParams(map2));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_FORMAT, "1");
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(map, th);
        }
        return map;
    }

    public static java.util.Map<java.lang.String, java.lang.String> addExceptionParam(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        try {
            addBizId(map);
            addSequenceLogParams(map);
            map.put("app_name", com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppName(getApplicationContext()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_TYPE, com.tencent.ysdk.shell.libware.apk.PackageUtils.getPackageName(getApplicationContext()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_VERSION, com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(getApplicationContext()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID, com.tencent.ysdk.shell.framework.YSDKLifeCycle.getSessionId());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_START_TIME, com.tencent.ysdk.shell.framework.YSDKLifeCycle.getSessionStartTime());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_LAST_SESSION_ID, com.tencent.ysdk.shell.framework.YSDKLifeCycle.getLastSessionId());
        } catch (java.lang.Exception unused) {
            com.tencent.ysdk.shell.module.stat.StatApi.getInstance().reportEvent(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_REPORT_ERROR, false, -1L, -1L, map, null, true);
        }
        return map;
    }

    protected static java.util.Map<java.lang.String, java.lang.String> addLocationLogParams(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        try {
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_LONGITUDE, DEFAULT_VAL);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_LATITUDE, DEFAULT_VAL);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_PROVINCE, DEFAULT_VAL);
            map.put("city", DEFAULT_VAL);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_DISTRIC, DEFAULT_VAL);
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(map, th);
        }
        return map;
    }

    protected static java.util.Map<java.lang.String, java.lang.String> addNormalParam(int i, java.lang.String str, int i2, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String qQAppId;
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PLATFORM, "" + i2);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_ERRORCODE, "" + i);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_DETAILMSG, str);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_SDK_TAG, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getTag());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_SDK_ORIGINAL_TAG, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getTag());
        map.put("timestamp", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        if (2 == i2) {
            qQAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId();
        } else {
            qQAppId = 1 == i2 ? com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId() : com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
        }
        map.put("appid", qQAppId);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_OPEN_ID, "" + str2);
        return map;
    }

    protected static java.util.Map<java.lang.String, java.lang.String> addPluginParams(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        try {
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PLUGIN_VER, java.lang.String.valueOf(com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().getLoadedPluginVersion()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PLUGIN_HOST_VERSION, java.lang.String.valueOf(1));
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(map, th);
        }
        return map;
    }

    protected static java.util.Map<java.lang.String, java.lang.String> addSequenceLogParams(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        java.lang.String strReplace = java.util.UUID.randomUUID().toString().replace("-", "");
        int i = mParamSequence;
        mParamSequence = i + 1;
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_SEQUENCE, java.lang.String.valueOf(i));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_REPORT_TYPE, "0");
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOG_ID, strReplace);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOG_VERSION, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
        return map;
    }

    protected static java.util.Map<java.lang.String, java.lang.String> addUserLogParams(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, int i) {
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        try {
            addUserLogParamsInner(map, str, i);
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(map, th);
        }
        return map;
    }

    private static void addUserLogParamsInner(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, int i) {
        java.lang.String str2;
        int i2;
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
            str2 = loginRecord.open_id;
            i2 = loginRecord.platform;
        } else {
            str2 = str;
            i2 = i;
        }
        if (i2 != 7) {
            switch (i2) {
                case 1:
                    map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_LOGIN_OPENID, str2);
                    map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_LOGIN_TYPE, "qq");
                    break;
                case 2:
                    map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_LOGIN_OPENID, str2);
                    map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_LOGIN_TYPE, com.tencent.ysdk.framework.common.ePlatform.PLATFORM_STR_WX);
                    break;
                default:
                    map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_LOGIN_TYPE, java.lang.String.valueOf(i2));
                    map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_LOGIN_OPENID, str2);
                    break;
            }
        } else {
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_LOGIN_TYPE, "guest");
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_LOGIN_OPENID, str2);
        }
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_USER_ID, str2);
        map.put("qimei", com.tencent.ysdk.shell.module.stat.StatApi.getQImei());
        map.put("qimei36", com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei36());
        map.put("imei", com.tencent.ysdk.shell.module.stat.StatApi.getInstance().getIMEI());
        java.lang.String[] imeis = com.tencent.ysdk.shell.libware.device.DeviceUtils.getImeis(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_IMEI1, (imeis == null || imeis.length <= 0) ? null : imeis[0]);
        map.put("imei2", (imeis == null || imeis.length <= 1) ? null : imeis[1]);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_IMSI1, com.tencent.ysdk.shell.libware.device.DeviceUtils.getImsi(getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_MAC, com.tencent.ysdk.shell.libware.device.DeviceUtils.getMacAddress(getApplicationContext()));
        map.put("uuid", getUUID(getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_OAID, com.tencent.ysdk.shell.libware.device.DeviceUtils.getOAID());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_GUID, null);
        map.put("country", java.util.Locale.getDefault().getCountry());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_TIME_ZONE, java.util.TimeZone.getDefault().getID());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_YYBINSTALLED, com.tencent.ysdk.shell.module.stat.StatApi.getYYBInstallState());
    }

    private static java.lang.String generateParams(@androidx.annotation.NonNull java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (entry != null) {
                if (i == 0) {
                    sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(entry.getKey()));
                    sb.append("=");
                    sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(entry.getValue()));
                    i++;
                } else {
                    sb.append("&");
                    sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(entry.getKey()));
                    sb.append("=");
                    sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(entry.getValue()));
                }
            }
        }
        return com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(sb.toString()) + ";";
    }

    protected static android.content.Context getApplicationContext() {
        if (mApplicationContext == null) {
            mApplicationContext = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
        }
        return mApplicationContext;
    }

    private static java.lang.String getUUID(android.content.Context context) {
        try {
            if (android.text.TextUtils.isEmpty(mUUID)) {
                android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(YSDK_STAT_CONFIG, 0);
                if (sharedPreferences.contains("uuid")) {
                    mUUID = sharedPreferences.getString("uuid", "");
                }
                if (android.text.TextUtils.isEmpty(mUUID)) {
                    mUUID = java.util.UUID.randomUUID().toString().replace("-", "");
                    android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("uuid", mUUID);
                    editorEdit.apply();
                }
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
        }
        return mUUID;
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> normalParam(java.util.HashMap<java.lang.String, java.lang.String> map) {
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        addDeviceLogParams(map);
        addUserLogParams(map, "", 0);
        addAppLogParams(map);
        return map;
    }

    public static void resetSequenceId() {
        mParamSequence = 1;
    }
}
