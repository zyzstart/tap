package com.tencent.ysdk.shell.framework.config;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ConfigManager {
    private static final java.lang.String CLOUD_CONFIG_KEY_ALL = "all";
    private static final java.lang.String CLOUD_CONFIG_KEY_OPENID = "openid";
    private static final java.lang.String CLOUD_CONFIG_KEY_PLATFORM = "plat";
    private static final int CLOUD_CONF_TYPE_ALL = 1;
    private static final int CLOUD_CONF_TYPE_OPENID = 3;
    private static final int CLOUD_CONF_TYPE_PLAT = 2;
    private static final java.lang.String TAG = "YSDK ConfigManager";
    private static volatile com.tencent.ysdk.shell.framework.config.ConfigManager instance;
    private java.util.Properties mLocalConfig = null;
    private java.util.HashMap<java.lang.String, java.lang.String> mConfigInfoInCache = new java.util.HashMap<>();
    private com.tencent.ysdk.shell.framework.storage.ILightStorage mCloudAllConfigSP = null;
    private com.tencent.ysdk.shell.framework.storage.ILightStorage mCloudPlatConfigSP = null;
    private com.tencent.ysdk.shell.framework.storage.ILightStorage mCloudUserConfigSP = null;

    public static com.tencent.ysdk.shell.framework.config.ConfigManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.config.ConfigManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.framework.config.ConfigManager();
                }
            }
        }
        return instance;
    }

    private void printConfig(com.tencent.ysdk.shell.framework.storage.ILightStorage iLightStorage, java.lang.String str) {
        if (iLightStorage == null) {
            return;
        }
        java.util.Map<java.lang.String, ?> all = iLightStorage.readAll();
        if (all == null || all.isEmpty()) {
            com.tencent.ysdk.libware.file.Logger.w(str);
            return;
        }
        for (java.util.Map.Entry<java.lang.String, ?> entry : all.entrySet()) {
            com.tencent.ysdk.libware.file.Logger.d(TAG, "Key = " + entry.getKey() + ", Value = " + entry.getValue().toString());
        }
        com.tencent.ysdk.libware.file.Logger.d(TAG, " ==========================================================");
    }

    private java.lang.String readCloudConfig(java.lang.String str) {
        try {
            if (this.mCloudUserConfigSP != null && this.mCloudUserConfigSP.contains(str)) {
                return this.mCloudUserConfigSP.readString(str, null);
            }
            if (this.mCloudPlatConfigSP != null && this.mCloudPlatConfigSP.contains(str)) {
                return this.mCloudPlatConfigSP.readString(str, null);
            }
            if (this.mCloudAllConfigSP != null && this.mCloudAllConfigSP.contains(str)) {
                return this.mCloudAllConfigSP.readString(str, null);
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.libware.file.Logger.w(TAG, "readCloudConfig failed");
        }
    }

    @java.lang.Deprecated
    public static java.lang.String readConfigFromFile(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null) {
            com.tencent.ysdk.libware.file.Logger.e(TAG, "readConfigFromFile context is null");
            return str3;
        }
        try {
            try {
                java.io.InputStream inputStreamFromAssets = com.tencent.ysdk.shell.framework.wrapper.ContextProxy.getInputStreamFromAssets(context, str);
                java.util.Properties properties = new java.util.Properties();
                properties.load(inputStreamFromAssets);
                java.lang.String property = properties.getProperty(str2, "");
                if (property != null && property.length() != 0) {
                    java.lang.String strTrim = property.trim();
                    com.tencent.ysdk.libware.file.Closer.closeStream(inputStreamFromAssets);
                    return strTrim;
                }
                com.tencent.ysdk.libware.file.Logger.d(TAG, "no key: " + str2);
                com.tencent.ysdk.libware.file.Closer.closeStream(inputStreamFromAssets);
                return "";
            } catch (java.io.IOException e) {
                e.printStackTrace();
                com.tencent.ysdk.libware.file.Closer.closeStream(null);
                return "";
            }
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.libware.file.Closer.closeStream(null);
            throw th;
        }
    }

    private java.lang.String readLocalConfig(java.lang.String str) {
        java.util.Properties properties = this.mLocalConfig;
        if (properties == null || !properties.containsKey(str)) {
            return null;
        }
        try {
            java.lang.String property = this.mLocalConfig.getProperty(str, null);
            if (property != null && property.length() != 0) {
                return property.trim();
            }
            com.tencent.ysdk.libware.file.Logger.w(TAG, "key value is empty: " + str);
            return property;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.libware.file.Logger.w(TAG, "readLocalConfig failed");
            return null;
        }
    }

    private void writeCloudConfig(int i, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                com.tencent.ysdk.libware.file.Logger.d("writeCloudConfig, value is null:" + i);
                return;
            }
            com.tencent.ysdk.shell.framework.storage.ILightStorage iLightStorage = null;
            switch (i) {
                case 1:
                    iLightStorage = this.mCloudAllConfigSP;
                    break;
                case 2:
                    iLightStorage = this.mCloudPlatConfigSP;
                    break;
                case 3:
                    iLightStorage = this.mCloudUserConfigSP;
                    break;
            }
            if (iLightStorage == null) {
                com.tencent.ysdk.libware.file.Logger.d("writeCloudConfig, sp is null:" + i);
                return;
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            java.util.HashMap map = new java.util.HashMap();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i2);
                java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    java.lang.String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            }
            iLightStorage.writeMap(map);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public boolean init() {
        android.content.Context applicationContext = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
        boolean z = false;
        if (applicationContext == null) {
            com.tencent.ysdk.libware.file.Logger.e(TAG, "context is null");
            return false;
        }
        java.io.InputStream inputStreamFromAssets = null;
        try {
            try {
                this.mCloudAllConfigSP = com.tencent.ysdk.shell.framework.storage.LightStorageFactory.getLightStorage(com.tencent.ysdk.shell.framework.config.Config.YSDK_CLOUD_CONFIG_FILE_ALL);
                this.mLocalConfig = new java.util.Properties();
                inputStreamFromAssets = com.tencent.ysdk.shell.framework.wrapper.ContextProxy.getInputStreamFromAssets(applicationContext, "ysdkconf.ini");
                this.mLocalConfig.load(inputStreamFromAssets);
                com.tencent.ysdk.libware.file.Closer.closeStream(inputStreamFromAssets);
                z = true;
            } catch (java.io.IOException unused) {
                com.tencent.ysdk.libware.file.Logger.e("YSDK_DOCTOR", "ERROR-YSDK config file");
                com.tencent.ysdk.libware.file.Closer.closeStream(inputStreamFromAssets);
            }
            return z;
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.libware.file.Closer.closeStream(inputStreamFromAssets);
            throw th;
        }
    }

    public void initSpecialConfig(int i, java.lang.String str) {
        try {
            this.mCloudPlatConfigSP = com.tencent.ysdk.shell.framework.storage.LightStorageFactory.getLightStorage(com.tencent.ysdk.shell.framework.config.Config.YSDK_CLOUD_CONFIG_FILE_PLAT + i);
            this.mCloudUserConfigSP = com.tencent.ysdk.shell.framework.storage.LightStorageFactory.getLightStorage(com.tencent.ysdk.shell.framework.config.Config.YSDK_CLOUD_CONFIG_FILE_OPENID + str);
            this.mConfigInfoInCache.clear();
            if (this.mCloudAllConfigSP != null) {
                this.mCloudAllConfigSP.clear();
            }
            if (this.mCloudPlatConfigSP != null) {
                this.mCloudPlatConfigSP.clear();
            }
            if (this.mCloudUserConfigSP != null) {
                this.mCloudUserConfigSP.clear();
            }
        } catch (java.lang.Exception unused) {
            com.tencent.ysdk.libware.file.Logger.e("YSDK_DOCTOR", "ERROR-YSDK config file");
        }
    }

    protected boolean isSwitchEnabled(java.lang.String str, boolean z) {
        java.lang.String config = readConfig(str, "");
        if (android.text.TextUtils.isEmpty(config)) {
            return z;
        }
        if (com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON.equalsIgnoreCase(config)) {
            return true;
        }
        if ("false".equalsIgnoreCase(config)) {
            return false;
        }
        return z;
    }

    public void parseCloudConf(java.lang.String str) {
        try {
            com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(str);
            if (safeJSONObject.has(CLOUD_CONFIG_KEY_ALL)) {
                writeCloudConfig(1, safeJSONObject.getString(CLOUD_CONFIG_KEY_ALL));
            }
            if (safeJSONObject.has(CLOUD_CONFIG_KEY_PLATFORM)) {
                writeCloudConfig(2, safeJSONObject.getString(CLOUD_CONFIG_KEY_PLATFORM));
            }
            if (safeJSONObject.has("openid")) {
                writeCloudConfig(3, safeJSONObject.getString("openid"));
            }
            if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
                printAllConfig();
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.libware.file.Logger.e("parseCloudConf exception");
            e.printStackTrace();
        }
    }

    protected void printAllConfig() {
        com.tencent.ysdk.libware.file.Logger.d(TAG, " ===================print config start ===================");
        printConfig(this.mCloudAllConfigSP, "allCloudKeys is null");
        printConfig(this.mCloudPlatConfigSP, "allCloudPlatKeys is null");
        printConfig(this.mCloudUserConfigSP, "allCloudUserKeys is null");
        java.util.Enumeration enumerationKeys = this.mLocalConfig.keys();
        while (enumerationKeys.hasMoreElements()) {
            java.lang.Object objNextElement = enumerationKeys.nextElement();
            com.tencent.ysdk.libware.file.Logger.d(TAG, "Key = " + objNextElement + ", Value = " + this.mLocalConfig.get(objNextElement));
        }
        com.tencent.ysdk.libware.file.Logger.d(TAG, " ===================print config end ===================");
    }

    protected int readConfig(java.lang.String str, int i) {
        return com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(readConfig(str, ""), i);
    }

    protected java.lang.String readConfig(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = this.mConfigInfoInCache.containsKey(str) ? this.mConfigInfoInCache.get(str) : null;
        if (!android.text.TextUtils.isEmpty(str3)) {
            return str3;
        }
        java.lang.String cloudConfig = readCloudConfig(str);
        if (android.text.TextUtils.isEmpty(cloudConfig)) {
            cloudConfig = readLocalConfig(str);
        }
        if (cloudConfig != null && cloudConfig.length() != 0) {
            str2 = cloudConfig;
        }
        this.mConfigInfoInCache.put(str, str2);
        return str2;
    }

    void tearDown() {
        instance = null;
    }
}
