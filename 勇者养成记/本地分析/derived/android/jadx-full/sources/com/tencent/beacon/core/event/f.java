package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f167a;
    public boolean b;
    public long c;
    public long d;
    public java.util.Map e;
    public boolean f;
    public java.lang.String g;

    public f(java.lang.String str, java.lang.String str2, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        this.f167a = str2;
        this.b = z;
        this.c = j;
        this.d = j2;
        if (map != null) {
            java.util.HashMap map2 = new java.util.HashMap();
            this.e = map2;
            map2.putAll(map);
        }
        this.f = z2;
        this.g = str;
    }
}
