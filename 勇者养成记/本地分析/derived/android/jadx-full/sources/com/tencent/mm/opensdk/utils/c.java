package com.tencent.mm.opensdk.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {

    public static final class a {
        public static java.lang.Object a(int i, java.lang.String str) {
            try {
                switch (i) {
                    case 1:
                        return java.lang.Integer.valueOf(str);
                    case 2:
                        return java.lang.Long.valueOf(str);
                    case 3:
                        return str;
                    case 4:
                        return java.lang.Boolean.valueOf(str);
                    case 5:
                        return java.lang.Float.valueOf(str);
                    case 6:
                        return java.lang.Double.valueOf(str);
                    default:
                        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                        return null;
                }
            } catch (java.lang.Exception e) {
                com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
                return null;
            }
        }
    }

    public static final class b implements android.provider.BaseColumns {
        public static final android.net.Uri CONTENT_URI = android.net.Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
