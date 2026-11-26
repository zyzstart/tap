package com.tencent.beacon.core.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f156a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ long c;

    a(android.content.Context context, java.lang.String str, long j) {
        this.f156a = context;
        this.b = str;
        this.c = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.content.SharedPreferences sharedPreferencesC = com.tencent.beacon.core.a.f.a(this.f156a).c();
        if (sharedPreferencesC != null) {
            sharedPreferencesC.edit().putLong(this.b, this.c).apply();
        }
    }
}
