package com.unisound.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {
    public static final java.lang.String b = "utf-8";
    public static java.util.HashMap<java.lang.String, java.lang.String> c = new java.util.HashMap<>();
    private static final int d = 10000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f1454a = null;

    /* JADX WARN: Code duplicated, block: B:44:0x00cc A[Catch: IOException -> 0x00a8, TRY_ENTER, TryCatch #4 {IOException -> 0x00a8, blocks: (B:24:0x00a4, B:28:0x00ac, B:30:0x00b1, B:44:0x00cc, B:46:0x00d1, B:48:0x00d6), top: B:67:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00d1 A[Catch: IOException -> 0x00a8, TryCatch #4 {IOException -> 0x00a8, blocks: (B:24:0x00a4, B:28:0x00ac, B:30:0x00b1, B:44:0x00cc, B:46:0x00d1, B:48:0x00d6), top: B:67:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d6 A[Catch: IOException -> 0x00a8, TRY_LEAVE, TryCatch #4 {IOException -> 0x00a8, blocks: (B:24:0x00a4, B:28:0x00ac, B:30:0x00b1, B:44:0x00cc, B:46:0x00d1, B:48:0x00d6), top: B:67:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ea A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ec A[Catch: IOException -> 0x00e8, TryCatch #3 {IOException -> 0x00e8, blocks: (B:54:0x00e4, B:58:0x00ec, B:60:0x00f1), top: B:65:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00f1 A[Catch: IOException -> 0x00e8, TRY_LEAVE, TryCatch #3 {IOException -> 0x00e8, blocks: (B:54:0x00e4, B:58:0x00ec, B:60:0x00f1), top: B:65:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.unisound.b.l a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i) throws java.lang.Throwable {
        ?? r8;
        java.io.OutputStream outputStream;
        ?? r9;
        java.io.InputStream inputStream;
        java.io.BufferedReader bufferedReader;
        byte[] bytes = a(map).toString().getBytes();
        java.lang.String str2 = "";
        com.unisound.b.l lVar = new com.unisound.b.l();
        java.io.InputStream inputStream2 = null;
        java.io.InputStream inputStream3 = null;
        inputStream2 = null;
        java.io.OutputStream outputStream2 = null;
        try {
            try {
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                httpURLConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", java.lang.String.valueOf(bytes.length));
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bytes);
                    int responseCode = httpURLConnection.getResponseCode();
                    lVar.a(com.unisound.b.j.a(httpURLConnection.getHeaderField("Date")));
                    lVar.b(java.lang.System.currentTimeMillis());
                    if (responseCode == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, "UTF-8"));
                            while (true) {
                                try {
                                    java.lang.String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    str2 = str2 + line;
                                } catch (java.io.IOException e) {
                                    inputStream3 = inputStream;
                                    e = e;
                                    outputStream2 = outputStream;
                                    r9 = bufferedReader;
                                    try {
                                        e.printStackTrace();
                                        if (outputStream2 != null) {
                                            outputStream2.close();
                                        }
                                        if (inputStream3 != null) {
                                            inputStream3.close();
                                        }
                                        if (r9 != 0) {
                                            r9.close();
                                        }
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        java.io.OutputStream outputStream3 = outputStream2;
                                        inputStream2 = inputStream3;
                                        r8 = r9;
                                        outputStream = outputStream3;
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                                if (inputStream2 != null) {
                                                    inputStream2.close();
                                                }
                                                if (r8 != 0) {
                                                    r8.close();
                                                }
                                            } catch (java.io.IOException e2) {
                                                e2.printStackTrace();
                                                throw th;
                                            }
                                        } else {
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (r8 != 0) {
                                                r8.close();
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    inputStream2 = inputStream;
                                    r8 = bufferedReader;
                                    if (outputStream != null) {
                                        outputStream.close();
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (r8 != 0) {
                                            r8.close();
                                        }
                                    } else {
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (r8 != 0) {
                                            r8.close();
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (java.io.IOException e3) {
                            inputStream3 = inputStream;
                            e = e3;
                            outputStream2 = outputStream;
                            r9 = 0;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                        }
                    } else {
                        str2 = "{}";
                        inputStream = null;
                        bufferedReader = null;
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (java.io.IOException e4) {
                    e = e4;
                    outputStream2 = outputStream;
                    r9 = inputStream2;
                    e.printStackTrace();
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (r9 != 0) {
                        r9.close();
                    }
                    lVar.a(str2);
                    return lVar;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    r8 = 0;
                }
            } catch (java.io.IOException e5) {
                e5.printStackTrace();
            }
        } catch (java.io.IOException e6) {
            e = e6;
        } catch (java.lang.Throwable th5) {
            th = th5;
            r8 = 0;
            outputStream = null;
        }
        lVar.a(str2);
        return lVar;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00cb A[Catch: Exception -> 0x00c7, TRY_LEAVE, TryCatch #11 {Exception -> 0x00c7, blocks: (B:51:0x00c3, B:55:0x00cb), top: B:77:0x00c3 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00d4 A[PHI: r0 r6
  0x00d4: PHI (r0v5 'th' ??) = (r0v3 'th' ??), (r0v0 'th' ??) binds: [B:58:0x00d2, B:34:0x00a5] A[DONT_GENERATE, DONT_INLINE]
  0x00d4: PHI (r6v6 java.net.HttpURLConnection) = (r6v5 java.net.HttpURLConnection), (r6v9 java.net.HttpURLConnection) binds: [B:58:0x00d2, B:34:0x00a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00e7 A[Catch: Exception -> 0x00e3, TRY_LEAVE, TryCatch #13 {Exception -> 0x00e3, blocks: (B:64:0x00df, B:68:0x00e7), top: B:81:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:72:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:75:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.net.HttpURLConnection httpURLConnection;
        ?? r8;
        java.lang.Exception e;
        java.lang.Exception exc;
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2;
        java.io.PrintWriter printWriter;
        ?? th = new java.lang.StringBuilder();
        java.io.PrintWriter printWriter2 = null;
        try {
            httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            try {
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestProperty("connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                if (str2.equals(com.tencent.connect.common.Constants.HTTP_POST)) {
                    printWriter = new java.io.PrintWriter(httpURLConnection.getOutputStream());
                    try {
                        printWriter.print(str3);
                        printWriter.flush();
                        bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                        while (true) {
                            try {
                                java.lang.String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                th.append(line);
                            } catch (java.lang.Exception e2) {
                                exc = e2;
                                printWriter2 = printWriter;
                                bufferedReader = bufferedReader2;
                                e = exc;
                                th = th;
                                r8 = bufferedReader;
                                try {
                                    e.printStackTrace();
                                    if (printWriter2 != null) {
                                        try {
                                            printWriter2.close();
                                            if (r8 != 0) {
                                                r8.close();
                                            }
                                        } catch (java.lang.Exception e3) {
                                            e3.printStackTrace();
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            return th.toString();
                                        }
                                    } else if (r8 != 0) {
                                        r8.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    if (printWriter2 != null) {
                                        try {
                                            printWriter2.close();
                                            if (r8 != 0) {
                                                r8.close();
                                            }
                                        } catch (java.lang.Exception e4) {
                                            e4.printStackTrace();
                                            if (httpURLConnection != null) {
                                                throw th;
                                            }
                                            httpURLConnection.disconnect();
                                            throw th;
                                        }
                                    } else if (r8 != 0) {
                                        r8.close();
                                    }
                                    if (httpURLConnection != null) {
                                        throw th;
                                    }
                                    httpURLConnection.disconnect();
                                    throw th;
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                printWriter2 = printWriter;
                                th = th;
                                r8 = bufferedReader2;
                                if (printWriter2 != null) {
                                    printWriter2.close();
                                    if (r8 != 0) {
                                        r8.close();
                                    }
                                } else if (r8 != 0) {
                                    r8.close();
                                }
                                if (httpURLConnection != null) {
                                    throw th;
                                }
                                httpURLConnection.disconnect();
                                throw th;
                            }
                        }
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (java.lang.Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        bufferedReader2.close();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (java.lang.Exception e6) {
                        printWriter2 = printWriter;
                        e = e6;
                        r8 = 0;
                        th = th;
                        e.printStackTrace();
                        if (printWriter2 != null) {
                            printWriter2.close();
                            if (r8 != 0) {
                                r8.close();
                            }
                        } else if (r8 != 0) {
                            r8.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        bufferedReader2 = null;
                    }
                } else {
                    httpURLConnection.connect();
                    java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    while (true) {
                        try {
                            java.lang.String line2 = bufferedReader3.readLine();
                            if (line2 == null) {
                                break;
                            }
                            th.append(line2);
                        } catch (java.lang.Exception e7) {
                            exc = e7;
                            bufferedReader = bufferedReader3;
                            e = exc;
                            th = th;
                            r8 = bufferedReader;
                            e.printStackTrace();
                            if (printWriter2 != null) {
                                printWriter2.close();
                                if (r8 != 0) {
                                    r8.close();
                                }
                            } else if (r8 != 0) {
                                r8.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (java.lang.Throwable th5) {
                            r8 = bufferedReader3;
                            th = th5;
                            if (printWriter2 != null) {
                                printWriter2.close();
                                if (r8 != 0) {
                                    r8.close();
                                }
                            } else if (r8 != 0) {
                                r8.close();
                            }
                            if (httpURLConnection != null) {
                                throw th;
                            }
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    }
                    bufferedReader2 = bufferedReader3;
                    printWriter = null;
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    bufferedReader2.close();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            } catch (java.lang.Exception e8) {
                e = e8;
                r8 = printWriter2;
                th = th;
            } catch (java.lang.Throwable th6) {
                th = th6;
                r8 = printWriter2;
            }
        } catch (java.lang.Exception e9) {
            e = e9;
            httpURLConnection = null;
            r8 = 0;
            th = th;
        } catch (java.lang.Throwable th7) {
            th = th7;
            httpURLConnection = null;
            r8 = 0;
        }
        return th.toString();
    }

    private static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String strEncode;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = "";
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            sb.append(str);
            sb.append(entry.getKey());
            sb.append("=");
            try {
                strEncode = java.net.URLEncoder.encode(entry.getValue(), "UTF-8");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.unisound.b.i.b("encode error, key = " + entry.getKey());
                strEncode = "";
            }
            sb.append(strEncode);
            str = "&";
        }
        com.unisound.b.i.d("requestData : POST params is " + sb.toString());
        return sb.toString();
    }

    public static void a(java.util.HashMap<java.lang.String, java.lang.String> map) {
        c = map;
    }
}
