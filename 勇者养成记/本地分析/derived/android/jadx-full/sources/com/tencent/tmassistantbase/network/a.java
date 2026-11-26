package com.tencent.tmassistantbase.network;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.net.HttpURLConnection f1044a = null;
    protected java.io.InputStream b = null;

    protected abstract void a(org.json.JSONObject jSONObject, int i);

    protected synchronized boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f1044a != null) {
            return false;
        }
        new java.lang.Thread(new com.tencent.tmassistantbase.network.b(this, str)).start();
        return false;
    }
}
