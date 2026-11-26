package com.tencent.connect.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AssistActivity extends android.app.Activity {
    public static final java.lang.String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";
    private java.lang.String d;
    private com.tencent.connect.common.AssistActivity.QQStayReceiver e;
    private boolean f;
    private boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f500a = false;
    protected android.os.Handler b = new android.os.Handler() { // from class: com.tencent.connect.common.AssistActivity.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what == 0 && !com.tencent.connect.common.AssistActivity.this.isFinishing()) {
                com.tencent.open.log.SLog.w("openSDK_LOG.AssistActivity", "-->finish by timeout");
                com.tencent.connect.common.AssistActivity.this.finish();
            }
        }
    };

    private class QQStayReceiver extends android.content.BroadcastReceiver {
        private QQStayReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            android.net.Uri uri = (android.net.Uri) intent.getParcelableExtra("uriData");
            android.content.Intent intent2 = new android.content.Intent();
            try {
                java.lang.String string = uri.toString();
                for (java.lang.String str : string.substring(string.indexOf(string.contains("#") ? "#" : com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START) + 1).split("&")) {
                    java.lang.String[] strArrSplit = str.split("=");
                    intent2.putExtra(strArrSplit[0], strArrSplit[1]);
                }
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "QQStayReceiver parse uri error : " + e.getMessage());
            }
            intent2.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_share");
            intent2.setData(uri);
            com.tencent.connect.common.AssistActivity.this.setResult(-1, intent2);
        }
    }

    private void a(android.os.Bundle bundle) {
        java.lang.String string = bundle.getString("viaShareType");
        java.lang.String string2 = bundle.getString("callbackAction");
        java.lang.String string3 = bundle.getString("url");
        java.lang.String string4 = bundle.getString("openId");
        java.lang.String string5 = bundle.getString("appId");
        java.lang.String str = "";
        java.lang.String str2 = "";
        if ("shareToQQ".equals(string2)) {
            str = com.tencent.connect.common.Constants.VIA_SHARE_TO_QQ;
            str2 = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        } else if ("shareToQzone".equals(string2)) {
            str = com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE;
            str2 = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        }
        java.lang.String str3 = str2;
        java.lang.String str4 = str;
        if (com.tencent.open.utils.l.a(this, string3)) {
            com.tencent.open.a.d.a().a(string4, string5, str4, str3, "3", "0", string, "0", "2", "0");
        } else {
            com.tencent.tauth.IUiListener listnerWithAction = com.tencent.connect.common.UIListenerManager.getInstance().getListnerWithAction(string2);
            if (listnerWithAction != null) {
                listnerWithAction.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_OPEN_BROWSER_ERROR, null));
            }
            com.tencent.open.a.d.a().a(string4, string5, str4, str3, "3", "1", string, "0", "2", "0");
            finish();
        }
        getIntent().removeExtra("shareH5");
    }

    public static android.content.Intent getAssistActivityIntent(android.content.Context context) {
        return new android.content.Intent(context, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("--onActivityResult--requestCode: ");
        sb.append(i);
        sb.append(" | resultCode: ");
        sb.append(i2);
        sb.append("data = null ? ");
        sb.append(intent == null);
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", sb.toString());
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            return;
        }
        if (intent != null) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_login");
        }
        setResultData(i, intent);
        if (this.f) {
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new java.lang.Runnable() { // from class: com.tencent.connect.common.AssistActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish delay");
                    com.tencent.connect.common.AssistActivity.this.finish();
                }
            }, 200L);
        } else {
            com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish immediate");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        getWindow().addFlags(oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_QRPUSH);
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.f = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_RESTORE_LANDSCAPE, false);
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--onCreate-- mRestoreLandscape=" + this.f);
        if (getIntent() == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        android.content.Intent intent = (android.content.Intent) getIntent().getParcelableExtra(EXTRA_INTENT);
        int intExtra = intent == null ? 0 : intent.getIntExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, 0);
        this.d = intent == null ? "" : intent.getStringExtra("appid");
        android.os.Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.c = bundle.getBoolean("RESTART_FLAG");
            this.f500a = bundle.getBoolean("RESUME_FLAG", false);
        }
        if (this.c) {
            com.tencent.open.log.SLog.d("openSDK_LOG.AssistActivity", "is restart");
            return;
        }
        if (bundleExtra != null) {
            com.tencent.open.log.SLog.w("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            a(bundleExtra);
            return;
        }
        if (intent == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
            finish();
            return;
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + intExtra);
        try {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter(com.tencent.connect.common.Constants.SHARE_QQ_AND_STAY + intent.getData().getQueryParameter("share_id"));
            if (this.e == null) {
                this.e = new com.tencent.connect.common.AssistActivity.QQStayReceiver();
            }
            registerReceiver(this.e, intentFilter);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "registerReceiver exception : " + e.getMessage());
        }
        startActivityForResult(intent, intExtra);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
        com.tencent.connect.common.AssistActivity.QQStayReceiver qQStayReceiver = this.e;
        if (qQStayReceiver != null) {
            unregisterReceiver(qQStayReceiver);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(android.content.Intent intent) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, -1);
        if (intExtra == 10108) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_request_avatar");
            if (intent.getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
        } else if (intExtra == 10109) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_request_set_emotion");
            if (intent.getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
        } else if (intExtra == 10110) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_request_dynamic_avatar");
            if (intent.getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
        } else if (intExtra == 10111) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "joinGroup");
            if (intent.getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
        } else if (intExtra == 10112) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "bindGroup");
            if (intent.getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
        } else {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_share");
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            } else {
                com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onPause() {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "-->onPause");
        this.b.removeMessages(0);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        android.content.Intent intent = getIntent();
        if (intent.getBooleanExtra("is_login", false)) {
            return;
        }
        if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.c && !isFinishing()) {
            finish();
        }
        if (!this.f500a) {
            this.f500a = true;
        } else {
            this.b.sendMessage(this.b.obtainMessage(0));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(android.os.Bundle bundle) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.f500a);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }

    public void setResultData(int i, android.content.Intent intent) {
        if (intent == null) {
            com.tencent.open.log.SLog.w("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i == 11101) {
                com.tencent.open.a.d.a().a("", this.d, "2", "1", "7", "2");
                return;
            }
            return;
        }
        try {
            java.lang.String stringExtra = intent.getStringExtra(com.tencent.connect.common.Constants.KEY_RESPONSE);
            com.tencent.open.log.SLog.d("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- ");
            if (android.text.TextUtils.isEmpty(stringExtra)) {
                com.tencent.open.log.SLog.w("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
            } else {
                org.json.JSONObject jSONObject = new org.json.JSONObject(stringExtra);
                java.lang.String strOptString = jSONObject.optString("openid");
                java.lang.String strOptString2 = jSONObject.optString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN);
                java.lang.String strOptString3 = jSONObject.optString("proxy_code");
                long jOptLong = jSONObject.optLong("proxy_expires_in");
                if (!android.text.TextUtils.isEmpty(strOptString) && !android.text.TextUtils.isEmpty(strOptString2)) {
                    com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
                    setResult(-1, intent);
                    com.tencent.open.a.d.a().a(strOptString, this.d, "2", "1", "7", "0");
                    return;
                } else {
                    if (android.text.TextUtils.isEmpty(strOptString3) || jOptLong == 0) {
                        com.tencent.open.log.SLog.w("[REDACTED]", "[REDACTED]");
                        setResult(0, intent);
                        com.tencent.open.a.d.a().a("", this.d, "2", "1", "7", "1");
                        return;
                    }
                    com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--setResultData--proxy_code and proxy_expires_in are valid");
                }
            }
            setResult(-1, intent);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e.printStackTrace();
        }
    }
}
