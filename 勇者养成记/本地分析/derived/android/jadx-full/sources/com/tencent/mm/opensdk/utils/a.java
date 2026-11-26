package com.tencent.mm.opensdk.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {
    public static int a(android.os.Bundle bundle, java.lang.String str) {
        if (bundle == null) {
            return -1;
        }
        try {
            return bundle.getInt(str, -1);
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            return -1;
        }
    }

    public static java.lang.String b(android.os.Bundle bundle, java.lang.String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return null;
        }
    }
}
