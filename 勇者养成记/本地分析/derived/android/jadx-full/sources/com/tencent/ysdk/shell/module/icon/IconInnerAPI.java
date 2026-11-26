package com.tencent.ysdk.shell.module.icon;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconInnerAPI {
    public static void notifyStateChange(java.lang.String str, boolean z) {
        com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance().iconInterface.notifyStateChange(str, z);
    }
}
