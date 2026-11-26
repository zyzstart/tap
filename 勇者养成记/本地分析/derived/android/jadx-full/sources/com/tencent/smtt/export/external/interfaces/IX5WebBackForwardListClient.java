package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5WebBackForwardListClient {
    void onIndexChanged(com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem iX5WebHistoryItem, int i);

    void onNewHistoryItem(com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem iX5WebHistoryItem);

    void onRemoveHistoryItem(com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem iX5WebHistoryItem);
}
