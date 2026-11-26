package com.tencent.ysdk.shell.module.user.impl.qq;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQUserLoginRet extends com.tencent.ysdk.module.user.UserLoginRet {
    public java.lang.String access_token = "[REDACTED]";
    public long access_token_expire = 0;
    public java.lang.String pay_token = "[REDACTED]";
    public long pay_token_expire = 0;

    public QQUserLoginRet() {
        this.platform = 1;
    }

    protected void parseQQLoginResponse(com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse qQUserCheckResponse) {
        this.ret = qQUserCheckResponse.ret;
        this.flag = qQUserCheckResponse.flag;
        this.pf = qQUserCheckResponse.pf;
        this.pf_key = qQUserCheckResponse.pfKey;
        this.nick_name = qQUserCheckResponse.nick_name;
        setRegChannel(qQUserCheckResponse.regChannel);
        setUserType(qQUserCheckResponse.first);
    }

    @Override // com.tencent.ysdk.module.user.UserLoginRet, com.tencent.ysdk.framework.common.BaseRet
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[REDACTED]" + this.access_token + "[REDACTED]");
        sb.append("[REDACTED]" + this.access_token_expire + "[REDACTED]");
        sb.append("[REDACTED]" + this.pay_token + "[REDACTED]");
        sb.append("[REDACTED]" + this.pay_token_expire + "[REDACTED]");
        sb.append("regChannel" + getRegChannel() + "\n");
        return "QQUserLoginRet : \n" + super.toString() + sb.toString();
    }
}
