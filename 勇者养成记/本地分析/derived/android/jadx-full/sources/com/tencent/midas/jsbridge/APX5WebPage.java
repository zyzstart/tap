package com.tencent.midas.jsbridge;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APX5WebPage implements com.tencent.midas.jsbridge.IAPWebPage {
    private static final int HEADER_BACK = 1;
    private static final int HEADER_CLOSE = 2;
    private static final int HEADER_REFRESH = 4;
    private static final java.lang.String TAG = "APX5WebPage";
    private android.app.Activity activity;
    protected android.app.ProgressDialog waitDialog;
    protected com.tencent.midas.jsbridge.APX5WebView webView = null;
    private com.tencent.midas.jsbridge.IAPX5WebViewCallback webviewCallback = new com.tencent.midas.jsbridge.IAPX5WebViewCallback() { // from class: com.tencent.midas.jsbridge.APX5WebPage.1
        @Override // com.tencent.midas.jsbridge.IAPX5WebViewCallback
        public boolean WebChromeClientJsAlert(com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
            com.tencent.midas.comm.APLog.d(com.tencent.midas.jsbridge.APX5WebPage.TAG, "WebChromeClientJsAlert message=" + str2);
            com.tencent.midas.jsbridge.APWebProtocol.AnalyzeWebEntry(com.tencent.midas.jsbridge.APX5WebPage.this.activity, com.tencent.midas.jsbridge.APX5WebPage.this.webView.getWebView(), com.tencent.midas.jsbridge.APX5WebPage.this, str2);
            return true;
        }

        @Override // com.tencent.midas.jsbridge.IAPX5WebViewCallback
        public boolean WebChromeClientJsPrompt(com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.smtt.export.external.interfaces.JsPromptResult jsPromptResult) {
            return true;
        }

        @Override // com.tencent.midas.jsbridge.IAPX5WebViewCallback
        public void WebViewClientPageFinished(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
            android.app.ProgressDialog progressDialog;
            if (com.tencent.midas.jsbridge.APX5WebPage.this.activity.isFinishing() || (progressDialog = com.tencent.midas.jsbridge.APX5WebPage.this.waitDialog) == null || !progressDialog.isShowing()) {
                return;
            }
            com.tencent.midas.jsbridge.APX5WebPage.this.waitDialog.dismiss();
        }

        @Override // com.tencent.midas.jsbridge.IAPX5WebViewCallback
        public void WebViewClientPageStarted(com.tencent.smtt.sdk.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            com.tencent.midas.jsbridge.APX5WebPage.this.waitDialog.show();
        }

        @Override // com.tencent.midas.jsbridge.IAPX5WebViewCallback
        public void WebViewClientReceivedError(com.tencent.smtt.sdk.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            android.app.ProgressDialog progressDialog;
            if (com.tencent.midas.jsbridge.APX5WebPage.this.activity.isFinishing() || (progressDialog = com.tencent.midas.jsbridge.APX5WebPage.this.waitDialog) == null || !progressDialog.isShowing()) {
                return;
            }
            com.tencent.midas.jsbridge.APX5WebPage.this.waitDialog.dismiss();
        }
    };

    protected com.tencent.midas.comm.APProgressDialog createDialog() {
        com.tencent.midas.comm.APProgressDialog aPProgressDialog = new com.tencent.midas.comm.APProgressDialog(this.activity);
        aPProgressDialog.setMessage("请稍候...");
        return aPProgressDialog;
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void initHead(final android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        int iIntValue;
        try {
            com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface(), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_WEBPAGE_HEAD_INIT, "", "headControl=" + str + "&headTitle=" + str2);
            try {
                iIntValue = java.lang.Integer.valueOf(str).intValue();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                iIntValue = 0;
            }
            if (!android.text.TextUtils.isEmpty(str2)) {
                str2 = com.pay.tool.APMidasTools.urlDecode(str2, 1);
            }
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) activity.findViewById(com.pay.tool.APMidasCommMethod.getId(activity, "midas_header_layout"));
            if (iIntValue <= 0 && android.text.TextUtils.isEmpty(str2)) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            android.widget.TextView textView = (android.widget.TextView) activity.findViewById(com.pay.tool.APMidasCommMethod.getId(activity, "midas_header_title"));
            if (android.text.TextUtils.isEmpty(str2)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(str2);
            }
            android.widget.ImageButton imageButton = (android.widget.ImageButton) activity.findViewById(com.pay.tool.APMidasCommMethod.getId(activity, "midas_header_back"));
            if ((iIntValue & 1) == 1) {
                imageButton.setVisibility(0);
                imageButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.midas.jsbridge.APX5WebPage.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(android.view.View view) {
                        com.tencent.midas.comm.APLog.d(com.tencent.midas.jsbridge.APX5WebPage.TAG, "backBtn() clicked");
                        com.tencent.midas.jsbridge.APX5WebView aPX5WebView = com.tencent.midas.jsbridge.APX5WebPage.this.webView;
                        boolean z = (aPX5WebView == null || aPX5WebView.getWebView() == null) ? false : true;
                        com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface(), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_WEBPAGE_X5_BACK, "", "webviewNotNull=" + z);
                        if (z && com.tencent.midas.jsbridge.APX5WebPage.this.webView.getWebView().canGoBack()) {
                            com.tencent.midas.jsbridge.APX5WebPage.this.webView.getWebView().goBack();
                        }
                    }
                });
            } else {
                imageButton.setVisibility(8);
            }
            android.widget.ImageButton imageButton2 = (android.widget.ImageButton) activity.findViewById(com.pay.tool.APMidasCommMethod.getId(activity, "midas_header_close"));
            if ((iIntValue & 2) == 2) {
                imageButton2.setVisibility(0);
                imageButton2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.midas.jsbridge.APX5WebPage.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(android.view.View view) {
                        com.tencent.midas.comm.APLog.d(com.tencent.midas.jsbridge.APX5WebPage.TAG, "closeBtn() clicked");
                        com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface(), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_WEBPAGE_X5_CLOSE, "", "");
                        com.tencent.midas.api.APMidasResponse aPMidasResponse = new com.tencent.midas.api.APMidasResponse();
                        aPMidasResponse.resultCode = 100;
                        aPMidasResponse.resultMsg = "关闭";
                        com.tencent.midas.control.APMidasPayHelper.midasCallBack(aPMidasResponse);
                        activity.finish();
                    }
                });
            } else {
                imageButton2.setVisibility(8);
            }
            android.widget.ImageButton imageButton3 = (android.widget.ImageButton) activity.findViewById(com.pay.tool.APMidasCommMethod.getId(activity, "midas_header_refresh"));
            if ((iIntValue & 4) != 4) {
                imageButton3.setVisibility(8);
            } else {
                imageButton3.setVisibility(0);
                imageButton3.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.midas.jsbridge.APX5WebPage.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(android.view.View view) {
                        com.tencent.midas.comm.APLog.d(com.tencent.midas.jsbridge.APX5WebPage.TAG, "refreshBtn() clicked");
                        com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface(), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_WEBPAGE_X5_REFRESH, "", "");
                        com.tencent.midas.jsbridge.APX5WebView aPX5WebView = com.tencent.midas.jsbridge.APX5WebPage.this.webView;
                        if (aPX5WebView == null || aPX5WebView.getWebView() == null) {
                            return;
                        }
                        com.tencent.midas.jsbridge.APX5WebPage.this.webView.getWebView().reload();
                    }
                });
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void initUI(android.app.Activity activity) {
        this.activity = activity;
        activity.setContentView(com.pay.tool.APMidasCommMethod.getLayoutId(activity, "unipay_layout_activity_web_x5"));
        this.webView = new com.tencent.midas.jsbridge.APX5WebView(activity, (com.tencent.smtt.sdk.WebView) activity.findViewById(com.pay.tool.APMidasCommMethod.getId(activity, "unipay_id_WebView")), this.webviewCallback);
        com.tencent.midas.comm.APProgressDialog aPProgressDialogCreateDialog = createDialog();
        this.waitDialog = aPProgressDialogCreateDialog;
        aPProgressDialogCreateDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: com.tencent.midas.jsbridge.APX5WebPage.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(android.content.DialogInterface dialogInterface) {
            }
        });
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void loadUrl(java.lang.String str) {
        this.webView.loadUrl(str);
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void toPureH5Pay(android.app.Activity activity, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        this.activity = activity;
        activity.setContentView(com.pay.tool.APMidasCommMethod.getLayoutId(activity, "unipay_layout_activity_web_x5"));
        com.tencent.smtt.sdk.WebView webView = (com.tencent.smtt.sdk.WebView) activity.findViewById(com.pay.tool.APMidasCommMethod.getId(activity, "unipay_id_WebView"));
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) webView.getLayoutParams();
        layoutParams.width = (int) (displayMetrics.widthPixels * 0.85f);
        layoutParams.height = (int) (displayMetrics.heightPixels * 0.85f);
        webView.setLayoutParams(layoutParams);
        this.webView = new com.tencent.midas.jsbridge.APX5WebView(activity, webView, this.webviewCallback);
        com.tencent.midas.comm.APProgressDialog aPProgressDialogCreateDialog = createDialog();
        this.waitDialog = aPProgressDialogCreateDialog;
        aPProgressDialogCreateDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: com.tencent.midas.jsbridge.APX5WebPage.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(android.content.DialogInterface dialogInterface) {
            }
        });
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void updateWebViewSize(java.lang.String str) {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.webView.getWebView().getLayoutParams();
        com.tencent.midas.comm.APLog.i("webviewclient == ", "updateWebViewSize ");
        java.lang.String urlParamsValue = com.pay.tool.APMidasTools.getUrlParamsValue(str, "mpwidth");
        int iIntValue = !android.text.TextUtils.isEmpty(urlParamsValue) ? java.lang.Integer.valueOf(urlParamsValue).intValue() : 0;
        java.lang.String urlParamsValue2 = com.pay.tool.APMidasTools.getUrlParamsValue(str, "mpheight");
        int iIntValue2 = android.text.TextUtils.isEmpty(urlParamsValue2) ? 0 : java.lang.Integer.valueOf(urlParamsValue2).intValue();
        if (iIntValue2 == 0 || iIntValue == 0) {
            return;
        }
        layoutParams.width = com.pay.tool.APMidasCommMethod.dip2px(this.activity, iIntValue);
        layoutParams.height = com.pay.tool.APMidasCommMethod.dip2px(this.activity, iIntValue2);
        this.webView.getWebView().setLayoutParams(layoutParams);
    }
}
