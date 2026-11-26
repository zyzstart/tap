package oicq.wlogin_sdk.tools;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f1690a;
    private byte[] b;
    private byte[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private byte[] h;
    private int j;
    private boolean i = true;
    private java.util.Random k = new java.util.Random();

    a() {
    }

    private static long a(byte[] bArr, int i, int i2) {
        long j = 0;
        int i3 = i2 > 4 ? i + 4 : i2 + i;
        while (i < i3) {
            long j2 = (j << 8) | ((long) (bArr[i] & 255));
            i++;
            j = j2;
        }
        return 4294967295L & j;
    }

    private void a() {
        this.f = 0;
        while (true) {
            int i = this.f;
            if (i >= 8) {
                break;
            }
            if (this.i) {
                byte[] bArr = this.f1690a;
                bArr[i] = (byte) (bArr[i] ^ this.b[i]);
            } else {
                byte[] bArr2 = this.f1690a;
                bArr2[i] = (byte) (bArr2[i] ^ this.c[this.e + i]);
            }
            this.f++;
        }
        java.lang.System.arraycopy(a(this.f1690a), 0, this.c, this.d, 8);
        this.f = 0;
        while (true) {
            int i2 = this.f;
            if (i2 >= 8) {
                java.lang.System.arraycopy(this.f1690a, 0, this.b, 0, 8);
                int i3 = this.d;
                this.e = i3;
                this.d = i3 + 8;
                this.f = 0;
                this.i = false;
                return;
            }
            byte[] bArr3 = this.c;
            int i4 = this.d + i2;
            bArr3[i4] = (byte) (bArr3[i4] ^ this.b[i2]);
            this.f = i2 + 1;
        }
    }

    private byte[] a(byte[] bArr) {
        try {
            long jA = a(bArr, 0, 4);
            long jA2 = a(bArr, 4, 4);
            long jA3 = a(this.h, 0, 4);
            long jA4 = a(this.h, 4, 4);
            long jA5 = a(this.h, 8, 4);
            long jA6 = a(this.h, 12, 4);
            long j = 0;
            int i = 16;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(8);
                    java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) jA);
                    dataOutputStream.writeInt((int) jA2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                j = (j + 2654435769L) & 4294967295L;
                jA = (jA + ((((jA2 << 4) + jA3) ^ (jA2 + j)) ^ ((jA2 >>> 5) + jA4))) & 4294967295L;
                jA2 = (jA2 + ((((jA << 4) + jA5) ^ (jA + j)) ^ ((jA >>> 5) + jA6))) & 4294967295L;
                i = i2;
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    private byte[] a(byte[] bArr, int i) {
        try {
            long jA = a(bArr, i, 4);
            long jA2 = a(bArr, i + 4, 4);
            long jA3 = a(this.h, 0, 4);
            long jA4 = a(this.h, 4, 4);
            long jA5 = a(this.h, 8, 4);
            long jA6 = a(this.h, 12, 4);
            long j = 3816266640L;
            int i2 = 16;
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(8);
                    java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) jA);
                    dataOutputStream.writeInt((int) jA2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                jA2 = (jA2 - ((((jA << 4) + jA5) ^ (jA + j)) ^ ((jA >>> 5) + jA6))) & 4294967295L;
                jA = (jA - ((((jA2 << 4) + jA3) ^ (jA2 + j)) ^ ((jA2 >>> 5) + jA4))) & 4294967295L;
                j = (j - 2654435769L) & 4294967295L;
                i2 = i3;
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    private int b() {
        return this.k.nextInt();
    }

    private boolean b(byte[] bArr, int i, int i2) {
        this.f = 0;
        while (true) {
            int i3 = this.f;
            if (i3 >= 8) {
                byte[] bArrB = b(this.b);
                this.b = bArrB;
                if (bArrB == null) {
                    return false;
                }
                this.j += 8;
                this.d += 8;
                this.f = 0;
                return true;
            }
            if (this.j + i3 >= i2) {
                return true;
            }
            byte[] bArr2 = this.b;
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.d + i) + i3]);
            this.f = i3 + 1;
        }
    }

    private byte[] b(byte[] bArr) {
        return a(bArr, 0);
    }

    private byte[] b(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3;
        this.f1690a = new byte[8];
        this.b = new byte[8];
        this.f = 1;
        this.g = 0;
        this.e = 0;
        this.d = 0;
        this.h = bArr2;
        this.i = true;
        int i4 = (i2 + 10) % 8;
        this.f = i4;
        if (i4 != 0) {
            this.f = 8 - i4;
        }
        this.c = new byte[this.f + i2 + 10];
        this.f1690a[0] = (byte) ((b() & 248) | this.f);
        int i5 = 1;
        while (true) {
            i3 = this.f;
            if (i5 > i3) {
                break;
            }
            this.f1690a[i5] = (byte) (b() & 255);
            i5++;
        }
        this.f = i3 + 1;
        for (int i6 = 0; i6 < 8; i6++) {
            this.b[i6] = 0;
        }
        this.g = 1;
        while (this.g <= 2) {
            int i7 = this.f;
            if (i7 < 8) {
                byte[] bArr3 = this.f1690a;
                this.f = i7 + 1;
                bArr3[i7] = (byte) (b() & 255);
                this.g++;
            }
            if (this.f == 8) {
                a();
            }
        }
        while (i2 > 0) {
            int i8 = this.f;
            if (i8 < 8) {
                byte[] bArr4 = this.f1690a;
                this.f = i8 + 1;
                bArr4[i8] = bArr[i];
                i2--;
                i++;
            }
            if (this.f == 8) {
                a();
            }
        }
        this.g = 1;
        while (true) {
            int i9 = this.g;
            if (i9 > 7) {
                return this.c;
            }
            int i10 = this.f;
            if (i10 < 8) {
                byte[] bArr5 = this.f1690a;
                this.f = i10 + 1;
                bArr5[i10] = 0;
                this.g = i9 + 1;
            }
            if (this.f == 8) {
                a();
            }
        }
    }

    protected byte[] a(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3 = 0;
        this.e = 0;
        this.d = 0;
        this.h = bArr2;
        int i4 = i + 8;
        byte[] bArr3 = new byte[i4];
        if (i2 % 8 != 0 || i2 < 16) {
            return null;
        }
        byte[] bArrA = a(bArr, i);
        this.b = bArrA;
        int i5 = bArrA[0] & 7;
        this.f = i5;
        int i6 = (i2 - i5) - 10;
        if (i6 < 0) {
            return null;
        }
        for (int i7 = i; i7 < i4; i7++) {
            bArr3[i7] = 0;
        }
        this.c = new byte[i6];
        this.e = 0;
        this.d = 8;
        this.j = 8;
        this.f++;
        this.g = 1;
        while (true) {
            int i8 = this.g;
            if (i8 > 2) {
                while (i6 != 0) {
                    int i9 = this.f;
                    if (i9 < 8) {
                        this.c[i3] = (byte) (bArr3[(this.e + i) + i9] ^ this.b[i9]);
                        i3++;
                        i6--;
                        this.f = i9 + 1;
                    }
                    if (this.f == 8) {
                        this.e = this.d - 8;
                        if (!b(bArr, i, i2)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                }
                this.g = 1;
                while (this.g < 8) {
                    int i10 = this.f;
                    if (i10 < 8) {
                        if ((bArr3[(this.e + i) + i10] ^ this.b[i10]) != 0) {
                            return null;
                        }
                        this.f = i10 + 1;
                    }
                    if (this.f == 8) {
                        this.e = this.d;
                        if (!b(bArr, i, i2)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                    this.g++;
                }
                return this.c;
            }
            int i11 = this.f;
            if (i11 < 8) {
                this.f = i11 + 1;
                this.g = i8 + 1;
            }
            if (this.f == 8) {
                if (!b(bArr, i, i2)) {
                    return null;
                }
                bArr3 = bArr;
            }
        }
    }

    protected byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 0, bArr.length, bArr2);
    }

    protected byte[] b(byte[] bArr, byte[] bArr2) {
        return b(bArr, 0, bArr.length, bArr2);
    }
}
