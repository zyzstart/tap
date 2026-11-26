package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    private static java.net.Proxy e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.util.HashMap f374a = new java.util.HashMap();
    protected java.lang.String b;
    com.tencent.bugly.opengame.proguard.i c;
    private java.util.HashMap d;

    a() {
        new java.util.HashMap();
        this.d = new java.util.HashMap();
        this.b = "GBK";
        this.c = new com.tencent.bugly.opengame.proguard.i();
    }

    public static com.tencent.bugly.opengame.proguard.aj a(int i) {
        if (i == 1) {
            return new com.tencent.bugly.opengame.proguard.ai();
        }
        if (i == 3) {
            return new com.tencent.bugly.opengame.proguard.ah();
        }
        return null;
    }

    public static com.tencent.bugly.opengame.proguard.ap a(android.content.Context context, int i, byte[] bArr) {
        com.tencent.bugly.opengame.crashreport.common.info.a aVarB = com.tencent.bugly.opengame.crashreport.common.info.a.b();
        com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBeanC = com.tencent.bugly.opengame.crashreport.common.strategy.a.a().c();
        if (aVarB == null || strategyBeanC == null) {
            com.tencent.bugly.opengame.proguard.x.e("Can not create request pkg for parameters is invalid.", new java.lang.Object[0]);
            return null;
        }
        try {
            com.tencent.bugly.opengame.proguard.ap apVar = new com.tencent.bugly.opengame.proguard.ap();
            synchronized (aVarB) {
                apVar.f385a = 1;
                apVar.b = aVarB.f();
                apVar.c = aVarB.c;
                apVar.d = aVarB.j;
                apVar.e = aVarB.l;
                aVarB.getClass();
                apVar.f = "3.0.0";
                apVar.g = i;
                apVar.h = bArr == null ? "".getBytes() : bArr;
                apVar.i = aVarB.g;
                apVar.j = aVarB.h;
                apVar.k = new java.util.HashMap();
                apVar.l = aVarB.e();
                apVar.m = strategyBeanC.p;
                apVar.o = aVarB.h();
                apVar.p = com.tencent.bugly.opengame.crashreport.common.info.b.c(context);
                apVar.q = java.lang.System.currentTimeMillis();
                apVar.r = aVarB.k();
                apVar.s = aVarB.j();
                apVar.t = aVarB.m();
                apVar.u = aVarB.l();
                apVar.v = aVarB.n();
                apVar.w = apVar.p;
                aVarB.getClass();
                apVar.n = "com.tencent.bugly";
                apVar.k.put("A26", aVarB.y());
                apVar.k.put("A60", aVarB.z());
                apVar.k.put("A61", aVarB.A());
                java.util.Map map = apVar.k;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(aVarB.R());
                map.put("A62", sb.toString());
                java.util.Map map2 = apVar.k;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(aVarB.S());
                map2.put("A63", sb2.toString());
                java.util.Map map3 = apVar.k;
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(aVarB.z);
                map3.put("F11", sb3.toString());
                java.util.Map map4 = apVar.k;
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append(aVarB.y);
                map4.put("F12", sb4.toString());
                apVar.k.put("G1", aVarB.u());
                apVar.k.put("A64", aVarB.T());
                if (aVarB.B) {
                    apVar.k.put("G2", aVarB.L());
                    apVar.k.put("G3", aVarB.M());
                    apVar.k.put("G4", aVarB.N());
                    apVar.k.put("G5", aVarB.O());
                    apVar.k.put("G6", aVarB.P());
                    apVar.k.put("G7", java.lang.Long.toString(aVarB.Q()));
                }
                apVar.k.put("D3", aVarB.k);
                if (com.tencent.bugly.opengame.b.b != null) {
                    for (com.tencent.bugly.opengame.a aVar : com.tencent.bugly.opengame.b.b) {
                        if (aVar.versionKey != null && aVar.version != null) {
                            apVar.k.put(aVar.versionKey, aVar.version);
                        }
                    }
                }
                apVar.k.put("G15", com.tencent.bugly.opengame.proguard.z.b("G15", ""));
                apVar.k.put("D4", com.tencent.bugly.opengame.proguard.z.b("D4", "0"));
            }
            com.tencent.bugly.opengame.proguard.u uVarA = com.tencent.bugly.opengame.proguard.u.a();
            if (uVarA != null && !uVarA.f406a && bArr != null) {
                byte[] bArrA = com.tencent.bugly.opengame.proguard.z.a(apVar.h, 2, 1, strategyBeanC.u);
                apVar.h = bArrA;
                if (bArrA == null) {
                    com.tencent.bugly.opengame.proguard.x.e("reqPkg sbuffer error!", new java.lang.Object[0]);
                    return null;
                }
            }
            java.util.Map mapF = aVarB.F();
            if (mapF != null) {
                for (java.util.Map.Entry entry : mapF.entrySet()) {
                    apVar.k.put(entry.getKey(), entry.getValue());
                }
            }
            return apVar;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static com.tencent.bugly.opengame.proguard.aq a(byte[] bArr, boolean z) {
        if (bArr != null) {
            try {
                com.tencent.bugly.opengame.proguard.d dVar = new com.tencent.bugly.opengame.proguard.d();
                dVar.c();
                dVar.a(com.unisound.b.f.b);
                dVar.a(bArr);
                java.lang.Object objB = dVar.b(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, new com.tencent.bugly.opengame.proguard.aq());
                com.tencent.bugly.opengame.proguard.aq aqVar = com.tencent.bugly.opengame.proguard.aq.class.isInstance(objB) ? (com.tencent.bugly.opengame.proguard.aq) com.tencent.bugly.opengame.proguard.aq.class.cast(objB) : null;
                if (!z && aqVar != null && aqVar.c != null && aqVar.c.length > 0) {
                    com.tencent.bugly.opengame.proguard.x.c("resp buf %d", java.lang.Integer.valueOf(aqVar.c.length));
                    byte[] bArrB = com.tencent.bugly.opengame.proguard.z.b(aqVar.c, 2, 1, com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.d);
                    aqVar.c = bArrB;
                    if (bArrB == null) {
                        com.tencent.bugly.opengame.proguard.x.e("resp sbuffer error!", new java.lang.Object[0]);
                        return null;
                    }
                }
                return aqVar;
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.opengame.proguard.x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0054  */
    /* JADX WARN: Code duplicated, block: B:26:0x006b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0084  */
    /* JADX WARN: Code duplicated, block: B:34:0x009a A[LOOP:0: B:32:0x0094->B:34:0x009a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d8 A[LOOP:1: B:40:0x00d2->B:42:0x00d8, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x009a, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x00d8, please report this as an issue */
    public static com.tencent.bugly.opengame.proguard.at a(com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean) {
        byte b;
        java.util.HashMap map;
        java.util.Map map2;
        java.util.Map map3;
        if (userInfoBean == null) {
            return null;
        }
        com.tencent.bugly.opengame.proguard.at atVar = new com.tencent.bugly.opengame.proguard.at();
        atVar.f389a = userInfoBean.e;
        atVar.e = userInfoBean.j;
        atVar.d = userInfoBean.c;
        atVar.c = userInfoBean.d;
        atVar.g = com.tencent.bugly.opengame.crashreport.common.info.a.b().i();
        atVar.h = userInfoBean.o == 1;
        int i = userInfoBean.b;
        switch (i) {
            case 1:
                atVar.b = (byte) 1;
                map = new java.util.HashMap();
                atVar.f = map;
                if (userInfoBean.p >= 0) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(userInfoBean.p);
                    map.put("C01", sb.toString());
                }
                if (userInfoBean.q >= 0) {
                    java.util.Map map4 = atVar.f;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(userInfoBean.q);
                    map4.put("C02", sb2.toString());
                }
                map2 = userInfoBean.r;
                if (map2 != null && map2.size() > 0) {
                    for (java.util.Map.Entry entry : userInfoBean.r.entrySet()) {
                        atVar.f.put("C03_" + ((java.lang.String) entry.getKey()), entry.getValue());
                    }
                }
                map3 = userInfoBean.s;
                if (map3 != null && map3.size() > 0) {
                    for (java.util.Map.Entry entry2 : userInfoBean.s.entrySet()) {
                        atVar.f.put("C04_" + ((java.lang.String) entry2.getKey()), entry2.getValue());
                    }
                }
                java.util.Map map5 = atVar.f;
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(!userInfoBean.l);
                map5.put("A36", sb3.toString());
                java.util.Map map6 = atVar.f;
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append(userInfoBean.g);
                map6.put("F02", sb4.toString());
                java.util.Map map7 = atVar.f;
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                sb5.append(userInfoBean.h);
                map7.put("F03", sb5.toString());
                atVar.f.put("F04", userInfoBean.j);
                java.util.Map map8 = atVar.f;
                java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                sb6.append(userInfoBean.i);
                map8.put("F05", sb6.toString());
                atVar.f.put("F06", userInfoBean.m);
                java.util.Map map9 = atVar.f;
                java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                sb7.append(userInfoBean.k);
                map9.put("F10", sb7.toString());
                com.tencent.bugly.opengame.proguard.x.c("summary type %d vm:%d", java.lang.Byte.valueOf(atVar.b), java.lang.Integer.valueOf(atVar.f.size()));
                return atVar;
            case 2:
                b = 4;
                atVar.b = b;
                map = new java.util.HashMap();
                atVar.f = map;
                if (userInfoBean.p >= 0) {
                    java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                    sb8.append(userInfoBean.p);
                    map.put("C01", sb8.toString());
                }
                if (userInfoBean.q >= 0) {
                    java.util.Map map10 = atVar.f;
                    java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
                    sb9.append(userInfoBean.q);
                    map10.put("C02", sb9.toString());
                }
                map2 = userInfoBean.r;
                if (map2 != null) {
                    while (r0.hasNext()) {
                        atVar.f.put("C03_" + ((java.lang.String) entry.getKey()), entry.getValue());
                    }
                }
                map3 = userInfoBean.s;
                if (map3 != null) {
                    while (r0.hasNext()) {
                        atVar.f.put("C04_" + ((java.lang.String) entry2.getKey()), entry2.getValue());
                    }
                }
                java.util.Map map11 = atVar.f;
                java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
                sb10.append(!userInfoBean.l);
                map11.put("A36", sb10.toString());
                java.util.Map map12 = atVar.f;
                java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
                sb11.append(userInfoBean.g);
                map12.put("F02", sb11.toString());
                java.util.Map map13 = atVar.f;
                java.lang.StringBuilder sb12 = new java.lang.StringBuilder();
                sb12.append(userInfoBean.h);
                map13.put("F03", sb12.toString());
                atVar.f.put("F04", userInfoBean.j);
                java.util.Map map14 = atVar.f;
                java.lang.StringBuilder sb13 = new java.lang.StringBuilder();
                sb13.append(userInfoBean.i);
                map14.put("F05", sb13.toString());
                atVar.f.put("F06", userInfoBean.m);
                java.util.Map map15 = atVar.f;
                java.lang.StringBuilder sb14 = new java.lang.StringBuilder();
                sb14.append(userInfoBean.k);
                map15.put("F10", sb14.toString());
                com.tencent.bugly.opengame.proguard.x.c("summary type %d vm:%d", java.lang.Byte.valueOf(atVar.b), java.lang.Integer.valueOf(atVar.f.size()));
                return atVar;
            case 3:
                atVar.b = (byte) 2;
                map = new java.util.HashMap();
                atVar.f = map;
                if (userInfoBean.p >= 0) {
                    java.lang.StringBuilder sb15 = new java.lang.StringBuilder();
                    sb15.append(userInfoBean.p);
                    map.put("C01", sb15.toString());
                }
                if (userInfoBean.q >= 0) {
                    java.util.Map map16 = atVar.f;
                    java.lang.StringBuilder sb16 = new java.lang.StringBuilder();
                    sb16.append(userInfoBean.q);
                    map16.put("C02", sb16.toString());
                }
                map2 = userInfoBean.r;
                if (map2 != null) {
                    while (r0.hasNext()) {
                        atVar.f.put("C03_" + ((java.lang.String) entry.getKey()), entry.getValue());
                    }
                }
                map3 = userInfoBean.s;
                if (map3 != null) {
                    while (r0.hasNext()) {
                        atVar.f.put("C04_" + ((java.lang.String) entry2.getKey()), entry2.getValue());
                    }
                }
                java.util.Map map17 = atVar.f;
                java.lang.StringBuilder sb17 = new java.lang.StringBuilder();
                sb17.append(!userInfoBean.l);
                map17.put("A36", sb17.toString());
                java.util.Map map18 = atVar.f;
                java.lang.StringBuilder sb18 = new java.lang.StringBuilder();
                sb18.append(userInfoBean.g);
                map18.put("F02", sb18.toString());
                java.util.Map map19 = atVar.f;
                java.lang.StringBuilder sb19 = new java.lang.StringBuilder();
                sb19.append(userInfoBean.h);
                map19.put("F03", sb19.toString());
                atVar.f.put("F04", userInfoBean.j);
                java.util.Map map110 = atVar.f;
                java.lang.StringBuilder sb110 = new java.lang.StringBuilder();
                sb110.append(userInfoBean.i);
                map110.put("F05", sb110.toString());
                atVar.f.put("F06", userInfoBean.m);
                java.util.Map map111 = atVar.f;
                java.lang.StringBuilder sb111 = new java.lang.StringBuilder();
                sb111.append(userInfoBean.k);
                map111.put("F10", sb111.toString());
                com.tencent.bugly.opengame.proguard.x.c("summary type %d vm:%d", java.lang.Byte.valueOf(atVar.b), java.lang.Integer.valueOf(atVar.f.size()));
                return atVar;
            case 4:
                b = 3;
                atVar.b = b;
                map = new java.util.HashMap();
                atVar.f = map;
                if (userInfoBean.p >= 0) {
                    java.lang.StringBuilder sb112 = new java.lang.StringBuilder();
                    sb112.append(userInfoBean.p);
                    map.put("C01", sb112.toString());
                }
                if (userInfoBean.q >= 0) {
                    java.util.Map map112 = atVar.f;
                    java.lang.StringBuilder sb113 = new java.lang.StringBuilder();
                    sb113.append(userInfoBean.q);
                    map112.put("C02", sb113.toString());
                }
                map2 = userInfoBean.r;
                if (map2 != null) {
                    while (r0.hasNext()) {
                        atVar.f.put("C03_" + ((java.lang.String) entry.getKey()), entry.getValue());
                    }
                }
                map3 = userInfoBean.s;
                if (map3 != null) {
                    while (r0.hasNext()) {
                        atVar.f.put("C04_" + ((java.lang.String) entry2.getKey()), entry2.getValue());
                    }
                }
                java.util.Map map113 = atVar.f;
                java.lang.StringBuilder sb114 = new java.lang.StringBuilder();
                sb114.append(!userInfoBean.l);
                map113.put("A36", sb114.toString());
                java.util.Map map114 = atVar.f;
                java.lang.StringBuilder sb115 = new java.lang.StringBuilder();
                sb115.append(userInfoBean.g);
                map114.put("F02", sb115.toString());
                java.util.Map map115 = atVar.f;
                java.lang.StringBuilder sb116 = new java.lang.StringBuilder();
                sb116.append(userInfoBean.h);
                map115.put("F03", sb116.toString());
                atVar.f.put("F04", userInfoBean.j);
                java.util.Map map116 = atVar.f;
                java.lang.StringBuilder sb117 = new java.lang.StringBuilder();
                sb117.append(userInfoBean.i);
                map116.put("F05", sb117.toString());
                atVar.f.put("F06", userInfoBean.m);
                java.util.Map map117 = atVar.f;
                java.lang.StringBuilder sb118 = new java.lang.StringBuilder();
                sb118.append(userInfoBean.k);
                map117.put("F10", sb118.toString());
                com.tencent.bugly.opengame.proguard.x.c("summary type %d vm:%d", java.lang.Byte.valueOf(atVar.b), java.lang.Integer.valueOf(atVar.f.size()));
                return atVar;
            default:
                if (i < 10 || i >= 20) {
                    com.tencent.bugly.opengame.proguard.x.e("unknown uinfo type %d ", java.lang.Integer.valueOf(userInfoBean.b));
                    return null;
                }
                b = (byte) i;
                atVar.b = b;
                map = new java.util.HashMap();
                atVar.f = map;
                if (userInfoBean.p >= 0) {
                    java.lang.StringBuilder sb119 = new java.lang.StringBuilder();
                    sb119.append(userInfoBean.p);
                    map.put("C01", sb119.toString());
                }
                if (userInfoBean.q >= 0) {
                    java.util.Map map118 = atVar.f;
                    java.lang.StringBuilder sb1110 = new java.lang.StringBuilder();
                    sb1110.append(userInfoBean.q);
                    map118.put("C02", sb1110.toString());
                }
                map2 = userInfoBean.r;
                if (map2 != null) {
                    while (r0.hasNext()) {
                        atVar.f.put("C03_" + ((java.lang.String) entry.getKey()), entry.getValue());
                    }
                }
                map3 = userInfoBean.s;
                if (map3 != null) {
                    while (r0.hasNext()) {
                        atVar.f.put("C04_" + ((java.lang.String) entry2.getKey()), entry2.getValue());
                    }
                }
                java.util.Map map119 = atVar.f;
                java.lang.StringBuilder sb1111 = new java.lang.StringBuilder();
                sb1111.append(!userInfoBean.l);
                map119.put("A36", sb1111.toString());
                java.util.Map map1110 = atVar.f;
                java.lang.StringBuilder sb1112 = new java.lang.StringBuilder();
                sb1112.append(userInfoBean.g);
                map1110.put("F02", sb1112.toString());
                java.util.Map map1111 = atVar.f;
                java.lang.StringBuilder sb1113 = new java.lang.StringBuilder();
                sb1113.append(userInfoBean.h);
                map1111.put("F03", sb1113.toString());
                atVar.f.put("F04", userInfoBean.j);
                java.util.Map map1112 = atVar.f;
                java.lang.StringBuilder sb1114 = new java.lang.StringBuilder();
                sb1114.append(userInfoBean.i);
                map1112.put("F05", sb1114.toString());
                atVar.f.put("F06", userInfoBean.m);
                java.util.Map map1113 = atVar.f;
                java.lang.StringBuilder sb1115 = new java.lang.StringBuilder();
                sb1115.append(userInfoBean.k);
                map1113.put("F10", sb1115.toString());
                com.tencent.bugly.opengame.proguard.x.c("summary type %d vm:%d", java.lang.Byte.valueOf(atVar.b), java.lang.Integer.valueOf(atVar.f.size()));
                return atVar;
        }
    }

    public static com.tencent.bugly.opengame.proguard.au a(java.util.List list, int i) {
        com.tencent.bugly.opengame.crashreport.common.info.a aVarB;
        if (list == null || list.size() == 0 || (aVarB = com.tencent.bugly.opengame.crashreport.common.info.a.b()) == null) {
            return null;
        }
        aVarB.t();
        com.tencent.bugly.opengame.proguard.au auVar = new com.tencent.bugly.opengame.proguard.au();
        auVar.b = aVarB.d;
        auVar.c = aVarB.h();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.bugly.opengame.proguard.at atVarA = a((com.tencent.bugly.opengame.crashreport.biz.UserInfoBean) it.next());
            if (atVarA != null) {
                arrayList.add(atVarA);
            }
        }
        auVar.d = arrayList;
        java.util.HashMap map = new java.util.HashMap();
        auVar.e = map;
        map.put("A7", aVarB.f);
        auVar.e.put("A6", aVarB.s());
        auVar.e.put("A5", aVarB.r());
        java.util.Map map2 = auVar.e;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(aVarB.p());
        map2.put("A2", sb.toString());
        java.util.Map map3 = auVar.e;
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(aVarB.p());
        map3.put("A1", sb2.toString());
        auVar.e.put("A24", aVarB.h);
        java.util.Map map4 = auVar.e;
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(aVarB.q());
        map4.put("A17", sb3.toString());
        auVar.e.put("A15", aVarB.w());
        java.util.Map map5 = auVar.e;
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append(aVarB.x());
        map5.put("A13", sb4.toString());
        auVar.e.put("F08", aVarB.v);
        auVar.e.put("F09", aVarB.w);
        java.util.Map mapG = aVarB.G();
        if (mapG != null && mapG.size() > 0) {
            for (java.util.Map.Entry entry : mapG.entrySet()) {
                auVar.e.put("C04_" + ((java.lang.String) entry.getKey()), entry.getValue());
            }
        }
        if (i == 1) {
            auVar.f390a = (byte) 1;
        } else {
            if (i != 2) {
                com.tencent.bugly.opengame.proguard.x.e("unknown up type %d ", java.lang.Integer.valueOf(i));
                return null;
            }
            auVar.f390a = (byte) 2;
        }
        return auVar;
    }

    public static com.tencent.bugly.opengame.proguard.k a(byte[] bArr, java.lang.Class cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                com.tencent.bugly.opengame.proguard.k kVar = (com.tencent.bugly.opengame.proguard.k) cls.newInstance();
                com.tencent.bugly.opengame.proguard.i iVar = new com.tencent.bugly.opengame.proguard.i(bArr);
                iVar.a(com.unisound.b.f.b);
                kVar.a(iVar);
                return kVar;
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.opengame.proguard.x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static java.lang.String a(java.util.ArrayList arrayList) {
        java.lang.StringBuilder sb;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            java.lang.String str = (java.lang.String) arrayList.get(i);
            if (str.equals("java.lang.Integer") || str.equals("int")) {
                str = "int32";
            } else if (str.equals("java.lang.Boolean") || str.equals("boolean")) {
                str = "bool";
            } else if (str.equals("java.lang.Byte") || str.equals("byte")) {
                str = "char";
            } else if (str.equals("java.lang.Double") || str.equals("double")) {
                str = "double";
            } else if (str.equals("java.lang.Float") || str.equals("float")) {
                str = "float";
            } else if (str.equals("java.lang.Long") || str.equals("long")) {
                str = "int64";
            } else if (str.equals("java.lang.Short") || str.equals("short")) {
                str = "short";
            } else {
                if (str.equals("java.lang.Character")) {
                    throw new java.lang.IllegalArgumentException("can not support java.lang.Character");
                }
                if (str.equals("java.lang.String")) {
                    str = "string";
                } else if (str.equals("java.util.List")) {
                    str = "list";
                } else if (str.equals("java.util.Map")) {
                    str = "map";
                }
            }
            arrayList.set(i, str);
        }
        java.util.Collections.reverse(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            java.lang.String str2 = (java.lang.String) arrayList.get(i2);
            if (str2.equals("list")) {
                int i3 = i2 - 1;
                arrayList.set(i3, "<" + ((java.lang.String) arrayList.get(i3)));
                sb = new java.lang.StringBuilder();
            } else if (str2.equals("map")) {
                int i4 = i2 - 1;
                arrayList.set(i4, "<" + ((java.lang.String) arrayList.get(i4)) + ",");
                sb = new java.lang.StringBuilder();
            } else {
                if (str2.equals("Array")) {
                    int i5 = i2 - 1;
                    arrayList.set(i5, "<" + ((java.lang.String) arrayList.get(i5)));
                    sb = new java.lang.StringBuilder();
                }
            }
            sb.append((java.lang.String) arrayList.get(0));
            sb.append(">");
            arrayList.set(0, sb.toString());
        }
        java.util.Collections.reverse(arrayList);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((java.lang.String) it.next());
        }
        return stringBuffer.toString();
    }

    public static void a(java.lang.String str, int i) {
        if (android.text.TextUtils.isEmpty(str)) {
            e = null;
        } else {
            e = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(str, i));
        }
    }

    public static void a(java.net.InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            e = null;
        } else {
            e = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(inetAddress, i));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void a(java.util.ArrayList arrayList, java.lang.Object obj) {
        java.lang.Object obj2;
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new java.lang.IllegalArgumentException("only byte[] is supported");
            }
            if (java.lang.reflect.Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                a(arrayList, java.lang.reflect.Array.get(obj, 0));
                return;
            } else {
                arrayList.add("Array");
                arrayList.add(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
                return;
            }
        }
        if (obj instanceof java.lang.reflect.Array) {
            throw new java.lang.IllegalArgumentException("can not support Array, please use List");
        }
        if (obj instanceof java.util.List) {
            arrayList.add("java.util.List");
            java.util.List list = (java.util.List) obj;
            if (list.size() <= 0) {
                arrayList.add(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
                return;
            }
            obj2 = list.get(0);
        } else {
            if (!(obj instanceof java.util.Map)) {
                arrayList.add(obj.getClass().getName());
                return;
            }
            arrayList.add("java.util.Map");
            java.util.Map map = (java.util.Map) obj;
            if (map.size() <= 0) {
                arrayList.add(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
                arrayList.add(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
                return;
            } else {
                java.lang.Object next = map.keySet().iterator().next();
                obj2 = map.get(next);
                arrayList.add(next.getClass().getName());
            }
        }
        a(arrayList, obj2);
    }

    public static byte[] a(com.tencent.bugly.opengame.proguard.k kVar) {
        try {
            com.tencent.bugly.opengame.proguard.j jVar = new com.tencent.bugly.opengame.proguard.j();
            jVar.a(com.unisound.b.f.b);
            kVar.a(jVar);
            return jVar.b();
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.opengame.proguard.x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] a(java.lang.Object obj) {
        try {
            com.tencent.bugly.opengame.proguard.d dVar = new com.tencent.bugly.opengame.proguard.d();
            dVar.c();
            dVar.a(com.unisound.b.f.b);
            dVar.b(1);
            dVar.b("RqdServer");
            dVar.c("sync");
            dVar.a(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, obj);
            return dVar.a();
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.opengame.proguard.x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static java.net.Proxy b() {
        return e;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public void a(java.lang.String str, java.lang.Object obj) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("put key can not is null");
        }
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("put value can not is null");
        }
        if (obj instanceof java.util.Set) {
            throw new java.lang.IllegalArgumentException("can not support Set");
        }
        com.tencent.bugly.opengame.proguard.j jVar = new com.tencent.bugly.opengame.proguard.j();
        jVar.a(this.b);
        jVar.a(obj, 0);
        byte[] bArrA = com.tencent.bugly.opengame.proguard.l.a(jVar.a());
        java.util.HashMap map = new java.util.HashMap(1);
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        a(arrayList, obj);
        map.put(a(arrayList), bArrA);
        this.d.remove(str);
        this.f374a.put(str, map);
    }

    public void a(byte[] bArr) {
        this.c.a(bArr);
        this.c.a(this.b);
        java.util.HashMap map = new java.util.HashMap(1);
        java.util.HashMap map2 = new java.util.HashMap(1);
        map2.put("", new byte[0]);
        map.put("", map2);
        this.f374a = this.c.a((java.util.Map) map, 0, false);
    }

    public byte[] a() {
        com.tencent.bugly.opengame.proguard.j jVar = new com.tencent.bugly.opengame.proguard.j(0);
        jVar.a(this.b);
        jVar.a((java.util.Map) this.f374a, 0);
        return com.tencent.bugly.opengame.proguard.l.a(jVar.a());
    }
}
