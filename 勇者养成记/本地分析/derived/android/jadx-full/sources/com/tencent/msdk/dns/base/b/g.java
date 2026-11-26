package com.tencent.msdk.dns.base.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f653a = {1, 2};
    private static final android.util.SparseArray b;

    static {
        android.util.SparseArray sparseArray = new android.util.SparseArray(2);
        b = sparseArray;
        sparseArray.put(1, new com.tencent.msdk.dns.base.b.b());
        b.put(2, new com.tencent.msdk.dns.base.b.c());
    }

    public static java.util.List a(int i) {
        java.util.ArrayList arrayList = null;
        for (int i2 : f653a) {
            if ((i2 & i) != 0) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                arrayList.add(b.get(i2));
            }
        }
        return arrayList != null ? arrayList : java.util.Collections.emptyList();
    }
}
