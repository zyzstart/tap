package com.tencent.ysdk.shell.module.icon.impl.floatingviews;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FloatMenu {
    private static com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu instance;
    private java.util.List<com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem> mMenuItems;
    private java.lang.String mMenuTag;
    private java.lang.String mMenuUrl;
    private java.lang.String mMenuVersion;
    private int mMsgNum;
    private boolean mIconIsNew = false;
    private boolean mIconCanBeShowed = false;
    private boolean mSandboxIconCanBeShowed = true;

    private FloatMenu() {
    }

    public static com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu getMenuInstance() {
        if (instance == null) {
            instance = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu();
        }
        return instance;
    }

    public boolean getIconIsNew() {
        if (getMenuItems() == null) {
            return false;
        }
        for (com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem menuItem : this.mMenuItems) {
            if (com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.needShowRedPoint(menuItem.getIconID(), menuItem.getTs())) {
                return true;
            }
        }
        return false;
    }

    public java.util.List<com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem> getMenuItems() {
        return this.mMenuItems;
    }

    public java.lang.String getMenuTag() {
        return this.mMenuTag;
    }

    public java.lang.String getMenuUrl() {
        return this.mMenuUrl;
    }

    public java.lang.String getMenuVersion() {
        return this.mMenuVersion;
    }

    public int getMsgNum() {
        return this.mMsgNum;
    }

    public boolean isIconCanBeShowed() {
        return this.mIconCanBeShowed;
    }

    public boolean isSandboxIconCanBeShowed() {
        return this.mSandboxIconCanBeShowed;
    }

    public void setIconCanBeShowed(boolean z) {
        this.mIconCanBeShowed = z;
    }

    public void setIconIsNew(boolean z) {
        this.mIconIsNew = z;
    }

    public void setMenuItems(java.util.List<com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem> list) {
        this.mMenuItems = list;
    }

    public void setMenuTag(java.lang.String str) {
        this.mMenuTag = str;
    }

    public void setMenuUrl(java.lang.String str) {
        this.mMenuUrl = str;
    }

    public void setMenuVersion(java.lang.String str) {
        this.mMenuVersion = str;
    }

    public void setMsgNum(int i) {
        this.mMsgNum = i;
    }

    public void setSandboxIconCanBeShowed(boolean z) {
        this.mSandboxIconCanBeShowed = z;
    }
}
