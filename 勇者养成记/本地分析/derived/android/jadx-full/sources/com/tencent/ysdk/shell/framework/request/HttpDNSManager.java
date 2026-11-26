package com.tencent.ysdk.shell.framework.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HttpDNSManager {
    private static volatile com.tencent.ysdk.shell.framework.request.HttpDNSManager instance;
    private com.tencent.msdk.dns.MSDKDnsResolver resolver;

    private HttpDNSManager() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            selfCheck();
        }
        com.tencent.msdk.dns.MSDKDnsResolver.getInstance().init(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), com.unisound.sdk.cb.c, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev(), 1000);
        this.resolver = com.tencent.msdk.dns.MSDKDnsResolver.getInstance();
        this.resolver.WGSetDnsOpenId(null);
    }

    public static com.tencent.ysdk.shell.framework.request.HttpDNSManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.request.HttpDNSManager.class) {
                instance = new com.tencent.ysdk.shell.framework.request.HttpDNSManager();
            }
        }
        instance.getHttpDns("");
        return instance;
    }

    private void selfCheck() {
        try {
            android.content.pm.ApplicationInfo applicationInfo = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageManager().getApplicationInfo(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageName(), 0);
            if (applicationInfo.targetSdkVersion < 28 || (applicationInfo.flags & oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_PT4Token) != 0) {
                return;
            }
            com.tencent.ysdk.libware.file.Logger.e("YSDK_DOCTOR", "注意！！android:usesCleartextTraffic为false，HTTP请求可能无法访问将导致HttpDNS功能异常");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public java.lang.String getHttpDns(java.lang.String str) {
        java.lang.String property = java.lang.System.getProperty("http.proxyHost");
        java.lang.String property2 = java.lang.System.getProperty("http.proxyPort");
        if (property != null && property2 != null) {
            return str;
        }
        try {
            java.net.URL url = new java.net.URL(str);
            java.lang.String addrByName = this.resolver.getAddrByName(url.getHost());
            android.util.Log.i("HttpDNSManager", addrByName);
            java.lang.String[] strArrSplit = addrByName.split(";");
            if (2 != strArrSplit.length || "0".equals(strArrSplit[0])) {
                return str;
            }
            return url.getProtocol() + "://" + strArrSplit[0];
        } catch (java.net.MalformedURLException unused) {
            return str;
        }
    }
}
