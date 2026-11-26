package com.tencent.ysdk.shell.module.realName.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RegisterRealNameActivity extends android.app.Activity {
    private static final int DIALOG_CONFIRM_TYPE_LOGIN = 1;
    private static final int DIALOG_CONFIRM_TYPE_TRY_AGAIN = 2;
    private static final int SELECT_TYPE_IDENTITY_TYP = 1;
    private android.view.View dialogView;
    private android.widget.TextView mAgreement;
    private android.view.View mBackBtn;
    private android.widget.CheckBox mCheckBox;
    private android.view.View mCommitBtn;
    private android.widget.Button mConfirm;
    private android.widget.TextView mDes1;
    private android.view.View mDialogViewClose;
    private android.widget.EditText mIdentityNum;
    private android.widget.ImageView mIdentityNumMust;
    private android.widget.TextView mIdentityType;
    private int mIdentityTypeIndex;
    private android.widget.ImageView mIdentityTypeMust;
    private android.widget.ImageView mImgTips;
    private android.widget.EditText mName;
    private android.widget.ImageView mNameMust;
    private android.app.ProgressDialog mProgressDialog;
    private android.app.Dialog mResultDialog;
    private android.widget.TextView mTips;
    private android.widget.TextView mTipsDes;
    private android.view.View mTipsQQ;
    private android.app.Dialog mWebDialog;
    private android.view.View webDialogView;
    private android.webkit.WebView webView;
    private boolean mHasSuccRegisterRealName = false;
    private android.view.View.OnClickListener mOnClickListener = new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if (view.getId() == com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_back")) {
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.goBack();
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.finish();
                return;
            }
            if (view.getId() == com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_commit")) {
                com.tencent.ysdk.shell.libware.file.Logger.d("commitNameAuth");
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.commitNameAuth();
                return;
            }
            if (view.getId() == com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_agreement")) {
                com.tencent.ysdk.shell.libware.file.Logger.d("showUserAgreement");
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.showUserAgreement();
                return;
            }
            if (view.getId() == com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_webview_dialog_close")) {
                com.tencent.ysdk.shell.libware.file.Logger.d("hideUserAgreement");
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.hideUserAgreement();
                return;
            }
            if (view.getId() == com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_webview_dialog_close")) {
                com.tencent.ysdk.shell.libware.file.Logger.d("hideUserAgreement");
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.hideUserAgreement();
                return;
            }
            if (view.getId() == com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_identity_type")) {
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.showSelectDialog(1);
                return;
            }
            if (view.getId() == com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_dialog_tips_qq")) {
                return;
            }
            if (view.getId() == com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_dialog_close")) {
                if (com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mResultDialog != null) {
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mResultDialog.hide();
                }
                if (com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mHasSuccRegisterRealName) {
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.notifyRegisterRealNameResultSucc();
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.finish();
                    return;
                }
                return;
            }
            if (view.getId() == com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_dialog_confirm")) {
                if (view.getTag() != null && ((java.lang.Integer) view.getTag()).intValue() == 1) {
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.notifyRegisterRealNameResultSucc();
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.finish();
                } else if (com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mResultDialog != null) {
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mResultDialog.hide();
                }
            }
        }
    };
    private android.text.TextWatcher mIdentityNumTextWatcher = new android.text.TextWatcher() { // from class: com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.2
        @Override // android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(charSequence.toString()) || com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNumMust == null) {
                return;
            }
            com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNumMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_must"));
            com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNumMust.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(charSequence.toString())) {
                if (com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNumMust != null) {
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNumMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_must"));
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNumMust.setVisibility(0);
                    return;
                }
                return;
            }
            if (com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNumMust != null) {
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNumMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_del"));
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNumMust.setVisibility(0);
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNumMust.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(android.view.View view) {
                        com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityNum.setText("");
                    }
                });
            }
        }
    };
    private android.text.TextWatcher mNameTextWatcher = new android.text.TextWatcher() { // from class: com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.3
        @Override // android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
            if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(editable.toString()) || com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust == null) {
                return;
            }
            com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_must"));
            com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(charSequence.toString()) || com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust == null) {
                return;
            }
            com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_must"));
            com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(charSequence.toString())) {
                if (com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust != null) {
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_must"));
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust.setVisibility(0);
                    return;
                }
                return;
            }
            if (com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust != null) {
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_del"));
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust.setVisibility(0);
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mNameMust.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(android.view.View view) {
                        com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mName.setText("");
                    }
                });
            }
        }
    };

    private class UiListener implements com.tencent.ysdk.shell.module.realName.RealNameInnerListener {
        private UiListener() {
        }

        @Override // com.tencent.ysdk.shell.module.realName.RealNameInnerListener
        public void OnRegisterRealNameNotify(com.tencent.ysdk.framework.common.BaseRet baseRet) {
            com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.hidProgress();
            if (baseRet.ret == 0) {
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mHasSuccRegisterRealName = true;
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mImgTips.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_success"));
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mTips.setText(com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_success")));
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mTipsDes.setText(com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_success_des")));
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mTipsQQ.setVisibility(8);
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mConfirm.setText(com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_login")));
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mConfirm.setTag(1);
            } else {
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mHasSuccRegisterRealName = false;
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mImgTips.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_warning"));
                java.lang.String string = com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_fail"));
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mTips.setText(string);
                int i = baseRet.flag;
                if (i != 100105) {
                    switch (i) {
                        case 1:
                            string = com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_fail_reg_already"));
                            break;
                        case 2:
                            string = com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_fail_count_limit"));
                            break;
                        case 3:
                            string = com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_fail_invalid_id"));
                            break;
                        case 4:
                            string = com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_fail_invalid_birth"));
                            break;
                        case 5:
                            string = com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_fail_invalid_name"));
                            break;
                        case 6:
                            string = com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_fail_invalid_para"));
                            break;
                    }
                } else {
                    string = com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_fail_server_error"));
                }
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mTipsDes.setText(java.lang.String.format(string, java.lang.Integer.valueOf(baseRet.flag)));
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mTipsQQ.setVisibility(0);
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mConfirm.setText(com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_tryagain")));
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mConfirm.setTag(2);
            }
            if (com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mResultDialog == null) {
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity registerRealNameActivity = com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this;
                registerRealNameActivity.mResultDialog = new android.app.Dialog(registerRealNameActivity, com.tencent.ysdk.shell.libware.ui.res.Res.style("com_tencent_ysdk_dialog_theme"));
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mResultDialog.setContentView(com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.dialogView);
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mResultDialog.setCancelable(false);
            }
            com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mResultDialog.show();
        }
    }

    private boolean checkAgreementUserInput(boolean z) {
        com.tencent.ysdk.shell.libware.file.Logger.d("checkAgreementUserInput");
        if (this.mCheckBox.isChecked()) {
            return true;
        }
        if (!z) {
            return false;
        }
        showCheckInfoByItemId(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_agreement_check_box"));
        return false;
    }

    private boolean checkIdentityNumUserInput(boolean z) {
        com.tencent.ysdk.shell.libware.file.Logger.d("checkIdentityNumUserInput");
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(this.mIdentityNum.getEditableText() != null ? this.mIdentityNum.getEditableText().toString() : "")) {
            this.mIdentityNumMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_correct"));
            this.mIdentityNumMust.setVisibility(0);
            return true;
        }
        this.mIdentityNumMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_must"));
        this.mIdentityNumMust.setVisibility(0);
        if (z) {
            showCheckInfoByItemId(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_identity_num_must"));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIdentityTypeUserInput(boolean z) {
        com.tencent.ysdk.shell.libware.file.Logger.d("checkIdentityTypeUserInput");
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(this.mIdentityType.getText() != null ? this.mIdentityType.getText().toString() : "")) {
            this.mIdentityTypeMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_correct"));
            this.mIdentityTypeMust.setVisibility(0);
            return true;
        }
        this.mIdentityTypeMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_must"));
        this.mIdentityTypeMust.setVisibility(0);
        if (z) {
            showCheckInfoByItemId(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_identity_type_must"));
        }
        return false;
    }

    private boolean checkNameUserInput(boolean z) {
        com.tencent.ysdk.shell.libware.file.Logger.d("checkNameUserInput");
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(this.mName.getEditableText() != null ? this.mName.getEditableText().toString() : "")) {
            this.mNameMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_correct"));
            this.mNameMust.setVisibility(0);
            return true;
        }
        this.mNameMust.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable("com_tencent_ysdk_real_name_must"));
        this.mNameMust.setVisibility(0);
        if (z) {
            showCheckInfoByItemId(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_name_must"));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitNameAuth() {
        com.tencent.ysdk.shell.libware.file.Logger.d("commitNameAuth");
        if (checkNameUserInput(true) && checkIdentityTypeUserInput(true) && checkIdentityNumUserInput(true) && checkAgreementUserInput(true)) {
            showProgress();
            com.tencent.ysdk.shell.libware.file.Logger.d("check result is ok");
            com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara registerRealNameRequestPara = new com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara();
            if (this.mName.getEditableText() != null) {
                registerRealNameRequestPara.real_name = this.mName.getEditableText().toString().trim();
            } else {
                registerRealNameRequestPara.real_name = "";
            }
            registerRealNameRequestPara.cert_type = java.lang.String.valueOf(this.mIdentityTypeIndex);
            if (this.mIdentityNum.getEditableText() != null) {
                registerRealNameRequestPara.cert_id = this.mIdentityNum.getEditableText().toString().trim();
            } else {
                registerRealNameRequestPara.cert_id = "";
            }
            com.tencent.ysdk.shell.module.realName.RealNameApi.getInstance().registerRealName(registerRealNameRequestPara, new com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.UiListener());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        if (!this.mHasSuccRegisterRealName) {
            notifyRegisterRealNameResultFailed();
        } else {
            notifyRegisterRealNameResultSucc();
            com.tencent.ysdk.shell.libware.file.Logger.d("mHasSuccRegisterRealName is true");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hidProgress() {
        android.app.ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideUserAgreement() {
        android.app.Dialog dialog = this.mWebDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    private void initView() {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "initView");
        com.tencent.ysdk.framework.common.ePlatform userLoginPltform = com.tencent.ysdk.shell.module.realName.RealNameApi.getInstance().getUserLoginPltform();
        java.lang.String string = "";
        if (userLoginPltform == com.tencent.ysdk.framework.common.ePlatform.QQ) {
            string = getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_des1_qq_str"));
        } else if (userLoginPltform == com.tencent.ysdk.framework.common.ePlatform.WX) {
            string = getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_des1_wx_str"));
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "platName:" + string);
        java.lang.String str = "<font color='" + getResources().getColor(com.tencent.ysdk.shell.libware.ui.res.Res.color("com_tencent_ysdk_real_name_title_color")) + "'> " + com.tencent.ysdk.shell.module.realName.RealNameApi.getInstance().getUserNickname() + " </font>";
        this.mDes1 = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_des1"));
        android.widget.TextView textView = this.mDes1;
        textView.setText(android.text.Html.fromHtml(java.lang.String.format(textView.getText().toString(), string, str)));
        this.dialogView = android.view.LayoutInflater.from(this).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout("com_tencent_ysdk_real_name_dialog"), (android.view.ViewGroup) null);
        this.mDialogViewClose = this.dialogView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_dialog_close"));
        this.mDialogViewClose.setOnClickListener(this.mOnClickListener);
        this.mTipsQQ = this.dialogView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_dialog_tips_qq"));
        this.mTipsQQ.setOnClickListener(this.mOnClickListener);
        this.mImgTips = (android.widget.ImageView) this.dialogView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_dialog_img_tips"));
        this.mTips = (android.widget.TextView) this.dialogView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_dialog_tips"));
        this.mTipsDes = (android.widget.TextView) this.dialogView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_dialog_tips_des"));
        this.mConfirm = (android.widget.Button) this.dialogView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_dialog_confirm"));
        this.mConfirm.setOnClickListener(this.mOnClickListener);
        this.mName = (android.widget.EditText) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_name"));
        this.mName.addTextChangedListener(this.mNameTextWatcher);
        this.mNameMust = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_name_must"));
        this.mIdentityType = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_identity_type"));
        this.mIdentityType.setOnClickListener(this.mOnClickListener);
        this.mIdentityTypeMust = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_identity_type_must"));
        this.mIdentityNum = (android.widget.EditText) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_identity_num"));
        this.mIdentityNum.addTextChangedListener(this.mIdentityNumTextWatcher);
        this.mIdentityNumMust = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_identity_num_must"));
        this.mCheckBox = (android.widget.CheckBox) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_agreement_check_box"));
        this.mAgreement = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_agreement"));
        this.mAgreement.setOnClickListener(this.mOnClickListener);
        this.mBackBtn = findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_back"));
        this.mBackBtn.setOnClickListener(this.mOnClickListener);
        this.mCommitBtn = findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_commit"));
        this.mCommitBtn.setOnClickListener(this.mOnClickListener);
    }

    private void notifyRegisterRealNameResultFailed() {
        com.tencent.ysdk.framework.common.BaseRet baseRet = new com.tencent.ysdk.framework.common.BaseRet();
        baseRet.ret = 1;
        baseRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_NotRegisterRealName;
        baseRet.msg = "user cancle register real name";
        com.tencent.ysdk.shell.module.realName.RealNameApi.getInstance().notifyRegisterRealName(baseRet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRegisterRealNameResultSucc() {
        com.tencent.ysdk.framework.common.BaseRet baseRet = new com.tencent.ysdk.framework.common.BaseRet();
        baseRet.ret = 0;
        baseRet.flag = 0;
        baseRet.msg = "user register real name succ ";
        com.tencent.ysdk.shell.module.realName.RealNameApi.getInstance().notifyRegisterRealName(baseRet);
    }

    private void showCheckInfoByItemId(int i) {
        int iString;
        com.tencent.ysdk.shell.libware.file.Logger.d("redId:" + i);
        if (com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_agreement_check_box") == i) {
            iString = com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_agreement_tips");
        } else if (com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_name_must") == i) {
            iString = com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_name");
        } else if (com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_identity_type_must") == i) {
            iString = com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_identity_type");
        } else {
            iString = com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_act_identity_num_must") == i ? com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_identity_num") : -1;
        }
        android.widget.Toast.makeText(getApplicationContext(), getResources().getString(iString), 0).show();
    }

    private void showProgress() {
        this.mProgressDialog = android.app.ProgressDialog.show(this, null, getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_commit_progress_msg")));
        this.mProgressDialog.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.4
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mProgressDialog.hide();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSelectDialog(final int i) {
        final java.lang.String[] stringArray;
        int iString;
        com.tencent.ysdk.shell.libware.file.Logger.d("showSelectDialog:" + i);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        final android.widget.TextView textView = null;
        int i2 = 0;
        if (i != 1) {
            stringArray = null;
            iString = 0;
        } else {
            checkIdentityTypeUserInput(false);
            textView = this.mIdentityType;
            i2 = this.mIdentityTypeIndex;
            stringArray = getResources().getStringArray(com.tencent.ysdk.shell.libware.ui.res.Res.array("com_tencent_ysdk_identity_type_str_arr"));
            iString = com.tencent.ysdk.shell.libware.ui.res.Res.string("com_tencent_ysdk_real_name_identity_type");
        }
        builder.setSingleChoiceItems(stringArray, i2, new android.content.DialogInterface.OnClickListener() { // from class: com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i3) {
                try {
                    if (textView != null) {
                        textView.setText(stringArray[i3]);
                        com.tencent.ysdk.shell.libware.file.Logger.d("which:" + i3 + ";conent:" + stringArray[i3]);
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                if (i == 1) {
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.mIdentityTypeIndex = i3;
                    com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.this.checkIdentityTypeUserInput(false);
                }
                dialogInterface.dismiss();
            }
        });
        try {
            java.lang.String string = getResources().getString(iString);
            com.tencent.ysdk.shell.libware.file.Logger.d("tips", string);
            builder.setTitle(string);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserAgreement() {
        if (this.mWebDialog == null) {
            this.webDialogView = android.view.LayoutInflater.from(this).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout("com_tencent_ysdk_real_name_webview_dialog"), (android.view.ViewGroup) null);
            this.webDialogView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_webview_dialog_close")).setOnClickListener(this.mOnClickListener);
            this.webView = (android.webkit.WebView) this.webDialogView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_webview_dialog_webview"));
            this.webView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, getResources().getDisplayMetrics().heightPixels - 200));
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                try {
                    this.webView.removeJavascriptInterface("searchBoxJavaBridge_");
                    this.webView.removeJavascriptInterface("accessibility");
                    this.webView.removeJavascriptInterface("accessibilityTraversal");
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
            this.mWebDialog = new android.app.Dialog(this, com.tencent.ysdk.shell.libware.ui.res.Res.style("com_tencent_ysdk_dialog_theme"));
            this.mWebDialog.setContentView(this.webDialogView);
            this.mWebDialog.setCancelable(false);
        }
        android.webkit.WebView webView = this.webView;
        if (webView != null) {
            webView.loadUrl(getResources().getString(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_real_name_agreement_url")));
        }
        this.mWebDialog.show();
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "onCreate");
        setContentView(com.tencent.ysdk.shell.libware.ui.res.Res.layout("com_tencent_ysdk_real_name_main"));
        try {
            initView();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        android.app.Dialog dialog = this.mWebDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        android.app.Dialog dialog2 = this.mResultDialog;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        android.app.ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i == 4) {
            goBack();
        } else if (i == 82) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
