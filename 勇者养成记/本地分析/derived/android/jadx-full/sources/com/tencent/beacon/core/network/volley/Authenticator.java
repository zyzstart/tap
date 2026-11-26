package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface Authenticator {
    java.lang.String getAuthToken();

    void invalidateAuthToken(java.lang.String str);
}
