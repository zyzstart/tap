package com.tencent.beacon.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.stat.ModuleImpl f219a;

    f(com.tencent.beacon.stat.ModuleImpl moduleImpl) {
        this.f219a = moduleImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f219a.quaSharedPrefs.a(com.tencent.beacon.core.a.f.a(((com.tencent.beacon.core.c) this.f219a).mContext));
        this.f219a.onQuaDate.a(((com.tencent.beacon.core.a.f) this.f219a.quaSharedPrefs.b()).a("on_qua_date", ""));
        this.f219a.commonEventCalls.a(java.lang.Long.valueOf(((com.tencent.beacon.core.a.f) this.f219a.quaSharedPrefs.b()).a("common_event_calls", 0L)));
        this.f219a.realTimeEventCalls.a(java.lang.Long.valueOf(((com.tencent.beacon.core.a.f) this.f219a.quaSharedPrefs.b()).a("real_time_event_calls", 0L)));
        this.f219a.commonEventWriteSucc.a(java.lang.Long.valueOf(((com.tencent.beacon.core.a.f) this.f219a.quaSharedPrefs.b()).a("common_event_write_succ", 0L)));
        this.f219a.realTimeEventWriteSucc.a(java.lang.Long.valueOf(((com.tencent.beacon.core.a.f) this.f219a.quaSharedPrefs.b()).a("real_time_event_write_succ", 0L)));
        this.f219a.realTimeEventUploadSucc.a(java.lang.Long.valueOf(((com.tencent.beacon.core.a.f) this.f219a.quaSharedPrefs.b()).a("real_time_event_upload_succ", 0L)));
        this.f219a.resetAllAnotherDay();
    }
}
