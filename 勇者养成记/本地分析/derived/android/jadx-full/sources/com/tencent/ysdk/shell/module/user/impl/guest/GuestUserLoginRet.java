package com.tencent.ysdk.shell.module.user.impl.guest;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GuestUserLoginRet extends com.tencent.ysdk.module.user.UserLoginRet {
    public java.lang.String pay_token = "[REDACTED]";

    public GuestUserLoginRet() {
        this.platform = 7;
    }

    protected void parseGuestLoginResponse(com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse guestUserLoginResponse) {
        this.ret = guestUserLoginResponse.ret;
        this.flag = 0;
        this.msg = guestUserLoginResponse.msg;
        this.platform = 7;
        this.open_id = guestUserLoginResponse.openid;
        this.pay_token = guestUserLoginResponse.pay_token;
        this.pf = guestUserLoginResponse.pf;
        this.pf_key = guestUserLoginResponse.pfKey;
        setRegChannel(guestUserLoginResponse.regChannel);
        setUserType(guestUserLoginResponse.first);
    }
}
