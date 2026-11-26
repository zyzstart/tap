package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class o extends java.io.FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.common.n f1497a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private o(com.unisound.common.n nVar, java.io.OutputStream outputStream) {
        super(outputStream);
        this.f1497a = nVar;
    }

    /* synthetic */ o(com.unisound.common.n nVar, java.io.OutputStream outputStream, com.unisound.common.m mVar) {
        this(nVar, outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.out.close();
        } catch (java.io.IOException unused) {
            this.f1497a.c = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        try {
            this.out.flush();
        } catch (java.io.IOException unused) {
            this.f1497a.c = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        try {
            this.out.write(i);
        } catch (java.io.IOException unused) {
            this.f1497a.c = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        try {
            this.out.write(bArr, i, i2);
        } catch (java.io.IOException unused) {
            this.f1497a.c = true;
        }
    }
}
