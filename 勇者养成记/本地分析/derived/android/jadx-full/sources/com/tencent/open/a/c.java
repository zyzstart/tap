package com.tencent.open.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f688a;
    private static java.lang.String b;

    public static java.lang.String a() {
        return "";
    }

    public static java.lang.String a(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(f688a)) {
            return f688a;
        }
        if (context == null) {
            return "";
        }
        f688a = "";
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            f688a = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f688a;
    }

    public static java.lang.String b() {
        return java.util.Locale.getDefault().getLanguage();
    }

    public static java.lang.String b(android.content.Context context) {
        return "";
    }

    public static java.lang.String c(android.content.Context context) {
        return "";
    }

    public static java.lang.String d(android.content.Context context) {
        return "";
    }

    public static java.lang.String e(android.content.Context context) {
        try {
            if (b == null) {
                android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
                android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("imei=");
                sb.append(b(context));
                sb.append('&');
                sb.append("model=");
                sb.append(android.os.Build.MODEL);
                sb.append('&');
                sb.append("os=");
                sb.append(android.os.Build.VERSION.RELEASE);
                sb.append('&');
                sb.append("apilevel=");
                sb.append(android.os.Build.VERSION.SDK_INT);
                sb.append('&');
                java.lang.String strB = com.tencent.open.a.a.b(context);
                if (strB == null) {
                    strB = "";
                }
                sb.append("network=");
                sb.append(strB);
                sb.append('&');
                sb.append("sdcard=");
                sb.append(android.os.Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append('&');
                sb.append("display=");
                sb.append(displayMetrics.widthPixels);
                sb.append('*');
                sb.append(displayMetrics.heightPixels);
                sb.append('&');
                sb.append("manu=");
                sb.append(android.os.Build.MANUFACTURER);
                sb.append("&");
                sb.append("wifi=");
                sb.append(com.tencent.open.a.a.e(context));
                b = sb.toString();
            }
            return b;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
