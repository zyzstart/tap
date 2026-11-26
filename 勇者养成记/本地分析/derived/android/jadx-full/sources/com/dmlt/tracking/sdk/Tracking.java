package com.dmlt.tracking.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Tracking {
    private static java.lang.String aid;
    private static android.content.Context appContext;
    private static java.lang.String appKey;
    private static java.lang.String channel;
    private static java.lang.String cid;
    private static com.dmlt.tracking.sdk.DodAdReportCallback mDodAdReportCallback;
    private static java.lang.String oaid;
    private static com.dmlt.tracking.config.RoleInfo roleInfo;
    private static java.lang.String subchannel;
    private static com.dmlt.tracking.config.UinInfo uinInfo;
    private static java.lang.String uuid;

    private static java.lang.String chargeParams(java.lang.String str, java.lang.String str2, int i) {
        return "goods_id=" + str + "&order_id=" + str2 + "&amount=" + i;
    }

    private static boolean check() {
        if (com.dmlt.tracking.util.ObjectUtil.isEmpty(appKey)) {
            com.dmlt.tracking.util.LogUtil.e("[REDACTED]");
            return true;
        }
        if (com.dmlt.tracking.util.ObjectUtil.isEmpty(appContext)) {
            com.dmlt.tracking.util.LogUtil.e("appContext can not be null! init failed!");
            return true;
        }
        if (com.dmlt.tracking.util.ObjectUtil.isEmpty(aid)) {
            com.dmlt.tracking.util.LogUtil.e("aid can not be null! init failed!");
            return true;
        }
        if (!com.dmlt.tracking.util.ObjectUtil.isEmpty(channel)) {
            return false;
        }
        com.dmlt.tracking.util.LogUtil.e("channel can not be null! init failed!");
        return true;
    }

    private static boolean checkRoleInfo() {
        if (checkUinInfo()) {
            return true;
        }
        com.dmlt.tracking.config.RoleInfo roleInfo2 = roleInfo;
        if (roleInfo2 == null) {
            com.dmlt.tracking.util.LogUtil.e("Your role is incorrect!");
            return true;
        }
        if (!com.dmlt.tracking.util.ObjectUtil.isEmpty(roleInfo2.getRoleId())) {
            return false;
        }
        com.dmlt.tracking.util.LogUtil.e("Your role is incorrect!");
        return true;
    }

    private static boolean checkUinInfo() {
        com.dmlt.tracking.config.UinInfo uinInfo2 = uinInfo;
        if (uinInfo2 == null) {
            com.dmlt.tracking.util.LogUtil.e("Your uin is incorrect!");
            return true;
        }
        if (!com.dmlt.tracking.util.ObjectUtil.isEmpty(java.lang.Integer.valueOf(uinInfo2.getUin()))) {
            return false;
        }
        com.dmlt.tracking.util.LogUtil.e("Your uin is incorrect!");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String deviceParams(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("idfa=");
        sb.append("&oaid=");
        sb.append(oaid);
        sb.append("&imei=");
        sb.append(com.dmlt.tracking.util.DataContextUtil.getImei(context));
        sb.append("&android=");
        sb.append(com.dmlt.tracking.util.DataContextUtil.getAndroid(context));
        sb.append("&mac=");
        sb.append(com.dmlt.tracking.util.DataContextUtil.getMac(context));
        try {
            sb.append("&ua=");
            sb.append(java.net.URLEncoder.encode(com.dmlt.tracking.util.DataContextUtil.getUa(context), com.unisound.b.f.b));
        } catch (java.io.UnsupportedEncodingException e) {
            com.dmlt.tracking.util.LogUtil.e(e.getMessage());
            sb.append("&ua=");
        }
        sb.append("&os=android");
        return sb.toString();
    }

    public static void init(final android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, boolean z) {
        com.dmlt.tracking.config.ConstConfig.DebugMode = z;
        appContext = context;
        appKey = str;
        channel = str4;
        subchannel = str5;
        aid = str2;
        cid = str3;
        uuid = new com.dmlt.tracking.sdk.DeviceUuidFactory(context).getDodUuid();
        if (check()) {
            com.dmlt.tracking.util.LogUtil.e("init failed");
        } else {
            new com.dmlt.tracking.sdk.MiitHelper(new com.dmlt.tracking.sdk.MiitHelper.AppIdsUpdater() { // from class: com.dmlt.tracking.sdk.Tracking.1
                @Override // com.dmlt.tracking.sdk.MiitHelper.AppIdsUpdater
                public void OnIdsAvalid(@androidx.annotation.NonNull java.lang.String str6) {
                    com.dmlt.tracking.util.LogUtil.i("ids=======>" + str6);
                }

                @Override // com.dmlt.tracking.sdk.MiitHelper.AppIdsUpdater
                public void OnIdsOAID(@androidx.annotation.NonNull java.lang.String str6) {
                    java.lang.String unused = com.dmlt.tracking.sdk.Tracking.oaid = str6;
                    com.dmlt.tracking.util.HttpUtil.get((com.dmlt.tracking.config.ConstConfig.getUrl() + com.dmlt.tracking.config.ConstConfig.STARTUP_SERVICE) + (com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + com.dmlt.tracking.sdk.Tracking.selfParams() + "&" + com.dmlt.tracking.sdk.Tracking.deviceParams(context) + "&" + com.dmlt.tracking.sdk.Tracking.phoneParams()), new com.dmlt.tracking.util.HttpUtil.OnRequestCallBack() { // from class: com.dmlt.tracking.sdk.Tracking.1.1
                        @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
                        public void onError(java.lang.String str7) {
                            com.dmlt.tracking.util.LogUtil.e("startup onError: " + str7);
                        }

                        @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
                        public void onSuccess(java.lang.String str7) {
                            com.dmlt.tracking.util.LogUtil.i("startup onSuccess: " + str7);
                        }
                    });
                }
            }).getDeviceIds(context);
        }
    }

    public static void isAdReportOdds(final int i) {
        com.dmlt.tracking.util.HttpUtil.get((com.dmlt.tracking.config.ConstConfig.getUrl() + com.dmlt.tracking.config.ConstConfig.AD_REPORT_ODDS) + ("[REDACTED]" + appKey + "[REDACTED]" + channel + "[REDACTED]" + cid + "[REDACTED]" + i), new com.dmlt.tracking.util.HttpUtil.OnRequestCallBack() { // from class: com.dmlt.tracking.sdk.Tracking.7
            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onError(java.lang.String str) {
                com.dmlt.tracking.util.LogUtil.e("onError: " + str);
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("amount", i);
                    jSONObject.put(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, true);
                    jSONObject.put("message", "");
                    if (com.dmlt.tracking.sdk.Tracking.mDodAdReportCallback != null) {
                        com.dmlt.tracking.sdk.Tracking.mDodAdReportCallback.onReportSuccess(jSONObject.toString());
                    }
                } catch (java.lang.Exception unused) {
                }
            }

            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onSuccess(java.lang.String str) {
                com.dmlt.tracking.util.LogUtil.i("onSuccess: " + str);
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                    jSONObject.put("amount", i);
                    if (com.dmlt.tracking.sdk.Tracking.mDodAdReportCallback != null) {
                        com.dmlt.tracking.sdk.Tracking.mDodAdReportCallback.onReportSuccess(jSONObject.toString());
                    }
                } catch (java.lang.Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String phoneParams() {
        return "phone_model=" + android.os.Build.MODEL + "&phone_carrier=" + android.os.Build.BRAND + "&phone_model_version=" + android.os.Build.VERSION.RELEASE;
    }

    private static java.lang.String realNameParam(java.lang.String str, java.lang.String str2) {
        return "real_name=" + java.net.URLEncoder.encode(str) + "&id_card=" + str2;
    }

    public static void reportCreateRole() {
        if (checkRoleInfo()) {
            com.dmlt.tracking.util.LogUtil.e("setCreateRole failed");
            return;
        }
        com.dmlt.tracking.util.HttpUtil.get((com.dmlt.tracking.config.ConstConfig.getUrl() + com.dmlt.tracking.config.ConstConfig.CREATE_ROLE_SERVICE) + (com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + selfParams() + "&" + deviceParams(appContext) + "&" + phoneParams() + "&" + uinParams(uinInfo) + "&" + roleParams(roleInfo)), new com.dmlt.tracking.util.HttpUtil.OnRequestCallBack() { // from class: com.dmlt.tracking.sdk.Tracking.3
            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onError(java.lang.String str) {
                com.dmlt.tracking.util.LogUtil.e("setCreateRole onError: " + str);
            }

            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onSuccess(java.lang.String str) {
                com.dmlt.tracking.util.LogUtil.i("setCreateRole onSuccess: " + str);
            }
        });
    }

    public static void reportLogin() {
        if (checkRoleInfo()) {
            com.dmlt.tracking.util.LogUtil.e("setLogin failed");
            return;
        }
        com.dmlt.tracking.util.HttpUtil.get((com.dmlt.tracking.config.ConstConfig.getUrl() + com.dmlt.tracking.config.ConstConfig.LOGIN_SERVICE) + (com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + selfParams() + "&" + deviceParams(appContext) + "&" + phoneParams() + "&" + uinParams(uinInfo) + "&" + roleParams(roleInfo)), new com.dmlt.tracking.util.HttpUtil.OnRequestCallBack() { // from class: com.dmlt.tracking.sdk.Tracking.4
            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onError(java.lang.String str) {
                com.dmlt.tracking.util.LogUtil.e("setLogin onError: " + str);
            }

            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onSuccess(java.lang.String str) {
                com.dmlt.tracking.util.LogUtil.i("setLogin onSuccess: " + str);
            }
        });
    }

    public static void reportRealName(java.lang.String str, java.lang.String str2) {
        if (checkRoleInfo()) {
            com.dmlt.tracking.util.LogUtil.e("setRechargeEnd failed");
            return;
        }
        if (com.dmlt.tracking.util.ObjectUtil.isEmpty(str2)) {
            com.dmlt.tracking.util.LogUtil.e("Your IdCard is empty!");
            return;
        }
        if (com.dmlt.tracking.util.ObjectUtil.isEmpty(str)) {
            com.dmlt.tracking.util.LogUtil.e("Your realName is empty!");
            return;
        }
        com.dmlt.tracking.util.HttpUtil.get((com.dmlt.tracking.config.ConstConfig.getUrl() + com.dmlt.tracking.config.ConstConfig.REALNAME_SERVICE) + (com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + selfParams() + "&" + deviceParams(appContext) + "&" + phoneParams() + "&" + uinParams(uinInfo) + "&" + roleParams(roleInfo) + "&" + realNameParam(str, str2)), new com.dmlt.tracking.util.HttpUtil.OnRequestCallBack() { // from class: com.dmlt.tracking.sdk.Tracking.6
            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onError(java.lang.String str3) {
                com.dmlt.tracking.util.LogUtil.e("reportRealName onError: " + str3);
            }

            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onSuccess(java.lang.String str3) {
                com.dmlt.tracking.util.LogUtil.i("reportRealName onSuccess: " + str3);
            }
        });
    }

    public static void reportRecharge(java.lang.String str, java.lang.String str2, int i) {
        if (checkRoleInfo()) {
            com.dmlt.tracking.util.LogUtil.e("setRechargeEnd failed");
            return;
        }
        if (com.dmlt.tracking.util.ObjectUtil.isEmpty(str2)) {
            com.dmlt.tracking.util.LogUtil.e("Your order_id is empty!");
            return;
        }
        com.dmlt.tracking.util.HttpUtil.get((com.dmlt.tracking.config.ConstConfig.getUrl() + com.dmlt.tracking.config.ConstConfig.RECHARGE_SERVICE) + (com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + selfParams() + "&" + deviceParams(appContext) + "&" + phoneParams() + "&" + uinParams(uinInfo) + "&" + roleParams(roleInfo) + "&" + chargeParams(str, str2, i)), new com.dmlt.tracking.util.HttpUtil.OnRequestCallBack() { // from class: com.dmlt.tracking.sdk.Tracking.5
            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onError(java.lang.String str3) {
                com.dmlt.tracking.util.LogUtil.e("setRechargeEnd onError: " + str3);
            }

            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onSuccess(java.lang.String str3) {
                com.dmlt.tracking.util.LogUtil.i("setRechargeEnd onSuccess: " + str3);
            }
        });
    }

    public static void reportRegister() {
        if (checkUinInfo()) {
            com.dmlt.tracking.util.LogUtil.e("setRegister failed");
            return;
        }
        com.dmlt.tracking.util.HttpUtil.get((com.dmlt.tracking.config.ConstConfig.getUrl() + com.dmlt.tracking.config.ConstConfig.REGISTER_SERVICE) + (com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + selfParams() + "&" + deviceParams(appContext) + "&" + phoneParams() + "&" + uinParams(uinInfo)), new com.dmlt.tracking.util.HttpUtil.OnRequestCallBack() { // from class: com.dmlt.tracking.sdk.Tracking.2
            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onError(java.lang.String str) {
                com.dmlt.tracking.util.LogUtil.e("setRegister onError: " + str);
            }

            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onSuccess(java.lang.String str) {
                com.dmlt.tracking.util.LogUtil.i("setRegister onSuccess: " + str);
            }
        });
    }

    private static java.lang.String roleParams(com.dmlt.tracking.config.RoleInfo roleInfo2) {
        return "role_id=" + roleInfo2.getRoleId() + "&world_id=" + roleInfo2.getWorldId() + "&level=" + roleInfo2.getLevel() + "&role_name=" + roleInfo2.getRoleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String selfParams() {
        return "[REDACTED]" + appKey + "[REDACTED]" + channel + "[REDACTED]" + subchannel + "[REDACTED]" + aid + "[REDACTED]" + cid + "[REDACTED]" + uuid;
    }

    public static void setAdReportCallback(com.dmlt.tracking.sdk.DodAdReportCallback dodAdReportCallback) {
        mDodAdReportCallback = dodAdReportCallback;
    }

    public static void setRoleInfo(java.lang.String str, int i, int i2, java.lang.String str2) {
        if (checkUinInfo()) {
            return;
        }
        roleInfo = new com.dmlt.tracking.config.RoleInfo(str, i, i2, str2);
    }

    public static void setUinInfo(int i, int i2, java.lang.String str) {
        uinInfo = new com.dmlt.tracking.config.UinInfo(i, i2, str);
    }

    private static java.lang.String uinParams(com.dmlt.tracking.config.UinInfo uinInfo2) {
        return "uin=" + uinInfo2.getUin() + "&region=" + uinInfo2.getRegion() + "&channel_name=" + uinInfo2.getChannelName();
    }
}
