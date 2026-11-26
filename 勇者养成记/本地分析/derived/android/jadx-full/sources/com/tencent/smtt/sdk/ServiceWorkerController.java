package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class ServiceWorkerController {
    public static com.tencent.smtt.sdk.ServiceWorkerController getInstance(android.content.Context context) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        uVarA.a(context);
        if (!uVarA.b()) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return new com.tencent.smtt.sdk.i();
            }
            return null;
        }
        final com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController iX5CoreServiceWorkerControllerQ = com.tencent.smtt.sdk.u.a().c().q();
        if (iX5CoreServiceWorkerControllerQ != null) {
            return new com.tencent.smtt.sdk.ServiceWorkerController() { // from class: com.tencent.smtt.sdk.ServiceWorkerController.1
                @Override // com.tencent.smtt.sdk.ServiceWorkerController
                public com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings getServiceWorkerWebSettings() {
                    return iX5CoreServiceWorkerControllerQ.getServiceWorkerWebSettings();
                }

                @Override // com.tencent.smtt.sdk.ServiceWorkerController
                public void setServiceWorkerClient(com.tencent.smtt.export.external.interfaces.ServiceWorkerClient serviceWorkerClient) {
                    iX5CoreServiceWorkerControllerQ.setServiceWorkerClient(serviceWorkerClient);
                }
            };
        }
        return null;
    }

    public abstract com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(com.tencent.smtt.export.external.interfaces.ServiceWorkerClient serviceWorkerClient);
}
