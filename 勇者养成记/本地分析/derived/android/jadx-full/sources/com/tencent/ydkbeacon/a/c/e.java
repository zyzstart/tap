package com.tencent.ydkbeacon.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements java.io.FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.a.c.f f1189a;

    e(com.tencent.ydkbeacon.a.c.f fVar) {
        this.f1189a = fVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(java.io.File file) {
        return java.util.regex.Pattern.matches("cpu[0-9]", file.getName());
    }
}
