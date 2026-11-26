package com.tencent.qqdownloader.pay.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQDownloaderApiFactory {
    public static com.tencent.qqdownloader.pay.api.IQQDownloaderApi createApi(final android.app.Activity activity) {
        com.tencent.qqdownloader.pay.api.a aVar = new com.tencent.qqdownloader.pay.api.a(activity);
        com.tencent.qqdownloader.pay.api.b.a().a(aVar);
        com.tencent.qqdownloader.pay.a.d.a().a(new java.lang.Runnable() { // from class: com.tencent.qqdownloader.pay.api.QQDownloaderApiFactory.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.qqdownloader.pay.a.a.a(activity.getApplicationContext());
            }
        });
        return aVar;
    }
}
