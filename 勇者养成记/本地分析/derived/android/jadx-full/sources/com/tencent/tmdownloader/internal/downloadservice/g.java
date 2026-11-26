package com.tencent.tmdownloader.internal.downloadservice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmdownloader.internal.downloadservice.g f1136a;
    protected boolean b = true;
    protected boolean c = false;
    protected int d = 5;

    public g() {
        d();
    }

    public static synchronized com.tencent.tmdownloader.internal.downloadservice.g a() {
        if (f1136a == null) {
            f1136a = new com.tencent.tmdownloader.internal.downloadservice.g();
        }
        return f1136a;
    }

    private void d() {
        java.util.HashMap mapB = com.tencent.tmdownloader.internal.b.c.j.b();
        java.lang.String str = (java.lang.String) mapB.get("isTaskAutoResume");
        if (str != null && str.length() > 0) {
            this.b = !str.equals("false");
        }
        java.lang.String str2 = (java.lang.String) mapB.get("isDownloadWifiOnly");
        if (str2 != null && str2.length() > 0) {
            this.c = !str2.equals("false");
        }
        java.lang.String str3 = (java.lang.String) mapB.get("maxTaskNum");
        if (str3 == null || str3.length() <= 0) {
            return;
        }
        this.d = java.lang.Integer.valueOf(str3).intValue();
    }

    public void a(int i) {
        com.tencent.tmdownloader.internal.downloadservice.g gVar = f1136a;
        if (gVar.d == i) {
            return;
        }
        gVar.d = i;
        com.tencent.tmdownloader.internal.b.c.j.a("maxTaskNum", java.lang.String.valueOf(i), "Integer");
    }

    public void a(boolean z) {
        com.tencent.tmdownloader.internal.downloadservice.g gVar = f1136a;
        if (gVar.b == z) {
            return;
        }
        gVar.b = z;
        com.tencent.tmdownloader.internal.b.c.j.a("isTaskAutoResume", java.lang.String.valueOf(z), "boolean");
    }

    public boolean a(java.lang.String str, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.i("DownloadSetting", "isAutoDownload downloadInfoNetType = " + str + ",currentNetType = " + str2);
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        if (str2.equalsIgnoreCase("WIFI")) {
            return true;
        }
        return str2.contains("net") && !str.equalsIgnoreCase("WIFI");
    }

    public void b(boolean z) {
        com.tencent.tmdownloader.internal.downloadservice.g gVar = f1136a;
        if (gVar.c == z) {
            return;
        }
        gVar.c = z;
        com.tencent.tmdownloader.internal.b.c.j.a("isDownloadWifiOnly", java.lang.String.valueOf(z), "boolean");
    }

    public boolean b() {
        return this.c;
    }

    public boolean b(java.lang.String str, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.i("DownloadSetting", "isAutoPause downloadInfoNetType = " + str + ",currentNetType = " + str2);
        return (android.text.TextUtils.isEmpty(str) || !str.equalsIgnoreCase("WIFI") || str2.equalsIgnoreCase("WIFI")) ? false : true;
    }

    public boolean c() {
        if (!this.b) {
            return com.tencent.tmdownloader.internal.downloadservice.c.a().contains("wifi");
        }
        java.lang.String strA = com.tencent.tmdownloader.internal.downloadservice.c.a();
        return strA.contains("wifi") || strA.contains("net");
    }
}
