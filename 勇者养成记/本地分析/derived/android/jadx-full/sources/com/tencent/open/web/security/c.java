package com.tencent.open.web.security;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends com.tencent.open.a.C0028a {
    private java.lang.String d;

    public c(android.webkit.WebView webView, long j, java.lang.String str, java.lang.String str2) {
        super(webView, j, str);
        this.d = str2;
    }

    private void b(java.lang.String str) {
        android.webkit.WebView webView = (android.webkit.WebView) this.f685a.get();
        if (webView != null) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.d);
            stringBuffer.append("){");
            stringBuffer.append(this.d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            java.lang.String string = stringBuffer.toString();
            com.tencent.open.log.SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + string);
            webView.loadUrl(string);
        }
    }

    @Override // com.tencent.open.a.C0028a
    public void a() {
        com.tencent.open.log.SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.a.C0028a
    public void a(java.lang.Object obj) {
        com.tencent.open.log.SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.a.C0028a
    public void a(java.lang.String str) {
        com.tencent.open.log.SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("result", !com.tencent.open.b.c.f701a ? -4 : 0);
            jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SN, this.b);
            jSONObject.put(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
