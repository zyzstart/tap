package com.qq.gdt.action.d.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j implements java.io.Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.String f99a;
    private final long b;
    private java.io.BufferedInputStream c;
    private java.net.HttpURLConnection d;

    j(java.lang.String str, long j, java.io.BufferedInputStream bufferedInputStream, java.net.HttpURLConnection httpURLConnection) {
        this.f99a = str;
        this.b = j;
        this.c = bufferedInputStream;
        this.d = httpURLConnection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] a() throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = this.c.read(bArr);
                if (-1 == i) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } finally {
            com.qq.gdt.action.d.b.k.a(byteArrayOutputStream);
            com.qq.gdt.action.d.b.k.a(this);
        }
    }

    public final java.lang.String b() throws java.io.IOException {
        return new java.lang.String(a(), com.qq.gdt.action.d.b.k.f100a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.lang.String c() throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = this.c.read(bArr);
                if (-1 == i) {
                    this.c = new java.io.BufferedInputStream(new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                    return new java.lang.String(byteArrayOutputStream.toByteArray(), com.qq.gdt.action.d.b.k.f100a);
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } finally {
            com.qq.gdt.action.d.b.k.a(byteArrayOutputStream);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.qq.gdt.action.d.b.k.a(this.c);
        this.d.disconnect();
        this.d = null;
    }
}
