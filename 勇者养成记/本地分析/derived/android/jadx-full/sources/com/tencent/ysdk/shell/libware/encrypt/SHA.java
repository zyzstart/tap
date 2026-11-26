package com.tencent.ysdk.shell.libware.encrypt;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SHA {
    private final int[] abcde = {1732584193, -271733879, -1732584194, 271733878, -1009589776};
    private int[] digestInt = new int[5];
    private int[] tmpData = new int[80];

    private byte[] byteArrayFormatData(byte[] bArr) {
        int i;
        int length = bArr.length;
        int i2 = length % 64;
        int i3 = 63;
        if (i2 < 56) {
            i3 = 55 - i2;
            i = (length - i2) + 64;
        } else if (i2 == 56) {
            i = length + 8 + 64;
        } else {
            i3 = (63 - i2) + 56;
            i = ((length + 64) - i2) + 64;
        }
        byte[] bArr2 = new byte[i];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = -128;
        int i4 = length + 1;
        int i5 = 0;
        while (i5 < i3) {
            bArr2[i4] = 0;
            i5++;
            i4++;
        }
        long j = ((long) length) * 8;
        int i6 = i4 + 1;
        bArr2[i4] = (byte) (j >> 56);
        int i7 = i6 + 1;
        bArr2[i6] = (byte) ((j >> 48) & 255);
        int i8 = i7 + 1;
        bArr2[i7] = (byte) ((j >> 40) & 255);
        int i9 = i8 + 1;
        bArr2[i8] = (byte) ((j >> 32) & 255);
        int i10 = i9 + 1;
        bArr2[i9] = (byte) ((j >> 24) & 255);
        int i11 = i10 + 1;
        bArr2[i10] = (byte) ((j >> 16) & 255);
        bArr2[i11] = (byte) ((j >> 8) & 255);
        bArr2[i11 + 1] = (byte) (j & 255);
        return bArr2;
    }

    private static java.lang.String byteArrayToHexString(byte[] bArr) {
        java.lang.String str = "";
        for (byte b : bArr) {
            str = str + byteToHexString(b);
        }
        return str;
    }

    private int byteArrayToInt(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    private static java.lang.String byteToHexString(byte b) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new java.lang.String(new char[]{cArr[(b >>> 4) & 15], cArr[b & 15]});
    }

    private void encrypt() {
        for (int i = 16; i <= 79; i++) {
            int[] iArr = this.tmpData;
            iArr[i] = f4(((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16], 1);
        }
        int[] iArr2 = new int[5];
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            iArr2[i2] = this.digestInt[i2];
        }
        for (int i3 = 0; i3 <= 19; i3++) {
            int iF4 = f4(iArr2[0], 5) + f1(iArr2[1], iArr2[2], iArr2[3]) + iArr2[4] + this.tmpData[i3] + 1518500249;
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = f4(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = iF4;
        }
        for (int i4 = 20; i4 <= 39; i4++) {
            int iF5 = f4(iArr2[0], 5) + f2(iArr2[1], iArr2[2], iArr2[3]) + iArr2[4] + this.tmpData[i4] + 1859775393;
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = f4(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = iF5;
        }
        for (int i5 = 40; i5 <= 59; i5++) {
            int iF6 = (((f4(iArr2[0], 5) + f3(iArr2[1], iArr2[2], iArr2[3])) + iArr2[4]) + this.tmpData[i5]) - 1894007588;
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = f4(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = iF6;
        }
        for (int i6 = 60; i6 <= 79; i6++) {
            int iF7 = (((f4(iArr2[0], 5) + f2(iArr2[1], iArr2[2], iArr2[3])) + iArr2[4]) + this.tmpData[i6]) - 899497514;
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = f4(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = iF7;
        }
        for (int i7 = 0; i7 < iArr2.length; i7++) {
            int[] iArr3 = this.digestInt;
            iArr3[i7] = iArr3[i7] + iArr2[i7];
        }
        int i8 = 0;
        while (true) {
            int[] iArr4 = this.tmpData;
            if (i8 >= iArr4.length) {
                return;
            }
            iArr4[i8] = 0;
            i8++;
        }
    }

    private int f1(int i, int i2, int i3) {
        return ((i ^ (-1)) & i3) | (i2 & i);
    }

    private int f2(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int f3(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    private int f4(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    private void intToByteArray(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
    }

    private int processInputBytes(byte[] bArr) {
        int[] iArr = this.abcde;
        java.lang.System.arraycopy(iArr, 0, this.digestInt, 0, iArr.length);
        byte[] bArrByteArrayFormatData = byteArrayFormatData(bArr);
        int length = bArrByteArrayFormatData.length / 64;
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < 16; i2++) {
                this.tmpData[i2] = byteArrayToInt(bArrByteArrayFormatData, (i * 64) + (i2 * 4));
            }
            encrypt();
        }
        return 20;
    }

    public java.lang.String digest(java.lang.String str) {
        return getDigestOfString(str.getBytes());
    }

    public java.lang.String digest(java.lang.String str, java.lang.String str2) {
        try {
            return getDigestOfString(str.getBytes(str2));
        } catch (java.io.UnsupportedEncodingException unused) {
            return digest(str);
        }
    }

    public byte[] getDigestOfBytes(byte[] bArr) {
        processInputBytes(bArr);
        byte[] bArr2 = new byte[20];
        int i = 0;
        while (true) {
            int[] iArr = this.digestInt;
            if (i >= iArr.length) {
                return bArr2;
            }
            intToByteArray(iArr[i], bArr2, i * 4);
            i++;
        }
    }

    public java.lang.String getDigestOfString(byte[] bArr) {
        return byteArrayToHexString(getDigestOfBytes(bArr));
    }
}
