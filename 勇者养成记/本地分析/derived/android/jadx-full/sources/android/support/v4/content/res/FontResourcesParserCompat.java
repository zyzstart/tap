package android.support.v4.content.res;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    public interface FamilyResourceEntry {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry {

        @android.support.annotation.NonNull
        private final android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(@android.support.annotation.NonNull android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.mEntries = fontFileResourceEntryArr;
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    public static final class FontFileResourceEntry {

        @android.support.annotation.NonNull
        private final java.lang.String mFileName;
        private boolean mItalic;
        private int mResourceId;
        private int mWeight;

        public FontFileResourceEntry(@android.support.annotation.NonNull java.lang.String str, int i, boolean z, int i2) {
            this.mFileName = str;
            this.mWeight = i;
            this.mItalic = z;
            this.mResourceId = i2;
        }

        @android.support.annotation.NonNull
        public java.lang.String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static final class ProviderResourceEntry implements android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry {

        @android.support.annotation.NonNull
        private final android.support.v4.provider.FontRequest mRequest;
        private final int mStrategy;
        private final int mTimeoutMs;

        public ProviderResourceEntry(@android.support.annotation.NonNull android.support.v4.provider.FontRequest fontRequest, int i, int i2) {
            this.mRequest = fontRequest;
            this.mStrategy = i;
            this.mTimeoutMs = i2;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        @android.support.annotation.NonNull
        public android.support.v4.provider.FontRequest getRequest() {
            return this.mRequest;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.support.annotation.Nullable
    public static android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry parse(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return readFamilies(xmlPullParser, resources);
        }
        throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
    }

    public static java.util.List<java.util.List<byte[]>> readCerts(android.content.res.Resources resources, @android.support.annotation.ArrayRes int i) {
        java.util.ArrayList arrayList = null;
        if (i != 0) {
            android.content.res.TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
            if (typedArrayObtainTypedArray.length() > 0) {
                arrayList = new java.util.ArrayList();
                if (typedArrayObtainTypedArray.getResourceId(0, 0) != 0) {
                    for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                        arrayList.add(toByteArrayList(resources.getStringArray(typedArrayObtainTypedArray.getResourceId(i2, 0))));
                    }
                } else {
                    arrayList.add(toByteArrayList(resources.getStringArray(i)));
                }
            }
            typedArrayObtainTypedArray.recycle();
        }
        return arrayList != null ? arrayList : java.util.Collections.emptyList();
    }

    @android.support.annotation.Nullable
    private static android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry readFamilies(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return readFamily(xmlPullParser, resources);
        }
        skip(xmlPullParser);
        return null;
    }

    @android.support.annotation.Nullable
    private static android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry readFamily(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.content.res.TypedArray typedArrayObtainAttributes = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlPullParser), android.support.compat.R.styleable.FontFamily);
        java.lang.String string = typedArrayObtainAttributes.getString(android.support.compat.R.styleable.FontFamily_fontProviderAuthority);
        java.lang.String string2 = typedArrayObtainAttributes.getString(android.support.compat.R.styleable.FontFamily_fontProviderPackage);
        java.lang.String string3 = typedArrayObtainAttributes.getString(android.support.compat.R.styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(android.support.compat.R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(android.support.compat.R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(android.support.compat.R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                skip(xmlPullParser);
            }
            return new android.support.v4.content.res.FontResourcesParserCompat.ProviderResourceEntry(new android.support.v4.provider.FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(readFont(xmlPullParser, resources));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry((android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry[]) arrayList.toArray(new android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry[arrayList.size()]));
    }

    private static android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry readFont(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.content.res.TypedArray typedArrayObtainAttributes = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlPullParser), android.support.compat.R.styleable.FontFamilyFont);
        int i = typedArrayObtainAttributes.getInt(android.support.compat.R.styleable.FontFamilyFont_fontWeight, 400);
        boolean z = 1 == typedArrayObtainAttributes.getInt(android.support.compat.R.styleable.FontFamilyFont_fontStyle, 0);
        int resourceId = typedArrayObtainAttributes.getResourceId(android.support.compat.R.styleable.FontFamilyFont_font, 0);
        java.lang.String string = typedArrayObtainAttributes.getString(android.support.compat.R.styleable.FontFamilyFont_font);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            skip(xmlPullParser);
        }
        return new android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry(string, i, z, resourceId);
    }

    private static void skip(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }

    private static java.util.List<byte[]> toByteArrayList(java.lang.String[] strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : strArr) {
            arrayList.add(android.util.Base64.decode(str, 0));
        }
        return arrayList;
    }
}
