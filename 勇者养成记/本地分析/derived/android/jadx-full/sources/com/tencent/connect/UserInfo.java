package com.tencent.connect;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserInfo extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String GRAPH_OPEN_ID = "oauth2.0/m_me";

    public UserInfo(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    public UserInfo(android.content.Context context, com.tencent.connect.auth.c cVar, com.tencent.connect.auth.QQToken qQToken) {
        super(cVar, qQToken);
    }

    public void getOpenId(com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), GRAPH_OPEN_ID, a(), com.tencent.connect.common.Constants.HTTP_GET, new com.tencent.connect.common.BaseApi.TempRequestListener(iUiListener));
    }

    public void getUserInfo(com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), "user/get_simple_userinfo", a(), com.tencent.connect.common.Constants.HTTP_GET, new com.tencent.connect.common.BaseApi.TempRequestListener(iUiListener));
    }
}
