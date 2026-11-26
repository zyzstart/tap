package com.tencent.bugly.opengame.crashreport.crash;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f358a;
    private android.content.Context b;
    private com.tencent.bugly.opengame.proguard.u c;
    private com.tencent.bugly.opengame.proguard.p d;
    private com.tencent.bugly.opengame.crashreport.common.strategy.a e;
    private com.tencent.bugly.opengame.proguard.o f;
    private com.tencent.bugly.opengame.BuglyStrategy.a g;

    public b(int i, android.content.Context context, com.tencent.bugly.opengame.proguard.u uVar, com.tencent.bugly.opengame.proguard.p pVar, com.tencent.bugly.opengame.crashreport.common.strategy.a aVar, com.tencent.bugly.opengame.BuglyStrategy.a aVar2, com.tencent.bugly.opengame.proguard.o oVar) {
        f358a = i;
        this.b = context;
        this.c = uVar;
        this.d = pVar;
        this.e = aVar;
        this.g = aVar2;
        this.f = oVar;
    }

    private static com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean a(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean = (com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean) com.tencent.bugly.opengame.proguard.z.a(blob, com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f349a = j;
            }
            return crashDetailBean;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean a(java.util.List list, com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean) {
        java.util.List listB;
        java.lang.String[] strArrSplit;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean2 = null;
        java.util.ArrayList arrayList = new java.util.ArrayList(10);
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.bugly.opengame.crashreport.crash.a aVar = (com.tencent.bugly.opengame.crashreport.crash.a) it.next();
            if (aVar.e) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() > 0 && (listB = b(arrayList)) != null && listB.size() > 0) {
            java.util.Collections.sort(listB);
            com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean3 = null;
            for (int i = 0; i < listB.size(); i++) {
                com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean4 = (com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean) listB.get(i);
                if (i == 0) {
                    crashDetailBean3 = crashDetailBean4;
                } else {
                    java.lang.String str = crashDetailBean4.s;
                    if (str != null && (strArrSplit = str.split("\n")) != null) {
                        for (java.lang.String str2 : strArrSplit) {
                            if (!crashDetailBean3.s.contains(str2)) {
                                crashDetailBean3.t++;
                                crashDetailBean3.s += str2 + "\n";
                            }
                        }
                    }
                }
            }
            crashDetailBean2 = crashDetailBean3;
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        java.util.Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.tencent.bugly.opengame.crashreport.crash.a aVar2 = (com.tencent.bugly.opengame.crashreport.crash.a) it2.next();
            if (!aVar2.e && !aVar2.d) {
                java.lang.String str3 = crashDetailBean2.s;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(aVar2.b);
                if (!str3.contains(sb.toString())) {
                    crashDetailBean2.t++;
                    crashDetailBean2.s += aVar2.b + "\n";
                }
            }
        }
        if (crashDetailBean2.r != crashDetailBean.r) {
            java.lang.String str4 = crashDetailBean2.s;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(crashDetailBean.r);
            if (!str4.contains(sb2.toString())) {
                crashDetailBean2.t++;
                crashDetailBean2.s += crashDetailBean.r + "\n";
            }
        }
        return crashDetailBean2;
    }

    private static com.tencent.bugly.opengame.proguard.am a(java.lang.String str, android.content.Context context, java.lang.String str2) {
        java.lang.Object[] objArr;
        java.lang.String str3;
        java.io.FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            objArr = new java.lang.Object[0];
            str3 = "rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}";
        } else {
            com.tencent.bugly.opengame.proguard.x.c("zip %s", str2);
            java.io.File file = new java.io.File(str2);
            java.io.File file2 = new java.io.File(context.getCacheDir(), str);
            if (com.tencent.bugly.opengame.proguard.z.a(file, file2, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING)) {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    fileInputStream = new java.io.FileInputStream(file2);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                            byteArrayOutputStream.flush();
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.tencent.bugly.opengame.proguard.x.c("read bytes :%d", java.lang.Integer.valueOf(byteArray.length));
                        com.tencent.bugly.opengame.proguard.am amVar = new com.tencent.bugly.opengame.proguard.am((byte) 2, file2.getName(), byteArray);
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e) {
                            if (!com.tencent.bugly.opengame.proguard.x.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        if (file2.exists()) {
                            com.tencent.bugly.opengame.proguard.x.c("del tmp", new java.lang.Object[0]);
                            file2.delete();
                        }
                        return amVar;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        try {
                            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                                th.printStackTrace();
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (java.io.IOException e2) {
                                    if (!com.tencent.bugly.opengame.proguard.x.a(e2)) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            if (file2.exists()) {
                                com.tencent.bugly.opengame.proguard.x.c("del tmp", new java.lang.Object[0]);
                            }
                            return null;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (java.io.IOException e3) {
                                    if (!com.tencent.bugly.opengame.proguard.x.a(e3)) {
                                        e3.printStackTrace();
                                    }
                                }
                            }
                            if (file2.exists()) {
                                com.tencent.bugly.opengame.proguard.x.c("del tmp", new java.lang.Object[0]);
                                file2.delete();
                            }
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            } else {
                objArr = new java.lang.Object[0];
                str3 = "zip fail!";
            }
        }
        com.tencent.bugly.opengame.proguard.x.d(str3, objArr);
        return null;
    }

    private static com.tencent.bugly.opengame.proguard.an a(android.content.Context context, com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean, com.tencent.bugly.opengame.crashreport.common.info.a aVar) {
        java.lang.String str;
        com.tencent.bugly.opengame.proguard.am amVarA;
        com.tencent.bugly.opengame.proguard.am amVarA2;
        com.tencent.bugly.opengame.proguard.am amVar;
        if (context == null || crashDetailBean == null || aVar == null) {
            com.tencent.bugly.opengame.proguard.x.d("enExp args == null", new java.lang.Object[0]);
            return null;
        }
        com.tencent.bugly.opengame.proguard.an anVar = new com.tencent.bugly.opengame.proguard.an();
        int i = crashDetailBean.b;
        switch (i) {
            case 0:
                str = crashDetailBean.j ? "200" : "100";
                anVar.f383a = str;
                break;
            case 1:
                str = crashDetailBean.j ? "201" : "101";
                anVar.f383a = str;
                break;
            case 2:
                str = crashDetailBean.j ? "202" : "102";
                anVar.f383a = str;
                break;
            case 3:
                str = crashDetailBean.j ? "203" : "103";
                anVar.f383a = str;
                break;
            case 4:
                str = crashDetailBean.j ? "204" : "104";
                anVar.f383a = str;
                break;
            case 5:
                str = crashDetailBean.j ? "207" : "107";
                anVar.f383a = str;
                break;
            case 6:
                str = crashDetailBean.j ? "206" : "106";
                anVar.f383a = str;
                break;
            case 7:
                str = crashDetailBean.j ? "208" : "108";
                anVar.f383a = str;
                break;
            default:
                com.tencent.bugly.opengame.proguard.x.e("crash type error! %d", java.lang.Integer.valueOf(i));
                break;
        }
        anVar.b = crashDetailBean.r;
        anVar.c = crashDetailBean.n;
        anVar.d = crashDetailBean.o;
        anVar.e = crashDetailBean.p;
        anVar.g = crashDetailBean.q;
        anVar.h = crashDetailBean.z;
        anVar.i = crashDetailBean.c;
        anVar.j = null;
        anVar.l = crashDetailBean.m;
        anVar.m = crashDetailBean.e;
        anVar.f = crashDetailBean.B;
        anVar.t = com.tencent.bugly.opengame.crashreport.common.info.a.b().i();
        anVar.n = null;
        java.util.Map map = crashDetailBean.i;
        if (map != null && map.size() > 0) {
            anVar.o = new java.util.ArrayList();
            for (java.util.Map.Entry entry : crashDetailBean.i.entrySet()) {
                com.tencent.bugly.opengame.proguard.ak akVar = new com.tencent.bugly.opengame.proguard.ak();
                akVar.f380a = ((com.tencent.bugly.opengame.crashreport.common.info.PlugInBean) entry.getValue()).f341a;
                akVar.c = ((com.tencent.bugly.opengame.crashreport.common.info.PlugInBean) entry.getValue()).c;
                akVar.d = ((com.tencent.bugly.opengame.crashreport.common.info.PlugInBean) entry.getValue()).b;
                akVar.b = aVar.r();
                anVar.o.add(akVar);
            }
        }
        java.util.Map map2 = crashDetailBean.h;
        if (map2 != null && map2.size() > 0) {
            anVar.p = new java.util.ArrayList();
            for (java.util.Map.Entry entry2 : crashDetailBean.h.entrySet()) {
                com.tencent.bugly.opengame.proguard.ak akVar2 = new com.tencent.bugly.opengame.proguard.ak();
                akVar2.f380a = ((com.tencent.bugly.opengame.crashreport.common.info.PlugInBean) entry2.getValue()).f341a;
                akVar2.c = ((com.tencent.bugly.opengame.crashreport.common.info.PlugInBean) entry2.getValue()).c;
                akVar2.d = ((com.tencent.bugly.opengame.crashreport.common.info.PlugInBean) entry2.getValue()).b;
                anVar.p.add(akVar2);
            }
        }
        if (crashDetailBean.j) {
            anVar.k = crashDetailBean.t;
            java.lang.String str2 = crashDetailBean.s;
            if (str2 != null && str2.length() > 0) {
                if (anVar.q == null) {
                    anVar.q = new java.util.ArrayList();
                }
                try {
                    anVar.q.add(new com.tencent.bugly.opengame.proguard.am((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes(com.unisound.b.f.b)));
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                    anVar.q = null;
                }
            }
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = java.lang.Integer.valueOf(anVar.k);
            java.util.ArrayList arrayList = anVar.q;
            objArr[1] = java.lang.Integer.valueOf(arrayList != null ? arrayList.size() : 0);
            com.tencent.bugly.opengame.proguard.x.c("crashcount:%d sz:%d", objArr);
        }
        if (crashDetailBean.w != null) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList();
            }
            try {
                anVar.q.add(new com.tencent.bugly.opengame.proguard.am((byte) 1, "log.txt", crashDetailBean.w.getBytes(com.unisound.b.f.b)));
            } catch (java.io.UnsupportedEncodingException e2) {
                e2.printStackTrace();
                anVar.q = null;
            }
        }
        if (crashDetailBean.x != null) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList();
            }
            try {
                anVar.q.add(new com.tencent.bugly.opengame.proguard.am((byte) 1, "jniLog.txt", crashDetailBean.x.getBytes(com.unisound.b.f.b)));
            } catch (java.io.UnsupportedEncodingException e3) {
                e3.printStackTrace();
                anVar.q = null;
            }
        }
        if (!com.tencent.bugly.opengame.proguard.z.a(crashDetailBean.U)) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList();
            }
            try {
                amVar = new com.tencent.bugly.opengame.proguard.am((byte) 1, "crashInfos.txt", crashDetailBean.U.getBytes(com.unisound.b.f.b));
            } catch (java.io.UnsupportedEncodingException e4) {
                e4.printStackTrace();
                amVar = null;
            }
            if (amVar != null) {
                com.tencent.bugly.opengame.proguard.x.c("attach crash infos", new java.lang.Object[0]);
                anVar.q.add(amVar);
            }
        }
        if (crashDetailBean.V != null) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList();
            }
            com.tencent.bugly.opengame.proguard.am amVarA3 = a("backupRecord.zip", context, crashDetailBean.V);
            if (amVarA3 != null) {
                com.tencent.bugly.opengame.proguard.x.c("attach backup record", new java.lang.Object[0]);
                anVar.q.add(amVarA3);
            }
        }
        byte[] bArr = crashDetailBean.y;
        if (bArr != null && bArr.length > 0) {
            com.tencent.bugly.opengame.proguard.am amVar2 = new com.tencent.bugly.opengame.proguard.am((byte) 2, "buglylog.zip", bArr);
            com.tencent.bugly.opengame.proguard.x.c("attach user log", new java.lang.Object[0]);
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList();
            }
            anVar.q.add(amVar2);
        }
        if (crashDetailBean.b == 3) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList();
            }
            com.tencent.bugly.opengame.proguard.x.c("crashBean.userDatas:%s", crashDetailBean.O);
            java.util.Map map3 = crashDetailBean.O;
            if (map3 != null && map3.containsKey("BUGLY_CR_01")) {
                try {
                    if (!android.text.TextUtils.isEmpty((java.lang.CharSequence) crashDetailBean.O.get("BUGLY_CR_01"))) {
                        anVar.q.add(new com.tencent.bugly.opengame.proguard.am((byte) 1, "anrMessage.txt", ((java.lang.String) crashDetailBean.O.get("BUGLY_CR_01")).getBytes(com.unisound.b.f.b)));
                        com.tencent.bugly.opengame.proguard.x.c("attach anr message", new java.lang.Object[0]);
                    }
                } catch (java.io.UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    anVar.q = null;
                }
                crashDetailBean.O.remove("BUGLY_CR_01");
            }
            java.lang.String str3 = crashDetailBean.v;
            if (str3 != null && (amVarA2 = a("trace.zip", context, str3)) != null) {
                com.tencent.bugly.opengame.proguard.x.c("attach traces", new java.lang.Object[0]);
                anVar.q.add(amVarA2);
            }
        }
        if (crashDetailBean.b == 1) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList();
            }
            java.lang.String str4 = crashDetailBean.v;
            if (str4 != null && (amVarA = a("tomb.zip", context, str4)) != null) {
                com.tencent.bugly.opengame.proguard.x.c("attach tombs", new java.lang.Object[0]);
                anVar.q.add(amVarA);
            }
        }
        java.util.List list = aVar.C;
        if (list != null && !list.isEmpty()) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList();
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Iterator it = aVar.C.iterator();
            while (it.hasNext()) {
                sb.append((java.lang.String) it.next());
            }
            try {
                anVar.q.add(new com.tencent.bugly.opengame.proguard.am((byte) 1, "martianlog.txt", sb.toString().getBytes(com.unisound.b.f.b)));
                com.tencent.bugly.opengame.proguard.x.c("attach pageTracingList", new java.lang.Object[0]);
            } catch (java.io.UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        byte[] bArr2 = crashDetailBean.T;
        if (bArr2 != null && bArr2.length > 0) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList();
            }
            anVar.q.add(new com.tencent.bugly.opengame.proguard.am((byte) 1, "userExtraByteData", crashDetailBean.T));
            com.tencent.bugly.opengame.proguard.x.c("attach extraData", new java.lang.Object[0]);
        }
        java.util.HashMap map4 = new java.util.HashMap();
        anVar.r = map4;
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(crashDetailBean.C);
        map4.put("A9", sb2.toString());
        java.util.Map map5 = anVar.r;
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(crashDetailBean.D);
        map5.put("A11", sb3.toString());
        java.util.Map map6 = anVar.r;
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append(crashDetailBean.E);
        map6.put("A10", sb4.toString());
        anVar.r.put("A23", crashDetailBean.f);
        anVar.r.put("A7", aVar.f);
        anVar.r.put("A6", aVar.s());
        anVar.r.put("A5", aVar.r());
        anVar.r.put("A22", aVar.h());
        java.util.Map map7 = anVar.r;
        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
        sb5.append(crashDetailBean.G);
        map7.put("A2", sb5.toString());
        java.util.Map map8 = anVar.r;
        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
        sb6.append(crashDetailBean.F);
        map8.put("A1", sb6.toString());
        anVar.r.put("A24", aVar.h);
        java.util.Map map9 = anVar.r;
        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
        sb7.append(crashDetailBean.H);
        map9.put("A17", sb7.toString());
        anVar.r.put("A3", aVar.k());
        anVar.r.put("A16", aVar.m());
        anVar.r.put("A25", aVar.n());
        anVar.r.put("A14", aVar.l());
        anVar.r.put("A15", aVar.w());
        java.util.Map map10 = anVar.r;
        java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
        sb8.append(aVar.x());
        map10.put("A13", sb8.toString());
        anVar.r.put("A34", crashDetailBean.A);
        if (aVar.x != null) {
            anVar.r.put("productIdentify", aVar.x);
        }
        try {
            anVar.r.put("A26", java.net.URLEncoder.encode(crashDetailBean.I, com.unisound.b.f.b));
        } catch (java.io.UnsupportedEncodingException e7) {
            e7.printStackTrace();
        }
        if (crashDetailBean.b == 1) {
            anVar.r.put("A27", crashDetailBean.K);
            anVar.r.put("A28", crashDetailBean.J);
            java.util.Map map11 = anVar.r;
            java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
            sb9.append(crashDetailBean.k);
            map11.put("A29", sb9.toString());
        }
        anVar.r.put("A30", crashDetailBean.L);
        java.util.Map map12 = anVar.r;
        java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
        sb10.append(crashDetailBean.M);
        map12.put("A18", sb10.toString());
        java.util.Map map13 = anVar.r;
        java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
        sb11.append(!crashDetailBean.N);
        map13.put("A36", sb11.toString());
        java.util.Map map14 = anVar.r;
        java.lang.StringBuilder sb12 = new java.lang.StringBuilder();
        sb12.append(aVar.q);
        map14.put("F02", sb12.toString());
        java.util.Map map15 = anVar.r;
        java.lang.StringBuilder sb13 = new java.lang.StringBuilder();
        sb13.append(aVar.r);
        map15.put("F03", sb13.toString());
        anVar.r.put("F04", aVar.e());
        java.util.Map map16 = anVar.r;
        java.lang.StringBuilder sb14 = new java.lang.StringBuilder();
        sb14.append(aVar.s);
        map16.put("F05", sb14.toString());
        anVar.r.put("F06", aVar.p);
        anVar.r.put("F08", aVar.v);
        anVar.r.put("F09", aVar.w);
        java.util.Map map17 = anVar.r;
        java.lang.StringBuilder sb15 = new java.lang.StringBuilder();
        sb15.append(aVar.t);
        map17.put("F10", sb15.toString());
        if (crashDetailBean.P >= 0) {
            java.util.Map map18 = anVar.r;
            java.lang.StringBuilder sb16 = new java.lang.StringBuilder();
            sb16.append(crashDetailBean.P);
            map18.put("C01", sb16.toString());
        }
        if (crashDetailBean.Q >= 0) {
            java.util.Map map19 = anVar.r;
            java.lang.StringBuilder sb17 = new java.lang.StringBuilder();
            sb17.append(crashDetailBean.Q);
            map19.put("C02", sb17.toString());
        }
        java.util.Map map20 = crashDetailBean.R;
        if (map20 != null && map20.size() > 0) {
            for (java.util.Map.Entry entry3 : crashDetailBean.R.entrySet()) {
                anVar.r.put("C03_" + ((java.lang.String) entry3.getKey()), entry3.getValue());
            }
        }
        java.util.Map map21 = crashDetailBean.S;
        if (map21 != null && map21.size() > 0) {
            for (java.util.Map.Entry entry4 : crashDetailBean.S.entrySet()) {
                anVar.r.put("C04_" + ((java.lang.String) entry4.getKey()), entry4.getValue());
            }
        }
        anVar.s = null;
        java.util.Map map22 = crashDetailBean.O;
        if (map22 != null && map22.size() > 0) {
            java.util.Map map23 = crashDetailBean.O;
            anVar.s = map23;
            com.tencent.bugly.opengame.proguard.x.a("setted message size %d", java.lang.Integer.valueOf(map23.size()));
        }
        java.lang.Object[] objArr2 = new java.lang.Object[12];
        objArr2[0] = crashDetailBean.n;
        objArr2[1] = crashDetailBean.c;
        objArr2[2] = aVar.e();
        objArr2[3] = java.lang.Long.valueOf((crashDetailBean.r - crashDetailBean.M) / 1000);
        objArr2[4] = java.lang.Boolean.valueOf(crashDetailBean.k);
        objArr2[5] = java.lang.Boolean.valueOf(crashDetailBean.N);
        objArr2[6] = java.lang.Boolean.valueOf(crashDetailBean.j);
        objArr2[7] = java.lang.Boolean.valueOf(crashDetailBean.b == 1);
        objArr2[8] = java.lang.Integer.valueOf(crashDetailBean.t);
        objArr2[9] = crashDetailBean.s;
        objArr2[10] = java.lang.Boolean.valueOf(crashDetailBean.d);
        objArr2[11] = java.lang.Integer.valueOf(anVar.r.size());
        com.tencent.bugly.opengame.proguard.x.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
        return anVar;
    }

    private static java.util.List a(java.util.List list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.bugly.opengame.crashreport.crash.a aVar = (com.tencent.bugly.opengame.crashreport.crash.a) it.next();
            if (aVar.d && aVar.b <= jCurrentTimeMillis - 86400000) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean) {
        java.lang.String str6;
        com.tencent.bugly.opengame.crashreport.common.info.a aVarB = com.tencent.bugly.opengame.crashreport.common.info.a.b();
        if (aVarB == null) {
            return;
        }
        com.tencent.bugly.opengame.proguard.x.e("#++++++++++Record By Bugly++++++++++#", new java.lang.Object[0]);
        com.tencent.bugly.opengame.proguard.x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new java.lang.Object[0]);
        com.tencent.bugly.opengame.proguard.x.e("# PKG NAME: %s", aVarB.c);
        com.tencent.bugly.opengame.proguard.x.e("# APP VER: %s", aVarB.j);
        com.tencent.bugly.opengame.proguard.x.e("# LAUNCH TIME: %s", com.tencent.bugly.opengame.proguard.z.a(new java.util.Date(com.tencent.bugly.opengame.crashreport.common.info.a.b().f342a)));
        com.tencent.bugly.opengame.proguard.x.e("# CRASH TYPE: %s", str);
        com.tencent.bugly.opengame.proguard.x.e("# CRASH TIME: %s", str2);
        com.tencent.bugly.opengame.proguard.x.e("# CRASH PROCESS: %s", str3);
        com.tencent.bugly.opengame.proguard.x.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            com.tencent.bugly.opengame.proguard.x.e("# REPORT ID: %s", crashDetailBean.c);
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = aVarB.g;
            objArr[1] = aVarB.x().booleanValue() ? "ROOTED" : "UNROOT";
            com.tencent.bugly.opengame.proguard.x.e("# CRASH DEVICE: %s %s", objArr);
            com.tencent.bugly.opengame.proguard.x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", java.lang.Long.valueOf(crashDetailBean.C), java.lang.Long.valueOf(crashDetailBean.D), java.lang.Long.valueOf(crashDetailBean.E));
            com.tencent.bugly.opengame.proguard.x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", java.lang.Long.valueOf(crashDetailBean.F), java.lang.Long.valueOf(crashDetailBean.G), java.lang.Long.valueOf(crashDetailBean.H));
            if (!com.tencent.bugly.opengame.proguard.z.a(crashDetailBean.K)) {
                com.tencent.bugly.opengame.proguard.x.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.K, crashDetailBean.J);
            } else if (crashDetailBean.b == 3) {
                java.lang.Object[] objArr2 = new java.lang.Object[1];
                if (crashDetailBean.O == null) {
                    str6 = "null";
                } else {
                    str6 = ((java.lang.String) crashDetailBean.O.get("BUGLY_CR_01"));
                }
                objArr2[0] = str6;
                com.tencent.bugly.opengame.proguard.x.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!com.tencent.bugly.opengame.proguard.z.a(str5)) {
            com.tencent.bugly.opengame.proguard.x.e("# CRASH STACK: ", new java.lang.Object[0]);
            com.tencent.bugly.opengame.proguard.x.e(str5, new java.lang.Object[0]);
        }
        com.tencent.bugly.opengame.proguard.x.e("#++++++++++++++++++++++++++++++++++++++++++#", new java.lang.Object[0]);
    }

    public static void a(boolean z, java.util.List list) {
        if (list != null && list.size() > 0) {
            com.tencent.bugly.opengame.proguard.x.c("up finish update state %b", java.lang.Boolean.valueOf(z));
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean = (com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean) it.next();
                com.tencent.bugly.opengame.proguard.x.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.c, java.lang.Integer.valueOf(crashDetailBean.l), java.lang.Boolean.valueOf(crashDetailBean.d), java.lang.Boolean.valueOf(crashDetailBean.j));
                int i = crashDetailBean.l + 1;
                crashDetailBean.l = i;
                crashDetailBean.d = z;
                com.tencent.bugly.opengame.proguard.x.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.c, java.lang.Integer.valueOf(i), java.lang.Boolean.valueOf(crashDetailBean.d), java.lang.Boolean.valueOf(crashDetailBean.j));
            }
            java.util.Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                com.tencent.bugly.opengame.crashreport.crash.c.a().a((com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean) it2.next());
            }
            com.tencent.bugly.opengame.proguard.x.c("update state size %d", java.lang.Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        com.tencent.bugly.opengame.proguard.x.b("[crash] upload fail.", new java.lang.Object[0]);
    }

    private static com.tencent.bugly.opengame.crashreport.crash.a b(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            com.tencent.bugly.opengame.crashreport.crash.a aVar = new com.tencent.bugly.opengame.crashreport.crash.a();
            aVar.f350a = cursor.getLong(cursor.getColumnIndex("_id"));
            aVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.c = cursor.getString(cursor.getColumnIndex("_s1"));
            aVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            aVar.e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            aVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.util.List b() {
        android.database.Cursor cursorA;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            cursorA = com.tencent.bugly.opengame.proguard.p.a().a("t_cr", new java.lang.String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            }
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("_id in ");
                sb.append("(");
                int i = 0;
                while (cursorA.moveToNext()) {
                    com.tencent.bugly.opengame.crashreport.crash.a aVarB = b(cursorA);
                    if (aVarB != null) {
                        arrayList.add(aVarB);
                    } else {
                        try {
                            sb.append(cursorA.getLong(cursorA.getColumnIndex("_id")));
                            sb.append(",");
                            i++;
                        } catch (java.lang.Throwable unused) {
                            com.tencent.bugly.opengame.proguard.x.d("unknown id!", new java.lang.Object[0]);
                        }
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new java.lang.StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                java.lang.String string = sb.toString();
                sb.setLength(0);
                if (i > 0) {
                    com.tencent.bugly.opengame.proguard.x.d("deleted %s illegal data %d", "t_cr", java.lang.Integer.valueOf(com.tencent.bugly.opengame.proguard.p.a().a("t_cr", string, (java.lang.String[]) null, (com.tencent.bugly.opengame.proguard.o) null, true)));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return arrayList;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    private java.util.List b(java.util.List list) {
        android.database.Cursor cursorA;
        if (list == null || list.size() == 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(((com.tencent.bugly.opengame.crashreport.crash.a) it.next()).f350a);
            sb.append(",");
        }
        java.lang.StringBuilder sb2 = sb.toString().contains(",") ? new java.lang.StringBuilder(sb.substring(0, sb.lastIndexOf(","))) : sb;
        sb2.append(")");
        java.lang.String string = sb2.toString();
        sb2.setLength(0);
        try {
            cursorA = com.tencent.bugly.opengame.proguard.p.a().a("t_cr", null, string, null, null, true);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            }
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                sb2.append("_id in ");
                sb2.append("(");
                int i = 0;
                while (cursorA.moveToNext()) {
                    com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBeanA = a(cursorA);
                    if (crashDetailBeanA != null) {
                        arrayList.add(crashDetailBeanA);
                    } else {
                        try {
                            sb2.append(cursorA.getLong(cursorA.getColumnIndex("_id")));
                            sb2.append(",");
                            i++;
                        } catch (java.lang.Throwable unused) {
                            com.tencent.bugly.opengame.proguard.x.d("unknown id!", new java.lang.Object[0]);
                        }
                    }
                }
                if (sb2.toString().contains(",")) {
                    sb2 = new java.lang.StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                }
                sb2.append(")");
                java.lang.String string2 = sb2.toString();
                if (i > 0) {
                    com.tencent.bugly.opengame.proguard.x.d("deleted %s illegal data %d", "t_cr", java.lang.Integer.valueOf(com.tencent.bugly.opengame.proguard.p.a().a("t_cr", string2, (java.lang.String[]) null, (com.tencent.bugly.opengame.proguard.o) null, true)));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return arrayList;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    private static void c(java.util.List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(((com.tencent.bugly.opengame.crashreport.crash.a) it.next()).f350a);
            sb.append(",");
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        java.lang.String string = sb2.toString();
        sb2.setLength(0);
        try {
            com.tencent.bugly.opengame.proguard.x.c("deleted %s data %d", "t_cr", java.lang.Integer.valueOf(com.tencent.bugly.opengame.proguard.p.a().a("t_cr", string, (java.lang.String[]) null, (com.tencent.bugly.opengame.proguard.o) null, true)));
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void d(java.util.List list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean = (com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean) it.next();
                    sb.append(" or _id");
                    sb.append(" = ");
                    sb.append(crashDetailBean.f349a);
                }
                java.lang.String string = sb.toString();
                if (string.length() > 0) {
                    string = string.substring(4);
                }
                sb.setLength(0);
                com.tencent.bugly.opengame.proguard.x.c("deleted %s data %d", "t_cr", java.lang.Integer.valueOf(com.tencent.bugly.opengame.proguard.p.a().a("t_cr", string, (java.lang.String[]) null, (com.tencent.bugly.opengame.proguard.o) null, true)));
            } catch (java.lang.Throwable th) {
                if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    private static android.content.ContentValues e(com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            if (crashDetailBean.f349a > 0) {
                contentValues.put("_id", java.lang.Long.valueOf(crashDetailBean.f349a));
            }
            contentValues.put("_tm", java.lang.Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            contentValues.put("_up", java.lang.Integer.valueOf(crashDetailBean.d ? 1 : 0));
            contentValues.put("_me", java.lang.Integer.valueOf(crashDetailBean.j ? 1 : 0));
            contentValues.put("_uc", java.lang.Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", com.tencent.bugly.opengame.proguard.z.a(crashDetailBean));
            return contentValues;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final java.util.List a() {
        com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBeanC = com.tencent.bugly.opengame.crashreport.common.strategy.a.a().c();
        if (strategyBeanC == null) {
            com.tencent.bugly.opengame.proguard.x.d("have not synced remote!", new java.lang.Object[0]);
            return null;
        }
        if (!strategyBeanC.g) {
            com.tencent.bugly.opengame.proguard.x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new java.lang.Object[0]);
            com.tencent.bugly.opengame.proguard.x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new java.lang.Object[0]);
            return null;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long jB = com.tencent.bugly.opengame.proguard.z.b();
        java.util.List listB = b();
        com.tencent.bugly.opengame.proguard.x.c("Size of crash list loaded from DB: %s", java.lang.Integer.valueOf(listB.size()));
        if (listB == null || listB.size() <= 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(a(listB));
        listB.removeAll(arrayList);
        java.util.Iterator it = listB.iterator();
        while (it.hasNext()) {
            com.tencent.bugly.opengame.crashreport.crash.a aVar = (com.tencent.bugly.opengame.crashreport.crash.a) it.next();
            long j = aVar.b;
            if (j >= jB - com.tencent.bugly.opengame.crashreport.crash.c.g) {
                if (aVar.d) {
                    if (j >= jCurrentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!aVar.e) {
                    }
                } else if (aVar.f < 3 || j >= jCurrentTimeMillis - 86400000) {
                }
            }
            it.remove();
            arrayList.add(aVar);
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.List listB2 = b(listB);
        if (listB2 != null && listB2.size() > 0) {
            java.lang.String str = com.tencent.bugly.opengame.crashreport.common.info.a.b().j;
            java.util.Iterator it2 = listB2.iterator();
            while (it2.hasNext()) {
                com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean = (com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean) it2.next();
                if (!str.equals(crashDetailBean.f)) {
                    it2.remove();
                    arrayList2.add(crashDetailBean);
                }
            }
        }
        if (arrayList2.size() > 0) {
            d(arrayList2);
        }
        return listB2;
    }

    public final void a(com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean, long j, boolean z) {
        if (com.tencent.bugly.opengame.crashreport.crash.c.l) {
            com.tencent.bugly.opengame.proguard.x.a("try to upload right now", new java.lang.Object[0]);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, 3000L, z, crashDetailBean.b == 7, z);
        }
    }

    public final void a(final java.util.List list, long j, boolean z, boolean z2, boolean z3) {
        com.tencent.bugly.opengame.proguard.u uVar;
        com.tencent.bugly.opengame.proguard.ao aoVar;
        if (com.tencent.bugly.opengame.crashreport.common.info.a.a(this.b).e && (uVar = this.c) != null) {
            if (z3 || uVar.b(com.tencent.bugly.opengame.crashreport.crash.c.f360a)) {
                com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBeanC = this.e.c();
                if (!strategyBeanC.g) {
                    com.tencent.bugly.opengame.proguard.x.d("remote report is disable!", new java.lang.Object[0]);
                    com.tencent.bugly.opengame.proguard.x.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new java.lang.Object[0]);
                    return;
                }
                if (list == null || list.size() == 0) {
                    return;
                }
                try {
                    java.lang.String str = this.c.f406a ? strategyBeanC.s : strategyBeanC.t;
                    java.lang.String str2 = this.c.f406a ? com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.c : com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.f344a;
                    int i = this.c.f406a ? 830 : 630;
                    android.content.Context context = this.b;
                    com.tencent.bugly.opengame.crashreport.common.info.a aVarB = com.tencent.bugly.opengame.crashreport.common.info.a.b();
                    if (context == null || list == null || list.size() == 0 || aVarB == null) {
                        com.tencent.bugly.opengame.proguard.x.d("enEXPPkg args == null!", new java.lang.Object[0]);
                        aoVar = null;
                    } else {
                        aoVar = new com.tencent.bugly.opengame.proguard.ao();
                        aoVar.f384a = new java.util.ArrayList();
                        java.util.Iterator it = list.iterator();
                        while (it.hasNext()) {
                            aoVar.f384a.add(a(context, (com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean) it.next(), aVarB));
                        }
                    }
                    if (aoVar == null) {
                        com.tencent.bugly.opengame.proguard.x.d("create eupPkg fail!", new java.lang.Object[0]);
                        return;
                    }
                    byte[] bArrA = com.tencent.bugly.opengame.proguard.a.a((com.tencent.bugly.opengame.proguard.k) aoVar);
                    if (bArrA == null) {
                        com.tencent.bugly.opengame.proguard.x.d("send encode fail!", new java.lang.Object[0]);
                        return;
                    }
                    com.tencent.bugly.opengame.proguard.ap apVarA = com.tencent.bugly.opengame.proguard.a.a(this.b, i, bArrA);
                    if (apVarA == null) {
                        com.tencent.bugly.opengame.proguard.x.d("request package is null.", new java.lang.Object[0]);
                        return;
                    }
                    com.tencent.bugly.opengame.proguard.t tVar = new com.tencent.bugly.opengame.proguard.t() { // from class: com.tencent.bugly.opengame.crashreport.crash.b.1
                        @Override // com.tencent.bugly.opengame.proguard.t
                        public final void a(boolean z4) {
                            com.tencent.bugly.opengame.crashreport.crash.b.a(z4, list);
                        }
                    };
                    if (z) {
                        this.c.a(f358a, apVarA, str, str2, tVar, j, z2);
                    } else {
                        this.c.a(f358a, apVarA, str, str2, tVar, false);
                    }
                } catch (java.lang.Throwable th) {
                    com.tencent.bugly.opengame.proguard.x.e("req cr error %s", th.toString());
                    if (com.tencent.bugly.opengame.proguard.x.b(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    public final boolean a(com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean) {
        return a(crashDetailBean, -123456789);
    }

    public final boolean a(com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean, int i) {
        java.lang.Object[] objArr;
        java.lang.String str;
        if (crashDetailBean == null) {
            return true;
        }
        java.lang.String str2 = com.tencent.bugly.opengame.crashreport.crash.c.n;
        if (str2 != null && !str2.isEmpty()) {
            com.tencent.bugly.opengame.proguard.x.c("Crash filter for crash stack is: %s", com.tencent.bugly.opengame.crashreport.crash.c.n);
            if (crashDetailBean.q.contains(com.tencent.bugly.opengame.crashreport.crash.c.n)) {
                com.tencent.bugly.opengame.proguard.x.d("This crash contains the filter string set. It will not be record and upload.", new java.lang.Object[0]);
                return true;
            }
        }
        java.lang.String str3 = com.tencent.bugly.opengame.crashreport.crash.c.o;
        if (str3 != null && !str3.isEmpty()) {
            com.tencent.bugly.opengame.proguard.x.c("Crash regular filter for crash stack is: %s", com.tencent.bugly.opengame.crashreport.crash.c.o);
            if (java.util.regex.Pattern.compile(com.tencent.bugly.opengame.crashreport.crash.c.o).matcher(crashDetailBean.q).find()) {
                com.tencent.bugly.opengame.proguard.x.d("This crash matches the regular filter string set. It will not be record and upload.", new java.lang.Object[0]);
                return true;
            }
        }
        int i2 = crashDetailBean.b;
        java.lang.String str4 = crashDetailBean.n;
        java.lang.String str5 = crashDetailBean.o;
        java.lang.String str6 = crashDetailBean.p;
        java.lang.String str7 = crashDetailBean.q;
        long j = crashDetailBean.r;
        java.lang.String str8 = crashDetailBean.m;
        java.lang.String str9 = crashDetailBean.e;
        java.lang.String str10 = crashDetailBean.c;
        java.lang.String str11 = crashDetailBean.A;
        java.lang.String str12 = crashDetailBean.B;
        if (this.f != null) {
            com.tencent.bugly.opengame.proguard.x.c("Calling 'onCrashSaving' of RQD crash listener.", new java.lang.Object[0]);
            if (!this.f.c()) {
                com.tencent.bugly.opengame.proguard.x.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new java.lang.Object[0]);
                return true;
            }
        }
        if (crashDetailBean.b != 2) {
            com.tencent.bugly.opengame.proguard.r rVar = new com.tencent.bugly.opengame.proguard.r();
            rVar.b = 1;
            rVar.c = crashDetailBean.A;
            rVar.d = crashDetailBean.B;
            rVar.e = crashDetailBean.r;
            this.d.b(1);
            this.d.a(rVar);
            objArr = new java.lang.Object[0];
            str = "[crash] a crash occur, handling...";
        } else {
            objArr = new java.lang.Object[0];
            str = "[crash] a caught exception occur, handling...";
        }
        com.tencent.bugly.opengame.proguard.x.b(str, objArr);
        java.util.List<com.tencent.bugly.opengame.crashreport.crash.a> listB = b();
        java.util.ArrayList arrayList = null;
        if (listB != null && listB.size() > 0) {
            arrayList = new java.util.ArrayList(10);
            java.util.ArrayList<com.tencent.bugly.opengame.crashreport.crash.a> arrayList2 = new java.util.ArrayList(10);
            arrayList.addAll(a(listB));
            listB.removeAll(arrayList);
            if (!com.tencent.bugly.opengame.b.c && com.tencent.bugly.opengame.crashreport.crash.c.d) {
                boolean z = false;
                for (com.tencent.bugly.opengame.crashreport.crash.a aVar : listB) {
                    if (crashDetailBean.u.equals(aVar.c)) {
                        if (aVar.e) {
                            z = true;
                        }
                        arrayList2.add(aVar);
                    }
                }
                if (z || arrayList2.size() >= com.tencent.bugly.opengame.crashreport.crash.c.c) {
                    com.tencent.bugly.opengame.proguard.x.a("same crash occur too much do merged!", new java.lang.Object[0]);
                    com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBeanA = a(arrayList2, crashDetailBean);
                    for (com.tencent.bugly.opengame.crashreport.crash.a aVar2 : arrayList2) {
                        if (aVar2.f350a != crashDetailBeanA.f349a) {
                            arrayList.add(aVar2);
                        }
                    }
                    d(crashDetailBeanA);
                    c(arrayList);
                    com.tencent.bugly.opengame.proguard.x.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new java.lang.Object[0]);
                    return true;
                }
            }
        }
        d(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            c(arrayList);
        }
        com.tencent.bugly.opengame.proguard.x.b("[crash] save crash success", new java.lang.Object[0]);
        return false;
    }

    public final void b(com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean) {
        if (this.f != null) {
            com.tencent.bugly.opengame.proguard.x.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new java.lang.Object[0]);
            int i = crashDetailBean.b;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0074  */
    /* JADX WARN: Code duplicated, block: B:73:0x016a A[Catch: all -> 0x0196, TRY_LEAVE, TryCatch #0 {all -> 0x0196, blocks: (B:10:0x0010, B:11:0x0018, B:21:0x002b, B:25:0x003c, B:27:0x0043, B:29:0x0050, B:37:0x0079, B:39:0x007f, B:40:0x0092, B:42:0x0098, B:44:0x00aa, B:46:0x00b8, B:48:0x00be, B:49:0x00cb, B:51:0x00d7, B:53:0x00e3, B:55:0x00fa, B:57:0x011a, B:59:0x0121, B:56:0x0108, B:62:0x0136, B:65:0x0141, B:71:0x0166, B:73:0x016a, B:76:0x016f, B:78:0x0189, B:67:0x014e, B:70:0x0154, B:30:0x005c, B:33:0x0062), top: B:85:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x016d  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    public final void c(com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean) {
        int i;
        java.util.Map mapOnCrashHandleStart;
        byte[] bArrOnCrashHandleStart2GetExtraDatas;
        java.lang.String strSubstring;
        if (crashDetailBean == null) {
            return;
        }
        if (this.g == null && this.f == null) {
            return;
        }
        try {
            com.tencent.bugly.opengame.proguard.x.a("[crash callback] start user's callback:onCrashHandleStart()", new java.lang.Object[0]);
            switch (crashDetailBean.b) {
                case 0:
                    i = 0;
                    break;
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 3;
                    break;
                case 5:
                    i = 5;
                    break;
                case 6:
                    i = 6;
                    break;
                case 7:
                    i = 7;
                    break;
                default:
                    return;
            }
            int i2 = crashDetailBean.b;
            java.lang.String str = crashDetailBean.n;
            java.lang.String str2 = crashDetailBean.p;
            java.lang.String str3 = crashDetailBean.q;
            long j = crashDetailBean.r;
            byte[] bArr = null;
            if (this.f != null) {
                com.tencent.bugly.opengame.proguard.x.c("Calling 'onCrashHandleStart' of RQD crash listener.", new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new java.lang.Object[0]);
                java.lang.String strB = this.f.b();
                if (strB != null) {
                    java.util.HashMap map = new java.util.HashMap(1);
                    map.put("userData", strB);
                    mapOnCrashHandleStart = map;
                } else {
                    mapOnCrashHandleStart = null;
                }
            } else if (this.g != null) {
                com.tencent.bugly.opengame.proguard.x.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new java.lang.Object[0]);
                mapOnCrashHandleStart = this.g.onCrashHandleStart(i, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
            } else {
                mapOnCrashHandleStart = null;
            }
            if (mapOnCrashHandleStart != null && mapOnCrashHandleStart.size() > 0) {
                crashDetailBean.O = new java.util.LinkedHashMap(mapOnCrashHandleStart.size());
                for (java.util.Map.Entry entry : mapOnCrashHandleStart.entrySet()) {
                    if (!com.tencent.bugly.opengame.proguard.z.a((java.lang.String) entry.getKey())) {
                        java.lang.String strSubstring2 = (java.lang.String) entry.getKey();
                        if (strSubstring2.length() > 100) {
                            strSubstring2 = strSubstring2.substring(0, 100);
                            com.tencent.bugly.opengame.proguard.x.d("setted key length is over limit %d substring to %s", 100, strSubstring2);
                        }
                        if (com.tencent.bugly.opengame.proguard.z.a((java.lang.String) entry.getValue()) || ((java.lang.String) entry.getValue()).length() <= 30000) {
                            strSubstring = ((java.lang.String) entry.getValue());
                        } else {
                            strSubstring = ((java.lang.String) entry.getValue()).substring(((java.lang.String) entry.getValue()).length() - 30000);
                            com.tencent.bugly.opengame.proguard.x.d("setted %s value length is over limit %d substring", strSubstring2, 30000);
                        }
                        crashDetailBean.O.put(strSubstring2, strSubstring);
                        com.tencent.bugly.opengame.proguard.x.a("add setted key %s value size:%d", strSubstring2, java.lang.Integer.valueOf(strSubstring.length()));
                    }
                }
            }
            com.tencent.bugly.opengame.proguard.x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new java.lang.Object[0]);
            if (this.f == null) {
                if (this.g != null) {
                    com.tencent.bugly.opengame.proguard.x.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new java.lang.Object[0]);
                    bArrOnCrashHandleStart2GetExtraDatas = this.g.onCrashHandleStart2GetExtraDatas(i, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
                }
                crashDetailBean.T = bArr;
                if (bArr != null) {
                    if (bArr.length > 30000) {
                        com.tencent.bugly.opengame.proguard.x.d("extra bytes size %d is over limit %d will drop over part", java.lang.Integer.valueOf(bArr.length), 30000);
                        crashDetailBean.T = java.util.Arrays.copyOf(bArr, 30000);
                    }
                    com.tencent.bugly.opengame.proguard.x.a("add extra bytes %d ", java.lang.Integer.valueOf(bArr.length));
                }
            }
            com.tencent.bugly.opengame.proguard.x.c("Calling 'getCrashExtraData' of RQD crash listener.", new java.lang.Object[0]);
            bArrOnCrashHandleStart2GetExtraDatas = this.f.a();
            bArr = bArrOnCrashHandleStart2GetExtraDatas;
            crashDetailBean.T = bArr;
            if (bArr != null) {
                if (bArr.length > 30000) {
                    com.tencent.bugly.opengame.proguard.x.d("extra bytes size %d is over limit %d will drop over part", java.lang.Integer.valueOf(bArr.length), 30000);
                    crashDetailBean.T = java.util.Arrays.copyOf(bArr, 30000);
                }
                com.tencent.bugly.opengame.proguard.x.a("add extra bytes %d ", java.lang.Integer.valueOf(bArr.length));
            }
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.opengame.proguard.x.d("crash handle callback something wrong! %s", th.getClass().getName());
            if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void d(com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean) {
        android.content.ContentValues contentValuesE;
        if (crashDetailBean == null || (contentValuesE = e(crashDetailBean)) == null) {
            return;
        }
        long jA = com.tencent.bugly.opengame.proguard.p.a().a("t_cr", contentValuesE, (com.tencent.bugly.opengame.proguard.o) null, true);
        if (jA >= 0) {
            com.tencent.bugly.opengame.proguard.x.c("insert %s success!", "t_cr");
            crashDetailBean.f349a = jA;
        }
    }
}
