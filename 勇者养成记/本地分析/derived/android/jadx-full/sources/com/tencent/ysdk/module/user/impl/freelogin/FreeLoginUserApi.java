package com.tencent.ysdk.module.user.impl.freelogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class FreeLoginUserApi {
    FreeLoginUserApi() {
    }

    public static com.tencent.ysdk.module.user.impl.freelogin.IFreeLoginUserApi getInstance() {
        return (com.tencent.ysdk.module.user.impl.freelogin.IFreeLoginUserApi) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getFreeLoginUserApiInstance", new java.lang.Object[0]);
    }
}
