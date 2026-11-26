package com.tencent.ysdk.module.user;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserToken {

    @com.tencent.ysdk.framework.verification.YSDKDescription("[REDACTED]")
    public static final int TOKEN_TYPE_FREE_LOGIN_ACCESS = 6;

    @com.tencent.ysdk.framework.verification.YSDKDescription("[REDACTED]")
    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.3")
    public static final int TOKEN_TYPE_GUEST_PAY = 5;

    @com.tencent.ysdk.framework.verification.YSDKDescription("[REDACTED]")
    public static final int TOKEN_TYPE_QQ_ACCESS = 1;

    @com.tencent.ysdk.framework.verification.YSDKDescription("[REDACTED]")
    public static final int TOKEN_TYPE_QQ_PAY = 2;

    @com.tencent.ysdk.framework.verification.YSDKDescription("[REDACTED]")
    public static final int TOKEN_TYPE_WX_ACCESS = 3;

    @com.tencent.ysdk.framework.verification.YSDKDescription("[REDACTED]")
    public static final int TOKEN_TYPE_WX_REFRESH = 4;
    public long expiration;
    public int type;
    public java.lang.String value;

    public UserToken() {
        this.type = 0;
        this.value = "";
        this.expiration = 0L;
    }

    public UserToken(int i, java.lang.String str, long j) {
        this.type = 0;
        this.value = "";
        this.expiration = 0L;
        this.type = i;
        this.value = str;
        this.expiration = j;
    }

    public UserToken(com.tencent.ysdk.module.user.UserToken userToken) {
        this.type = 0;
        this.value = "";
        this.expiration = 0L;
        this.type = userToken.type;
        this.value = userToken.value;
        this.expiration = userToken.expiration;
    }
}
