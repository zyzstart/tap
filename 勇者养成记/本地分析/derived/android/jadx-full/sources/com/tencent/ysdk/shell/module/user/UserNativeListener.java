package com.tencent.ysdk.shell.module.user;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserNativeListener {
    public static native void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet);

    public static native void OnRelationNotify(com.tencent.ysdk.module.user.UserRelationRet userRelationRet);

    public static native void OnWakeupNotify(com.tencent.ysdk.module.user.WakeupRet wakeupRet);
}
