package android.support.v4.provider;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FontsContractCompat {
    private static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final java.lang.String PARCEL_FONT_RESULTS = "font_results";

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
    private static final java.lang.String TAG = "FontsContractCompat";
    private static final android.support.v4.util.LruCache<java.lang.String, android.graphics.Typeface> sTypefaceCache = new android.support.v4.util.LruCache<>(16);
    private static final android.support.v4.provider.SelfDestructiveThread sBackgroundThread = new android.support.v4.provider.SelfDestructiveThread("fonts", 10, 10000);
    private static final java.lang.Object sLock = new java.lang.Object();

    @android.support.annotation.GuardedBy("sLock")
    private static final android.support.v4.util.SimpleArrayMap<java.lang.String, java.util.ArrayList<android.support.v4.provider.SelfDestructiveThread.ReplyCallback<android.graphics.Typeface>>> sPendingReplies = new android.support.v4.util.SimpleArrayMap<>();
    private static final java.util.Comparator<byte[]> sByteArrayComparator = new java.util.Comparator<byte[]>() { // from class: android.support.v4.provider.FontsContractCompat.5
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };

    public static final class Columns implements android.provider.BaseColumns {
        public static final java.lang.String FILE_ID = "file_id";
        public static final java.lang.String ITALIC = "font_italic";
        public static final java.lang.String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final java.lang.String TTC_INDEX = "font_ttc_index";
        public static final java.lang.String VARIATION_SETTINGS = "font_variation_settings";
        public static final java.lang.String WEIGHT = "font_weight";
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final android.support.v4.provider.FontsContractCompat.FontInfo[] mFonts;
        private final int mStatusCode;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        @interface FontResultStatus {
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public FontFamilyResult(int i, @android.support.annotation.Nullable android.support.v4.provider.FontsContractCompat.FontInfo[] fontInfoArr) {
            this.mStatusCode = i;
            this.mFonts = fontInfoArr;
        }

        public android.support.v4.provider.FontsContractCompat.FontInfo[] getFonts() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }
    }

    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final android.net.Uri mUri;
        private final int mWeight;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public FontInfo(@android.support.annotation.NonNull android.net.Uri uri, @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED) int i, @android.support.annotation.IntRange(from = 1, to = 1000) int i2, boolean z, int i3) {
            this.mUri = (android.net.Uri) android.support.v4.util.Preconditions.checkNotNull(uri);
            this.mTtcIndex = i;
            this.mWeight = i2;
            this.mItalic = z;
            this.mResultCode = i3;
        }

        public int getResultCode() {
            return this.mResultCode;
        }

        @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED)
        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        @android.support.annotation.NonNull
        public android.net.Uri getUri() {
            return this.mUri;
        }

        @android.support.annotation.IntRange(from = 1, to = 1000)
        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i) {
        }

        public void onTypefaceRetrieved(android.graphics.Typeface typeface) {
        }
    }

    private FontsContractCompat() {
    }

    public static android.graphics.Typeface buildTypeface(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.Nullable android.os.CancellationSignal cancellationSignal, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] fontInfoArr) {
        return android.support.v4.graphics.TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    private static java.util.List<byte[]> convertToByteArrayList(android.content.pm.Signature[] signatureArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (android.content.pm.Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean equalsByteArrayList(java.util.List<byte[]> list, java.util.List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!java.util.Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @android.support.annotation.NonNull
    public static android.support.v4.provider.FontsContractCompat.FontFamilyResult fetchFonts(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.Nullable android.os.CancellationSignal cancellationSignal, @android.support.annotation.NonNull android.support.v4.provider.FontRequest fontRequest) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        return provider == null ? new android.support.v4.provider.FontsContractCompat.FontFamilyResult(1, null) : new android.support.v4.provider.FontsContractCompat.FontFamilyResult(0, getFontFromProvider(context, fontRequest, provider.authority, cancellationSignal));
    }

    private static java.util.List<java.util.List<byte[]>> getCertificates(android.support.v4.provider.FontRequest fontRequest, android.content.res.Resources resources) {
        return fontRequest.getCertificates() != null ? fontRequest.getCertificates() : android.support.v4.content.res.FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.support.annotation.VisibleForTesting
    @android.support.annotation.NonNull
    static android.support.v4.provider.FontsContractCompat.FontInfo[] getFontFromProvider(android.content.Context context, android.support.v4.provider.FontRequest fontRequest, java.lang.String str, android.os.CancellationSignal cancellationSignal) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.net.Uri uriBuild = new android.net.Uri.Builder().scheme("content").authority(str).build();
        android.net.Uri uriBuild2 = new android.net.Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = android.os.Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(uriBuild, new java.lang.String[]{"_id", android.support.v4.provider.FontsContractCompat.Columns.FILE_ID, android.support.v4.provider.FontsContractCompat.Columns.TTC_INDEX, android.support.v4.provider.FontsContractCompat.Columns.VARIATION_SETTINGS, android.support.v4.provider.FontsContractCompat.Columns.WEIGHT, android.support.v4.provider.FontsContractCompat.Columns.ITALIC, android.support.v4.provider.FontsContractCompat.Columns.RESULT_CODE}, "query = ?", new java.lang.String[]{fontRequest.getQuery()}, null, cancellationSignal) : context.getContentResolver().query(uriBuild, new java.lang.String[]{"_id", android.support.v4.provider.FontsContractCompat.Columns.FILE_ID, android.support.v4.provider.FontsContractCompat.Columns.TTC_INDEX, android.support.v4.provider.FontsContractCompat.Columns.VARIATION_SETTINGS, android.support.v4.provider.FontsContractCompat.Columns.WEIGHT, android.support.v4.provider.FontsContractCompat.Columns.ITALIC, android.support.v4.provider.FontsContractCompat.Columns.RESULT_CODE}, "query = ?", new java.lang.String[]{fontRequest.getQuery()}, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex(android.support.v4.provider.FontsContractCompat.Columns.RESULT_CODE);
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex(android.support.v4.provider.FontsContractCompat.Columns.FILE_ID);
                int columnIndex4 = cursorQuery.getColumnIndex(android.support.v4.provider.FontsContractCompat.Columns.TTC_INDEX);
                int columnIndex5 = cursorQuery.getColumnIndex(android.support.v4.provider.FontsContractCompat.Columns.WEIGHT);
                int columnIndex6 = cursorQuery.getColumnIndex(android.support.v4.provider.FontsContractCompat.Columns.ITALIC);
                while (cursorQuery.moveToNext()) {
                    int i = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                    arrayList2.add(new android.support.v4.provider.FontsContractCompat.FontInfo(columnIndex3 == -1 ? android.content.ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : android.content.ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (android.support.v4.provider.FontsContractCompat.FontInfo[]) arrayList.toArray(new android.support.v4.provider.FontsContractCompat.FontInfo[0]);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.graphics.Typeface getFontInternal(android.content.Context context, android.support.v4.provider.FontRequest fontRequest, int i) {
        try {
            android.support.v4.provider.FontsContractCompat.FontFamilyResult fontFamilyResultFetchFonts = fetchFonts(context, null, fontRequest);
            if (fontFamilyResultFetchFonts.getStatusCode() == 0) {
                return android.support.v4.graphics.TypefaceCompat.createFromFontInfo(context, null, fontFamilyResultFetchFonts.getFonts(), i);
            }
            return null;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static android.graphics.Typeface getFontSync(final android.content.Context context, final android.support.v4.provider.FontRequest fontRequest, @android.support.annotation.Nullable final android.widget.TextView textView, int i, int i2, final int i3) {
        final java.lang.String str = fontRequest.getIdentifier() + "-" + i3;
        android.graphics.Typeface typeface = sTypefaceCache.get(str);
        if (typeface != null) {
            return typeface;
        }
        boolean z = i == 0;
        if (z && i2 == -1) {
            return getFontInternal(context, fontRequest, i3);
        }
        java.util.concurrent.Callable<android.graphics.Typeface> callable = new java.util.concurrent.Callable<android.graphics.Typeface>() { // from class: android.support.v4.provider.FontsContractCompat.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public android.graphics.Typeface call() throws java.lang.Exception {
                android.graphics.Typeface fontInternal = android.support.v4.provider.FontsContractCompat.getFontInternal(context, fontRequest, i3);
                if (fontInternal != null) {
                    android.support.v4.provider.FontsContractCompat.sTypefaceCache.put(str, fontInternal);
                }
                return fontInternal;
            }
        };
        if (z) {
            try {
                return (android.graphics.Typeface) sBackgroundThread.postAndWait(callable, i2);
            } catch (java.lang.InterruptedException unused) {
                return null;
            }
        }
        final java.lang.ref.WeakReference weakReference = new java.lang.ref.WeakReference(textView);
        android.support.v4.provider.SelfDestructiveThread.ReplyCallback<android.graphics.Typeface> replyCallback = new android.support.v4.provider.SelfDestructiveThread.ReplyCallback<android.graphics.Typeface>() { // from class: android.support.v4.provider.FontsContractCompat.2
            @Override // android.support.v4.provider.SelfDestructiveThread.ReplyCallback
            public void onReply(android.graphics.Typeface typeface2) {
                if (((android.widget.TextView) weakReference.get()) != null) {
                    textView.setTypeface(typeface2, i3);
                }
            }
        };
        synchronized (sLock) {
            if (sPendingReplies.containsKey(str)) {
                sPendingReplies.get(str).add(replyCallback);
                return null;
            }
            java.util.ArrayList<android.support.v4.provider.SelfDestructiveThread.ReplyCallback<android.graphics.Typeface>> arrayList = new java.util.ArrayList<>();
            arrayList.add(replyCallback);
            sPendingReplies.put(str, arrayList);
            sBackgroundThread.postAndReply(callable, new android.support.v4.provider.SelfDestructiveThread.ReplyCallback<android.graphics.Typeface>() { // from class: android.support.v4.provider.FontsContractCompat.3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.support.v4.provider.SelfDestructiveThread.ReplyCallback
                public void onReply(android.graphics.Typeface typeface2) {
                    java.util.ArrayList arrayList2;
                    synchronized (android.support.v4.provider.FontsContractCompat.sLock) {
                        arrayList2 = (java.util.ArrayList) android.support.v4.provider.FontsContractCompat.sPendingReplies.get(str);
                        android.support.v4.provider.FontsContractCompat.sPendingReplies.remove(str);
                    }
                    for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                        ((android.support.v4.provider.SelfDestructiveThread.ReplyCallback) arrayList2.get(i4)).onReply(typeface2);
                    }
                }
            });
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.support.annotation.VisibleForTesting
    @android.support.annotation.Nullable
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static android.content.pm.ProviderInfo getProvider(@android.support.annotation.NonNull android.content.pm.PackageManager packageManager, @android.support.annotation.NonNull android.support.v4.provider.FontRequest fontRequest, @android.support.annotation.Nullable android.content.res.Resources resources) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String providerAuthority = fontRequest.getProviderAuthority();
        android.content.pm.ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new android.content.pm.PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            throw new android.content.pm.PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
        java.util.List<byte[]> listConvertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        java.util.Collections.sort(listConvertToByteArrayList, sByteArrayComparator);
        java.util.List<java.util.List<byte[]>> certificates = getCertificates(fontRequest, resources);
        for (int i = 0; i < certificates.size(); i++) {
            java.util.ArrayList arrayList = new java.util.ArrayList(certificates.get(i));
            java.util.Collections.sort(arrayList, sByteArrayComparator);
            if (equalsByteArrayList(listConvertToByteArrayList, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    @android.support.annotation.RequiresApi(19)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static java.util.Map<android.net.Uri, java.nio.ByteBuffer> prepareFontData(android.content.Context context, android.support.v4.provider.FontsContractCompat.FontInfo[] fontInfoArr, android.os.CancellationSignal cancellationSignal) {
        java.util.HashMap map = new java.util.HashMap();
        for (android.support.v4.provider.FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.getResultCode() == 0) {
                android.net.Uri uri = fontInfo.getUri();
                if (!map.containsKey(uri)) {
                    map.put(uri, android.support.v4.graphics.TypefaceCompatUtil.mmap(context, cancellationSignal, uri));
                }
            }
        }
        return java.util.Collections.unmodifiableMap(map);
    }

    public static void requestFont(@android.support.annotation.NonNull final android.content.Context context, @android.support.annotation.NonNull final android.support.v4.provider.FontRequest fontRequest, @android.support.annotation.NonNull final android.support.v4.provider.FontsContractCompat.FontRequestCallback fontRequestCallback, @android.support.annotation.NonNull android.os.Handler handler) {
        final android.os.Handler handler2 = new android.os.Handler();
        handler.post(new java.lang.Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    android.support.v4.provider.FontsContractCompat.FontFamilyResult fontFamilyResultFetchFonts = android.support.v4.provider.FontsContractCompat.fetchFonts(context, null, fontRequest);
                    if (fontFamilyResultFetchFonts.getStatusCode() != 0) {
                        switch (fontFamilyResultFetchFonts.getStatusCode()) {
                            case 1:
                                handler2.post(new java.lang.Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(-2);
                                    }
                                });
                                break;
                            case 2:
                                handler2.post(new java.lang.Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(-3);
                                    }
                                });
                                break;
                            default:
                                handler2.post(new java.lang.Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(-3);
                                    }
                                });
                                break;
                        }
                        return;
                    }
                    android.support.v4.provider.FontsContractCompat.FontInfo[] fonts = fontFamilyResultFetchFonts.getFonts();
                    if (fonts == null || fonts.length == 0) {
                        handler2.post(new java.lang.Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.5
                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(1);
                            }
                        });
                        return;
                    }
                    for (android.support.v4.provider.FontsContractCompat.FontInfo fontInfo : fonts) {
                        if (fontInfo.getResultCode() != 0) {
                            final int resultCode = fontInfo.getResultCode();
                            if (resultCode < 0) {
                                handler2.post(new java.lang.Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.6
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(-3);
                                    }
                                });
                                return;
                            } else {
                                handler2.post(new java.lang.Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.7
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(resultCode);
                                    }
                                });
                                return;
                            }
                        }
                    }
                    final android.graphics.Typeface typefaceBuildTypeface = android.support.v4.provider.FontsContractCompat.buildTypeface(context, null, fonts);
                    if (typefaceBuildTypeface == null) {
                        handler2.post(new java.lang.Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.8
                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-3);
                            }
                        });
                    } else {
                        handler2.post(new java.lang.Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.9
                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRetrieved(typefaceBuildTypeface);
                            }
                        });
                    }
                } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                    handler2.post(new java.lang.Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRequestFailed(-1);
                        }
                    });
                }
            }
        });
    }
}
