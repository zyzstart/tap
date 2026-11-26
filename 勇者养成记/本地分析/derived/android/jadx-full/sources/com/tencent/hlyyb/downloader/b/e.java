package com.tencent.hlyyb.downloader.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f607a;
    int f;
    int h;
    int i;
    int k;
    int b = -1;
    int c = -1;
    int d = -1;
    java.util.List e = new java.util.ArrayList();
    java.lang.String g = "";
    java.util.List j = new java.util.ArrayList();
    java.util.List l = new java.util.ArrayList();
    java.lang.String m = "";

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.f607a);
        sb.append(",");
        sb.append(this.b);
        sb.append(",");
        sb.append(this.c);
        sb.append(",");
        sb.append(this.d);
        sb.append(",");
        if (this.e.size() > 0) {
            java.util.Iterator it = this.e.iterator();
            while (it.hasNext()) {
                sb.append((java.lang.String) it.next());
                sb.append("-");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(",");
        sb.append(this.f);
        sb.append(",");
        sb.append(this.g);
        sb.append(",");
        sb.append(this.h);
        sb.append(",");
        sb.append(this.i);
        sb.append(",");
        if (this.j.size() > 0) {
            java.util.Iterator it2 = this.j.iterator();
            while (it2.hasNext()) {
                sb.append((java.lang.String) it2.next());
                sb.append("-");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(",");
        sb.append(this.k);
        sb.append(",");
        if (this.l.size() > 0) {
            java.util.Iterator it3 = this.l.iterator();
            while (it3.hasNext()) {
                sb.append((java.lang.String) it3.next());
                sb.append("-");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(",");
        sb.append(this.m);
        return sb.toString();
    }
}
