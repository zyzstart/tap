package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.export.external.DexLoader f944a;
    private java.lang.Object b = null;

    public o(com.tencent.smtt.export.external.DexLoader dexLoader) {
        this.f944a = null;
        this.f944a = dexLoader;
    }

    public java.lang.Object a(android.content.Context context, java.lang.Object obj, android.os.Bundle bundle) {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f944a;
        if (dexLoader != null) {
            this.b = dexLoader.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new java.lang.Class[]{android.content.Context.class, java.lang.Object.class, android.os.Bundle.class}, context, obj, bundle);
        }
        return this.b;
    }

    public void a() {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f944a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public void a(boolean z) {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f944a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public void b() {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f944a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public void c() {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f944a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public long d() {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f944a;
        if (dexLoader == null) {
            return 0L;
        }
        java.lang.Object objInvokeMethod = dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new java.lang.Class[0], new java.lang.Object[0]);
        if (objInvokeMethod instanceof java.lang.Long) {
            return ((java.lang.Long) objInvokeMethod).longValue();
        }
        return 0L;
    }

    public int e() {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f944a;
        if (dexLoader != null) {
            java.lang.Object objInvokeMethod = dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new java.lang.Class[0], new java.lang.Object[0]);
            if (objInvokeMethod instanceof java.lang.Integer) {
                return ((java.lang.Integer) objInvokeMethod).intValue();
            }
        }
        return 0;
    }

    public int f() {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f944a;
        if (dexLoader != null) {
            java.lang.Object objInvokeMethod = dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new java.lang.Class[0], new java.lang.Object[0]);
            if (objInvokeMethod instanceof java.lang.Integer) {
                return ((java.lang.Integer) objInvokeMethod).intValue();
            }
        }
        return 0;
    }
}
