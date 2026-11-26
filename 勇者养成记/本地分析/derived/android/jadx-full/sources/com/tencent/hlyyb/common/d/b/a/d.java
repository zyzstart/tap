package com.tencent.hlyyb.common.d.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class d extends java.util.LinkedHashMap {
    d(com.tencent.hlyyb.common.d.b.a.c cVar, int i, float f, boolean z) {
        super(8, 1.0f, true);
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(java.util.Map.Entry entry) {
        return size() > 8;
    }
}
