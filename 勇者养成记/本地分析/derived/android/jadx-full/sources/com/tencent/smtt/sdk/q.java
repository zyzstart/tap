package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.export.external.DexLoader f947a;

    public q(com.tencent.smtt.export.external.DexLoader dexLoader) {
        this.f947a = null;
        this.f947a = dexLoader;
    }

    public java.lang.String a(android.content.Context context) {
        java.lang.Object objNewInstance;
        java.lang.Object objInvokeMethod;
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f947a;
        return (dexLoader == null || (objNewInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new java.lang.Class[0], new java.lang.Object[0])) == null || (objInvokeMethod = this.f947a.invokeMethod(objNewInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new java.lang.Class[]{android.content.Context.class}, context)) == null) ? "" : java.lang.String.valueOf(objInvokeMethod);
    }

    public void a(android.content.Context context, java.lang.String str) {
        java.lang.Object objNewInstance;
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f947a;
        if (dexLoader == null || (objNewInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new java.lang.Class[0], new java.lang.Object[0])) == null) {
            return;
        }
        this.f947a.invokeMethod(objNewInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new java.lang.Class[]{android.content.Context.class, java.lang.String.class}, context, str);
    }
}
