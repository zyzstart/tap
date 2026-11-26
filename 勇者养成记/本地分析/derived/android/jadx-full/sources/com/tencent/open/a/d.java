package com.tencent.open.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.open.a.d f689a;

    protected d() {
    }

    public static synchronized com.tencent.open.a.d a() {
        if (f689a == null) {
            f689a = new com.tencent.open.a.d();
        }
        return f689a;
    }

    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.Long l, int i2, int i3, java.lang.String str5) {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - l.longValue();
        if (l.longValue() == 0 || jElapsedRealtime < 0) {
            jElapsedRealtime = 0;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("https://huatuocode.huatuo.qq.com");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
        stringBuffer.append(i);
        stringBuffer.append("&code=");
        stringBuffer.append(i2);
        stringBuffer.append("&time=");
        stringBuffer.append(jElapsedRealtime);
        stringBuffer.append("&rate=");
        stringBuffer.append(i3);
        stringBuffer.append("&uin=");
        stringBuffer.append(str2);
        stringBuffer.append("&data=");
        com.tencent.open.a.g.a().a(stringBuffer.toString(), com.tencent.connect.common.Constants.HTTP_GET, com.tencent.open.utils.l.a(java.lang.String.valueOf(i), java.lang.String.valueOf(i2), java.lang.String.valueOf(jElapsedRealtime), java.lang.String.valueOf(i3), str, str2, str3, str4, str5), true);
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        com.tencent.open.a.g.a().a(com.tencent.open.utils.l.a(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8) {
        com.tencent.open.a.g.a().a(com.tencent.open.utils.l.a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10) {
        com.tencent.open.a.g.a().a(com.tencent.open.utils.l.a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }
}
