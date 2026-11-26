package com.tencent.ysdk.shell.module.immersiveicon;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ImmersiveIconInterface {
    java.lang.String getImmersiveIconVersion();

    void notifyStateChange(java.lang.String str, boolean z);

    void performImmersiveIconAction(java.lang.String str);

    void performImmersiveIconAction(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map);

    void regOnStateChangeListener(com.tencent.ysdk.module.immersiveicon.OnStateChangeListener onStateChangeListener);
}
