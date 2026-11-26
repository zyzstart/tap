package com.tencent.ysdk.shell.module.sandbox;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SandboxLoginHandler {
    public static final java.lang.String TAG = "sandbox_login";

    public static void handleMarkSandbox(java.util.Map map) {
        java.lang.String str = (java.lang.String) map.get("packageName");
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.ysdk.shell.module.sandbox.SandboxConfig.setSandBoxEnv();
        com.tencent.ysdk.shell.module.sandbox.SandboxConfig.setPackageName(str);
        com.tencent.ysdk.shell.module.sandbox.SandboxConfig.setLogin(((java.lang.Boolean) map.get(com.tencent.pipe.IPipeInterface.KEY_IS_LOGIN)).booleanValue());
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().setSandboxIconCanBeShowed(false);
    }
}
