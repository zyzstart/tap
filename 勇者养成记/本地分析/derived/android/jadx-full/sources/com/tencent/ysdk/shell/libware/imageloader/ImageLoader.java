package com.tencent.ysdk.shell.libware.imageloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ImageLoader {
    private static final int DEAFULT_THREAD_COUNT = 1;
    private static final java.lang.String TAG = "ImageLoader";
    private static com.tencent.ysdk.shell.libware.imageloader.ImageLoader mInstance;
    private com.tencent.ysdk.shell.libware.imageloader.LruCache<java.lang.String, android.graphics.Bitmap> mLruCache;
    private java.lang.Thread mPoolThread;
    private android.os.Handler mPoolThreadHandler;
    private java.util.concurrent.Semaphore mSemaphoreThreadPool;
    private java.util.LinkedList<java.lang.Runnable> mTaskQueue;
    private java.util.concurrent.ExecutorService mThreadPool;
    private android.os.Handler mUIHandler;
    private com.tencent.ysdk.shell.libware.imageloader.ImageLoader.Type mType = com.tencent.ysdk.shell.libware.imageloader.ImageLoader.Type.LIFO;
    private java.util.concurrent.Semaphore mSemaphorePoolThreadHandler = new java.util.concurrent.Semaphore(0);
    private boolean isDiskCacheEnable = true;

    private class ImgBeanHolder {
        android.graphics.Bitmap bitmap;
        android.widget.ImageView imageView;
        java.lang.String path;

        private ImgBeanHolder() {
        }
    }

    public enum Type {
        FIFO,
        LIFO
    }

    private ImageLoader(int i, com.tencent.ysdk.shell.libware.imageloader.ImageLoader.Type type) {
        init(i, type);
    }

    private synchronized void addTask(java.lang.Runnable runnable) {
        this.mTaskQueue.add(runnable);
        try {
            if (this.mPoolThreadHandler == null) {
                this.mSemaphorePoolThreadHandler.acquire();
            }
        } catch (java.lang.InterruptedException unused) {
        }
        this.mPoolThreadHandler.sendEmptyMessage(272);
    }

    private java.lang.Runnable buildTask(final java.lang.String str, final android.widget.ImageView imageView, final boolean z) {
        return new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.libware.imageloader.ImageLoader.4
            @Override // java.lang.Runnable
            public void run() throws java.lang.Throwable {
                android.graphics.Bitmap bitmapLoadImageFromLocal;
                if (z) {
                    java.io.File diskCacheDir = com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.getDiskCacheDir(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.md5(str));
                    if (diskCacheDir.exists()) {
                        android.util.Log.e(com.tencent.ysdk.shell.libware.imageloader.ImageLoader.TAG, "find image :" + str + " in disk cache .");
                        bitmapLoadImageFromLocal = com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.loadImageFromLocal(diskCacheDir.getAbsolutePath(), imageView);
                    } else if (!com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.isDiskCacheEnable) {
                        android.util.Log.e(com.tencent.ysdk.shell.libware.imageloader.ImageLoader.TAG, "load image :" + str + " to memory.");
                        bitmapLoadImageFromLocal = com.tencent.ysdk.shell.libware.imageloader.DownloadImgUtils.downloadImgByUrl(str, imageView);
                    } else if (com.tencent.ysdk.shell.libware.imageloader.DownloadImgUtils.downloadImgByUrl(str, diskCacheDir)) {
                        android.util.Log.e(com.tencent.ysdk.shell.libware.imageloader.ImageLoader.TAG, "download image :" + str + " to disk cache . path is " + diskCacheDir.getAbsolutePath());
                        bitmapLoadImageFromLocal = com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.loadImageFromLocal(diskCacheDir.getAbsolutePath(), imageView);
                    } else {
                        bitmapLoadImageFromLocal = null;
                    }
                } else {
                    bitmapLoadImageFromLocal = com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.loadImageFromLocal(str, imageView);
                }
                com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.addBitmapToLruCache(str, bitmapLoadImageFromLocal);
                com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.refreashBitmap(str, imageView, bitmapLoadImageFromLocal);
                com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.mSemaphoreThreadPool.release();
            }
        };
    }

    private android.graphics.Bitmap getBitmapFromLruCache(java.lang.String str) {
        return this.mLruCache.get(str);
    }

    public static com.tencent.ysdk.shell.libware.imageloader.ImageLoader getInstance() {
        if (mInstance == null) {
            synchronized (com.tencent.ysdk.shell.libware.imageloader.ImageLoader.class) {
                if (mInstance == null) {
                    mInstance = new com.tencent.ysdk.shell.libware.imageloader.ImageLoader(1, com.tencent.ysdk.shell.libware.imageloader.ImageLoader.Type.LIFO);
                }
            }
        }
        return mInstance;
    }

    public static com.tencent.ysdk.shell.libware.imageloader.ImageLoader getInstance(int i, com.tencent.ysdk.shell.libware.imageloader.ImageLoader.Type type) {
        if (mInstance == null) {
            synchronized (com.tencent.ysdk.shell.libware.imageloader.ImageLoader.class) {
                if (mInstance == null) {
                    mInstance = new com.tencent.ysdk.shell.libware.imageloader.ImageLoader(i, type);
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.Runnable getTask() {
        if (this.mType == com.tencent.ysdk.shell.libware.imageloader.ImageLoader.Type.FIFO) {
            return this.mTaskQueue.removeFirst();
        }
        if (this.mType == com.tencent.ysdk.shell.libware.imageloader.ImageLoader.Type.LIFO) {
            return this.mTaskQueue.removeLast();
        }
        return null;
    }

    private void init(int i, com.tencent.ysdk.shell.libware.imageloader.ImageLoader.Type type) {
        initBackThread();
        this.mLruCache = new com.tencent.ysdk.shell.libware.imageloader.LruCache<java.lang.String, android.graphics.Bitmap>(((int) java.lang.Runtime.getRuntime().maxMemory()) / 8) { // from class: com.tencent.ysdk.shell.libware.imageloader.ImageLoader.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.ysdk.shell.libware.imageloader.LruCache
            public int sizeOf(java.lang.String str, android.graphics.Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
        this.mThreadPool = java.util.concurrent.Executors.newFixedThreadPool(i);
        this.mTaskQueue = new java.util.LinkedList<>();
        this.mType = type;
        this.mSemaphoreThreadPool = new java.util.concurrent.Semaphore(i);
    }

    private void initBackThread() {
        this.mPoolThread = new java.lang.Thread() { // from class: com.tencent.ysdk.shell.libware.imageloader.ImageLoader.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                android.os.Looper.prepare();
                com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.mPoolThreadHandler = new android.os.Handler() { // from class: com.tencent.ysdk.shell.libware.imageloader.ImageLoader.2.1
                    @Override // android.os.Handler
                    public void handleMessage(android.os.Message message) {
                        com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.mThreadPool.execute(com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.getTask());
                        try {
                            com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.mSemaphoreThreadPool.acquire();
                        } catch (java.lang.InterruptedException unused) {
                        }
                    }
                };
                com.tencent.ysdk.shell.libware.imageloader.ImageLoader.this.mSemaphorePoolThreadHandler.release();
                android.os.Looper.loop();
            }
        };
        this.mPoolThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.Bitmap loadImageFromLocal(java.lang.String str, android.widget.ImageView imageView) {
        com.tencent.ysdk.shell.libware.imageloader.ImageSizeUtil.ImageSize imageViewSize = com.tencent.ysdk.shell.libware.imageloader.ImageSizeUtil.getImageViewSize(imageView);
        return decodeSampledBitmapFromPath(str, imageViewSize.width, imageViewSize.height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreashBitmap(java.lang.String str, android.widget.ImageView imageView, android.graphics.Bitmap bitmap) {
        com.tencent.ysdk.shell.libware.imageloader.ImageLoader.ImgBeanHolder imgBeanHolder = new com.tencent.ysdk.shell.libware.imageloader.ImageLoader.ImgBeanHolder();
        imgBeanHolder.bitmap = bitmap;
        imgBeanHolder.path = str;
        imgBeanHolder.imageView = imageView;
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.obj = imgBeanHolder;
        this.mUIHandler.sendMessage(messageObtain);
    }

    protected void addBitmapToLruCache(java.lang.String str, android.graphics.Bitmap bitmap) {
        if (getBitmapFromLruCache(str) != null || bitmap == null) {
            return;
        }
        this.mLruCache.put(str, bitmap);
    }

    public java.lang.String bytes2hex02(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public void cacheImage(java.lang.String str, boolean z) {
    }

    protected android.graphics.Bitmap decodeSampledBitmapFromPath(java.lang.String str, int i, int i2) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(str, options);
        options.inSampleSize = com.tencent.ysdk.shell.libware.imageloader.ImageSizeUtil.caculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return android.graphics.BitmapFactory.decodeFile(str, options);
    }

    public java.io.File getDiskCacheDir(android.content.Context context, java.lang.String str) {
        return new java.io.File(("mounted".equals(android.os.Environment.getExternalStorageState()) ? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath()) + java.io.File.separator + str);
    }

    public void loadImage(java.lang.String str, android.widget.ImageView imageView, boolean z) {
        if (imageView != null) {
            com.tencent.ysdk.shell.libware.file.Logger.d("Load Image by URL:" + str);
            imageView.setTag(str);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d("Cache Image by URL:" + str);
            imageView = new android.widget.ImageView(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
            android.view.ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            imageView.setLayoutParams(layoutParams);
        }
        if (this.mUIHandler == null) {
            this.mUIHandler = new android.os.Handler() { // from class: com.tencent.ysdk.shell.libware.imageloader.ImageLoader.3
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    com.tencent.ysdk.shell.libware.imageloader.ImageLoader.ImgBeanHolder imgBeanHolder = (com.tencent.ysdk.shell.libware.imageloader.ImageLoader.ImgBeanHolder) message.obj;
                    android.graphics.Bitmap bitmap = imgBeanHolder.bitmap;
                    android.widget.ImageView imageView2 = imgBeanHolder.imageView;
                    if (imageView2.getTag().toString().equals(imgBeanHolder.path)) {
                        imageView2.setImageBitmap(bitmap);
                    }
                }
            };
        }
        android.graphics.Bitmap bitmapFromLruCache = getBitmapFromLruCache(str);
        if (bitmapFromLruCache != null) {
            refreashBitmap(str, imageView, bitmapFromLruCache);
        } else {
            addTask(buildTask(str, imageView, z));
        }
    }

    public java.lang.String md5(java.lang.String str) {
        try {
            return bytes2hex02(java.security.MessageDigest.getInstance("md5").digest(str.getBytes()));
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
