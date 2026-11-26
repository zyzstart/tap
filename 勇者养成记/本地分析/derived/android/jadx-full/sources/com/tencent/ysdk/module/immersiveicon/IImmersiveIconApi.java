package com.tencent.ysdk.module.immersiveicon;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IImmersiveIconApi {
    java.lang.String getIconVersion();

    void performFeature(java.lang.String str);

    void performFeature(java.lang.String str, java.util.HashMap map);

    void regOnStateChangeListener(com.tencent.ysdk.module.immersiveicon.OnStateChangeListener onStateChangeListener);
}
