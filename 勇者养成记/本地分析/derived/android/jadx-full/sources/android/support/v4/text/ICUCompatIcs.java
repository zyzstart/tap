package android.support.v4.text;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(14)
class ICUCompatIcs {
    private static final java.lang.String TAG = "ICUCompatIcs";
    private static java.lang.reflect.Method sAddLikelySubtagsMethod;
    private static java.lang.reflect.Method sGetScriptMethod;

    static {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("libcore.icu.ICU");
            if (cls != null) {
                sGetScriptMethod = cls.getMethod("getScript", java.lang.String.class);
                sAddLikelySubtagsMethod = cls.getMethod("addLikelySubtags", java.lang.String.class);
            }
        } catch (java.lang.Exception e) {
            sGetScriptMethod = null;
            sAddLikelySubtagsMethod = null;
            android.util.Log.w(TAG, e);
        }
    }

    ICUCompatIcs() {
    }

    private static java.lang.String addLikelySubtags(java.util.Locale locale) {
        java.lang.String string = locale.toString();
        try {
            if (sAddLikelySubtagsMethod != null) {
                return (java.lang.String) sAddLikelySubtagsMethod.invoke(null, string);
            }
        } catch (java.lang.IllegalAccessException e) {
            android.util.Log.w(TAG, e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            android.util.Log.w(TAG, e2);
        }
        return string;
    }

    private static java.lang.String getScript(java.lang.String str) {
        try {
            if (sGetScriptMethod != null) {
                return (java.lang.String) sGetScriptMethod.invoke(null, str);
            }
        } catch (java.lang.IllegalAccessException e) {
            android.util.Log.w(TAG, e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            android.util.Log.w(TAG, e2);
        }
        return null;
    }

    public static java.lang.String maximizeAndGetScript(java.util.Locale locale) {
        java.lang.String strAddLikelySubtags = addLikelySubtags(locale);
        if (strAddLikelySubtags != null) {
            return getScript(strAddLikelySubtags);
        }
        return null;
    }
}
