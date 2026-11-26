package com.dodjoy.unitywebview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebViewWithButtomNavgation implements android.view.View.OnClickListener {
    private static com.dodjoy.unitywebview.WebViewWithButtomNavgation _instance;
    private android.app.Activity mActivity;
    private android.view.View mBackBtn;
    private android.view.View mCloseBtn;
    private android.view.View mFowardBtn;
    private android.view.View mOpenInBrowserBtn;
    private android.view.View mRefreshBtn;
    private android.view.View mView;
    private android.webkit.WebView mWebView;

    private WebViewWithButtomNavgation(android.app.Activity activity) {
        this.mActivity = activity;
    }

    private void doInit(final java.lang.String str) {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.unitywebview.WebViewWithButtomNavgation.1
            @Override // java.lang.Runnable
            public void run() {
                com.dodjoy.unitywebview.WebViewWithButtomNavgation.this.showWebView(str);
            }
        });
    }

    private int getResourcesId(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return context.getResources().getIdentifier(str2, str, context.getPackageName());
    }

    public static void init(android.app.Activity activity, java.lang.String str) {
        if (activity == null) {
            return;
        }
        if (_instance == null) {
            _instance = new com.dodjoy.unitywebview.WebViewWithButtomNavgation(activity);
        }
        _instance.doInit(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebView(java.lang.String str) {
        this.mView = android.view.LayoutInflater.from(this.mActivity).inflate(getResourcesId(this.mActivity, "layout", "dodlib_web_with_navgation"), (android.view.ViewGroup) null);
        this.mWebView = (android.webkit.WebView) this.mView.findViewById(getResourcesId(this.mActivity, "id", "dodlib_navweb_webview"));
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            this.mWebView.getSettings().setCacheMode(1);
        }
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.setWebViewClient(new android.webkit.WebViewClient());
        this.mWebView.loadUrl(str);
        this.mBackBtn = this.mView.findViewById(getResourcesId(this.mActivity, "id", "dodlib_navweb_back_button"));
        this.mBackBtn.setOnClickListener(this);
        this.mFowardBtn = this.mView.findViewById(getResourcesId(this.mActivity, "id", "dodlib_navweb_forward_button"));
        this.mFowardBtn.setOnClickListener(this);
        this.mRefreshBtn = this.mView.findViewById(getResourcesId(this.mActivity, "id", "dodlib_navweb_refresh_button"));
        this.mRefreshBtn.setOnClickListener(this);
        this.mOpenInBrowserBtn = this.mView.findViewById(getResourcesId(this.mActivity, "id", "dodlib_navweb_openinbrowser_button"));
        this.mOpenInBrowserBtn.setOnClickListener(this);
        this.mCloseBtn = this.mView.findViewById(getResourcesId(this.mActivity, "id", "dodlib_navweb_close_btn"));
        this.mCloseBtn.setOnClickListener(this);
        this.mActivity.addContentView(this.mView, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view == this.mBackBtn) {
            if (this.mWebView.canGoBack()) {
                this.mWebView.goBack();
                return;
            }
            return;
        }
        if (view == this.mFowardBtn) {
            if (this.mWebView.canGoForward()) {
                this.mWebView.goForward();
            }
        } else {
            if (view == this.mRefreshBtn) {
                this.mWebView.reload();
                return;
            }
            if (view == this.mOpenInBrowserBtn) {
                this.mWebView.getContext().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(this.mWebView.getUrl())));
            } else if (view == this.mCloseBtn) {
                ((android.view.ViewGroup) this.mView.getParent()).removeView(this.mView);
            }
        }
    }
}
