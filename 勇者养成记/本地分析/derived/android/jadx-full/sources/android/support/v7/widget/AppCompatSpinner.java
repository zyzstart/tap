package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AppCompatSpinner extends android.widget.Spinner implements android.support.v4.view.TintableBackgroundView {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = {android.R.attr.spinnerMode};
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final java.lang.String TAG = "AppCompatSpinner";
    private final android.support.v7.widget.AppCompatBackgroundHelper mBackgroundTintHelper;
    private int mDropDownWidth;
    private android.support.v7.widget.ForwardingListener mForwardingListener;
    private android.support.v7.widget.AppCompatSpinner.DropdownPopup mPopup;
    private final android.content.Context mPopupContext;
    private final boolean mPopupSet;
    private android.widget.SpinnerAdapter mTempAdapter;
    private final android.graphics.Rect mTempRect;

    private static class DropDownAdapter implements android.widget.ListAdapter, android.widget.SpinnerAdapter {
        private android.widget.SpinnerAdapter mAdapter;
        private android.widget.ListAdapter mListAdapter;

        public DropDownAdapter(@android.support.annotation.Nullable android.widget.SpinnerAdapter spinnerAdapter, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) {
            this.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof android.widget.ListAdapter) {
                this.mListAdapter = (android.widget.ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (android.os.Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)) {
                    android.widget.ThemedSpinnerAdapter themedSpinnerAdapter = (android.widget.ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof android.support.v7.widget.ThemedSpinnerAdapter) {
                    android.support.v7.widget.ThemedSpinnerAdapter themedSpinnerAdapter2 = (android.support.v7.widget.ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                        themedSpinnerAdapter2.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            android.widget.ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public android.view.View getDropDownView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i) {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            android.widget.ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(android.database.DataSetObserver dataSetObserver) {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(android.database.DataSetObserver dataSetObserver) {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class DropdownPopup extends android.support.v7.widget.ListPopupWindow {
        android.widget.ListAdapter mAdapter;
        private java.lang.CharSequence mHintText;
        private final android.graphics.Rect mVisibleRect;

        public DropdownPopup(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mVisibleRect = new android.graphics.Rect();
            setAnchorView(android.support.v7.widget.AppCompatSpinner.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.AppCompatSpinner.DropdownPopup.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i2, long j) {
                    android.support.v7.widget.AppCompatSpinner.this.setSelection(i2);
                    if (android.support.v7.widget.AppCompatSpinner.this.getOnItemClickListener() != null) {
                        android.support.v7.widget.AppCompatSpinner.this.performItemClick(view, i2, android.support.v7.widget.AppCompatSpinner.DropdownPopup.this.mAdapter.getItemId(i2));
                    }
                    android.support.v7.widget.AppCompatSpinner.DropdownPopup.this.dismiss();
                }
            });
        }

        void computeContentWidth() {
            android.graphics.drawable.Drawable background = getBackground();
            int i = 0;
            if (background != null) {
                background.getPadding(android.support.v7.widget.AppCompatSpinner.this.mTempRect);
                i = android.support.v7.widget.ViewUtils.isLayoutRtl(android.support.v7.widget.AppCompatSpinner.this) ? android.support.v7.widget.AppCompatSpinner.this.mTempRect.right : -android.support.v7.widget.AppCompatSpinner.this.mTempRect.left;
            } else {
                android.graphics.Rect rect = android.support.v7.widget.AppCompatSpinner.this.mTempRect;
                android.support.v7.widget.AppCompatSpinner.this.mTempRect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = android.support.v7.widget.AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = android.support.v7.widget.AppCompatSpinner.this.getPaddingRight();
            int width = android.support.v7.widget.AppCompatSpinner.this.getWidth();
            if (android.support.v7.widget.AppCompatSpinner.this.mDropDownWidth == -2) {
                int iCompatMeasureContentWidth = android.support.v7.widget.AppCompatSpinner.this.compatMeasureContentWidth((android.widget.SpinnerAdapter) this.mAdapter, getBackground());
                int i2 = (android.support.v7.widget.AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - android.support.v7.widget.AppCompatSpinner.this.mTempRect.left) - android.support.v7.widget.AppCompatSpinner.this.mTempRect.right;
                if (iCompatMeasureContentWidth > i2) {
                    iCompatMeasureContentWidth = i2;
                }
                setContentWidth(java.lang.Math.max(iCompatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (android.support.v7.widget.AppCompatSpinner.this.mDropDownWidth == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(android.support.v7.widget.AppCompatSpinner.this.mDropDownWidth);
            }
            setHorizontalOffset(android.support.v7.widget.ViewUtils.isLayoutRtl(android.support.v7.widget.AppCompatSpinner.this) ? i + ((width - paddingRight) - getWidth()) : i + paddingLeft);
        }

        public java.lang.CharSequence getHintText() {
            return this.mHintText;
        }

        boolean isVisibleToUser(android.view.View view) {
            return android.support.v4.view.ViewCompat.isAttachedToWindow(view) && view.getGlobalVisibleRect(this.mVisibleRect);
        }

        @Override // android.support.v7.widget.ListPopupWindow
        public void setAdapter(android.widget.ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mAdapter = listAdapter;
        }

        public void setPromptText(java.lang.CharSequence charSequence) {
            this.mHintText = charSequence;
        }

        @Override // android.support.v7.widget.ListPopupWindow, android.support.v7.view.menu.ShowableListMenu
        public void show() {
            android.view.ViewTreeObserver viewTreeObserver;
            boolean zIsShowing = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(1);
            setSelection(android.support.v7.widget.AppCompatSpinner.this.getSelectedItemPosition());
            if (zIsShowing || (viewTreeObserver = android.support.v7.widget.AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            final android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.AppCompatSpinner.DropdownPopup.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = android.support.v7.widget.AppCompatSpinner.DropdownPopup.this;
                    if (!dropdownPopup.isVisibleToUser(android.support.v7.widget.AppCompatSpinner.this)) {
                        android.support.v7.widget.AppCompatSpinner.DropdownPopup.this.dismiss();
                    } else {
                        android.support.v7.widget.AppCompatSpinner.DropdownPopup.this.computeContentWidth();
                        android.support.v7.widget.AppCompatSpinner.DropdownPopup.super.show();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.AppCompatSpinner.DropdownPopup.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    android.view.ViewTreeObserver viewTreeObserver2 = android.support.v7.widget.AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }
    }

    public AppCompatSpinner(android.content.Context context) {
        this(context, (android.util.AttributeSet) null);
    }

    public AppCompatSpinner(android.content.Context context, int i) {
        this(context, null, android.support.v7.appcompat.R.attr.spinnerStyle, i);
    }

    public AppCompatSpinner(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v14, types: [int] */
    /* JADX WARN: Type inference failed for: r12v16 */
    public AppCompatSpinner(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2, android.content.res.Resources.Theme theme) throws java.lang.Throwable {
        java.lang.CharSequence[] textArray;
        android.widget.SpinnerAdapter spinnerAdapter;
        android.content.res.TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.mTempRect = new android.graphics.Rect();
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, android.support.v7.appcompat.R.styleable.Spinner, i, 0);
        this.mBackgroundTintHelper = new android.support.v7.widget.AppCompatBackgroundHelper(this);
        if (theme != null) {
            this.mPopupContext = new android.support.v7.view.ContextThemeWrapper(context, theme);
        } else {
            int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.Spinner_popupTheme, 0);
            if (resourceId != 0) {
                this.mPopupContext = new android.support.v7.view.ContextThemeWrapper(context, resourceId);
            } else {
                this.mPopupContext = android.os.Build.VERSION.SDK_INT < 23 ? context : null;
            }
        }
        if (this.mPopupContext != null) {
            if (i2 == -1) {
                android.content.res.TypedArray typedArray = android.os.Build.VERSION.SDK_INT;
                try {
                    if (typedArray >= 11) {
                        try {
                            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS_ANDROID_SPINNERMODE, i, 0);
                            try {
                                i2 = typedArrayObtainStyledAttributes.hasValue(0) ? typedArrayObtainStyledAttributes.getInt(0, 0) : i2;
                                if (typedArrayObtainStyledAttributes != null) {
                                    typedArrayObtainStyledAttributes.recycle();
                                }
                            } catch (java.lang.Exception e) {
                                e = e;
                                android.util.Log.i(TAG, "Could not read android:spinnerMode", e);
                                if (typedArrayObtainStyledAttributes != null) {
                                }
                                if (i2 == 1) {
                                    final android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = new android.support.v7.widget.AppCompatSpinner.DropdownPopup(this.mPopupContext, attributeSet, i);
                                    android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes2 = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(this.mPopupContext, attributeSet, android.support.v7.appcompat.R.styleable.Spinner, i, 0);
                                    this.mDropDownWidth = tintTypedArrayObtainStyledAttributes2.getLayoutDimension(android.support.v7.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
                                    dropdownPopup.setBackgroundDrawable(tintTypedArrayObtainStyledAttributes2.getDrawable(android.support.v7.appcompat.R.styleable.Spinner_android_popupBackground));
                                    dropdownPopup.setPromptText(tintTypedArrayObtainStyledAttributes.getString(android.support.v7.appcompat.R.styleable.Spinner_android_prompt));
                                    tintTypedArrayObtainStyledAttributes2.recycle();
                                    this.mPopup = dropdownPopup;
                                    this.mForwardingListener = new android.support.v7.widget.ForwardingListener(this) { // from class: android.support.v7.widget.AppCompatSpinner.1
                                        @Override // android.support.v7.widget.ForwardingListener
                                        public android.support.v7.view.menu.ShowableListMenu getPopup() {
                                            return dropdownPopup;
                                        }

                                        @Override // android.support.v7.widget.ForwardingListener
                                        public boolean onForwardingStarted() {
                                            if (android.support.v7.widget.AppCompatSpinner.this.mPopup.isShowing()) {
                                                return true;
                                            }
                                            android.support.v7.widget.AppCompatSpinner.this.mPopup.show();
                                            return true;
                                        }
                                    };
                                }
                                textArray = tintTypedArrayObtainStyledAttributes.getTextArray(android.support.v7.appcompat.R.styleable.Spinner_android_entries);
                                if (textArray != null) {
                                    android.widget.ArrayAdapter arrayAdapter = new android.widget.ArrayAdapter(context, android.R.layout.simple_spinner_item, textArray);
                                    arrayAdapter.setDropDownViewResource(android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item);
                                    setAdapter((android.widget.SpinnerAdapter) arrayAdapter);
                                }
                                tintTypedArrayObtainStyledAttributes.recycle();
                                this.mPopupSet = true;
                                spinnerAdapter = this.mTempAdapter;
                                if (spinnerAdapter != null) {
                                    setAdapter(spinnerAdapter);
                                    this.mTempAdapter = null;
                                }
                                this.mBackgroundTintHelper.loadFromAttributes(attributeSet, i);
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            typedArrayObtainStyledAttributes = null;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            typedArray = 0;
                            if (typedArray != 0) {
                                typedArray.recycle();
                            }
                            throw th;
                        }
                    } else {
                        i2 = 1;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
            if (i2 == 1) {
                final android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup2 = new android.support.v7.widget.AppCompatSpinner.DropdownPopup(this.mPopupContext, attributeSet, i);
                android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes3 = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(this.mPopupContext, attributeSet, android.support.v7.appcompat.R.styleable.Spinner, i, 0);
                this.mDropDownWidth = tintTypedArrayObtainStyledAttributes3.getLayoutDimension(android.support.v7.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
                dropdownPopup2.setBackgroundDrawable(tintTypedArrayObtainStyledAttributes3.getDrawable(android.support.v7.appcompat.R.styleable.Spinner_android_popupBackground));
                dropdownPopup2.setPromptText(tintTypedArrayObtainStyledAttributes.getString(android.support.v7.appcompat.R.styleable.Spinner_android_prompt));
                tintTypedArrayObtainStyledAttributes3.recycle();
                this.mPopup = dropdownPopup2;
                this.mForwardingListener = new android.support.v7.widget.ForwardingListener(this) { // from class: android.support.v7.widget.AppCompatSpinner.1
                    @Override // android.support.v7.widget.ForwardingListener
                    public android.support.v7.view.menu.ShowableListMenu getPopup() {
                        return dropdownPopup2;
                    }

                    @Override // android.support.v7.widget.ForwardingListener
                    public boolean onForwardingStarted() {
                        if (android.support.v7.widget.AppCompatSpinner.this.mPopup.isShowing()) {
                            return true;
                        }
                        android.support.v7.widget.AppCompatSpinner.this.mPopup.show();
                        return true;
                    }
                };
            }
        }
        textArray = tintTypedArrayObtainStyledAttributes.getTextArray(android.support.v7.appcompat.R.styleable.Spinner_android_entries);
        if (textArray != null) {
            android.widget.ArrayAdapter arrayAdapter2 = new android.widget.ArrayAdapter(context, android.R.layout.simple_spinner_item, textArray);
            arrayAdapter2.setDropDownViewResource(android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item);
            setAdapter((android.widget.SpinnerAdapter) arrayAdapter2);
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        this.mPopupSet = true;
        spinnerAdapter = this.mTempAdapter;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.mTempAdapter = null;
        }
        this.mBackgroundTintHelper.loadFromAttributes(attributeSet, i);
    }

    int compatMeasureContentWidth(android.widget.SpinnerAdapter spinnerAdapter, android.graphics.drawable.Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = java.lang.Math.max(0, getSelectedItemPosition());
        int iMin = java.lang.Math.min(spinnerAdapter.getCount(), iMax + 15);
        android.view.View view = null;
        int iMax2 = 0;
        for (int iMax3 = java.lang.Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = java.lang.Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.mTempRect);
        return iMax2 + this.mTempRect.left + this.mTempRect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        android.support.v7.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup != null) {
            return dropdownPopup.getHorizontalOffset();
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup != null) {
            return dropdownPopup.getVerticalOffset();
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public android.graphics.drawable.Drawable getPopupBackground() {
        android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup != null) {
            return dropdownPopup.getBackground();
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public android.content.Context getPopupContext() {
        if (this.mPopup != null) {
            return this.mPopupContext;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public java.lang.CharSequence getPrompt() {
        android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = this.mPopup;
        return dropdownPopup != null ? dropdownPopup.getHintText() : super.getPrompt();
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @android.support.annotation.Nullable
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public android.content.res.ColorStateList getSupportBackgroundTintList() {
        android.support.v7.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @android.support.annotation.Nullable
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        android.support.v7.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup == null || !dropdownPopup.isShowing()) {
            return;
        }
        this.mPopup.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup == null || android.view.View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(java.lang.Math.min(java.lang.Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), android.view.View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        android.support.v7.widget.ForwardingListener forwardingListener = this.mForwardingListener;
        if (forwardingListener == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup == null) {
            return super.performClick();
        }
        if (dropdownPopup.isShowing()) {
            return true;
        }
        this.mPopup.show();
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(android.widget.SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup != null) {
            android.content.Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            this.mPopup.setAdapter(new android.support.v7.widget.AppCompatSpinner.DropDownAdapter(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        android.support.v7.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@android.support.annotation.DrawableRes int i) {
        super.setBackgroundResource(i);
        android.support.v7.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup != null) {
            dropdownPopup.setHorizontalOffset(i);
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup != null) {
            dropdownPopup.setVerticalOffset(i);
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup != null) {
            dropdownPopup.setBackgroundDrawable(drawable);
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@android.support.annotation.DrawableRes int i) {
        setPopupBackgroundDrawable(android.support.v7.content.res.AppCompatResources.getDrawable(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(java.lang.CharSequence charSequence) {
        android.support.v7.widget.AppCompatSpinner.DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup != null) {
            dropdownPopup.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@android.support.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        android.support.v7.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@android.support.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        android.support.v7.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }
}
