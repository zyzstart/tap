package com.dodjoy.privacy.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PrivacyImpl implements com.dodjoy.privacy.IDodPrivacy {
    public static java.lang.String HiddenPrivacy = null;
    private static final java.lang.String SP_IS_FIRST_ENTER_APP = "SP_IS_FIRST_ENTER_APP";
    public static boolean isShowSplash;
    public static java.lang.String privacyContent;
    public static java.lang.String privacyTitle;
    public static java.lang.String privacyUrl;
    public static java.lang.String serverUrl;
    private android.app.AlertDialog dialog;
    private android.app.Activity mActity;
    public android.widget.RelativeLayout mBgRe;
    private java.lang.String mCallbackGoName;
    com.dodjoy.privacy.DodPrivacyCallback mDodPrivacyCallback;
    android.content.SharedPreferences preferences;
    private java.lang.String TAG = "PrivacyImpl";
    private boolean isFirstUse = true;
    private boolean showDialog = true;

    /* JADX INFO: Access modifiers changed from: private */
    public void enterApp() {
        this.dialog.cancel();
        saveFirstEnterApp("yes");
        this.mDodPrivacyCallback.agree();
    }

    private static void getPrivacyConfigUrl(android.content.Context context) {
        try {
            java.io.InputStream inputStreamOpen = context.getResources().getAssets().open("PrivacyConfig.json");
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            while (true) {
                int i = inputStreamOpen.read();
                if (i == -1) {
                    break;
                } else {
                    byteArrayOutputStream.write(i);
                }
            }
            java.lang.String string = byteArrayOutputStream.toString();
            if (string == null || string == "") {
                android.util.Log.e("PrivacyImpl", "读取 PrivacyConfig.json error");
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(string);
            if (jSONObject.has("HiddenPrivacy")) {
                HiddenPrivacy = jSONObject.getString("HiddenPrivacy");
            }
            privacyTitle = jSONObject.getString("PrivacyTitle");
            privacyContent = jSONObject.getString("PrivacyContent");
            privacyUrl = jSONObject.getString("Privacyrl");
            serverUrl = jSONObject.getString("serviceUrl");
            if (jSONObject.has("showSplash")) {
                isShowSplash = true;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFirstEnterApp() {
        boolean zIsFirstEnterApp = isFirstEnterApp();
        getPrivacyConfigUrl(this.mActity);
        if (zIsFirstEnterApp && android.text.TextUtils.isEmpty(HiddenPrivacy)) {
            android.util.Log.e("PrivacyImpl", "首次进入游戏");
            startDialog();
        } else {
            android.util.Log.e("PrivacyImpl", "非首次进入游戏");
            this.mDodPrivacyCallback.agree();
        }
    }

    private void startDialog() {
        this.dialog = new android.app.AlertDialog.Builder(this.mActity).create();
        this.dialog.show();
        this.dialog.setCancelable(false);
        android.view.Window window = this.dialog.getWindow();
        if (window != null) {
            window.setContentView(this.mActity.getResources().getIdentifier("dod_privacy", "layout", this.mActity.getPackageName()));
            window.setGravity(17);
            window.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.flags = 2;
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            android.widget.TextView textView = (android.widget.TextView) window.findViewById(this.mActity.getResources().getIdentifier("tv_title", "id", this.mActity.getPackageName()));
            android.widget.TextView textView2 = (android.widget.TextView) window.findViewById(this.mActity.getResources().getIdentifier("tv_1", "id", this.mActity.getPackageName()));
            textView2.setMovementMethod(android.text.method.ScrollingMovementMethod.getInstance());
            android.widget.TextView textView3 = (android.widget.TextView) window.findViewById(this.mActity.getResources().getIdentifier("tv_cancel", "id", this.mActity.getPackageName()));
            android.widget.TextView textView4 = (android.widget.TextView) window.findViewById(this.mActity.getResources().getIdentifier("tv_agree", "id", this.mActity.getPackageName()));
            this.mBgRe = (android.widget.RelativeLayout) window.findViewById(this.mActity.getResources().getIdentifier("bg_re", "id", this.mActity.getPackageName()));
            textView3.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.dodjoy.privacy.impl.PrivacyImpl.2
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.dodjoy.privacy.impl.PrivacyImpl.this.startFinish();
                }
            });
            textView4.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.dodjoy.privacy.impl.PrivacyImpl.3
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.dodjoy.privacy.impl.PrivacyImpl.this.enterApp();
                }
            });
            java.lang.String str = privacyContent;
            textView2.setText(str);
            textView.setText(privacyTitle);
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
            spannableStringBuilder.append((java.lang.CharSequence) str);
            int iIndexOf = str.indexOf("《");
            spannableStringBuilder.setSpan(new android.text.style.ClickableSpan() { // from class: com.dodjoy.privacy.impl.PrivacyImpl.4
                @Override // android.text.style.ClickableSpan
                public void onClick(android.view.View view) {
                    com.dodjoy.privacy.impl.PrivacyImpl.this.saveFirstEnterApp(cn.yunzhisheng.asr.JniUscClient.aA);
                    android.content.Intent intent = new android.content.Intent();
                    intent.setAction("android.intent.action.VIEW");
                    android.net.Uri uri = android.net.Uri.parse(com.dodjoy.privacy.impl.PrivacyImpl.serverUrl);
                    intent.setFlags(268435456);
                    intent.setData(uri);
                    com.dodjoy.privacy.impl.PrivacyImpl.this.mActity.startActivity(intent);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(android.text.TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf, iIndexOf + 6, 0);
            int iLastIndexOf = str.lastIndexOf("《");
            spannableStringBuilder.setSpan(new android.text.style.ClickableSpan() { // from class: com.dodjoy.privacy.impl.PrivacyImpl.5
                @Override // android.text.style.ClickableSpan
                public void onClick(android.view.View view) {
                    com.dodjoy.privacy.impl.PrivacyImpl.this.saveFirstEnterApp(cn.yunzhisheng.asr.JniUscClient.aA);
                    android.content.Intent intent = new android.content.Intent();
                    intent.setAction("android.intent.action.VIEW");
                    android.net.Uri uri = android.net.Uri.parse(com.dodjoy.privacy.impl.PrivacyImpl.privacyUrl);
                    intent.setFlags(268435456);
                    intent.setData(uri);
                    com.dodjoy.privacy.impl.PrivacyImpl.this.mActity.startActivity(intent);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(android.text.TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }
            }, iLastIndexOf, iLastIndexOf + 6, 0);
            textView2.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
            textView2.setText(spannableStringBuilder, android.widget.TextView.BufferType.SPANNABLE);
            if (!isShowSplash) {
                this.mBgRe.setVisibility(4);
            } else {
                this.mBgRe.setVisibility(0);
                hidenSplash();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFinish() {
        this.mDodPrivacyCallback.cancel();
        saveFirstEnterApp(cn.yunzhisheng.asr.JniUscClient.aA);
        this.dialog.cancel();
        java.lang.System.exit(0);
    }

    @Override // com.dodjoy.privacy.IDodPrivacy
    public void Init(android.app.Activity activity, com.dodjoy.privacy.DodPrivacyCallback dodPrivacyCallback) {
        this.mActity = activity;
        this.mDodPrivacyCallback = dodPrivacyCallback;
        this.mActity.runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.privacy.impl.PrivacyImpl.1
            @Override // java.lang.Runnable
            public void run() {
                com.dodjoy.privacy.impl.PrivacyImpl.this.handleFirstEnterApp();
            }
        });
    }

    public void hidenSplash() {
        new android.os.Handler().postDelayed(new java.lang.Runnable() { // from class: com.dodjoy.privacy.impl.PrivacyImpl.6
            @Override // java.lang.Runnable
            public void run() {
                com.dodjoy.privacy.impl.PrivacyImpl.this.mBgRe.setVisibility(4);
            }
        }, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY);
    }

    public boolean isFirstEnterApp() {
        java.lang.String string = this.mActity.getSharedPreferences("isPrivacy", 0).getString("isAgreement", cn.yunzhisheng.asr.JniUscClient.aA);
        return string == null || !string.equals("yes");
    }

    public void saveFirstEnterApp(java.lang.String str) {
        android.content.SharedPreferences.Editor editorEdit = this.mActity.getSharedPreferences("isPrivacy", 0).edit();
        editorEdit.putString("isAgreement", str);
        editorEdit.commit();
    }
}
