package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    private static java.net.Proxy e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, byte[]>> f416a = new java.util.HashMap<>();
    protected java.lang.String b;
    com.tencent.bugly.proguard.i c;
    private java.util.HashMap<java.lang.String, java.lang.Object> d;

    a() {
        new java.util.HashMap();
        this.d = new java.util.HashMap<>();
        this.b = "GBK";
        this.c = new com.tencent.bugly.proguard.i();
    }

    public static com.tencent.bugly.proguard.aj a(int i) {
        if (i == 1) {
            return new com.tencent.bugly.proguard.ai();
        }
        if (i == 3) {
            return new com.tencent.bugly.proguard.ah();
        }
        return null;
    }

    public static com.tencent.bugly.proguard.ap a(android.content.Context context, int i, byte[] bArr) {
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBeanC = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (aVarB == null || strategyBeanC == null) {
            com.tencent.bugly.proguard.x.e("Can not create request pkg for parameters is invalid.", new java.lang.Object[0]);
            return null;
        }
        try {
            com.tencent.bugly.proguard.ap apVar = new com.tencent.bugly.proguard.ap();
            synchronized (aVarB) {
                apVar.f427a = 1;
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
                apVar.p = com.tencent.bugly.crashreport.common.info.b.c(context);
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
                java.util.Map<java.lang.String, java.lang.String> map = apVar.k;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(aVarB.R());
                map.put("A62", sb.toString());
                java.util.Map<java.lang.String, java.lang.String> map2 = apVar.k;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(aVarB.S());
                map2.put("A63", sb2.toString());
                java.util.Map<java.lang.String, java.lang.String> map3 = apVar.k;
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(aVarB.z);
                map3.put("F11", sb3.toString());
                java.util.Map<java.lang.String, java.lang.String> map4 = apVar.k;
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
                if (com.tencent.bugly.b.b != null) {
                    for (com.tencent.bugly.a aVar : com.tencent.bugly.b.b) {
                        if (aVar.versionKey != null && aVar.version != null) {
                            apVar.k.put(aVar.versionKey, aVar.version);
                        }
                    }
                }
                apVar.k.put("G15", com.tencent.bugly.proguard.z.b("G15", ""));
                apVar.k.put("D4", com.tencent.bugly.proguard.z.b("D4", "0"));
            }
            com.tencent.bugly.proguard.u uVarA = com.tencent.bugly.proguard.u.a();
            if (uVarA != null && !uVarA.f448a && bArr != null) {
                apVar.h = com.tencent.bugly.proguard.z.a(apVar.h, 2, 1, strategyBeanC.u);
                if (apVar.h == null) {
                    com.tencent.bugly.proguard.x.e("reqPkg sbuffer error!", new java.lang.Object[0]);
                    return null;
                }
            }
            java.util.Map<java.lang.String, java.lang.String> mapF = aVarB.F();
            if (mapF != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : mapF.entrySet()) {
                    apVar.k.put(entry.getKey(), entry.getValue());
                }
            }
            return apVar;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static com.tencent.bugly.proguard.aq a(byte[] bArr, boolean z) {
        if (bArr != null) {
            try {
                com.tencent.bugly.proguard.d dVar = new com.tencent.bugly.proguard.d();
                dVar.c();
                dVar.a(com.unisound.b.f.b);
                dVar.a(bArr);
                java.lang.Object objB = dVar.b(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, new com.tencent.bugly.proguard.aq());
                com.tencent.bugly.proguard.aq aqVar = com.tencent.bugly.proguard.aq.class.isInstance(objB) ? (com.tencent.bugly.proguard.aq) com.tencent.bugly.proguard.aq.class.cast(objB) : null;
                if (!z && aqVar != null && aqVar.c != null && aqVar.c.length > 0) {
                    com.tencent.bugly.proguard.x.c("resp buf %d", java.lang.Integer.valueOf(aqVar.c.length));
                    aqVar.c = com.tencent.bugly.proguard.z.b(aqVar.c, 2, 1, com.tencent.bugly.crashreport.common.strategy.StrategyBean.d);
                    if (aqVar.c == null) {
                        com.tencent.bugly.proguard.x.e("resp sbuffer error!", new java.lang.Object[0]);
                        return null;
                    }
                }
                return aqVar;
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.proguard.x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static com.tencent.bugly.proguard.at a(com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        com.tencent.bugly.proguard.at atVar = new com.tencent.bugly.proguard.at();
        atVar.f431a = userInfoBean.e;
        atVar.e = userInfoBean.j;
        atVar.d = userInfoBean.c;
        atVar.c = userInfoBean.d;
        atVar.g = com.tencent.bugly.crashreport.common.info.a.b().i();
        atVar.h = userInfoBean.o == 1;
        switch (userInfoBean.b) {
            case 1:
                atVar.b = (byte) 1;
                break;
            case 2:
                atVar.b = (byte) 4;
                break;
            case 3:
                atVar.b = (byte) 2;
                break;
            case 4:
                atVar.b = (byte) 3;
                break;
            default:
                if (userInfoBean.b < 10 || userInfoBean.b >= 20) {
                    com.tencent.bugly.proguard.x.e("unknown uinfo type %d ", java.lang.Integer.valueOf(userInfoBean.b));
                    return null;
                }
                atVar.b = (byte) userInfoBean.b;
                break;
                break;
        }
        atVar.f = new java.util.HashMap();
        if (userInfoBean.p >= 0) {
            java.util.Map<java.lang.String, java.lang.String> map = atVar.f;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(userInfoBean.p);
            map.put("C01", sb.toString());
        }
        if (userInfoBean.q >= 0) {
            java.util.Map<java.lang.String, java.lang.String> map2 = atVar.f;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(userInfoBean.q);
            map2.put("C02", sb2.toString());
        }
        if (userInfoBean.r != null && userInfoBean.r.size() > 0) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : userInfoBean.r.entrySet()) {
                atVar.f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        if (userInfoBean.s != null && userInfoBean.s.size() > 0) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : userInfoBean.s.entrySet()) {
                atVar.f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        java.util.Map<java.lang.String, java.lang.String> map3 = atVar.f;
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(!userInfoBean.l);
        map3.put("A36", sb3.toString());
        java.util.Map<java.lang.String, java.lang.String> map4 = atVar.f;
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append(userInfoBean.g);
        map4.put("F02", sb4.toString());
        java.util.Map<java.lang.String, java.lang.String> map5 = atVar.f;
        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
        sb5.append(userInfoBean.h);
        map5.put("F03", sb5.toString());
        atVar.f.put("F04", userInfoBean.j);
        java.util.Map<java.lang.String, java.lang.String> map6 = atVar.f;
        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
        sb6.append(userInfoBean.i);
        map6.put("F05", sb6.toString());
        atVar.f.put("F06", userInfoBean.m);
        java.util.Map<java.lang.String, java.lang.String> map7 = atVar.f;
        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
        sb7.append(userInfoBean.k);
        map7.put("F10", sb7.toString());
        com.tencent.bugly.proguard.x.c("summary type %d vm:%d", java.lang.Byte.valueOf(atVar.b), java.lang.Integer.valueOf(atVar.f.size()));
        return atVar;
    }

    public static com.tencent.bugly.proguard.au a(java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> list, int i) {
        com.tencent.bugly.crashreport.common.info.a aVarB;
        if (list == null || list.size() == 0 || (aVarB = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        aVarB.t();
        com.tencent.bugly.proguard.au auVar = new com.tencent.bugly.proguard.au();
        auVar.b = aVarB.d;
        auVar.c = aVarB.h();
        java.util.ArrayList<com.tencent.bugly.proguard.at> arrayList = new java.util.ArrayList<>();
        java.util.Iterator<com.tencent.bugly.crashreport.biz.UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            com.tencent.bugly.proguard.at atVarA = a(it.next());
            if (atVarA != null) {
                arrayList.add(atVarA);
            }
        }
        auVar.d = arrayList;
        auVar.e = new java.util.HashMap();
        auVar.e.put("A7", aVarB.f);
        auVar.e.put("A6", aVarB.s());
        auVar.e.put("A5", aVarB.r());
        java.util.Map<java.lang.String, java.lang.String> map = auVar.e;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(aVarB.p());
        map.put("A2", sb.toString());
        java.util.Map<java.lang.String, java.lang.String> map2 = auVar.e;
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(aVarB.p());
        map2.put("A1", sb2.toString());
        auVar.e.put("A24", aVarB.h);
        java.util.Map<java.lang.String, java.lang.String> map3 = auVar.e;
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(aVarB.q());
        map3.put("A17", sb3.toString());
        auVar.e.put("A15", aVarB.w());
        java.util.Map<java.lang.String, java.lang.String> map4 = auVar.e;
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append(aVarB.x());
        map4.put("A13", sb4.toString());
        auVar.e.put("F08", aVarB.v);
        auVar.e.put("F09", aVarB.w);
        java.util.Map<java.lang.String, java.lang.String> mapG = aVarB.G();
        if (mapG != null && mapG.size() > 0) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : mapG.entrySet()) {
                auVar.e.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        switch (i) {
            case 1:
                auVar.f432a = (byte) 1;
                return auVar;
            case 2:
                auVar.f432a = (byte) 2;
                return auVar;
            default:
                com.tencent.bugly.proguard.x.e("unknown up type %d ", java.lang.Integer.valueOf(i));
                return null;
        }
    }

    public static <T extends com.tencent.bugly.proguard.k> T a(byte[] bArr, java.lang.Class<T> cls) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            T tNewInstance = cls.newInstance();
            com.tencent.bugly.proguard.i iVar = new com.tencent.bugly.proguard.i(bArr);
            iVar.a(com.unisound.b.f.b);
            tNewInstance.a(iVar);
            return tNewInstance;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static java.lang.String a(java.util.ArrayList<java.lang.String> arrayList) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            java.lang.String str = arrayList.get(i);
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
            java.lang.String str2 = arrayList.get(i2);
            if (str2.equals("list")) {
                int i3 = i2 - 1;
                arrayList.set(i3, "<" + arrayList.get(i3));
                arrayList.set(0, arrayList.get(0) + ">");
            } else if (str2.equals("map")) {
                int i4 = i2 - 1;
                arrayList.set(i4, "<" + arrayList.get(i4) + ",");
                arrayList.set(0, arrayList.get(0) + ">");
            } else if (str2.equals("Array")) {
                int i5 = i2 - 1;
                arrayList.set(i5, "<" + arrayList.get(i5));
                arrayList.set(0, arrayList.get(0) + ">");
            }
        }
        java.util.Collections.reverse(arrayList);
        java.util.Iterator<java.lang.String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
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

    private void a(java.util.ArrayList<java.lang.String> arrayList, java.lang.Object obj) {
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
            if (list.size() > 0) {
                a(arrayList, list.get(0));
                return;
            } else {
                arrayList.add(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
                return;
            }
        }
        if (!(obj instanceof java.util.Map)) {
            arrayList.add(obj.getClass().getName());
            return;
        }
        arrayList.add("java.util.Map");
        java.util.Map map = (java.util.Map) obj;
        if (map.size() <= 0) {
            arrayList.add(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
            arrayList.add(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
        } else {
            java.lang.Object next = map.keySet().iterator().next();
            java.lang.Object obj2 = map.get(next);
            arrayList.add(next.getClass().getName());
            a(arrayList, obj2);
        }
    }

    public static byte[] a(com.tencent.bugly.proguard.k kVar) {
        try {
            com.tencent.bugly.proguard.j jVar = new com.tencent.bugly.proguard.j();
            jVar.a(com.unisound.b.f.b);
            kVar.a(jVar);
            return jVar.b();
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] a(java.lang.Object obj) {
        try {
            com.tencent.bugly.proguard.d dVar = new com.tencent.bugly.proguard.d();
            dVar.c();
            dVar.a(com.unisound.b.f.b);
            dVar.b(1);
            dVar.b("RqdServer");
            dVar.c("sync");
            dVar.a(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, obj);
            return dVar.a();
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.b(th)) {
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

    public <T> void a(java.lang.String str, T t) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new java.lang.IllegalArgumentException("put value can not is null");
        }
        if (t instanceof java.util.Set) {
            throw new java.lang.IllegalArgumentException("can not support Set");
        }
        com.tencent.bugly.proguard.j jVar = new com.tencent.bugly.proguard.j();
        jVar.a(this.b);
        jVar.a(t, 0);
        byte[] bArrA = com.tencent.bugly.proguard.l.a(jVar.a());
        java.util.HashMap<java.lang.String, byte[]> map = new java.util.HashMap<>(1);
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(1);
        a(arrayList, t);
        map.put(a(arrayList), bArrA);
        this.d.remove(str);
        this.f416a.put(str, map);
    }

    public void a(byte[] bArr) {
        this.c.a(bArr);
        this.c.a(this.b);
        java.util.HashMap map = new java.util.HashMap(1);
        java.util.HashMap map2 = new java.util.HashMap(1);
        map2.put("", new byte[0]);
        map.put("", map2);
        this.f416a = this.c.a((java.util.Map) map, 0, false);
    }

    public byte[] a() {
        com.tencent.bugly.proguard.j jVar = new com.tencent.bugly.proguard.j(0);
        jVar.a(this.b);
        jVar.a((java.util.Map) this.f416a, 0);
        return com.tencent.bugly.proguard.l.a(jVar.a());
    }
}
