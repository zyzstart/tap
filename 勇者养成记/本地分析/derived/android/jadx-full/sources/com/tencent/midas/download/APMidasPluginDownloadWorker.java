package com.tencent.midas.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class APMidasPluginDownloadWorker implements java.lang.Runnable {
    private static final java.lang.String TAG = "PluginDownloadWorker";
    private final android.content.Context context;
    private final java.util.ArrayList downInfos;
    private final com.tencent.midas.download.IAPMidasPluginDownListener downListener;
    private final java.io.File saveDir;

    APMidasPluginDownloadWorker(android.content.Context context, java.util.ArrayList arrayList, java.io.File file, com.tencent.midas.download.IAPMidasPluginDownListener iAPMidasPluginDownListener) {
        this.downInfos = arrayList;
        this.saveDir = file;
        this.downListener = iAPMidasPluginDownListener;
        this.context = context;
    }

    private static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean downloadSingleDownInfo(com.tencent.midas.download.APMidasPluginDownInfo aPMidasPluginDownInfo) throws java.lang.Throwable {
        java.lang.String str;
        java.io.InputStream inputStream;
        java.lang.String str2;
        java.lang.StringBuilder sb;
        if (aPMidasPluginDownInfo == null) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot download down info, info is null!");
            return false;
        }
        if (android.text.TextUtils.isEmpty(aPMidasPluginDownInfo.full_url)) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot download down info, info's url is empty!");
            return false;
        }
        if (android.text.TextUtils.isEmpty(aPMidasPluginDownInfo.name)) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot download down info, info's name is empty!");
            return false;
        }
        if (aPMidasPluginDownInfo.name.endsWith(".apk") || aPMidasPluginDownInfo.name.endsWith(".Apk") || aPMidasPluginDownInfo.name.endsWith(".APK")) {
            str = aPMidasPluginDownInfo.name;
        } else {
            str = aPMidasPluginDownInfo.name + ".apk";
        }
        if (isPluginAlreadyExist(this.context, str, aPMidasPluginDownInfo.new_md5_decode, this.saveDir.getAbsolutePath())) {
            com.tencent.midas.comm.APLog.d(TAG, "plugin already test, no need to download! name = " + str);
            return true;
        }
        try {
            java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory().getCanonicalPath() + "/Tencent/MidasPay/", str);
            if (file.exists()) {
                com.tencent.midas.comm.APLog.d(TAG, "File name = " + str + " already exist in sdcard! We can copy from it, no need to download, but need to check md5!");
                if (com.tencent.midas.plugin.APPluginUtils.checkFileMD5(file.getAbsolutePath(), aPMidasPluginDownInfo.new_md5_decode)) {
                    com.tencent.midas.comm.APLog.d(TAG, "File name = " + str + " already exist in sdcard! We can copy from it, no need to download, md5 ok too!");
                    if (com.tencent.midas.plugin.APPluginUtils.copyFile(file.getAbsolutePath(), this.saveDir.getAbsolutePath(), str)) {
                        com.tencent.midas.comm.APLog.d(TAG, "File name = " + str + " already exist in sdcard! We can copy from it, no need to download, md5 ok too! Copy success!");
                        return true;
                    }
                    str2 = TAG;
                    sb = new java.lang.StringBuilder();
                    sb.append("File name = ");
                    sb.append(str);
                    sb.append(" already exist in sdcard! We can copy from it, no need to download, md5 ok too! Copy fail!");
                } else {
                    str2 = TAG;
                    sb = new java.lang.StringBuilder();
                    sb.append("File name = ");
                    sb.append(str);
                    sb.append(" already exist in sdcard! We can copy from it, no need to download, but md5 not ok!");
                }
            } else {
                str2 = TAG;
                sb = new java.lang.StringBuilder();
                sb.append("File name = ");
                sb.append(str);
                sb.append(" not exist in sdcard! Cannot copy from it, we need to download!");
            }
            com.tencent.midas.comm.APLog.d(str2, sb.toString());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.midas.comm.APLog.d(TAG, "File name = " + str + " copy from sdcard got exception " + e);
        }
        java.lang.String str3 = aPMidasPluginDownInfo.full_url;
        com.tencent.midas.comm.APLog.d(TAG, "download single down info! Start to down url = " + str3);
        com.tencent.midas.comm.APLog.d(TAG, "download single down info! Start to down file name = " + str);
        java.io.File file2 = new java.io.File(this.saveDir, str);
        if (file2.exists()) {
            if (!file2.delete()) {
                com.tencent.midas.comm.APLog.e(TAG, "File already exist test, cannot delete old file, file = " + file2.getAbsolutePath());
                return false;
            }
            com.tencent.midas.comm.APLog.w(TAG, "download single down info! file name already exist, delete it successfully = " + file2.getAbsolutePath());
        }
        java.io.FileOutputStream fileOutputStream = null;
        inputStream = null;
        java.io.InputStream inputStream2 = null;
        fileOutputStream = null;
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str3).openConnection();
            httpURLConnection.setConnectTimeout(45000);
            httpURLConnection.setReadTimeout(45000);
            httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_GET);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                com.tencent.midas.comm.APLog.e(TAG, "Cannot download file, http code not 200! Code = " + responseCode);
                closeQuietly(null);
                closeQuietly(null);
                return false;
            }
            if (!file2.createNewFile()) {
                com.tencent.midas.comm.APLog.e(TAG, "Cannot download file, fail to create file! File = " + file2.getAbsolutePath());
                closeQuietly(null);
                closeQuietly(null);
                return false;
            }
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file2);
            try {
                inputStream2 = httpURLConnection.getInputStream();
                byte[] bArr = new byte[2048];
                while (true) {
                    int i = inputStream2.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, i);
                }
                fileOutputStream2.flush();
                closeQuietly(inputStream2);
                closeQuietly(fileOutputStream2);
                com.tencent.midas.comm.APLog.d(TAG, "download single down info success! File name = " + str + " About to copy to sdcard!");
                try {
                    java.lang.String str4 = android.os.Environment.getExternalStorageDirectory().getCanonicalPath() + "/Tencent/MidasPay/";
                    if (new java.io.File(str4, str).exists()) {
                        com.tencent.midas.comm.APLog.d(TAG, "File name = " + str + " already exist in sdcard! No need to copy!");
                        return true;
                    }
                    com.tencent.midas.comm.APLog.d(TAG, "File name = " + str + " not exist in sdcard! Need to copy!");
                    com.tencent.midas.plugin.APPluginUtils.copyFile(file2.getAbsolutePath(), str4, str);
                    return true;
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    com.tencent.midas.comm.APLog.d(TAG, "File name = " + str + " copy to sdcard got exception " + e2);
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                inputStream = inputStream2;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    com.tencent.midas.comm.APLog.e(TAG, "download single down info fail! File name = " + str);
                    closeQuietly(inputStream);
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    closeQuietly(inputStream);
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                fileOutputStream = fileOutputStream2;
                closeQuietly(inputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            inputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private static boolean isPluginAlreadyExist(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.midas.comm.APLog.d(TAG, "plugin already exist in midasplugins test, file name = " + str);
        com.tencent.midas.comm.APLog.d(TAG, "plugin already exist in midasplugins test, md5 = " + str2);
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.midas.comm.APLog.e(TAG, "plugin already exist in midasplugins test error, empty file name!");
            return false;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.tencent.midas.comm.APLog.e(TAG, "plugin already exist in midasplugins test error, empty md5!");
            return false;
        }
        if (context == null) {
            com.tencent.midas.comm.APLog.e(TAG, "plugin already exist in midasplugins test error, null context!");
            return false;
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            com.tencent.midas.comm.APLog.e(TAG, "plugin already exist in midasplugins test error, empty saveDir!");
            return false;
        }
        java.io.File pluginPath = com.tencent.midas.plugin.APPluginConfig.getPluginPath(context);
        if (pluginPath == null) {
            com.tencent.midas.comm.APLog.e(TAG, "plugin already exist in midasplugins error, cannot get plugin path!");
            return false;
        }
        java.io.File file = new java.io.File(pluginPath, str);
        if (!file.exists()) {
            com.tencent.midas.comm.APLog.d(TAG, "plugin already exist in midasplugins test, plugin not exist! Name = " + str);
            return false;
        }
        try {
            if (com.tencent.midas.plugin.APPluginUtils.checkFileMD5(file.getCanonicalPath(), str2)) {
                com.tencent.midas.comm.APLog.d(TAG, "plugin already exist in midasplugins test, plugin exist & md5 correct!");
                if (com.tencent.midas.plugin.APPluginUtils.copyFile(file.getCanonicalPath(), str3, str)) {
                    com.tencent.midas.comm.APLog.d(TAG, "plugin already exist in midasplugins test, plugin exist & md5 correct & copy success!");
                    return true;
                }
                com.tencent.midas.comm.APLog.e(TAG, "plugin already exist in midasplugins test, plugin exist & md5 correct & copy fail!");
            } else {
                com.tencent.midas.comm.APLog.d(TAG, "plugin already exist in midasplugins test, plugin exist & md5 not correct!");
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
            com.tencent.midas.comm.APLog.d(TAG, "plugin already exist in midasplugins test error, exception = " + e);
        }
        com.tencent.midas.comm.APLog.e(TAG, "plugin already exist in midasplugins test, final false!");
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        com.tencent.midas.comm.APLog.d(TAG, "About to enter critical region！");
        synchronized (com.tencent.midas.download.APMidasPluginDownloadWorker.class) {
            com.tencent.midas.comm.APLog.d(TAG, "Enter critical region！");
            if (this.downListener == null) {
                com.tencent.midas.comm.APLog.e(TAG, "Cannot start plugin down worker, null downListener!");
                return;
            }
            if (this.downInfos != null && !this.downInfos.isEmpty()) {
                if (this.context == null) {
                    com.tencent.midas.comm.APLog.e(TAG, "Cannot start plugin down worker, null context!");
                    this.downListener.onDownloadFail(-8);
                    return;
                }
                if (this.saveDir == null) {
                    com.tencent.midas.comm.APLog.e(TAG, "Cannot start plugin down worker, null save dir!");
                    this.downListener.onDownloadFail(-6);
                    return;
                }
                if (!this.saveDir.isDirectory()) {
                    com.tencent.midas.comm.APLog.e(TAG, "Cannot start plugin down worker, save dir not directory!");
                    this.downListener.onDownloadFail(-7);
                    return;
                }
                if (com.tencent.midas.download.APMidasPluginDownloadUtils.checkIniFileExist(this.saveDir)) {
                    com.tencent.midas.comm.APLog.d(TAG, "MidasSign.ini already exists, no need to download again!");
                    this.downListener.onDownloadFail(-2);
                    return;
                }
                com.tencent.midas.comm.APLog.d(TAG, "MidasSign.ini not exists, start to download again!");
                com.tencent.midas.plugin.APPluginUtils.clearDirContent(this.saveDir);
                if (!this.saveDir.exists() && !this.saveDir.mkdirs()) {
                    com.tencent.midas.comm.APLog.e(TAG, "Cannot start plugin down worker, save dir not exist and cannot create it!");
                    this.downListener.onDownloadFail(-3);
                    return;
                }
                for (com.tencent.midas.download.APMidasPluginDownInfo aPMidasPluginDownInfo : this.downInfos) {
                    if (!downloadSingleDownInfo(aPMidasPluginDownInfo)) {
                        this.downListener.onDownloadFail(-4);
                        com.tencent.midas.comm.APLog.d(TAG, "File name = " + aPMidasPluginDownInfo.name + " download fail, about to clear download dir!");
                        com.tencent.midas.plugin.APPluginUtils.clearDirContent(this.saveDir);
                        return;
                    }
                }
                this.downListener.onDownloadSuccess();
                com.tencent.midas.comm.APLog.d(TAG, "About to leave critical region");
                com.tencent.midas.comm.APLog.d(TAG, "Leave critical region");
                return;
            }
            com.tencent.midas.comm.APLog.e(TAG, "Cannot start plugin down worker, empty down list!");
            this.downListener.onDownloadFail(-5);
        }
    }
}
