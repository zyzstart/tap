package com.tencent.bugly.crashreport.common.info;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.app.ActivityManager f290a;

    static {
        "@buglyAllChannel@".split(",");
        "@buglyAllChannelPriority@".split(",");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a(int i) throws java.lang.Throwable {
        java.io.FileReader fileReader = null;
        try {
            try {
                java.io.FileReader fileReader2 = new java.io.FileReader("/proc/" + i + "/cmdline");
                try {
                    char[] cArr = new char[512];
                    fileReader2.read(cArr);
                    int i2 = 0;
                    while (i2 < cArr.length && cArr[i2] != 0) {
                        i2++;
                    }
                    java.lang.String strSubstring = new java.lang.String(cArr).substring(0, i2);
                    try {
                        fileReader2.close();
                    } catch (java.lang.Throwable unused) {
                    }
                    return strSubstring;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (java.lang.Throwable unused2) {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    private static java.lang.String a(byte[] bArr) {
        java.security.cert.X509Certificate x509Certificate;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (bArr != null && bArr.length > 0) {
            try {
                java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
                if (certificateFactory == null || (x509Certificate = (java.security.cert.X509Certificate) certificateFactory.generateCertificate(new java.io.ByteArrayInputStream(bArr))) == null) {
                    return null;
                }
                sb.append("Issuer|");
                java.security.Principal issuerDN = x509Certificate.getIssuerDN();
                if (issuerDN != null) {
                    sb.append(issuerDN.toString());
                } else {
                    sb.append(android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN);
                }
                sb.append("\n");
                sb.append("SerialNumber|");
                java.math.BigInteger serialNumber = x509Certificate.getSerialNumber();
                if (issuerDN != null) {
                    sb.append(serialNumber.toString(16));
                } else {
                    sb.append(android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN);
                }
                sb.append("\n");
                sb.append("NotBefore|");
                java.util.Date notBefore = x509Certificate.getNotBefore();
                if (issuerDN != null) {
                    sb.append(notBefore.toString());
                } else {
                    sb.append(android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN);
                }
                sb.append("\n");
                sb.append("NotAfter|");
                java.util.Date notAfter = x509Certificate.getNotAfter();
                if (issuerDN != null) {
                    sb.append(notAfter.toString());
                } else {
                    sb.append(android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN);
                }
                sb.append("\n");
                sb.append("SHA1|");
                java.lang.String strA = com.tencent.bugly.proguard.z.a(java.security.MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
                if (strA == null || strA.length() <= 0) {
                    sb.append(android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN);
                } else {
                    sb.append(strA.toString());
                }
                sb.append("\n");
                sb.append("MD5|");
                java.lang.String strA2 = com.tencent.bugly.proguard.z.a(java.security.MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
                if (strA2 == null || strA2.length() <= 0) {
                    sb.append(android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN);
                } else {
                    sb.append(strA2.toString());
                }
            } catch (java.security.cert.CertificateException e) {
                if (!com.tencent.bugly.proguard.x.a(e)) {
                    e.printStackTrace();
                }
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return sb.length() == 0 ? android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN : sb.toString();
    }

    public static java.util.List<java.lang.String> a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return null;
        }
        try {
            java.lang.String str = map.get("BUGLY_DISABLE");
            if (str != null && str.length() != 0) {
                java.lang.String[] strArrSplit = str.split(",");
                for (int i = 0; i < strArrSplit.length; i++) {
                    strArrSplit[i] = strArrSplit[i].trim();
                }
                return java.util.Arrays.asList(strArrSplit);
            }
            return null;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        if (context == null || str == null || str.trim().length() <= 0) {
            return false;
        }
        try {
            java.lang.String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (java.lang.String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static android.content.pm.PackageInfo b(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0);
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && applicationInfo != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                return applicationLabel.toString();
            }
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static java.util.Map<java.lang.String, java.lang.String> d(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            java.util.HashMap map = new java.util.HashMap();
            java.lang.Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
            if (obj != null) {
                map.put("BUGLY_DISABLE", obj.toString());
            }
            java.lang.Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
            if (obj2 != null) {
                map.put("BUGLY_APPID", obj2.toString());
            }
            java.lang.Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
            if (obj3 != null) {
                map.put("BUGLY_APP_CHANNEL", obj3.toString());
            }
            java.lang.Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
            if (obj4 != null) {
                map.put("BUGLY_APP_VERSION", obj4.toString());
            }
            java.lang.Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
            if (obj5 != null) {
                map.put("BUGLY_ENABLE_DEBUG", obj5.toString());
            }
            java.lang.Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
            if (obj6 != null) {
                map.put("com.tencent.rdm.uuid", obj6.toString());
            }
            return map;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static java.lang.String e(android.content.Context context) {
        android.content.pm.Signature[] signatureArr;
        java.lang.String strA = a(context);
        if (strA == null) {
            return null;
        }
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(strA, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
                return null;
            }
            return a(packageInfo.signatures[0].toByteArray());
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean f(android.content.Context context) {
        if (context == null) {
            return false;
        }
        if (f290a == null) {
            f290a = (android.app.ActivityManager) context.getSystemService("activity");
        }
        try {
            android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
            f290a.getMemoryInfo(memoryInfo);
            if (!memoryInfo.lowMemory) {
                return false;
            }
            com.tencent.bugly.proguard.x.c("Memory is low.", new java.lang.Object[0]);
            return true;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public static java.lang.String g(android.content.Context context) {
        if (context == null) {
            return "";
        }
        java.lang.String strH = h(context);
        return !com.tencent.bugly.proguard.z.a(strH) ? strH : i(context);
    }

    private static java.lang.String h(android.content.Context context) {
        java.lang.String property = "";
        java.io.InputStream inputStreamOpen = null;
        try {
            try {
                try {
                    java.lang.String string = com.tencent.bugly.proguard.z.a("DENGTA_META", context).getString("key_channelpath", "");
                    if (com.tencent.bugly.proguard.z.a(string)) {
                        string = "channel.ini";
                    }
                    com.tencent.bugly.proguard.x.a("[AppInfo] Beacon channel file path: " + string, new java.lang.Object[0]);
                    if (!string.equals("")) {
                        inputStreamOpen = context.getAssets().open(string);
                        java.util.Properties properties = new java.util.Properties();
                        properties.load(inputStreamOpen);
                        property = properties.getProperty("CHANNEL", "");
                        com.tencent.bugly.proguard.x.a("[AppInfo] Beacon channel read from assert: " + property, new java.lang.Object[0]);
                        if (!com.tencent.bugly.proguard.z.a(property)) {
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                } catch (java.io.IOException e) {
                                    com.tencent.bugly.proguard.x.a(e);
                                }
                            }
                            return property;
                        }
                    }
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                } catch (java.lang.Exception unused) {
                    com.tencent.bugly.proguard.x.d("[AppInfo] Failed to get get beacon channel", new java.lang.Object[0]);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                }
            } catch (java.io.IOException e2) {
                com.tencent.bugly.proguard.x.a(e2);
            }
            return property;
        } catch (java.lang.Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (java.io.IOException e3) {
                    com.tencent.bugly.proguard.x.a(e3);
                }
            }
            throw th;
        }
    }

    private static java.lang.String i(android.content.Context context) {
        try {
            java.lang.Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
            return obj != null ? obj.toString() : "";
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.d("[AppInfo] Failed to read beacon channel from manifest.", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a(th);
            return "";
        }
    }
}
