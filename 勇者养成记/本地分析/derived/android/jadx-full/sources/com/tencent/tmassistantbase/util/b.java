package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f1051a = !com.tencent.tmassistantbase.util.b.class.desiredAssertionStatus();

    private b() {
    }

    public static byte[] a(java.lang.String str, int i) {
        return a(str.getBytes(), i);
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        com.tencent.tmassistantbase.util.d dVar = new com.tencent.tmassistantbase.util.d(i3, new byte[(i2 * 3) / 4]);
        if (!dVar.a(bArr, i, i2, true)) {
            throw new java.lang.IllegalArgumentException("bad base-64");
        }
        int i4 = dVar.b;
        byte[] bArr2 = dVar.f1052a;
        if (i4 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i4];
        java.lang.System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }

    public static java.lang.String b(byte[] bArr, int i) {
        try {
            return new java.lang.String(c(bArr, i), "US-ASCII");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) {
        com.tencent.tmassistantbase.util.e eVar = new com.tencent.tmassistantbase.util.e(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!eVar.d) {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (eVar.e && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (eVar.f ? 2 : 1);
        }
        eVar.f1052a = new byte[i4];
        eVar.a(bArr, i, i2, true);
        if (f1051a || eVar.b == i4) {
            return eVar.f1052a;
        }
        throw new java.lang.AssertionError();
    }

    public static byte[] c(byte[] bArr, int i) {
        return b(bArr, 0, bArr.length, i);
    }
}
