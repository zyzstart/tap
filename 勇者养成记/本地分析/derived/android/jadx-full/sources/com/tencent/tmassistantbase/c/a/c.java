package com.tencent.tmassistantbase.c.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.util.Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantbase.c.a.b f1013a;

    c(com.tencent.tmassistantbase.c.a.b bVar) {
        this.f1013a = bVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(java.util.Map.Entry entry, java.util.Map.Entry entry2) {
        return ((java.lang.String) entry.getKey()).compareTo((java.lang.String) entry2.getKey());
    }
}
