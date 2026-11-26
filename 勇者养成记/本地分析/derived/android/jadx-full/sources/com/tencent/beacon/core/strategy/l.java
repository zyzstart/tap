package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l extends com.tencent.beacon.core.d.a {
    public l(android.content.Context context, int i, int i2, java.lang.String str) {
        super(context, i, i2, str);
    }

    @Override // com.tencent.beacon.core.d.a
    public void a(boolean z) {
    }

    @Override // com.tencent.beacon.core.d.a
    public com.tencent.beacon.core.protocol.common.RequestPackage f() {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.beacon.core.info.g gVarB = com.tencent.beacon.core.info.g.b(this.c);
        try {
            com.tencent.beacon.core.protocol.common.RequestPackage requestPackageA = com.tencent.beacon.core.d.m.a(c(), gVarB, "".getBytes(java.nio.charset.Charset.forName("UTF-8")), -1, -1, this.f);
            if (requestPackageA != null && c() == 100) {
                java.util.HashMap map = new java.util.HashMap();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("");
                sb.append(com.tencent.beacon.event.UserAction.getUserID(null));
                map.put("A1", sb.toString());
                com.tencent.beacon.core.info.c cVarA = com.tencent.beacon.core.info.c.a(gVarB.c());
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("");
                sb2.append(cVarA.c());
                map.put("A2", sb2.toString());
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("");
                sb3.append(cVarA.e());
                map.put("A4", sb3.toString());
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("");
                sb4.append(cVarA.f());
                map.put("A6", sb4.toString());
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                sb5.append("");
                sb5.append(cVarA.a());
                map.put("A7", sb5.toString());
                com.tencent.beacon.qimei.Qimei qimei = com.tencent.beacon.qimei.QimeiSDK.getInstance().getQimei(this.c);
                if (qimei != null && qimei.getQimeiMap() != null) {
                    map.putAll(qimei.getQimeiMap());
                }
                java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                sb6.append("");
                sb6.append(gVarB.b((java.lang.String) null));
                map.put("A23", sb6.toString());
                java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                sb7.append("");
                sb7.append(cVarA.b());
                map.put("A31", sb7.toString());
                map.put("A33", com.tencent.beacon.core.info.e.d(gVarB.c()).k(gVarB.c()));
                if (com.tencent.beacon.core.info.a.h(gVarB.c())) {
                    str = "A66";
                    str2 = "F";
                } else {
                    str = "A66";
                    str2 = "B";
                }
                map.put(str, str2);
                java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                sb8.append("");
                sb8.append(com.tencent.beacon.core.info.a.c(gVarB.c()));
                map.put("A67", sb8.toString());
                java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
                sb9.append("");
                sb9.append(com.tencent.beacon.core.info.a.b(gVarB.c()));
                map.put("A68", sb9.toString());
                map.put("A85", com.tencent.beacon.core.info.a.e ? "Y" : "N");
                requestPackageA.reserved = com.tencent.beacon.core.e.c.a(map);
            }
            return requestPackageA;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("[event] encode empty package failed", new java.lang.Object[0]);
            return null;
        }
    }
}
