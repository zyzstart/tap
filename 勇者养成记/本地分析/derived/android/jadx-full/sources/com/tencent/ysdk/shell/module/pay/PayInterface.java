package com.tencent.ysdk.shell.module.pay;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface PayInterface {
    public static final java.lang.String LOG_TAG = "YSDK_PAY";

    void buyGoods(com.tencent.ysdk.module.pay.PayBuyGoodsPara payBuyGoodsPara, com.tencent.ysdk.module.pay.PayListener payListener);

    void buyGoods(java.lang.String str, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str2, byte[] bArr, boolean z, java.lang.String str3, java.lang.String str4, com.tencent.ysdk.module.pay.PayListener payListener);

    void buyGoods(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener);

    java.lang.String getProductId(boolean z, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str, java.lang.String str2);

    void recharge(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener);

    void setEnv(java.lang.String str);

    void setLogEnable(boolean z);

    void setPayEnable(boolean z, com.tencent.ysdk.module.msgbox.MsgItem msgItem);
}
