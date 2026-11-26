package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bh implements com.unisound.sdk.ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.bg f1532a;

    bh(com.unisound.sdk.bg bgVar) {
        this.f1532a = bgVar;
    }

    @Override // com.unisound.sdk.ac
    public void a(int i) {
        if (i == 1000 && this.f1532a.aq != null) {
            this.f1532a.aq.sendEmptyMessage(24);
        }
    }
}
