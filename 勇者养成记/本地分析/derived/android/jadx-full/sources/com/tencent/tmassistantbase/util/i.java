package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class i implements java.io.FileFilter {
    i() {
    }

    @Override // java.io.FileFilter
    public boolean accept(java.io.File file) {
        return java.util.regex.Pattern.matches("cpu[0-9]", file.getName());
    }
}
