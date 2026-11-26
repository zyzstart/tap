package com.tencent.bugly.crashreport.crash.jni;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a implements com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.content.Context f322a;
    private final com.tencent.bugly.crashreport.crash.b b;
    private final com.tencent.bugly.crashreport.common.info.a c;
    private final com.tencent.bugly.crashreport.common.strategy.a d;

    public a(android.content.Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.f322a = context;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i, int i2, long j, long j2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i3, java.lang.String str5, int i4, int i5, int i6, java.lang.String str6, java.lang.String str7) {
        com.tencent.bugly.proguard.x.a("Native Crash Happen v1", new java.lang.Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException2(int i, int i2, long j, long j2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i3, java.lang.String str5, int i4, int i5, int i6, java.lang.String str6, java.lang.String str7, java.lang.String[] strArr) {
        java.lang.String str8;
        java.lang.String str9;
        java.lang.String str10;
        boolean z;
        java.lang.String str11;
        java.lang.String str12;
        boolean z2;
        java.lang.String str13;
        boolean z3;
        com.tencent.bugly.proguard.x.a("Native Crash Happen v2", new java.lang.Object[0]);
        try {
            java.lang.String strA = com.tencent.bugly.crashreport.crash.jni.b.a(str3);
            java.lang.String strA2 = "UNKNOWN";
            if (i3 > 0) {
                str9 = str + "(" + str5 + ")";
                str8 = "UNKNOWN";
                str10 = "KERNEL";
            } else {
                if (i4 > 0) {
                    android.content.Context context = this.f322a;
                    strA2 = com.tencent.bugly.crashreport.common.info.AppInfo.a(i4);
                }
                if (strA2.equals(java.lang.String.valueOf(i4))) {
                    str8 = strA2;
                    str9 = str;
                    str10 = str5;
                } else {
                    str8 = strA2 + "(" + i4 + ")";
                    str9 = str;
                    str10 = str5;
                }
            }
            java.util.HashMap map = new java.util.HashMap();
            if (strArr != null) {
                for (int i7 = 0; i7 < strArr.length; i7++) {
                    java.lang.String str14 = strArr[i7];
                    if (str14 != null) {
                        com.tencent.bugly.proguard.x.a("Extra message[%d]: %s", java.lang.Integer.valueOf(i7), str14);
                        java.lang.String[] strArrSplit = str14.split("=");
                        if (strArrSplit.length == 2) {
                            map.put(strArrSplit[0], strArrSplit[1]);
                        } else {
                            com.tencent.bugly.proguard.x.d("bad extraMsg %s", str14);
                        }
                    }
                }
            } else {
                com.tencent.bugly.proguard.x.c("not found extraMsg", new java.lang.Object[0]);
            }
            java.lang.String str15 = (java.lang.String) map.get("HasPendingException");
            if (str15 == null || !str15.equals(com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON)) {
                z = false;
            } else {
                com.tencent.bugly.proguard.x.a("Native crash happened with a Java pending exception.", new java.lang.Object[0]);
                z = true;
            }
            java.lang.String str16 = (java.lang.String) map.get("ExceptionProcessName");
            if (str16 == null || str16.length() == 0) {
                str11 = this.c.d;
            } else {
                com.tencent.bugly.proguard.x.c("Name of crash process: %s", str16);
                str11 = str16;
            }
            java.lang.String str17 = (java.lang.String) map.get("ExceptionThreadName");
            if (str17 == null || str17.length() == 0) {
                java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
                str12 = threadCurrentThread.getName() + "(" + threadCurrentThread.getId() + ")";
            } else {
                com.tencent.bugly.proguard.x.c("Name of crash thread: %s", str17);
                java.util.Iterator<java.lang.Thread> it = java.lang.Thread.getAllStackTraces().keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str13 = str17;
                        z3 = false;
                        break;
                    }
                    java.lang.Thread next = it.next();
                    if (next.getName().equals(str17)) {
                        str13 = str17 + "(" + next.getId() + ")";
                        z3 = true;
                        break;
                    }
                }
                str12 = z3 ? str13 : str13 + "(" + i2 + ")";
            }
            long j3 = (j * 1000) + (j2 / 1000);
            java.lang.String str18 = (java.lang.String) map.get("SysLogPath");
            java.lang.String str19 = (java.lang.String) map.get("JniLogPath");
            if (!this.d.b()) {
                com.tencent.bugly.proguard.x.d("no remote but still store!", new java.lang.Object[0]);
            }
            if (!this.d.c().g && this.d.b()) {
                com.tencent.bugly.proguard.x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new java.lang.Object[0]);
                com.tencent.bugly.crashreport.crash.b.a("NATIVE_CRASH", com.tencent.bugly.proguard.z.a(), str11, str12, str9 + "\n" + str2 + "\n" + strA, null);
                com.tencent.bugly.proguard.z.b(str4);
                return;
            }
            java.lang.String str20 = str9;
            try {
                com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBeanPackageCrashDatas = packageCrashDatas(str11, str12, j3, str9, str2, strA, str10, str8, str4, str18, str19, str7, null, null, true, z);
                if (crashDetailBeanPackageCrashDatas == null) {
                    com.tencent.bugly.proguard.x.e("pkg crash datas fail!", new java.lang.Object[0]);
                    return;
                }
                com.tencent.bugly.crashreport.crash.b.a("NATIVE_CRASH", com.tencent.bugly.proguard.z.a(), str11, str12, str20 + "\n" + str2 + "\n" + strA, crashDetailBeanPackageCrashDatas);
                try {
                    boolean z4 = this.b.a(crashDetailBeanPackageCrashDatas, i3) ? false : true;
                    java.lang.String dumpFilePath = null;
                    com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler nativeCrashHandler = com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.getInstance();
                    if (nativeCrashHandler != null) {
                        dumpFilePath = nativeCrashHandler.getDumpFilePath();
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    com.tencent.bugly.crashreport.crash.jni.b.a(z2, dumpFilePath);
                    if (z4) {
                        this.b.a(crashDetailBeanPackageCrashDatas, 3000L, z2);
                    }
                    this.b.b(crashDetailBeanPackageCrashDatas);
                    return;
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
        if (com.tencent.bugly.proguard.x.a(th)) {
            return;
        }
        th.printStackTrace();
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final com.tencent.bugly.crashreport.crash.CrashDetailBean packageCrashDatas(java.lang.String str, java.lang.String str2, long j, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, java.lang.String str11, byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map, boolean z, boolean z2) {
        int i;
        java.lang.String str12;
        int iIndexOf;
        boolean zK = com.tencent.bugly.crashreport.crash.c.a().k();
        if (zK) {
            com.tencent.bugly.proguard.x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new java.lang.Object[0]);
        }
        com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean = new com.tencent.bugly.crashreport.crash.CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.e = this.c.h();
        crashDetailBean.f = this.c.j;
        crashDetailBean.g = this.c.w();
        crashDetailBean.m = this.c.g();
        crashDetailBean.n = str3;
        crashDetailBean.o = zK ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        crashDetailBean.q = str5 == null ? "" : str5;
        crashDetailBean.r = j;
        crashDetailBean.u = com.tencent.bugly.proguard.z.b(crashDetailBean.q.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.c.y();
        crashDetailBean.h = this.c.v();
        crashDetailBean.i = this.c.J();
        crashDetailBean.v = str8;
        com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler nativeCrashHandler = com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.getInstance();
        java.lang.String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        java.lang.String strA = com.tencent.bugly.crashreport.crash.jni.b.a(dumpFilePath, str8);
        if (!com.tencent.bugly.proguard.z.a(strA)) {
            crashDetailBean.U = strA;
        }
        crashDetailBean.V = com.tencent.bugly.crashreport.crash.jni.b.b(dumpFilePath);
        crashDetailBean.w = com.tencent.bugly.crashreport.crash.jni.b.a(str9, com.tencent.bugly.crashreport.crash.c.e, null, false);
        crashDetailBean.x = com.tencent.bugly.crashreport.crash.jni.b.a(str10, com.tencent.bugly.crashreport.crash.c.e, null, true);
        crashDetailBean.J = str7;
        crashDetailBean.K = str6;
        crashDetailBean.L = str11;
        crashDetailBean.F = this.c.p();
        crashDetailBean.G = this.c.o();
        crashDetailBean.H = this.c.q();
        if (z) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = com.tencent.bugly.proguard.z.a(this.f322a, com.tencent.bugly.crashreport.crash.c.e, (java.lang.String) null);
            }
            crashDetailBean.y = com.tencent.bugly.proguard.y.a();
            crashDetailBean.M = this.c.f292a;
            crashDetailBean.N = this.c.a();
            crashDetailBean.P = this.c.H();
            crashDetailBean.Q = this.c.I();
            crashDetailBean.R = this.c.B();
            crashDetailBean.S = this.c.G();
            crashDetailBean.z = com.tencent.bugly.proguard.z.a(com.tencent.bugly.crashreport.crash.c.f, false);
            int iIndexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (iIndexOf2 > 0 && (i = iIndexOf2 + 6) < crashDetailBean.q.length()) {
                java.lang.String strSubstring = crashDetailBean.q.substring(i, crashDetailBean.q.length() - 1);
                if (strSubstring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (iIndexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(strSubstring)) > 0) {
                    java.lang.String strSubstring2 = str12.substring(iIndexOf);
                    crashDetailBean.z.put(crashDetailBean.B, strSubstring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i);
                    crashDetailBean.q += strSubstring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.c.d;
            }
            this.b.c(crashDetailBean);
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.M = -1L;
            crashDetailBean.P = -1;
            crashDetailBean.Q = -1;
            crashDetailBean.R = map;
            crashDetailBean.S = this.c.G();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
        }
        return crashDetailBean;
    }
}
