package com.tencent.mm.opensdk.modelbiz;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JumpToBizProfile {
    public static final int JUMP_TO_HARD_WARE_BIZ_PROFILE = 1;
    public static final int JUMP_TO_NORMAL_BIZ_PROFILE = 0;

    public static class Req extends com.tencent.mm.opensdk.modelbase.BaseReq {
        private static final int EXT_MSG_LENGTH = 1024;
        private static final java.lang.String TAG = "MicroMsg.SDK.JumpToBizProfile.Req";
        public java.lang.String extMsg;
        public int profileType = 0;
        public java.lang.String toUserName;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3;
            java.lang.String str4 = this.toUserName;
            if (str4 == null || str4.length() == 0) {
                str = TAG;
                str2 = "checkArgs fail, toUserName is invalid";
            } else {
                java.lang.String str5 = this.extMsg;
                if (str5 != null && str5.length() > 1024) {
                    str = TAG;
                    str2 = "ext msg is not null, while the length exceed 1024 bytes";
                } else {
                    if (this.profileType != 1 || ((str3 = this.extMsg) != null && str3.length() != 0)) {
                        return true;
                    }
                    str = TAG;
                    str2 = "scene is jump to hardware profile, while extmsg is null";
                }
            }
            com.tencent.mm.opensdk.utils.Log.e(str, str2);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(android.os.Bundle bundle) {
            super.fromBundle(bundle);
            this.toUserName = bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
            this.extMsg = bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 7;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_profile_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_profile_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_profile_req_scene", 0);
            bundle.putInt("_wxapi_jump_to_biz_profile_req_profile_type", this.profileType);
        }
    }
}
