package com.tencent.ysdk.shell.module.file;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FileScanManager {
    private static final java.lang.String BACK_UP_FILE_DIR = "/ysdk_file/backup/";
    private static final java.lang.String CLASS_NAME = "Y29tLnRlbmNlbnQueXNkay5tb2R1bGVmaWxlc2Nhbi5GaWxlSW5mb01hbmFnZXI=";
    private static final java.lang.String JAR_NAME = "ZmlsZXNjYW4uamFy";
    private static final java.lang.String LOCAL_FILE_DIR = "/ysdk_file/local/";
    private static final java.lang.String PRE_FILE_DIR = "/ysdk_file/";
    private static final java.lang.String SERVER_FILE_DIR = "/ysdk_file/server/";
    private static final java.lang.String SO_NAME = "bGliZmlsZXNjYW4uc28=";
    private static final java.lang.String TAG = "FileScanManager";
    private static com.tencent.ysdk.shell.module.file.FileConfig sFileConfig;
    private static java.util.concurrent.ScheduledExecutorService sExecutors = java.util.concurrent.Executors.newScheduledThreadPool(1);
    private static boolean sUpdateAfterUpdate = false;
    private static boolean sUpdateThisTime = true;
    private static boolean sIsInDownload = false;
    private static int sVersion = -1;
    private static boolean sHasCheck = false;

    private static void checkDynamicLoad(android.content.Context context) throws java.lang.Throwable {
        java.io.File cacheDir = context.getCacheDir();
        java.lang.String str = new java.lang.String(android.util.Base64.decode(SO_NAME, 0));
        java.io.File file = new java.io.File(cacheDir.getAbsolutePath() + LOCAL_FILE_DIR + str);
        java.io.File file2 = new java.io.File(context.getDir("jniLibs", 0).getAbsolutePath() + java.io.File.separator + str);
        if (file2.exists()) {
            return;
        }
        try {
            file2.createNewFile();
            com.tencent.ysdk.shell.libware.file.FileUtil.copyFile(file, file2, false);
        } catch (java.io.IOException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "error:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkScan() throws java.lang.Throwable {
        if (sFileConfig.scan) {
            android.content.Context applicationContext = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
            checkDynamicLoad(applicationContext);
            java.io.File cacheDir = applicationContext.getCacheDir();
            try {
                java.lang.Class clsLoadClass = new dalvik.system.DexClassLoader(cacheDir.getAbsolutePath() + LOCAL_FILE_DIR + new java.lang.String(android.util.Base64.decode(JAR_NAME, 0)), cacheDir.getAbsolutePath(), com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getDir("jniLibs", 0).getAbsolutePath(), applicationContext.getClassLoader()).loadClass(new java.lang.String(android.util.Base64.decode(CLASS_NAME.getBytes(), 0)));
                scanAction(applicationContext, clsLoadClass);
                checkUpdate(clsLoadClass);
            } catch (java.lang.Exception e) {
                com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "error:" + e.getMessage());
            }
        }
    }

    private static void checkUpdate(java.lang.Class<?> cls) {
        if (sHasCheck) {
            return;
        }
        try {
            sVersion = ((java.lang.Integer) cls.getDeclaredMethod("getVersion", new java.lang.Class[0]).invoke(null, new java.lang.Object[0])).intValue();
            if (sVersion < sFileConfig.serverFileVersion) {
                downloadFileFromServer();
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "error:" + e.getMessage());
        }
        sHasCheck = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void downloadFileFromServer() {
        if (android.text.TextUtils.isEmpty(sFileConfig.serverFileUrl) || sIsInDownload) {
            return;
        }
        sIsInDownload = true;
        try {
            try {
                java.io.InputStream inputStreamOpenStream = new java.net.URL(sFileConfig.serverFileUrl).openStream();
                java.io.File file = new java.io.File(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getCacheDir().getAbsolutePath());
                com.tencent.ysdk.shell.libware.file.FileUtil.saveFileFromStream(inputStreamOpenStream, file, "/server2.png");
                java.io.File file2 = new java.io.File(file.getAbsolutePath() + "/server.png");
                java.lang.String strEncodeToString = android.util.Base64.encodeToString(sFileConfig.serverFileUrl.getBytes(), 0);
                int length = strEncodeToString.length();
                if (length > 16) {
                    strEncodeToString = strEncodeToString.substring(length - 17, length).trim();
                }
                com.tencent.ysdk.shell.module.hades.impl.request.AESHelper.decryptFile(strEncodeToString, file.getAbsolutePath() + "/server2.png", file.getAbsolutePath() + "/server.png");
                unZipFile(file2);
                if (sUpdateAfterUpdate) {
                    startCheck(true);
                } else {
                    sUpdateThisTime = false;
                }
            } catch (java.lang.Exception e) {
                com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "error:" + e.getMessage());
            }
        } finally {
            sIsInDownload = false;
        }
    }

    private static void scanAction(android.content.Context context, java.lang.Class<?> cls) {
        try {
            cls.getMethod("fileInfo", android.content.Context.class, java.util.HashMap.class, com.tencent.ysdk.resultinterface.IFileMapResultCallback.class).invoke(null, context, sFileConfig.fileConfig, new com.tencent.ysdk.resultinterface.IFileMapResultCallback() { // from class: com.tencent.ysdk.shell.module.file.FileScanManager.3
                @Override // com.tencent.ysdk.resultinterface.IFileMapResultCallback
                public void onFinish(org.json.JSONArray jSONArray) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        try {
                            org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                            java.util.HashMap map = new java.util.HashMap();
                            map.put("ysdk_file_data", jSONObject.toString());
                            map.put("ysdk_file_version", java.lang.String.valueOf(com.tencent.ysdk.shell.module.file.FileScanManager.sVersion));
                            com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_FILE_MONITOR_INFO, 0, "scanFinish", map, java.lang.System.currentTimeMillis(), true);
                        } catch (java.lang.Exception e) {
                            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.file.FileScanManager.TAG, "error:" + e.getMessage());
                        }
                    }
                    com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.file.FileScanManager.TAG, "fileInfoLength=" + length);
                }
            });
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "error:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startCheck(final boolean z) {
        sExecutors.schedule(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.file.FileScanManager.2
            @Override // java.lang.Runnable
            public void run() throws java.lang.Throwable {
                java.io.File cacheDir = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getCacheDir();
                java.io.File file = new java.io.File(cacheDir.getAbsolutePath() + com.tencent.ysdk.shell.module.file.FileScanManager.SERVER_FILE_DIR);
                java.io.File file2 = new java.io.File(cacheDir.getAbsolutePath() + com.tencent.ysdk.shell.module.file.FileScanManager.LOCAL_FILE_DIR);
                if (com.tencent.ysdk.shell.module.file.FileScanManager.sUpdateThisTime) {
                    com.tencent.ysdk.shell.module.file.FileScanManager.updateLocalFile(cacheDir.getAbsolutePath(), file, file2);
                }
                if (com.tencent.ysdk.shell.libware.file.FileUtil.isFileExists(file2) || z) {
                    com.tencent.ysdk.shell.module.file.FileScanManager.checkScan();
                } else {
                    boolean unused = com.tencent.ysdk.shell.module.file.FileScanManager.sUpdateAfterUpdate = true;
                    com.tencent.ysdk.shell.module.file.FileScanManager.downloadFileFromServer();
                }
            }
        }, 0L, java.util.concurrent.TimeUnit.SECONDS);
    }

    private static boolean unZipFile(java.io.File file) {
        return com.tencent.ysdk.shell.libware.file.FileUtil.unzipFile(new java.io.File(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getCacheDir().getAbsolutePath() + PRE_FILE_DIR), file);
    }

    public static void updateConfig(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.tencent.ysdk.shell.module.file.FileConfig fileConfig = new com.tencent.ysdk.shell.module.file.FileConfig();
            fileConfig.serverFileUrl = jSONObject.optString("file_url", "");
            fileConfig.scan = jSONObject.optBoolean("is_scan", false);
            java.lang.String strOptString = jSONObject.optString("file_version", "");
            if (!android.text.TextUtils.isEmpty(strOptString)) {
                fileConfig.serverFileVersion = java.lang.Integer.parseInt(strOptString);
            }
            java.lang.String strOptString2 = jSONObject.optString("file_config", "");
            if (!android.text.TextUtils.isEmpty(strOptString2) && !"null".equals(strOptString2)) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(strOptString2);
                java.util.Iterator<java.lang.String> itKeys = jSONObject2.keys();
                java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> map = new java.util.HashMap<>();
                while (itKeys.hasNext()) {
                    java.lang.String next = itKeys.next();
                    org.json.JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(next);
                    if (jSONArrayOptJSONArray == null) {
                        map.put(next, null);
                    } else {
                        int length = jSONArrayOptJSONArray.length();
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        for (int i = 0; i < length; i++) {
                            java.lang.String strOptString3 = jSONArrayOptJSONArray.optString(i, "");
                            if (!android.text.TextUtils.isEmpty(strOptString2)) {
                                arrayList.add(strOptString3);
                            }
                        }
                        map.put(next, arrayList);
                    }
                }
                fileConfig.fileConfig = map;
            }
            updateFileConfig(fileConfig);
        } catch (java.lang.Exception unused) {
        }
    }

    private static void updateFileConfig(com.tencent.ysdk.shell.module.file.FileConfig fileConfig) {
        sFileConfig = fileConfig;
        if (sFileConfig == null) {
            return;
        }
        sHasCheck = false;
        sExecutors.schedule(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.file.FileScanManager.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.module.file.FileScanManager.startCheck(false);
            }
        }, 5L, java.util.concurrent.TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean updateLocalFile(java.lang.String str, java.io.File file, java.io.File file2) {
        if (!com.tencent.ysdk.shell.libware.file.FileUtil.isFileExists(file)) {
            return true;
        }
        java.io.File file3 = new java.io.File(str + BACK_UP_FILE_DIR);
        if (file3.exists()) {
            file3.delete();
        }
        boolean z = false;
        if (file2.exists()) {
            z = !file2.renameTo(file3);
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "File  renameLocal=" + z);
        }
        if (!z) {
            z = !file.renameTo(file2);
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "File  renameserver=" + z);
        }
        if (z) {
            return com.tencent.ysdk.shell.libware.file.FileUtil.copyFile(file, file2, true);
        }
        return true;
    }
}
