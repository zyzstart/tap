package com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FullScreenPic {
    public static java.lang.String TAG = "FullScreenPic";
    private static volatile com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPic instance;
    private android.app.Activity mContext;
    private com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter mPresenter;
    private com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicView mView;

    private FullScreenPic(android.app.Activity activity) {
        this.mContext = activity;
    }

    public static synchronized com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPic getInstance(android.app.Activity activity) {
        if (instance == null) {
            instance = new com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPic(activity);
        }
        return instance;
    }

    public void showPic(java.util.ArrayList<java.lang.String> arrayList, int i) {
        this.mView = new com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicView(this.mContext);
        this.mPresenter = new com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter();
        this.mView.setPresenter((com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.Presenter) this.mPresenter);
        this.mView.showPic(arrayList, i);
    }
}
