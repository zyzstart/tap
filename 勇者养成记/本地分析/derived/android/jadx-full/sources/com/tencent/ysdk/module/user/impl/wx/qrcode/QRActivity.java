package com.tencent.ysdk.module.user.impl.wx.qrcode;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QRActivity extends android.app.Activity {
    public static final java.lang.String TAG = "QRCode";
    private com.tencent.ysdk.module.user.impl.wx.qrcode.IQRCodePresenter qrCodePresenter;

    public static void enterActivity(android.content.Context context) {
        try {
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (java.lang.Exception unused) {
            com.tencent.ysdk.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.libware.file.Logger.e(TAG, "* 扫码登录Activity未声明，请对照YSDKDemo Mainfest文件中微信接入关于QRActivity的声明");
            com.tencent.ysdk.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.qrCodePresenter.responseAuthCancel();
        super.onBackPressed();
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx start qr");
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(com.tencent.ysdk.libware.ui.res.Res.layout(getResources(), "com_tencent_ysdk_qr", getPackageName()));
        com.tencent.ysdk.module.user.impl.wx.qrcode.IQRCodePresenter iQRCodePresenter = (com.tencent.ysdk.module.user.impl.wx.qrcode.IQRCodePresenter) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getQRPresenter", this);
        this.qrCodePresenter = iQRCodePresenter;
        if (iQRCodePresenter == null) {
            com.tencent.ysdk.libware.file.Logger.e("YSDK_LOGIN_WX", "qrCodePresenter is null");
        } else {
            iQRCodePresenter.auth();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.qrCodePresenter.endAuth();
        super.onDestroy();
    }
}
