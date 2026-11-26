package com.tencent.open.web.security;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends com.tencent.open.a {
    @Override // com.tencent.open.a
    public void a(java.lang.String str, java.lang.String str2, java.util.List list, com.tencent.open.a.C0028a c0028a) {
        com.tencent.open.log.SLog.v("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, java.net.URLDecoder.decode((java.lang.String) list.get(i), "UTF-8"));
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        com.tencent.open.a.b bVar = (com.tencent.open.a.b) this.f684a.get(str);
        if (bVar != null) {
            com.tencent.open.log.SLog.d("openSDK_LOG.SecureJsBridge", "-->handler != null");
            bVar.call(str2, list, c0028a);
            return;
        }
        com.tencent.open.log.SLog.e("openSDK_LOG.SecureJsBridge", "-->handler == null objName: " + str);
        if (c0028a != null) {
            c0028a.a();
        }
    }

    @Override // com.tencent.open.a
    public boolean a(android.webkit.WebView webView, java.lang.String str) {
        com.tencent.open.log.SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !android.net.Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 7) {
            return false;
        }
        java.lang.String str2 = (java.lang.String) arrayList.get(2);
        java.lang.String str3 = (java.lang.String) arrayList.get(3);
        java.lang.String str4 = (java.lang.String) arrayList.get(4);
        java.lang.String str5 = (java.lang.String) arrayList.get(5);
        com.tencent.open.log.SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
        if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str3) && !android.text.TextUtils.isEmpty(str4)) {
            try {
                a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new com.tencent.open.web.security.c(webView, java.lang.Long.parseLong(str4), str, str5));
                return true;
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }
}
