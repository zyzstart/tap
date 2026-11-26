package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class w {
    public android.os.Handler Ma;

    public w(android.os.Handler handler) {
        this.Ma = handler;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        java.lang.String string = context.getSharedPreferences("turingfd_conf_105548_28_advertisersMini", 0).getString(str, "");
        if (android.text.TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            int length = string.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = string.toCharArray();
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i2])) << 4));
            }
            return new java.lang.String(com.tencent.turingfd.sdk.ams.ad.C0086b.a(bArr, com.tencent.turingfd.sdk.ams.ad.C0086b.b()), "UTF-8");
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static android.content.SharedPreferences i(android.content.Context context) {
        return context.getSharedPreferences("turingfd_conf_105548_28_advertisersMini", 0);
    }

    public void a(android.content.Context context, int i, long j) {
        b(context, "202", i + "_" + j);
    }

    public void a(android.content.Context context, long j) {
        b(context, "204", "" + j);
    }

    public void a(android.content.Context context, com.tencent.turingfd.sdk.ams.ad.r rVar) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("101", rVar.qa);
        map.put("102", "" + rVar.ra);
        if (!android.text.TextUtils.isEmpty(rVar.ua)) {
            map.put("103", rVar.ua);
        }
        if (!android.text.TextUtils.isEmpty(rVar.va)) {
            map.put("104", rVar.va);
        }
        if (!android.text.TextUtils.isEmpty(rVar.wa)) {
            map.put("105", rVar.wa);
        }
        if (!android.text.TextUtils.isEmpty(rVar.xa)) {
            map.put("106", rVar.xa);
        }
        this.Ma.post(new com.tencent.turingfd.sdk.ams.ad.v(this, context, map));
    }

    public void b(android.content.Context context, long j) {
        b(context, "201", "" + j);
    }

    public final void b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.util.HashMap map = new java.util.HashMap();
        map.put(str, str2);
        this.Ma.post(new com.tencent.turingfd.sdk.ams.ad.v(this, context, map));
    }

    public void c(android.content.Context context, long j) {
        b(context, "203", "" + j);
    }

    public java.lang.String f(android.content.Context context) {
        return a(context, "201");
    }

    public java.lang.String g(android.content.Context context) {
        return a(context, "203");
    }

    public java.lang.String h(android.content.Context context) {
        return a(context, "202");
    }

    public com.tencent.turingfd.sdk.ams.ad.r j(android.content.Context context) {
        java.lang.String strA = a(context, "101");
        if (android.text.TextUtils.isEmpty(strA)) {
            return com.tencent.turingfd.sdk.ams.ad.r.a(1);
        }
        long jLongValue = 0;
        try {
            jLongValue = java.lang.Long.valueOf(a(context, "102")).longValue();
        } catch (java.lang.Throwable unused) {
        }
        java.lang.String strA2 = a(context, "103");
        java.lang.String strA3 = a(context, "104");
        java.lang.String strA4 = a(context, "105");
        java.lang.String strA5 = a(context, "106");
        com.tencent.turingfd.sdk.ams.ad.r.a aVarCreate = com.tencent.turingfd.sdk.ams.ad.r.create(0);
        aVarCreate.ua = strA2;
        aVarCreate.ra = jLongValue;
        aVarCreate.qa = strA;
        aVarCreate.va = strA3;
        aVarCreate.wa = strA4;
        aVarCreate.xa = strA5;
        return aVarCreate.build();
    }
}
