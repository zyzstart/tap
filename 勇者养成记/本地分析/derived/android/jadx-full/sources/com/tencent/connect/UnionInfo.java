package com.tencent.connect;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UnionInfo extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String URL_GET_UNION_ID = "https://openmobile.qq.com/oauth2.0/me";

    public UnionInfo(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    public void getUnionId(com.tencent.tauth.IUiListener iUiListener) {
        android.os.Bundle bundleA = a();
        bundleA.putString(com.tencent.open.SocialOperation.GAME_UNION_ID, "1");
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), URL_GET_UNION_ID, bundleA, com.tencent.connect.common.Constants.HTTP_GET, new com.tencent.connect.common.BaseApi.TempRequestListener(iUiListener));
    }
}
