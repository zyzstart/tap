package com.tencent.tmdownloader.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends com.tencent.tmassistantbase.network.f {
    protected static com.tencent.tmdownloader.internal.a.a d;

    protected a() {
    }

    public static synchronized com.tencent.tmdownloader.internal.a.a b() {
        if (d == null) {
            d = new com.tencent.tmdownloader.internal.a.a();
        }
        return d;
    }

    @Override // com.tencent.tmassistantbase.network.f
    protected void a(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3;
        byte[] bArr4;
        com.tencent.tmassistantbase.util.TMLog.i("GetConfigEngine", "onFinish enter");
        if (bArr2 == null || i != 0) {
            com.tencent.tmassistantbase.util.TMLog.i("GetConfigEngine", "onFinished errorCode = " + i + " response = " + bArr2);
            return;
        }
        com.tencent.tmassistantbase.jce.Response responseA = com.tencent.tmassistantbase.common.d.a(bArr2);
        if (responseA != null && (bArr3 = responseA.body) != null) {
            com.qq.taf.jce.JceStruct jceStructA = com.tencent.tmassistantbase.common.d.a(bArr3, com.tencent.tmassistantbase.jce.GetConfigResponse.class);
            if (jceStructA != null && (jceStructA instanceof com.tencent.tmassistantbase.jce.GetConfigResponse)) {
                for (com.tencent.tmassistantbase.jce.ConfigItem configItem : ((com.tencent.tmassistantbase.jce.GetConfigResponse) jceStructA).settingList) {
                    if (configItem != null && (bArr4 = configItem.configuration) != null) {
                        switch (configItem.type) {
                            case 5:
                                com.tencent.tmassistantbase.util.TMLog.i("GetConfigEngine", "BlackListConfig.blackList:" + ((java.lang.String) ((com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BlackListConfig) com.tencent.tmassistantbase.common.d.b(bArr4, com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BlackListConfig.class)).blackList.get(0)));
                                com.tencent.tmassistantbase.common.e.a().b(configItem.configuration);
                                break;
                            case 6:
                                com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BatchReportConfig batchReportConfig = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BatchReportConfig) com.tencent.tmassistantbase.common.d.b(bArr4, com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BatchReportConfig.class);
                                if (batchReportConfig != null) {
                                    com.tencent.tmassistantbase.util.TMLog.i("GetConfigEngine", "reportConfig.batchReportInterval = " + batchReportConfig.batchReportInterval + " reportConfig.batchReportMaxCount = " + batchReportConfig.batchReportMaxCount + " reportConfig.reportRetryCount = " + batchReportConfig.reportRetryCount);
                                    com.tencent.tmassistantbase.common.e.a().a(configItem.configuration);
                                }
                                break;
                            case 7:
                                try {
                                    com.tencent.tmassistantbase.util.TMLog.i("GetConfigEngine", "logConfig.logStatus:" + ((com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.LogConfig) com.tencent.tmassistantbase.common.d.b(bArr4, com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.LogConfig.class)).logStatus);
                                    com.tencent.tmassistantbase.common.e.a().c(configItem.configuration);
                                } catch (java.lang.Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                    }
                }
            } else {
                com.tencent.tmassistantbase.util.TMLog.i("GetConfigEngine", "GetConfigResponse is null");
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("GetConfigEngine", "onFinish exit");
    }

    public void c() {
        com.tencent.tmassistantbase.jce.GetConfigRequest getConfigRequest = new com.tencent.tmassistantbase.jce.GetConfigRequest();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        getConfigRequest.typeList = arrayList;
        arrayList.add(5);
        getConfigRequest.typeList.add(6);
        getConfigRequest.typeList.add(7);
        byte[] bArrA = com.tencent.tmassistantbase.common.d.a(com.tencent.tmassistantbase.common.d.b(getConfigRequest));
        com.tencent.tmassistantbase.util.TMLog.d("GetConfigEngine", "halleyTest sendConfigRequest begin");
        super.a(bArrA);
    }
}
