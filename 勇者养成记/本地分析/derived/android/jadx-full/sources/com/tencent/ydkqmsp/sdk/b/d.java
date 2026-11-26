package com.tencent.ydkqmsp.sdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[][] f1299a = {new byte[]{16, 99, -74, 82, 99, 26, 112, -8, 43, 100}, new byte[]{8, 127, -87, 73, 34, 55, 118, -78, 113, 62, -29, 0, 102, 56, 120, -16, 53, 113, -89, 73, 44, 55, 114, -90, 101, 93, -128, 105, 11, 123, 34, -77, 117, 43, -13, 119, 39, 53, 115, -14, 50, 99, -13, 110, 26, 96, 55, -39, 44, 119, -106, 88, 58, 114}, new byte[]{20, 96, -3, 68, 33, 44, 121}};

    public static java.lang.String a(int i) {
        return com.tencent.ydkqmsp.sdk.f.k.a(f1299a[i]);
    }

    public static void a(com.tencent.ydkqmsp.sdk.b.b bVar) {
        java.lang.String str = bVar.f1297a;
        java.lang.String str2 = bVar.d;
        java.lang.String str3 = bVar.c;
        com.tencent.ydkqmsp.sdk.b.c cVar = new com.tencent.ydkqmsp.sdk.b.c(bVar);
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            if (!(httpURLConnection instanceof java.net.HttpURLConnection)) {
                return;
            }
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setRequestProperty(a(0), a(1));
            java.io.InputStream inputStream = httpURLConnection.getInputStream();
            byte[] bArrA = a(inputStream);
            java.io.File file = new java.io.File(str3);
            if (!file.exists()) {
                file.mkdir();
            }
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(new java.io.File(file + java.io.File.separator + str2));
            fileOutputStream.write(bArrA);
            fileOutputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            cVar.f1298a = 0;
            java.lang.String strA = a(2);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("dwl:");
            sb.append(str);
            sb.append("  ok");
            com.tencent.ydkqmsp.sdk.f.g.c(strA, 0, sb.toString());
        } catch (java.lang.Exception unused) {
            cVar.f1298a = 1;
            com.tencent.ydkqmsp.sdk.f.g.c(a(2), 0, "dwl:" + str + "  fail");
        }
        com.tencent.ydkqmsp.sdk.c.f.i().d().a(cVar);
    }

    public static byte[] a(java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArr = new byte[1024];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }
}
