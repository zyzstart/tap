package com.tencent.ysdk.shell.module.user.impl.wx.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXUserInfoResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_CITY = "city";
    private static final java.lang.String PARAM_COUNTRY = "country";
    private static final java.lang.String PARAM_GENDER = "sex";
    private static final java.lang.String PARAM_NICKNAME = "nickname";
    private static final java.lang.String PARAM_OPENID = "openid";
    private static final java.lang.String PARAM_PICTURE = "picture";
    private static final java.lang.String PARAM_PROVINCE = "province";
    private static final java.lang.String PARAM_USERID = "unionid";
    public com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo userInfo = new com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo();

    private void parseWXUserInfoResponse(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "parseWXUserInfoResponse");
        try {
            this.userInfo.nickName = safeJSONObject.getString(PARAM_NICKNAME);
            this.userInfo.openId = safeJSONObject.getString("openid");
            this.userInfo.gender = "2".equals(safeJSONObject.getString(PARAM_GENDER)) ? "女" : "男";
            this.userInfo.setPicURLs(com.tencent.ysdk.framework.common.ePlatform.WX, safeJSONObject.getString("picture"));
            if (safeJSONObject.has("unionid")) {
                this.userInfo.userId = safeJSONObject.getString("unionid");
            }
            this.userInfo.province = safeJSONObject.getString("province");
            this.userInfo.city = safeJSONObject.getString("city");
            this.userInfo.country = "";
            if (safeJSONObject.has("country")) {
                this.userInfo.country = safeJSONObject.getString("country");
            }
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, this.userInfo.toString());
            com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserTableModel.savePersonInfo(this.userInfo);
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "JSONException : " + safeJSONObject.toString());
            e.printStackTrace();
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parseWXUserInfoResponse(safeJSONObject);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, safeJSONObject.toString());
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("WXUserInfoResponse json: ");
        sb.append("&userInfo=" + this.userInfo.toString());
        return super.toString() + sb.toString();
    }
}
