package com.tencent.smtt.export.external.extension.proxy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ProxyWebChromeClientExtension implements com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension {
    private static boolean sCompatibleNewOnSavePassword = true;
    private static boolean sCompatibleOpenFileChooser = true;
    protected com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension mWebChromeClient;

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void acquireWakeLock() {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.acquireWakeLock();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void addFlashView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.addFlashView(view, layoutParams);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void exitFullScreenFlash() {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.exitFullScreenFlash();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public android.content.Context getApplicationContex() {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            return iX5WebChromeClientExtension.getApplicationContex();
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public android.view.View getVideoLoadingProgressView() {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            return iX5WebChromeClientExtension.getVideoLoadingProgressView();
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public java.lang.Object getX5WebChromeClientInstance() {
        return this.mWebChromeClient;
    }

    public com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension getmWebChromeClient() {
        return this.mWebChromeClient;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void h5videoExitFullScreen(java.lang.String str) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.h5videoExitFullScreen(str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void h5videoRequestFullScreen(java.lang.String str) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.h5videoRequestFullScreen(str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void jsExitFullScreen() {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.jsExitFullScreen();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void jsRequestFullScreen() {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.jsRequestFullScreen();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onAddFavorite(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            return iX5WebChromeClientExtension.onAddFavorite(iX5WebViewExtension, str, str2, jsResult);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onAllMetaDataFinished(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, java.util.HashMap map) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.onAllMetaDataFinished(iX5WebViewExtension, map);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onBackforwardFinished(int i) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.onBackforwardFinished(i);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onColorModeChanged(long j) {
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onHitTestResultFinished(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.onHitTestResultFinished(iX5WebViewExtension, hitTestResult);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onHitTestResultForPluginFinished(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult, android.os.Bundle bundle) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.onHitTestResultForPluginFinished(iX5WebViewExtension, hitTestResult, bundle);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public java.lang.Object onMiscCallBack(java.lang.String str, android.os.Bundle bundle) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            return iX5WebChromeClientExtension.onMiscCallBack(str, bundle);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onPageNotResponding(java.lang.Runnable runnable) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            return iX5WebChromeClientExtension.onPageNotResponding(runnable);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onPermissionRequest(java.lang.String str, long j, com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback mediaAccessPermissionsCallback) {
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onPrepareX5ReadPageDataFinished(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, java.util.HashMap map) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.onPrepareX5ReadPageDataFinished(iX5WebViewExtension, map);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onPrintPage() {
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onPromptNotScalable(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.onPromptNotScalable(iX5WebViewExtension);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onPromptScaleSaved(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.onPromptScaleSaved(iX5WebViewExtension);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onSavePassword(android.webkit.ValueCallback valueCallback, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, boolean z) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null && sCompatibleNewOnSavePassword) {
            try {
                return iX5WebChromeClientExtension.onSavePassword(valueCallback, str, str2, str3, str4, str5, z);
            } catch (java.lang.NoSuchMethodError e) {
                if (e.getMessage() == null || !e.getMessage().contains("[REDACTED]")) {
                    throw e;
                }
                android.util.Log.d("[REDACTED]", "[REDACTED]");
                sCompatibleNewOnSavePassword = false;
            }
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onSavePassword(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, android.os.Message message) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension == null) {
            return false;
        }
        try {
            return iX5WebChromeClientExtension.onSavePassword(str, str2, str3, z, message);
        } catch (java.lang.NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onX5ReadModeAvailableChecked(java.util.HashMap map) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.onX5ReadModeAvailableChecked(map);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void openFileChooser(android.webkit.ValueCallback valueCallback, java.lang.String str, java.lang.String str2) {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension == null || !sCompatibleOpenFileChooser) {
            return;
        }
        try {
            iX5WebChromeClientExtension.openFileChooser(valueCallback, str, str2);
        } catch (java.lang.NoSuchMethodError e) {
            if (e.getMessage() == null || !e.getMessage().contains("openFileChooser")) {
                throw e;
            }
            android.util.Log.d("incompatible-oldcore", "IX5WebChromeClientExtension.openFileChooser");
            sCompatibleOpenFileChooser = false;
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void releaseWakeLock() {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.releaseWakeLock();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void requestFullScreenFlash() {
        com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension = this.mWebChromeClient;
        if (iX5WebChromeClientExtension != null) {
            iX5WebChromeClientExtension.requestFullScreenFlash();
        }
    }

    public void setWebChromeClientExtend(com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        this.mWebChromeClient = iX5WebChromeClientExtension;
    }
}
