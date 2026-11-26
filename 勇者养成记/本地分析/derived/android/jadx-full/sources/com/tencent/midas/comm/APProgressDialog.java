package com.tencent.midas.comm;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APProgressDialog extends android.app.ProgressDialog {
    private android.content.Context context;
    private java.lang.String loadingTxt;
    private android.widget.TextView loading_txt;

    public APProgressDialog(android.content.Context context) {
        super(context);
        this.loadingTxt = "请稍候...";
        this.loading_txt = null;
        this.context = null;
        this.context = context;
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.pay.tool.APMidasCommMethod.getLayoutId(this.context, "unipay_layout_loadding"));
        android.widget.ProgressBar progressBar = (android.widget.ProgressBar) findViewById(com.pay.tool.APMidasCommMethod.getId(this.context, "unipay_progress"));
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.2f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(2);
        progressBar.setAnimation(alphaAnimation);
        alphaAnimation.start();
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.pay.tool.APMidasCommMethod.getId(this.context, "unipay_id_LoadingTxt"));
        this.loading_txt = textView;
        textView.setText(this.loadingTxt);
        setCancelable(false);
    }

    @Override // android.app.AlertDialog, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        cancel();
        return false;
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public void setMessage(java.lang.CharSequence charSequence) {
        super.setMessage(charSequence);
        this.loadingTxt = java.lang.String.valueOf(charSequence);
    }
}
