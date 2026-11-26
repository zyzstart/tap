package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ax extends java.lang.Thread {
    private com.unisound.common.am b;
    private java.lang.String c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f1480a = "";
    private com.unisound.common.ak d = null;
    private com.unisound.client.ErrorCode e = new com.unisound.client.ErrorCode();

    private void a(int i) {
        com.unisound.common.am amVar = this.b;
        if (amVar != null) {
            amVar.a(this, this.e.createProfessionError(i));
        }
    }

    private void c(java.lang.String str) {
        this.c = str;
        start();
    }

    public com.unisound.common.ak a() {
        return this.d;
    }

    void a(com.unisound.common.am amVar) {
        this.b = amVar;
    }

    public void a(java.lang.String str) {
        this.f1480a = str;
    }

    void a(java.lang.String str, com.unisound.common.ak akVar, java.util.List<java.lang.String> list) {
        this.d = akVar;
        this.d.a(false);
        this.f1480a += "?ak=" + str + "&imei=" + com.unisound.c.a.q + "&an=wechar&si=" + akVar.c() + "&av=1.0&sn=abcdefg&trace=1";
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("data=<SCENE>\n");
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("\n");
        }
        sb.append("</SCENE>");
        c(sb.toString());
    }

    public void b() {
        this.b = null;
    }

    protected void b(java.lang.String str) {
        com.unisound.common.y.a("UploadSceneTask:" + str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int i = com.unisound.client.ErrorCode.UPLOAD_SCENE_DATA_NETWORK_ERROR;
        try {
            byte[] bytes = this.c.getBytes();
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(this.f1480a).openConnection();
            httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(30000);
            java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream())).readLine());
                int i2 = java.lang.Integer.parseInt(jSONObject.has(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE) ? jSONObject.getString(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE) : "");
                int i3 = 0;
                com.unisound.common.y.c("upload userdata code=", java.lang.Integer.valueOf(i2));
                if (i2 == 0) {
                    this.d.a(true);
                } else if (i2 == -1) {
                    i3 = com.unisound.client.ErrorCode.UPLOAD_SCENE_GENERAL_ERROR;
                } else if (i2 == -5) {
                    i3 = com.unisound.client.ErrorCode.UPLOAD_SCENE_INVALID_KEY;
                } else if (i2 == -8) {
                    i3 = com.unisound.client.ErrorCode.UPLOAD_SCENE_STREAM_IO_ERR;
                } else if (i2 == -11) {
                    i3 = com.unisound.client.ErrorCode.UPLOAD_SCENE_UNKNOWN_ERR;
                } else if (i2 == -12) {
                    i3 = com.unisound.client.ErrorCode.UPLOAD_SCENE_DATA_SIZE_IS_FORBIDDEN;
                } else if (i2 == -13) {
                    i3 = com.unisound.client.ErrorCode.UPLOAD_SCENE_INVALID_VER;
                } else {
                    i3 = i2 == -6 ? com.unisound.client.ErrorCode.UPLOAD_SCENE_DATA_TOO_FAST : com.unisound.client.ErrorCode.UPLOAD_SCENE_DATA_SERVER_REFUSED;
                }
                i = i3;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        a(i);
    }
}
