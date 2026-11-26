package com.tencent.ydkqmsp.sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    public static org.json.JSONObject a(int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(0), i);
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(1), com.tencent.ydkqmsp.sdk.app.a.getAppID());
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(2), com.tencent.ydkqmsp.sdk.app.a.getDevId());
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(3), com.tencent.ydkqmsp.sdk.app.a.getUid());
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(4), com.tencent.ydkqmsp.sdk.app.a.getQImeiVer());
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(5), android.os.Build.VERSION.SDK_INT);
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(6), com.tencent.ydkqmsp.sdk.a.c.c());
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(7), com.tencent.ydkqmsp.sdk.a.c.d());
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(8), java.lang.System.currentTimeMillis());
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(9), 1);
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(10), com.tencent.ydkqmsp.sdk.a.c.g() ? "1" : "0");
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(11), "");
            return jSONObject;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
