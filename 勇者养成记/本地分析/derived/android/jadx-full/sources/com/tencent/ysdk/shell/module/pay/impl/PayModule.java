package com.tencent.ysdk.shell.module.pay.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PayModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.pay.PayInterface {
    private static final int MSG_INIT_PAY = 1;
    private static final int MSG_NOTIFY_PAY = 2;
    private static final int MSG_PAY_BUY_GOODS = 4;
    private static final int MSG_PAY_RECHARGE = 3;
    private android.os.Handler mUiHandler = null;
    private boolean isPayEnable = true;
    private com.tencent.ysdk.module.msgbox.MsgItem payMsg = null;

    protected class BuyGoodsPara {
        com.tencent.ysdk.module.pay.PayListener mListener = null;
        com.tencent.ysdk.module.pay.PayBuyGoodsPara payBuyGoodsPara;

        protected BuyGoodsPara() {
        }
    }

    private class HandlerInUI extends android.os.Handler {
        public HandlerInUI(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            switch (message.what) {
                case 1:
                    if (!(message.obj instanceof com.tencent.ysdk.module.user.UserLoginRet)) {
                        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "initPayAsync is bad , not instanceof UserLoginRet");
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.this.reportPay(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PAY_ERROR, -1, "initPayAsync is bad", null, java.lang.System.currentTimeMillis());
                    } else {
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.this.initPayAsync((com.tencent.ysdk.module.user.UserLoginRet) message.obj);
                    }
                    break;
                case 2:
                    if (!(message.obj instanceof com.tencent.ysdk.shell.module.pay.impl.PayModule.NotifyPayPara)) {
                        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "NotifyPayPara is bad , not instanceof NotifyPayPara");
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.this.reportPay(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PAY_ERROR, -1, "NotifyPayPara is bad", null, java.lang.System.currentTimeMillis());
                    } else {
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.NotifyPayPara notifyPayPara = (com.tencent.ysdk.shell.module.pay.impl.PayModule.NotifyPayPara) message.obj;
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.this.notifyPayAsync(notifyPayPara.mListener, notifyPayPara.mTempRet);
                    }
                    break;
                case 3:
                    if (!(message.obj instanceof com.tencent.ysdk.shell.module.pay.impl.PayModule.RechargePara)) {
                        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "RechargePara is bad , not instanceof RechargePara");
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.this.reportPay(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PAY_ERROR, -1, "RechargePara is bad", null, java.lang.System.currentTimeMillis());
                    } else {
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.RechargePara rechargePara = (com.tencent.ysdk.shell.module.pay.impl.PayModule.RechargePara) message.obj;
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.this.rechargeAsync(rechargePara.mZoneId, rechargePara.mSaveValue, rechargePara.mIsCanChange, rechargePara.mResData, rechargePara.mYsdkExtInfo, rechargePara.mListener);
                    }
                    break;
                case 4:
                    if (!(message.obj instanceof com.tencent.ysdk.shell.module.pay.impl.PayModule.BuyGoodsPara)) {
                        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "BuyGoodsPara is bad , not instanceof BuyGoodsPara");
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.this.reportPay(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PAY_ERROR, -1, "BuyGoodsPara is bad", null, java.lang.System.currentTimeMillis());
                    } else {
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.BuyGoodsPara buyGoodsPara = (com.tencent.ysdk.shell.module.pay.impl.PayModule.BuyGoodsPara) message.obj;
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.this.buyGoodsAsync(buyGoodsPara.payBuyGoodsPara, buyGoodsPara.mListener);
                    }
                    break;
            }
        }
    }

    interface MidasKeyCallback {
        void callback(java.lang.String str);
    }

    protected class NotifyPayPara {
        com.tencent.ysdk.module.pay.PayListener mListener = null;
        com.tencent.ysdk.module.pay.PayRet mTempRet = null;

        protected NotifyPayPara() {
        }
    }

    public class PayCallBack implements com.tencent.midas.api.IAPMidasPayCallBack {
        private com.tencent.ysdk.module.pay.PayListener mPayListener;
        private java.lang.String mYsdkExtInfo;

        protected PayCallBack(java.lang.String str, com.tencent.ysdk.module.pay.PayListener payListener) {
            this.mYsdkExtInfo = "";
            this.mPayListener = payListener;
            this.mYsdkExtInfo = str;
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(com.tencent.midas.api.APMidasResponse aPMidasResponse) {
            java.lang.String strValueOf;
            java.lang.String str;
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "response");
            com.tencent.ysdk.module.pay.PayRet payRet = new com.tencent.ysdk.module.pay.PayRet();
            payRet.platform = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().platform;
            if (aPMidasResponse == null) {
                com.tencent.ysdk.shell.libware.file.Logger.w("APMidasResponse is null");
                payRet.ret = 1;
                payRet.flag = -1;
                payRet.msg = "APMidasResponse is null";
                strValueOf = java.lang.String.valueOf(-2);
            } else {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "APMidasResponse\nresultCode = " + aPMidasResponse.resultCode + "\npayChannel = " + aPMidasResponse.payChannel + "\npayState = " + aPMidasResponse.payState + "\nproviderState = " + aPMidasResponse.provideState + "\nsavetype = " + aPMidasResponse.extendInfo);
                java.lang.String strValueOf2 = java.lang.String.valueOf(aPMidasResponse.resultCode);
                if (aPMidasResponse.resultCode == 0) {
                    payRet.ret = 0;
                    payRet.flag = 0;
                    payRet.msg = aPMidasResponse.resultMsg;
                    try {
                        android.content.Intent intent = new android.content.Intent();
                        intent.setAction(com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.PUSH_ACTION);
                        intent.putExtra(com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.PAY_SCENE, com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.SCENE_AFTERPAY);
                        intent.putExtra(com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.PAY_ERRORCODE, java.lang.String.valueOf(aPMidasResponse.resultCode));
                        com.tencent.ysdk.shell.external.LocalBroadcastManager.getInstance(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()).sendBroadcast(intent);
                    } catch (java.lang.Exception e) {
                        com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
                    }
                } else {
                    payRet.ret = 1;
                    if (2 == aPMidasResponse.resultCode) {
                        payRet.flag = 4001;
                    } else if (3 == aPMidasResponse.resultCode) {
                        payRet.flag = 4002;
                    } else {
                        payRet.flag = aPMidasResponse.resultCode;
                    }
                    payRet.msg = aPMidasResponse.resultMsg + ";code:" + aPMidasResponse.resultCode;
                    try {
                        android.content.Intent intent2 = new android.content.Intent();
                        intent2.setAction(com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.PUSH_ACTION);
                        intent2.putExtra(com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.PAY_SCENE, com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.SCENE_AFTERPAY_FAILED);
                        intent2.putExtra(com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.PAY_ERRORCODE, java.lang.String.valueOf(aPMidasResponse.resultCode));
                        com.tencent.ysdk.shell.external.LocalBroadcastManager.getInstance(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()).sendBroadcast(intent2);
                    } catch (java.lang.Exception e2) {
                        com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e2);
                    }
                }
                payRet.payChannel = aPMidasResponse.payChannel;
                payRet.realSaveNum = aPMidasResponse.realSaveNum;
                payRet.payState = aPMidasResponse.payState;
                payRet.provideState = aPMidasResponse.provideState;
                payRet.extendInfo = aPMidasResponse.extendInfo;
                payRet.payReserve1 = aPMidasResponse.payReserve1;
                payRet.payReserve2 = aPMidasResponse.payReserve2;
                payRet.payReserve3 = aPMidasResponse.payReserve3;
                strValueOf = strValueOf2;
            }
            payRet.ysdkExtInfo = this.mYsdkExtInfo;
            com.tencent.ysdk.shell.module.pay.impl.PayModule.this.notifyPay(this.mPayListener, payRet);
            if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev() && payRet.flag != 0) {
                com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, payRet.toString());
                com.tencent.ysdk.shell.framework.verification.UserTips.showMidasErrorTips();
            }
            java.util.HashMap map = new java.util.HashMap();
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_CHANNEL, java.lang.String.valueOf(payRet.payChannel));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_SAVE_VALUE, java.lang.String.valueOf(payRet.realSaveNum));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_STATE, java.lang.String.valueOf(payRet.payState));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_TYPE, payRet.extendInfo);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_PROVIDE_STATE, java.lang.String.valueOf(payRet.provideState));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_ERROR_CODE, strValueOf);
            com.tencent.ysdk.shell.module.pay.impl.PayModule.this.reportPay(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_PAY_Notify, payRet.flag, payRet.msg, map, java.lang.System.currentTimeMillis());
            if (aPMidasResponse == null) {
                str = com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PAY_FAIL;
            } else if (aPMidasResponse.resultCode == 0) {
                str = com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PAY_SUCCESS;
            } else if (aPMidasResponse.resultCode == 2) {
                map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_TYPE, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click.val());
                str = com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PAY_CANCEL;
            } else {
                str = com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PAY_FAIL;
            }
            com.tencent.ysdk.shell.module.pay.impl.PayModule.this.reportPay(str, payRet.flag, payRet.msg, map, java.lang.System.currentTimeMillis());
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            android.util.Log.i(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "UnipayNeedLogin");
            com.tencent.ysdk.module.pay.PayRet payRet = new com.tencent.ysdk.module.pay.PayRet();
            payRet.ret = 1;
            payRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
            payRet.msg = com.tencent.pipe.IPipeInterface.CMD_MIDASPAYNEEDLOGIN;
            payRet.platform = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().platform;
            payRet.ysdkExtInfo = this.mYsdkExtInfo;
            com.tencent.ysdk.shell.module.pay.impl.PayModule.this.notifyPay(this.mPayListener, payRet);
            com.tencent.ysdk.shell.module.pay.impl.PayModule.this.reportPay(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_PAY_Notify, payRet.flag, payRet.msg, null, java.lang.System.currentTimeMillis());
            com.tencent.ysdk.shell.module.pay.impl.PayModule.this.reportPay(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PAY_FAIL, payRet.flag, payRet.msg, null, java.lang.System.currentTimeMillis());
        }
    }

    protected class RechargePara {
        java.lang.String mZoneId = "";
        java.lang.String mSaveValue = "";
        boolean mIsCanChange = true;
        byte[] mResData = null;
        java.lang.String mYsdkExtInfo = "";
        com.tencent.ysdk.module.pay.PayListener mListener = null;

        protected RechargePara() {
        }
    }

    private class UserInnerLoginListenerImp implements com.tencent.ysdk.shell.module.user.UserInnerLoginListener {
        private UserInnerLoginListenerImp() {
        }

        @Override // com.tencent.ysdk.shell.module.user.UserInnerLoginListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            if (userLoginRet != null && userLoginRet.ret == 0 && userLoginRet.flag == 0) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "PayModule init start");
                com.tencent.ysdk.shell.module.pay.impl.PayModule.this.mUiHandler.sendMessage(android.os.Message.obtain(com.tencent.ysdk.shell.module.pay.impl.PayModule.this.mUiHandler, 1, userLoginRet));
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "PayModule init end");
            }
        }
    }

    public PayModule() {
        this.name = "pay";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buyGoodsByMidasKey(java.lang.String str, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str2, byte[] bArr, boolean z, java.lang.String str3, java.lang.String str4, com.tencent.ysdk.module.pay.PayListener payListener) {
        java.lang.String productId = getProductId(z, payItem, str2, str3);
        com.tencent.ysdk.shell.libware.file.Logger.d("producId:" + productId);
        com.tencent.ysdk.module.pay.PayBuyGoodsPara payBuyGoodsPara = new com.tencent.ysdk.module.pay.PayBuyGoodsPara();
        payBuyGoodsPara.zoneId = str;
        payBuyGoodsPara.resData = bArr;
        payBuyGoodsPara.ysdkExt = str4;
        payBuyGoodsPara.tokenType = 3;
        payBuyGoodsPara.prodcutId = productId;
        payBuyGoodsPara.isCanChange = z;
        payBuyGoodsPara.unit = payItem.unit;
        buyGoods(payBuyGoodsPara, payListener);
    }

    private boolean checkFreeLoginPayEnable() {
        if (!com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().isHasLogin() || com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_FREE_LOGIN_PAY_SWITCH, false)) {
            return true;
        }
        java.lang.String config = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.YSDK_FREE_LOGIN_NO_PAY_MSG, com.tencent.ysdk.shell.framework.config.Config.YSDK_FREE_LOGIN_NO_PAY_DEFAULT_NSG);
        com.tencent.ysdk.module.msgbox.MsgItem msgItem = new com.tencent.ysdk.module.msgbox.MsgItem();
        msgItem.setMessageType(3);
        msgItem.setText(config);
        com.tencent.ysdk.shell.module.msgbox.MsgBoxApiImpl.getInstance().showMsgBoxObj(msgItem);
        return false;
    }

    private boolean checkPayEnable() {
        if (!checkFreeLoginPayEnable()) {
            return false;
        }
        if (!this.isPayEnable) {
            reportPay(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_PAY_DISABLE, -1, "Pay is disable by Server", null, java.lang.System.currentTimeMillis());
            if (this.payMsg != null) {
                com.tencent.ysdk.shell.module.msgbox.MsgBoxApiImpl.getInstance().showMsgBoxObj(this.payMsg);
            }
        }
        return this.isPayEnable;
    }

    private void doctor() {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "doctor");
        java.lang.String config = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_PAY_LIST, "");
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(config)) {
            com.tencent.ysdk.shell.libware.file.Logger.d("value is null");
            return;
        }
        java.lang.String str = "";
        java.lang.String[] strArrSplit = config.split(",");
        if (strArrSplit != null && strArrSplit.length > 0) {
            for (java.lang.String str2 : strArrSplit) {
                java.lang.Class<?> cls = null;
                try {
                    cls = java.lang.Class.forName(str2);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                if (cls != null) {
                    str = str + str2.substring(str2.lastIndexOf(".") + 1) + "_";
                }
            }
        }
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            com.tencent.ysdk.shell.libware.file.Logger.d("result is null");
            return;
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_INIT_INFO, str);
        reportPay(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PAY_INIT, 0, "pay doctor bad", map, java.lang.System.currentTimeMillis());
    }

    private java.lang.String getGoodsInfo(boolean z, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        int i = payItem.price;
        java.lang.String str4 = payItem.name;
        java.lang.String str5 = payItem.desc;
        java.lang.String strValueOf = java.lang.String.valueOf(payItem.num);
        if (strValueOf.length() > 0) {
            str3 = z ? "2" : "1";
        } else {
            str3 = "2";
            strValueOf = "1";
        }
        java.lang.String str6 = payItem.id + "*" + i + "*" + strValueOf;
        java.lang.String str7 = str4 + "*" + str5;
        java.lang.String[] strArr = {str6, str3, str7, str2, str};
        java.util.Arrays.sort(strArr);
        java.lang.String str8 = strArr[0] + strArr[1] + strArr[2] + strArr[3] + strArr[4];
        java.util.HashMap<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
        map.put("payitem", str6);
        map.put("appmode", str3);
        map.put("goodsmeta", str7);
        map.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, str2);
        map.put(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_SIG, new com.tencent.ysdk.shell.libware.encrypt.SHA().digest(str8));
        return mapToString(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPayAsync(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "PayModule init async start");
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity() != null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "Activity:" + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().toString());
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "init Pay Activity maybe wrong");
        }
        com.tencent.ysdk.shell.framework.verification.UserTips.showMidasInitTips();
        com.tencent.midas.api.request.APMidasGameRequest aPMidasGameRequest = new com.tencent.midas.api.request.APMidasGameRequest();
        setMidasBaseRequest(userLoginRet, aPMidasGameRequest);
        com.tencent.midas.api.APMidasPayAPI.init(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), aPMidasGameRequest);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "Midas version:" + com.tencent.midas.api.APMidasPayAPI.getMidasPluginVersion());
        doctor();
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "PayModule init async end");
    }

    private java.lang.String mapToString(java.util.HashMap<java.lang.String, java.lang.String> map) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(entry.getValue());
            stringBuffer.append("&");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPay(com.tencent.ysdk.module.pay.PayListener payListener, com.tencent.ysdk.module.pay.PayRet payRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "notifyPay start");
        com.tencent.ysdk.shell.module.pay.impl.PayModule.NotifyPayPara notifyPayPara = new com.tencent.ysdk.shell.module.pay.impl.PayModule.NotifyPayPara();
        notifyPayPara.mListener = payListener;
        notifyPayPara.mTempRet = payRet;
        this.mUiHandler.sendMessage(android.os.Message.obtain(this.mUiHandler, 2, notifyPayPara));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPayAsync(com.tencent.ysdk.module.pay.PayListener payListener, com.tencent.ysdk.module.pay.PayRet payRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "notifyPayAsync: " + payRet.toString());
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "OK-notifyPayAsync");
        if (payListener == null) {
            com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "ERROR-listener is null");
            return;
        }
        try {
            payListener.OnPayNotify(payRet);
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, " listener.OnPayNotify");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPay(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, long j) {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        java.util.Map<java.lang.String, java.lang.String> map2 = map != null ? map : new java.util.HashMap<>();
        try {
            map2.put("offerid", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId());
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_BUY_TYPE, com.tencent.ysdk.shell.module.stat.StatEvent.PayEvent.getBuyType());
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_IS_VISITOR, com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().isVisitorState() ? "1" : "0");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(str, i, str2, loginRecord.platform, loginRecord.open_id, map, j, true);
    }

    private void reportPayEvent(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, long j, com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType, java.lang.String str3) {
        java.util.Map<java.lang.String, java.lang.String> map2 = map != null ? map : new java.util.HashMap<>();
        try {
            map2.put("offerid", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId());
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_BUY_TYPE, com.tencent.ysdk.shell.module.stat.StatEvent.PayEvent.getBuyType());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(str, i, str2, map, j, true, eventType, str3);
    }

    private void requestOfferId(final com.tencent.ysdk.shell.module.pay.impl.PayModule.MidasKeyCallback midasKeyCallback) {
        if (com.tencent.ysdk.shell.module.sandbox.SandboxConfig.isSandboxEnv()) {
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdRequest(new com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdResponse>() { // from class: com.tencent.ysdk.shell.module.pay.impl.PayModule.1
                @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
                public void onResponse(com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdResponse getMidasOfferIdResponse) {
                    if (android.text.TextUtils.isEmpty(getMidasOfferIdResponse.mMidasKey) || android.text.TextUtils.isEmpty(getMidasOfferIdResponse.mOfferId)) {
                        return;
                    }
                    com.tencent.ysdk.shell.module.sandbox.SandboxConfig.setOfferId(getMidasOfferIdResponse.mOfferId);
                    com.tencent.ysdk.shell.module.sandbox.SandboxConfig.setMidasKey(getMidasOfferIdResponse.mMidasKey);
                    com.tencent.ysdk.shell.module.pay.impl.PayModule.MidasKeyCallback midasKeyCallback2 = midasKeyCallback;
                    if (midasKeyCallback2 != null) {
                        midasKeyCallback2.callback(getMidasOfferIdResponse.mMidasKey);
                    }
                }
            }));
        }
    }

    private void setMidasBaseRequest(com.tencent.ysdk.module.user.UserLoginRet userLoginRet, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        aPMidasBaseRequest.offerId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId();
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, aPMidasBaseRequest.offerId);
        aPMidasBaseRequest.openId = userLoginRet.open_id;
        aPMidasBaseRequest.openKey = userLoginRet.getPayToken();
        if (2 == userLoginRet.platform) {
            aPMidasBaseRequest.sessionType = "[REDACTED]";
            aPMidasBaseRequest.sessionId = "hy_gameid";
        } else if (1 == userLoginRet.platform) {
            aPMidasBaseRequest.sessionType = "[REDACTED]";
            aPMidasBaseRequest.sessionId = "openid";
        } else if (7 == userLoginRet.platform) {
            aPMidasBaseRequest.sessionType = "st_dummy";
            aPMidasBaseRequest.sessionId = "hy_gameid";
        }
        aPMidasBaseRequest.pf = userLoginRet.pf;
        aPMidasBaseRequest.pfKey = userLoginRet.pf_key;
        aPMidasBaseRequest.acctType = "common";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecharge(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.module.pay.impl.PayModule.RechargePara rechargePara = new com.tencent.ysdk.shell.module.pay.impl.PayModule.RechargePara();
        rechargePara.mZoneId = str;
        rechargePara.mSaveValue = str2;
        rechargePara.mIsCanChange = z;
        rechargePara.mResData = bArr;
        rechargePara.mYsdkExtInfo = str3;
        rechargePara.mListener = payListener;
        this.mUiHandler.sendMessage(android.os.Message.obtain(this.mUiHandler, 3, rechargePara));
    }

    @Override // com.tencent.ysdk.shell.module.pay.PayInterface
    public void buyGoods(com.tencent.ysdk.module.pay.PayBuyGoodsPara payBuyGoodsPara, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "buyGoods send start");
        if (checkPayEnable()) {
            com.tencent.ysdk.shell.module.pay.impl.PayModule.BuyGoodsPara buyGoodsPara = new com.tencent.ysdk.shell.module.pay.impl.PayModule.BuyGoodsPara();
            buyGoodsPara.payBuyGoodsPara = payBuyGoodsPara;
            buyGoodsPara.mListener = payListener;
            this.mUiHandler.sendMessage(android.os.Message.obtain(this.mUiHandler, 4, buyGoodsPara));
        }
    }

    @Override // com.tencent.ysdk.shell.module.pay.PayInterface
    public void buyGoods(final java.lang.String str, final com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str2, final byte[] bArr, final boolean z, final java.lang.String str3, final java.lang.String str4, final com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "buyGoods with sdk order start");
        if (checkPayEnable()) {
            if (com.tencent.ysdk.shell.module.sandbox.SandboxConfig.isSandboxEnv()) {
                requestOfferId(new com.tencent.ysdk.shell.module.pay.impl.PayModule.MidasKeyCallback() { // from class: com.tencent.ysdk.shell.module.pay.impl.PayModule.3
                    @Override // com.tencent.ysdk.shell.module.pay.impl.PayModule.MidasKeyCallback
                    public void callback(java.lang.String str5) {
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.this.buyGoodsByMidasKey(str, payItem, str5, bArr, z, str3, str4, payListener);
                    }
                });
            } else {
                buyGoodsByMidasKey(str, payItem, str2, bArr, z, str3, str4, payListener);
            }
        }
    }

    @Override // com.tencent.ysdk.shell.module.pay.PayInterface
    public void buyGoods(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "buyGoods with server order start");
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "url：" + str2);
        if (checkPayEnable()) {
            com.tencent.ysdk.module.pay.PayBuyGoodsPara payBuyGoodsPara = new com.tencent.ysdk.module.pay.PayBuyGoodsPara();
            payBuyGoodsPara.zoneId = str;
            payBuyGoodsPara.goodsTokenUrl = str2;
            payBuyGoodsPara.resData = bArr;
            payBuyGoodsPara.ysdkExt = str3;
            payBuyGoodsPara.tokenType = 1;
            payBuyGoodsPara.isCanChange = z;
            buyGoods(payBuyGoodsPara, payListener);
        }
    }

    public void buyGoodsAsync(com.tencent.ysdk.module.pay.PayBuyGoodsPara payBuyGoodsPara, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.module.stat.StatEvent.PayEvent.setBuyType(com.tencent.ysdk.shell.module.stat.StatEvent.PayEvent.PAY_STAT_PARAM_BUYGOODS);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "buyGoodsAsync start， zoneId：" + payBuyGoodsPara.zoneId);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "buyGoodsAsync start， unit：" + payBuyGoodsPara.unit);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "buyGoodsAsync start， isShowNum：" + payBuyGoodsPara.isShowNum);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "buyGoodsAsync start， payChannel：" + payBuyGoodsPara.payChannel);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "buyGoodsAsync start， isCanChange：" + payBuyGoodsPara.isCanChange);
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity() == null) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "YSDK Activity is null");
            com.tencent.ysdk.shell.framework.verification.UserTips.showMidasYSDKActivityIsNullError();
            return;
        }
        com.tencent.ysdk.shell.framework.verification.UserTips.showRechargeTips();
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, loginRecord.toString());
        if (loginRecord.ret == 0 && loginRecord.flag == 0) {
            com.tencent.midas.api.request.APMidasGoodsRequest aPMidasGoodsRequest = new com.tencent.midas.api.request.APMidasGoodsRequest();
            setMidasBaseRequest(loginRecord, aPMidasGoodsRequest);
            aPMidasGoodsRequest.zoneId = payBuyGoodsPara.zoneId;
            aPMidasGoodsRequest.mallType = payBuyGoodsPara.mallType;
            aPMidasGoodsRequest.tokenType = payBuyGoodsPara.tokenType;
            if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(payBuyGoodsPara.prodcutId)) {
                com.tencent.ysdk.shell.libware.file.Logger.d("prodcutId:" + payBuyGoodsPara.prodcutId);
                aPMidasGoodsRequest.prodcutId = payBuyGoodsPara.prodcutId;
            }
            aPMidasGoodsRequest.goodsTokenUrl = payBuyGoodsPara.goodsTokenUrl;
            aPMidasGoodsRequest.isCanChange = payBuyGoodsPara.isCanChange;
            if (payBuyGoodsPara.resData != null) {
                aPMidasGoodsRequest.resData = payBuyGoodsPara.resData;
            } else {
                com.tencent.ysdk.shell.libware.file.Logger.e("resData is null");
            }
            if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(payBuyGoodsPara.reserv)) {
                com.tencent.ysdk.shell.libware.file.Logger.d("reserv:" + payBuyGoodsPara.reserv);
                aPMidasGoodsRequest.reserv = payBuyGoodsPara.reserv;
            }
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(payBuyGoodsPara.unit)) {
                com.tencent.ysdk.shell.libware.file.Logger.d("bad unit:" + payBuyGoodsPara.unit);
                aPMidasGoodsRequest.setUnit("");
            } else {
                aPMidasGoodsRequest.setUnit(payBuyGoodsPara.unit);
            }
            aPMidasGoodsRequest.setShowNum(payBuyGoodsPara.isShowNum);
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(payBuyGoodsPara.payChannel)) {
                com.tencent.ysdk.shell.libware.file.Logger.d("bad payChannel:" + payBuyGoodsPara.payChannel);
                aPMidasGoodsRequest.setPayChannel("");
            } else {
                aPMidasGoodsRequest.setPayChannel(payBuyGoodsPara.payChannel);
            }
            if (payBuyGoodsPara.gameLogo > 0) {
                com.tencent.ysdk.shell.libware.file.Logger.d("game logo:" + payBuyGoodsPara.gameLogo);
                aPMidasGoodsRequest.gameLogo = payBuyGoodsPara.gameLogo;
            }
            if (com.tencent.ysdk.shell.module.sandbox.SandboxConfig.isSandboxEnv()) {
                com.tencent.ysdk.shell.module.sandbox.SandboxPayModule.getInstance().launchRemotePay(aPMidasGoodsRequest, new com.tencent.ysdk.shell.module.pay.impl.PayModule.PayCallBack(payBuyGoodsPara.ysdkExt, payListener));
            } else {
                com.tencent.midas.api.APMidasPayAPI.launchPay(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), aPMidasGoodsRequest, new com.tencent.ysdk.shell.module.pay.impl.PayModule.PayCallBack(payBuyGoodsPara.ysdkExt, payListener));
            }
        } else {
            com.tencent.ysdk.module.pay.PayRet payRet = new com.tencent.ysdk.module.pay.PayRet();
            payRet.ret = 1;
            payRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
            payRet.msg = "recharge check login record invalid;" + loginRecord.msg;
            payRet.platform = loginRecord.platform;
            payRet.ysdkExtInfo = payBuyGoodsPara.ysdkExt;
            notifyPay(payListener, payRet);
        }
        java.util.Map<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_ZONEID, payBuyGoodsPara.zoneId);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_TOKEN_TYPE, java.lang.String.valueOf(payBuyGoodsPara.tokenType));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_PRODUCT_ID, payBuyGoodsPara.prodcutId);
        reportPayEvent(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_PAY_BUYGOODS, loginRecord.flag, loginRecord.msg, map, java.lang.System.currentTimeMillis(), com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, "");
    }

    @Override // com.tencent.ysdk.shell.module.pay.PayInterface
    public java.lang.String getProductId(boolean z, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "buyGoods getPayProductId");
        if (com.tencent.ysdk.shell.module.sandbox.SandboxConfig.isSandboxEnv()) {
            str = com.tencent.ysdk.shell.module.sandbox.SandboxConfig.getMidasKey();
        }
        return getGoodsInfo(z, payItem, str, str2);
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        try {
            this.mUiHandler = new com.tencent.ysdk.shell.module.pay.impl.PayModule.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
            com.tencent.ysdk.shell.module.user.UserApi.setUserInnerLoginListener(new com.tencent.ysdk.shell.module.pay.impl.PayModule.UserInnerLoginListenerImp());
            if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "YSDK Pay init to test");
                com.tencent.midas.api.APMidasPayAPI.setLogEnable(true);
                com.tencent.midas.api.APMidasPayAPI.setEnv(com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
            } else {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "YSDK Pay init to release");
                com.tencent.midas.api.APMidasPayAPI.setLogEnable(false);
                com.tencent.midas.api.APMidasPayAPI.setEnv("release");
            }
            if (com.tencent.ysdk.shell.module.sandbox.SandboxConfig.isSandboxEnv()) {
                android.content.Intent intent = new android.content.Intent();
                intent.setAction("com.tencent.ysdk.framework.communicate.PipeService");
                intent.setPackage("com.tencent.android.qqdownloader");
                com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().bindService(intent, com.tencent.ysdk.shell.module.sandbox.pipe.PipeSender.getInstance(), 1);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.ysdk.shell.module.pay.PayInterface
    public void recharge(final java.lang.String str, final java.lang.String str2, final boolean z, final byte[] bArr, final java.lang.String str3, final com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "recharge start");
        if (checkPayEnable()) {
            if (com.tencent.ysdk.shell.module.sandbox.SandboxConfig.isSandboxEnv()) {
                requestOfferId(new com.tencent.ysdk.shell.module.pay.impl.PayModule.MidasKeyCallback() { // from class: com.tencent.ysdk.shell.module.pay.impl.PayModule.2
                    @Override // com.tencent.ysdk.shell.module.pay.impl.PayModule.MidasKeyCallback
                    public void callback(java.lang.String str4) {
                        com.tencent.ysdk.shell.module.pay.impl.PayModule.this.startRecharge(str, str2, z, bArr, str3, payListener);
                    }
                });
            } else {
                startRecharge(str, str2, z, bArr, str3, payListener);
            }
        }
    }

    public void rechargeAsync(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.shell.module.stat.StatEvent.PayEvent.setBuyType(com.tencent.ysdk.shell.module.stat.StatEvent.PayEvent.PAY_STAT_PARAM_RECHARGE);
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity() == null) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "YSDK Activity is null");
            com.tencent.ysdk.shell.framework.verification.UserTips.showMidasYSDKActivityIsNullError();
            return;
        }
        com.tencent.ysdk.shell.framework.verification.UserTips.showRechargeTips();
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, loginRecord.toString());
        if (loginRecord.ret == 0 && loginRecord.flag == 0) {
            com.tencent.midas.api.request.APMidasGameRequest aPMidasGameRequest = new com.tencent.midas.api.request.APMidasGameRequest();
            setMidasBaseRequest(loginRecord, aPMidasGameRequest);
            aPMidasGameRequest.zoneId = str;
            aPMidasGameRequest.saveValue = str2;
            aPMidasGameRequest.isCanChange = z;
            aPMidasGameRequest.resData = bArr;
            if (com.tencent.ysdk.shell.module.sandbox.SandboxConfig.isSandboxEnv()) {
                com.tencent.ysdk.shell.module.sandbox.SandboxPayModule.getInstance().launchRemotePay(aPMidasGameRequest, new com.tencent.ysdk.shell.module.pay.impl.PayModule.PayCallBack(str3, payListener));
            } else {
                com.tencent.midas.api.APMidasPayAPI.launchPay(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), aPMidasGameRequest, new com.tencent.ysdk.shell.module.pay.impl.PayModule.PayCallBack(str3, payListener));
            }
        } else {
            com.tencent.ysdk.module.pay.PayRet payRet = new com.tencent.ysdk.module.pay.PayRet();
            payRet.ret = 1;
            payRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
            payRet.msg = "recharge check login record invalid;" + loginRecord.msg;
            payRet.platform = loginRecord.platform;
            payRet.ysdkExtInfo = str3;
            notifyPay(payListener, payRet);
        }
        java.util.Map<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_ZONEID, str);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_SAVE_VALUE, str2);
        reportPayEvent(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_PAY_RECHARGE, loginRecord.flag, loginRecord.msg, map, java.lang.System.currentTimeMillis(), com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, "");
    }

    @Override // com.tencent.ysdk.shell.module.Module
    protected void selfCheck() {
        com.tencent.ysdk.shell.module.pay.impl.PayModuleSelfCheck.checkPermission();
        com.tencent.ysdk.shell.module.pay.impl.PayModuleSelfCheck.checkSDKConfig();
    }

    @Override // com.tencent.ysdk.shell.module.pay.PayInterface
    public void setEnv(java.lang.String str) {
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "YSDK Pay setEnv bad: null env");
            return;
        }
        if (str.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TEST) || str.equals("release")) {
            com.tencent.midas.api.APMidasPayAPI.setEnv(str);
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.pay.PayInterface.LOG_TAG, "YSDK Pay setEnv bad: bad env," + str);
    }

    @Override // com.tencent.ysdk.shell.module.pay.PayInterface
    public void setLogEnable(boolean z) {
        com.tencent.midas.api.APMidasPayAPI.setLogEnable(z);
    }

    @Override // com.tencent.ysdk.shell.module.pay.PayInterface
    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.3.5")
    public void setPayEnable(boolean z, com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        this.isPayEnable = z;
        this.payMsg = msgItem;
    }
}
