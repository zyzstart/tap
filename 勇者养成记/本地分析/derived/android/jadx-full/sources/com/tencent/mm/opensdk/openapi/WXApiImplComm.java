package com.tencent.mm.opensdk.openapi;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class WXApiImplComm {
    private static final java.lang.String TAG = "MicroMsg.SDK.WXMsgImplComm";
    private static final java.lang.String WX_APP_SIGNATURE = "[REDACTED_HEX_CONSTANT]";

    private WXApiImplComm() {
        throw new java.lang.RuntimeException(com.tencent.mm.opensdk.openapi.WXApiImplComm.class.getSimpleName() + " should not be instantiated");
    }

    public static boolean isIntentFromWx(android.content.Intent intent, java.lang.String str) {
        java.lang.String stringExtra;
        return (intent == null || (stringExtra = intent.getStringExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_TOKEN_KEY)) == null || !stringExtra.equals(str)) ? false : true;
    }

    public static boolean validateAppSignature(android.content.Context context, android.content.pm.Signature[] signatureArr, boolean z) {
        java.lang.String str;
        java.lang.String str2;
        if (z) {
            for (android.content.pm.Signature signature : signatureArr) {
                java.lang.String lowerCase = signature.toCharsString().toLowerCase();
                com.tencent.mm.opensdk.utils.Log.d(TAG, "check signature:" + lowerCase);
                if (lowerCase.equals(WX_APP_SIGNATURE)) {
                    str = TAG;
                    str2 = "pass";
                }
            }
            return false;
        }
        str = TAG;
        str2 = "ignore wechat app signature validation";
        com.tencent.mm.opensdk.utils.Log.d(str, str2);
        return true;
    }

    public static boolean validateAppSignatureForPackage(android.content.Context context, java.lang.String str, boolean z) {
        if (z) {
            try {
                return validateAppSignature(context, context.getPackageManager().getPackageInfo(str, 64).signatures, z);
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        com.tencent.mm.opensdk.utils.Log.d(TAG, "ignore wechat app signature validation");
        return true;
    }
}
