package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.regex.Pattern f118a = java.util.regex.Pattern.compile("^([a-zA-Z][a-zA-Z\\d_]{0,63})$", 2);
    private static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("^ams_reserved_(.*?)", 2);

    public static boolean a(java.lang.String str) {
        java.lang.String str2;
        if (com.qq.gdt.action.h.t.a(str)) {
            str2 = "在logAction方法中，actionType参数不能为空！";
        } else {
            if (f118a.matcher(str).matches()) {
                return true;
            }
            str2 = "在logAction方法中，actionType参数只能包含字母、数字和下划线，且只能以字母开头，长度不能超过64个字符！";
        }
        com.qq.gdt.action.h.l.c(str2);
        return false;
    }

    public static boolean a(org.json.JSONObject jSONObject) {
        java.lang.String strA;
        int i;
        if (jSONObject == null) {
            return true;
        }
        java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            java.lang.String next = itKeys.next();
            if (com.qq.gdt.action.h.t.a(next)) {
                strA = "在logAction方法中，actionParam参数的key不能为空！";
            } else if (f118a.matcher(next).matches()) {
                if (b.matcher(next).matches()) {
                    com.qq.gdt.action.h.l.b("SDK内部预留参数的key均以'ams_reserved_'开头，该参数的值会被SDK内部覆盖，请不要使用！");
                }
                try {
                    java.lang.Object obj = jSONObject.get(next);
                    if (!(obj instanceof java.lang.String) && !(obj instanceof java.lang.Number) && !(obj instanceof java.lang.Boolean) && !(obj instanceof org.json.JSONArray)) {
                        com.qq.gdt.action.h.l.c(com.qq.gdt.action.h.t.a("在logAction方法中，actionParam参数的value必须是String/Number/Boolean/JSONArray中的一种！[key=%s, value=%s]", next, obj.toString()));
                        return false;
                    }
                    if (obj instanceof org.json.JSONArray) {
                        org.json.JSONArray jSONArray = (org.json.JSONArray) obj;
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            java.lang.Object obj2 = jSONArray.get(i2);
                            if (!(obj2 instanceof java.lang.String) && !(obj2 instanceof java.lang.Number) && !(obj2 instanceof java.lang.Boolean)) {
                                com.qq.gdt.action.h.l.c(com.qq.gdt.action.h.t.a("在logAction方法中，如果actionParam参数中的某个元素的value是JSONArray，那么这个JSONArray中的每个元素必须是String/Number/Boolean中的一种！[key=%s, value=%s, %nvalue的第%d个元素为%s]", next, obj.toString(), java.lang.Integer.valueOf(i2), obj2.toString()));
                                return false;
                            }
                        }
                        if (jSONArray.length() >= 2) {
                            java.lang.Object obj3 = jSONArray.get(0);
                            while (i < jSONArray.length()) {
                                java.lang.Object obj4 = jSONArray.get(i);
                                i = (((obj4 instanceof java.lang.String) && (obj3 instanceof java.lang.String)) || ((obj4 instanceof java.lang.Number) && (obj3 instanceof java.lang.Number)) || ((obj4 instanceof java.lang.Boolean) && (obj3 instanceof java.lang.Boolean))) ? i + 1 : 1;
                                com.qq.gdt.action.h.l.c("在logAction方法中，如果actionParam参数中的某个元素的value是JSONArray，那么这个JSONArray中所有元素的类型必须是同一种！");
                                return false;
                            }
                        }
                        continue;
                    }
                } catch (org.json.JSONException unused) {
                    strA = com.qq.gdt.action.h.t.a("Unexpected action param key. [key='%s']", next);
                }
            } else {
                strA = "在logAction方法中，actionParam参数的key只能包含字母、数字和下划线，且不能以数字开头，长度不能超过64个字符！";
            }
            com.qq.gdt.action.h.l.c(strA);
            return false;
        }
        return true;
    }

    public static void b(java.lang.String str) {
        if ("ACTIVATE_APP".equals(str)) {
            com.qq.gdt.action.h.l.b("如果您想统计App的激活行为，只需要在调用logEvent方法时传入START_APP参数，SDK会自动识别本次行为是激活还是启动行为，并进行上报。");
        }
    }

    public static boolean c(java.lang.String str) {
        return com.qq.gdt.action.ActionType.START_APP.equals(str) || "ACTIVATE_APP".equals(str);
    }
}
