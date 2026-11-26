package com.tencent.midas.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMidasPluginDownloadUtils {
    private static final java.lang.String TAG = "PDUtils";

    static boolean checkIniFileExist(java.io.File file) {
        if (file != null && file.isDirectory()) {
            return new java.io.File(file, "MidasSign.ini").exists();
        }
        return false;
    }

    private static org.json.JSONArray getPureH5UpdateJsAlertData(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && str.startsWith("midassdk://") && str.length() > 11) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str.substring(11, str.length()));
                if (jSONObject.has(com.tencent.tauth.AuthActivity.ACTION_KEY) && "update".equalsIgnoreCase(jSONObject.getString(com.tencent.tauth.AuthActivity.ACTION_KEY)) && jSONObject.has(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA) && !android.text.TextUtils.isEmpty(jSONObject.getString(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA))) {
                    return jSONObject.getJSONArray(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean handlePureH5UpdateJsAlertLogic(final android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.tencent.midas.comm.APLog.d(TAG, "Cannot handle h5 update logic! Null context!");
            return false;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.midas.comm.APLog.d(TAG, "Cannot handle h5 update logic! Empty alert message!");
            return false;
        }
        boolean zIsPureH5UpdateJsAlert = isPureH5UpdateJsAlert(str);
        org.json.JSONArray pureH5UpdateJsAlertData = getPureH5UpdateJsAlertData(str);
        if (pureH5UpdateJsAlertData == null) {
            com.tencent.midas.comm.APLog.d(TAG, "Cannot handle h5 update logic! Not relevant message!");
            return zIsPureH5UpdateJsAlert;
        }
        com.tencent.midas.comm.APLog.d(TAG, "Got h5 update alert message!");
        final java.util.ArrayList downJson = parseDownJson(pureH5UpdateJsAlertData);
        if (downJson == null) {
            com.tencent.midas.comm.APLog.d(TAG, "Got h5 update alert message! Cannot parse json to list!");
            return zIsPureH5UpdateJsAlert;
        }
        if (downJson.size() <= 0) {
            com.tencent.midas.comm.APLog.d(TAG, "Got h5 update alert message! Cannot parse json to list! Size error = " + downJson.size());
            return zIsPureH5UpdateJsAlert;
        }
        com.tencent.midas.comm.APLog.d(TAG, "Got h5 update alert message! Start down lists = " + downJson.toString());
        com.tencent.midas.download.APMidasPluginDownloadManager.startDownload(context, downJson, new com.tencent.midas.download.IAPMidasPluginDownListener() { // from class: com.tencent.midas.download.APMidasPluginDownloadUtils.1
            @Override // com.tencent.midas.download.IAPMidasPluginDownListener
            public void onDownloadFail(int i) {
            }

            @Override // com.tencent.midas.download.IAPMidasPluginDownListener
            public void onDownloadSuccess() {
                com.tencent.midas.comm.APLog.d(com.tencent.midas.download.APMidasPluginDownloadUtils.TAG, "Got h5 update alert message! List download success!");
                com.tencent.midas.download.APMidasPluginDownloadUtils.writeMidasSignFile(context, downJson);
            }
        });
        return zIsPureH5UpdateJsAlert;
    }

    private static boolean isPureH5UpdateJsAlert(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && str.startsWith("midassdk://") && str.length() > 11) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str.substring(11, str.length()));
                if (jSONObject.has(com.tencent.tauth.AuthActivity.ACTION_KEY) && "update".equalsIgnoreCase(jSONObject.getString(com.tencent.tauth.AuthActivity.ACTION_KEY))) {
                    com.tencent.midas.comm.APLog.d(TAG, "isPureH5UpdateJsAlert msg = " + str);
                    com.tencent.midas.comm.APLog.d(TAG, "isPureH5UpdateJsAlert == true!");
                    return true;
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static java.util.ArrayList parseDownJson(org.json.JSONArray jSONArray) {
        if (jSONArray == null) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot parse down json! jsonArray is null!");
            return null;
        }
        try {
            int length = jSONArray.length();
            if (length == 0) {
                com.tencent.midas.comm.APLog.e(TAG, "Cannot parse down json! jsonArray length is 0!");
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < length; i++) {
                com.tencent.midas.download.APMidasPluginDownInfo aPMidasPluginDownInfo = new com.tencent.midas.download.APMidasPluginDownInfo();
                org.json.JSONObject jSONObject = (org.json.JSONObject) jSONArray.get(i);
                java.lang.String string = jSONObject.getString("file_name");
                aPMidasPluginDownInfo.name = string;
                if (android.text.TextUtils.isEmpty(string)) {
                    com.tencent.midas.comm.APLog.e(TAG, "Cannot parse down json! item's name is empty!");
                    return null;
                }
                java.lang.String string2 = jSONObject.getString("update_md5");
                aPMidasPluginDownInfo.new_md5_encode = string2;
                if (android.text.TextUtils.isEmpty(string2)) {
                    com.tencent.midas.comm.APLog.e(TAG, "Cannot parse down json! item's new encode md5 is empty!");
                    return null;
                }
                try {
                    java.lang.String strDeCodeKey = new com.tencent.midas.comm.APMidasRSATools().deCodeKey(aPMidasPluginDownInfo.new_md5_encode);
                    aPMidasPluginDownInfo.new_md5_decode = strDeCodeKey.substring(strDeCodeKey.length() - 32);
                    com.tencent.midas.comm.APLog.d(TAG, "Parse down json! name = " + aPMidasPluginDownInfo.name + " decode md5 success!");
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    com.tencent.midas.comm.APLog.e(TAG, "Cannot parse down json, decode md5 got exception = " + e);
                }
                if (android.text.TextUtils.isEmpty(aPMidasPluginDownInfo.new_md5_decode)) {
                    com.tencent.midas.comm.APLog.e(TAG, "Cannot parse down json! item's new decode md5 is empty!");
                    return null;
                }
                java.lang.String string3 = jSONObject.getString("full_download_url");
                aPMidasPluginDownInfo.full_url = string3;
                if (android.text.TextUtils.isEmpty(string3)) {
                    com.tencent.midas.comm.APLog.e(TAG, "Cannot parse down json! item's full url is empty!");
                    return null;
                }
                arrayList.add(aPMidasPluginDownInfo);
            }
            return arrayList;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.tencent.midas.comm.APLog.e(TAG, "Cannot parse down json! exception = " + e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeMidasSignFile(android.content.Context context, java.util.ArrayList arrayList) {
        if (context == null) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot write MidasSign.ini! null context!");
            return;
        }
        if (arrayList == null) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot write MidasSign.ini! null list!");
            return;
        }
        if (arrayList.size() <= 0) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot write MidasSign.ini! list size error = " + arrayList.size());
            return;
        }
        java.io.File file = new java.io.File(context.getApplicationContext().getDir("midaspluginsTemp", 0), "MidasSign.ini");
        if (file.exists() && !file.delete()) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot delete old MidasSign.ini file!");
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            java.lang.String str = ((com.tencent.midas.download.APMidasPluginDownInfo) arrayList.get(i)).name;
            if (android.text.TextUtils.isEmpty(str)) {
                com.tencent.midas.comm.APLog.e(TAG, "Cannot write MidasSign.ini! item name empty!");
                return;
            }
            if (!str.endsWith(".apk")) {
                str = str + ".apk";
            }
            java.lang.String str2 = ((com.tencent.midas.download.APMidasPluginDownInfo) arrayList.get(i)).new_md5_encode;
            if (android.text.TextUtils.isEmpty(str2)) {
                com.tencent.midas.comm.APLog.e(TAG, "Cannot write MidasSign.ini! item md5 empty!");
                return;
            }
            sb.append(str + ":" + str2);
            sb.append(com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE);
        }
        java.lang.String string = sb.toString();
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(file);
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(fileWriter);
            bufferedWriter.write(string);
            bufferedWriter.close();
            fileWriter.close();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.midas.comm.APLog.e(TAG, "Write MidasSign.ini got exception = " + e);
        }
        com.tencent.midas.comm.APLog.d(TAG, "Write MidasSign.ini success!");
    }
}
