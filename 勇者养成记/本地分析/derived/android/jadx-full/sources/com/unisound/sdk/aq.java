package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.unisound.common.a f1521a = new com.unisound.common.a("asrv3.hivoice.cn", 80, "117.121.49.41", 80);
    public static com.unisound.common.a b = new com.unisound.common.a("v_eng.hivoice.cn", 80, "117.121.55.43", 80);
    public static com.unisound.common.a c = new com.unisound.common.a("v_cnt.hivoice.cn", 80, "117.121.55.41", 80);
    public static com.unisound.common.a d = new com.unisound.common.a("eval.hivoice.cn", 80, "140.207.193.59", 80);
    public static com.unisound.common.a e = new com.unisound.common.a("117.121.55.39", 9001, "117.121.55.39", 9001);
    public static com.unisound.common.a f = new com.unisound.common.a("v_zhen.hivoice.cn", 9004, "v_zhen.hivoice.cn", 9004);

    public static com.unisound.common.a a(java.lang.String str) {
        if (str.equals("en")) {
            return b;
        }
        if (str.equals("co")) {
            return c;
        }
        if (str.equals(com.unisound.sdk.as.aE)) {
            return d;
        }
        return com.unisound.sdk.as.aF.equals(str) ? f : f1521a;
    }
}
