package com.tencent.ysdk.shell.module.pay;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.1.1")
public class PayApi {
    private static final java.lang.String TAG = "YSDK.PayApi";
    private static volatile com.tencent.ysdk.shell.module.pay.PayApi instance;
    private com.tencent.ysdk.shell.module.pay.PayInterface payInterfaceImp = null;

    private PayApi() {
    }

    public static com.tencent.ysdk.shell.module.pay.PayApi getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.pay.PayApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.pay.PayApi();
                }
            }
        }
        return instance;
    }

    private com.tencent.ysdk.shell.module.pay.PayInterface getOrLoadPayInnerInterface() {
        com.tencent.ysdk.shell.module.pay.PayInterface payInterface = this.payInterfaceImp;
        if (payInterface != null) {
            return payInterface;
        }
        com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
        if (moduleManager != null) {
            java.lang.Object moduleByName = moduleManager.getModuleByName("pay");
            if (moduleByName instanceof com.tencent.ysdk.shell.module.pay.PayInterface) {
                this.payInterfaceImp = (com.tencent.ysdk.shell.module.pay.PayInterface) moduleByName;
            }
        }
        return this.payInterfaceImp;
    }

    public void bugGoods(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.module.pay.PayInterface orLoadPayInnerInterface = getOrLoadPayInnerInterface();
        if (orLoadPayInnerInterface != null) {
            orLoadPayInnerInterface.buyGoods(str, str2, z, bArr, str3, payListener);
        } else {
            com.tencent.ysdk.libware.file.Logger.e(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("bugGoods"));
        }
    }

    public void buyGoods(com.tencent.ysdk.module.pay.PayBuyGoodsPara payBuyGoodsPara, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.module.pay.PayInterface orLoadPayInnerInterface = getOrLoadPayInnerInterface();
        if (orLoadPayInnerInterface != null) {
            orLoadPayInnerInterface.buyGoods(payBuyGoodsPara, payListener);
        } else {
            com.tencent.ysdk.libware.file.Logger.e(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("buyGoods"));
        }
    }

    public void buyGoods(java.lang.String str, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str2, byte[] bArr, boolean z, java.lang.String str3, java.lang.String str4, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.module.pay.PayInterface orLoadPayInnerInterface = getOrLoadPayInnerInterface();
        if (orLoadPayInnerInterface != null) {
            orLoadPayInnerInterface.buyGoods(str, payItem, str2, bArr, z, str3, str4, payListener);
        } else {
            com.tencent.ysdk.libware.file.Logger.e(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("buyGoods"));
        }
    }

    public com.tencent.ysdk.shell.module.pay.PayInterface getPayInterfaceImp() {
        return this.payInterfaceImp;
    }

    public java.lang.String getPayProductId(boolean z, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.pay.PayInterface orLoadPayInnerInterface = getOrLoadPayInnerInterface();
        if (orLoadPayInnerInterface != null) {
            return orLoadPayInnerInterface.getProductId(z, payItem, str, str2);
        }
        com.tencent.ysdk.libware.file.Logger.e(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getPayProductId"));
        return "";
    }

    public void recharge(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.module.pay.PayInterface orLoadPayInnerInterface = getOrLoadPayInnerInterface();
        if (orLoadPayInnerInterface != null) {
            orLoadPayInnerInterface.recharge(str, str2, z, bArr, str3, payListener);
        } else {
            com.tencent.ysdk.libware.file.Logger.e(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg(com.tencent.ysdk.shell.module.stat.StatEvent.PayEvent.PAY_STAT_PARAM_RECHARGE));
        }
    }

    public void setEnv(java.lang.String str) {
        com.tencent.ysdk.shell.module.pay.PayInterface orLoadPayInnerInterface = getOrLoadPayInnerInterface();
        if (orLoadPayInnerInterface != null) {
            orLoadPayInnerInterface.setEnv(str);
        } else {
            com.tencent.ysdk.libware.file.Logger.e(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("setEnv"));
        }
    }

    public void setLogEnable(boolean z) {
        com.tencent.ysdk.shell.module.pay.PayInterface orLoadPayInnerInterface = getOrLoadPayInnerInterface();
        if (orLoadPayInnerInterface != null) {
            orLoadPayInnerInterface.setLogEnable(z);
        } else {
            com.tencent.ysdk.libware.file.Logger.e(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("setLogEnable"));
        }
    }
}
