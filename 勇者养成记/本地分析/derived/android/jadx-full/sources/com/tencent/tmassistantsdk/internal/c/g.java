package com.tencent.tmassistantsdk.internal.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.c.f f1074a;

    g(com.tencent.tmassistantsdk.internal.c.f fVar) {
        this.f1074a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.tencent.tmassistantbase.util.k.q() && com.tencent.tmassistantbase.util.k.p().equalsIgnoreCase("wifi")) {
            this.f1074a.f1073a.c();
        }
    }
}
