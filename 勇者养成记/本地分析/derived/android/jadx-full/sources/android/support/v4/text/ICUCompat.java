package android.support.v4.text;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ICUCompat {
    private static final android.support.v4.text.ICUCompat.ICUCompatBaseImpl IMPL;

    @android.support.annotation.RequiresApi(21)
    static class ICUCompatApi21Impl extends android.support.v4.text.ICUCompat.ICUCompatBaseImpl {
        ICUCompatApi21Impl() {
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatBaseImpl
        public java.lang.String maximizeAndGetScript(java.util.Locale locale) {
            return android.support.v4.text.ICUCompatApi21.maximizeAndGetScript(locale);
        }
    }

    static class ICUCompatBaseImpl {
        ICUCompatBaseImpl() {
        }

        public java.lang.String maximizeAndGetScript(java.util.Locale locale) {
            return android.support.v4.text.ICUCompatIcs.maximizeAndGetScript(locale);
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.text.ICUCompat.ICUCompatApi21Impl();
        } else {
            IMPL = new android.support.v4.text.ICUCompat.ICUCompatBaseImpl();
        }
    }

    private ICUCompat() {
    }

    @android.support.annotation.Nullable
    public static java.lang.String maximizeAndGetScript(java.util.Locale locale) {
        return IMPL.maximizeAndGetScript(locale);
    }
}
