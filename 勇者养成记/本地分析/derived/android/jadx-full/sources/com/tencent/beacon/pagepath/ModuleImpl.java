package com.tencent.beacon.pagepath;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ModuleImpl extends com.tencent.beacon.core.c {
    private static com.tencent.beacon.pagepath.ModuleImpl mInstance;
    private boolean enableModule;

    public ModuleImpl(android.content.Context context) {
        super(context);
        this.enableModule = com.tencent.beacon.upload.UploadStrategy.DEFAULT_PAGE_PATH_ENABLE;
    }

    public static synchronized com.tencent.beacon.pagepath.ModuleImpl getInstance(android.content.Context context) {
        if (mInstance == null) {
            mInstance = new com.tencent.beacon.pagepath.ModuleImpl(context);
        }
        return mInstance;
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStarted() {
        super.onModuleStarted();
        this.enableModule = this.enableModule && android.os.Build.VERSION.SDK_INT >= 14;
        com.tencent.beacon.core.e.d.d("[module] pagePath module > %S", "" + this.enableModule);
        if (this.enableModule) {
            ((android.app.Application) this.mContext).registerActivityLifecycleCallbacks(new com.tencent.beacon.pagepath.b());
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStrategyUpdated(int i, java.util.Map map) {
        super.onModuleStrategyUpdated(i, map);
        if (i == 1) {
            this.enableModule = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("isPagePath"), this.enableModule);
            com.tencent.beacon.core.e.d.a("[module] get isPagePath: " + this.enableModule, new java.lang.Object[0]);
        }
    }
}
