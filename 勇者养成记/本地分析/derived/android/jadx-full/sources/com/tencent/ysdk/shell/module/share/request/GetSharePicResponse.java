package com.tencent.ysdk.shell.module.share.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetSharePicResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_DATA = "data";
    private static final java.lang.String PARAM_IMAGE_URL = "imgUrl";
    public java.lang.String imgUrl = "";

    private void parseGetMenuResponseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        try {
            if (safeJSONObject.has("data")) {
                com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject2 = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(safeJSONObject.getJSONObject("data"));
                if (safeJSONObject2.has(PARAM_IMAGE_URL)) {
                    this.imgUrl = safeJSONObject2.getString(PARAM_IMAGE_URL);
                }
            } else {
                com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.icon.impl.IconModule.TAG, safeJSONObject.toString());
            }
        } catch (java.lang.Exception e) {
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
