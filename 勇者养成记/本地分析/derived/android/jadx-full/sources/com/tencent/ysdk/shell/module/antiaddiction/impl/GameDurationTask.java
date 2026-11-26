package com.tencent.ysdk.shell.module.antiaddiction.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GameDurationTask extends com.tencent.ysdk.shell.framework.timertask.BaseTask {
    private static final int INTERVAL = 5;
    private static final int MAX_ANTI_DURATION = 300;
    public static final java.lang.String TASK_NAME = "YSDKGameDuration";
    private com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.JudgeTimingResponseHandler mHandler;
    private boolean mIsVisitorSwitch;
    private long mStartTime;

    public GameDurationTask(com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.JudgeTimingResponseHandler judgeTimingResponseHandler, boolean z) {
        super(TASK_NAME);
        this.mStartTime = java.lang.System.currentTimeMillis() / 1000;
        this.mHandler = judgeTimingResponseHandler;
        this.mIsVisitorSwitch = z;
    }

    public int getDuration() {
        int iCurrentTimeMillis = (int) ((java.lang.System.currentTimeMillis() / 1000) - this.mStartTime);
        if (iCurrentTimeMillis >= 300) {
            return 300;
        }
        return iCurrentTimeMillis;
    }

    @Override // com.tencent.ysdk.shell.framework.timertask.BaseTask
    public int getMyInterval() {
        return 5;
    }

    @Override // com.tencent.ysdk.shell.framework.timertask.BaseTask
    protected int getNextEarlyRunTime() {
        return 0;
    }

    @Override // com.tencent.ysdk.shell.framework.timertask.BaseTask
    public void run() {
        int duration = getDuration();
        this.mStartTime = java.lang.System.currentTimeMillis() / 1000;
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam judgeTimingRequestParam = new com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam();
        judgeTimingRequestParam.factType = 12;
        judgeTimingRequestParam.platform = com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform);
        judgeTimingRequestParam.openId = loginRecord.open_id;
        judgeTimingRequestParam.duration = duration;
        judgeTimingRequestParam.visitorSwitch = this.mIsVisitorSwitch ? 1 : 0;
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.antiaddiction.impl.http.request.JudgeTimingRequest(judgeTimingRequestParam, this.mHandler));
    }
}
