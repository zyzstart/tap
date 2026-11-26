package android.support.v4.text;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(21)
class ICUCompatApi21 {
    private static final java.lang.String TAG = "ICUCompatApi21";
    private static java.lang.reflect.Method sAddLikelySubtagsMethod;

    static {
        try {
            sAddLikelySubtagsMethod = java.lang.Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", java.util.Locale.class);
        } catch (java.lang.Exception e) {
            throw new java.lang.IllegalStateException(e);
        }
    }

    ICUCompatApi21() {
    }

    public static java.lang.String maximizeAndGetScript(java.util.Locale locale) {
        try {
            return ((java.util.Locale) sAddLikelySubtagsMethod.invoke(null, locale)).getScript();
        } catch (java.lang.IllegalAccessException e) {
            android.util.Log.w(TAG, e);
            return locale.getScript();
        } catch (java.lang.reflect.InvocationTargetException e2) {
            android.util.Log.w(TAG, e2);
            return locale.getScript();
        }
    }
}
