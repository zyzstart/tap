package com.tencent.qqdownloader.pay.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f762a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String g;
    private int h;
    private java.lang.String k;
    private java.lang.String e = "";
    private java.lang.String f = "";
    private long i = 0;
    private long j = 0;

    public b(android.content.Context context) {
        this.f762a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.g = "";
        this.h = 1;
        this.k = "";
        this.c = b(context);
        d(context);
        this.b = c(context);
        this.h = 1;
        java.lang.String[] strArrC = com.tencent.qqdownloader.pay.utils.b.c(context);
        this.f762a = (strArrC == null || !com.tencent.qqdownloader.pay.utils.b.a(strArrC, 0)) ? com.tencent.qqdownloader.pay.utils.b.a(context) : strArrC[0];
        this.d = com.tencent.qqdownloader.pay.utils.b.b(context);
        this.g = a();
        this.k = ((java.lang.Object) a(android.os.Build.MODEL)) + "_" + ((java.lang.Object) a(android.os.Build.MANUFACTURER)) + "_" + ((java.lang.Object) a(android.os.Build.PRODUCT));
    }

    public static java.lang.String a() {
        try {
            return "35" + (android.os.Build.BOARD.length() % 10) + (android.os.Build.BRAND.length() % 10) + (android.os.Build.CPU_ABI.length() % 10) + (android.os.Build.DEVICE.length() % 10) + (android.os.Build.DISPLAY.length() % 10) + (android.os.Build.HOST.length() % 10) + (android.os.Build.ID.length() % 10) + (android.os.Build.MANUFACTURER.length() % 10) + (android.os.Build.MODEL.length() % 10) + (android.os.Build.PRODUCT.length() % 10) + (android.os.Build.TAGS.length() % 10) + (android.os.Build.TYPE.length() % 10) + (android.os.Build.USER.length() % 10);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return com.tencent.qqdownloader.pay.a.a.c(context).getString(com.tencent.qqdownloader.pay.a.b.e, "");
    }

    public static java.lang.StringBuffer a(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (android.text.TextUtils.isEmpty(str)) {
            stringBuffer.append("NA");
            return stringBuffer;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > ' ' && charArray[i] != '/' && charArray[i] != '_' && charArray[i] != '&' && charArray[i] != '|' && charArray[i] != '-') {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer;
    }

    public static void a(android.content.Context context, java.lang.String str) {
        com.tencent.qqdownloader.pay.a.a.a(context, com.tencent.qqdownloader.pay.a.b.e, str);
    }

    public static java.lang.String b(android.content.Context context) {
        try {
            return android.provider.Settings.Secure.getString(context.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private java.lang.String c(final android.content.Context context) {
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null && !android.text.TextUtils.isEmpty(connectionInfo.getMacAddress()) && !connectionInfo.getMacAddress().equals("02:00:00:00:00:00")) {
                return connectionInfo.getMacAddress();
            }
            final java.lang.String strA = com.tencent.qqdownloader.pay.utils.b.a();
            if (strA.length() <= 0) {
                return a(context);
            }
            com.tencent.qqdownloader.pay.a.d.a().a(new java.lang.Runnable() { // from class: com.tencent.qqdownloader.pay.c.b.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.qqdownloader.pay.c.b.a(context, strA);
                }
            });
            return strA;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private void d(android.content.Context context) {
        int iMax;
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1) {
            this.j = context.getResources().getDisplayMetrics().widthPixels;
            iMax = context.getResources().getDisplayMetrics().heightPixels;
        } else if (i == 2) {
            this.j = context.getResources().getDisplayMetrics().heightPixels;
            iMax = context.getResources().getDisplayMetrics().widthPixels;
        } else {
            int i2 = context.getResources().getDisplayMetrics().widthPixels;
            int i3 = context.getResources().getDisplayMetrics().heightPixels;
            this.j = java.lang.Math.min(i2, i3);
            iMax = java.lang.Math.max(i2, i3);
        }
        this.i = iMax;
    }

    public java.lang.String b() {
        return this.f762a;
    }

    public java.lang.String c() {
        return this.b;
    }

    public java.lang.String d() {
        return this.c;
    }

    public java.lang.String e() {
        return this.d;
    }

    public int f() {
        return this.h;
    }

    public long g() {
        return this.i;
    }

    public long h() {
        return this.j;
    }

    public java.lang.String i() {
        return this.k;
    }

    public java.lang.String toString() {
        return "DeviceInfo{imei='" + this.f762a + "', macAdress='" + this.b + "', androidId='" + this.c + "', imsi='" + this.d + "', imsi2='" + this.e + "', imei2='" + this.f + "', sdkVersion=" + this.h + ", deviceHeight=" + this.i + ", deviceWidth=" + this.j + ", moduleInfo='" + this.k + "'}";
    }
}
