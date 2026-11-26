package android.support.v7.view.menu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MenuPopupHelper implements android.support.v7.view.menu.MenuHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private android.view.View mAnchorView;
    private final android.content.Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final android.widget.PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final android.support.v7.view.menu.MenuBuilder mMenu;
    private android.widget.PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private android.support.v7.view.menu.MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private android.support.v7.view.menu.MenuPresenter.Callback mPresenterCallback;

    public MenuPopupHelper(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.support.v7.view.menu.MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, android.support.v7.appcompat.R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.support.v7.view.menu.MenuBuilder menuBuilder, @android.support.annotation.NonNull android.view.View view) {
        this(context, menuBuilder, view, false, android.support.v7.appcompat.R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.support.v7.view.menu.MenuBuilder menuBuilder, @android.support.annotation.NonNull android.view.View view, boolean z, @android.support.annotation.AttrRes int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.support.v7.view.menu.MenuBuilder menuBuilder, @android.support.annotation.NonNull android.view.View view, boolean z, @android.support.annotation.AttrRes int i, @android.support.annotation.StyleRes int i2) {
        this.mDropDownGravity = android.support.v4.view.GravityCompat.START;
        this.mInternalOnDismissListener = new android.widget.PopupWindow.OnDismissListener() { // from class: android.support.v7.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                android.support.v7.view.menu.MenuPopupHelper.this.onDismiss();
            }
        };
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
    }

    @android.support.annotation.NonNull
    private android.support.v7.view.menu.MenuPopup createPopup() {
        android.view.Display defaultDisplay = ((android.view.WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        android.graphics.Point point = new android.graphics.Point();
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        android.support.v7.view.menu.MenuPopup cascadingMenuPopup = java.lang.Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(android.support.v7.appcompat.R.dimen.abc_cascading_menus_min_smallest_width) ? new android.support.v7.view.menu.CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly) : new android.support.v7.view.menu.StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        cascadingMenuPopup.addMenu(this.mMenu);
        cascadingMenuPopup.setOnDismissListener(this.mInternalOnDismissListener);
        cascadingMenuPopup.setAnchorView(this.mAnchorView);
        cascadingMenuPopup.setCallback(this.mPresenterCallback);
        cascadingMenuPopup.setForceShowIcon(this.mForceShowIcon);
        cascadingMenuPopup.setGravity(this.mDropDownGravity);
        return cascadingMenuPopup;
    }

    private void showPopup(int i, int i2, boolean z, boolean z2) {
        android.support.v7.view.menu.MenuPopup popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            if ((android.support.v4.view.GravityCompat.getAbsoluteGravity(this.mDropDownGravity, android.support.v4.view.ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) == 5) {
                i += this.mAnchorView.getWidth();
            }
            popup.setHorizontalOffset(i);
            popup.setVerticalOffset(i2);
            int i3 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.setEpicenterBounds(new android.graphics.Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        popup.show();
    }

    @Override // android.support.v7.view.menu.MenuHelper
    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    @android.support.annotation.NonNull
    public android.support.v7.view.menu.MenuPopup getPopup() {
        if (this.mPopup == null) {
            this.mPopup = createPopup();
        }
        return this.mPopup;
    }

    public boolean isShowing() {
        android.support.v7.view.menu.MenuPopup menuPopup = this.mPopup;
        return menuPopup != null && menuPopup.isShowing();
    }

    protected void onDismiss() {
        this.mPopup = null;
        android.widget.PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(@android.support.annotation.NonNull android.view.View view) {
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
        android.support.v7.view.menu.MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setForceShowIcon(z);
        }
    }

    public void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void setOnDismissListener(@android.support.annotation.Nullable android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // android.support.v7.view.menu.MenuHelper
    public void setPresenterCallback(@android.support.annotation.Nullable android.support.v7.view.menu.MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
        android.support.v7.view.menu.MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new java.lang.IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void show(int i, int i2) {
        if (!tryShow(i, i2)) {
            throw new java.lang.IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(0, 0, false, false);
        return true;
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(i, i2, true, true);
        return true;
    }
}
