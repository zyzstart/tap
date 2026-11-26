package com.tencent.ysdk.shell.module.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ADManager {
    private static final java.lang.String TAG = "AD_Module";
    private static com.tencent.ysdk.shell.module.ad.ADManager instance;
    private com.tencent.ysdk.shell.module.ad.ADManager.ADLoginListener adLoginListener;
    private com.tencent.ysdk.shell.module.ad.request.ADInfo info;

    class ADLoginListener implements com.tencent.ysdk.shell.module.user.UserInnerLoginListener {
        ADLoginListener() {
            com.tencent.ysdk.shell.module.user.UserApi.setUserInnerLoginListener(this);
        }

        @Override // com.tencent.ysdk.shell.module.user.UserInnerLoginListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            if (userLoginRet != null) {
                if (userLoginRet.ret != 0 || userLoginRet.flag != 0) {
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.ad.ADManager.TAG, "ADinfo login Fail");
                    return;
                }
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.ad.ADManager.TAG, "ADinfo login Type" + userLoginRet.getLoginType());
                if (userLoginRet.getLoginType() == 0) {
                    com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager.getInstance().addCommand(new com.tencent.ysdk.shell.framework.floatingwindow.IShowFloatingWindowCommand() { // from class: com.tencent.ysdk.shell.module.ad.ADManager.ADLoginListener.1
                        @Override // com.tencent.ysdk.shell.framework.floatingwindow.IShowFloatingWindowCommand
                        public void execute() {
                            com.tencent.ysdk.shell.module.ad.ADManager.this.showADOnUiThread();
                        }

                        @Override // com.tencent.ysdk.shell.framework.floatingwindow.IShowFloatingWindowCommand
                        public int getFloatingWindowType() {
                            return 3;
                        }
                    });
                }
            }
        }
    }

    private ADManager() {
    }

    public static synchronized com.tencent.ysdk.shell.module.ad.ADManager getInstance() {
        if (instance == null) {
            instance = new com.tencent.ysdk.shell.module.ad.ADManager();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showADOnUiThread() {
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().runOnUiThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.ad.ADManager.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.module.ad.ADManager.this.showAD();
            }
        });
    }

    public void initAD() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "load ADinfo ");
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.ad.request.GetADInfoRequest(new com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.ad.request.GetADinfoResponse>() { // from class: com.tencent.ysdk.shell.module.ad.ADManager.1
            @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
            public void onResponse(com.tencent.ysdk.shell.module.ad.request.GetADinfoResponse getADinfoResponse) {
                com.tencent.ysdk.shell.libware.file.Logger.d(getADinfoResponse.toString());
                if (getADinfoResponse.ret != 0) {
                    com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.ad.ADManager.TAG, "load ad get bad response, don't show ad");
                    return;
                }
                com.tencent.ysdk.shell.module.ad.request.ADInfo aDInfo = getADinfoResponse.adInfo;
                if (android.text.TextUtils.isEmpty(aDInfo.getAction()) || android.text.TextUtils.isEmpty(aDInfo.getPicUrl())) {
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.ad.ADManager.TAG, "load ad get null response, can't show ad");
                    return;
                }
                com.tencent.ysdk.shell.module.ad.ADManager.this.info = aDInfo;
                if (com.tencent.ysdk.shell.module.ad.ADManager.this.adLoginListener == null) {
                    com.tencent.ysdk.shell.module.ad.ADManager aDManager = com.tencent.ysdk.shell.module.ad.ADManager.this;
                    aDManager.adLoginListener = aDManager.new ADLoginListener();
                }
            }
        }));
    }

    public void showAD() {
        com.tencent.ysdk.shell.module.ad.request.ADInfo aDInfo = this.info;
        if (aDInfo == null || android.text.TextUtils.isEmpty(aDInfo.getPicUrl()) || android.text.TextUtils.isEmpty(this.info.getAction())) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "ADinfo not find");
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis <= this.info.getStartTime() || jCurrentTimeMillis >= this.info.getEndTime()) {
            java.util.HashMap map = new java.util.HashMap();
            map.put(com.tencent.ysdk.shell.module.ad.ADManagerStat.PARAM_AD_ACTION_URL, this.info.getAction());
            map.put(com.tencent.ysdk.shell.module.ad.ADManagerStat.PARAM_AD_IMAGE_URL, this.info.getPicUrl());
            com.tencent.ysdk.shell.module.ad.ADManagerStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.ad.ADManagerStat.EVENT_AD_CACHE, 0, "", map);
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "cache ADinfo ");
            return;
        }
        new com.tencent.ysdk.shell.module.ad.ADView(this.info.getPicUrl(), this.info.getAction()).show();
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put(com.tencent.ysdk.shell.module.ad.ADManagerStat.PARAM_AD_ACTION_URL, this.info.getAction());
        map2.put(com.tencent.ysdk.shell.module.ad.ADManagerStat.PARAM_AD_IMAGE_URL, this.info.getPicUrl());
        com.tencent.ysdk.shell.module.ad.ADManagerStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.ad.ADManagerStat.EVENT_AD_SHOW, 0, "", map2);
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "show ADinfo ");
    }
}
