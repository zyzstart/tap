package com.tencent.ysdk.shell.module.icon.impl.floatingviews;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MenuItemView extends android.widget.RelativeLayout {
    private static final java.lang.String UI_ID_ITEM = "com_tencent_ysdk_icon_item_icon";
    private static final java.lang.String UI_ID_RED = "com_tencent_ysdk_icon_item_red";
    private static final java.lang.String UI_ID_WORD = "com_tencent_ysdk_icon_item_word";
    private static final java.lang.String UI_LAYOUT_ITEM_VIEW = "com_tencent_ysdk_icon_item_view";
    protected android.widget.ImageView itemIcon;
    protected android.widget.ImageView itemRed;
    protected android.widget.TextView itemWord;

    public MenuItemView(android.content.Context context) {
        super(context);
        android.view.LayoutInflater.from(context).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_ITEM_VIEW), this);
        initView();
    }

    private void initView() {
        this.itemIcon = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ITEM));
        this.itemWord = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_WORD));
        this.itemRed = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_RED));
    }

    public void setRed(boolean z) {
        if (z) {
            this.itemRed.setVisibility(0);
        } else {
            this.itemRed.setVisibility(4);
        }
    }
}
