package com.tencent.tauth;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IRequestListener {
    void onComplete(org.json.JSONObject jSONObject);

    void onConnectTimeoutException(org.apache.http.conn.ConnectTimeoutException connectTimeoutException);

    void onHttpStatusException(com.tencent.open.utils.HttpUtils.HttpStatusException httpStatusException);

    void onIOException(java.io.IOException iOException);

    void onJSONException(org.json.JSONException jSONException);

    void onMalformedURLException(java.net.MalformedURLException malformedURLException);

    void onNetworkUnavailableException(com.tencent.open.utils.HttpUtils.NetworkUnavailableException networkUnavailableException);

    void onSocketTimeoutException(java.net.SocketTimeoutException socketTimeoutException);

    void onUnknowException(java.lang.Exception exc);
}
