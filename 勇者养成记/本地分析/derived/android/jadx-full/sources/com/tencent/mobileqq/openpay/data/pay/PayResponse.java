package com.tencent.mobileqq.openpay.data.pay;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PayResponse extends com.tencent.mobileqq.openpay.data.base.BaseResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f643a;
    public java.lang.String callbackUrl;
    public java.lang.String payTime;
    public java.lang.String serialNumber;
    public java.lang.String spData;
    public java.lang.String totalFee;
    public java.lang.String transactionId;

    @Override // com.tencent.mobileqq.openpay.data.base.BaseResponse
    public boolean checkParams() {
        if (this.retCode == -9999999) {
            return false;
        }
        if (!isSuccess() || isPayByWeChat()) {
            return true;
        }
        return (android.text.TextUtils.isEmpty(this.transactionId) || android.text.TextUtils.isEmpty(this.payTime) || android.text.TextUtils.isEmpty(this.totalFee)) ? false : true;
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseResponse
    public void fromBundle(android.os.Bundle bundle) {
        super.fromBundle(bundle);
        this.f643a = bundle.getString("_mqqpay_payresp_paychanneltype");
        this.transactionId = bundle.getString("_mqqpay_payresp_transactionid");
        this.payTime = bundle.getString("_mqqpay_payresp_paytime");
        this.totalFee = bundle.getString("_mqqpay_payresp_totalfee");
        this.callbackUrl = bundle.getString("_mqqpay_payresp_callbackurl");
        this.spData = bundle.getString("_mqqpay_payresp_spdata");
        this.serialNumber = bundle.getString("_mqqpay_payapi_serialnumber");
    }

    public boolean isPayByWeChat() {
        return !android.text.TextUtils.isEmpty(this.f643a) && this.f643a.compareTo("1") == 0;
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseResponse
    public void toBundle(android.os.Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_mqqpay_payresp_paychanneltype", this.f643a);
        bundle.putString("_mqqpay_payresp_transactionid", this.transactionId);
        bundle.putString("_mqqpay_payresp_paytime", this.payTime);
        bundle.putString("_mqqpay_payresp_totalfee", this.totalFee);
        bundle.putString("_mqqpay_payresp_callbackurl", this.callbackUrl);
        bundle.putString("_mqqpay_payresp_spdata", this.spData);
        bundle.putString("_mqqpay_payapi_serialnumber", this.serialNumber);
    }
}
