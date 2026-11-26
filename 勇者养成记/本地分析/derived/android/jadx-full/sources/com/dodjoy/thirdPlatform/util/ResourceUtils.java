package com.dodjoy.thirdPlatform.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ResourceUtils {
    public static int getAnimId(android.content.Context context, java.lang.String str) {
        return context.getResources().getIdentifier(str, "anim", context.getPackageName());
    }

    public static int getColorId(android.content.Context context, java.lang.String str) {
        return context.getResources().getIdentifier(str, "color", context.getPackageName());
    }

    public static int getDimen(android.content.Context context, java.lang.String str) {
        return context.getResources().getIdentifier(str, "dimen", context.getPackageName());
    }

    public static int getDrawableId(android.content.Context context, java.lang.String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    public static int getId(android.content.Context context, java.lang.String str) {
        return context.getResources().getIdentifier(str, "id", context.getPackageName());
    }

    public static int getLayoutId(android.content.Context context, java.lang.String str) {
        return context.getResources().getIdentifier(str, "layout", context.getPackageName());
    }

    private static java.lang.Object getResourceId(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Class<?>[] classes = java.lang.Class.forName(context.getPackageName() + ".R").getClasses();
            for (int i = 0; i < classes.length; i++) {
                if (classes[i].getSimpleName().equals(str2)) {
                    java.lang.reflect.Field[] fields = classes[i].getFields();
                    for (int i2 = 0; i2 < fields.length; i2++) {
                        if (fields[i2].getName().equals(str)) {
                            java.lang.System.out.println(str);
                            return fields[i2].get(null);
                        }
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getStringId(android.content.Context context, java.lang.String str) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    public static int getStyleId(android.content.Context context, java.lang.String str) {
        return context.getResources().getIdentifier(str, "style", context.getPackageName());
    }

    public static int getStyleable(android.content.Context context, java.lang.String str) {
        return ((java.lang.Integer) getResourceId(context, str, "styleable")).intValue();
    }

    public static int[] getStyleableArray(android.content.Context context, java.lang.String str) {
        return (int[]) getResourceId(context, str, "styleable");
    }

    public static java.lang.Object getStyleableId(android.content.Context context, java.lang.String str) {
        return java.lang.Integer.valueOf(context.getResources().getIdentifier(str, "styleable", context.getPackageName()));
    }
}
