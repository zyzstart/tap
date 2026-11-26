package com.tencent.ydkbeacon.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements com.tencent.ydkqmsp.sdk.base.IVendorCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.a.c.f f1188a;

    d(com.tencent.ydkbeacon.a.c.f fVar) {
        this.f1188a = fVar;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.IVendorCallback
    public void onResult(boolean z, java.lang.String str, java.lang.String str2) {
        com.tencent.ydkbeacon.a.e.c.a("getOAID: isEnable: %s, aaid: %s, oaid: %s", java.lang.Boolean.valueOf(z), str, str2);
        this.f1188a.m = str2;
    }
}
