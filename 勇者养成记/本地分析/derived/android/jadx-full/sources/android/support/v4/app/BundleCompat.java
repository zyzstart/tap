package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class BundleCompat {

    static class BundleCompatBaseImpl {
        private static final java.lang.String TAG = "BundleCompatBaseImpl";
        private static java.lang.reflect.Method sGetIBinderMethod;
        private static boolean sGetIBinderMethodFetched;
        private static java.lang.reflect.Method sPutIBinderMethod;
        private static boolean sPutIBinderMethodFetched;

        BundleCompatBaseImpl() {
        }

        public static android.os.IBinder getBinder(android.os.Bundle bundle, java.lang.String str) {
            if (!sGetIBinderMethodFetched) {
                try {
                    sGetIBinderMethod = android.os.Bundle.class.getMethod("getIBinder", java.lang.String.class);
                    sGetIBinderMethod.setAccessible(true);
                } catch (java.lang.NoSuchMethodException e) {
                    android.util.Log.i(TAG, "Failed to retrieve getIBinder method", e);
                }
                sGetIBinderMethodFetched = true;
            }
            java.lang.reflect.Method method = sGetIBinderMethod;
            if (method != null) {
                try {
                    return (android.os.IBinder) method.invoke(bundle, str);
                } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException e2) {
                    android.util.Log.i(TAG, "Failed to invoke getIBinder via reflection", e2);
                    sGetIBinderMethod = null;
                }
            }
            return null;
        }

        public static void putBinder(android.os.Bundle bundle, java.lang.String str, android.os.IBinder iBinder) {
            if (!sPutIBinderMethodFetched) {
                try {
                    sPutIBinderMethod = android.os.Bundle.class.getMethod("putIBinder", java.lang.String.class, android.os.IBinder.class);
                    sPutIBinderMethod.setAccessible(true);
                } catch (java.lang.NoSuchMethodException e) {
                    android.util.Log.i(TAG, "Failed to retrieve putIBinder method", e);
                }
                sPutIBinderMethodFetched = true;
            }
            java.lang.reflect.Method method = sPutIBinderMethod;
            if (method != null) {
                try {
                    method.invoke(bundle, str, iBinder);
                } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException e2) {
                    android.util.Log.i(TAG, "Failed to invoke putIBinder via reflection", e2);
                    sPutIBinderMethod = null;
                }
            }
        }
    }

    private BundleCompat() {
    }

    public static android.os.IBinder getBinder(android.os.Bundle bundle, java.lang.String str) {
        return android.os.Build.VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : android.support.v4.app.BundleCompat.BundleCompatBaseImpl.getBinder(bundle, str);
    }

    public static void putBinder(android.os.Bundle bundle, java.lang.String str, android.os.IBinder iBinder) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            android.support.v4.app.BundleCompat.BundleCompatBaseImpl.putBinder(bundle, str, iBinder);
        }
    }
}
