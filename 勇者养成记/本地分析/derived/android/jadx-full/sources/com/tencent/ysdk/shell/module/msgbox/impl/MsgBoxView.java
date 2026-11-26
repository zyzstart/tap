package com.tencent.ysdk.shell.module.msgbox.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MsgBoxView implements com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxContract.View {
    private com.tencent.ysdk.module.msgbox.MsgItem mMsgItem;
    private com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxContract.Presenter mPresenter;
    private android.view.WindowManager mWindowManager;

    private android.view.WindowManager getWindowManager() {
        this.mWindowManager = (android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window");
        return this.mWindowManager;
    }

    private void reportRequestTime(java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportWebViewPreLoadTime(this.mMsgItem.getDuration(), com.tencent.ysdk.shell.framework.web.WebViewStatHelper.appendPushID(str, this.mMsgItem.getMessageId(), this.mMsgItem.getBussinessId()), str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTips() {
        try {
            reportRequestTime(this.mMsgItem.getBgPicUrl(), "4");
            com.tencent.ysdk.shell.module.msgbox.impl.TipView tipView = new com.tencent.ysdk.shell.module.msgbox.impl.TipView(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext());
            com.tencent.ysdk.module.msgbox.MsgItem msgItemCloneSelf = this.mMsgItem.cloneSelf();
            msgItemCloneSelf.setBubbleCommand(new com.tencent.ysdk.shell.module.icon.impl.bubble.BubbleCommandImpl(msgItemCloneSelf));
            addFloatWindow(tipView, -2, com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWidth(tipView.getContext()));
            tipView.updateViewContent(msgItemCloneSelf);
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast() {
        try {
            android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), this.mMsgItem.getText(), 1).show();
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebView() {
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_PUSH_ID, this.mMsgItem.getMessageId());
        map.put(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_BUSINESS_ID, this.mMsgItem.getBussinessId());
        reportRequestTime(this.mMsgItem.getH5Url(), "3");
        com.tencent.ysdk.module.msgbox.MsgItem msgItemCloneSelf = this.mMsgItem.cloneSelf();
        final com.tencent.ysdk.shell.module.icon.impl.bubble.BubbleCommandImpl bubbleCommandImpl = new com.tencent.ysdk.shell.module.icon.impl.bubble.BubbleCommandImpl(msgItemCloneSelf);
        msgItemCloneSelf.setBubbleCommand(bubbleCommandImpl);
        com.tencent.ysdk.shell.framework.web.router.IntentRouter.commonJump(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext(), com.tencent.ysdk.shell.framework.web.WebViewStatHelper.appendPushID(msgItemCloneSelf.getH5Url(), msgItemCloneSelf.getMessageId(), msgItemCloneSelf.getBussinessId()), null, 8, map, new com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener() { // from class: com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView.2
            @Override // com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener
            public void onClose() {
                bubbleCommandImpl.execute();
            }

            @Override // com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener
            public void onPageFinish() {
            }

            @Override // com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener
            public void onPageStart() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWindow() {
        try {
            reportRequestTime(this.mMsgItem.getBgPicUrl(), "2");
            com.tencent.ysdk.module.msgbox.MsgItem msgItemCloneSelf = this.mMsgItem.cloneSelf();
            msgItemCloneSelf.setBubbleCommand(new com.tencent.ysdk.shell.module.icon.impl.bubble.BubbleCommandImpl(msgItemCloneSelf));
            com.tencent.ysdk.shell.module.msgbox.impl.PopWindowView popWindowView = new com.tencent.ysdk.shell.module.msgbox.impl.PopWindowView(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext());
            addWindow(popWindowView);
            popWindowView.updateViewContent(msgItemCloneSelf);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void addFloatWindow(android.view.View view) {
        addFloatWindow(view, -2, -2);
    }

    public void addFloatWindow(android.view.View view, int i, int i2) {
        this.mWindowManager = getWindowManager();
        if (view.getParent() == null) {
            android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(1000);
            layoutParams.height = i;
            layoutParams.width = i2;
            layoutParams.gravity = 49;
            layoutParams.flags = 40;
            layoutParams.format = -3;
            this.mWindowManager.addView(view, layoutParams);
        }
    }

    public void addWindow(android.view.View view) {
        this.mWindowManager = getWindowManager();
        if (view.getParent() == null) {
            android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(1000);
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            this.mWindowManager.addView(view, layoutParams);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.mvp.BaseView
    public void setPresenter(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxContract.Presenter presenter) {
        this.mPresenter = presenter;
        this.mPresenter.start();
    }

    @Override // com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxContract.View
    public void showMsg(final com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        if (msgItem == null) {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG, "Msg is null please check it");
            return;
        }
        android.os.Handler handler = new android.os.Handler(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        long showAfterSec = msgItem.getShowAfterSec() * 1000;
        if (showAfterSec < 0) {
            showAfterSec = 0;
        }
        handler.postDelayed(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView.this.mMsgItem = msgItem;
                    int i = 2;
                    switch (msgItem.getMessageType()) {
                        case 1:
                            com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager.getInstance().addCommand(new com.tencent.ysdk.shell.framework.floatingwindow.AbstractFloatingWindowCommand(i) { // from class: com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView.1.1
                                @Override // com.tencent.ysdk.shell.framework.floatingwindow.AbstractFloatingWindowCommand
                                protected void executeWithTryCatch() {
                                    com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView.this.showWindow();
                                }
                            });
                            com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.reportMsgBoxShowEvent(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.EVENT_POP_SHOW, 0, "showPopView", msgItem.getMessageId(), msgItem.getH5Url());
                            break;
                        case 2:
                            com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager.getInstance().addCommand(new com.tencent.ysdk.shell.framework.floatingwindow.AbstractFloatingWindowCommand(i) { // from class: com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView.1.2
                                @Override // com.tencent.ysdk.shell.framework.floatingwindow.AbstractFloatingWindowCommand
                                protected void executeWithTryCatch() {
                                    com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView.this.showTips();
                                }
                            });
                            com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.reportMsgBoxShowEvent(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.EVENT_TIPS_SHOW, 0, "showTipsView", msgItem.getMessageId(), msgItem.getH5Url());
                            break;
                        case 3:
                            com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView.this.showToast();
                            com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.reportMsgBoxShowEvent(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.EVENT_TOAST_SHOW, 0, "showToast", msgItem.getMessageId(), msgItem.getH5Url());
                            break;
                        case 4:
                            com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager.getInstance().addCommand(new com.tencent.ysdk.shell.framework.floatingwindow.AbstractFloatingWindowCommand(i) { // from class: com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView.1.3
                                @Override // com.tencent.ysdk.shell.framework.floatingwindow.AbstractFloatingWindowCommand
                                protected void executeWithTryCatch() {
                                    com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxView.this.showWebView();
                                }
                            });
                            com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.reportMsgBoxShowEvent(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.EVENT_H5_SHOW, 0, "showH5View", msgItem.getMessageId(), msgItem.getH5Url());
                            break;
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }, showAfterSec);
    }
}
