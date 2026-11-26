package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tencent.smtt.export.external.DexLoader f950a;

    public t(com.tencent.smtt.export.external.DexLoader dexLoader) {
        this.f950a = null;
        this.f950a = dexLoader;
    }

    public java.lang.Object a(android.content.Context context) {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f950a;
        return dexLoader.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new java.lang.Class[]{android.content.Context.class, dalvik.system.DexClassLoader.class}, context, dexLoader.getClassLoader());
    }

    public void a(java.lang.Object obj) {
        this.f950a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new java.lang.Class[0], new java.lang.Object[0]);
    }

    public void a(java.lang.Object obj, android.app.Activity activity, int i) {
        this.f950a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new java.lang.Class[]{android.app.Activity.class, java.lang.Integer.TYPE}, activity, java.lang.Integer.valueOf(i));
    }

    public boolean a(java.lang.Object obj, android.os.Bundle bundle, android.widget.FrameLayout frameLayout, java.lang.Object obj2) {
        com.tencent.smtt.export.external.DexLoader dexLoader;
        java.lang.Class[] clsArr;
        java.lang.Object[] objArr;
        if (obj2 != null) {
            dexLoader = this.f950a;
            clsArr = new java.lang.Class[]{android.os.Bundle.class, android.widget.FrameLayout.class, java.lang.Object.class};
            objArr = new java.lang.Object[]{bundle, frameLayout, obj2};
        } else {
            dexLoader = this.f950a;
            clsArr = new java.lang.Class[]{android.os.Bundle.class, android.widget.FrameLayout.class};
            objArr = new java.lang.Object[]{bundle, frameLayout};
        }
        java.lang.Object objInvokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", clsArr, objArr);
        if (objInvokeMethod instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) objInvokeMethod).booleanValue();
        }
        return false;
    }
}
