package com.tencent.ysdk.module.user.impl.freelogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IFreeLoginUserApi {
    java.lang.String getLoginInfo();

    com.tencent.ysdk.framework.common.ePlatform getLoginPlatformFormInfo();

    boolean isDebug();

    boolean isFreeAutoLoginValid();

    int loginBeforeCheck(com.tencent.ysdk.framework.common.ePlatform eplatform, com.tencent.ysdk.module.user.UserLoginRet userLoginRet);

    void setLoginInfo(java.lang.String str);
}
