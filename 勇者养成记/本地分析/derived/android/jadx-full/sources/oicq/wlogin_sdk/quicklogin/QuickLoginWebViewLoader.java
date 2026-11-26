package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QuickLoginWebViewLoader {
    static int finishAnimEnter = 0;
    static int finishAnimExit = 0;
    static final java.lang.String link = "https://xui.ptlogin2.qq.com/cgi-bin/xlogin";
    static boolean sslErrorProcessed = false;

    public static void disableAccessibility(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT == 17) {
            try {
                android.view.accessibility.AccessibilityManager accessibilityManager = (android.view.accessibility.AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager.isEnabled()) {
                    java.lang.reflect.Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", java.lang.Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, 0);
                }
            } catch (java.lang.Error | java.lang.Exception unused) {
            }
        }
    }

    public static void load(android.app.Activity activity, android.content.Intent intent) {
        java.lang.String str;
        finishAnimEnter = intent.getIntExtra("finishAnimEnter", 0);
        finishAnimExit = intent.getIntExtra("finishAnimExit", 0);
        oicq.wlogin_sdk.quicklogin.QuikLoginJSInterface quikLoginJSInterface = new oicq.wlogin_sdk.quicklogin.QuikLoginJSInterface(activity);
        sslErrorProcessed = false;
        if (intent == null) {
            oicq.wlogin_sdk.tools.util.LOGI("QuickLoginWebViewLoader.load parameter data is null", null);
            return;
        }
        long longExtra = intent.getLongExtra("appid", 0L);
        java.lang.String stringExtra = intent.getStringExtra("account");
        int i = true == intent.getBooleanExtra("isUserAccountLocked", false) ? 1 : 0;
        int i2 = true == intent.getBooleanExtra("forceWebLogin", false) ? 1 : 0;
        if (0 == longExtra) {
            oicq.wlogin_sdk.tools.util.LOGI("QuickLoginWebViewActivity get appid failed");
            return;
        }
        java.lang.String stringExtra2 = intent.getStringExtra("titleBackgroundColor");
        if (stringExtra2 == null || stringExtra2.length() == 0) {
            stringExtra2 = "#3F51B5";
        }
        java.lang.String stringExtra3 = intent.getStringExtra("titleTextColor");
        if (stringExtra3 == null || stringExtra3.length() == 0) {
            stringExtra3 = "#FFFFFF";
        }
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(activity);
        relativeLayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        double d = height;
        java.lang.Double.isNaN(d);
        int i3 = (int) (d * 0.07d);
        android.widget.TextView textView = new android.widget.TextView(activity);
        try {
            textView.setBackgroundColor(android.graphics.Color.parseColor(stringExtra2));
            textView.setTextColor(android.graphics.Color.parseColor(stringExtra3));
        } catch (java.lang.IllegalArgumentException unused) {
            oicq.wlogin_sdk.tools.util.LOGI("color error titleBackgroundColor " + stringExtra2 + " titleTextColor " + stringExtra3, "");
            android.util.Log.e(oicq.wlogin_sdk.tools.util.FILE_DIR, "color error titleBackgroundColor " + stringExtra2 + " titleTextColor " + stringExtra3);
        }
        textView.setText("");
        textView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, i3));
        relativeLayout.addView(textView);
        android.widget.Button button = new android.widget.Button(activity);
        try {
            button.setBackgroundColor(android.graphics.Color.parseColor(stringExtra2));
            button.setTextColor(android.graphics.Color.parseColor(stringExtra3));
        } catch (java.lang.IllegalArgumentException unused2) {
            oicq.wlogin_sdk.tools.util.LOGI("color error titleBackgroundColor " + stringExtra2 + " titleTextColor " + stringExtra3, "");
            android.util.Log.e(oicq.wlogin_sdk.tools.util.FILE_DIR, "color error titleBackgroundColor " + stringExtra2 + " titleTextColor " + stringExtra3);
        }
        button.setText("关闭");
        button.setPadding(15, button.getPaddingTop(), 15, button.getPaddingBottom());
        button.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, i3));
        relativeLayout.addView(button);
        button.setOnClickListener(new oicq.wlogin_sdk.quicklogin.a(activity));
        try {
            android.webkit.WebView webView = new android.webkit.WebView(activity);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, height - i3);
            layoutParams.setMargins(0, i3, 0, 0);
            webView.setLayoutParams(layoutParams);
            relativeLayout.addView(webView);
            activity.setContentView(relativeLayout);
            android.webkit.WebSettings settings = webView.getSettings();
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            if (17 <= android.os.Build.VERSION.SDK_INT) {
                webView.addJavascriptInterface(new oicq.wlogin_sdk.quicklogin.QuikLoginJSInterface(activity), "WTLogin");
                str = "javascript:function wtCB(uin, sig, input) { WTLogin.ptloginCallBack(uin, sig, input); }function wtAlert(input) { WTLogin.ptAlertCallBack(input); }";
            } else {
                str = "javascript:function wtCB(uin, sig, input) { return prompt(JSON.stringify({ uin:''+uin, sig:''+sig, input:''+input})); }";
            }
            disableAccessibility(activity);
            settings.setJavaScriptEnabled(true);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            if (17 > android.os.Build.VERSION.SDK_INT) {
                webView.setWebChromeClient(new oicq.wlogin_sdk.quicklogin.b(quikLoginJSInterface));
            }
            webView.setWebViewClient(new oicq.wlogin_sdk.quicklogin.c(activity, webView, str));
            java.lang.String str2 = "";
            if (stringExtra != null && stringExtra.length() != 0) {
                str2 = "&default_uin=" + stringExtra + "&pt_lock_uin=" + i;
            }
            activity.runOnUiThread(new oicq.wlogin_sdk.quicklogin.g(webView, "https://xui.ptlogin2.qq.com/cgi-bin/xlogin?[REDACTED]" + longExtra + "&style=42&s_url=http://wtlogin.qq.com/&pt_no_onekey=1&pt_no_auth=1&daid=499&wt_force_pwd=" + i2 + str2, str));
        } catch (java.lang.Error e) {
            oicq.wlogin_sdk.tools.util.LOGI("create webview failed " + e.getMessage(), "");
        } catch (java.lang.Exception e2) {
            oicq.wlogin_sdk.tools.util.LOGI("create webview failed " + e2.getMessage(), "");
        }
    }
}
