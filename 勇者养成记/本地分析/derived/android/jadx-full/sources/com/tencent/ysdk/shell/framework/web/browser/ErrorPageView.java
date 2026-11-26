package com.tencent.ysdk.shell.framework.web.browser;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ErrorPageView extends android.widget.RelativeLayout {
    private static final java.lang.String UI_ID_ICON_ERROR_ICON = "com_tencent_ysdk_icon_error_icon";
    private static final java.lang.String UI_ID_ICON_ERROR_TITLE = "com_tencent_ysdk_icon_error_title";
    private static final java.lang.String UI_ID_ICON_ERROR_WORD = "com_tencent_ysdk_icon_error_word";
    private static final java.lang.String UI_ID_ICON_FRESH_BUTTON = "com_tencent_ysdk_icon_fresh_btn";
    private static final java.lang.String UI_LAYOUT_ERRORPAGE = "com_tencent_ysdk_icon_errerpage";
    private android.view.View.OnClickListener defaultListener;
    private android.widget.ImageView mErrorImg;
    private android.widget.TextView mErrorText;
    private android.widget.TextView mErrorTitle;
    private java.lang.String mFailingUrl;
    private android.widget.Button mFreshBtn;
    private android.view.LayoutInflater mInflater;
    private com.tencent.smtt.sdk.WebView mWebView;

    public ErrorPageView(android.content.Context context) {
        super(context);
        this.defaultListener = new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.this.setVisibility(8);
                com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.this.mWebView.reload();
                com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.this.mWebView.setVisibility(0);
            }
        };
        initViews(context);
    }

    public ErrorPageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.defaultListener = new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.this.setVisibility(8);
                com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.this.mWebView.reload();
                com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.this.mWebView.setVisibility(0);
            }
        };
        initViews(context);
    }

    public ErrorPageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.defaultListener = new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.this.setVisibility(8);
                com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.this.mWebView.reload();
                com.tencent.ysdk.shell.framework.web.browser.ErrorPageView.this.mWebView.setVisibility(0);
            }
        };
        initViews(context);
    }

    private void initViews(android.content.Context context) {
        this.mInflater = android.view.LayoutInflater.from(context);
        try {
            this.mInflater.inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_ERRORPAGE), this);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        this.mErrorImg = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ICON_ERROR_ICON));
        this.mErrorTitle = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ICON_ERROR_TITLE));
        this.mErrorText = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ICON_ERROR_WORD));
        this.mFreshBtn = (android.widget.Button) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ICON_FRESH_BUTTON));
        this.mFreshBtn.setOnClickListener(this.defaultListener);
    }

    public void setFailingUrl(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
        this.mWebView = webView;
        this.mFailingUrl = str;
    }
}
