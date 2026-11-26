package com.tencent.tmdownloader.internal.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmdownloader.internal.b.a f1116a;

    public static synchronized com.tencent.tmdownloader.internal.b.a a() {
        if (f1116a == null) {
            f1116a = new com.tencent.tmdownloader.internal.b.a();
        }
        return f1116a;
    }

    public void a(com.tencent.tmdownloader.internal.downloadservice.d dVar) {
        com.tencent.tmdownloader.internal.b.c.g.a(dVar);
    }

    public void a(java.lang.String str) {
        com.tencent.tmdownloader.internal.b.c.g.a(str);
        com.tencent.tmdownloader.internal.b.c.e.a(str);
    }

    public void a(java.lang.String str, java.lang.String str2) {
        com.tencent.tmdownloader.internal.b.c.e.a(str, str2);
    }

    public void a(java.util.ArrayList arrayList) {
        com.tencent.tmdownloader.internal.b.c.g.a(arrayList);
    }

    public com.tencent.tmdownloader.internal.downloadservice.d b(java.lang.String str) {
        return com.tencent.tmdownloader.internal.b.c.g.b(str);
    }

    public java.util.ArrayList b() {
        return com.tencent.tmdownloader.internal.b.c.g.b();
    }

    public com.tencent.tmdownloader.internal.downloadservice.d c(java.lang.String str) {
        return com.tencent.tmdownloader.internal.b.c.g.c(str);
    }

    public java.util.ArrayList c() {
        return com.tencent.tmdownloader.internal.b.c.g.c();
    }
}
