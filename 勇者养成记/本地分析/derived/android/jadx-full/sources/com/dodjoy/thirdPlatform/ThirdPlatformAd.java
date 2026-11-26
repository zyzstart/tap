package com.dodjoy.thirdPlatform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ThirdPlatformAd {
    private static java.lang.Class<?> mPlatformClass;
    private static java.lang.Object mPlatformSingleton;

    private static java.lang.Class<?> GetPlatformClass() {
        if (mPlatformClass == null) {
            try {
                mPlatformClass = java.lang.Class.forName("com.dodjoy.ad.DodADHelper");
            } catch (java.lang.ClassNotFoundException unused) {
            }
        }
        return mPlatformClass;
    }

    private static java.lang.Object GetPlatformSingleton() {
        if (mPlatformSingleton == null) {
            try {
                try {
                    mPlatformSingleton = GetPlatformClass().getDeclaredMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
                } catch (java.lang.IllegalAccessException e) {
                    e.printStackTrace();
                } catch (java.lang.reflect.InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            } catch (java.lang.NoSuchMethodException e3) {
                e3.printStackTrace();
            }
        }
        return mPlatformSingleton;
    }

    public static void init(android.app.Activity activity, java.lang.String str, android.os.Bundle bundle) {
        try {
            invokeMethod("init", new java.lang.Object[]{activity, str, bundle}, new java.lang.Class[]{android.app.Activity.class, java.lang.String.class, android.os.Bundle.class});
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static void invokeMethod(java.lang.String str, java.lang.Object[] objArr, java.lang.Class[] clsArr) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.lang.Class<?> clsGetPlatformClass = GetPlatformClass();
        if (clsGetPlatformClass != null) {
            clsGetPlatformClass.getDeclaredMethod(str, clsArr).invoke(GetPlatformSingleton(), objArr);
        }
    }

    public static void onActivityResult(int i, int i2, android.content.Intent intent) {
        try {
            invokeMethod("onActivityResult", new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), intent}, new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.Integer.TYPE, android.content.Intent.class});
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onBackPressed() {
        try {
            invokeMethod("onBackPressed", null, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onConfigurationChanged(android.content.res.Configuration configuration) {
        try {
            invokeMethod("onConfigurationChanged", new java.lang.Object[]{configuration}, new java.lang.Class[]{android.content.res.Configuration.class});
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onDestroy() {
        try {
            invokeMethod("onDestroy", null, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onNewIntent(android.content.Intent intent) {
        try {
            invokeMethod("onNewIntent", new java.lang.Object[]{intent}, new java.lang.Class[]{android.content.Intent.class});
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onPause() {
        try {
            invokeMethod("onPause", null, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        try {
            invokeMethod("onRequestPermissionsResult", new java.lang.Object[]{java.lang.Integer.valueOf(i), strArr, iArr}, new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.String[].class, int[].class});
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onRestart() {
        try {
            invokeMethod("onRestart", null, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onResume() {
        try {
            invokeMethod("onResume", null, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onSaveInstanceState(android.os.Bundle bundle) {
        try {
            invokeMethod("onSaveInstanceState", new java.lang.Object[]{bundle}, new java.lang.Class[]{android.os.Bundle.class});
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onStart() {
        try {
            invokeMethod("onStart", null, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void onStop() {
        try {
            invokeMethod("onStop", null, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
