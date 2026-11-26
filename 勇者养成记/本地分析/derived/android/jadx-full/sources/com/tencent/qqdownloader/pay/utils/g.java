package com.tencent.qqdownloader.pay.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class g {
    public static java.lang.Object a(java.lang.Object obj, java.lang.String str) {
        return a(obj, str, (java.lang.Object[]) null);
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) throws java.lang.Exception {
        java.lang.reflect.Method declaredMethod;
        java.lang.Class<?> cls = obj.getClass();
        try {
            declaredMethod = cls.getDeclaredMethod(str, clsArr);
        } catch (java.lang.Exception e) {
            declaredMethod = cls.getSuperclass() != null ? cls.getSuperclass().getDeclaredMethod(str, clsArr) : null;
            if (declaredMethod == null) {
                throw e;
            }
        }
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.Object[] objArr) {
        return a(obj, str, a(objArr), objArr);
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2) {
        return a(str, str2, (java.lang.Object[]) null);
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        return a(str, str2, objArr, a(objArr));
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr, java.lang.Class[] clsArr) throws java.lang.Exception {
        java.lang.reflect.Method declaredMethod;
        java.lang.Class<?> cls = java.lang.Class.forName(str);
        try {
            declaredMethod = cls.getDeclaredMethod(str2, clsArr);
        } catch (java.lang.Exception e) {
            declaredMethod = cls.getSuperclass() != null ? cls.getSuperclass().getDeclaredMethod(str2, clsArr) : null;
            if (declaredMethod == null) {
                throw e;
            }
        }
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(cls, objArr);
    }

    public static java.lang.Class[] a(java.lang.Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        java.lang.Class[] clsArr = new java.lang.Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] != null) {
                clsArr[i] = objArr[i].getClass();
            } else {
                clsArr[i] = java.lang.String.class;
            }
            if (clsArr[i] == java.lang.Integer.class) {
                clsArr[i] = java.lang.Integer.TYPE;
            } else if (clsArr[i] == java.lang.Boolean.class) {
                clsArr[i] = java.lang.Boolean.TYPE;
            } else if (clsArr[i] == java.lang.Long.class) {
                clsArr[i] = java.lang.Long.TYPE;
            }
        }
        return clsArr;
    }
}
