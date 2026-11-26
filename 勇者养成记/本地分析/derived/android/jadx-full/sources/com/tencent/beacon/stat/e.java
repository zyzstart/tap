package com.tencent.beacon.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.stat.ModuleImpl f218a;

    e(com.tencent.beacon.stat.ModuleImpl moduleImpl) {
        this.f218a = moduleImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((com.tencent.beacon.core.a.f) this.f218a.quaSharedPrefs.a()).b().a("on_qua_date", this.f218a.onQuaDate.a()).a("common_event_calls", this.f218a.commonEventCalls.a()).a("real_time_event_calls", this.f218a.realTimeEventCalls.a()).a("common_event_write_succ", this.f218a.commonEventWriteSucc.a()).a("real_time_event_write_succ", this.f218a.realTimeEventWriteSucc.a()).a("real_time_event_upload_succ", this.f218a.realTimeEventUploadSucc.a()).a();
        } catch (java.lang.Exception e) {
            com.tencent.beacon.core.e.d.a(e);
        }
    }
}
