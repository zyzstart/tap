package com.tencent.msdk.dns.core.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {
    public static com.tencent.msdk.dns.core.a.c.d a(int i, com.tencent.msdk.dns.core.a.b.b bVar, com.tencent.msdk.dns.core.a.a.b bVar2, com.tencent.msdk.dns.core.a.a.b bVar3) {
        int i2;
        int i3;
        if (bVar == null) {
            bVar = com.tencent.msdk.dns.core.a.b.b.a();
        }
        if (bVar2 == null) {
            bVar2 = com.tencent.msdk.dns.core.a.a.b.a();
        }
        if (bVar3 == null) {
            bVar3 = com.tencent.msdk.dns.core.a.a.b.a();
        }
        java.lang.String strE = bVar2.e();
        if ("0".equals(strE)) {
            strE = bVar.b();
            i2 = 0;
        } else {
            i2 = 1;
        }
        java.lang.String strE2 = bVar3.e();
        if ("0".equals(strE2)) {
            strE2 = bVar.c();
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i == 1) {
            return new com.tencent.msdk.dns.core.a.c.d(1, new com.tencent.msdk.dns.core.a.c.d.a(strE, i2), null);
        }
        if (i != 2) {
            return i != 3 ? new com.tencent.msdk.dns.core.a.c.d(0, null, null) : new com.tencent.msdk.dns.core.a.c.d(3, new com.tencent.msdk.dns.core.a.c.d.a(strE, i2), new com.tencent.msdk.dns.core.a.c.d.a(strE2, i3));
        }
        return new com.tencent.msdk.dns.core.a.c.d(2, null, new com.tencent.msdk.dns.core.a.c.d.a(strE2, i3));
    }
}
