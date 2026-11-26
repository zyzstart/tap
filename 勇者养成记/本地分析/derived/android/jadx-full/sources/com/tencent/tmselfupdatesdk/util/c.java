package com.tencent.tmselfupdatesdk.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.Object f1174a;
    private final boolean b = true;

    private c(java.lang.Class cls) {
        this.f1174a = cls;
    }

    private c(java.lang.Object obj) {
        this.f1174a = obj;
    }

    public static com.tencent.tmselfupdatesdk.util.c a(java.lang.Class cls) {
        return new com.tencent.tmselfupdatesdk.util.c(cls);
    }

    public static com.tencent.tmselfupdatesdk.util.c a(java.lang.Object obj) {
        return new com.tencent.tmselfupdatesdk.util.c(obj);
    }

    public static com.tencent.tmselfupdatesdk.util.c a(java.lang.String str) {
        return a(f(str));
    }

    private static com.tencent.tmselfupdatesdk.util.c a(java.lang.reflect.Method method, java.lang.Object obj, java.lang.Object... objArr) {
        try {
            a((java.lang.reflect.AccessibleObject) method);
            if (method.getReturnType() != java.lang.Void.TYPE) {
                return a(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return a(obj);
        } catch (java.lang.Exception e) {
            throw new com.tencent.tmselfupdatesdk.util.ReflectException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static java.lang.reflect.AccessibleObject a(java.lang.reflect.AccessibleObject accessibleObject) {
        if (accessibleObject == 0) {
            return null;
        }
        if (accessibleObject instanceof java.lang.reflect.Member) {
            java.lang.reflect.Member member = (java.lang.reflect.Member) accessibleObject;
            if (java.lang.reflect.Modifier.isPublic(member.getModifiers()) && java.lang.reflect.Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return accessibleObject;
            }
        }
        if (!accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
        }
        return accessibleObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.reflect.Method a(java.lang.String str, java.lang.Class[] clsArr) throws java.lang.NoSuchMethodException {
        java.lang.Class clsB = b();
        try {
            return clsB.getMethod(str, clsArr);
        } catch (java.lang.NoSuchMethodException unused) {
            do {
                try {
                    return clsB.getDeclaredMethod(str, clsArr);
                } catch (java.lang.NoSuchMethodException unused2) {
                    clsB = clsB.getSuperclass();
                }
            } while (clsB != null);
            throw new java.lang.NoSuchMethodException();
        }
    }

    private boolean a(java.lang.reflect.Method method, java.lang.String str, java.lang.Class[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(java.lang.Class[] clsArr, java.lang.Class[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != com.tencent.tmselfupdatesdk.util.d.class && !b(clsArr[i]).isAssignableFrom(b(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    private static java.lang.Class[] a(java.lang.Object... objArr) {
        if (objArr == null) {
            return new java.lang.Class[0];
        }
        java.lang.Class[] clsArr = new java.lang.Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            clsArr[i] = obj == null ? com.tencent.tmselfupdatesdk.util.d.class : obj.getClass();
        }
        return clsArr;
    }

    public static java.lang.Class b(java.lang.Class cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (java.lang.Boolean.TYPE == cls) {
            return java.lang.Boolean.class;
        }
        if (java.lang.Integer.TYPE == cls) {
            return java.lang.Integer.class;
        }
        if (java.lang.Long.TYPE == cls) {
            return java.lang.Long.class;
        }
        if (java.lang.Short.TYPE == cls) {
            return java.lang.Short.class;
        }
        if (java.lang.Byte.TYPE == cls) {
            return java.lang.Byte.class;
        }
        if (java.lang.Double.TYPE == cls) {
            return java.lang.Double.class;
        }
        if (java.lang.Float.TYPE == cls) {
            return java.lang.Float.class;
        }
        if (java.lang.Character.TYPE == cls) {
            return java.lang.Character.class;
        }
        return java.lang.Void.TYPE == cls ? java.lang.Void.class : cls;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.reflect.Method b(java.lang.String str, java.lang.Class[] clsArr) throws java.lang.NoSuchMethodException {
        java.lang.Class clsB = b();
        for (java.lang.reflect.Method method : clsB.getMethods()) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (java.lang.reflect.Method method2 : clsB.getDeclaredMethods()) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            clsB = clsB.getSuperclass();
        } while (clsB != null);
        throw new java.lang.NoSuchMethodException("No similar method " + str + " with params " + java.util.Arrays.toString(clsArr) + " could be found on type " + b() + ".");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.reflect.Field e(java.lang.String str) {
        java.lang.Class clsB = b();
        try {
            return (java.lang.reflect.Field) a((java.lang.reflect.AccessibleObject) clsB.getField(str));
        } catch (java.lang.NoSuchFieldException e) {
            do {
                try {
                    return (java.lang.reflect.Field) a((java.lang.reflect.AccessibleObject) clsB.getDeclaredField(str));
                } catch (java.lang.NoSuchFieldException unused) {
                    clsB = clsB.getSuperclass();
                    if (clsB == null) {
                        throw new com.tencent.tmselfupdatesdk.util.ReflectException(e);
                    }
                }
            } while (clsB == null);
            throw new com.tencent.tmselfupdatesdk.util.ReflectException(e);
        }
    }

    private static java.lang.Class f(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.Exception e) {
            throw new com.tencent.tmselfupdatesdk.util.ReflectException(e);
        }
    }

    public com.tencent.tmselfupdatesdk.util.c a(java.lang.String str, java.lang.Object... objArr) {
        java.lang.Class[] clsArrA = a(objArr);
        try {
            try {
                return a(a(str, clsArrA), this.f1174a, objArr);
            } catch (java.lang.NoSuchMethodException e) {
                throw new com.tencent.tmselfupdatesdk.util.ReflectException(e);
            }
        } catch (java.lang.NoSuchMethodException unused) {
            return a(b(str, clsArrA), this.f1174a, objArr);
        }
    }

    public java.lang.Object a() {
        return this.f1174a;
    }

    public java.lang.Class b() {
        return this.b ? (java.lang.Class) this.f1174a : this.f1174a.getClass();
    }

    public java.lang.Object b(java.lang.String str) {
        return c(str).a();
    }

    public com.tencent.tmselfupdatesdk.util.c c(java.lang.String str) {
        try {
            return a(e(str).get(this.f1174a));
        } catch (java.lang.Exception e) {
            throw new com.tencent.tmselfupdatesdk.util.ReflectException(e);
        }
    }

    public com.tencent.tmselfupdatesdk.util.c d(java.lang.String str) {
        return a(str, new java.lang.Object[0]);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.tencent.tmselfupdatesdk.util.c) {
            return this.f1174a.equals(((com.tencent.tmselfupdatesdk.util.c) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f1174a.hashCode();
    }

    public java.lang.String toString() {
        return this.f1174a.toString();
    }
}
