package com.tencent.ysdk.shell.module.debug;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DebugViewManager {
    private static com.tencent.ysdk.shell.module.debug.DebugViewManager mInstance;
    private static android.view.WindowManager mWindowManager;
    private com.tencent.ysdk.shell.module.debug.view.DebugConfigView mDebugConfigView;
    private com.tencent.ysdk.shell.module.debug.view.DebugIconView mDebugIconView;

    private DebugViewManager(android.content.Context context) {
        this.mDebugIconView = new com.tencent.ysdk.shell.module.debug.view.DebugIconView(context);
        this.mDebugConfigView = new com.tencent.ysdk.shell.module.debug.view.DebugConfigView(context);
    }

    public static com.tencent.ysdk.shell.module.debug.DebugViewManager getInstance() {
        if (mInstance == null) {
            synchronized (com.tencent.ysdk.shell.module.debug.DebugViewManager.class) {
                if (mInstance == null) {
                    mInstance = new com.tencent.ysdk.shell.module.debug.DebugViewManager(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext());
                }
            }
        }
        return mInstance;
    }

    public void clearConfig() {
        com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.remove(com.tencent.ysdk.shell.libware.util.AppSharePreferenceKey.KEY_DEBUG_HTTP_DOMAIN);
    }

    public void closeDebugIconView() {
        this.mDebugIconView.closeDebugIconView();
    }

    public java.lang.String getDebugInfo() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = getLoginRecord();
        sb.append("pkgName: ");
        sb.append(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getAppPkgName());
        sb.append("\n");
        sb.append("appid: ");
        sb.append(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId());
        sb.append("\n");
        sb.append("[REDACTED]");
        sb.append(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId());
        sb.append("\n");
        sb.append("qimei: ");
        sb.append(com.tencent.ysdk.api.YSDKApi.getQImei());
        sb.append("\n");
        sb.append("openid: ");
        sb.append(loginRecord.open_id);
        sb.append("\n");
        sb.append("pf: ");
        sb.append(loginRecord.pf);
        sb.append("\n");
        sb.append("pfkey: ");
        sb.append(loginRecord.pf_key);
        sb.append("\n");
        sb.append("防沉迷时长(秒，每5分钟刷新一次)：");
        sb.append(com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().getGameDuration());
        return sb.toString();
    }

    public java.lang.String getDomain() {
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getDomain();
    }

    com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        return com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
    }

    public android.view.WindowManager getWindowManager() {
        if (mWindowManager == null) {
            mWindowManager = (android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window");
        }
        return mWindowManager;
    }

    public void setClipBoard(java.lang.String str) {
        ((android.content.ClipboardManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("clipboard")).setPrimaryClip(android.content.ClipData.newPlainText("Label", str));
    }

    public void showDebugConfigView() {
        this.mDebugConfigView.showDebugConfigView();
    }

    public void showDebugIconView(android.app.Activity activity) {
        mWindowManager = (android.view.WindowManager) activity.getSystemService("window");
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().postDelayOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.debug.DebugViewManager.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.module.debug.DebugViewManager.this.mDebugIconView.showDebugIconView();
            }
        }, 3000);
    }

    public void switchToFormalDomain() {
        com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.put(com.tencent.ysdk.shell.libware.util.AppSharePreferenceKey.KEY_DEBUG_HTTP_DOMAIN, com.tencent.ysdk.shell.framework.constant.Constant.YSDK_FORMAL_HTTP_DOMAIN);
    }

    public void switchToTestDomain() {
        com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.put(com.tencent.ysdk.shell.libware.util.AppSharePreferenceKey.KEY_DEBUG_HTTP_DOMAIN, com.tencent.ysdk.shell.framework.constant.Constant.YSDK_TEST_HTTP_DOMAIN);
    }
}
