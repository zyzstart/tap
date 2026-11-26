package com.tencent.ysdk.shell.module.cloud.newconfig;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ConfigSettingsManager {
    private static volatile com.tencent.ysdk.shell.module.cloud.newconfig.ConfigSettingsManager instance;

    private static class PullNewConfigHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigResponse> {
        private PullNewConfigHandler() {
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigResponse pullNewConfigResponse) {
            org.json.JSONObject sdkConfJson;
            java.util.HashMap map = new java.util.HashMap();
            map.put("response", pullNewConfigResponse.getResponseJson() != null ? pullNewConfigResponse.getResponseJson().toString() : "");
            com.tencent.ysdk.shell.framework.dynamic.PluginStatHelper.reportConfigResponse(map);
            if (pullNewConfigResponse.ret == 0 && (sdkConfJson = pullNewConfigResponse.getSdkConfJson()) != null) {
                new com.tencent.ysdk.shell.module.cloud.newconfig.ConfigSettingsResolver().resolveConfig(sdkConfJson);
            }
        }
    }

    private ConfigSettingsManager() {
    }

    public static com.tencent.ysdk.shell.module.cloud.newconfig.ConfigSettingsManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.bugly.BuglyApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.cloud.newconfig.ConfigSettingsManager();
                }
            }
        }
        return instance;
    }

    public void pullCloudSettings(int i) {
        switch (i) {
            case 0:
            case 1:
                com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigRequest pullNewConfigRequest = new com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigRequest(new com.tencent.ysdk.shell.module.cloud.newconfig.ConfigSettingsManager.PullNewConfigHandler());
                com.tencent.ysdk.shell.framework.dynamic.PluginStatHelper.reportConfigRequestEvent();
                com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(pullNewConfigRequest);
                break;
        }
    }
}
