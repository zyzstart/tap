package com.tencent.ysdk.module.pay;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PayRet extends com.tencent.ysdk.framework.common.BaseRet {
    public static final int PAYCHANEL_ACCT_QBQD = 11;
    public static final int PAYCHANEL_ACCT_QDQB = 0;
    public static final int PAYCHANEL_GOLDCOUPONS = 10;
    public static final int PAYCHANEL_HF = 9;
    public static final int PAYCHANEL_MCARD = 5;
    public static final int PAYCHANEL_QQCARD = 4;
    public static final int PAYCHANEL_TENPAY_BANK = 2;
    public static final int PAYCHANEL_TENPAY_CFT = 1;
    public static final int PAYCHANEL_TENPAY_KJ = 3;
    public static final int PAYCHANEL_UNKOWN = -1;
    public static final int PAYCHANEL_WECHAT = 8;
    public static final int PAYCHANEL_YB = 7;
    public static final int PAYPROVIDESTATE_SUCC = 0;
    public static final int PAYPROVIDESTATE_UNKOWN = -1;
    public static final int PAYSTATE_PAYCANCEL = 1;
    public static final int PAYSTATE_PAYERROR = 2;
    public static final int PAYSTATE_PAYSUCC = 0;
    public static final int PAYSTATE_PAYUNKOWN = -1;
    public int platform = 0;
    public int realSaveNum = 0;
    public int payChannel = -1;
    public int payState = -1;
    public int provideState = -1;
    public java.lang.String extendInfo = "";
    public java.lang.String payReserve1 = "";
    public java.lang.String payReserve2 = "";
    public java.lang.String payReserve3 = "";
    public java.lang.String ysdkExtInfo = "";

    @Override // com.tencent.ysdk.framework.common.BaseRet
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("platform : " + this.platform + "\n");
        sb.append("realSaveNum : " + this.realSaveNum + "\n");
        sb.append("payChannel : " + this.payChannel + "\n");
        sb.append("payState : " + this.payState + "\n");
        sb.append("provideState : " + this.provideState + "\n");
        sb.append("extendInfo : " + this.extendInfo + "\n");
        sb.append("payReserve1 : " + this.payReserve1 + "\n");
        sb.append("payReserve2 : " + this.payReserve2 + "\n");
        sb.append("payReserve3 : " + this.payReserve3 + "\n");
        sb.append("ysdkExtInfo : " + this.ysdkExtInfo + "\n");
        return "PayRet : \n" + super.toString() + sb.toString();
    }
}
