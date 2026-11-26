package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class ReflectionHelper {
    protected static boolean LOG = false;
    protected static final boolean LOGV = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.unity3d.player.ReflectionHelper.a[] f1584a = new com.unity3d.player.ReflectionHelper.a[4096];
    private static long b = 0;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile java.lang.reflect.Member f1586a;
        private final java.lang.Class b;
        private final java.lang.String c;
        private final java.lang.String d;
        private final int e;

        a(java.lang.Class cls, java.lang.String str, java.lang.String str2) {
            this.b = cls;
            this.c = str;
            this.d = str2;
            this.e = ((((this.b.hashCode() + 527) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof com.unity3d.player.ReflectionHelper.a) {
                com.unity3d.player.ReflectionHelper.a aVar = (com.unity3d.player.ReflectionHelper.a) obj;
                if (this.e == aVar.e && this.d.equals(aVar.d) && this.c.equals(aVar.c) && this.b.equals(aVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.e;
        }
    }

    ReflectionHelper() {
    }

    private static float a(java.lang.Class cls, java.lang.Class cls2) {
        if (cls.equals(cls2)) {
            return 1.0f;
        }
        if (cls.isPrimitive() || cls2.isPrimitive()) {
            return 0.0f;
        }
        try {
            if (cls.asSubclass(cls2) != null) {
                return 0.5f;
            }
        } catch (java.lang.ClassCastException unused) {
        }
        try {
            return cls2.asSubclass(cls) != null ? 0.1f : 0.0f;
        } catch (java.lang.ClassCastException unused2) {
            return 0.0f;
        }
    }

    private static float a(java.lang.Class cls, java.lang.Class[] clsArr, java.lang.Class[] clsArr2) {
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        int i = 0;
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float fA = 1.0f;
        if (clsArr != null) {
            int length = clsArr.length;
            int i2 = 0;
            while (i < length) {
                fA *= a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
        }
        return fA * a(cls, clsArr2[clsArr2.length - 1]);
    }

    private static java.lang.Class a(java.lang.String str, int[] iArr) {
        while (iArr[0] < str.length()) {
            int i = iArr[0];
            iArr[0] = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != '(' && cCharAt != ')') {
                if (cCharAt == 'L') {
                    int iIndexOf = str.indexOf(59, iArr[0]);
                    if (iIndexOf == -1) {
                        return null;
                    }
                    java.lang.String strSubstring = str.substring(iArr[0], iIndexOf);
                    iArr[0] = iIndexOf + 1;
                    try {
                        return java.lang.Class.forName(strSubstring.replace('/', '.'));
                    } catch (java.lang.ClassNotFoundException unused) {
                        return null;
                    }
                }
                if (cCharAt == 'Z') {
                    return java.lang.Boolean.TYPE;
                }
                if (cCharAt == 'I') {
                    return java.lang.Integer.TYPE;
                }
                if (cCharAt == 'F') {
                    return java.lang.Float.TYPE;
                }
                if (cCharAt == 'V') {
                    return java.lang.Void.TYPE;
                }
                if (cCharAt == 'B') {
                    return java.lang.Byte.TYPE;
                }
                if (cCharAt == 'C') {
                    return java.lang.Character.TYPE;
                }
                if (cCharAt == 'S') {
                    return java.lang.Short.TYPE;
                }
                if (cCharAt == 'J') {
                    return java.lang.Long.TYPE;
                }
                if (cCharAt == 'D') {
                    return java.lang.Double.TYPE;
                }
                if (cCharAt == '[') {
                    return java.lang.reflect.Array.newInstance((java.lang.Class<?>) a(str, iArr), 0).getClass();
                }
                com.unity3d.player.g.Log(5, "! parseType; " + cCharAt + " is not known!");
                return null;
            }
        }
        return null;
    }

    private static void a(com.unity3d.player.ReflectionHelper.a aVar, java.lang.reflect.Member member) {
        aVar.f1586a = member;
        f1584a[aVar.hashCode() & (f1584a.length - 1)] = aVar;
    }

    private static boolean a(com.unity3d.player.ReflectionHelper.a aVar) {
        com.unity3d.player.ReflectionHelper.a aVar2 = f1584a[aVar.hashCode() & (f1584a.length - 1)];
        if (!aVar.equals(aVar2)) {
            return false;
        }
        aVar.f1586a = aVar2.f1586a;
        return true;
    }

    private static java.lang.Class[] a(java.lang.String str) {
        java.lang.Class clsA;
        int i = 0;
        int[] iArr = {0};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (iArr[0] < str.length() && (clsA = a(str, iArr)) != null) {
            arrayList.add(clsA);
        }
        java.lang.Class[] clsArr = new java.lang.Class[arrayList.size()];
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            clsArr[i] = (java.lang.Class) it.next();
            i++;
        }
        return clsArr;
    }

    protected static void endUnityLaunch() {
        b++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static java.lang.reflect.Constructor getConstructorID(java.lang.Class cls, java.lang.String str) {
        java.lang.reflect.Constructor<?> constructor;
        com.unity3d.player.ReflectionHelper.a aVar = new com.unity3d.player.ReflectionHelper.a(cls, "", str);
        if (a(aVar)) {
            constructor = (java.lang.reflect.Constructor) aVar.f1586a;
        } else {
            java.lang.Class[] clsArrA = a(str);
            float f = 0.0f;
            java.lang.reflect.Constructor<?> constructor2 = null;
            for (java.lang.reflect.Constructor<?> constructor3 : cls.getConstructors()) {
                float fA = a(java.lang.Void.TYPE, constructor3.getParameterTypes(), clsArrA);
                if (fA > f) {
                    if (fA == 1.0f) {
                        constructor2 = constructor3;
                        break;
                    }
                    constructor2 = constructor3;
                    f = fA;
                }
            }
            a(aVar, constructor2);
            constructor = constructor2;
        }
        if (constructor != null) {
            return constructor;
        }
        throw new java.lang.NoSuchMethodError("<init>" + str + " in class " + cls.getName());
    }

    protected static java.lang.reflect.Field getFieldID(java.lang.Class cls, java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.reflect.Field field;
        java.lang.Class superclass = cls;
        com.unity3d.player.ReflectionHelper.a aVar = new com.unity3d.player.ReflectionHelper.a(superclass, str, str2);
        if (a(aVar)) {
            field = (java.lang.reflect.Field) aVar.f1586a;
        } else {
            java.lang.Class[] clsArrA = a(str2);
            float f = 0.0f;
            java.lang.reflect.Field field2 = null;
            while (superclass != null) {
                java.lang.reflect.Field[] declaredFields = superclass.getDeclaredFields();
                int length = declaredFields.length;
                java.lang.reflect.Field field3 = field2;
                float f2 = f;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        f = f2;
                        field2 = field3;
                        break;
                    }
                    java.lang.reflect.Field field4 = declaredFields[i];
                    if (z == java.lang.reflect.Modifier.isStatic(field4.getModifiers()) && field4.getName().compareTo(str) == 0) {
                        float fA = a(field4.getType(), (java.lang.Class[]) null, clsArrA);
                        if (fA > f2) {
                            if (fA == 1.0f) {
                                field2 = field4;
                                f = fA;
                                break;
                            }
                            field3 = field4;
                            f2 = fA;
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (f == 1.0f || superclass.isPrimitive() || superclass.isInterface() || superclass.equals(java.lang.Object.class) || superclass.equals(java.lang.Void.TYPE)) {
                    break;
                }
                superclass = superclass.getSuperclass();
            }
            a(aVar, field2);
            field = field2;
        }
        if (field != null) {
            return field;
        }
        java.lang.Object[] objArr = new java.lang.Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = superclass.getName();
        throw new java.lang.NoSuchFieldError(java.lang.String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    protected static java.lang.reflect.Method getMethodID(java.lang.Class cls, java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.reflect.Method method;
        com.unity3d.player.ReflectionHelper.a aVar = new com.unity3d.player.ReflectionHelper.a(cls, str, str2);
        if (a(aVar)) {
            method = (java.lang.reflect.Method) aVar.f1586a;
        } else {
            java.lang.Class[] clsArrA = a(str2);
            float f = 0.0f;
            java.lang.reflect.Method method2 = null;
            while (cls != null) {
                java.lang.reflect.Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                java.lang.reflect.Method method3 = method2;
                float f2 = f;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        f = f2;
                        method2 = method3;
                        break;
                    }
                    java.lang.reflect.Method method4 = declaredMethods[i];
                    if (z == java.lang.reflect.Modifier.isStatic(method4.getModifiers()) && method4.getName().compareTo(str) == 0) {
                        float fA = a(method4.getReturnType(), method4.getParameterTypes(), clsArrA);
                        if (fA > f2) {
                            if (fA == 1.0f) {
                                method2 = method4;
                                f = fA;
                                break;
                            }
                            method3 = method4;
                            f2 = fA;
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(java.lang.Object.class) || cls.equals(java.lang.Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            a(aVar, method2);
            method = method2;
        }
        if (method != null) {
            return method;
        }
        java.lang.Object[] objArr = new java.lang.Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new java.lang.NoSuchMethodError(java.lang.String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyFinalize(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native java.lang.Object nativeProxyInvoke(int i, java.lang.String str, java.lang.Object[] objArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyLogJNIInvokeException();

    protected static java.lang.Object newProxyInstance(int i, java.lang.Class cls) {
        return newProxyInstance(i, new java.lang.Class[]{cls});
    }

    protected static java.lang.Object newProxyInstance(final int i, final java.lang.Class[] clsArr) {
        return java.lang.reflect.Proxy.newProxyInstance(com.unity3d.player.ReflectionHelper.class.getClassLoader(), clsArr, new java.lang.reflect.InvocationHandler() { // from class: com.unity3d.player.ReflectionHelper.1
            private long c = com.unity3d.player.ReflectionHelper.b;

            private static java.lang.Object a(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.NoSuchMethodException {
                if (objArr == null) {
                    try {
                        objArr = new java.lang.Object[0];
                    } catch (java.lang.NoClassDefFoundError unused) {
                        com.unity3d.player.g.Log(6, java.lang.String.format("Java interface default methods are only supported since Android Oreo", new java.lang.Object[0]));
                        com.unity3d.player.ReflectionHelper.nativeProxyLogJNIInvokeException();
                        return null;
                    }
                }
                java.lang.Class<?> declaringClass = method.getDeclaringClass();
                java.lang.reflect.Constructor declaredConstructor = java.lang.invoke.MethodHandles.Lookup.class.getDeclaredConstructor(java.lang.Class.class, java.lang.Integer.TYPE);
                declaredConstructor.setAccessible(true);
                return ((java.lang.invoke.MethodHandles.Lookup) declaredConstructor.newInstance(declaringClass, 2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
            }

            protected final void finalize() throws java.lang.Throwable {
                try {
                    if (this.c == com.unity3d.player.ReflectionHelper.b) {
                        com.unity3d.player.ReflectionHelper.nativeProxyFinalize(i);
                    }
                } finally {
                    super.finalize();
                }
            }

            @Override // java.lang.reflect.InvocationHandler
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
                if (this.c != com.unity3d.player.ReflectionHelper.b) {
                    com.unity3d.player.g.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
                    return null;
                }
                java.lang.Object objNativeProxyInvoke = com.unity3d.player.ReflectionHelper.nativeProxyInvoke(i, method.getName(), objArr);
                if (objNativeProxyInvoke == null) {
                    if ((method.getModifiers() & 1024) == 0) {
                        return a(obj, method, objArr);
                    }
                    com.unity3d.player.ReflectionHelper.nativeProxyLogJNIInvokeException();
                }
                return objNativeProxyInvoke;
            }
        });
    }
}
