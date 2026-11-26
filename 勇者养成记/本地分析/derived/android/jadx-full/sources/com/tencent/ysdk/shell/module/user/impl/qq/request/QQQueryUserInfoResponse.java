package com.tencent.ysdk.shell.module.user.impl.qq.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQQueryUserInfoResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_CITY = "city";
    private static final java.lang.String PARAM_COUNTRY = "country";
    private static final java.lang.String PARAM_GENDER = "gender";
    private static final java.lang.String PARAM_NICKNAME = "nickname";
    private static final java.lang.String PARAM_PICTURE = "figureurl";
    private static final java.lang.String PARAM_PROVINCE = "province";
    private static final java.lang.String PARAM_QQ_AVATAR = "qq_face_url";
    private static final java.lang.String PARAM_USERID = "user_id";
    public com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo info = new com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo();

    public QQQueryUserInfoResponse(java.lang.String str) {
        this.info.openId = str;
    }

    private void parseQQQueryUserInfoRespones(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        try {
            this.info.nickName = safeJSONObject.getString(PARAM_NICKNAME);
            this.info.gender = safeJSONObject.getString(PARAM_GENDER);
            this.info.setPicURLs(com.tencent.ysdk.framework.common.ePlatform.QQ, safeJSONObject.has(PARAM_QQ_AVATAR) ? safeJSONObject.getString(PARAM_QQ_AVATAR) : safeJSONObject.getString(PARAM_PICTURE));
            if (safeJSONObject.has("user_id")) {
                this.info.userId = safeJSONObject.getString("user_id");
            }
            this.info.country = safeJSONObject.getString("country");
            this.info.city = safeJSONObject.getString("city");
            this.info.province = safeJSONObject.getString("province");
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LOG_TAG, this.info.toString());
            com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserTableModel.savePersonInfo(this.info);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parseQQQueryUserInfoRespones(safeJSONObject);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.w(safeJSONObject.toString());
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("&nickName=" + this.info.nickName);
        sb.append("&gender=" + this.info.gender);
        sb.append("&pictureSmall=" + this.info.pictureSmall);
        sb.append("&pictureMiddle=" + this.info.pictureMiddle);
        sb.append("&pictureLarge=" + this.info.pictureLarge);
        sb.append("&province=" + this.info.province);
        sb.append("&country=" + this.info.country);
        sb.append("&city=" + this.info.city);
        return super.toString() + sb.toString();
    }
}
