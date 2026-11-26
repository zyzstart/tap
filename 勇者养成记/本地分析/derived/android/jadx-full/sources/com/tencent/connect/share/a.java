package com.tencent.connect.share;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    public static final int a(android.graphics.BitmapFactory.Options options, int i, int i2) {
        int iB = b(options, i, i2);
        if (iB > 8) {
            return ((iB + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < iB) {
            i3 <<= 1;
        }
        return i3;
    }

    private static android.graphics.Bitmap a(android.graphics.Bitmap bitmap, int i) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = i / width;
        matrix.postScale(f, f);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static final android.graphics.Bitmap a(java.lang.String str, int i) {
        java.lang.String str2;
        java.lang.String str3;
        android.graphics.Bitmap bitmapDecodeFile;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            android.graphics.BitmapFactory.decodeFile(str, options);
        } catch (java.lang.OutOfMemoryError e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception1:", e);
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (options.mCancel || i2 == -1 || i3 == -1) {
            return null;
        }
        if (i2 <= i3) {
            i2 = i3;
        }
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        if (i2 > i) {
            options.inSampleSize = a(options, -1, i * i);
        }
        options.inJustDecodeBounds = false;
        try {
            bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(str, options);
        } catch (java.lang.Exception e2) {
            e = e2;
            str2 = "openSDK_LOG.AsynScaleCompressImage";
            str3 = "scaleBitmap exception2:";
            com.tencent.open.log.SLog.e(str2, str3, e);
            bitmapDecodeFile = null;
        } catch (java.lang.OutOfMemoryError e3) {
            e = e3;
            str2 = "openSDK_LOG.AsynScaleCompressImage";
            str3 = "scaleBitmap OutOfMemoryError:";
            com.tencent.open.log.SLog.e(str2, str3, e);
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap return null");
            return null;
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i4 > i5) {
            i5 = i4;
        }
        return i5 > i ? a(bitmapDecodeFile, i) : bitmapDecodeFile;
    }

    protected static final java.lang.String a(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
        stringBuffer.append(str2);
        java.lang.String string = stringBuffer.toString();
        java.io.File file2 = new java.io.File(string);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap == null) {
            return null;
        }
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            return string;
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static final void a(final android.content.Context context, final java.lang.String str, final com.tencent.open.utils.d dVar) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (android.text.TextUtils.isEmpty(str)) {
            dVar.a(1, (java.lang.String) null);
        } else if (!com.tencent.open.utils.l.a()) {
            dVar.a(2, (java.lang.String) null);
        } else {
            final android.os.Handler handler = new android.os.Handler(context.getMainLooper()) { // from class: com.tencent.connect.share.a.1
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    int i = message.what;
                    if (i == 101) {
                        dVar.a(0, (java.util.ArrayList) message.obj);
                    } else if (i != 102) {
                        super.handleMessage(message);
                    } else {
                        dVar.a(message.arg1, (java.lang.String) null);
                    }
                }
            };
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.connect.share.a.2
                /* JADX WARN: Code duplicated, block: B:26:0x00ec  */
                /* JADX WARN: Code duplicated, block: B:27:0x00ee A[Catch: Exception -> 0x0181, TryCatch #0 {Exception -> 0x0181, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0015, B:15:0x0089, B:17:0x00af, B:22:0x00ca, B:24:0x00d0, B:35:0x012b, B:37:0x0137, B:39:0x013f, B:41:0x0145, B:43:0x016a, B:27:0x00ee, B:29:0x00f4, B:31:0x010b, B:18:0x00b7, B:8:0x0036, B:10:0x003c, B:12:0x0051, B:14:0x0072), top: B:49:0x0002 }] */
                /* JADX WARN: Code duplicated, block: B:29:0x00f4 A[Catch: Exception -> 0x0181, TRY_LEAVE, TryCatch #0 {Exception -> 0x0181, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0015, B:15:0x0089, B:17:0x00af, B:22:0x00ca, B:24:0x00d0, B:35:0x012b, B:37:0x0137, B:39:0x013f, B:41:0x0145, B:43:0x016a, B:27:0x00ee, B:29:0x00f4, B:31:0x010b, B:18:0x00b7, B:8:0x0036, B:10:0x003c, B:12:0x0051, B:14:0x0072), top: B:49:0x0002 }] */
                /* JADX WARN: Code duplicated, block: B:33:0x0129  */
                /* JADX WARN: Code duplicated, block: B:34:0x012a  */
                /* JADX WARN: Instruction removed from duplicated block: B:29:0x00f4, please report this as an issue */
                @Override // java.lang.Runnable
                public void run() {
                    java.lang.String str2;
                    java.lang.String str3;
                    java.lang.String strA;
                    boolean zN;
                    java.util.ArrayList arrayList;
                    java.lang.String str4;
                    boolean zA;
                    try {
                        android.graphics.Bitmap bitmapA = com.tencent.connect.share.a.a(str, 840);
                        if (bitmapA != null) {
                            java.io.File fileA = com.tencent.open.utils.f.a("Images");
                            if (fileA != null) {
                                str3 = fileA.getAbsolutePath() + java.io.File.separator + com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR + java.io.File.separator;
                                str2 = null;
                            } else {
                                java.io.File fileD = com.tencent.open.utils.f.d();
                                if (fileD == null) {
                                    com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                                    android.os.Message messageObtainMessage = handler.obtainMessage();
                                    messageObtainMessage.arg1 = 102;
                                    handler.sendMessage(messageObtainMessage);
                                    return;
                                }
                                java.lang.String absolutePath = fileD.getAbsolutePath();
                                java.lang.String str5 = absolutePath + java.io.File.separator + com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR + java.io.File.separator;
                                com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + str5);
                                str2 = absolutePath;
                                str3 = str5;
                            }
                            java.lang.String str6 = "share2qq_temp" + com.tencent.open.utils.l.f(str) + ".jpg";
                            java.lang.String str7 = str;
                            if (com.tencent.connect.share.a.b(str, 840, 840)) {
                                com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                                strA = com.tencent.connect.share.a.a(bitmapA, str3, str6);
                                if (!android.text.TextUtils.isEmpty(strA)) {
                                }
                                zN = com.tencent.open.utils.l.n(strA);
                                com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + zN);
                                arrayList = new java.util.ArrayList(2);
                                if (zN) {
                                    str4 = strA;
                                } else if (android.text.TextUtils.isEmpty(str2)) {
                                    str4 = str3 + str6;
                                    zA = com.tencent.open.utils.l.a(context, strA, str4);
                                    com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str4 + ",isSuccess=" + zA);
                                    if (zA) {
                                        str4 = null;
                                    }
                                } else {
                                    str4 = null;
                                }
                                arrayList.add(strA);
                                arrayList.add(str4);
                                if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                                    com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((java.lang.String) arrayList.get(0)) + "," + ((java.lang.String) arrayList.get(1)) + "]");
                                    android.os.Message messageObtainMessage2 = handler.obtainMessage(101);
                                    messageObtainMessage2.obj = arrayList;
                                    handler.sendMessage(messageObtainMessage2);
                                    return;
                                }
                            } else {
                                com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                            }
                            strA = str7;
                            zN = com.tencent.open.utils.l.n(strA);
                            com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + zN);
                            arrayList = new java.util.ArrayList(2);
                            if (zN) {
                                str4 = strA;
                            } else if (android.text.TextUtils.isEmpty(str2)) {
                                str4 = str3 + str6;
                                zA = com.tencent.open.utils.l.a(context, strA, str4);
                                com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str4 + ",isSuccess=" + zA);
                                if (zA) {
                                    str4 = null;
                                }
                            } else {
                                str4 = null;
                            }
                            arrayList.add(strA);
                            arrayList.add(str4);
                            if (arrayList.size() >= 2) {
                                com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((java.lang.String) arrayList.get(0)) + "," + ((java.lang.String) arrayList.get(1)) + "]");
                                android.os.Message messageObtainMessage3 = handler.obtainMessage(101);
                                messageObtainMessage3.obj = arrayList;
                                handler.sendMessage(messageObtainMessage3);
                                return;
                            }
                        }
                    } catch (java.lang.Exception e) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e);
                    }
                    com.tencent.open.log.SLog.d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
                    android.os.Message messageObtainMessage4 = handler.obtainMessage(102);
                    messageObtainMessage4.arg1 = 3;
                    handler.sendMessage(messageObtainMessage4);
                }
            }).start();
        }
    }

    private static int b(android.graphics.BitmapFactory.Options options, int i, int i2) {
        int iCeil;
        int iMin;
        double d = options.outWidth;
        double d2 = options.outHeight;
        if (i2 == -1) {
            iCeil = 1;
        } else {
            java.lang.Double.isNaN(d);
            java.lang.Double.isNaN(d2);
            double d3 = i2;
            java.lang.Double.isNaN(d3);
            iCeil = (int) java.lang.Math.ceil(java.lang.Math.sqrt((d * d2) / d3));
        }
        if (i == -1) {
            iMin = 128;
        } else {
            double d4 = i;
            java.lang.Double.isNaN(d);
            java.lang.Double.isNaN(d4);
            double dFloor = java.lang.Math.floor(d / d4);
            java.lang.Double.isNaN(d2);
            java.lang.Double.isNaN(d4);
            iMin = (int) java.lang.Math.min(dFloor, java.lang.Math.floor(d2 / d4));
        }
        if (iMin < iCeil) {
            return iCeil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? iCeil : iMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(java.lang.String str, int i, int i2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            android.graphics.BitmapFactory.decodeFile(str, options);
        } catch (java.lang.OutOfMemoryError e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e);
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || i3 == -1 || i4 == -1) {
            return false;
        }
        int i5 = i3 > i4 ? i3 : i4;
        if (i3 >= i4) {
            i3 = i4;
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i5 + "shortSide=" + i3);
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        return i5 > i2 || i3 > i;
    }
}
