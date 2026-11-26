package com.soundcloud.android.crop;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CropImageActivity extends com.soundcloud.android.crop.MonitoredActivity {
    private static final int SIZE_DEFAULT = 2048;
    private static final int SIZE_LIMIT = 4096;
    private int aspectX;
    private int aspectY;
    private com.soundcloud.android.crop.HighlightView cropView;
    private int exifRotation;
    private final android.os.Handler handler = new android.os.Handler();
    private com.soundcloud.android.crop.CropImageView imageView;
    private boolean isSaving;
    private int maxX;
    private int maxY;
    private com.soundcloud.android.crop.RotateBitmap rotateBitmap;
    private int sampleSize;
    private boolean saveAsPng;
    private android.net.Uri saveUri;
    private android.net.Uri sourceUri;

    private class Cropper {
        private Cropper() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void makeDefault() {
            int i;
            if (com.soundcloud.android.crop.CropImageActivity.this.rotateBitmap == null) {
                return;
            }
            com.soundcloud.android.crop.HighlightView highlightView = new com.soundcloud.android.crop.HighlightView(com.soundcloud.android.crop.CropImageActivity.this.imageView);
            int width = com.soundcloud.android.crop.CropImageActivity.this.rotateBitmap.getWidth();
            int height = com.soundcloud.android.crop.CropImageActivity.this.rotateBitmap.getHeight();
            boolean z = false;
            android.graphics.Rect rect = new android.graphics.Rect(0, 0, width, height);
            int iMin = (java.lang.Math.min(width, height) * 4) / 5;
            if (com.soundcloud.android.crop.CropImageActivity.this.aspectX == 0 || com.soundcloud.android.crop.CropImageActivity.this.aspectY == 0) {
                i = iMin;
            } else if (com.soundcloud.android.crop.CropImageActivity.this.aspectX > com.soundcloud.android.crop.CropImageActivity.this.aspectY) {
                i = (com.soundcloud.android.crop.CropImageActivity.this.aspectY * iMin) / com.soundcloud.android.crop.CropImageActivity.this.aspectX;
            } else {
                i = iMin;
                iMin = (com.soundcloud.android.crop.CropImageActivity.this.aspectX * iMin) / com.soundcloud.android.crop.CropImageActivity.this.aspectY;
            }
            int i2 = (width - iMin) / 2;
            int i3 = (height - i) / 2;
            android.graphics.RectF rectF = new android.graphics.RectF(i2, i3, i2 + iMin, i3 + i);
            android.graphics.Matrix unrotatedMatrix = com.soundcloud.android.crop.CropImageActivity.this.imageView.getUnrotatedMatrix();
            if (com.soundcloud.android.crop.CropImageActivity.this.aspectX != 0 && com.soundcloud.android.crop.CropImageActivity.this.aspectY != 0) {
                z = true;
            }
            highlightView.setup(unrotatedMatrix, rect, rectF, z);
            com.soundcloud.android.crop.CropImageActivity.this.imageView.add(highlightView);
        }

        public void crop() {
            com.soundcloud.android.crop.CropImageActivity.this.handler.post(new java.lang.Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.Cropper.1
                @Override // java.lang.Runnable
                public void run() {
                    com.soundcloud.android.crop.CropImageActivity.Cropper.this.makeDefault();
                    com.soundcloud.android.crop.CropImageActivity.this.imageView.invalidate();
                    if (com.soundcloud.android.crop.CropImageActivity.this.imageView.highlightViews.size() == 1) {
                        com.soundcloud.android.crop.CropImageActivity.this.cropView = com.soundcloud.android.crop.CropImageActivity.this.imageView.highlightViews.get(0);
                        com.soundcloud.android.crop.CropImageActivity.this.cropView.setFocus(true);
                    }
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int calculateBitmapSampleSize(android.net.Uri uri) throws java.lang.Throwable {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        java.io.InputStream inputStream = null;
        try {
            java.io.InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            try {
                android.graphics.BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                com.soundcloud.android.crop.CropUtil.closeSilently(inputStreamOpenInputStream);
                int maxImageSize = getMaxImageSize();
                while (true) {
                    if (options.outHeight / i <= maxImageSize && options.outWidth / i <= maxImageSize) {
                        return i;
                    }
                    i <<= 1;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                com.soundcloud.android.crop.CropUtil.closeSilently(inputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private void clearImageView() {
        this.imageView.clear();
        com.soundcloud.android.crop.RotateBitmap rotateBitmap = this.rotateBitmap;
        if (rotateBitmap != null) {
            rotateBitmap.recycle();
        }
        java.lang.System.gc();
    }

    private android.graphics.Bitmap decodeRegionCrop(android.graphics.Rect rect, int i, int i2) throws java.lang.Throwable {
        java.io.InputStream inputStreamOpenInputStream;
        android.graphics.Rect rect2;
        clearImageView();
        java.io.InputStream inputStream = null;
        try {
            try {
                inputStreamOpenInputStream = getContentResolver().openInputStream(this.sourceUri);
                try {
                    android.graphics.BitmapRegionDecoder bitmapRegionDecoderNewInstance = android.graphics.BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                    int width = bitmapRegionDecoderNewInstance.getWidth();
                    int height = bitmapRegionDecoderNewInstance.getHeight();
                    if (this.exifRotation != 0) {
                        android.graphics.Matrix matrix = new android.graphics.Matrix();
                        matrix.setRotate(-this.exifRotation);
                        android.graphics.RectF rectF = new android.graphics.RectF();
                        matrix.mapRect(rectF, new android.graphics.RectF(rect));
                        rectF.offset(rectF.left < 0.0f ? width : 0.0f, rectF.top < 0.0f ? height : 0.0f);
                        rect2 = new android.graphics.Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    } else {
                        rect2 = rect;
                    }
                    try {
                        android.graphics.Bitmap bitmapDecodeRegion = bitmapRegionDecoderNewInstance.decodeRegion(rect2, new android.graphics.BitmapFactory.Options());
                        if (bitmapDecodeRegion != null && (rect2.width() > i || rect2.height() > i2)) {
                            android.graphics.Matrix matrix2 = new android.graphics.Matrix();
                            matrix2.postScale(i / rect2.width(), i2 / rect2.height());
                            bitmapDecodeRegion = android.graphics.Bitmap.createBitmap(bitmapDecodeRegion, 0, 0, bitmapDecodeRegion.getWidth(), bitmapDecodeRegion.getHeight(), matrix2, true);
                        }
                        com.soundcloud.android.crop.CropUtil.closeSilently(inputStreamOpenInputStream);
                        return bitmapDecodeRegion;
                    } catch (java.lang.IllegalArgumentException e) {
                        throw new java.lang.IllegalArgumentException("Rectangle " + rect2 + " is outside of the image (" + width + "," + height + "," + this.exifRotation + ")", e);
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    inputStream = inputStreamOpenInputStream;
                    com.soundcloud.android.crop.Log.e("Error cropping image: " + e.getMessage(), e);
                    setResultException(e);
                    com.soundcloud.android.crop.CropUtil.closeSilently(inputStream);
                    return inputStream;
                } catch (java.lang.OutOfMemoryError e3) {
                    e = e3;
                    inputStream = inputStreamOpenInputStream;
                    com.soundcloud.android.crop.Log.e("OOM cropping image: " + e.getMessage(), e);
                    setResultException(e);
                    com.soundcloud.android.crop.CropUtil.closeSilently(inputStream);
                    return inputStream;
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.soundcloud.android.crop.CropUtil.closeSilently(inputStreamOpenInputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStreamOpenInputStream = null;
            }
        } catch (java.io.IOException e4) {
            e = e4;
        } catch (java.lang.OutOfMemoryError e5) {
            e = e5;
        }
    }

    private int getMaxImageSize() {
        int maxTextureSize = getMaxTextureSize();
        if (maxTextureSize == 0) {
            return 2048;
        }
        return java.lang.Math.min(maxTextureSize, 4096);
    }

    private int getMaxTextureSize() {
        int[] iArr = new int[1];
        android.opengl.GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context, com.soundcloud.android.crop.CropImageActivity] */
    private void loadInput() throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.InputStream inputStreamOpenInputStream;
        java.lang.OutOfMemoryError e;
        java.io.IOException e2;
        android.content.Intent intent = getIntent();
        android.os.Bundle extras = intent.getExtras();
        if (extras != null) {
            this.aspectX = extras.getInt(com.soundcloud.android.crop.Crop.Extra.ASPECT_X);
            this.aspectY = extras.getInt(com.soundcloud.android.crop.Crop.Extra.ASPECT_Y);
            this.maxX = extras.getInt(com.soundcloud.android.crop.Crop.Extra.MAX_X);
            this.maxY = extras.getInt(com.soundcloud.android.crop.Crop.Extra.MAX_Y);
            this.saveAsPng = extras.getBoolean(com.soundcloud.android.crop.Crop.Extra.AS_PNG, false);
            this.saveUri = (android.net.Uri) extras.getParcelable("output");
        }
        this.sourceUri = intent.getData();
        if (this.sourceUri != null) {
            android.content.ContentResolver contentResolver = getContentResolver();
            ?? r1 = this.sourceUri;
            this.exifRotation = com.soundcloud.android.crop.CropUtil.getExifRotation(com.soundcloud.android.crop.CropUtil.getFromMediaUri(this, contentResolver, r1));
            try {
                try {
                    this.sampleSize = calculateBitmapSampleSize(this.sourceUri);
                    inputStreamOpenInputStream = getContentResolver().openInputStream(this.sourceUri);
                    try {
                        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                        options.inSampleSize = this.sampleSize;
                        this.rotateBitmap = new com.soundcloud.android.crop.RotateBitmap(android.graphics.BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options), this.exifRotation);
                        r1 = inputStreamOpenInputStream;
                    } catch (java.io.IOException e3) {
                        e2 = e3;
                        com.soundcloud.android.crop.Log.e("Error reading image: " + e2.getMessage(), e2);
                        setResultException(e2);
                        r1 = inputStreamOpenInputStream;
                    } catch (java.lang.OutOfMemoryError e4) {
                        e = e4;
                        com.soundcloud.android.crop.Log.e("OOM reading image: " + e.getMessage(), e);
                        setResultException(e);
                        r1 = inputStreamOpenInputStream;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    com.soundcloud.android.crop.CropUtil.closeSilently(r1);
                    throw th;
                }
            } catch (java.io.IOException e5) {
                inputStreamOpenInputStream = null;
                e2 = e5;
            } catch (java.lang.OutOfMemoryError e6) {
                inputStreamOpenInputStream = null;
                e = e6;
            } catch (java.lang.Throwable th3) {
                r1 = 0;
                th = th3;
                com.soundcloud.android.crop.CropUtil.closeSilently(r1);
                throw th;
            }
            com.soundcloud.android.crop.CropUtil.closeSilently(r1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSaveClicked() throws java.lang.Throwable {
        int i;
        com.soundcloud.android.crop.HighlightView highlightView = this.cropView;
        if (highlightView == null || this.isSaving) {
            return;
        }
        this.isSaving = true;
        android.graphics.Rect scaledCropRect = highlightView.getScaledCropRect(this.sampleSize);
        int iWidth = scaledCropRect.width();
        int iHeight = scaledCropRect.height();
        int i2 = this.maxX;
        if (i2 > 0 && (i = this.maxY) > 0 && (iWidth > i2 || iHeight > i)) {
            float f = iWidth / iHeight;
            int i3 = this.maxX;
            int i4 = this.maxY;
            if (i3 / i4 > f) {
                iWidth = (int) ((i4 * f) + 0.5f);
                iHeight = i4;
            } else {
                iHeight = (int) ((i3 / f) + 0.5f);
                iWidth = i3;
            }
        }
        try {
            android.graphics.Bitmap bitmapDecodeRegionCrop = decodeRegionCrop(scaledCropRect, iWidth, iHeight);
            if (bitmapDecodeRegionCrop != null) {
                this.imageView.setImageRotateBitmapResetBase(new com.soundcloud.android.crop.RotateBitmap(bitmapDecodeRegionCrop, this.exifRotation), true);
                this.imageView.center();
                this.imageView.highlightViews.clear();
            }
            saveImage(bitmapDecodeRegionCrop);
        } catch (java.lang.IllegalArgumentException e) {
            setResultException(e);
            finish();
        }
    }

    private void saveImage(final android.graphics.Bitmap bitmap) {
        if (bitmap != null) {
            com.soundcloud.android.crop.CropUtil.startBackgroundJob(this, null, getResources().getString(getApplicationContext().getResources().getIdentifier("crop__saving", "string", getApplicationContext().getPackageName())), new java.lang.Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.soundcloud.android.crop.CropImageActivity.this.saveOutput(bitmap);
                }
            }, this.handler);
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveOutput(final android.graphics.Bitmap bitmap) {
        if (this.saveUri != null) {
            java.io.OutputStream outputStreamOpenOutputStream = null;
            try {
                try {
                    outputStreamOpenOutputStream = getContentResolver().openOutputStream(this.saveUri);
                    if (outputStreamOpenOutputStream != null) {
                        bitmap.compress(this.saveAsPng ? android.graphics.Bitmap.CompressFormat.PNG : android.graphics.Bitmap.CompressFormat.JPEG, 90, outputStreamOpenOutputStream);
                    }
                } catch (java.io.IOException e) {
                    setResultException(e);
                    com.soundcloud.android.crop.Log.e("Cannot open file: " + this.saveUri, e);
                }
                com.soundcloud.android.crop.CropUtil.closeSilently(outputStreamOpenOutputStream);
                com.soundcloud.android.crop.CropUtil.copyExifRotation(com.soundcloud.android.crop.CropUtil.getFromMediaUri(this, getContentResolver(), this.sourceUri), com.soundcloud.android.crop.CropUtil.getFromMediaUri(this, getContentResolver(), this.saveUri));
                setResultUri(this.saveUri);
            } catch (java.lang.Throwable th) {
                com.soundcloud.android.crop.CropUtil.closeSilently(outputStreamOpenOutputStream);
                throw th;
            }
        }
        this.handler.post(new java.lang.Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.6
            @Override // java.lang.Runnable
            public void run() {
                com.soundcloud.android.crop.CropImageActivity.this.imageView.clear();
                bitmap.recycle();
            }
        });
        finish();
    }

    private void setResultException(java.lang.Throwable th) {
        setResult(404, new android.content.Intent().putExtra("error", th));
    }

    private void setResultUri(android.net.Uri uri) {
        setResult(-1, new android.content.Intent().putExtra("output", uri));
    }

    private void setupViews() {
        setContentView(getApplicationContext().getResources().getIdentifier("crop__activity_crop", "layout", getApplicationContext().getPackageName()));
        this.imageView = (com.soundcloud.android.crop.CropImageView) findViewById(getApplicationContext().getResources().getIdentifier("crop_image", "id", getApplicationContext().getPackageName()));
        com.soundcloud.android.crop.CropImageView cropImageView = this.imageView;
        cropImageView.context = this;
        cropImageView.setRecycler(new com.soundcloud.android.crop.ImageViewTouchBase.Recycler() { // from class: com.soundcloud.android.crop.CropImageActivity.1
            @Override // com.soundcloud.android.crop.ImageViewTouchBase.Recycler
            public void recycle(android.graphics.Bitmap bitmap) {
                bitmap.recycle();
                java.lang.System.gc();
            }
        });
        findViewById(getApplicationContext().getResources().getIdentifier("btn_cancel", "id", getApplicationContext().getPackageName())).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.soundcloud.android.crop.CropImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.soundcloud.android.crop.CropImageActivity.this.setResult(0);
                com.soundcloud.android.crop.CropImageActivity.this.finish();
            }
        });
        findViewById(getApplicationContext().getResources().getIdentifier("btn_done", "id", getApplicationContext().getPackageName())).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.soundcloud.android.crop.CropImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) throws java.lang.Throwable {
                com.soundcloud.android.crop.CropImageActivity.this.onSaveClicked();
            }
        });
    }

    @android.annotation.TargetApi(19)
    private void setupWindowFlags() {
        requestWindowFeature(1);
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            getWindow().clearFlags(oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_QRPUSH);
        }
    }

    private void startCrop() {
        if (isFinishing()) {
            return;
        }
        this.imageView.setImageRotateBitmapResetBase(this.rotateBitmap, true);
        com.soundcloud.android.crop.CropUtil.startBackgroundJob(this, null, getResources().getString(getApplicationContext().getResources().getIdentifier("crop__wait", "string", getApplicationContext().getPackageName())), new java.lang.Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
                com.soundcloud.android.crop.CropImageActivity.this.handler.post(new java.lang.Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.soundcloud.android.crop.CropImageActivity.this.imageView.getScale() == 1.0f) {
                            com.soundcloud.android.crop.CropImageActivity.this.imageView.center();
                        }
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await();
                    new com.soundcloud.android.crop.CropImageActivity.Cropper().crop();
                } catch (java.lang.InterruptedException e) {
                    throw new java.lang.RuntimeException(e);
                }
            }
        }, this.handler);
    }

    @Override // com.soundcloud.android.crop.MonitoredActivity
    public /* bridge */ /* synthetic */ void addLifeCycleListener(com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener lifeCycleListener) {
        super.addLifeCycleListener(lifeCycleListener);
    }

    public boolean isSaving() {
        return this.isSaving;
    }

    @Override // com.soundcloud.android.crop.MonitoredActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) throws java.lang.Throwable {
        super.onCreate(bundle);
        setupWindowFlags();
        setupViews();
        loadInput();
        if (this.rotateBitmap == null) {
            finish();
        } else {
            startCrop();
        }
    }

    @Override // com.soundcloud.android.crop.MonitoredActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.soundcloud.android.crop.RotateBitmap rotateBitmap = this.rotateBitmap;
        if (rotateBitmap != null) {
            rotateBitmap.recycle();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return false;
    }

    @Override // com.soundcloud.android.crop.MonitoredActivity
    public /* bridge */ /* synthetic */ void removeLifeCycleListener(com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener lifeCycleListener) {
        super.removeLifeCycleListener(lifeCycleListener);
    }
}
