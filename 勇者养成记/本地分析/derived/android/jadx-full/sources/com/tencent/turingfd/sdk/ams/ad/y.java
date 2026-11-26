package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class y {
    public static final long Oa = java.lang.System.currentTimeMillis();

    public static java.lang.String b(android.content.Context context, boolean z) {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("T:");
        sb.append(Oa);
        sb.append(",");
        sb.append("F:");
        sb.append(z ? "1" : "0");
        if (com.tencent.turingfd.sdk.ams.ad.C.Za.containsKey(com.tencent.turingfd.sdk.ams.ad.C.ab)) {
            str = com.tencent.turingfd.sdk.ams.ad.C.ab + "_" + com.tencent.turingfd.sdk.ams.ad.C.Za.get(com.tencent.turingfd.sdk.ams.ad.C.ab).Xa.a(context);
        } else {
            str = "";
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            sb.append(",");
            sb.append("MSA:");
            sb.append(str);
        }
        java.lang.String strA = com.tencent.turingfd.sdk.ams.ad.w.a(context, "204");
        if (!android.text.TextUtils.isEmpty(strA)) {
            sb.append(",");
            sb.append("R:");
            sb.append(strA);
        }
        int i = context.getSharedPreferences("turingfd_protect_105548_28_advertisersMini", 0).getInt("301", 0);
        if (i > 0) {
            sb.append(",");
            sb.append("RB:");
            sb.append(i);
        }
        if (!android.text.TextUtils.isEmpty(com.tencent.turingfd.sdk.ams.ad.w.a(context, "105"))) {
            sb.append(",");
            sb.append("TAT:");
            sb.append("1");
        }
        return sb.toString();
    }
}
