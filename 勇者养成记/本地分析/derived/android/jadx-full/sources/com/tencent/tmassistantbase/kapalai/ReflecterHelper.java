package com.tencent.tmassistantbase.kapalai;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ReflecterHelper {
    public static java.lang.Class mCurrentClass;

    private static java.lang.Class[] getArgsClasses(java.lang.Object[] objArr) {
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

    private static final java.lang.reflect.Field getField(java.lang.String str) {
        java.lang.reflect.Field declaredField = null;
        try {
            declaredField = mCurrentClass.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (java.lang.NoSuchFieldException e) {
            e.printStackTrace();
            return declaredField;
        } catch (java.lang.SecurityException e2) {
            e2.printStackTrace();
            return declaredField;
        }
    }

    public static final int getIntValue(java.lang.Object obj, java.lang.String str, int i) {
        setClass(obj.getClass().getName());
        java.lang.reflect.Field field = getField(str);
        if (field == null) {
            return i;
        }
        try {
            return field.getInt(obj);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
            return i;
        } catch (java.lang.IllegalArgumentException e2) {
            e2.printStackTrace();
            return i;
        }
    }

    public static java.lang.Object getProperty(java.lang.Object obj, java.lang.String str) throws java.lang.NoSuchFieldException {
        java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static final int getStaticIntValue(java.lang.String str, int i) {
        java.lang.reflect.Field field = getField(str);
        if (field == null) {
            return i;
        }
        try {
            return field.getInt(null);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
            return i;
        } catch (java.lang.IllegalArgumentException e2) {
            e2.printStackTrace();
            return i;
        }
    }

    public static java.lang.Object getStaticProperty(java.lang.String str, java.lang.String str2) {
        setClass(str);
        java.lang.reflect.Field field = getField(str2);
        if (field == null) {
            return null;
        }
        try {
            return field.get(null);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object invokeMethod(java.lang.Object obj, java.lang.String str) {
        return invokeMethod(obj, str, null);
    }

    public static java.lang.Object invokeMethod(java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) throws java.lang.Exception {
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

    public static java.lang.Object invokeMethod(java.lang.Object obj, java.lang.String str, java.lang.Object[] objArr) {
        return invokeMethod(obj, str, getArgsClasses(objArr), objArr);
    }

    public static java.lang.Object invokeStaticMethod(java.lang.String str, java.lang.String str2) {
        return invokeStaticMethod(str, str2, null);
    }

    public static java.lang.Object invokeStaticMethod(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        return invokeStaticMethod(str, str2, objArr, getArgsClasses(objArr));
    }

    public static java.lang.Object invokeStaticMethod(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr, java.lang.Class[] clsArr) throws java.lang.Exception {
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

    public static java.lang.Object newInstance(java.lang.String str) {
        return newInstance(str, null);
    }

    public static java.lang.Object newInstance(java.lang.String str, java.lang.Object[] objArr) throws java.lang.NoSuchMethodException {
        java.lang.reflect.Constructor<?> declaredConstructor = java.lang.Class.forName(str).getDeclaredConstructor(getArgsClasses(objArr));
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(objArr);
    }

    public static java.lang.Object newInstance(java.lang.String str, java.lang.Object[] objArr, java.lang.Class[] clsArr) throws java.lang.NoSuchMethodException {
        java.lang.reflect.Constructor<?> declaredConstructor = java.lang.Class.forName(str).getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(objArr);
    }

    public static final boolean setClass(java.lang.String str) {
        java.lang.Class<?> cls;
        try {
            cls = java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        mCurrentClass = cls;
        return cls != null;
    }

    public static void setProperty(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static void setStaticProperty(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        setClass(str);
        java.lang.reflect.Field field = getField(str2);
        if (field != null) {
            try {
                field.set(null, obj);
            } catch (java.lang.IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}
