package com.tencent.ysdk.framework.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BaseRet {
    public static final int RET_FAIL = 1;
    public static final int RET_OTHER = -1;
    public static final int RET_SUCC = 0;
    public int errorCode;
    public int flag;
    public java.lang.String msg;
    public int ret;

    public BaseRet() {
        this.ret = 1;
        this.flag = -1;
        this.msg = "";
        this.errorCode = -1;
    }

    public BaseRet(int i, int i2, java.lang.String str) {
        this.ret = 1;
        this.flag = -1;
        this.msg = "";
        this.errorCode = -1;
        this.ret = i;
        this.flag = i2;
        this.msg = str;
    }

    public BaseRet(com.tencent.ysdk.framework.common.BaseRet baseRet) {
        this.ret = 1;
        this.flag = -1;
        this.msg = "";
        this.errorCode = -1;
        if (baseRet != null) {
            this.ret = baseRet.ret;
            this.flag = baseRet.flag;
            this.msg = baseRet.msg;
            this.errorCode = baseRet.errorCode;
        }
    }

    public void copy(com.tencent.ysdk.framework.common.BaseRet baseRet) {
        if (baseRet != null) {
            this.ret = baseRet.ret;
            this.flag = baseRet.flag;
            this.msg = baseRet.msg;
        }
    }

    public java.lang.String toString() {
        return "BaseRet{ret=" + this.ret + ", flag=" + this.flag + ", msg='" + this.msg + "', errorCode=" + this.errorCode + '}';
    }
}
