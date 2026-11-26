package com.tencent.ydkqmsp.sdk.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    private static com.tencent.ydkqmsp.sdk.f.a e = new com.tencent.ydkqmsp.sdk.f.a(102400);
    protected static final java.util.Comparator f = new com.tencent.ydkqmsp.sdk.f.a.C0051a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.List f1343a = new java.util.LinkedList();
    private java.util.List b = new java.util.ArrayList(64);
    private int c = 0;
    private final int d;

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.f.a$a, reason: collision with other inner class name */
    static class C0051a implements java.util.Comparator {
        C0051a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public a(int i) {
        this.d = i;
    }

    public static com.tencent.ydkqmsp.sdk.f.a a() {
        return e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void b() {
        while (this.c > this.d) {
            byte[] bArr = (byte[]) this.f1343a.remove(0);
            this.b.remove(bArr);
            this.c -= bArr.length;
        }
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.d) {
                this.f1343a.add(bArr);
                int iBinarySearch = java.util.Collections.binarySearch(this.b, bArr, f);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.b.add(iBinarySearch, bArr);
                this.c += bArr.length;
                b();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            byte[] bArr = (byte[]) this.b.get(i2);
            if (bArr.length >= i) {
                this.c -= bArr.length;
                this.b.remove(i2);
                this.f1343a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
