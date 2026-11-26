package com.tencent.ysdk.shell.module.user.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface UserInnerInterface {
    com.tencent.ysdk.module.user.UserLoginRet getLaunchRecord();

    com.tencent.ysdk.module.user.UserLoginRet getLoginRecord();

    java.lang.Object getPlatformObject();

    com.tencent.ysdk.module.user.WakeupRet handleIntent(android.content.Intent intent);

    void login();

    void loginWithLaunchRecord();

    void loginWithLocalRecord(boolean z);

    void loginWithMemory();

    void logout();

    boolean onActivityResult(int i, int i2, android.content.Intent intent);

    void queryUserInfo(com.tencent.ysdk.module.user.UserRelationListener userRelationListener);

    void setUserListener(com.tencent.ysdk.module.user.UserListener userListener);
}
