package com.dmlt.tracking.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ObjectUtil {
    public static boolean isEmpty(java.lang.Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof java.lang.String) && obj.toString().length() == 0) {
            return true;
        }
        if (obj.getClass().isArray() && java.lang.reflect.Array.getLength(obj) == 0) {
            return true;
        }
        if ((obj instanceof java.util.Collection) && ((java.util.Collection) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof java.util.Map) && ((java.util.Map) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof android.util.SparseArray) && ((android.util.SparseArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof android.util.SparseBooleanArray) && ((android.util.SparseBooleanArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof android.util.SparseIntArray) && ((android.util.SparseIntArray) obj).size() == 0) {
            return true;
        }
        return android.os.Build.VERSION.SDK_INT >= 18 && (obj instanceof android.util.SparseLongArray) && ((android.util.SparseLongArray) obj).size() == 0;
    }
}
