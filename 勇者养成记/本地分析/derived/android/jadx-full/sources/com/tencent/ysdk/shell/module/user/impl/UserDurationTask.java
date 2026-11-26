package com.tencent.ysdk.shell.module.user.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserDurationTask extends com.tencent.ysdk.shell.framework.timertask.BaseTask {
    private static final java.lang.String LOG_PARAM_GAMETIME = "gameTime";
    private static final java.lang.String LOG_PARAM_LOCALTIME = "localTime";
    public static final java.lang.String TASK_NAME = "YSDKDuration";
    private long durationTime;
    private int interval;
    private long startTime;

    public UserDurationTask() {
        super(TASK_NAME);
        this.durationTime = 0L;
        this.startTime = java.lang.System.currentTimeMillis() / 1000;
        this.interval = 1;
    }

    @Override // com.tencent.ysdk.shell.framework.timertask.BaseTask
    public int getMyInterval() {
        return this.interval;
    }

    @Override // com.tencent.ysdk.shell.framework.timertask.BaseTask
    protected int getNextEarlyRunTime() {
        return 1;
    }

    @Override // com.tencent.ysdk.shell.framework.timertask.BaseTask
    public void run() {
        this.durationTime = (java.lang.System.currentTimeMillis() / 1000) - this.startTime;
        if (this.durationTime < 600) {
            this.interval = 1;
        } else {
            this.interval = 5;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TASK_NAME, "Game time Duration :" + this.durationTime);
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_GAMETIME_TYPE, java.lang.String.valueOf(5));
        map.put(LOG_PARAM_GAMETIME, java.lang.String.valueOf(this.durationTime));
        map.put(LOG_PARAM_LOCALTIME, java.lang.String.valueOf(this.startTime));
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_USER_GAME_DURATION, 0, "", loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), false);
    }
}
