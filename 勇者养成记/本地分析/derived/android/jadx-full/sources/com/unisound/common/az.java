package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class az {
    private static java.io.File a(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            com.unisound.common.y.c("VprHttpClient : ", "create filedir failure!");
        }
        try {
            file.createNewFile();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0055 A[Catch: IOException -> 0x0051, TRY_LEAVE, TryCatch #5 {IOException -> 0x0051, blocks: (B:23:0x004d, B:27:0x0055), top: B:70:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:50:0x008f A[Catch: IOException -> 0x008b, TRY_LEAVE, TryCatch #8 {IOException -> 0x008b, blocks: (B:46:0x0087, B:50:0x008f), top: B:72:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7 A[Catch: IOException -> 0x00a3, TRY_LEAVE, TryCatch #2 {IOException -> 0x00a3, blocks: (B:58:0x009f, B:62:0x00a7), top: B:66:0x009f }] */
    /* JADX WARN: Code duplicated, block: B:66:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static boolean a(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        java.io.FileOutputStream fileOutputStream;
        java.net.HttpURLConnection httpURLConnection = null;
        java.io.FileOutputStream fileOutputStream2 = null;
        httpURLConnection = null;
        try {
            java.io.File fileA = a(str2);
            java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(30000);
                httpURLConnection2.setRequestMethod(com.tencent.connect.common.Constants.HTTP_GET);
                httpURLConnection2.connect();
                if (httpURLConnection2.getResponseCode() == 200) {
                    inputStream = httpURLConnection2.getInputStream();
                    try {
                        byte[] bArrA = a(inputStream);
                        fileOutputStream = new java.io.FileOutputStream(fileA);
                        try {
                            fileOutputStream.write(bArrA);
                            fileOutputStream.flush();
                            fileOutputStream2 = fileOutputStream;
                        } catch (java.lang.Exception e) {
                            e = e;
                            httpURLConnection = httpURLConnection2;
                            try {
                                com.unisound.common.y.c("VprHttpClient : ", "getVPRAudio wrong!");
                                e.printStackTrace();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (java.io.IOException e2) {
                                        e2.printStackTrace();
                                        return false;
                                    }
                                } else if (inputStream != null) {
                                    inputStream.close();
                                }
                                return false;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (java.io.IOException e3) {
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                } else if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } else if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        fileOutputStream = null;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } else {
                    inputStream = null;
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                } else if (inputStream != null) {
                    inputStream.close();
                }
                return true;
            } catch (java.lang.Exception e6) {
                e = e6;
                inputStream = null;
                fileOutputStream = null;
            } catch (java.lang.Throwable th4) {
                th = th4;
                inputStream = null;
                fileOutputStream = null;
            }
        } catch (java.lang.Exception e7) {
            e = e7;
            inputStream = null;
            fileOutputStream = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            inputStream = null;
            fileOutputStream = null;
        }
    }

    public static byte[] a(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }
}
