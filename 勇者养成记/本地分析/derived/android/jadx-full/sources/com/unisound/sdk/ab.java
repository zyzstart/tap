package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ab {
    public static final java.lang.String f = "ml";
    public static final int i = 0;
    public static final int j = -100;
    public static final int k = -200;
    public static final int l = -300;
    public static int m = 20;
    public static final int n = 1000;
    public static final int o = 1001;
    private static java.lang.String q = "assetsModelsMD5";
    private static com.unisound.sdk.g t = new com.unisound.sdk.g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f1512a;
    public java.lang.String[] b = {"tri", "l", "wid", "am", "digit", "wseg", com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_STAT};
    public java.lang.String c = "am";
    public java.lang.String d = "net";
    private java.lang.String p = ".dat";
    public java.lang.String e = "main";
    public boolean g = false;
    private boolean r = false;
    private java.util.List<java.lang.String> s = new java.util.ArrayList();
    public boolean h = false;
    private com.unisound.sdk.ac u = null;

    public ab() {
        t.a(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void a(java.util.Map<java.lang.String, java.lang.String> map) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            try {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    for (java.lang.String str : map.keySet()) {
                        jSONObject.put(str, map.get(str));
                    }
                    java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(this.f1512a + q, "rw");
                    try {
                        randomAccessFile2.write(jSONObject.toString().getBytes());
                        randomAccessFile2.close();
                    } catch (java.lang.Exception e) {
                        randomAccessFile = randomAccessFile2;
                        e = e;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                    } catch (java.lang.Throwable th) {
                        randomAccessFile = randomAccessFile2;
                        th = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
            }
        } catch (java.io.IOException e4) {
            e4.printStackTrace();
        }
    }

    private boolean a(android.content.res.AssetManager assetManager, java.lang.String str) {
        boolean z;
        this.r = false;
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                return true;
            }
            java.io.InputStream inputStreamOpen = assetManager.open("version/data");
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStreamOpen));
            java.lang.String line = bufferedReader.readLine();
            inputStreamOpen.close();
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(file));
            java.lang.String line2 = bufferedReader2.readLine();
            boolean z2 = (line2 == null || line2.equals(line)) ? false : true;
            bufferedReader.close();
            bufferedReader2.close();
            java.io.FileReader fileReader = new java.io.FileReader(new java.io.File(this.f1512a + q));
            java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(fileReader);
            java.lang.String line3 = bufferedReader3.readLine();
            org.json.JSONObject jSONObject = line3 != null ? new org.json.JSONObject(line3) : null;
            z = z2;
            for (java.lang.String str2 : this.b) {
                java.lang.String strK = k(this.f1512a + str2 + ".dat");
                java.lang.String string = jSONObject != null ? jSONObject.getString(str2) : "";
                if (android.text.TextUtils.isEmpty(string) || android.text.TextUtils.isEmpty(strK) || !string.equalsIgnoreCase(strK)) {
                    this.r = true;
                    java.util.List<java.lang.String> list = this.s;
                    list.add(str2);
                    z = true;
                }
            }
            bufferedReader3.close();
            fileReader.close();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            z = true;
        }
        com.unisound.common.y.c("ModelData isUpdateModel = " + z);
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean a(android.content.res.AssetManager assetManager, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(new java.io.File(str2));
                try {
                    byte[] bArr = new byte[10240];
                    if (m == 1) {
                        java.io.InputStream inputStreamOpen = assetManager.open(str + "/data");
                        while (true) {
                            int i2 = inputStreamOpen.read(bArr, 0, bArr.length);
                            if (i2 <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i2);
                        }
                        inputStreamOpen.close();
                    } else {
                        for (java.lang.String str3 : assetManager.list(str)) {
                            java.io.InputStream inputStreamOpen2 = assetManager.open(str + "/" + str3);
                            while (true) {
                                int i3 = inputStreamOpen2.read(bArr, 0, bArr.length);
                                if (i3 <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i3);
                            }
                            inputStreamOpen2.close();
                        }
                    }
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    com.unisound.common.y.a("init asr model error");
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
    }

    public static boolean a(android.content.res.AssetManager assetManager, java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        if (!z && new java.io.File(str2).exists()) {
            if (!z2 || cn.yunzhisheng.asrfix.JniAsrFix.a(str2)) {
                return true;
            }
            com.unisound.common.y.a("reset model file " + str2);
        }
        return a(assetManager, str, str2);
    }

    private java.lang.String b(android.content.res.AssetManager assetManager, java.lang.String str) {
        try {
            return com.unisound.common.aa.a(assetManager.open(str + "/data"));
        } catch (java.lang.Exception e) {
            com.unisound.common.y.a("getMd5FromAssets from assets error!");
            e.printStackTrace();
            return "";
        }
    }

    public static boolean d(java.lang.String str) {
        return cn.yunzhisheng.asrfix.JniAsrFix.a(str);
    }

    private boolean i(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    private static void j(java.lang.String str) {
        com.unisound.common.y.a(str);
    }

    private java.lang.String k(java.lang.String str) {
        try {
            return com.unisound.common.aa.a(new java.io.File(str));
        } catch (java.lang.Exception e) {
            com.unisound.common.y.a("getMd5FromAssets from file error!");
            e.printStackTrace();
            return "";
        }
    }

    public int a(int i2) {
        return t.a(i2);
    }

    public int a(java.lang.String str, java.lang.String str2) {
        return t.a(str, str2);
    }

    public int a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return t.a(str, str2, str3);
    }

    public int a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.io.File file = new java.io.File(str4);
        if (file.exists()) {
            file.delete();
        } else {
            java.io.File file2 = new java.io.File(file.getParent());
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        return t.a() ? t.a(str, str2, str3, str4) : t.a(str, str2, str3, this.f1512a, str4);
    }

    public int a(boolean z) {
        com.unisound.sdk.g gVar;
        int i2;
        if (z) {
            gVar = t;
            i2 = 1;
        } else {
            gVar = t;
            i2 = 0;
        }
        return gVar.b(i2);
    }

    public java.lang.String a() {
        return this.f1512a + this.d + ".dat";
    }

    public java.lang.String a(java.lang.String str, java.util.List<java.lang.String> list) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("<" + str + ">");
        stringBuffer.append("\n");
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append("\n");
        }
        stringBuffer.append("</" + str + ">");
        com.unisound.common.y.c("ModelData : ", "getVocabString --> vocab = ", stringBuffer.toString());
        return stringBuffer.toString();
    }

    public void a(com.unisound.sdk.ac acVar) {
        this.u = acVar;
    }

    public void a(java.lang.String str) {
        this.f1512a = str + "/";
    }

    public boolean a(android.content.Context context) {
        return a(context, false);
    }

    public boolean a(android.content.Context context, java.lang.String str) {
        try {
            java.io.InputStream inputStreamOpen = context.getAssets().open(str);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStreamOpen));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    inputStreamOpen.close();
                    return true;
                }
                java.lang.String[] strArrSplit = line.split("=");
                if (strArrSplit.length == 2) {
                    java.lang.String strTrim = strArrSplit[0].trim();
                    java.lang.String strTrim2 = strArrSplit[1].trim();
                    if ("models".equals(strTrim)) {
                        this.b = strTrim2.split(",");
                    } else if ("am".equals(strTrim)) {
                        this.c = strTrim2;
                    } else if ("custom".equals(strTrim)) {
                        this.d = strTrim2;
                    } else if ("domain".equals(strTrim)) {
                        this.e = strTrim2;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.unisound.common.y.a("model list error");
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean a(android.content.Context context, boolean z) {
        synchronized (this) {
            if (this.g) {
                return true;
            }
            android.content.res.AssetManager assets = context.getAssets();
            java.io.File file = new java.io.File(this.f1512a);
            if (!file.exists()) {
                file.mkdirs();
            }
            boolean zA = a(assets, this.f1512a + com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION);
            if (zA) {
                com.unisound.common.y.a("init asr models..");
                java.util.HashMap map = new java.util.HashMap();
                if (this.r) {
                    for (java.lang.String str : this.s) {
                        com.unisound.common.y.c("ModelData , partCopy : model = " + str);
                        if (!a(assets, str, this.f1512a + str + ".dat", zA, this.h)) {
                            return false;
                        }
                    }
                }
                for (java.lang.String str2 : this.b) {
                    if (!this.r) {
                        if (!a(assets, str2, this.f1512a + str2 + ".dat", zA, this.h)) {
                            return false;
                        }
                    }
                    map.put(str2, b(assets, str2));
                }
                com.unisound.common.y.a("init asr models ok");
                a(assets, com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, this.f1512a + com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION);
                a(map);
                this.s.clear();
            } else {
                com.unisound.common.y.a("init not overwrite models..");
            }
            if (!t.a() && z && t.a(this.f1512a)) {
                this.u.a(1000);
            }
            this.g = true;
            return true;
        }
    }

    public java.lang.String b(java.lang.String str) {
        return this.f1512a + str + "_partialFile";
    }

    public boolean b() {
        java.lang.String str = this.f1512a + this.d + this.p;
        if (cn.yunzhisheng.asrfix.JniAsrFix.a(str)) {
            return true;
        }
        i(str);
        return false;
    }

    public boolean b(android.content.Context context, java.lang.String str) {
        try {
            for (java.lang.String str2 : context.getAssets().list("")) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean c() {
        boolean zA;
        synchronized (this) {
            zA = cn.yunzhisheng.asrfix.JniAsrFix.a(this.f1512a + this.d + this.p);
        }
        return zA;
    }

    public boolean c(java.lang.String str) {
        return false;
    }

    public int d() {
        try {
            synchronized (this) {
                java.io.File file = new java.io.File(this.f1512a + this.c + this.p);
                if (!file.exists()) {
                    return 0;
                }
                return (int) file.length();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.unisound.common.y.a("setAMFile error");
            return 0;
        }
    }

    public int e(java.lang.String str) {
        int iCompileDecodeNet = cn.yunzhisheng.asrfix.JniAsrFix.compileDecodeNet(this.f1512a, str);
        if (iCompileDecodeNet == 0) {
            return 0;
        }
        j("setUserData DecodeNet error:" + iCompileDecodeNet);
        return l;
    }

    public boolean e() {
        return cn.yunzhisheng.asrfix.JniAsrFix.a(this.f1512a + this.c);
    }

    public java.lang.String f(java.lang.String str) {
        java.lang.String str2 = "#JSGF V1.0 utf-8 cn;\ngrammar " + str + ";\npublic <" + str + "> =( \"<s>\" (\n<NAME>\n) \"</s>\");";
        com.unisound.common.y.c("ModelData : ", "getJsgf --> jsgf = ", str2);
        return str2;
    }

    public void f() {
        t.b();
    }

    public java.lang.String g() {
        return t.c();
    }

    public java.lang.String g(java.lang.String str) {
        return this.f1512a + "jsgf_model/" + str + ".dat";
    }

    public int h(java.lang.String str) {
        return t.b(str);
    }

    public com.unisound.sdk.g h() {
        return t;
    }
}
