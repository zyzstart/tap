package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JsonArrayRequest extends com.tencent.beacon.core.network.volley.JsonRequest {
    public JsonArrayRequest(int i, java.lang.String str, org.json.JSONArray jSONArray, com.tencent.beacon.core.network.volley.Response.Listener listener, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener) {
        super(i, str, jSONArray == null ? null : jSONArray.toString(), listener, errorListener);
    }

    public JsonArrayRequest(java.lang.String str, com.tencent.beacon.core.network.volley.Response.Listener listener, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener) {
        super(0, str, null, listener, errorListener);
    }

    @Override // com.tencent.beacon.core.network.volley.JsonRequest, com.tencent.beacon.core.network.volley.Request
    protected com.tencent.beacon.core.network.volley.Response parseNetworkResponse(com.tencent.beacon.core.network.volley.NetworkResponse networkResponse) {
        com.tencent.beacon.core.network.volley.ParseError parseError;
        try {
            return com.tencent.beacon.core.network.volley.Response.success(new org.json.JSONArray(new java.lang.String(networkResponse.data, com.tencent.beacon.core.network.volley.HttpHeaderParser.parseCharset(networkResponse.headers, com.unisound.b.f.b))), com.tencent.beacon.core.network.volley.HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (java.io.UnsupportedEncodingException e) {
            parseError = new com.tencent.beacon.core.network.volley.ParseError(e);
            return com.tencent.beacon.core.network.volley.Response.error(parseError);
        } catch (org.json.JSONException e2) {
            parseError = new com.tencent.beacon.core.network.volley.ParseError(e2);
            return com.tencent.beacon.core.network.volley.Response.error(parseError);
        }
    }
}
