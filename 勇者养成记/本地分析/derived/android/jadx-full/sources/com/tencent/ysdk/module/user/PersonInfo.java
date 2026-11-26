package com.tencent.ysdk.module.user;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PersonInfo {

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户openid")
    public java.lang.String openId = "";

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户昵称")
    public java.lang.String nickName = "";

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户userId,同一个开发者名下多个应用同一用户的唯一标示")
    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.1.1")
    public java.lang.String userId = "";

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户性别")
    public java.lang.String gender = "";

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户小头像")
    public java.lang.String pictureSmall = "";

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户中头像")
    public java.lang.String pictureMiddle = "";

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户大头像")
    public java.lang.String pictureLarge = "";

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户国籍")
    public java.lang.String country = "";

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户省份")
    public java.lang.String province = "";

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户城市")
    public java.lang.String city = "";

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("UserInfoResponse json: \n");
        sb.append("nick_name: " + this.nickName + "\n");
        sb.append("open_id: " + this.openId + "\n");
        sb.append("userId: " + this.userId + "\n");
        sb.append("gender: " + this.gender + "\n");
        sb.append("picture_small: " + this.pictureSmall + "\n");
        sb.append("picture_middle: " + this.pictureMiddle + "\n");
        sb.append("picture_large: " + this.pictureLarge + "\n");
        sb.append("provice: " + this.province + "\n");
        sb.append("city: " + this.city + "\n");
        sb.append("country: " + this.country + "\n");
        return super.toString() + sb.toString();
    }
}
