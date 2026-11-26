package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class ActionMenuPresenter extends android.support.v7.view.menu.BaseMenuPresenter implements android.support.v4.view.ActionProvider.SubUiVisibilityListener {
    private static final java.lang.String TAG = "ActionMenuPresenter";
    private final android.util.SparseBooleanArray mActionButtonGroups;
    android.support.v7.widget.ActionMenuPresenter.ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton mOverflowButton;
    android.support.v7.widget.ActionMenuPresenter.OverflowPopup mOverflowPopup;
    private android.graphics.drawable.Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private android.support.v7.widget.ActionMenuPresenter.ActionMenuPopupCallback mPopupCallback;
    final android.support.v7.widget.ActionMenuPresenter.PopupPresenterCallback mPopupPresenterCallback;
    android.support.v7.widget.ActionMenuPresenter.OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private android.view.View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    private class ActionButtonSubmenu extends android.support.v7.view.menu.MenuPopupHelper {
        public ActionButtonSubmenu(android.content.Context context, android.support.v7.view.menu.SubMenuBuilder subMenuBuilder, android.view.View view) {
            super(context, subMenuBuilder, view, false, android.support.v7.appcompat.R.attr.actionOverflowMenuStyle);
            if (!((android.support.v7.view.menu.MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                setAnchorView(android.support.v7.widget.ActionMenuPresenter.this.mOverflowButton == null ? (android.view.View) android.support.v7.widget.ActionMenuPresenter.this.mMenuView : android.support.v7.widget.ActionMenuPresenter.this.mOverflowButton);
            }
            setPresenterCallback(android.support.v7.widget.ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        @Override // android.support.v7.view.menu.MenuPopupHelper
        protected void onDismiss() {
            android.support.v7.widget.ActionMenuPresenter actionMenuPresenter = android.support.v7.widget.ActionMenuPresenter.this;
            actionMenuPresenter.mActionButtonPopup = null;
            actionMenuPresenter.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    private class ActionMenuPopupCallback extends android.support.v7.view.menu.ActionMenuItemView.PopupCallback {
        ActionMenuPopupCallback() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.PopupCallback
        public android.support.v7.view.menu.ShowableListMenu getPopup() {
            if (android.support.v7.widget.ActionMenuPresenter.this.mActionButtonPopup != null) {
                return android.support.v7.widget.ActionMenuPresenter.this.mActionButtonPopup.getPopup();
            }
            return null;
        }
    }

    private class OpenOverflowRunnable implements java.lang.Runnable {
        private android.support.v7.widget.ActionMenuPresenter.OverflowPopup mPopup;

        public OpenOverflowRunnable(android.support.v7.widget.ActionMenuPresenter.OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (android.support.v7.widget.ActionMenuPresenter.this.mMenu != null) {
                android.support.v7.widget.ActionMenuPresenter.this.mMenu.changeMenuMode();
            }
            android.view.View view = (android.view.View) android.support.v7.widget.ActionMenuPresenter.this.mMenuView;
            if (view != null && view.getWindowToken() != null && this.mPopup.tryShow()) {
                android.support.v7.widget.ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }
            android.support.v7.widget.ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    private class OverflowMenuButton extends android.support.v7.widget.AppCompatImageView implements android.support.v7.widget.ActionMenuView.ActionMenuChildView {
        private final float[] mTempPts;

        public OverflowMenuButton(android.content.Context context) {
            super(context, null, android.support.v7.appcompat.R.attr.actionOverflowButtonStyle);
            this.mTempPts = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            android.support.v7.widget.TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new android.support.v7.widget.ForwardingListener(this) { // from class: android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton.1
                @Override // android.support.v7.widget.ForwardingListener
                public android.support.v7.view.menu.ShowableListMenu getPopup() {
                    if (android.support.v7.widget.ActionMenuPresenter.this.mOverflowPopup == null) {
                        return null;
                    }
                    return android.support.v7.widget.ActionMenuPresenter.this.mOverflowPopup.getPopup();
                }

                @Override // android.support.v7.widget.ForwardingListener
                public boolean onForwardingStarted() {
                    android.support.v7.widget.ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                @Override // android.support.v7.widget.ForwardingListener
                public boolean onForwardingStopped() {
                    if (android.support.v7.widget.ActionMenuPresenter.this.mPostedOpenRunnable != null) {
                        return false;
                    }
                    android.support.v7.widget.ActionMenuPresenter.this.hideOverflowMenu();
                    return true;
                }
            });
        }

        @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            android.support.v7.widget.ActionMenuPresenter.this.showOverflowMenu();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            android.graphics.drawable.Drawable drawable = getDrawable();
            android.graphics.drawable.Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = java.lang.Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.graphics.drawable.DrawableCompat.setHotspotBounds(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    private class OverflowPopup extends android.support.v7.view.menu.MenuPopupHelper {
        public OverflowPopup(android.content.Context context, android.support.v7.view.menu.MenuBuilder menuBuilder, android.view.View view, boolean z) {
            super(context, menuBuilder, view, z, android.support.v7.appcompat.R.attr.actionOverflowMenuStyle);
            setGravity(android.support.v4.view.GravityCompat.END);
            setPresenterCallback(android.support.v7.widget.ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        @Override // android.support.v7.view.menu.MenuPopupHelper
        protected void onDismiss() {
            if (android.support.v7.widget.ActionMenuPresenter.this.mMenu != null) {
                android.support.v7.widget.ActionMenuPresenter.this.mMenu.close();
            }
            android.support.v7.widget.ActionMenuPresenter.this.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    private class PopupPresenterCallback implements android.support.v7.view.menu.MenuPresenter.Callback {
        PopupPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof android.support.v7.view.menu.SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            android.support.v7.view.menu.MenuPresenter.Callback callback = android.support.v7.widget.ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(android.support.v7.view.menu.MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            android.support.v7.widget.ActionMenuPresenter.this.mOpenSubMenuId = ((android.support.v7.view.menu.SubMenuBuilder) menuBuilder).getItem().getItemId();
            android.support.v7.view.menu.MenuPresenter.Callback callback = android.support.v7.widget.ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }
    }

    private static class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v7.widget.ActionMenuPresenter.SavedState> CREATOR = new android.os.Parcelable.Creator<android.support.v7.widget.ActionMenuPresenter.SavedState>() { // from class: android.support.v7.widget.ActionMenuPresenter.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v7.widget.ActionMenuPresenter.SavedState createFromParcel(android.os.Parcel parcel) {
                return new android.support.v7.widget.ActionMenuPresenter.SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v7.widget.ActionMenuPresenter.SavedState[] newArray(int i) {
                return new android.support.v7.widget.ActionMenuPresenter.SavedState[i];
            }
        };
        public int openSubMenuId;

        SavedState() {
        }

        SavedState(android.os.Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    public ActionMenuPresenter(android.content.Context context) {
        super(context, android.support.v7.appcompat.R.layout.abc_action_menu_layout, android.support.v7.appcompat.R.layout.abc_action_menu_item_layout);
        this.mActionButtonGroups = new android.util.SparseBooleanArray();
        this.mPopupPresenterCallback = new android.support.v7.widget.ActionMenuPresenter.PopupPresenterCallback();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private android.view.View findViewForItem(android.view.MenuItem menuItem) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof android.support.v7.view.menu.MenuView.ItemView) && ((android.support.v7.view.menu.MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public void bindItemView(android.support.v7.view.menu.MenuItemImpl menuItemImpl, android.support.v7.view.menu.MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        android.support.v7.view.menu.ActionMenuItemView actionMenuItemView = (android.support.v7.view.menu.ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((android.support.v7.widget.ActionMenuView) this.mMenuView);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new android.support.v7.widget.ActionMenuPresenter.ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(android.view.ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.mOverflowButton) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public boolean flagActionItems() {
        java.util.ArrayList<android.support.v7.view.menu.MenuItemImpl> visibleItems;
        int size;
        int i;
        int iMeasureChildForCells;
        int i2;
        boolean z;
        android.support.v7.widget.ActionMenuPresenter actionMenuPresenter = this;
        int i3 = 0;
        if (actionMenuPresenter.mMenu != null) {
            visibleItems = actionMenuPresenter.mMenu.getVisibleItems();
            size = visibleItems.size();
        } else {
            visibleItems = null;
            size = 0;
        }
        int i4 = actionMenuPresenter.mMaxItems;
        int i5 = actionMenuPresenter.mActionItemWidthLimit;
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) actionMenuPresenter.mMenuView;
        int i6 = i4;
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            android.support.v7.view.menu.MenuItemImpl menuItemImpl = visibleItems.get(i9);
            if (menuItemImpl.requiresActionButton()) {
                i7++;
            } else if (menuItemImpl.requestsActionButton()) {
                i8++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.mExpandedActionViewsExclusive && menuItemImpl.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (actionMenuPresenter.mReserveOverflow && (z2 || i8 + i7 > i6)) {
            i6--;
        }
        int i10 = i6 - i7;
        android.util.SparseBooleanArray sparseBooleanArray = actionMenuPresenter.mActionButtonGroups;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.mStrictWidthLimit) {
            int i11 = actionMenuPresenter.mMinCellSize;
            iMeasureChildForCells = i5 / i11;
            i = i11 + ((i5 % i11) / iMeasureChildForCells);
        } else {
            i = 0;
            iMeasureChildForCells = 0;
        }
        int i12 = i5;
        int i13 = 0;
        int i14 = 0;
        while (i13 < size) {
            android.support.v7.view.menu.MenuItemImpl menuItemImpl2 = visibleItems.get(i13);
            if (menuItemImpl2.requiresActionButton()) {
                android.view.View itemView = actionMenuPresenter.getItemView(menuItemImpl2, actionMenuPresenter.mScrapActionButtonView, viewGroup);
                if (actionMenuPresenter.mScrapActionButtonView == null) {
                    actionMenuPresenter.mScrapActionButtonView = itemView;
                }
                if (actionMenuPresenter.mStrictWidthLimit) {
                    iMeasureChildForCells -= android.support.v7.widget.ActionMenuView.measureChildForCells(itemView, i, iMeasureChildForCells, iMakeMeasureSpec, i3);
                } else {
                    itemView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                i12 -= measuredWidth;
                if (i14 != 0) {
                    measuredWidth = i14;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                menuItemImpl2.setIsActionButton(z);
                i2 = size;
                i14 = measuredWidth;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i10 > 0 || z3) && i12 > 0 && (!actionMenuPresenter.mStrictWidthLimit || iMeasureChildForCells > 0);
                if (z4) {
                    boolean z5 = z4;
                    android.view.View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, actionMenuPresenter.mScrapActionButtonView, viewGroup);
                    i2 = size;
                    if (actionMenuPresenter.mScrapActionButtonView == null) {
                        actionMenuPresenter.mScrapActionButtonView = itemView2;
                    }
                    if (actionMenuPresenter.mStrictWidthLimit) {
                        int iMeasureChildForCells2 = android.support.v7.widget.ActionMenuView.measureChildForCells(itemView2, i, iMeasureChildForCells, iMakeMeasureSpec, 0);
                        iMeasureChildForCells -= iMeasureChildForCells2;
                        if (iMeasureChildForCells2 == 0) {
                            z5 = false;
                        }
                    } else {
                        itemView2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i12 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z4 = actionMenuPresenter.mStrictWidthLimit ? z5 & (i12 >= 0) : z5 & (i12 + i14 > 0);
                } else {
                    i2 = size;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        android.support.v7.view.menu.MenuItemImpl menuItemImpl3 = visibleItems.get(i15);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i10++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                }
                if (z4) {
                    i10--;
                }
                menuItemImpl2.setIsActionButton(z4);
            } else {
                i2 = size;
                menuItemImpl2.setIsActionButton(false);
            }
            i13++;
            size = i2;
            actionMenuPresenter = this;
            i3 = 0;
        }
        return true;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public android.view.View getItemView(android.support.v7.view.menu.MenuItemImpl menuItemImpl, android.view.View view, android.view.ViewGroup viewGroup) {
        android.view.View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        android.support.v7.widget.ActionMenuView actionMenuView = (android.support.v7.widget.ActionMenuView) viewGroup;
        android.view.ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public android.support.v7.view.menu.MenuView getMenuView(android.view.ViewGroup viewGroup) {
        android.support.v7.view.menu.MenuView menuView = this.mMenuView;
        android.support.v7.view.menu.MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((android.support.v7.widget.ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    public android.graphics.drawable.Drawable getOverflowIcon() {
        android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.mPendingOverflowIconSet) {
            return this.mPendingOverflowIcon;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        if (this.mPostedOpenRunnable != null && this.mMenuView != null) {
            ((android.view.View) this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
            this.mPostedOpenRunnable = null;
            return true;
        }
        android.support.v7.widget.ActionMenuPresenter.OverflowPopup overflowPopup = this.mOverflowPopup;
        if (overflowPopup == null) {
            return false;
        }
        overflowPopup.dismiss();
        return true;
    }

    public boolean hideSubMenus() {
        android.support.v7.widget.ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = this.mActionButtonPopup;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.dismiss();
        return true;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public void initForMenu(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.Nullable android.support.v7.view.menu.MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        android.content.res.Resources resources = context.getResources();
        android.support.v7.view.ActionBarPolicy actionBarPolicy = android.support.v7.view.ActionBarPolicy.get(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = actionBarPolicy.getMaxActionButtons();
        }
        int measuredWidth = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton(this.mSystemContext);
                if (this.mPendingOverflowIconSet) {
                    this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = measuredWidth;
        this.mMinCellSize = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.mScrapActionButtonView = null;
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        android.support.v7.widget.ActionMenuPresenter.OverflowPopup overflowPopup = this.mOverflowPopup;
        return overflowPopup != null && overflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(menuBuilder, z);
    }

    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = android.support.v7.view.ActionBarPolicy.get(this.mContext).getMaxActionButtons();
        }
        if (this.mMenu != null) {
            this.mMenu.onItemsChanged(true);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        android.view.MenuItem menuItemFindItem;
        if (parcelable instanceof android.support.v7.widget.ActionMenuPresenter.SavedState) {
            android.support.v7.widget.ActionMenuPresenter.SavedState savedState = (android.support.v7.widget.ActionMenuPresenter.SavedState) parcelable;
            if (savedState.openSubMenuId <= 0 || (menuItemFindItem = this.mMenu.findItem(savedState.openSubMenuId)) == null) {
                return;
            }
            onSubMenuSelected((android.support.v7.view.menu.SubMenuBuilder) menuItemFindItem.getSubMenu());
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public android.os.Parcelable onSaveInstanceState() {
        android.support.v7.widget.ActionMenuPresenter.SavedState savedState = new android.support.v7.widget.ActionMenuPresenter.SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(android.support.v7.view.menu.SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        android.support.v7.view.menu.SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (android.support.v7.view.menu.SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        android.view.View viewFindViewForItem = findViewForItem(subMenuBuilder2.getItem());
        if (viewFindViewForItem == null) {
            return false;
        }
        this.mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        for (int i = 0; i < size; i++) {
            android.view.MenuItem item = subMenuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        this.mActionButtonPopup = new android.support.v7.widget.ActionMenuPresenter.ActionButtonSubmenu(this.mContext, subMenuBuilder, viewFindViewForItem);
        this.mActionButtonPopup.setForceShowIcon(z);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    @Override // android.support.v4.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else if (this.mMenu != null) {
            this.mMenu.close(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mExpandedActionViewsExclusive = z;
    }

    public void setItemLimit(int i) {
        this.mMaxItems = i;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(android.support.v7.widget.ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setOverflowIcon(android.graphics.drawable.Drawable drawable) {
        android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            this.mPendingOverflowIconSet = true;
            this.mPendingOverflowIcon = drawable;
        }
    }

    public void setReserveOverflow(boolean z) {
        this.mReserveOverflow = z;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.mWidthLimit = i;
        this.mStrictWidthLimit = z;
        this.mWidthLimitSet = true;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int i, android.support.v7.view.menu.MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        if (!this.mReserveOverflow || isOverflowMenuShowing() || this.mMenu == null || this.mMenuView == null || this.mPostedOpenRunnable != null || this.mMenu.getNonActionItems().isEmpty()) {
            return false;
        }
        this.mPostedOpenRunnable = new android.support.v7.widget.ActionMenuPresenter.OpenOverflowRunnable(new android.support.v7.widget.ActionMenuPresenter.OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
        ((android.view.View) this.mMenuView).post(this.mPostedOpenRunnable);
        super.onSubMenuSelected(null);
        return true;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((android.view.View) this.mMenuView).requestLayout();
        boolean z2 = false;
        if (this.mMenu != null) {
            java.util.ArrayList<android.support.v7.view.menu.MenuItemImpl> actionItems = this.mMenu.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                android.support.v4.view.ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        java.util.ArrayList<android.support.v7.view.menu.MenuItemImpl> nonActionItems = this.mMenu != null ? this.mMenu.getNonActionItems() : null;
        if (this.mReserveOverflow && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton(this.mSystemContext);
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.mOverflowButton);
                }
                android.support.v7.widget.ActionMenuView actionMenuView = (android.support.v7.widget.ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.mOverflowButton, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton overflowMenuButton = this.mOverflowButton;
            if (overflowMenuButton != null && overflowMenuButton.getParent() == this.mMenuView) {
                ((android.view.ViewGroup) this.mMenuView).removeView(this.mOverflowButton);
            }
        }
        ((android.support.v7.widget.ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
