package com.tencent.ysdk.shell.module.cloud.tasks.wakeup;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LastWakeUpInfo {
    private int lastWakeCount;
    private long lastWakeTimeStamp;

    public LastWakeUpInfo(long j, int i) {
        this.lastWakeTimeStamp = j;
        this.lastWakeCount = i;
    }

    public int getLastWakeCount() {
        return this.lastWakeCount;
    }

    public long getLastWakeTimeStamp() {
        return this.lastWakeTimeStamp;
    }
}
