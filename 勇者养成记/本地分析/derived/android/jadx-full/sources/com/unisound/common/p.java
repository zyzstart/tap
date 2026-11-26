package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.common.l f1498a;
    private final java.lang.String b;
    private final long[] c;
    private boolean d;
    private com.unisound.common.n e;
    private long f;

    private p(com.unisound.common.l lVar, java.lang.String str) {
        this.f1498a = lVar;
        this.b = str;
        this.c = new long[lVar.q];
    }

    /* synthetic */ p(com.unisound.common.l lVar, java.lang.String str, com.unisound.common.m mVar) {
        this(lVar, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(java.lang.String[] strArr) throws java.io.IOException {
        if (strArr.length != this.f1498a.q) {
            throw b(strArr);
        }
        for (int i = 0; i < strArr.length; i++) {
            try {
                this.c[i] = java.lang.Long.parseLong(strArr[i]);
            } catch (java.lang.NumberFormatException unused) {
                throw b(strArr);
            }
        }
    }

    private java.io.IOException b(java.lang.String[] strArr) throws java.io.IOException {
        throw new java.io.IOException("unexpected journal line: " + java.util.Arrays.toString(strArr));
    }

    public java.io.File a(int i) {
        return new java.io.File(this.f1498a.l, this.b + "." + i);
    }

    public java.lang.String a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (long j : this.c) {
            sb.append(' ');
            sb.append(j);
        }
        return sb.toString();
    }

    public java.io.File b(int i) {
        return new java.io.File(this.f1498a.l, this.b + "." + i + ".tmp");
    }
}
