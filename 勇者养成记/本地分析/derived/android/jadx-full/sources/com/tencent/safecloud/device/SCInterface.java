package com.tencent.safecloud.device;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public enum SCInterface {
    instance;

    private static final java.lang.String SDK_VERSION = "2.4.2";
    public static java.lang.String b = "kYxOpRWMqak2stoJ2Hrq+Oi9GLegH17D5FUkRQ==";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f801a = "C2uRLLInrbpYtSL1MQuXoMx06vOL/6qjB1cGUgWlJjIQBYuT55ToLsCUhf0=";
    private java.lang.String url = "";
    private java.lang.String deviceUrl = "";
    private com.tencent.safecloud.device.openlib.SCInter rInstance = null;
    private java.lang.String mAppId = "";
    private boolean isInited = false;
    private int mScence = 0;

    SCInterface() {
    }

    public void clearCache(android.content.Context context, com.tencent.safecloud.device.openlib.SCCallback sCCallback) {
        java.lang.String str;
        if (!this.isInited) {
            str = "please ivoke startWithAppId first!";
        } else {
            if (sCCallback != null) {
                com.tencent.safecloud.device.openlib.SCInter sCInter = this.rInstance;
                if (sCInter != null) {
                    sCInter.clearCache(context, sCCallback);
                    return;
                }
                return;
            }
            str = "callback can not be NULL!";
        }
        com.tencent.safecloud.device.openlib.LogUtil.e(str);
    }

    public int generatorToken(android.content.Context context, com.tencent.safecloud.device.openlib.SCCallback sCCallback) {
        if (!this.isInited) {
            com.tencent.safecloud.device.openlib.LogUtil.e("please ivoke startWithAppId first!");
            return -2;
        }
        if (this.rInstance != null && !com.tencent.safecloud.device.openlib.CheckUtils.isNullStr(this.url)) {
            this.rInstance.setServerUrl(this.url);
        }
        qfc.b bVar = new qfc.b(sCCallback);
        if (this.rInstance == null) {
            bVar.onFail(-3);
            return 0;
        }
        com.tencent.safecloud.device.openlib.ErrorManager.clearError();
        if (this.mScence > 0) {
            com.tencent.safecloud.device.openlib.ErrorManager.addTime("scence=" + this.mScence);
        }
        return this.rInstance.generatorToken(context, bVar);
    }

    public int getDeviceId(android.content.Context context, com.tencent.safecloud.device.openlib.IVendorCallback iVendorCallback) {
        if (!this.isInited) {
            com.tencent.safecloud.device.openlib.LogUtil.e("please ivoke startWithAppId first!");
            return -2;
        }
        com.tencent.safecloud.device.openlib.SCInter sCInter = this.rInstance;
        if (sCInter != null) {
            return sCInter.getDeviceId(context, iVendorCallback);
        }
        return -2;
    }

    public java.lang.String getIP() {
        com.tencent.safecloud.device.openlib.SCInter sCInter = this.rInstance;
        java.lang.String ip = sCInter != null ? sCInter.getIP() : "";
        if (com.tencent.safecloud.device.openlib.CheckUtils.isNullStr(ip)) {
            ip = "";
            if (!this.isInited) {
                com.tencent.safecloud.device.openlib.LogUtil.d("FPC ip is null, startWithAppId first and try again");
            }
            com.tencent.safecloud.device.openlib.LogUtil.d("FPC ip is null, check startWithAppId is success?");
        }
        return ip;
    }

    public java.lang.String getSDKVersion() {
        return SDK_VERSION;
    }

    public java.lang.String getToken() {
        com.tencent.safecloud.device.openlib.SCInter sCInter = this.rInstance;
        java.lang.String token = sCInter != null ? sCInter.getToken() : "[REDACTED]";
        if (com.tencent.safecloud.device.openlib.CheckUtils.isNullStr(token)) {
            token = "[REDACTED]";
            if (!this.isInited) {
                com.tencent.safecloud.device.openlib.LogUtil.e("[REDACTED]");
            }
            com.tencent.safecloud.device.openlib.LogUtil.e("[REDACTED]");
        }
        return token;
    }

    public boolean isInited() {
        return this.isInited;
    }

    public void setDomains(android.content.Context context, java.lang.String... strArr) {
        com.tencent.safecloud.device.openlib.SCInter sCInter = this.rInstance;
        if (sCInter != null) {
            sCInter.setDomains(context, strArr);
        }
    }

    public void setLogEnable(boolean z) {
        if (z) {
            com.tencent.safecloud.device.openlib.LogUtil.enableLog();
        } else {
            com.tencent.safecloud.device.openlib.LogUtil.closeLog();
        }
    }

    public void setScene(int i) {
        this.mScence = i;
    }

    public void setServerUrl(java.lang.String str) {
        com.tencent.safecloud.device.openlib.LogUtil.d("set URL2 " + str);
        this.url = str;
    }

    public void setTouchEvent(android.view.View view, android.view.MotionEvent motionEvent, android.content.Context context) {
        com.tencent.safecloud.device.openlib.SCInter sCInter = this.rInstance;
        if (sCInter != null) {
            sCInter.setTouchEvent(view, motionEvent, context);
        }
    }

    public void startSensorListen(android.content.Context context) {
        com.tencent.safecloud.device.openlib.SCInter sCInter = this.rInstance;
        if (sCInter != null) {
            sCInter.startSensorListen(context);
        }
    }

    public int startWithAppId(android.content.Context context, java.lang.String str) {
        com.tencent.safecloud.device.openlib.LogUtil.d("start init0");
        com.tencent.safecloud.device.openlib.ErrorManager.clearError();
        this.mAppId = str;
        com.tencent.safecloud.device.openlib.ErrorManager.addError(com.tencent.safecloud.device.openlib.ErrorManager.eError.ERROR_INIT, new java.lang.String[]{"init failed"});
        try {
            if (com.tencent.safecloud.device.openlib.CheckUtils.isNullStr(str)) {
                com.tencent.safecloud.device.openlib.LogUtil.e("appId can not be null");
                return -1;
            }
            if (!this.isInited) {
                com.tencent.safecloud.device.openlib.LogUtil.d("start init1");
                android.content.res.AssetManager assets = context.getAssets();
                com.tencent.safecloud.device.openlib.NativeHelper nativeHelper = new com.tencent.safecloud.device.openlib.NativeHelper();
                java.lang.String modelName = com.tencent.safecloud.device.openlib.CheckUtils.getModelName();
                com.tencent.safecloud.device.openlib.LogUtil.d("start init2");
                int iT1 = nativeHelper.t1(modelName, f801a, context.getFilesDir().getParent(), assets, context.getClassLoader());
                com.tencent.safecloud.device.openlib.LogUtil.d("dex errInt:" + iT1);
                if (iT1 != 0) {
                    com.tencent.safecloud.device.openlib.ErrorManager.addError(com.tencent.safecloud.device.openlib.ErrorManager.eError.ERROR_LOAD_CORE, new java.lang.String[]{"dex error:" + iT1});
                    return -2;
                }
                if (nativeHelper.mDexClassLoader == null) {
                    com.tencent.safecloud.device.openlib.ErrorManager.addError(com.tencent.safecloud.device.openlib.ErrorManager.eError.ERROR_LOAD_CORE, new java.lang.String[]{"load fail"});
                    return -2;
                }
                try {
                    com.tencent.safecloud.device.openlib.LogUtil.d("start init3");
                    com.tencent.safecloud.device.openlib.SCInter sCInter = (com.tencent.safecloud.device.openlib.SCInter) nativeHelper.mDexClassLoader.loadClass("com.tencent.safecloud.device.SCInterCore").newInstance();
                    this.rInstance = sCInter;
                    if (sCInter == null) {
                        return -2;
                    }
                    sCInter.startWithAppId(context, str);
                    this.isInited = true;
                } catch (java.lang.Exception e) {
                    com.tencent.safecloud.device.openlib.ErrorManager.addError(com.tencent.safecloud.device.openlib.ErrorManager.eError.ERROR_LOAD_CORE, new java.lang.String[]{com.tencent.safecloud.device.openlib.ErrorManager.catchMsg(e)});
                    return -2;
                }
            }
            if (this.isInited) {
                com.tencent.safecloud.device.openlib.LogUtil.info("tencent sdk init success");
            }
            return 0;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return -2;
        }
    }
}
