package com.bun.miitmdid.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class Utils {

    @android.support.annotation.Keep
    public static final java.lang.String CPU_ABI_X86 = "x86";

    @android.support.annotation.Keep
    private static java.lang.String CPUABI() {
        try {
            return new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream())).readLine().contains(CPU_ABI_X86) ? CPU_ABI_X86 : "arm";
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "arm";
        }
    }

    public static void PrintClassMethod(java.lang.Class<?> cls) {
        for (java.lang.reflect.Method method : cls.getMethods()) {
            java.lang.System.out.println(method.getName());
        }
    }

    public static void PrintObjectType(java.lang.Class<?> cls) {
        java.lang.String name = cls.getName();
        java.lang.System.out.println("PrintObjectType:" + name);
    }

    public static void PrintObjectType(java.lang.Object obj) {
        java.lang.String name = obj.getClass().getName();
        java.lang.System.out.println("PrintObjectType:" + name);
    }

    @android.support.annotation.Keep
    public static long getFileCRC(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                int length = (int) file.length();
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
                java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i += fileInputStream.read(bArr, i, length - i)) {
                }
                crc32.update(length);
                return crc32.getValue();
            }
        } catch (java.io.IOException unused) {
        }
        return -1L;
    }

    @android.support.annotation.Keep
    public static void getFileListame(java.lang.String str) {
        java.io.File[] fileArrListFiles = new java.io.File(str).listFiles();
        if (fileArrListFiles != null) {
            for (int i = 0; i < fileArrListFiles.length; i++) {
                android.util.Log.i("Utils", fileArrListFiles[i].getName());
                if (fileArrListFiles[i].isDirectory()) {
                    getFileListame(fileArrListFiles[i].getAbsolutePath());
                    android.util.Log.i("Utils", java.lang.String.valueOf(fileArrListFiles[i].getAbsolutePath()) + fileArrListFiles[i].getName());
                }
            }
        }
    }

    @android.support.annotation.Keep
    public static java.lang.String getLibraryDir(android.content.Context context) {
        return context.getApplicationInfo().nativeLibraryDir;
    }

    @android.support.annotation.Keep
    public static java.lang.String getUserDir(android.content.Context context) {
        return context.getFilesDir().getParent();
    }

    @android.support.annotation.Keep
    public static java.lang.String getXdataDir(android.content.Context context, java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(java.lang.String.valueOf(getUserDir(context)) + "/" + com.bun.miitmdid.core.JLibrary.xdata + "/" + str);
        return stringBuffer.toString();
    }

    @android.support.annotation.Keep
    public static java.lang.String getYdataDir(android.content.Context context, java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(java.lang.String.valueOf(getUserDir(context)) + "/" + com.bun.miitmdid.core.JLibrary.ydata + "/" + str);
        return stringBuffer.toString();
    }

    @android.support.annotation.Keep
    public static boolean isX86() {
        return android.os.Build.CPU_ABI.equals(CPU_ABI_X86) || CPUABI().equals(CPU_ABI_X86);
    }

    @android.support.annotation.Keep
    public static boolean update(android.content.Context context) throws java.lang.Exception {
        long zipCrc = com.bun.miitmdid.core.ZipUtils.getZipCrc(new java.io.File(context.getApplicationInfo().sourceDir));
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("update", 0);
        boolean z = zipCrc != sharedPreferences.getLong("crc", 0L);
        sharedPreferences.edit().putLong("crc", zipCrc).commit();
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.support.annotation.Keep
    public static void x0xooXdata(java.io.InputStream inputStream, java.lang.String str, android.content.Context context) throws java.lang.Exception {
        try {
            java.io.File file = new java.io.File(str);
            byte[] bArr = new byte[65536];
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream);
            java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
            while (true) {
                int i = bufferedInputStream.read(bArr);
                if (i <= 0) {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                    return;
                }
                bufferedOutputStream.write(bArr, 0, i);
            }
        } catch (java.lang.Exception e) {
            throw e;
        }
    }
}
