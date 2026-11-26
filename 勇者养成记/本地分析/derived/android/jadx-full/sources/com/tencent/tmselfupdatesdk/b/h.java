package com.tencent.tmselfupdatesdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class h implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.b.d f1155a;
    final /* synthetic */ android.content.Context b;
    final /* synthetic */ com.tencent.tmselfupdatesdk.b.f c;

    h(com.tencent.tmselfupdatesdk.b.f fVar, com.tencent.tmselfupdatesdk.b.d dVar, android.content.Context context) {
        this.c = fVar;
        this.f1155a = dVar;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.tmselfupdatesdk.b.d dVar = this.f1155a;
        dVar.d = this.c.a(this.b, dVar);
        com.tencent.tmselfupdatesdk.b.d dVar2 = this.f1155a;
        if (dVar2.d != null) {
            this.c.e = dVar2;
            com.tencent.tmassistantbase.util.x.a("PatchManager", "loadPatchFromFile in new thread succeed! mPatchInfo=" + this.c.e);
        }
        this.c.f = false;
    }
}
