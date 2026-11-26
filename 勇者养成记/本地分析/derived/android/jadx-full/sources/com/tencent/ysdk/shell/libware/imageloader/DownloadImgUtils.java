package com.tencent.ysdk.shell.libware.imageloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DownloadImgUtils {
    /* JADX WARN: Code duplicated, block: B:24:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static android.graphics.Bitmap downloadImgByUrl(java.lang.String str, android.widget.ImageView imageView) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.InputStream inputStream = null;
        try {
            try {
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                bufferedInputStream = new java.io.BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    bufferedInputStream.mark(bufferedInputStream.available());
                    android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    com.tencent.ysdk.shell.libware.imageloader.ImageSizeUtil.ImageSize imageViewSize = com.tencent.ysdk.shell.libware.imageloader.ImageSizeUtil.getImageViewSize(imageView);
                    options.inSampleSize = com.tencent.ysdk.shell.libware.imageloader.ImageSizeUtil.caculateInSampleSize(options, imageViewSize.width, imageViewSize.height);
                    options.inJustDecodeBounds = false;
                    bufferedInputStream.reset();
                    android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    httpURLConnection.disconnect();
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                    return bitmapDecodeStream;
                } catch (java.lang.Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            bufferedInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (0 != 0) {
                inputStream.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:? A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean downloadImgByUrl(java.lang.String str, java.io.File file) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        java.io.InputStream inputStream2 = null;
        try {
            inputStream = ((java.net.HttpURLConnection) new java.net.URL(str).openConnection()).getInputStream();
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
                try {
                    byte[] bArr = new byte[512];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                    fileOutputStream.flush();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException unused2) {
                    }
                    return true;
                } catch (java.lang.Exception e) {
                    e = e;
                    inputStream2 = inputStream;
                    try {
                        e.printStackTrace();
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException unused4) {
                            }
                        }
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        fileOutputStream2 = fileOutputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException unused5) {
                            }
                        }
                        if (fileOutputStream2 == null) {
                            throw th;
                        }
                        try {
                            fileOutputStream2.close();
                            throw th;
                        } catch (java.io.IOException unused6) {
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream2 == null) {
                        throw th;
                    }
                    fileOutputStream2.close();
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream2 == null) {
                    throw th;
                }
                fileOutputStream2.close();
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }
}
