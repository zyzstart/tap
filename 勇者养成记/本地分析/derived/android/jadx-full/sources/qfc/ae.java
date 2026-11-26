package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ae extends android.os.AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1695a = "https://cloud.tgpa.qq.com/xid_report/";
    private java.lang.String b = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvdIUsFlQpJDHydGfUHz7\niBXJupDyM01FEvxd8KMlqb8j0dveQ/lxY5LNrFb7Al3fNh1XhdOJgeNPsFLw+1H0\ngQQAStLKvmh3ERzpJSeStdl0TFRtJxU9JjPp1j/ZsSe5fQUAGEW6noy+EXHs0mq1\naHHVRcbLyfEfJ2bETpP15SBWttUml1X7roypf8mt1AVWOt3GX+WvZhRNuXwTCi+1\nGS3Hz1K/RO3ooi0HVt4zZaDIi+xG3b13i6iMArR7B8QiUEyFOOqmD6YaP5bViNRm\ne3NhrIvsbU2wDLYucBh6dmXBwuU0HPGt22Jqkvdxg1yOeKhYlDmwQv+O4Z/64kH+\n1QIDAQAB";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Void doInBackground(java.lang.String... strArr) throws java.lang.Throwable {
        java.lang.String strA;
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.String str = strArr[0];
        java.lang.String str2 = strArr[1];
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.io.BufferedInputStream bufferedInputStream2 = null;
        try {
            strA = qfc.z.a(str2.getBytes(), android.util.Base64.decode(this.b.getBytes(), 2));
            try {
                jSONObject.put("event_name", str);
                jSONObject.put("event_data", java.lang.String.valueOf(strA));
                jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_TIME, java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000));
                jSONObject.put("sdk_type", "simple");
                jSONObject.put("version_name", "1.0.8");
                jSONObject.put("version_code", com.tencent.connect.common.Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
            } catch (java.lang.Exception e) {
                e = e;
                e.printStackTrace();
                qfc.ac.j("make report json data exception.");
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            strA = null;
        }
        try {
            java.lang.String string = jSONObject.toString();
            qfc.ac.j("report json event data: " + java.lang.String.valueOf(strA));
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(this.f1695a).openConnection();
            httpURLConnection.setConnectTimeout(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
            httpURLConnection.setReadTimeout(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
            httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("accept", "application/json");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(string.getBytes());
            outputStream.flush();
            outputStream.close();
            bufferedInputStream = new java.io.BufferedInputStream(httpURLConnection.getInputStream());
            try {
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(bufferedInputStream, com.unisound.b.f.b));
                    while (true) {
                        java.lang.String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    qfc.ac.j("simple report response data: " + sb.toString());
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e4) {
                e = e4;
                e.printStackTrace();
                if (bufferedInputStream != null) {
                }
                return null;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            bufferedInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        try {
            bufferedInputStream.close();
        } catch (java.lang.Exception e6) {
            e6.printStackTrace();
        }
        return null;
    }
}
