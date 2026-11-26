package com.tencent.mm.opensdk.modelbiz;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class JumpToBizWebview {

    public static class Req extends com.tencent.mm.opensdk.modelbase.BaseReq {
        private static final int EXT_MSG_LENGTH = 1024;
        private static final java.lang.String TAG = "MicroMsg.SDK.JumpToBizWebview.Req";
        public java.lang.String extMsg;
        public int scene = 1;
        public java.lang.String toUserName;
        public int webType;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3 = this.toUserName;
            if (str3 == null || str3.length() <= 0) {
                str = TAG;
                str2 = "checkArgs fail, toUserName is invalid";
            } else {
                java.lang.String str4 = this.extMsg;
                if (str4 == null || str4.length() <= 1024) {
                    return true;
                }
                str = TAG;
                str2 = "ext msg is not null, while the length exceed 1024 bytes";
            }
            com.tencent.mm.opensdk.utils.Log.e(str, str2);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 8;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
        }
    }
}
