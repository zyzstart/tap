package com.tencent.connect.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.Class f458a = null;
    private static java.lang.Class b = null;
    private static java.lang.reflect.Method c = null;
    private static java.lang.reflect.Method d = null;
    private static java.lang.reflect.Method e = null;
    private static java.lang.reflect.Method f = null;
    private static boolean g = false;

    public static void a(android.content.Context context, com.tencent.connect.auth.QQToken qQToken, java.lang.String str, java.lang.String... strArr) {
        if (g) {
            b(context, qQToken);
            try {
                d.invoke(b, context, str, strArr);
            } catch (java.lang.Exception e2) {
                com.tencent.open.log.SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }

    public static boolean a(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        return com.tencent.open.utils.g.a(context, qQToken.getAppId()).b("[REDACTED]");
    }

    public static void b(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        java.lang.reflect.Method method;
        java.lang.Class cls;
        java.lang.Object[] objArr;
        try {
            if (a(context, qQToken)) {
                method = f;
                cls = f458a;
                objArr = new java.lang.Object[]{java.lang.Boolean.TRUE};
            } else {
                method = f;
                cls = f458a;
                objArr = new java.lang.Object[]{java.lang.Boolean.FALSE};
            }
            method.invoke(cls, objArr);
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("OpenConfig", "checkStatStatus exception: " + e2.toString());
        }
    }

    public static void c(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        java.lang.String str = "[REDACTED]" + qQToken.getAppId();
        try {
            f458a = java.lang.Class.forName("com.tencent.stat.StatConfig");
            java.lang.Class<?> cls = java.lang.Class.forName("com.tencent.stat.StatService");
            b = cls;
            c = cls.getMethod("reportQQ", android.content.Context.class, java.lang.String.class);
            d = b.getMethod("trackCustomEvent", android.content.Context.class, java.lang.String.class, java.lang.String[].class);
            e = b.getMethod("commitEvents", android.content.Context.class, java.lang.Integer.TYPE);
            f = f458a.getMethod("setEnableStatService", java.lang.Boolean.TYPE);
            b(context, qQToken);
            f458a.getMethod("setAutoExceptionCaught", java.lang.Boolean.TYPE).invoke(f458a, java.lang.Boolean.FALSE);
            f458a.getMethod("setEnableSmartReporting", java.lang.Boolean.TYPE).invoke(f458a, java.lang.Boolean.TRUE);
            f458a.getMethod("setSendPeriodMinutes", java.lang.Integer.TYPE).invoke(f458a, 1440);
            java.lang.Class<?> cls2 = java.lang.Class.forName("com.tencent.stat.StatReportStrategy");
            f458a.getMethod("setStatSendStrategy", cls2).invoke(f458a, cls2.getField("PERIOD").get(null));
            b.getMethod("startStatService", android.content.Context.class, java.lang.String.class, java.lang.String.class).invoke(b, context, str, java.lang.Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            g = true;
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
        }
    }

    public static void d(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        if (!android.text.TextUtils.isEmpty(qQToken.getOpenId())) {
            com.tencent.open.a.d.a().a(qQToken.getOpenId(), qQToken.getAppId(), "[REDACTED]", "[REDACTED]", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "[REDACTED]", "[REDACTED]", "[REDACTED]");
        }
        if (g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    c.invoke(b, context, qQToken.getOpenId());
                } catch (java.lang.Exception e2) {
                    com.tencent.open.log.SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                }
            }
        }
    }
}
