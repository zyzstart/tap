package com.tencent.ysdk.shell.framework.timertask;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class BaseTask {
    private int notifiedTimes = 0;
    private java.lang.String mTaskName = "";

    public BaseTask(java.lang.String str) {
        setTaskName(str);
    }

    public abstract int getMyInterval();

    protected abstract int getNextEarlyRunTime();

    public final int getNotifiedTimes() {
        return this.notifiedTimes;
    }

    public java.lang.String getTaskName() {
        return this.mTaskName;
    }

    public final void increaseNotifiedTimes() {
        this.notifiedTimes++;
    }

    public void letTaskRunEarly() {
        this.notifiedTimes = getMyInterval() - getNextEarlyRunTime();
    }

    public final void resetNotifiedTimes() {
        this.notifiedTimes = 0;
    }

    public abstract void run();

    public void setTaskName(java.lang.String str) {
        this.mTaskName = str;
    }
}
