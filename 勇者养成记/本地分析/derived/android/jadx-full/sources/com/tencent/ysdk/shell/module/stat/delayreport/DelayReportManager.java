package com.tencent.ysdk.shell.module.stat.delayreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DelayReportManager {
    private static final java.lang.String TAG = "DelayReportManager";
    private static volatile com.tencent.ysdk.shell.module.stat.delayreport.DelayReportManager instance;
    private java.util.Queue<com.tencent.ysdk.module.stat.DelayReport> delayReportQueue = new java.util.ArrayDeque();

    private DelayReportManager() {
    }

    public static com.tencent.ysdk.shell.module.stat.delayreport.DelayReportManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.stat.delayreport.DelayReportManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.stat.delayreport.DelayReportManager();
                }
            }
        }
        return instance;
    }

    public void addDelayReport(com.tencent.ysdk.module.stat.DelayReport delayReport) {
        this.delayReportQueue.add(delayReport);
    }

    public void report() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isInit()) {
            while (!this.delayReportQueue.isEmpty()) {
                com.tencent.ysdk.module.stat.DelayReport delayReportRemove = this.delayReportQueue.remove();
                if (delayReportRemove != null) {
                    delayReportRemove.execute();
                }
            }
        }
    }
}
