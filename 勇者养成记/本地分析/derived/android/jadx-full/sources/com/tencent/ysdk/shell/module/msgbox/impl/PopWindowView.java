package com.tencent.ysdk.shell.module.msgbox.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PopWindowView extends android.widget.RelativeLayout implements android.view.View.OnClickListener {
    private static final int CLICK_TYPE_BACK = 4;
    private static final int CLICK_TYPE_BLANK = 3;
    private static final int CLICK_TYPE_CLOSE = 1;
    private static final int CLICK_TYPE_MORE = 2;
    private static final java.lang.String UI_ID_POP_BANNER = "com_tencent_ysdk_icon_forcepop_banner";
    private static final java.lang.String UI_ID_POP_BUTTON = "com_tencent_ysdk_icon_forcepop_button";
    private static final java.lang.String UI_ID_POP_CLOSE = "com_tencent_ysdk_icon_forcepop_xx";
    private static final java.lang.String UI_ID_POP_CONTENT = "com_tencent_ysdk_icon_forcepop_content";
    private static final java.lang.String UI_ID_POP_DIALOG = "com_tencent_ysdk_icon_forcepop_layout";
    private static final java.lang.String UI_ID_POP_TITLE = "com_tencent_ysdk_icon_forcepop_title";
    private static final java.lang.String UI_LAYOUT_POP = "com_tencent_ysdk_msgbox_popwindow_view";
    private com.tencent.ysdk.module.icon.IBubbleCommand mBubbleCommand;
    private android.widget.ImageView mCloseBtn;
    private android.widget.Button mConfirmBtn;
    private java.lang.String mConfirmBtnUrl;
    private android.widget.TextView mContent;
    private android.widget.RelativeLayout mDialog;
    private android.widget.ImageView mForcePopBanner;
    private java.lang.String mImageUrl;
    private java.lang.String mPopInfoBussinessId;
    private java.lang.String mPopInfoID;
    private android.widget.TextView mTitle;

    public PopWindowView(android.content.Context context) {
        super(context);
        android.view.LayoutInflater.from(context).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_POP), this);
        initView();
        initEvents();
    }

    private void close() {
        if (getParent() != null) {
            ((android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window")).removeView(this);
        }
    }

    private void initEvents() {
        this.mCloseBtn.setOnClickListener(this);
        this.mConfirmBtn.setOnClickListener(this);
        this.mDialog.setOnClickListener(this);
        setOnClickListener(this);
        requestFocus();
    }

    private void initView() {
        this.mCloseBtn = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_POP_CLOSE));
        this.mTitle = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_POP_TITLE));
        this.mContent = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_POP_CONTENT));
        this.mConfirmBtn = (android.widget.Button) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_POP_BUTTON));
        this.mDialog = (android.widget.RelativeLayout) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_POP_DIALOG));
        this.mForcePopBanner = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_POP_BANNER));
    }

    private void reportClose(int i) {
        com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportOtherWindowClose(com.tencent.ysdk.shell.framework.web.WebViewStatHelper.appendPushID(this.mImageUrl, this.mPopInfoID, this.mPopInfoBussinessId), i, "2");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        reportPopClickEvent(4);
        reportClose(3);
        close();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view.getId() == com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_POP_CLOSE)) {
            reportClose(1);
            close();
            com.tencent.ysdk.module.icon.IBubbleCommand iBubbleCommand = this.mBubbleCommand;
            if (iBubbleCommand != null) {
                iBubbleCommand.execute();
            }
            reportPopClickEvent(1);
            return;
        }
        if (view != this.mConfirmBtn) {
            if (view == this.mDialog) {
                return;
            }
            reportClose(2);
            close();
            reportPopClickEvent(3);
            return;
        }
        reportClose(4);
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(this.mConfirmBtnUrl)) {
            com.tencent.ysdk.shell.framework.web.router.IntentRouter.commonJump(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), this.mConfirmBtnUrl, 4);
        }
        if (getParent() != null) {
            ((android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window")).removeView(this);
        }
        reportPopClickEvent(2);
    }

    public void reportPopClickEvent(int i) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("click_type", java.lang.String.valueOf(i));
        map.put(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_PUSH_ID, java.lang.String.valueOf(this.mPopInfoID));
        com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.reportMsgBoxBasicEvent(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.EVENT_POP_CLICK, 0, "pop click", map);
    }

    public void updateViewContent(final com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(msgItem.getTitle())) {
            this.mTitle.setText(msgItem.getTitle());
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(msgItem.getText())) {
            this.mContent.setText(msgItem.getText());
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(msgItem.getPushButtonText())) {
            this.mConfirmBtn.setText(msgItem.getPushButtonText());
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(msgItem.getPushButtonUrl())) {
            this.mConfirmBtnUrl = msgItem.getPushButtonUrl();
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(msgItem.getBgPicUrl())) {
            this.mForcePopBanner.setImageBitmap(null);
            this.mImageUrl = msgItem.getBgPicUrl();
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.msgbox.impl.PopWindowView.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        java.net.URL url = new java.net.URL(com.tencent.ysdk.shell.module.msgbox.impl.PopWindowView.this.mImageUrl);
                        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                        final android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(url.openStream());
                        if (bitmapDecodeStream != null) {
                            com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportOtherWindowLoadTime(android.os.SystemClock.elapsedRealtime() - jElapsedRealtime, com.tencent.ysdk.shell.framework.web.WebViewStatHelper.appendPushID(com.tencent.ysdk.shell.module.msgbox.impl.PopWindowView.this.mImageUrl, msgItem.getMessageId(), msgItem.getBussinessId()), "2");
                            com.tencent.ysdk.shell.module.msgbox.impl.PopWindowView.this.mForcePopBanner.post(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.msgbox.impl.PopWindowView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.tencent.ysdk.shell.module.msgbox.impl.PopWindowView.this.mForcePopBanner.setImageBitmap(bitmapDecodeStream);
                                }
                            });
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        this.mPopInfoID = msgItem.getMessageId();
        this.mPopInfoBussinessId = msgItem.getBussinessId();
        this.mBubbleCommand = msgItem.getBubbleCommand();
    }
}
