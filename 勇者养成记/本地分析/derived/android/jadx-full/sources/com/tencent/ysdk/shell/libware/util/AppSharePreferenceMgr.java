package com.tencent.ysdk.shell.libware.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AppSharePreferenceMgr {
    public static final java.lang.String FILE_NAME = "sp_data";

    private static class SharedPreferencesCompat {
        private static final java.lang.reflect.Method sApplyMethod = findApplyMethod();

        private SharedPreferencesCompat() {
        }

        public static void apply(android.content.SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor, new java.lang.Object[0]);
                    return;
                }
            } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException unused) {
            }
            editor.commit();
        }

        private static java.lang.reflect.Method findApplyMethod() {
            try {
                return android.content.SharedPreferences.Editor.class.getMethod("apply", new java.lang.Class[0]);
            } catch (java.lang.NoSuchMethodException unused) {
                return null;
            }
        }
    }

    public static void clear() {
        android.content.SharedPreferences.Editor editorEdit = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getSharedPreferences(FILE_NAME, 0).edit();
        editorEdit.clear();
        com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.SharedPreferencesCompat.apply(editorEdit);
    }

    public static boolean contains(java.lang.String str) {
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getSharedPreferences(FILE_NAME, 0).contains(str);
    }

    public static java.lang.Object get(java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences sharedPreferences = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getSharedPreferences(FILE_NAME, 0);
        if (obj instanceof java.lang.String) {
            return sharedPreferences.getString(str, (java.lang.String) obj);
        }
        if (obj instanceof java.lang.Integer) {
            return java.lang.Integer.valueOf(sharedPreferences.getInt(str, ((java.lang.Integer) obj).intValue()));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Boolean.valueOf(sharedPreferences.getBoolean(str, ((java.lang.Boolean) obj).booleanValue()));
        }
        if (obj instanceof java.lang.Float) {
            return java.lang.Float.valueOf(sharedPreferences.getFloat(str, ((java.lang.Float) obj).floatValue()));
        }
        if (obj instanceof java.lang.Long) {
            return java.lang.Long.valueOf(sharedPreferences.getLong(str, ((java.lang.Long) obj).longValue()));
        }
        return null;
    }

    public static java.util.Map<java.lang.String, ?> getAll() {
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getSharedPreferences(FILE_NAME, 0).getAll();
    }

    public static void put(java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences.Editor editorEdit = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getSharedPreferences(FILE_NAME, 0).edit();
        if (obj instanceof java.lang.String) {
            editorEdit.putString(str, (java.lang.String) obj);
        } else if (obj instanceof java.lang.Integer) {
            editorEdit.putInt(str, ((java.lang.Integer) obj).intValue());
        } else if (obj instanceof java.lang.Boolean) {
            editorEdit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
        } else if (obj instanceof java.lang.Float) {
            editorEdit.putFloat(str, ((java.lang.Float) obj).floatValue());
        } else if (obj instanceof java.lang.Long) {
            editorEdit.putLong(str, ((java.lang.Long) obj).longValue());
        } else {
            editorEdit.putString(str, obj.toString());
        }
        com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.SharedPreferencesCompat.apply(editorEdit);
    }

    public static void remove(java.lang.String str) {
        android.content.SharedPreferences.Editor editorEdit = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getSharedPreferences(FILE_NAME, 0).edit();
        editorEdit.remove(str);
        com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.SharedPreferencesCompat.apply(editorEdit);
    }
}
