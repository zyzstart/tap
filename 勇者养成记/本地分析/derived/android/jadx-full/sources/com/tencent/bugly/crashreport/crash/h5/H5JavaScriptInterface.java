package com.tencent.bugly.crashreport.crash.h5;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class H5JavaScriptInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.HashSet<java.lang.Integer> f317a = new java.util.HashSet<>();
    private java.lang.String b = null;
    private java.lang.Thread c = null;
    private java.lang.String d = null;
    private java.util.Map<java.lang.String, java.lang.String> e = null;

    private H5JavaScriptInterface() {
    }

    private static com.tencent.bugly.crashreport.crash.h5.a a(java.lang.String str) {
        java.lang.String string;
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.tencent.bugly.crashreport.crash.h5.a aVar = new com.tencent.bugly.crashreport.crash.h5.a();
            aVar.f318a = jSONObject.getString("projectRoot");
            if (aVar.f318a == null) {
                return null;
            }
            aVar.b = jSONObject.getString("context");
            if (aVar.b == null) {
                return null;
            }
            aVar.c = jSONObject.getString("url");
            if (aVar.c == null) {
                return null;
            }
            aVar.d = jSONObject.getString("userAgent");
            if (aVar.d == null) {
                return null;
            }
            aVar.e = jSONObject.getString("language");
            if (aVar.e == null) {
                return null;
            }
            aVar.f = jSONObject.getString("name");
            if (aVar.f == null || aVar.f.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                return null;
            }
            int iIndexOf = string.indexOf("\n");
            if (iIndexOf < 0) {
                com.tencent.bugly.proguard.x.d("H5 crash stack's format is wrong!", new java.lang.Object[0]);
                return null;
            }
            aVar.h = string.substring(iIndexOf + 1);
            aVar.g = string.substring(0, iIndexOf);
            int iIndexOf2 = aVar.g.indexOf(":");
            if (iIndexOf2 > 0) {
                aVar.g = aVar.g.substring(iIndexOf2 + 1);
            }
            aVar.i = jSONObject.getString("file");
            if (aVar.f == null) {
                return null;
            }
            aVar.j = jSONObject.getLong("lineNumber");
            if (aVar.j < 0) {
                return null;
            }
            aVar.k = jSONObject.getLong("columnNumber");
            if (aVar.k < 0) {
                return null;
            }
            com.tencent.bugly.proguard.x.a("H5 crash information is following: ", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[projectRoot]: " + aVar.f318a, new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[context]: " + aVar.b, new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[url]: " + aVar.c, new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[userAgent]: " + aVar.d, new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[language]: " + aVar.e, new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[name]: " + aVar.f, new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[message]: " + aVar.g, new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[stacktrace]: \n" + aVar.h, new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[file]: " + aVar.i, new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[lineNumber]: " + aVar.j, new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.a("[columnNumber]: " + aVar.k, new java.lang.Object[0]);
            return aVar;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface getInstance(com.tencent.bugly.crashreport.CrashReport.WebViewInterface webViewInterface) {
        java.lang.String string = null;
        if (webViewInterface == null || f317a.contains(java.lang.Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface h5JavaScriptInterface = new com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface();
        f317a.add(java.lang.Integer.valueOf(webViewInterface.hashCode()));
        h5JavaScriptInterface.c = java.lang.Thread.currentThread();
        java.lang.Thread thread = h5JavaScriptInterface.c;
        if (thread != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("\n");
            for (int i = 2; i < thread.getStackTrace().length; i++) {
                java.lang.StackTraceElement stackTraceElement = thread.getStackTrace()[i];
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
        com.tencent.bugly.proguard.x.d("Log from js: %s", str);
    }

    @android.webkit.JavascriptInterface
    public void reportJSException(java.lang.String str) {
        if (str == null) {
            com.tencent.bugly.proguard.x.d("Payload from JS is null.", new java.lang.Object[0]);
            return;
        }
        java.lang.String strB = com.tencent.bugly.proguard.z.b(str.getBytes());
        java.lang.String str2 = this.b;
        if (str2 != null && str2.equals(strB)) {
            com.tencent.bugly.proguard.x.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new java.lang.Object[0]);
            return;
        }
        this.b = strB;
        com.tencent.bugly.proguard.x.d("Handling JS exception ...", new java.lang.Object[0]);
        com.tencent.bugly.crashreport.crash.h5.a aVarA = a(str);
        if (aVarA == null) {
            com.tencent.bugly.proguard.x.d("Failed to parse payload.", new java.lang.Object[0]);
            return;
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap();
        if (aVarA.f318a != null) {
            linkedHashMap2.put("[JS] projectRoot", aVarA.f318a);
        }
        if (aVarA.b != null) {
            linkedHashMap2.put("[JS] context", aVarA.b);
        }
        if (aVarA.c != null) {
            linkedHashMap2.put("[JS] url", aVarA.c);
        }
        if (aVarA.d != null) {
            linkedHashMap2.put("[JS] userAgent", aVarA.d);
        }
        if (aVarA.i != null) {
            linkedHashMap2.put("[JS] file", aVarA.i);
        }
        if (aVarA.j != 0) {
            linkedHashMap2.put("[JS] lineNumber", java.lang.Long.toString(aVarA.j));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.e);
        linkedHashMap.put("Java Stack", this.d);
        java.lang.Thread thread = this.c;
        if (aVarA != null) {
            com.tencent.bugly.crashreport.inner.InnerApi.postH5CrashAsync(thread, aVarA.f, aVarA.g, aVarA.h, linkedHashMap);
        }
    }
}
