package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class v implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f410a;
    private int b;
    private final android.content.Context c;
    private final int d;
    private final byte[] e;
    private final com.tencent.bugly.opengame.crashreport.common.info.a f;
    private final com.tencent.bugly.opengame.crashreport.common.strategy.a g;
    private final com.tencent.bugly.opengame.proguard.s h;
    private final com.tencent.bugly.opengame.proguard.u i;
    private final int j;
    private final com.tencent.bugly.opengame.proguard.t k;
    private final com.tencent.bugly.opengame.proguard.t l;
    private java.lang.String m;
    private final java.lang.String n;
    private final java.util.Map o;
    private int p;
    private long q;
    private long r;
    private boolean s;
    private boolean t;

    public v(android.content.Context context, int i, int i2, byte[] bArr, java.lang.String str, java.lang.String str2, com.tencent.bugly.opengame.proguard.t tVar, boolean z, int i3, int i4, boolean z2, java.util.Map map) {
        this.f410a = 2;
        this.b = 30000;
        this.m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = true;
        this.t = false;
        this.c = context;
        this.f = com.tencent.bugly.opengame.crashreport.common.info.a.a(context);
        this.e = bArr;
        this.g = com.tencent.bugly.opengame.crashreport.common.strategy.a.a();
        this.h = com.tencent.bugly.opengame.proguard.s.a(context);
        this.i = com.tencent.bugly.opengame.proguard.u.a();
        this.j = i;
        this.m = str;
        this.n = str2;
        this.k = tVar;
        this.l = null;
        this.s = z;
        this.d = i2;
        if (i3 > 0) {
            this.f410a = i3;
        }
        if (i4 > 0) {
            this.b = i4;
        }
        this.t = z2;
        this.o = map;
    }

    public v(android.content.Context context, int i, int i2, byte[] bArr, java.lang.String str, java.lang.String str2, com.tencent.bugly.opengame.proguard.t tVar, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, tVar, z, 2, 30000, z2, null);
    }

    private static java.lang.String a(java.lang.String str) {
        if (com.tencent.bugly.opengame.proguard.z.a(str)) {
            return str;
        }
        try {
            return java.lang.String.format("%s?aid=%s", str, java.util.UUID.randomUUID().toString());
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.opengame.proguard.x.a(th);
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0017  */
    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    private void a(com.tencent.bugly.opengame.proguard.aq aqVar, boolean z, int i, java.lang.String str, int i2) {
        java.lang.String strValueOf;
        int i3 = this.d;
        if (i3 == 630) {
            strValueOf = "crash";
        } else if (i3 == 640) {
            strValueOf = "userinfo";
        } else if (i3 == 830) {
            strValueOf = "crash";
        } else if (i3 != 840) {
            strValueOf = java.lang.String.valueOf(i3);
        } else {
            strValueOf = "userinfo";
        }
        if (z) {
            com.tencent.bugly.opengame.proguard.x.a("[Upload] Success: %s", strValueOf);
        } else {
            com.tencent.bugly.opengame.proguard.x.e("[Upload] Failed to upload(%d) %s: %s", java.lang.Integer.valueOf(i), strValueOf, str);
            if (this.s) {
                this.i.a(i2, (com.tencent.bugly.opengame.proguard.aq) null);
            }
        }
        if (this.q + this.r > 0) {
            this.i.a(this.i.a(this.t) + this.q + this.r, this.t);
        }
        com.tencent.bugly.opengame.proguard.t tVar = this.k;
        if (tVar != null) {
            tVar.a(z);
        }
        com.tencent.bugly.opengame.proguard.t tVar2 = this.l;
        if (tVar2 != null) {
            tVar2.a(z);
        }
    }

    private static boolean a(com.tencent.bugly.opengame.proguard.aq aqVar, com.tencent.bugly.opengame.crashreport.common.info.a aVar, com.tencent.bugly.opengame.crashreport.common.strategy.a aVar2) {
        if (aqVar == null) {
            com.tencent.bugly.opengame.proguard.x.d("resp == null!", new java.lang.Object[0]);
            return false;
        }
        byte b = aqVar.f386a;
        if (b != 0) {
            com.tencent.bugly.opengame.proguard.x.e("resp result error %d", java.lang.Byte.valueOf(b));
            return false;
        }
        try {
            if (!com.tencent.bugly.opengame.proguard.z.a(aqVar.d) && !com.tencent.bugly.opengame.crashreport.common.info.a.b().i().equals(aqVar.d)) {
                com.tencent.bugly.opengame.proguard.p.a().a(com.tencent.bugly.opengame.crashreport.common.strategy.a.f345a, "gateway", aqVar.d.getBytes("UTF-8"), (com.tencent.bugly.opengame.proguard.o) null, true);
                aVar.d(aqVar.d);
            }
            if (!com.tencent.bugly.opengame.proguard.z.a(aqVar.f) && !com.tencent.bugly.opengame.crashreport.common.info.a.b().j().equals(aqVar.f)) {
                com.tencent.bugly.opengame.proguard.p.a().a(com.tencent.bugly.opengame.crashreport.common.strategy.a.f345a, com.tencent.ysdk.shell.module.report.impl.ReportComm.DEVICE, aqVar.f.getBytes("UTF-8"), (com.tencent.bugly.opengame.proguard.o) null, true);
                aVar.e(aqVar.f);
            }
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.opengame.proguard.x.a(th);
        }
        aVar.i = aqVar.e;
        int i = aqVar.b;
        if (i == 510) {
            byte[] bArr = aqVar.c;
            if (bArr == null) {
                com.tencent.bugly.opengame.proguard.x.e("[Upload] Strategy data is null. Response cmd: %d", java.lang.Integer.valueOf(i));
                return false;
            }
            com.tencent.bugly.opengame.proguard.as asVar = (com.tencent.bugly.opengame.proguard.as) com.tencent.bugly.opengame.proguard.a.a(bArr, com.tencent.bugly.opengame.proguard.as.class);
            if (asVar == null) {
                com.tencent.bugly.opengame.proguard.x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", java.lang.Integer.valueOf(aqVar.b));
                return false;
            }
            aVar2.a(asVar);
        }
        return true;
    }

    public final void a(long j) {
        this.p++;
        this.q += j;
    }

    public final void b(long j) {
        this.r += j;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0237  */
    /* JADX WARN: Code duplicated, block: B:112:0x0265 A[Catch: all -> 0x0465, TryCatch #1 {all -> 0x0465, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:15:0x003e, B:18:0x0070, B:20:0x0081, B:22:0x0085, B:24:0x0089, B:27:0x008f, B:29:0x0097, B:31:0x00a3, B:33:0x00aa, B:35:0x00b5, B:37:0x00be, B:39:0x00c9, B:40:0x00ce, B:43:0x00d4, B:45:0x00df, B:47:0x00e8, B:49:0x00f4, B:51:0x0105, B:53:0x0111, B:55:0x0117, B:57:0x0123, B:59:0x012b, B:61:0x0137, B:62:0x014d, B:66:0x0157, B:69:0x016e, B:71:0x017b, B:73:0x018b, B:76:0x0193, B:79:0x01c3, B:80:0x01d2, B:83:0x01dc, B:86:0x01e3, B:89:0x01ed, B:90:0x01f3, B:108:0x0239, B:110:0x0256, B:112:0x0265, B:113:0x026d, B:115:0x0273, B:117:0x027b, B:120:0x0295, B:127:0x02cf, B:129:0x02da, B:130:0x02ef, B:132:0x02f7, B:134:0x0338, B:136:0x0350, B:138:0x0366, B:91:0x01f7, B:94:0x0201, B:95:0x0208, B:98:0x021a, B:101:0x0224, B:104:0x022f, B:141:0x037a, B:143:0x038a, B:145:0x038d, B:146:0x0395, B:148:0x039b, B:150:0x03a3, B:151:0x03b5, B:153:0x03c1, B:155:0x03c9, B:157:0x03d5, B:159:0x03db, B:161:0x03e7, B:163:0x03ef, B:165:0x03fb, B:167:0x03ff, B:169:0x0406, B:173:0x0418, B:175:0x042b, B:177:0x0436, B:172:0x0415, B:179:0x0441, B:181:0x044d, B:183:0x0459, B:122:0x029e, B:124:0x02ac), top: B:192:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0273 A[Catch: all -> 0x0465, TRY_LEAVE, TryCatch #1 {all -> 0x0465, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:15:0x003e, B:18:0x0070, B:20:0x0081, B:22:0x0085, B:24:0x0089, B:27:0x008f, B:29:0x0097, B:31:0x00a3, B:33:0x00aa, B:35:0x00b5, B:37:0x00be, B:39:0x00c9, B:40:0x00ce, B:43:0x00d4, B:45:0x00df, B:47:0x00e8, B:49:0x00f4, B:51:0x0105, B:53:0x0111, B:55:0x0117, B:57:0x0123, B:59:0x012b, B:61:0x0137, B:62:0x014d, B:66:0x0157, B:69:0x016e, B:71:0x017b, B:73:0x018b, B:76:0x0193, B:79:0x01c3, B:80:0x01d2, B:83:0x01dc, B:86:0x01e3, B:89:0x01ed, B:90:0x01f3, B:108:0x0239, B:110:0x0256, B:112:0x0265, B:113:0x026d, B:115:0x0273, B:117:0x027b, B:120:0x0295, B:127:0x02cf, B:129:0x02da, B:130:0x02ef, B:132:0x02f7, B:134:0x0338, B:136:0x0350, B:138:0x0366, B:91:0x01f7, B:94:0x0201, B:95:0x0208, B:98:0x021a, B:101:0x0224, B:104:0x022f, B:141:0x037a, B:143:0x038a, B:145:0x038d, B:146:0x0395, B:148:0x039b, B:150:0x03a3, B:151:0x03b5, B:153:0x03c1, B:155:0x03c9, B:157:0x03d5, B:159:0x03db, B:161:0x03e7, B:163:0x03ef, B:165:0x03fb, B:167:0x03ff, B:169:0x0406, B:173:0x0418, B:175:0x042b, B:177:0x0436, B:172:0x0415, B:179:0x0441, B:181:0x044d, B:183:0x0459, B:122:0x029e, B:124:0x02ac), top: B:192:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x02cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x02cf A[Catch: all -> 0x0465, TRY_ENTER, TryCatch #1 {all -> 0x0465, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:15:0x003e, B:18:0x0070, B:20:0x0081, B:22:0x0085, B:24:0x0089, B:27:0x008f, B:29:0x0097, B:31:0x00a3, B:33:0x00aa, B:35:0x00b5, B:37:0x00be, B:39:0x00c9, B:40:0x00ce, B:43:0x00d4, B:45:0x00df, B:47:0x00e8, B:49:0x00f4, B:51:0x0105, B:53:0x0111, B:55:0x0117, B:57:0x0123, B:59:0x012b, B:61:0x0137, B:62:0x014d, B:66:0x0157, B:69:0x016e, B:71:0x017b, B:73:0x018b, B:76:0x0193, B:79:0x01c3, B:80:0x01d2, B:83:0x01dc, B:86:0x01e3, B:89:0x01ed, B:90:0x01f3, B:108:0x0239, B:110:0x0256, B:112:0x0265, B:113:0x026d, B:115:0x0273, B:117:0x027b, B:120:0x0295, B:127:0x02cf, B:129:0x02da, B:130:0x02ef, B:132:0x02f7, B:134:0x0338, B:136:0x0350, B:138:0x0366, B:91:0x01f7, B:94:0x0201, B:95:0x0208, B:98:0x021a, B:101:0x0224, B:104:0x022f, B:141:0x037a, B:143:0x038a, B:145:0x038d, B:146:0x0395, B:148:0x039b, B:150:0x03a3, B:151:0x03b5, B:153:0x03c1, B:155:0x03c9, B:157:0x03d5, B:159:0x03db, B:161:0x03e7, B:163:0x03ef, B:165:0x03fb, B:167:0x03ff, B:169:0x0406, B:173:0x0418, B:175:0x042b, B:177:0x0436, B:172:0x0415, B:179:0x0441, B:181:0x044d, B:183:0x0459, B:122:0x029e, B:124:0x02ac), top: B:192:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02da A[Catch: all -> 0x0465, TryCatch #1 {all -> 0x0465, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:15:0x003e, B:18:0x0070, B:20:0x0081, B:22:0x0085, B:24:0x0089, B:27:0x008f, B:29:0x0097, B:31:0x00a3, B:33:0x00aa, B:35:0x00b5, B:37:0x00be, B:39:0x00c9, B:40:0x00ce, B:43:0x00d4, B:45:0x00df, B:47:0x00e8, B:49:0x00f4, B:51:0x0105, B:53:0x0111, B:55:0x0117, B:57:0x0123, B:59:0x012b, B:61:0x0137, B:62:0x014d, B:66:0x0157, B:69:0x016e, B:71:0x017b, B:73:0x018b, B:76:0x0193, B:79:0x01c3, B:80:0x01d2, B:83:0x01dc, B:86:0x01e3, B:89:0x01ed, B:90:0x01f3, B:108:0x0239, B:110:0x0256, B:112:0x0265, B:113:0x026d, B:115:0x0273, B:117:0x027b, B:120:0x0295, B:127:0x02cf, B:129:0x02da, B:130:0x02ef, B:132:0x02f7, B:134:0x0338, B:136:0x0350, B:138:0x0366, B:91:0x01f7, B:94:0x0201, B:95:0x0208, B:98:0x021a, B:101:0x0224, B:104:0x022f, B:141:0x037a, B:143:0x038a, B:145:0x038d, B:146:0x0395, B:148:0x039b, B:150:0x03a3, B:151:0x03b5, B:153:0x03c1, B:155:0x03c9, B:157:0x03d5, B:159:0x03db, B:161:0x03e7, B:163:0x03ef, B:165:0x03fb, B:167:0x03ff, B:169:0x0406, B:173:0x0418, B:175:0x042b, B:177:0x0436, B:172:0x0415, B:179:0x0441, B:181:0x044d, B:183:0x0459, B:122:0x029e, B:124:0x02ac), top: B:192:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0338 A[Catch: all -> 0x0465, TryCatch #1 {all -> 0x0465, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:15:0x003e, B:18:0x0070, B:20:0x0081, B:22:0x0085, B:24:0x0089, B:27:0x008f, B:29:0x0097, B:31:0x00a3, B:33:0x00aa, B:35:0x00b5, B:37:0x00be, B:39:0x00c9, B:40:0x00ce, B:43:0x00d4, B:45:0x00df, B:47:0x00e8, B:49:0x00f4, B:51:0x0105, B:53:0x0111, B:55:0x0117, B:57:0x0123, B:59:0x012b, B:61:0x0137, B:62:0x014d, B:66:0x0157, B:69:0x016e, B:71:0x017b, B:73:0x018b, B:76:0x0193, B:79:0x01c3, B:80:0x01d2, B:83:0x01dc, B:86:0x01e3, B:89:0x01ed, B:90:0x01f3, B:108:0x0239, B:110:0x0256, B:112:0x0265, B:113:0x026d, B:115:0x0273, B:117:0x027b, B:120:0x0295, B:127:0x02cf, B:129:0x02da, B:130:0x02ef, B:132:0x02f7, B:134:0x0338, B:136:0x0350, B:138:0x0366, B:91:0x01f7, B:94:0x0201, B:95:0x0208, B:98:0x021a, B:101:0x0224, B:104:0x022f, B:141:0x037a, B:143:0x038a, B:145:0x038d, B:146:0x0395, B:148:0x039b, B:150:0x03a3, B:151:0x03b5, B:153:0x03c1, B:155:0x03c9, B:157:0x03d5, B:159:0x03db, B:161:0x03e7, B:163:0x03ef, B:165:0x03fb, B:167:0x03ff, B:169:0x0406, B:173:0x0418, B:175:0x042b, B:177:0x0436, B:172:0x0415, B:179:0x0441, B:181:0x044d, B:183:0x0459, B:122:0x029e, B:124:0x02ac), top: B:192:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x029e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:134:0x0338, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrA;
        java.util.Map map;
        boolean z;
        long j;
        java.lang.String str;
        java.lang.Object[] objArr;
        int length = 0;
        try {
            this.p = 0;
            this.q = 0L;
            this.r = 0L;
            byte[] bArrA2 = this.e;
            if (com.tencent.bugly.opengame.crashreport.common.info.b.c(this.c) == null) {
                a(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArrA2 != null && bArrA2.length != 0) {
                long jA = this.i.a(this.t);
                if (((long) bArrA2.length) + jA >= 2097152) {
                    com.tencent.bugly.opengame.proguard.x.e("[Upload] Upload too much data, try next time: %d/%d", java.lang.Long.valueOf(jA), 2097152L);
                    a(null, false, 0, "over net consume: 2048K", 0);
                    return;
                }
                com.tencent.bugly.opengame.proguard.x.c("[Upload] Run upload task with cmd: %d", java.lang.Integer.valueOf(this.d));
                if (this.c != null && this.f != null && this.g != null && this.h != null) {
                    com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBeanC = this.g.c();
                    if (strategyBeanC == null) {
                        a(null, false, 0, "illegal local strategy", 0);
                        return;
                    }
                    java.util.HashMap map2 = new java.util.HashMap();
                    map2.put("prodId", this.f.f());
                    map2.put("bundleId", this.f.c);
                    map2.put("appVer", this.f.j);
                    if (this.o != null) {
                        map2.putAll(this.o);
                    }
                    if (this.s) {
                        map2.put("cmd", java.lang.Integer.toString(this.d));
                        map2.put("platformId", java.lang.Byte.toString((byte) 1));
                        this.f.getClass();
                        map2.put("sdkVer", "3.0.0");
                        map2.put("strategylastUpdateTime", java.lang.Long.toString(strategyBeanC.p));
                        if (!this.i.a(map2)) {
                            a(null, false, 0, "failed to add security info to HTTP headers", 0);
                            return;
                        }
                        byte[] bArrA3 = com.tencent.bugly.opengame.proguard.z.a(bArrA2, 2);
                        if (bArrA3 == null) {
                            a(null, false, 0, "failed to zip request body", 0);
                            return;
                        }
                        bArrA2 = this.i.a(bArrA3);
                        if (bArrA2 == null) {
                            a(null, false, 0, "failed to encrypt request body", 0);
                            return;
                        }
                    }
                    this.i.a(this.j, java.lang.System.currentTimeMillis());
                    com.tencent.bugly.opengame.proguard.t tVar = this.k;
                    com.tencent.bugly.opengame.proguard.t tVar2 = this.l;
                    java.lang.String strA = this.m;
                    int i = 0;
                    int i2 = 0;
                    int i3 = -1;
                    while (true) {
                        int i4 = i + 1;
                        if (i >= this.f410a) {
                            a(null, false, i2, "failed after many attempts", 0);
                            return;
                        }
                        if (i4 > 1) {
                            com.tencent.bugly.opengame.proguard.x.d("[Upload] Failed to upload last time, wait and try(%d) again.", java.lang.Integer.valueOf(i4));
                            com.tencent.bugly.opengame.proguard.z.b(this.b);
                            if (i4 == this.f410a) {
                                com.tencent.bugly.opengame.proguard.x.d("[Upload] Use the back-up url at the last time: %s", this.n);
                                strA = this.n;
                            }
                        }
                        com.tencent.bugly.opengame.proguard.x.c("[Upload] Send %d bytes", java.lang.Integer.valueOf(bArrA2.length));
                        if (this.s) {
                            strA = a(strA);
                        }
                        com.tencent.bugly.opengame.proguard.x.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", strA, java.lang.Integer.valueOf(this.d), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                        bArrA = this.h.a(strA, bArrA2, this, map2);
                        if (bArrA != null) {
                            map = this.h.f405a;
                            if (!this.s) {
                                break;
                            }
                            if (map == null || map.size() == 0) {
                                com.tencent.bugly.opengame.proguard.x.d("[Upload] Headers is empty.", new java.lang.Object[0]);
                            } else {
                                if (map.containsKey("status")) {
                                    if (map.containsKey("Bugly-Version")) {
                                        java.lang.String str2 = (java.lang.String) map.get("Bugly-Version");
                                        if (str2.contains(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_BUGLY)) {
                                            com.tencent.bugly.opengame.proguard.x.c("[Upload] Bugly version from headers is: %s", str2);
                                            z = true;
                                        } else {
                                            com.tencent.bugly.opengame.proguard.x.d("[Upload] Bugly version is not valid: %s", str2);
                                        }
                                    } else {
                                        str = "[Upload] Headers does not contain %s";
                                        objArr = new java.lang.Object[]{"Bugly-Version"};
                                    }
                                    if (!z) {
                                        try {
                                            i3 = java.lang.Integer.parseInt((java.lang.String) map.get("status"));
                                            com.tencent.bugly.opengame.proguard.x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                                            if (i3 != 0) {
                                                break;
                                            }
                                            if (i3 == 2) {
                                                a(null, false, 1, "status of server is " + i3, i3);
                                                return;
                                            }
                                            if (this.q + this.r > 0) {
                                                this.i.a(this.i.a(this.t) + this.q + this.r, this.t);
                                            }
                                            this.i.a(i3, (com.tencent.bugly.opengame.proguard.aq) null);
                                            com.tencent.bugly.opengame.proguard.x.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                                            this.i.a(this.j, this.d, this.e, this.m, this.n, this.k, this.f410a, this.b, true, this.o);
                                            return;
                                        } catch (java.lang.Throwable unused) {
                                            j = 0;
                                            com.tencent.bugly.opengame.proguard.x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for format of status header is invalid: " + java.lang.Integer.toString(i3));
                                            i = i4;
                                            i2 = 1;
                                        }
                                    } else {
                                        com.tencent.bugly.opengame.proguard.x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                                        com.tencent.bugly.opengame.proguard.x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for no status header.");
                                        if (map != null) {
                                            for (java.util.Map.Entry entry : map.entrySet()) {
                                                com.tencent.bugly.opengame.proguard.x.c(java.lang.String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new java.lang.Object[0]);
                                            }
                                        }
                                        com.tencent.bugly.opengame.proguard.x.c("[Upload] Failed to upload for no status header.", new java.lang.Object[0]);
                                    }
                                } else {
                                    str = "[Upload] Headers does not contain %s";
                                    objArr = new java.lang.Object[]{"status"};
                                }
                                com.tencent.bugly.opengame.proguard.x.d(str, objArr);
                            }
                            z = false;
                            if (!z) {
                                i3 = java.lang.Integer.parseInt((java.lang.String) map.get("status"));
                                com.tencent.bugly.opengame.proguard.x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                                if (i3 != 0) {
                                    break;
                                }
                                if (i3 == 2) {
                                    a(null, false, 1, "status of server is " + i3, i3);
                                    return;
                                }
                                if (this.q + this.r > 0) {
                                    this.i.a(this.i.a(this.t) + this.q + this.r, this.t);
                                }
                                this.i.a(i3, (com.tencent.bugly.opengame.proguard.aq) null);
                                com.tencent.bugly.opengame.proguard.x.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                                this.i.a(this.j, this.d, this.e, this.m, this.n, this.k, this.f410a, this.b, true, this.o);
                                return;
                            }
                            com.tencent.bugly.opengame.proguard.x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                            com.tencent.bugly.opengame.proguard.x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for no status header.");
                            if (map != null) {
                                while (r1.hasNext()) {
                                    com.tencent.bugly.opengame.proguard.x.c(java.lang.String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new java.lang.Object[0]);
                                }
                            }
                            com.tencent.bugly.opengame.proguard.x.c("[Upload] Failed to upload for no status header.", new java.lang.Object[0]);
                        } else {
                            com.tencent.bugly.opengame.proguard.x.e("[Upload] Failed to upload(%d): %s", 1, "Failed to upload for no response!");
                        }
                        j = 0;
                        i = i4;
                        i2 = 1;
                    }
                    com.tencent.bugly.opengame.proguard.x.c("[Upload] Received %d bytes", java.lang.Integer.valueOf(bArrA.length));
                    if (this.s) {
                        if (bArrA.length == 0) {
                            for (java.util.Map.Entry entry2 : map.entrySet()) {
                                com.tencent.bugly.opengame.proguard.x.c("[Upload] HTTP headers from server: key = %s, value = %s", entry2.getKey(), entry2.getValue());
                            }
                            a(null, false, 1, "response data from server is empty", 0);
                            return;
                        }
                        byte[] bArrB = this.i.b(bArrA);
                        if (bArrB == null) {
                            a(null, false, 1, "failed to decrypt response from server", 0);
                            return;
                        }
                        bArrA = com.tencent.bugly.opengame.proguard.z.b(bArrB, 2);
                        if (bArrA == null) {
                            a(null, false, 1, "failed unzip(Gzip) response from server", 0);
                            return;
                        }
                    }
                    com.tencent.bugly.opengame.proguard.aq aqVarA = com.tencent.bugly.opengame.proguard.a.a(bArrA, this.s);
                    if (aqVarA == null) {
                        a(null, false, 1, "failed to decode response package", 0);
                        return;
                    }
                    if (this.s) {
                        this.i.a(i3, aqVarA);
                    }
                    java.lang.Object[] objArr2 = new java.lang.Object[2];
                    objArr2[0] = java.lang.Integer.valueOf(aqVarA.b);
                    if (aqVarA.c != null) {
                        length = aqVarA.c.length;
                    }
                    objArr2[1] = java.lang.Integer.valueOf(length);
                    com.tencent.bugly.opengame.proguard.x.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr2);
                    if (a(aqVarA, this.f, this.g)) {
                        a(aqVarA, true, 2, "successfully uploaded", 0);
                        return;
                    } else {
                        a(aqVarA, false, 2, "failed to process response package", 0);
                        return;
                    }
                }
                a(null, false, 0, "illegal access error", 0);
                return;
            }
            a(null, false, 0, "request package is empty!", 0);
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }
}
