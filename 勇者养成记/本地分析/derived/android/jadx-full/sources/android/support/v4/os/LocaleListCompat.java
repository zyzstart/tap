package android.support.v4.os;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class LocaleListCompat {
    static final android.support.v4.os.LocaleListInterface IMPL;
    private static final android.support.v4.os.LocaleListCompat sEmptyLocaleList = new android.support.v4.os.LocaleListCompat();

    @android.support.annotation.RequiresApi(24)
    static class LocaleListCompatApi24Impl implements android.support.v4.os.LocaleListInterface {
        private android.os.LocaleList mLocaleList = new android.os.LocaleList(new java.util.Locale[0]);

        LocaleListCompatApi24Impl() {
        }

        @Override // android.support.v4.os.LocaleListInterface
        public boolean equals(java.lang.Object obj) {
            return this.mLocaleList.equals(((android.support.v4.os.LocaleListCompat) obj).unwrap());
        }

        @Override // android.support.v4.os.LocaleListInterface
        public java.util.Locale get(int i) {
            return this.mLocaleList.get(i);
        }

        @Override // android.support.v4.os.LocaleListInterface
        @android.support.annotation.Nullable
        public java.util.Locale getFirstMatch(java.lang.String[] strArr) {
            android.os.LocaleList localeList = this.mLocaleList;
            if (localeList != null) {
                return localeList.getFirstMatch(strArr);
            }
            return null;
        }

        @Override // android.support.v4.os.LocaleListInterface
        public java.lang.Object getLocaleList() {
            return this.mLocaleList;
        }

        @Override // android.support.v4.os.LocaleListInterface
        public int hashCode() {
            return this.mLocaleList.hashCode();
        }

        @Override // android.support.v4.os.LocaleListInterface
        @android.support.annotation.IntRange(from = android.support.v4.media.session.PlaybackStateCompat.PLAYBACK_POSITION_UNKNOWN)
        public int indexOf(java.util.Locale locale) {
            return this.mLocaleList.indexOf(locale);
        }

        @Override // android.support.v4.os.LocaleListInterface
        public boolean isEmpty() {
            return this.mLocaleList.isEmpty();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public void setLocaleList(@android.support.annotation.NonNull java.util.Locale... localeArr) {
            this.mLocaleList = new android.os.LocaleList(localeArr);
        }

        @Override // android.support.v4.os.LocaleListInterface
        @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED)
        public int size() {
            return this.mLocaleList.size();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public java.lang.String toLanguageTags() {
            return this.mLocaleList.toLanguageTags();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public java.lang.String toString() {
            return this.mLocaleList.toString();
        }
    }

    static class LocaleListCompatBaseImpl implements android.support.v4.os.LocaleListInterface {
        private android.support.v4.os.LocaleListHelper mLocaleList = new android.support.v4.os.LocaleListHelper(new java.util.Locale[0]);

        LocaleListCompatBaseImpl() {
        }

        @Override // android.support.v4.os.LocaleListInterface
        public boolean equals(java.lang.Object obj) {
            return this.mLocaleList.equals(((android.support.v4.os.LocaleListCompat) obj).unwrap());
        }

        @Override // android.support.v4.os.LocaleListInterface
        public java.util.Locale get(int i) {
            return this.mLocaleList.get(i);
        }

        @Override // android.support.v4.os.LocaleListInterface
        @android.support.annotation.Nullable
        public java.util.Locale getFirstMatch(java.lang.String[] strArr) {
            android.support.v4.os.LocaleListHelper localeListHelper = this.mLocaleList;
            if (localeListHelper != null) {
                return localeListHelper.getFirstMatch(strArr);
            }
            return null;
        }

        @Override // android.support.v4.os.LocaleListInterface
        public java.lang.Object getLocaleList() {
            return this.mLocaleList;
        }

        @Override // android.support.v4.os.LocaleListInterface
        public int hashCode() {
            return this.mLocaleList.hashCode();
        }

        @Override // android.support.v4.os.LocaleListInterface
        @android.support.annotation.IntRange(from = android.support.v4.media.session.PlaybackStateCompat.PLAYBACK_POSITION_UNKNOWN)
        public int indexOf(java.util.Locale locale) {
            return this.mLocaleList.indexOf(locale);
        }

        @Override // android.support.v4.os.LocaleListInterface
        public boolean isEmpty() {
            return this.mLocaleList.isEmpty();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public void setLocaleList(@android.support.annotation.NonNull java.util.Locale... localeArr) {
            this.mLocaleList = new android.support.v4.os.LocaleListHelper(localeArr);
        }

        @Override // android.support.v4.os.LocaleListInterface
        @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED)
        public int size() {
            return this.mLocaleList.size();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public java.lang.String toLanguageTags() {
            return this.mLocaleList.toLanguageTags();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public java.lang.String toString() {
            return this.mLocaleList.toString();
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            IMPL = new android.support.v4.os.LocaleListCompat.LocaleListCompatApi24Impl();
        } else {
            IMPL = new android.support.v4.os.LocaleListCompat.LocaleListCompatBaseImpl();
        }
    }

    private LocaleListCompat() {
    }

    public static android.support.v4.os.LocaleListCompat create(@android.support.annotation.NonNull java.util.Locale... localeArr) {
        android.support.v4.os.LocaleListCompat localeListCompat = new android.support.v4.os.LocaleListCompat();
        localeListCompat.setLocaleListArray(localeArr);
        return localeListCompat;
    }

    @android.support.annotation.NonNull
    public static android.support.v4.os.LocaleListCompat forLanguageTags(@android.support.annotation.Nullable java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        java.lang.String[] strArrSplit = str.split(",");
        java.util.Locale[] localeArr = new java.util.Locale[strArrSplit.length];
        for (int i = 0; i < localeArr.length; i++) {
            localeArr[i] = android.os.Build.VERSION.SDK_INT >= 21 ? java.util.Locale.forLanguageTag(strArrSplit[i]) : android.support.v4.os.LocaleHelper.forLanguageTag(strArrSplit[i]);
        }
        android.support.v4.os.LocaleListCompat localeListCompat = new android.support.v4.os.LocaleListCompat();
        localeListCompat.setLocaleListArray(localeArr);
        return localeListCompat;
    }

    @android.support.annotation.Size(min = 1)
    @android.support.annotation.NonNull
    public static android.support.v4.os.LocaleListCompat getAdjustedDefault() {
        return android.os.Build.VERSION.SDK_INT >= 24 ? wrap(android.os.LocaleList.getAdjustedDefault()) : create(java.util.Locale.getDefault());
    }

    @android.support.annotation.Size(min = 1)
    @android.support.annotation.NonNull
    public static android.support.v4.os.LocaleListCompat getDefault() {
        return android.os.Build.VERSION.SDK_INT >= 24 ? wrap(android.os.LocaleList.getDefault()) : create(java.util.Locale.getDefault());
    }

    @android.support.annotation.NonNull
    public static android.support.v4.os.LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @android.support.annotation.RequiresApi(24)
    private void setLocaleList(android.os.LocaleList localeList) {
        int size = localeList.size();
        if (size > 0) {
            java.util.Locale[] localeArr = new java.util.Locale[size];
            for (int i = 0; i < size; i++) {
                localeArr[i] = localeList.get(i);
            }
            IMPL.setLocaleList(localeArr);
        }
    }

    private void setLocaleListArray(java.util.Locale... localeArr) {
        IMPL.setLocaleList(localeArr);
    }

    @android.support.annotation.RequiresApi(24)
    public static android.support.v4.os.LocaleListCompat wrap(java.lang.Object obj) {
        android.support.v4.os.LocaleListCompat localeListCompat = new android.support.v4.os.LocaleListCompat();
        if (obj instanceof android.os.LocaleList) {
            localeListCompat.setLocaleList((android.os.LocaleList) obj);
        }
        return localeListCompat;
    }

    public boolean equals(java.lang.Object obj) {
        return IMPL.equals(obj);
    }

    public java.util.Locale get(int i) {
        return IMPL.get(i);
    }

    public java.util.Locale getFirstMatch(java.lang.String[] strArr) {
        return IMPL.getFirstMatch(strArr);
    }

    public int hashCode() {
        return IMPL.hashCode();
    }

    @android.support.annotation.IntRange(from = android.support.v4.media.session.PlaybackStateCompat.PLAYBACK_POSITION_UNKNOWN)
    public int indexOf(java.util.Locale locale) {
        return IMPL.indexOf(locale);
    }

    public boolean isEmpty() {
        return IMPL.isEmpty();
    }

    @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED)
    public int size() {
        return IMPL.size();
    }

    @android.support.annotation.NonNull
    public java.lang.String toLanguageTags() {
        return IMPL.toLanguageTags();
    }

    public java.lang.String toString() {
        return IMPL.toString();
    }

    @android.support.annotation.Nullable
    public java.lang.Object unwrap() {
        return IMPL.getLocaleList();
    }
}
