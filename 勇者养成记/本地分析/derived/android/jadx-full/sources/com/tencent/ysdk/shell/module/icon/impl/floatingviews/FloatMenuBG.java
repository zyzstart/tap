package com.tencent.ysdk.shell.module.icon.impl.floatingviews;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FloatMenuBG extends android.widget.RelativeLayout {
    private static final java.lang.String UI_ID_REMOVE_VIEW = "com_tencent_ysdk_icon_movetoremove_icon";
    private static final java.lang.String UI_ID_REMOVE_VIEW_CLOSE_CLOSE = "com_tencent_ysdk_icon_close_text";
    private static final java.lang.String UI_ID_REMOVE_VIEW_FOCUS_RES = "com_tencent_ysdk_icon_remove_focus";
    private static final java.lang.String UI_ID_REMOVE_VIEW_RES = "com_tencent_ysdk_icon_remove";
    private static final java.lang.String UI_LAYOUT_VIEW = "com_tencent_ysdk_icon_floatmenu_bg";
    private android.widget.TextView closeAreaText;
    public boolean isAdded;
    private boolean isFocusNow;
    private android.graphics.Rect mRect;
    private android.widget.ImageView moveToRemoveArea;

    public FloatMenuBG(android.content.Context context) {
        super(context);
        this.isAdded = false;
        this.isFocusNow = false;
        this.mRect = new android.graphics.Rect();
        android.view.LayoutInflater.from(context).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_VIEW), this);
        this.moveToRemoveArea = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_REMOVE_VIEW));
        this.closeAreaText = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_REMOVE_VIEW_CLOSE_CLOSE));
    }

    public void changeFocus(boolean z) {
        if (z) {
            if (this.isFocusNow) {
                return;
            }
            this.moveToRemoveArea.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable(UI_ID_REMOVE_VIEW_FOCUS_RES));
            android.view.ViewGroup.LayoutParams layoutParams = this.moveToRemoveArea.getLayoutParams();
            layoutParams.width = 190;
            layoutParams.height = 190;
            this.moveToRemoveArea.setLayoutParams(layoutParams);
            this.closeAreaText.setVisibility(4);
            this.isFocusNow = true;
            return;
        }
        if (this.isFocusNow) {
            this.isFocusNow = false;
            this.moveToRemoveArea.setImageResource(com.tencent.ysdk.shell.libware.ui.res.Res.drawable(UI_ID_REMOVE_VIEW_RES));
            android.view.ViewGroup.LayoutParams layoutParams2 = this.moveToRemoveArea.getLayoutParams();
            layoutParams2.width = com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE;
            layoutParams2.height = com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE;
            this.moveToRemoveArea.setLayoutParams(layoutParams2);
            this.closeAreaText.setVisibility(0);
        }
    }

    public android.graphics.Rect getMoveEdge() {
        this.moveToRemoveArea.getGlobalVisibleRect(this.mRect);
        return this.mRect;
    }

    public boolean isInRange(int i, int i2) {
        return getMoveEdge().contains(i, i2);
    }
}
