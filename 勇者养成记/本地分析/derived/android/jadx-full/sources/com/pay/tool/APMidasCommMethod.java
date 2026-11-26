package com.pay.tool;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMidasCommMethod {
    private static java.util.Stack activityStack;

    public static java.lang.String MaptoString(java.util.HashMap map) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.util.Map.Entry entry : map.entrySet()) {
            stringBuffer.append((java.lang.String) entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append((java.lang.String) entry.getValue());
            stringBuffer.append("&");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static java.lang.String MaptoString(java.util.HashMap map, java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.util.Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            stringBuffer.append((java.lang.String) ((java.util.Map.Entry) it.next()).getValue());
            stringBuffer.append(str);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static java.lang.String dealString(java.lang.String str) {
        java.lang.StringBuilder sb;
        int length;
        int i;
        java.lang.String strRawString = rawString(str);
        if (strRawString.length() <= 3) {
            return str;
        }
        if (strRawString.length() > 3 && strRawString.length() <= 6) {
            sb = new java.lang.StringBuilder();
            sb.append(str.substring(0, 3));
            sb.append(" ");
            length = str.length();
            i = 4;
        } else if (strRawString.length() > 6 && strRawString.length() <= 9) {
            sb = new java.lang.StringBuilder();
            sb.append(str.substring(3, 6));
            sb.append(" ");
            length = str.length();
            i = 7;
        } else {
            if (strRawString.length() <= 9 || strRawString.length() > 12) {
                return str;
            }
            sb = new java.lang.StringBuilder();
            sb.append(str.substring(6, 9));
            sb.append(" ");
            length = str.length();
            i = 10;
        }
        sb.append(str.substring(i, length));
        return sb.toString();
    }

    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static java.lang.String fenToYuan(java.lang.String str, int i) {
        java.lang.String str2;
        java.text.DecimalFormat decimalFormat = (java.text.DecimalFormat) java.text.DecimalFormat.getInstance();
        try {
            if (i == 0) {
                str2 = "0";
            } else {
                if (i != 1) {
                    if (i == 2) {
                        str2 = "0.00";
                    }
                    return decimalFormat.format(java.lang.Float.valueOf(str).floatValue() / 100.0f);
                }
                str2 = "0.0";
            }
            return decimalFormat.format(java.lang.Float.valueOf(str).floatValue() / 100.0f);
        } catch (java.lang.Exception unused) {
            return "";
        }
        decimalFormat.applyPattern(str2);
    }

    public static int getAnimId(android.content.Context context, java.lang.String str) {
        return context.getApplicationContext().getResources().getIdentifier(str, "anim", context.getApplicationContext().getPackageName());
    }

    public static java.lang.String getApplicationPackageName() {
        android.content.pm.PackageManager packageManager;
        try {
            android.content.Context context = com.tencent.midas.api.APMidasPayAPI.fromContext;
            return (context == null || (packageManager = context.getPackageManager()) == null) ? "" : packageManager.getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.i("APMidasCommMethod", "getApplicationPackageName error:" + e.toString());
            return "";
        }
    }

    public static java.lang.String getApplicationVersion() {
        try {
            return com.tencent.midas.api.APMidasPayAPI.fromContext.getPackageManager().getPackageInfo(com.tencent.midas.api.APMidasPayAPI.fromContext.getPackageName(), 0).versionName;
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.i("APMidasCommMethod", "getApplicationVersion error:" + e.toString());
            return "";
        }
    }

    public static int getColorId(android.content.Context context, java.lang.String str) {
        return context.getResources().getColor(context.getResources().getIdentifier(str, "color", context.getPackageName()));
    }

    public static android.graphics.drawable.Drawable getDrawable(android.content.Context context, java.lang.String str) {
        return context.getResources().getDrawable(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
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

    public static java.lang.String getStringId(android.content.Context context, java.lang.String str) {
        return context.getResources().getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
    }

    public static int getStyleId(android.content.Context context, java.lang.String str) {
        return context.getResources().getIdentifier(str, "style", context.getPackageName());
    }

    public static void popActivity() {
        com.tencent.midas.comm.APLog.i("jar popActivity", "1");
        try {
            if (activityStack == null) {
                return;
            }
            for (int i = 0; i < activityStack.size(); i++) {
                if (activityStack.get(i) != null) {
                    ((android.app.Activity) activityStack.get(i)).finish();
                }
            }
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.i("jar popActivity ex", e.toString());
        }
        releaseActivityStack();
    }

    public static void pushActivity(android.app.Activity activity) {
        if (activityStack == null) {
            activityStack = new java.util.Stack();
        }
        activityStack.push(activity);
    }

    public static int px2dip(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static java.lang.String rawString(java.lang.String str) {
        return str.replace(" ", "");
    }

    public static void releaseActivityStack() {
        java.util.Stack stack = activityStack;
        if (stack != null) {
            stack.clear();
        }
        activityStack = null;
    }

    public static void transformStrToList(java.lang.String str, java.util.List list) {
        int iIndexOf = str.indexOf("[");
        int iIndexOf2 = str.indexOf("]");
        list.clear();
        if (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf2 <= iIndexOf) {
            return;
        }
        java.lang.String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
        if (strSubstring.length() != 0) {
            for (java.lang.String str2 : strSubstring.split(",")) {
                list.add(str2);
            }
        }
    }

    public static void transformStrToMap(java.lang.String str, java.util.TreeMap treeMap) {
        int iIndexOf = str.indexOf("[");
        int iIndexOf2 = str.indexOf("]");
        if (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf2 <= iIndexOf) {
            return;
        }
        java.lang.String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
        if (strSubstring.length() == 0) {
            treeMap.clear();
            return;
        }
        java.lang.String[] strArrSplit = strSubstring.split(",");
        int length = strArrSplit.length;
        if (length <= 0 || length % 2 != 0) {
            return;
        }
        treeMap.clear();
        for (int i = 0; i < length / 2; i++) {
            int i2 = i * 2;
            treeMap.put(strArrSplit[i2], strArrSplit[i2 + 1]);
        }
    }

    public static void transformStrToMpInfoList(java.lang.String str, java.util.List list, java.util.List list2) {
        int iIndexOf = str.indexOf("[");
        int iIndexOf2 = str.indexOf("]");
        if (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf2 <= iIndexOf) {
            return;
        }
        java.lang.String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
        if (strSubstring.length() == 0) {
            list.clear();
            list2.clear();
            return;
        }
        java.lang.String[] strArrSplit = strSubstring.split(",");
        int length = strArrSplit.length;
        if (length <= 0 || length % 2 != 0) {
            return;
        }
        list.clear();
        list2.clear();
        for (int i = 0; i < length / 2; i++) {
            int i2 = i * 2;
            java.lang.String str2 = strArrSplit[i2];
            java.lang.String str3 = strArrSplit[i2 + 1];
            list.add(str2);
            list2.add(str3);
        }
    }
}
