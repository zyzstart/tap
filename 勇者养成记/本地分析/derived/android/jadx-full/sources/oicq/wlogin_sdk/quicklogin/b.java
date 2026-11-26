package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class b extends android.webkit.WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ oicq.wlogin_sdk.quicklogin.QuikLoginJSInterface f1669a;

    b(oicq.wlogin_sdk.quicklogin.QuikLoginJSInterface quikLoginJSInterface) {
        this.f1669a = quikLoginJSInterface;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult) {
        jsPromptResult.cancel();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
            this.f1669a.ptloginCallBack(jSONObject.getString("uin"), jSONObject.getString(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_SIG), jSONObject.optString("input"));
            return true;
        } catch (java.lang.Exception unused) {
            oicq.wlogin_sdk.tools.util.LOGI("onJsPrompt failed message " + str2, "");
            return true;
        }
    }
}
