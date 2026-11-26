package android.support.v4.os;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class EnvironmentCompat {
    public static final java.lang.String MEDIA_UNKNOWN = "unknown";
    private static final java.lang.String TAG = "EnvironmentCompat";

    private EnvironmentCompat() {
    }

    public static java.lang.String getStorageState(java.io.File file) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return android.os.Environment.getStorageState(file);
        }
        try {
            return file.getCanonicalPath().startsWith(android.os.Environment.getExternalStorageDirectory().getCanonicalPath()) ? android.os.Environment.getExternalStorageState() : MEDIA_UNKNOWN;
        } catch (java.io.IOException e) {
            android.util.Log.w(TAG, "Failed to resolve canonical path: " + e);
            return MEDIA_UNKNOWN;
        }
    }
}
