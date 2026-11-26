package com.tencent.beacon.core.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {
    public static int a(java.lang.String str, java.lang.Object obj, java.lang.String str2) {
        try {
            java.lang.reflect.Field declaredField = java.lang.Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (java.lang.Exception unused) {
            com.tencent.beacon.core.e.d.b("[core] ref get %s.%s failed.", str, str2);
            return -1;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (java.lang.Exception unused) {
            com.tencent.beacon.core.e.d.b("[core] ref call %s#%s failed.", str, str2);
            return null;
        }
    }
}
