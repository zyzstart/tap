package com.tencent.mobileqq.openpay.data.pay;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PayApi extends com.tencent.mobileqq.openpay.data.base.BaseApi {
    public java.lang.String bargainorId;
    public java.lang.String callbackScheme;
    public java.lang.String nonce;
    public java.lang.String pubAcc;
    public java.lang.String pubAccHint;
    public java.lang.String serialNumber;
    public java.lang.String sig;
    public java.lang.String sigType;
    public long timeStamp;
    public java.lang.String tokenId;

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public boolean checkParams() {
        return (android.text.TextUtils.isEmpty(this.appId) || android.text.TextUtils.isEmpty("[REDACTED]") || android.text.TextUtils.isEmpty(this.callbackScheme) || android.text.TextUtils.isEmpty(this.tokenId) || android.text.TextUtils.isEmpty(this.bargainorId) || android.text.TextUtils.isEmpty(this.nonce) || android.text.TextUtils.isEmpty(this.sig) || android.text.TextUtils.isEmpty(this.sigType) || this.timeStamp <= 0 || android.text.TextUtils.isEmpty(this.serialNumber)) ? false : true;
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public void fromBundle(android.os.Bundle bundle) {
        super.fromBundle(bundle);
        this.serialNumber = bundle.getString("_mqqpay_payapi_serialnumber");
        this.callbackScheme = bundle.getString("_mqqpay_payapi_callbackscheme");
        this.pubAcc = bundle.getString("_mqqpay_payapi_pubacc");
        this.pubAccHint = bundle.getString("_mqqpay_payapi_pubacchint");
        this.tokenId = bundle.getString("[REDACTED]");
        this.nonce = bundle.getString("_mqqpay_payapi_nonce");
        this.timeStamp = bundle.getLong("_mqqpay_payapi_timeStamp");
        this.bargainorId = bundle.getString("_mqqpay_payapi_bargainorId");
        this.sigType = bundle.getString("_mqqpay_payapi_sigType");
        this.sig = bundle.getString("_mqqpay_payapi_sig");
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public int getApiMark() {
        return 1;
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public java.lang.String getApiName() {
        return "pay";
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public void toBundle(android.os.Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_mqqpay_payapi_serialnumber", this.serialNumber);
        bundle.putString("_mqqpay_payapi_callbackscheme", this.callbackScheme);
        bundle.putString("_mqqpay_payapi_pubacc", this.pubAcc);
        bundle.putString("_mqqpay_payapi_pubacchint", this.pubAccHint);
        bundle.putString("[REDACTED]", this.tokenId);
        bundle.putString("_mqqpay_payapi_nonce", this.nonce);
        bundle.putLong("_mqqpay_payapi_timeStamp", this.timeStamp);
        bundle.putString("_mqqpay_payapi_bargainorId", this.bargainorId);
        bundle.putString("_mqqpay_payapi_sigType", this.sigType);
        bundle.putString("_mqqpay_payapi_sig", this.sig);
    }
}
