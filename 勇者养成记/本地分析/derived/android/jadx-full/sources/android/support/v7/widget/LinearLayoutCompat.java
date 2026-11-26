package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LinearLayoutCompat extends android.view.ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private android.graphics.drawable.Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface DividerMode {
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.appcompat.R.styleable.LinearLayoutCompat_Layout);
            this.weight = typedArrayObtainStyledAttributes.getFloat(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams) {
            super((android.view.ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(android.content.Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, android.support.v7.appcompat.R.styleable.LinearLayoutCompat, i, 0);
        int i2 = tintTypedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = tintTypedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = tintTypedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = tintTypedArrayObtainStyledAttributes.getFloat(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = tintTypedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = tintTypedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = tintTypedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    private void forceUniformHeight(int i, int i2) {
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            android.view.View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, iMakeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            android.view.View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, iMakeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void setChildFrame(android.view.View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof android.support.v7.widget.LinearLayoutCompat.LayoutParams;
    }

    void drawDividersHorizontal(android.graphics.Canvas canvas) {
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean zIsLayoutRtl = android.support.v7.widget.ViewUtils.isLayoutRtl(this);
        for (int i = 0; i < virtualChildCount; i++) {
            android.view.View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, zIsLayoutRtl ? virtualChildAt.getRight() + layoutParams.rightMargin : (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            android.view.View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                left = zIsLayoutRtl ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.mDividerWidth;
            } else {
                android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams2 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt2.getLayoutParams();
                left = zIsLayoutRtl ? (virtualChildAt2.getLeft() - layoutParams2.leftMargin) - this.mDividerWidth : virtualChildAt2.getRight() + layoutParams2.rightMargin;
            }
            drawVerticalDivider(canvas, left);
        }
    }

    void drawDividersVertical(android.graphics.Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            android.view.View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            android.view.View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin);
        }
    }

    void drawHorizontalDivider(android.graphics.Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(android.graphics.Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public android.support.v7.widget.LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public android.support.v7.widget.LinearLayoutCompat.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new android.support.v7.widget.LinearLayoutCompat.LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public android.support.v7.widget.LinearLayoutCompat.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new android.support.v7.widget.LinearLayoutCompat.LayoutParams(layoutParams);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount <= i2) {
            throw new java.lang.RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        android.view.View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new java.lang.RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return bottom + ((android.support.v7.widget.LinearLayoutCompat.LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(android.view.View view, int i) {
        return 0;
    }

    public android.graphics.drawable.Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(android.view.View view) {
        return 0;
    }

    int getNextLocationOffset(android.view.View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    android.view.View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:48:0x010e  */
    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        int baseline;
        int i9;
        int i10;
        int measuredHeight;
        int i11;
        int i12;
        boolean zIsLayoutRtl = android.support.v7.widget.ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i13 = i4 - i2;
        int paddingBottom = i13 - getPaddingBottom();
        int paddingBottom2 = (i13 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i14 = this.mGravity;
        int i15 = i14 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = android.support.v4.view.GravityCompat.getAbsoluteGravity(8388615 & i14, android.support.v4.view.ViewCompat.getLayoutDirection(this));
        if (absoluteGravity != 1) {
            paddingLeft = absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        } else {
            paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        }
        if (zIsLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            int i16 = i5 + (i6 * childrenSkipCount);
            android.view.View virtualChildAt = getVirtualChildAt(i16);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i16);
                i7 = virtualChildCount;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight2 = virtualChildAt.getMeasuredHeight();
                android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                if (z) {
                    i8 = childrenSkipCount;
                    i7 = virtualChildCount;
                    baseline = layoutParams.height != -1 ? virtualChildAt.getBaseline() : -1;
                    i9 = layoutParams.gravity;
                    if (i9 < 0) {
                        i9 = i15;
                    }
                    i10 = i9 & 112;
                    if (i10 != 16) {
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                    } else if (i10 != 48) {
                        i11 = layoutParams.topMargin + paddingTop;
                        if (baseline != -1) {
                            measuredHeight = i11 + (iArr[1] - baseline);
                        } else {
                            measuredHeight = i11;
                        }
                    } else if (i10 != 80) {
                        measuredHeight = paddingTop;
                    } else {
                        i12 = (paddingBottom - measuredHeight2) - layoutParams.bottomMargin;
                        if (baseline != -1) {
                            measuredHeight = i12 - (iArr2[2] - (virtualChildAt.getMeasuredHeight() - baseline));
                        } else {
                            measuredHeight = i12;
                        }
                    }
                    if (hasDividerBeforeChildAt(i16)) {
                        paddingLeft += this.mDividerWidth;
                    }
                    int i17 = layoutParams.leftMargin + paddingLeft;
                    setChildFrame(virtualChildAt, i17 + getLocationOffset(virtualChildAt), measuredHeight, measuredWidth, measuredHeight2);
                    int nextLocationOffset = i17 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                    childrenSkipCount = i8 + getChildrenSkipCount(virtualChildAt, i16);
                    paddingLeft = nextLocationOffset;
                } else {
                    i8 = childrenSkipCount;
                    i7 = virtualChildCount;
                }
                i9 = layoutParams.gravity;
                if (i9 < 0) {
                    i9 = i15;
                }
                i10 = i9 & 112;
                if (i10 != 16) {
                    measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                } else if (i10 != 48) {
                    i11 = layoutParams.topMargin + paddingTop;
                    if (baseline != -1) {
                        measuredHeight = i11 + (iArr[1] - baseline);
                    } else {
                        measuredHeight = i11;
                    }
                } else if (i10 != 80) {
                    measuredHeight = paddingTop;
                } else {
                    i12 = (paddingBottom - measuredHeight2) - layoutParams.bottomMargin;
                    if (baseline != -1) {
                        measuredHeight = i12 - (iArr2[2] - (virtualChildAt.getMeasuredHeight() - baseline));
                    } else {
                        measuredHeight = i12;
                    }
                }
                if (hasDividerBeforeChildAt(i16)) {
                    paddingLeft += this.mDividerWidth;
                }
                int i18 = layoutParams.leftMargin + paddingLeft;
                setChildFrame(virtualChildAt, i18 + getLocationOffset(virtualChildAt), measuredHeight, measuredWidth, measuredHeight2);
                int nextLocationOffset2 = i18 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                childrenSkipCount = i8 + getChildrenSkipCount(virtualChildAt, i16);
                paddingLeft = nextLocationOffset2;
            } else {
                i7 = virtualChildCount;
            }
            childrenSkipCount++;
            virtualChildCount = i7;
            i15 = i15;
            paddingTop = paddingTop;
        }
    }

    void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i7 = this.mGravity;
        int i8 = i7 & 112;
        int i9 = i7 & android.support.v4.view.GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i8 != 16) {
            paddingTop = i8 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.mTotalLength;
        } else {
            paddingTop = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        }
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            android.view.View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(childrenSkipCount);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                int i10 = layoutParams.gravity;
                if (i10 < 0) {
                    i10 = i9;
                }
                int absoluteGravity = android.support.v4.view.GravityCompat.getAbsoluteGravity(i10, android.support.v4.view.ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity != 1) {
                    i5 = absoluteGravity != 5 ? layoutParams.leftMargin + paddingLeft : (paddingRight - measuredWidth) - layoutParams.rightMargin;
                } else {
                    i5 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                }
                if (hasDividerBeforeChildAt(childrenSkipCount)) {
                    paddingTop += this.mDividerHeight;
                }
                int i11 = paddingTop + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i5, i11 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                int nextLocationOffset = i11 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                paddingTop = nextLocationOffset;
            }
            childrenSkipCount++;
        }
    }

    void measureChildBeforeLayout(android.view.View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    void measureHorizontal(int i, int i2) {
        int[] iArr;
        int i3;
        int iMax;
        int i4;
        int i5;
        int i6;
        int i7;
        int baseline;
        int i8;
        int i9;
        int i10;
        boolean z;
        boolean z2;
        android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams;
        int i11;
        android.view.View view;
        int i12;
        boolean z3;
        int baseline2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z4 = this.mBaselineAligned;
        boolean z5 = this.mUseLargestChild;
        int i13 = 1073741824;
        boolean z6 = mode == 1073741824;
        int childrenSkipCount = 0;
        int iMax2 = Integer.MIN_VALUE;
        float f = 0.0f;
        int i14 = 0;
        int iMax3 = 0;
        int iMax4 = 0;
        boolean z7 = false;
        int i15 = 0;
        boolean z8 = true;
        boolean z9 = false;
        while (true) {
            iArr = iArr3;
            i3 = 8;
            if (childrenSkipCount >= virtualChildCount) {
                break;
            }
            android.view.View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(childrenSkipCount);
                z = z5;
                z2 = z4;
            } else if (virtualChildAt.getVisibility() == 8) {
                childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                z = z5;
                z2 = z4;
            } else {
                if (hasDividerBeforeChildAt(childrenSkipCount)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams2 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                f += layoutParams2.weight;
                if (mode == i13 && layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                    if (z6) {
                        this.mTotalLength += layoutParams2.leftMargin + layoutParams2.rightMargin;
                    } else {
                        int i16 = this.mTotalLength;
                        this.mTotalLength = java.lang.Math.max(i16, layoutParams2.leftMargin + i16 + layoutParams2.rightMargin);
                    }
                    if (z4) {
                        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        i10 = childrenSkipCount;
                        z = z5;
                        z2 = z4;
                        layoutParams = layoutParams2;
                        view = virtualChildAt;
                        i11 = -1;
                        i12 = 1073741824;
                    } else {
                        i10 = childrenSkipCount;
                        z = z5;
                        z2 = z4;
                        layoutParams = layoutParams2;
                        view = virtualChildAt;
                        i12 = 1073741824;
                        i11 = -1;
                        z7 = true;
                    }
                } else {
                    if (layoutParams2.width != 0 || layoutParams2.weight <= 0.0f) {
                        i9 = Integer.MIN_VALUE;
                    } else {
                        layoutParams2.width = -2;
                        i9 = 0;
                    }
                    i10 = childrenSkipCount;
                    int i17 = i9;
                    z = z5;
                    z2 = z4;
                    layoutParams = layoutParams2;
                    i11 = -1;
                    measureChildBeforeLayout(virtualChildAt, i10, i, f == 0.0f ? this.mTotalLength : 0, i2, 0);
                    if (i17 != Integer.MIN_VALUE) {
                        layoutParams.width = i17;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z6) {
                        view = virtualChildAt;
                        this.mTotalLength += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(view);
                    } else {
                        view = virtualChildAt;
                        int i18 = this.mTotalLength;
                        this.mTotalLength = java.lang.Math.max(i18, i18 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
                    }
                    if (z) {
                        iMax2 = java.lang.Math.max(measuredWidth, iMax2);
                        i12 = 1073741824;
                    } else {
                        i12 = 1073741824;
                    }
                }
                if (mode2 == i12 || layoutParams.height != i11) {
                    z3 = false;
                } else {
                    z3 = true;
                    z9 = true;
                }
                int i19 = layoutParams.topMargin + layoutParams.bottomMargin;
                int measuredHeight = view.getMeasuredHeight() + i19;
                int iCombineMeasuredStates = android.view.View.combineMeasuredStates(i15, view.getMeasuredState());
                if (z2 && (baseline2 = view.getBaseline()) != i11) {
                    int i20 = ((((layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & (-2)) >> 1;
                    iArr2[i20] = java.lang.Math.max(iArr2[i20], baseline2);
                    iArr[i20] = java.lang.Math.max(iArr[i20], measuredHeight - baseline2);
                }
                int iMax5 = java.lang.Math.max(i14, measuredHeight);
                boolean z10 = z8 && layoutParams.height == i11;
                if (layoutParams.weight > 0.0f) {
                    if (!z3) {
                        i19 = measuredHeight;
                    }
                    iMax4 = java.lang.Math.max(iMax4, i19);
                } else {
                    int i21 = iMax4;
                    if (z3) {
                        measuredHeight = i19;
                    }
                    iMax3 = java.lang.Math.max(iMax3, measuredHeight);
                    iMax4 = i21;
                }
                i14 = iMax5;
                childrenSkipCount = getChildrenSkipCount(view, i10) + i10;
                i15 = iCombineMeasuredStates;
                z8 = z10;
            }
            childrenSkipCount++;
            iArr3 = iArr;
            z5 = z;
            z4 = z2;
            i13 = 1073741824;
        }
        boolean z11 = z5;
        boolean z12 = z4;
        int iMax6 = i14;
        int i22 = iMax3;
        int i23 = iMax4;
        int iCombineMeasuredStates2 = i15;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr2[1] != -1 || iArr2[0] != -1 || iArr2[2] != -1 || iArr2[3] != -1) {
            iMax6 = java.lang.Math.max(iMax6, java.lang.Math.max(iArr2[3], java.lang.Math.max(iArr2[0], java.lang.Math.max(iArr2[1], iArr2[2]))) + java.lang.Math.max(iArr[3], java.lang.Math.max(iArr[0], java.lang.Math.max(iArr[1], iArr[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int childrenSkipCount2 = 0;
            while (childrenSkipCount2 < virtualChildCount) {
                android.view.View virtualChildAt2 = getVirtualChildAt(childrenSkipCount2);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(childrenSkipCount2);
                } else if (virtualChildAt2.getVisibility() == i3) {
                    childrenSkipCount2 += getChildrenSkipCount(virtualChildAt2, childrenSkipCount2);
                } else {
                    android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams3 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z6) {
                        this.mTotalLength += layoutParams3.leftMargin + iMax2 + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i24 = this.mTotalLength;
                        this.mTotalLength = java.lang.Math.max(i24, i24 + iMax2 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt2));
                    }
                }
                childrenSkipCount2++;
                i3 = 8;
            }
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int iResolveSizeAndState = android.view.View.resolveSizeAndState(java.lang.Math.max(this.mTotalLength, getSuggestedMinimumWidth()), i, 0);
        int i25 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
        if (z7 || (i25 != 0 && f > 0.0f)) {
            float f2 = this.mWeightSum;
            if (f2 <= 0.0f) {
                f2 = f;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i26 = i22;
            int iMax7 = -1;
            float f3 = f2;
            int i27 = 0;
            while (i27 < virtualChildCount) {
                android.view.View virtualChildAt3 = getVirtualChildAt(i27);
                if (virtualChildAt3 == null) {
                    i4 = i25;
                } else if (virtualChildAt3.getVisibility() == 8) {
                    i4 = i25;
                } else {
                    android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams4 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt3.getLayoutParams();
                    float f4 = layoutParams4.weight;
                    if (f4 > 0.0f) {
                        int i28 = (int) ((i25 * f4) / f3);
                        float f5 = f3 - f4;
                        int i29 = i25 - i28;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams4.topMargin + layoutParams4.bottomMargin, layoutParams4.height);
                        if (layoutParams4.width == 0) {
                            i8 = 1073741824;
                            if (mode == 1073741824) {
                                if (i28 <= 0) {
                                    i28 = 0;
                                }
                                virtualChildAt3.measure(android.view.View.MeasureSpec.makeMeasureSpec(i28, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates2 = android.view.View.combineMeasuredStates(iCombineMeasuredStates2, virtualChildAt3.getMeasuredState() & (-16777216));
                            f3 = f5;
                            i5 = i29;
                        } else {
                            i8 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i28;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(android.view.View.MeasureSpec.makeMeasureSpec(measuredWidth2, i8), childMeasureSpec);
                        iCombineMeasuredStates2 = android.view.View.combineMeasuredStates(iCombineMeasuredStates2, virtualChildAt3.getMeasuredState() & (-16777216));
                        f3 = f5;
                        i5 = i29;
                    } else {
                        i5 = i25;
                    }
                    if (z6) {
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + layoutParams4.leftMargin + layoutParams4.rightMargin + getNextLocationOffset(virtualChildAt3);
                        i6 = 1073741824;
                    } else {
                        int i30 = this.mTotalLength;
                        this.mTotalLength = java.lang.Math.max(i30, virtualChildAt3.getMeasuredWidth() + i30 + layoutParams4.leftMargin + layoutParams4.rightMargin + getNextLocationOffset(virtualChildAt3));
                        i6 = 1073741824;
                    }
                    boolean z13 = mode2 != i6 && layoutParams4.height == -1;
                    int i31 = layoutParams4.topMargin + layoutParams4.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i31;
                    iMax7 = java.lang.Math.max(iMax7, measuredHeight2);
                    if (!z13) {
                        i31 = measuredHeight2;
                    }
                    int iMax8 = java.lang.Math.max(i26, i31);
                    if (z8) {
                        i7 = -1;
                        boolean z14 = layoutParams4.height == -1;
                        if (!z12 && (baseline = virtualChildAt3.getBaseline()) != i7) {
                            int i32 = ((((layoutParams4.gravity < 0 ? this.mGravity : layoutParams4.gravity) & 112) >> 4) & (-2)) >> 1;
                            iArr2[i32] = java.lang.Math.max(iArr2[i32], baseline);
                            iArr[i32] = java.lang.Math.max(iArr[i32], measuredHeight2 - baseline);
                        }
                        i26 = iMax8;
                        z8 = z14;
                        i4 = i5;
                        f3 = f3;
                    } else {
                        i7 = -1;
                    }
                    if (!z12) {
                    }
                    i26 = iMax8;
                    z8 = z14;
                    i4 = i5;
                    f3 = f3;
                }
                i27++;
                i25 = i4;
            }
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            iMax6 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax7 : java.lang.Math.max(iMax7, java.lang.Math.max(iArr2[3], java.lang.Math.max(iArr2[0], java.lang.Math.max(iArr2[1], iArr2[2]))) + java.lang.Math.max(iArr[3], java.lang.Math.max(iArr[0], java.lang.Math.max(iArr[1], iArr[2]))));
            iMax = i26;
        } else {
            iMax = java.lang.Math.max(i22, i23);
            if (z11 && mode != 1073741824) {
                for (int i33 = 0; i33 < virtualChildCount; i33++) {
                    android.view.View virtualChildAt4 = getVirtualChildAt(i33);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt4.measure(android.view.View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
        }
        if (!z8 && mode2 != 1073741824) {
            iMax6 = iMax;
        }
        setMeasuredDimension(iResolveSizeAndState | ((-16777216) & iCombineMeasuredStates2), android.view.View.resolveSizeAndState(java.lang.Math.max(iMax6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
        if (z9) {
            forceUniformHeight(virtualChildCount, i);
        }
    }

    int measureNullChild(int i) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:149:0x033a  */
    /* JADX WARN: Code duplicated, block: B:155:0x0347  */
    /* JADX WARN: Code duplicated, block: B:59:0x016f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0176 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0179  */
    /* JADX WARN: Code duplicated, block: B:66:0x0184  */
    /* JADX WARN: Code duplicated, block: B:68:0x0188  */
    void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int iMax;
        int i5;
        float f;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams;
        android.view.View view;
        int i16;
        boolean z3;
        int i17;
        int measuredWidth;
        int iMax2;
        boolean z4;
        int iMax3;
        int iMax4;
        int i18;
        int iCombineMeasuredStates = 0;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int i19 = this.mBaselineAlignedChildIndex;
        boolean z5 = this.mUseLargestChild;
        float f2 = 0.0f;
        int i20 = 0;
        int iMax5 = Integer.MIN_VALUE;
        int i21 = 0;
        int childrenSkipCount = 0;
        boolean z6 = false;
        boolean z7 = true;
        boolean z8 = false;
        int i22 = 0;
        while (childrenSkipCount < virtualChildCount) {
            android.view.View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(childrenSkipCount);
                iMax2 = i20;
                i11 = virtualChildCount;
                i18 = i22;
                i12 = mode2;
            } else {
                int i23 = i20;
                if (virtualChildAt.getVisibility() == 8) {
                    childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                    i11 = virtualChildCount;
                    i18 = i22;
                    iMax2 = i23;
                    i12 = mode2;
                } else {
                    if (hasDividerBeforeChildAt(childrenSkipCount)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams2 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                    float f3 = f2 + layoutParams2.weight;
                    if (mode2 == 1073741824 && layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                        int i24 = this.mTotalLength;
                        this.mTotalLength = java.lang.Math.max(i24, layoutParams2.topMargin + i24 + layoutParams2.bottomMargin);
                        i14 = i21;
                        view = virtualChildAt;
                        i11 = virtualChildCount;
                        i10 = i23;
                        iMax5 = iMax5;
                        z6 = true;
                        i13 = childrenSkipCount;
                        i15 = i22;
                        i12 = mode2;
                        layoutParams = layoutParams2;
                    } else {
                        int i25 = iMax5;
                        if (layoutParams2.height != 0 || layoutParams2.weight <= 0.0f) {
                            i9 = Integer.MIN_VALUE;
                        } else {
                            layoutParams2.height = -2;
                            i9 = 0;
                        }
                        i10 = i23;
                        int i26 = i9;
                        i11 = virtualChildCount;
                        int i27 = i22;
                        i12 = mode2;
                        i13 = childrenSkipCount;
                        i14 = i21;
                        i15 = i27;
                        layoutParams = layoutParams2;
                        measureChildBeforeLayout(virtualChildAt, childrenSkipCount, i, 0, i2, f3 == 0.0f ? this.mTotalLength : 0);
                        if (i26 != Integer.MIN_VALUE) {
                            layoutParams.height = i26;
                        }
                        int measuredHeight = virtualChildAt.getMeasuredHeight();
                        int i28 = this.mTotalLength;
                        view = virtualChildAt;
                        this.mTotalLength = java.lang.Math.max(i28, i28 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
                        iMax5 = z5 ? java.lang.Math.max(measuredHeight, i25) : i25;
                    }
                    if (i19 >= 0 && i19 == i13 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i13 < i19 && layoutParams.weight > 0.0f) {
                        throw new java.lang.RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode != 1073741824) {
                        i16 = -1;
                        if (layoutParams.width == -1) {
                            z3 = true;
                            z8 = true;
                        }
                        i17 = layoutParams.leftMargin + layoutParams.rightMargin;
                        measuredWidth = view.getMeasuredWidth() + i17;
                        iMax2 = java.lang.Math.max(i10, measuredWidth);
                        int iCombineMeasuredStates2 = android.view.View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                        if (z7 || layoutParams.width != i16) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        if (layoutParams.weight > 0.0f) {
                            if (!z3) {
                                i17 = measuredWidth;
                            }
                            iMax3 = java.lang.Math.max(i14, i17);
                            iMax4 = i15;
                        } else {
                            iMax3 = i14;
                            if (z3) {
                                measuredWidth = i17;
                            }
                            iMax4 = java.lang.Math.max(i15, measuredWidth);
                        }
                        childrenSkipCount = i13 + getChildrenSkipCount(view, i13);
                        z7 = z4;
                        iCombineMeasuredStates = iCombineMeasuredStates2;
                        i21 = iMax3;
                        i18 = iMax4;
                        f2 = f3;
                    } else {
                        i16 = -1;
                    }
                    z3 = false;
                    i17 = layoutParams.leftMargin + layoutParams.rightMargin;
                    measuredWidth = view.getMeasuredWidth() + i17;
                    iMax2 = java.lang.Math.max(i10, measuredWidth);
                    int iCombineMeasuredStates3 = android.view.View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                    if (z7) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    if (layoutParams.weight > 0.0f) {
                        if (!z3) {
                            i17 = measuredWidth;
                        }
                        iMax3 = java.lang.Math.max(i14, i17);
                        iMax4 = i15;
                    } else {
                        iMax3 = i14;
                        if (z3) {
                            measuredWidth = i17;
                        }
                        iMax4 = java.lang.Math.max(i15, measuredWidth);
                    }
                    childrenSkipCount = i13 + getChildrenSkipCount(view, i13);
                    z7 = z4;
                    iCombineMeasuredStates = iCombineMeasuredStates3;
                    i21 = iMax3;
                    i18 = iMax4;
                    f2 = f3;
                }
            }
            childrenSkipCount++;
            mode2 = i12;
            virtualChildCount = i11;
            i22 = i18;
            i20 = iMax2;
        }
        int iMax6 = i20;
        int i29 = iMax5;
        int i30 = virtualChildCount;
        int i31 = i22;
        int i32 = mode2;
        int i33 = i21;
        if (this.mTotalLength > 0) {
            i3 = i30;
            if (hasDividerBeforeChildAt(i3)) {
                this.mTotalLength += this.mDividerHeight;
            }
        } else {
            i3 = i30;
        }
        if (z5) {
            i4 = i32;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                this.mTotalLength = 0;
                int childrenSkipCount2 = 0;
                while (childrenSkipCount2 < i3) {
                    android.view.View virtualChildAt2 = getVirtualChildAt(childrenSkipCount2);
                    if (virtualChildAt2 == null) {
                        this.mTotalLength += measureNullChild(childrenSkipCount2);
                    } else if (virtualChildAt2.getVisibility() == 8) {
                        childrenSkipCount2 += getChildrenSkipCount(virtualChildAt2, childrenSkipCount2);
                    } else {
                        android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams3 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt2.getLayoutParams();
                        int i34 = this.mTotalLength;
                        this.mTotalLength = java.lang.Math.max(i34, i34 + i29 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt2));
                    }
                    childrenSkipCount2++;
                }
            }
        } else {
            i4 = i32;
        }
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        int iResolveSizeAndState = android.view.View.resolveSizeAndState(java.lang.Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i2, 0);
        int i35 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
        if (z6 || (i35 != 0 && f2 > 0.0f)) {
            float f4 = this.mWeightSum;
            if (f4 > 0.0f) {
                f2 = f4;
            }
            this.mTotalLength = 0;
            float f5 = f2;
            int i36 = 0;
            while (i36 < i3) {
                android.view.View virtualChildAt3 = getVirtualChildAt(i36);
                if (virtualChildAt3.getVisibility() == 8) {
                    i6 = i35;
                } else {
                    android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutParams4 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = layoutParams4.weight;
                    if (f6 > 0.0f) {
                        int i37 = (int) ((i35 * f6) / f5);
                        int i38 = i35 - i37;
                        f = f5 - f6;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams4.leftMargin + layoutParams4.rightMargin, layoutParams4.width);
                        if (layoutParams4.height == 0) {
                            i8 = 1073741824;
                            if (i4 == 1073741824) {
                                if (i37 <= 0) {
                                    i37 = 0;
                                }
                                virtualChildAt3.measure(childMeasureSpec, android.view.View.MeasureSpec.makeMeasureSpec(i37, 1073741824));
                            }
                            iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt3.getMeasuredState() & android.support.v4.view.InputDeviceCompat.SOURCE_ANY);
                            i5 = i38;
                        } else {
                            i8 = 1073741824;
                        }
                        int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i37;
                        if (measuredHeight2 < 0) {
                            measuredHeight2 = 0;
                        }
                        virtualChildAt3.measure(childMeasureSpec, android.view.View.MeasureSpec.makeMeasureSpec(measuredHeight2, i8));
                        iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt3.getMeasuredState() & android.support.v4.view.InputDeviceCompat.SOURCE_ANY);
                        i5 = i38;
                    } else {
                        i5 = i35;
                        f = f5;
                    }
                    int i39 = layoutParams4.leftMargin + layoutParams4.rightMargin;
                    int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i39;
                    iMax6 = java.lang.Math.max(iMax6, measuredWidth2);
                    if (mode != 1073741824) {
                        i6 = i5;
                        i7 = -1;
                        z = layoutParams4.width == -1;
                        if (z) {
                            measuredWidth2 = i39;
                        }
                        int iMax7 = java.lang.Math.max(i31, measuredWidth2);
                        if (z7 || layoutParams4.width != i7) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        int i40 = this.mTotalLength;
                        this.mTotalLength = java.lang.Math.max(i40, virtualChildAt3.getMeasuredHeight() + i40 + layoutParams4.topMargin + layoutParams4.bottomMargin + getNextLocationOffset(virtualChildAt3));
                        z7 = z2;
                        f5 = f;
                        i31 = iMax7;
                    } else {
                        i6 = i5;
                        i7 = -1;
                    }
                    if (z) {
                        measuredWidth2 = i39;
                    }
                    int iMax8 = java.lang.Math.max(i31, measuredWidth2);
                    if (z7) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    int i41 = this.mTotalLength;
                    this.mTotalLength = java.lang.Math.max(i41, virtualChildAt3.getMeasuredHeight() + i41 + layoutParams4.topMargin + layoutParams4.bottomMargin + getNextLocationOffset(virtualChildAt3));
                    z7 = z2;
                    f5 = f;
                    i31 = iMax8;
                }
                i36++;
                i4 = i4;
                i35 = i6;
            }
            this.mTotalLength += getPaddingTop() + getPaddingBottom();
            iMax = i31;
        } else {
            iMax = java.lang.Math.max(i31, i33);
            if (z5 && i4 != 1073741824) {
                for (int i42 = 0; i42 < i3; i42++) {
                    android.view.View virtualChildAt4 = getVirtualChildAt(i42);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((android.support.v7.widget.LinearLayoutCompat.LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt4.measure(android.view.View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(i29, 1073741824));
                    }
                }
            }
        }
        if (z7 || mode == 1073741824) {
            iMax = iMax6;
        }
        setMeasuredDimension(android.view.View.resolveSizeAndState(java.lang.Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates), iResolveSizeAndState);
        if (z8) {
            forceUniformWidth(i3, i2);
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.widget.LinearLayoutCompat.class.getName());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(android.support.v7.widget.LinearLayoutCompat.class.getName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.mBaselineAlignedChildIndex = i;
            return;
        }
        throw new java.lang.IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(android.graphics.drawable.Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= android.support.v4.view.GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & android.support.v4.view.GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & com.tencent.safecloud.device.openlib.DeviceConfig.ERR_SERVER_NET);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = java.lang.Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
