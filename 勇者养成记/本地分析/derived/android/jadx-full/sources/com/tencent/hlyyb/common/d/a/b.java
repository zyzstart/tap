package com.tencent.hlyyb.common.d.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends com.tencent.hlyyb.common.d.a.a implements com.tencent.hlyyb.common.d.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.common.a.p f566a = new com.tencent.hlyyb.common.a.p();
    private java.util.List b = new java.util.ArrayList();

    public b() {
        java.lang.String strB = com.tencent.hlyyb.common.d.j.b("settings_in_client", "", true);
        if (android.text.TextUtils.isEmpty(strB)) {
            return;
        }
        try {
            this.f566a.a(strB);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.tencent.hlyyb.common.d.j.a("settings_in_client", "", true);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void a() {
        java.util.Iterator it = this.b.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.tencent.hlyyb.common.d.d
    public final java.lang.String a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        return this.f566a.a(str, i, str2, str3, str4, str5);
    }

    @Override // com.tencent.hlyyb.common.d.a.a, com.tencent.hlyyb.common.d.b
    public final void a(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str2) && !com.tencent.hlyyb.common.d.b.a.c.a().b().equals(str2)) {
            com.tencent.hlyyb.common.d.b.a.c.a().a(str2, true);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f566a) {
            this.f566a.b();
            this.f566a.a(str);
        }
        com.tencent.hlyyb.common.d.j.a("settings_in_client", this.f566a.a(), true);
        a();
    }

    @Override // com.tencent.hlyyb.common.d.a.a
    public final java.lang.String b() {
        return "settings";
    }

    @Override // com.tencent.hlyyb.common.d.a.a, com.tencent.hlyyb.common.d.b
    public final void c() {
        com.tencent.hlyyb.common.d.f.d().b();
    }
}
