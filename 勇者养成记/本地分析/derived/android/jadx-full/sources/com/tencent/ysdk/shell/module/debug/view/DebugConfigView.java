package com.tencent.ysdk.shell.module.debug.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DebugConfigView extends android.widget.LinearLayout implements android.view.View.OnClickListener {
    private static final java.lang.String UI_BUTTON_CLOSE = "com_tencent_ysdk_debug_config_close_button";
    private static final java.lang.String UI_CLEAR_BUTTON = "com_tencent_ysdk_debug_config_clear_button";
    private static final java.lang.String UI_COPY_BUTTON = "com_tencent_ysdk_debug_config_copy_button";
    private static final java.lang.String UI_FORMAL_BUTTON = "com_tencent_ysdk_debug_config_formal_button";
    private static final java.lang.String UI_INFO_TEXT = "com_tencent_ysdk_debug_config_info_text";
    private static final java.lang.String UI_LAYOUT_DEBUG_ICON_VIEW = "com_tencent_ysdk_debug_config_view";
    private static final java.lang.String UI_REMOVE_BUTTON = "com_tencent_ysdk_debug_config_remove_icon";
    private static final java.lang.String UI_TEST_BUTTON = "com_tencent_ysdk_debug_config_test_button";
    private static final java.lang.String UI_TEXT_CURRENT_DOMAIN = "com_tencent_ysdk_debug_config_current_domain_text";
    private android.widget.Button mChangeToFormalButton;
    private android.widget.Button mChangeToTestButton;
    private android.widget.Button mClearConfigButton;
    private android.widget.Button mCloseButton;
    private android.content.Context mContext;
    private android.widget.Button mCopyButton;
    private android.widget.TextView mInfoText;
    private android.widget.TextView mRemoveIconView;
    private android.view.WindowManager mWindowManager;

    public DebugConfigView(android.content.Context context) {
        super(context);
        this.mContext = context;
        android.view.LayoutInflater.from(context).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_DEBUG_ICON_VIEW), this);
        this.mCloseButton = (android.widget.Button) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_BUTTON_CLOSE));
        this.mChangeToFormalButton = (android.widget.Button) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_FORMAL_BUTTON));
        this.mChangeToTestButton = (android.widget.Button) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_TEST_BUTTON));
        this.mClearConfigButton = (android.widget.Button) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_CLEAR_BUTTON));
        this.mInfoText = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_INFO_TEXT));
        this.mCopyButton = (android.widget.Button) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_COPY_BUTTON));
        this.mRemoveIconView = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_REMOVE_BUTTON));
        setOnClickListener(this);
        this.mCloseButton.setOnClickListener(this);
        this.mChangeToFormalButton.setOnClickListener(this);
        this.mChangeToTestButton.setOnClickListener(this);
        this.mClearConfigButton.setOnClickListener(this);
        this.mCopyButton.setOnClickListener(this);
        this.mRemoveIconView.setOnClickListener(this);
        setGravity(android.support.v4.view.GravityCompat.START);
    }

    public void closeDebugConfigView() {
        android.view.WindowManager windowManager = this.mWindowManager;
        if (windowManager != null) {
            windowManager.removeView(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view == this.mCloseButton) {
            closeDebugConfigView();
            return;
        }
        if (view == this.mChangeToTestButton) {
            com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().switchToTestDomain();
            android.widget.Toast.makeText(this.mContext, "已切换至沙箱环境，重启应用生效", 1).show();
            return;
        }
        if (view == this.mChangeToFormalButton) {
            com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().switchToFormalDomain();
            android.widget.Toast.makeText(this.mContext, "已切换至正式环境，重启应用生效", 1).show();
            return;
        }
        if (view == this.mClearConfigButton) {
            com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().clearConfig();
            android.widget.Toast.makeText(this.mContext, "已清除环境配置，以ysdkconf中配置生效，重启应用生效", 1).show();
        } else if (view == this.mCopyButton) {
            com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().setClipBoard(com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().getDebugInfo().replace("\n", ","));
            android.widget.Toast.makeText(this.mContext, "已复制进剪切板", 1).show();
        } else if (view == this.mRemoveIconView) {
            com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().closeDebugIconView();
            android.widget.Toast.makeText(this.mContext, "已移除调试页面的悬浮球，重启应用仍会展现", 1).show();
        }
    }

    public void showDebugConfigView() {
        ((android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_TEXT_CURRENT_DOMAIN))).setText(com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().getDomain());
        this.mInfoText.setText(com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().getDebugInfo());
        this.mWindowManager = com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().getWindowManager();
        android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(1000);
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        if (getParent() == null) {
            this.mWindowManager.addView(this, layoutParams);
        } else {
            this.mWindowManager.updateViewLayout(this, layoutParams);
        }
    }
}
