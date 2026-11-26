package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ScrollingTabContainerView extends android.widget.HorizontalScrollView implements android.widget.AdapterView.OnItemSelectedListener {
    private static final int FADE_DURATION = 200;
    private static final java.lang.String TAG = "ScrollingTabContainerView";
    private static final android.view.animation.Interpolator sAlphaInterpolator = new android.view.animation.DecelerateInterpolator();
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private android.support.v7.widget.ScrollingTabContainerView.TabClickListener mTabClickListener;
    android.support.v7.widget.LinearLayoutCompat mTabLayout;
    java.lang.Runnable mTabSelector;
    private android.widget.Spinner mTabSpinner;
    protected final android.support.v7.widget.ScrollingTabContainerView.VisibilityAnimListener mVisAnimListener;
    protected android.view.ViewPropertyAnimator mVisibilityAnim;

    private class TabAdapter extends android.widget.BaseAdapter {
        TabAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return android.support.v7.widget.ScrollingTabContainerView.this.mTabLayout.getChildCount();
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i) {
            return ((android.support.v7.widget.ScrollingTabContainerView.TabView) android.support.v7.widget.ScrollingTabContainerView.this.mTabLayout.getChildAt(i)).getTab();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            if (view == null) {
                return android.support.v7.widget.ScrollingTabContainerView.this.createTabView((android.support.v7.app.ActionBar.Tab) getItem(i), true);
            }
            ((android.support.v7.widget.ScrollingTabContainerView.TabView) view).bindTab((android.support.v7.app.ActionBar.Tab) getItem(i));
            return view;
        }
    }

    private class TabClickListener implements android.view.View.OnClickListener {
        TabClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            ((android.support.v7.widget.ScrollingTabContainerView.TabView) view).getTab().select();
            int childCount = android.support.v7.widget.ScrollingTabContainerView.this.mTabLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = android.support.v7.widget.ScrollingTabContainerView.this.mTabLayout.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class TabView extends android.support.v7.widget.LinearLayoutCompat {
        private final int[] BG_ATTRS;
        private android.view.View mCustomView;
        private android.widget.ImageView mIconView;
        private android.support.v7.app.ActionBar.Tab mTab;
        private android.widget.TextView mTextView;

        public TabView(android.content.Context context, android.support.v7.app.ActionBar.Tab tab, boolean z) {
            super(context, null, android.support.v7.appcompat.R.attr.actionBarTabStyle);
            this.BG_ATTRS = new int[]{android.R.attr.background};
            this.mTab = tab;
            android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, null, this.BG_ATTRS, android.support.v7.appcompat.R.attr.actionBarTabStyle, 0);
            if (tintTypedArrayObtainStyledAttributes.hasValue(0)) {
                setBackgroundDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(0));
            }
            tintTypedArrayObtainStyledAttributes.recycle();
            if (z) {
                setGravity(8388627);
            }
            update();
        }

        public void bindTab(android.support.v7.app.ActionBar.Tab tab) {
            this.mTab = tab;
            update();
        }

        public android.support.v7.app.ActionBar.Tab getTab() {
            return this.mTab;
        }

        @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
        public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.Tab.class.getName());
        }

        @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
        public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.Tab.class.getName());
        }

        @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (android.support.v7.widget.ScrollingTabContainerView.this.mMaxTabWidth <= 0 || getMeasuredWidth() <= android.support.v7.widget.ScrollingTabContainerView.this.mMaxTabWidth) {
                return;
            }
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(android.support.v7.widget.ScrollingTabContainerView.this.mMaxTabWidth, 1073741824), i2);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void update() {
            android.support.v7.app.ActionBar.Tab tab = this.mTab;
            android.view.View customView = tab.getCustomView();
            if (customView != null) {
                android.view.ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((android.view.ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.mCustomView = customView;
                android.widget.TextView textView = this.mTextView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                android.widget.ImageView imageView = this.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                    return;
                }
                return;
            }
            android.view.View view = this.mCustomView;
            if (view != null) {
                removeView(view);
                this.mCustomView = null;
            }
            android.graphics.drawable.Drawable icon = tab.getIcon();
            java.lang.CharSequence text = tab.getText();
            if (icon != null) {
                if (this.mIconView == null) {
                    android.support.v7.widget.AppCompatImageView appCompatImageView = new android.support.v7.widget.AppCompatImageView(getContext());
                    android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams = new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.mIconView = appCompatImageView;
                }
                this.mIconView.setImageDrawable(icon);
                this.mIconView.setVisibility(0);
            } else {
                android.widget.ImageView imageView2 = this.mIconView;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                }
            }
            boolean z = !android.text.TextUtils.isEmpty(text);
            if (z) {
                if (this.mTextView == null) {
                    android.support.v7.widget.AppCompatTextView appCompatTextView = new android.support.v7.widget.AppCompatTextView(getContext(), null, android.support.v7.appcompat.R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams2 = new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.mTextView = appCompatTextView;
                }
                this.mTextView.setText(text);
                this.mTextView.setVisibility(0);
            } else {
                android.widget.TextView textView2 = this.mTextView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.mTextView.setText((java.lang.CharSequence) null);
                }
            }
            android.widget.ImageView imageView3 = this.mIconView;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.getContentDescription());
            }
            android.support.v7.widget.TooltipCompat.setTooltipText(this, z ? null : tab.getContentDescription());
        }
    }

    protected class VisibilityAnimListener extends android.animation.AnimatorListenerAdapter {
        private boolean mCanceled = false;
        private int mFinalVisibility;

        protected VisibilityAnimListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (this.mCanceled) {
                return;
            }
            android.support.v7.widget.ScrollingTabContainerView scrollingTabContainerView = android.support.v7.widget.ScrollingTabContainerView.this;
            scrollingTabContainerView.mVisibilityAnim = null;
            scrollingTabContainerView.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            android.support.v7.widget.ScrollingTabContainerView.this.setVisibility(0);
            this.mCanceled = false;
        }

        public android.support.v7.widget.ScrollingTabContainerView.VisibilityAnimListener withFinalVisibility(android.view.ViewPropertyAnimator viewPropertyAnimator, int i) {
            this.mFinalVisibility = i;
            android.support.v7.widget.ScrollingTabContainerView.this.mVisibilityAnim = viewPropertyAnimator;
            return this;
        }
    }

    public ScrollingTabContainerView(android.content.Context context) {
        super(context);
        this.mVisAnimListener = new android.support.v7.widget.ScrollingTabContainerView.VisibilityAnimListener();
        setHorizontalScrollBarEnabled(false);
        android.support.v7.view.ActionBarPolicy actionBarPolicy = android.support.v7.view.ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.mStackedTabMaxWidth = actionBarPolicy.getStackedTabMaxWidth();
        this.mTabLayout = createTabLayout();
        addView(this.mTabLayout, new android.view.ViewGroup.LayoutParams(-2, -1));
    }

    private android.widget.Spinner createSpinner() {
        android.support.v7.widget.AppCompatSpinner appCompatSpinner = new android.support.v7.widget.AppCompatSpinner(getContext(), null, android.support.v7.appcompat.R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private android.support.v7.widget.LinearLayoutCompat createTabLayout() {
        android.support.v7.widget.LinearLayoutCompat linearLayoutCompat = new android.support.v7.widget.LinearLayoutCompat(getContext(), null, android.support.v7.appcompat.R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean isCollapsed() {
        android.widget.Spinner spinner = this.mTabSpinner;
        return spinner != null && spinner.getParent() == this;
    }

    private void performCollapse() {
        if (isCollapsed()) {
            return;
        }
        if (this.mTabSpinner == null) {
            this.mTabSpinner = createSpinner();
        }
        removeView(this.mTabLayout);
        addView(this.mTabSpinner, new android.view.ViewGroup.LayoutParams(-2, -1));
        if (this.mTabSpinner.getAdapter() == null) {
            this.mTabSpinner.setAdapter((android.widget.SpinnerAdapter) new android.support.v7.widget.ScrollingTabContainerView.TabAdapter());
        }
        java.lang.Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.mTabSelector = null;
        }
        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }

    private boolean performExpand() {
        if (!isCollapsed()) {
            return false;
        }
        removeView(this.mTabSpinner);
        addView(this.mTabLayout, new android.view.ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }

    public void addTab(android.support.v7.app.ActionBar.Tab tab, int i, boolean z) {
        android.support.v7.widget.ScrollingTabContainerView.TabView tabViewCreateTabView = createTabView(tab, false);
        this.mTabLayout.addView(tabViewCreateTabView, i, new android.support.v7.widget.LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((android.support.v7.widget.ScrollingTabContainerView.TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            tabViewCreateTabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void addTab(android.support.v7.app.ActionBar.Tab tab, boolean z) {
        android.support.v7.widget.ScrollingTabContainerView.TabView tabViewCreateTabView = createTabView(tab, false);
        this.mTabLayout.addView(tabViewCreateTabView, new android.support.v7.widget.LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((android.support.v7.widget.ScrollingTabContainerView.TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            tabViewCreateTabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void animateToTab(int i) {
        final android.view.View childAt = this.mTabLayout.getChildAt(i);
        java.lang.Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.mTabSelector = new java.lang.Runnable() { // from class: android.support.v7.widget.ScrollingTabContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                android.support.v7.widget.ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((android.support.v7.widget.ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                android.support.v7.widget.ScrollingTabContainerView.this.mTabSelector = null;
            }
        };
        post(this.mTabSelector);
    }

    public void animateToVisibility(int i) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mVisibilityAnim;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i != 0) {
            android.view.ViewPropertyAnimator viewPropertyAnimatorAlpha = animate().alpha(0.0f);
            viewPropertyAnimatorAlpha.setDuration(200L);
            viewPropertyAnimatorAlpha.setInterpolator(sAlphaInterpolator);
            viewPropertyAnimatorAlpha.setListener(this.mVisAnimListener.withFinalVisibility(viewPropertyAnimatorAlpha, i));
            viewPropertyAnimatorAlpha.start();
            return;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        android.view.ViewPropertyAnimator viewPropertyAnimatorAlpha2 = animate().alpha(1.0f);
        viewPropertyAnimatorAlpha2.setDuration(200L);
        viewPropertyAnimatorAlpha2.setInterpolator(sAlphaInterpolator);
        viewPropertyAnimatorAlpha2.setListener(this.mVisAnimListener.withFinalVisibility(viewPropertyAnimatorAlpha2, i));
        viewPropertyAnimatorAlpha2.start();
    }

    android.support.v7.widget.ScrollingTabContainerView.TabView createTabView(android.support.v7.app.ActionBar.Tab tab, boolean z) {
        android.support.v7.widget.ScrollingTabContainerView.TabView tabView = new android.support.v7.widget.ScrollingTabContainerView.TabView(getContext(), tab, z);
        if (z) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, this.mContentHeight));
        } else {
            tabView.setFocusable(true);
            if (this.mTabClickListener == null) {
                this.mTabClickListener = new android.support.v7.widget.ScrollingTabContainerView.TabClickListener();
            }
            tabView.setOnClickListener(this.mTabClickListener);
        }
        return tabView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        java.lang.Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        android.support.v7.view.ActionBarPolicy actionBarPolicy = android.support.v7.view.ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.mStackedTabMaxWidth = actionBarPolicy.getStackedTabMaxWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        java.lang.Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
        ((android.support.v7.widget.ScrollingTabContainerView.TabView) view).getTab().select();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.mTabLayout.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.mMaxTabWidth = -1;
        } else {
            if (childCount > 2) {
                this.mMaxTabWidth = (int) (android.view.View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.mMaxTabWidth = android.view.View.MeasureSpec.getSize(i) / 2;
            }
            this.mMaxTabWidth = java.lang.Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
        }
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (!z && this.mAllowCollapse) {
            this.mTabLayout.measure(0, iMakeMeasureSpec);
            if (this.mTabLayout.getMeasuredWidth() > android.view.View.MeasureSpec.getSize(i)) {
                performCollapse();
            } else {
                performExpand();
            }
        } else {
            performExpand();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.mSelectedTabIndex);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(android.widget.AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((android.support.v7.widget.ScrollingTabContainerView.TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.mTabLayout.removeViewAt(i);
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((android.support.v7.widget.ScrollingTabContainerView.TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z) {
        this.mAllowCollapse = z;
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.mSelectedTabIndex = i;
        int childCount = this.mTabLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            android.view.View childAt = this.mTabLayout.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
            i2++;
        }
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    public void updateTab(int i) {
        ((android.support.v7.widget.ScrollingTabContainerView.TabView) this.mTabLayout.getChildAt(i)).update();
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((android.support.v7.widget.ScrollingTabContainerView.TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }
}
