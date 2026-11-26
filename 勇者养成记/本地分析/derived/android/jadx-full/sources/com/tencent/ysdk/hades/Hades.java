package com.tencent.ysdk.hades;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class Hades {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.List f1388a = new java.util.LinkedList();

    static {
        try {
            java.lang.System.loadLibrary("hades_lib");
            init(android.os.Build.VERSION.SDK_INT);
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int a(java.lang.String str) throws java.lang.Exception {
        int i = 0;
        try {
            if (str.charAt(0) != '(') {
                throw new java.lang.Exception("Invalid method signature: " + str);
            }
            int iB = 1;
            while (str.charAt(iB) != ')') {
                iB += b(str.substring(iB));
                i++;
            }
            return i;
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            throw new java.lang.Exception("Invalid method signature: " + str, e);
        }
    }

    private static void a(dalvik.system.DexClassLoader dexClassLoader, java.lang.String str, java.lang.ClassLoader classLoader) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str, true, dexClassLoader);
            java.lang.reflect.Method method = null;
            java.lang.String str2 = (java.lang.String) cls.getField("className").get(null);
            java.lang.String str3 = (java.lang.String) cls.getField("methodName").get(null);
            java.lang.String str4 = (java.lang.String) cls.getField("methodSig").get(null);
            if (str2 != null && !str2.equals("")) {
                java.lang.Class<?> cls2 = java.lang.Class.forName(str2, true, classLoader);
                java.lang.reflect.Modifier.isAbstract(cls2.getModifiers());
                java.lang.reflect.Method method2 = null;
                for (java.lang.reflect.Method method3 : cls.getDeclaredMethods()) {
                    if (method3.getName().equals("method") && java.lang.reflect.Modifier.isStatic(method3.getModifiers())) {
                        method = method3;
                    } else if (method3.getName().equals("origin") && java.lang.reflect.Modifier.isStatic(method3.getModifiers())) {
                        method2 = method3;
                    }
                }
                if (method == null) {
                    return;
                }
                a(cls2, str3, str4, method, method2);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private static void a(java.lang.Class cls, java.lang.String str, java.lang.String str2, java.lang.reflect.Method method, java.lang.reflect.Method method2) {
        try {
            find(cls, str, str2, method.getParameterTypes().length == a(str2), method, method2);
        } catch (java.lang.Exception unused) {
        }
    }

    public static void a(java.lang.String str, dalvik.system.DexClassLoader dexClassLoader, java.lang.ClassLoader classLoader) throws java.lang.ClassNotFoundException {
        java.lang.Class<?> cls = java.lang.Class.forName(str, true, dexClassLoader);
        for (java.lang.String str2 : (java.lang.String[]) cls.getField("classNames").get(null)) {
            a(dexClassLoader, str2, classLoader);
        }
        f1388a.add(cls);
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            java.lang.ClassLoader classLoader = context.getClassLoader();
            if (new java.io.File(str).exists()) {
                a(str2, new dalvik.system.DexClassLoader(str, context.getApplicationInfo().dataDir, null, classLoader), classLoader);
                return true;
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    private static int b(java.lang.String str) throws java.lang.Exception {
        switch (str.charAt(0)) {
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'I':
            case 'J':
            case 'S':
            case 'V':
            case 'Z':
                return 1;
            case 'L':
                int i = 1;
                while (str.charAt(i) != ';') {
                    i++;
                }
                return 1 + i;
            case '[':
                return 1 + b(str.substring(1));
            default:
                throw new java.lang.Exception("Invalid type: " + str);
        }
    }

    public static native void find(java.lang.Class cls, java.lang.String str, java.lang.String str2, boolean z, java.lang.reflect.Method method, java.lang.reflect.Method method2);

    public static native void init(int i);
}
