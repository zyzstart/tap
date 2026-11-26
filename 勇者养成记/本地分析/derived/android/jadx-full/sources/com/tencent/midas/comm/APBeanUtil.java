package com.tencent.midas.comm;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APBeanUtil {
    public static void copyProperties(java.lang.Object obj, java.lang.Object obj2) {
        try {
            copyPropertiesExclude(obj, obj2, null, true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyPropertiesExclude(java.lang.Object obj, java.lang.Object obj2, java.lang.String[] strArr, boolean z) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method[] declaredMethods;
        java.lang.reflect.Method[] declaredMethods2;
        java.lang.Object objInvoke;
        java.util.List listAsList = (strArr == null || strArr.length <= 0) ? null : java.util.Arrays.asList(strArr);
        if (z) {
            declaredMethods = obj.getClass().getMethods();
            declaredMethods2 = obj2.getClass().getMethods();
        } else {
            declaredMethods = obj.getClass().getDeclaredMethods();
            declaredMethods2 = obj2.getClass().getDeclaredMethods();
        }
        for (java.lang.reflect.Method method : declaredMethods) {
            java.lang.String name = method.getName();
            if (name.contains("get") && (listAsList == null || !listAsList.contains(name.substring(3).toLowerCase()))) {
                java.lang.reflect.Method methodFindMethodByName = findMethodByName(declaredMethods2, "set" + name.substring(3));
                if (methodFindMethodByName != null && (objInvoke = method.invoke(obj, new java.lang.Object[0])) != null && (!(objInvoke instanceof java.util.Collection) || ((java.util.Collection) objInvoke).size() > 0)) {
                    methodFindMethodByName.invoke(obj2, objInvoke);
                }
            }
        }
    }

    public static void copyPropertiesInclude(java.lang.Object obj, java.lang.Object obj2, java.lang.String[] strArr, boolean z) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method[] declaredMethods;
        java.lang.reflect.Method[] declaredMethods2;
        java.lang.Object objInvoke;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        java.util.List listAsList = java.util.Arrays.asList(strArr);
        if (z) {
            declaredMethods = obj.getClass().getMethods();
            declaredMethods2 = obj2.getClass().getMethods();
        } else {
            declaredMethods = obj.getClass().getDeclaredMethods();
            declaredMethods2 = obj2.getClass().getDeclaredMethods();
        }
        for (java.lang.reflect.Method method : declaredMethods) {
            java.lang.String name = method.getName();
            if (name.contains("get")) {
                java.lang.String strSubstring = name.substring(3);
                if (listAsList.contains(strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1))) {
                    java.lang.reflect.Method methodFindMethodByName = findMethodByName(declaredMethods2, "set" + name.substring(3));
                    if (methodFindMethodByName != null && (objInvoke = method.invoke(obj, new java.lang.Object[0])) != null && (!(objInvoke instanceof java.util.Collection) || ((java.util.Collection) objInvoke).size() > 0)) {
                        methodFindMethodByName.invoke(obj2, objInvoke);
                    }
                }
            }
        }
    }

    public static java.lang.reflect.Method findMethodByName(java.lang.reflect.Method[] methodArr, java.lang.String str) {
        for (int i = 0; i < methodArr.length; i++) {
            if (methodArr[i].getName().equals(str)) {
                return methodArr[i];
            }
        }
        return null;
    }
}
