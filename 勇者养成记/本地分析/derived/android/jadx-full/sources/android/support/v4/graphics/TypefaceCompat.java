package android.support.v4.graphics;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompat {
    private static final java.lang.String TAG = "TypefaceCompat";
    private static final android.support.v4.util.LruCache<java.lang.String, android.graphics.Typeface> sTypefaceCache;
    private static final android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl sTypefaceCompatImpl;

    interface TypefaceCompatImpl {
        android.graphics.Typeface createFromFontFamilyFilesResourceEntry(android.content.Context context, android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, android.content.res.Resources resources, int i);

        android.graphics.Typeface createFromFontInfo(android.content.Context context, @android.support.annotation.Nullable android.os.CancellationSignal cancellationSignal, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i);

        android.graphics.Typeface createFromResourcesFontFile(android.content.Context context, android.content.res.Resources resources, int i, java.lang.String str, int i2);
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            sTypefaceCompatImpl = new android.support.v4.graphics.TypefaceCompatApi26Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 24 && android.support.v4.graphics.TypefaceCompatApi24Impl.isUsable()) {
            sTypefaceCompatImpl = new android.support.v4.graphics.TypefaceCompatApi24Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            sTypefaceCompatImpl = new android.support.v4.graphics.TypefaceCompatApi21Impl();
        } else {
            sTypefaceCompatImpl = new android.support.v4.graphics.TypefaceCompatBaseImpl();
        }
        sTypefaceCache = new android.support.v4.util.LruCache<>(16);
    }

    private TypefaceCompat() {
    }

    public static android.graphics.Typeface createFromFontInfo(android.content.Context context, @android.support.annotation.Nullable android.os.CancellationSignal cancellationSignal, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i);
    }

    public static android.graphics.Typeface createFromResourcesFamilyXml(android.content.Context context, android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, android.content.res.Resources resources, int i, int i2, @android.support.annotation.Nullable android.widget.TextView textView) {
        android.graphics.Typeface typefaceCreateFromFontFamilyFilesResourceEntry;
        if (familyResourceEntry instanceof android.support.v4.content.res.FontResourcesParserCompat.ProviderResourceEntry) {
            android.support.v4.content.res.FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (android.support.v4.content.res.FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            typefaceCreateFromFontFamilyFilesResourceEntry = android.support.v4.provider.FontsContractCompat.getFontSync(context, providerResourceEntry.getRequest(), textView, providerResourceEntry.getFetchStrategy(), providerResourceEntry.getTimeout(), i2);
        } else {
            typefaceCreateFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i2);
        }
        if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
            sTypefaceCache.put(createResourceUid(resources, i, i2), typefaceCreateFromFontFamilyFilesResourceEntry);
        }
        return typefaceCreateFromFontFamilyFilesResourceEntry;
    }

    @android.support.annotation.Nullable
    public static android.graphics.Typeface createFromResourcesFontFile(android.content.Context context, android.content.res.Resources resources, int i, java.lang.String str, int i2) {
        android.graphics.Typeface typefaceCreateFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i, str, i2);
        if (typefaceCreateFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources, i, i2), typefaceCreateFromResourcesFontFile);
        }
        return typefaceCreateFromResourcesFontFile;
    }

    private static java.lang.String createResourceUid(android.content.res.Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static android.graphics.Typeface findFromCache(android.content.res.Resources resources, int i, int i2) {
        return sTypefaceCache.get(createResourceUid(resources, i, i2));
    }
}
