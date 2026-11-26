package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ActionMenuView extends android.support.v7.widget.LinearLayoutCompat implements android.support.v7.view.menu.MenuBuilder.ItemInvoker, android.support.v7.view.menu.MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final java.lang.String TAG = "ActionMenuView";
    private android.support.v7.view.menu.MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private android.support.v7.view.menu.MenuBuilder mMenu;
    android.support.v7.view.menu.MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    android.support.v7.widget.ActionMenuView.OnMenuItemClickListener mOnMenuItemClickListener;
    private android.content.Context mPopupContext;
    private int mPopupTheme;
    private android.support.v7.widget.ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    private static class ActionMenuPresenterCallback implements android.support.v7.view.menu.MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z) {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(android.support.v7.view.menu.MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {

        @android.view.ViewDebug.ExportedProperty
        public int cellsUsed;

        @android.view.ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;

        @android.view.ViewDebug.ExportedProperty
        public int extraPixels;

        @android.view.ViewDebug.ExportedProperty
        public boolean isOverflowButton;

        @android.view.ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }

        LayoutParams(int i, int i2, boolean z) {
            super(i, i2);
            this.isOverflowButton = z;
        }

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.support.v7.widget.ActionMenuView.LayoutParams layoutParams) {
            super((android.view.ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class MenuBuilderCallback implements android.support.v7.view.menu.MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(android.support.v7.view.menu.MenuBuilder menuBuilder, android.view.MenuItem menuItem) {
            return android.support.v7.widget.ActionMenuView.this.mOnMenuItemClickListener != null && android.support.v7.widget.ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(android.support.v7.view.menu.MenuBuilder menuBuilder) {
            if (android.support.v7.widget.ActionMenuView.this.mMenuBuilderCallback != null) {
                android.support.v7.widget.ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(android.view.MenuItem menuItem);
    }

    public ActionMenuView(android.content.Context context) {
        this(context, null);
    }

    public ActionMenuView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (f * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    static int measureChildForCells(android.view.View view, int i, int i2, int i3, int i4) {
        android.support.v7.widget.ActionMenuView.LayoutParams layoutParams = (android.support.v7.widget.ActionMenuView.LayoutParams) view.getLayoutParams();
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i3) - i4, android.view.View.MeasureSpec.getMode(i3));
        android.support.v7.view.menu.ActionMenuItemView actionMenuItemView = view instanceof android.support.v7.view.menu.ActionMenuItemView ? (android.support.v7.view.menu.ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.hasText();
        int i5 = 2;
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z || i6 >= 2) {
                i5 = i6;
            }
        }
        layoutParams.expandable = !layoutParams.isOverflowButton && z;
        layoutParams.cellsUsed = i5;
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), iMakeMeasureSpec);
        return i5;
    }

    /* JADX WARN: Code duplicated, block: B:136:0x0251  */
    /* JADX WARN: Code duplicated, block: B:139:0x0256 A[ADDED_TO_REGION, LOOP:5: B:139:0x0256->B:144:0x0275, LOOP_START, PHI: r13
  0x0256: PHI (r13v4 int) = (r13v3 int), (r13v5 int) binds: [B:138:0x0254, B:144:0x0275] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:140:0x0258  */
    /* JADX WARN: Code duplicated, block: B:143:0x0267  */
    /* JADX WARN: Code duplicated, block: B:146:0x027a  */
    /* JADX WARN: Code duplicated, block: B:147:0x027f  */
    /* JADX WARN: Code duplicated, block: B:172:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v18 */
    private void onMeasureExactFormat(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        android.view.View childAt;
        android.support.v7.widget.ActionMenuView.LayoutParams layoutParams;
        ?? r13;
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i9 = size - paddingLeft;
        int i10 = this.mMinCellSize;
        int i11 = i9 / i10;
        int i12 = i9 % i10;
        if (i11 == 0) {
            setMeasuredDimension(i9, 0);
            return;
        }
        int i13 = i10 + (i12 / i11);
        int childCount = getChildCount();
        int i14 = i11;
        int i15 = 0;
        int iMax = 0;
        boolean z2 = false;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        long j = 0;
        while (i15 < childCount) {
            android.view.View childAt2 = getChildAt(i15);
            int i19 = size2;
            if (childAt2.getVisibility() != 8) {
                boolean z3 = childAt2 instanceof android.support.v7.view.menu.ActionMenuItemView;
                int i20 = i16 + 1;
                if (z3) {
                    int i21 = this.mGeneratedItemPadding;
                    r13 = 0;
                    childAt2.setPadding(i21, 0, i21, 0);
                } else {
                    r13 = 0;
                }
                android.support.v7.widget.ActionMenuView.LayoutParams layoutParams2 = (android.support.v7.widget.ActionMenuView.LayoutParams) childAt2.getLayoutParams();
                layoutParams2.expanded = r13;
                layoutParams2.extraPixels = r13;
                layoutParams2.cellsUsed = r13;
                layoutParams2.expandable = r13;
                layoutParams2.leftMargin = r13;
                layoutParams2.rightMargin = r13;
                layoutParams2.preventEdgeOffset = z3 && ((android.support.v7.view.menu.ActionMenuItemView) childAt2).hasText();
                int iMeasureChildForCells = measureChildForCells(childAt2, i13, layoutParams2.isOverflowButton ? 1 : i14, childMeasureSpec, paddingTop);
                int iMax2 = java.lang.Math.max(i17, iMeasureChildForCells);
                if (layoutParams2.expandable) {
                    i18++;
                }
                if (layoutParams2.isOverflowButton) {
                    z2 = true;
                }
                i14 -= iMeasureChildForCells;
                iMax = java.lang.Math.max(iMax, childAt2.getMeasuredHeight());
                if (iMeasureChildForCells == 1) {
                    j |= (long) (1 << i15);
                    iMax = iMax;
                }
                i17 = iMax2;
                i16 = i20;
            }
            i15++;
            size2 = i19;
        }
        int i22 = size2;
        boolean z4 = z2 && i16 == 2;
        boolean z5 = false;
        while (true) {
            if (i18 <= 0 || i14 <= 0) {
                i3 = i9;
                z = z5;
                i4 = iMax;
                i5 = mode;
                break;
            }
            int i23 = android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i24 = 0;
            int i25 = 0;
            long j2 = 0;
            while (i24 < childCount) {
                boolean z6 = z5;
                android.support.v7.widget.ActionMenuView.LayoutParams layoutParams3 = (android.support.v7.widget.ActionMenuView.LayoutParams) getChildAt(i24).getLayoutParams();
                int i26 = iMax;
                if (layoutParams3.expandable) {
                    if (layoutParams3.cellsUsed < i23) {
                        i23 = layoutParams3.cellsUsed;
                        j2 = 1 << i24;
                        i25 = 1;
                    } else if (layoutParams3.cellsUsed == i23) {
                        i25++;
                        j2 |= (long) (1 << i24);
                    }
                }
                i24++;
                mode = mode;
                iMax = i26;
                z5 = z6;
                i9 = i9;
            }
            i3 = i9;
            z = z5;
            i4 = iMax;
            i5 = mode;
            j |= j2;
            if (i25 > i14) {
                break;
            }
            int i27 = i23 + 1;
            int i28 = 0;
            while (i28 < childCount) {
                android.view.View childAt3 = getChildAt(i28);
                android.support.v7.widget.ActionMenuView.LayoutParams layoutParams4 = (android.support.v7.widget.ActionMenuView.LayoutParams) childAt3.getLayoutParams();
                long j3 = 1 << i28;
                if ((j2 & j3) == 0) {
                    if (layoutParams4.cellsUsed == i27) {
                        j |= j3;
                    }
                    i27 = i27;
                } else {
                    if (z4 && layoutParams4.preventEdgeOffset && i14 == 1) {
                        int i29 = this.mGeneratedItemPadding;
                        childAt3.setPadding(i29 + i13, 0, i29, 0);
                    }
                    layoutParams4.cellsUsed++;
                    layoutParams4.expanded = true;
                    i14--;
                }
                i28++;
                i27 = i27;
            }
            mode = i5;
            iMax = i4;
            i9 = i3;
            z5 = true;
        }
        if (!z2) {
            i6 = 1;
            boolean z7 = i16 == 1;
            if (i14 > 0 || j == 0 || (i14 >= i16 - i6 && !z7 && i17 <= i6)) {
                i7 = 0;
            } else {
                float fBitCount = java.lang.Long.bitCount(j);
                if (z7) {
                    i7 = 0;
                } else {
                    if ((j & 1) != 0) {
                        i7 = 0;
                        if (!((android.support.v7.widget.ActionMenuView.LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                            fBitCount -= 0.5f;
                        }
                    } else {
                        i7 = 0;
                    }
                    int i30 = childCount - 1;
                    if ((j & ((long) (1 << i30))) != 0 && !((android.support.v7.widget.ActionMenuView.LayoutParams) getChildAt(i30).getLayoutParams()).preventEdgeOffset) {
                        fBitCount -= 0.5f;
                    }
                }
                int i31 = fBitCount > 0.0f ? (int) ((i14 * i13) / fBitCount) : 0;
                boolean z8 = z;
                for (int i32 = 0; i32 < childCount; i32++) {
                    if ((j & ((long) (1 << i32))) != 0) {
                        android.view.View childAt4 = getChildAt(i32);
                        android.support.v7.widget.ActionMenuView.LayoutParams layoutParams5 = (android.support.v7.widget.ActionMenuView.LayoutParams) childAt4.getLayoutParams();
                        if (childAt4 instanceof android.support.v7.view.menu.ActionMenuItemView) {
                            layoutParams5.extraPixels = i31;
                            layoutParams5.expanded = true;
                            if (i32 == 0 && !layoutParams5.preventEdgeOffset) {
                                layoutParams5.leftMargin = (-i31) / 2;
                            }
                            z8 = true;
                        } else if (layoutParams5.isOverflowButton) {
                            layoutParams5.extraPixels = i31;
                            layoutParams5.expanded = true;
                            layoutParams5.rightMargin = (-i31) / 2;
                            z8 = true;
                        } else {
                            if (i32 != 0) {
                                layoutParams5.leftMargin = i31 / 2;
                            }
                            if (i32 != childCount - 1) {
                                layoutParams5.rightMargin = i31 / 2;
                            }
                        }
                    }
                }
                z = z8;
            }
            if (z) {
                while (i7 < childCount) {
                    childAt = getChildAt(i7);
                    layoutParams = (android.support.v7.widget.ActionMenuView.LayoutParams) childAt.getLayoutParams();
                    if (!layoutParams.expanded) {
                        childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec((layoutParams.cellsUsed * i13) + layoutParams.extraPixels, 1073741824), childMeasureSpec);
                    }
                    i7++;
                }
            }
            if (i5 != 1073741824) {
                i8 = i4;
            } else {
                i8 = i22;
            }
            setMeasuredDimension(i3, i8);
        }
        i6 = 1;
        if (i14 > 0) {
            i7 = 0;
        } else {
            i7 = 0;
        }
        if (z) {
            while (i7 < childCount) {
                childAt = getChildAt(i7);
                layoutParams = (android.support.v7.widget.ActionMenuView.LayoutParams) childAt.getLayoutParams();
                if (!layoutParams.expanded) {
                    childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec((layoutParams.cellsUsed * i13) + layoutParams.extraPixels, 1073741824), childMeasureSpec);
                }
                i7++;
            }
        }
        if (i5 != 1073741824) {
            i8 = i4;
        } else {
            i8 = i22;
        }
        setMeasuredDimension(i3, i8);
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof android.support.v7.widget.ActionMenuView.LayoutParams);
    }

    public void dismissPopupMenus() {
        android.support.v7.widget.ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    public android.support.v7.widget.ActionMenuView.LayoutParams generateDefaultLayoutParams() {
        android.support.v7.widget.ActionMenuView.LayoutParams layoutParams = new android.support.v7.widget.ActionMenuView.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    public android.support.v7.widget.ActionMenuView.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new android.support.v7.widget.ActionMenuView.LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    public android.support.v7.widget.ActionMenuView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        android.support.v7.widget.ActionMenuView.LayoutParams layoutParams2 = layoutParams instanceof android.support.v7.widget.ActionMenuView.LayoutParams ? new android.support.v7.widget.ActionMenuView.LayoutParams((android.support.v7.widget.ActionMenuView.LayoutParams) layoutParams) : new android.support.v7.widget.ActionMenuView.LayoutParams(layoutParams);
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public android.support.v7.widget.ActionMenuView.LayoutParams generateOverflowButtonLayoutParams() {
        android.support.v7.widget.ActionMenuView.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.isOverflowButton = true;
        return layoutParamsGenerateDefaultLayoutParams;
    }

    public android.view.Menu getMenu() {
        if (this.mMenu == null) {
            android.content.Context context = getContext();
            this.mMenu = new android.support.v7.view.menu.MenuBuilder(context);
            this.mMenu.setCallback(new android.support.v7.widget.ActionMenuView.MenuBuilderCallback());
            this.mPresenter = new android.support.v7.widget.ActionMenuPresenter(context);
            this.mPresenter.setReserveOverflow(true);
            android.support.v7.widget.ActionMenuPresenter actionMenuPresenter = this.mPresenter;
            android.support.v7.view.menu.MenuPresenter.Callback actionMenuPresenterCallback = this.mActionMenuPresenterCallback;
            if (actionMenuPresenterCallback == null) {
                actionMenuPresenterCallback = new android.support.v7.widget.ActionMenuView.ActionMenuPresenterCallback();
            }
            actionMenuPresenter.setCallback(actionMenuPresenterCallback);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    @android.support.annotation.Nullable
    public android.graphics.drawable.Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @Override // android.support.v7.view.menu.MenuView
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public int getWindowAnimations() {
        return 0;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean hasSupportDividerBeforeChildAt(int i) {
        boolean zNeedsDividerAfter = false;
        if (i == 0) {
            return false;
        }
        android.view.KeyEvent.Callback childAt = getChildAt(i - 1);
        android.view.KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof android.support.v7.widget.ActionMenuView.ActionMenuChildView)) {
            zNeedsDividerAfter = false | ((android.support.v7.widget.ActionMenuView.ActionMenuChildView) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof android.support.v7.widget.ActionMenuView.ActionMenuChildView)) ? zNeedsDividerAfter : zNeedsDividerAfter | ((android.support.v7.widget.ActionMenuView.ActionMenuChildView) childAt2).needsDividerBefore();
    }

    public boolean hideOverflowMenu() {
        android.support.v7.widget.ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu();
    }

    @Override // android.support.v7.view.menu.MenuView
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void initialize(android.support.v7.view.menu.MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @Override // android.support.v7.view.menu.MenuBuilder.ItemInvoker
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean invokeItem(android.support.v7.view.menu.MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isOverflowMenuShowPending() {
        android.support.v7.widget.ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        android.support.v7.widget.ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing();
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        android.support.v7.widget.ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int paddingLeft;
        if (!this.mFormatItems) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zIsLayoutRtl = android.support.v7.widget.ViewUtils.isLayoutRtl(this);
        int measuredWidth = paddingRight;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            android.view.View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                android.support.v7.widget.ActionMenuView.LayoutParams layoutParams = (android.support.v7.widget.ActionMenuView.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i11)) {
                        measuredWidth2 += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zIsLayoutRtl) {
                        paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
                        width = paddingLeft + measuredWidth2;
                    } else {
                        width = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        paddingLeft = width - measuredWidth2;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    measuredWidth -= measuredWidth2;
                    i9 = 1;
                } else {
                    measuredWidth -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    hasSupportDividerBeforeChildAt(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            android.view.View childAt2 = getChildAt(0);
            int measuredWidth3 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth3 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth3 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        if (i15 > 0) {
            i6 = measuredWidth / i15;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int iMax = java.lang.Math.max(i5, i6);
        if (zIsLayoutRtl) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                android.view.View childAt3 = getChildAt(i5);
                android.support.v7.widget.ActionMenuView.LayoutParams layoutParams2 = (android.support.v7.widget.ActionMenuView.LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                    int i16 = width2 - layoutParams2.rightMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth4, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth4 + layoutParams2.leftMargin) + iMax);
                }
                i5++;
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        while (i5 < childCount) {
            android.view.View childAt4 = getChildAt(i5);
            android.support.v7.widget.ActionMenuView.LayoutParams layoutParams3 = (android.support.v7.widget.ActionMenuView.LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int i18 = paddingLeft2 + layoutParams3.leftMargin;
                int measuredWidth5 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth5, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth5 + layoutParams3.rightMargin + iMax;
            }
            i5++;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        android.support.v7.view.menu.MenuBuilder menuBuilder;
        boolean z = this.mFormatItems;
        this.mFormatItems = android.view.View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        int size = android.view.View.MeasureSpec.getSize(i);
        if (this.mFormatItems && (menuBuilder = this.mMenu) != null && size != this.mFormatItemsWidth) {
            this.mFormatItemsWidth = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (this.mFormatItems && childCount > 0) {
            onMeasureExactFormat(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            android.support.v7.widget.ActionMenuView.LayoutParams layoutParams = (android.support.v7.widget.ActionMenuView.LayoutParams) getChildAt(i3).getLayoutParams();
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public android.support.v7.view.menu.MenuBuilder peekMenu() {
        return this.mMenu;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.setExpandedActionViewsExclusive(z);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setMenuCallbacks(android.support.v7.view.menu.MenuPresenter.Callback callback, android.support.v7.view.menu.MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setOnMenuItemClickListener(android.support.v7.widget.ActionMenuView.OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(@android.support.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    public void setPopupTheme(@android.support.annotation.StyleRes int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new android.view.ContextThemeWrapper(getContext(), i);
            }
        }
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setPresenter(android.support.v7.widget.ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        this.mPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        android.support.v7.widget.ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu();
    }
}
