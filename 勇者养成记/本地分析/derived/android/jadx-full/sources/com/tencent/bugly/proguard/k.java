package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class k implements java.io.Serializable {
    public abstract void a(com.tencent.bugly.proguard.i iVar);

    public abstract void a(com.tencent.bugly.proguard.j jVar);

    public abstract void a(java.lang.StringBuilder sb, int i);

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        a(sb, 0);
        return sb.toString();
    }
}
