package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class v implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f452a;
    private int b;
    private final android.content.Context c;
    private final int d;
    private final byte[] e;
    private final com.tencent.bugly.crashreport.common.info.a f;
    private final com.tencent.bugly.crashreport.common.strategy.a g;
    private final com.tencent.bugly.proguard.s h;
    private final com.tencent.bugly.proguard.u i;
    private final int j;
    private final com.tencent.bugly.proguard.t k;
    private final com.tencent.bugly.proguard.t l;
    private java.lang.String m;
    private final java.lang.String n;
    private final java.util.Map<java.lang.String, java.lang.String> o;
    private int p;
    private long q;
    private long r;
    private boolean s;
    private boolean t;

    public v(android.content.Context context, int i, int i2, byte[] bArr, java.lang.String str, java.lang.String str2, com.tencent.bugly.proguard.t tVar, boolean z, int i3, int i4, boolean z2, java.util.Map<java.lang.String, java.lang.String> map) {
        this.f452a = 2;
        this.b = 30000;
        this.m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = true;
        this.t = false;
        this.c = context;
        this.f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.e = bArr;
        this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.h = com.tencent.bugly.proguard.s.a(context);
        this.i = com.tencent.bugly.proguard.u.a();
        this.j = i;
        this.m = str;
        this.n = str2;
        this.k = tVar;
        com.tencent.bugly.proguard.u uVar = this.i;
        this.l = null;
        this.s = z;
        this.d = i2;
        if (i3 > 0) {
            this.f452a = i3;
        }
        if (i4 > 0) {
            this.b = i4;
        }
        this.t = z2;
        this.o = map;
    }

    public v(android.content.Context context, int i, int i2, byte[] bArr, java.lang.String str, java.lang.String str2, com.tencent.bugly.proguard.t tVar, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, tVar, z, 2, 30000, z2, null);
    }

    private static java.lang.String a(java.lang.String str) {
        if (com.tencent.bugly.proguard.z.a(str)) {
            return str;
        }
        try {
            return java.lang.String.format("%s?aid=%s", str, java.util.UUID.randomUUID().toString());
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.a(th);
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0017  */
    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    private void a(com.tencent.bugly.proguard.aq aqVar, boolean z, int i, java.lang.String str, int i2) {
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
            com.tencent.bugly.proguard.x.a("[Upload] Success: %s", strValueOf);
        } else {
            com.tencent.bugly.proguard.x.e("[Upload] Failed to upload(%d) %s: %s", java.lang.Integer.valueOf(i), strValueOf, str);
            if (this.s) {
                this.i.a(i2, (com.tencent.bugly.proguard.aq) null);
            }
        }
        if (this.q + this.r > 0) {
            this.i.a(this.i.a(this.t) + this.q + this.r, this.t);
        }
        com.tencent.bugly.proguard.t tVar = this.k;
        if (tVar != null) {
            int i4 = this.d;
            long j = this.q;
            long j2 = this.r;
            tVar.a(z);
        }
        com.tencent.bugly.proguard.t tVar2 = this.l;
        if (tVar2 != null) {
            int i5 = this.d;
            long j3 = this.q;
            long j4 = this.r;
            tVar2.a(z);
        }
    }

    private static boolean a(com.tencent.bugly.proguard.aq aqVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (aqVar == null) {
            com.tencent.bugly.proguard.x.d("resp == null!", new java.lang.Object[0]);
            return false;
        }
        if (aqVar.f428a != 0) {
            com.tencent.bugly.proguard.x.e("resp result error %d", java.lang.Byte.valueOf(aqVar.f428a));
            return false;
        }
        try {
            if (!com.tencent.bugly.proguard.z.a(aqVar.d) && !com.tencent.bugly.crashreport.common.info.a.b().i().equals(aqVar.d)) {
                com.tencent.bugly.proguard.p.a().a(com.tencent.bugly.crashreport.common.strategy.a.f295a, "gateway", aqVar.d.getBytes("UTF-8"), (com.tencent.bugly.proguard.o) null, true);
                aVar.d(aqVar.d);
            }
            if (!com.tencent.bugly.proguard.z.a(aqVar.f) && !com.tencent.bugly.crashreport.common.info.a.b().j().equals(aqVar.f)) {
                com.tencent.bugly.proguard.p.a().a(com.tencent.bugly.crashreport.common.strategy.a.f295a, com.tencent.ysdk.shell.module.report.impl.ReportComm.DEVICE, aqVar.f.getBytes("UTF-8"), (com.tencent.bugly.proguard.o) null, true);
                aVar.e(aqVar.f);
            }
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.a(th);
        }
        aVar.i = aqVar.e;
        if (aqVar.b == 510) {
            if (aqVar.c == null) {
                com.tencent.bugly.proguard.x.e("[Upload] Strategy data is null. Response cmd: %d", java.lang.Integer.valueOf(aqVar.b));
                return false;
            }
            com.tencent.bugly.proguard.as asVar = (com.tencent.bugly.proguard.as) com.tencent.bugly.proguard.a.a(aqVar.c, com.tencent.bugly.proguard.as.class);
            if (asVar == null) {
                com.tencent.bugly.proguard.x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", java.lang.Integer.valueOf(aqVar.b));
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

    /* JADX WARN: Code duplicated, block: B:100:0x0348 A[Catch: Throwable -> 0x0475, TryCatch #1 {Throwable -> 0x0475, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:13:0x003c, B:15:0x006e, B:17:0x0081, B:19:0x0085, B:21:0x0089, B:24:0x008f, B:26:0x0097, B:28:0x00a3, B:30:0x00c9, B:31:0x00ce, B:33:0x00d2, B:35:0x0105, B:37:0x0111, B:39:0x0117, B:41:0x0123, B:43:0x012b, B:45:0x0137, B:47:0x0146, B:48:0x014a, B:50:0x014e, B:51:0x0152, B:52:0x0159, B:55:0x0161, B:57:0x0178, B:58:0x0185, B:60:0x0197, B:61:0x019c, B:63:0x01cb, B:64:0x01e0, B:67:0x01ea, B:70:0x01f1, B:72:0x01f9, B:73:0x0201, B:84:0x0245, B:86:0x0273, B:87:0x027b, B:89:0x0281, B:90:0x02a1, B:95:0x02df, B:97:0x02ea, B:98:0x02ff, B:100:0x0348, B:102:0x0360, B:74:0x0205, B:76:0x020d, B:77:0x0216, B:79:0x0226, B:80:0x0230, B:81:0x023b, B:103:0x0388, B:105:0x039a, B:107:0x039d, B:108:0x03a5, B:110:0x03ab, B:111:0x03c5, B:113:0x03d1, B:115:0x03d9, B:117:0x03e5, B:119:0x03eb, B:121:0x03f7, B:123:0x03ff, B:125:0x040b, B:127:0x040f, B:128:0x0414, B:132:0x0428, B:134:0x043b, B:136:0x0446, B:131:0x0425, B:138:0x0451, B:140:0x045d, B:142:0x0469, B:92:0x02ae), top: B:151:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x02ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x0245 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0273 A[Catch: Throwable -> 0x0475, TryCatch #1 {Throwable -> 0x0475, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:13:0x003c, B:15:0x006e, B:17:0x0081, B:19:0x0085, B:21:0x0089, B:24:0x008f, B:26:0x0097, B:28:0x00a3, B:30:0x00c9, B:31:0x00ce, B:33:0x00d2, B:35:0x0105, B:37:0x0111, B:39:0x0117, B:41:0x0123, B:43:0x012b, B:45:0x0137, B:47:0x0146, B:48:0x014a, B:50:0x014e, B:51:0x0152, B:52:0x0159, B:55:0x0161, B:57:0x0178, B:58:0x0185, B:60:0x0197, B:61:0x019c, B:63:0x01cb, B:64:0x01e0, B:67:0x01ea, B:70:0x01f1, B:72:0x01f9, B:73:0x0201, B:84:0x0245, B:86:0x0273, B:87:0x027b, B:89:0x0281, B:90:0x02a1, B:95:0x02df, B:97:0x02ea, B:98:0x02ff, B:100:0x0348, B:102:0x0360, B:74:0x0205, B:76:0x020d, B:77:0x0216, B:79:0x0226, B:80:0x0230, B:81:0x023b, B:103:0x0388, B:105:0x039a, B:107:0x039d, B:108:0x03a5, B:110:0x03ab, B:111:0x03c5, B:113:0x03d1, B:115:0x03d9, B:117:0x03e5, B:119:0x03eb, B:121:0x03f7, B:123:0x03ff, B:125:0x040b, B:127:0x040f, B:128:0x0414, B:132:0x0428, B:134:0x043b, B:136:0x0446, B:131:0x0425, B:138:0x0451, B:140:0x045d, B:142:0x0469, B:92:0x02ae), top: B:151:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0281 A[Catch: Throwable -> 0x0475, LOOP:2: B:87:0x027b->B:89:0x0281, LOOP_END, TryCatch #1 {Throwable -> 0x0475, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:13:0x003c, B:15:0x006e, B:17:0x0081, B:19:0x0085, B:21:0x0089, B:24:0x008f, B:26:0x0097, B:28:0x00a3, B:30:0x00c9, B:31:0x00ce, B:33:0x00d2, B:35:0x0105, B:37:0x0111, B:39:0x0117, B:41:0x0123, B:43:0x012b, B:45:0x0137, B:47:0x0146, B:48:0x014a, B:50:0x014e, B:51:0x0152, B:52:0x0159, B:55:0x0161, B:57:0x0178, B:58:0x0185, B:60:0x0197, B:61:0x019c, B:63:0x01cb, B:64:0x01e0, B:67:0x01ea, B:70:0x01f1, B:72:0x01f9, B:73:0x0201, B:84:0x0245, B:86:0x0273, B:87:0x027b, B:89:0x0281, B:90:0x02a1, B:95:0x02df, B:97:0x02ea, B:98:0x02ff, B:100:0x0348, B:102:0x0360, B:74:0x0205, B:76:0x020d, B:77:0x0216, B:79:0x0226, B:80:0x0230, B:81:0x023b, B:103:0x0388, B:105:0x039a, B:107:0x039d, B:108:0x03a5, B:110:0x03ab, B:111:0x03c5, B:113:0x03d1, B:115:0x03d9, B:117:0x03e5, B:119:0x03eb, B:121:0x03f7, B:123:0x03ff, B:125:0x040b, B:127:0x040f, B:128:0x0414, B:132:0x0428, B:134:0x043b, B:136:0x0446, B:131:0x0425, B:138:0x0451, B:140:0x045d, B:142:0x0469, B:92:0x02ae), top: B:151:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x02dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x02df A[Catch: Throwable -> 0x0475, TRY_ENTER, TryCatch #1 {Throwable -> 0x0475, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:13:0x003c, B:15:0x006e, B:17:0x0081, B:19:0x0085, B:21:0x0089, B:24:0x008f, B:26:0x0097, B:28:0x00a3, B:30:0x00c9, B:31:0x00ce, B:33:0x00d2, B:35:0x0105, B:37:0x0111, B:39:0x0117, B:41:0x0123, B:43:0x012b, B:45:0x0137, B:47:0x0146, B:48:0x014a, B:50:0x014e, B:51:0x0152, B:52:0x0159, B:55:0x0161, B:57:0x0178, B:58:0x0185, B:60:0x0197, B:61:0x019c, B:63:0x01cb, B:64:0x01e0, B:67:0x01ea, B:70:0x01f1, B:72:0x01f9, B:73:0x0201, B:84:0x0245, B:86:0x0273, B:87:0x027b, B:89:0x0281, B:90:0x02a1, B:95:0x02df, B:97:0x02ea, B:98:0x02ff, B:100:0x0348, B:102:0x0360, B:74:0x0205, B:76:0x020d, B:77:0x0216, B:79:0x0226, B:80:0x0230, B:81:0x023b, B:103:0x0388, B:105:0x039a, B:107:0x039d, B:108:0x03a5, B:110:0x03ab, B:111:0x03c5, B:113:0x03d1, B:115:0x03d9, B:117:0x03e5, B:119:0x03eb, B:121:0x03f7, B:123:0x03ff, B:125:0x040b, B:127:0x040f, B:128:0x0414, B:132:0x0428, B:134:0x043b, B:136:0x0446, B:131:0x0425, B:138:0x0451, B:140:0x045d, B:142:0x0469, B:92:0x02ae), top: B:151:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x02ea A[Catch: Throwable -> 0x0475, TryCatch #1 {Throwable -> 0x0475, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:13:0x003c, B:15:0x006e, B:17:0x0081, B:19:0x0085, B:21:0x0089, B:24:0x008f, B:26:0x0097, B:28:0x00a3, B:30:0x00c9, B:31:0x00ce, B:33:0x00d2, B:35:0x0105, B:37:0x0111, B:39:0x0117, B:41:0x0123, B:43:0x012b, B:45:0x0137, B:47:0x0146, B:48:0x014a, B:50:0x014e, B:51:0x0152, B:52:0x0159, B:55:0x0161, B:57:0x0178, B:58:0x0185, B:60:0x0197, B:61:0x019c, B:63:0x01cb, B:64:0x01e0, B:67:0x01ea, B:70:0x01f1, B:72:0x01f9, B:73:0x0201, B:84:0x0245, B:86:0x0273, B:87:0x027b, B:89:0x0281, B:90:0x02a1, B:95:0x02df, B:97:0x02ea, B:98:0x02ff, B:100:0x0348, B:102:0x0360, B:74:0x0205, B:76:0x020d, B:77:0x0216, B:79:0x0226, B:80:0x0230, B:81:0x023b, B:103:0x0388, B:105:0x039a, B:107:0x039d, B:108:0x03a5, B:110:0x03ab, B:111:0x03c5, B:113:0x03d1, B:115:0x03d9, B:117:0x03e5, B:119:0x03eb, B:121:0x03f7, B:123:0x03ff, B:125:0x040b, B:127:0x040f, B:128:0x0414, B:132:0x0428, B:134:0x043b, B:136:0x0446, B:131:0x0425, B:138:0x0451, B:140:0x045d, B:142:0x0469, B:92:0x02ae), top: B:151:0x0003, inners: #0 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:100:0x0348, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrA;
        java.util.Map<java.lang.String, java.lang.String> map;
        boolean z;
        java.lang.String str;
        java.lang.Object[] objArr;
        int length = 0;
        try {
            this.p = 0;
            this.q = 0L;
            this.r = 0L;
            byte[] bArrA2 = this.e;
            if (com.tencent.bugly.crashreport.common.info.b.c(this.c) == null) {
                a(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArrA2 != null && bArrA2.length != 0) {
                long jA = this.i.a(this.t);
                if (((long) bArrA2.length) + jA >= 2097152) {
                    com.tencent.bugly.proguard.x.e("[Upload] Upload too much data, try next time: %d/%d", java.lang.Long.valueOf(jA), 2097152L);
                    a(null, false, 0, "over net consume: 2048K", 0);
                    return;
                }
                com.tencent.bugly.proguard.x.c("[Upload] Run upload task with cmd: %d", java.lang.Integer.valueOf(this.d));
                if (this.c != null && this.f != null && this.g != null && this.h != null) {
                    com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBeanC = this.g.c();
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
                        byte[] bArrA3 = com.tencent.bugly.proguard.z.a(bArrA2, 2);
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
                    if (this.k != null) {
                        com.tencent.bugly.proguard.t tVar = this.k;
                        int i = this.d;
                    }
                    if (this.l != null) {
                        com.tencent.bugly.proguard.t tVar2 = this.l;
                        int i2 = this.d;
                    }
                    java.lang.String strA = this.m;
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = -1;
                    while (true) {
                        i3++;
                        if (i3 >= this.f452a) {
                            a(null, false, i4, "failed after many attempts", 0);
                            return;
                        }
                        if (i3 > 1) {
                            com.tencent.bugly.proguard.x.d("[Upload] Failed to upload last time, wait and try(%d) again.", java.lang.Integer.valueOf(i3));
                            com.tencent.bugly.proguard.z.b(this.b);
                            if (i3 == this.f452a) {
                                com.tencent.bugly.proguard.x.d("[Upload] Use the back-up url at the last time: %s", this.n);
                                strA = this.n;
                            }
                        }
                        com.tencent.bugly.proguard.x.c("[Upload] Send %d bytes", java.lang.Integer.valueOf(bArrA2.length));
                        if (this.s) {
                            strA = a(strA);
                        }
                        com.tencent.bugly.proguard.x.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", strA, java.lang.Integer.valueOf(this.d), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                        bArrA = this.h.a(strA, bArrA2, this, map2);
                        if (bArrA != null) {
                            map = this.h.f447a;
                            if (!this.s) {
                                break;
                            }
                            if (map == null || map.size() == 0) {
                                com.tencent.bugly.proguard.x.d("[Upload] Headers is empty.", new java.lang.Object[0]);
                            } else {
                                if (map.containsKey("status")) {
                                    if (map.containsKey("Bugly-Version")) {
                                        java.lang.String str2 = map.get("Bugly-Version");
                                        if (str2.contains(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_BUGLY)) {
                                            com.tencent.bugly.proguard.x.c("[Upload] Bugly version from headers is: %s", str2);
                                            z = true;
                                        } else {
                                            com.tencent.bugly.proguard.x.d("[Upload] Bugly version is not valid: %s", str2);
                                        }
                                    } else {
                                        str = "[Upload] Headers does not contain %s";
                                        objArr = new java.lang.Object[]{"Bugly-Version"};
                                    }
                                    if (!z) {
                                        try {
                                            i5 = java.lang.Integer.parseInt(map.get("status"));
                                            com.tencent.bugly.proguard.x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                                            if (i5 != 0) {
                                                break;
                                            }
                                            if (i5 == 2) {
                                                a(null, false, 1, "status of server is " + i5, i5);
                                                return;
                                            }
                                            if (this.q + this.r > 0) {
                                                this.i.a(this.i.a(this.t) + this.q + this.r, this.t);
                                            }
                                            this.i.a(i5, (com.tencent.bugly.proguard.aq) null);
                                            com.tencent.bugly.proguard.x.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                                            this.i.a(this.j, this.d, this.e, this.m, this.n, this.k, this.f452a, this.b, true, this.o);
                                            return;
                                        } catch (java.lang.Throwable unused) {
                                            com.tencent.bugly.proguard.x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for format of status header is invalid: " + java.lang.Integer.toString(i5));
                                            i4 = 1;
                                        }
                                    } else {
                                        com.tencent.bugly.proguard.x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                                        com.tencent.bugly.proguard.x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for no status header.");
                                        if (map != null) {
                                            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                                                com.tencent.bugly.proguard.x.c(java.lang.String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new java.lang.Object[0]);
                                            }
                                        }
                                        com.tencent.bugly.proguard.x.c("[Upload] Failed to upload for no status header.", new java.lang.Object[0]);
                                        i4 = 1;
                                    }
                                } else {
                                    str = "[Upload] Headers does not contain %s";
                                    objArr = new java.lang.Object[]{"status"};
                                }
                                com.tencent.bugly.proguard.x.d(str, objArr);
                            }
                            z = false;
                            if (!z) {
                                i5 = java.lang.Integer.parseInt(map.get("status"));
                                com.tencent.bugly.proguard.x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                                if (i5 != 0) {
                                    break;
                                }
                                if (i5 == 2) {
                                    a(null, false, 1, "status of server is " + i5, i5);
                                    return;
                                }
                                if (this.q + this.r > 0) {
                                    this.i.a(this.i.a(this.t) + this.q + this.r, this.t);
                                }
                                this.i.a(i5, (com.tencent.bugly.proguard.aq) null);
                                com.tencent.bugly.proguard.x.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                                this.i.a(this.j, this.d, this.e, this.m, this.n, this.k, this.f452a, this.b, true, this.o);
                                return;
                            }
                            com.tencent.bugly.proguard.x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
                            com.tencent.bugly.proguard.x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for no status header.");
                            if (map != null) {
                                while (r1.hasNext()) {
                                    com.tencent.bugly.proguard.x.c(java.lang.String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new java.lang.Object[0]);
                                }
                            }
                            com.tencent.bugly.proguard.x.c("[Upload] Failed to upload for no status header.", new java.lang.Object[0]);
                            i4 = 1;
                        } else {
                            com.tencent.bugly.proguard.x.e("[Upload] Failed to upload(%d): %s", 1, "Failed to upload for no response!");
                            i4 = 1;
                        }
                    }
                    com.tencent.bugly.proguard.x.c("[Upload] Received %d bytes", java.lang.Integer.valueOf(bArrA.length));
                    if (this.s) {
                        if (bArrA.length == 0) {
                            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : map.entrySet()) {
                                com.tencent.bugly.proguard.x.c("[Upload] HTTP headers from server: key = %s, value = %s", entry2.getKey(), entry2.getValue());
                            }
                            a(null, false, 1, "response data from server is empty", 0);
                            return;
                        }
                        byte[] bArrB = this.i.b(bArrA);
                        if (bArrB == null) {
                            a(null, false, 1, "failed to decrypt response from server", 0);
                            return;
                        }
                        bArrA = com.tencent.bugly.proguard.z.b(bArrB, 2);
                        if (bArrA == null) {
                            a(null, false, 1, "failed unzip(Gzip) response from server", 0);
                            return;
                        }
                    }
                    com.tencent.bugly.proguard.aq aqVarA = com.tencent.bugly.proguard.a.a(bArrA, this.s);
                    if (aqVarA == null) {
                        a(null, false, 1, "failed to decode response package", 0);
                        return;
                    }
                    if (this.s) {
                        this.i.a(i5, aqVarA);
                    }
                    java.lang.Object[] objArr2 = new java.lang.Object[2];
                    objArr2[0] = java.lang.Integer.valueOf(aqVarA.b);
                    if (aqVarA.c != null) {
                        length = aqVarA.c.length;
                    }
                    objArr2[1] = java.lang.Integer.valueOf(length);
                    com.tencent.bugly.proguard.x.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr2);
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
            if (com.tencent.bugly.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }
}
