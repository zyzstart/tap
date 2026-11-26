package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    private static dalvik.system.DexClassLoader b;
    private static android.os.Looper c;
    private static com.tencent.smtt.utils.d d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f961a;

    public interface a {
        void a();

        void a(int i);

        void a(java.lang.Throwable th);
    }

    private d(android.content.Context context) {
        this.f961a = "";
        this.f961a = context.getDir("debugtbs", 0).getAbsolutePath() + java.io.File.separator + "plugin";
    }

    public static com.tencent.smtt.utils.d a(android.content.Context context) {
        if (d == null) {
            d = new com.tencent.smtt.utils.d(context);
        }
        return d;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void a(final java.lang.String str, final com.tencent.smtt.utils.d.a aVar) {
        new java.lang.Thread() { // from class: com.tencent.smtt.utils.d.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws java.lang.Throwable {
                java.io.FileOutputStream fileOutputStream;
                java.io.InputStream inputStream = null;
                fileOutputStreamD = null;
                java.io.FileOutputStream fileOutputStreamD = null;
                inputStream = null;
                try {
                    try {
                        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL("http://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs").openConnection();
                        int contentLength = httpURLConnection.getContentLength();
                        httpURLConnection.setConnectTimeout(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
                        httpURLConnection.connect();
                        java.io.InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            fileOutputStreamD = com.tencent.smtt.utils.f.d(new java.io.File(str));
                            byte[] bArr = new byte[8192];
                            int i = 0;
                            while (true) {
                                int i2 = inputStream2.read(bArr);
                                if (i2 <= 0) {
                                    break;
                                }
                                i += i2;
                                fileOutputStreamD.write(bArr, 0, i2);
                                aVar.a((i * 100) / contentLength);
                            }
                            aVar.a();
                            try {
                                inputStream2.close();
                            } catch (java.lang.Exception e) {
                                e.printStackTrace();
                            }
                            fileOutputStreamD.close();
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStreamD;
                            inputStream = inputStream2;
                            try {
                                e.printStackTrace();
                                aVar.a(e);
                                try {
                                    inputStream.close();
                                } catch (java.lang.Exception e3) {
                                    e3.printStackTrace();
                                }
                                fileOutputStream.close();
                            } catch (java.lang.Throwable th) {
                                th = th;
                                try {
                                    inputStream.close();
                                } catch (java.lang.Exception e4) {
                                    e4.printStackTrace();
                                }
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (java.lang.Exception e5) {
                                    e5.printStackTrace();
                                    throw th;
                                }
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStreamD;
                            inputStream = inputStream2;
                            inputStream.close();
                            fileOutputStream.close();
                            throw th;
                        }
                    } catch (java.lang.Exception e6) {
                        e6.printStackTrace();
                    }
                } catch (java.lang.Exception e7) {
                    e = e7;
                    fileOutputStream = null;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            }
        }.start();
    }

    public void a(final java.lang.String str, final com.tencent.smtt.sdk.WebView webView, final android.content.Context context) {
        final android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(context);
        final android.widget.TextView textView = new android.widget.TextView(context);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setText("加载中，请稍后...");
        relativeLayout.addView(textView, layoutParams);
        webView.addView(relativeLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
        java.lang.String str2 = this.f961a + java.io.File.separator + "DebugPlugin.tbs";
        com.tencent.smtt.utils.f.b(new java.io.File(str2));
        a(str2, new com.tencent.smtt.utils.d.a() { // from class: com.tencent.smtt.utils.d.1
            @Override // com.tencent.smtt.utils.d.a
            public void a() {
                webView.post(new java.lang.Runnable() { // from class: com.tencent.smtt.utils.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.widget.Toast.makeText(context, "下载成功", 0).show();
                        relativeLayout.setVisibility(4);
                        com.tencent.smtt.utils.d.AnonymousClass1 anonymousClass1 = com.tencent.smtt.utils.d.AnonymousClass1.this;
                        com.tencent.smtt.utils.d.this.a(str, webView, context, com.tencent.smtt.utils.d.c);
                    }
                });
            }

            @Override // com.tencent.smtt.utils.d.a
            public void a(final int i) {
                webView.post(new java.lang.Runnable() { // from class: com.tencent.smtt.utils.d.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        textView.setText("已下载" + i + "%");
                    }
                });
            }

            @Override // com.tencent.smtt.utils.d.a
            public void a(java.lang.Throwable th) {
                webView.post(new java.lang.Runnable() { // from class: com.tencent.smtt.utils.d.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        android.widget.Toast.makeText(context, "下载失败，请检查网络", 0).show();
                    }
                });
            }
        });
    }

    @android.annotation.SuppressLint({"NewApi"})
    public void a(java.lang.String str, com.tencent.smtt.sdk.WebView webView, android.content.Context context, android.os.Looper looper) {
        com.tencent.smtt.utils.TbsLog.i("debugtbs", "showPluginView -- url: " + str + "; webview: " + webView + "; context: " + context);
        java.lang.String str2 = this.f961a + java.io.File.separator + "DebugPlugin.tbs";
        java.lang.String str3 = this.f961a + java.io.File.separator + "DebugPlugin.apk";
        java.io.File file = new java.io.File(str2);
        java.io.File file2 = new java.io.File(str3);
        c = looper;
        if (file.exists()) {
            file2.delete();
            file.renameTo(file2);
        }
        if (!file2.exists()) {
            com.tencent.smtt.utils.TbsLog.i("debugtbs", "showPluginView - going to download plugin...");
            a(str, webView, context);
            return;
        }
        try {
            java.lang.String strA = com.tencent.smtt.utils.b.a(context, true, new java.io.File(str3));
            if (!"[REDACTED_HEX_CONSTANT]".equals(strA)) {
                com.tencent.smtt.utils.TbsLog.e("debugtbs", "verifyPlugin apk: " + str3 + " signature failed - sig: " + strA);
                android.widget.Toast.makeText(context, "插件校验失败，请重试", 0).show();
                file.delete();
                file2.delete();
                return;
            }
            java.lang.String str4 = this.f961a + java.io.File.separator + "opt";
            java.io.File file3 = new java.io.File(str4);
            if (!file3.exists()) {
                file3.mkdirs();
            }
            if (b == null) {
                b = new dalvik.system.DexClassLoader(str3, str4, null, context.getClassLoader());
            }
            java.util.HashMap map = new java.util.HashMap();
            map.put("url", str);
            map.put("tbs_version", "" + com.tencent.smtt.sdk.WebView.getTbsSDKVersion(context));
            map.put("tbs_core_version", "" + com.tencent.smtt.sdk.WebView.getTbsCoreVersion(context));
            if (c != null) {
                map.put("looper", looper);
            }
            java.lang.Object objNewInstance = b.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(android.content.Context.class, java.util.Map.class).newInstance(context, map);
            if (!(objNewInstance instanceof android.widget.FrameLayout)) {
                com.tencent.smtt.utils.TbsLog.e("debugtbs", "get debugview failure: " + objNewInstance);
                return;
            }
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) objNewInstance;
            webView.addView(frameLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
            com.tencent.smtt.utils.TbsLog.i("debugtbs", "show " + frameLayout + " successful in " + webView);
        } catch (java.lang.Exception e) {
            com.tencent.smtt.utils.f.b(file2);
            e.printStackTrace();
        }
    }
}
