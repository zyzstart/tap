package com.tencent.ysdk.shell.module.msgbox.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MsgBoxContract {

    interface Presenter extends com.tencent.ysdk.shell.framework.mvp.BasePresenter {
    }

    interface View extends com.tencent.ysdk.shell.framework.mvp.BaseView<com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxContract.Presenter> {
        void showMsg(com.tencent.ysdk.module.msgbox.MsgItem msgItem);
    }
}
