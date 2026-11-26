package com.tencent.ysdk.shell.module.user.impl.wx.qrcode;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QRCodePresenter implements com.tencent.ysdk.module.user.impl.wx.qrcode.IQRCodePresenter {
    private static final int ERROR_CODE_NATIVE = -1000;
    private static final java.lang.String EVENT_API = "YSDK_User_Login_FirstScanLogin_WX_API_REQUEST";
    private static final java.lang.String EVENT_RESULT = "YSDK_User_Login_FirstScanLogin_WX_RESULT";
    private static final java.lang.String EVENT_SCAN = "YSDK_User_Login_FirstScanLogin_WX_SCAN";
    private static final java.lang.String EVENT_START = "YSDK_User_Login_FirstScanLogin_WX_START";
    private static final java.lang.String STAT_LOGIN_PLATFORM_WX = "wx";
    private android.app.Activity mActivity;
    private com.tencent.mm.opensdk.diffdev.IDiffDevOAuth oAuth;
    private com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeView qrCodeView = new com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeView(this);
    private com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeModel qrCodeModel = new com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeModel(this);

    public QRCodePresenter(android.app.Activity activity) {
        this.mActivity = activity;
    }

    public static com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter getInstance(android.app.Activity activity) {
        return new com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestQRCode(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.TAG, "QRAuth requestQRCode");
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_WX", "wx auth");
        if (this.oAuth == null) {
            this.oAuth = com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory.getDiffDevOAuth();
        }
        this.oAuth.auth(str, str2, str3, str4, str5, new com.tencent.mm.opensdk.diffdev.OAuthListener() { // from class: com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.2
            @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
            public void onAuthFinish(com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode, java.lang.String str6) {
                com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_WX", "wx auth finish " + oAuthErrCode.name());
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.this.qrCodeView.hideQRCode();
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.this.responseAuthResult(oAuthErrCode.getCode(), oAuthErrCode.name(), str6);
            }

            @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
            public void onAuthGotQrcode(java.lang.String str6, byte[] bArr) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.TAG, "QRCode Path :" + str6);
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.TAG, "QRCode byte length :" + (bArr == null ? 0 : bArr.length));
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.this.qrCodeView.showQRCode(bArr);
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.this.qrCodeView.hideLoading();
            }

            @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
            public void onQrcodeScanned() {
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.this.qrCodeView.showScanedInfo();
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.this.reportWXScanEvent(com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.EVENT_SCAN, "", 0, "", null, java.lang.System.currentTimeMillis(), true);
            }
        });
    }

    private void requestQRCodeParam() {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.TAG, "QRAuth requestQRCodeParam");
        this.qrCodeModel.requestForAuthParam(new com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeModel.AuthParamCallBack() { // from class: com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.1
            @Override // com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeModel.AuthParamCallBack
            public void onError(int i, java.lang.String str) {
                com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_WX", "wx request qr fail " + i + " , msg " + str);
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.this.qrCodeView.hideLoading();
                com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.TAG, "ErrCode: " + i + " Err:" + str);
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.this.reportWXScanEvent(com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.EVENT_API, "", i, str, null, java.lang.System.currentTimeMillis(), true);
            }

            @Override // com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeModel.AuthParamCallBack
            public void onSuccess(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
                com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_WX", "wx request qr succ");
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.this.requestQRCode(str, str2, str3, str4, str5);
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.this.reportWXScanEvent(com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.EVENT_API, "", 0, "", null, java.lang.System.currentTimeMillis(), true);
            }
        });
    }

    @Override // com.tencent.ysdk.module.user.impl.wx.qrcode.IQRCodePresenter
    public void auth() {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.TAG, "QRAuth Start");
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_WX", "wx qr auth");
        try {
            this.qrCodeView.showLoading();
            requestQRCodeParam();
            reportWXScanEvent(EVENT_START, "", 0, "", null, java.lang.System.currentTimeMillis(), true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            reportWXScanEvent(EVENT_START, "", -1000, "Native Exception", null, java.lang.System.currentTimeMillis(), true);
        }
    }

    @Override // com.tencent.ysdk.module.user.impl.wx.qrcode.IQRCodePresenter
    public void endAuth() {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.TAG, "QRAuth Stop");
        com.tencent.mm.opensdk.diffdev.IDiffDevOAuth iDiffDevOAuth = this.oAuth;
        if (iDiffDevOAuth != null) {
            iDiffDevOAuth.stopAuth();
            this.oAuth.removeAllListeners();
        }
    }

    public android.app.Activity getActivity() {
        return this.mActivity;
    }

    protected void reportWXScanEvent(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map, long j, boolean z) {
        java.util.Map<java.lang.String, java.lang.String> map2 = map != null ? map : new java.util.HashMap();
        try {
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOGIN_TICKET, "" + str2);
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
            map2.put("offerid", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId());
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_PLATFORM, "wx");
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_TYPE, "5");
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_LOCAL_ERROR_CODE, java.lang.String.valueOf(i));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(str, i, str3, map2, j, z);
        if (str.equals(EVENT_RESULT)) {
            if (i == com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK.getCode()) {
                com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_USER_LOGIN_SUCCESS, i, str3, map2, j, z, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, "");
            } else {
                com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_USER_LOGIN_FAIL, i, str3, map2, j, z, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, "");
            }
        }
    }

    @Override // com.tencent.ysdk.module.user.impl.wx.qrcode.IQRCodePresenter
    public void responseAuthCancel() {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.TAG, "QRAuth responseAuthCancel");
        try {
            android.content.Intent intent = new android.content.Intent(this.mActivity, java.lang.Class.forName(this.mActivity.getPackageManager().getLaunchIntentForPackage(this.mActivity.getPackageName()).getComponent().getClassName()));
            intent.setFlags(268435456);
            intent.addFlags(536870912);
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.CALLBACK_FLAG, "[REDACTED]");
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.ERROR_CODE, com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel.getCode());
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.ERROR_DESC, com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel.name());
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.TRANSACTION_TYPE, com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WX_LOGIN_TRANSACTION);
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_CODE, "[REDACTED]");
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().handleIntent(intent);
            reportWXScanEvent(EVENT_RESULT, "", com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel.getCode(), com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel.name(), null, java.lang.System.currentTimeMillis(), true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            this.mActivity.finish();
        }
    }

    public void responseAuthResult(int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.TAG, "QRAuth responseAuthResult");
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_WX", "wx responseAuthResult " + i + " , errStr : " + str);
        try {
            android.content.Intent intent = new android.content.Intent(this.mActivity, java.lang.Class.forName(this.mActivity.getPackageManager().getLaunchIntentForPackage(this.mActivity.getPackageName()).getComponent().getClassName()));
            intent.setFlags(268435456);
            intent.addFlags(536870912);
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.CALLBACK_FLAG, "[REDACTED]");
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.ERROR_CODE, i);
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.ERROR_DESC, str);
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.TRANSACTION_TYPE, com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WX_LOGIN_TRANSACTION);
            intent.putExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_CODE, str2);
            reportWXScanEvent(EVENT_RESULT, str2, i, str, null, java.lang.System.currentTimeMillis(), true);
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_WX", "wx handleIntent");
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().handleIntent(intent);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            this.mActivity.finish();
        }
    }
}
