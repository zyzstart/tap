package com.tencent.ysdk.shell.module.cloud.newconfig;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class ConfigSettingsResolver {
    private static final java.lang.String PLUGIN_RULES = "plugin_rules";
    private static final java.lang.String TAG = "YSDK_NEW_CONFIG";
    private static final java.util.HashMap<java.lang.String, java.lang.Class<?>> name2Resolver = new java.util.HashMap<>();

    static {
        name2Resolver.put(PLUGIN_RULES, com.tencent.ysdk.shell.framework.dynamic.PluginConfigInfoResolver.class);
    }

    ConfigSettingsResolver() {
    }

    private void resolveByName(java.lang.String str, org.json.JSONArray jSONArray) {
        java.lang.Class<?> cls;
        if (android.text.TextUtils.isEmpty(str) || jSONArray == null || (cls = name2Resolver.get(str)) == null) {
            return;
        }
        try {
            java.lang.Object objNewInstance = cls.newInstance();
            if (objNewInstance instanceof com.tencent.ysdk.shell.module.cloud.newconfig.IConfigSettingsResolver) {
                ((com.tencent.ysdk.shell.module.cloud.newconfig.IConfigSettingsResolver) objNewInstance).resolve(jSONArray);
            }
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    public void resolveConfig(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.tencent.ysdk.libware.file.Logger.d(TAG, "resolveConfig: " + jSONObject.toString());
        java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            java.lang.String next = itKeys.next();
            resolveByName(next, jSONObject.optJSONArray(next));
        }
    }
}
