package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {
    public static int a(java.lang.String str) {
        if ("shareToQQ".equals(str)) {
            return 10103;
        }
        if ("shareToQzone".equals(str)) {
            return 10104;
        }
        if ("addToQQFavorites".equals(str)) {
            return 10105;
        }
        if ("sendToMyComputer".equals(str)) {
            return 10106;
        }
        if ("shareToTroopBar".equals(str)) {
            return 10107;
        }
        if ("action_login".equals(str)) {
            return com.tencent.connect.common.Constants.REQUEST_LOGIN;
        }
        return "action_request".equals(str) ? 10100 : -1;
    }

    public static int a(java.lang.String str, java.lang.String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        java.lang.String[] strArrSplit = str.split("\\.");
        java.lang.String[] strArrSplit2 = str2.split("\\.");
        int i = 0;
        while (i < strArrSplit.length && i < strArrSplit2.length) {
            try {
                int i2 = java.lang.Integer.parseInt(strArrSplit[i]);
                int i3 = java.lang.Integer.parseInt(strArrSplit2[i]);
                if (i2 < i3) {
                    return -1;
                }
                if (i2 > i3) {
                    return 1;
                }
                i++;
            } catch (java.lang.NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (strArrSplit.length > i) {
            return 1;
        }
        return strArrSplit2.length > i ? -1 : 0;
    }

    private static long a(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr, 0, 8192);
            if (i == -1) {
                com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j);
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    public static java.lang.String a(int i) {
        if (i == 10103) {
            return "shareToQQ";
        }
        if (i == 10104) {
            return "shareToQzone";
        }
        if (i == 10105) {
            return "addToQQFavorites";
        }
        if (i == 10106) {
            return "sendToMyComputer";
        }
        if (i == 10107) {
            return "shareToTroopBar";
        }
        if (i == 11101) {
            return "action_login";
        }
        if (i == 10100) {
            return "action_request";
        }
        return null;
    }

    public static java.lang.String a(android.app.Activity activity) {
        java.lang.String str;
        java.lang.String str2;
        try {
            android.content.pm.ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128);
            com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e = e;
            str = "openSDK_LOG.SystemUtils";
            str2 = "NameNotFoundException";
            com.tencent.open.log.SLog.e(str, str2, e);
            return null;
        } catch (java.lang.Exception e2) {
            e = e2;
            str = "openSDK_LOG.SystemUtils";
            str2 = "Exception";
            com.tencent.open.log.SLog.e(str, str2, e);
            return null;
        }
    }

    public static java.lang.String a(android.app.Activity activity, java.lang.String str) {
        if (activity == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] bArrA = com.tencent.open.utils.e.a(str);
            if (bArrA == null) {
                com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            java.lang.System.arraycopy(bArrA, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            java.lang.System.arraycopy(bArrA, 8, bArr2, 0, 16);
            return com.tencent.open.utils.e.a(activity.getPackageName(), com.tencent.open.utils.e.a(bArr2), bArr);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static boolean a() {
        try {
            return ((java.lang.Boolean) android.os.Environment.class.getMethod("isExternalStorageLegacy", new java.lang.Class[0]).invoke(android.os.Environment.class, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean a(android.content.Context context, android.content.Intent intent) {
        return (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (android.content.pm.Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (com.tencent.open.utils.l.f(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:? A[SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    public static boolean a(java.lang.String str, java.lang.String str2, int i) {
        java.io.InputStream inputStreamOpen;
        java.io.FileOutputStream fileOutputStream;
        com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libName: " + str);
        android.content.Context contextA = com.tencent.open.utils.f.a();
        if (contextA == null) {
            com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, global context is null. ");
            return false;
        }
        android.content.SharedPreferences sharedPreferences = contextA.getSharedPreferences("secure_lib", 0);
        java.io.File file = new java.io.File(contextA.getFilesDir(), str2);
        if (file.exists()) {
            int i2 = sharedPreferences.getInt(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, 0);
            com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: " + i + " | oldVersion: " + i2);
            if (i == i2) {
                return true;
            }
        } else {
            java.io.File parentFile = file.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    file.createNewFile();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        }
        java.io.FileOutputStream fileOutputStreamOpenFileOutput = null;
        fileOutputStreamOpenFileOutput = null;
        fileOutputStreamOpenFileOutput = null;
        java.io.InputStream inputStream = null;
        try {
            inputStreamOpen = contextA.getAssets().open(str);
            try {
                fileOutputStreamOpenFileOutput = contextA.openFileOutput(str2, 0);
                a(inputStreamOpen, fileOutputStreamOpenFileOutput);
                android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putInt(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, i);
                editorEdit.commit();
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
                return true;
            } catch (java.lang.Exception e2) {
                e = e2;
                java.io.FileOutputStream fileOutputStream2 = fileOutputStreamOpenFileOutput;
                inputStream = inputStreamOpen;
                fileOutputStream = fileOutputStream2;
                try {
                    com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException unused4) {
                        }
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    java.io.InputStream inputStream2 = inputStream;
                    fileOutputStreamOpenFileOutput = fileOutputStream;
                    inputStreamOpen = inputStream2;
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (java.io.IOException unused5) {
                        }
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        throw th;
                    }
                    try {
                        fileOutputStreamOpenFileOutput.close();
                        throw th;
                    } catch (java.io.IOException unused6) {
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    throw th;
                }
                fileOutputStreamOpenFileOutput.close();
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStreamOpen = null;
        }
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str) {
        com.tencent.open.log.SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        java.lang.String strA = "";
        try {
            java.lang.String packageName = context.getPackageName();
            android.content.pm.Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(signatureArr[0].toByteArray());
            java.lang.String strA2 = com.tencent.open.utils.l.a(messageDigest.digest());
            messageDigest.reset();
            com.tencent.open.log.SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + strA2);
            messageDigest.update(com.tencent.open.utils.l.i(packageName + "_" + strA2 + "_" + str + ""));
            strA = com.tencent.open.utils.l.a(messageDigest.digest());
            messageDigest.reset();
            com.tencent.open.log.SLog.v("openSDK_LOG.SystemUtils", "-->signEncryped: " + strA);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
        }
        return strA;
    }

    public static boolean b(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        try {
            context.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);
            com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled true");
            return true;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e = e;
            str = "openSDK_LOG.SystemUtils";
            str2 = "PackageManager.NameNotFoundException";
            com.tencent.open.log.SLog.e(str, str2, e);
            return false;
        } catch (java.lang.Exception e2) {
            e = e2;
            str = "openSDK_LOG.SystemUtils";
            str2 = "Exception";
            com.tencent.open.log.SLog.e(str, str2, e);
            return false;
        }
    }

    public static int c(android.content.Context context, java.lang.String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static boolean c(android.content.Context context) {
        return context != null && context.getApplicationInfo().targetSdkVersion >= 29 && android.os.Build.VERSION.SDK_INT >= 29 && !a();
    }

    public static int d(android.content.Context context, java.lang.String str) {
        return a(a(context, com.tencent.connect.common.Constants.PACKAGE_TIM), str);
    }

    public static int e(android.content.Context context, java.lang.String str) {
        return a(a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED), str);
    }
}
