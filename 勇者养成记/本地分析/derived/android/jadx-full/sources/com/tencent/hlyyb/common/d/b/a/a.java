package com.tencent.hlyyb.common.d.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.common.d.b.a.b f567a;

    public a(java.lang.String str) {
        this.f567a = new com.tencent.hlyyb.common.d.b.a.b(this, com.tencent.hlyyb.common.a.a(), "halley_schedule_" + com.tencent.hlyyb.common.a.c() + (com.tencent.hlyyb.common.a.b() ? "_test_" : "_") + com.tencent.hlyyb.common.a.j() + "_" + str + ".db", null, 1);
    }

    public final synchronized void a(java.lang.String str, byte[] bArr) {
        if (!android.text.TextUtils.isEmpty(str) && bArr != null) {
            this.f567a.a(str, bArr);
        }
    }

    public final synchronized byte[] a(java.lang.String str) {
        return this.f567a.a(str);
    }
}
