package com.tencent.tmselfupdatesdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class l implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1158a;
    final /* synthetic */ com.tencent.tmselfupdatesdk.b.d b;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ com.tencent.tmselfupdatesdk.b.f d;

    l(com.tencent.tmselfupdatesdk.b.f fVar, java.lang.String str, com.tencent.tmselfupdatesdk.b.d dVar, java.lang.String str2) {
        this.d = fVar;
        this.f1158a = str;
        this.b = dVar;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String str = this.f1158a;
        com.tencent.tmassistantbase.common.e eVarA = com.tencent.tmassistantbase.common.e.a();
        com.tencent.tmselfupdatesdk.b.f fVar = this.d;
        com.tencent.tmselfupdatesdk.b.d dVar = this.b;
        if (str.equals(eVarA.a(fVar.b(dVar.g, dVar.h), ""))) {
            return;
        }
        com.tencent.tmassistantbase.common.e eVarA2 = com.tencent.tmassistantbase.common.e.a();
        com.tencent.tmselfupdatesdk.b.f fVar2 = this.d;
        com.tencent.tmselfupdatesdk.b.d dVar2 = this.b;
        eVarA2.b(fVar2.b(dVar2.g, dVar2.h), this.f1158a);
        com.tencent.tmselfupdatesdk.b.f fVar3 = this.d;
        com.tencent.tmselfupdatesdk.b.d dVar3 = this.b;
        com.tencent.tmselfupdatesdk.util.a.a("patchDailyUsed", true, fVar3.b(dVar3.g, dVar3.h), this.c);
    }
}
