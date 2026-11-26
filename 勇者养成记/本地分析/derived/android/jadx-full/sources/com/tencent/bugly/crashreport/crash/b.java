package com.tencent.bugly.crashreport.crash;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f308a;
    private android.content.Context b;
    private com.tencent.bugly.proguard.u c;
    private com.tencent.bugly.proguard.p d;
    private com.tencent.bugly.crashreport.common.strategy.a e;
    private com.tencent.bugly.proguard.o f;
    private com.tencent.bugly.BuglyStrategy.a g;

    public b(int i, android.content.Context context, com.tencent.bugly.proguard.u uVar, com.tencent.bugly.proguard.p pVar, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.BuglyStrategy.a aVar2, com.tencent.bugly.proguard.o oVar) {
        f308a = i;
        this.b = context;
        this.c = uVar;
        this.d = pVar;
        this.e = aVar;
        this.g = aVar2;
        this.f = oVar;
    }

    private static com.tencent.bugly.crashreport.crash.CrashDetailBean a(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean = (com.tencent.bugly.crashreport.crash.CrashDetailBean) com.tencent.bugly.proguard.z.a(blob, com.tencent.bugly.crashreport.crash.CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f299a = j;
            }
            return crashDetailBean;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private com.tencent.bugly.crashreport.crash.CrashDetailBean a(java.util.List<com.tencent.bugly.crashreport.crash.a> list, com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean) {
        java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> listB;
        java.lang.String[] strArrSplit;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean2 = null;
        java.util.ArrayList arrayList = new java.util.ArrayList(10);
        for (com.tencent.bugly.crashreport.crash.a aVar : list) {
            if (aVar.e) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() > 0 && (listB = b(arrayList)) != null && listB.size() > 0) {
            java.util.Collections.sort(listB);
            com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean3 = null;
            for (int i = 0; i < listB.size(); i++) {
                com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean4 = listB.get(i);
                if (i == 0) {
                    crashDetailBean3 = crashDetailBean4;
                } else if (crashDetailBean4.s != null && (strArrSplit = crashDetailBean4.s.split("\n")) != null) {
                    for (java.lang.String str : strArrSplit) {
                        if (!crashDetailBean3.s.contains(str)) {
                            crashDetailBean3.t++;
                            crashDetailBean3.s += str + "\n";
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
        for (com.tencent.bugly.crashreport.crash.a aVar2 : list) {
            if (!aVar2.e && !aVar2.d) {
                java.lang.String str2 = crashDetailBean2.s;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(aVar2.b);
                if (!str2.contains(sb.toString())) {
                    crashDetailBean2.t++;
                    crashDetailBean2.s += aVar2.b + "\n";
                }
            }
        }
        if (crashDetailBean2.r != crashDetailBean.r) {
            java.lang.String str3 = crashDetailBean2.s;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(crashDetailBean.r);
            if (!str3.contains(sb2.toString())) {
                crashDetailBean2.t++;
                crashDetailBean2.s += crashDetailBean.r + "\n";
            }
        }
        return crashDetailBean2;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream] */
    private static com.tencent.bugly.proguard.am a(java.lang.String str, android.content.Context context, java.lang.String str2) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            com.tencent.bugly.proguard.x.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new java.lang.Object[0]);
            return null;
        }
        com.tencent.bugly.proguard.x.c("zip %s", str2);
        java.io.File file = new java.io.File(str2);
        ?? cacheDir = context.getCacheDir();
        java.io.File file2 = new java.io.File((java.io.File) cacheDir, str);
        if (!com.tencent.bugly.proguard.z.a(file, file2, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING)) {
            com.tencent.bugly.proguard.x.d("zip fail!", new java.lang.Object[0]);
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
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
                    com.tencent.bugly.proguard.x.c("read bytes :%d", java.lang.Integer.valueOf(byteArray.length));
                    com.tencent.bugly.proguard.am amVar = new com.tencent.bugly.proguard.am((byte) 2, file2.getName(), byteArray);
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException e) {
                        if (!com.tencent.bugly.proguard.x.a(e)) {
                            e.printStackTrace();
                        }
                    }
                    if (file2.exists()) {
                        com.tencent.bugly.proguard.x.c("del tmp", new java.lang.Object[0]);
                        file2.delete();
                    }
                    return amVar;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (!com.tencent.bugly.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e2) {
                            if (!com.tencent.bugly.proguard.x.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        com.tencent.bugly.proguard.x.c("del tmp", new java.lang.Object[0]);
                        file2.delete();
                    }
                    return null;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (cacheDir != 0) {
                    try {
                        cacheDir.close();
                    } catch (java.io.IOException e3) {
                        if (!com.tencent.bugly.proguard.x.a(e3)) {
                            e3.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    com.tencent.bugly.proguard.x.c("del tmp", new java.lang.Object[0]);
                    file2.delete();
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            cacheDir = 0;
            if (cacheDir != 0) {
                cacheDir.close();
            }
            if (file2.exists()) {
                com.tencent.bugly.proguard.x.c("del tmp", new java.lang.Object[0]);
                file2.delete();
            }
            throw th;
        }
    }

    private static com.tencent.bugly.proguard.an a(android.content.Context context, com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) throws java.lang.Throwable {
        com.tencent.bugly.proguard.am amVarA;
        com.tencent.bugly.proguard.am amVarA2;
        com.tencent.bugly.proguard.am amVar;
        if (context == null || crashDetailBean == null || aVar == null) {
            com.tencent.bugly.proguard.x.d("enExp args == null", new java.lang.Object[0]);
            return null;
        }
        com.tencent.bugly.proguard.an anVar = new com.tencent.bugly.proguard.an();
        switch (crashDetailBean.b) {
            case 0:
                anVar.f425a = crashDetailBean.j ? "200" : "100";
                break;
            case 1:
                anVar.f425a = crashDetailBean.j ? "201" : "101";
                break;
            case 2:
                anVar.f425a = crashDetailBean.j ? "202" : "102";
                break;
            case 3:
                anVar.f425a = crashDetailBean.j ? "203" : "103";
                break;
            case 4:
                anVar.f425a = crashDetailBean.j ? "204" : "104";
                break;
            case 5:
                anVar.f425a = crashDetailBean.j ? "207" : "107";
                break;
            case 6:
                anVar.f425a = crashDetailBean.j ? "206" : "106";
                break;
            case 7:
                anVar.f425a = crashDetailBean.j ? "208" : "108";
                break;
            default:
                com.tencent.bugly.proguard.x.e("crash type error! %d", java.lang.Integer.valueOf(crashDetailBean.b));
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
        anVar.t = com.tencent.bugly.crashreport.common.info.a.b().i();
        anVar.n = null;
        if (crashDetailBean.i != null && crashDetailBean.i.size() > 0) {
            anVar.o = new java.util.ArrayList<>();
            for (java.util.Map.Entry<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> entry : crashDetailBean.i.entrySet()) {
                com.tencent.bugly.proguard.ak akVar = new com.tencent.bugly.proguard.ak();
                akVar.f422a = entry.getValue().f291a;
                akVar.c = entry.getValue().c;
                akVar.d = entry.getValue().b;
                akVar.b = aVar.r();
                anVar.o.add(akVar);
            }
        }
        if (crashDetailBean.h != null && crashDetailBean.h.size() > 0) {
            anVar.p = new java.util.ArrayList<>();
            for (java.util.Map.Entry<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> entry2 : crashDetailBean.h.entrySet()) {
                com.tencent.bugly.proguard.ak akVar2 = new com.tencent.bugly.proguard.ak();
                akVar2.f422a = entry2.getValue().f291a;
                akVar2.c = entry2.getValue().c;
                akVar2.d = entry2.getValue().b;
                anVar.p.add(akVar2);
            }
        }
        if (crashDetailBean.j) {
            anVar.k = crashDetailBean.t;
            if (crashDetailBean.s != null && crashDetailBean.s.length() > 0) {
                if (anVar.q == null) {
                    anVar.q = new java.util.ArrayList<>();
                }
                try {
                    anVar.q.add(new com.tencent.bugly.proguard.am((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes(com.unisound.b.f.b)));
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                    anVar.q = null;
                }
            }
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = java.lang.Integer.valueOf(anVar.k);
            objArr[1] = java.lang.Integer.valueOf(anVar.q != null ? anVar.q.size() : 0);
            com.tencent.bugly.proguard.x.c("crashcount:%d sz:%d", objArr);
        }
        if (crashDetailBean.w != null) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList<>();
            }
            try {
                anVar.q.add(new com.tencent.bugly.proguard.am((byte) 1, "log.txt", crashDetailBean.w.getBytes(com.unisound.b.f.b)));
            } catch (java.io.UnsupportedEncodingException e2) {
                e2.printStackTrace();
                anVar.q = null;
            }
        }
        if (crashDetailBean.x != null) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList<>();
            }
            try {
                anVar.q.add(new com.tencent.bugly.proguard.am((byte) 1, "jniLog.txt", crashDetailBean.x.getBytes(com.unisound.b.f.b)));
            } catch (java.io.UnsupportedEncodingException e3) {
                e3.printStackTrace();
                anVar.q = null;
            }
        }
        if (!com.tencent.bugly.proguard.z.a(crashDetailBean.U)) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList<>();
            }
            try {
                amVar = new com.tencent.bugly.proguard.am((byte) 1, "crashInfos.txt", crashDetailBean.U.getBytes(com.unisound.b.f.b));
            } catch (java.io.UnsupportedEncodingException e4) {
                e4.printStackTrace();
                amVar = null;
            }
            if (amVar != null) {
                com.tencent.bugly.proguard.x.c("attach crash infos", new java.lang.Object[0]);
                anVar.q.add(amVar);
            }
        }
        if (crashDetailBean.V != null) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList<>();
            }
            com.tencent.bugly.proguard.am amVarA3 = a("backupRecord.zip", context, crashDetailBean.V);
            if (amVarA3 != null) {
                com.tencent.bugly.proguard.x.c("attach backup record", new java.lang.Object[0]);
                anVar.q.add(amVarA3);
            }
        }
        if (crashDetailBean.y != null && crashDetailBean.y.length > 0) {
            com.tencent.bugly.proguard.am amVar2 = new com.tencent.bugly.proguard.am((byte) 2, "buglylog.zip", crashDetailBean.y);
            com.tencent.bugly.proguard.x.c("attach user log", new java.lang.Object[0]);
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList<>();
            }
            anVar.q.add(amVar2);
        }
        if (crashDetailBean.b == 3) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList<>();
            }
            com.tencent.bugly.proguard.x.c("crashBean.userDatas:%s", crashDetailBean.O);
            if (crashDetailBean.O != null && crashDetailBean.O.containsKey("BUGLY_CR_01")) {
                try {
                    if (!android.text.TextUtils.isEmpty(crashDetailBean.O.get("BUGLY_CR_01"))) {
                        anVar.q.add(new com.tencent.bugly.proguard.am((byte) 1, "anrMessage.txt", crashDetailBean.O.get("BUGLY_CR_01").getBytes(com.unisound.b.f.b)));
                        com.tencent.bugly.proguard.x.c("attach anr message", new java.lang.Object[0]);
                    }
                } catch (java.io.UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    anVar.q = null;
                }
                crashDetailBean.O.remove("BUGLY_CR_01");
            }
            if (crashDetailBean.v != null && (amVarA2 = a("trace.zip", context, crashDetailBean.v)) != null) {
                com.tencent.bugly.proguard.x.c("attach traces", new java.lang.Object[0]);
                anVar.q.add(amVarA2);
            }
        }
        if (crashDetailBean.b == 1) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList<>();
            }
            if (crashDetailBean.v != null && (amVarA = a("tomb.zip", context, crashDetailBean.v)) != null) {
                com.tencent.bugly.proguard.x.c("attach tombs", new java.lang.Object[0]);
                anVar.q.add(amVarA);
            }
        }
        if (aVar.C != null && !aVar.C.isEmpty()) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList<>();
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Iterator<java.lang.String> it = aVar.C.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            try {
                anVar.q.add(new com.tencent.bugly.proguard.am((byte) 1, "martianlog.txt", sb.toString().getBytes(com.unisound.b.f.b)));
                com.tencent.bugly.proguard.x.c("attach pageTracingList", new java.lang.Object[0]);
            } catch (java.io.UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        if (crashDetailBean.T != null && crashDetailBean.T.length > 0) {
            if (anVar.q == null) {
                anVar.q = new java.util.ArrayList<>();
            }
            anVar.q.add(new com.tencent.bugly.proguard.am((byte) 1, "userExtraByteData", crashDetailBean.T));
            com.tencent.bugly.proguard.x.c("attach extraData", new java.lang.Object[0]);
        }
        anVar.r = new java.util.HashMap();
        java.util.Map<java.lang.String, java.lang.String> map = anVar.r;
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(crashDetailBean.C);
        map.put("A9", sb2.toString());
        java.util.Map<java.lang.String, java.lang.String> map2 = anVar.r;
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(crashDetailBean.D);
        map2.put("A11", sb3.toString());
        java.util.Map<java.lang.String, java.lang.String> map3 = anVar.r;
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append(crashDetailBean.E);
        map3.put("A10", sb4.toString());
        anVar.r.put("A23", crashDetailBean.f);
        anVar.r.put("A7", aVar.f);
        anVar.r.put("A6", aVar.s());
        anVar.r.put("A5", aVar.r());
        anVar.r.put("A22", aVar.h());
        java.util.Map<java.lang.String, java.lang.String> map4 = anVar.r;
        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
        sb5.append(crashDetailBean.G);
        map4.put("A2", sb5.toString());
        java.util.Map<java.lang.String, java.lang.String> map5 = anVar.r;
        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
        sb6.append(crashDetailBean.F);
        map5.put("A1", sb6.toString());
        anVar.r.put("A24", aVar.h);
        java.util.Map<java.lang.String, java.lang.String> map6 = anVar.r;
        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
        sb7.append(crashDetailBean.H);
        map6.put("A17", sb7.toString());
        anVar.r.put("A3", aVar.k());
        anVar.r.put("A16", aVar.m());
        anVar.r.put("A25", aVar.n());
        anVar.r.put("A14", aVar.l());
        anVar.r.put("A15", aVar.w());
        java.util.Map<java.lang.String, java.lang.String> map7 = anVar.r;
        java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
        sb8.append(aVar.x());
        map7.put("A13", sb8.toString());
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
            java.util.Map<java.lang.String, java.lang.String> map8 = anVar.r;
            java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
            sb9.append(crashDetailBean.k);
            map8.put("A29", sb9.toString());
        }
        anVar.r.put("A30", crashDetailBean.L);
        java.util.Map<java.lang.String, java.lang.String> map9 = anVar.r;
        java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
        sb10.append(crashDetailBean.M);
        map9.put("A18", sb10.toString());
        java.util.Map<java.lang.String, java.lang.String> map10 = anVar.r;
        java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
        sb11.append(!crashDetailBean.N);
        map10.put("A36", sb11.toString());
        java.util.Map<java.lang.String, java.lang.String> map11 = anVar.r;
        java.lang.StringBuilder sb12 = new java.lang.StringBuilder();
        sb12.append(aVar.q);
        map11.put("F02", sb12.toString());
        java.util.Map<java.lang.String, java.lang.String> map12 = anVar.r;
        java.lang.StringBuilder sb13 = new java.lang.StringBuilder();
        sb13.append(aVar.r);
        map12.put("F03", sb13.toString());
        anVar.r.put("F04", aVar.e());
        java.util.Map<java.lang.String, java.lang.String> map13 = anVar.r;
        java.lang.StringBuilder sb14 = new java.lang.StringBuilder();
        sb14.append(aVar.s);
        map13.put("F05", sb14.toString());
        anVar.r.put("F06", aVar.p);
        anVar.r.put("F08", aVar.v);
        anVar.r.put("F09", aVar.w);
        java.util.Map<java.lang.String, java.lang.String> map14 = anVar.r;
        java.lang.StringBuilder sb15 = new java.lang.StringBuilder();
        sb15.append(aVar.t);
        map14.put("F10", sb15.toString());
        if (crashDetailBean.P >= 0) {
            java.util.Map<java.lang.String, java.lang.String> map15 = anVar.r;
            java.lang.StringBuilder sb16 = new java.lang.StringBuilder();
            sb16.append(crashDetailBean.P);
            map15.put("C01", sb16.toString());
        }
        if (crashDetailBean.Q >= 0) {
            java.util.Map<java.lang.String, java.lang.String> map16 = anVar.r;
            java.lang.StringBuilder sb17 = new java.lang.StringBuilder();
            sb17.append(crashDetailBean.Q);
            map16.put("C02", sb17.toString());
        }
        if (crashDetailBean.R != null && crashDetailBean.R.size() > 0) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry3 : crashDetailBean.R.entrySet()) {
                anVar.r.put("C03_" + entry3.getKey(), entry3.getValue());
            }
        }
        if (crashDetailBean.S != null && crashDetailBean.S.size() > 0) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry4 : crashDetailBean.S.entrySet()) {
                anVar.r.put("C04_" + entry4.getKey(), entry4.getValue());
            }
        }
        anVar.s = null;
        if (crashDetailBean.O != null && crashDetailBean.O.size() > 0) {
            anVar.s = crashDetailBean.O;
            com.tencent.bugly.proguard.x.a("setted message size %d", java.lang.Integer.valueOf(anVar.s.size()));
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
        com.tencent.bugly.proguard.x.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
        return anVar;
    }

    private static java.util.List<com.tencent.bugly.crashreport.crash.a> a(java.util.List<com.tencent.bugly.crashreport.crash.a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.tencent.bugly.crashreport.crash.a aVar : list) {
            if (aVar.d && aVar.b <= jCurrentTimeMillis - 86400000) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean) {
        java.lang.String str6;
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        if (aVarB == null) {
            return;
        }
        com.tencent.bugly.proguard.x.e("#++++++++++Record By Bugly++++++++++#", new java.lang.Object[0]);
        com.tencent.bugly.proguard.x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new java.lang.Object[0]);
        com.tencent.bugly.proguard.x.e("# PKG NAME: %s", aVarB.c);
        com.tencent.bugly.proguard.x.e("# APP VER: %s", aVarB.j);
        com.tencent.bugly.proguard.x.e("# LAUNCH TIME: %s", com.tencent.bugly.proguard.z.a(new java.util.Date(com.tencent.bugly.crashreport.common.info.a.b().f292a)));
        com.tencent.bugly.proguard.x.e("# CRASH TYPE: %s", str);
        com.tencent.bugly.proguard.x.e("# CRASH TIME: %s", str2);
        com.tencent.bugly.proguard.x.e("# CRASH PROCESS: %s", str3);
        com.tencent.bugly.proguard.x.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            com.tencent.bugly.proguard.x.e("# REPORT ID: %s", crashDetailBean.c);
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = aVarB.g;
            objArr[1] = aVarB.x().booleanValue() ? "ROOTED" : "UNROOT";
            com.tencent.bugly.proguard.x.e("# CRASH DEVICE: %s %s", objArr);
            com.tencent.bugly.proguard.x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", java.lang.Long.valueOf(crashDetailBean.C), java.lang.Long.valueOf(crashDetailBean.D), java.lang.Long.valueOf(crashDetailBean.E));
            com.tencent.bugly.proguard.x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", java.lang.Long.valueOf(crashDetailBean.F), java.lang.Long.valueOf(crashDetailBean.G), java.lang.Long.valueOf(crashDetailBean.H));
            if (!com.tencent.bugly.proguard.z.a(crashDetailBean.K)) {
                com.tencent.bugly.proguard.x.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.K, crashDetailBean.J);
            } else if (crashDetailBean.b == 3) {
                java.lang.Object[] objArr2 = new java.lang.Object[1];
                if (crashDetailBean.O == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.O.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                com.tencent.bugly.proguard.x.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!com.tencent.bugly.proguard.z.a(str5)) {
            com.tencent.bugly.proguard.x.e("# CRASH STACK: ", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.e(str5, new java.lang.Object[0]);
        }
        com.tencent.bugly.proguard.x.e("#++++++++++++++++++++++++++++++++++++++++++#", new java.lang.Object[0]);
    }

    public static void a(boolean z, java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            com.tencent.bugly.proguard.x.c("up finish update state %b", java.lang.Boolean.valueOf(z));
            for (com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean : list) {
                com.tencent.bugly.proguard.x.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.c, java.lang.Integer.valueOf(crashDetailBean.l), java.lang.Boolean.valueOf(crashDetailBean.d), java.lang.Boolean.valueOf(crashDetailBean.j));
                crashDetailBean.l++;
                crashDetailBean.d = z;
                com.tencent.bugly.proguard.x.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.c, java.lang.Integer.valueOf(crashDetailBean.l), java.lang.Boolean.valueOf(crashDetailBean.d), java.lang.Boolean.valueOf(crashDetailBean.j));
            }
            java.util.Iterator<com.tencent.bugly.crashreport.crash.CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                com.tencent.bugly.crashreport.crash.c.a().a(it.next());
            }
            com.tencent.bugly.proguard.x.c("update state size %d", java.lang.Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        com.tencent.bugly.proguard.x.b("[crash] upload fail.", new java.lang.Object[0]);
    }

    private static com.tencent.bugly.crashreport.crash.a b(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            com.tencent.bugly.crashreport.crash.a aVar = new com.tencent.bugly.crashreport.crash.a();
            aVar.f300a = cursor.getLong(cursor.getColumnIndex("_id"));
            aVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.c = cursor.getString(cursor.getColumnIndex("_s1"));
            aVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            aVar.e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            aVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.util.List<com.tencent.bugly.crashreport.crash.a> b() throws java.lang.Throwable {
        android.database.Cursor cursorA;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            try {
                cursorA = com.tencent.bugly.proguard.p.a().a("t_cr", new java.lang.String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
                if (cursorA == null) {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    return null;
                }
                try {
                    try {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("_id in ");
                        sb.append("(");
                        int i = 0;
                        while (cursorA.moveToNext()) {
                            com.tencent.bugly.crashreport.crash.a aVarB = b(cursorA);
                            if (aVarB != null) {
                                arrayList.add(aVarB);
                            } else {
                                try {
                                    sb.append(cursorA.getLong(cursorA.getColumnIndex("_id")));
                                    sb.append(",");
                                    i++;
                                } catch (java.lang.Throwable unused) {
                                    com.tencent.bugly.proguard.x.d("unknown id!", new java.lang.Object[0]);
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
                            com.tencent.bugly.proguard.x.d("deleted %s illegal data %d", "t_cr", java.lang.Integer.valueOf(com.tencent.bugly.proguard.p.a().a("t_cr", string, (java.lang.String[]) null, (com.tencent.bugly.proguard.o) null, true)));
                        }
                        if (cursorA != null) {
                            cursorA.close();
                        }
                        return arrayList;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        cursor = cursorA;
                        if (!com.tencent.bugly.proguard.x.a(th)) {
                            th.printStackTrace();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                cursorA = null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0118  */
    private java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> b(java.util.List<com.tencent.bugly.crashreport.crash.a> list) throws java.lang.Throwable {
        android.database.Cursor cursorA;
        if (list == null || list.size() == 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        java.util.Iterator<com.tencent.bugly.crashreport.crash.a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f300a);
            sb.append(",");
        }
        java.lang.StringBuilder sb2 = sb.toString().contains(",") ? new java.lang.StringBuilder(sb.substring(0, sb.lastIndexOf(","))) : sb;
        sb2.append(")");
        java.lang.String string = sb2.toString();
        sb2.setLength(0);
        try {
            cursorA = com.tencent.bugly.proguard.p.a().a("t_cr", null, string, null, null, true);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            }
            try {
                try {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    sb2.append("_id in ");
                    sb2.append("(");
                    int i = 0;
                    while (cursorA.moveToNext()) {
                        com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBeanA = a(cursorA);
                        if (crashDetailBeanA != null) {
                            arrayList.add(crashDetailBeanA);
                        } else {
                            try {
                                sb2.append(cursorA.getLong(cursorA.getColumnIndex("_id")));
                                sb2.append(",");
                                i++;
                            } catch (java.lang.Throwable unused) {
                                com.tencent.bugly.proguard.x.d("unknown id!", new java.lang.Object[0]);
                            }
                        }
                    }
                    if (sb2.toString().contains(",")) {
                        sb2 = new java.lang.StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                    }
                    sb2.append(")");
                    java.lang.String string2 = sb2.toString();
                    if (i > 0) {
                        com.tencent.bugly.proguard.x.d("deleted %s illegal data %d", "t_cr", java.lang.Integer.valueOf(com.tencent.bugly.proguard.p.a().a("t_cr", string2, (java.lang.String[]) null, (com.tencent.bugly.proguard.o) null, true)));
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    return arrayList;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (!com.tencent.bugly.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    return null;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (cursorA != null) {
                    cursorA.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursorA = null;
        }
    }

    private static void c(java.util.List<com.tencent.bugly.crashreport.crash.a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        java.util.Iterator<com.tencent.bugly.crashreport.crash.a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f300a);
            sb.append(",");
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        java.lang.String string = sb2.toString();
        sb2.setLength(0);
        try {
            com.tencent.bugly.proguard.x.c("deleted %s data %d", "t_cr", java.lang.Integer.valueOf(com.tencent.bugly.proguard.p.a().a("t_cr", string, (java.lang.String[]) null, (com.tencent.bugly.proguard.o) null, true)));
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void d(java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean : list) {
                    sb.append(" or _id");
                    sb.append(" = ");
                    sb.append(crashDetailBean.f299a);
                }
                java.lang.String string = sb.toString();
                java.lang.String strSubstring = string.length() > 0 ? string.substring(4) : string;
                sb.setLength(0);
                com.tencent.bugly.proguard.x.c("deleted %s data %d", "t_cr", java.lang.Integer.valueOf(com.tencent.bugly.proguard.p.a().a("t_cr", strSubstring, (java.lang.String[]) null, (com.tencent.bugly.proguard.o) null, true)));
            } catch (java.lang.Throwable th) {
                if (com.tencent.bugly.proguard.x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    private static android.content.ContentValues e(com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            if (crashDetailBean.f299a > 0) {
                contentValues.put("_id", java.lang.Long.valueOf(crashDetailBean.f299a));
            }
            contentValues.put("_tm", java.lang.Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            int i = 1;
            contentValues.put("_up", java.lang.Integer.valueOf(crashDetailBean.d ? 1 : 0));
            if (!crashDetailBean.j) {
                i = 0;
            }
            contentValues.put("_me", java.lang.Integer.valueOf(i));
            contentValues.put("_uc", java.lang.Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", com.tencent.bugly.proguard.z.a(crashDetailBean));
            return contentValues;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> a() throws java.lang.Throwable {
        com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBeanC = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (strategyBeanC == null) {
            com.tencent.bugly.proguard.x.d("have not synced remote!", new java.lang.Object[0]);
            return null;
        }
        if (!strategyBeanC.g) {
            com.tencent.bugly.proguard.x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new java.lang.Object[0]);
            return null;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long jB = com.tencent.bugly.proguard.z.b();
        java.util.List<com.tencent.bugly.crashreport.crash.a> listB = b();
        com.tencent.bugly.proguard.x.c("Size of crash list loaded from DB: %s", java.lang.Integer.valueOf(listB.size()));
        if (listB == null || listB.size() <= 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(a(listB));
        listB.removeAll(arrayList);
        java.util.Iterator<com.tencent.bugly.crashreport.crash.a> it = listB.iterator();
        while (it.hasNext()) {
            com.tencent.bugly.crashreport.crash.a next = it.next();
            if (next.b < jB - com.tencent.bugly.crashreport.crash.c.g) {
                it.remove();
                arrayList.add(next);
            } else if (next.d) {
                if (next.b >= jCurrentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f >= 3 && next.b < jCurrentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> listB2 = b(listB);
        if (listB2 != null && listB2.size() > 0) {
            java.lang.String str = com.tencent.bugly.crashreport.common.info.a.b().j;
            java.util.Iterator<com.tencent.bugly.crashreport.crash.CrashDetailBean> it2 = listB2.iterator();
            while (it2.hasNext()) {
                com.tencent.bugly.crashreport.crash.CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f)) {
                    it2.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            d(arrayList2);
        }
        return listB2;
    }

    public final void a(com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean, long j, boolean z) {
        if (com.tencent.bugly.crashreport.crash.c.l) {
            com.tencent.bugly.proguard.x.a("try to upload right now", new java.lang.Object[0]);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, 3000L, z, crashDetailBean.b == 7, z);
        }
    }

    public final void a(final java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> list, long j, boolean z, boolean z2, boolean z3) {
        com.tencent.bugly.proguard.u uVar;
        com.tencent.bugly.proguard.ao aoVar;
        if (com.tencent.bugly.crashreport.common.info.a.a(this.b).e && (uVar = this.c) != null) {
            if (z3 || uVar.b(com.tencent.bugly.crashreport.crash.c.f310a)) {
                com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBeanC = this.e.c();
                if (!strategyBeanC.g) {
                    com.tencent.bugly.proguard.x.d("remote report is disable!", new java.lang.Object[0]);
                    com.tencent.bugly.proguard.x.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new java.lang.Object[0]);
                    return;
                }
                if (list == null || list.size() == 0) {
                    return;
                }
                try {
                    java.lang.String str = this.c.f448a ? strategyBeanC.s : strategyBeanC.t;
                    java.lang.String str2 = this.c.f448a ? com.tencent.bugly.crashreport.common.strategy.StrategyBean.c : com.tencent.bugly.crashreport.common.strategy.StrategyBean.f294a;
                    int i = this.c.f448a ? 830 : 630;
                    android.content.Context context = this.b;
                    com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
                    if (context == null || list == null || list.size() == 0 || aVarB == null) {
                        com.tencent.bugly.proguard.x.d("enEXPPkg args == null!", new java.lang.Object[0]);
                        aoVar = null;
                    } else {
                        aoVar = new com.tencent.bugly.proguard.ao();
                        aoVar.f426a = new java.util.ArrayList<>();
                        java.util.Iterator<com.tencent.bugly.crashreport.crash.CrashDetailBean> it = list.iterator();
                        while (it.hasNext()) {
                            aoVar.f426a.add(a(context, it.next(), aVarB));
                        }
                    }
                    if (aoVar == null) {
                        com.tencent.bugly.proguard.x.d("create eupPkg fail!", new java.lang.Object[0]);
                        return;
                    }
                    byte[] bArrA = com.tencent.bugly.proguard.a.a((com.tencent.bugly.proguard.k) aoVar);
                    if (bArrA == null) {
                        com.tencent.bugly.proguard.x.d("send encode fail!", new java.lang.Object[0]);
                        return;
                    }
                    com.tencent.bugly.proguard.ap apVarA = com.tencent.bugly.proguard.a.a(this.b, i, bArrA);
                    if (apVarA == null) {
                        com.tencent.bugly.proguard.x.d("request package is null.", new java.lang.Object[0]);
                        return;
                    }
                    com.tencent.bugly.proguard.t tVar = new com.tencent.bugly.proguard.t() { // from class: com.tencent.bugly.crashreport.crash.b.1
                        @Override // com.tencent.bugly.proguard.t
                        public final void a(boolean z4) {
                            com.tencent.bugly.crashreport.crash.b bVar = com.tencent.bugly.crashreport.crash.b.this;
                            com.tencent.bugly.crashreport.crash.b.a(z4, (java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean>) list);
                        }
                    };
                    if (z) {
                        this.c.a(f308a, apVarA, str, str2, tVar, j, z2);
                    } else {
                        this.c.a(f308a, apVarA, str, str2, tVar, false);
                    }
                } catch (java.lang.Throwable th) {
                    com.tencent.bugly.proguard.x.e("req cr error %s", th.toString());
                    if (com.tencent.bugly.proguard.x.b(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    public final boolean a(com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean) {
        return a(crashDetailBean, -123456789);
    }

    public final boolean a(com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean, int i) throws java.lang.Throwable {
        if (crashDetailBean == null) {
            return true;
        }
        if (com.tencent.bugly.crashreport.crash.c.n != null && !com.tencent.bugly.crashreport.crash.c.n.isEmpty()) {
            com.tencent.bugly.proguard.x.c("Crash filter for crash stack is: %s", com.tencent.bugly.crashreport.crash.c.n);
            if (crashDetailBean.q.contains(com.tencent.bugly.crashreport.crash.c.n)) {
                com.tencent.bugly.proguard.x.d("This crash contains the filter string set. It will not be record and upload.", new java.lang.Object[0]);
                return true;
            }
        }
        if (com.tencent.bugly.crashreport.crash.c.o != null && !com.tencent.bugly.crashreport.crash.c.o.isEmpty()) {
            com.tencent.bugly.proguard.x.c("Crash regular filter for crash stack is: %s", com.tencent.bugly.crashreport.crash.c.o);
            if (java.util.regex.Pattern.compile(com.tencent.bugly.crashreport.crash.c.o).matcher(crashDetailBean.q).find()) {
                com.tencent.bugly.proguard.x.d("This crash matches the regular filter string set. It will not be record and upload.", new java.lang.Object[0]);
                return true;
            }
        }
        int i2 = crashDetailBean.b;
        java.lang.String str = crashDetailBean.n;
        java.lang.String str2 = crashDetailBean.o;
        java.lang.String str3 = crashDetailBean.p;
        java.lang.String str4 = crashDetailBean.q;
        long j = crashDetailBean.r;
        java.lang.String str5 = crashDetailBean.m;
        java.lang.String str6 = crashDetailBean.e;
        java.lang.String str7 = crashDetailBean.c;
        java.lang.String str8 = crashDetailBean.A;
        java.lang.String str9 = crashDetailBean.B;
        if (this.f != null) {
            com.tencent.bugly.proguard.x.c("Calling 'onCrashSaving' of RQD crash listener.", new java.lang.Object[0]);
            if (!this.f.c()) {
                com.tencent.bugly.proguard.x.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new java.lang.Object[0]);
                return true;
            }
        }
        if (crashDetailBean.b != 2) {
            com.tencent.bugly.proguard.r rVar = new com.tencent.bugly.proguard.r();
            rVar.b = 1;
            rVar.c = crashDetailBean.A;
            rVar.d = crashDetailBean.B;
            rVar.e = crashDetailBean.r;
            this.d.b(1);
            this.d.a(rVar);
            com.tencent.bugly.proguard.x.b("[crash] a crash occur, handling...", new java.lang.Object[0]);
        } else {
            com.tencent.bugly.proguard.x.b("[crash] a caught exception occur, handling...", new java.lang.Object[0]);
        }
        java.util.List<com.tencent.bugly.crashreport.crash.a> listB = b();
        java.util.ArrayList arrayList = null;
        if (listB != null && listB.size() > 0) {
            arrayList = new java.util.ArrayList(10);
            java.util.ArrayList arrayList2 = new java.util.ArrayList(10);
            arrayList.addAll(a(listB));
            listB.removeAll(arrayList);
            if (!com.tencent.bugly.b.c && com.tencent.bugly.crashreport.crash.c.d) {
                boolean z = false;
                for (com.tencent.bugly.crashreport.crash.a aVar : listB) {
                    if (crashDetailBean.u.equals(aVar.c)) {
                        if (aVar.e) {
                            z = true;
                        }
                        arrayList2.add(aVar);
                    }
                }
                if (z || arrayList2.size() >= com.tencent.bugly.crashreport.crash.c.c) {
                    com.tencent.bugly.proguard.x.a("same crash occur too much do merged!", new java.lang.Object[0]);
                    com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBeanA = a(arrayList2, crashDetailBean);
                    for (com.tencent.bugly.crashreport.crash.a aVar2 : arrayList2) {
                        if (aVar2.f300a != crashDetailBeanA.f299a) {
                            arrayList.add(aVar2);
                        }
                    }
                    d(crashDetailBeanA);
                    c(arrayList);
                    com.tencent.bugly.proguard.x.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new java.lang.Object[0]);
                    return true;
                }
            }
        }
        d(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            c(arrayList);
        }
        com.tencent.bugly.proguard.x.b("[crash] save crash success", new java.lang.Object[0]);
        return false;
    }

    public final void b(com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean) {
        if (this.f != null) {
            com.tencent.bugly.proguard.x.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new java.lang.Object[0]);
            com.tencent.bugly.proguard.o oVar = this.f;
            int i = crashDetailBean.b;
        }
    }

    public final void c(com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean) {
        int i;
        java.util.Map<java.lang.String, java.lang.String> mapOnCrashHandleStart;
        java.lang.String strSubstring;
        java.util.HashMap map;
        if (crashDetailBean == null) {
            return;
        }
        if (this.g == null && this.f == null) {
            return;
        }
        try {
            com.tencent.bugly.proguard.x.a("[crash callback] start user's callback:onCrashHandleStart()", new java.lang.Object[0]);
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
            byte[] bArrOnCrashHandleStart2GetExtraDatas = null;
            if (this.f != null) {
                com.tencent.bugly.proguard.x.c("Calling 'onCrashHandleStart' of RQD crash listener.", new java.lang.Object[0]);
                com.tencent.bugly.proguard.o oVar = this.f;
                com.tencent.bugly.proguard.x.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new java.lang.Object[0]);
                java.lang.String strB = this.f.b();
                if (strB != null) {
                    map = new java.util.HashMap(1);
                    map.put("userData", strB);
                } else {
                    map = null;
                }
                mapOnCrashHandleStart = map;
            } else if (this.g != null) {
                com.tencent.bugly.proguard.x.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new java.lang.Object[0]);
                mapOnCrashHandleStart = this.g.onCrashHandleStart(i, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
            } else {
                mapOnCrashHandleStart = null;
            }
            if (mapOnCrashHandleStart != null && mapOnCrashHandleStart.size() > 0) {
                crashDetailBean.O = new java.util.LinkedHashMap(mapOnCrashHandleStart.size());
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : mapOnCrashHandleStart.entrySet()) {
                    if (!com.tencent.bugly.proguard.z.a(entry.getKey())) {
                        java.lang.String key = entry.getKey();
                        if (key.length() > 100) {
                            key = key.substring(0, 100);
                            com.tencent.bugly.proguard.x.d("setted key length is over limit %d substring to %s", 100, key);
                        }
                        if (com.tencent.bugly.proguard.z.a(entry.getValue()) || entry.getValue().length() <= 30000) {
                            strSubstring = entry.getValue();
                        } else {
                            strSubstring = entry.getValue().substring(entry.getValue().length() - 30000);
                            com.tencent.bugly.proguard.x.d("setted %s value length is over limit %d substring", key, 30000);
                        }
                        crashDetailBean.O.put(key, strSubstring);
                        com.tencent.bugly.proguard.x.a("add setted key %s value size:%d", key, java.lang.Integer.valueOf(strSubstring.length()));
                    }
                }
            }
            com.tencent.bugly.proguard.x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new java.lang.Object[0]);
            if (this.f != null) {
                com.tencent.bugly.proguard.x.c("Calling 'getCrashExtraData' of RQD crash listener.", new java.lang.Object[0]);
                bArrOnCrashHandleStart2GetExtraDatas = this.f.a();
            } else if (this.g != null) {
                com.tencent.bugly.proguard.x.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new java.lang.Object[0]);
                bArrOnCrashHandleStart2GetExtraDatas = this.g.onCrashHandleStart2GetExtraDatas(i, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
            }
            crashDetailBean.T = bArrOnCrashHandleStart2GetExtraDatas;
            if (bArrOnCrashHandleStart2GetExtraDatas != null) {
                if (bArrOnCrashHandleStart2GetExtraDatas.length > 30000) {
                    com.tencent.bugly.proguard.x.d("extra bytes size %d is over limit %d will drop over part", java.lang.Integer.valueOf(bArrOnCrashHandleStart2GetExtraDatas.length), 30000);
                    crashDetailBean.T = java.util.Arrays.copyOf(bArrOnCrashHandleStart2GetExtraDatas, 30000);
                }
                com.tencent.bugly.proguard.x.a("add extra bytes %d ", java.lang.Integer.valueOf(bArrOnCrashHandleStart2GetExtraDatas.length));
            }
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.d("crash handle callback something wrong! %s", th.getClass().getName());
            if (com.tencent.bugly.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void d(com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean) {
        android.content.ContentValues contentValuesE;
        if (crashDetailBean == null || (contentValuesE = e(crashDetailBean)) == null) {
            return;
        }
        long jA = com.tencent.bugly.proguard.p.a().a("t_cr", contentValuesE, (com.tencent.bugly.proguard.o) null, true);
        if (jA >= 0) {
            com.tencent.bugly.proguard.x.c("insert %s success!", "t_cr");
            crashDetailBean.f299a = jA;
        }
    }
}
