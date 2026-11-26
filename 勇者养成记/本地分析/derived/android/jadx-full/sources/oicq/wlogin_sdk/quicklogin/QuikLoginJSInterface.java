package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QuikLoginJSInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.app.Activity f1667a;

    public QuikLoginJSInterface(android.app.Activity activity) {
        this.f1667a = activity;
    }

    @android.webkit.JavascriptInterface
    public void ptAlertCallBack(java.lang.String str) {
        new android.app.AlertDialog.Builder(this.f1667a).setTitle("登录提示").setMessage(str).setPositiveButton("确定", (android.content.DialogInterface.OnClickListener) null).show();
    }

    @android.webkit.JavascriptInterface
    public void ptloginCallBack(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str3 != null && true == str3.equals("undefined")) {
            str3 = "";
        }
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("uin", str);
        intent.putExtra(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_SIG, str2);
        intent.putExtra("input", str3);
        intent.putExtra("isRetFromWeb", true);
        this.f1667a.setResult(-1, intent);
        this.f1667a.finish();
        if (oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimEnter == 0 && oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimExit == 0) {
            return;
        }
        this.f1667a.overridePendingTransition(oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimEnter, oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimExit);
    }
}
