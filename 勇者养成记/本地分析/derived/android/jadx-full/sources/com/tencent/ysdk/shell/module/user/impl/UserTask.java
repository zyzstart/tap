package com.tencent.ysdk.shell.module.user.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserTask extends com.tencent.ysdk.shell.framework.timertask.BaseTask {
    private static final int TASK_AUTO_LOGIN_DEFAULT_INTERVAL = 30;
    private static final int TASK_AUTO_LOGIN_MAX_INTERVAL = 90;
    private static final int TASK_AUTO_LOGIN_MIN_INTERVAL = 10;
    public static final java.lang.String TASK_NAME = "YSDKAutoLogin";
    private static final int TASK_NEXT_LOGIN_DEFAULT_INTERVAL = 5;
    private static final int TASK_NEXT_LOGIN_MAX_INTERVAL = 10;
    private static final int TASK_NEXT_LOGIN_MIN_INTERVAL = 1;
    private int mRealTaskInterval;

    public UserTask() {
        super(TASK_NAME);
        this.mRealTaskInterval = 0;
    }

    @Override // com.tencent.ysdk.shell.framework.timertask.BaseTask
    public int getMyInterval() {
        java.lang.String config = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_USER_AUTO_LOGIN_INTERVAL, "");
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(config)) {
            this.mRealTaskInterval = 30;
        } else {
            try {
                int i = java.lang.Integer.parseInt(config);
                if (i > 90) {
                    this.mRealTaskInterval = 90;
                } else if (i < 10) {
                    this.mRealTaskInterval = 10;
                } else {
                    this.mRealTaskInterval = i;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                this.mRealTaskInterval = 30;
            }
        }
        return this.mRealTaskInterval;
    }

    @Override // com.tencent.ysdk.shell.framework.timertask.BaseTask
    protected int getNextEarlyRunTime() {
        int config = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_USER_NEXT_AUTO_LOGIN_INTERVAL, 5);
        int i = this.mRealTaskInterval;
        if (config > i) {
            config = i / 2;
        } else if (config > 10) {
            this.mRealTaskInterval = 10;
        } else if (config < 1) {
            this.mRealTaskInterval = 1;
        } else {
            this.mRealTaskInterval = config;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("nextLoginTime" + config);
        return config;
    }

    @Override // com.tencent.ysdk.shell.framework.timertask.BaseTask
    public void run() {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.UserModule.LOG_TAG, "auto login！");
        com.tencent.ysdk.shell.module.user.UserApi.getInstance().autoLogin();
    }
}
