package com.dodjoy.thirdPlatform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodYSDKLoginActivity extends android.app.Activity implements android.view.View.OnClickListener {
    public static java.lang.String LOGINFLAG = "qq";
    private static com.dodjoy.thirdPlatform.DodYSDKCallback dodYSDKCallback;
    private static java.lang.ref.WeakReference<com.dodjoy.thirdPlatform.DodYSDKLoginActivity> sActivityRef;
    private android.view.View mView;
    private android.widget.Button qqLogin;
    private android.widget.Button wxLogin;

    public static void finishActivity() {
        java.lang.ref.WeakReference<com.dodjoy.thirdPlatform.DodYSDKLoginActivity> weakReference = sActivityRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        sActivityRef.get().finish();
    }

    public static void setDodYSDKLoginCallback(com.dodjoy.thirdPlatform.DodYSDKCallback dodYSDKCallback2) {
        dodYSDKCallback = dodYSDKCallback2;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        if (LOGINFLAG == "qq") {
            super.onActivityResult(i, i2, intent);
            com.tencent.ysdk.api.YSDKApi.onActivityResult(i, i2, intent);
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view == this.wxLogin) {
            LOGINFLAG = com.tencent.ysdk.framework.common.ePlatform.PLATFORM_STR_WX;
            com.dodjoy.thirdPlatform.DodYSDKCallback dodYSDKCallback2 = dodYSDKCallback;
            if (dodYSDKCallback2 != null) {
                dodYSDKCallback2.dodWXLogin();
            }
            finish();
            return;
        }
        if (view == this.qqLogin) {
            LOGINFLAG = "qq";
            com.dodjoy.thirdPlatform.DodYSDKCallback dodYSDKCallback3 = dodYSDKCallback;
            if (dodYSDKCallback3 != null) {
                dodYSDKCallback3.dodQQLogin();
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        this.mView = android.view.LayoutInflater.from(this).inflate(com.dodjoy.thirdPlatform.util.ResourceUtils.getLayoutId(this, "dod_ysdk_login"), (android.view.ViewGroup) null);
        super.onCreate(bundle);
        setContentView(this.mView);
        this.wxLogin = (android.widget.Button) this.mView.findViewById(com.dodjoy.thirdPlatform.util.ResourceUtils.getId(getApplicationContext(), "dod_ysdk_wx_login"));
        this.qqLogin = (android.widget.Button) this.mView.findViewById(com.dodjoy.thirdPlatform.util.ResourceUtils.getId(getApplicationContext(), "dod_ysdk_qq_login"));
        this.wxLogin.setOnClickListener(this);
        this.qqLogin.setOnClickListener(this);
        sActivityRef = new java.lang.ref.WeakReference<>(this);
    }
}
