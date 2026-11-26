package com.tencent.ysdk.shell.module.realName;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface RealNameInterface {
    public static final java.lang.String LOG_TAG = "YSDK_RealName";

    com.tencent.ysdk.framework.common.ePlatform getUserLoginPltform();

    java.lang.String getUserNickname();

    void notifyRegisterRealNameToLoginModule(com.tencent.ysdk.framework.common.BaseRet baseRet);

    void registerRealName(com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara registerRealNameRequestPara, com.tencent.ysdk.shell.module.realName.RealNameInnerListener realNameInnerListener);

    void showRegisterPage(com.tencent.ysdk.framework.common.ePlatform eplatform, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.ysdk.shell.module.realName.RealNameInnerListener realNameInnerListener);
}
