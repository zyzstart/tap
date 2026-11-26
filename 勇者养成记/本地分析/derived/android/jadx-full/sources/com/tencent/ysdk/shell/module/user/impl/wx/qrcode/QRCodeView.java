package com.tencent.ysdk.shell.module.user.impl.wx.qrcode;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QRCodeView {
    private boolean isLoadingShowing;
    private boolean isQRCodeShowing;
    private android.widget.ProgressBar loadingIm;
    private android.widget.ImageView qrCodeIm;
    private com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter qrCodePresenter;
    private android.widget.TextView tipsTv;

    public QRCodeView(com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter qRCodePresenter) {
        android.app.Activity activity = qRCodePresenter.getActivity();
        android.content.res.Resources resources = activity.getResources();
        java.lang.String packageName = activity.getPackageName();
        this.qrCodeIm = (android.widget.ImageView) activity.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(resources, "com_tencent_ysdk_qrCodeIm", packageName));
        this.tipsTv = (android.widget.TextView) activity.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(resources, "com_tencent_ysdk_tipsTv", packageName));
        this.loadingIm = (android.widget.ProgressBar) activity.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(resources, "com_tencent_ysdk_loadingIm", packageName));
    }

    public void hideLoading() {
        if (this.isLoadingShowing) {
            this.isLoadingShowing = false;
            this.loadingIm.setVisibility(4);
        }
    }

    public void hideQRCode() {
        if (this.isQRCodeShowing) {
            this.isQRCodeShowing = false;
            this.qrCodeIm.setVisibility(4);
            this.tipsTv.setText("");
        }
    }

    public void showLoading() {
        if (this.isLoadingShowing) {
            return;
        }
        this.isLoadingShowing = true;
        this.loadingIm.setVisibility(0);
    }

    public void showQRCode(byte[] bArr) {
        if (this.isQRCodeShowing || bArr == null) {
            return;
        }
        this.qrCodeIm.setVisibility(0);
        this.qrCodeIm.setImageBitmap(android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        this.isQRCodeShowing = true;
        this.tipsTv.setText("请用手机微信扫描二维码登录");
    }

    public void showScanedInfo() {
        if (this.isQRCodeShowing) {
            this.tipsTv.setText("请在手机上完成授权操作");
        }
    }
}
