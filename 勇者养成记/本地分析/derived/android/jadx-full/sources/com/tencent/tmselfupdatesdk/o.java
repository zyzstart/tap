package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class o implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.g f1173a;

    o(com.tencent.tmselfupdatesdk.g gVar) {
        this.f1173a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1173a.h() != null) {
            try {
                this.f1173a.a(this.f1173a.h().getDownloadTaskState(this.f1173a.h));
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_SaveUpdateManager", "exception:", e);
                e.printStackTrace();
            }
        }
    }
}
