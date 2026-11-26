package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class JsVirtualMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.content.Context f813a;
    private final com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine b;
    private final java.util.HashSet c;

    private static class a implements com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.tencent.smtt.sdk.WebView f814a;

        public a(android.content.Context context) {
            com.tencent.smtt.sdk.WebView webView = new com.tencent.smtt.sdk.WebView(context);
            this.f814a = webView;
            webView.getSettings().setJavaScriptEnabled(true);
        }

        public void a() {
            com.tencent.smtt.sdk.WebView webView = this.f814a;
            if (webView == null) {
                return;
            }
            webView.onPause();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void addJavascriptInterface(java.lang.Object obj, java.lang.String str) {
            com.tencent.smtt.sdk.WebView webView = this.f814a;
            if (webView == null) {
                return;
            }
            webView.addJavascriptInterface(obj, str);
            this.f814a.loadUrl("about:blank");
        }

        public void b() {
            com.tencent.smtt.sdk.WebView webView = this.f814a;
            if (webView == null) {
                return;
            }
            webView.onResume();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void destroy() {
            com.tencent.smtt.sdk.WebView webView = this.f814a;
            if (webView == null) {
                return;
            }
            webView.clearHistory();
            this.f814a.clearCache(true);
            this.f814a.loadUrl("about:blank");
            this.f814a.freeMemory();
            this.f814a.pauseTimers();
            this.f814a.destroy();
            this.f814a = null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateJavascript(java.lang.String str, final android.webkit.ValueCallback valueCallback, java.net.URL url) {
            com.tencent.smtt.sdk.WebView webView = this.f814a;
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(str, valueCallback == null ? null : new com.tencent.smtt.sdk.ValueCallback() { // from class: com.tencent.smtt.sdk.JsVirtualMachine.a.1
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(java.lang.String str2) {
                    valueCallback.onReceiveValue(str2);
                }
            });
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue evaluateScript(java.lang.String str, java.net.URL url) {
            com.tencent.smtt.sdk.WebView webView = this.f814a;
            if (webView == null) {
                return null;
            }
            webView.evaluateJavascript(str, null);
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateScriptAsync(java.lang.String str, final android.webkit.ValueCallback valueCallback, java.net.URL url) {
            com.tencent.smtt.sdk.WebView webView = this.f814a;
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(str, valueCallback == null ? null : new com.tencent.smtt.sdk.ValueCallback() { // from class: com.tencent.smtt.sdk.JsVirtualMachine.a.2
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(java.lang.String str2) {
                    valueCallback.onReceiveValue(null);
                }
            });
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public byte[] getNativeBuffer(int i) {
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int getNativeBufferId() {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void removeJavascriptInterface(java.lang.String str) {
            com.tencent.smtt.sdk.WebView webView = this.f814a;
            if (webView == null) {
                return;
            }
            webView.removeJavascriptInterface(str);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setExceptionHandler(android.webkit.ValueCallback valueCallback) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setName(java.lang.String str) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int setNativeBuffer(int i, byte[] bArr) {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setPerContextData(java.lang.Object obj) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void stealValueFromOtherCtx(java.lang.String str, com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext iX5JsContext, java.lang.String str2) {
        }
    }

    public JsVirtualMachine(android.content.Context context) {
        this(context, null);
    }

    public JsVirtualMachine(android.content.Context context, android.os.Looper looper) {
        this.c = new java.util.HashSet();
        this.f813a = context;
        this.b = com.tencent.smtt.sdk.X5JsCore.a(context, looper);
    }

    protected com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext a() {
        com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            return iX5JsVirtualMachine.createJsContext();
        }
        com.tencent.smtt.sdk.JsVirtualMachine.a aVar = new com.tencent.smtt.sdk.JsVirtualMachine.a(this.f813a);
        this.c.add(new java.lang.ref.WeakReference(aVar));
        return aVar;
    }

    public void destroy() {
        com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.destroy();
            return;
        }
        for (java.lang.ref.WeakReference weakReference : this.c) {
            if (weakReference.get() != null) {
                ((com.tencent.smtt.sdk.JsVirtualMachine.a) weakReference.get()).destroy();
            }
        }
    }

    public android.os.Looper getLooper() {
        com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        return iX5JsVirtualMachine != null ? iX5JsVirtualMachine.getLooper() : android.os.Looper.myLooper();
    }

    public boolean isFallback() {
        return this.b == null;
    }

    public void onPause() {
        com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onPause();
            return;
        }
        for (java.lang.ref.WeakReference weakReference : this.c) {
            if (weakReference.get() != null) {
                ((com.tencent.smtt.sdk.JsVirtualMachine.a) weakReference.get()).a();
            }
        }
    }

    public void onResume() {
        com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onResume();
            return;
        }
        for (java.lang.ref.WeakReference weakReference : this.c) {
            if (weakReference.get() != null) {
                ((com.tencent.smtt.sdk.JsVirtualMachine.a) weakReference.get()).b();
            }
        }
    }
}
