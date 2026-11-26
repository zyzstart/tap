package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebHistoryItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem f881a = null;
    private android.webkit.WebHistoryItem b = null;

    private WebHistoryItem() {
    }

    static com.tencent.smtt.sdk.WebHistoryItem a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        com.tencent.smtt.sdk.WebHistoryItem webHistoryItem2 = new com.tencent.smtt.sdk.WebHistoryItem();
        webHistoryItem2.b = webHistoryItem;
        return webHistoryItem2;
    }

    static com.tencent.smtt.sdk.WebHistoryItem a(com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        com.tencent.smtt.sdk.WebHistoryItem webHistoryItem = new com.tencent.smtt.sdk.WebHistoryItem();
        webHistoryItem.f881a = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public android.graphics.Bitmap getFavicon() {
        com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem iX5WebHistoryItem = this.f881a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getFavicon() : this.b.getFavicon();
    }

    public java.lang.String getOriginalUrl() {
        com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem iX5WebHistoryItem = this.f881a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getOriginalUrl() : this.b.getOriginalUrl();
    }

    public java.lang.String getTitle() {
        com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem iX5WebHistoryItem = this.f881a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getTitle() : this.b.getTitle();
    }

    public java.lang.String getUrl() {
        com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem iX5WebHistoryItem = this.f881a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getUrl() : this.b.getUrl();
    }
}
