package com.bun.miitmdid.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class MdidSdkHelper {
    public static java.lang.String TAG = "MdidSdkHelper";

    @android.support.annotation.Keep
    public static boolean _OuterIsOk = true;

    @android.support.annotation.Keep
    private java.lang.String sdk_date = "2020011018";

    @android.support.annotation.Keep
    public static int InitSdk(android.content.Context context, boolean z, com.bun.supplier.IIdentifierListener iIdentifierListener) {
        java.lang.String str;
        try {
            if (!_OuterIsOk) {
                if (iIdentifierListener == null) {
                    return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
                }
                iIdentifierListener.OnSupport(false, new com.bun.supplier.a());
                return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            java.lang.Class<?> cls = java.lang.Class.forName("com.bun.miitmdid.core.MdidSdk");
            if (cls == null) {
                str = "not found class:com.bun.miitmdid.core.MdidSdk";
            } else {
                java.lang.reflect.Constructor<?> constructor = cls.getConstructor(java.lang.Boolean.TYPE);
                if (constructor == null) {
                    str = "not found MdidSdk Constructor";
                } else {
                    java.lang.Object objNewInstance = constructor.newInstance(java.lang.Boolean.valueOf(z));
                    if (objNewInstance == null) {
                        str = "Create MdidSdk Instance failed";
                    } else {
                        java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("InitSdk", android.content.Context.class, com.bun.supplier.IIdentifierListener.class);
                        if (declaredMethod != null) {
                            int iIntValue = ((java.lang.Integer) declaredMethod.invoke(objNewInstance, context, iIdentifierListener)).intValue();
                            logd(z, "call and retvalue:" + iIntValue);
                            return iIntValue;
                        }
                        str = "not found MdidSdk InitSdk function";
                    }
                }
            }
            logd(z, str);
            return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            loge(z, e);
            logd(z, "exception exit");
            return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
        }
    }

    public static void logd(boolean z, java.lang.String str) {
        if (z) {
            android.util.Log.d(TAG, str);
        }
    }

    public static void loge(boolean z, java.lang.Exception exc) {
        if (z) {
            android.util.Log.e(TAG, exc.getClass().getSimpleName(), exc);
        }
    }
}
