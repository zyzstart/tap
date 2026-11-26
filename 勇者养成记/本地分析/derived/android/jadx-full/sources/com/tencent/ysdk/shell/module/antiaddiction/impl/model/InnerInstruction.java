package com.tencent.ysdk.shell.module.antiaddiction.impl.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class InnerInstruction {
    private com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet mInstruction;
    private com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack mLoginCallback;
    private com.tencent.ysdk.shell.module.antiaddiction.impl.model.VisitorLoginModel mVisitorLoginModel;

    public InnerInstruction(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet, com.tencent.ysdk.shell.module.antiaddiction.impl.model.VisitorLoginModel visitorLoginModel, com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack loginAntiAddictCallBack) {
        this.mInstruction = antiAddictRet;
        this.mLoginCallback = loginAntiAddictCallBack;
        this.mVisitorLoginModel = visitorLoginModel;
    }

    public com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet getInstruction() {
        return this.mInstruction;
    }

    public com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack getLoginCallback() {
        return this.mLoginCallback;
    }

    public com.tencent.ysdk.shell.module.antiaddiction.impl.model.VisitorLoginModel getVisitorLoginModel() {
        return this.mVisitorLoginModel;
    }
}
