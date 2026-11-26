package com.tencent.ysdk.shell.module.user.impl.wx;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXUserLoginRet extends com.tencent.ysdk.module.user.UserLoginRet {
    public java.lang.String wx_code = "";
    public java.lang.String access_token = "[REDACTED]";
    public long access_token_expire = 0;
    public java.lang.String refresh_token = "[REDACTED]";
    public long refresh_token_expire = 0;
    public java.lang.String nick_name = "";

    public WXUserLoginRet() {
        this.platform = 2;
    }

    protected void parseWXLoginResponse(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse wXUserLoginResponse) {
        this.ret = wXUserLoginResponse.ret;
        this.flag = 0;
        this.msg = "wx first login succ, get login info!";
        this.platform = 2;
        this.access_token = wXUserLoginResponse.accessToken;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        if (wXUserLoginResponse.expired > 0) {
            this.access_token_expire = ((long) wXUserLoginResponse.expired) + jCurrentTimeMillis;
        } else {
            this.access_token_expire = 7200 + jCurrentTimeMillis;
        }
        this.open_id = wXUserLoginResponse.openid;
        this.pf = wXUserLoginResponse.pf;
        this.pf_key = wXUserLoginResponse.pfKey;
        this.nick_name = wXUserLoginResponse.nick_name;
        this.refresh_token = wXUserLoginResponse.refreshToken;
        if (this.refresh_token_expire == 0) {
            this.refresh_token_expire = jCurrentTimeMillis + 2592000;
        }
        setRegChannel(wXUserLoginResponse.regChannel);
        setUserType(wXUserLoginResponse.first);
    }

    @Override // com.tencent.ysdk.module.user.UserLoginRet, com.tencent.ysdk.framework.common.BaseRet
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("wx_code : " + this.wx_code + "\n");
        sb.append("[REDACTED]" + this.access_token + "[REDACTED]");
        sb.append("[REDACTED]" + this.access_token_expire + "[REDACTED]");
        sb.append("nick_name :" + this.nick_name + "\n");
        sb.append("[REDACTED]" + this.refresh_token + "[REDACTED]");
        sb.append("[REDACTED]" + this.refresh_token_expire + "[REDACTED]");
        return "WXUserLoginRet : \n" + super.toString() + sb.toString();
    }
}
