package com.tencent.msdk.dns.base.log;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a implements com.tencent.msdk.dns.base.log.ILogNode {
    private java.lang.String a(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        return (23 >= str.length() || 24 <= android.os.Build.VERSION.SDK_INT) ? str : str.substring(0, 23);
    }

    private void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        int iMin;
        java.lang.String strA = a(str);
        if (str2 == null) {
            str2 = "";
        }
        if (th != null) {
            str2 = str2 + "\n" + android.util.Log.getStackTraceString(th);
        }
        if (4000 >= str2.length()) {
            android.util.Log.println(i, strA, str2);
            return;
        }
        int i2 = 0;
        int length = str2.length();
        while (i2 < length) {
            int iIndexOf = str2.indexOf(10, i2);
            if (-1 == iIndexOf) {
                iIndexOf = length;
            }
            while (true) {
                iMin = java.lang.Math.min(iIndexOf, i2 + com.pay.http.APPluginErrorCode.ERROR_APP_WECHAT);
                android.util.Log.println(i, strA, str2.substring(i2, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i2 = iMin;
                }
            }
            i2 = iMin + 1;
        }
    }

    @Override // com.tencent.msdk.dns.base.log.ILogNode
    public void println(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                a(i, str, str2, th);
                break;
        }
    }
}
