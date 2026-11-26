package com.tencent.bugly.opengame.crashreport.crash.h5;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class H5JavaScriptInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.HashSet f367a = new java.util.HashSet();
    private java.lang.String b = null;
    private java.lang.Thread c = null;
    private java.lang.String d = null;
    private java.util.Map e = null;

    private H5JavaScriptInterface() {
    }

    private static com.tencent.bugly.opengame.crashreport.crash.h5.a a(java.lang.String str) {
        java.lang.String string;
        if (str != null && str.length() > 0) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                com.tencent.bugly.opengame.crashreport.crash.h5.a aVar = new com.tencent.bugly.opengame.crashreport.crash.h5.a();
                java.lang.String string2 = jSONObject.getString("projectRoot");
                aVar.f368a = string2;
                if (string2 == null) {
                    return null;
                }
                java.lang.String string3 = jSONObject.getString("context");
                aVar.b = string3;
                if (string3 == null) {
                    return null;
                }
                java.lang.String string4 = jSONObject.getString("url");
                aVar.c = string4;
                if (string4 == null) {
                    return null;
                }
                java.lang.String string5 = jSONObject.getString("userAgent");
                aVar.d = string5;
                if (string5 == null) {
                    return null;
                }
                java.lang.String string6 = jSONObject.getString("language");
                aVar.e = string6;
                if (string6 == null) {
                    return null;
                }
                java.lang.String string7 = jSONObject.getString("name");
                aVar.f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int iIndexOf = string.indexOf("\n");
                if (iIndexOf < 0) {
                    com.tencent.bugly.opengame.proguard.x.d("H5 crash stack's format is wrong!", new java.lang.Object[0]);
                    return null;
                }
                aVar.h = string.substring(iIndexOf + 1);
                java.lang.String strSubstring = string.substring(0, iIndexOf);
                aVar.g = strSubstring;
                int iIndexOf2 = strSubstring.indexOf(":");
                if (iIndexOf2 > 0) {
                    aVar.g = aVar.g.substring(iIndexOf2 + 1);
                }
                aVar.i = jSONObject.getString("file");
                if (aVar.f == null) {
                    return null;
                }
                long j = jSONObject.getLong("lineNumber");
                aVar.j = j;
                if (j < 0) {
                    return null;
                }
                long j2 = jSONObject.getLong("columnNumber");
                aVar.k = j2;
                if (j2 < 0) {
                    return null;
                }
                com.tencent.bugly.opengame.proguard.x.a("H5 crash information is following: ", new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[projectRoot]: " + aVar.f368a, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[context]: " + aVar.b, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[url]: " + aVar.c, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[userAgent]: " + aVar.d, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[language]: " + aVar.e, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[name]: " + aVar.f, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[message]: " + aVar.g, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[stacktrace]: \n" + aVar.h, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[file]: " + aVar.i, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[lineNumber]: " + aVar.j, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("[columnNumber]: " + aVar.k, new java.lang.Object[0]);
                return aVar;
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static com.tencent.bugly.opengame.crashreport.crash.h5.H5JavaScriptInterface getInstance(com.tencent.bugly.opengame.crashreport.CrashReport.WebViewInterface webViewInterface) {
        java.lang.String string = null;
        if (webViewInterface == null || f367a.contains(java.lang.Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        com.tencent.bugly.opengame.crashreport.crash.h5.H5JavaScriptInterface h5JavaScriptInterface = new com.tencent.bugly.opengame.crashreport.crash.h5.H5JavaScriptInterface();
        f367a.add(java.lang.Integer.valueOf(webViewInterface.hashCode()));
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        h5JavaScriptInterface.c = threadCurrentThread;
        if (threadCurrentThread != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("\n");
            for (int i = 2; i < threadCurrentThread.getStackTrace().length; i++) {
                java.lang.StackTraceElement stackTraceElement = threadCurrentThread.getStackTrace()[i];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
            string = sb.toString();
        }
        h5JavaScriptInterface.d = string;
        java.util.HashMap map = new java.util.HashMap();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append((java.lang.Object) webViewInterface.getContentDescription());
        map.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.e = map;
        return h5JavaScriptInterface;
    }

    @android.webkit.JavascriptInterface
    public void printLog(java.lang.String str) {
        com.tencent.bugly.opengame.proguard.x.d("Log from js: %s", str);
    }

    @android.webkit.JavascriptInterface
    public void reportJSException(java.lang.String str) {
        java.lang.Object[] objArr;
        java.lang.String str2;
        if (str == null) {
            objArr = new java.lang.Object[0];
            str2 = "Payload from JS is null.";
        } else {
            java.lang.String strB = com.tencent.bugly.opengame.proguard.z.b(str.getBytes());
            java.lang.String str3 = this.b;
            if (str3 == null || !str3.equals(strB)) {
                this.b = strB;
                com.tencent.bugly.opengame.proguard.x.d("Handling JS exception ...", new java.lang.Object[0]);
                com.tencent.bugly.opengame.crashreport.crash.h5.a aVarA = a(str);
                if (aVarA != null) {
                    java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
                    java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap();
                    java.lang.String str4 = aVarA.f368a;
                    if (str4 != null) {
                        linkedHashMap2.put("[JS] projectRoot", str4);
                    }
                    java.lang.String str5 = aVarA.b;
                    if (str5 != null) {
                        linkedHashMap2.put("[JS] context", str5);
                    }
                    java.lang.String str6 = aVarA.c;
                    if (str6 != null) {
                        linkedHashMap2.put("[JS] url", str6);
                    }
                    java.lang.String str7 = aVarA.d;
                    if (str7 != null) {
                        linkedHashMap2.put("[JS] userAgent", str7);
                    }
                    java.lang.String str8 = aVarA.i;
                    if (str8 != null) {
                        linkedHashMap2.put("[JS] file", str8);
                    }
                    long j = aVarA.j;
                    if (j != 0) {
                        linkedHashMap2.put("[JS] lineNumber", java.lang.Long.toString(j));
                    }
                    linkedHashMap.putAll(linkedHashMap2);
                    linkedHashMap.putAll(this.e);
                    linkedHashMap.put("Java Stack", this.d);
                    java.lang.Thread thread = this.c;
                    if (aVarA != null) {
                        com.tencent.bugly.opengame.crashreport.inner.InnerApi.postH5CrashAsync(thread, aVarA.f, aVarA.g, aVarA.h, linkedHashMap);
                        return;
                    }
                    return;
                }
                objArr = new java.lang.Object[0];
                str2 = "Failed to parse payload.";
            } else {
                objArr = new java.lang.Object[0];
                str2 = "Same payload from js. Please check whether you've injected bugly.js more than one times.";
            }
        }
        com.tencent.bugly.opengame.proguard.x.d(str2, objArr);
    }
}
