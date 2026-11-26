package com.tencent.beacon.core.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class h implements com.tencent.beacon.core.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.d.i f153a;

    h(com.tencent.beacon.core.d.i iVar) {
        this.f153a = iVar;
    }

    @Override // com.tencent.beacon.core.b.b
    public void a(java.lang.Exception exc) {
        com.tencent.beacon.core.e.d.d("[upload error] upload fail! exception: %s", exc.getMessage());
    }

    @Override // com.tencent.beacon.core.b.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(java.lang.String str) {
    }
}
