package com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface FullScreenPicContract {

    public interface Presenter extends com.tencent.ysdk.shell.framework.mvp.BasePresenter {
        void close();

        void showPic(com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.View view, java.util.ArrayList<java.lang.String> arrayList, int i);
    }

    public interface View extends com.tencent.ysdk.shell.framework.mvp.BaseView<com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.Presenter> {
        void close();

        android.content.Context getContext();

        void setAdapter(com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.FullPicAdapter fullPicAdapter);

        void setCurrentView(int i);

        void showPic(java.util.ArrayList<java.lang.String> arrayList, int i);
    }
}
