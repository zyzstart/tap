package com.unisound.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h {
    public static double a(org.json.JSONObject jSONObject, java.lang.String str, double d) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getDouble(str);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return d;
    }

    public static int a(org.json.JSONObject jSONObject, java.lang.String str, int i) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getInt(str);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public static <T> java.lang.Object a(java.lang.String str, java.lang.Class<T> cls) {
        return null;
    }

    public static java.lang.Object a(java.lang.String str, java.lang.reflect.Type type) {
        return null;
    }

    public static java.lang.String a(java.lang.Object obj) {
        return null;
    }

    public static java.lang.String a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                java.lang.String string = jSONObject.getString(str);
                return (string == null || string.equals("") || string.equals("null")) ? str2 : string;
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    public static org.json.JSONObject a(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.Object objNextValue = new org.json.JSONTokener(str).nextValue();
            return (objNextValue == null || !(objNextValue instanceof org.json.JSONObject)) ? jSONObject : (org.json.JSONObject) objNextValue;
        } catch (java.lang.Exception unused) {
            return jSONObject;
        }
    }

    public static org.json.JSONObject a(org.json.JSONArray jSONArray, int i) {
        if (jSONArray != null) {
            try {
                if (i < jSONArray.length()) {
                    return jSONArray.getJSONObject(i);
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static org.json.JSONObject a(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getJSONObject(str);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.Object obj) {
        if (obj != null) {
            try {
                if ("".equals(obj)) {
                    return;
                }
                jSONObject.put(str, obj);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(org.json.JSONObject jSONObject, java.lang.String str, boolean z) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getBoolean(str);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    public static java.lang.String b(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static org.json.JSONArray b(java.lang.String str) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (str != null && !"".equals(str)) {
            try {
                java.lang.Object objNextValue = new org.json.JSONTokener(str).nextValue();
                if (objNextValue != null) {
                    if (objNextValue instanceof org.json.JSONObject) {
                        jSONArray.put((org.json.JSONObject) objNextValue);
                    } else if (objNextValue instanceof org.json.JSONArray) {
                        jSONArray = (org.json.JSONArray) objNextValue;
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return jSONArray;
    }

    public static void b(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2) {
        if (str2 != null) {
            try {
                if ("".equals(str2)) {
                    return;
                }
                jSONObject.put(str, str2);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static org.json.JSONArray c(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
