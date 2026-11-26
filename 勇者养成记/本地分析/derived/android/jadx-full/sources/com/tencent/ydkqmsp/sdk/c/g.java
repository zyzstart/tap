package com.tencent.ydkqmsp.sdk.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.content.SharedPreferences f1316a;
    private static final int b;

    static class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.ydkqmsp.sdk.c.g.b();
        }
    }

    static class b implements java.lang.Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.ydkqmsp.sdk.c.g.b();
        }
    }

    static {
        b = android.os.Build.VERSION.SDK_INT < 23 ? 9 : 23;
    }

    private static void a() {
        java.lang.String str;
        try {
            int i = b;
            java.lang.String[] strArr = new java.lang.String[i];
            com.tencent.ydkqmsp.sdk.c.f.a(10L, 0L, 0L, 0L, null, null, null, strArr);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                strArr[i2] = com.tencent.ydkqmsp.sdk.f.l.a(strArr[i2]);
                sb.append(strArr[i2]);
                sb.append(",");
                if (i2 == 0) {
                    sb2.append(java.lang.String.format("k%d:", java.lang.Integer.valueOf(i2 + 1)));
                    str = strArr[i2];
                } else {
                    sb2.append(java.lang.String.format(";k%d:", java.lang.Integer.valueOf(i2 + 1)));
                    str = strArr[i2];
                }
                sb2.append(str);
            }
            sb2.append(java.lang.String.format(";k%d:", java.lang.Integer.valueOf(i + 1)));
            sb2.append(com.tencent.ydkqmsp.sdk.u.U.BEACON_ID_VERSION);
            sb.append(sb2.toString());
            sb.append(",");
            sb.append(com.tencent.ydkqmsp.sdk.a.c.a(sb2.toString()));
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("Java -- cbid: ");
            sb3.append(sb.toString());
            sb3.append(" bidMd5: ");
            sb3.append(com.tencent.ydkqmsp.sdk.a.c.a(sb2.toString()));
            com.tencent.ydkqmsp.sdk.f.g.b("cbid", 0, sb3.toString());
            com.tencent.ydkqmsp.sdk.a.f.a(sb.toString(), 5);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(long j) {
        com.tencent.ydkqmsp.sdk.c.f.i().c().postDelayed(new com.tencent.ydkqmsp.sdk.c.g.b(), j);
    }

    public static void a(android.content.Context context) {
        try {
            f1316a = context.getSharedPreferences("qmsp_cbid_time", 0);
            b();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void b() {
        try {
            if (!com.tencent.ydkqmsp.sdk.app.a.getTaskStatus()) {
                com.tencent.ydkqmsp.sdk.f.g.a("cbid", 1, "Cbid Task Finish！");
                return;
            }
            if (f1316a != null) {
                long j = 28800000;
                if (!com.tencent.ydkqmsp.sdk.c.f.i().a(1002).booleanValue()) {
                    a(28800000L);
                    return;
                }
                long j2 = 0;
                long j3 = f1316a.getLong("cbid_last_time", 0L);
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                long j4 = jCurrentTimeMillis - j3;
                if (j4 >= 0) {
                    j2 = j4;
                }
                if (j2 > 28800000) {
                    a();
                    android.content.SharedPreferences.Editor editorEdit = f1316a.edit();
                    editorEdit.putLong("cbid_last_time", jCurrentTimeMillis);
                    editorEdit.commit();
                } else {
                    j = 28800000 - j2;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("cbid rpt after: ");
                sb.append(j);
                com.tencent.ydkqmsp.sdk.f.g.a("cbid", 1, sb.toString());
                com.tencent.ydkqmsp.sdk.c.f.i().c().postDelayed(new com.tencent.ydkqmsp.sdk.c.g.a(), j);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
