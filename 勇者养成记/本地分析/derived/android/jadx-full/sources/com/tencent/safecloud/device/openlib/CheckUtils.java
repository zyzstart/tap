package com.tencent.safecloud.device.openlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CheckUtils {
    public static java.lang.String getAppCert(android.content.Context context) {
        try {
            return getMD5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (java.lang.Exception e) {
            com.tencent.safecloud.device.openlib.LogUtil.e("verify cert:" + com.tencent.safecloud.device.openlib.ErrorManager.catchMsg(e), e);
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String getAssetFile(android.content.Context context, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        java.io.IOException e;
        java.io.InputStream inputStreamOpen;
        java.io.FileOutputStream fileOutputStream;
        if (str2 == null || str2.equals("")) {
            str2 = context.getFilesDir().toString();
        }
        java.lang.String str3 = str2 + java.io.File.separator + str;
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                java.io.File file = new java.io.File(str3);
                if (file.exists()) {
                    file.delete();
                }
                inputStreamOpen = context.getResources().getAssets().open(str, 1);
                try {
                    fileOutputStream = new java.io.FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i = inputStreamOpen.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                        fileOutputStream.getChannel().force(true);
                        fileOutputStream.flush();
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (java.io.IOException unused) {
                            }
                        }
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                        return str3;
                    } catch (java.io.IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException unused4) {
                            }
                        }
                        return null;
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                    fileOutputStream = null;
                    e.printStackTrace();
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (java.lang.Throwable th) {
                    inputStream = inputStreamOpen;
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused5) {
                        }
                    }
                    if (r0 == 0) {
                        throw th;
                    }
                    try {
                        r0.close();
                        throw th;
                    } catch (java.io.IOException unused6) {
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                r0 = str;
                inputStream = context;
                th = th2;
            }
        } catch (java.io.IOException e4) {
            e = e4;
            inputStreamOpen = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private static java.lang.String getMD5(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            java.lang.String lowerCase = new java.math.BigInteger(1, messageDigest.digest()).toString(16).toLowerCase();
            while (lowerCase.length() < 32) {
                lowerCase = "0" + lowerCase;
            }
            return lowerCase;
        } catch (java.security.NoSuchAlgorithmException e) {
            com.tencent.safecloud.device.openlib.LogUtil.e("md5 error！" + com.tencent.safecloud.device.openlib.ErrorManager.catchMsg(e), e);
            return "";
        }
    }

    public static java.lang.String getModelName() {
        return "safecloud_model_" + com.tencent.safecloud.device.SCInterface.instance.getSDKVersion().replace(".", "_");
    }

    public static java.lang.String getProcessName(android.content.Context context) {
        int iMyPid = android.os.Process.myPid();
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public static java.lang.String getVersionName(android.content.Context context) {
        try {
            java.lang.String packageName = context.getPackageName();
            return packageName + "_" + context.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (java.lang.Exception e) {
            com.tencent.safecloud.device.openlib.LogUtil.e("package name" + com.tencent.safecloud.device.openlib.ErrorManager.catchMsg(e), e);
            return null;
        }
    }

    public static boolean isNullStr(java.lang.String str) {
        return str == null || "".equals(str);
    }
}
