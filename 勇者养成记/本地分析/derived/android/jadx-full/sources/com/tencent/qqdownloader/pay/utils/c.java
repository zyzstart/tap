package com.tencent.qqdownloader.pay.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    public static java.lang.Integer a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.Integer num) {
        try {
            return java.lang.Integer.valueOf(jSONObject.getInt(str));
        } catch (org.json.JSONException unused) {
            return num;
        }
    }

    public static java.lang.String a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String string = jSONObject.getString(str);
            if (string == null) {
                return str2;
            }
            return (string == null || !string.equals("null")) ? string : str2;
        } catch (org.json.JSONException unused) {
            return str2;
        }
    }
}
