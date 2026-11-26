package android.support.v4.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SlidingPaneLayout extends android.view.ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    static final android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl IMPL;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final java.lang.String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    final android.support.v4.widget.ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private android.support.v4.widget.SlidingPaneLayout.PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final java.util.ArrayList<android.support.v4.widget.SlidingPaneLayout.DisableLayerRunnable> mPostedRunnables;
    boolean mPreservedOpenState;
    private android.graphics.drawable.Drawable mShadowDrawableLeft;
    private android.graphics.drawable.Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    android.view.View mSlideableView;
    private int mSliderFadeColor;
    private final android.graphics.Rect mTmpRect;

    class AccessibilityDelegate extends android.support.v4.view.AccessibilityDelegateCompat {
        private final android.graphics.Rect mTmpRect = new android.graphics.Rect();

        AccessibilityDelegate() {
        }

        private void copyNodeInfoNoChildren(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            android.graphics.Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean filter(android.view.View view) {
            return android.support.v4.widget.SlidingPaneLayout.this.isDimmed(view);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v4.widget.SlidingPaneLayout.class.getName());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompatObtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, accessibilityNodeInfoCompatObtain);
            accessibilityNodeInfoCompatObtain.recycle();
            accessibilityNodeInfoCompat.setClassName(android.support.v4.widget.SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            java.lang.Object parentForAccessibility = android.support.v4.view.ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof android.view.View) {
                accessibilityNodeInfoCompat.setParent((android.view.View) parentForAccessibility);
            }
            int childCount = android.support.v4.widget.SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = android.support.v4.widget.SlidingPaneLayout.this.getChildAt(i);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    android.support.v4.view.ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            if (filter(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    private class DisableLayerRunnable implements java.lang.Runnable {
        final android.view.View mChildView;

        DisableLayerRunnable(android.view.View view) {
            this.mChildView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() == android.support.v4.widget.SlidingPaneLayout.this) {
                this.mChildView.setLayerType(0, null);
                android.support.v4.widget.SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            android.support.v4.widget.SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    private class DragHelperCallback extends android.support.v4.widget.ViewDragHelper.Callback {
        DragHelperCallback() {
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(android.view.View view, int i, int i2) {
            android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) android.support.v4.widget.SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (android.support.v4.widget.SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int width = android.support.v4.widget.SlidingPaneLayout.this.getWidth() - ((android.support.v4.widget.SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + android.support.v4.widget.SlidingPaneLayout.this.mSlideableView.getWidth());
                return java.lang.Math.max(java.lang.Math.min(i, width), width - android.support.v4.widget.SlidingPaneLayout.this.mSlideRange);
            }
            int paddingLeft = android.support.v4.widget.SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return java.lang.Math.min(java.lang.Math.max(i, paddingLeft), android.support.v4.widget.SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(android.view.View view, int i, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(android.view.View view) {
            return android.support.v4.widget.SlidingPaneLayout.this.mSlideRange;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            android.support.v4.widget.SlidingPaneLayout.this.mDragHelper.captureChildView(android.support.v4.widget.SlidingPaneLayout.this.mSlideableView, i2);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewCaptured(android.view.View view, int i) {
            android.support.v4.widget.SlidingPaneLayout.this.setAllChildrenVisible();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (android.support.v4.widget.SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                if (android.support.v4.widget.SlidingPaneLayout.this.mSlideOffset != 0.0f) {
                    android.support.v4.widget.SlidingPaneLayout slidingPaneLayout = android.support.v4.widget.SlidingPaneLayout.this;
                    slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
                    android.support.v4.widget.SlidingPaneLayout.this.mPreservedOpenState = true;
                } else {
                    android.support.v4.widget.SlidingPaneLayout slidingPaneLayout2 = android.support.v4.widget.SlidingPaneLayout.this;
                    slidingPaneLayout2.updateObscuredViewsVisibility(slidingPaneLayout2.mSlideableView);
                    android.support.v4.widget.SlidingPaneLayout slidingPaneLayout3 = android.support.v4.widget.SlidingPaneLayout.this;
                    slidingPaneLayout3.dispatchOnPanelClosed(slidingPaneLayout3.mSlideableView);
                    android.support.v4.widget.SlidingPaneLayout.this.mPreservedOpenState = false;
                }
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(android.view.View view, int i, int i2, int i3, int i4) {
            android.support.v4.widget.SlidingPaneLayout.this.onPanelDragged(i);
            android.support.v4.widget.SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewReleased(android.view.View view, float f, float f2) {
            int paddingLeft;
            android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams();
            if (android.support.v4.widget.SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = android.support.v4.widget.SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f < 0.0f || (f == 0.0f && android.support.v4.widget.SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += android.support.v4.widget.SlidingPaneLayout.this.mSlideRange;
                }
                paddingLeft = (android.support.v4.widget.SlidingPaneLayout.this.getWidth() - paddingRight) - android.support.v4.widget.SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                paddingLeft = layoutParams.leftMargin + android.support.v4.widget.SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && android.support.v4.widget.SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingLeft += android.support.v4.widget.SlidingPaneLayout.this.mSlideRange;
                }
            }
            android.support.v4.widget.SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
            android.support.v4.widget.SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(android.view.View view, int i) {
            if (android.support.v4.widget.SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((android.support.v4.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {android.R.attr.layout_weight};
        android.graphics.Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight;

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.weight = 0.0f;
        }

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.weight = 0.0f;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams) {
            super((android.view.ViewGroup.MarginLayoutParams) layoutParams);
            this.weight = 0.0f;
            this.weight = layoutParams.weight;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.weight = 0.0f;
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(android.view.View view);

        void onPanelOpened(android.view.View view);

        void onPanelSlide(android.view.View view, float f);
    }

    static class SavedState extends android.support.v4.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<android.support.v4.widget.SlidingPaneLayout.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<android.support.v4.widget.SlidingPaneLayout.SavedState>() { // from class: android.support.v4.widget.SlidingPaneLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            public android.support.v4.widget.SlidingPaneLayout.SavedState createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.widget.SlidingPaneLayout.SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public android.support.v4.widget.SlidingPaneLayout.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new android.support.v4.widget.SlidingPaneLayout.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public android.support.v4.widget.SlidingPaneLayout.SavedState[] newArray(int i) {
                return new android.support.v4.widget.SlidingPaneLayout.SavedState[i];
            }
        };
        boolean isOpen;

        SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
        }

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }
    }

    public static class SimplePanelSlideListener implements android.support.v4.widget.SlidingPaneLayout.PanelSlideListener {
        @Override // android.support.v4.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(android.view.View view) {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(android.view.View view) {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(android.view.View view, float f) {
        }
    }

    interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(android.support.v4.widget.SlidingPaneLayout slidingPaneLayout, android.view.View view);
    }

    static class SlidingPanelLayoutImplBase implements android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl {
        SlidingPanelLayoutImplBase() {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(android.support.v4.widget.SlidingPaneLayout slidingPaneLayout, android.view.View view) {
            android.support.v4.view.ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @android.support.annotation.RequiresApi(16)
    static class SlidingPanelLayoutImplJB extends android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase {
        private java.lang.reflect.Method mGetDisplayList;
        private java.lang.reflect.Field mRecreateDisplayList;

        SlidingPanelLayoutImplJB() {
            try {
                this.mGetDisplayList = android.view.View.class.getDeclaredMethod("getDisplayList", (java.lang.Class[]) null);
            } catch (java.lang.NoSuchMethodException e) {
                android.util.Log.e(android.support.v4.widget.SlidingPaneLayout.TAG, "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.mRecreateDisplayList = android.view.View.class.getDeclaredField("mRecreateDisplayList");
                this.mRecreateDisplayList.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e2) {
                android.util.Log.e(android.support.v4.widget.SlidingPaneLayout.TAG, "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(android.support.v4.widget.SlidingPaneLayout slidingPaneLayout, android.view.View view) {
            java.lang.reflect.Field field;
            if (this.mGetDisplayList == null || (field = this.mRecreateDisplayList) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.mGetDisplayList.invoke(view, (java.lang.Object[]) null);
            } catch (java.lang.Exception e) {
                android.util.Log.e(android.support.v4.widget.SlidingPaneLayout.TAG, "Error refreshing display list state", e);
            }
            super.invalidateChildRegion(slidingPaneLayout, view);
        }
    }

    @android.support.annotation.RequiresApi(17)
    static class SlidingPanelLayoutImplJBMR1 extends android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase {
        SlidingPanelLayoutImplJBMR1() {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(android.support.v4.widget.SlidingPaneLayout slidingPaneLayout, android.view.View view) {
            android.support.v4.view.ViewCompat.setLayerPaint(view, ((android.support.v4.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams()).dimPaint);
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            IMPL = new android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplJBMR1();
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            IMPL = new android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplJB();
        } else {
            IMPL = new android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase();
        }
    }

    public SlidingPaneLayout(android.content.Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new android.graphics.Rect();
        this.mPostedRunnables = new java.util.ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        android.support.v4.view.ViewCompat.setAccessibilityDelegate(this, new android.support.v4.widget.SlidingPaneLayout.AccessibilityDelegate());
        android.support.v4.view.ViewCompat.setImportantForAccessibility(this, 1);
        this.mDragHelper = android.support.v4.widget.ViewDragHelper.create(this, 0.5f, new android.support.v4.widget.SlidingPaneLayout.DragHelperCallback());
        this.mDragHelper.setMinVelocity(f * 400.0f);
    }

    private boolean closePane(android.view.View view, int i) {
        if (!this.mFirstLayout && !smoothSlideTo(0.0f, i)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void dimChildView(android.view.View view, float f, int i) {
        android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams();
        if (f <= 0.0f || i == 0) {
            if (view.getLayerType() != 0) {
                if (layoutParams.dimPaint != null) {
                    layoutParams.dimPaint.setColorFilter(null);
                }
                android.support.v4.widget.SlidingPaneLayout.DisableLayerRunnable disableLayerRunnable = new android.support.v4.widget.SlidingPaneLayout.DisableLayerRunnable(view);
                this.mPostedRunnables.add(disableLayerRunnable);
                android.support.v4.view.ViewCompat.postOnAnimation(this, disableLayerRunnable);
                return;
            }
            return;
        }
        int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (i & android.support.v4.view.ViewCompat.MEASURED_SIZE_MASK);
        if (layoutParams.dimPaint == null) {
            layoutParams.dimPaint = new android.graphics.Paint();
        }
        layoutParams.dimPaint.setColorFilter(new android.graphics.PorterDuffColorFilter(i2, android.graphics.PorterDuff.Mode.SRC_OVER));
        if (view.getLayerType() != 2) {
            view.setLayerType(2, layoutParams.dimPaint);
        }
        invalidateChildRegion(view);
    }

    private boolean openPane(android.view.View view, int i) {
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    private void parallaxOtherViews(float f) {
        boolean z;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) this.mSlideableView.getLayoutParams();
        if (!layoutParams.dimWhenOffset) {
            z = false;
        } else if ((zIsLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
            z = true;
        } else {
            z = false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = getChildAt(i);
            if (childAt != this.mSlideableView) {
                float f2 = 1.0f - this.mParallaxOffset;
                int i2 = this.mParallaxBy;
                this.mParallaxOffset = f;
                int i3 = ((int) (f2 * i2)) - ((int) ((1.0f - f) * i2));
                if (zIsLayoutRtlSupport) {
                    i3 = -i3;
                }
                childAt.offsetLeftAndRight(i3);
                if (z) {
                    dimChildView(childAt, zIsLayoutRtlSupport ? this.mParallaxOffset - 1.0f : 1.0f - this.mParallaxOffset, this.mCoveredFadeColor);
                }
            }
        }
    }

    private static boolean viewIsOpaque(android.view.View view) {
        android.graphics.drawable.Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        return android.os.Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    protected boolean canScroll(android.view.View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                android.view.View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z) {
            if (view.canScrollHorizontally(isLayoutRtlSupport() ? i : -i)) {
                return true;
            }
        }
        return false;
    }

    @java.lang.Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof android.support.v4.widget.SlidingPaneLayout.LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (this.mCanSlide) {
                android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this);
            } else {
                this.mDragHelper.abort();
            }
        }
    }

    void dispatchOnPanelClosed(android.view.View view) {
        android.support.v4.widget.SlidingPaneLayout.PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelOpened(android.view.View view) {
        android.support.v4.widget.SlidingPaneLayout.PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelSlide(android.view.View view) {
        android.support.v4.widget.SlidingPaneLayout.PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        int i;
        int right;
        super.draw(canvas);
        android.graphics.drawable.Drawable drawable = isLayoutRtlSupport() ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        android.view.View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (isLayoutRtlSupport()) {
            right = childAt.getRight();
            i = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i2 = left - intrinsicWidth;
            i = left;
            right = i2;
        }
        drawable.setBounds(right, top, i, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j) {
        android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams();
        int iSave = canvas.save(2);
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                android.graphics.Rect rect = this.mTmpRect;
                rect.left = java.lang.Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                android.graphics.Rect rect2 = this.mTmpRect;
                rect2.right = java.lang.Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new android.support.v4.widget.SlidingPaneLayout.LayoutParams();
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new android.support.v4.widget.SlidingPaneLayout.LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof android.view.ViewGroup.MarginLayoutParams ? new android.support.v4.widget.SlidingPaneLayout.LayoutParams((android.view.ViewGroup.MarginLayoutParams) layoutParams) : new android.support.v4.widget.SlidingPaneLayout.LayoutParams(layoutParams);
    }

    @android.support.annotation.ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @android.support.annotation.ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    void invalidateChildRegion(android.view.View view) {
        IMPL.invalidateChildRegion(this, view);
    }

    boolean isDimmed(android.view.View view) {
        if (view == null) {
            return false;
        }
        return this.mCanSlide && ((android.support.v4.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams()).dimWhenOffset && this.mSlideOffset > 0.0f;
    }

    boolean isLayoutRtlSupport() {
        return android.support.v4.view.ViewCompat.getLayoutDirection(this) == 1;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i = 0; i < size; i++) {
            this.mPostedRunnables.get(i).run();
        }
        this.mPostedRunnables.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        boolean z;
        android.view.View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        }
        if (actionMasked == 0) {
            this.mIsUnableToDrag = false;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
            if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y) && isDimmed(this.mSlideableView)) {
                z = true;
            }
            return this.mDragHelper.shouldInterceptTouchEvent(motionEvent) || z;
        }
        if (actionMasked == 2) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float fAbs = java.lang.Math.abs(x2 - this.mInitialMotionX);
            float fAbs2 = java.lang.Math.abs(y2 - this.mInitialMotionY);
            if (fAbs > this.mDragHelper.getTouchSlop() && fAbs2 > fAbs) {
                this.mDragHelper.cancel();
                this.mIsUnableToDrag = true;
                return false;
            }
        }
        z = false;
        if (this.mDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        if (zIsLayoutRtlSupport) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }
        int i10 = i3 - i;
        int paddingRight = zIsLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zIsLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.mSlideOffset = (this.mCanSlide && this.mPreservedOpenState) ? 1.0f : 0.0f;
        }
        int width = paddingRight;
        int i11 = width;
        for (int i12 = 0; i12 < childCount; i12++) {
            android.view.View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.slideable) {
                    int i13 = i10 - paddingLeft;
                    int iMin = (java.lang.Math.min(width, i13 - this.mOverhangSize) - i11) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.mSlideRange = iMin;
                    int i14 = zIsLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.dimWhenOffset = ((i11 + i14) + iMin) + (measuredWidth / 2) > i13;
                    int i15 = (int) (iMin * this.mSlideOffset);
                    i5 = i14 + i15 + i11;
                    this.mSlideOffset = i15 / this.mSlideRange;
                    i6 = 0;
                } else if (!this.mCanSlide || (i7 = this.mParallaxBy) == 0) {
                    i5 = width;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.mSlideOffset) * i7);
                    i5 = width;
                }
                if (zIsLayoutRtlSupport) {
                    i9 = (i10 - i5) + i6;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i5 - i6;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                width += childAt.getWidth();
                i11 = i5;
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((android.support.v4.widget.SlidingPaneLayout.LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i16 = 0; i16 < childCount; i16++) {
                    dimChildView(getChildAt(i16), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
            z2 = false;
        } else {
            z2 = false;
        }
        this.mFirstLayout = z2;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b4 A[PHI: r12
  0x00b4: PHI (r12v2 float) = (r12v1 float), (r12v3 float) binds: [B:35:0x00a9, B:37:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:41:0x00be  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:59:0x0117  */
    /* JADX WARN: Code duplicated, block: B:60:0x0119  */
    /* JADX WARN: Code duplicated, block: B:63:0x0121  */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingTop;
        int paddingTop2;
        int i3;
        int iMakeMeasureSpec;
        int i4;
        int iMakeMeasureSpec2;
        int i5;
        int iMakeMeasureSpec3;
        int iMakeMeasureSpec4;
        int measuredHeight;
        boolean z;
        int mode = android.view.View.MeasureSpec.getMode(i);
        int size = android.view.View.MeasureSpec.getSize(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new java.lang.IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new java.lang.IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z2 = false;
        if (mode2 == Integer.MIN_VALUE) {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop2 = 0;
        } else if (mode2 != 1073741824) {
            paddingTop2 = 0;
            paddingTop = 0;
        } else {
            paddingTop2 = (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = paddingTop2;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            android.util.Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        int iMin = paddingTop2;
        int i6 = paddingLeft;
        int i7 = 0;
        boolean z3 = false;
        float f = 0.0f;
        while (true) {
            i3 = 8;
            if (i7 >= childCount) {
                break;
            }
            android.view.View childAt = getChildAt(i7);
            android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = z2;
            } else if (layoutParams.weight > 0.0f) {
                f += layoutParams.weight;
                if (layoutParams.width != 0) {
                    i5 = layoutParams.leftMargin + layoutParams.rightMargin;
                    if (layoutParams.width == -2) {
                        iMakeMeasureSpec3 = android.view.View.MeasureSpec.makeMeasureSpec(paddingLeft - i5, Integer.MIN_VALUE);
                    } else if (layoutParams.width == -1) {
                        iMakeMeasureSpec3 = android.view.View.MeasureSpec.makeMeasureSpec(paddingLeft - i5, 1073741824);
                    } else {
                        iMakeMeasureSpec3 = android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                    }
                    if (layoutParams.height == -2) {
                        iMakeMeasureSpec4 = android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                    } else if (layoutParams.height == -1) {
                        iMakeMeasureSpec4 = android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                    } else {
                        iMakeMeasureSpec4 = android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                    }
                    childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
                    int measuredWidth = childAt.getMeasuredWidth();
                    measuredHeight = childAt.getMeasuredHeight();
                    if (mode2 == Integer.MIN_VALUE && measuredHeight > iMin) {
                        iMin = java.lang.Math.min(measuredHeight, paddingTop);
                    }
                    i6 -= measuredWidth;
                    if (i6 < 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    layoutParams.slideable = z;
                    boolean z4 = z | z3;
                    if (layoutParams.slideable) {
                        this.mSlideableView = childAt;
                    }
                    z3 = z4;
                }
            } else {
                i5 = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    iMakeMeasureSpec3 = android.view.View.MeasureSpec.makeMeasureSpec(paddingLeft - i5, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    iMakeMeasureSpec3 = android.view.View.MeasureSpec.makeMeasureSpec(paddingLeft - i5, 1073741824);
                } else {
                    iMakeMeasureSpec3 = android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    iMakeMeasureSpec4 = android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    iMakeMeasureSpec4 = android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                } else {
                    iMakeMeasureSpec4 = android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
                int measuredWidth2 = childAt.getMeasuredWidth();
                measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE) {
                    iMin = java.lang.Math.min(measuredHeight, paddingTop);
                }
                i6 -= measuredWidth2;
                if (i6 < 0) {
                    z = true;
                } else {
                    z = false;
                }
                layoutParams.slideable = z;
                boolean z5 = z | z3;
                if (layoutParams.slideable) {
                    this.mSlideableView = childAt;
                }
                z3 = z5;
            }
            i7++;
            z2 = false;
        }
        if (z3 || f > 0.0f) {
            int i8 = paddingLeft - this.mOverhangSize;
            int i9 = 0;
            while (i9 < childCount) {
                android.view.View childAt2 = getChildAt(i9);
                if (childAt2.getVisibility() != i3) {
                    android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams2 = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i3) {
                        boolean z6 = layoutParams2.width == 0 && layoutParams2.weight > 0.0f;
                        int measuredWidth3 = z6 ? 0 : childAt2.getMeasuredWidth();
                        if (!z3 || childAt2 == this.mSlideableView) {
                            if (layoutParams2.weight > 0.0f) {
                                if (layoutParams2.width != 0) {
                                    iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams2.height == -2) {
                                    iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                } else {
                                    iMakeMeasureSpec = layoutParams2.height == -1 ? android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824) : android.view.View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                                }
                                if (z3) {
                                    int i10 = paddingLeft - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                                    int iMakeMeasureSpec5 = android.view.View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                                    if (measuredWidth3 != i10) {
                                        childAt2.measure(iMakeMeasureSpec5, iMakeMeasureSpec);
                                    }
                                } else {
                                    childAt2.measure(android.view.View.MeasureSpec.makeMeasureSpec(measuredWidth3 + ((int) ((layoutParams2.weight * java.lang.Math.max(0, i6)) / f)), 1073741824), iMakeMeasureSpec);
                                }
                            }
                        } else if (layoutParams2.width < 0 && (measuredWidth3 > i8 || layoutParams2.weight > 0.0f)) {
                            if (!z6) {
                                i4 = 1073741824;
                                iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams2.height == -2) {
                                iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                i4 = 1073741824;
                            } else if (layoutParams2.height == -1) {
                                i4 = 1073741824;
                                iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                            } else {
                                i4 = 1073741824;
                                iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                            }
                            childAt2.measure(android.view.View.MeasureSpec.makeMeasureSpec(i8, i4), iMakeMeasureSpec2);
                        }
                    }
                }
                i9++;
                i8 = i8;
                i3 = 8;
            }
        }
        setMeasuredDimension(size, iMin + getPaddingTop() + getPaddingBottom());
        this.mCanSlide = z3;
        if (this.mDragHelper.getViewDragState() == 0 || z3) {
            return;
        }
        this.mDragHelper.abort();
    }

    void onPanelDragged(int i) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (zIsLayoutRtlSupport) {
            i = (getWidth() - i) - width;
        }
        this.mSlideOffset = (i - ((zIsLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()) + (zIsLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin))) / this.mSlideRange;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(this.mSlideOffset);
        }
        if (layoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof android.support.v4.widget.SlidingPaneLayout.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        android.support.v4.widget.SlidingPaneLayout.SavedState savedState = (android.support.v4.widget.SlidingPaneLayout.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        android.support.v4.widget.SlidingPaneLayout.SavedState savedState = new android.support.v4.widget.SlidingPaneLayout.SavedState(super.onSaveInstanceState());
        savedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.mFirstLayout = true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                return true;
            case 1:
                if (isDimmed(this.mSlideableView)) {
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    float f = x2 - this.mInitialMotionX;
                    float f2 = y2 - this.mInitialMotionY;
                    int touchSlop = this.mDragHelper.getTouchSlop();
                    if ((f * f) + (f2 * f2) < touchSlop * touchSlop && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y2)) {
                        closePane(this.mSlideableView, 0);
                    }
                }
                return true;
            default:
                return true;
        }
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(android.view.View view, android.view.View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.mCanSlide) {
            return;
        }
        this.mPreservedOpenState = view == this.mSlideableView;
    }

    void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(@android.support.annotation.ColorInt int i) {
        this.mCoveredFadeColor = i;
    }

    public void setPanelSlideListener(android.support.v4.widget.SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    @java.lang.Deprecated
    public void setShadowDrawable(android.graphics.drawable.Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(android.graphics.drawable.Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(android.graphics.drawable.Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @java.lang.Deprecated
    public void setShadowResource(@android.support.annotation.DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(android.support.v4.content.ContextCompat.getDrawable(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(android.support.v4.content.ContextCompat.getDrawable(getContext(), i));
    }

    public void setSliderFadeColor(@android.support.annotation.ColorInt int i) {
        this.mSliderFadeColor = i;
    }

    @java.lang.Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @java.lang.Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    boolean smoothSlideTo(float f, int i) {
        int paddingLeft;
        if (!this.mCanSlide) {
            return false;
        }
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        android.support.v4.widget.SlidingPaneLayout.LayoutParams layoutParams = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) this.mSlideableView.getLayoutParams();
        if (zIsLayoutRtlSupport) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + layoutParams.rightMargin) + (f * this.mSlideRange)) + this.mSlideableView.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + layoutParams.leftMargin + (f * this.mSlideRange));
        }
        android.support.v4.widget.ViewDragHelper viewDragHelper = this.mDragHelper;
        android.view.View view = this.mSlideableView;
        if (!viewDragHelper.smoothSlideViewTo(view, paddingLeft, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    void updateObscuredViewsVisibility(android.view.View view) {
        int left;
        int right;
        int top;
        int bottom;
        android.view.View view2 = view;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        int width = zIsLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zIsLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            android.view.View childAt = getChildAt(i);
            if (childAt == view2) {
                return;
            }
            if (childAt.getVisibility() == 8) {
                zIsLayoutRtlSupport = zIsLayoutRtlSupport;
            } else {
                childAt.setVisibility((java.lang.Math.max(zIsLayoutRtlSupport ? paddingLeft : width, childAt.getLeft()) < left || java.lang.Math.max(paddingTop, childAt.getTop()) < top || java.lang.Math.min(zIsLayoutRtlSupport ? width : paddingLeft, childAt.getRight()) > right || java.lang.Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i++;
            zIsLayoutRtlSupport = zIsLayoutRtlSupport;
            view2 = view;
        }
    }
}
