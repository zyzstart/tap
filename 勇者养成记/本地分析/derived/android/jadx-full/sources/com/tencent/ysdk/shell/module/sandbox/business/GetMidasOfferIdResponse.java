package com.tencent.ysdk.shell.module.sandbox.business;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetMidasOfferIdResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String TAG = "sandbox_pay";
    public java.lang.String mMidasKey;
    public java.lang.String mOfferId;

    public static java.lang.String decrypt(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str.getBytes(), "[REDACTED]");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            return new java.lang.String(cipher.doFinal(bArr), com.unisound.b.f.b);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox_pay", e);
            return "";
        }
    }

    public static java.lang.String getMidasKeyFromJson(org.json.JSONObject jSONObject) {
        com.tencent.ysdk.shell.libware.file.Logger.d("sandbox_pay", "getMidasKeyFromJson: " + jSONObject.toString());
        if (jSONObject == null) {
            return "";
        }
        try {
            java.lang.String string = jSONObject.getString("midasKey");
            java.lang.String string2 = jSONObject.getString("[REDACTED]");
            com.tencent.ysdk.shell.libware.file.Logger.d("sandbox_pay", "getMidasKeyFromJson: " + string2 + ",midasKeyHex == " + string);
            return decrypt(com.qq.taf.jce.HexUtil.hexStr2Bytes(string), com.tencent.ysdk.shell.module.sandbox.SandboxConfig.PIN + string2);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox_pay", e);
            return "";
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        try {
            com.tencent.ysdk.shell.libware.file.Logger.d("sandbox_pay", "parseJson: " + safeJSONObject);
            org.json.JSONObject jSONObject = safeJSONObject.getJSONObject(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
            this.mOfferId = jSONObject.getString("offerid");
            this.mMidasKey = getMidasKeyFromJson(jSONObject);
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox_pay", e);
        }
    }
}
