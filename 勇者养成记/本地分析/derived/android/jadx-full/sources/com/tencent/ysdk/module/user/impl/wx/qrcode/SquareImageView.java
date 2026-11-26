package com.tencent.ysdk.module.user.impl.wx.qrcode;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SquareImageView extends android.widget.ImageView {
    public SquareImageView(android.content.Context context) {
        super(context);
    }

    public SquareImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (i > i2) {
            super.onMeasure(i2, i2);
        } else {
            super.onMeasure(i, i);
        }
    }
}
