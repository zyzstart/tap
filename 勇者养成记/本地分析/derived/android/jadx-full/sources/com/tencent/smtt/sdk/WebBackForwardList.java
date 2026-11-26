package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebBackForwardList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList f880a = null;
    private android.webkit.WebBackForwardList b = null;

    static com.tencent.smtt.sdk.WebBackForwardList a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        com.tencent.smtt.sdk.WebBackForwardList webBackForwardList2 = new com.tencent.smtt.sdk.WebBackForwardList();
        webBackForwardList2.b = webBackForwardList;
        return webBackForwardList2;
    }

    static com.tencent.smtt.sdk.WebBackForwardList a(com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        com.tencent.smtt.sdk.WebBackForwardList webBackForwardList = new com.tencent.smtt.sdk.WebBackForwardList();
        webBackForwardList.f880a = iX5WebBackForwardList;
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList iX5WebBackForwardList = this.f880a;
        return iX5WebBackForwardList != null ? iX5WebBackForwardList.getCurrentIndex() : this.b.getCurrentIndex();
    }

    public com.tencent.smtt.sdk.WebHistoryItem getCurrentItem() {
        com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList iX5WebBackForwardList = this.f880a;
        return iX5WebBackForwardList != null ? com.tencent.smtt.sdk.WebHistoryItem.a(iX5WebBackForwardList.getCurrentItem()) : com.tencent.smtt.sdk.WebHistoryItem.a(this.b.getCurrentItem());
    }

    public com.tencent.smtt.sdk.WebHistoryItem getItemAtIndex(int i) {
        com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList iX5WebBackForwardList = this.f880a;
        return iX5WebBackForwardList != null ? com.tencent.smtt.sdk.WebHistoryItem.a(iX5WebBackForwardList.getItemAtIndex(i)) : com.tencent.smtt.sdk.WebHistoryItem.a(this.b.getItemAtIndex(i));
    }

    public int getSize() {
        com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList iX5WebBackForwardList = this.f880a;
        return iX5WebBackForwardList != null ? iX5WebBackForwardList.getSize() : this.b.getSize();
    }
}
