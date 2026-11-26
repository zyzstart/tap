package com.tencent.ysdk.shell.module.hades;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class HadesApi {
    private static final java.lang.String LIB_HADES_SO = "libhades_lib.so";
    private static com.tencent.ysdk.shell.module.hades.HadesApi instance = null;
    private static boolean isEnvChecked = false;
    private static boolean isSCFPSDKinited = false;
    private static com.tencent.ysdk.shell.module.hades.impl.HadesModule module;

    private HadesApi(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        module = new com.tencent.ysdk.shell.module.hades.impl.HadesModule(str, str2, str3);
    }

    public static final void checkEnv() {
        if (isEnvChecked) {
            return;
        }
        isEnvChecked = true;
        try {
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().loadPluginSo(LIB_HADES_SO);
        } catch (java.lang.Throwable unused) {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_DOCTOR", "so文件加载异常，缺少libhades_lib.so文件");
            com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.hades.HadesApi.1
                @Override // java.lang.Runnable
                public void run() {
                    android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "so加载异常，缺少libhades_lib.so文件", 1).show();
                }
            });
        }
    }

    public static final android.app.Activity getActivity() {
        return module.getActivity();
    }

    public static final android.content.Context getApplicationContext() {
        return module.getApplicationContext();
    }

    public static final synchronized com.tencent.ysdk.shell.module.hades.HadesApi getInstance(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (instance == null) {
            instance = new com.tencent.ysdk.shell.module.hades.HadesApi(str, str2, str3);
        }
        return instance;
    }

    public static final void irt(java.lang.String str) {
        com.tencent.ysdk.shell.framework.web.router.IntentRouter.commonJump(module.getActivity(), str, 2);
    }

    public static final void reportHadesEvent(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.shell.module.hades.impl.HadesModule.reportHadesEvent(str, i, str2, map);
    }

    public static final void startSCFPSDK() {
        if (isSCFPSDKinited) {
            return;
        }
        isSCFPSDKinited = true;
        final com.tencent.safecloud.device.SCInterface sCInterface = com.tencent.safecloud.device.SCInterface.instance;
        sCInterface.startWithAppId(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "YYB2sAQkbK3lbg9a");
        sCInterface.setLogEnable(false);
        sCInterface.setServerUrl("https://dp.finsec.qq.com/f1");
        sCInterface.generatorToken(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), new com.tencent.safecloud.device.openlib.SCCallback() { // from class: com.tencent.ysdk.shell.module.hades.HadesApi.2
            @Override // com.tencent.safecloud.device.openlib.SCCallback
            public void onFail(final int i) {
                com.tencent.ysdk.shell.libware.file.Logger.e("SCFPSDK err:" + i);
                if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isHostDebugMode()) {
                    try {
                        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.hades.HadesApi.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), "YSDK_SCFP err:" + i + ":请比对最新assert文件、so库、jar包、权限列表、混淆配置配置文件、网络代理、本机时间", 1).show();
                            }
                        });
                    } catch (java.lang.Exception e) {
                        com.tencent.ysdk.shell.libware.file.Logger.e(e.getMessage());
                    }
                }
            }

            @Override // com.tencent.safecloud.device.openlib.SCCallback
            public void onSuccess() {
                com.tencent.ysdk.shell.libware.file.Logger.d("[REDACTED]" + sCInterface.getToken());
            }
        });
        try {
            sCInterface.getDeviceId(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), new com.tencent.safecloud.device.openlib.IVendorCallback() { // from class: com.tencent.ysdk.shell.module.hades.HadesApi.3
                @Override // com.tencent.safecloud.device.openlib.IVendorCallback
                public void onResult(boolean z, java.lang.String str) {
                    com.tencent.ysdk.shell.libware.file.Logger.d("SCFPSDK onSupportOAID:" + z + " :" + str);
                    if (!z || android.text.TextUtils.isEmpty(str)) {
                        return;
                    }
                    com.tencent.ysdk.shell.libware.device.DeviceUtils.devOAID = str;
                }
            });
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
