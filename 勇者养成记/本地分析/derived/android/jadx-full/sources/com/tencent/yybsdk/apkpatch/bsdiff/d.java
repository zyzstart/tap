package com.tencent.yybsdk.apkpatch.bsdiff;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1397a;
    private int b;
    private int c;
    private int d;

    public d() {
    }

    public d(java.io.InputStream inputStream) throws com.tencent.yybsdk.apkpatch.bsdiff.InvalidHeaderException, java.io.IOException {
        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStream);
        byte[] bArr = new byte[8];
        dataInputStream.read(bArr);
        java.lang.String str = new java.lang.String(bArr, "UTF-8");
        this.f1397a = str;
        if (!str.equals("BSDIFF40")) {
            throw new com.tencent.yybsdk.apkpatch.bsdiff.InvalidHeaderException("Header missing magic number");
        }
        this.b = com.tencent.yybsdk.apkpatch.bsdiff.e.a(dataInputStream);
        this.c = com.tencent.yybsdk.apkpatch.bsdiff.e.a(dataInputStream);
        this.d = com.tencent.yybsdk.apkpatch.bsdiff.e.a(dataInputStream);
        b();
    }

    private void b() throws com.tencent.yybsdk.apkpatch.bsdiff.InvalidHeaderException {
        int i = this.b;
        if (i < 0) {
            throw new com.tencent.yybsdk.apkpatch.bsdiff.InvalidHeaderException("control block length", i);
        }
        int i2 = this.c;
        if (i2 < 0) {
            throw new com.tencent.yybsdk.apkpatch.bsdiff.InvalidHeaderException("diff block length", i2);
        }
        int i3 = this.d;
        if (i3 < 0) {
            throw new com.tencent.yybsdk.apkpatch.bsdiff.InvalidHeaderException("output file length", i3);
        }
    }

    public int a() {
        return this.d;
    }

    public java.lang.String toString() {
        return ((("" + this.f1397a + "\n") + "control bytes = " + this.b + "\n") + "diff bytes = " + this.c + "\n") + "output size = " + this.d;
    }
}
