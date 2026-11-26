package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.Map<java.lang.String, java.lang.String> f457a = null;
    private static boolean b = false;

    public static android.content.Context a(android.content.Context context) {
        android.content.Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static android.content.SharedPreferences a(java.lang.String str, android.content.Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    private static java.io.BufferedReader a(java.io.File file) {
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            return new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), com.unisound.b.f.b));
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.a(th);
            return null;
        }
    }

    public static java.io.BufferedReader a(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return null;
        }
        try {
            java.io.File file = new java.io.File(str, str2);
            if (file.exists() && file.canRead()) {
                return a(file);
            }
            return null;
        } catch (java.lang.NullPointerException e) {
            com.tencent.bugly.proguard.x.a(e);
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Class<?>[] clsArr, java.lang.Object[] objArr) {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static <T> T a(byte[] bArr, android.os.Parcelable.Creator<T> creator) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        try {
            return creator.createFromParcel(parcelObtain);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        } finally {
            if (parcelObtain != null) {
                parcelObtain.recycle();
            }
        }
    }

    public static java.lang.String a() {
        return a(java.lang.System.currentTimeMillis());
    }

    public static java.lang.String a(long j) {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.US).format(new java.util.Date(j));
        } catch (java.lang.Exception unused) {
            return new java.util.Date().toString();
        }
    }

    /* JADX WARN: Code duplicated, block: B:76:0x00fe A[EXC_TOP_SPLITTER, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a(android.content.Context context, int i, java.lang.String str) {
        java.lang.Process processExec = null;
        if (!com.tencent.bugly.crashreport.common.info.AppInfo.a(context, "android.permission.READ_LOGS")) {
            com.tencent.bugly.proguard.x.d("no read_log permission!", new java.lang.Object[0]);
            return null;
        }
        java.lang.String[] strArr = str == null ? new java.lang.String[]{"logcat", "-d", "-v", "threadtime"} : new java.lang.String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            processExec = java.lang.Runtime.getRuntime().exec(strArr);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getInputStream()));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
                if (i > 0 && sb.length() > i) {
                    sb.delete(0, sb.length() - i);
                }
                if (processExec != null) {
                    try {
                        processExec.getOutputStream().close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        processExec.getInputStream().close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        processExec.getErrorStream().close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return sb.toString();
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            sb.append("\n[error:" + th.toString() + "]");
            return sb.toString();
        } finally {
            if (processExec != null) {
                processExec.getOutputStream().close();
                processExec.getInputStream().close();
                processExec.getErrorStream().close();
            }
        }
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        if (f457a == null) {
            f457a = new java.util.HashMap();
            java.util.ArrayList<java.lang.String> arrayListC = c(context, "getprop");
            if (arrayListC != null && arrayListC.size() > 0) {
                com.tencent.bugly.proguard.x.b(com.tencent.bugly.proguard.z.class, "Successfully get 'getprop' list.", new java.lang.Object[0]);
                java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                java.util.Iterator<java.lang.String> it = arrayListC.iterator();
                while (it.hasNext()) {
                    java.util.regex.Matcher matcher = patternCompile.matcher(it.next());
                    if (matcher.find()) {
                        f457a.put(matcher.group(1), matcher.group(2));
                    }
                }
                com.tencent.bugly.proguard.x.b(com.tencent.bugly.proguard.z.class, "System properties number: %d.", java.lang.Integer.valueOf(f457a.size()));
            }
        }
        return f457a.containsKey(str) ? f457a.get(str) : "fail";
    }

    public static java.lang.String a(java.io.File file, int i, boolean z) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        if (file != null && file.exists()) {
            try {
                if (file.canRead()) {
                    try {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), com.unisound.b.f.b));
                        while (true) {
                            try {
                                java.lang.String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                                sb.append("\n");
                                if (i > 0 && sb.length() > i) {
                                    if (z) {
                                        sb.delete(i, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i);
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                com.tencent.bugly.proguard.x.a(th);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (java.lang.Exception e) {
                                        com.tencent.bugly.proguard.x.a(e);
                                    }
                                }
                                return null;
                            }
                        }
                        java.lang.String string = sb.toString();
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Exception e2) {
                            com.tencent.bugly.proguard.x.a(e2);
                        }
                        return string;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public static java.lang.String a(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            th.printStackTrace(new java.io.PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (java.lang.Throwable th2) {
            if (com.tencent.bugly.proguard.x.a(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static java.lang.String a(java.util.Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.US).format(date);
        } catch (java.lang.Exception unused) {
            return new java.util.Date().toString();
        }
    }

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (byte b2 : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static java.lang.Thread a(java.lang.Runnable runnable, java.lang.String str) {
        try {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.e("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(int i, boolean z) {
        java.util.HashMap map = new java.util.HashMap(12);
        java.util.Map<java.lang.Thread, java.lang.StackTraceElement[]> allStackTraces = java.lang.Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        java.lang.Thread thread = android.os.Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        java.lang.Thread.currentThread().getId();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.Thread, java.lang.StackTraceElement[]> entry : allStackTraces.entrySet()) {
            sb.setLength(0);
            if (entry.getValue() != null && entry.getValue().length != 0) {
                for (java.lang.StackTraceElement stackTraceElement : entry.getValue()) {
                    if (i > 0 && sb.length() >= i) {
                        sb.append("\n[Stack over limit size :" + i + " , has been cut!]");
                        break;
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
                map.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
            }
        }
        return map;
    }

    public static java.util.Map<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> a(android.os.Parcel parcel) {
        android.os.Bundle bundle = parcel.readBundle();
        java.util.HashMap map = null;
        if (bundle == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int iIntValue = ((java.lang.Integer) bundle.get("pluginNum")).intValue();
        for (int i = 0; i < iIntValue; i++) {
            arrayList.add(bundle.getString("pluginKey" + i));
        }
        for (int i2 = 0; i2 < iIntValue; i2++) {
            arrayList2.add(new com.tencent.bugly.crashreport.common.info.PlugInBean(bundle.getString("pluginVal" + i2 + "plugInId"), bundle.getString("pluginVal" + i2 + "plugInVersion"), bundle.getString("pluginVal" + i2 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            map = new java.util.HashMap(arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                map.put(arrayList.get(i3), com.tencent.bugly.crashreport.common.info.PlugInBean.class.cast(arrayList2.get(i3)));
            }
        } else {
            com.tencent.bugly.proguard.x.e("map plugin parcel error!", new java.lang.Object[0]);
        }
        return map;
    }

    public static void a(android.os.Parcel parcel, java.util.Map<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(size);
        for (java.util.Map.Entry<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            bundle.putString("pluginKey" + i, (java.lang.String) arrayList.get(i));
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bundle.putString("pluginVal" + i2 + "plugInId", ((com.tencent.bugly.crashreport.common.info.PlugInBean) arrayList2.get(i2)).f291a);
            bundle.putString("pluginVal" + i2 + "plugInUUID", ((com.tencent.bugly.crashreport.common.info.PlugInBean) arrayList2.get(i2)).c);
            bundle.putString("pluginVal" + i2 + "plugInVersion", ((com.tencent.bugly.crashreport.common.info.PlugInBean) arrayList2.get(i2)).b);
        }
        parcel.writeBundle(bundle);
    }

    public static void a(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        try {
            java.lang.reflect.Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, obj);
        } catch (java.lang.Exception unused) {
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, long j) {
        com.tencent.bugly.proguard.x.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        try {
            java.io.File file = new java.io.File(context.getFilesDir() + java.io.File.separator + str);
            if (file.exists()) {
                if (java.lang.System.currentTimeMillis() - file.lastModified() < j) {
                    return false;
                }
                com.tencent.bugly.proguard.x.c("[Util] Lock file (%s) is expired, unlock it.", str);
                b(context, str);
            }
            if (file.createNewFile()) {
                com.tencent.bugly.proguard.x.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                return true;
            }
            com.tencent.bugly.proguard.x.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            return false;
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.a(th);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static boolean a(java.io.File file, java.io.File file2, int i) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.util.zip.ZipOutputStream zipOutputStream;
        com.tencent.bugly.proguard.x.c("rqdp{  ZF start}", new java.lang.Object[0]);
        if (file == null || file2 == null || file.equals(file2)) {
            com.tencent.bugly.proguard.x.d("rqdp{  err ZF 1R!}", new java.lang.Object[0]);
            return false;
        }
        if (!file.exists() || !file.canRead()) {
            com.tencent.bugly.proguard.x.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new java.lang.Object[0]);
            return false;
        }
        try {
            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
        }
        if (!file2.exists() || !file2.canRead()) {
            return false;
        }
        java.io.FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(new java.io.FileOutputStream(file2)));
                try {
                    zipOutputStream.setMethod(8);
                    zipOutputStream.putNextEntry(new java.util.zip.ZipEntry(file.getName()));
                    byte[] bArr = new byte[com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 <= 0) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, i2);
                    }
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        zipOutputStream.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                    com.tencent.bugly.proguard.x.c("rqdp{  ZF end}", new java.lang.Object[0]);
                    return true;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    try {
                        if (!com.tencent.bugly.proguard.x.a(th)) {
                            th.printStackTrace();
                        }
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        com.tencent.bugly.proguard.x.c("rqdp{  ZF end}", new java.lang.Object[0]);
                        return false;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (zipOutputStream != null) {
                            zipOutputStream.close();
                        }
                        com.tencent.bugly.proguard.x.c("rqdp{  ZF end}", new java.lang.Object[0]);
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                zipOutputStream = null;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            fileInputStream = null;
            zipOutputStream = null;
        }
    }

    public static boolean a(java.lang.Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        com.tencent.bugly.proguard.w wVarA = com.tencent.bugly.proguard.w.a();
        if (wVarA != null) {
            return wVarA.a(runnable);
        }
        java.lang.String[] strArrSplit = runnable.getClass().getName().split("\\.");
        return a(runnable, strArrSplit[strArrSplit.length - 1]) != null;
    }

    public static boolean a(java.lang.String str) {
        return str == null || str.trim().length() <= 0;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0055 A[Catch: all -> 0x0059, Exception -> 0x005b, TRY_ENTER, TryCatch #2 {Exception -> 0x005b, blocks: (B:7:0x001c, B:18:0x0035, B:19:0x0038, B:24:0x0055, B:25:0x0058), top: B:37:0x0006, outer: #3 }] */
    public static synchronized byte[] a(int i) {
        java.io.DataInputStream dataInputStream;
        java.io.DataInputStream dataInputStream2 = null;
        try {
            try {
                try {
                    byte[] bArr = new byte[16];
                    dataInputStream = new java.io.DataInputStream(new java.io.FileInputStream(new java.io.File("/dev/urandom")));
                    try {
                        dataInputStream.readFully(bArr);
                        dataInputStream.close();
                        return bArr;
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.tencent.bugly.proguard.x.e("Failed to read from /dev/urandom : %s", e);
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
                        keyGenerator.init(128, new java.security.SecureRandom());
                        return keyGenerator.generateKey().getEncoded();
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (0 != 0) {
                        dataInputStream2.close();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                dataInputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (0 != 0) {
                    dataInputStream2.close();
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            if (!com.tencent.bugly.proguard.x.b(e3)) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    @android.annotation.TargetApi(19)
    public static byte[] a(int i, byte[] bArr, byte[] bArr2) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, "[REDACTED]");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            if (android.os.Build.VERSION.SDK_INT < 21 || b) {
                cipher.init(i, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr2));
            } else {
                try {
                    cipher.init(i, secretKeySpec, new javax.crypto.spec.GCMParameterSpec(cipher.getBlockSize() << 3, bArr2));
                } catch (java.security.InvalidAlgorithmParameterException e) {
                    b = true;
                    throw e;
                }
            }
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception e2) {
            if (com.tencent.bugly.proguard.x.b(e2)) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(android.os.Parcelable parcelable) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static byte[] a(java.io.File file, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.util.zip.ZipOutputStream zipOutputStream;
        java.lang.Throwable th;
        byte[] byteArray = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        com.tencent.bugly.proguard.x.c("rqdp{  ZF start}", new java.lang.Object[0]);
        try {
            java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(str.getBytes("UTF-8"));
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            zipOutputStream = new java.util.zip.ZipOutputStream(byteArrayOutputStream);
            try {
                try {
                    zipOutputStream.setMethod(8);
                    zipOutputStream.putNextEntry(new java.util.zip.ZipEntry(str2));
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = byteArrayInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, i);
                    }
                    zipOutputStream.closeEntry();
                    zipOutputStream.flush();
                    zipOutputStream.finish();
                    byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        zipOutputStream.close();
                    } catch (java.io.IOException e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (!com.tencent.bugly.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (java.io.IOException e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                com.tencent.bugly.proguard.x.c("rqdp{  ZF end}", new java.lang.Object[0]);
                throw th;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            zipOutputStream = null;
        }
        com.tencent.bugly.proguard.x.c("rqdp{  ZF end}", new java.lang.Object[0]);
        return byteArray;
    }

    public static byte[] a(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        java.lang.Object[] objArr = new java.lang.Object[2];
        objArr[0] = java.lang.Integer.valueOf(bArr.length);
        objArr[1] = i == 2 ? "Gzip" : "zip";
        com.tencent.bugly.proguard.x.c("[Util] Zip %d bytes data with type %s", objArr);
        try {
            com.tencent.bugly.proguard.ae aeVarA = com.tencent.bugly.proguard.ad.a(i);
            if (aeVarA == null) {
                return null;
            }
            return aeVarA.a(bArr);
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, java.lang.String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return a(a(bArr, 2), 1, str);
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static byte[] a(byte[] bArr, int i, java.lang.String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        com.tencent.bugly.proguard.x.c("rqdp{  enD:} %d %d", java.lang.Integer.valueOf(bArr.length), java.lang.Integer.valueOf(i));
        try {
            com.tencent.bugly.proguard.aj ajVarA = com.tencent.bugly.proguard.a.a(i);
            if (ajVarA == null) {
                return null;
            }
            ajVarA.a(str);
            return ajVarA.b(bArr);
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static long b() {
        try {
            return (((java.lang.System.currentTimeMillis() + ((long) java.util.TimeZone.getDefault().getRawOffset())) / 86400000) * 86400000) - ((long) java.util.TimeZone.getDefault().getRawOffset());
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        return (com.tencent.bugly.crashreport.common.info.a.b() == null || com.tencent.bugly.crashreport.common.info.a.b().E == null) ? "" : com.tencent.bugly.crashreport.common.info.a.b().E.getString(str, str2);
    }

    public static java.lang.String b(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static java.lang.String b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return com.tencent.ysdk.shell.framework.constant.ConstantString.CONSTANT_STRING_NULL_CAPITAL;
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static java.util.Map<java.lang.String, java.lang.String> b(android.os.Parcel parcel) {
        android.os.Bundle bundle = parcel.readBundle();
        java.util.HashMap map = null;
        if (bundle == null) {
            return null;
        }
        java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList("keys");
        java.util.ArrayList<java.lang.String> stringArrayList2 = bundle.getStringArrayList("values");
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            com.tencent.bugly.proguard.x.e("map parcel error!", new java.lang.Object[0]);
        } else {
            map = new java.util.HashMap(stringArrayList.size());
            for (int i = 0; i < stringArrayList.size(); i++) {
                map.put(stringArrayList.get(i), stringArrayList2.get(i));
            }
        }
        return map;
    }

    public static void b(long j) {
        try {
            java.lang.Thread.sleep(j);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void b(android.os.Parcel parcel, java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(size);
        java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList<>(size);
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putStringArrayList("keys", arrayList);
        bundle.putStringArrayList("values", arrayList2);
        parcel.writeBundle(bundle);
    }

    public static void b(java.lang.String str) {
        if (str == null) {
            return;
        }
        java.io.File file = new java.io.File(str);
        if (file.isFile() && file.exists() && file.canWrite()) {
            file.delete();
        }
    }

    public static boolean b(android.content.Context context, java.lang.String str) {
        com.tencent.bugly.proguard.x.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        try {
            java.io.File file = new java.io.File(context.getFilesDir() + java.io.File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            com.tencent.bugly.proguard.x.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            return true;
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.a(th);
            return false;
        }
    }

    public static byte[] b(int i, byte[] bArr, byte[] bArr2) {
        try {
            java.security.PublicKey publicKeyGeneratePublic = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(bArr2));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception e) {
            if (com.tencent.bugly.proguard.x.b(e)) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        java.lang.Object[] objArr = new java.lang.Object[2];
        objArr[0] = java.lang.Integer.valueOf(bArr.length);
        objArr[1] = i == 2 ? "Gzip" : "zip";
        com.tencent.bugly.proguard.x.c("[Util] Unzip %d bytes data with type %s", objArr);
        try {
            com.tencent.bugly.proguard.ae aeVarA = com.tencent.bugly.proguard.ad.a(i);
            if (aeVarA == null) {
                return null;
            }
            return aeVarA.b(bArr);
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, java.lang.String str) {
        try {
            return b(b(bArr, 1, str), 2);
        } catch (java.lang.Exception e) {
            if (com.tencent.bugly.proguard.x.a(e)) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] b(byte[] bArr, int i, java.lang.String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        try {
            com.tencent.bugly.proguard.aj ajVarA = com.tencent.bugly.proguard.a.a(i);
            if (ajVarA == null) {
                return null;
            }
            ajVarA.a(str);
            return ajVarA.a(bArr);
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            com.tencent.bugly.proguard.x.d("encrytype %d %s", java.lang.Integer.valueOf(i), str);
            return null;
        }
    }

    public static long c(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return java.lang.Long.parseLong(new java.lang.String(bArr, com.unisound.b.f.b));
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static java.util.ArrayList<java.lang.String> c(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2;
        if (com.tencent.bugly.crashreport.common.info.AppInfo.f(context)) {
            return new java.util.ArrayList<>(java.util.Arrays.asList("unknown(low memory)"));
        }
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        java.io.BufferedReader bufferedReader3 = null;
        try {
            java.util.ArrayList arrayList2 = new java.util.ArrayList(java.util.Arrays.asList((new java.io.File("/system/bin/sh").exists() && new java.io.File("/system/bin/sh").canExecute()) ? "/system/bin/sh" : "sh", "-c"));
            arrayList2.add(str);
            java.lang.Process processExec = java.lang.Runtime.getRuntime().exec((java.lang.String[]) arrayList2.toArray(new java.lang.String[3]));
            bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getInputStream()));
            while (true) {
                try {
                    java.lang.String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    arrayList.add(line);
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = null;
                }
            }
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getErrorStream()));
            while (true) {
                try {
                    try {
                        java.lang.String line2 = bufferedReader.readLine();
                        if (line2 != null) {
                            arrayList.add(line2);
                        } else {
                            try {
                                break;
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        if (!com.tencent.bugly.proguard.x.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
                th = th3;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (bufferedReader == null) {
                    throw th;
                }
                try {
                    bufferedReader.close();
                    throw th;
                } catch (java.io.IOException e5) {
                    e5.printStackTrace();
                    throw th;
                }
            }
            bufferedReader2.close();
            try {
                bufferedReader.close();
            } catch (java.io.IOException e6) {
                e6.printStackTrace();
            }
            return arrayList;
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static boolean c(java.lang.String str) {
        if (str == null || str.trim().length() <= 0) {
            return false;
        }
        if (str.length() > 255) {
            com.tencent.bugly.proguard.x.a("URL(%s)'s length is larger than 255.", str);
            return false;
        }
        if (str.toLowerCase().startsWith("http")) {
            return true;
        }
        com.tencent.bugly.proguard.x.a("URL(%s) is not start with \"http\".", str);
        return false;
    }

    public static byte[] c(long j) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(j);
            return sb.toString().getBytes(com.unisound.b.f.b);
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
