package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i extends com.tencent.smtt.sdk.ServiceWorkerController {
    @Override // com.tencent.smtt.sdk.ServiceWorkerController
    public com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings getServiceWorkerWebSettings() {
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return null;
        }
        final android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings = android.webkit.ServiceWorkerController.getInstance().getServiceWorkerWebSettings();
        return new com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings() { // from class: com.tencent.smtt.sdk.i.1
            @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
            public boolean getAllowContentAccess() {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    return serviceWorkerWebSettings.getAllowContentAccess();
                }
                return false;
            }

            @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
            public boolean getAllowFileAccess() {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    return serviceWorkerWebSettings.getAllowFileAccess();
                }
                return false;
            }

            @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
            public boolean getBlockNetworkLoads() {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    return serviceWorkerWebSettings.getBlockNetworkLoads();
                }
                return false;
            }

            @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
            public int getCacheMode() {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    return serviceWorkerWebSettings.getCacheMode();
                }
                return -1;
            }

            @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
            public void setAllowContentAccess(boolean z) {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    serviceWorkerWebSettings.setAllowContentAccess(z);
                }
            }

            @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
            public void setAllowFileAccess(boolean z) {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    serviceWorkerWebSettings.setAllowContentAccess(z);
                }
            }

            @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
            public void setBlockNetworkLoads(boolean z) {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    serviceWorkerWebSettings.setBlockNetworkLoads(z);
                }
            }

            @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
            public void setCacheMode(int i) {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    serviceWorkerWebSettings.setCacheMode(i);
                }
            }
        };
    }

    @Override // com.tencent.smtt.sdk.ServiceWorkerController
    public void setServiceWorkerClient(final com.tencent.smtt.export.external.interfaces.ServiceWorkerClient serviceWorkerClient) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            android.webkit.ServiceWorkerController.getInstance().setServiceWorkerClient(new android.webkit.ServiceWorkerClient() { // from class: com.tencent.smtt.sdk.i.2
                @Override // android.webkit.ServiceWorkerClient
                public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebResourceRequest webResourceRequest) {
                    com.tencent.smtt.export.external.interfaces.WebResourceResponse webResourceResponseShouldInterceptRequest = serviceWorkerClient.shouldInterceptRequest(new com.tencent.smtt.sdk.SystemWebViewClient.e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), webResourceRequest.isRedirect(), webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
                    if (webResourceResponseShouldInterceptRequest == null) {
                        return null;
                    }
                    android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(webResourceResponseShouldInterceptRequest.getMimeType(), webResourceResponseShouldInterceptRequest.getEncoding(), webResourceResponseShouldInterceptRequest.getData());
                    webResourceResponse.setResponseHeaders(webResourceResponseShouldInterceptRequest.getResponseHeaders());
                    int statusCode = webResourceResponseShouldInterceptRequest.getStatusCode();
                    java.lang.String reasonPhrase = webResourceResponseShouldInterceptRequest.getReasonPhrase();
                    if (statusCode != webResourceResponse.getStatusCode() || (reasonPhrase != null && !reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
                        webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
                    }
                    return webResourceResponse;
                }
            });
        }
    }
}
