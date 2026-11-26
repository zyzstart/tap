package com.tencent.ysdk.shell.module.msgbox.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TipView extends android.widget.RelativeLayout implements android.view.View.OnClickListener {
    private static final int CLICK_TYPE_CLOSE = 1;
    private static final int CLICK_TYPE_MORE = 2;
    private static final java.lang.String UI_ID_BUTTON = "ysdk_msg_box_tips_button";
    private static final java.lang.String UI_ID_CONTENT = "ysdk_msg_box_tips_msg";
    private static final java.lang.String UI_ID_ICON = "ysdk_msg_box_tips_icon";
    private static final java.lang.String UI_ID_TITLE = "ysdk_msg_box_tips_title";
    private static final java.lang.String UI_LAYOUT = "com_tencent_ysdk_msgbox_tips_view";
    private com.tencent.ysdk.module.icon.IBubbleCommand mBubbleCommand;
    private android.widget.Button mConfirmBtn;
    private java.lang.String mConfirmBtnUrl;
    private android.widget.TextView mContent;
    private android.widget.ImageView mIcon;
    private java.lang.String mIconURL;
    private java.lang.String mPopInfoBussinessId;
    private java.lang.String mPopInfoID;
    private android.widget.TextView mTitle;

    public TipView(android.content.Context context) {
        super(context);
        android.view.LayoutInflater.from(context).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT), this);
        initView();
        initEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean close() {
        if (getParent() == null) {
            return false;
        }
        ((android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window")).removeView(this);
        com.tencent.ysdk.module.icon.IBubbleCommand iBubbleCommand = this.mBubbleCommand;
        if (iBubbleCommand == null) {
            return true;
        }
        iBubbleCommand.execute();
        return true;
    }

    private void initEvents() {
        this.mConfirmBtn.setOnClickListener(this);
    }

    private void initView() {
        this.mIcon = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ICON));
        this.mTitle = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_TITLE));
        this.mContent = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_CONTENT));
        this.mConfirmBtn = (android.widget.Button) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_BUTTON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClose(int i) {
        com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportOtherWindowClose(com.tencent.ysdk.shell.framework.web.WebViewStatHelper.appendPushID(this.mConfirmBtnUrl, this.mPopInfoID, this.mPopInfoBussinessId), i, "4");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view != this.mConfirmBtn || com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(this.mConfirmBtnUrl)) {
            return;
        }
        com.tencent.ysdk.shell.framework.web.router.IntentRouter.commonJump(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), this.mConfirmBtnUrl, 8);
        close();
        reportClose(1);
        reportPopClickEvent(2);
    }

    public void reportPopClickEvent(int i) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("click_type", java.lang.String.valueOf(i));
        map.put(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_PUSH_ID, java.lang.String.valueOf(this.mPopInfoID));
        com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.reportMsgBoxBasicEvent(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.EVENT_TIPS_CLICK, 0, "tips click", map);
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
            this.mIconURL = msgItem.getBgPicUrl();
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.msgbox.impl.TipView.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        java.net.URL url = new java.net.URL(com.tencent.ysdk.shell.module.msgbox.impl.TipView.this.mIconURL);
                        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                        final android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(url.openStream());
                        if (bitmapDecodeStream != null) {
                            com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportOtherWindowLoadTime(android.os.SystemClock.elapsedRealtime() - jElapsedRealtime, com.tencent.ysdk.shell.framework.web.WebViewStatHelper.appendPushID(com.tencent.ysdk.shell.module.msgbox.impl.TipView.this.mIconURL, msgItem.getMessageId(), msgItem.getBussinessId()), "4");
                            com.tencent.ysdk.shell.module.msgbox.impl.TipView.this.mIcon.post(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.msgbox.impl.TipView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.tencent.ysdk.shell.module.msgbox.impl.TipView.this.mIcon.setImageBitmap(bitmapDecodeStream);
                                }
                            });
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        if (msgItem.getShowDelaySec() > 0) {
            postDelayed(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.msgbox.impl.TipView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (com.tencent.ysdk.shell.module.msgbox.impl.TipView.this.close()) {
                        com.tencent.ysdk.shell.module.msgbox.impl.TipView.this.reportClose(4);
                        com.tencent.ysdk.shell.module.msgbox.impl.TipView.this.reportPopClickEvent(1);
                    }
                }
            }, msgItem.getShowDelaySec() * 1000);
        }
        this.mPopInfoID = msgItem.getMessageId();
        this.mPopInfoBussinessId = msgItem.getBussinessId();
        this.mBubbleCommand = msgItem.getBubbleCommand();
    }
}
