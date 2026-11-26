package com.qq.gdt.action.d.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class h {
    public static com.qq.gdt.action.d.b.h a(com.qq.gdt.action.d.b.f fVar, byte[] bArr) {
        return a(fVar, bArr, 0, bArr.length);
    }

    public static com.qq.gdt.action.d.b.h a(final com.qq.gdt.action.d.b.f fVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("content == null");
        }
        com.qq.gdt.action.d.b.k.a(bArr.length, i, i2);
        return new com.qq.gdt.action.d.b.h() { // from class: com.qq.gdt.action.d.b.h.1
            @Override // com.qq.gdt.action.d.b.h
            public com.qq.gdt.action.d.b.f a() {
                return fVar;
            }

            @Override // com.qq.gdt.action.d.b.h
            public void a(java.io.BufferedOutputStream bufferedOutputStream) throws java.io.IOException {
                bufferedOutputStream.write(bArr, i, i2);
            }

            @Override // com.qq.gdt.action.d.b.h
            public long b() {
                return i2;
            }
        };
    }

    public abstract com.qq.gdt.action.d.b.f a();

    public abstract void a(java.io.BufferedOutputStream bufferedOutputStream) throws java.io.IOException;

    public long b() throws java.io.IOException {
        return -1L;
    }
}
