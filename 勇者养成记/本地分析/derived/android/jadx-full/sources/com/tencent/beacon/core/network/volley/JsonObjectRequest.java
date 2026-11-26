package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JsonObjectRequest extends com.tencent.beacon.core.network.volley.JsonRequest {
    public JsonObjectRequest(int i, java.lang.String str, org.json.JSONObject jSONObject, com.tencent.beacon.core.network.volley.Response.Listener listener, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), listener, errorListener);
    }

    public JsonObjectRequest(java.lang.String str, org.json.JSONObject jSONObject, com.tencent.beacon.core.network.volley.Response.Listener listener, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, listener, errorListener);
    }

    @Override // com.tencent.beacon.core.network.volley.JsonRequest, com.tencent.beacon.core.network.volley.Request
    protected com.tencent.beacon.core.network.volley.Response parseNetworkResponse(com.tencent.beacon.core.network.volley.NetworkResponse networkResponse) {
        com.tencent.beacon.core.network.volley.ParseError parseError;
        try {
            return com.tencent.beacon.core.network.volley.Response.success(new org.json.JSONObject(new java.lang.String(networkResponse.data, com.tencent.beacon.core.network.volley.HttpHeaderParser.parseCharset(networkResponse.headers, com.unisound.b.f.b))), com.tencent.beacon.core.network.volley.HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (java.io.UnsupportedEncodingException e) {
            parseError = new com.tencent.beacon.core.network.volley.ParseError(e);
            return com.tencent.beacon.core.network.volley.Response.error(parseError);
        } catch (org.json.JSONException e2) {
            parseError = new com.tencent.beacon.core.network.volley.ParseError(e2);
            return com.tencent.beacon.core.network.volley.Response.error(parseError);
        }
    }
}
