package com.tencent.mm.opensdk.modelpay;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PayReq extends com.tencent.mm.opensdk.modelbase.BaseReq {
    private static final int EXTDATA_MAX_LENGTH = 1024;
    private static final java.lang.String TAG = "MicroMsg.PaySdk.PayReq";
    public java.lang.String appId;
    public java.lang.String extData;
    public java.lang.String nonceStr;
    public com.tencent.mm.opensdk.modelpay.PayReq.Options options;
    public java.lang.String packageValue;
    public java.lang.String partnerId;
    public java.lang.String prepayId;
    public java.lang.String sign;
    public java.lang.String signType;
    public java.lang.String timeStamp;

    public static class Options {
        public static final int INVALID_FLAGS = -1;
        public java.lang.String callbackClassName;
        public int callbackFlags = -1;

        public void fromBundle(android.os.Bundle bundle) {
            this.callbackClassName = com.tencent.mm.opensdk.utils.a.b(bundle, "_wxapi_payoptions_callback_classname");
            this.callbackFlags = com.tencent.mm.opensdk.utils.a.a(bundle, "_wxapi_payoptions_callback_flags");
        }

        public void toBundle(android.os.Bundle bundle) {
            bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
            bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
        }
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public boolean checkArgs() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3 = this.appId;
        if (str3 == null || str3.length() == 0) {
            str = TAG;
            str2 = "checkArgs fail, invalid appId";
        } else {
            java.lang.String str4 = this.partnerId;
            if (str4 == null || str4.length() == 0) {
                str = TAG;
                str2 = "checkArgs fail, invalid partnerId";
            } else {
                java.lang.String str5 = this.prepayId;
                if (str5 == null || str5.length() == 0) {
                    str = TAG;
                    str2 = "checkArgs fail, invalid prepayId";
                } else {
                    java.lang.String str6 = this.nonceStr;
                    if (str6 == null || str6.length() == 0) {
                        str = TAG;
                        str2 = "checkArgs fail, invalid nonceStr";
                    } else {
                        java.lang.String str7 = this.timeStamp;
                        if (str7 == null || str7.length() == 0) {
                            str = TAG;
                            str2 = "checkArgs fail, invalid timeStamp";
                        } else {
                            java.lang.String str8 = this.packageValue;
                            if (str8 == null || str8.length() == 0) {
                                str = TAG;
                                str2 = "checkArgs fail, invalid packageValue";
                            } else {
                                java.lang.String str9 = this.sign;
                                if (str9 == null || str9.length() == 0) {
                                    str = TAG;
                                    str2 = "checkArgs fail, invalid sign";
                                } else {
                                    java.lang.String str10 = this.extData;
                                    if (str10 == null || str10.length() <= 1024) {
                                        return true;
                                    }
                                    str = TAG;
                                    str2 = "checkArgs fail, extData length too long";
                                }
                            }
                        }
                    }
                }
            }
        }
        com.tencent.mm.opensdk.utils.Log.e(str, str2);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public void fromBundle(android.os.Bundle bundle) {
        super.fromBundle(bundle);
        this.appId = com.tencent.mm.opensdk.utils.a.b(bundle, "_wxapi_payreq_appid");
        this.partnerId = com.tencent.mm.opensdk.utils.a.b(bundle, "_wxapi_payreq_partnerid");
        this.prepayId = com.tencent.mm.opensdk.utils.a.b(bundle, "_wxapi_payreq_prepayid");
        this.nonceStr = com.tencent.mm.opensdk.utils.a.b(bundle, "_wxapi_payreq_noncestr");
        this.timeStamp = com.tencent.mm.opensdk.utils.a.b(bundle, "_wxapi_payreq_timestamp");
        this.packageValue = com.tencent.mm.opensdk.utils.a.b(bundle, "_wxapi_payreq_packagevalue");
        this.sign = com.tencent.mm.opensdk.utils.a.b(bundle, "_wxapi_payreq_sign");
        this.extData = com.tencent.mm.opensdk.utils.a.b(bundle, "_wxapi_payreq_extdata");
        this.signType = com.tencent.mm.opensdk.utils.a.b(bundle, "_wxapi_payreq_sign_type");
        com.tencent.mm.opensdk.modelpay.PayReq.Options options = new com.tencent.mm.opensdk.modelpay.PayReq.Options();
        this.options = options;
        options.fromBundle(bundle);
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public int getType() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public void toBundle(android.os.Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_payreq_appid", this.appId);
        bundle.putString("_wxapi_payreq_partnerid", this.partnerId);
        bundle.putString("_wxapi_payreq_prepayid", this.prepayId);
        bundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
        bundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
        bundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
        bundle.putString("_wxapi_payreq_sign", this.sign);
        bundle.putString("_wxapi_payreq_extdata", this.extData);
        bundle.putString("_wxapi_payreq_sign_type", this.signType);
        com.tencent.mm.opensdk.modelpay.PayReq.Options options = this.options;
        if (options != null) {
            options.toBundle(bundle);
        }
    }
}
