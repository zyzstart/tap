package com.tencent.ydkbeacon.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.a.d.a f1185a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ long c;

    a(com.tencent.ydkbeacon.a.d.a aVar, java.lang.String str, long j) {
        this.f1185a = aVar;
        this.b = str;
        this.c = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1185a.edit().putLong(this.b, this.c);
    }
}
