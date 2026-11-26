package com.tencent.ydkqmsp.sdk.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i extends java.util.zip.ZipInputStream {
    public i(java.io.InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.util.zip.ZipInputStream
    public java.util.zip.ZipEntry getNextEntry() throws java.io.IOException {
        java.util.zip.ZipEntry nextEntry = super.getNextEntry();
        if (com.tencent.ydkqmsp.sdk.f.h.a(nextEntry)) {
            throw new com.tencent.ydkqmsp.sdk.f.h();
        }
        return nextEntry;
    }
}
