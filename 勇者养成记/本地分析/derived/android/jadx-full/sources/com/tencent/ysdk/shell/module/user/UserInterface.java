package com.tencent.ysdk.shell.module.user;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface UserInterface {
    void autoLogin();

    com.tencent.ysdk.framework.common.ePlatform getLaunchPlatform();

    com.tencent.ysdk.framework.common.ePlatform getLoginPlatform();

    com.tencent.ysdk.module.user.UserLoginRet getLoginRecord();

    java.lang.Object getPlatformObject(com.tencent.ysdk.framework.common.ePlatform eplatform);

    java.lang.String getRegisterChannelId();

    com.tencent.ysdk.framework.common.ePlatform getStartPlatform();

    void handleIntent(android.content.Intent intent);

    void localLogin();

    void login(com.tencent.ysdk.framework.common.ePlatform eplatform);

    void logout();

    void notifyLoginAsync(com.tencent.ysdk.module.user.UserLoginRet userLoginRet);

    void onActivityResult(int i, int i2, android.content.Intent intent);

    void onPause(android.app.Activity activity);

    void onResume(android.app.Activity activity);

    void queryUserInfo(com.tencent.ysdk.framework.common.ePlatform eplatform, com.tencent.ysdk.module.user.UserRelationListener userRelationListener);

    void setUserListener(com.tencent.ysdk.module.user.UserListener userListener);

    boolean switchUser(boolean z);
}
