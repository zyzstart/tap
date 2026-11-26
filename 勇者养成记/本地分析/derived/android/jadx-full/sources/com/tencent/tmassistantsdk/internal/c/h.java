package com.tencent.tmassistantsdk.internal.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h extends com.tencent.tmassistantsdk.internal.c.a {
    protected static com.tencent.tmassistantsdk.internal.c.h d;

    private h() {
    }

    public static synchronized com.tencent.tmassistantsdk.internal.c.h h() {
        if (d == null) {
            d = new com.tencent.tmassistantsdk.internal.c.h();
        }
        return d;
    }

    public com.tencent.tmassistantsdk.internal.protocol.jce.TipsInfoLog a(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedInfo tMAssistantAuthorizedInfo) {
        com.tencent.tmassistantbase.util.TMLog.i("TipsInfoReportManager", "createTipsInfoLog");
        if (tMAssistantAuthorizedInfo == null) {
            return null;
        }
        com.tencent.tmassistantsdk.internal.protocol.jce.TipsInfoLog tipsInfoLog = new com.tencent.tmassistantsdk.internal.protocol.jce.TipsInfoLog();
        tipsInfoLog.userId = tMAssistantAuthorizedInfo.userId;
        tipsInfoLog.userIdType = tMAssistantAuthorizedInfo.userIdType;
        tipsInfoLog.gamePackageName = tMAssistantAuthorizedInfo.gamePackageName;
        tipsInfoLog.gameVersionCode = java.lang.Integer.parseInt(tMAssistantAuthorizedInfo.gameVersionCode);
        tipsInfoLog.gameChannelId = tMAssistantAuthorizedInfo.gameChannelId;
        return tipsInfoLog;
    }

    @Override // com.tencent.tmassistantsdk.internal.c.a
    protected com.tencent.tmassistantsdk.internal.e.a.a e() {
        return com.tencent.tmassistantsdk.internal.e.a.d.f();
    }

    @Override // com.tencent.tmassistantsdk.internal.c.a
    protected byte f() {
        return (byte) 1;
    }

    @Override // com.tencent.tmassistantsdk.internal.c.a
    protected boolean g() {
        return true;
    }
}
