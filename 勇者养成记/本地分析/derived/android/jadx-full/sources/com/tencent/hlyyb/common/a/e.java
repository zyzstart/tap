package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e implements com.tencent.hlyyb.common.a.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f531a;

    e() {
    }

    public static int a(java.lang.String str, int i, int i2, int i3) {
        int i4;
        try {
            java.lang.String strA = a(str, com.tencent.hlyyb.common.a.c());
            if (android.text.TextUtils.isEmpty(strA)) {
                strA = a(str, 0);
            }
            i4 = java.lang.Integer.parseInt(strA);
        } catch (java.lang.Throwable unused) {
            i4 = i3;
        }
        return com.tencent.hlyyb.common.f.c.a(i4, i, i2, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x014b, code lost:
    
        if ((r13 == -4 || r13 == -3 || r13 == -288) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        if ((r13 == -4 || r13 == -3 || r13 == -288) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
    
        if (r13 == 0) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r11, int r12, int r13, java.util.Map r14) {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hlyyb.common.a.e.a(java.lang.String, int, int, java.util.Map):int");
    }

    public static java.lang.String a() {
        return f531a;
    }

    private static java.lang.String a(java.lang.String str, int i) {
        return com.tencent.hlyyb.common.d.f.d().e().a(str, i, com.tencent.hlyyb.common.a.f(), com.tencent.hlyyb.common.a.f518a, com.tencent.hlyyb.common.d.b.a.c.a().a(com.tencent.hlyyb.common.a.f.b()), com.tencent.hlyyb.common.d.j.a(com.tencent.hlyyb.common.a.f.h()));
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        int iIndexOf;
        try {
            if (android.text.TextUtils.isEmpty(str) || -1 == (iIndexOf = str.indexOf("filename="))) {
                return null;
            }
            int i = iIndexOf + 9;
            int iIndexOf2 = str.indexOf(";", i);
            if (iIndexOf2 == -1) {
                iIndexOf2 = str.length();
            }
            java.lang.String strSubstring = str.substring(i, iIndexOf2);
            try {
                try {
                    strSubstring = java.net.URLDecoder.decode(strSubstring, com.unisound.b.f.b);
                } catch (java.io.UnsupportedEncodingException unused) {
                    strSubstring = java.net.URLDecoder.decode(strSubstring, "gbk");
                }
            } catch (java.io.UnsupportedEncodingException unused2) {
            }
            if (android.text.TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            int iLastIndexOf = strSubstring.lastIndexOf("/") + 1;
            java.lang.String strSubstring2 = iLastIndexOf > 0 ? strSubstring.substring(iLastIndexOf) : strSubstring;
            return !android.text.TextUtils.isEmpty(strSubstring2) ? c(strSubstring, str2) : strSubstring2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.String str5;
        java.lang.String strA = a(str3, str4);
        if (strA == null && (strA = b(str, str4)) == null) {
            str5 = "downloadfile" + str4;
            if (!android.text.TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK)) {
                str5 = str5 + ".apk";
            }
        } else {
            str5 = strA;
        }
        return !android.text.TextUtils.isEmpty(str5) ? str5.replace(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START, "").replace("*", "").replace(":", "").replace("\\", "").replace("/", "").replace("\"", "").replace("<", "").replace(">", "").replace("|", "") : str5;
    }

    public static void a(java.lang.String str) {
        f531a = str;
    }

    public static boolean a(int i) {
        return i > 0 && i <= Integer.MAX_VALUE && new java.util.Random().nextInt(i) == 0;
    }

    public static boolean a(java.lang.Exception exc) {
        java.lang.String message;
        if (!(exc instanceof java.io.IOException) || (message = exc.getMessage()) == null) {
            return false;
        }
        return message.contains("ENOSPC") || message.contains("No space left on device");
    }

    public static boolean a(java.lang.String str, boolean z, java.util.Map map, boolean z2, boolean z3) {
        if (map != null) {
            java.util.Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        try {
            com.tencent.hlyyb.common.c.m.d().a(str, z, map, false, true);
            return true;
        } catch (java.lang.Throwable th) {
            try {
                th.printStackTrace();
                return true;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.util.zip.Deflater deflater = new java.util.zip.Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[256];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.finish();
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0022  */
    private static int b(java.lang.String str, int i) {
        java.lang.String str2;
        if (str.equals("HLDisconnEvent")) {
            return -2;
        }
        int i2 = 1;
        if (i == 0) {
            str2 = "self_report_succ_denominator_value";
        } else {
            if (i == -4 || i == -3 || i == -288) {
                str2 = "self_report_succ_denominator_value";
            } else {
                str2 = "self_report_fail_denominator_value";
            }
        }
        if (i != 0) {
            if (!(i == -4 || i == -3 || i == -288)) {
                i2 = 50;
            }
        }
        return a(str2, 0, android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, i2);
    }

    public static long b() {
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getAbsolutePath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002b  */
    private static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.String strSubstring;
        int iLastIndexOf;
        try {
            java.lang.String strDecode = android.net.Uri.decode(str);
            if (strDecode == null) {
                strSubstring = null;
            } else {
                int iIndexOf = strDecode.indexOf(63);
                if (iIndexOf > 0) {
                    strDecode = strDecode.substring(0, iIndexOf);
                }
                if (strDecode.endsWith("/") || (iLastIndexOf = strDecode.lastIndexOf(47) + 1) <= 0) {
                    strSubstring = null;
                } else {
                    strSubstring = strDecode.substring(iLastIndexOf);
                }
            }
            if (android.text.TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            return c(strSubstring, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long c() {
        try {
            java.lang.String absolutePath = com.tencent.hlyyb.common.a.a().getFilesDir().getAbsolutePath();
            android.os.StatFs statFs = new android.os.StatFs(absolutePath);
            statFs.restat(absolutePath);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    private static java.lang.String c(java.lang.String str, java.lang.String str2) {
        int iLastIndexOf = str.lastIndexOf(".");
        java.lang.String strSubstring = "";
        if (iLastIndexOf > 0 && str.length() > iLastIndexOf + 1) {
            java.lang.String strSubstring2 = str.substring(0, iLastIndexOf);
            strSubstring = str.substring(iLastIndexOf);
            str = strSubstring2;
        }
        return str + str2 + strSubstring;
    }

    @Override // com.tencent.hlyyb.common.a.g
    public final void a(int i, java.lang.String str) {
        if (i != 0) {
            com.tencent.hlyyb.common.a.b.b();
            com.tencent.hlyyb.common.a.b.d();
            com.tencent.hlyyb.common.a.b.c();
        }
    }
}
