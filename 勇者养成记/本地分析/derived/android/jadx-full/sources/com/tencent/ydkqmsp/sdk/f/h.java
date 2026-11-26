package com.tencent.ydkqmsp.sdk.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h extends java.io.IOException {
    public static boolean a(java.util.zip.ZipEntry zipEntry) {
        java.lang.String name;
        return (zipEntry == null || (name = zipEntry.getName()) == null || (!name.contains("../") && !name.contains("..\\"))) ? false : true;
    }
}
