package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k {
    public static java.lang.Object a(java.lang.Class cls, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        try {
            java.lang.reflect.Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.addLog(com.tencent.smtt.utils.TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, java.lang.String.valueOf(th), new java.lang.Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str) {
        return a(obj, str, (java.lang.Class[]) null, new java.lang.Object[0]);
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            java.lang.Class<?> cls = obj.getClass();
            java.lang.reflect.Method method = android.os.Build.VERSION.SDK_INT > 10 ? cls.getMethod(str, clsArr) : cls.getDeclaredMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.addLog(com.tencent.smtt.utils.TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, java.lang.String.valueOf(th), new java.lang.Object[0]);
            if (th.getCause() != null && th.getCause().toString().contains("AuthenticationFail")) {
                return new java.lang.String("AuthenticationFail");
            }
            if (str != null && (str.equalsIgnoreCase("canLoadX5Core") || str.equalsIgnoreCase("initTesRuntimeEnvironment"))) {
                return null;
            }
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            th.printStackTrace(new java.io.PrintWriter(stringWriter));
            android.util.Log.e("ReflectionUtils", "invokeInstance -- exceptions:" + stringWriter.toString());
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2) {
        try {
            return java.lang.Class.forName(str).getMethod(str2, new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.addLog(com.tencent.smtt.utils.TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, java.lang.String.valueOf(th), new java.lang.Object[0]);
            return null;
        }
    }

    public static java.lang.reflect.Method a(java.lang.Object obj, java.lang.String str, java.lang.Class... clsArr) {
        for (java.lang.Class<?> superclass = obj.getClass(); superclass != java.lang.Object.class && superclass != null; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredMethod(str, clsArr);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }
}
