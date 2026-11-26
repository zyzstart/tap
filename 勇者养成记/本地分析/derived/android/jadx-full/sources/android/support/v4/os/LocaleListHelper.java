package android.support.v4.os;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(14)
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
final class LocaleListHelper {
    private static final int NUM_PSEUDO_LOCALES = 2;
    private static final java.lang.String STRING_AR_XB = "ar-XB";
    private static final java.lang.String STRING_EN_XA = "en-XA";
    private final java.util.Locale[] mList;

    @android.support.annotation.NonNull
    private final java.lang.String mStringRepresentation;
    private static final java.util.Locale[] sEmptyList = new java.util.Locale[0];
    private static final android.support.v4.os.LocaleListHelper sEmptyLocaleList = new android.support.v4.os.LocaleListHelper(new java.util.Locale[0]);
    private static final java.util.Locale LOCALE_EN_XA = new java.util.Locale("en", "XA");
    private static final java.util.Locale LOCALE_AR_XB = new java.util.Locale("ar", "XB");
    private static final java.util.Locale EN_LATN = android.support.v4.os.LocaleHelper.forLanguageTag("en-Latn");
    private static final java.lang.Object sLock = new java.lang.Object();

    @android.support.annotation.GuardedBy("sLock")
    private static android.support.v4.os.LocaleListHelper sLastExplicitlySetLocaleList = null;

    @android.support.annotation.GuardedBy("sLock")
    private static android.support.v4.os.LocaleListHelper sDefaultLocaleList = null;

    @android.support.annotation.GuardedBy("sLock")
    private static android.support.v4.os.LocaleListHelper sDefaultAdjustedLocaleList = null;

