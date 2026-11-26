package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1501a = "partial";
    public static final java.lang.String b = "full";
    public static final java.lang.String c = "change";
    private static final java.lang.String d = "asr_recongize";
    private static final java.lang.String e = "retTag";
    private static final java.lang.String f = "nlu";
    private static java.util.ArrayList<java.lang.String> g = new java.util.ArrayList<>();

    public static com.unisound.sdk.co a(java.lang.String str, boolean z, com.unisound.sdk.w wVar) {
        try {
            if (str.contains(d)) {
                if (str.contains("-changeable-")) {
                    str = str.replace("-changeable-", "");
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (jSONObject.has(e)) {
                    if (jSONObject.getString(e).equals(f)) {
                        jSONObject.remove(e);
                        if (jSONObject.has(d)) {
                            jSONObject.remove(d);
                            wVar.y(jSONObject.has("nluProcessTime") ? jSONObject.getString("nluProcessTime") : "0");
                            return new com.unisound.sdk.co(jSONObject.toString().replace("\\/", "/"));
                        }
                    }
                } else if (!z && jSONObject.has(d)) {
                    jSONObject.remove(d);
                    wVar.y(jSONObject.has("nluProcessTime") ? jSONObject.getString("nluProcessTime") : "0");
                    return new com.unisound.sdk.co(jSONObject.toString().replace("\\/", "/"));
                }
            }
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return new com.unisound.sdk.co(null);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002e A[Catch: JSONException -> 0x0012, TryCatch #0 {JSONException -> 0x0012, blocks: (B:6:0x000e, B:18:0x002e, B:20:0x0035, B:22:0x003c, B:24:0x0043, B:26:0x004a, B:28:0x0051, B:30:0x0058, B:32:0x005f, B:34:0x0066, B:36:0x006d), top: B:43:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0035 A[Catch: JSONException -> 0x0012, TryCatch #0 {JSONException -> 0x0012, blocks: (B:6:0x000e, B:18:0x002e, B:20:0x0035, B:22:0x003c, B:24:0x0043, B:26:0x004a, B:28:0x0051, B:30:0x0058, B:32:0x005f, B:34:0x0066, B:36:0x006d), top: B:43:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:22:0x003c A[Catch: JSONException -> 0x0012, TryCatch #0 {JSONException -> 0x0012, blocks: (B:6:0x000e, B:18:0x002e, B:20:0x0035, B:22:0x003c, B:24:0x0043, B:26:0x004a, B:28:0x0051, B:30:0x0058, B:32:0x005f, B:34:0x0066, B:36:0x006d), top: B:43:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0043 A[Catch: JSONException -> 0x0012, TryCatch #0 {JSONException -> 0x0012, blocks: (B:6:0x000e, B:18:0x002e, B:20:0x0035, B:22:0x003c, B:24:0x0043, B:26:0x004a, B:28:0x0051, B:30:0x0058, B:32:0x005f, B:34:0x0066, B:36:0x006d), top: B:43:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:26:0x004a A[Catch: JSONException -> 0x0012, TryCatch #0 {JSONException -> 0x0012, blocks: (B:6:0x000e, B:18:0x002e, B:20:0x0035, B:22:0x003c, B:24:0x0043, B:26:0x004a, B:28:0x0051, B:30:0x0058, B:32:0x005f, B:34:0x0066, B:36:0x006d), top: B:43:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0051 A[Catch: JSONException -> 0x0012, TryCatch #0 {JSONException -> 0x0012, blocks: (B:6:0x000e, B:18:0x002e, B:20:0x0035, B:22:0x003c, B:24:0x0043, B:26:0x004a, B:28:0x0051, B:30:0x0058, B:32:0x005f, B:34:0x0066, B:36:0x006d), top: B:43:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0058 A[Catch: JSONException -> 0x0012, TryCatch #0 {JSONException -> 0x0012, blocks: (B:6:0x000e, B:18:0x002e, B:20:0x0035, B:22:0x003c, B:24:0x0043, B:26:0x004a, B:28:0x0051, B:30:0x0058, B:32:0x005f, B:34:0x0066, B:36:0x006d), top: B:43:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:32:0x005f A[Catch: JSONException -> 0x0012, TryCatch #0 {JSONException -> 0x0012, blocks: (B:6:0x000e, B:18:0x002e, B:20:0x0035, B:22:0x003c, B:24:0x0043, B:26:0x004a, B:28:0x0051, B:30:0x0058, B:32:0x005f, B:34:0x0066, B:36:0x006d), top: B:43:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0066 A[Catch: JSONException -> 0x0012, TryCatch #0 {JSONException -> 0x0012, blocks: (B:6:0x000e, B:18:0x002e, B:20:0x0035, B:22:0x003c, B:24:0x0043, B:26:0x004a, B:28:0x0051, B:30:0x0058, B:32:0x005f, B:34:0x0066, B:36:0x006d), top: B:43:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:36:0x006d A[Catch: JSONException -> 0x0012, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0012, blocks: (B:6:0x000e, B:18:0x002e, B:20:0x0035, B:22:0x003c, B:24:0x0043, B:26:0x004a, B:28:0x0051, B:30:0x0058, B:32:0x005f, B:34:0x0066, B:36:0x006d), top: B:43:0x000e }] */
    public static java.lang.String a(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7) {
        java.lang.String str4;
        java.lang.String str5;
        if (str2 == null) {
            return "";
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (i == 1) {
                str4 = "engine_mode";
                str5 = "net";
            } else if (i == 0) {
                str4 = "engine_mode";
                str5 = "mix";
            } else {
                if (i != 2) {
                    if (i == 1000) {
                        str4 = "engine_mode";
                        str5 = com.unisound.sdk.cx.f1560a;
                    } else {
                        if (str != null) {
                            jSONObject.put("result_type", str);
                        }
                        if (obj != null) {
                            jSONObject.put("last_result", obj);
                        }
                        if (str2 != null) {
                            jSONObject.put("recognition_result", str2);
                        }
                        if (str3 != null) {
                            jSONObject.put(com.unisound.common.x.c, str3);
                        }
                        if (obj2 != null) {
                            jSONObject.put("score", obj2);
                        }
                        if (obj3 != null) {
                            jSONObject.put("utteranceTime", obj3);
                        }
                        if (obj4 != null) {
                            jSONObject.put("outRecordingTime", obj4);
                        }
                        if (obj5 != null) {
                            jSONObject.put("delayTime", obj5);
                        }
                        if (obj6 != null) {
                            jSONObject.put("utteranceStartTime", obj6);
                        }
                        if (obj7 != null) {
                            jSONObject.put("utteranceEndTime", obj7);
                        }
                    }
                    return jSONObject.toString().replace("\\/", "/");
                }
                str4 = "engine_mode";
                str5 = "local";
            }
            jSONObject.put(str4, str5);
            if (str != null) {
                jSONObject.put("result_type", str);
            }
            if (obj != null) {
                jSONObject.put("last_result", obj);
            }
            if (str2 != null) {
                jSONObject.put("recognition_result", str2);
            }
            if (str3 != null) {
                jSONObject.put(com.unisound.common.x.c, str3);
            }
            if (obj2 != null) {
                jSONObject.put("score", obj2);
            }
            if (obj3 != null) {
                jSONObject.put("utteranceTime", obj3);
            }
            if (obj4 != null) {
                jSONObject.put("outRecordingTime", obj4);
            }
            if (obj5 != null) {
                jSONObject.put("delayTime", obj5);
            }
            if (obj6 != null) {
                jSONObject.put("utteranceStartTime", obj6);
            }
            if (obj7 != null) {
                jSONObject.put("utteranceEndTime", obj7);
            }
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString().replace("\\/", "/");
    }

    public static java.lang.String a(com.unisound.sdk.b bVar) {
        com.unisound.sdk.am amVarE = bVar.a().e();
        if (amVarE == com.unisound.sdk.am.LOCAL) {
            return b(bVar);
        }
        return amVarE == com.unisound.sdk.am.NET ? c(bVar) : "";
    }

    private java.lang.String a(java.lang.String str) {
        try {
            if (!str.contains(d) || !str.contains(e)) {
                return "";
            }
            if (str.contains("-changeable-")) {
                str = str.replace("-changeable-", "");
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            return (jSONObject.has(e) && jSONObject.getString(e).equals(f) && jSONObject.has(d)) ? jSONObject.getString(d) : "";
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            if (str.contains(str2)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                str = jSONObject.has(str2) ? jSONObject.getString(str2) : "";
            }
            return str;
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static java.lang.String a(java.util.ArrayList<java.lang.String> arrayList, java.util.ArrayList<java.lang.String> arrayList2, java.util.ArrayList<java.lang.String> arrayList3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (arrayList != null) {
            new org.json.JSONObject();
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                try {
                    jSONArray.put(new org.json.JSONObject(arrayList.get(i)));
                } catch (org.json.JSONException e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("local_asr", jSONArray);
        }
        if (arrayList2 != null) {
            new org.json.JSONObject();
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                try {
                    jSONArray2.put(new org.json.JSONObject(arrayList2.get(i2)));
                } catch (org.json.JSONException e3) {
                    e3.printStackTrace();
                }
            }
            jSONObject.put("net_asr", jSONArray2);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            new org.json.JSONObject();
            org.json.JSONArray jSONArray3 = new org.json.JSONArray();
            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                try {
                    if (arrayList3.get(i3) != null) {
                        jSONArray3.put(new org.json.JSONObject(arrayList3.get(i3)));
                    }
                } catch (org.json.JSONException e4) {
                    e4.printStackTrace();
                }
            }
            jSONObject.put("net_nlu", jSONArray3);
        }
        return jSONObject.toString().replace("\\/", "/");
    }

    public static java.util.Map<java.lang.Integer, java.lang.Object> a(java.lang.String str, java.util.Map<java.lang.String, java.lang.Integer> map) {
        java.util.HashMap map2 = new java.util.HashMap();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            for (java.lang.String str2 : map.keySet()) {
                map2.put(map.get(str2), jSONObject.opt(str2));
            }
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return map2;
    }

    public static void a() {
        com.unisound.common.y.c("clearTotalASRResult");
        java.util.ArrayList<java.lang.String> arrayList = g;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public static java.lang.String b() {
        if (g == null) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < g.size(); i++) {
            stringBuffer.append(g.get(i));
        }
        return new java.lang.String(stringBuffer);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0058  */
    /* JADX WARN: Code duplicated, block: B:19:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0062  */
    /* JADX WARN: Code duplicated, block: B:21:0x0067  */
    private static java.lang.String b(com.unisound.sdk.b bVar) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        com.unisound.sdk.al alVarA = bVar.a();
        int iB = bVar.b();
        boolean zC = bVar.c();
        java.lang.String strA = alVarA.a();
        boolean zD = alVarA.d();
        float fH = alVarA.h();
        int i = alVarA.i();
        int iF = alVarA.f();
        int iG = alVarA.g();
        long jK = alVarA.k();
        long j = alVarA.j();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (iB == 1) {
                str = "engine_mode";
                str2 = "net";
            } else if (iB == 0) {
                str = "engine_mode";
                str2 = "mix";
            } else {
                if (iB != 2) {
                    if (iB != 1000) {
                        if (zC) {
                            str3 = "result_type";
                            str4 = b;
                        } else if (zD) {
                            str3 = "result_type";
                            str4 = c;
                        } else {
                            str3 = "result_type";
                            str4 = "partial";
                        }
                        jSONObject.put(str3, str4);
                        jSONObject.put("recognition_result", strA);
                        jSONObject.put("score", fH);
                        jSONObject.put("utteranceTime", i);
                        jSONObject.put("outRecordingTime", j);
                        jSONObject.put("delayTime", jK);
                        jSONObject.put("utteranceStartTime", iF);
                        jSONObject.put("utteranceEndTime", iG);
                        return jSONObject.toString().replace("\\/", "/");
                    }
                    str = "engine_mode";
                    str2 = com.unisound.sdk.cx.f1560a;
                    e.printStackTrace();
                    return jSONObject.toString().replace("\\/", "/");
                }
                str = "engine_mode";
                str2 = "local";
            }
            jSONObject.put(str, str2);
            if (zC) {
                str3 = "result_type";
                str4 = b;
            } else if (zD) {
                str3 = "result_type";
                str4 = c;
            } else {
                str3 = "result_type";
                str4 = "partial";
            }
            jSONObject.put(str3, str4);
            jSONObject.put("recognition_result", strA);
            jSONObject.put("score", fH);
            jSONObject.put("utteranceTime", i);
            jSONObject.put("outRecordingTime", j);
            jSONObject.put("delayTime", jK);
            jSONObject.put("utteranceStartTime", iF);
            jSONObject.put("utteranceEndTime", iG);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString().replace("\\/", "/");
    }

    private static void b(java.lang.String str) {
        com.unisound.common.y.c("addToTotalASRResult=" + str);
        java.util.ArrayList<java.lang.String> arrayList = g;
        if (arrayList != null) {
            arrayList.add(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0073  */
    /* JADX WARN: Code duplicated, block: B:26:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0082  */
    private static java.lang.String c(com.unisound.sdk.b bVar) {
        java.lang.Object[] objArr;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        com.unisound.sdk.al alVarA = bVar.a();
        int iB = bVar.b();
        boolean zC = bVar.c();
        boolean zD = bVar.d();
        java.lang.String strB = alVarA.b();
        java.lang.String strA = alVarA.a();
        if (zD) {
            objArr = new java.lang.Object[]{"originFormat onResult -> result = ", strA};
        } else {
            strA = a(strA, d);
            if (!alVarA.d()) {
                b(strA);
            }
            objArr = new java.lang.Object[]{"format onResult -> result = ", strA};
        }
        com.unisound.common.y.b(objArr);
        boolean zD2 = alVarA.d();
        boolean zC2 = alVarA.c();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (iB == 1) {
                str = "engine_mode";
                str2 = "net";
            } else if (iB == 0) {
                str = "engine_mode";
                str2 = "mix";
            } else {
                if (iB != 2) {
                    if (iB != 1000) {
                        if (zC) {
                            str3 = "result_type";
                            str4 = b;
                        } else if (zD2) {
                            str3 = "result_type";
                            str4 = c;
                        } else {
                            str3 = "result_type";
                            str4 = "partial";
                        }
                        jSONObject.put(str3, str4);
                        jSONObject.put("last_result", zC2);
                        jSONObject.put("recognition_result", strA);
                        jSONObject.put(com.unisound.common.x.c, strB);
                        return jSONObject.toString().replace("\\/", "/");
                    }
                    str = "engine_mode";
                    str2 = com.unisound.sdk.cx.f1560a;
                    e.printStackTrace();
                    return jSONObject.toString().replace("\\/", "/");
                }
                str = "engine_mode";
                str2 = "local";
            }
            jSONObject.put(str, str2);
            if (zC) {
                str3 = "result_type";
                str4 = b;
            } else if (zD2) {
                str3 = "result_type";
                str4 = c;
            } else {
                str3 = "result_type";
                str4 = "partial";
            }
            jSONObject.put(str3, str4);
            jSONObject.put("last_result", zC2);
            jSONObject.put("recognition_result", strA);
            jSONObject.put(com.unisound.common.x.c, strB);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString().replace("\\/", "/");
    }
}
