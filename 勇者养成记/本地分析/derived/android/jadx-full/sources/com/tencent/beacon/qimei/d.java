package com.tencent.beacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements com.tencent.beacon.core.d.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.qimei.e f210a;

    d(com.tencent.beacon.qimei.e eVar) {
        this.f210a = eVar;
    }

    @Override // com.tencent.beacon.core.d.g
    public void a(int i, byte[] bArr, boolean z) {
        if (i != 103) {
            com.tencent.beacon.core.e.d.i("[qimei] qimei req unmatch key: %d", java.lang.Integer.valueOf(i));
            return;
        }
        boolean z2 = bArr != null && bArr.length > 0;
        com.tencent.beacon.core.e.d.a("[qimei] query qimei finish, result: " + z2, new java.lang.Object[0]);
        if (z2) {
            com.tencent.beacon.core.e.d.d("[qimei] process CMD_RESPONSE_GEN_QIMEI", new java.lang.Object[0]);
            this.f210a.a(bArr);
            com.tencent.beacon.core.a.d.a().a(112, false);
            com.tencent.beacon.qimei.i.a(this.f210a.c, java.lang.System.currentTimeMillis());
        }
    }
}
