package com.tencent.mm.opensdk.channel;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MMessageActV2 {
    public static final java.lang.String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final java.lang.String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final java.lang.String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final java.lang.String TAG = "MicroMsg.SDK.MMessageAct";

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public android.os.Bundle bundle;
        public java.lang.String content;
        public int flags = -1;
        public java.lang.String targetClassName;
        public java.lang.String targetPkgName;
        public java.lang.String token;

        public java.lang.String toString() {
            return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
        }
    }

    public static boolean send(android.content.Context context, com.tencent.mm.opensdk.channel.MMessageActV2.Args args) {
        if (context == null || args == null) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "send fail, invalid argument");
            return false;
        }
        if (com.tencent.mm.opensdk.utils.d.b(args.targetPkgName)) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "send fail, invalid targetPkgName, targetPkgName = " + args.targetPkgName);
            return false;
        }
        if (com.tencent.mm.opensdk.utils.d.b(args.targetClassName)) {
            args.targetClassName = args.targetPkgName + DEFAULT_ENTRY_CLASS_NAME;
        }
        com.tencent.mm.opensdk.utils.Log.d(TAG, "send, targetPkgName = " + args.targetPkgName + ", targetClassName = " + args.targetClassName);
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(args.targetPkgName, args.targetClassName);
        android.os.Bundle bundle = args.bundle;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        java.lang.String packageName = context.getPackageName();
        intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.SDK_VERSION, 620824064);
        intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.APP_PACKAGE, packageName);
        intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.CONTENT, args.content);
        intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.CHECK_SUM, com.tencent.mm.opensdk.channel.a.b.a(args.content, 620824064, packageName));
        intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.TOKEN, args.token);
        int i = args.flags;
        if (i == -1) {
            intent.addFlags(268435456).addFlags(oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_PT4Token);
        } else {
            intent.setFlags(i);
        }
        try {
            context.startActivity(intent);
            com.tencent.mm.opensdk.utils.Log.d(TAG, "send mm message, intent=" + intent);
            return true;
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "send fail, ex = " + e.getMessage());
            return false;
        }
    }
}
