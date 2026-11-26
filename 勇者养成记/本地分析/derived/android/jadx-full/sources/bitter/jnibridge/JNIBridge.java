package bitter.jnibridge;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JNIBridge {

    private static class a implements java.lang.reflect.InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private java.lang.Object f0a = new java.lang.Object[0];
        private long b;
        private java.lang.reflect.Constructor c;

        public a(long j) {
            this.b = j;
            try {
                this.c = java.lang.invoke.MethodHandles.Lookup.class.getDeclaredConstructor(java.lang.Class.class, java.lang.Integer.TYPE);
                this.c.setAccessible(true);
            } catch (java.lang.NoClassDefFoundError unused) {
                this.c = null;
            } catch (java.lang.NoSuchMethodException unused2) {
                this.c = null;
            }
        }

        private java.lang.Object a(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
            if (objArr == null) {
                objArr = new java.lang.Object[0];
            }
            java.lang.Class<?> declaringClass = method.getDeclaringClass();
            return ((java.lang.invoke.MethodHandles.Lookup) this.c.newInstance(declaringClass, 2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
        }

        public final void a() {
            synchronized (this.f0a) {
                this.b = 0L;
            }
        }

        public final void finalize() {
            synchronized (this.f0a) {
                if (this.b == 0) {
                    return;
                }
                bitter.jnibridge.JNIBridge.delete(this.b);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public final java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
            synchronized (this.f0a) {
                if (this.b == 0) {
                    return null;
                }
                try {
                    return bitter.jnibridge.JNIBridge.invoke(this.b, method.getDeclaringClass(), method, objArr);
                } catch (java.lang.NoSuchMethodError e) {
                    if (this.c == null) {
                        java.lang.System.err.println("JNIBridge error: Java interface default methods are only supported since Android Oreo");
                        throw e;
                    }
                    if ((method.getModifiers() & 1024) == 0) {
                        return a(obj, method, objArr);
                    }
                    throw e;
                }
            }
        }
    }

    static native void delete(long j);

    static void disableInterfaceProxy(java.lang.Object obj) {
        if (obj != null) {
            ((bitter.jnibridge.JNIBridge.a) java.lang.reflect.Proxy.getInvocationHandler(obj)).a();
        }
    }

    static native java.lang.Object invoke(long j, java.lang.Class cls, java.lang.reflect.Method method, java.lang.Object[] objArr);

    static java.lang.Object newInterfaceProxy(long j, java.lang.Class[] clsArr) {
        return java.lang.reflect.Proxy.newProxyInstance(bitter.jnibridge.JNIBridge.class.getClassLoader(), clsArr, new bitter.jnibridge.JNIBridge.a(j));
    }
}
