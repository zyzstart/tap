package com.tencent.ysdk.shell.module.immersiveicon.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetFeatureResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_DATA = "data";
    private static final java.lang.String PARAM_MENU_LIST = "menu_list";
    private static final java.lang.String PARAM_MENU_TAG = "desc";
    private static final java.lang.String PARAM_MENU_URL = "jmp_url";
    private static final java.lang.String PARAM_RED_FLAG = "show_me";
    private static final java.lang.String PARAM_RED_HAS_RED = "has_red";
    private static final java.lang.String PARAM_RED_ID = "id";
    private static final java.lang.String PARAM_RED_TAG = "red_point";
    private static final java.lang.String PARAM_RED_TS = "last_ts";
    public java.util.List<com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem> featureItems = new java.util.ArrayList();

    private void parseGetMenuResponseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        try {
            if (!safeJSONObject.has("data")) {
                com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.TAG, safeJSONObject.toString());
                return;
            }
            com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject2 = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(safeJSONObject.getJSONObject("data"));
            if (safeJSONObject2.has(PARAM_MENU_LIST)) {
                org.json.JSONArray jSONArray = new org.json.JSONArray(safeJSONObject2.getString(PARAM_MENU_LIST));
                for (int i = 0; i < jSONArray.length(); i++) {
                    org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        parseMenuList(jSONObject);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void parseMenuList(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem featureItem = new com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem();
        if (jSONObject.has("desc")) {
            featureItem.setDesc(jSONObject.getString("desc"));
        }
        if (jSONObject.has(PARAM_MENU_URL)) {
            featureItem.setJmpUrl(jSONObject.getString(PARAM_MENU_URL));
        }
        if (jSONObject.has(PARAM_RED_TAG)) {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(PARAM_RED_TAG);
            if (jSONObject2.has(PARAM_RED_HAS_RED)) {
                featureItem.setRed(jSONObject2.getInt(PARAM_RED_HAS_RED) > 0);
            }
            if (featureItem.isRed()) {
                if (jSONObject2.has(PARAM_RED_ID)) {
                    java.lang.String string = jSONObject2.getString(PARAM_RED_ID);
                    if (!android.text.TextUtils.isEmpty(string)) {
                        featureItem.setIconID(string);
                    }
                }
                if (jSONObject2.has(PARAM_RED_TS)) {
                    java.lang.String string2 = jSONObject2.getString(PARAM_RED_TS);
                    if (!android.text.TextUtils.isEmpty(string2)) {
                        featureItem.setTs(string2);
                    }
                }
            }
        }
        this.featureItems.add(featureItem);
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parseGetMenuResponseJson(safeJSONObject);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.icon.impl.IconModule.TAG, safeJSONObject.toString());
        }
    }
}
