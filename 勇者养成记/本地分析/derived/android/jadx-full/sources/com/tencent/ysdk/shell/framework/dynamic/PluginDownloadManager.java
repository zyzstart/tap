package com.tencent.ysdk.shell.framework.dynamic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class PluginDownloadManager {
    private static final java.lang.String DOWNLOAD_COST_TIME = "costTime";
    private static final java.lang.String DOWNLOAD_FAILED = "DownloadFailed";
    private static final java.lang.String DOWNLOAD_SUCCESS = "DownloadSuccess";
    public static final java.lang.String RESOLVE_SUCCESS = "ResolveSuccess";
    private static final java.lang.String START_DOWNLOAD = "StartDownload";
    private static final java.lang.String TAG = "YSDK_PLUGIN";
    private static com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager mInstance;

    private PluginDownloadManager() {
    }

    private boolean checkLocalDownloadInfo(android.content.Context context, com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo pluginDownloadInfo, com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo) {
        return pluginFileInfo != null && fitHostVersion(pluginFileInfo) && pluginFileInfo.getVersionCode() >= pluginDownloadInfo.getPluginVersion();
    }

    private void clearPlugins(int i, int i2) {
        java.io.File[] fileArrListFiles;
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "clearPlugins start");
        java.lang.String pluginBaseDir = com.tencent.ysdk.framework.dynamic.manager.PluginManager.getPluginBaseDir(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "clearPlugins: path=" + pluginBaseDir);
        java.io.File file = new java.io.File(pluginBaseDir);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (java.io.File file2 : fileArrListFiles) {
                java.lang.String name = file2.getName();
                com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "clearPlugins: dirName=" + name);
                if (!name.equals(java.lang.String.valueOf(i)) && !name.equals(java.lang.String.valueOf(i2))) {
                    com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "delete plugins: " + name);
                    deleteFile(file2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlugins(android.content.Context context) {
        com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo localDownloadPluginInfo = getLocalDownloadPluginInfo(context);
        com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo loadedPluginInfo = com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().getLoadedPluginInfo();
        clearPlugins(loadedPluginInfo != null ? loadedPluginInfo.getPluginFileInfo().getVersionCode() : 0, localDownloadPluginInfo != null ? localDownloadPluginInfo.getVersionCode() : 0);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:? A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean copyFromAsset(android.content.Context context, com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.InputStream inputStream = null;
        try {
            java.io.InputStream inputStreamOpen = context.getAssets().open("ysdkcore-debug.apk");
            try {
                fileOutputStream = new java.io.FileOutputStream(pluginFileInfo.getFilePath());
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStreamOpen.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                    fileOutputStream.flush();
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                    return true;
                } catch (java.io.IOException e3) {
                    e = e3;
                    inputStream = inputStreamOpen;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (java.io.IOException e7) {
                            e7.printStackTrace();
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    inputStream = inputStreamOpen;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        throw th;
                    }
                    fileOutputStream.close();
                    throw th;
                }
            } catch (java.io.IOException e8) {
                e = e8;
                fileOutputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (java.io.IOException e9) {
            e = e9;
            fileOutputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    private com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo copyPluginInAssets(android.content.Context context) throws java.lang.Throwable {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "start copyFromAsset");
        com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo localPluginInfos = getLocalPluginInfos(context);
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "copyFromAsset result " + copyFromAsset(context, localPluginInfos));
        return localPluginInfos;
    }

    private void deleteFile(java.io.File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else {
                java.io.File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null) {
                    return;
                }
                for (java.io.File file2 : fileArrListFiles) {
                    deleteFile(file2);
                }
            }
            file.delete();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x012f -> B:90:0x0132). Please report as a decompilation issue!!! */
    private void extractSoToFilePath(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.util.jar.JarFile jarFile;
        java.io.InputStream inputStream;
        java.io.FileOutputStream fileOutputStream;
        java.util.jar.JarFile jarFile2 = null;
        try {
            try {
                try {
                    com.tencent.ysdk.libware.file.Logger.d("YSDKPlugin", "sourceFilePath: " + str);
                    com.tencent.ysdk.libware.file.Logger.d("YSDKPlugin", "targetSaveSoDir: " + str);
                    jarFile = new java.util.jar.JarFile(str);
                    try {
                        java.util.Enumeration<java.util.jar.JarEntry> enumerationEntries = jarFile.entries();
                        byte[] bArr = new byte[1024];
                        while (enumerationEntries.hasMoreElements()) {
                            java.util.jar.JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                            java.lang.String name = jarEntryNextElement.getName();
                            if (!android.text.TextUtils.isEmpty(name) && name.lastIndexOf(47) >= 0) {
                                java.lang.String strSubstring = name.substring(name.lastIndexOf(47) + 1);
                                if (strSubstring.endsWith(".so")) {
                                    com.tencent.ysdk.libware.file.Logger.d("YSDKPlugin", "extractSoToFilePath: " + strSubstring);
                                    try {
                                        inputStream = jarFile.getInputStream(jarEntryNextElement);
                                        try {
                                            fileOutputStream = new java.io.FileOutputStream(str2 + java.io.File.separator + strSubstring);
                                            try {
                                                try {
                                                    com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "extract so:" + strSubstring + " to path:" + str2);
                                                    while (true) {
                                                        int i = inputStream.read(bArr);
                                                        if (i != -1) {
                                                            fileOutputStream.write(bArr, 0, i);
                                                        } else {
                                                            try {
                                                                break;
                                                            } catch (java.lang.Exception e) {
                                                                e.printStackTrace();
                                                            }
                                                        }
                                                    }
                                                    fileOutputStream.close();
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (java.lang.Exception e2) {
                                                            e = e2;
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                } catch (java.lang.Throwable th) {
                                                    th = th;
                                                    if (fileOutputStream != null) {
                                                        try {
                                                            fileOutputStream.close();
                                                        } catch (java.lang.Exception e3) {
                                                            e3.printStackTrace();
                                                        }
                                                    }
                                                    if (inputStream == null) {
                                                        throw th;
                                                    }
                                                    try {
                                                        inputStream.close();
                                                        throw th;
                                                    } catch (java.lang.Exception e4) {
                                                        e4.printStackTrace();
                                                        throw th;
                                                    }
                                                }
                                            } catch (java.lang.Exception e5) {
                                                e = e5;
                                                e.printStackTrace();
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (java.lang.Exception e6) {
                                                        e6.printStackTrace();
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (java.lang.Exception e7) {
                                                        e = e7;
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                        } catch (java.lang.Exception e8) {
                                            e = e8;
                                            fileOutputStream = null;
                                        } catch (java.lang.Throwable th2) {
                                            th = th2;
                                            fileOutputStream = null;
                                        }
                                    } catch (java.lang.Exception e9) {
                                        e = e9;
                                        inputStream = null;
                                        fileOutputStream = null;
                                    } catch (java.lang.Throwable th3) {
                                        th = th3;
                                        inputStream = null;
                                        fileOutputStream = null;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        jarFile.close();
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        if (jarFile != null) {
                            try {
                                jarFile.close();
                            } catch (java.io.IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    jarFile = jarFile2;
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
        } catch (java.io.IOException e11) {
            e11.printStackTrace();
        }
    }

    private boolean fitHostVersion(@androidx.annotation.NonNull com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo) {
        return com.tencent.ysdk.shell.framework.dynamic.PluginConfigInfoResolver.isFitHostVersion(pluginFileInfo.getMaxHostVersion(), pluginFileInfo.getMinHostVersion());
    }

    public static com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager getInstance() {
        if (mInstance == null) {
            synchronized (com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.class) {
                mInstance = new com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager();
            }
        }
        return mInstance;
    }

    public static com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo getLocalDownloadPluginInfo(android.content.Context context) {
        return new com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo().readFromSp(context.getSharedPreferences(com.tencent.ysdk.framework.dynamic.constant.PluginConst.SP_DOWNLOAD_PLUGIN, 0));
    }

    private com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo getLocalPluginInfos(android.content.Context context) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "getLocalPluginInfos enter..");
        com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfoBuild = new com.tencent.ysdk.framework.dynamic.manager.PluginFileInfoBuilder().setMaxHostVersion(10).setMinHostVersion(1).setFilePath(getPluginApkPath(1)).setPluginVersion(1).build();
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "getLocalPluginInfos from SharedPreferences is empty. construct default plugin info.");
        return pluginFileInfoBuild;
    }

    private java.lang.String getPluginApkPath(int i) {
        return com.tencent.ysdk.framework.dynamic.manager.PluginManager.makePluginDir(i, "apk") + java.io.File.separator + "base.apk";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo recordDownloadInfo(android.content.Context context, com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo pluginDownloadInfo, java.lang.String str) {
        com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfoBuild = new com.tencent.ysdk.framework.dynamic.manager.PluginFileInfoBuilder().setMaxHostVersion(pluginDownloadInfo.getMaxHostVersion()).setMinHostVersion(pluginDownloadInfo.getMinHostVersion()).setPluginMd5(pluginDownloadInfo.getPluginMd5()).setFilePath(str).setPluginVersion(pluginDownloadInfo.getPluginVersion()).setDownloadUrl(pluginDownloadInfo.getDownloadUrl()).build();
        pluginFileInfoBuild.writeToSp(context.getSharedPreferences(com.tencent.ysdk.framework.dynamic.constant.PluginConst.SP_DOWNLOAD_PLUGIN, 0));
        return pluginFileInfoBuild;
    }

    private void reportLoadSuccess(long j) {
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_LOAD_RESULT, java.lang.String.valueOf(0));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_LOAD_TIME, java.lang.String.valueOf(j));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_IS_PRELOAD, java.lang.String.valueOf(true));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE, java.lang.String.valueOf(0));
        com.tencent.ysdk.innerapi.DynamicInnerApi.reportApiEventWithDeviceInfo(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PLUGIN_LOAD, 0, "loadSuccess", map);
    }

    public void pluginOdex(android.content.Context context, com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "load odex false");
        com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo loadedPluginInfo = com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().getLoadedPluginInfo();
        if (loadedPluginInfo != null && pluginFileInfo.getVersionCode() == loadedPluginInfo.getPluginFileInfo().getVersionCode()) {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "版本相同,不做预加载");
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().loadPlugin(context, pluginFileInfo, true)) {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "preLoadPlugin: success:" + pluginFileInfo.getVersionCode());
            pluginFileInfo.setPreload(true);
            pluginFileInfo.writeToSp(context.getSharedPreferences(com.tencent.ysdk.framework.dynamic.constant.PluginConst.SP_PRELOAD_PLUGIN, 0));
            pluginFileInfo.writeToSp(context.getSharedPreferences(com.tencent.ysdk.framework.dynamic.constant.PluginConst.SP_DOWNLOAD_PLUGIN, 0));
            reportLoadSuccess(java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    public void startDownload(final android.content.Context context, @androidx.annotation.NonNull final com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo pluginDownloadInfo) {
        com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo localDownloadPluginInfo = getLocalDownloadPluginInfo(context);
        if (localDownloadPluginInfo != null) {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "localDownloadInfo not null");
            clearPlugins(context);
            if (checkLocalDownloadInfo(context, pluginDownloadInfo, localDownloadPluginInfo)) {
                com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "plugin had downloaded " + localDownloadPluginInfo.isHasPreload());
                if (localDownloadPluginInfo.isHasPreload()) {
                    return;
                }
                pluginOdex(context, localDownloadPluginInfo);
                return;
            }
        }
        final java.lang.String downloadUrl = pluginDownloadInfo.getDownloadUrl();
        final java.lang.String pluginMd5 = pluginDownloadInfo.getPluginMd5();
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "startDownload: downloadUrl" + downloadUrl);
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "startDownload: md5" + pluginMd5);
        final java.lang.String pluginApkPath = getPluginApkPath(pluginDownloadInfo.getPluginVersion());
        int randNumByLimit = com.tencent.ysdk.shell.libware.util.Math.getRandNumByLimit(0, pluginDownloadInfo.getRandomTime());
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "startDownload: randomTime=" + randNumByLimit);
        if (pluginDownloadInfo.checkParam()) {
            com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "run: start download");
                        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                        java.util.HashMap map = new java.util.HashMap();
                        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_PLUGIN_VER, java.lang.String.valueOf(pluginDownloadInfo.getPluginVersion()));
                        com.tencent.ysdk.shell.framework.dynamic.PluginStatHelper.reportDownloadEvent(true, com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.START_DOWNLOAD, map);
                        final com.tencent.ysdk.shell.libware.download.DownloadManager downloadManager = com.tencent.ysdk.shell.libware.download.DownloadManager.getInstance();
                        downloadManager.addListener(new com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener() { // from class: com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.1.1
                            @Override // com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener
                            public void onErr(com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadItem downloadItem) {
                                if (downloadItem.mHashValue.equals(pluginMd5)) {
                                    com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "onErr: " + downloadItem.mHashValue);
                                    java.util.HashMap map2 = new java.util.HashMap();
                                    map2.put(com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.DOWNLOAD_COST_TIME, java.lang.String.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                                    map2.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_PLUGIN_VER, java.lang.String.valueOf(pluginDownloadInfo.getPluginVersion()));
                                    com.tencent.ysdk.shell.framework.dynamic.PluginStatHelper.reportDownloadEvent(false, com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.DOWNLOAD_FAILED, map2);
                                    downloadManager.removeListener(this);
                                }
                            }

                            @Override // com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener
                            public void onSuccess(com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadItem downloadItem) {
                                if (downloadItem.mHashValue.equals(pluginMd5)) {
                                    com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "onSuccess: " + downloadItem.mHashValue);
                                    java.util.HashMap map2 = new java.util.HashMap();
                                    map2.put(com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.DOWNLOAD_COST_TIME, java.lang.String.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                                    map2.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_PLUGIN_VER, java.lang.String.valueOf(pluginDownloadInfo.getPluginVersion()));
                                    com.tencent.ysdk.shell.framework.dynamic.PluginStatHelper.reportDownloadEvent(true, com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.DOWNLOAD_SUCCESS, map2);
                                    com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.this.pluginOdex(context, com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.this.recordDownloadInfo(context, pluginDownloadInfo, downloadItem.mLocalFilePath));
                                    downloadManager.removeListener(this);
                                    com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.this.clearPlugins(context);
                                }
                            }
                        });
                        downloadManager.addToDownloadQueue(new java.net.URL(downloadUrl), pluginApkPath, pluginMd5);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }, randNumByLimit);
        }
    }
}
