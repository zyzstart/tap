package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1482a = 10485760;
    private static com.unisound.common.l b = null;
    private static int c = 1024;
    private static final java.lang.String d = "wakeupkeys";
    private static final java.lang.String e = "http://asr-wakeup.hivoice.cn:8080/uc/m/upload";
    private static final int f = 5000;
    private static final java.lang.String g = "WakeupWordCacheAndUpload";
    private static com.unisound.common.ba h;
    private static java.lang.Object i = new java.lang.Object();

    private ba() {
    }

    public static com.unisound.common.ba a() {
        if (h == null) {
            synchronized (i) {
                if (h == null) {
                    h = new com.unisound.common.ba();
                }
            }
        }
        return h;
    }

    public static java.io.File a(android.content.Context context, java.lang.String str) {
        return new java.io.File((("mounted".equals(android.os.Environment.getExternalStorageState()) || !android.os.Environment.isExternalStorageRemovable()) ? context.getExternalCacheDir() : context.getCacheDir()).getPath() + java.io.File.separator + str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static java.lang.String a(java.lang.String str, com.unisound.common.bd bdVar, java.util.concurrent.BlockingQueue<byte[]> blockingQueue, int i2) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.net.HttpURLConnection httpURLConnection;
        java.lang.Exception e2;
        com.unisound.common.y.c("WakeupWordCacheAndUpload httpPost params : K = " + bdVar.a() + ",UI = " + bdVar.b() + ",U = " + bdVar.c() + ",Text = " + bdVar.e() + bdVar.f() + ",Timestamp = " + bdVar.g() + ",timelength = " + bdVar.h() + ",AC = " + bdVar.d());
        java.lang.String str2 = "";
        java.net.HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                java.util.Iterator it = blockingQueue.iterator();
                int length = 0;
                while (it.hasNext()) {
                    length += ((byte[]) it.next()).length;
                }
                int i3 = length / ((bdVar.i() * 2) / 1000);
                httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                try {
                    httpURLConnection.setRequestProperty("K", java.net.URLEncoder.encode(bdVar.a(), "UTF-8"));
                    httpURLConnection.setRequestProperty("UI", java.net.URLEncoder.encode(bdVar.b(), "UTF-8"));
                    httpURLConnection.setRequestProperty("U", java.net.URLEncoder.encode(bdVar.c(), "UTF-8"));
                    httpURLConnection.setRequestProperty("Text", java.net.URLEncoder.encode(bdVar.e() + bdVar.f() + "_" + i3, "UTF-8"));
                    httpURLConnection.setRequestProperty("AC", java.net.URLEncoder.encode(bdVar.d(), "UTF-8"));
                    httpURLConnection.setRequestProperty("Timestamp", java.net.URLEncoder.encode(bdVar.g(), "UTF-8"));
                    httpURLConnection.setRequestProperty("TL", java.net.URLEncoder.encode(bdVar.h(), "UTF-8"));
                    httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setConnectTimeout(i2);
                    java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                    while (true) {
                        byte[] bArrPoll = blockingQueue.poll();
                        if (bArrPoll == null) {
                            break;
                        }
                        outputStream.write(bArrPoll);
                        if (com.unisound.common.y.p) {
                            com.unisound.common.j.a(bArrPoll, "/sdcard/asrtest/uploadwakeup.pcm");
                        }
                    }
                    outputStream.flush();
                    outputStream.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream(), com.unisound.b.f.b));
                        while (true) {
                            java.lang.String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            str2 = str2 + line;
                        }
                        bufferedReader.close();
                    } else {
                        com.unisound.common.y.a(g, "responseCode = " + responseCode);
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (java.lang.Exception e3) {
                    e2 = e3;
                    httpURLConnection2 = httpURLConnection;
                    e2.printStackTrace();
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e4) {
                e2 = e4;
            }
            return str2;
        } catch (java.lang.Throwable th3) {
            th = th3;
            httpURLConnection = httpURLConnection2;
        }
    }

    private static java.lang.String a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String strEncode;
        com.unisound.common.y.c("WakeupWordCacheAndUpload buildGetUrl");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
        java.lang.String str2 = "";
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            sb.append(str2);
            sb.append(entry.getKey());
            sb.append("=");
            try {
                strEncode = java.net.URLEncoder.encode(entry.getValue(), "UTF-8");
            } catch (java.io.UnsupportedEncodingException unused) {
                strEncode = "";
            }
            sb.append(strEncode);
            str2 = "&";
        }
        return sb.toString();
    }

    private static void a(android.content.Context context, java.lang.String str, com.unisound.common.bd bdVar) {
        com.unisound.common.y.c("WakeupWordCacheAndUpload saveParamsValue");
        java.lang.String strA = bdVar.a();
        java.lang.String strB = bdVar.b();
        java.lang.String strC = bdVar.c();
        java.lang.String str2 = bdVar.e() + "_" + bdVar.f();
        java.lang.String strD = bdVar.d();
        java.lang.String strG = bdVar.g();
        java.lang.String strH = bdVar.h();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(strA);
        sb.append("#");
        sb.append(strB);
        sb.append("#");
        sb.append(strC);
        sb.append("#");
        sb.append(str2);
        sb.append("#");
        sb.append(strG);
        sb.append("#");
        sb.append(strD);
        sb.append("#");
        sb.append(strH);
        sb.append("#");
        sb.append("end");
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(d, 0).edit();
        com.unisound.common.y.c("WakeupWordCacheAndUpload saveUploadKey : key = " + str + ", value = " + sb.toString());
        editorEdit.putString(str, sb.toString());
        editorEdit.commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean a(android.content.Context context, java.lang.String str, java.util.concurrent.BlockingQueue<byte[]> blockingQueue) {
        java.lang.Exception e2;
        com.unisound.common.n nVarB;
        com.unisound.common.y.c("WakeupWordCacheAndUpload saveData2Cache");
        java.io.OutputStream outputStreamC = null;
        try {
            try {
                if (b == null) {
                    b = com.unisound.common.l.a(a(context, "locationData"), 1, 1, 10485760L);
                }
                nVarB = b.b(str);
                try {
                    if (nVarB != null) {
                        outputStreamC = nVarB.c(0);
                        com.unisound.common.y.c("WakeupWordCacheAndUpload saveData2Cache: write BlockingQueue size :" + blockingQueue.size());
                        while (true) {
                            byte[] bArrPoll = blockingQueue.poll(50L, java.util.concurrent.TimeUnit.MILLISECONDS);
                            if (bArrPoll == null) {
                                break;
                            }
                            byte[] bArr = new byte[bArrPoll.length];
                            java.lang.System.arraycopy(bArrPoll, 0, bArr, 0, bArr.length);
                            outputStreamC.write(bArr);
                        }
                        outputStreamC.flush();
                        nVarB.a();
                        b.e();
                    } else {
                        com.unisound.common.y.a("WakeupWordCacheAndUpload DiskLruCacheWrapper: edit key:" + str + " , editor id null!");
                    }
                    if (outputStreamC == null) {
                        return true;
                    }
                    try {
                        outputStreamC.close();
                        return true;
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                        return true;
                    }
                } catch (java.lang.Exception e4) {
                    e2 = e4;
                    e2.printStackTrace();
                    if (nVarB != null) {
                        try {
                            nVarB.b();
                        } catch (java.io.IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (0 != 0) {
                        try {
                            outputStreamC.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return false;
                }
            } catch (java.lang.Throwable th) {
                if (0 != 0) {
                    try {
                        outputStreamC.close();
                    } catch (java.io.IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e8) {
            e2 = e8;
            nVarB = null;
        }
    }

    public static void b() {
        com.unisound.common.l lVar = b;
        if (lVar != null) {
            try {
                lVar.close();
                b = null;
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(android.content.Context context, com.unisound.common.bd bdVar, java.util.concurrent.BlockingQueue<byte[]> blockingQueue) {
        com.unisound.common.y.c("WakeupWordCacheAndUpload saveParamAndCache");
        java.lang.String string = java.lang.Long.toString(java.lang.System.currentTimeMillis());
        if (a(context, string, blockingQueue)) {
            a(context, string, bdVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(android.net.ConnectivityManager connectivityManager) {
        if (connectivityManager != null) {
            for (android.net.NetworkInfo networkInfo : connectivityManager.getAllNetworkInfo()) {
                if (android.net.NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.util.ArrayList<java.lang.String> c(android.content.Context context) {
        com.unisound.common.y.c("WakeupWordCacheAndUpload getCacheTimekeyList");
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        try {
            if (b == null) {
                b = com.unisound.common.l.a(a(context, "locationData"), 1, 1, 10485760L);
            }
            arrayList = b.g();
            com.unisound.common.y.c("KEY", "key size is " + arrayList.size());
            java.util.Iterator<java.lang.String> it = arrayList.iterator();
            while (it.hasNext()) {
                com.unisound.common.y.c("KEY", "key is " + it.next());
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.util.concurrent.BlockingQueue<byte[]> c(android.content.Context context, java.lang.String str) {
        com.unisound.common.y.c("WakeupWordCacheAndUpload getCacheData");
        java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue();
        java.io.InputStream inputStreamA = null;
        try {
            try {
                try {
                    if (b == null) {
                        b = com.unisound.common.l.a(a(context, "locationData"), 1, 1, 10485760L);
                    }
                    com.unisound.common.q qVarA = b.a(str);
                    if (qVarA != null) {
                        inputStreamA = qVarA.a(0);
                        byte[] bArr = new byte[c];
                        while (true) {
                            int i2 = inputStreamA.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            byte[] bArr2 = new byte[i2];
                            java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
                            linkedBlockingQueue.add(bArr2);
                        }
                    }
                    if (inputStreamA != null) {
                        inputStreamA.close();
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    if (inputStreamA != null) {
                        inputStreamA.close();
                    }
                }
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
            }
            return linkedBlockingQueue;
        } catch (java.lang.Throwable th) {
            if (inputStreamA != null) {
                try {
                    inputStreamA.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(android.content.Context context, com.unisound.common.bd bdVar, java.util.concurrent.BlockingQueue<byte[]> blockingQueue) throws java.lang.Throwable {
        com.unisound.common.y.c("WakeupWordCacheAndUpload uploadWakeupContent");
        if (!b((android.net.ConnectivityManager) context.getSystemService("connectivity"))) {
            return false;
        }
        java.lang.String strA = a(e, bdVar, blockingQueue, 5000);
        com.unisound.common.y.c("WakeupWordCacheAndUpload uploadWakeup result = " + strA);
        if (strA.equals("")) {
            return false;
        }
        try {
            java.lang.String string = new org.json.JSONObject(strA).getString("rc");
            if (string.equals("0")) {
                return true;
            }
            if (!string.equals("-1002")) {
                return false;
            }
            com.unisound.common.y.a("WakeupWordCacheAndUpload uploadWakeup error ! result = " + strA);
            return false;
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean d(android.content.Context context, java.lang.String str) {
        com.unisound.common.y.c("WakeupWordCacheAndUpload removeCache");
        try {
            if (b == null) {
                b = com.unisound.common.l.a(a(context, "locationData"), 1, 1, 10485760L);
            }
            return b.c(str);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static void e(android.content.Context context, java.lang.String str) {
        com.unisound.common.y.c("WakeupWordCacheAndUpload removeParamsValue");
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(d, 0).edit();
        com.unisound.common.y.c("WakeupWordCacheAndUpload removeUploadKey : key = " + str);
        editorEdit.remove(str);
        editorEdit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(android.content.Context context, java.lang.String str) {
        e(context, str);
        d(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.unisound.common.bd g(android.content.Context context, java.lang.String str) {
        com.unisound.common.y.c("WakeupWordCacheAndUpload getWakeupwordParam");
        com.unisound.common.bd bdVar = new com.unisound.common.bd();
        java.lang.String string = context.getSharedPreferences(d, 0).getString(str, "");
        if (android.text.TextUtils.isEmpty(string)) {
            return null;
        }
        java.lang.String[] strArrSplit = string.split("#");
        com.unisound.common.y.c("WakeupWordCacheAndUpload getWakeupwordParam length = " + strArrSplit.length);
        for (java.lang.String str2 : strArrSplit) {
            com.unisound.common.y.c("WakeupWordCacheAndUpload getWakeupwordParam value = " + str2);
        }
        bdVar.a(strArrSplit[0]);
        bdVar.b(strArrSplit[1]);
        bdVar.c(strArrSplit[2]);
        bdVar.e(strArrSplit[3].split("_")[0]);
        bdVar.a(java.lang.Float.parseFloat(strArrSplit[3].split("_")[1]));
        bdVar.f(strArrSplit[4]);
        bdVar.d(strArrSplit[5]);
        bdVar.g(strArrSplit[6]);
        return bdVar;
    }

    public void a(android.content.Context context) {
        new com.unisound.common.bc(this, context).start();
    }

    public void a(android.content.Context context, com.unisound.common.bd bdVar, java.util.concurrent.BlockingQueue<byte[]> blockingQueue) {
        new com.unisound.common.bb(this, blockingQueue, context, bdVar).start();
    }
}
