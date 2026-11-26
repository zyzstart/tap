package com.dodjoy.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AndroidDownUtil {
    public static java.lang.String GetDownFullFilePath(android.content.Context context, java.lang.String str) {
        java.lang.String strGetDataDir = com.dodjoy.utilities.DodBaseContext.GetDataDir();
        if (strGetDataDir == null) {
            return null;
        }
        return strGetDataDir + "/" + str;
    }

    public static java.lang.String GetUrlFileName(java.lang.String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf <= 0) {
            return null;
        }
        return str.substring(iLastIndexOf + 1);
    }
}
