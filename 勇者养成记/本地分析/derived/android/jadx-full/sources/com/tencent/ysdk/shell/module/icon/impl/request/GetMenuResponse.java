package com.tencent.ysdk.shell.module.icon.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetMenuResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_DATA = "data";
    private static final java.lang.String PARAM_DATA_DYNAMIC = "dynamic";
    private static final java.lang.String PARAM_DATA_STATIC = "static";
    private static final java.lang.String PARAM_ICON_CAN_BE_SHOWED = "icon_can_be_showed";
    private static final java.lang.String PARAM_ICON_ISNEW = "icon_tip";
    private static final java.lang.String PARAM_ICON_URL = "yyb_pic_url";
    private static final java.lang.String PARAM_ITEM_ISNEW = "tips";
    private static final java.lang.String PARAM_MENU_LIST = "menu_list";
    private static final java.lang.String PARAM_MENU_MSG_URL = "menu_msg_url";
    private static final java.lang.String PARAM_MENU_TAG = "menu_tag";
    private static final java.lang.String PARAM_MSG_NUM = "msg_num";
    private static final java.lang.String PARAM_PUSH_INFO = "push_info";
    public java.lang.String mMenuMsgUrl = "";
    public java.lang.String mIconUrl = "";
    public java.lang.String mMenuTag = "";
    public java.util.List<com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem> mItems = new java.util.ArrayList();
    public int msg_num = 0;
    public boolean iconIsNew = false;
    public boolean iconCanBeShowed = false;

    private void parseGetMenuResponseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        try {
            if (safeJSONObject.has("data")) {
                com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject2 = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(safeJSONObject.getJSONObject("data"));
                if (safeJSONObject2.has(PARAM_DATA_STATIC)) {
                    parseResponseStaticInfo(safeJSONObject2.optJSONObject(PARAM_DATA_STATIC));
                }
            } else {
                com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.icon.impl.IconModule.TAG, safeJSONObject.toString());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void parseResponseStaticInfo(org.json.JSONObject jSONObject) {
        try {
            com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(jSONObject);
            if (safeJSONObject.has(PARAM_ICON_CAN_BE_SHOWED)) {
                this.iconCanBeShowed = safeJSONObject.getInt(PARAM_ICON_CAN_BE_SHOWED) > 0;
            }
            if (!this.iconCanBeShowed) {
                com.tencent.ysdk.shell.libware.file.Logger.d("iconCanBeShowed is false");
                return;
            }
            if (safeJSONObject.has(PARAM_MENU_LIST)) {
                if (safeJSONObject.has(PARAM_MENU_TAG)) {
                    this.mMenuTag = safeJSONObject.getString(PARAM_MENU_TAG);
                }
                if (safeJSONObject.has(PARAM_MENU_MSG_URL)) {
                    this.mMenuMsgUrl = safeJSONObject.getString(PARAM_MENU_MSG_URL);
                }
                if (safeJSONObject.has(PARAM_ICON_URL)) {
                    this.mIconUrl = safeJSONObject.getString(PARAM_ICON_URL);
                }
                org.json.JSONArray jSONArrayOptJSONArray = safeJSONObject.optJSONArray(PARAM_MENU_LIST);
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    org.json.JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem menuItem = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem(jSONObject2);
                        if (android.text.TextUtils.isEmpty(menuItem.getUniqId()) || android.text.TextUtils.isEmpty(menuItem.getTitle()) || android.text.TextUtils.isEmpty(menuItem.getJumpUrl()) || android.text.TextUtils.isEmpty(menuItem.getPicUrl()) || !menuItem.isShow()) {
                            com.tencent.ysdk.shell.libware.file.Logger.d("item info is null or not set to not show:" + menuItem.toString());
                        } else {
                            this.mItems.add(menuItem);
                        }
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("parseResponseStaticInfo exception");
            e.printStackTrace();
        }
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
