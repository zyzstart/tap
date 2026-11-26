package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5WebHistoryItem {
    boolean canDrawBaseLayer();

    boolean drawBaseLayer(android.graphics.Canvas canvas, boolean z);

    java.lang.Object getCustomData();

    android.graphics.Bitmap getFavicon();

    int getId();

    boolean getIsSubmitForm();

    java.lang.String getOriginalUrl();

    java.lang.String getTitle();

    java.lang.String getTouchIconUrl();

    java.lang.String getUrl();

    void setCustomData(java.lang.Object obj);

    void setFavicon(android.graphics.Bitmap bitmap);

    void setUrl(java.lang.String str);
}
