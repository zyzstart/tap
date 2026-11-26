package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {
    public static <T> java.util.List<java.util.List<T>> a(java.util.List<T> list, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2 * i;
            if (i3 >= list.size()) {
                return arrayList;
            }
            arrayList.add(list.subList(i3, java.lang.Math.min(i3 + i, list.size())));
            i2++;
        }
    }

    public static boolean a(java.util.Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean b(java.util.Collection<?> collection) {
        return !a(collection);
    }
}
