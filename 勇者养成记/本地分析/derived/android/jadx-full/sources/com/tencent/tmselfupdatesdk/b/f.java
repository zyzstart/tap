package com.tencent.tmselfupdatesdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.ThreadLocal f1153a;
    private static final int b;
    private static com.tencent.tmselfupdatesdk.b.f c;
    private static final java.lang.String d;
    private com.tencent.tmselfupdatesdk.b.d e;
    private com.tencent.tmselfupdatesdk.b.b g;
    private com.tencent.tmassistantbase.jce.GetHotSdkUpdateResponse h;
    private android.content.Context i;
    private volatile boolean f = false;
    private com.tencent.tmselfupdatesdk.b.c j = new com.tencent.tmselfupdatesdk.b.i(this);
    private com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener k = new com.tencent.tmselfupdatesdk.b.j(this);
    private java.lang.String l = "http://down.myapp.com/myapp/yingyongbao/superappsdk/patch.zip";

    static {
        b = com.tencent.tmassistantbase.common.a.f1018a ? 100000 : 3;
        d = com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.class.getName();
        f1153a = new com.tencent.tmselfupdatesdk.b.k();
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.tmselfupdatesdk.b.e a(android.content.Context context, com.tencent.tmselfupdatesdk.b.d dVar) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.tencent.tmassistantbase.util.x.a("PatchManager", "loadPatch start.. context=" + context + ". patchInfo=" + dVar);
        java.lang.ClassLoader classLoader = context.getApplicationContext().getClassLoader();
        try {
            java.io.File file = new java.io.File(dVar.c);
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
            com.tencent.tmselfupdatesdk.b.e eVar = new com.tencent.tmselfupdatesdk.b.e();
            dalvik.system.DexClassLoader dexClassLoader = new dalvik.system.DexClassLoader(dVar.f1151a, dVar.c, dVar.b, classLoader.getParent());
            eVar.b = dexClassLoader;
            eVar.f1152a = dexClassLoader.loadClass(d);
            com.tencent.tmassistantbase.util.x.a("PatchManager", "patchLoaderInfo.entryClass=" + eVar.f1152a);
            com.tencent.tmassistantbase.util.x.a("PatchManager", "patchLoaderInfo.entryClass.getInstance=" + com.tencent.tmselfupdatesdk.util.c.a(eVar.f1152a).d("getInstance").a());
            dVar.e = (java.lang.String) com.tencent.tmselfupdatesdk.util.c.a(eVar.f1152a).d("getInstance").d("getSDKName").a();
            dVar.f = (java.lang.String) com.tencent.tmselfupdatesdk.util.c.a(eVar.f1152a).d("getInstance").d("getSDKVersionName").a();
            dVar.g = ((java.lang.Integer) com.tencent.tmselfupdatesdk.util.c.a(eVar.f1152a).d("getInstance").d("getSDKVersionCode").a()).intValue();
            dVar.h = ((java.lang.Integer) com.tencent.tmselfupdatesdk.util.c.a(eVar.f1152a).d("getInstance").d("getSDKBuildNo").a()).intValue();
            android.util.Log.e("PatchManager", "loadPatch success.. context=" + context + ". cost time:" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms. patchInfo=" + dVar);
            com.tencent.tmselfupdatesdk.util.a.a("loadPatchSuccess", true, b(dVar.g, dVar.h));
            return eVar;
        } catch (java.lang.Throwable th) {
            android.util.Log.e("PatchManager", "loadPatch exception.. context=" + context + ". patchInfo=" + dVar);
            com.tencent.yybsdk.apkpatch.f.b.a(dVar.f1151a);
            com.tencent.tmselfupdatesdk.util.a.a("loadPatchException", true, b(dVar.g, dVar.h));
            th.printStackTrace();
            return null;
        }
    }

    public static synchronized com.tencent.tmselfupdatesdk.b.f a() {
        if (c == null) {
            c = new com.tencent.tmselfupdatesdk.b.f();
        }
        return c;
    }

    private void a(int i, int i2) {
        java.util.List listG = g();
        java.lang.String strB = b(i, i2);
        if (listG.contains(strB)) {
            return;
        }
        java.lang.String strA = com.tencent.tmassistantbase.common.e.a().a("key_exception_hot_sdk_versions", "");
        if (android.text.TextUtils.isEmpty(strA)) {
            com.tencent.tmassistantbase.common.e.a().b("key_exception_hot_sdk_versions", strB);
        } else {
            com.tencent.tmassistantbase.common.e.a().b("key_exception_hot_sdk_versions", strA + "|" + strB);
        }
        com.tencent.tmselfupdatesdk.util.a.a("runPatchException", true, strB);
    }

    private void a(java.lang.String str, int i) {
        android.content.SharedPreferences.Editor editorEdit = this.i.getSharedPreferences("TMSDKPrefer", 0).edit();
        editorEdit.putInt(str, i);
        editorEdit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, long j) {
        android.content.SharedPreferences.Editor editorEdit = this.i.getSharedPreferences("TMSDKPrefer", 0).edit();
        editorEdit.putLong(str, j);
        editorEdit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences.Editor editorEdit = this.i.getSharedPreferences("TMSDKPrefer", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    private int b(java.lang.String str, int i) {
        return this.i.getSharedPreferences("TMSDKPrefer", 0).getInt(str, i);
    }

    private long b(java.lang.String str, long j) {
        return this.i.getSharedPreferences("TMSDKPrefer", 0).getLong(str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.tmselfupdatesdk.b.d b(android.content.Context context) throws java.lang.Throwable {
        com.tencent.tmassistantbase.util.x.a("PatchManager", "loadPatchFromFile..");
        synchronized (this) {
            if (this.f) {
                com.tencent.tmassistantbase.util.x.b("PatchManager", "更新包已在加载中.. 暂时返回null");
                return null;
            }
            this.f = true;
            com.tencent.tmselfupdatesdk.b.d dVar = new com.tencent.tmselfupdatesdk.b.d();
            java.lang.String strB = b();
            dVar.f1151a = strB;
            java.lang.String strB2 = com.tencent.tmassistantbase.util.n.b(strB);
            java.lang.String strB3 = b("key_patch_md5", "");
            com.tencent.tmassistantbase.util.x.a("PatchManager", "localMD5=" + strB2 + "\nserverMd5=" + strB3);
            if (!strB3.equalsIgnoreCase(strB2)) {
                com.tencent.tmassistantbase.util.x.b("PatchManager", "更新包MD5与服务器下发的MD5不匹配，删除本地包，返回空.");
                com.tencent.yybsdk.apkpatch.f.b.a(dVar.f1151a);
                this.f = false;
                com.tencent.tmselfupdatesdk.util.a.a("loadPatchFailWrongMd5", true, strB2, strB3);
                return null;
            }
            dVar.c = context.getDir("tmsdkpatch", 0).getAbsolutePath() + java.io.File.separator + "oat";
            if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
                com.tencent.tmselfupdatesdk.b.e eVarA = a(context, dVar);
                dVar.d = eVarA;
                if (eVarA != null) {
                    this.e = dVar;
                    this.f = false;
                    com.tencent.tmassistantbase.util.x.a("PatchManager", "loadPatchFromFile. succeed! mPatchInfo=" + this.e);
                    return this.e;
                }
                this.f = false;
            } else {
                com.tencent.tmassistantbase.util.x.a("PatchManager", "current is main thread. load patch in a new thread..");
                new java.lang.Thread(new com.tencent.tmselfupdatesdk.b.h(this, dVar, context)).start();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String b(int i, int i2) {
        return i + "-" + i2;
    }

    private java.lang.String b(java.lang.String str, java.lang.String str2) {
        return this.i.getSharedPreferences("TMSDKPrefer", 0).getString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(android.content.Context context) {
        com.tencent.tmassistantbase.util.x.a("PatchManager", "refreshPatchFromNetwork. 拉取更新包信息..");
        if (b("key_last_request_patch_day", "").equals(d())) {
            a("key_today_request_patch_times", b("key_today_request_patch_times", 0) + 1);
        } else {
            a("key_last_request_patch_day", d());
            a("key_today_request_patch_times", 1);
        }
        if (this.g == null) {
            com.tencent.tmselfupdatesdk.b.b bVar = new com.tencent.tmselfupdatesdk.b.b();
            this.g = bVar;
            bVar.a(this.j);
        }
        this.g.a(this.e);
    }

    public static java.lang.String d() {
        return ((java.text.SimpleDateFormat) f1153a.get()).format(new java.util.Date());
    }

    private boolean e() {
        return new java.io.File(b()).exists();
    }

    private boolean f() {
        if (!com.tencent.tmassistantbase.b.d.a()) {
            com.tencent.tmassistantbase.util.x.b("PatchManager", "不满足拉取更新条件，没有网络.");
            return false;
        }
        if (!b("key_last_request_patch_day", "").equals(d())) {
            return true;
        }
        int iB = b("key_today_request_patch_times", 0);
        long jB = b("key_last_request_patch_success_time", 0L);
        if (java.lang.System.currentTimeMillis() - jB <= 600000) {
            if (com.tencent.tmassistantbase.common.a.f1018a) {
                com.tencent.tmassistantbase.util.x.b("PatchManager", "不满足拉取更新条件，距离上一次拉取成功间隔不到：10分钟. 当前时间间隔：" + (((java.lang.System.currentTimeMillis() - jB) / 1000) / 60) + "分钟");
            }
            return false;
        }
        if (iB < b) {
            return true;
        }
        if (com.tencent.tmassistantbase.common.a.f1018a) {
            com.tencent.tmassistantbase.util.x.b("PatchManager", "不满足拉取更新条件，当天已拉取次数：" + iB + ". 当天最大可拉取次数：" + b);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.List g() {
        return java.util.Arrays.asList(com.tencent.tmassistantbase.common.e.a().a("key_exception_hot_sdk_versions", "").split("|"));
    }

    public com.tencent.tmselfupdatesdk.b.d a(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        if (com.tencent.tmassistantbase.common.a.f1018a) {
            com.tencent.tmassistantbase.util.x.a("PatchManager", "PatchManager >> getPatchInfo called..");
        }
        this.i = context;
        com.tencent.tmassistantbase.util.k.a().a(this.i);
        if (e() && this.e == null) {
            com.tencent.tmassistantbase.util.x.a("PatchManager", "更新包已存在，加载本地包. path:" + b());
            this.e = b(context);
        }
        com.tencent.tmselfupdatesdk.b.d dVar = this.e;
        if (dVar == null || dVar.k || dVar.l) {
            com.tencent.tmselfupdatesdk.b.d dVar2 = this.e;
            if (dVar2 == null) {
                str = "PatchManager";
                str2 = "更新包信息为空，返回null.";
            } else if (dVar2.k) {
                str = "PatchManager";
                str2 = "更新包信息不为空，但发生过异常，返回null.";
            } else {
                str = "PatchManager";
                str2 = "更新包信息不为空，但已被回滚，返回null.";
            }
            com.tencent.tmassistantbase.util.x.a(str, str2);
            this.e = null;
        }
        if (f()) {
            new java.lang.Thread(new com.tencent.tmselfupdatesdk.b.g(this, context)).start();
        }
        com.tencent.tmassistantbase.util.x.a("PatchManager", "PatchManager >> getPatchInfo return " + this.e);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("当前使用的SDK版本号【");
        com.tencent.tmselfupdatesdk.b.d dVar3 = this.e;
        sb.append(dVar3 != null ? dVar3.g : 3010);
        sb.append("】, BuildNo:");
        com.tencent.tmselfupdatesdk.b.d dVar4 = this.e;
        sb.append(dVar4 != null ? java.lang.Integer.valueOf(dVar4.h) : "33");
        android.util.Log.i("PatchManager", sb.toString());
        return this.e;
    }

    public void a(com.tencent.tmselfupdatesdk.b.d dVar) {
        dVar.k = true;
        a(dVar.g, dVar.h);
        com.tencent.yybsdk.apkpatch.f.b.a(dVar.f1151a);
    }

    public void a(com.tencent.tmselfupdatesdk.b.d dVar, java.lang.String str) {
        java.lang.String strD = d();
        if (strD.equals(com.tencent.tmassistantbase.common.e.a().a(b(dVar.g, dVar.h), ""))) {
            return;
        }
        new java.lang.Thread(new com.tencent.tmselfupdatesdk.b.l(this, strD, dVar, str)).start();
    }

    public java.lang.String b() {
        return this.i.getDir("tmsdkpatch", 0).getAbsolutePath() + java.io.File.separator + "patch.dex";
    }

    public java.lang.String c() {
        return this.i.getDir("tmsdkpatch", 0).getAbsolutePath();
    }
}
