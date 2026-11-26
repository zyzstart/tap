package com.tencent.ysdk.shell.module.sandbox.business;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PayInfoEncodeResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String TAG = "sandbox_pay";
    public int mCode;
    public java.lang.String mData;

    public boolean isRequestSuccess() {
        return this.mCode != 0;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.libware.file.Logger.d("sandbox_pay", "parseJson: " + safeJSONObject.toString());
        try {
            this.mData = safeJSONObject.getJSONObject(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA).getJSONObject("payInfoVertifyMsg").toString();
            this.mCode = safeJSONObject.getInt("code");
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox_pay", e);
        }
    }
}
