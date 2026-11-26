package com.tencent.ysdk.module.user;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserLoginRet extends com.tencent.ysdk.framework.common.BaseRet {
    public static final java.lang.String DEFAULT_CHANNEL = "00000000";
    public static final int LOGIN_TYPE_AUTH = 0;
    public static final int LOGIN_TYPE_AUTO = 1;
    public static final int LOGIN_TYPE_LOGOUT = 3;
    public static final int LOGIN_TYPE_TIMER = 2;
    public static final int USER_TYPE_NEW = 1;
    public static final int USER_TYPE_OLD = 0;
    public long create_timestamp;

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.4")
    private int login_type;
    public java.lang.String nick_name;
    public java.lang.String open_id;
    public java.lang.String pf;
    public java.lang.String pf_key;
    public int platform;
    private java.lang.String reg_channel;
    public java.util.Vector token;
    public long update_timestamp;

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.0")
    private int user_type;

    public UserLoginRet() {
        this.platform = com.tencent.ysdk.framework.common.ePlatform.None.val();
        this.open_id = "";
        this.nick_name = "";
        this.user_type = 0;
        this.reg_channel = DEFAULT_CHANNEL;
        this.login_type = 0;
        this.pf = "";
        this.pf_key = "";
        this.create_timestamp = 0L;
        this.update_timestamp = 0L;
        this.token = new java.util.Vector();
    }

    public UserLoginRet(int i, int i2, java.lang.String str, int i3) {
        super(i, i2, str);
        this.platform = com.tencent.ysdk.framework.common.ePlatform.None.val();
        this.open_id = "";
        this.nick_name = "";
        this.user_type = 0;
        this.reg_channel = DEFAULT_CHANNEL;
        this.login_type = 0;
        this.pf = "";
        this.pf_key = "";
        this.create_timestamp = 0L;
        this.update_timestamp = 0L;
        this.token = new java.util.Vector();
        this.platform = i3;
    }

    public UserLoginRet(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        super(userLoginRet);
        this.platform = com.tencent.ysdk.framework.common.ePlatform.None.val();
        this.open_id = "";
        this.nick_name = "";
        this.user_type = 0;
        this.reg_channel = DEFAULT_CHANNEL;
        this.login_type = 0;
        this.pf = "";
        this.pf_key = "";
        this.create_timestamp = 0L;
        this.update_timestamp = 0L;
        this.token = new java.util.Vector();
        if (userLoginRet != null) {
            this.platform = userLoginRet.platform;
            this.open_id = userLoginRet.open_id;
            this.user_type = userLoginRet.user_type;
            this.reg_channel = userLoginRet.reg_channel;
            this.pf = userLoginRet.pf;
            this.pf_key = userLoginRet.pf_key;
            this.create_timestamp = userLoginRet.create_timestamp;
            this.update_timestamp = userLoginRet.update_timestamp;
            this.nick_name = userLoginRet.nick_name;
            this.login_type = userLoginRet.getLoginType();
            java.util.Iterator it = userLoginRet.token.iterator();
            while (it.hasNext()) {
                this.token.add(new com.tencent.ysdk.module.user.UserToken((com.tencent.ysdk.module.user.UserToken) it.next()));
            }
        }
    }

    public void copy(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        super.copy((com.tencent.ysdk.framework.common.BaseRet) userLoginRet);
        if (userLoginRet != null) {
            this.platform = userLoginRet.platform;
            this.open_id = userLoginRet.open_id;
            this.user_type = userLoginRet.user_type;
            this.reg_channel = userLoginRet.reg_channel;
            this.pf = userLoginRet.pf;
            this.pf_key = userLoginRet.pf_key;
            this.create_timestamp = userLoginRet.create_timestamp;
            this.update_timestamp = userLoginRet.update_timestamp;
            this.login_type = userLoginRet.login_type;
            java.util.Iterator it = userLoginRet.token.iterator();
            while (it.hasNext()) {
                this.token.add(new com.tencent.ysdk.module.user.UserToken((com.tencent.ysdk.module.user.UserToken) it.next()));
            }
        }
    }

    public java.lang.String getAccessToken() {
        com.tencent.ysdk.module.user.UserToken userToken;
        int i;
        int i2 = this.platform;
        if (i2 != 2) {
            if (i2 == 1) {
                userToken = getTokenByType(1);
            } else if (i2 == 8) {
                i = 6;
            } else if (i2 == 7) {
                i = 5;
            } else {
                userToken = new com.tencent.ysdk.module.user.UserToken();
            }
            return userToken.value;
        }
        i = 3;
        userToken = getTokenByType(i);
        return userToken.value;
    }

    public int getLoginType() {
        return this.login_type;
    }

    public java.lang.String getPayToken() {
        com.tencent.ysdk.module.user.UserToken userToken;
        int i;
        int i2 = this.platform;
        if (i2 != 2) {
            if (i2 == 1) {
                userToken = getTokenByType(2);
            } else if (i2 == 7) {
                i = 5;
            } else {
                userToken = new com.tencent.ysdk.module.user.UserToken();
            }
            return userToken.value;
        }
        i = 3;
        userToken = getTokenByType(i);
        return userToken.value;
    }

    public java.lang.String getRefreshToken() {
        return (this.platform == 2 ? getTokenByType(4) : new com.tencent.ysdk.module.user.UserToken()).value;
    }

    public java.lang.String getRegChannel() {
        return this.reg_channel;
    }

    public com.tencent.ysdk.module.user.UserToken getTokenByType(int i) {
        for (int i2 = 0; i2 < this.token.size(); i2++) {
            if (((com.tencent.ysdk.module.user.UserToken) this.token.get(i2)).type == i) {
                return (com.tencent.ysdk.module.user.UserToken) this.token.get(i2);
            }
        }
        return new com.tencent.ysdk.module.user.UserToken();
    }

    public int getUserType() {
        return this.user_type;
    }

    public void setLoginType(int i) {
        this.login_type = i;
    }

    public void setRegChannel(java.lang.String str) {
        this.reg_channel = str;
    }

    public void setUserType(int i) {
        this.user_type = i;
    }

    @Override // com.tencent.ysdk.framework.common.BaseRet
    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("platform : " + this.platform + "\n");
        sb.append("open_id : " + this.open_id + "\n");
        sb.append("user_type :" + this.user_type + "\n");
        sb.append("login_type :" + getLoginType() + "\n");
        sb.append("pf :" + this.pf + "\n");
        sb.append("pf_key :" + this.pf_key + "\n");
        for (int i = 0; i < this.token.size(); i++) {
            com.tencent.ysdk.module.user.UserToken userToken = (com.tencent.ysdk.module.user.UserToken) this.token.get(i);
            switch (userToken.type) {
                case 1:
                    str = "[REDACTED]";
                    break;
                case 2:
                    str = "[REDACTED]";
                    break;
                case 3:
                    str = "[REDACTED]";
                    break;
                case 4:
                    str = "[REDACTED]";
                    break;
                case 5:
                    str = "[REDACTED]";
                    break;
                case 6:
                    str = "[REDACTED]";
                    break;
                default:
                    str = "[REDACTED]";
                    break;
            }
            sb.append(str + "[REDACTED]" + userToken.value + "[REDACTED]" + userToken.expiration + "[REDACTED]");
        }
        return "UserLoginRet : \n" + super.toString() + sb.toString();
    }
}
