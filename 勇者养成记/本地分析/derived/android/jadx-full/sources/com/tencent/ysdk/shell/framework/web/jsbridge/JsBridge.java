package com.tencent.ysdk.shell.framework.web.jsbridge;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JsBridge {
    public static final java.lang.String CALL_BATCH_NAME = "callBatch";
    public static final java.lang.String FILE_CHOOSER_CALLBACK_FUNCTION_NAME = "fileChooserCallback";
    public static final java.lang.String JS_BRIDGE_SCHEME = "jsb://";
    public static final int ST_PAGE_ORIGINAL = 2000;
    public static final java.lang.String TAG = "YSDK JsBridge";
    public android.content.Context mContext;
    public com.tencent.smtt.sdk.WebView mWebView;

    public enum ResponseType {
        Method,
        Event
    }

    public JsBridge(com.tencent.smtt.sdk.WebView webView, android.content.Context context) {
        this.mWebView = webView;
        this.mContext = context;
    }

    public void callback(final java.lang.String str, final java.lang.String str2, final com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.ResponseType responseType) {
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.this.callbackUiThread(str, str2, responseType);
                }
            });
        } else {
            callbackUiThread(str, str2, responseType);
        }
    }

    public void callbackUiThread(java.lang.String str, java.lang.String str2, com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.ResponseType responseType) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("javascript:");
        switch (responseType) {
            case Method:
                stringBuffer.append("if(!!");
                stringBuffer.append("window." + str);
                stringBuffer.append("){");
                stringBuffer.append(str);
                stringBuffer.append("(");
                stringBuffer.append(str2);
                stringBuffer.append(")}");
                break;
            case Event:
                stringBuffer.append("var event = document.createEvent('Events');");
                stringBuffer.append("event.initEvent('" + str + "');");
                stringBuffer.append("event.data = " + str2 + ";");
                stringBuffer.append("window.dispatchEvent(event);");
                break;
        }
        com.tencent.smtt.sdk.WebView webView = this.mWebView;
        if (webView != null) {
            try {
                webView.loadUrl(stringBuffer.toString());
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void response(java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        response(str, i, str2, str3, null);
    }

    public void response(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map) {
        response(str, i, str2, str3, map, com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.ResponseType.Method);
    }

    public void response(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map, com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.ResponseType responseType) {
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("result", 0);
            jSONObject.put(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, str3);
            if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str2)) {
                jSONObject.put("method", str2);
            }
            jSONObject.put("seqid", i);
            if (map != null) {
                for (java.lang.String str4 : map.keySet()) {
                    jSONObject.put(str4, map.get(str4));
                }
            }
            callback(str, jSONObject.toString(), responseType);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void responseFail(java.lang.String str, int i, java.lang.String str2, int i2) {
        responseFail(str, i, str2, i2, null);
    }

    public void responseFail(java.lang.String str, int i, java.lang.String str2, int i2, java.util.Map<java.lang.String, java.lang.String> map) {
        responseFail(str, i, str2, i2, null, com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.ResponseType.Method);
    }

    public void responseFail(java.lang.String str, int i, java.lang.String str2, int i2, java.util.Map<java.lang.String, java.lang.String> map, com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.ResponseType responseType) {
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("result", -1);
            jSONObject.put("code", i2);
            jSONObject.put("method", str2);
            jSONObject.put("seqid", i);
            if (map != null) {
                for (java.lang.String str3 : map.keySet()) {
                    jSONObject.put(str3, map.get(str3));
                }
            }
            callback(str, jSONObject.toString(), responseType);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
