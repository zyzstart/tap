package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class m extends com.tencent.hlyyb.common.c.a {
    private static com.tencent.hlyyb.common.c.m b = new com.tencent.hlyyb.common.c.m();

    private m() {
    }

    private static java.lang.String a(java.lang.String str, boolean z, java.util.Map map) {
        java.lang.String strD = com.tencent.hlyyb.common.a.f.d();
        map.put("A23", com.tencent.hlyyb.common.a.e);
        com.tencent.hlyyb.common.c.p pVar = new com.tencent.hlyyb.common.c.p();
        pVar.c(str);
        pVar.a(java.lang.System.currentTimeMillis());
        pVar.b(com.tencent.hlyyb.common.c.l.f560a);
        pVar.a(strD);
        map.put("A1", com.tencent.hlyyb.common.a.d);
        map.put("A2", com.tencent.hlyyb.common.f.c.b());
        map.put("A4", com.tencent.hlyyb.common.f.c.c());
        map.put("A6", com.tencent.hlyyb.common.f.c.d());
        map.put("A7", com.tencent.hlyyb.common.f.c.g());
        map.put("A23", com.tencent.hlyyb.common.a.e);
        map.put("A33", com.tencent.hlyyb.common.a.f.f());
        map.put("A10", com.tencent.hlyyb.common.c.l.d);
        map.put("A9", com.tencent.hlyyb.common.c.l.c);
        map.put("A19", strD);
        pVar.a(map);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.tencent.hlyyb.common.f.c.a(java.lang.System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
        sb.append("INFO|");
        sb.append(com.tencent.hlyyb.common.a.e.a() + "|");
        sb.append(com.tencent.hlyyb.common.c.l.b + "|");
        sb.append("beacon|");
        sb.append("1.8.1|");
        java.lang.String strB = pVar.b();
        try {
            strB = java.net.URLEncoder.encode(pVar.b(), com.unisound.b.f.b);
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append(strB + "|");
        sb.append("|");
        sb.append("upload_ip|");
        sb.append("|");
        sb.append(pVar.a() + "|");
        sb.append(pVar.d() + "|");
        sb.append(z + "|");
        sb.append("0|");
        sb.append("0|");
        sb.append(a(pVar.e()) + "|");
        sb.append(com.tencent.hlyyb.common.f.c.a(pVar.c(), "yyyy-MM-dd HH:mm:ss") + "|");
        sb.append("upload_time");
        return sb.toString();
    }

    private static java.lang.String a(java.util.Map map) {
        java.util.Set<java.lang.String> setKeySet;
        if (map == null || (setKeySet = map.keySet()) == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : setKeySet) {
            sb.append("&");
            sb.append(str);
            sb.append("=");
            sb.append((java.lang.String) map.get(str));
        }
        java.lang.String strSubstring = sb.substring(1);
        sb.setLength(0);
        return strSubstring;
    }

    public static com.tencent.hlyyb.common.c.m d() {
        return b;
    }

    @Override // com.tencent.hlyyb.common.c.a
    public final java.lang.String a() {
        return "halley-cloud-HalleyAction";
    }

    public final void a(java.lang.String str, boolean z, java.util.Map map, boolean z2, boolean z3) {
        super.a(a(str, z, map), z2, z3);
    }

    @Override // com.tencent.hlyyb.common.c.a
    public final int b() {
        return com.tencent.hlyyb.common.a.e.a("report_insert_new_record_num_limit", 5, 100, 100);
    }

    @Override // com.tencent.hlyyb.common.c.a
    public final java.lang.String c() {
        return "beacon";
    }
}
