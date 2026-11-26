package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class u {
    public static java.lang.String a(java.lang.String str) {
        return a(str, 30000);
    }

    /* JADX WARN: Code duplicated, block: B:72:0x00c8 A[Catch: IOException -> 0x00c4, TryCatch #10 {IOException -> 0x00c4, blocks: (B:68:0x00c0, B:72:0x00c8, B:74:0x00cd), top: B:80:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x00cd A[Catch: IOException -> 0x00c4, TRY_LEAVE, TryCatch #10 {IOException -> 0x00c4, blocks: (B:68:0x00c0, B:72:0x00c8, B:74:0x00cd), top: B:80:0x00c0 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a(java.lang.String str, int i) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.IOException e;
        java.net.MalformedURLException e2;
        java.io.InputStream inputStream;
        java.lang.String str2 = "";
        java.io.InputStream inputStream2 = null;
        java.io.BufferedReader bufferedReader2 = null;
        inputStream2 = null;
        inputStream2 = null;
        inputStream2 = null;
        inputStream2 = null;
        inputStream2 = null;
        inputStream2 = null;
        try {
            try {
                try {
                    str = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                    try {
                        str.setConnectTimeout(i);
                        str.setRequestMethod(com.tencent.connect.common.Constants.HTTP_GET);
                        str.connect();
                        if (str.getResponseCode() == 200) {
                            inputStream = str.getInputStream();
                            try {
                                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, com.unisound.b.f.b));
                                while (true) {
                                    try {
                                        java.lang.String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        str2 = str2 + line;
                                    } catch (java.net.MalformedURLException e3) {
                                        inputStream2 = inputStream;
                                        e2 = e3;
                                        str = str;
                                        e2.printStackTrace();
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (str != 0) {
                                            str.disconnect();
                                        }
                                    } catch (java.io.IOException e4) {
                                        inputStream2 = inputStream;
                                        e = e4;
                                        str = str;
                                        e.printStackTrace();
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (str != 0) {
                                            str.disconnect();
                                        }
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        inputStream2 = inputStream;
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                                if (bufferedReader != null) {
                                                    bufferedReader.close();
                                                }
                                                if (str != 0) {
                                                    str.disconnect();
                                                }
                                            } catch (java.io.IOException e5) {
                                                e5.printStackTrace();
                                                throw th;
                                            }
                                        } else {
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                            if (str != 0) {
                                                str.disconnect();
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                bufferedReader2 = bufferedReader;
                            } catch (java.net.MalformedURLException e6) {
                                inputStream2 = inputStream;
                                e2 = e6;
                                bufferedReader = null;
                                str = str;
                            } catch (java.io.IOException e7) {
                                inputStream2 = inputStream;
                                e = e7;
                                bufferedReader = null;
                                str = str;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                bufferedReader = null;
                            }
                        } else {
                            str2 = "{}";
                            inputStream = null;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (str != 0) {
                            str.disconnect();
                        }
                    } catch (java.net.MalformedURLException e8) {
                        e2 = e8;
                        bufferedReader = null;
                        str = str;
                    } catch (java.io.IOException e9) {
                        e = e9;
                        bufferedReader = null;
                        str = str;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (java.io.IOException e10) {
                    e10.printStackTrace();
                }
            } catch (java.net.MalformedURLException e11) {
                e2 = e11;
                str = 0;
                bufferedReader = null;
            } catch (java.io.IOException e12) {
                e = e12;
                str = 0;
                bufferedReader = null;
            } catch (java.lang.Throwable th4) {
                th = th4;
                str = 0;
                bufferedReader = null;
            }
            return str2;
        } catch (java.lang.Throwable th5) {
            th = th5;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return a(str, str2.getBytes());
    }

    public static java.lang.String a(java.lang.String str, byte[] bArr) {
        return a(str, bArr, 30000);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a(java.lang.String str, byte[] bArr, int i) throws java.lang.Throwable {
        ?? r3;
        java.lang.String string = "";
        ?? r1 = 0;
        r1 = 0;
        try {
            try {
                r3 = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                try {
                    r3.setRequestProperty("Accept-Charset", "UTF-8");
                    r3.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                    r1 = 1;
                    r3.setDoInput(true);
                    r3.setDoOutput(true);
                    r3.setConnectTimeout(i);
                    java.io.OutputStream outputStream = r3.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    outputStream.close();
                    if (r3.getResponseCode() == 200) {
                        java.io.InputStream inputStream = r3.getInputStream();
                        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, com.unisound.b.f.b));
                        java.lang.Object obj = inputStream;
                        while (true) {
                            java.lang.String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(string);
                            sb.append(line);
                            string = sb.toString();
                            obj = sb;
                        }
                        bufferedReader.close();
                        r1 = obj;
                    } else {
                        string = "{}";
                    }
                    if (r3 != 0) {
                        r3.disconnect();
                    }
                } catch (java.lang.Exception e) {
                    e = e;
                    r1 = r3;
                    e.printStackTrace();
                    string = "Error";
                    if (r1 != 0) {
                        r1.disconnect();
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (r3 != 0) {
                        r3.disconnect();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                r3 = r1;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        return string;
    }

    public static int b(java.lang.String str, java.lang.String str2) {
        return b(str, str2.getBytes(), 30000);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    public static int b(java.lang.String str, byte[] bArr, int i) throws java.lang.Throwable {
        ?? r2;
        int responseCode;
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                r2 = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                try {
                    r2.setRequestProperty("Accept-Charset", "UTF-8");
                    r2.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                    r0 = 1;
                    r0 = 1;
                    r2.setDoInput(true);
                    r2.setDoOutput(true);
                    r2.setConnectTimeout(i);
                    java.io.OutputStream outputStream = r2.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    outputStream.close();
                    responseCode = r2.getResponseCode();
                    if (responseCode == 200) {
                        responseCode = 0;
                    }
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                } catch (java.lang.Exception e) {
                    e = e;
                    r0 = r2;
                    e.printStackTrace();
                    if (r0 != 0) {
                        r0.disconnect();
                    }
                    responseCode = -1;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                r2 = r0;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        return responseCode;
    }
}
