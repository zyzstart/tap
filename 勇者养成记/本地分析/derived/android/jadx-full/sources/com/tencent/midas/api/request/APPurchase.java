package com.tencent.midas.api.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPurchase {
    public java.lang.String mOriginalJson;
    public java.lang.String mSignature;
    public java.lang.String mSku;

    public APPurchase() {
        this.mSignature = "";
        this.mOriginalJson = "";
        this.mSku = "";
    }

    public APPurchase(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
        this.mSignature = (java.lang.String) jSONObject.get("sign");
        this.mOriginalJson = (java.lang.String) jSONObject.get(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
        this.mSku = "";
    }

    public APPurchase(java.lang.String str, java.lang.String str2) {
        this.mOriginalJson = str;
        this.mSku = new org.json.JSONObject(new java.lang.String(android.util.Base64.decode(str.getBytes(), 0))).optString("product-id");
        this.mSignature = str2;
    }

    public java.lang.String getOriginalJson() {
        return this.mOriginalJson;
    }

    public java.lang.String getSignature() {
        return this.mSignature;
    }

    public java.lang.String getSku() {
        return this.mSku;
    }

    public java.lang.String toString() {
        return "PurchaseInfo():" + this.mOriginalJson;
    }
}
