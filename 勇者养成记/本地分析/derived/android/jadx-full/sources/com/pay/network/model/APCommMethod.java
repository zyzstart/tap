package com.pay.network.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APCommMethod {
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
