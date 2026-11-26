package com.tencent.ysdk.shell.module.user.impl.wx.qrcode;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QRCodeModel {
    private com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeModel.AuthParamCallBack callBack;
    private com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter qrCodePresenter;

    public interface AuthParamCallBack {
        void onError(int i, java.lang.String str);

        void onSuccess(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);
    }

    private class WXScanLoginResponseHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForloginResponse> {
        private WXScanLoginResponseHandler() {
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForloginResponse wXUserScanForloginResponse) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.TAG, wXUserScanForloginResponse.toString());
            if (wXUserScanForloginResponse.ret == 0) {
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeModel.this.callBack.onSuccess(wXUserScanForloginResponse.appid, wXUserScanForloginResponse.scope, wXUserScanForloginResponse.noncestr, wXUserScanForloginResponse.timestamp, wXUserScanForloginResponse.signature);
            } else {
                com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeModel.this.callBack.onError(wXUserScanForloginResponse.flag, wXUserScanForloginResponse.msg);
            }
        }
    }

    public QRCodeModel(com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter qRCodePresenter) {
        this.qrCodePresenter = qRCodePresenter;
    }

    public void requestForAuthParam(com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeModel.AuthParamCallBack authParamCallBack) {
        this.callBack = authParamCallBack;
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForLoginCodeRequest(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId(), com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId(), "snsapi_userinfo,snsapi_friend,snsapi_message", java.lang.String.valueOf(new java.util.Random(java.lang.System.currentTimeMillis()).nextLong()), java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000), new com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodeModel.WXScanLoginResponseHandler()));
    }
}
