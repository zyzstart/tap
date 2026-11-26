package com.tencent.ysdk.shell.module.realName.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RegisterRealNameResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    public static final int CERT_BIND_COUNT_LIMIT = 2;
    public static final int INVALID_BIRTH = 4;
    public static final int INVALID_CN_NAME = 5;
    public static final int INVALID_ID_CARD = 3;
    public static final int INVALID_PARA = 6;
    public static final int REG_ALREADY = 1;

    /* JADX WARN: Code duplicated, block: B:15:0x0032  */
    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        super.parseBaseJson(safeJSONObject);
        int i = 1;
        if (1 != this.ret) {
            this.flag = 0;
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, safeJSONObject.toString());
        int i2 = this.flag;
        if (i2 != 32) {
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    i = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.YSDK_SERVER_ERROR;
                    break;
                case 5:
                    break;
                case 6:
                    i = 2;
                    break;
                default:
                    switch (i2) {
                        case 100:
                            i = 6;
                            break;
                        case 101:
                            i = 3;
                            break;
                        case 102:
                            i = 4;
                            break;
                        case 103:
                            i = 5;
                            break;
                        case 104:
                            i = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_NEED_LOGIN;
                            break;
                        default:
                            i = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.YSDK_SERVER_ERROR;
                            break;
                    }
                    break;
            }
        } else {
            i = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_NEED_LOGIN;
        }
        this.flag = i;
        this.msg = this.msg.toString() + this.flag;
    }
}
