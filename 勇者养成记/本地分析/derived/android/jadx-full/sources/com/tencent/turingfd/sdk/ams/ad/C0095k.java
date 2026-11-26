package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class C0095k {
    public static java.util.HashMap<java.lang.String, java.lang.Class<?>> ia = new java.util.HashMap<>();
    public static java.util.HashMap<java.lang.Class<?>, java.util.HashMap<java.lang.String, java.lang.reflect.Method>> ja;

    static {
        new java.util.HashMap();
        ja = new java.util.HashMap<>();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0023  */
    /* JADX WARN: Code duplicated, block: B:16:0x0024 A[Catch: Throwable -> 0x0029, TRY_LEAVE, TryCatch #1 {Throwable -> 0x0029, blocks: (B:13:0x001d, B:16:0x0024), top: B:25:0x001d, outer: #0 }] */
    public static java.lang.Object a(java.lang.String str, java.lang.String str2, java.lang.Class<?>[] clsArr, java.lang.Object obj, java.lang.Object[] objArr) {
        java.lang.reflect.Method methodA;
        java.lang.Object objInvoke = null;
        try {
            try {
                java.lang.Class<?> cls = ia.get(str);
                if (cls == null) {
                    cls = java.lang.Class.forName(str);
                }
                if (cls != null) {
                    ia.put(str, cls);
                    methodA = a(cls, str2, clsArr);
                    if (methodA == null) {
                        return null;
                    }
                    objInvoke = methodA.invoke(obj, objArr);
                    return objInvoke;
                }
                cls = null;
                try {
                    methodA = a(cls, str2, clsArr);
                    if (methodA == null) {
                        return null;
                    }
                    objInvoke = methodA.invoke(obj, objArr);
                    return objInvoke;
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        } catch (java.lang.Throwable th3) {
            th3.printStackTrace();
            return objInvoke;
        }
    }

    public static java.lang.reflect.Method a(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        if (cls != null) {
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
                    if (clsArr != null) {
                        for (java.lang.Class<?> cls2 : clsArr) {
                            stringBuffer.append("+");
                            stringBuffer.append(cls2.getName());
                        }
                    }
                    java.lang.String string = stringBuffer.toString();
                    java.util.HashMap<java.lang.String, java.lang.reflect.Method> map = ja.get(cls);
                    if (map == null) {
                        map = new java.util.HashMap<>();
                        ja.put(cls, map);
                    }
                    java.lang.reflect.Method declaredMethod = map.get(string);
                    if (declaredMethod == null) {
                        declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    }
                    if (declaredMethod == null) {
                        return null;
                    }
                    declaredMethod.setAccessible(true);
                    map.put(string, declaredMethod);
                    return declaredMethod;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
