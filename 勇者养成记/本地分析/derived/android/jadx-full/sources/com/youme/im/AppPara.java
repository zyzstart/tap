package com.youme.im;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.SuppressLint({"DefaultLocale", "NewApi"})
public class AppPara {
    private static java.lang.String atest(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) (str.charAt(i) ^ 18));
        }
        return sb.toString();
    }

    public static void initPara(android.content.Context context) {
        boolean z;
        java.lang.String string;
        try {
            java.lang.String packageName = context.getPackageName();
            if (packageName != null) {
                com.youme.im.NativeEngine.setPackageName(packageName);
            }
        } catch (java.lang.Exception unused) {
        }
        try {
            com.youme.im.NativeEngine.setModel(android.os.Build.MODEL);
            com.youme.im.NativeEngine.setBrand(android.os.Build.BRAND);
            com.youme.im.NativeEngine.setCPUArch(android.os.Build.CPU_ABI);
            com.youme.im.NativeEngine.setCPUChip(android.os.Build.HARDWARE);
        } catch (java.lang.Exception unused2) {
        }
        java.lang.String str = "";
        try {
            java.lang.String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null) {
                z = false;
                break;
            }
            int i = 0;
            while (true) {
                if (i >= strArr.length) {
                    z = false;
                    break;
                } else {
                    if (strArr[i].equals("android.permission.READ_PHONE_STATE")) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
        } catch (java.lang.Exception unused3) {
            z = false;
        }
        if (z) {
            try {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
                str = (java.lang.String) telephonyManager.getClass().getDeclaredMethod(atest("uwfVwd{qw[v"), new java.lang.Class[0]).invoke(telephonyManager, new java.lang.Object[0]);
            } catch (java.lang.Exception unused4) {
            }
        }
        if (android.text.TextUtils.isEmpty(str)) {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("YoumeCommon", 0);
            string = sharedPreferences.getString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_UUID, "");
            if (android.text.TextUtils.isEmpty(string)) {
                string = java.util.UUID.randomUUID().toString();
                android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_UUID, string);
                editorEdit.commit();
            }
        } else {
            string = str;
        }
        if (string == null) {
            string = "";
        }
        com.youme.im.NativeEngine.setDeviceIMEI(string);
        try {
            java.lang.String str2 = android.os.Build.VERSION.RELEASE;
            if (str2 != null) {
                com.youme.im.NativeEngine.setSysVersion(str2);
            }
        } catch (java.lang.Exception unused5) {
        }
        try {
            java.lang.String string2 = context.getCacheDir().toString();
            if (string2 != null) {
                com.youme.im.NativeEngine.setDocumentPath(string2);
            }
        } catch (java.lang.Exception unused6) {
        }
    }
}
