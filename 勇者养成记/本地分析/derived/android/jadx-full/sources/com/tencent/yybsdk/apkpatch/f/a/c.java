package com.tencent.yybsdk.apkpatch.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.io.FileFilter {
    c() {
    }

    @Override // java.io.FileFilter
    public boolean accept(java.io.File file) {
        return java.util.regex.Pattern.matches("cpu[0-9]", file.getName());
    }
}
