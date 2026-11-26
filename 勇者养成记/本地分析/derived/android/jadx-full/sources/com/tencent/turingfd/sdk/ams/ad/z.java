package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class z {
    public static final java.lang.String Qa = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.A);
    public static final java.lang.String Ra = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.B);
    public static final java.lang.String Sa = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.C);
    public static final java.lang.String Ta = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.D);
    public static final java.lang.String Ua = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.F);
    public static long Va = 0;
    public static final java.lang.String[] Wa = {"^/data/user/\\d+$", "^/data/data$"};

    static class a {
        public final java.lang.String Pa;
        public final boolean match;

        public a(boolean z, java.lang.String str) {
            this.match = z;
            this.Pa = str;
        }
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append("_");
        try {
            str2 = context.getPackageManager().getApplicationInfo(str, 0).sourceDir;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            str2 = "";
        }
        try {
            sb.append(com.tencent.turingfd.sdk.ams.ad.C0086b.a(new java.io.File(str2)).get(0));
        } catch (java.lang.Throwable unused2) {
            sb.append("");
        }
        sb.append("_");
        long length = -1;
        if (!android.text.TextUtils.isEmpty(str2)) {
            java.io.File file = new java.io.File(str2);
            if (file.exists()) {
                length = file.length();
            }
        }
        sb.append(length);
        sb.append("_");
        sb.append(android.os.Process.myUid());
        return sb.toString();
    }

    public static java.lang.String h() {
        return "" + Va;
    }

    public static boolean i() {
        try {
            return 999 == android.os.Process.myUid() / 100000;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:219:0x0351 */
    /* JADX WARN: Code duplicated, block: B:124:0x0213  */
    /* JADX WARN: Code duplicated, block: B:126:0x0217  */
    /* JADX WARN: Code duplicated, block: B:127:0x0222  */
    public static java.lang.String k(android.content.Context context) throws java.lang.Throwable {
        java.io.File parentFile;
        boolean z;
        com.tencent.turingfd.sdk.ams.ad.z.a aVar;
        int iA;
        java.io.FileReader fileReader;
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2;
        java.lang.String name;
        java.lang.String packageName;
        java.lang.String strSubstring;
        boolean z2;
        com.tencent.turingfd.sdk.ams.ad.z.a aVar2;
        int iIndexOf;
        int iLastIndexOf;
        boolean z3;
        com.tencent.turingfd.sdk.ams.ad.z.a aVar3;
        java.lang.String str;
        java.lang.reflect.Method method;
        java.lang.String str2;
        com.tencent.turingfd.sdk.ams.ad.z.a aVar4;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.ArrayList<com.tencent.turingfd.sdk.ams.ad.p> arrayList = new java.util.ArrayList();
        java.io.File parentFile2 = context.getApplicationContext().getFilesDir().getParentFile();
        if (parentFile2 == null || (parentFile = parentFile2.getParentFile()) == null) {
            aVar = new com.tencent.turingfd.sdk.ams.ad.z.a(false, "");
        } else {
            java.lang.String[] strArr = Wa;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                }
                if (java.util.regex.Pattern.compile(strArr[i]).matcher(parentFile.getAbsolutePath()).find()) {
                    z = false;
                    break;
                }
                i++;
            }
            java.lang.String absolutePath = parentFile2.getAbsolutePath();
            java.lang.String packageName2 = context.getPackageName();
            java.lang.String[] strArrSplit = absolutePath.split("/", 6);
            if (absolutePath.startsWith("/data/data/") && strArrSplit.length >= 4 && !android.text.TextUtils.isEmpty(strArrSplit[3])) {
                packageName2 = strArrSplit[3];
            } else if (absolutePath.startsWith("/data/user/") && strArrSplit.length >= 5 && !android.text.TextUtils.isEmpty(strArrSplit[4])) {
                packageName2 = strArrSplit[4];
            }
            aVar = (!z || packageName2.equals(context.getPackageName())) ? new com.tencent.turingfd.sdk.ams.ad.z.a(z, "") : new com.tencent.turingfd.sdk.ams.ad.z.a(z, b(context, packageName2));
        }
        if (!aVar.match || android.text.TextUtils.isEmpty(aVar.Pa)) {
            iA = com.tencent.turingfd.sdk.ams.ad.C0086b.a(0, false, 0);
        } else {
            iA = com.tencent.turingfd.sdk.ams.ad.C0086b.a(0, true, 0);
            com.tencent.turingfd.sdk.ams.ad.p pVar = new com.tencent.turingfd.sdk.ams.ad.p();
            pVar.oa = Qa + Sa;
            pVar.pa = aVar.Pa;
            arrayList.add(pVar);
        }
        android.content.Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            aVar2 = new com.tencent.turingfd.sdk.ams.ad.z.a(false, "");
        } else {
            try {
                fileReader = new java.io.FileReader("/proc/self/maps");
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader);
                    while (true) {
                        try {
                            java.lang.String line = bufferedReader.readLine();
                            if (line != null) {
                                int iIndexOf2 = line.indexOf(47);
                                if (iIndexOf2 != -1) {
                                    java.lang.String strTrim = line.substring(iIndexOf2).trim();
                                    if (android.os.Build.VERSION.SDK_INT >= 23) {
                                        if (strTrim.startsWith("/data/app/") && strTrim.endsWith("/base.odex")) {
                                            java.lang.String[] strArrSplit2 = strTrim.split("/");
                                            if (strArrSplit2.length >= 7) {
                                                name = strArrSplit2[3];
                                                break;
                                            }
                                        }
                                    } else if (strTrim.startsWith("/data/dalvik-cache/") && strTrim.endsWith(".apk@classes.dex") && (iLastIndexOf = strTrim.lastIndexOf(47)) != -1) {
                                        java.lang.String strReplace = strTrim.substring(iLastIndexOf, strTrim.length() - 12).replace('@', '/');
                                        if (strReplace.startsWith("/data/app/")) {
                                            java.io.File file = new java.io.File(strReplace);
                                            if (!"base.apk".equals(file.getName())) {
                                                name = file.getName();
                                                break;
                                            }
                                            if (file.getParentFile() != null) {
                                                name = file.getParentFile().getName();
                                                break;
                                            }
                                        }
                                    }
                                    packageName = applicationContext.getPackageName();
                                    if (!android.text.TextUtils.isEmpty(name) || (iIndexOf = name.indexOf("-")) == -1) {
                                        strSubstring = packageName;
                                        z2 = false;
                                    } else {
                                        strSubstring = name.substring(0, iIndexOf);
                                        if (android.text.TextUtils.isEmpty(strSubstring)) {
                                            strSubstring = packageName;
                                            z2 = false;
                                        } else {
                                            java.io.File file2 = new java.io.File("/data/data/" + strSubstring);
                                            if (!file2.exists() || !file2.canWrite()) {
                                                strSubstring = packageName;
                                            }
                                            z2 = !android.text.TextUtils.equals(packageName, strSubstring);
                                        }
                                    }
                                    if (z2) {
                                        aVar2 = new com.tencent.turingfd.sdk.ams.ad.z.a(z2, b(context, strSubstring));
                                    } else {
                                        aVar2 = new com.tencent.turingfd.sdk.ams.ad.z.a(z2, "");
                                    }
                                }
                            }
                            name = null;
                            break;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            com.tencent.turingfd.sdk.ams.ad.C0086b.a(fileReader);
                            com.tencent.turingfd.sdk.ams.ad.C0086b.a(bufferedReader2);
                            throw th;
                        }
                    }
                    com.tencent.turingfd.sdk.ams.ad.C0086b.a(fileReader);
                    com.tencent.turingfd.sdk.ams.ad.C0086b.a(bufferedReader);
                } catch (java.lang.Throwable unused) {
                    bufferedReader = null;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileReader = null;
            }
            packageName = applicationContext.getPackageName();
            if (android.text.TextUtils.isEmpty(name)) {
                strSubstring = packageName;
                z2 = false;
            } else {
                strSubstring = packageName;
                z2 = false;
            }
            if (z2) {
                aVar2 = new com.tencent.turingfd.sdk.ams.ad.z.a(z2, b(context, strSubstring));
            } else {
                aVar2 = new com.tencent.turingfd.sdk.ams.ad.z.a(z2, "");
            }
        }
        int iA2 = com.tencent.turingfd.sdk.ams.ad.C0086b.a(iA, aVar2.match, 1);
        if (aVar2.match) {
            com.tencent.turingfd.sdk.ams.ad.p pVar2 = new com.tencent.turingfd.sdk.ams.ad.p();
            pVar2.oa = Qa + Ta;
            pVar2.pa = aVar2.Pa;
            arrayList.add(pVar2);
        }
        if (android.os.Build.VERSION.SDK_INT < 17) {
            aVar3 = new com.tencent.turingfd.sdk.ams.ad.z.a(false, "");
        } else {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            try {
                try {
                    if ("HUAWEI".equalsIgnoreCase(android.os.Build.BRAND)) {
                        try {
                            java.lang.Class<?> cls = java.lang.Class.forName("android.os.UserManager");
                            java.lang.reflect.Field field = context.getClass().getField("USER_SERVICE");
                            field.setAccessible(true);
                            java.lang.Object systemService = context.getSystemService((java.lang.String) field.get(context));
                            if (systemService == null || (method = cls.getMethod("getUserName", new java.lang.Class[0])) == null) {
                                str = "";
                            } else {
                                method.setAccessible(true);
                                str = (java.lang.String) method.invoke(systemService, new java.lang.Object[0]);
                            }
                        } catch (java.lang.Throwable unused2) {
                        }
                        java.lang.String str3 = new java.lang.String(android.util.Base64.decode("5YiG6Lqr5bqU55So", 0));
                        if (!android.text.TextUtils.isEmpty(str) && str3.equals(str)) {
                            sb2.append("HuaWei");
                            z3 = true;
                        }
                        aVar3 = new com.tencent.turingfd.sdk.ams.ad.z.a(z3, sb2.toString());
                    } else {
                        if ("xiaomi".equalsIgnoreCase(android.os.Build.BRAND)) {
                            if (i()) {
                                sb2.append("XiaoMi");
                                z3 = true;
                            }
                        } else if ("oppo".equalsIgnoreCase(android.os.Build.BRAND)) {
                            if (i()) {
                                sb2.append("OPPO");
                                z3 = true;
                            }
                        } else if ("vivo".equalsIgnoreCase(android.os.Build.BRAND)) {
                            if (i()) {
                                sb2.append("VIVO_A");
                                z3 = true;
                            } else {
                                java.lang.String str4 = new java.lang.String(com.tencent.turingfd.sdk.ams.ad.C0086b.a("/proc/self/mountinfo"));
                                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                sb3.append(context.getApplicationContext().getPackageName());
                                sb3.append("_cloned");
                                if (str4.contains(sb3.toString())) {
                                    sb2.append("VIVO_B");
                                    z3 = true;
                                }
                            }
                        }
                        aVar3 = new com.tencent.turingfd.sdk.ams.ad.z.a(z3, sb2.toString());
                    }
                    z3 = false;
                } catch (java.lang.Throwable unused3) {
                }
            } catch (java.lang.Throwable unused4) {
                z3 = false;
            }
            aVar3 = new com.tencent.turingfd.sdk.ams.ad.z.a(z3, sb2.toString());
        }
        int iA3 = com.tencent.turingfd.sdk.ams.ad.C0086b.a(iA2, aVar3.match, 2);
        if (aVar3.match) {
            com.tencent.turingfd.sdk.ams.ad.p pVar3 = new com.tencent.turingfd.sdk.ams.ad.p();
            pVar3.oa = Qa + Ua;
            pVar3.pa = aVar3.Pa;
            arrayList.add(pVar3);
        }
        int iMyUid = android.os.Process.myUid();
        if (iMyUid < 10000) {
            aVar4 = new com.tencent.turingfd.sdk.ams.ad.z.a(false, "");
        } else {
            java.lang.String[] packagesForUid = com.tencent.turingfd.sdk.ams.ad.l.getPackagesForUid(iMyUid);
            java.lang.String packageName3 = context.getPackageName();
            int length2 = packagesForUid.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    str2 = null;
                    break;
                }
                str2 = packagesForUid[i2];
                if (!str2.equals(packageName3)) {
                    break;
                }
                i2++;
            }
            aVar4 = !android.text.TextUtils.isEmpty(str2) ? new com.tencent.turingfd.sdk.ams.ad.z.a(true, b(context, str2)) : new com.tencent.turingfd.sdk.ams.ad.z.a(false, "");
        }
        int iA4 = com.tencent.turingfd.sdk.ams.ad.C0086b.a(iA3, aVar4.match, 3);
        if (aVar4.match) {
            com.tencent.turingfd.sdk.ams.ad.p pVar4 = new com.tencent.turingfd.sdk.ams.ad.p();
            pVar4.oa = Qa + "dual_d";
            pVar4.pa = aVar4.Pa;
            arrayList.add(pVar4);
        }
        if (iA4 > 0) {
            com.tencent.turingfd.sdk.ams.ad.p pVar5 = new com.tencent.turingfd.sdk.ams.ad.p();
            pVar5.oa = Qa + Ra;
            pVar5.pa = "" + iA4;
            arrayList.add(pVar5);
        }
        Va = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
        for (com.tencent.turingfd.sdk.ams.ad.p pVar6 : arrayList) {
            sb.append(pVar6.oa);
            sb.append(':');
            sb.append(pVar6.pa);
            sb.append(",");
        }
        return sb.toString();
    }
}
