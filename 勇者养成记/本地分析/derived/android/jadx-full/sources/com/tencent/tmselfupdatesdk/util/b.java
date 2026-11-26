package com.tencent.tmselfupdatesdk.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    public static java.lang.Object a(java.lang.ClassLoader classLoader, java.lang.Object obj) {
        java.util.HashSet hashSet = new java.util.HashSet();
        a(obj.getClass(), hashSet);
        int size = hashSet.size();
        java.lang.Class[] clsArr = new java.lang.Class[size];
        hashSet.toArray(clsArr);
        java.lang.Class[] clsArr2 = new java.lang.Class[hashSet.size()];
        for (int i = 0; i < size; i++) {
            try {
                clsArr2[i] = classLoader.loadClass(clsArr[i].getName());
            } catch (java.lang.Throwable th) {
                com.tencent.tmassistantbase.util.x.b("PatchUtil", "generateProxyObject exception!!");
                th.printStackTrace();
            }
        }
        return java.lang.reflect.Proxy.newProxyInstance(classLoader, clsArr2, new com.tencent.tmselfupdatesdk.b.a(obj));
    }

    public static void a(java.lang.Class cls, java.util.HashSet hashSet) {
        java.lang.Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length != 0) {
            hashSet.addAll(java.util.Arrays.asList(interfaces));
        }
        if (cls.getSuperclass() != java.lang.Object.class) {
            a(cls.getSuperclass(), hashSet);
        }
    }
}
