package com.tencent.ysdk.module.msgbox;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MsgItem implements java.io.Serializable {
    private java.lang.String bgPicUrl;
    private java.lang.String bussinessId;
    private long duration;
    private java.lang.Long endTime;
    private java.lang.String h5Url;
    private com.tencent.ysdk.module.icon.IBubbleCommand mBubbleCommand;
    private java.lang.String messageId;
    private int messageType;
    private com.tencent.ysdk.module.msgbox.MsgItem.MsgAction msgAction;
    private java.lang.String pushButtonText;
    private java.lang.String pushButtonUrl;
    private long showAfterSec;
    private int showDelaySec;
    private int showFrequency;
    private int showType;
    private java.lang.String text;
    private java.lang.String title;

    public static class MsgAction {
        private int actionType;
        private java.lang.String text;

        public int getActionType() {
            return this.actionType;
        }

        public java.lang.String getText() {
            return this.text;
        }

        public void setActionType(int i) {
            this.actionType = i;
        }

        public void setText(java.lang.String str) {
            this.text = str;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface MsgActionType {
        public static final int NONE = 0;
        public static final int SHOW_ICON_BUBBLE = 1;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface MsgItemType {
        public static final int POP_WINDOW = 1;
        public static final int TIPS_VIEW = 2;
        public static final int TOAST = 3;
        public static final int WEBVIEW = 4;
    }

    public com.tencent.ysdk.module.msgbox.MsgItem cloneSelf() {
        com.tencent.ysdk.module.msgbox.MsgItem msgItem = new com.tencent.ysdk.module.msgbox.MsgItem();
        msgItem.setBgPicUrl(getBgPicUrl());
        msgItem.setEndTime(getEndTime());
        msgItem.setH5Url(getH5Url());
        msgItem.setMessageId(getMessageId());
        msgItem.setMessageType(getMessageType());
        msgItem.setPushButtonText(getPushButtonText());
        msgItem.setPushButtonUrl(getPushButtonUrl());
        msgItem.setShowAfterSec(getShowAfterSec());
        msgItem.setShowDelaySec(getShowDelaySec());
        msgItem.setShowFrequency(getShowFrequency());
        msgItem.setShowType(getShowType());
        msgItem.setText(getText());
        msgItem.setTitle(getTitle());
        msgItem.setBussinessId(getBussinessId());
        msgItem.setDuration(getDuration());
        msgItem.setMsgAction(this.msgAction);
        return msgItem;
    }

    public java.lang.String getBgPicUrl() {
        return this.bgPicUrl;
    }

    public com.tencent.ysdk.module.icon.IBubbleCommand getBubbleCommand() {
        return this.mBubbleCommand;
    }

    public java.lang.String getBussinessId() {
        return this.bussinessId;
    }

    public long getDuration() {
        return this.duration;
    }

    public java.lang.Long getEndTime() {
        return this.endTime;
    }

    public java.lang.String getH5Url() {
        return this.h5Url;
    }

    public java.lang.String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public com.tencent.ysdk.module.msgbox.MsgItem.MsgAction getMsgAction() {
        return this.msgAction;
    }

    public java.lang.String getPushButtonText() {
        return this.pushButtonText;
    }

    public java.lang.String getPushButtonUrl() {
        return this.pushButtonUrl;
    }

    public long getShowAfterSec() {
        return this.showAfterSec;
    }

    public int getShowDelaySec() {
        return this.showDelaySec;
    }

    public int getShowFrequency() {
        return this.showFrequency;
    }

    public int getShowType() {
        return this.showType;
    }

    public java.lang.String getText() {
        return this.text;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setBgPicUrl(java.lang.String str) {
        this.bgPicUrl = str;
    }

    public void setBubbleCommand(com.tencent.ysdk.module.icon.IBubbleCommand iBubbleCommand) {
        this.mBubbleCommand = iBubbleCommand;
    }

    public void setBussinessId(java.lang.String str) {
        this.bussinessId = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setEndTime(java.lang.Long l) {
        this.endTime = l;
    }

    public void setH5Url(java.lang.String str) {
        this.h5Url = str;
    }

    public void setMessageId(java.lang.String str) {
        this.messageId = str;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setMsgAction(com.tencent.ysdk.module.msgbox.MsgItem.MsgAction msgAction) {
        this.msgAction = msgAction;
    }

    public void setPushButtonText(java.lang.String str) {
        this.pushButtonText = str;
    }

    public void setPushButtonUrl(java.lang.String str) {
        this.pushButtonUrl = str;
    }

    public void setShowAfterSec(long j) {
        this.showAfterSec = j;
    }

    public void setShowDelaySec(int i) {
        this.showDelaySec = i;
    }

    public void setShowFrequency(int i) {
        this.showFrequency = i;
    }

    public void setShowType(int i) {
        this.showType = i;
    }

    public void setText(java.lang.String str) {
        this.text = str;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }
}
