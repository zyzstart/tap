package com.tencent.ysdk.shell.module.user.impl.freelogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FreeLoginRet extends com.tencent.ysdk.module.user.UserLoginRet {
    public java.lang.String access_token = "[REDACTED]";

    public FreeLoginRet() {
        this.platform = 8;
    }

    public void parseFreeLoginResponse(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse cloudGameFreeloginResponse) {
        this.ret = cloudGameFreeloginResponse.ret;
        this.flag = 0;
        if (com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().isLoginInfoVaild(this.platform)) {
            this.open_id = com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().getgOpenID();
            this.access_token = com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().getToken();
            this.pf = cloudGameFreeloginResponse.mDataJson.optString("pf");
            this.pf_key = cloudGameFreeloginResponse.mDataJson.optString("pfkey");
        }
        this.msg = "free login succ!";
        this.platform = 8;
    }

    @Override // com.tencent.ysdk.module.user.UserLoginRet, com.tencent.ysdk.framework.common.BaseRet
    public java.lang.String toString() {
        return "[REDACTED]" + this.access_token + "[REDACTED]" + this.platform + "[REDACTED]" + this.open_id + "[REDACTED]" + this.nick_name + "[REDACTED]" + this.pf + "[REDACTED]" + this.pf_key + "[REDACTED]" + this.create_timestamp + "[REDACTED]" + this.update_timestamp + "[REDACTED]" + this.token + "[REDACTED]" + this.ret + "[REDACTED]" + this.flag + "[REDACTED]" + this.msg + "[REDACTED]" + this.errorCode + '}';
    }
}