    @android.support.annotation.GuardedBy("sLock")
    private static java.util.Locale sLastDefaultLocale = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    LocaleListHelper(@android.support.annotation.NonNull java.util.Locale locale, android.support.v4.os.LocaleListHelper localeListHelper) {
        if (locale == null) {
            throw new java.lang.NullPointerException("topLocale is null");
        }
        int length = localeListHelper == null ? 0 : localeListHelper.mList.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (locale.equals(localeListHelper.mList[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = (i == -1 ? 1 : 0) + length;
        java.util.Locale[] localeArr = new java.util.Locale[i2];
        localeArr[0] = (java.util.Locale) locale.clone();
        if (i == -1) {
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                localeArr[i4] = (java.util.Locale) localeListHelper.mList[i3].clone();
                i3 = i4;
            }
        } else {
            int i5 = 0;
            while (i5 < i) {
                int i6 = i5 + 1;
                localeArr[i6] = (java.util.Locale) localeListHelper.mList[i5].clone();
                i5 = i6;
            }
            for (int i7 = i + 1; i7 < length; i7++) {
                localeArr[i7] = (java.util.Locale) localeListHelper.mList[i7].clone();
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i8 = 0; i8 < i2; i8++) {
            sb.append(android.support.v4.os.LocaleHelper.toLanguageTag(localeArr[i8]));
            if (i8 < i2 - 1) {
                sb.append(',');
            }
        }
        this.mList = localeArr;
        this.mStringRepresentation = sb.toString();
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    LocaleListHelper(@android.support.annotation.NonNull java.util.Locale... localeArr) {
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            this.mStringRepresentation = "";
            return;
        }
        java.util.Locale[] localeArr2 = new java.util.Locale[localeArr.length];
        java.util.HashSet hashSet = new java.util.HashSet();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            java.util.Locale locale = localeArr[i];
            if (locale == null) {
                throw new java.lang.NullPointerException("list[" + i + "] is null");
            }
            if (hashSet.contains(locale)) {
                throw new java.lang.IllegalArgumentException("list[" + i + "] is a repetition");
            }
            java.util.Locale locale2 = (java.util.Locale) locale.clone();
            localeArr2[i] = locale2;
            sb.append(android.support.v4.os.LocaleHelper.toLanguageTag(locale2));
            if (i < localeArr.length - 1) {
                sb.append(',');
            }
            hashSet.add(locale2);
        }
        this.mList = localeArr2;
        this.mStringRepresentation = sb.toString();
    }

    private java.util.Locale computeFirstMatch(java.util.Collection<java.lang.String> collection, boolean z) {
        int iComputeFirstMatchIndex = computeFirstMatchIndex(collection, z);
        if (iComputeFirstMatchIndex == -1) {
            return null;
        }
        return this.mList[iComputeFirstMatchIndex];
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001e  */
    private int computeFirstMatchIndex(java.util.Collection<java.lang.String> collection, boolean z) {
        int iFindFirstMatchIndex;
        java.util.Locale[] localeArr = this.mList;
        if (localeArr.length == 1) {
            return 0;
        }
        if (localeArr.length == 0) {
            return -1;
        }
        if (z) {
            iFindFirstMatchIndex = findFirstMatchIndex(EN_LATN);
            if (iFindFirstMatchIndex == 0) {
                return 0;
            }
            if (iFindFirstMatchIndex >= Integer.MAX_VALUE) {
                iFindFirstMatchIndex = android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        } else {
            iFindFirstMatchIndex = android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        java.util.Iterator<java.lang.String> it = collection.iterator();
        while (it.hasNext()) {
            int iFindFirstMatchIndex2 = findFirstMatchIndex(android.support.v4.os.LocaleHelper.forLanguageTag(it.next()));
            if (iFindFirstMatchIndex2 == 0) {
                return 0;
            }
            if (iFindFirstMatchIndex2 < iFindFirstMatchIndex) {
                iFindFirstMatchIndex = iFindFirstMatchIndex2;
            }
        }
        if (iFindFirstMatchIndex == Integer.MAX_VALUE) {
            return 0;
        }
        return iFindFirstMatchIndex;
    }

    private int findFirstMatchIndex(java.util.Locale locale) {
        int i = 0;
        while (true) {
            java.util.Locale[] localeArr = this.mList;
            if (i >= localeArr.length) {
                return android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (matchScore(locale, localeArr[i]) > 0) {
                return i;
            }
            i++;
        }
    }

    @android.support.annotation.NonNull
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    static android.support.v4.os.LocaleListHelper forLanguageTags(@android.support.annotation.Nullable java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        java.lang.String[] strArrSplit = str.split(",");
        java.util.Locale[] localeArr = new java.util.Locale[strArrSplit.length];
        for (int i = 0; i < localeArr.length; i++) {
            localeArr[i] = android.support.v4.os.LocaleHelper.forLanguageTag(strArrSplit[i]);
        }
        return new android.support.v4.os.LocaleListHelper(localeArr);
    }

    @android.support.annotation.Size(min = 1)
    @android.support.annotation.NonNull
    static android.support.v4.os.LocaleListHelper getAdjustedDefault() {
        android.support.v4.os.LocaleListHelper localeListHelper;
        getDefault();
        synchronized (sLock) {
            localeListHelper = sDefaultAdjustedLocaleList;
        }
        return localeListHelper;
    }

    @android.support.annotation.Size(min = 1)
    @android.support.annotation.NonNull
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    static android.support.v4.os.LocaleListHelper getDefault() {
        java.util.Locale locale = java.util.Locale.getDefault();
        synchronized (sLock) {
            if (!locale.equals(sLastDefaultLocale)) {
                sLastDefaultLocale = locale;
                if (sDefaultLocaleList != null && locale.equals(sDefaultLocaleList.get(0))) {
                    return sDefaultLocaleList;
                }
                sDefaultLocaleList = new android.support.v4.os.LocaleListHelper(locale, sLastExplicitlySetLocaleList);
                sDefaultAdjustedLocaleList = sDefaultLocaleList;
            }
            return sDefaultLocaleList;
        }
    }

    @android.support.annotation.NonNull
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    static android.support.v4.os.LocaleListHelper getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    private static java.lang.String getLikelyScript(java.util.Locale locale) {
        if (android.os.Build.VERSION.SDK_INT < 21) {
            return "";
        }
        java.lang.String script = locale.getScript();
        return !script.isEmpty() ? script : "";
    }

    private static boolean isPseudoLocale(java.lang.String str) {
        return STRING_EN_XA.equals(str) || STRING_AR_XB.equals(str);
    }

    private static boolean isPseudoLocale(java.util.Locale locale) {
        return LOCALE_EN_XA.equals(locale) || LOCALE_AR_XB.equals(locale);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    static boolean isPseudoLocalesOnly(@android.support.annotation.Nullable java.lang.String[] strArr) {
        if (strArr == null) {
            return true;
        }
        if (strArr.length > 3) {
            return false;
        }
        for (java.lang.String str : strArr) {
            if (!str.isEmpty() && !isPseudoLocale(str)) {
                return false;
            }
        }
        return true;
    }

    @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 1)
    private static int matchScore(java.util.Locale locale, java.util.Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
            return 0;
        }
        java.lang.String likelyScript = getLikelyScript(locale);
        if (!likelyScript.isEmpty()) {
            return likelyScript.equals(getLikelyScript(locale2)) ? 1 : 0;
        }
        java.lang.String country = locale.getCountry();
        return (country.isEmpty() || country.equals(locale2.getCountry())) ? 1 : 0;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    static void setDefault(@android.support.annotation.Size(min = 1) @android.support.annotation.NonNull android.support.v4.os.LocaleListHelper localeListHelper) {
        setDefault(localeListHelper, 0);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    static void setDefault(@android.support.annotation.Size(min = 1) @android.support.annotation.NonNull android.support.v4.os.LocaleListHelper localeListHelper, int i) {
        if (localeListHelper == null) {
            throw new java.lang.NullPointerException("locales is null");
        }
        if (localeListHelper.isEmpty()) {
            throw new java.lang.IllegalArgumentException("locales is empty");
        }
        synchronized (sLock) {
            sLastDefaultLocale = localeListHelper.get(i);
            java.util.Locale.setDefault(sLastDefaultLocale);
            sLastExplicitlySetLocaleList = localeListHelper;
            sDefaultLocaleList = localeListHelper;
            if (i == 0) {
                sDefaultAdjustedLocaleList = sDefaultLocaleList;
            } else {
                sDefaultAdjustedLocaleList = new android.support.v4.os.LocaleListHelper(sLastDefaultLocale, sDefaultLocaleList);
            }
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof android.support.v4.os.LocaleListHelper)) {
            return false;
        }
        java.util.Locale[] localeArr = ((android.support.v4.os.LocaleListHelper) obj).mList;
        if (this.mList.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            java.util.Locale[] localeArr2 = this.mList;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    java.util.Locale get(int i) {
        if (i >= 0) {
            java.util.Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    @android.support.annotation.Nullable
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    java.util.Locale getFirstMatch(java.lang.String[] strArr) {
        return computeFirstMatch(java.util.Arrays.asList(strArr), false);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    int getFirstMatchIndex(java.lang.String[] strArr) {
        return computeFirstMatchIndex(java.util.Arrays.asList(strArr), false);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    int getFirstMatchIndexWithEnglishSupported(java.util.Collection<java.lang.String> collection) {
        return computeFirstMatchIndex(collection, true);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    int getFirstMatchIndexWithEnglishSupported(java.lang.String[] strArr) {
        return getFirstMatchIndexWithEnglishSupported(java.util.Arrays.asList(strArr));
    }

    @android.support.annotation.Nullable
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    java.util.Locale getFirstMatchWithEnglishSupported(java.lang.String[] strArr) {
        return computeFirstMatch(java.util.Arrays.asList(strArr), true);
    }

    public int hashCode() {
        int iHashCode = 1;
        int i = 0;
        while (true) {
            java.util.Locale[] localeArr = this.mList;
            if (i >= localeArr.length) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 31) + localeArr[i].hashCode();
            i++;
        }
    }

    @android.support.annotation.IntRange(from = android.support.v4.media.session.PlaybackStateCompat.PLAYBACK_POSITION_UNKNOWN)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    int indexOf(java.util.Locale locale) {
        int i = 0;
        while (true) {
            java.util.Locale[] localeArr = this.mList;
            if (i >= localeArr.length) {
                return -1;
            }
            if (localeArr[i].equals(locale)) {
                return i;
            }
            i++;
        }
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    boolean isEmpty() {
        return this.mList.length == 0;
    }

    @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    int size() {
        return this.mList.length;
    }

    @android.support.annotation.NonNull
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    java.lang.String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            java.util.Locale[] localeArr = this.mList;
            if (i >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i]);
            if (i < this.mList.length - 1) {
                sb.append(',');
            }
            i++;
        }
    }
}
