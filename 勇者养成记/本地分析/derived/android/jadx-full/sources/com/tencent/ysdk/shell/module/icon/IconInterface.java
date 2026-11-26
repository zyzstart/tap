package com.tencent.ysdk.shell.module.icon;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IconInterface {
    void createGameAssistant();

    java.lang.String getIconVersion();

    void notifyStateChange(java.lang.String str, boolean z);

    void onDestroy();

    void onPause();

    void onResume();

    void removeGameAssistant();

    void showForcePopWindow(int i);

    void showIconBubble(com.tencent.ysdk.module.msgbox.MsgItem msgItem);
}
