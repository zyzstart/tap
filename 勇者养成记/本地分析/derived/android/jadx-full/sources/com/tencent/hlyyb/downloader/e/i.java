package com.tencent.hlyyb.downloader.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class i extends java.io.RandomAccessFile {
    public i(java.io.File file, java.lang.String str) {
        super(file, str);
    }

    @Override // java.io.RandomAccessFile
    protected final void finalize() {
        try {
            super.finalize();
        } catch (java.lang.Throwable unused) {
        }
    }
}
