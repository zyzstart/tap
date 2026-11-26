package com.tencent.ysdk.shell.module.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PicLoadManager {
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> cache = new java.util.concurrent.ConcurrentHashMap<>();

    public interface PicLoadListener {
        void onError();

        void onSuccess();
    }

    public static void asyncCacheImage(final java.lang.String str, final com.tencent.ysdk.shell.module.ad.PicLoadManager.PicLoadListener picLoadListener) {
        if (!android.text.TextUtils.isEmpty(str)) {
            new android.os.AsyncTask() { // from class: com.tencent.ysdk.shell.module.ad.PicLoadManager.2
                @Override // android.os.AsyncTask
                protected java.lang.Object doInBackground(java.lang.Object[] objArr) {
                    try {
                        return com.tencent.ysdk.shell.module.ad.PicLoadManager.loadFromMemoryCache(str);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        com.tencent.ysdk.shell.module.ad.PicLoadManager.PicLoadListener picLoadListener2 = picLoadListener;
                        if (picLoadListener2 != null) {
                            picLoadListener2.onError();
                        }
                        return null;
                    }
                }

                @Override // android.os.AsyncTask
                protected void onPostExecute(java.lang.Object obj) {
                    super.onPostExecute(obj);
                    if (obj != null && (obj instanceof android.graphics.Bitmap)) {
                        com.tencent.ysdk.libware.file.Logger.d("Image cached: " + str);
                        com.tencent.ysdk.shell.module.ad.PicLoadManager.PicLoadListener picLoadListener2 = picLoadListener;
                        if (picLoadListener2 != null) {
                            picLoadListener2.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.tencent.ysdk.libware.file.Logger.e("Image can`t be load");
                    com.tencent.ysdk.libware.file.Logger.e("Url:" + str);
                    com.tencent.ysdk.shell.module.ad.PicLoadManager.PicLoadListener picLoadListener3 = picLoadListener;
                    if (picLoadListener3 != null) {
                        picLoadListener3.onError();
                    }
                }

                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    super.onPreExecute();
                    com.tencent.ysdk.libware.file.Logger.d("Image cache: " + str);
                }
            }.execute(new java.lang.Object[0]);
            return;
        }
        com.tencent.ysdk.libware.file.Logger.d("Image url is empty");
        if (picLoadListener != null) {
            picLoadListener.onError();
        }
    }

    public static void asyncLoadImage(final java.lang.String str, final android.widget.ImageView imageView, final com.tencent.ysdk.shell.module.ad.PicLoadManager.PicLoadListener picLoadListener) {
        if (!android.text.TextUtils.isEmpty(str)) {
            new android.os.AsyncTask() { // from class: com.tencent.ysdk.shell.module.ad.PicLoadManager.1
                @Override // android.os.AsyncTask
                protected java.lang.Object doInBackground(java.lang.Object[] objArr) {
                    try {
                        return com.tencent.ysdk.shell.module.ad.PicLoadManager.loadFromMemoryCache(str);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        com.tencent.ysdk.shell.module.ad.PicLoadManager.PicLoadListener picLoadListener2 = picLoadListener;
                        if (picLoadListener2 != null) {
                            picLoadListener2.onError();
                        }
                        return null;
                    }
                }

                @Override // android.os.AsyncTask
                protected void onPostExecute(java.lang.Object obj) {
                    super.onPostExecute(obj);
                    if (obj != null) {
                        try {
                            if (obj instanceof android.graphics.Bitmap) {
                                imageView.setImageBitmap((android.graphics.Bitmap) obj);
                                if (picLoadListener != null) {
                                    picLoadListener.onSuccess();
                                    return;
                                }
                                return;
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (picLoadListener != null) {
                        picLoadListener.onError();
                    }
                    com.tencent.ysdk.libware.file.Logger.e("Image can`t be load");
                    com.tencent.ysdk.libware.file.Logger.e("Url:" + str);
                }
            }.execute(new java.lang.Object[0]);
            return;
        }
        com.tencent.ysdk.libware.file.Logger.d("Image url is empty");
        if (picLoadListener != null) {
            picLoadListener.onError();
        }
    }

    private static int calculateInSampleSize(android.graphics.BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private static android.graphics.Bitmap createScaleBitmap(android.graphics.Bitmap bitmap, int i, int i2, int i3) {
        android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmap, i, i2, false);
        if (bitmap != bitmapCreateScaledBitmap) {
            bitmap.recycle();
        }
        return bitmapCreateScaledBitmap;
    }

    private static android.graphics.Bitmap decodeSampledBitmapFromFile(java.io.File file) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        return android.graphics.BitmapFactory.decodeFile(file.getPath(), options);
    }

    private static android.graphics.Bitmap file2Bitmap(java.io.File file) {
        if (file == null) {
            return null;
        }
        return decodeSampledBitmapFromFile(file);
    }

    private static java.io.File loadFromFileCache(java.lang.String str) {
        java.io.File file = new java.io.File(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getCacheDir().toString(), com.tencent.ysdk.shell.libware.encrypt.MD5.toMD5(str));
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            try {
                java.io.InputStream inputStream = new java.net.URL(str).openConnection().getInputStream();
                byte[] bArr = new byte[1024];
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.graphics.Bitmap loadFromMemoryCache(java.lang.String str) {
        java.lang.ref.SoftReference<android.graphics.Bitmap> softReference = cache.get(str);
        android.graphics.Bitmap bitmapFile2Bitmap = softReference != null ? softReference.get() : null;
        if (bitmapFile2Bitmap == null && (bitmapFile2Bitmap = file2Bitmap(loadFromFileCache(str))) != null) {
            cache.put(str, new java.lang.ref.SoftReference<>(bitmapFile2Bitmap));
        }
        return bitmapFile2Bitmap;
    }
}
