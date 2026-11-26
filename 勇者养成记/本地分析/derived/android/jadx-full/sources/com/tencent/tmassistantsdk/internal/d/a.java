package com.tencent.tmassistantsdk.internal.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends com.tencent.tmassistantbase.network.a {
    protected com.tencent.tmassistantsdk.internal.d.b c = null;

    private com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.b a(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.c cVar;
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.b bVar = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.b();
        bVar.f1089a = jSONObject.getInt("hasAuthoried");
        bVar.c = jSONObject.getInt(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE);
        bVar.d = jSONObject.getString("downloadUrl");
        bVar.e = jSONObject.getInt("versionCode");
        org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("tipsInfo");
        if (jSONObject2 == null || jSONObject2.length() <= 0) {
            cVar = null;
        } else {
            cVar = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.c();
            cVar.f1090a = jSONObject2.getString("title");
            cVar.b = jSONObject2.getString("content");
            org.json.JSONArray jSONArray = jSONObject2.getJSONArray("actionButton");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a aVar = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a();
                    aVar.f1088a = jSONArray.getJSONObject(i).getString("textInstalled");
                    aVar.b = jSONArray.getJSONObject(i).getString("textUninstalled");
                    aVar.c = jSONArray.getJSONObject(i).getInt("jumpType");
                    aVar.d = jSONArray.getJSONObject(i).getString("jumpUrl");
                    arrayList.add(aVar);
                }
            }
            cVar.c = arrayList;
        }
        bVar.b = cVar;
        com.tencent.tmassistantbase.util.TMLog.i("GetAuthorizedHttpRequest", "dataInfo :" + bVar.toString());
        return bVar;
    }

    private java.lang.String b(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedInfo tMAssistantAuthorizedInfo) {
        return ((((((((((("?appId=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.appId)) + "&userId=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.userId)) + "&userIdType=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.userIdType)) + "&identityInfo=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.identityInfo)) + "&identityType=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.identityType)) + "&gamePackageName=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.gamePackageName)) + "&gameVersionCode=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.gameVersionCode)) + "&gameChannelId=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.gameChannelId)) + "&actionFlag=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.actionFlag)) + "&verifyType=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.verifyType)) + "&via=" + java.net.URLEncoder.encode(tMAssistantAuthorizedInfo.via)) + "&actionType=" + tMAssistantAuthorizedInfo.actionType;
    }

    public void a(com.tencent.tmassistantsdk.internal.d.b bVar) {
        this.c = bVar;
    }

    public void a(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedInfo tMAssistantAuthorizedInfo) {
        com.tencent.tmassistantbase.util.TMLog.i("GetAuthorizedHttpRequest", "authorizedInfo = " + tMAssistantAuthorizedInfo);
        if (tMAssistantAuthorizedInfo != null) {
            super.a(b(tMAssistantAuthorizedInfo));
        }
    }

    @Override // com.tencent.tmassistantbase.network.a
    protected void a(org.json.JSONObject jSONObject, int i) {
        if (this.c == null) {
            com.tencent.tmassistantbase.util.TMLog.i("GetAuthorizedHttpRequest", "mGetAuthorizedListener is null !");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("GetAuthorizedHttpRequest", "responseData = " + jSONObject + ",errorCode = " + i);
        try {
            if (i != 0 || jSONObject == null) {
                this.c.a(null, i);
            } else {
                com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.b bVarA = a(jSONObject);
                if (bVarA != null) {
                    this.c.a(bVarA, 0);
                }
            }
        } catch (org.json.JSONException e) {
            this.c.a(null, 704);
            e.printStackTrace();
        }
    }
}
