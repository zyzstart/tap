package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QuickLogin {
    private static int a(android.app.Activity activity, long j, long j2, oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam) {
        android.content.Intent intent;
        java.lang.String str;
        java.lang.String str2;
        if (quickLoginParam == null || (str2 = quickLoginParam.webViewActivityClassName) == null || str2.length() == 0) {
            intent = new android.content.Intent(activity, (java.lang.Class<?>) oicq.wlogin_sdk.quicklogin.QuickLoginWebViewActivity.class);
        } else {
            intent = new android.content.Intent();
            intent.setClassName(activity, quickLoginParam.webViewActivityClassName);
        }
        intent.putExtra("appid", j);
        intent.putExtra("subappid", j2);
        if (quickLoginParam != null && (str = quickLoginParam.userAccount) != null && str.length() != 0) {
            intent.putExtra("account", quickLoginParam.userAccount);
            intent.putExtra("isUserAccountLocked", quickLoginParam.isUserAccountLocked);
        }
        if (quickLoginParam != null) {
            intent.putExtra("forceWebLogin", quickLoginParam.forceWebLogin);
        }
        if (quickLoginParam != null) {
            intent.putExtra("titleBackgroundColor", quickLoginParam.titleBackgroundColor);
            intent.putExtra("titleTextColor", quickLoginParam.titleTextColor);
            intent.putExtra("finishAnimEnter", quickLoginParam.finishAnimEnter);
            intent.putExtra("finishAnimExit", quickLoginParam.finishAnimExit);
        }
        oicq.wlogin_sdk.tools.util.LOGI("before startActivityForResult for web", "");
        activity.startActivityForResult(intent, 1202);
        if (quickLoginParam == null) {
            return oicq.wlogin_sdk.tools.util.E_LOGIN_THROUGH_WEB;
        }
        if (quickLoginParam.startAnimEnter == 0 && quickLoginParam.startAnimExit == 0) {
            return oicq.wlogin_sdk.tools.util.E_LOGIN_THROUGH_WEB;
        }
        activity.overridePendingTransition(quickLoginParam.startAnimEnter, quickLoginParam.startAnimExit);
        return oicq.wlogin_sdk.tools.util.E_LOGIN_THROUGH_WEB;
    }

    private static int a(android.content.Context context, android.app.Activity activity, java.lang.String str, long j, long j2, java.lang.String str2) {
        byte[] bArrString_to_buf = oicq.wlogin_sdk.tools.util.get_rsa_pubkey(context);
        if (bArrString_to_buf == null || bArrString_to_buf.length == 0) {
            bArrString_to_buf = oicq.wlogin_sdk.tools.util.string_to_buf(oicq.wlogin_sdk.tools.RSACrypt.DEFAULT_PUB_KEY);
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(str, "com.tencent.open.agent.AgentActivity");
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("dstSsoVer", 1L);
        bundle.putLong("dstAppid", j);
        bundle.putLong("subDstAppid", j2);
        bundle.putByteArray("dstAppVer", str2.getBytes());
        bundle.putByteArray("publickey", bArrString_to_buf);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_PARAMS, bundle);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_quick_login");
        oicq.wlogin_sdk.tools.util.LOGI("before startActivityForResult for qq", "");
        activity.startActivityForResult(intent, 1201);
        return oicq.wlogin_sdk.tools.util.E_LOGIN_THROUGH_QQ;
    }

    public static int jumpToLoginActivity(android.content.Context context, android.app.Activity activity, long j, long j2, java.lang.String str, oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam) {
        if (quickLoginParam == null || true != quickLoginParam.forceWebLogin) {
            try {
                if (true == oicq.wlogin_sdk.tools.util.isMQQExist(context)) {
                    oicq.wlogin_sdk.tools.util.LOGI("login through qq", "");
                    return a(context, activity, "com.tencent.mobileqq", j, j2, str);
                }
                if (true == oicq.wlogin_sdk.tools.util.isPackageExist(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD)) {
                    oicq.wlogin_sdk.tools.util.LOGI("login through qq hd", "");
                    return a(context, activity, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD, j, j2, str);
                }
                if (true == oicq.wlogin_sdk.tools.util.isPackageExist(context, com.tencent.connect.common.Constants.PACKAGE_TIM)) {
                    oicq.wlogin_sdk.tools.util.LOGI("login through tim", "");
                    return a(context, activity, com.tencent.connect.common.Constants.PACKAGE_TIM, j, j2, str);
                }
                if (true == oicq.wlogin_sdk.tools.util.isPackageExist(context, com.tencent.connect.common.Constants.PACKAGE_QIM)) {
                    oicq.wlogin_sdk.tools.util.LOGI("login through qim", "");
                    return a(context, activity, com.tencent.connect.common.Constants.PACKAGE_QIM, j, j2, str);
                }
                oicq.wlogin_sdk.tools.util.LOGI("login through web", "");
                return a(activity, j, j2, quickLoginParam);
            } catch (java.lang.Exception e) {
                oicq.wlogin_sdk.tools.util.LOGI("login through web as exception occurred " + e.getMessage(), "");
            }
        }
        return a(activity, j, j2, quickLoginParam);
    }
}
