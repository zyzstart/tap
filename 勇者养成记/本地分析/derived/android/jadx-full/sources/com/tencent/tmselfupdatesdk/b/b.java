package com.tencent.tmselfupdatesdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends com.tencent.tmassistantbase.network.f {
    private com.tencent.tmselfupdatesdk.b.c d;

    public void a(com.tencent.tmselfupdatesdk.b.c cVar) {
        this.d = cVar;
    }

    public void a(com.tencent.tmselfupdatesdk.b.d dVar) {
        com.tencent.tmassistantbase.jce.Request requestB = com.tencent.tmassistantbase.common.d.b(new com.tencent.tmassistantbase.jce.GetHotSdkUpdateRequest());
        if (dVar == null || dVar.k || dVar.l) {
            com.tencent.tmassistantbase.jce.SdkInfo sdkInfo = requestB.head.sdkInfo;
            sdkInfo.name = "selfUpdate";
            sdkInfo.versionName = "3.0.1";
            sdkInfo.versionCode = 3010;
            sdkInfo.builderNum = "33";
        } else {
            com.tencent.tmassistantbase.jce.SdkInfo sdkInfo2 = requestB.head.sdkInfo;
            sdkInfo2.name = dVar.e;
            sdkInfo2.versionName = dVar.f;
            sdkInfo2.versionCode = dVar.g;
            sdkInfo2.builderNum = java.lang.String.valueOf(dVar.h);
        }
        com.tencent.tmassistantbase.util.x.a("GetHotSdkUpdate", "发送更新请求：\nname:" + requestB.head.sdkInfo.name + "\nversionName:" + requestB.head.sdkInfo.versionName + "\nversionCode:" + requestB.head.sdkInfo.versionCode + "\nbuildNum:" + requestB.head.sdkInfo.builderNum);
        a(com.tencent.tmassistantbase.common.d.a(requestB));
    }

    @Override // com.tencent.tmassistantbase.network.f
    protected void a(byte[] bArr, byte[] bArr2, int i) {
        com.tencent.tmassistantbase.util.x.a("GetHotSdkUpdate", "GetHotSdkUpdateEngine onFinish enter. errorCode=" + i);
        if (bArr2 == null || i != 0) {
            com.tencent.tmassistantbase.util.x.b("GetHotSdkUpdate", "onFinished errorCode = " + i + " response = " + bArr2);
            com.tencent.tmselfupdatesdk.b.c cVar = this.d;
            if (cVar != null) {
                cVar.a(i);
                return;
            }
            return;
        }
        com.tencent.tmassistantbase.jce.Response responseA = com.tencent.tmassistantbase.common.d.a(bArr2);
        if (responseA == null || responseA.body == null) {
            com.tencent.tmselfupdatesdk.b.c cVar2 = this.d;
            if (cVar2 != null) {
                cVar2.a(-10087);
            }
            com.tencent.tmassistantbase.util.x.b("GetHotSdkUpdate", "GetHotSdkUpdateEngine. unpackPackage error! jceResp is null!");
            return;
        }
        com.tencent.tmassistantbase.util.x.a("GetHotSdkUpdate", "jceResp.body.length=" + responseA.body.length);
        com.qq.taf.jce.JceStruct jceStructA = com.tencent.tmassistantbase.common.d.a(responseA.body, com.tencent.tmassistantbase.jce.GetHotSdkUpdateResponse.class);
        if (jceStructA != null && (jceStructA instanceof com.tencent.tmassistantbase.jce.GetHotSdkUpdateResponse)) {
            com.tencent.tmselfupdatesdk.b.c cVar3 = this.d;
            if (cVar3 != null) {
                cVar3.a((com.tencent.tmassistantbase.jce.GetHotSdkUpdateResponse) jceStructA);
                return;
            }
            return;
        }
        com.tencent.tmassistantbase.util.x.b("GetHotSdkUpdate", "GetHotSdkUpdateEngine. unpageageJceResponse error! jceResponse is null!");
        com.tencent.tmselfupdatesdk.b.c cVar4 = this.d;
        if (cVar4 != null) {
            cVar4.a(-10086);
        }
    }
}
