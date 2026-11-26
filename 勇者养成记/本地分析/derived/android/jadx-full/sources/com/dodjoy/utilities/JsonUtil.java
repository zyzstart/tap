package com.dodjoy.utilities;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JsonUtil {
    public static org.json.JSONArray GetArray(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static long GetLong(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            return jSONObject.getLong(str);
        } catch (java.lang.Exception unused) {
            return 0L;
        }
    }

    public static java.lang.String GetString(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            return jSONObject.getString(str);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
