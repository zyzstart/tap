package com.tencent.ysdk.shell.module.stat.delayreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DelayReportApiImpl implements com.tencent.ysdk.module.stat.IDelayReportApi {
    private static com.tencent.ysdk.module.stat.IDelayReportApi instance;

    public static com.tencent.ysdk.module.stat.IDelayReportApi getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.stat.delayreport.DelayReportApiImpl.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.stat.delayreport.DelayReportApiImpl();
                }
            }
        }
        return instance;
    }

    @Override // com.tencent.ysdk.module.stat.IDelayReportApi
    public void addDelayReport(com.tencent.ysdk.module.stat.DelayReport delayReport) {
        com.tencent.ysdk.shell.module.stat.delayreport.DelayReportManager.getInstance().addDelayReport(delayReport);
    }
}
