package com.tencent.ysdk.module.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DelayReport {
    private static final java.lang.String TAG = "YSDK.DelayReport";
    private java.lang.Runnable reportCommand;

    public DelayReport(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        this.reportCommand = runnable;
    }

    public void execute() {
        if (this.reportCommand != null) {
            com.tencent.ysdk.libware.file.Logger.d(TAG, "report execute");
            this.reportCommand.run();
        }
    }
}
