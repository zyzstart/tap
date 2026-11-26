package com.tencent.beacon.core.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.Random f157a = new java.util.Random();
    private static final java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(0);
    private static java.lang.String c;

    public static int a(int i) {
        return f157a.nextInt(i);
    }

    public static int a(java.lang.String str, int i, int i2, int i3) {
        int iIntValue;
        if (str != null) {
            try {
                iIntValue = java.lang.Integer.valueOf(str).intValue();
            } catch (java.lang.Exception unused) {
                iIntValue = i;
            } catch (java.lang.Throwable th) {
                com.tencent.beacon.core.e.d.a(th);
            }
            if (iIntValue >= i2 && iIntValue <= i3) {
                return iIntValue;
            }
        }
        return i;
    }

    public static long a(java.lang.String str, long j, long j2, long j3) {
        long jLongValue;
        if (str == null) {
            return j;
        }
        try {
            jLongValue = java.lang.Long.valueOf(str).longValue();
        } catch (java.lang.Exception unused) {
            jLongValue = j;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            return j;
        }
        return (jLongValue < j2 || jLongValue > j3) ? j : jLongValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.Object a(byte[] bArr) {
        java.lang.Throwable th;
        java.io.ObjectInputStream objectInputStream;
        java.lang.Object object = null;
        if (bArr == null) {
            return null;
        }
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        try {
            objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
            try {
                object = objectInputStream.readObject();
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    com.tencent.beacon.core.e.d.a(th);
                    com.tencent.beacon.core.e.d.b(th.getMessage(), new java.lang.Object[0]);
                } finally {
                    a((java.io.Closeable) objectInputStream);
                    a((java.io.Closeable) byteArrayInputStream);
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            objectInputStream = null;
        }
        return object;
    }

    public static java.lang.String a() {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.US).format(new java.util.Date());
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            return "";
        }
    }

    public static java.lang.String a(long j) {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.US).format(new java.util.Date(j));
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            java.lang.String strA = com.tencent.beacon.core.info.c.a(context).a();
            com.tencent.beacon.core.info.b bVarB = com.tencent.beacon.core.info.b.b(context);
            java.lang.String strA2 = bVarB != null ? bVarB.a() : "";
            int iNextInt = f157a.nextInt(2147473647) + 1000;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(strA2);
            sb.append("_");
            sb.append(strA);
            sb.append("_");
            sb.append(new java.util.Date().getTime());
            sb.append("_");
            sb.append(iNextInt);
            return b(sb.toString());
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context, int i, java.lang.String str) {
        try {
            return b(java.lang.String.format("%1$s_%2$s_%3$s_%4$s_%5$s", com.tencent.beacon.core.info.c.a(context).a(), str, java.lang.Long.valueOf(new java.util.Date().getTime()), java.lang.Integer.valueOf(b.addAndGet(1)), java.lang.Integer.valueOf(i)));
        } catch (java.lang.Exception e) {
            com.tencent.beacon.core.e.d.b("get Rid error", e);
            return null;
        }
    }

    public static java.lang.String a(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter(stringWriter));
        java.lang.String strReplace = (th.getMessage() + "\n" + stringWriter.getBuffer().toString()).replace("\t", " ").replace("\n", "").replace("$", "-");
        return strReplace.length() > 1024 ? strReplace.substring(0, 1024) : strReplace;
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
                    com.tencent.beacon.core.e.d.a(th);
                    return null;
                } finally {
                    a((java.io.Closeable) bufferedReader);
                    a((java.io.Closeable) bufferedReader2);
                }
            }
            bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getErrorStream(), java.nio.charset.Charset.forName("UTF-8")));
            while (true) {
                try {
                    java.lang.String line2 = bufferedReader2.readLine();
                    if (line2 == null) {
                        a((java.io.Closeable) bufferedReader);
                        a((java.io.Closeable) bufferedReader2);
                        return arrayList;
                    }
                    arrayList.add(line2);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
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

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(int i, int i2) {
        return a(i2) + 1 <= i;
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
            com.tencent.beacon.core.e.d.a(th);
            return z;
        }
    }

    public static boolean a(java.util.Set set, java.util.ArrayList arrayList) {
        java.util.HashSet hashSetA = a(arrayList);
        java.lang.String[] strArr = (java.lang.String[]) set.toArray(new java.lang.String[0]);
        java.lang.String[] strArr2 = (java.lang.String[]) hashSetA.toArray(new java.lang.String[0]);
        java.util.Arrays.sort(strArr);
        java.util.Arrays.sort(strArr);
        return java.util.Arrays.equals(strArr, strArr2);
    }

    public static byte[] a(java.lang.Object obj) {
        java.io.ObjectOutputStream objectOutputStream;
        com.tencent.beacon.core.e.d.a("en obj 2 bytes ", new java.lang.Object[0]);
        if (obj == null || !java.io.Serializable.class.isInstance(obj)) {
            com.tencent.beacon.core.e.d.b("not serial obj ", new java.lang.Object[0]);
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a((java.io.Closeable) objectOutputStream);
                a((java.io.Closeable) byteArrayOutputStream);
                return byteArray;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    com.tencent.beacon.core.e.d.a(th);
                    com.tencent.beacon.core.e.d.b(th.getMessage(), new java.lang.Object[0]);
                    return null;
                } finally {
                    a((java.io.Closeable) objectOutputStream);
                    a((java.io.Closeable) byteArrayOutputStream);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            objectOutputStream = null;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        com.tencent.beacon.core.e.d.a("unzp: %s len: %s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(bArr.length));
        try {
            return com.tencent.beacon.core.c.a.a.b(i, bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("err unzp}" + th.toString(), new java.lang.Object[0]);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, java.lang.String str) {
        try {
            return a(b(bArr, i2, str), i);
        } catch (java.lang.Exception e) {
            com.tencent.beacon.core.e.d.a(e);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i, java.lang.String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        com.tencent.beacon.core.e.d.a("enD:} %d %d", java.lang.Integer.valueOf(bArr.length), java.lang.Integer.valueOf(i));
        try {
            return com.tencent.beacon.core.c.a.c.b(i, str, bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("err enD: %s", th.toString());
            return null;
        }
    }

    public static long b(long j) {
        return new java.util.Date().getTime() + j;
    }

    public static synchronized java.lang.String b(android.content.Context context) {
        if (com.tencent.beacon.core.e.j.b(c)) {
            java.lang.String str = "on_app_first_install_time_" + com.tencent.beacon.core.info.a.c(context);
            long jA = com.tencent.beacon.core.a.f.a(context).a(str, 0L);
            if (jA == 0) {
                jA = new java.util.Date().getTime();
                com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.core.e.a(context, str, jA));
            }
            java.lang.String strValueOf = java.lang.String.valueOf(jA);
            c = strValueOf;
            com.tencent.beacon.core.e.d.a("[cover] process: %s, getAppFirstInstallTime: %s", str, strValueOf);
        }
        com.tencent.beacon.core.e.d.a("[cover] getAppFirstInstallTime: %s", c);
        return c;
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String strC = c(str);
        if (strC == null) {
            return strC;
        }
        try {
            return strC.substring(8, 24);
        } catch (java.lang.Exception unused) {
            return strC;
        }
    }

    public static byte[] b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        com.tencent.beacon.core.e.d.a("zp: %s len: %s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(bArr.length));
        try {
            return com.tencent.beacon.core.c.a.a.a(i, bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("err zp : %s", th.toString());
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
            com.tencent.beacon.core.e.d.a(th);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i, java.lang.String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        try {
            return com.tencent.beacon.core.c.a.c.a(i, str, bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("err unD: %s", th.toString());
            return null;
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
            com.tencent.beacon.core.e.d.a(e);
            return str;
        }
    }

    public static java.util.Date d(java.lang.String str) {
        if (str != null && str.trim().length() > 0) {
            try {
                return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.US).parse(str);
            } catch (java.text.ParseException e) {
                com.tencent.beacon.core.e.d.a(e);
            }
        }
        return null;
    }

    public static java.lang.String e(java.lang.String str) throws java.lang.Throwable {
        java.lang.String string = "";
        java.io.FileInputStream fileInputStream = null;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            try {
                java.io.FileInputStream fileInputStream3 = new java.io.FileInputStream(str);
                try {
                    byte[] bArr = new byte[fileInputStream3.available()];
                    string = fileInputStream3.read(bArr) > 0 ? org.apache.http.util.EncodingUtils.getString(bArr, "UTF-8") : "";
                    a((java.io.Closeable) fileInputStream3);
                    fileInputStream = bArr;
                } catch (java.lang.Exception unused) {
                    fileInputStream2 = fileInputStream3;
                    com.tencent.beacon.core.e.d.b("Read file %s failed.", str);
                    a((java.io.Closeable) fileInputStream2);
                    fileInputStream = fileInputStream2;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream3;
                    a((java.io.Closeable) fileInputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception unused2) {
        }
        return string;
    }
}
