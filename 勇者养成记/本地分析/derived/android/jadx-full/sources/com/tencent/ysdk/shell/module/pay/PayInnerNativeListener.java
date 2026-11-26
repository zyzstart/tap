package com.tencent.ysdk.shell.module.pay;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PayInnerNativeListener implements com.tencent.ysdk.module.pay.PayListener {
    @Override // com.tencent.ysdk.module.pay.PayListener
    public void OnPayNotify(com.tencent.ysdk.module.pay.PayRet payRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "PayNativeListener OnPayNotify start");
        com.tencent.ysdk.shell.module.pay.PayNativeListener.OnPayNotify(payRet);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "PayNativeListener OnPayNotify end");
    }
}
