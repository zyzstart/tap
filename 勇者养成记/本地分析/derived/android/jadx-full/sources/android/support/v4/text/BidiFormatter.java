package android.support.v4.text;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final java.lang.String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = 8234;
    private static final char PDF = 8236;
    private static final char RLE = 8235;
    private final android.support.v4.text.TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;
    private static android.support.v4.text.TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = android.support.v4.text.TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final char LRM = 8206;
    private static final java.lang.String LRM_STRING = java.lang.Character.toString(LRM);
    private static final char RLM = 8207;
    private static final java.lang.String RLM_STRING = java.lang.Character.toString(RLM);
    private static final android.support.v4.text.BidiFormatter DEFAULT_LTR_INSTANCE = new android.support.v4.text.BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    private static final android.support.v4.text.BidiFormatter DEFAULT_RTL_INSTANCE = new android.support.v4.text.BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);

    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private android.support.v4.text.TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(android.support.v4.text.BidiFormatter.isRtlLocale(java.util.Locale.getDefault()));
        }

        public Builder(java.util.Locale locale) {
            initialize(android.support.v4.text.BidiFormatter.isRtlLocale(locale));
        }

        public Builder(boolean z) {
            initialize(z);
        }

        private static android.support.v4.text.BidiFormatter getDefaultInstanceFromContext(boolean z) {
            return z ? android.support.v4.text.BidiFormatter.DEFAULT_RTL_INSTANCE : android.support.v4.text.BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean z) {
            this.mIsRtlContext = z;
            this.mTextDirectionHeuristicCompat = android.support.v4.text.BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public android.support.v4.text.BidiFormatter build() {
            return (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == android.support.v4.text.BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) ? getDefaultInstanceFromContext(this.mIsRtlContext) : new android.support.v4.text.BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public android.support.v4.text.BidiFormatter.Builder setTextDirectionHeuristic(android.support.v4.text.TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        public android.support.v4.text.BidiFormatter.Builder stereoReset(boolean z) {
            if (z) {
                this.mFlags |= 2;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }
    }

    private static class DirectionalityEstimator {
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final java.lang.CharSequence text;
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private static final byte[] DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];

        static {
            for (int i = 0; i < DIR_TYPE_CACHE_SIZE; i++) {
                DIR_TYPE_CACHE[i] = java.lang.Character.getDirectionality(i);
            }
        }

        DirectionalityEstimator(java.lang.CharSequence charSequence, boolean z) {
            this.text = charSequence;
            this.isHtml = z;
            this.length = charSequence.length();
        }

        private static byte getCachedDirectionality(char c) {
            return c < DIR_TYPE_CACHE_SIZE ? DIR_TYPE_CACHE[c] : java.lang.Character.getDirectionality(c);
        }

        private byte skipEntityBackward() {
            char c;
            int i = this.charIndex;
            do {
                int i2 = this.charIndex;
                if (i2 <= 0) {
                    break;
                }
                java.lang.CharSequence charSequence = this.text;
                int i3 = i2 - 1;
                this.charIndex = i3;
                this.lastChar = charSequence.charAt(i3);
                c = this.lastChar;
                if (c == '&') {
                    return (byte) 12;
                }
            } while (c != ';');
            this.charIndex = i;
            this.lastChar = ';';
            return (byte) 13;
        }

        private byte skipEntityForward() {
            char cCharAt;
            do {
                int i = this.charIndex;
                if (i >= this.length) {
                    return (byte) 12;
                }
                java.lang.CharSequence charSequence = this.text;
                this.charIndex = i + 1;
                cCharAt = charSequence.charAt(i);
                this.lastChar = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        private byte skipTagBackward() {
            char cCharAt;
            int i = this.charIndex;
            while (true) {
                int i2 = this.charIndex;
                if (i2 <= 0) {
                    break;
                }
                java.lang.CharSequence charSequence = this.text;
                int i3 = i2 - 1;
                this.charIndex = i3;
                this.lastChar = charSequence.charAt(i3);
                char c = this.lastChar;
                if (c == '<') {
                    return (byte) 12;
                }
                if (c == '>') {
                    break;
                }
                if (c == '\"' || c == '\'') {
                    char c2 = this.lastChar;
                    do {
                        int i4 = this.charIndex;
                        if (i4 <= 0) {
                            break;
                        }
                        java.lang.CharSequence charSequence2 = this.text;
                        int i5 = i4 - 1;
                        this.charIndex = i5;
                        cCharAt = charSequence2.charAt(i5);
                        this.lastChar = cCharAt;
                    } while (cCharAt != c2);
                }
            }
            this.charIndex = i;
            this.lastChar = '>';
            return (byte) 13;
        }

        private byte skipTagForward() {
            char cCharAt;
            int i = this.charIndex;
            while (true) {
                int i2 = this.charIndex;
                if (i2 >= this.length) {
                    this.charIndex = i;
                    this.lastChar = '<';
                    return (byte) 13;
                }
                java.lang.CharSequence charSequence = this.text;
                this.charIndex = i2 + 1;
                this.lastChar = charSequence.charAt(i2);
                char c = this.lastChar;
                if (c == '>') {
                    return (byte) 12;
                }
                if (c == '\"' || c == '\'') {
                    char c2 = this.lastChar;
                    do {
                        int i3 = this.charIndex;
                        if (i3 >= this.length) {
                            break;
                        }
                        java.lang.CharSequence charSequence2 = this.text;
                        this.charIndex = i3 + 1;
                        cCharAt = charSequence2.charAt(i3);
                        this.lastChar = cCharAt;
                    } while (cCharAt != c2);
                }
            }
        }

        byte dirTypeBackward() {
            this.lastChar = this.text.charAt(this.charIndex - 1);
            if (java.lang.Character.isLowSurrogate(this.lastChar)) {
                int iCodePointBefore = java.lang.Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= java.lang.Character.charCount(iCodePointBefore);
                return java.lang.Character.getDirectionality(iCodePointBefore);
            }
            this.charIndex--;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (!this.isHtml) {
                return cachedDirectionality;
            }
            char c = this.lastChar;
            if (c == '>') {
                return skipTagBackward();
            }
            return c == ';' ? skipEntityBackward() : cachedDirectionality;
        }

        byte dirTypeForward() {
            this.lastChar = this.text.charAt(this.charIndex);
            if (java.lang.Character.isHighSurrogate(this.lastChar)) {
                int iCodePointAt = java.lang.Character.codePointAt(this.text, this.charIndex);
                this.charIndex += java.lang.Character.charCount(iCodePointAt);
                return java.lang.Character.getDirectionality(iCodePointAt);
            }
            this.charIndex++;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (!this.isHtml) {
                return cachedDirectionality;
            }
            char c = this.lastChar;
            if (c == '<') {
                return skipTagForward();
            }
            return c == '&' ? skipEntityForward() : cachedDirectionality;
        }

        int getEntryDir() {
            this.charIndex = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.charIndex < this.length && i == 0) {
                byte bDirTypeForward = dirTypeForward();
                if (bDirTypeForward != 9) {
                    switch (bDirTypeForward) {
                        case 0:
                            if (i3 == 0) {
                                return -1;
                            }
                            i = i3;
                            break;
                        case 1:
                        case 2:
                            if (i3 == 0) {
                                return 1;
                            }
                            i = i3;
                            break;
                        default:
                            switch (bDirTypeForward) {
                                case 14:
                                case 15:
                                    i3++;
                                    i2 = -1;
                                    continue;
                                case 16:
                                case 17:
                                    i3++;
                                    i2 = 1;
                                    continue;
                                case 18:
                                    i3--;
                                    i2 = 0;
                                    continue;
                            }
                            i = i3;
                            break;
                    }
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        i3--;
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        i3--;
                        break;
                    case 18:
                        i3++;
                        break;
                }
            }
            return 0;
        }

        int getExitDir() {
            this.charIndex = this.length;
            int i = 0;
            int i2 = 0;
            while (this.charIndex > 0) {
                byte bDirTypeBackward = dirTypeBackward();
                if (bDirTypeBackward != 9) {
                    switch (bDirTypeBackward) {
                        case 0:
                            if (i2 == 0) {
                                return -1;
                            }
                            if (i == 0) {
                                i = i2;
                            }
                            break;
                        case 1:
                        case 2:
                            if (i2 == 0) {
                                return 1;
                            }
                            if (i == 0) {
                                i = i2;
                            }
                            break;
                        default:
                            switch (bDirTypeBackward) {
                                case 14:
                                case 15:
                                    if (i == i2) {
                                        return -1;
                                    }
                                    i2--;
                                    continue;
                                    break;
                                case 16:
                                case 17:
                                    if (i == i2) {
                                        return 1;
                                    }
                                    i2--;
                                    continue;
                                    break;
                                case 18:
                                    i2++;
                                    continue;
                                default:
                                    if (i != 0) {
                                    }
                                    break;
                            }
                            i = i2;
                            break;
                    }
                }
            }
            return 0;
        }
    }

    private BidiFormatter(boolean z, int i, android.support.v4.text.TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z;
        this.mFlags = i;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    private static int getEntryDir(java.lang.CharSequence charSequence) {
        return new android.support.v4.text.BidiFormatter.DirectionalityEstimator(charSequence, false).getEntryDir();
    }

    private static int getExitDir(java.lang.CharSequence charSequence) {
        return new android.support.v4.text.BidiFormatter.DirectionalityEstimator(charSequence, false).getExitDir();
    }

    public static android.support.v4.text.BidiFormatter getInstance() {
        return new android.support.v4.text.BidiFormatter.Builder().build();
    }

    public static android.support.v4.text.BidiFormatter getInstance(java.util.Locale locale) {
        return new android.support.v4.text.BidiFormatter.Builder(locale).build();
    }

    public static android.support.v4.text.BidiFormatter getInstance(boolean z) {
        return new android.support.v4.text.BidiFormatter.Builder(z).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRtlLocale(java.util.Locale locale) {
        return android.support.v4.text.TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private java.lang.String markAfter(java.lang.CharSequence charSequence, android.support.v4.text.TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean zIsRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (zIsRtl || getExitDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (this.mIsRtlContext) {
            return (!zIsRtl || getExitDir(charSequence) == -1) ? RLM_STRING : "";
        }
        return "";
    }

    private java.lang.String markBefore(java.lang.CharSequence charSequence, android.support.v4.text.TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean zIsRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (zIsRtl || getEntryDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (this.mIsRtlContext) {
            return (!zIsRtl || getEntryDir(charSequence) == -1) ? RLM_STRING : "";
        }
        return "";
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    public boolean isRtl(java.lang.CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    public boolean isRtl(java.lang.String str) {
        return isRtl((java.lang.CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public java.lang.CharSequence unicodeWrap(java.lang.CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public java.lang.CharSequence unicodeWrap(java.lang.CharSequence charSequence, android.support.v4.text.TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public java.lang.CharSequence unicodeWrap(java.lang.CharSequence charSequence, android.support.v4.text.TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zIsRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        if (getStereoReset() && z) {
            spannableStringBuilder.append((java.lang.CharSequence) markBefore(charSequence, zIsRtl ? android.support.v4.text.TextDirectionHeuristicsCompat.RTL : android.support.v4.text.TextDirectionHeuristicsCompat.LTR));
        }
        if (zIsRtl != this.mIsRtlContext) {
            spannableStringBuilder.append(zIsRtl ? RLE : LRE);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(PDF);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((java.lang.CharSequence) markAfter(charSequence, zIsRtl ? android.support.v4.text.TextDirectionHeuristicsCompat.RTL : android.support.v4.text.TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public java.lang.CharSequence unicodeWrap(java.lang.CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z);
    }

    public java.lang.String unicodeWrap(java.lang.String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public java.lang.String unicodeWrap(java.lang.String str, android.support.v4.text.TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public java.lang.String unicodeWrap(java.lang.String str, android.support.v4.text.TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((java.lang.CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    public java.lang.String unicodeWrap(java.lang.String str, boolean z) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z);
    }
}
