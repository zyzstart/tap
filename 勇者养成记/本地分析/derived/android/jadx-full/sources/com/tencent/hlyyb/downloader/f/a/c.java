package com.tencent.hlyyb.downloader.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c extends java.util.concurrent.FutureTask implements java.lang.Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.Object f639a;

    public c(com.tencent.hlyyb.downloader.f.a.b bVar, java.lang.Runnable runnable, java.lang.Object obj) {
        super(runnable, null);
        this.f639a = runnable;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(java.lang.Object obj) {
        com.tencent.hlyyb.downloader.f.a.c cVar = (com.tencent.hlyyb.downloader.f.a.c) obj;
        if (this == cVar) {
            return 0;
        }
        if (cVar == null) {
            return -1;
        }
        java.lang.Object obj2 = this.f639a;
        if (obj2 == null || cVar.f639a == null || !obj2.getClass().equals(cVar.f639a.getClass())) {
            return 0;
        }
        java.lang.Object obj3 = this.f639a;
        if (obj3 instanceof java.lang.Comparable) {
            return ((java.lang.Comparable) obj3).compareTo(cVar.f639a);
        }
        return 0;
    }
}
