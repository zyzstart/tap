package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class AppCompatPopupWindow extends android.widget.PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR;
    private static final java.lang.String TAG = "AppCompatPopupWindow";
    private boolean mOverlapAnchor;

    static {
        COMPAT_OVERLAP_ANCHOR = android.os.Build.VERSION.SDK_INT < 21;
    }

    public AppCompatPopupWindow(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.Nullable android.util.AttributeSet attributeSet, @android.support.annotation.AttrRes int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    public AppCompatPopupWindow(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.Nullable android.util.AttributeSet attributeSet, @android.support.annotation.AttrRes int i, @android.support.annotation.StyleRes int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, i, i2);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, android.support.v7.appcompat.R.styleable.PopupWindow, i, i2);
        if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.PopupWindow_overlapAnchor)) {
            setSupportOverlapAnchor(tintTypedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(android.support.v7.appcompat.R.styleable.PopupWindow_android_popupBackground));
        int i3 = android.os.Build.VERSION.SDK_INT;
        if (i2 != 0 && i3 < 11 && tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.PopupWindow_android_popupAnimationStyle)) {
            setAnimationStyle(tintTypedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.PopupWindow_android_popupAnimationStyle, -1));
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        if (android.os.Build.VERSION.SDK_INT < 14) {
            wrapOnScrollChangedListener(this);
        }
    }

    private static void wrapOnScrollChangedListener(final android.widget.PopupWindow popupWindow) {
        try {
            final java.lang.reflect.Field declaredField = android.widget.PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            java.lang.reflect.Field declaredField2 = android.widget.PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            final android.view.ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = (android.view.ViewTreeObserver.OnScrollChangedListener) declaredField2.get(popupWindow);
            declaredField2.set(popupWindow, new android.view.ViewTreeObserver.OnScrollChangedListener() { // from class: android.support.v7.widget.AppCompatPopupWindow.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    try {
                        java.lang.ref.WeakReference weakReference = (java.lang.ref.WeakReference) declaredField.get(popupWindow);
                        if (weakReference != null && weakReference.get() != null) {
                            onScrollChangedListener.onScrollChanged();
                        }
                    } catch (java.lang.IllegalAccessException unused) {
                    }
                }
            });
        } catch (java.lang.Exception e) {
            android.util.Log.d(TAG, "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean getSupportOverlapAnchor() {
        return COMPAT_OVERLAP_ANCHOR ? this.mOverlapAnchor : android.support.v4.widget.PopupWindowCompat.getOverlapAnchor(this);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportOverlapAnchor(boolean z) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z;
        } else {
            android.support.v4.widget.PopupWindowCompat.setOverlapAnchor(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(android.view.View view, int i, int i2) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(android.view.View view, int i, int i2, int i3) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(android.view.View view, int i, int i2, int i3, int i4) {
        super.update(view, i, (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) ? i2 - view.getHeight() : i2, i3, i4);
    }
}
