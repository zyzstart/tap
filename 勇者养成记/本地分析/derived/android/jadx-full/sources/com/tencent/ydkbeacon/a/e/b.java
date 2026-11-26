package com.tencent.ydkbeacon.a.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.Random f1198a = new java.util.Random();
    private static final java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(0);

    public static int a(java.lang.String str, int i, int i2, int i3) {
        int i4;
        if (str != null) {
            try {
                try {
                    i4 = java.lang.Integer.parseInt(str);
                } catch (java.lang.Exception e) {
                    com.tencent.ydkbeacon.a.e.c.a(e);
                    i4 = i;
                }
                if (i4 >= i2 && i4 <= i3) {
                    return i4;
                }
            } catch (java.lang.Throwable th) {
                com.tencent.ydkbeacon.a.e.c.a(th);
            }
        }
        return i;
    }

    public static long a(java.lang.String str, long j, long j2, long j3) {
        long j4;
        if (str == null) {
            return j;
        }
        try {
            try {
                j4 = java.lang.Long.parseLong(str);
            } catch (java.lang.Exception e) {
                com.tencent.ydkbeacon.a.e.c.a(e);
                j4 = j;
            }
            return (j4 < j2 || j4 > j3) ? j : j4;
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            return j;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.Object a(byte[] bArr) {
        java.lang.Throwable th;
        java.io.ObjectInputStream objectInputStream;
        java.io.Closeable[] closeableArr;
        java.lang.Object object = null;
        if (bArr == null) {
            return null;
        }
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        try {
            objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
            try {
                object = objectInputStream.readObject();
                a(objectInputStream);
                closeableArr = new java.io.Closeable[]{byteArrayInputStream};
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    com.tencent.ydkbeacon.a.e.c.a(th);
                    com.tencent.ydkbeacon.a.e.c.b(th.getMessage(), new java.lang.Object[0]);
                    a(objectInputStream);
                    closeableArr = new java.io.Closeable[]{byteArrayInputStream};
                } catch (java.lang.Throwable th3) {
                    a(objectInputStream);
                    a(byteArrayInputStream);
                    throw th3;
                }
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            objectInputStream = null;
        }
        a(closeableArr);
        return object;
    }

    public static java.lang.String a() {
        java.lang.String strE = com.tencent.ydkbeacon.a.c.f.p().e();
        com.tencent.ydkbeacon.a.c.c cVarD = com.tencent.ydkbeacon.a.c.c.d();
        return b((cVarD != null ? cVarD.f() : "") + "_" + strE + "_" + new java.util.Date().getTime() + "_" + (f1198a.nextInt(2147473647) + 1000));
    }

    public static java.lang.String a(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter(stringWriter));
        java.lang.String strReplace = (th.getMessage() + "\n" + stringWriter.getBuffer().toString()).replace("\t", " ").replace("\n", " ").replace("$", "-");
        return strReplace.length() > 10240 ? strReplace.substring(0, 10240) : strReplace;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.util.ArrayList a(java.lang.String[] strArr) {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.Process processExec = java.lang.Runtime.getRuntime().exec(strArr);
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getInputStream(), java.nio.charset.Charset.forName("UTF-8")));
            while (true) {
                try {
                    java.lang.String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    arrayList.add(line);
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader2 = null;
                }
                try {
                    com.tencent.ydkbeacon.a.e.c.a(th);
                    a(bufferedReader);
                    a(bufferedReader2);
                    return null;
                } catch (java.lang.Throwable th2) {
                    a(bufferedReader);
                    a(bufferedReader2);
                    throw th2;
                }
            }
            bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getErrorStream(), java.nio.charset.Charset.forName("UTF-8")));
            while (true) {
                try {
                    java.lang.String line2 = bufferedReader2.readLine();
                    if (line2 == null) {
                        a(bufferedReader);
                        a(bufferedReader2);
                        return arrayList;
                    }
                    arrayList.add(line2);
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedReader = null;
            bufferedReader2 = null;
        }
    }

    public static java.util.HashSet a(java.util.ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        java.util.HashSet hashSet = new java.util.HashSet(arrayList.size());
        hashSet.addAll(arrayList);
        return hashSet;
    }

    public static void a(java.io.Closeable... closeableArr) {
        for (java.io.Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (java.lang.Exception unused) {
                }
            }
        }
    }

    public static boolean a(java.lang.String str) {
        return str.startsWith("rqd_");
    }

    public static boolean a(java.lang.String str, boolean z) {
        if (str == null) {
            return z;
        }
        try {
            if (str.toLowerCase().equals("y")) {
                return true;
            }
            if (str.toLowerCase().equals("n")) {
                return false;
            }
            return z;
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            return z;
        }
    }

    public static byte[] a(java.lang.Object obj) {
        java.io.ObjectOutputStream objectOutputStream;
        if (!(obj instanceof java.io.Serializable)) {
            com.tencent.ydkbeacon.a.e.c.b("not serial obj ", new java.lang.Object[0]);
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a(objectOutputStream);
                a(byteArrayOutputStream);
                return byteArray;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    com.tencent.ydkbeacon.a.e.c.a(th);
                    com.tencent.ydkbeacon.a.e.c.b(th.getMessage(), new java.lang.Object[0]);
                    a(objectOutputStream);
                    a(byteArrayOutputStream);
                    return null;
                } catch (java.lang.Throwable th2) {
                    a(objectOutputStream);
                    a(byteArrayOutputStream);
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            objectOutputStream = null;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        com.tencent.ydkbeacon.a.e.c.a("unzp: %s len: %s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(bArr.length));
        try {
            return com.tencent.ydkbeacon.base.net.c.a.b(i, bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.b.d.b().a("509", "unzipData length: " + bArr.length + ",type:" + i, th);
            com.tencent.ydkbeacon.a.e.c.a(th);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("err unzp}");
            sb.append(th.toString());
            com.tencent.ydkbeacon.a.e.c.b(sb.toString(), new java.lang.Object[0]);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, java.lang.String str) {
        try {
            return a(b(bArr, i2, str), i);
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i, java.lang.String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        com.tencent.ydkbeacon.a.e.c.a("CoreUtils", "encry data length:%d type: %d", java.lang.Integer.valueOf(bArr.length), java.lang.Integer.valueOf(i));
        try {
            return com.tencent.ydkbeacon.base.net.c.c.b(i, str, bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            com.tencent.ydkbeacon.a.b.d.b().a("507", "data length: " + bArr.length + ",type:" + i + ",key: " + str, th);
            return null;
        }
    }

    public static long b() {
        return new java.util.Date().getTime() + com.tencent.ydkbeacon.a.c.c.d().j();
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String strC = c(str);
        if (strC == null) {
            return strC;
        }
        try {
            return strC.substring(8, 24);
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
            return strC;
        }
    }

    public static byte[] b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        com.tencent.ydkbeacon.a.e.c.a("zp: %s len: %s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(bArr.length));
        try {
            return com.tencent.ydkbeacon.base.net.c.a.a(i, bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.b.d.b().a("509", "zipData length: " + bArr.length + ",type:" + i, th);
            com.tencent.ydkbeacon.a.e.c.a(th);
            com.tencent.ydkbeacon.a.e.c.b("err zp : %s", th.toString());
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, java.lang.String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return a(b(bArr, i), i2, str);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i, java.lang.String str) {
        if (bArr == null || bArr.length <= 0 || i == -1) {
            return bArr;
        }
        try {
            return com.tencent.ydkbeacon.base.net.c.c.a(i, str, bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.e("data length: " + bArr.length + ",type:" + i + ",key: " + str + ",error: " + th.getMessage(), new java.lang.Object[0]);
            com.tencent.ydkbeacon.a.b.d dVarB = com.tencent.ydkbeacon.a.b.d.b();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("data length: ");
            sb.append(bArr.length);
            sb.append(",type:");
            sb.append(i);
            sb.append(",key: ");
            sb.append(str);
            dVarB.a("508", sb.toString(), th);
            return null;
        }
    }

    public static java.lang.String c() {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.US).format(new java.util.Date());
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            return "";
        }
    }

    public static java.lang.String c(java.lang.String str) {
        try {
            byte[] bArrDigest = java.security.MessageDigest.getInstance("MD5").digest(str.getBytes(java.nio.charset.Charset.forName("UTF-8")));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b2 : bArrDigest) {
                int i = b2 & 255;
                if (i < 16) {
                    sb.append(0);
                }
                sb.append(java.lang.Integer.toHexString(i));
            }
            return sb.toString();
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
            return str;
        }
    }

    public static java.util.Date d(java.lang.String str) {
        if (str != null && str.trim().length() > 0) {
            try {
                return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.US).parse(str);
            } catch (java.text.ParseException e) {
                com.tencent.ydkbeacon.a.e.c.a(e);
            }
        }
        return null;
    }

    public static java.lang.String e(java.lang.String str) throws java.lang.Throwable {
        java.io.Closeable[] closeableArr;
        java.lang.String str2 = "";
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(str);
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    str2 = fileInputStream2.read(bArr) > 0 ? new java.lang.String(bArr, "UTF-8") : "";
                    closeableArr = new java.io.Closeable[]{fileInputStream2};
                } catch (java.lang.Exception unused) {
                    fileInputStream = fileInputStream2;
                    com.tencent.ydkbeacon.a.e.c.b("Read file %s failed.", str);
                    closeableArr = new java.io.Closeable[]{fileInputStream};
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    a(fileInputStream);
                    throw th;
                }
            } catch (java.lang.Exception unused2) {
            }
            a(closeableArr);
            return str2;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
