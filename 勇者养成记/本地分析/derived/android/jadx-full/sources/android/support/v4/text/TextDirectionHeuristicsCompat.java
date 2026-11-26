package android.support.v4.text;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class TextDirectionHeuristicsCompat {
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;
    public static final android.support.v4.text.TextDirectionHeuristicCompat LTR = new android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(null, false);
    public static final android.support.v4.text.TextDirectionHeuristicCompat RTL = new android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(null, true);
    public static final android.support.v4.text.TextDirectionHeuristicCompat FIRSTSTRONG_LTR = new android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(android.support.v4.text.TextDirectionHeuristicsCompat.FirstStrong.INSTANCE, false);
    public static final android.support.v4.text.TextDirectionHeuristicCompat FIRSTSTRONG_RTL = new android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(android.support.v4.text.TextDirectionHeuristicsCompat.FirstStrong.INSTANCE, true);
    public static final android.support.v4.text.TextDirectionHeuristicCompat ANYRTL_LTR = new android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(android.support.v4.text.TextDirectionHeuristicsCompat.AnyStrong.INSTANCE_RTL, false);
    public static final android.support.v4.text.TextDirectionHeuristicCompat LOCALE = android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale.INSTANCE;

    private static class AnyStrong implements android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
        private final boolean mLookForRtl;
        public static final android.support.v4.text.TextDirectionHeuristicsCompat.AnyStrong INSTANCE_RTL = new android.support.v4.text.TextDirectionHeuristicsCompat.AnyStrong(true);
        public static final android.support.v4.text.TextDirectionHeuristicsCompat.AnyStrong INSTANCE_LTR = new android.support.v4.text.TextDirectionHeuristicsCompat.AnyStrong(false);

        private AnyStrong(boolean z) {
            this.mLookForRtl = z;
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(java.lang.CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                switch (android.support.v4.text.TextDirectionHeuristicsCompat.isRtlText(java.lang.Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (this.mLookForRtl) {
                            return 0;
                        }
                        z = true;
                        break;
                    case 1:
                        if (!this.mLookForRtl) {
                            return 1;
                        }
                        z = true;
                        break;
                        break;
                }
                i++;
            }
            if (z) {
                return this.mLookForRtl ? 1 : 0;
            }
            return 2;
        }
    }

    private static class FirstStrong implements android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
        public static final android.support.v4.text.TextDirectionHeuristicsCompat.FirstStrong INSTANCE = new android.support.v4.text.TextDirectionHeuristicsCompat.FirstStrong();

        private FirstStrong() {
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(java.lang.CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int iIsRtlTextOrFormat = 2;
            while (i < i3 && iIsRtlTextOrFormat == 2) {
                iIsRtlTextOrFormat = android.support.v4.text.TextDirectionHeuristicsCompat.isRtlTextOrFormat(java.lang.Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return iIsRtlTextOrFormat;
        }
    }

    private interface TextDirectionAlgorithm {
        int checkRtl(java.lang.CharSequence charSequence, int i, int i2);
    }

    private static abstract class TextDirectionHeuristicImpl implements android.support.v4.text.TextDirectionHeuristicCompat {
        private final android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm textDirectionAlgorithm) {
            this.mAlgorithm = textDirectionAlgorithm;
        }

        private boolean doCheck(java.lang.CharSequence charSequence, int i, int i2) {
            switch (this.mAlgorithm.checkRtl(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return defaultIsRtl();
            }
        }

        protected abstract boolean defaultIsRtl();

        @Override // android.support.v4.text.TextDirectionHeuristicCompat
        public boolean isRtl(java.lang.CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new java.lang.IllegalArgumentException();
            }
            return this.mAlgorithm == null ? defaultIsRtl() : doCheck(charSequence, i, i2);
        }

        @Override // android.support.v4.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] cArr, int i, int i2) {
            return isRtl(java.nio.CharBuffer.wrap(cArr), i, i2);
        }
    }

    private static class TextDirectionHeuristicInternal extends android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        TextDirectionHeuristicInternal(android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.mDefaultIsRtl = z;
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    private static class TextDirectionHeuristicLocale extends android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
        public static final android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale INSTANCE = new android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale();

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean defaultIsRtl() {
            return android.support.v4.text.TextUtilsCompat.getLayoutDirectionFromLocale(java.util.Locale.getDefault()) == 1;
        }
    }

    private TextDirectionHeuristicsCompat() {
    }

    static int isRtlText(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    static int isRtlTextOrFormat(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                switch (i) {
                    case 14:
                    case 15:
                        return 1;
                    case 16:
                    case 17:
                        return 0;
                    default:
                        return 2;
                }
        }
    }
}
