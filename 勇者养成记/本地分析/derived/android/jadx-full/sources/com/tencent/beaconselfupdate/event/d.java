package com.tencent.beaconselfupdate.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f258a;
    public boolean b;
    public long c;
    public long d;
    public java.util.Map e;
    boolean f;

    public d(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        this.f258a = str;
        this.b = z;
        this.c = j;
        this.d = j2;
        if (map != null) {
            java.util.HashMap map2 = new java.util.HashMap();
            this.e = map2;
            map2.putAll(map);
        }
        this.f = z2;
    }
}
