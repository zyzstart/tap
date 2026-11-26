package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconCloseView {
    private static final int ICON_CLOSE_NEED_TIP = 0;
    private static final int ICON_CLOSE_NO_TIP = 1;
    private static final int ICON_CLOSE_TIP_MAX_SHOW_TIME = 3;
    private static final java.lang.String TAG = "IconCloseView";
    private static final java.lang.String UI_ID_ICON_POP_CLOSE_BUTTON = "com_tencent_ysdk_icon_close_still_close";
    private static final java.lang.String UI_ID_ICON_POP_NOT_CLOSE_BUTTON = "com_tencent_ysdk_icon_close_not_close";
    private static final java.lang.String UI_ID_ICON_POP_NO_MORE_TIPS = "com_tencent_ysdk_icon_close_no_more_tips";
    private static final java.lang.String UI_LAYOUT_ICON_POP_WINDOW = "com_tencent_ysdk_icon_close_pop_view";
    private static final int UNDEFINED = -1;
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.OnIconCloseTipClickCallback mCallback;
    private android.widget.TextView mCloseIconButton;
    private android.content.Context mContext;
    private android.view.View mIconClosePopWindowView;
    private android.widget.CheckBox mNoMoreTipsBox;
    private android.widget.TextView mNotCloseIconButton;
    private android.view.WindowManager mWindowManager;

    public interface OnIconCloseTipClickCallback {
        void onCloseClick();

        void onNoCloseClick();
    }

    public IconCloseView(android.content.Context context, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.OnIconCloseTipClickCallback onIconCloseTipClickCallback) {
        this.mContext = context;
        this.mCallback = onIconCloseTipClickCallback;
        initIconView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.Map<java.lang.String, java.lang.String> getCommonMap(int i) {
        java.util.HashMap map = new java.util.HashMap();
        if (i >= 3) {
            this.mNoMoreTipsBox.setVisibility(0);
            map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_ICON_CLOSE_WINDOW_CHECKBOX_SHOW, com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
            map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_ICON_CLOSE_WINDOW_CHECKBOX_CHOOSE, "false");
        } else {
            map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_ICON_CLOSE_WINDOW_CHECKBOX_SHOW, "false");
            map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_ICON_CLOSE_WINDOW_CHECKBOX_CHOOSE, "null");
        }
        return map;
    }

    private android.view.WindowManager getWindowManager() {
        if (this.mWindowManager == null) {
            this.mWindowManager = (android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window");
        }
        return this.mWindowManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCloseBtnClick() {
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.OnIconCloseTipClickCallback onIconCloseTipClickCallback = this.mCallback;
        if (onIconCloseTipClickCallback != null) {
            onIconCloseTipClickCallback.onCloseClick();
        }
        int iconCloseCount = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.getIconCloseCount(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id);
        java.util.Map<java.lang.String, java.lang.String> commonMap = getCommonMap(iconCloseCount);
        commonMap.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_ICON_CLOSE_WINDOW_RESULT, cn.yunzhisheng.asr.JniUscClient.s);
        if (this.mIconClosePopWindowView.getParent() != null) {
            ((android.view.WindowManager) this.mIconClosePopWindowView.getContext().getSystemService("window")).removeView(this.mIconClosePopWindowView);
        }
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.saveIconCloseCount(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id, iconCloseCount + 1);
        android.widget.CheckBox checkBox = this.mNoMoreTipsBox;
        if (checkBox != null && checkBox.isChecked()) {
            com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.saveIconTipsMode(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id, 1);
        }
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_ICON_CLOSE_WINDOW_CLOSE, 0, "icon close window close", commonMap, java.lang.System.currentTimeMillis(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNotCloseBtnClick() {
        try {
            if (this.mCallback != null) {
                this.mCallback.onNoCloseClick();
            }
            java.util.Map<java.lang.String, java.lang.String> commonMap = getCommonMap(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.getIconCloseCount(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id));
            commonMap.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_ICON_CLOSE_WINDOW_RESULT, "stillUse");
            if (this.mIconClosePopWindowView.getParent() != null) {
                ((android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window")).removeView(this.mIconClosePopWindowView);
            }
            com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().resetAndShowIconWindow();
            if (this.mNoMoreTipsBox != null && this.mNoMoreTipsBox.isChecked()) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.saveIconTipsMode(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id, 1);
            }
            com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_ICON_CLOSE_WINDOW_CLOSE, 0, "icon close window close", commonMap, java.lang.System.currentTimeMillis(), true);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, e.getLocalizedMessage());
        }
    }

    private void initIconView() {
        if (this.mIconClosePopWindowView == null) {
            this.mIconClosePopWindowView = android.view.View.inflate(this.mContext, com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_ICON_POP_WINDOW), null);
        }
        if (this.mCloseIconButton == null) {
            this.mCloseIconButton = (android.widget.TextView) this.mIconClosePopWindowView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ICON_POP_CLOSE_BUTTON));
        }
        if (this.mNotCloseIconButton == null) {
            this.mNotCloseIconButton = (android.widget.TextView) this.mIconClosePopWindowView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ICON_POP_NOT_CLOSE_BUTTON));
        }
        if (this.mNoMoreTipsBox == null) {
            this.mNoMoreTipsBox = (android.widget.CheckBox) this.mIconClosePopWindowView.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ICON_POP_NO_MORE_TIPS));
        }
        initListener();
    }

    private void initListener() {
        this.mCloseIconButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                try {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.this.handleCloseBtnClick();
                } catch (java.lang.Exception e) {
                    com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.TAG, e);
                }
            }
        });
        this.mNotCloseIconButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                try {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.this.handleNotCloseBtnClick();
                } catch (java.lang.Exception e) {
                    com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.TAG, e);
                }
            }
        });
        this.mNoMoreTipsBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
                try {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.this.getCommonMap(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.getIconCloseCount(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id)).put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_ICON_CLOSE_WINDOW_CHECKBOX_CHOOSE, java.lang.String.valueOf(z));
                } catch (java.lang.Exception e) {
                    com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.TAG, e);
                }
            }
        });
    }

    public void showNoMoreTipsWindow() {
        try {
            java.lang.String str = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id;
            if (com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.getIconCloseTipMode(str) == 1) {
                return;
            }
            int iconCloseCount = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.getIconCloseCount(str);
            if (iconCloseCount <= 3) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.saveIconCloseCount(str, iconCloseCount + 1);
                this.mNoMoreTipsBox.setVisibility(4);
            } else {
                this.mNoMoreTipsBox.setVisibility(0);
            }
            if (this.mIconClosePopWindowView.getParent() == null) {
                android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(1000);
                layoutParams.height = -2;
                layoutParams.width = -2;
                layoutParams.format = -3;
                getWindowManager().addView(this.mIconClosePopWindowView, layoutParams);
                com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_ICON_CLOSE_WINDOW_EXPOSURE, 0, "icon close window show", null, java.lang.System.currentTimeMillis(), true);
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }
}
