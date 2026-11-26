package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class C0086b {
    public static int a(int i, boolean z, int i2) {
        return i | ((z ? 1 : 0) << i2);
    }

    public static int a(android.util.SparseArray<java.lang.Object> sparseArray) {
        java.lang.Integer num = (java.lang.Integer) a(sparseArray, 0, java.lang.Integer.class);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static android.util.SparseArray<java.lang.Object> a() {
        return new android.util.SparseArray<>();
    }

    public static <E> E a(android.util.SparseArray<java.lang.Object> sparseArray, int i, java.lang.Class<E> cls) {
        if (sparseArray == null) {
            return null;
        }
        java.lang.Object obj = sparseArray.get(i);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.pm.Signature[] signatureArr;
        try {
            signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (java.lang.Throwable unused) {
            signatureArr = null;
        }
        if (signatureArr != null) {
            for (android.content.pm.Signature signature : signatureArr) {
                if ("SHA1".equals(str2)) {
                    byte[] byteArray = signature.toByteArray();
                    try {
                        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
                        if (messageDigest == null) {
                            return null;
                        }
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        return sb.toString();
                    } catch (java.security.NoSuchAlgorithmException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(bArr.length);
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase(java.util.Locale.getDefault()));
        }
        return stringBuffer.toString();
    }

    public static java.util.List<java.lang.String> a(java.io.File file) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.jar.JarFile jarFile = new java.util.jar.JarFile(file);
        try {
            java.security.cert.Certificate[] certificateArrA = a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), new byte[8192]);
            if (certificateArrA != null) {
                for (java.security.cert.Certificate certificate : certificateArrA) {
                    arrayList.add(b(certificate.getEncoded()));
                }
            }
        } catch (java.lang.Exception unused) {
        } finally {
            jarFile.close();
        }
        return arrayList;
    }

    public static void a(android.content.Context context, java.lang.String str, int i) {
        try {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("turingfd_protect_105548_28_advertisersMini", 0).edit();
            editorEdit.putInt(str, i);
            editorEdit.commit();
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(byte[] bArr, int[] iArr) {
        int length = bArr.length >> 2;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            iArr[i] = bArr[i2] & 255;
            int i4 = i3 + 1;
            iArr[i] = iArr[i] | ((bArr[i3] & 255) << 8);
            int i5 = i4 + 1;
            iArr[i] = iArr[i] | ((bArr[i4] & 255) << 16);
            iArr[i] = iArr[i] | ((bArr[i5] & 255) << 24);
            i++;
            i2 = i5 + 1;
        }
        if (i2 < bArr.length) {
            int i6 = i2 + 1;
            iArr[i] = bArr[i2] & 255;
            int i7 = 8;
            while (i6 < bArr.length) {
                iArr[i] = iArr[i] | ((bArr[i6] & 255) << i7);
                i6++;
                i7 += 8;
            }
        }
    }

    public static void a(int[] iArr, int i, byte[] bArr) {
        int i2;
        int length = bArr.length >> 2;
        if (length > i) {
            length = i;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = 8;
            if (i3 >= length) {
                break;
            }
            int i5 = i4 + 1;
            bArr[i4] = (byte) (iArr[i3] & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((iArr[i3] >>> 8) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((iArr[i3] >>> 16) & 255);
            i4 = i7 + 1;
            bArr[i7] = (byte) ((iArr[i3] >>> 24) & 255);
            i3++;
        }
        if (i <= length || i4 >= bArr.length) {
            return;
        }
        bArr[i4] = (byte) (iArr[i3] & 255);
        for (int i8 = i4 + 1; i2 <= 24 && i8 < bArr.length; i8++) {
            bArr[i8] = (byte) ((iArr[i3] >>> i2) & 255);
            i2 += 8;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] a(java.lang.String str) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            fileInputStream = new java.io.FileInputStream(str);
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream(fileInputStream.available());
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (-1 == i) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, i);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (byteArray == null) {
                        byteArray = "".getBytes();
                    }
                    a(fileInputStream);
                    a(byteArrayOutputStream2);
                    return byteArray;
                } catch (java.lang.Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th;
                    a(fileInputStream);
                    a(byteArrayOutputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrC = c(bArr2);
        if (bArr == null || bArrC == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr.length % 4 == 0 && bArr.length >= 8) {
            int[] iArr = new int[bArr.length >>> 2];
            a(bArr, iArr);
            int length = bArrC.length % 4 == 0 ? bArrC.length >>> 2 : (bArrC.length >>> 2) + 1;
            if (length < 4) {
                length = 4;
            }
            int[] iArr2 = new int[length];
            for (int i = 0; i < length; i++) {
                iArr2[i] = 0;
            }
            a(bArrC, iArr2);
            int length2 = iArr.length - 1;
            int i2 = iArr[length2];
            int i3 = iArr[0];
            for (int i4 = ((52 / (length2 + 1)) + 6) * (-1640531527); i4 != 0; i4 -= -1640531527) {
                int i5 = (i4 >>> 2) & 3;
                int i6 = i3;
                int i7 = length2;
                while (i7 > 0) {
                    int i8 = iArr[i7 - 1];
                    i6 = iArr[i7] - (((i6 ^ i4) + (i8 ^ iArr2[(i7 & 3) ^ i5])) ^ (((i8 >>> 5) ^ (i6 << 2)) + ((i6 >>> 3) ^ (i8 << 4))));
                    iArr[i7] = i6;
                    i7--;
                }
                int i9 = iArr[length2];
                i3 = iArr[0] - ((((i9 >>> 5) ^ (i6 << 2)) + ((i6 >>> 3) ^ (i9 << 4))) ^ ((i6 ^ i4) + (iArr2[(i7 & 3) ^ i5] ^ i9)));
                iArr[0] = i3;
            }
            int i10 = iArr[iArr.length - 1];
            if (i10 >= 0 && i10 <= ((iArr.length - 1) << 2)) {
                byte[] bArr3 = new byte[i10];
                a(iArr, iArr.length - 1, bArr3);
                return bArr3;
            }
        }
        return null;
    }

    public static java.security.cert.Certificate[] a(java.util.jar.JarFile jarFile, java.util.jar.JarEntry jarEntry, byte[] bArr) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
            do {
                try {
                } catch (java.io.IOException unused) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    return null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    throw th;
                }
            } while (inputStream.read(bArr, 0, bArr.length) != -1);
            java.security.cert.Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                inputStream.close();
            } catch (java.io.IOException unused4) {
            }
            return certificates;
        } catch (java.io.IOException unused5) {
            inputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static java.lang.String b(byte[] bArr) {
        byte[] bArrDigest;
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(new java.lang.String(b("4D4435")));
            messageDigest.update(bArr);
            bArrDigest = messageDigest.digest();
        } catch (java.security.NoSuchAlgorithmException unused) {
            bArrDigest = null;
        }
        return a(bArrDigest);
    }

    public static byte[] b() {
        try {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            int[] iArr = {-36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49};
            for (int i = 0; i < 21; i++) {
                stringBuffer.append((char) ("http://pmir.3g.qq.com".charAt(i) + iArr[i]));
            }
            return stringBuffer.toString().getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] b(java.lang.String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = java.lang.Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArrC = c(bArr2);
        if (bArr == null || bArrC == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
        int[] iArr = new int[length];
        a(bArr, iArr);
        iArr[length - 1] = bArr.length;
        int length2 = bArrC.length % 4 == 0 ? bArrC.length >>> 2 : (bArrC.length >>> 2) + 1;
        if (length2 < 4) {
            length2 = 4;
        }
        int[] iArr2 = new int[length2];
        for (int i = 0; i < length2; i++) {
            iArr2[i] = 0;
        }
        a(bArrC, iArr2);
        int length3 = iArr.length - 1;
        int i2 = iArr[length3];
        int i3 = iArr[0];
        int i4 = (52 / (length3 + 1)) + 6;
        int i5 = i2;
        int i6 = 0;
        while (true) {
            int i7 = i4 - 1;
            if (i4 <= 0) {
                byte[] bArr3 = new byte[iArr.length << 2];
                a(iArr, iArr.length, bArr3);
                return bArr3;
            }
            i6 -= 1640531527;
            int i8 = (i6 >>> 2) & 3;
            int i9 = i5;
            int i10 = 0;
            while (i10 < length3) {
                int i11 = i10 + 1;
                int i12 = iArr[i11];
                i9 = ((((i9 >>> 5) ^ (i12 << 2)) + ((i12 >>> 3) ^ (i9 << 4))) ^ ((i12 ^ i6) + (i9 ^ iArr2[(i10 & 3) ^ i8]))) + iArr[i10];
                iArr[i10] = i9;
                i10 = i11;
            }
            int i13 = iArr[0];
            i5 = ((((i9 >>> 5) ^ (i13 << 2)) + ((i13 >>> 3) ^ (i9 << 4))) ^ ((i13 ^ i6) + (iArr2[(i10 & 3) ^ i8] ^ i9))) + iArr[length3];
            iArr[length3] = i5;
            i4 = i7;
        }
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return bArr;
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.security.NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static byte d(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && (activeNetworkInfo.getState() == android.net.NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == android.net.NetworkInfo.State.CONNECTED)) {
                if (activeNetworkInfo.getType() == 1) {
                    return (byte) 0;
                }
                if (activeNetworkInfo.getType() == 0) {
                    return (android.net.Proxy.getDefaultHost() == null && android.net.Proxy.getHost(context) == null) ? (byte) 1 : (byte) 2;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return (byte) -1;
    }
}
