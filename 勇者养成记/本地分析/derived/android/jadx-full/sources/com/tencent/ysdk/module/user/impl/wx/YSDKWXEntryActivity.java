package com.tencent.ysdk.module.user.impl.wx;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKWXEntryActivity extends android.app.Activity implements com.tencent.mm.opensdk.openapi.IWXAPIEventHandler {
    public static final java.lang.String KEY_WX_APPID = "WX_APP_ID";
    private static final java.lang.String LOG_TAG = "YSDK_USER_WX";
    private java.lang.String mMessageExt;
    private java.lang.String mPlatformId;
    private java.lang.String mWxCardList;

    private void initEntry() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "initEntry");
        java.lang.String configFromFile = readConfigFromFile(this, "ysdkconf.ini", "WX_APP_ID", "");
        com.tencent.mm.opensdk.openapi.IWXAPI iwxapiCreateWXAPI = com.tencent.mm.opensdk.openapi.WXAPIFactory.createWXAPI(this, configFromFile, true);
        iwxapiCreateWXAPI.registerApp(configFromFile);
        try {
            iwxapiCreateWXAPI.handleIntent(getIntent(), this);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.libware.file.Logger.e("YSDK_USER_WX", e.getClass().getName());
            e.printStackTrace();
        }
    }

    private static java.lang.String readConfigFromFile(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null) {
            com.tencent.ysdk.libware.file.Logger.e("YSDK_USER_WX", "readConfigFromFile context is null");
            return str3;
        }
        java.io.InputStream inputStream = null;
        try {
            try {
                java.io.InputStream inputStreamOpen = context.getResources().getAssets().open(str);
                java.util.Properties properties = new java.util.Properties();
                properties.load(inputStreamOpen);
                java.lang.String property = properties.getProperty(str2, "");
                if (property != null && property.length() != 0) {
                    java.lang.String strTrim = property.trim();
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return strTrim;
                }
                com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "no key: " + str2);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return "";
            } catch (java.lang.Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.io.IOException e4) {
            e4.printStackTrace();
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (java.lang.Exception e5) {
                    e5.printStackTrace();
                }
            }
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0030 A[Catch: Exception -> 0x0038, TRY_LEAVE, TryCatch #0 {Exception -> 0x0038, blocks: (B:4:0x0009, B:6:0x000f, B:7:0x0030), top: B:13:0x0009 }] */
    private void setPlatformInfo(android.content.Intent intent) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "setPlatformInfo");
        if (intent != null) {
            try {
                if (intent.getExtras() != null) {
                    android.os.Bundle extras = getIntent().getExtras();
                    this.mPlatformId = extras.getString("platformId");
                    this.mMessageExt = extras.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.PLATFORM_MSG);
                    this.mWxCardList = extras.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.MISC_CARD_LIST);
                } else {
                    com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "setPlatformInfo intent or intent.getExtras is null");
                }
            } catch (java.lang.Exception e) {
                com.tencent.ysdk.libware.file.Logger.e("YSDK_USER_WX", e.getClass().getName());
                e.printStackTrace();
            }
        } else {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "setPlatformInfo intent or intent.getExtras is null");
        }
    }

    private void testPlatform(android.content.Intent intent) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "TestPlatform");
        if (intent == null) {
            str = "YSDK_USER_WX";
            str2 = "wx intent is NULL";
        } else {
            try {
                android.os.Bundle extras = intent.getExtras();
                if (extras == null) {
                    com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "wx getExtras is NULL");
                    return;
                } else {
                    com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", extras);
                    str = "YSDK_USER_WX";
                    str2 = "intent content end";
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        com.tencent.ysdk.libware.file.Logger.d(str, str2);
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "YSDKWXEntryActivity onCreate");
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        testPlatform(getIntent());
        setPlatformInfo(getIntent());
        initEntry();
    }

    @Override // android.app.Activity
    protected void onNewIntent(android.content.Intent intent) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "YSDKWXEntryActivity onNewIntent");
        super.onNewIntent(intent);
        testPlatform(getIntent());
        setIntent(intent);
        setPlatformInfo(intent);
        initEntry();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003c  */
    /* JADX WARN: Code duplicated, block: B:15:0x0079  */
    /* JADX WARN: Code duplicated, block: B:17:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:19:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:21:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:22:0x00ee  */
    /* JADX WARN: Instruction removed from duplicated block: B:19:0x00a4, please report this as an issue */
    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        java.lang.String str;
        java.lang.String str2;
        android.content.Intent launchIntentForPackage;
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage;
        java.lang.String str3;
        java.lang.String str4;
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "onReq");
        java.lang.String str5 = baseReq.openId;
        if (str5 != null) {
            if ("".equals(str5)) {
                str = "YSDK_USER_WX";
                str2 = "OpenID is empty";
            } else {
                com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "OpenID : " + baseReq.openId);
            }
            if (baseReq.openId == null) {
                baseReq.openId = "";
            }
            launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            launchIntentForPackage.setFlags(268435456);
            launchIntentForPackage.addFlags(536870912);
            launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.CALLBACK_FLAG, "[REDACTED]");
            com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "onReq" + this.mMessageExt);
            if (baseReq instanceof com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req) {
                if (baseReq instanceof com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req) {
                    com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "ShowMessageFromWX.Req");
                    com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req req = (com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req) baseReq;
                    launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.MEDIA_TAG, ((com.tencent.mm.opensdk.modelmsg.WXAppExtendObject) req.message.mediaObject).extInfo);
                    wXMediaMessage = req.message;
                    launchIntentForPackage.putExtra("country", req.country);
                    launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_LANG, req.lang);
                    com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "mediaMsg.messageExt" + wXMediaMessage.messageExt);
                    if (com.tencent.ysdk.libware.util.YSDKTextUtils.ckIsEmpty(wXMediaMessage.messageExt)) {
                        str3 = this.mMessageExt;
                    } else {
                        str3 = wXMediaMessage.messageExt;
                    }
                    str4 = com.tencent.ysdk.module.user.impl.wx.WXKey.MSG_EXT;
                }
                launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.TRANSACTION_TYPE, baseReq.transaction);
                launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_OPENID, baseReq.openId);
                launchIntentForPackage.putExtra("platformId", this.mPlatformId);
                com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "打印最终给ysdk 的intent ---- s\n");
                com.tencent.ysdk.libware.file.Logger.d(launchIntentForPackage);
                com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "打印最终给ysdk 的intent ---- e\n");
                startActivity(launchIntentForPackage);
                com.tencent.ysdk.innerapi.DynamicInnerApi.handleIntent(launchIntentForPackage);
            }
            com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "LaunchFromWX.Req");
            launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.MEDIA_TAG, "[REDACTED]");
            com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req req2 = (com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req) baseReq;
            launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.MSG_EXT, req2.messageExt);
            launchIntentForPackage.putExtra("country", req2.country);
            str3 = req2.lang;
            str4 = com.tencent.ysdk.module.user.impl.wx.WXKey.USER_LANG;
            launchIntentForPackage.putExtra(str4, str3);
            launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.TRANSACTION_TYPE, baseReq.transaction);
            launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_OPENID, baseReq.openId);
            launchIntentForPackage.putExtra("platformId", this.mPlatformId);
            com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "打印最终给ysdk 的intent ---- s\n");
            com.tencent.ysdk.libware.file.Logger.d(launchIntentForPackage);
            com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "打印最终给ysdk 的intent ---- e\n");
            startActivity(launchIntentForPackage);
            com.tencent.ysdk.innerapi.DynamicInnerApi.handleIntent(launchIntentForPackage);
        }
        str = "YSDK_USER_WX";
        str2 = "OpenID Null";
        com.tencent.ysdk.libware.file.Logger.d(str, str2);
        if (baseReq.openId == null) {
            baseReq.openId = "";
        }
        launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        launchIntentForPackage.setFlags(268435456);
        launchIntentForPackage.addFlags(536870912);
        launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.CALLBACK_FLAG, "[REDACTED]");
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "onReq" + this.mMessageExt);
        if (baseReq instanceof com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req) {
            if (baseReq instanceof com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req) {
                com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "ShowMessageFromWX.Req");
                com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req req3 = (com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req) baseReq;
                launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.MEDIA_TAG, ((com.tencent.mm.opensdk.modelmsg.WXAppExtendObject) req3.message.mediaObject).extInfo);
                wXMediaMessage = req3.message;
                launchIntentForPackage.putExtra("country", req3.country);
                launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_LANG, req3.lang);
                com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "mediaMsg.messageExt" + wXMediaMessage.messageExt);
                if (com.tencent.ysdk.libware.util.YSDKTextUtils.ckIsEmpty(wXMediaMessage.messageExt)) {
                    str3 = this.mMessageExt;
                } else {
                    str3 = wXMediaMessage.messageExt;
                }
                str4 = com.tencent.ysdk.module.user.impl.wx.WXKey.MSG_EXT;
            }
            launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.TRANSACTION_TYPE, baseReq.transaction);
            launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_OPENID, baseReq.openId);
            launchIntentForPackage.putExtra("platformId", this.mPlatformId);
            com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "打印最终给ysdk 的intent ---- s\n");
            com.tencent.ysdk.libware.file.Logger.d(launchIntentForPackage);
            com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "打印最终给ysdk 的intent ---- e\n");
            startActivity(launchIntentForPackage);
            com.tencent.ysdk.innerapi.DynamicInnerApi.handleIntent(launchIntentForPackage);
        }
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "LaunchFromWX.Req");
        launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.MEDIA_TAG, "[REDACTED]");
        com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req req4 = (com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req) baseReq;
        launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.MSG_EXT, req4.messageExt);
        launchIntentForPackage.putExtra("country", req4.country);
        str3 = req4.lang;
        str4 = com.tencent.ysdk.module.user.impl.wx.WXKey.USER_LANG;
        launchIntentForPackage.putExtra(str4, str3);
        launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.TRANSACTION_TYPE, baseReq.transaction);
        launchIntentForPackage.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_OPENID, baseReq.openId);
        launchIntentForPackage.putExtra("platformId", this.mPlatformId);
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "打印最终给ysdk 的intent ---- s\n");
        com.tencent.ysdk.libware.file.Logger.d(launchIntentForPackage);
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "打印最终给ysdk 的intent ---- e\n");
        startActivity(launchIntentForPackage);
        com.tencent.ysdk.innerapi.DynamicInnerApi.handleIntent(launchIntentForPackage);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(com.tencent.mm.opensdk.modelbase.BaseResp baseResp) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "onResp");
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setFlags(268435456);
            intent.addFlags(536870912);
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.CALLBACK_FLAG, "[REDACTED]");
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.ERROR_CODE, baseResp.errCode);
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.ERROR_DESC, baseResp.errStr);
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.TRANSACTION_TYPE, baseResp.transaction);
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_OPENID, baseResp.openId);
            intent.putExtra("platformId", this.mPlatformId);
            com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "transaction: " + baseResp.transaction);
            if (baseResp instanceof com.tencent.mm.opensdk.modelmsg.SendAuth.Resp) {
                com.tencent.mm.opensdk.modelmsg.SendAuth.Resp resp = (com.tencent.mm.opensdk.modelmsg.SendAuth.Resp) baseResp;
                com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "code: " + resp.code);
                intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_CODE, resp.code);
                intent.putExtra("country", resp.country);
                intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_LANG, resp.lang);
            }
            if ((baseResp instanceof com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp) && !android.text.TextUtils.isEmpty(baseResp.transaction) && baseResp.transaction.startsWith(com.tencent.ysdk.shell.module.share.impl.ShareModule.WX_SHARE_PREFIX)) {
                com.tencent.ysdk.libware.file.Logger.d("YSDK_USER_WX", "share code: " + baseResp.errCode);
                intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.SHARE_CODE, baseResp.errCode);
            }
            if (com.tencent.midas.api.APMidasPayAPI.WX_COUPONS.equals(baseResp.transaction)) {
                intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.MISC_CARD_LIST, this.mWxCardList);
            }
            com.tencent.ysdk.innerapi.DynamicInnerApi.handleIntent(intent);
            finish();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
