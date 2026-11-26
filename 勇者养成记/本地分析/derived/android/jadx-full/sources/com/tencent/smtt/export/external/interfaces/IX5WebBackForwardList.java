package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5WebBackForwardList {
    int getCurrentIndex();

    com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem getCurrentItem();

    com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem getItemAtIndex(int i);

    int getSize();
}
