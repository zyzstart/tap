package com.tencent.beacon.core.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.content.Context f129a;
    private java.lang.Object b;
    private boolean c = false;
    int d = 0;

    public b(android.content.Context context) {
        this.f129a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int iA;
        if (this.b == null) {
            this.b = com.tencent.beacon.core.e.f.a("android.app.ActivityThread", "currentActivityThread", new java.lang.Class[0], new java.lang.Object[0]);
        }
        java.lang.Object obj = this.b;
        if (obj == null || (iA = com.tencent.beacon.core.e.f.a("android.app.ActivityThread", obj, "mNumVisibleActivities")) <= 0) {
            return;
        }
        com.tencent.beacon.core.e.d.a("[core] mNumVisibleActivities: " + iA, new java.lang.Object[0]);
        com.tencent.beacon.core.info.a.e = true;
    }

    private void b() {
        if (java.lang.Integer.valueOf(android.os.Build.VERSION.SDK).intValue() >= 18 || this.b != null || this.c) {
            a();
        } else {
            new android.os.Handler(this.f129a.getMainLooper()).post(new com.tencent.beacon.core.a.a(this));
            this.c = true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.d == 0) {
            com.tencent.beacon.core.e.d.a("[core] Activity Monitor Task was started.", new java.lang.Object[0]);
        }
        int i = this.d;
        this.d = i + 1;
        if (i < 10) {
            if (com.tencent.beacon.core.info.a.e) {
                com.tencent.beacon.core.e.d.a("[core] Found visible activity.", new java.lang.Object[0]);
                new com.tencent.beacon.core.event.m(this.f129a).c();
                this.d = 10;
            } else {
                b();
                com.tencent.beacon.core.a.d.a().a(this, 5000L);
            }
        }
        if (this.d == 10) {
            com.tencent.beacon.core.e.d.a("[core] Activity Monitor Task was exited.", new java.lang.Object[0]);
        }
    }
}
