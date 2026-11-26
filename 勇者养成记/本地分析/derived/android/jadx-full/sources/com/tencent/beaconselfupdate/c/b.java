package com.tencent.beaconselfupdate.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {
    public static android.util.SparseArray a(android.util.SparseArray sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        android.util.SparseArray sparseArray2 = new android.util.SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            sparseArray2.append(iKeyAt, sparseArray.get(iKeyAt));
        }
        return sparseArray2;
    }
}
