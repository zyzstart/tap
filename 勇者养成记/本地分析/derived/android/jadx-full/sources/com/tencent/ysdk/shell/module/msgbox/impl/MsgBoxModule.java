package com.tencent.ysdk.shell.module.msgbox.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MsgBoxModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.msgbox.MsgBoxInterface {
    public static final java.lang.String TAG = "YSDK MSGBOX";
    private com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource mDataSource;
    private com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxPresenter mPresenter;
    private com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView mView;

    public MsgBoxModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_MSGBOX;
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_MSG_BOX_SWITCH, true)) {
            com.tencent.ysdk.shell.libware.file.Logger.w(TAG, "MsgBox is closed");
            return;
        }
        this.mView = new com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView();
        this.mPresenter = new com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxPresenter(this.mView);
        this.mDataSource = new com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource(this.mPresenter);
    }

    @Override // com.tencent.ysdk.shell.module.msgbox.MsgBoxInterface
    public void showJsonMsg(java.lang.String str) {
        this.mDataSource.showJsonMsg(str);
    }

    @Override // com.tencent.ysdk.shell.module.msgbox.MsgBoxInterface
    public void showObjMsg(com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        this.mPresenter.onNewData(msgItem);
    }
}
