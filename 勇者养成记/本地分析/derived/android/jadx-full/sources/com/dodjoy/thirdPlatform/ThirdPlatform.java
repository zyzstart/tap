package com.dodjoy.thirdPlatform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ThirdPlatform implements com.dodjoy.platform.IThirdPlatform, com.dodjoy.thirdPlatform.DodYSDKCallback, com.tencent.ysdk.module.user.UserListener, com.tencent.ysdk.module.bugly.BuglyListener, com.tencent.ysdk.module.antiaddiction.listener.AntiAddictListener {
    public static boolean mAntiAddictExecuteState = false;
    static android.app.Activity mContext = null;
    public static org.json.JSONObject m_cacheToken = null;
    public static boolean m_clickLogin = false;
    public static android.app.Activity sActivity;
    private java.lang.String mChannelName;
    private java.lang.String mPayUrl;
    private java.lang.String mRounte;
    private boolean m_inited;
    private java.lang.String TAG = "YSDK";
    private java.lang.Boolean m_haveGDT = false;
    private boolean is_dosdkpay = false;
    private java.lang.String mOrderId = "";
    private float mPrice = 0.0f;
    private int TIME = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static void changeExecuteState(boolean z) {
        mAntiAddictExecuteState = z;
    }

    @android.annotation.TargetApi(23)
    private void checkAndRequestPermission() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (mContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            arrayList.add("android.permission.READ_PHONE_STATE");
        }
        if (arrayList.size() == 0) {
            initSdk();
            return;
        }
        java.lang.String[] strArr = new java.lang.String[arrayList.size()];
        arrayList.toArray(strArr);
        mContext.requestPermissions(strArr, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBanlance(final java.lang.String str, final float f, final boolean z) {
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        com.tencent.ysdk.api.YSDKApi.getLoginRecord(userLoginRet);
        java.util.ArrayList arrayList = new java.util.ArrayList(0);
        arrayList.add(new android.util.Pair(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_CHANNEL, getChannelName()));
        arrayList.add(new android.util.Pair("getblance", "1"));
        arrayList.add(new android.util.Pair("worldid", com.dodjoy.platform.PlatformInterface.getAreaID()));
        arrayList.add(new android.util.Pair("openid", userLoginRet.open_id));
        arrayList.add(new android.util.Pair("pf", userLoginRet.pf));
        arrayList.add(new android.util.Pair("pfkey", userLoginRet.pf_key));
        arrayList.add(new android.util.Pair("[REDACTED]", userLoginRet.getPayToken()));
        arrayList.add(new android.util.Pair("amt", f + ""));
        arrayList.add(new android.util.Pair("route", this.mRounte + ""));
        com.dodjoy.utilities.DodRequest.request(this.mPayUrl, arrayList, new com.dodjoy.utilities.RequestCallback() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.4
            @Override // com.dodjoy.utilities.RequestCallback
            public void onFail(java.lang.Object obj) {
                android.util.Log.e("Unity", "check blanance error " + obj);
                com.dodjoy.thirdPlatform.ThirdPlatform thirdPlatform = com.dodjoy.thirdPlatform.ThirdPlatform.this;
                java.lang.String str2 = str;
                float f2 = f;
                thirdPlatform.doSdkPay(str2, f2, f2);
            }

            @Override // com.dodjoy.utilities.RequestCallback
            public void onSuccess(java.lang.Object obj) {
                if (obj == null) {
                    android.util.Log.e("Unity", "check banlance null ");
                    com.dodjoy.thirdPlatform.ThirdPlatform thirdPlatform = com.dodjoy.thirdPlatform.ThirdPlatform.this;
                    java.lang.String str2 = str;
                    float f2 = f;
                    thirdPlatform.doSdkPay(str2, f2, f2);
                    return;
                }
                org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
                try {
                    int i = jSONObject.getInt("ret");
                    if (i == 0) {
                        double d = jSONObject.getDouble("isneed");
                        android.util.Log.e("Unity", "need amount is " + d);
                        if (d >= 0.0d) {
                            com.dodjoy.thirdPlatform.ThirdPlatform.this.is_dosdkpay = false;
                            com.dodjoy.thirdPlatform.ThirdPlatform.this.requestNotify(str, f);
                        } else if (!z) {
                            com.dodjoy.thirdPlatform.ThirdPlatform.this.doSdkPay(str, (float) (-d), f);
                        }
                    } else {
                        android.util.Log.e("Unity", "check banlance failed " + i);
                        com.dodjoy.thirdPlatform.ThirdPlatform.this.doSdkPay(str, f, f);
                    }
                } catch (java.lang.Exception e) {
                    android.util.Log.e("Unity", "check banlance exception " + e);
                    com.dodjoy.thirdPlatform.ThirdPlatform thirdPlatform2 = com.dodjoy.thirdPlatform.ThirdPlatform.this;
                    java.lang.String str3 = str;
                    float f3 = f;
                    thirdPlatform2.doSdkPay(str3, f3, f3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSdkPay(final java.lang.String str, final float f, final float f2) {
        mContext.runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.5
            @Override // java.lang.Runnable
            public void run() {
                com.dodjoy.thirdPlatform.ThirdPlatform.this.is_dosdkpay = true;
                com.dodjoy.thirdPlatform.ThirdPlatform.this.mOrderId = str;
                com.dodjoy.thirdPlatform.ThirdPlatform.this.mPrice = f2;
                android.content.res.Resources resources = com.dodjoy.thirdPlatform.ThirdPlatform.mContext.getResources();
                android.graphics.Bitmap bitmapDecodeResource = android.graphics.BitmapFactory.decodeResource(resources, resources.getIdentifier("dod_ysdk_yuanbao", "drawable", com.dodjoy.thirdPlatform.ThirdPlatform.mContext.getPackageName()));
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                bitmapDecodeResource.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                com.tencent.ysdk.api.YSDKApi.recharge(com.dodjoy.platform.PlatformInterface.getAreaID(), ((int) f) + "", false, byteArray, "ysdkExt", new com.tencent.ysdk.module.pay.PayListener() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.5.1
                    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0038. Please report as an issue. */
                    @Override // com.tencent.ysdk.module.pay.PayListener
                    public void OnPayNotify(com.tencent.ysdk.module.pay.PayRet payRet) {
                        com.dodjoy.thirdPlatform.ThirdPlatform.this.is_dosdkpay = false;
                        if (payRet.ret != 0) {
                            int i = payRet.flag;
                            if (i != 3100) {
                                switch (i) {
                                }
                                return;
                            }
                            return;
                        }
                        switch (payRet.payState) {
                            case -1:
                                com.dodjoy.thirdPlatform.ThirdPlatform.this.requestNotify(str, f2);
                                break;
                            case 0:
                                com.dodjoy.thirdPlatform.ThirdPlatform.this.requestNotify(str, f2);
                                break;
                        }
                    }
                });
            }
        });
    }

    public static void executeInstruction(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet) {
        final int i = antiAddictRet.modal;
        switch (antiAddictRet.type) {
            case 1:
                if (!mAntiAddictExecuteState) {
                    mAntiAddictExecuteState = true;
                    new android.app.AlertDialog.Builder(mContext).setTitle(antiAddictRet.title).setMessage(antiAddictRet.content).setPositiveButton("知道了", new android.content.DialogInterface.OnClickListener() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.7
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                            android.util.Log.i("executeInstruction", "TYPE_TIPS 点击同意了 mAntiAddictExecuteState ：" + com.dodjoy.thirdPlatform.ThirdPlatform.mAntiAddictExecuteState + " model :" + i);
                            com.dodjoy.thirdPlatform.ThirdPlatform.changeExecuteState(false);
                        }
                    }).create().show();
                    com.tencent.ysdk.api.YSDKApi.reportAntiAddictExecute(antiAddictRet, java.lang.System.currentTimeMillis());
                }
                break;
            case 2:
                if (!mAntiAddictExecuteState) {
                    mAntiAddictExecuteState = true;
                    new android.app.AlertDialog.Builder(mContext).setTitle(antiAddictRet.title).setMessage(antiAddictRet.content).setPositiveButton("知道了", new android.content.DialogInterface.OnClickListener() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.8
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                            if (i == 1) {
                                android.util.Log.i("executeInstruction", " TYPE_LOGOUT 点击同意了 mAntiAddictExecuteState ：" + com.dodjoy.thirdPlatform.ThirdPlatform.mAntiAddictExecuteState);
                                com.dodjoy.thirdPlatform.ThirdPlatform.userLogout();
                            }
                            android.util.Log.i("executeInstruction", "modal ---" + i);
                            com.dodjoy.thirdPlatform.ThirdPlatform.changeExecuteState(false);
                        }
                    }).create().show();
                    com.tencent.ysdk.api.YSDKApi.reportAntiAddictExecute(antiAddictRet, java.lang.System.currentTimeMillis());
                }
                break;
            case 3:
                if (!mAntiAddictExecuteState) {
                    mAntiAddictExecuteState = true;
                    android.view.View viewInflate = android.view.View.inflate(sActivity, com.dodjoy.ysdk.R.layout.pop_window_web_layout, null);
                    android.webkit.WebView webView = (android.webkit.WebView) viewInflate.findViewById(com.dodjoy.ysdk.R.id.pop_window_webview);
                    android.widget.Button button = (android.widget.Button) viewInflate.findViewById(com.dodjoy.ysdk.R.id.pop_window_close);
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebViewClient(new android.webkit.WebViewClient());
                    webView.loadUrl(antiAddictRet.url);
                    final android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(viewInflate, 1000, 1000);
                    popupWindow.setTouchable(true);
                    popupWindow.setOutsideTouchable(false);
                    popupWindow.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable());
                    button.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(android.view.View view) {
                            if (i == 1) {
                                com.dodjoy.thirdPlatform.ThirdPlatform.userLogout();
                            }
                            popupWindow.dismiss();
                            com.dodjoy.thirdPlatform.ThirdPlatform.changeExecuteState(false);
                        }
                    });
                    popupWindow.showAtLocation(viewInflate, 17, 0, 0);
                    com.tencent.ysdk.api.YSDKApi.reportAntiAddictExecute(antiAddictRet, java.lang.System.currentTimeMillis());
                }
                break;
        }
    }

    private boolean hasAllPermissionsGranted(int[] iArr) {
        for (int i : iArr) {
            if (i == -1) {
                return false;
            }
        }
        return true;
    }

    private void initSdk() {
        if (this.m_inited) {
            return;
        }
        this.m_inited = true;
        com.tencent.ysdk.api.YSDKApi.onCreate(mContext);
        com.tencent.ysdk.api.YSDKApi.handleIntent(mContext.getIntent());
        com.tencent.ysdk.api.YSDKApi.setUserListener(this);
        com.tencent.ysdk.api.YSDKApi.setBuglyListener(this);
        com.tencent.ysdk.api.YSDKApi.init();
        com.tencent.ysdk.api.YSDKApi.setAntiAddictListener(this);
        java.lang.String strGetDodSdkCfg = com.dodjoy.platform.PlatformInterface.GetDodSdkCfg("GDTActionSetID");
        this.mChannelName = com.dodjoy.platform.PlatformInterface.GetDodSdkCfg("ChannelName");
        if (!android.text.TextUtils.isEmpty(strGetDodSdkCfg)) {
            this.m_haveGDT = true;
        }
        com.tencent.ysdk.api.YSDKApi.setScreenCapturer(new com.tencent.ysdk.module.share.impl.IScreenImageCapturer() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.1
            @Override // com.tencent.ysdk.module.share.impl.IScreenImageCapturer
            public android.graphics.Bitmap caputureImage() {
                android.graphics.Rect rect;
                android.graphics.Rect rect2;
                final java.lang.String str = "jpg_" + new java.text.SimpleDateFormat("yyyyMMdd_HHmmss", java.util.Locale.ENGLISH).format(new java.util.Date()) + ".jpg";
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put(com.tencent.smtt.sdk.TbsReaderView.KEY_FILE_PATH, str);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                com.dodjoy.platform.PlatformInterface.sendU3dMessage("DoScreenCapture", jSONObject);
                java.lang.Thread thread = new java.lang.Thread(new java.lang.Runnable() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        while (!new java.io.File(com.dodjoy.thirdPlatform.ThirdPlatform.mContext.getExternalFilesDir(null), str).isFile()) {
                            try {
                                java.lang.Thread.sleep(500L);
                            } catch (java.lang.InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
                try {
                    thread.join();
                } catch (java.lang.InterruptedException e2) {
                    e2.printStackTrace();
                }
                android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(new java.io.File(com.dodjoy.thirdPlatform.ThirdPlatform.mContext.getExternalFilesDir(null), str).getAbsolutePath(), new android.graphics.BitmapFactory.Options());
                android.graphics.Matrix matrix = new android.graphics.Matrix();
                float f = 786;
                matrix.postScale(f / bitmapDecodeFile.getWidth(), f / bitmapDecodeFile.getWidth());
                android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                android.graphics.Bitmap bitmapCreateBitmap2 = android.graphics.Bitmap.createBitmap(786, 1152, android.graphics.Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap2);
                android.graphics.Paint paint = new android.graphics.Paint();
                paint.setColor(-16777216);
                int height = (1152 - bitmapCreateBitmap.getHeight()) / 2;
                if (height >= 0) {
                    rect2 = new android.graphics.Rect(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                    rect = new android.graphics.Rect(0, height, 786, bitmapCreateBitmap.getHeight() + height);
                } else {
                    android.graphics.Rect rect3 = new android.graphics.Rect(0, -height, bitmapCreateBitmap.getWidth(), height + 1152);
                    rect = new android.graphics.Rect(0, 0, 786, 1152);
                    rect2 = rect3;
                }
                canvas.drawBitmap(bitmapCreateBitmap, rect2, rect, paint);
                return bitmapCreateBitmap2;
            }
        });
        com.tencent.ysdk.module.share.ShareApi.getInstance().regShareCallBack(new com.tencent.ysdk.module.share.ShareCallBack() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.2
            @Override // com.tencent.ysdk.module.share.ShareCallBack
            public void onCancel(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
            }

            @Override // com.tencent.ysdk.module.share.ShareCallBack
            public void onError(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
            }

            @Override // com.tencent.ysdk.module.share.ShareCallBack
            public void onSuccess(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
            }
        });
        if (this.m_haveGDT.booleanValue()) {
            com.qq.gdt.action.GDTAction.logAction(com.qq.gdt.action.ActionType.START_APP);
        }
    }

    public static void onLoginCancel(int i) {
        m_cacheToken = null;
        m_clickLogin = false;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("code", i);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.dodjoy.platform.PlatformInterface.onLoginCancel(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestNotify(java.lang.String str, float f) {
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        com.tencent.ysdk.api.YSDKApi.getLoginRecord(userLoginRet);
        java.util.ArrayList arrayList = new java.util.ArrayList(0);
        arrayList.add(new android.util.Pair(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_CHANNEL, getChannelName()));
        arrayList.add(new android.util.Pair("getblance", "0"));
        arrayList.add(new android.util.Pair("cpOrderid", str));
        arrayList.add(new android.util.Pair("worldid", com.dodjoy.platform.PlatformInterface.getAreaID()));
        arrayList.add(new android.util.Pair("openid", userLoginRet.open_id));
        arrayList.add(new android.util.Pair("pf", userLoginRet.pf));
        arrayList.add(new android.util.Pair("pfkey", userLoginRet.pf_key));
        arrayList.add(new android.util.Pair("[REDACTED]", userLoginRet.getPayToken()));
        arrayList.add(new android.util.Pair("amt", f + ""));
        arrayList.add(new android.util.Pair("route", this.mRounte + ""));
        com.dodjoy.utilities.DodRequest.request(this.mPayUrl, arrayList, new com.dodjoy.utilities.RequestCallback() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.3
            @Override // com.dodjoy.utilities.RequestCallback
            public void onFail(java.lang.Object obj) {
            }

            @Override // com.dodjoy.utilities.RequestCallback
            public void onSuccess(java.lang.Object obj) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void userLogout() {
        com.tencent.ysdk.api.YSDKApi.logout();
        m_cacheToken = null;
        com.dodjoy.platform.PlatformInterface.PlatformToGameLogout();
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void DealMessage(int i, java.lang.String str) {
        android.util.Log.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + " DealMessage type:" + i);
        if (i == 1 || i == 5 || i == 20) {
            return;
        }
        switch (i) {
            case 11:
            case 13:
                break;
            case 12:
                com.tencent.ysdk.api.YSDKApi.setAntiAddictGameStart();
                break;
            default:
                switch (i) {
                    case 16:
                        com.tencent.ysdk.api.YSDKApi.setAntiAddictGameEnd();
                        break;
                    case 17:
                        this.mPayUrl = str;
                        break;
                    case 18:
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                            jSONObject.put(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, java.lang.Float.parseFloat(jSONObject.getString("Price")) * 100.0f);
                            com.qq.gdt.action.GDTAction.logAction(com.qq.gdt.action.ActionType.PURCHASE, jSONObject);
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            return;
                        }
                        break;
                }
                break;
        }
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void GameToPlatformLogout() {
        android.util.Log.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + " GameToPlatformLogout");
        com.tencent.ysdk.api.YSDKApi.logout();
        m_cacheToken = null;
        com.dodjoy.platform.PlatformInterface.PlatformToGameLogout();
    }

    @Override // com.tencent.ysdk.module.bugly.BuglyListener
    public byte[] OnCrashExtDataNotify() {
        return null;
    }

    @Override // com.tencent.ysdk.module.bugly.BuglyListener
    public java.lang.String OnCrashExtMessageNotify() {
        android.util.Log.d(this.TAG, java.lang.String.format(java.util.Locale.CHINA, "OnCrashExtMessageNotify called", new java.lang.Object[0]));
        java.util.Date date = new java.util.Date();
        return "new Upload extra crashing message for bugly on " + new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
    }

    @Override // com.tencent.ysdk.module.user.UserListener
    public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        android.util.Log.d(this.TAG, "OnLoginNotify ret.flag:" + userLoginRet.flag);
        if (!m_clickLogin) {
            if (userLoginRet.flag == 0) {
                this.mRounte = com.tencent.ysdk.framework.common.ePlatform.PLATFORM_STR_WX;
                if (userLoginRet.flag != 0) {
                    return;
                }
                com.dodjoy.thirdPlatform.DodYSDKLoginActivity.finishActivity();
                java.lang.String str = userLoginRet.open_id;
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    if (1 == userLoginRet.platform) {
                        this.mRounte = "qq";
                    } else if (2 == userLoginRet.platform) {
                        this.mRounte = com.tencent.ysdk.framework.common.ePlatform.PLATFORM_STR_WX;
                    } else if (com.dodjoy.thirdPlatform.DodYSDKLoginActivity.LOGINFLAG != null) {
                        this.mRounte = com.dodjoy.thirdPlatform.DodYSDKLoginActivity.LOGINFLAG;
                    }
                    jSONObject.put("openid", str + "");
                    jSONObject.put("[REDACTED]", userLoginRet.getAccessToken() + "[REDACTED]");
                    jSONObject.put("route", this.mRounte + "");
                    com.dodjoy.platform.PlatformInterface.onLoginSuccess(jSONObject);
                    m_cacheToken = jSONObject;
                    return;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        m_cacheToken = null;
        m_clickLogin = false;
        this.mRounte = com.tencent.ysdk.framework.common.ePlatform.PLATFORM_STR_WX;
        int i = userLoginRet.flag;
        if (i == 0) {
            com.dodjoy.thirdPlatform.DodYSDKLoginActivity.finishActivity();
            java.lang.String str2 = userLoginRet.open_id;
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                if (1 == userLoginRet.platform) {
                    this.mRounte = "qq";
                } else if (2 == userLoginRet.platform) {
                    this.mRounte = com.tencent.ysdk.framework.common.ePlatform.PLATFORM_STR_WX;
                } else if (com.dodjoy.thirdPlatform.DodYSDKLoginActivity.LOGINFLAG != null) {
                    this.mRounte = com.dodjoy.thirdPlatform.DodYSDKLoginActivity.LOGINFLAG;
                }
                jSONObject2.put("openid", str2 + "");
                jSONObject2.put("[REDACTED]", userLoginRet.getAccessToken() + "[REDACTED]");
                jSONObject2.put("route", this.mRounte + "");
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                onLoginCancel(-userLoginRet.flag);
            }
            com.dodjoy.platform.PlatformInterface.onLoginSuccess(jSONObject2);
            return;
        }
        if (i == 3103) {
            onLoginCancel(-userLoginRet.flag);
            return;
        }
        switch (i) {
            case 1001:
                onLoginCancel(-userLoginRet.flag);
                break;
            case 1002:
                onLoginCancel(-userLoginRet.flag);
                break;
            case 1003:
                onLoginCancel(-userLoginRet.flag);
                break;
            case 1004:
                onLoginCancel(-userLoginRet.flag);
                break;
            case com.tencent.ysdk.framework.common.eFlag.QQ_NotSupportApi /* 1005 */:
                onLoginCancel(-userLoginRet.flag);
                break;
            default:
                switch (i) {
                    case 2000:
                        android.app.Activity activity = mContext;
                        android.widget.Toast.makeText(activity, com.dodjoy.thirdPlatform.util.ResourceUtils.getStringId(activity, "dod_wx_not_installed"), 0).show();
                        onLoginCancel(-userLoginRet.flag);
                        break;
                    case 2001:
                        onLoginCancel(-userLoginRet.flag);
                        break;
                    case 2002:
                        onLoginCancel(-userLoginRet.flag);
                        break;
                    case 2003:
                        onLoginCancel(-userLoginRet.flag);
                        break;
                    case 2004:
                        onLoginCancel(-userLoginRet.flag);
                        break;
                    default:
                        switch (i) {
                            case com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid /* 3100 */:
                                onLoginCancel(-userLoginRet.flag);
                                break;
                            case com.tencent.ysdk.framework.common.eFlag.Login_NotRegisterRealName /* 3101 */:
                                onLoginCancel(-userLoginRet.flag);
                                break;
                            default:
                                onLoginCancel(-userLoginRet.flag);
                                break;
                        }
                        break;
                }
                break;
        }
    }

    @Override // com.tencent.ysdk.module.user.UserListener
    public void OnRelationNotify(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
    }

    @Override // com.tencent.ysdk.module.user.UserListener
    public void OnWakeupNotify(com.tencent.ysdk.module.user.WakeupRet wakeupRet) {
        android.util.Log.d(this.TAG, "called");
        android.util.Log.d(this.TAG, "flag:" + wakeupRet.flag);
        android.util.Log.d(this.TAG, "msg:" + wakeupRet.msg);
        android.util.Log.d(this.TAG, "platform:" + wakeupRet.platform);
        if (3302 == wakeupRet.flag || wakeupRet.flag == 3303) {
            return;
        }
        int i = wakeupRet.flag;
    }

    public void Times() {
        if (this.is_dosdkpay) {
            final android.os.Handler handler = new android.os.Handler();
            handler.postDelayed(new java.lang.Runnable() { // from class: com.dodjoy.thirdPlatform.ThirdPlatform.6
                @Override // java.lang.Runnable
                public void run() {
                    com.dodjoy.thirdPlatform.ThirdPlatform.this.TIME += com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING;
                    com.dodjoy.thirdPlatform.ThirdPlatform thirdPlatform = com.dodjoy.thirdPlatform.ThirdPlatform.this;
                    thirdPlatform.checkBanlance(thirdPlatform.mOrderId, com.dodjoy.thirdPlatform.ThirdPlatform.this.mPrice, true);
                    if (com.dodjoy.thirdPlatform.ThirdPlatform.this.TIME <= 60000 && com.dodjoy.thirdPlatform.ThirdPlatform.this.is_dosdkpay) {
                        handler.postDelayed(this, com.dodjoy.thirdPlatform.ThirdPlatform.this.TIME);
                    } else {
                        java.lang.System.out.println("定时器停止了源");
                        handler.removeCallbacks(this);
                    }
                }
            }, 1000L);
        }
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void attachBaseContext(android.content.Context context) {
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void doSdkPay(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, float f, java.lang.String str4) {
        android.util.Log.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + " pay");
        this.mPayUrl = str3;
        try {
            if (!android.text.TextUtils.isEmpty(str4) && !android.text.TextUtils.isEmpty(this.mPayUrl)) {
                checkBanlance(str4, f * 10.0f, false);
                return;
            }
            com.dodjoy.platform.PlatformInterface.onPayCancel(-1);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.dodjoy.thirdPlatform.DodYSDKCallback
    public void dodQQLogin() {
        android.util.Log.d(this.TAG, "dodQQLogin");
        com.tencent.ysdk.api.YSDKApi.login(com.tencent.ysdk.framework.common.ePlatform.QQ);
    }

    @Override // com.dodjoy.thirdPlatform.DodYSDKCallback
    public void dodWXLogin() {
        android.util.Log.d(this.TAG, "dodWXLogin");
        com.tencent.ysdk.api.YSDKApi.login(com.tencent.ysdk.framework.common.ePlatform.WX);
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public int exitGame() {
        com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + " exitGame");
        com.dodjoy.platform.PlatformInterface.OnPlatformExit(true);
        return 1;
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public java.lang.String getChannelName() {
        return !android.text.TextUtils.isEmpty(this.mChannelName) ? this.mChannelName : com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_YSDK;
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public java.lang.String getSdkCountryInfo() {
        return null;
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void initThirdSdk() {
        android.util.Log.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + "on init third sdk");
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void initWithInstance(android.app.Activity activity, android.os.Bundle bundle) {
        android.util.Log.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + "on init ThirdPlatform");
        mContext = null;
        if (activity == null || !(activity instanceof android.app.Activity)) {
            throw new java.lang.RuntimeException("init on ThirdPlatform should be Activity");
        }
        mContext = activity;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            checkAndRequestPermission();
        } else {
            initSdk();
        }
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public int login() {
        if (!this.m_inited) {
            return 1;
        }
        m_clickLogin = true;
        android.util.Log.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + " login");
        try {
            mContext.startActivity(new android.content.Intent(mContext, (java.lang.Class<?>) com.dodjoy.thirdPlatform.DodYSDKLoginActivity.class));
            com.dodjoy.thirdPlatform.DodYSDKLoginActivity.setDodYSDKLoginCallback(this);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.api.YSDKApi.login(com.tencent.ysdk.framework.common.ePlatform.WX);
        }
        return 1;
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        android.util.Log.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + "onActivityResult");
        com.tencent.ysdk.api.YSDKApi.onActivityResult(i, i2, intent);
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onBackPressed() {
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        android.util.Log.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + " on configuration");
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onDestroy() {
        com.tencent.ysdk.api.YSDKApi.onDestroy(mContext);
    }

    @Override // com.tencent.ysdk.module.antiaddiction.listener.AntiAddictListener
    public void onLoginLimitNotify(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet) {
        android.util.Log.i(this.TAG, "onLoginLimitNotify --- ret" + antiAddictRet.ruleFamily);
        if (antiAddictRet.ret == 0) {
            switch (antiAddictRet.ruleFamily) {
                case "xg_work_tip":
                    executeInstruction(antiAddictRet);
                    break;
                case "xg_work_noplay":
                    executeInstruction(antiAddictRet);
                    break;
                case "xg_holiday_tip":
                    executeInstruction(antiAddictRet);
                    break;
                case "xg_holiday_noplay":
                    executeInstruction(antiAddictRet);
                    break;
                case "xg_alltime_noplaytime":
                    executeInstruction(antiAddictRet);
                    break;
                default:
                    executeInstruction(antiAddictRet);
                    break;
            }
        }
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onNewIntent(android.content.Intent intent) {
        android.util.Log.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + "onNewIntent");
        com.tencent.ysdk.api.YSDKApi.handleIntent(intent);
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onPause() {
        android.util.Log.i(this.TAG, "onPause");
        if (this.m_inited) {
            com.tencent.ysdk.api.YSDKApi.onPause(mContext);
        }
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        if (i == 1024 && hasAllPermissionsGranted(iArr)) {
            initSdk();
        }
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onRestart() {
        if (this.m_inited) {
            com.tencent.ysdk.api.YSDKApi.onRestart(mContext);
        }
        android.util.Log.i(this.TAG, "onRestart");
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onResume() {
        android.util.Log.i(this.TAG, "onResume");
        if (this.m_inited) {
            com.tencent.ysdk.api.YSDKApi.onResume(mContext);
        }
        if (this.m_haveGDT.booleanValue()) {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                checkAndRequestPermission();
            } else {
                com.qq.gdt.action.GDTAction.logAction(com.qq.gdt.action.ActionType.START_APP);
            }
        }
        if (this.mOrderId != "") {
            Times();
        }
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onSaveInstanceState(android.os.Bundle bundle) {
        android.util.Log.i(com.dodjoy.utils.DodLog.TAG, getChannelName() + "on save instance state");
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onStart() {
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void onStop() {
        com.tencent.ysdk.api.YSDKApi.onStop(mContext);
    }

    @Override // com.tencent.ysdk.module.antiaddiction.listener.AntiAddictListener
    public void onTimeLimitNotify(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet) {
        android.util.Log.i(this.TAG, "onTimeLimitNotify --- ret" + antiAddictRet.ruleFamily);
        if (antiAddictRet.ret == 0) {
            switch (antiAddictRet.ruleFamily) {
                case "xg_work_tip":
                    executeInstruction(antiAddictRet);
                    break;
                case "xg_work_noplay":
                    executeInstruction(antiAddictRet);
                    break;
                case "xg_holiday_tip":
                    executeInstruction(antiAddictRet);
                    break;
                case "xg_holiday_noplay":
                    executeInstruction(antiAddictRet);
                    break;
                case "xg_alltime_noplaytime":
                    executeInstruction(antiAddictRet);
                    break;
                default:
                    executeInstruction(antiAddictRet);
                    break;
            }
        }
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void preventIndulge() {
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public boolean quickLogin() {
        android.util.Log.e(this.TAG, "quickLogin");
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        com.tencent.ysdk.api.YSDKApi.getLoginRecord(userLoginRet);
        this.mRounte = com.tencent.ysdk.framework.common.ePlatform.PLATFORM_STR_WX;
        android.util.Log.d(com.dodjoy.utils.DodLog.TAG, "quickLogin>>>>>ret.flag:" + userLoginRet.flag);
        if (userLoginRet.flag != 0) {
            return false;
        }
        java.lang.String str = userLoginRet.open_id;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (1 == userLoginRet.platform) {
                this.mRounte = "qq";
            } else if (2 == userLoginRet.platform) {
                this.mRounte = com.tencent.ysdk.framework.common.ePlatform.PLATFORM_STR_WX;
            }
            jSONObject.put("openid", str + "");
            jSONObject.put("[REDACTED]", userLoginRet.getAccessToken() + "[REDACTED]");
            jSONObject.put("route", this.mRounte + "");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.dodjoy.platform.PlatformInterface.onLoginSuccess(jSONObject);
        return true;
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public void reqSpringGameFBAct(int i, boolean z) {
    }

    @Override // com.dodjoy.platform.IThirdPlatform
    public boolean supportSwitchAccount() {
        return true;
    }
}
