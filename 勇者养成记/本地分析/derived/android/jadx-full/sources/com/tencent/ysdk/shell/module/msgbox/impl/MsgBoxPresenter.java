package com.tencent.ysdk.shell.module.msgbox.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MsgBoxPresenter implements com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxContract.Presenter, com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.OnNewDataListener {
    private com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxContract.View mView;

    public MsgBoxPresenter(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxContract.View view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override // com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.OnNewDataListener
    public void onNewData(com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        this.mView.showMsg(msgItem);
    }

    @Override // com.tencent.ysdk.shell.framework.mvp.BasePresenter
    public void start() {
    }
}
