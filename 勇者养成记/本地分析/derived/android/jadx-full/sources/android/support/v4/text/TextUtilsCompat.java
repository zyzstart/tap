package android.support.v4.text;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class TextUtilsCompat {
    private static final java.lang.String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final java.lang.String HEBR_SCRIPT_SUBTAG = "Hebr";

    @java.lang.Deprecated
    public static final java.util.Locale ROOT = new java.util.Locale("", "");

    private TextUtilsCompat() {
    }

    private static int getLayoutDirectionFromFirstChar(@android.support.annotation.NonNull java.util.Locale locale) {
        switch (java.lang.Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    public static int getLayoutDirectionFromLocale(@android.support.annotation.Nullable java.util.Locale locale) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return android.text.TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(ROOT)) {
            return 0;
        }
        java.lang.String strMaximizeAndGetScript = android.support.v4.text.ICUCompat.maximizeAndGetScript(locale);
        if (strMaximizeAndGetScript == null) {
            return getLayoutDirectionFromFirstChar(locale);
        }
        return (strMaximizeAndGetScript.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || strMaximizeAndGetScript.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) ? 1 : 0;
    }

    @android.support.annotation.NonNull
    public static java.lang.String htmlEncode(@android.support.annotation.NonNull java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return android.text.TextUtils.htmlEncode(str);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                sb.append("&quot;");
            } else if (cCharAt == '<') {
                sb.append("&lt;");
            } else if (cCharAt != '>') {
                switch (cCharAt) {
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '\'':
                        sb.append("&#39;");
                        break;
                    default:
                        sb.append(cCharAt);
                        break;
                }
            } else {
                sb.append("&gt;");
            }
        }
        return sb.toString();
    }
}
