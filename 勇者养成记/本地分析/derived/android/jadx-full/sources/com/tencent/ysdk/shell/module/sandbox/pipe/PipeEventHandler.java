package com.tencent.ysdk.shell.module.sandbox.pipe;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PipeEventHandler {
    private static final java.lang.String TAG = "pipe_handler";

    public static java.util.Map dispatchEvent(int i, java.util.Map map) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "dispatchEvent: " + i);
        if (i == 1) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "handle EVENT_MARK_SANDBOX event");
            com.tencent.ysdk.shell.module.sandbox.SandboxLoginHandler.handleMarkSandbox(map);
        }
        if (i == 16) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "handle EVENT_FREE_LOGIN event");
            java.lang.String str = (java.lang.String) map.get(com.tencent.pipe.IPipeInterface.KEY_LOGIN_INFO);
            java.lang.String str2 = (java.lang.String) map.get(com.tencent.pipe.IPipeInterface.KEY_SESSION_TYPE);
            java.lang.String str3 = (java.lang.String) map.get("sessionId");
            com.tencent.ysdk.shell.module.sandbox.SandboxConfig.setSessionType(str2);
            com.tencent.ysdk.shell.module.sandbox.SandboxConfig.setSessionId(str3);
            if (android.text.TextUtils.isEmpty(str)) {
                com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "loginInfo is null");
            } else {
                com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().setLoginInfo(str);
            }
        }
        if (i == 302) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "handle EVENT_PAY_CALLBACK event");
            com.tencent.ysdk.shell.module.sandbox.SandboxPayModule.getInstance().sendPayCallback(map);
        }
        if (i != 402) {
            return null;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "handle EVENT_PLUGIN_QQ_LOGIN event");
        com.tencent.ysdk.shell.module.user.UserApi.getInstance().login(com.tencent.ysdk.framework.common.ePlatform.QQ);
        return null;
    }
}
