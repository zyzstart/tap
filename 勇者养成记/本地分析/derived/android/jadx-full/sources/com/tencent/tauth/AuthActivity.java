package com.tencent.tauth;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AuthActivity extends android.app.Activity {
    public static final java.lang.String ACTION_KEY = "action";
    public static final java.lang.String ACTION_SHARE_PRIZE = "sharePrize";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f987a;

    private void a(android.net.Uri uri) {
        java.lang.String str;
        java.lang.String str2;
        android.content.Intent intent;
        boolean booleanExtra;
        android.content.Intent intent2;
        java.lang.String str3;
        int i;
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (uri != null && uri.toString() != null && !uri.toString().equals("")) {
            java.lang.String string = uri.toString();
            android.os.Bundle bundleA = com.tencent.open.utils.l.a(string.substring(string.indexOf("#") + 1));
            if (bundleA != null) {
                java.lang.String string2 = bundleA.getString(ACTION_KEY);
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string2);
                if (string2 != null) {
                    if (string2.equals("shareToQQ") || string2.equals("shareToQzone") || string2.equals("sendToMyComputer") || string2.equals("shareToTroopBar")) {
                        if (string2.equals("shareToQzone") && com.tencent.open.utils.i.a((android.content.Context) this, "com.tencent.mobileqq") != null && com.tencent.open.utils.i.c(this, "5.2.0") < 0) {
                            int i2 = f987a + 1;
                            f987a = i2;
                            if (i2 == 2) {
                                f987a = 0;
                            }
                        }
                        com.tencent.open.log.SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                        intent = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                        intent.putExtras(bundleA);
                        intent.setFlags(603979776);
                    } else if (string2.equals("addToQQFavorites")) {
                        android.content.Intent intent3 = getIntent();
                        intent3.putExtras(bundleA);
                        intent3.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_share");
                        com.tencent.tauth.IUiListener listnerWithAction = com.tencent.connect.common.UIListenerManager.getInstance().getListnerWithAction(string2);
                        if (listnerWithAction != null) {
                            com.tencent.connect.common.UIListenerManager.getInstance().handleDataToListener(intent3, listnerWithAction);
                        }
                    } else if (string2.equals(ACTION_SHARE_PRIZE)) {
                        intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
                        java.lang.String string3 = "";
                        try {
                            string3 = com.tencent.open.utils.l.d(bundleA.getString("response")).getString("activityid");
                        } catch (java.lang.Exception e) {
                            com.tencent.open.log.SLog.e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e);
                        }
                        if (!android.text.TextUtils.isEmpty(string3)) {
                            intent.putExtra(ACTION_SHARE_PRIZE, true);
                            android.os.Bundle bundle = new android.os.Bundle();
                            bundle.putString("activityid", string3);
                            intent.putExtras(bundle);
                        }
                    } else {
                        if (string2.equals("sdkSetAvatar")) {
                            booleanExtra = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false);
                            intent2 = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                            str3 = com.tencent.connect.common.Constants.KEY_REQUEST_CODE;
                            i = 10108;
                        } else if ("sdkSetDynamicAvatar".equals(string2)) {
                            booleanExtra = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false);
                            intent2 = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                            str3 = com.tencent.connect.common.Constants.KEY_REQUEST_CODE;
                            i = com.tencent.connect.common.Constants.REQUEST_EDIT_DYNAMIC_AVATAR;
                        } else if (string2.equals("sdkSetEmotion")) {
                            booleanExtra = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false);
                            intent2 = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                            str3 = com.tencent.connect.common.Constants.KEY_REQUEST_CODE;
                            i = com.tencent.connect.common.Constants.REQUEST_EDIT_EMOTION;
                        } else if (string2.equals("bindGroup")) {
                            com.tencent.open.log.SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
                            booleanExtra = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false);
                            intent2 = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                            str3 = com.tencent.connect.common.Constants.KEY_REQUEST_CODE;
                            i = com.tencent.connect.common.Constants.REQUEST_BIND_GROUP;
                        } else if (string2.equals("joinGroup")) {
                            com.tencent.open.log.SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
                            booleanExtra = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false);
                            intent2 = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                            str3 = com.tencent.connect.common.Constants.KEY_REQUEST_CODE;
                            i = com.tencent.connect.common.Constants.REQUEST_JOIN_GROUP;
                        }
                        intent2.putExtra(str3, i);
                        intent2.putExtra(com.tencent.connect.common.Constants.KEY_STAY, booleanExtra);
                        intent2.putExtras(bundleA);
                        intent2.setFlags(603979776);
                        startActivity(intent2);
                    }
                    startActivity(intent);
                }
                finish();
                return;
            }
            str = "openSDK_LOG.AuthActivity";
            str2 = "-->handleActionUri, bundle is null";
            finish();
        }
        str = "openSDK_LOG.AuthActivity";
        str2 = "-->handleActionUri, uri invalid";
        com.tencent.open.log.SLog.w(str, str2);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            com.tencent.open.log.SLog.w("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
            finish();
            return;
        }
        android.net.Uri data = null;
        try {
            data = getIntent().getData();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.tencent.open.log.SLog.v("openSDK_LOG.AuthActivity", "-->onCreate, uri: " + data);
        try {
            a(data);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }
}
