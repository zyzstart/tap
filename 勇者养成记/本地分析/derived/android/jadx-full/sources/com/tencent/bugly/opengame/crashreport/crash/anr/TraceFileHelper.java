package com.tencent.bugly.opengame.crashreport.crash.anr;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TraceFileHelper {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f353a;
        public java.lang.String b;
        public long c;
        public java.util.Map d;
    }

    public interface b {
        boolean a(long j);

        boolean a(long j, long j2, java.lang.String str);

        boolean a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3);
    }

    private static java.lang.String a(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < 3; i++) {
            java.lang.String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    private static java.lang.Object[] a(java.io.BufferedReader bufferedReader, java.util.regex.Pattern... patternArr) throws java.io.IOException {
        if (bufferedReader != null && patternArr != null) {
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                for (java.util.regex.Pattern pattern : patternArr) {
                    if (pattern.matcher(line).matches()) {
                        return new java.lang.Object[]{pattern, line};
                    }
                }
            }
        }
        return null;
    }

    private static java.lang.String b(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (true) {
            java.lang.String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    public static com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a readFirstDumpInfo(java.lang.String str, final boolean z) throws java.lang.Throwable {
        if (str == null) {
            com.tencent.bugly.opengame.proguard.x.e("path:%s", str);
            return null;
        }
        final com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a aVar = new com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a();
        readTraceFile(str, new com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.b() { // from class: com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j) {
                com.tencent.bugly.opengame.proguard.x.c("process end %d", java.lang.Long.valueOf(j));
                return false;
            }

            @Override // com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j, long j2, java.lang.String str2) {
                com.tencent.bugly.opengame.proguard.x.c("new process %s", str2);
                com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a aVar2 = aVar;
                aVar2.f353a = j;
                aVar2.b = str2;
                aVar2.c = j2;
                return z;
            }

            @Override // com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(java.lang.String str2, int i, java.lang.String str3, java.lang.String str4) {
                com.tencent.bugly.opengame.proguard.x.c("new thread %s", str2);
                com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a aVar2 = aVar;
                if (aVar2.d == null) {
                    aVar2.d = new java.util.HashMap();
                }
                java.util.Map map = aVar.d;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(i);
                map.put(str2, new java.lang.String[]{str3, str4, sb.toString()});
                return true;
            }
        });
        if (aVar.f353a > 0 && aVar.c > 0 && aVar.b != null) {
            return aVar;
        }
        com.tencent.bugly.opengame.proguard.x.e("first dump error %s", aVar.f353a + " " + aVar.c + " " + aVar.b);
        return null;
    }

    public static com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a readTargetDumpInfo(final java.lang.String str, java.lang.String str2, final boolean z) throws java.lang.Throwable {
        if (str != null && str2 != null) {
            final com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a aVar = new com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a();
            readTraceFile(str2, new com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.b() { // from class: com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j) {
                    com.tencent.bugly.opengame.proguard.x.c("process end %d", java.lang.Long.valueOf(j));
                    com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a aVar2 = aVar;
                    return aVar2.f353a <= 0 || aVar2.c <= 0 || aVar2.b == null;
                }

                @Override // com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j, long j2, java.lang.String str3) {
                    com.tencent.bugly.opengame.proguard.x.c("new process %s", str3);
                    if (!str3.equals(str)) {
                        return true;
                    }
                    com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a aVar2 = aVar;
                    aVar2.f353a = j;
                    aVar2.b = str3;
                    aVar2.c = j2;
                    return z;
                }

                @Override // com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(java.lang.String str3, int i, java.lang.String str4, java.lang.String str5) {
                    com.tencent.bugly.opengame.proguard.x.c("new thread %s", str3);
                    com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a aVar2 = aVar;
                    if (aVar2.f353a > 0 && aVar2.c > 0 && aVar2.b != null) {
                        if (aVar2.d == null) {
                            aVar2.d = new java.util.HashMap();
                        }
                        java.util.Map map = aVar.d;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(i);
                        map.put(str3, new java.lang.String[]{str4, str5, sb.toString()});
                    }
                    return true;
                }
            });
            if (aVar.f353a > 0 && aVar.c > 0 && aVar.b != null) {
                return aVar;
            }
        }
        return null;
    }

    public static void readTraceFile(java.lang.String str, com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.b bVar) throws java.lang.Throwable {
        java.lang.Throwable th;
        if (str == null || bVar == null) {
            return;
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(file));
                try {
                    java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    java.util.regex.Pattern patternCompile2 = java.util.regex.Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    java.util.regex.Pattern patternCompile3 = java.util.regex.Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    java.util.regex.Pattern patternCompile4 = java.util.regex.Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.US);
                    while (true) {
                        java.lang.Object[] objArrA = a(bufferedReader2, patternCompile);
                        if (objArrA == null) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (java.io.IOException e) {
                                if (com.tencent.bugly.opengame.proguard.x.a(e)) {
                                    return;
                                }
                                e.printStackTrace();
                                return;
                            }
                        }
                        java.lang.String[] strArrSplit = objArrA[1].toString().split("\\s");
                        long j = java.lang.Long.parseLong(strArrSplit[2]);
                        long time = simpleDateFormat.parse(strArrSplit[4] + " " + strArrSplit[5]).getTime();
                        java.lang.Object[] objArrA2 = a(bufferedReader2, patternCompile3);
                        if (objArrA2 != null) {
                            java.util.regex.Matcher matcher = patternCompile3.matcher(objArrA2[1].toString());
                            matcher.find();
                            matcher.group(1);
                            if (!bVar.a(j, time, matcher.group(1))) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (java.io.IOException e2) {
                                    if (com.tencent.bugly.opengame.proguard.x.a(e2)) {
                                        return;
                                    }
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            while (true) {
                                java.lang.Object[] objArrA3 = a(bufferedReader2, patternCompile4, patternCompile2);
                                if (objArrA3 != null) {
                                    if (objArrA3[0] != patternCompile4) {
                                        if (bVar.a(java.lang.Long.parseLong(objArrA3[1].toString().split("\\s")[2]))) {
                                            break;
                                        }
                                        try {
                                            bufferedReader2.close();
                                            return;
                                        } catch (java.io.IOException e3) {
                                            if (com.tencent.bugly.opengame.proguard.x.a(e3)) {
                                                return;
                                            }
                                            e3.printStackTrace();
                                            return;
                                        }
                                    }
                                    java.lang.String string = objArrA3[1].toString();
                                    java.util.regex.Matcher matcher2 = java.util.regex.Pattern.compile("\".+\"").matcher(string);
                                    matcher2.find();
                                    java.lang.String strGroup = matcher2.group();
                                    java.lang.String strSubstring = strGroup.substring(1, strGroup.length() - 1);
                                    string.contains("NATIVE");
                                    java.util.regex.Matcher matcher3 = java.util.regex.Pattern.compile("tid=\\d+").matcher(string);
                                    matcher3.find();
                                    java.lang.String strGroup2 = matcher3.group();
                                    bVar.a(strSubstring, java.lang.Integer.parseInt(strGroup2.substring(strGroup2.indexOf("=") + 1)), a(bufferedReader2), b(bufferedReader2));
                                } else {
                                    break;
                                }
                            }
                        } else {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (java.io.IOException e4) {
                                if (com.tencent.bugly.opengame.proguard.x.a(e4)) {
                                    return;
                                }
                                e4.printStackTrace();
                                return;
                            }
                        }
                    }
                } catch (java.lang.Exception e5) {
                    e = e5;
                    bufferedReader = bufferedReader2;
                    if (!com.tencent.bugly.opengame.proguard.x.a(e)) {
                        e.printStackTrace();
                    }
                    com.tencent.bugly.opengame.proguard.x.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e6) {
                            if (com.tencent.bugly.opengame.proguard.x.a(e6)) {
                                return;
                            }
                            e6.printStackTrace();
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader == null) {
                        throw th;
                    }
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (java.io.IOException e7) {
                        if (com.tencent.bugly.opengame.proguard.x.a(e7)) {
                            throw th;
                        }
                        e7.printStackTrace();
                        throw th;
                    }
                }
            } catch (java.lang.Exception e8) {
                e = e8;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }
}
