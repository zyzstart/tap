package com.tencent.ysdk.shell.module.h5game;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class H5GameJSSDKManager implements com.tencent.ysdk.module.user.UserListener, com.tencent.ysdk.shell.module.user.UserInnerLoginListener, com.tencent.ysdk.module.user.UserRelationListener, com.tencent.ysdk.module.pay.PayListener {
    private static com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager instance;
    public boolean isConfigEnable = false;
    private com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge;
    private java.lang.String payFunction;
    private java.lang.String payMethod;
    private int paySeqid;
    private java.lang.String userLoginFunction;
    private java.lang.String userLoginMethod;
    private int userLoginSeqid;
    private java.lang.String userRelationFuction;
    private java.lang.String userRelationMethod;
    private int userRelationSeqid;

    private H5GameJSSDKManager() {
    }

    public static synchronized com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager getInstance() {
        if (instance == null) {
            instance = new com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager();
        }
        return instance;
    }

    private boolean isConfigEnable() {
        if (!this.isConfigEnable) {
            com.tencent.ysdk.shell.libware.file.Logger.e("H5GameModule is closed ,set Config Enable first.");
        }
        return this.isConfigEnable;
    }

    private synchronized void payCallBack(com.tencent.ysdk.module.pay.PayRet payRet) {
        if (this.jsBridge != null && !android.text.TextUtils.isEmpty(this.payFunction) && !android.text.TextUtils.isEmpty(this.payMethod)) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("flag", payRet.flag);
                jSONObject.put("extend_info", payRet.extendInfo);
                jSONObject.put("platform", payRet.platform);
                jSONObject.put("pay_channel", payRet.payChannel);
                jSONObject.put("pay_reserve1", payRet.payReserve1);
                jSONObject.put("pay_reserve2", payRet.payReserve2);
                jSONObject.put("pay_reserve3", payRet.payReserve3);
                jSONObject.put("pay_state", payRet.payState);
                jSONObject.put("pay_provide_state", payRet.provideState);
                jSONObject.put("pay_real_save_num", payRet.realSaveNum);
                jSONObject.put("pay_ysdk_ext_info", payRet.ysdkExtInfo);
                jSONObject.put("pay_msg", payRet.msg);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            this.jsBridge.response(this.payFunction, this.paySeqid, this.payMethod, jSONObject.toString());
            this.payFunction = null;
            this.paySeqid = 0;
            this.payMethod = null;
        }
    }

    private synchronized void userLoginCallBack(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        if (this.jsBridge != null && !android.text.TextUtils.isEmpty(this.userLoginFunction) && !android.text.TextUtils.isEmpty(this.userLoginMethod)) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("flag", userLoginRet.flag);
                jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_LOGIN_TYPE, userLoginRet.getLoginType());
                jSONObject.put("user_type", userLoginRet.getUserType());
                jSONObject.put(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN, userLoginRet.getAccessToken());
                jSONObject.put("[REDACTED]", userLoginRet.getPayToken());
                jSONObject.put("reg_channel", userLoginRet.getRegChannel());
                jSONObject.put("nick_name", userLoginRet.nick_name);
                jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_OPEN_ID, userLoginRet.open_id);
                jSONObject.put("pf", userLoginRet.pf);
                jSONObject.put("pf_key", userLoginRet.pf_key);
                jSONObject.put("platform", userLoginRet.platform);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            this.jsBridge.response(this.userLoginFunction, this.userLoginSeqid, this.userLoginMethod, jSONObject.toString());
            this.userLoginFunction = null;
            this.userLoginSeqid = 0;
            this.userLoginMethod = null;
        }
    }

    private synchronized void userRelationCallBack(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
        if (this.jsBridge != null && !android.text.TextUtils.isEmpty(this.userRelationFuction) && !android.text.TextUtils.isEmpty(this.userRelationMethod)) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("flag", userRelationRet.flag);
                jSONObject.put("info_type", userRelationRet.info_type);
                jSONObject.put("platform", userRelationRet.platform);
                com.tencent.ysdk.module.user.PersonInfo personInfo = (com.tencent.ysdk.module.user.PersonInfo) userRelationRet.persons.firstElement();
                if (personInfo != null) {
                    jSONObject.put("nick_name", personInfo.nickName);
                    jSONObject.put("userid", personInfo.userId);
                    jSONObject.put("openid", personInfo.openId);
                    jSONObject.put("gender", personInfo.gender);
                    jSONObject.put("pic_l", personInfo.pictureLarge);
                    jSONObject.put("pic_m", personInfo.pictureMiddle);
                    jSONObject.put("pic_s", personInfo.pictureSmall);
                    jSONObject.put("country", personInfo.country);
                    jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_PROVINCE, personInfo.province);
                    jSONObject.put("city", personInfo.city);
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            this.jsBridge.response(this.userRelationFuction, this.userRelationSeqid, this.userRelationMethod, jSONObject.toString());
            this.userRelationFuction = null;
            this.userRelationSeqid = 0;
            this.userRelationMethod = null;
        }
    }

    @Override // com.tencent.ysdk.module.user.UserListener
    public synchronized void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d("H5GameJSSDKManager ", "OnLoginNotify :" + userLoginRet.flag);
        if (!android.text.TextUtils.isEmpty(this.userLoginFunction) && !android.text.TextUtils.isEmpty(this.userLoginMethod)) {
            userLoginCallBack(userLoginRet);
        }
    }

    @Override // com.tencent.ysdk.module.pay.PayListener
    public synchronized void OnPayNotify(com.tencent.ysdk.module.pay.PayRet payRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d("H5GameJSSDKManager ", "OnPayNotify :" + payRet.flag);
        if (!android.text.TextUtils.isEmpty(this.payFunction) && !android.text.TextUtils.isEmpty(this.payMethod)) {
            payCallBack(payRet);
        }
    }

    @Override // com.tencent.ysdk.module.user.UserListener
    public synchronized void OnRelationNotify(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d("H5GameJSSDKManager ", "OnRelationNotify :" + userRelationRet.flag);
        if (!android.text.TextUtils.isEmpty(this.userRelationFuction) && !android.text.TextUtils.isEmpty(this.userRelationMethod)) {
            userRelationCallBack(userRelationRet);
        }
    }

    @Override // com.tencent.ysdk.module.user.UserListener
    public synchronized void OnWakeupNotify(com.tencent.ysdk.module.user.WakeupRet wakeupRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d("H5GameJSSDKManager ", "OnWakeupNotify :" + wakeupRet.flag);
    }

    public synchronized void requestAutoLogin(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        if (isConfigEnable()) {
            this.userLoginFunction = str2;
            this.userLoginSeqid = i;
            this.userLoginMethod = str;
            this.jsBridge = jsBridge;
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().setUserListener(this);
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().autoLogin();
        }
    }

    public synchronized void requestBuyItem(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        if (isConfigEnable()) {
            this.payFunction = str2;
            this.paySeqid = i;
            this.payMethod = str;
            this.jsBridge = jsBridge;
            com.tencent.ysdk.module.pay.PayItem payItem = new com.tencent.ysdk.module.pay.PayItem();
            payItem.id = uri.getQueryParameter("itemid");
            payItem.name = uri.getQueryParameter("item_name");
            payItem.desc = uri.getQueryParameter("item_desc");
            java.lang.String queryParameter = uri.getQueryParameter("item_price");
            if (!android.text.TextUtils.isEmpty(queryParameter)) {
                payItem.price = java.lang.Integer.parseInt(queryParameter);
            }
            java.lang.String queryParameter2 = uri.getQueryParameter("item_num");
            if (!android.text.TextUtils.isEmpty(queryParameter2)) {
                payItem.num = java.lang.Integer.parseInt(queryParameter2);
            }
            com.tencent.ysdk.api.YSDKApi.buyGoods(false, uri.getQueryParameter(com.tencent.open.SocialOperation.GAME_ZONE_ID), payItem, uri.getQueryParameter("[REDACTED]"), null, "[REDACTED]", "[REDACTED]", this);
        }
    }

    public synchronized void requestBuyItemURL(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        if (isConfigEnable()) {
            this.payFunction = str2;
            this.paySeqid = i;
            this.payMethod = str;
            this.jsBridge = jsBridge;
            com.tencent.ysdk.api.YSDKApi.buyGoods(uri.getQueryParameter(com.tencent.open.SocialOperation.GAME_ZONE_ID), uri.getQueryParameter("item_url"), null, "ysdkExt", this);
        }
    }

    public synchronized void requestCharge(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        if (isConfigEnable()) {
            this.payFunction = str2;
            this.paySeqid = i;
            this.payMethod = str;
            this.jsBridge = jsBridge;
            com.tencent.ysdk.api.YSDKApi.recharge(uri.getQueryParameter(com.tencent.open.SocialOperation.GAME_ZONE_ID), uri.getQueryParameter("save_value"), false, null, "ysdkExt", this);
        }
    }

    public synchronized void requestLogout(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        if (isConfigEnable()) {
            this.userLoginFunction = str2;
            this.userLoginSeqid = i;
            this.userLoginMethod = str;
            this.jsBridge = jsBridge;
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().setUserListener(this);
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().logout();
            com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
            com.tencent.ysdk.api.YSDKApi.getLoginRecord(userLoginRet);
            userLoginCallBack(userLoginRet);
        }
    }

    public synchronized void requestQQLogin(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        if (isConfigEnable()) {
            this.userLoginFunction = str2;
            this.userLoginSeqid = i;
            this.userLoginMethod = str;
            this.jsBridge = jsBridge;
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().setUserListener(this);
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().login(com.tencent.ysdk.framework.common.ePlatform.QQ);
        }
    }

    public synchronized void requestUserInfo(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        if (isConfigEnable()) {
            this.userRelationFuction = str2;
            this.userRelationSeqid = i;
            this.userRelationMethod = str;
            this.jsBridge = jsBridge;
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().setUserListener(this);
            com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
            com.tencent.ysdk.api.YSDKApi.getLoginRecord(userLoginRet);
            if (userLoginRet.flag == 0) {
                com.tencent.ysdk.shell.module.user.UserApi.getInstance().queryUserInfo(com.tencent.ysdk.framework.common.ePlatform.getEnum(userLoginRet.platform), this);
            }
        }
    }

    public synchronized void requestWXLogin(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        if (isConfigEnable()) {
            this.userLoginFunction = str2;
            this.userLoginSeqid = i;
            this.userLoginMethod = str;
            this.jsBridge = jsBridge;
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().setUserListener(this);
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().login(com.tencent.ysdk.framework.common.ePlatform.WX);
        }
    }
}
