package com.tencent.yybsdk.apkpatch.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends com.tencent.yybsdk.apkpatch.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1400a;
    private final int b;
    private final byte c;
    private final int d;
    private final int e;
    private com.tencent.yybsdk.apkpatch.c.b h;
    private com.tencent.yybsdk.apkpatch.c.f i;

    public c(int i, int i2, byte b, int i3, int i4) {
        this.f1400a = i;
        this.b = i2;
        this.c = b;
        this.d = i3;
        this.e = i4;
    }

    @Override // com.tencent.yybsdk.apkpatch.c.e
    public void a(int i) {
        this.i.a(i);
    }

    @Override // com.tencent.yybsdk.apkpatch.c.e
    public void a(com.tencent.yybsdk.apkpatch.c.b bVar) {
        this.h = bVar;
    }

    @Override // com.tencent.yybsdk.apkpatch.c.e
    public void a(com.tencent.yybsdk.apkpatch.c.f fVar) {
        this.i = fVar;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0141 A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:61:0x013a, B:63:0x0141, B:65:0x0148), top: B:70:0x013a }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0148 A[Catch: all -> 0x0150, TRY_LEAVE, TryCatch #0 {all -> 0x0150, blocks: (B:61:0x013a, B:63:0x0141, B:65:0x0148), top: B:70:0x013a }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        java.io.RandomAccessFile randomAccessFileE;
        com.tencent.yybsdk.apkpatch.a.b bVarF;
        int i;
        java.lang.String str = "";
        java.util.zip.Inflater inflaterB = null;
        try {
            try {
                randomAccessFileE = this.h.e();
                try {
                    randomAccessFileE.seek(this.b);
                    bVarF = this.h.f();
                    try {
                        bVarF.a(this.f1400a);
                        bVarF.b(this.d);
                        int i2 = 8192;
                        int i3 = this.e > 8192 ? 8192 : this.e;
                        if (this.d <= 8192) {
                            i2 = this.d;
                        }
                        if (i3 == 0) {
                            i3 = 128;
                        }
                        if (i2 == 0) {
                            i2 = 128;
                        }
                        byte[] bArr = new byte[i3];
                        if (this.c <= 0) {
                            while (true) {
                                int i4 = bVarF.read(bArr);
                                if (i4 <= 0) {
                                    break;
                                } else {
                                    randomAccessFileE.write(bArr, 0, i4);
                                }
                            }
                        } else {
                            inflaterB = this.h.b();
                            java.util.zip.InflaterInputStream inflaterInputStream = new java.util.zip.InflaterInputStream(bVarF, inflaterB, i2);
                            int i5 = 0;
                            while (true) {
                                int i6 = inflaterInputStream.read(bArr);
                                if (i6 <= 0) {
                                    break;
                                }
                                randomAccessFileE.write(bArr, 0, i6);
                                i5 += i6;
                            }
                            if (i5 != this.e) {
                                this.i.a(-49, "inflateLen error:" + this.f1400a + "," + this.d + "," + this.e + "," + i5);
                            }
                        }
                        if (bVarF != null) {
                            this.h.b(bVarF);
                        }
                        if (randomAccessFileE != null) {
                            this.h.b(randomAccessFileE);
                        }
                        if (inflaterB == null) {
                            return;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        try {
                            if (th.getMessage() == null || !th.getMessage().contains("No space")) {
                                str = "InflateError:" + this.f1400a + "," + this.d + "," + this.e + "," + th.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(th);
                                i = -50;
                            } else {
                                i = -59;
                            }
                            th.printStackTrace();
                            this.i.a(i, str);
                            if (bVarF != null) {
                                this.h.b(bVarF);
                            }
                            if (randomAccessFileE != null) {
                                this.h.b(randomAccessFileE);
                            }
                            if (0 == 0) {
                                return;
                            }
                        } catch (java.lang.Throwable th2) {
                            if (bVarF != null) {
                                try {
                                    this.h.b(bVarF);
                                    if (randomAccessFileE != null) {
                                        this.h.b(randomAccessFileE);
                                    }
                                    if (0 != 0) {
                                        inflaterB.reset();
                                        this.h.a((java.util.zip.Inflater) null);
                                    }
                                } catch (java.lang.Throwable unused) {
                                    throw th2;
                                }
                            } else {
                                if (randomAccessFileE != null) {
                                    this.h.b(randomAccessFileE);
                                }
                                if (0 != 0) {
                                    inflaterB.reset();
                                    this.h.a((java.util.zip.Inflater) null);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    bVarF = null;
                }
            } catch (java.lang.Throwable unused2) {
                return;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            randomAccessFileE = null;
            bVarF = null;
        }
        inflaterB.reset();
        this.h.a(inflaterB);
    }
}
