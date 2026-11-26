package com.tencent.ysdk.shell.module.icon.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconModuleStat {
    public static final java.lang.String EVENT_CAPTURE_SCREEN_CLICK = "YSDK_Icon_CAPTURE_CLICK";
    public static final java.lang.String EVENT_FLOAT_HEAD_ICON_ONCLICK = "YSDK_Icon_HEAD_ONCLICK";
    public static final java.lang.String EVENT_FLOAT_ITEM_FLIPE = "YSDK_Icon_REOPEN_ICON";
    public static final java.lang.String EVENT_FLOAT_ITEM_ONCLICK = "YSDK_Icon_ITEM_ONCLICK";
    public static final java.lang.String EVENT_FLOAT_SHOW = "YSDK_Icon_FLOAT_SHOW";
    public static final java.lang.String EVENT_FLOAT_TAB_DURATION = "YSDK_Icon_FLOAT_TAB_DURATION";
    public static final java.lang.String EVENT_FLOAT_WINDOW_DURATION = "YSDK_Icon_FLOAT_WINDOW_DURATION";
    public static final java.lang.String EVENT_FLOAT_WINDOW_PAGE_ID = "1";
    public static final java.lang.String EVENT_ICON_CLICK = "YSDK_Icon_CLICK_ICON";
    public static final java.lang.String EVENT_ICON_CLOSE_WINDOW_CLOSE = "YSDK_Icon_Close_Window_Close";
    public static final java.lang.String EVENT_ICON_CLOSE_WINDOW_EXPOSURE = "YSDK_Icon_Close_Window_Exposure";
    public static final java.lang.String EVENT_ICON_MOVE = "YSDK_Icon_Move_Icon";
    public static final java.lang.String EVENT_ICON_REMOVE = "YSDK_Icon_REMOVE_ICON";
    public static final java.lang.String EVENT_ICON_SHOW = "YSDK_Icon_SHOW_ICON";
    public static final java.lang.String EVENT_SHARE_API = "YSDK_Icon_SHARE_API";
    public static final java.lang.String EVENT_SHARE_CALLBACK = "YSDK_Icon_SHARE_PANEL_CALLBACK";
    public static final java.lang.String EVENT_SHARE_CLICK = "YSDK_Icon_SHARE_CLICK";
    public static final java.lang.String EVENT_SHARE_OPEN = "YSDK_Icon_SHARE_PANEL_OPEN";
    public static final java.lang.String PARAM_FLOAT_FIRST_ICON = "firstIconName";
    public static final java.lang.String PARAM_FLOAT_WINDOW_HEAD_TARGET = "floatHead";
    public static final java.lang.String PARAM_FLOAT_WINDOW_TAB_TARGET = "floatTab";
    public static final java.lang.String PARAM_FLOAT_WINDOW_TARGET = "floatWindow";
    public static final java.lang.String PARAM_ICON_CLOSE_WINDOW_CHECKBOX_CHOOSE = "chooseNoTips";
    public static final java.lang.String PARAM_ICON_CLOSE_WINDOW_CHECKBOX_SHOW = "showNoTipsBox";
    public static final java.lang.String PARAM_ICON_CLOSE_WINDOW_RESULT = "closeResult";
    public static final java.lang.String PARAM_ICON_MOVE_AFT_POSITION = "iconAftPosition";
    public static final java.lang.String PARAM_ICON_MOVE_PRE_POSITION = "iconPrePosition";
    public static final java.lang.String PARAM_ICON_TRAGET = "icon";
    public static final java.lang.String PARAM_NEED_SHOW_FIRST_ICON = "needShowFirstIcon";
    public static final java.lang.String PARA_FLOAT_DURATION = "showDuration";
    public static final java.lang.String PARA_FLOAT_ITEM_NAME = "iconName";
    public static final java.lang.String PARA_FLOAT_ITEM_URL = "loadH5";
    public static final java.lang.String PARA_SHARE_CHANNEL = "shareChannel";
    public static final java.lang.String PARA_SHARE_ERR_CODE = "errCode";
    public static final java.lang.String PARA_SHARE_ERR_MSG = "errMsg";
    public static final java.lang.String PARA_SHARE_EXTINFO = "extInfo";
    public static final java.lang.String PARA_SHARE_FROM = "isScreenCap";
    public static final java.lang.String PARA_SHARE_RESULT = "shareResult";

    public static class IconEventParams {
        private java.lang.String eventName;
        private java.util.Map<java.lang.String, java.lang.String> eventParams;
        private java.lang.String eventTarget;
        private com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType;
        private int flag;
        private java.lang.String pageId;
        private com.tencent.ysdk.shell.module.stat.StatConstants.PageType pageType;
        private java.lang.String pvId;
        private java.lang.String retDetail;

        public void setEventName(java.lang.String str) {
            this.eventName = str;
        }

        public void setEventParams(java.util.Map<java.lang.String, java.lang.String> map) {
            this.eventParams = map;
        }

        public void setEventTarget(java.lang.String str) {
            this.eventTarget = str;
        }

        public void setEventType(com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType) {
            this.eventType = eventType;
        }

        public void setFlag(int i) {
            this.flag = i;
        }

        public void setPageId(java.lang.String str) {
            this.pageId = str;
        }

        public void setPageType(com.tencent.ysdk.shell.module.stat.StatConstants.PageType pageType) {
            this.pageType = pageType;
        }

        public void setPvId(java.lang.String str) {
            this.pvId = str;
        }

        public void setRetDetail(java.lang.String str) {
            this.retDetail = str;
        }
    }

    public static void reportIconBasicEvent(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        reportIconEvent(str, i, str2, loginRecord.platform, loginRecord.open_id, map);
    }

    public static void reportIconEvent(java.lang.String str, int i, java.lang.String str2, int i2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map) {
        (map != null ? map : new java.util.HashMap<>()).put("icon_version", com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance().getIconVersion());
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(str, i, str2, i2, str3, map, java.lang.System.currentTimeMillis(), true);
    }

    public static void reportIconEvent(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType, java.lang.String str3) {
        (map != null ? map : new java.util.HashMap<>()).put("icon_version", com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance().getIconVersion());
        com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(str, i, str2, map, java.lang.System.currentTimeMillis() / 1000, true, eventType, str3);
    }

    public static void reportIconPageEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.IconEventParams iconEventParams) {
        if (iconEventParams.eventParams == null) {
            iconEventParams.eventParams = new java.util.HashMap();
        }
        iconEventParams.eventParams.put("icon_version", com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance().getIconVersion());
        com.tencent.ysdk.shell.module.stat.StatHelper.reportPageData(iconEventParams.eventName, iconEventParams.flag, iconEventParams.retDetail, iconEventParams.eventParams, java.lang.System.currentTimeMillis() / 1000, true, iconEventParams.pageType, iconEventParams.pageId, iconEventParams.pvId, iconEventParams.eventType, iconEventParams.eventTarget);
    }
}
