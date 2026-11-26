package com.tencent.ydkqmsp.sdk.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    public static void a(java.lang.String str, boolean z) {
        if (str == null) {
            return;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (java.io.File file2 : fileArrListFiles) {
                a(file2.getAbsolutePath(), z);
            }
            if (z) {
                return;
            }
            file.delete();
        }
    }
}
