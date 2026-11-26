package com.tencent.ysdk.shell.module.icon.impl.bubble;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BubbleCommandImpl extends com.tencent.ysdk.shell.module.icon.impl.bubble.AbstractBubbleCommand {
    private static final long SHOW_BUBBLE_TIMESTAMP_GAP = 5000;
    private com.tencent.ysdk.module.msgbox.MsgItem mMsg;

    public BubbleCommandImpl(com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        this.mMsg = msgItem;
    }

    private void reportBubbleEvent() {
        java.util.HashMap map = new java.util.HashMap();
        map.put("app_name", com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_TYPE, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getAppPkgName());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_VERSION, com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOG_VERSION, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_BUBBLE_TYPE, java.lang.Integer.toString(this.mMsg.getMessageType()));
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_BUBBLE_SHOW, 0, "bubble show", loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), true);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.bubble.AbstractBubbleCommand
    protected void executeInner() {
        com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().showIconBubble(this.mMsg);
        com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.put(com.tencent.ysdk.shell.libware.util.AppSharePreferenceKey.KEY_LAST_SHOW_BUBBLE_TIMESTAMP, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        reportBubbleEvent();
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.bubble.AbstractBubbleCommand
    protected boolean interceptBubble() {
        com.tencent.ysdk.module.msgbox.MsgItem msgItem = this.mMsg;
        if (msgItem == null || msgItem.getMsgAction() == null || this.mMsg.getMsgAction().getActionType() == 0) {
            return true;
        }
        java.lang.Object obj = com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.get(com.tencent.ysdk.shell.libware.util.AppSharePreferenceKey.KEY_LAST_SHOW_BUBBLE_TIMESTAMP, 0L);
        if (obj instanceof java.lang.Long) {
            return java.lang.System.currentTimeMillis() - ((java.lang.Long) obj).longValue() < SHOW_BUBBLE_TIMESTAMP_GAP;
        }
        return true;
    }
}
