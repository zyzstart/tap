package com.tencent.ysdk.shell.framework.web.jsbridge;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class YYBJsBridgeHelper {
    YYBJsBridgeHelper() {
    }

    static org.json.JSONArray getApkListInfo(android.content.Context context) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.List<com.tencent.ysdk.shell.libware.apk.LocalApkInfo> localApkInfos = new com.tencent.ysdk.shell.libware.apk.APKListUtils(context).getLocalApkInfos(context);
        if (localApkInfos == null || localApkInfos.size() <= 0) {
            return jSONArray;
        }
        for (com.tencent.ysdk.shell.libware.apk.LocalApkInfo localApkInfo : localApkInfos) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("packageName", localApkInfo.mPackageName);
                jSONObject.put("versionCode", localApkInfo.mVersionCode);
                jSONObject.put("versionName", localApkInfo.mVersionName);
                jSONArray.put(jSONObject);
            } catch (java.lang.Exception unused) {
            }
        }
        return jSONArray;
    }

    static org.json.JSONObject getNetInfo(android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.tencent.ysdk.shell.libware.device.NetInfo netInfo = com.tencent.ysdk.shell.libware.device.APNUtil.getNetInfo(context);
        if (netInfo.apn == com.tencent.ysdk.shell.libware.device.APN.UN_DETECT) {
            com.tencent.ysdk.shell.libware.device.APNUtil.refreshNetwork(context);
        }
        try {
            jSONObject.put("apn", netInfo.apn);
            jSONObject.put("isWap", netInfo.isWap ? 1 : 0);
            jSONObject.put("groupNetType", com.tencent.ysdk.shell.libware.device.APNUtil.getGroupNetType(context));
            jSONObject.put("networkOperator", netInfo.networkOperator);
            jSONObject.put("networkType", netInfo.networkType);
            jSONObject.put("wifiBssid", netInfo.bssid);
            jSONObject.put("qimei", com.tencent.beacon.event.UserAction.getQIMEI());
            jSONObject.put("qimei36", com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei36());
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    static org.json.JSONObject getStorageInfo() {
        long totalExternalSdCardSize;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            long availableInternalMemorySize = com.tencent.ysdk.shell.libware.device.DeviceUtils.getAvailableInternalMemorySize();
            long totalInternalMemorySize = com.tencent.ysdk.shell.libware.device.DeviceUtils.getTotalInternalMemorySize();
            boolean z = true;
            boolean z2 = (com.tencent.ysdk.shell.libware.file.FileUtil.isSDCardExistAndCanWrite() && !com.tencent.ysdk.shell.libware.device.DeviceUtils.isSdCardEmulated()) || com.tencent.ysdk.shell.libware.device.DeviceUtils.getTotalExternalMemorySize() > totalInternalMemorySize;
            if (com.tencent.ysdk.shell.libware.file.ExternalStorage.getExternalSDCardPaths().size() <= 0) {
                z = false;
            }
            jSONObject.put("availableInternalStorage", availableInternalMemorySize);
            jSONObject.put("totalInternalStorage", totalInternalMemorySize);
            if (z2 || z) {
                long availableExternalSdCardSize = 0;
                if (z2) {
                    availableExternalSdCardSize = com.tencent.ysdk.shell.libware.device.DeviceUtils.getAvailableExternalMemorySize() + 0;
                    totalExternalSdCardSize = 0 + com.tencent.ysdk.shell.libware.device.DeviceUtils.getTotalExternalMemorySize();
                } else {
                    totalExternalSdCardSize = 0;
                }
                if (z) {
                    availableExternalSdCardSize += com.tencent.ysdk.shell.libware.file.ExternalStorage.getAvailableExternalSdCardSize();
                    totalExternalSdCardSize += com.tencent.ysdk.shell.libware.file.ExternalStorage.getTotalExternalSdCardSize();
                }
                jSONObject.put("availableExternalStorage", availableExternalSdCardSize);
                jSONObject.put("totalExternalStorage", totalExternalSdCardSize);
            } else {
                jSONObject.put("availableExternalStorage", 0);
                jSONObject.put("totalExternalStorage", 0);
            }
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }
}
