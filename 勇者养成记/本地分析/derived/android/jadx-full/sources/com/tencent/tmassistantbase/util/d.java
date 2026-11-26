package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d extends com.tencent.tmassistantbase.util.c {
    private static final int[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int e;
    private int f;
    private final int[] g;

    public d(int i, byte[] bArr) {
        this.f1052a = bArr;
        this.g = (i & 8) == 0 ? c : d;
        this.e = 0;
        this.f = 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00db  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:63:0x0101  */
    /* JADX WARN: Code duplicated, block: B:65:0x0104 A[PHI: r6
  0x0104: PHI (r6v3 int) = (r6v2 int), (r6v4 int), (r6v5 int) binds: [B:57:0x00e2, B:62:0x00f8, B:61:0x00e9] A[DONT_GENERATE, DONT_INLINE]] */
    public boolean a(byte[] bArr, int i, int i2, boolean z) {
        int i3 = this.e;
        if (i3 == 6) {
            return false;
        }
        int i4 = i2 + i;
        int i5 = this.f;
        byte[] bArr2 = this.f1052a;
        int[] iArr = this.g;
        int i6 = 0;
        while (i < i4) {
            if (i3 == 0) {
                while (true) {
                    int i7 = i + 4;
                    if (i7 <= i4 && (i5 = (iArr[bArr[i] & 255] << 18) | (iArr[bArr[i + 1] & 255] << 12) | (iArr[bArr[i + 2] & 255] << 6) | iArr[bArr[i + 3] & 255]) >= 0) {
                        bArr2[i6 + 2] = (byte) i5;
                        bArr2[i6 + 1] = (byte) (i5 >> 8);
                        bArr2[i6] = (byte) (i5 >> 16);
                        i6 += 3;
                        i = i7;
                    }
                }
                if (i >= i4) {
                    if (!z) {
                        switch (i3) {
                            case 1:
                                this.e = 6;
                                return false;
                            case 2:
                                bArr2[i6] = (byte) (i5 >> 4);
                                i6++;
                                this.e = i3;
                                break;
                            case 3:
                                int i8 = i6 + 1;
                                bArr2[i6] = (byte) (i5 >> 10);
                                i6 = i8 + 1;
                                bArr2[i8] = (byte) (i5 >> 2);
                                this.e = i3;
                                break;
                            case 4:
                                this.e = 6;
                                return false;
                            default:
                                this.e = i3;
                                break;
                        }
                    } else {
                        this.e = i3;
                        this.f = i5;
                    }
                    this.b = i6;
                    return true;
                }
            }
            int i9 = i + 1;
            int i10 = iArr[bArr[i] & 255];
            switch (i3) {
                case 0:
                    if (i10 >= 0) {
                        i3++;
                        i5 = i10;
                    } else if (i10 != -1) {
                        this.e = 6;
                        return false;
                    }
                    i = i9;
                    break;
                case 1:
                    if (i10 >= 0) {
                        i10 |= i5 << 6;
                        i3++;
                        i5 = i10;
                    } else if (i10 != -1) {
                        this.e = 6;
                        return false;
                    }
                    i = i9;
                    break;
                case 2:
                    if (i10 >= 0) {
                        i10 |= i5 << 6;
                        i3++;
                        i5 = i10;
                    } else if (i10 == -2) {
                        bArr2[i6] = (byte) (i5 >> 4);
                        i6++;
                        i3 = 4;
                    } else if (i10 != -1) {
                        this.e = 6;
                        return false;
                    }
                    i = i9;
                    break;
                case 3:
                    if (i10 >= 0) {
                        int i11 = i10 | (i5 << 6);
                        bArr2[i6 + 2] = (byte) i11;
                        bArr2[i6 + 1] = (byte) (i11 >> 8);
                        bArr2[i6] = (byte) (i11 >> 16);
                        i6 += 3;
                        i5 = i11;
                        i3 = 0;
                    } else if (i10 == -2) {
                        bArr2[i6 + 1] = (byte) (i5 >> 2);
                        bArr2[i6] = (byte) (i5 >> 10);
                        i6 += 2;
                        i3 = 5;
                    } else if (i10 != -1) {
                        this.e = 6;
                        return false;
                    }
                    i = i9;
                    break;
                case 4:
                    if (i10 == -2) {
                        i3++;
                    } else if (i10 != -1) {
                        this.e = 6;
                        return false;
                    }
                    i = i9;
                    break;
                case 5:
                    if (i10 != -1) {
                        this.e = 6;
                        return false;
                    }
                    i = i9;
                    break;
                default:
                    i = i9;
                    break;
            }
        }
        if (!z) {
            switch (i3) {
                case 1:
                    this.e = 6;
                    return false;
                case 2:
                    bArr2[i6] = (byte) (i5 >> 4);
                    i6++;
                    this.e = i3;
                    break;
                case 3:
                    int i12 = i6 + 1;
                    bArr2[i6] = (byte) (i5 >> 10);
                    i6 = i12 + 1;
                    bArr2[i12] = (byte) (i5 >> 2);
                    this.e = i3;
                    break;
                case 4:
                    this.e = 6;
                    return false;
                default:
                    this.e = i3;
                    break;
            }
        } else {
            this.e = i3;
            this.f = i5;
        }
        this.b = i6;
        return true;
    }
}
