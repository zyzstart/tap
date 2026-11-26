package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h {
    public static int a() {
        try {
            java.io.File[] fileArrListFiles = new java.io.File("/sys/devices/system/cpu/").listFiles(new com.tencent.tmassistantbase.util.i());
            if (fileArrListFiles == null) {
                return 1;
            }
            return fileArrListFiles.length;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int b() {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.io.FileReader fileReader;
        java.io.FileNotFoundException e;
        int i = 0;
        try {
            try {
                try {
                    fileReader = new java.io.FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                    try {
                        bufferedReader = new java.io.BufferedReader(fileReader);
                        try {
                            java.lang.String line = bufferedReader.readLine();
                            if (line == null) {
                                try {
                                    fileReader.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                                try {
                                    bufferedReader.close();
                                } catch (java.io.IOException e3) {
                                    e3.printStackTrace();
                                }
                                return 0;
                            }
                            i = java.lang.Integer.parseInt(line.trim());
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                        } catch (java.io.FileNotFoundException e5) {
                            e = e5;
                            e.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (java.io.IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (bufferedReader != null) {
                            }
                            return i;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (java.io.IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (bufferedReader != null) {
                            }
                            return i;
                        }
                    } catch (java.io.FileNotFoundException e8) {
                        bufferedReader = null;
                        e = e8;
                    } catch (java.lang.Throwable th3) {
                        bufferedReader = null;
                        th = th3;
                    }
                } catch (java.lang.Throwable th4) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (bufferedReader == null) {
                        throw th4;
                    }
                    try {
                        bufferedReader.close();
                        throw th4;
                    } catch (java.io.IOException e10) {
                        e10.printStackTrace();
                        throw th4;
                    }
                }
            } catch (java.io.FileNotFoundException e11) {
                bufferedReader = null;
                e = e11;
                fileReader = null;
            } catch (java.lang.Throwable th5) {
                bufferedReader = null;
                th = th5;
                fileReader = null;
            }
            bufferedReader.close();
        } catch (java.io.IOException e12) {
            e12.printStackTrace();
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int c() throws java.lang.Throwable {
        java.io.FileReader fileReader;
        java.io.BufferedReader bufferedReader;
        java.io.IOException e;
        java.io.FileNotFoundException e2;
        java.io.BufferedReader bufferedReader2 = null;
        int i = 0;
        try {
            try {
                fileReader = new java.io.FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader);
                    try {
                        java.lang.String line = bufferedReader.readLine();
                        if (line == null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                            return 0;
                        }
                        i = java.lang.Integer.parseInt(line.trim());
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e5) {
                            e5.printStackTrace();
                        }
                    } catch (java.io.FileNotFoundException e6) {
                        e2 = e6;
                        e2.printStackTrace();
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                        }
                        return i;
                    } catch (java.io.IOException e8) {
                        e = e8;
                        e.printStackTrace();
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                        }
                        return i;
                    }
                } catch (java.io.FileNotFoundException e10) {
                    bufferedReader = null;
                    e2 = e10;
                } catch (java.io.IOException e11) {
                    bufferedReader = null;
                    e = e11;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (bufferedReader2 == null) {
                        throw th;
                    }
                    try {
                        bufferedReader2.close();
                        throw th;
                    } catch (java.io.IOException e13) {
                        e13.printStackTrace();
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
            }
        } catch (java.io.FileNotFoundException e14) {
            bufferedReader = null;
            e2 = e14;
            fileReader = null;
        } catch (java.io.IOException e15) {
            bufferedReader = null;
            e = e15;
            fileReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileReader = null;
        }
        try {
            bufferedReader.close();
        } catch (java.io.IOException e16) {
            e16.printStackTrace();
        }
        return i;
    }

    public static long d() throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader("/proc/meminfo"), 80);
                try {
                    java.lang.String line = bufferedReader2.readLine();
                    if (line == null) {
                        line = null;
                    }
                    if (line == null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                        return 0L;
                    }
                    long j = java.lang.Integer.parseInt(line.substring(line.indexOf(58) + 1, line.indexOf(107)).trim()) / 1024;
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                    return j;
                } catch (java.io.FileNotFoundException e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return 0L;
                } catch (java.lang.Exception e5) {
                    e = e5;
                    bufferedReader = bufferedReader2;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return 0L;
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.FileNotFoundException e7) {
            e = e7;
        } catch (java.lang.Exception e8) {
            e = e8;
        }
    }

    /* JADX WARN: Code duplicated, block: B:91:0x007f A[EXC_TOP_SPLITTER, PHI: r2
  0x007f: PHI (r2v7 java.io.BufferedReader) = (r2v6 java.io.BufferedReader), (r2v8 java.io.BufferedReader) binds: [B:50:0x0069, B:60:0x007d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0089: MOVE (r6 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:67:0x0089 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String e() throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.FileReader fileReader;
        java.io.IOException e;
        java.io.BufferedReader bufferedReader;
        java.io.FileNotFoundException e2;
        java.io.BufferedReader bufferedReader2;
        java.io.BufferedReader bufferedReader3 = null;
        try {
            try {
                fileReader = new java.io.FileReader("/proc/cpuinfo");
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader);
                    try {
                        java.lang.String line = bufferedReader.readLine();
                        if (line == null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                            return null;
                        }
                        java.lang.String[] strArrSplit = line.split(":\\s+", 2);
                        for (int i = 0; i < strArrSplit.length; i++) {
                        }
                        java.lang.String str = strArrSplit[1];
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e5) {
                            e5.printStackTrace();
                        }
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                        return str;
                    } catch (java.io.FileNotFoundException e7) {
                        e2 = e7;
                        e2.printStackTrace();
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        return null;
                    } catch (java.io.IOException e10) {
                        e = e10;
                        e.printStackTrace();
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return null;
                    }
                } catch (java.io.FileNotFoundException e12) {
                    e2 = e12;
                    bufferedReader = null;
                } catch (java.io.IOException e13) {
                    e = e13;
                    bufferedReader = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e14) {
                            e14.printStackTrace();
                        }
                    }
                    if (bufferedReader3 == null) {
                        throw th;
                    }
                    try {
                        bufferedReader3.close();
                        throw th;
                    } catch (java.io.IOException e15) {
                        e15.printStackTrace();
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedReader3 = bufferedReader2;
            }
        } catch (java.io.FileNotFoundException e16) {
            e2 = e16;
            fileReader = null;
            bufferedReader = null;
        } catch (java.io.IOException e17) {
            e = e17;
            fileReader = null;
            bufferedReader = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    public static java.lang.String f() {
        java.lang.String string;
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            string = java.util.Arrays.toString(android.os.Build.SUPPORTED_ABIS);
        } else {
            try {
                string = java.util.Arrays.toString(new java.lang.String[]{android.os.Build.CPU_ABI, android.os.Build.CPU_ABI2});
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                string = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
        }
        com.tencent.tmassistantbase.util.x.a("vivianabis", "supportABIS:" + string);
        return string;
    }
}
