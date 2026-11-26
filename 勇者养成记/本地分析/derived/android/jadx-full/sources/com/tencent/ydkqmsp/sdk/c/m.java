package com.tencent.ydkqmsp.sdk.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class m implements com.tencent.ydkqmsp.sdk.c.d, com.tencent.ydkqmsp.sdk.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.ydkqmsp.sdk.c.m f1330a;

    class a implements com.tencent.ydkqmsp.sdk.c.f.InterfaceC0048f {
        a() {
        }

        @Override // com.tencent.ydkqmsp.sdk.c.f.InterfaceC0048f
        public int a(long j, long j2, long j3, java.lang.Object obj, java.lang.Object obj2, java.lang.Object[] objArr, java.lang.Object[] objArr2) {
            if (obj != null && (obj instanceof java.lang.String)) {
                java.lang.String str = (java.lang.String) obj;
                com.tencent.ydkqmsp.sdk.f.g.a("QSec.Rpt", 1, java.lang.String.format("Op: %d, Rid: %d, val: %s", java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), str));
                com.tencent.ydkqmsp.sdk.c.m.this.a(j, j2, str);
            }
            return 0;
        }
    }

    private m() {
        com.tencent.ydkqmsp.sdk.c.f.a(3L, new com.tencent.ydkqmsp.sdk.c.m.a());
    }

    public static com.tencent.ydkqmsp.sdk.c.m b() {
        if (f1330a == null) {
            synchronized (com.tencent.ydkqmsp.sdk.c.m.class) {
                if (f1330a == null) {
                    f1330a = new com.tencent.ydkqmsp.sdk.c.m();
                }
            }
        }
        return f1330a;
    }

    @Override // com.tencent.ydkqmsp.sdk.c.d
    public java.lang.String a() {
        return "Rpt";
    }

    public void a(long j, long j2, java.lang.String str) {
        new org.json.JSONObject();
        if (j == 1 || j == 2) {
            com.tencent.ydkqmsp.sdk.a.f.a(str, (int) j2);
        }
    }
}
