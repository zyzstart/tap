package com.tencent.ysdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    private static java.util.Random random = new java.util.Random();
    private int contextStart;
    private int crypt;
    private boolean header;
    private byte[] key;
    private byte[] out;
    private int padding;
    private byte[] plain;
    private int pos;
    private int preCrypt;
    private byte[] prePlain;

    public e(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            throw new java.lang.IllegalArgumentException("Key length must be 16!");
        }
        this.header = true;
        this.key = bArr;
    }

    private byte[] decedeToHexStr(java.lang.String str) {
        return f4(com.tencent.ysdk.a.b.a(str));
    }

    private byte[] decipher(byte[] bArr) {
        return decipher(bArr, 0);
    }

    private byte[] decipher(byte[] bArr, int i) {
        try {
            long unsignedInt = getUnsignedInt(bArr, i, 4);
            long unsignedInt2 = getUnsignedInt(bArr, i + 4, 4);
            long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
            long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
            long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
            long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
            long j = 3816266640L;
            int i2 = 16;
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(8);
                    java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) unsignedInt);
                    dataOutputStream.writeInt((int) unsignedInt2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                unsignedInt2 = (unsignedInt2 - ((((unsignedInt << 4) + unsignedInt5) ^ (unsignedInt + j)) ^ ((unsignedInt >>> 5) + unsignedInt6))) & 4294967295L;
                unsignedInt = (unsignedInt - ((((unsignedInt2 << 4) + unsignedInt3) ^ (unsignedInt2 + j)) ^ ((unsignedInt2 >>> 5) + unsignedInt4))) & 4294967295L;
                j = (j - 2654435769L) & 4294967295L;
                i2 = i3;
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    private byte[] decode(byte[] bArr, int i, int i2) {
        int i3 = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        int i4 = i + 8;
        byte[] bArr2 = new byte[i4];
        if (i2 % 8 != 0 || i2 < 16) {
            return null;
        }
        byte[] bArrDecipher = decipher(bArr, i);
        this.prePlain = bArrDecipher;
        if (bArrDecipher == null) {
            return null;
        }
        int i5 = bArrDecipher[0] & 7;
        this.pos = i5;
        int i6 = (i2 - i5) - 10;
        if (i6 < 0) {
            return null;
        }
        for (int i7 = i; i7 < i4; i7++) {
            bArr2[i7] = 0;
        }
        this.out = new byte[i6];
        this.preCrypt = 0;
        this.crypt = 8;
        this.contextStart = 8;
        this.pos++;
        this.padding = 1;
        while (true) {
            int i8 = this.padding;
            if (i8 > 2) {
                while (i6 != 0) {
                    int i9 = this.pos;
                    if (i9 < 8) {
                        this.out[i3] = (byte) (bArr2[(this.preCrypt + i) + i9] ^ this.prePlain[i9]);
                        i3++;
                        i6--;
                        this.pos = i9 + 1;
                    }
                    if (this.pos == 8) {
                        this.preCrypt = this.crypt - 8;
                        if (!decrypt8Bytes(bArr, i, i2)) {
                            return null;
                        }
                        bArr2 = bArr;
                    }
                }
                this.padding = 1;
                while (this.padding < 8) {
                    int i10 = this.pos;
                    if (i10 < 8) {
                        if ((bArr2[(this.preCrypt + i) + i10] ^ this.prePlain[i10]) != 0) {
                            return null;
                        }
                        this.pos = i10 + 1;
                    }
                    if (this.pos == 8) {
                        this.preCrypt = this.crypt;
                        if (!decrypt8Bytes(bArr, i, i2)) {
                            return null;
                        }
                        bArr2 = bArr;
                    }
                    this.padding++;
                }
                return this.out;
            }
            int i11 = this.pos;
            if (i11 < 8) {
                this.pos = i11 + 1;
                this.padding = i8 + 1;
            }
            if (this.pos == 8) {
                if (!decrypt8Bytes(bArr, i, i2)) {
                    return null;
                }
                bArr2 = bArr;
            }
        }
    }

    private boolean decrypt8Bytes(byte[] bArr, int i, int i2) {
        this.pos = 0;
        while (true) {
            int i3 = this.pos;
            if (i3 >= 8) {
                byte[] bArrDecipher = decipher(this.prePlain);
                this.prePlain = bArrDecipher;
                if (bArrDecipher == null) {
                    return false;
                }
                this.contextStart += 8;
                this.crypt += 8;
                this.pos = 0;
                return true;
            }
            if (this.contextStart + i3 >= i2) {
                return true;
            }
            byte[] bArr2 = this.prePlain;
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.crypt + i) + i3]);
            this.pos = i3 + 1;
        }
    }

    private byte[] encipher(byte[] bArr) {
        try {
            long unsignedInt = getUnsignedInt(bArr, 0, 4);
            long unsignedInt2 = getUnsignedInt(bArr, 4, 4);
            long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
            long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
            long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
            long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
            long j = 0;
            int i = 16;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(8);
                    java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) unsignedInt);
                    dataOutputStream.writeInt((int) unsignedInt2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                j = (j + 2654435769L) & 4294967295L;
                unsignedInt = (unsignedInt + ((((unsignedInt2 << 4) + unsignedInt3) ^ (unsignedInt2 + j)) ^ ((unsignedInt2 >>> 5) + unsignedInt4))) & 4294967295L;
                unsignedInt2 = (unsignedInt2 + ((((unsignedInt << 4) + unsignedInt5) ^ (unsignedInt + j)) ^ ((unsignedInt >>> 5) + unsignedInt6))) & 4294967295L;
                i = i2;
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    private byte[] encode(byte[] bArr, int i, int i2) {
        int i3;
        this.plain = new byte[8];
        this.prePlain = new byte[8];
        this.pos = 1;
        this.padding = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        this.header = true;
        int i4 = (i2 + 10) % 8;
        this.pos = i4;
        if (i4 != 0) {
            this.pos = 8 - i4;
        }
        this.out = new byte[this.pos + i2 + 10];
        this.plain[0] = (byte) ((r() & 248) | this.pos);
        int i5 = 1;
        while (true) {
            i3 = this.pos;
            if (i5 > i3) {
                break;
            }
            this.plain[i5] = (byte) (r() & 255);
            i5++;
        }
        this.pos = i3 + 1;
        for (int i6 = 0; i6 < 8; i6++) {
            this.prePlain[i6] = 0;
        }
        this.padding = 1;
        while (this.padding <= 2) {
            int i7 = this.pos;
            if (i7 < 8) {
                byte[] bArr2 = this.plain;
                this.pos = i7 + 1;
                bArr2[i7] = (byte) (r() & 255);
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        while (i2 > 0) {
            int i8 = this.pos;
            if (i8 < 8) {
                byte[] bArr3 = this.plain;
                this.pos = i8 + 1;
                bArr3[i8] = bArr[i];
                i2--;
                i++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        this.padding = 1;
        while (true) {
            int i9 = this.padding;
            if (i9 > 7) {
                return this.out;
            }
            int i10 = this.pos;
            if (i10 < 8) {
                byte[] bArr4 = this.plain;
                this.pos = i10 + 1;
                bArr4[i10] = 0;
                this.padding = i9 + 1;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
    }

    private java.lang.String encode2HexStr(byte[] bArr) {
        return com.tencent.ysdk.a.b.a(f1(bArr));
    }

    private void encrypt8Bytes() {
        this.pos = 0;
        while (true) {
            int i = this.pos;
            if (i >= 8) {
                break;
            }
            if (this.header) {
                byte[] bArr = this.plain;
                bArr[i] = (byte) (bArr[i] ^ this.prePlain[i]);
            } else {
                byte[] bArr2 = this.plain;
                bArr2[i] = (byte) (bArr2[i] ^ this.out[this.preCrypt + i]);
            }
            this.pos++;
        }
        java.lang.System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
        this.pos = 0;
        while (true) {
            int i2 = this.pos;
            if (i2 >= 8) {
                java.lang.System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
                int i3 = this.crypt;
                this.preCrypt = i3;
                this.crypt = i3 + 8;
                this.pos = 0;
                this.header = false;
                return;
            }
            byte[] bArr3 = this.out;
            int i4 = this.crypt + i2;
            bArr3[i4] = (byte) (bArr3[i4] ^ this.prePlain[i2]);
            this.pos = i2 + 1;
        }
    }

    public static long getUnsignedInt(byte[] bArr, int i, int i2) {
        long j = 0;
        int i3 = i2 > 8 ? i + 8 : i2 + i;
        while (i < i3) {
            j = (j << 8) | ((long) (bArr[i] & 255));
            i++;
        }
        return (4294967295L & j) | (j >>> 32);
    }

    private int r() {
        return random.nextInt();
    }

    public byte[] f1(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public byte[] f2(java.lang.String str) {
        return f4(android.util.Base64.decode(str, 0));
    }

    public java.lang.String f3(byte[] bArr) {
        return android.util.Base64.encodeToString(f1(bArr), 0);
    }

    public byte[] f4(byte[] bArr) {
        return decode(bArr, 0, bArr.length);
    }
}
