package android.support.v4.print;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    private final android.support.v4.print.PrintHelper.PrintHelperVersionImpl mImpl;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface ColorMode {
    }

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface Orientation {
    }

    @android.support.annotation.RequiresApi(19)
    private static class PrintHelperApi19 implements android.support.v4.print.PrintHelper.PrintHelperVersionImpl {
        private static final java.lang.String LOG_TAG = "PrintHelperApi19";
        private static final int MAX_PRINT_SIZE = 3500;
        final android.content.Context mContext;
        int mOrientation;
        android.graphics.BitmapFactory.Options mDecodeOptions = null;
        private final java.lang.Object mLock = new java.lang.Object();
        int mScaleMode = 2;
        int mColorMode = 2;
        protected boolean mPrintActivityRespectsOrientation = true;
        protected boolean mIsMinMarginsHandlingCorrect = true;

        /* JADX INFO: renamed from: android.support.v4.print.PrintHelper$PrintHelperApi19$3, reason: invalid class name */
        class AnonymousClass3 extends android.print.PrintDocumentAdapter {
            private android.print.PrintAttributes mAttributes;
            android.graphics.Bitmap mBitmap = null;
            android.os.AsyncTask<android.net.Uri, java.lang.Boolean, android.graphics.Bitmap> mLoadBitmap;
            final /* synthetic */ android.support.v4.print.PrintHelper.OnPrintFinishCallback val$callback;
            final /* synthetic */ int val$fittingMode;
            final /* synthetic */ android.net.Uri val$imageFile;
            final /* synthetic */ java.lang.String val$jobName;

            AnonymousClass3(java.lang.String str, android.net.Uri uri, android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback, int i) {
                this.val$jobName = str;
                this.val$imageFile = uri;
                this.val$callback = onPrintFinishCallback;
                this.val$fittingMode = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void cancelLoad() {
                synchronized (android.support.v4.print.PrintHelper.PrintHelperApi19.this.mLock) {
                    if (android.support.v4.print.PrintHelper.PrintHelperApi19.this.mDecodeOptions != null) {
                        android.support.v4.print.PrintHelper.PrintHelperApi19.this.mDecodeOptions.requestCancelDecode();
                        android.support.v4.print.PrintHelper.PrintHelperApi19.this.mDecodeOptions = null;
                    }
                }
            }

            @Override // android.print.PrintDocumentAdapter
            public void onFinish() {
                super.onFinish();
                cancelLoad();
                android.os.AsyncTask<android.net.Uri, java.lang.Boolean, android.graphics.Bitmap> asyncTask = this.mLoadBitmap;
                if (asyncTask != null) {
                    asyncTask.cancel(true);
                }
                android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.val$callback;
                if (onPrintFinishCallback != null) {
                    onPrintFinishCallback.onFinish();
                }
                android.graphics.Bitmap bitmap = this.mBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                    this.mBitmap = null;
                }
            }

            /* JADX WARN: Type inference failed for: r11v3, types: [android.support.v4.print.PrintHelper$PrintHelperApi19$3$1] */
            @Override // android.print.PrintDocumentAdapter
            public void onLayout(final android.print.PrintAttributes printAttributes, final android.print.PrintAttributes printAttributes2, final android.os.CancellationSignal cancellationSignal, final android.print.PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, android.os.Bundle bundle) {
                synchronized (this) {
                    this.mAttributes = printAttributes2;
                }
                if (cancellationSignal.isCanceled()) {
                    layoutResultCallback.onLayoutCancelled();
                } else if (this.mBitmap != null) {
                    layoutResultCallback.onLayoutFinished(new android.print.PrintDocumentInfo.Builder(this.val$jobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
                } else {
                    this.mLoadBitmap = new android.os.AsyncTask<android.net.Uri, java.lang.Boolean, android.graphics.Bitmap>() { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.3.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        public android.graphics.Bitmap doInBackground(android.net.Uri... uriArr) {
                            try {
                                return android.support.v4.print.PrintHelper.PrintHelperApi19.this.loadConstrainedBitmap(android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3.this.val$imageFile);
                            } catch (java.io.FileNotFoundException unused) {
                                return null;
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        public void onCancelled(android.graphics.Bitmap bitmap) {
                            layoutResultCallback.onLayoutCancelled();
                            android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3.this.mLoadBitmap = null;
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        public void onPostExecute(android.graphics.Bitmap bitmap) {
                            android.print.PrintAttributes.MediaSize mediaSize;
                            super.onPostExecute(bitmap);
                            if (bitmap != null && (!android.support.v4.print.PrintHelper.PrintHelperApi19.this.mPrintActivityRespectsOrientation || android.support.v4.print.PrintHelper.PrintHelperApi19.this.mOrientation == 0)) {
                                synchronized (this) {
                                    mediaSize = android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3.this.mAttributes.getMediaSize();
                                }
                                if (mediaSize != null && mediaSize.isPortrait() != android.support.v4.print.PrintHelper.PrintHelperApi19.isPortrait(bitmap)) {
                                    android.graphics.Matrix matrix = new android.graphics.Matrix();
                                    matrix.postRotate(90.0f);
                                    bitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                }
                            }
                            android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3 anonymousClass3 = android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3.this;
                            anonymousClass3.mBitmap = bitmap;
                            if (bitmap != null) {
                                layoutResultCallback.onLayoutFinished(new android.print.PrintDocumentInfo.Builder(anonymousClass3.val$jobName).setContentType(1).setPageCount(1).build(), true ^ printAttributes2.equals(printAttributes));
                            } else {
                                layoutResultCallback.onLayoutFailed(null);
                            }
                            android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3.this.mLoadBitmap = null;
                        }

                        @Override // android.os.AsyncTask
                        protected void onPreExecute() {
                            cancellationSignal.setOnCancelListener(new android.os.CancellationSignal.OnCancelListener() { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.3.1.1
                                @Override // android.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3.this.cancelLoad();
                                    cancel(false);
                                }
                            });
                        }
                    }.execute(new android.net.Uri[0]);
                }
            }

            @Override // android.print.PrintDocumentAdapter
            public void onWrite(android.print.PageRange[] pageRangeArr, android.os.ParcelFileDescriptor parcelFileDescriptor, android.os.CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                android.support.v4.print.PrintHelper.PrintHelperApi19.this.writeBitmap(this.mAttributes, this.val$fittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
            }
        }

        PrintHelperApi19(android.content.Context context) {
            this.mContext = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public android.graphics.Bitmap convertBitmapForColorMode(android.graphics.Bitmap bitmap, int i) {
            if (i != 1) {
                return bitmap;
            }
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
            android.graphics.Paint paint = new android.graphics.Paint();
            android.graphics.ColorMatrix colorMatrix = new android.graphics.ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new android.graphics.ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return bitmapCreateBitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public android.graphics.Matrix getMatrix(int i, int i2, android.graphics.RectF rectF, int i3) {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            float f = i;
            float fWidth = rectF.width() / f;
            float fMax = i3 == 2 ? java.lang.Math.max(fWidth, rectF.height() / i2) : java.lang.Math.min(fWidth, rectF.height() / i2);
            matrix.postScale(fMax, fMax);
            matrix.postTranslate((rectF.width() - (f * fMax)) / 2.0f, (rectF.height() - (i2 * fMax)) / 2.0f);
            return matrix;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isPortrait(android.graphics.Bitmap bitmap) {
            return bitmap.getWidth() <= bitmap.getHeight();
        }

        private android.graphics.Bitmap loadBitmap(android.net.Uri uri, android.graphics.BitmapFactory.Options options) throws java.lang.Throwable {
            android.content.Context context;
            if (uri == null || (context = this.mContext) == null) {
                throw new java.lang.IllegalArgumentException("bad argument to loadBitmap");
            }
            java.io.InputStream inputStream = null;
            try {
                java.io.InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (java.io.IOException e) {
                            android.util.Log.w(LOG_TAG, "close fail ", e);
                        }
                    }
                    return bitmapDecodeStream;
                } catch (java.lang.Throwable th) {
                    th = th;
                    inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException e2) {
                            android.util.Log.w(LOG_TAG, "close fail ", e2);
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public android.graphics.Bitmap loadConstrainedBitmap(android.net.Uri uri) throws java.lang.Throwable {
            android.graphics.BitmapFactory.Options options;
            if (uri == null || this.mContext == null) {
                throw new java.lang.IllegalArgumentException("bad argument to getScaledBitmap");
            }
            android.graphics.BitmapFactory.Options options2 = new android.graphics.BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            loadBitmap(uri, options2);
            int i = options2.outWidth;
            int i2 = options2.outHeight;
            if (i <= 0 || i2 <= 0) {
                return null;
            }
            int iMax = java.lang.Math.max(i, i2);
            int i3 = 1;
            while (iMax > MAX_PRINT_SIZE) {
                iMax >>>= 1;
                i3 <<= 1;
            }
            if (i3 <= 0 || java.lang.Math.min(i, i2) / i3 <= 0) {
                return null;
            }
            synchronized (this.mLock) {
                this.mDecodeOptions = new android.graphics.BitmapFactory.Options();
                this.mDecodeOptions.inMutable = true;
                this.mDecodeOptions.inSampleSize = i3;
                options = this.mDecodeOptions;
            }
            try {
                android.graphics.Bitmap bitmapLoadBitmap = loadBitmap(uri, options);
                synchronized (this.mLock) {
                    this.mDecodeOptions = null;
                }
                return bitmapLoadBitmap;
            } catch (java.lang.Throwable th) {
                synchronized (this.mLock) {
                    this.mDecodeOptions = null;
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r11v0, types: [android.support.v4.print.PrintHelper$PrintHelperApi19$2] */
        public void writeBitmap(final android.print.PrintAttributes printAttributes, final int i, final android.graphics.Bitmap bitmap, final android.os.ParcelFileDescriptor parcelFileDescriptor, final android.os.CancellationSignal cancellationSignal, final android.print.PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            final android.print.PrintAttributes printAttributesBuild = this.mIsMinMarginsHandlingCorrect ? printAttributes : copyAttributes(printAttributes).setMinMargins(new android.print.PrintAttributes.Margins(0, 0, 0, 0)).build();
            new android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Throwable>() { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public java.lang.Throwable doInBackground(java.lang.Void... voidArr) {
                    android.graphics.RectF rectF;
                    try {
                        if (cancellationSignal.isCanceled()) {
                            return null;
                        }
                        android.print.pdf.PrintedPdfDocument printedPdfDocument = new android.print.pdf.PrintedPdfDocument(android.support.v4.print.PrintHelper.PrintHelperApi19.this.mContext, printAttributesBuild);
                        android.graphics.Bitmap bitmapConvertBitmapForColorMode = android.support.v4.print.PrintHelper.PrintHelperApi19.this.convertBitmapForColorMode(bitmap, printAttributesBuild.getColorMode());
                        if (cancellationSignal.isCanceled()) {
                            return null;
                        }
                        try {
                            android.graphics.pdf.PdfDocument.Page pageStartPage = printedPdfDocument.startPage(1);
                            if (android.support.v4.print.PrintHelper.PrintHelperApi19.this.mIsMinMarginsHandlingCorrect) {
                                rectF = new android.graphics.RectF(pageStartPage.getInfo().getContentRect());
                            } else {
                                android.print.pdf.PrintedPdfDocument printedPdfDocument2 = new android.print.pdf.PrintedPdfDocument(android.support.v4.print.PrintHelper.PrintHelperApi19.this.mContext, printAttributes);
                                android.graphics.pdf.PdfDocument.Page pageStartPage2 = printedPdfDocument2.startPage(1);
                                android.graphics.RectF rectF2 = new android.graphics.RectF(pageStartPage2.getInfo().getContentRect());
                                printedPdfDocument2.finishPage(pageStartPage2);
                                printedPdfDocument2.close();
                                rectF = rectF2;
                            }
                            android.graphics.Matrix matrix = android.support.v4.print.PrintHelper.PrintHelperApi19.this.getMatrix(bitmapConvertBitmapForColorMode.getWidth(), bitmapConvertBitmapForColorMode.getHeight(), rectF, i);
                            if (!android.support.v4.print.PrintHelper.PrintHelperApi19.this.mIsMinMarginsHandlingCorrect) {
                                matrix.postTranslate(rectF.left, rectF.top);
                                pageStartPage.getCanvas().clipRect(rectF);
                            }
                            pageStartPage.getCanvas().drawBitmap(bitmapConvertBitmapForColorMode, matrix, null);
                            printedPdfDocument.finishPage(pageStartPage);
                            if (cancellationSignal.isCanceled()) {
                                return null;
                            }
                            printedPdfDocument.writeTo(new java.io.FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                            return null;
                        } finally {
                            printedPdfDocument.close();
                            if (parcelFileDescriptor != null) {
                                try {
                                    parcelFileDescriptor.close();
                                } catch (java.io.IOException unused) {
                                }
                            }
                            if (bitmapConvertBitmapForColorMode != bitmap) {
                                bitmapConvertBitmapForColorMode.recycle();
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        return th;
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(java.lang.Throwable th) {
                    if (cancellationSignal.isCanceled()) {
                        writeResultCallback.onWriteCancelled();
                    } else if (th == null) {
                        writeResultCallback.onWriteFinished(new android.print.PageRange[]{android.print.PageRange.ALL_PAGES});
                    } else {
                        android.util.Log.e(android.support.v4.print.PrintHelper.PrintHelperApi19.LOG_TAG, "Error writing printed content", th);
                        writeResultCallback.onWriteFailed(null);
                    }
                }
            }.execute(new java.lang.Void[0]);
        }

        protected android.print.PrintAttributes.Builder copyAttributes(android.print.PrintAttributes printAttributes) {
            android.print.PrintAttributes.Builder minMargins = new android.print.PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
            if (printAttributes.getColorMode() != 0) {
                minMargins.setColorMode(printAttributes.getColorMode());
            }
            return minMargins;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getColorMode() {
            return this.mColorMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getOrientation() {
            int i = this.mOrientation;
            if (i == 0) {
                return 1;
            }
            return i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getScaleMode() {
            return this.mScaleMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(final java.lang.String str, final android.graphics.Bitmap bitmap, final android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback) {
            if (bitmap == null) {
                return;
            }
            final int i = this.mScaleMode;
            ((android.print.PrintManager) this.mContext.getSystemService("print")).print(str, new android.print.PrintDocumentAdapter() { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.1
                private android.print.PrintAttributes mAttributes;

                @Override // android.print.PrintDocumentAdapter
                public void onFinish() {
                    android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
                    if (onPrintFinishCallback2 != null) {
                        onPrintFinishCallback2.onFinish();
                    }
                }

                @Override // android.print.PrintDocumentAdapter
                public void onLayout(android.print.PrintAttributes printAttributes, android.print.PrintAttributes printAttributes2, android.os.CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, android.os.Bundle bundle) {
                    this.mAttributes = printAttributes2;
                    layoutResultCallback.onLayoutFinished(new android.print.PrintDocumentInfo.Builder(str).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
                }

                @Override // android.print.PrintDocumentAdapter
                public void onWrite(android.print.PageRange[] pageRangeArr, android.os.ParcelFileDescriptor parcelFileDescriptor, android.os.CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                    android.support.v4.print.PrintHelper.PrintHelperApi19.this.writeBitmap(this.mAttributes, i, bitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
                }
            }, new android.print.PrintAttributes.Builder().setMediaSize(isPortrait(bitmap) ? android.print.PrintAttributes.MediaSize.UNKNOWN_PORTRAIT : android.print.PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE).setColorMode(this.mColorMode).build());
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(java.lang.String str, android.net.Uri uri, android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback) throws java.io.FileNotFoundException {
            android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3 anonymousClass3 = new android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3(str, uri, onPrintFinishCallback, this.mScaleMode);
            android.print.PrintManager printManager = (android.print.PrintManager) this.mContext.getSystemService("print");
            android.print.PrintAttributes.Builder builder = new android.print.PrintAttributes.Builder();
            builder.setColorMode(this.mColorMode);
            int i = this.mOrientation;
            if (i == 1 || i == 0) {
                builder.setMediaSize(android.print.PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
            } else if (i == 2) {
                builder.setMediaSize(android.print.PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
            }
            printManager.print(str, anonymousClass3, builder.build());
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setColorMode(int i) {
            this.mColorMode = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setOrientation(int i) {
            this.mOrientation = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }
    }

    @android.support.annotation.RequiresApi(20)
    private static class PrintHelperApi20 extends android.support.v4.print.PrintHelper.PrintHelperApi19 {
        PrintHelperApi20(android.content.Context context) {
            super(context);
            this.mPrintActivityRespectsOrientation = false;
        }
    }

    @android.support.annotation.RequiresApi(23)
    private static class PrintHelperApi23 extends android.support.v4.print.PrintHelper.PrintHelperApi20 {
        PrintHelperApi23(android.content.Context context) {
            super(context);
            this.mIsMinMarginsHandlingCorrect = false;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperApi19
        protected android.print.PrintAttributes.Builder copyAttributes(android.print.PrintAttributes printAttributes) {
            android.print.PrintAttributes.Builder builderCopyAttributes = super.copyAttributes(printAttributes);
            if (printAttributes.getDuplexMode() != 0) {
                builderCopyAttributes.setDuplexMode(printAttributes.getDuplexMode());
            }
            return builderCopyAttributes;
        }
    }

    @android.support.annotation.RequiresApi(24)
    private static class PrintHelperApi24 extends android.support.v4.print.PrintHelper.PrintHelperApi23 {
        PrintHelperApi24(android.content.Context context) {
            super(context);
            this.mIsMinMarginsHandlingCorrect = true;
            this.mPrintActivityRespectsOrientation = true;
        }
    }

    private static final class PrintHelperStub implements android.support.v4.print.PrintHelper.PrintHelperVersionImpl {
        int mColorMode;
        int mOrientation;
        int mScaleMode;

        private PrintHelperStub() {
            this.mScaleMode = 2;
            this.mColorMode = 2;
            this.mOrientation = 1;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getColorMode() {
            return this.mColorMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getOrientation() {
            return this.mOrientation;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getScaleMode() {
            return this.mScaleMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(java.lang.String str, android.graphics.Bitmap bitmap, android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback) {
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(java.lang.String str, android.net.Uri uri, android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback) {
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setColorMode(int i) {
            this.mColorMode = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setOrientation(int i) {
            this.mOrientation = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }
    }

    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(java.lang.String str, android.graphics.Bitmap bitmap, android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback);

        void printBitmap(java.lang.String str, android.net.Uri uri, android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback) throws java.io.FileNotFoundException;

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface ScaleMode {
    }

    public PrintHelper(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            this.mImpl = new android.support.v4.print.PrintHelper.PrintHelperApi24(context);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new android.support.v4.print.PrintHelper.PrintHelperApi23(context);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            this.mImpl = new android.support.v4.print.PrintHelper.PrintHelperApi20(context);
        } else if (android.os.Build.VERSION.SDK_INT >= 19) {
            this.mImpl = new android.support.v4.print.PrintHelper.PrintHelperApi19(context);
        } else {
            this.mImpl = new android.support.v4.print.PrintHelper.PrintHelperStub();
        }
    }

    public static boolean systemSupportsPrint() {
        return android.os.Build.VERSION.SDK_INT >= 19;
    }

    public int getColorMode() {
        return this.mImpl.getColorMode();
    }

    public int getOrientation() {
        return this.mImpl.getOrientation();
    }

    public int getScaleMode() {
        return this.mImpl.getScaleMode();
    }

    public void printBitmap(java.lang.String str, android.graphics.Bitmap bitmap) {
        this.mImpl.printBitmap(str, bitmap, (android.support.v4.print.PrintHelper.OnPrintFinishCallback) null);
    }

    public void printBitmap(java.lang.String str, android.graphics.Bitmap bitmap, android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback) {
        this.mImpl.printBitmap(str, bitmap, onPrintFinishCallback);
    }

    public void printBitmap(java.lang.String str, android.net.Uri uri) throws java.io.FileNotFoundException {
        this.mImpl.printBitmap(str, uri, (android.support.v4.print.PrintHelper.OnPrintFinishCallback) null);
    }

    public void printBitmap(java.lang.String str, android.net.Uri uri, android.support.v4.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback) throws java.io.FileNotFoundException {
        this.mImpl.printBitmap(str, uri, onPrintFinishCallback);
    }

    public void setColorMode(int i) {
        this.mImpl.setColorMode(i);
    }

    public void setOrientation(int i) {
        this.mImpl.setOrientation(i);
    }

    public void setScaleMode(int i) {
        this.mImpl.setScaleMode(i);
    }
}
