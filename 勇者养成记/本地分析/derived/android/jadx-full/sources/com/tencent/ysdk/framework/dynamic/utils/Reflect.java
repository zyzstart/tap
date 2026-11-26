package com.tencent.ysdk.framework.dynamic.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Reflect {
    private final boolean isClass = true;
    private final java.lang.Object object;

    private static class NULL {
        private NULL() {
        }
    }

    private Reflect(java.lang.Class cls) {
        this.object = cls;
    }

    private Reflect(java.lang.Object obj) {
        this.object = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static java.lang.reflect.AccessibleObject accessible(java.lang.reflect.AccessibleObject accessibleObject) {
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
    private java.lang.reflect.Method exactMethod(java.lang.String str, java.lang.Class[] clsArr) throws java.lang.NoSuchMethodException {
        java.lang.Class clsType = type();
        try {
            return clsType.getMethod(str, clsArr);
        } catch (java.lang.NoSuchMethodException unused) {
            do {
                try {
                    return clsType.getDeclaredMethod(str, clsArr);
                } catch (java.lang.NoSuchMethodException unused2) {
                    clsType = clsType.getSuperclass();
                }
            } while (clsType != null);
            throw new java.lang.NoSuchMethodException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.reflect.Field field0(java.lang.String str) {
        java.lang.Class clsType = type();
        try {
            return (java.lang.reflect.Field) accessible(clsType.getField(str));
        } catch (java.lang.NoSuchFieldException e) {
            do {
                try {
                    return (java.lang.reflect.Field) accessible(clsType.getDeclaredField(str));
                } catch (java.lang.NoSuchFieldException unused) {
                    clsType = clsType.getSuperclass();
                    if (clsType == null) {
                        throw new com.tencent.ysdk.framework.dynamic.exception.ReflectException(e);
                    }
                }
            } while (clsType == null);
            throw new com.tencent.ysdk.framework.dynamic.exception.ReflectException(e);
        }
    }

    private static java.lang.Class forName(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.Exception e) {
            throw new com.tencent.ysdk.framework.dynamic.exception.ReflectException(e);
        }
    }

    private static java.lang.Class forName(java.lang.String str, java.lang.ClassLoader classLoader) {
        try {
            return java.lang.Class.forName(str, true, classLoader);
        } catch (java.lang.Exception e) {
            throw new com.tencent.ysdk.framework.dynamic.exception.ReflectException(e);
        }
    }

    private boolean isSimilarSignature(java.lang.reflect.Method method, java.lang.String str, java.lang.Class[] clsArr) {
        return method.getName().equals(str) && match(method.getParameterTypes(), clsArr);
    }

    private boolean match(java.lang.Class[] clsArr, java.lang.Class[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != com.tencent.ysdk.framework.dynamic.utils.Reflect.NULL.class && !wrapper(clsArr[i]).isAssignableFrom(wrapper(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static com.tencent.ysdk.framework.dynamic.utils.Reflect on(java.lang.Class cls) {
        return new com.tencent.ysdk.framework.dynamic.utils.Reflect(cls);
    }

    public static com.tencent.ysdk.framework.dynamic.utils.Reflect on(java.lang.Object obj) {
        return new com.tencent.ysdk.framework.dynamic.utils.Reflect(obj);
    }

    public static com.tencent.ysdk.framework.dynamic.utils.Reflect on(java.lang.String str) {
        return on(forName(str));
    }

    public static com.tencent.ysdk.framework.dynamic.utils.Reflect on(java.lang.String str, java.lang.ClassLoader classLoader) {
        return on(forName(str, classLoader));
    }

    private static com.tencent.ysdk.framework.dynamic.utils.Reflect on(java.lang.reflect.Constructor constructor, java.lang.Object... objArr) {
        try {
            return on(((java.lang.reflect.Constructor) accessible(constructor)).newInstance(objArr));
        } catch (java.lang.Exception e) {
            throw new com.tencent.ysdk.framework.dynamic.exception.ReflectException(e);
        }
    }

    private static com.tencent.ysdk.framework.dynamic.utils.Reflect on(java.lang.reflect.Method method, java.lang.Object obj, java.lang.Object... objArr) {
        try {
            accessible(method);
            if (method.getReturnType() != java.lang.Void.TYPE) {
                return on(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return on(obj);
        } catch (java.lang.Exception e) {
            throw new com.tencent.ysdk.framework.dynamic.exception.ReflectException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String property(java.lang.String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.reflect.Method similarMethod(java.lang.String str, java.lang.Class[] clsArr) throws java.lang.NoSuchMethodException {
        java.lang.Class clsType = type();
        for (java.lang.reflect.Method method : clsType.getMethods()) {
            if (isSimilarSignature(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (java.lang.reflect.Method method2 : clsType.getDeclaredMethods()) {
                if (isSimilarSignature(method2, str, clsArr)) {
                    return method2;
                }
            }
            clsType = clsType.getSuperclass();
        } while (clsType != null);
        throw new java.lang.NoSuchMethodException("No similar method " + str + " with params " + java.util.Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    private static java.lang.Class[] types(java.lang.Object... objArr) {
        if (objArr == null) {
            return new java.lang.Class[0];
        }
        java.lang.Class[] clsArr = new java.lang.Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            clsArr[i] = obj == null ? com.tencent.ysdk.framework.dynamic.utils.Reflect.NULL.class : obj.getClass();
        }
        return clsArr;
    }

    private static java.lang.Object unwrap(java.lang.Object obj) {
        return obj instanceof com.tencent.ysdk.framework.dynamic.utils.Reflect ? ((com.tencent.ysdk.framework.dynamic.utils.Reflect) obj).get() : obj;
    }

    public static java.lang.Class wrapper(java.lang.Class cls) {
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

    public java.lang.Object as(java.lang.Class cls) {
        final boolean z = this.object instanceof java.util.Map;
        return java.lang.reflect.Proxy.newProxyInstance(cls.getClassLoader(), new java.lang.Class[]{cls}, new java.lang.reflect.InvocationHandler() { // from class: com.tencent.ysdk.framework.dynamic.utils.Reflect.1
            @Override // java.lang.reflect.InvocationHandler
            public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
                java.lang.String name = method.getName();
                try {
                    return com.tencent.ysdk.framework.dynamic.utils.Reflect.on(com.tencent.ysdk.framework.dynamic.utils.Reflect.this.object).call(name, objArr).get();
                } catch (com.tencent.ysdk.framework.dynamic.exception.ReflectException e) {
                    if (z) {
                        java.util.Map map = (java.util.Map) com.tencent.ysdk.framework.dynamic.utils.Reflect.this.object;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(com.tencent.ysdk.framework.dynamic.utils.Reflect.property(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(com.tencent.ysdk.framework.dynamic.utils.Reflect.property(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(com.tencent.ysdk.framework.dynamic.utils.Reflect.property(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e;
                }
            }
        });
    }

    public com.tencent.ysdk.framework.dynamic.utils.Reflect call(java.lang.String str) {
        return call(str, new java.lang.Object[0]);
    }

    public com.tencent.ysdk.framework.dynamic.utils.Reflect call(java.lang.String str, java.lang.Object... objArr) {
        java.lang.Class[] clsArrTypes = types(objArr);
        try {
            try {
                return on(exactMethod(str, clsArrTypes), this.object, objArr);
            } catch (java.lang.NoSuchMethodException e) {
                throw new com.tencent.ysdk.framework.dynamic.exception.ReflectException(e);
            }
        } catch (java.lang.NoSuchMethodException unused) {
            return on(similarMethod(str, clsArrTypes), this.object, objArr);
        }
    }

    public com.tencent.ysdk.framework.dynamic.utils.Reflect create() {
        return create(new java.lang.Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public com.tencent.ysdk.framework.dynamic.utils.Reflect create(java.lang.Object... objArr) {
        java.lang.Class[] clsArrTypes = types(objArr);
        try {
            return on(type().getDeclaredConstructor(clsArrTypes), objArr);
        } catch (java.lang.NoSuchMethodException e) {
            for (java.lang.reflect.Constructor<?> constructor : type().getDeclaredConstructors()) {
                if (match(constructor.getParameterTypes(), clsArrTypes)) {
                    return on(constructor, objArr);
                }
            }
            throw new com.tencent.ysdk.framework.dynamic.exception.ReflectException(e);
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.tencent.ysdk.framework.dynamic.utils.Reflect) {
            return this.object.equals(((com.tencent.ysdk.framework.dynamic.utils.Reflect) obj).get());
        }
        return false;
    }

    public com.tencent.ysdk.framework.dynamic.utils.Reflect field(java.lang.String str) {
        try {
            return on(field0(str).get(this.object));
        } catch (java.lang.Exception e) {
            throw new com.tencent.ysdk.framework.dynamic.exception.ReflectException(e);
        }
    }

    public java.util.Map fields() {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.lang.Class clsType = type();
        do {
            for (java.lang.reflect.Field field : clsType.getDeclaredFields()) {
                if ((!this.isClass) ^ java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    java.lang.String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, field(name));
                    }
                }
            }
            clsType = clsType.getSuperclass();
        } while (clsType != null);
        return linkedHashMap;
    }

    public java.lang.Object get() {
        return this.object;
    }

    public java.lang.Object get(java.lang.String str) {
        return field(str).get();
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public com.tencent.ysdk.framework.dynamic.utils.Reflect set(java.lang.String str, java.lang.Object obj) {
        try {
            java.lang.reflect.Field fieldField0 = field0(str);
            fieldField0.setAccessible(true);
            fieldField0.set(this.object, unwrap(obj));
            return this;
        } catch (java.lang.Exception e) {
            throw new com.tencent.ysdk.framework.dynamic.exception.ReflectException(e);
        }
    }

    public java.lang.String toString() {
        return this.object.toString();
    }

    public java.lang.Class type() {
        return this.isClass ? (java.lang.Class) this.object : this.object.getClass();
    }
}
