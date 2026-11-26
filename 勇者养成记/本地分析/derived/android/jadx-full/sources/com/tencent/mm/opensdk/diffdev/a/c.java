package com.tencent.mm.opensdk.diffdev.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class c implements java.lang.Runnable {
    final /* synthetic */ com.tencent.mm.opensdk.diffdev.a.b g;

    c(com.tencent.mm.opensdk.diffdev.a.b bVar) {
        this.g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.g.f.c);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.opensdk.diffdev.OAuthListener) it.next()).onQrcodeScanned();
        }
    }
}
