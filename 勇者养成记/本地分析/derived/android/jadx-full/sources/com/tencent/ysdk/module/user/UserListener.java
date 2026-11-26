package com.tencent.ysdk.module.user;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface UserListener {
    void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet);

    void OnRelationNotify(com.tencent.ysdk.module.user.UserRelationRet userRelationRet);

    void OnWakeupNotify(com.tencent.ysdk.module.user.WakeupRet wakeupRet);
}
