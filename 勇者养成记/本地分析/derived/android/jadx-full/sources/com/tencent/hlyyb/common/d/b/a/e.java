package com.tencent.hlyyb.common.d.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.common.d.b.a.f f570a;

    public e() {
        this.f570a = new com.tencent.hlyyb.common.d.b.a.f(this, com.tencent.hlyyb.common.a.a(), "halley_schedule_" + com.tencent.hlyyb.common.a.c() + (com.tencent.hlyyb.common.a.b() ? "_test_" : "_") + com.tencent.hlyyb.common.a.j() + ".db", null, 1);
    }

    public final synchronized com.tencent.hlyyb.common.a.a a(java.lang.String str, java.lang.String str2) {
        return this.f570a.a(str, str2);
    }

    public final synchronized void a() {
        this.f570a.getWritableDatabase().execSQL("delete from halley_scoll_schedule_tbl");
    }

    public final synchronized void a(java.lang.String str, java.lang.String str2, com.tencent.hlyyb.common.a.a aVar) {
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2) && aVar != null) {
            this.f570a.a(str, str2, aVar);
        }
    }
}
