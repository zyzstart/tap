package com.tencent.ysdk.shell.libware.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SafeJSONObject extends org.json.JSONObject {
    public SafeJSONObject() {
    }

    public SafeJSONObject(java.lang.String str) throws org.json.JSONException {
        super(str);
    }

    public SafeJSONObject(org.json.JSONObject jSONObject) throws org.json.JSONException {
        super(jSONObject.toString());
    }

    @Override // org.json.JSONObject
    public boolean getBoolean(java.lang.String str) throws org.json.JSONException {
        if (has(str)) {
            return super.getBoolean(str);
        }
        return false;
    }

    public boolean getBoolean(java.lang.String str, boolean z) throws org.json.JSONException {
        return !has(str) ? z : super.getBoolean(str);
    }

    @Override // org.json.JSONObject
    public double getDouble(java.lang.String str) throws org.json.JSONException {
        if (has(str)) {
            return super.getDouble(str);
        }
        return -1.0d;
    }

    public double getDouble(java.lang.String str, double d) throws org.json.JSONException {
        return !has(str) ? d : super.getDouble(str);
    }

    @Override // org.json.JSONObject
    public int getInt(java.lang.String str) throws org.json.JSONException {
        if (has(str)) {
            return super.getInt(str);
        }
        return -1;
    }

    public int getInt(java.lang.String str, int i) throws org.json.JSONException {
        return !has(str) ? i : super.getInt(str);
    }

    @Override // org.json.JSONObject
    public org.json.JSONArray getJSONArray(java.lang.String str) throws org.json.JSONException {
        return !has(str) ? new org.json.JSONArray() : super.getJSONArray(str);
    }

    public org.json.JSONArray getJSONArray(java.lang.String str, org.json.JSONArray jSONArray) throws org.json.JSONException {
        return !has(str) ? jSONArray : super.getJSONArray(str);
    }

    @Override // org.json.JSONObject
    public org.json.JSONObject getJSONObject(java.lang.String str) throws org.json.JSONException {
        return !has(str) ? new com.tencent.ysdk.shell.libware.util.SafeJSONObject() : super.getJSONObject(str);
    }

    public org.json.JSONObject getJSONObject(java.lang.String str, org.json.JSONObject jSONObject) throws org.json.JSONException {
        return !has(str) ? jSONObject : super.getJSONObject(str);
    }

    @Override // org.json.JSONObject
    public long getLong(java.lang.String str) throws org.json.JSONException {
        if (has(str)) {
            return super.getLong(str);
        }
        return -1L;
    }

    public long getLong(java.lang.String str, java.lang.Long l) throws org.json.JSONException {
        return !has(str) ? l.longValue() : super.getLong(str);
    }

    @Override // org.json.JSONObject
    public java.lang.String getString(java.lang.String str) throws org.json.JSONException {
        return !has(str) ? "" : super.getString(str);
    }

    public java.lang.String getString(java.lang.String str, java.lang.String str2) throws org.json.JSONException {
        return !has(str) ? str2 : super.getString(str);
    }
}
