package com.tencent.tmassistantsdk.internal.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends com.tencent.tmassistantsdk.internal.c.a {
    protected static com.tencent.tmassistantsdk.internal.c.b d;

    private b() {
    }

    public static java.lang.String a(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (tMAssistantCallYYBParamStruct != null) {
            stringBuffer.append(com.tencent.tmassistantbase.util.k.b(com.tencent.tmassistantbase.util.k.a().b()));
            stringBuffer.append("_");
            stringBuffer.append(java.lang.String.valueOf(com.tencent.tmassistantbase.util.k.c(com.tencent.tmassistantbase.util.k.a().b())));
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.channelId);
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.via);
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.uin);
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.taskAppId);
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.taskPackageName);
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.taskVersion);
        }
        com.tencent.tmassistantbase.util.TMLog.i("BusinessReportManager", "logStr=" + ((java.lang.Object) stringBuffer));
        return stringBuffer.toString();
    }

    public static synchronized com.tencent.tmassistantsdk.internal.c.b h() {
        if (d == null) {
            d = new com.tencent.tmassistantsdk.internal.c.b();
        }
        return d;
    }

    public com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.tmassistantbase.util.TMLog.i("BusinessReportManager", "createTipsInfoLog");
        com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport statStdReport = new com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport();
        statStdReport.name = str3;
        statStdReport.time = java.lang.System.currentTimeMillis();
        statStdReport.versionInfo = "1004";
        statStdReport.extraData = str;
        statStdReport.traceId = str2;
        return statStdReport;
    }

    @Override // com.tencent.tmassistantsdk.internal.c.a
    protected com.tencent.tmassistantsdk.internal.e.a.a e() {
        return com.tencent.tmassistantsdk.internal.e.a.c.f();
    }

    @Override // com.tencent.tmassistantsdk.internal.c.a
    protected byte f() {
        return (byte) 3;
    }

    @Override // com.tencent.tmassistantsdk.internal.c.a
    protected boolean g() {
        return true;
    }
}
