package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    private static java.lang.String c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f720a;
    private com.tencent.open.utils.d b;
    private long d;
    private android.os.Handler e;
    private java.lang.ref.WeakReference f;
    private java.lang.Runnable g = new java.lang.Runnable() { // from class: com.tencent.open.utils.c.2
        @Override // java.lang.Runnable
        public void run() throws java.lang.Throwable {
            boolean zA;
            java.lang.StringBuilder sb;
            java.lang.String str;
            com.tencent.open.log.SLog.v("AsynLoadImg", "saveFileRunnable:");
            java.lang.String str2 = "share_qq_" + com.tencent.open.utils.l.f(com.tencent.open.utils.c.this.f720a) + ".jpg";
            java.lang.String str3 = com.tencent.open.utils.c.c + str2;
            java.io.File file = new java.io.File(str3);
            android.os.Message messageObtainMessage = com.tencent.open.utils.c.this.e.obtainMessage();
            if (file.exists()) {
                messageObtainMessage.arg1 = 0;
                messageObtainMessage.obj = str3;
                sb = new java.lang.StringBuilder();
                str = "file exists: time:";
            } else {
                android.graphics.Bitmap bitmapA = com.tencent.open.utils.c.a(com.tencent.open.utils.c.this.f720a);
                if (bitmapA != null) {
                    zA = com.tencent.open.utils.c.this.a(bitmapA, str2);
                } else {
                    com.tencent.open.log.SLog.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    zA = false;
                }
                if (zA) {
                    messageObtainMessage.arg1 = 0;
                    messageObtainMessage.obj = str3;
                } else {
                    messageObtainMessage.arg1 = 1;
                }
                sb = new java.lang.StringBuilder();
                str = "file not exists: download time:";
            }
            sb.append(str);
            sb.append(java.lang.System.currentTimeMillis() - com.tencent.open.utils.c.this.d);
            com.tencent.open.log.SLog.v("AsynLoadImg", sb.toString());
            com.tencent.open.utils.c.this.e.sendMessage(messageObtainMessage);
        }
    };

    public c(android.app.Activity activity) {
        this.f = new java.lang.ref.WeakReference(activity);
        this.e = new android.os.Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.c.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                com.tencent.open.log.SLog.v("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    com.tencent.open.utils.c.this.b.a(message.arg1, (java.lang.String) message.obj);
                } else {
                    com.tencent.open.utils.c.this.b.a(message.arg1, (java.lang.String) null);
                }
            }
        };
    }

    public static android.graphics.Bitmap a(java.lang.String str) {
        com.tencent.open.log.SLog.v("AsynLoadImg", "getbitmap:" + str);
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            java.io.InputStream inputStream = httpURLConnection.getInputStream();
            android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            com.tencent.open.log.SLog.v("AsynLoadImg", "image download finished." + str);
            return bitmapDecodeStream;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            com.tencent.open.log.SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
            com.tencent.open.log.SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }

    public void a(java.lang.String str, com.tencent.open.utils.d dVar) {
        com.tencent.open.log.SLog.v("AsynLoadImg", "--save---");
        if (str == null || str.equals("")) {
            dVar.a(1, (java.lang.String) null);
            return;
        }
        if (!com.tencent.open.utils.l.a()) {
            dVar.a(2, (java.lang.String) null);
            return;
        }
        if (this.f.get() != null) {
            android.app.Activity activity = (android.app.Activity) this.f.get();
            java.io.File fileH = com.tencent.open.utils.l.h(activity, "Images");
            java.io.File externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
            if (fileH == null) {
                com.tencent.open.log.SLog.e("AsynLoadImg", "externalImageFile is null");
                dVar.a(2, (java.lang.String) null);
                return;
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.tencent.open.utils.i.c(activity) ? fileH.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                sb.append("/tmp/");
                c = sb.toString();
            }
        }
        this.d = java.lang.System.currentTimeMillis();
        this.f720a = str;
        this.b = dVar;
        new java.lang.Thread(this.g).start();
    }

    public boolean a(android.graphics.Bitmap bitmap, java.lang.String str) throws java.lang.Throwable {
        java.lang.String str2 = c;
        java.io.BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                java.io.File file = new java.io.File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                java.lang.String str3 = str2 + str;
                com.tencent.open.log.SLog.v("AsynLoadImg", "saveFile:" + str);
                java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(str3)));
                try {
                    bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    com.tencent.open.log.SLog.e("AsynLoadImg", "saveFile bmp fail---", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e5) {
            e = e5;
        }
    }
}
