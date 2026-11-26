package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements com.tencent.smtt.export.external.interfaces.DownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.sdk.DownloadListener f908a;
    private com.tencent.smtt.sdk.WebView b;

    public b(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.sdk.DownloadListener downloadListener, boolean z) {
        this.f908a = downloadListener;
        this.b = webView;
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
        onDownloadStart(str, null, null, str2, str3, str4, j, null, null);
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(java.lang.String str, java.lang.String str2, byte[] bArr, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j, java.lang.String str6, java.lang.String str7) {
        com.tencent.smtt.sdk.DownloadListener downloadListener = this.f908a;
        if (downloadListener != null) {
            downloadListener.onDownloadStart(str, str3, str4, str5, j);
            return;
        }
        if (!com.tencent.smtt.sdk.QbSdk.canOpenMimeFileType(this.b.getContext(), str5)) {
            android.content.pm.ApplicationInfo applicationInfo = this.b.getContext().getApplicationInfo();
            if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                com.tencent.smtt.sdk.a.c.a(this.b.getContext(), str, null, null);
                return;
            }
            return;
        }
        android.content.Intent intent = new android.content.Intent("com.tencent.QQBrowser.action.sdk.document");
        intent.setFlags(268435456);
        intent.putExtra("key_reader_sdk_url", str);
        intent.putExtra("key_reader_sdk_type", 1);
        intent.setData(android.net.Uri.parse(str));
        this.b.getContext().startActivity(intent);
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadVideo(java.lang.String str, long j, int i) {
    }
}
