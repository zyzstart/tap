package com.tencent.ysdk.shell.framework;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKGame {
    public static final java.lang.String TAG = "YSDKGame";
    private static volatile com.tencent.ysdk.shell.framework.YSDKGame instance;
    private java.lang.String mChannelId = com.tencent.ysdk.module.user.UserLoginRet.DEFAULT_CHANNEL;
    private java.lang.String mGameVersionName = "";
    private int mGameVersionCode = 0;
    private com.tencent.ysdk.shell.framework.common.EnumScreenDir mGameScreenDir = com.tencent.ysdk.shell.framework.common.EnumScreenDir.SENSOR;

    private YSDKGame() {
    }

    private java.lang.String getChannelId(android.app.Activity activity) {
        try {
            java.lang.String channel = com.tencent.ysdk.shell.framework.channel.ApkChannelTool.readChannel(activity.getPackageCodePath());
            com.tencent.ysdk.shell.libware.file.Logger.d("Comment: " + channel);
            return !android.text.TextUtils.isEmpty(channel) ? channel : com.tencent.ysdk.module.user.UserLoginRet.DEFAULT_CHANNEL;
        } catch (java.io.IOException unused) {
            com.tencent.ysdk.shell.libware.file.Logger.e("Read apk file for channelId Error");
            return com.tencent.ysdk.module.user.UserLoginRet.DEFAULT_CHANNEL;
        }
    }

    public static com.tencent.ysdk.shell.framework.YSDKGame getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.YSDKGame.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.framework.YSDKGame();
                }
            }
        }
        return instance;
    }

    private int parseGameVersionCode(android.app.Activity activity) {
        return com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionCode(activity, com.tencent.ysdk.shell.framework.wrapper.ContextProxy.getPackageName(activity));
    }

    private java.lang.String parseGameVersionName(android.app.Activity activity) {
        return com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(activity, com.tencent.ysdk.shell.framework.wrapper.ContextProxy.getPackageName(activity));
    }

    protected java.lang.String getChannelId() {
        return this.mChannelId;
    }

    protected com.tencent.ysdk.shell.framework.common.EnumScreenDir getGameScreenDir() {
        return this.mGameScreenDir;
    }

    protected int getGameVersionCode() {
        return this.mGameVersionCode;
    }

    protected java.lang.String getGameVersionName() {
        return this.mGameVersionName;
    }

    public void init(android.app.Activity activity) {
        this.mChannelId = getChannelId(activity);
        this.mGameVersionName = parseGameVersionName(activity);
        this.mGameVersionCode = parseGameVersionCode(activity);
        try {
            this.mGameScreenDir = com.tencent.ysdk.shell.framework.common.EnumScreenDir.getEnum(com.tencent.ysdk.shell.framework.wrapper.ContextProxy.getActivityInfo(activity, com.tencent.ysdk.shell.framework.wrapper.ContextProxy.getPackageName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()), activity.getClass().getName()));
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }

    protected boolean isDefaultChannel(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.equals(com.tencent.ysdk.module.user.UserLoginRet.DEFAULT_CHANNEL)) {
            return true;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "reg channel is not default");
        return false;
    }

    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
    }

    protected void onDestroy(android.app.Activity activity) {
    }

    protected void onNewIntent(android.content.Intent intent) {
    }

    protected void onPause(android.app.Activity activity) {
    }

    protected void onRestart(android.app.Activity activity) {
    }

    protected void onResume(android.app.Activity activity) {
    }

    protected void onStop(android.app.Activity activity) {
    }
}
