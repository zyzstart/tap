package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MenuPopupWindow extends android.support.v7.widget.ListPopupWindow implements android.support.v7.widget.MenuItemHoverListener {
    private static final java.lang.String TAG = "MenuPopupWindow";
    private static java.lang.reflect.Method sSetTouchModalMethod;
    private android.support.v7.widget.MenuItemHoverListener mHoverListener;

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static class MenuDropDownListView extends android.support.v7.widget.DropDownListView {
        final int mAdvanceKey;
        private android.support.v7.widget.MenuItemHoverListener mHoverListener;
        private android.view.MenuItem mHoveredMenuItem;
        final int mRetreatKey;

        public MenuDropDownListView(android.content.Context context, boolean z) {
            super(context, z);
            android.content.res.Configuration configuration = context.getResources().getConfiguration();
            if (android.os.Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.mAdvanceKey = 22;
                this.mRetreatKey = 21;
            } else {
                this.mAdvanceKey = 21;
                this.mRetreatKey = 22;
            }
        }

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // android.support.v7.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // android.support.v7.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // android.support.v7.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // android.support.v7.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // android.support.v7.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(android.view.MotionEvent motionEvent, int i) {
            return super.onForwardedEvent(motionEvent, i);
        }

        @Override // android.view.View
        public boolean onHoverEvent(android.view.MotionEvent motionEvent) {
            int headersCount;
            android.support.v7.view.menu.MenuAdapter menuAdapter;
            int iPointToPosition;
            int i;
            if (this.mHoverListener != null) {
                android.widget.ListAdapter adapter = getAdapter();
                if (adapter instanceof android.widget.HeaderViewListAdapter) {
                    android.widget.HeaderViewListAdapter headerViewListAdapter = (android.widget.HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (android.support.v7.view.menu.MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    menuAdapter = (android.support.v7.view.menu.MenuAdapter) adapter;
                }
                android.support.v7.view.menu.MenuItemImpl item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i = iPointToPosition - headersCount) >= 0 && i < menuAdapter.getCount()) {
                    item = menuAdapter.getItem(i);
                }
                android.view.MenuItem menuItem = this.mHoveredMenuItem;
                if (menuItem != item) {
                    android.support.v7.view.menu.MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                    if (menuItem != null) {
                        this.mHoverListener.onItemHoverExit(adapterMenu, menuItem);
                    }
                    this.mHoveredMenuItem = item;
                    if (item != null) {
                        this.mHoverListener.onItemHoverEnter(adapterMenu, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
            android.support.v7.view.menu.ListMenuItemView listMenuItemView = (android.support.v7.view.menu.ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.mAdvanceKey) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i != this.mRetreatKey) {
                return super.onKeyDown(i, keyEvent);
            }
            setSelection(-1);
            ((android.support.v7.view.menu.MenuAdapter) getAdapter()).getAdapterMenu().close(false);
            return true;
        }

        public void setHoverListener(android.support.v7.widget.MenuItemHoverListener menuItemHoverListener) {
            this.mHoverListener = menuItemHoverListener;
        }
    }

    static {
        try {
            sSetTouchModalMethod = android.widget.PopupWindow.class.getDeclaredMethod("setTouchModal", java.lang.Boolean.TYPE);
        } catch (java.lang.NoSuchMethodException unused) {
            android.util.Log.i(TAG, "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.support.v7.widget.ListPopupWindow
    android.support.v7.widget.DropDownListView createDropDownListView(android.content.Context context, boolean z) {
        android.support.v7.widget.MenuPopupWindow.MenuDropDownListView menuDropDownListView = new android.support.v7.widget.MenuPopupWindow.MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    @Override // android.support.v7.widget.MenuItemHoverListener
    public void onItemHoverEnter(@android.support.annotation.NonNull android.support.v7.view.menu.MenuBuilder menuBuilder, @android.support.annotation.NonNull android.view.MenuItem menuItem) {
        android.support.v7.widget.MenuItemHoverListener menuItemHoverListener = this.mHoverListener;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.onItemHoverEnter(menuBuilder, menuItem);
        }
    }

    @Override // android.support.v7.widget.MenuItemHoverListener
    public void onItemHoverExit(@android.support.annotation.NonNull android.support.v7.view.menu.MenuBuilder menuBuilder, @android.support.annotation.NonNull android.view.MenuItem menuItem) {
        android.support.v7.widget.MenuItemHoverListener menuItemHoverListener = this.mHoverListener;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.onItemHoverExit(menuBuilder, menuItem);
        }
    }

    public void setEnterTransition(java.lang.Object obj) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.mPopup.setEnterTransition((android.transition.Transition) obj);
        }
    }

    public void setExitTransition(java.lang.Object obj) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.mPopup.setExitTransition((android.transition.Transition) obj);
        }
    }

    public void setHoverListener(android.support.v7.widget.MenuItemHoverListener menuItemHoverListener) {
        this.mHoverListener = menuItemHoverListener;
    }

    public void setTouchModal(boolean z) {
        java.lang.reflect.Method method = sSetTouchModalMethod;
        if (method != null) {
            try {
                method.invoke(this.mPopup, java.lang.Boolean.valueOf(z));
            } catch (java.lang.Exception unused) {
                android.util.Log.i(TAG, "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }
}
