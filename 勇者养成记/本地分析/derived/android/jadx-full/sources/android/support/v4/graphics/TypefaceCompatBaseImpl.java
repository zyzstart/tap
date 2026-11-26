package android.support.v4.graphics;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(14)
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class TypefaceCompatBaseImpl implements android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl {
    private static final java.lang.String CACHE_FILE_PREFIX = "cached_font_";
    private static final java.lang.String TAG = "TypefaceCompatBaseImpl";

    private interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    TypefaceCompatBaseImpl() {
    }

    private android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry findBestEntry(android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        return (android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i, new android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor<android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry>() { // from class: android.support.v4.graphics.TypefaceCompatBaseImpl.2
            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public int getWeight(android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.getWeight();
            }

            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public boolean isItalic(android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.isItalic();
            }
        });
    }

    private static <T> T findBestFont(T[] tArr, int i, android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor<T> styleExtractor) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (T t2 : tArr) {
            int iAbs = (java.lang.Math.abs(styleExtractor.getWeight(t2) - i2) * 2) + (styleExtractor.isItalic(t2) == z ? 0 : 1);
            if (t == null || i3 > iAbs) {
                t = t2;
                i3 = iAbs;
            }
        }
        return t;
    }

    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    @android.support.annotation.Nullable
    public android.graphics.Typeface createFromFontFamilyFilesResourceEntry(android.content.Context context, android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, android.content.res.Resources resources, int i) {
        android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntryFindBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i);
        if (fontFileResourceEntryFindBestEntry == null) {
            return null;
        }
        return android.support.v4.graphics.TypefaceCompat.createFromResourcesFontFile(context, resources, fontFileResourceEntryFindBestEntry.getResourceId(), fontFileResourceEntryFindBestEntry.getFileName(), i);
    }

    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    public android.graphics.Typeface createFromFontInfo(android.content.Context context, @android.support.annotation.Nullable android.os.CancellationSignal cancellationSignal, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i) throws java.lang.Throwable {
        java.io.InputStream inputStreamOpenInputStream;
        java.io.InputStream inputStream = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(findBestInfo(fontInfoArr, i).getUri());
            try {
                android.graphics.Typeface typefaceCreateFromInputStream = createFromInputStream(context, inputStreamOpenInputStream);
                android.support.v4.graphics.TypefaceCompatUtil.closeQuietly(inputStreamOpenInputStream);
                return typefaceCreateFromInputStream;
            } catch (java.io.IOException unused) {
                android.support.v4.graphics.TypefaceCompatUtil.closeQuietly(inputStreamOpenInputStream);
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                android.support.v4.graphics.TypefaceCompatUtil.closeQuietly(inputStream);
                throw th;
            }
        } catch (java.io.IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    protected android.graphics.Typeface createFromInputStream(android.content.Context context, java.io.InputStream inputStream) {
        java.io.File tempFile = android.support.v4.graphics.TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (android.support.v4.graphics.TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                return android.graphics.Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (java.lang.RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    @android.support.annotation.Nullable
    public android.graphics.Typeface createFromResourcesFontFile(android.content.Context context, android.content.res.Resources resources, int i, java.lang.String str, int i2) {
        java.io.File tempFile = android.support.v4.graphics.TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (android.support.v4.graphics.TypefaceCompatUtil.copyToFile(tempFile, resources, i)) {
                return android.graphics.Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (java.lang.RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    protected android.support.v4.provider.FontsContractCompat.FontInfo findBestInfo(android.support.v4.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return (android.support.v4.provider.FontsContractCompat.FontInfo) findBestFont(fontInfoArr, i, new android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor<android.support.v4.provider.FontsContractCompat.FontInfo>() { // from class: android.support.v4.graphics.TypefaceCompatBaseImpl.1
            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public int getWeight(android.support.v4.provider.FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.getWeight();
            }

            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public boolean isItalic(android.support.v4.provider.FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.isItalic();
            }
        });
    }
}
