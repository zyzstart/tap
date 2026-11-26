package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class cq extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f1556a = "http://v2.hivoice.cn:8081/casr/upload";
    public static final int b = 10000;
    public static final int c = 3000;
    public static final int d = 3000;
    public static final int e = 3000;
    public static final int f = 3000;
    public static final int g = 3000;
    public static final int h = 3000;
    private com.unisound.sdk.cr i;
    private java.lang.String k;
    private cn.yunzhisheng.casr.EncodeContent j = new cn.yunzhisheng.casr.EncodeContent();
    private java.lang.String l = "";

    private java.util.Map<java.lang.Integer, java.util.List<java.lang.String>> a(java.util.Map<java.lang.Integer, java.util.List<java.lang.String>> map) {
        java.util.Iterator<java.lang.Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            java.util.List<java.lang.String> list = map.get(it.next());
            if (list != null) {
                a(list);
                list.size();
            }
        }
        return map;
    }

    private void a(java.lang.String str) {
        com.unisound.common.y.a("UploadUserData:" + str);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0048  */
    private void a(java.util.List<java.lang.String> list) {
        for (int size = list.size() - 1; size > -1; size--) {
            java.lang.String strReplaceAll = list.get(size);
            if (strReplaceAll == null || strReplaceAll.length() == 0) {
                list.remove(size);
            } else {
                boolean z = false;
                if (strReplaceAll.indexOf(">") > -1) {
                    strReplaceAll = strReplaceAll.replaceAll(">", "");
                    z = true;
                }
                if (strReplaceAll.indexOf("<") > -1) {
                    strReplaceAll = strReplaceAll.replaceAll("<", "");
                    z = true;
                }
                if (strReplaceAll.length() == 0) {
                    list.remove(size);
                } else if (z) {
                    list.set(size, strReplaceAll);
                }
            }
        }
    }

    private boolean a(int i, java.util.List<java.lang.String> list, java.lang.StringBuilder sb) {
        java.lang.String strC = c(i);
        if (strC == null) {
            a(" not find tag id = " + i);
            return true;
        }
        if (list == null) {
            a(strC + " = NULL");
            return true;
        }
        int iB = b(i);
        if (list.size() > iB) {
            a(strC + " Number of over count > " + iB);
            a(com.unisound.client.ErrorCode.UPLOAD_USER_TOO_LARGE);
            return false;
        }
        a(list);
        sb.append("<" + strC + ">\n");
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("\n");
        }
        sb.append("</" + strC + ">\n");
        return true;
    }

    private int b(int i) {
        switch (i) {
            case 1:
                return 10000;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return 3000;
            default:
                return -1;
        }
    }

    private void b(java.lang.String str) {
        this.k = str;
        start();
    }

    private java.lang.String c(int i) {
        switch (i) {
            case 1:
                return "NAME";
            case 2:
                return "APP";
            case 3:
                return "SONG";
            case 4:
                return "SINGER";
            case 5:
                return "ALBUM";
            case 6:
                return "COMMAND";
            case 7:
                return "wechat_contact";
            default:
                return null;
        }
    }

    public void a(int i) {
        com.unisound.sdk.cr crVar = this.i;
        if (crVar != null) {
            crVar.e(i);
        }
    }

    public void a(com.unisound.sdk.cr crVar) {
        this.i = crVar;
    }

    public void a(java.lang.String str, android.util.SparseArray<java.util.List<java.lang.String>> sparseArray) {
        this.l = str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(";");
        sb.append(com.unisound.c.a.a(str));
        sb.append("\n");
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            if (!a(iKeyAt, sparseArray.get(iKeyAt), sb)) {
                return;
            }
        }
        b(sb.toString());
    }

    public void a(java.lang.String str, java.lang.String str2) {
        this.l = str;
        b(str + ";" + com.unisound.c.a.a(str) + "\n");
    }

    public void a(java.lang.String str, java.util.Map<java.lang.Integer, java.util.List<java.lang.String>> map) {
        this.l = str;
        if (this.i == null || map == null) {
            a(com.unisound.client.ErrorCode.UPLOAD_USER_DATA_EMPTY);
            return;
        }
        if (map.isEmpty()) {
            a(com.unisound.client.ErrorCode.UPLOAD_USER_DATA_EMPTY);
            return;
        }
        java.util.Map<java.lang.Integer, java.util.List<java.lang.String>> mapA = a(map);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(";");
        sb.append(com.unisound.c.a.a(str));
        sb.append("\n");
        for (java.lang.Integer num : mapA.keySet()) {
            if (!a(num.intValue(), mapA.get(num), sb)) {
                return;
            }
        }
        b(sb.toString());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int i = com.unisound.client.ErrorCode.UPLOAD_USER_DATA_NETWORK_ERROR;
        try {
            byte[] bytes = com.unisound.c.a.a(this.l).getBytes();
            int i2 = 0;
            com.unisound.common.y.c("uploadUserData server is :\n", f1556a, "\n Data is \n", this.k);
            byte[] bytes2 = this.k.getBytes();
            byte[] bArr = new byte[bytes.length + bytes2.length + 10];
            if (this.j.EncodeTotalContent(bytes, bytes2, bArr) != 0) {
                i = com.unisound.client.ErrorCode.UPLOAD_USER_ENCODE_ERROR;
            } else {
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(f1556a).openConnection();
                httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setConnectTimeout(30000);
                java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                if (httpURLConnection.getResponseCode() == 200) {
                    int i3 = java.lang.Integer.parseInt(new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream())).readLine());
                    com.unisound.common.y.c("upload userdata code=", java.lang.Integer.valueOf(i3));
                    if (i3 != 0) {
                        i2 = i3 == -6 ? com.unisound.client.ErrorCode.UPLOAD_USER_DATA_TOO_FAST : com.unisound.client.ErrorCode.UPLOAD_USER_DATA_SERVER_REFUSED;
                    }
                    i = i2;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        a(i);
    }
}
