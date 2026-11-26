package com.tencent.ysdk.framework.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class eFlag {

    @com.tencent.ysdk.framework.verification.YSDKDescription("没有查询到信息 再次调用接口重试")
    public static final int Certification_No_Found_Error = 6001;
    public static final int Error = -1;

    @com.tencent.ysdk.framework.verification.YSDKDescription("单机账号登录失败 引导用户再次尝试")
    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.3")
    public static final int GUEST_LoginFail = 3000;

    @com.tencent.ysdk.framework.verification.YSDKDescription("YSDK 自动登录中 无需关注,可以按照成功处理")
    public static final int Login_CheckingToken = 3102;

    @com.tencent.ysdk.framework.verification.YSDKDescription("YSDK 免登录信息校验失败 ")
    public static final int Login_Free_Login_Auth_Failed = 3104;

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户需要实名认证，游戏方取消超时验证逻辑，无需通知用户")
    public static final int Login_NeedRegisterRealName = 3103;

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户账号没有实名认证 引导用户重新授权并认证权")
    public static final int Login_NotRegisterRealName = 3101;

    @com.tencent.ysdk.framework.verification.YSDKDescription("本地票据不可用 引导用户重新授权")
    public static final int Login_TokenInvalid = 3100;

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户退出登录")
    public static final int Login_User_Logout = 3105;

    @com.tencent.ysdk.framework.verification.YSDKDescription("方法已经废弃")
    public static final int METHOD_DEPRECATED = 7001;

    @com.tencent.ysdk.framework.verification.YSDKDescription("支付参数错误  检查参数以后.引导用户重试")
    public static final int Pay_Param_Error = 4002;

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户取消支付 引导用户重试")
    public static final int Pay_User_Cancle = 4001;

    @com.tencent.ysdk.framework.verification.YSDKDescription("手Q返回登陆失败 引导用户重新授权")
    public static final int QQ_LoginFail = 1002;

    @com.tencent.ysdk.framework.verification.YSDKDescription("手Q提示登录时网路异常 引导用户检查网络后重试")
    public static final int QQ_NetworkErr = 1003;

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户手机没有安装手Q 引导用户安装手Q后重试")
    public static final int QQ_NotInstall = 1004;

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户手机手Q版本太低 引导用户升级手Q后重试")
    public static final int QQ_NotSupportApi = 1005;

    @com.tencent.ysdk.framework.verification.YSDKDescription("手Q返回用户取消 引导用户重新授权或者分享")
    public static final int QQ_UserCancel = 1001;

    @com.tencent.ysdk.framework.verification.YSDKDescription("没有查询到信息 再次调用接口重试")
    public static final int Relation_RelationNoPerson = 3201;

    @com.tencent.ysdk.framework.verification.YSDKDescription("没有获取到应用宝登录态")
    public static final int Sandbox_User_No_Login = 5001;

    @com.tencent.ysdk.framework.verification.YSDKDescription("暂不支持的登录类型")
    public static final int Sandbox_User_No_Support = 5002;
    public static final int Succ = 0;

    @com.tencent.ysdk.framework.verification.YSDKDescription("微信返回登陆失败 引导用户重新授权")
    public static final int WX_LoginFail = 2004;

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户手机没有安装微信 引导用户安装微信后重试")
    public static final int WX_NotInstall = 2000;

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户手机微信版本太低 引导用户升级微信后重试")
    public static final int WX_NotSupportApi = 2001;

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户取消授权 引导用户重新授权或者分享")
    public static final int WX_UserCancel = 2002;

    @com.tencent.ysdk.framework.verification.YSDKDescription("用户拒绝授权 引导用户重新授权")
    public static final int WX_UserDeny = 2003;

    @com.tencent.ysdk.framework.verification.YSDKDescription("应用被拉起时无登陆态 显示登录按钮,引导用户授权")
    public static final int Wakeup_NeedUserLogin = 3301;

    @com.tencent.ysdk.framework.verification.YSDKDescription("拉起游戏时存在异账号 游戏需要弹框让用户选择登入游戏的账号")
    public static final int Wakeup_NeedUserSelectAccount = 3303;

    @com.tencent.ysdk.framework.verification.YSDKDescription("YSDK自动登录中 游戏无需关注（登陆结束结果会通过LoginNotify回调）")
    public static final int Wakeup_YSDKLogining = 3302;
}
