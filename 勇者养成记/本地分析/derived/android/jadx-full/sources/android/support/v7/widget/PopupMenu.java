package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PopupMenu {
    private final android.view.View mAnchor;
    private final android.content.Context mContext;
    private android.view.View.OnTouchListener mDragListener;
    private final android.support.v7.view.menu.MenuBuilder mMenu;
    android.support.v7.widget.PopupMenu.OnMenuItemClickListener mMenuItemClickListener;
    android.support.v7.widget.PopupMenu.OnDismissListener mOnDismissListener;
    final android.support.v7.view.menu.MenuPopupHelper mPopup;

    public interface OnDismissListener {
        void onDismiss(android.support.v7.widget.PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(android.view.MenuItem menuItem);
    }

    public PopupMenu(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.view.View view) {
        this(context, view, 0);
    }

    public PopupMenu(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.view.View view, int i) {
        this(context, view, i, android.support.v7.appcompat.R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.view.View view, int i, @android.support.annotation.AttrRes int i2, @android.support.annotation.StyleRes int i3) {
        this.mContext = context;
        this.mAnchor = view;
        this.mMenu = new android.support.v7.view.menu.MenuBuilder(context);
        this.mMenu.setCallback(new android.support.v7.view.menu.MenuBuilder.Callback() { // from class: android.support.v7.widget.PopupMenu.1
            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(android.support.v7.view.menu.MenuBuilder menuBuilder, android.view.MenuItem menuItem) {
                if (android.support.v7.widget.PopupMenu.this.mMenuItemClickListener != null) {
                    return android.support.v7.widget.PopupMenu.this.mMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }

            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(android.support.v7.view.menu.MenuBuilder menuBuilder) {
            }
        });
        this.mPopup = new android.support.v7.view.menu.MenuPopupHelper(context, this.mMenu, view, false, i2, i3);
        this.mPopup.setGravity(i);
        this.mPopup.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.PopupMenu.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (android.support.v7.widget.PopupMenu.this.mOnDismissListener != null) {
                    android.support.v7.widget.PopupMenu.this.mOnDismissListener.onDismiss(android.support.v7.widget.PopupMenu.this);
                }
            }
        });
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    @android.support.annotation.NonNull
    public android.view.View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new android.support.v7.widget.ForwardingListener(this.mAnchor) { // from class: android.support.v7.widget.PopupMenu.3
                @Override // android.support.v7.widget.ForwardingListener
                public android.support.v7.view.menu.ShowableListMenu getPopup() {
                    return android.support.v7.widget.PopupMenu.this.mPopup.getPopup();
                }

                @Override // android.support.v7.widget.ForwardingListener
                protected boolean onForwardingStarted() {
                    android.support.v7.widget.PopupMenu.this.show();
                    return true;
                }

                @Override // android.support.v7.widget.ForwardingListener
                protected boolean onForwardingStopped() {
                    android.support.v7.widget.PopupMenu.this.dismiss();
                    return true;
                }
            };
        }
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    @android.support.annotation.NonNull
    public android.view.Menu getMenu() {
        return this.mMenu;
    }

    @android.support.annotation.NonNull
    public android.view.MenuInflater getMenuInflater() {
        return new android.support.v7.view.SupportMenuInflater(this.mContext);
    }

    public void inflate(@android.support.annotation.MenuRes int i) {
        getMenuInflater().inflate(i, this.mMenu);
    }

    public void setGravity(int i) {
        this.mPopup.setGravity(i);
    }

    public void setOnDismissListener(@android.support.annotation.Nullable android.support.v7.widget.PopupMenu.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnMenuItemClickListener(@android.support.annotation.Nullable android.support.v7.widget.PopupMenu.OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public void show() {
        this.mPopup.show();
    }
}
