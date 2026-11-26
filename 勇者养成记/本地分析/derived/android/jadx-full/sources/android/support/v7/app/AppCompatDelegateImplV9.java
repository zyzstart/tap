package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(14)
class AppCompatDelegateImplV9 extends android.support.v7.app.AppCompatDelegateImplBase implements android.support.v7.view.menu.MenuBuilder.Callback, android.view.LayoutInflater.Factory2 {
    private static final boolean IS_PRE_LOLLIPOP;
    private android.support.v7.app.AppCompatDelegateImplV9.ActionMenuPresenterCallback mActionMenuPresenterCallback;
    android.support.v7.view.ActionMode mActionMode;
    android.widget.PopupWindow mActionModePopup;
    android.support.v7.widget.ActionBarContextView mActionModeView;
    private android.support.v7.app.AppCompatViewInflater mAppCompatViewInflater;
    private boolean mClosingActionMenu;
    private android.support.v7.widget.DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    android.support.v4.view.ViewPropertyAnimatorCompat mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    int mInvalidatePanelMenuFeatures;
    boolean mInvalidatePanelMenuPosted;
    private final java.lang.Runnable mInvalidatePanelMenuRunnable;
    private boolean mLongPressBackDown;
    private android.support.v7.app.AppCompatDelegateImplV9.PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState[] mPanels;
    private android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState mPreparedPanel;
    java.lang.Runnable mShowActionModePopup;
    private android.view.View mStatusGuard;
    private android.view.ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private android.graphics.Rect mTempRect1;
    private android.graphics.Rect mTempRect2;
    private android.widget.TextView mTitleView;

    private final class ActionMenuPresenterCallback implements android.support.v7.view.menu.MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z) {
            android.support.v7.app.AppCompatDelegateImplV9.this.checkCloseActionMenu(menuBuilder);
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(android.support.v7.view.menu.MenuBuilder menuBuilder) {
            android.view.Window.Callback windowCallback = android.support.v7.app.AppCompatDelegateImplV9.this.getWindowCallback();
            if (windowCallback == null) {
                return true;
            }
            windowCallback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    class ActionModeCallbackWrapperV9 implements android.support.v7.view.ActionMode.Callback {
        private android.support.v7.view.ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapperV9(android.support.v7.view.ActionMode.Callback callback) {
            this.mWrapped = callback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(android.support.v7.view.ActionMode actionMode, android.view.MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(android.support.v7.view.ActionMode actionMode, android.view.Menu menu) {
            return this.mWrapped.onCreateActionMode(actionMode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(android.support.v7.view.ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            if (android.support.v7.app.AppCompatDelegateImplV9.this.mActionModePopup != null) {
                android.support.v7.app.AppCompatDelegateImplV9.this.mWindow.getDecorView().removeCallbacks(android.support.v7.app.AppCompatDelegateImplV9.this.mShowActionModePopup);
            }
            if (android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView != null) {
                android.support.v7.app.AppCompatDelegateImplV9.this.endOnGoingFadeAnimation();
                android.support.v7.app.AppCompatDelegateImplV9 appCompatDelegateImplV9 = android.support.v7.app.AppCompatDelegateImplV9.this;
                appCompatDelegateImplV9.mFadeAnim = android.support.v4.view.ViewCompat.animate(appCompatDelegateImplV9.mActionModeView).alpha(0.0f);
                android.support.v7.app.AppCompatDelegateImplV9.this.mFadeAnim.setListener(new android.support.v4.view.ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.ActionModeCallbackWrapperV9.1
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(android.view.View view) {
                        android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.setVisibility(8);
                        if (android.support.v7.app.AppCompatDelegateImplV9.this.mActionModePopup != null) {
                            android.support.v7.app.AppCompatDelegateImplV9.this.mActionModePopup.dismiss();
                        } else if (android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.getParent() instanceof android.view.View) {
                            android.support.v4.view.ViewCompat.requestApplyInsets((android.view.View) android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.getParent());
                        }
                        android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.removeAllViews();
                        android.support.v7.app.AppCompatDelegateImplV9.this.mFadeAnim.setListener(null);
                        android.support.v7.app.AppCompatDelegateImplV9.this.mFadeAnim = null;
                    }
                });
            }
            if (android.support.v7.app.AppCompatDelegateImplV9.this.mAppCompatCallback != null) {
                android.support.v7.app.AppCompatDelegateImplV9.this.mAppCompatCallback.onSupportActionModeFinished(android.support.v7.app.AppCompatDelegateImplV9.this.mActionMode);
            }
            android.support.v7.app.AppCompatDelegateImplV9.this.mActionMode = null;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(android.support.v7.view.ActionMode actionMode, android.view.Menu menu) {
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }
    }

    private class ListMenuDecorView extends android.support.v7.widget.ContentFrameLayout {
        public ListMenuDecorView(android.content.Context context) {
            super(context);
        }

        private boolean isOutOfBounds(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
            return android.support.v7.app.AppCompatDelegateImplV9.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !isOutOfBounds((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            android.support.v7.app.AppCompatDelegateImplV9.this.closePanel(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(android.support.v7.content.res.AppCompatResources.getDrawable(getContext(), i));
        }
    }

    protected static final class PanelFeatureState {
        int background;
        android.view.View createdPanelView;
        android.view.ViewGroup decorView;
        int featureId;
        android.os.Bundle frozenActionViewState;
        android.os.Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        android.support.v7.view.menu.ListMenuPresenter listMenuPresenter;
        android.content.Context listPresenterContext;
        android.support.v7.view.menu.MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView = false;
        boolean refreshMenuContent;
        android.view.View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;
        int x;
        int y;

        private static class SavedState implements android.os.Parcelable {
            public static final android.os.Parcelable.Creator<android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState>() { // from class: android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState.1
                @Override // android.os.Parcelable.Creator
                public android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState createFromParcel(android.os.Parcel parcel) {
                    return android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState.readFromParcel(parcel, null);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                    return android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState.readFromParcel(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState[] newArray(int i) {
                    return new android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState[i];
                }
            };
            int featureId;
            boolean isOpen;
            android.os.Bundle menuState;

            SavedState() {
            }

            static android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState readFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState savedState = new android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState();
                savedState.featureId = parcel.readInt();
                savedState.isOpen = parcel.readInt() == 1;
                if (savedState.isOpen) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(android.os.Parcel parcel, int i) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }
        }

        PanelFeatureState(int i) {
            this.featureId = i;
        }

        void applyFrozenState() {
            android.os.Bundle bundle;
            android.support.v7.view.menu.MenuBuilder menuBuilder = this.menu;
            if (menuBuilder == null || (bundle = this.frozenMenuState) == null) {
                return;
            }
            menuBuilder.restorePresenterStates(bundle);
            this.frozenMenuState = null;
        }

        public void clearMenuPresenters() {
            android.support.v7.view.menu.MenuBuilder menuBuilder = this.menu;
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.listMenuPresenter);
            }
            this.listMenuPresenter = null;
        }

        android.support.v7.view.menu.MenuView getListMenuView(android.support.v7.view.menu.MenuPresenter.Callback callback) {
            if (this.menu == null) {
                return null;
            }
            if (this.listMenuPresenter == null) {
                this.listMenuPresenter = new android.support.v7.view.menu.ListMenuPresenter(this.listPresenterContext, android.support.v7.appcompat.R.layout.abc_list_menu_item_layout);
                this.listMenuPresenter.setCallback(callback);
                this.menu.addMenuPresenter(this.listMenuPresenter);
            }
            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        public boolean hasPanelItems() {
            if (this.shownPanelView == null) {
                return false;
            }
            return this.createdPanelView != null || this.listMenuPresenter.getAdapter().getCount() > 0;
        }

        void onRestoreInstanceState(android.os.Parcelable parcelable) {
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState savedState = (android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState) parcelable;
            this.featureId = savedState.featureId;
            this.wasLastOpen = savedState.isOpen;
            this.frozenMenuState = savedState.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        android.os.Parcelable onSaveInstanceState() {
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState savedState = new android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState();
            savedState.featureId = this.featureId;
            savedState.isOpen = this.isOpen;
            if (this.menu != null) {
                savedState.menuState = new android.os.Bundle();
                this.menu.savePresenterStates(savedState.menuState);
            }
            return savedState;
        }

        void setMenu(android.support.v7.view.menu.MenuBuilder menuBuilder) {
            android.support.v7.view.menu.ListMenuPresenter listMenuPresenter;
            android.support.v7.view.menu.MenuBuilder menuBuilder2 = this.menu;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.removeMenuPresenter(this.listMenuPresenter);
            }
            this.menu = menuBuilder;
            if (menuBuilder == null || (listMenuPresenter = this.listMenuPresenter) == null) {
                return;
            }
            menuBuilder.addMenuPresenter(listMenuPresenter);
        }

        void setStyle(android.content.Context context) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            android.content.res.Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            themeNewTheme.resolveAttribute(android.support.v7.appcompat.R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            } else {
                themeNewTheme.applyStyle(android.support.v7.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            android.support.v7.view.ContextThemeWrapper contextThemeWrapper = new android.support.v7.view.ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(themeNewTheme);
            this.listPresenterContext = contextThemeWrapper;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
            this.background = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final class PanelMenuPresenterCallback implements android.support.v7.view.menu.MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z) {
            android.support.v7.view.menu.MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            android.support.v7.app.AppCompatDelegateImplV9 appCompatDelegateImplV9 = android.support.v7.app.AppCompatDelegateImplV9.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureStateFindMenuPanel = appCompatDelegateImplV9.findMenuPanel(menuBuilder);
            if (panelFeatureStateFindMenuPanel != null) {
                if (!z2) {
                    android.support.v7.app.AppCompatDelegateImplV9.this.closePanel(panelFeatureStateFindMenuPanel, z);
                } else {
                    android.support.v7.app.AppCompatDelegateImplV9.this.callOnPanelClosed(panelFeatureStateFindMenuPanel.featureId, panelFeatureStateFindMenuPanel, rootMenu);
                    android.support.v7.app.AppCompatDelegateImplV9.this.closePanel(panelFeatureStateFindMenuPanel, true);
                }
            }
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(android.support.v7.view.menu.MenuBuilder menuBuilder) {
            android.view.Window.Callback windowCallback;
            if (menuBuilder != null || !android.support.v7.app.AppCompatDelegateImplV9.this.mHasActionBar || (windowCallback = android.support.v7.app.AppCompatDelegateImplV9.this.getWindowCallback()) == null || android.support.v7.app.AppCompatDelegateImplV9.this.isDestroyed()) {
                return true;
            }
            windowCallback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    static {
        IS_PRE_LOLLIPOP = android.os.Build.VERSION.SDK_INT < 21;
    }

    AppCompatDelegateImplV9(android.content.Context context, android.view.Window window, android.support.v7.app.AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.mFadeAnim = null;
        this.mInvalidatePanelMenuRunnable = new java.lang.Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.1
            @Override // java.lang.Runnable
            public void run() {
                if ((android.support.v7.app.AppCompatDelegateImplV9.this.mInvalidatePanelMenuFeatures & 1) != 0) {
                    android.support.v7.app.AppCompatDelegateImplV9.this.doInvalidatePanelMenu(0);
                }
                if ((android.support.v7.app.AppCompatDelegateImplV9.this.mInvalidatePanelMenuFeatures & 4096) != 0) {
                    android.support.v7.app.AppCompatDelegateImplV9.this.doInvalidatePanelMenu(108);
                }
                android.support.v7.app.AppCompatDelegateImplV9 appCompatDelegateImplV9 = android.support.v7.app.AppCompatDelegateImplV9.this;
                appCompatDelegateImplV9.mInvalidatePanelMenuPosted = false;
                appCompatDelegateImplV9.mInvalidatePanelMenuFeatures = 0;
            }
        };
    }

    private void applyFixedSizeWindow() {
        android.support.v7.widget.ContentFrameLayout contentFrameLayout = (android.support.v7.widget.ContentFrameLayout) this.mSubDecor.findViewById(android.R.id.content);
        android.view.View decorView = this.mWindow.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        android.content.res.TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private android.view.ViewGroup createSubDecor() {
        android.view.ViewGroup viewGroup;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new java.lang.IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            requestWindowFeature(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBar, false)) {
            requestWindowFeature(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            requestWindowFeature(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            requestWindowFeature(10);
        }
        this.mIsFloating = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        this.mWindow.getDecorView();
        android.view.LayoutInflater layoutInflaterFrom = android.view.LayoutInflater.from(this.mContext);
        if (this.mWindowNoTitle) {
            viewGroup = this.mOverlayActionMode ? (android.view.ViewGroup) layoutInflaterFrom.inflate(android.support.v7.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (android.view.ViewGroup) null) : (android.view.ViewGroup) layoutInflaterFrom.inflate(android.support.v7.appcompat.R.layout.abc_screen_simple, (android.view.ViewGroup) null);
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                android.support.v4.view.ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new android.support.v4.view.OnApplyWindowInsetsListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.2
                    @Override // android.support.v4.view.OnApplyWindowInsetsListener
                    public android.support.v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, android.support.v4.view.WindowInsetsCompat windowInsetsCompat) {
                        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                        int iUpdateStatusGuard = android.support.v7.app.AppCompatDelegateImplV9.this.updateStatusGuard(systemWindowInsetTop);
                        if (systemWindowInsetTop != iUpdateStatusGuard) {
                            windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), iUpdateStatusGuard, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                        }
                        return android.support.v4.view.ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                    }
                });
            } else {
                ((android.support.v7.widget.FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.3
                    @Override // android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
                    public void onFitSystemWindows(android.graphics.Rect rect) {
                        rect.top = android.support.v7.app.AppCompatDelegateImplV9.this.updateStatusGuard(rect.top);
                    }
                });
            }
        } else if (this.mIsFloating) {
            viewGroup = (android.view.ViewGroup) layoutInflaterFrom.inflate(android.support.v7.appcompat.R.layout.abc_dialog_title_material, (android.view.ViewGroup) null);
            this.mOverlayActionBar = false;
            this.mHasActionBar = false;
        } else if (this.mHasActionBar) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            this.mContext.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (android.view.ViewGroup) android.view.LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.ContextThemeWrapper(this.mContext, typedValue.resourceId) : this.mContext).inflate(android.support.v7.appcompat.R.layout.abc_screen_toolbar, (android.view.ViewGroup) null);
            this.mDecorContentParent = (android.support.v7.widget.DecorContentParent) viewGroup.findViewById(android.support.v7.appcompat.R.id.decor_content_parent);
            this.mDecorContentParent.setWindowCallback(getWindowCallback());
            if (this.mOverlayActionBar) {
                this.mDecorContentParent.initFeature(109);
            }
            if (this.mFeatureProgress) {
                this.mDecorContentParent.initFeature(2);
            }
            if (this.mFeatureIndeterminateProgress) {
                this.mDecorContentParent.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new java.lang.IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
        }
        if (this.mDecorContentParent == null) {
            this.mTitleView = (android.widget.TextView) viewGroup.findViewById(android.support.v7.appcompat.R.id.title);
        }
        android.support.v7.widget.ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
        android.support.v7.widget.ContentFrameLayout contentFrameLayout = (android.support.v7.widget.ContentFrameLayout) viewGroup.findViewById(android.support.v7.appcompat.R.id.action_bar_activity_content);
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.mWindow.findViewById(android.R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                android.view.View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(android.R.id.content);
            if (viewGroup2 instanceof android.widget.FrameLayout) {
                ((android.widget.FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.mWindow.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new android.support.v7.widget.ContentFrameLayout.OnAttachListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.4
            @Override // android.support.v7.widget.ContentFrameLayout.OnAttachListener
            public void onAttachedFromWindow() {
            }

            @Override // android.support.v7.widget.ContentFrameLayout.OnAttachListener
            public void onDetachedFromWindow() {
                android.support.v7.app.AppCompatDelegateImplV9.this.dismissPopups();
            }
        });
        return viewGroup;
    }

    private void ensureSubDecor() {
        if (this.mSubDecorInstalled) {
            return;
        }
        this.mSubDecor = createSubDecor();
        java.lang.CharSequence title = getTitle();
        if (!android.text.TextUtils.isEmpty(title)) {
            onTitleChanged(title);
        }
        applyFixedSizeWindow();
        onSubDecorInstalled(this.mSubDecor);
        this.mSubDecorInstalled = true;
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState = getPanelState(0, false);
        if (isDestroyed()) {
            return;
        }
        if (panelState == null || panelState.menu == null) {
            invalidatePanelMenu(108);
        }
    }

    private boolean initializePanelContent(android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState) {
        if (panelFeatureState.createdPanelView != null) {
            panelFeatureState.shownPanelView = panelFeatureState.createdPanelView;
            return true;
        }
        if (panelFeatureState.menu == null) {
            return false;
        }
        if (this.mPanelMenuPresenterCallback == null) {
            this.mPanelMenuPresenterCallback = new android.support.v7.app.AppCompatDelegateImplV9.PanelMenuPresenterCallback();
        }
        panelFeatureState.shownPanelView = (android.view.View) panelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback);
        return panelFeatureState.shownPanelView != null;
    }

    private boolean initializePanelDecor(android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState) {
        panelFeatureState.setStyle(getActionBarThemedContext());
        panelFeatureState.decorView = new android.support.v7.app.AppCompatDelegateImplV9.ListMenuDecorView(panelFeatureState.listPresenterContext);
        panelFeatureState.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState) {
        android.content.Context context = this.mContext;
        if ((panelFeatureState.featureId == 0 || panelFeatureState.featureId == 108) && this.mDecorContentParent != null) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            android.content.res.Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedValue, true);
            android.content.res.Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                android.support.v7.view.ContextThemeWrapper contextThemeWrapper = new android.support.v7.view.ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(themeNewTheme);
                context = contextThemeWrapper;
            }
        }
        android.support.v7.view.menu.MenuBuilder menuBuilder = new android.support.v7.view.menu.MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.setMenu(menuBuilder);
        return true;
    }

    private void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted) {
            return;
        }
        android.support.v4.view.ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
    }

    private boolean onKeyDownPanel(int i, android.view.KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState = getPanelState(i, true);
        if (panelState.isOpen) {
            return false;
        }
        return preparePanel(panelState, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    private boolean onKeyUpPanel(int i, android.view.KeyEvent keyEvent) {
        boolean zHideOverflowMenu;
        boolean zPreparePanel;
        android.support.v7.widget.DecorContentParent decorContentParent;
        if (this.mActionMode != null) {
            return false;
        }
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState = getPanelState(i, true);
        if (i != 0 || (decorContentParent = this.mDecorContentParent) == null || !decorContentParent.canShowOverflowMenu() || android.view.ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
            if (panelState.isOpen || panelState.isHandled) {
                zHideOverflowMenu = panelState.isOpen;
                closePanel(panelState, true);
            } else if (panelState.isPrepared) {
                if (panelState.refreshMenuContent) {
                    panelState.isPrepared = false;
                    zPreparePanel = preparePanel(panelState, keyEvent);
                } else {
                    zPreparePanel = true;
                }
                if (zPreparePanel) {
                    openPanel(panelState, keyEvent);
                    zHideOverflowMenu = true;
                } else {
                    zHideOverflowMenu = false;
                }
            } else {
                zHideOverflowMenu = false;
            }
        } else if (this.mDecorContentParent.isOverflowMenuShowing()) {
            zHideOverflowMenu = this.mDecorContentParent.hideOverflowMenu();
        } else if (isDestroyed() || !preparePanel(panelState, keyEvent)) {
            zHideOverflowMenu = false;
        } else {
            zHideOverflowMenu = this.mDecorContentParent.showOverflowMenu();
        }
        if (zHideOverflowMenu) {
            android.media.AudioManager audioManager = (android.media.AudioManager) this.mContext.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                android.util.Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zHideOverflowMenu;
    }

    private void openPanel(android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState, android.view.KeyEvent keyEvent) {
        int i;
        android.view.ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.isOpen || isDestroyed()) {
            return;
        }
        if (panelFeatureState.featureId == 0) {
            android.content.Context context = this.mContext;
            boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
            boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
            if (z && z2) {
                return;
            }
        }
        android.view.Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !windowCallback.onMenuOpened(panelFeatureState.featureId, panelFeatureState.menu)) {
            closePanel(panelFeatureState, true);
            return;
        }
        android.view.WindowManager windowManager = (android.view.WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && preparePanel(panelFeatureState, keyEvent)) {
            if (panelFeatureState.decorView != null && !panelFeatureState.refreshDecorView) {
                if (panelFeatureState.createdPanelView != null && (layoutParams = panelFeatureState.createdPanelView.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                }
                panelFeatureState.isHandled = false;
                android.view.WindowManager.LayoutParams layoutParams2 = new android.view.WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
                layoutParams2.gravity = panelFeatureState.gravity;
                layoutParams2.windowAnimations = panelFeatureState.windowAnimations;
                windowManager.addView(panelFeatureState.decorView, layoutParams2);
                panelFeatureState.isOpen = true;
            }
            if (panelFeatureState.decorView == null) {
                if (!initializePanelDecor(panelFeatureState) || panelFeatureState.decorView == null) {
                    return;
                }
            } else if (panelFeatureState.refreshDecorView && panelFeatureState.decorView.getChildCount() > 0) {
                panelFeatureState.decorView.removeAllViews();
            }
            if (!initializePanelContent(panelFeatureState) || !panelFeatureState.hasPanelItems()) {
                return;
            }
            android.view.ViewGroup.LayoutParams layoutParams3 = panelFeatureState.shownPanelView.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new android.view.ViewGroup.LayoutParams(-2, -2);
            }
            panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
            android.view.ViewParent parent = panelFeatureState.shownPanelView.getParent();
            if (parent != null && (parent instanceof android.view.ViewGroup)) {
                ((android.view.ViewGroup) parent).removeView(panelFeatureState.shownPanelView);
            }
            panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, layoutParams3);
            if (!panelFeatureState.shownPanelView.hasFocus()) {
                panelFeatureState.shownPanelView.requestFocus();
            }
            i = -2;
            panelFeatureState.isHandled = false;
            android.view.WindowManager.LayoutParams layoutParams4 = new android.view.WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
            layoutParams4.gravity = panelFeatureState.gravity;
            layoutParams4.windowAnimations = panelFeatureState.windowAnimations;
            windowManager.addView(panelFeatureState.decorView, layoutParams4);
            panelFeatureState.isOpen = true;
        }
    }

    private boolean performPanelShortcut(android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState, int i, android.view.KeyEvent keyEvent, int i2) {
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) && panelFeatureState.menu != null) {
            zPerformShortcut = panelFeatureState.menu.performShortcut(i, keyEvent, i2);
        }
        if (zPerformShortcut && (i2 & 1) == 0 && this.mDecorContentParent == null) {
            closePanel(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    private boolean preparePanel(android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState, android.view.KeyEvent keyEvent) {
        android.support.v7.widget.DecorContentParent decorContentParent;
        android.support.v7.widget.DecorContentParent decorContentParent2;
        android.support.v7.widget.DecorContentParent decorContentParent3;
        if (isDestroyed()) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            closePanel(panelFeatureState2, false);
        }
        android.view.Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null) {
            panelFeatureState.createdPanelView = windowCallback.onCreatePanelView(panelFeatureState.featureId);
        }
        boolean z = panelFeatureState.featureId == 0 || panelFeatureState.featureId == 108;
        if (z && (decorContentParent3 = this.mDecorContentParent) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (panelFeatureState.createdPanelView == null && (!z || !(peekSupportActionBar() instanceof android.support.v7.app.ToolbarActionBar))) {
            if (panelFeatureState.menu == null || panelFeatureState.refreshMenuContent) {
                if (panelFeatureState.menu == null && (!initializePanelMenu(panelFeatureState) || panelFeatureState.menu == null)) {
                    return false;
                }
                if (z && this.mDecorContentParent != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new android.support.v7.app.AppCompatDelegateImplV9.ActionMenuPresenterCallback();
                    }
                    this.mDecorContentParent.setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                if (!windowCallback.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
                    panelFeatureState.setMenu(null);
                    if (z && (decorContentParent = this.mDecorContentParent) != null) {
                        decorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    return false;
                }
                panelFeatureState.refreshMenuContent = false;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            if (panelFeatureState.frozenActionViewState != null) {
                panelFeatureState.menu.restoreActionViewStates(panelFeatureState.frozenActionViewState);
                panelFeatureState.frozenActionViewState = null;
            }
            if (!windowCallback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                if (z && (decorContentParent2 = this.mDecorContentParent) != null) {
                    decorContentParent2.setMenu(null, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.qwertyMode = android.view.KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.menu.setQwertyMode(panelFeatureState.qwertyMode);
            panelFeatureState.menu.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.isHandled = false;
        this.mPreparedPanel = panelFeatureState;
        return true;
    }

    private void reopenMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z) {
        android.support.v7.widget.DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (android.view.ViewConfiguration.get(this.mContext).hasPermanentMenuKey() && !this.mDecorContentParent.isOverflowMenuShowPending())) {
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState = getPanelState(0, true);
            panelState.refreshDecorView = true;
            closePanel(panelState, false);
            openPanel(panelState, null);
            return;
        }
        android.view.Window.Callback windowCallback = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing() && z) {
            this.mDecorContentParent.hideOverflowMenu();
            if (isDestroyed()) {
                return;
            }
            windowCallback.onPanelClosed(108, getPanelState(0, true).menu);
            return;
        }
        if (windowCallback == null || isDestroyed()) {
            return;
        }
        if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuRunnable.run();
        }
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState2 = getPanelState(0, true);
        if (panelState2.menu == null || panelState2.refreshMenuContent || !windowCallback.onPreparePanel(0, panelState2.createdPanelView, panelState2.menu)) {
            return;
        }
        windowCallback.onMenuOpened(108, panelState2.menu);
        this.mDecorContentParent.showOverflowMenu();
    }

    private int sanitizeWindowFeatureId(int i) {
        if (i == 8) {
            android.util.Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i != 9) {
            return i;
        }
        android.util.Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean shouldInheritContext(android.view.ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        android.view.View decorView = this.mWindow.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof android.view.View) || android.support.v4.view.ViewCompat.isAttachedToWindow((android.view.View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new android.util.AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ((android.view.ViewGroup) this.mSubDecor.findViewById(android.R.id.content)).addView(view, layoutParams);
        this.mOriginalWindowCallback.onContentChanged();
    }

    android.view.View callActivityOnCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        android.view.View viewOnCreateView;
        if (!(this.mOriginalWindowCallback instanceof android.view.LayoutInflater.Factory) || (viewOnCreateView = ((android.view.LayoutInflater.Factory) this.mOriginalWindowCallback).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return viewOnCreateView;
    }

    void callOnPanelClosed(int i, android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState, android.view.Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState[] panelFeatureStateArr = this.mPanels;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !isDestroyed()) {
            this.mOriginalWindowCallback.onPanelClosed(i, menu);
        }
    }

    void checkCloseActionMenu(android.support.v7.view.menu.MenuBuilder menuBuilder) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        android.view.Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !isDestroyed()) {
            windowCallback.onPanelClosed(108, menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    void closePanel(int i) {
        closePanel(getPanelState(i, true), true);
    }

    void closePanel(android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState, boolean z) {
        android.support.v7.widget.DecorContentParent decorContentParent;
        if (z && panelFeatureState.featureId == 0 && (decorContentParent = this.mDecorContentParent) != null && decorContentParent.isOverflowMenuShowing()) {
            checkCloseActionMenu(panelFeatureState.menu);
            return;
        }
        android.view.WindowManager windowManager = (android.view.WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen && panelFeatureState.decorView != null) {
            windowManager.removeView(panelFeatureState.decorView);
            if (z) {
                callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == panelFeatureState) {
            this.mPreparedPanel = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.app.AppCompatDelegate
    public android.view.View createView(android.view.View view, java.lang.String str, @android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.util.AttributeSet attributeSet) {
        boolean z;
        if (this.mAppCompatViewInflater == null) {
            this.mAppCompatViewInflater = new android.support.v7.app.AppCompatViewInflater();
        }
        boolean zShouldInheritContext = false;
        if (IS_PRE_LOLLIPOP) {
            if (!(attributeSet instanceof org.xmlpull.v1.XmlPullParser)) {
                zShouldInheritContext = shouldInheritContext((android.view.ViewParent) view);
            } else if (((org.xmlpull.v1.XmlPullParser) attributeSet).getDepth() > 1) {
                zShouldInheritContext = true;
            }
            z = zShouldInheritContext;
        } else {
            z = false;
        }
        return this.mAppCompatViewInflater.createView(view, str, context, attributeSet, z, IS_PRE_LOLLIPOP, true, android.support.v7.widget.VectorEnabledTintResources.shouldBeUsed());
    }

    void dismissPopups() {
        android.support.v7.widget.DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.mActionModePopup != null) {
            this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
            if (this.mActionModePopup.isShowing()) {
                try {
                    this.mActionModePopup.dismiss();
                } catch (java.lang.IllegalArgumentException unused) {
                }
            }
            this.mActionModePopup = null;
        }
        endOnGoingFadeAnimation();
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState = getPanelState(0, false);
        if (panelState == null || panelState.menu == null) {
            return;
        }
        panelState.menu.close();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.mOriginalWindowCallback.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent);
    }

    void doInvalidatePanelMenu(int i) {
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState;
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState2 = getPanelState(i, true);
        if (panelState2.menu != null) {
            android.os.Bundle bundle = new android.os.Bundle();
            panelState2.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState2.frozenActionViewState = bundle;
            }
            panelState2.menu.stopDispatchingItemsChanged();
            panelState2.menu.clear();
        }
        panelState2.refreshMenuContent = true;
        panelState2.refreshDecorView = true;
        if ((i != 108 && i != 0) || this.mDecorContentParent == null || (panelState = getPanelState(0, false)) == null) {
            return;
        }
        panelState.isPrepared = false;
        preparePanel(panelState, null);
    }

    void endOnGoingFadeAnimation() {
        android.support.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState findMenuPanel(android.view.Menu menu) {
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.menu == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    @android.support.annotation.Nullable
    public <T extends android.view.View> T findViewById(@android.support.annotation.IdRes int i) {
        ensureSubDecor();
        return (T) this.mWindow.findViewById(i);
    }

    protected android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState getPanelState(int i, boolean z) {
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState[] panelFeatureStateArr2 = new android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                java.lang.System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.mPanels = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState2 = new android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    android.view.ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean hasWindowFeature(int i) {
        switch (sanitizeWindowFeatureId(i)) {
            case 1:
                return this.mWindowNoTitle;
            case 2:
                return this.mFeatureProgress;
            case 5:
                return this.mFeatureIndeterminateProgress;
            case 10:
                return this.mOverlayActionMode;
            case 108:
                return this.mHasActionBar;
            case 109:
                return this.mOverlayActionBar;
            default:
                return false;
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    public void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            if (this.mOriginalWindowCallback instanceof android.app.Activity) {
                this.mActionBar = new android.support.v7.app.WindowDecorActionBar((android.app.Activity) this.mOriginalWindowCallback, this.mOverlayActionBar);
            } else if (this.mOriginalWindowCallback instanceof android.app.Dialog) {
                this.mActionBar = new android.support.v7.app.WindowDecorActionBar((android.app.Dialog) this.mOriginalWindowCallback);
            }
            if (this.mActionBar != null) {
                this.mActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void installViewFactory() {
        android.view.LayoutInflater layoutInflaterFrom = android.view.LayoutInflater.from(this.mContext);
        if (layoutInflaterFrom.getFactory() == null) {
            android.support.v4.view.LayoutInflaterCompat.setFactory2(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof android.support.v7.app.AppCompatDelegateImplV9) {
                return;
            }
            android.util.Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    boolean onBackPressed() {
        android.support.v7.view.ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        android.support.v7.app.ActionBar supportActionBar;
        if (this.mHasActionBar && this.mSubDecorInstalled && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        android.support.v7.widget.AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        applyDayNight();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onCreate(android.os.Bundle bundle) {
        if (!(this.mOriginalWindowCallback instanceof android.app.Activity) || android.support.v4.app.NavUtils.getParentActivityName((android.app.Activity) this.mOriginalWindowCallback) == null) {
            return;
        }
        android.support.v7.app.ActionBar actionBarPeekSupportActionBar = peekSupportActionBar();
        if (actionBarPeekSupportActionBar == null) {
            this.mEnableDefaultActionBarUp = true;
        } else {
            actionBarPeekSupportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        android.view.View viewCallActivityOnCreateView = callActivityOnCreateView(view, str, context, attributeSet);
        return viewCallActivityOnCreateView != null ? viewCallActivityOnCreateView : createView(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        super.onDestroy();
        if (this.mActionBar != null) {
            this.mActionBar.onDestroy();
        }
    }

    boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i == 4) {
            this.mLongPressBackDown = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            onKeyDownPanel(0, keyEvent);
            return true;
        }
        if (android.os.Build.VERSION.SDK_INT < 11) {
            onKeyShortcut(i, keyEvent);
        }
        return false;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    boolean onKeyShortcut(int i, android.view.KeyEvent keyEvent) {
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState = this.mPreparedPanel;
        if (panelFeatureState != null && performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
            if (panelFeatureState2 != null) {
                panelFeatureState2.isHandled = true;
            }
            return true;
        }
        if (this.mPreparedPanel == null) {
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState = getPanelState(0, true);
            preparePanel(panelState, keyEvent);
            boolean zPerformPanelShortcut = performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent, 1);
            panelState.isPrepared = false;
            if (zPerformPanelShortcut) {
                return true;
            }
        }
        return false;
    }

    boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.mLongPressBackDown;
            this.mLongPressBackDown = false;
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState = getPanelState(0, false);
            if (panelState != null && panelState.isOpen) {
                if (!z) {
                    closePanel(panelState, true);
                }
                return true;
            }
            if (onBackPressed()) {
                return true;
            }
        } else if (i == 82) {
            onKeyUpPanel(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(android.support.v7.view.menu.MenuBuilder menuBuilder, android.view.MenuItem menuItem) {
        android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelFeatureStateFindMenuPanel;
        android.view.Window.Callback windowCallback = getWindowCallback();
        if (windowCallback == null || isDestroyed() || (panelFeatureStateFindMenuPanel = findMenuPanel(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return windowCallback.onMenuItemSelected(panelFeatureStateFindMenuPanel.featureId, menuItem);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(android.support.v7.view.menu.MenuBuilder menuBuilder) {
        reopenMenu(menuBuilder, true);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    boolean onMenuOpened(int i, android.view.Menu menu) {
        if (i != 108) {
            return false;
        }
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.dispatchMenuVisibilityChanged(true);
        }
        return true;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    void onPanelClosed(int i, android.view.Menu menu) {
        if (i == 108) {
            android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
                return;
            }
            return;
        }
        if (i == 0) {
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState = getPanelState(i, true);
            if (panelState.isOpen) {
                closePanel(panelState, false);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onPostCreate(android.os.Bundle bundle) {
        ensureSubDecor();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onPostResume() {
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onStop() {
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    void onSubDecorInstalled(android.view.ViewGroup viewGroup) {
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    void onTitleChanged(java.lang.CharSequence charSequence) {
        android.support.v7.widget.DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        if (peekSupportActionBar() != null) {
            peekSupportActionBar().setWindowTitle(charSequence);
            return;
        }
        android.widget.TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean requestWindowFeature(int i) {
        int iSanitizeWindowFeatureId = sanitizeWindowFeatureId(i);
        if (this.mWindowNoTitle && iSanitizeWindowFeatureId == 108) {
            return false;
        }
        if (this.mHasActionBar && iSanitizeWindowFeatureId == 1) {
            this.mHasActionBar = false;
        }
        switch (iSanitizeWindowFeatureId) {
            case 1:
                throwFeatureRequestIfSubDecorInstalled();
                this.mWindowNoTitle = true;
                return true;
            case 2:
                throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureProgress = true;
                return true;
            case 5:
                throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureIndeterminateProgress = true;
                return true;
            case 10:
                throwFeatureRequestIfSubDecorInstalled();
                this.mOverlayActionMode = true;
                return true;
            case 108:
                throwFeatureRequestIfSubDecorInstalled();
                this.mHasActionBar = true;
                return true;
            case 109:
                throwFeatureRequestIfSubDecorInstalled();
                this.mOverlayActionBar = true;
                return true;
            default:
                return this.mWindow.requestFeature(iSanitizeWindowFeatureId);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(int i) {
        ensureSubDecor();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        android.view.LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mOriginalWindowCallback.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(android.view.View view) {
        ensureSubDecor();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mOriginalWindowCallback.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mOriginalWindowCallback.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setSupportActionBar(android.support.v7.widget.Toolbar toolbar) {
        if (this.mOriginalWindowCallback instanceof android.app.Activity) {
            android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof android.support.v7.app.WindowDecorActionBar) {
                throw new java.lang.IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.mMenuInflater = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                android.support.v7.app.ToolbarActionBar toolbarActionBar = new android.support.v7.app.ToolbarActionBar(toolbar, ((android.app.Activity) this.mOriginalWindowCallback).getTitle(), this.mAppCompatWindowCallback);
                this.mActionBar = toolbarActionBar;
                this.mWindow.setCallback(toolbarActionBar.getWrappedWindowCallback());
            } else {
                this.mActionBar = null;
                this.mWindow.setCallback(this.mAppCompatWindowCallback);
            }
            invalidateOptionsMenu();
        }
    }

    final boolean shouldAnimateActionModeView() {
        android.view.ViewGroup viewGroup;
        return this.mSubDecorInstalled && (viewGroup = this.mSubDecor) != null && android.support.v4.view.ViewCompat.isLaidOut(viewGroup);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public android.support.v7.view.ActionMode startSupportActionMode(@android.support.annotation.NonNull android.support.v7.view.ActionMode.Callback callback) {
        if (callback == null) {
            throw new java.lang.IllegalArgumentException("ActionMode callback can not be null.");
        }
        android.support.v7.view.ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        android.support.v7.app.AppCompatDelegateImplV9.ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new android.support.v7.app.AppCompatDelegateImplV9.ActionModeCallbackWrapperV9(callback);
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.mActionMode = supportActionBar.startActionMode(actionModeCallbackWrapperV9);
            if (this.mActionMode != null && this.mAppCompatCallback != null) {
                this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
            }
        }
        if (this.mActionMode == null) {
            this.mActionMode = startSupportActionModeFromWindow(actionModeCallbackWrapperV9);
        }
        return this.mActionMode;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    android.support.v7.view.ActionMode startSupportActionModeFromWindow(@android.support.annotation.NonNull android.support.v7.view.ActionMode.Callback callback) {
        android.support.v7.view.ActionMode actionModeOnWindowStartingSupportActionMode;
        android.content.Context contextThemeWrapper;
        endOnGoingFadeAnimation();
        android.support.v7.view.ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        if (!(callback instanceof android.support.v7.app.AppCompatDelegateImplV9.ActionModeCallbackWrapperV9)) {
            callback = new android.support.v7.app.AppCompatDelegateImplV9.ActionModeCallbackWrapperV9(callback);
        }
        if (this.mAppCompatCallback == null || isDestroyed()) {
            actionModeOnWindowStartingSupportActionMode = null;
        } else {
            try {
                actionModeOnWindowStartingSupportActionMode = this.mAppCompatCallback.onWindowStartingSupportActionMode(callback);
            } catch (java.lang.AbstractMethodError unused) {
                actionModeOnWindowStartingSupportActionMode = null;
            }
        }
        if (actionModeOnWindowStartingSupportActionMode != null) {
            this.mActionMode = actionModeOnWindowStartingSupportActionMode;
        } else {
            if (this.mActionModeView == null) {
                if (this.mIsFloating) {
                    android.util.TypedValue typedValue = new android.util.TypedValue();
                    android.content.res.Resources.Theme theme = this.mContext.getTheme();
                    theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        android.content.res.Resources.Theme themeNewTheme = this.mContext.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        contextThemeWrapper = new android.support.v7.view.ContextThemeWrapper(this.mContext, 0);
                        contextThemeWrapper.getTheme().setTo(themeNewTheme);
                    } else {
                        contextThemeWrapper = this.mContext;
                    }
                    this.mActionModeView = new android.support.v7.widget.ActionBarContextView(contextThemeWrapper);
                    this.mActionModePopup = new android.widget.PopupWindow(contextThemeWrapper, (android.util.AttributeSet) null, android.support.v7.appcompat.R.attr.actionModePopupWindowStyle);
                    android.support.v4.widget.PopupWindowCompat.setWindowLayoutType(this.mActionModePopup, 2);
                    this.mActionModePopup.setContentView(this.mActionModeView);
                    this.mActionModePopup.setWidth(-1);
                    contextThemeWrapper.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarSize, typedValue, true);
                    this.mActionModeView.setContentHeight(android.util.TypedValue.complexToDimensionPixelSize(typedValue.data, contextThemeWrapper.getResources().getDisplayMetrics()));
                    this.mActionModePopup.setHeight(-2);
                    this.mShowActionModePopup = new java.lang.Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.5
                        @Override // java.lang.Runnable
                        public void run() {
                            android.support.v7.app.AppCompatDelegateImplV9.this.mActionModePopup.showAtLocation(android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView, 55, 0, 0);
                            android.support.v7.app.AppCompatDelegateImplV9.this.endOnGoingFadeAnimation();
                            if (!android.support.v7.app.AppCompatDelegateImplV9.this.shouldAnimateActionModeView()) {
                                android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.setAlpha(1.0f);
                                android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.setVisibility(0);
                            } else {
                                android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.setAlpha(0.0f);
                                android.support.v7.app.AppCompatDelegateImplV9 appCompatDelegateImplV9 = android.support.v7.app.AppCompatDelegateImplV9.this;
                                appCompatDelegateImplV9.mFadeAnim = android.support.v4.view.ViewCompat.animate(appCompatDelegateImplV9.mActionModeView).alpha(1.0f);
                                android.support.v7.app.AppCompatDelegateImplV9.this.mFadeAnim.setListener(new android.support.v4.view.ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.5.1
                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    public void onAnimationEnd(android.view.View view) {
                                        android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.setAlpha(1.0f);
                                        android.support.v7.app.AppCompatDelegateImplV9.this.mFadeAnim.setListener(null);
                                        android.support.v7.app.AppCompatDelegateImplV9.this.mFadeAnim = null;
                                    }

                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    public void onAnimationStart(android.view.View view) {
                                        android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.setVisibility(0);
                                    }
                                });
                            }
                        }
                    };
                } else {
                    android.support.v7.widget.ViewStubCompat viewStubCompat = (android.support.v7.widget.ViewStubCompat) this.mSubDecor.findViewById(android.support.v7.appcompat.R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(android.view.LayoutInflater.from(getActionBarThemedContext()));
                        this.mActionModeView = (android.support.v7.widget.ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.mActionModeView != null) {
                endOnGoingFadeAnimation();
                this.mActionModeView.killMode();
                android.support.v7.view.StandaloneActionMode standaloneActionMode = new android.support.v7.view.StandaloneActionMode(this.mActionModeView.getContext(), this.mActionModeView, callback, this.mActionModePopup == null);
                if (callback.onCreateActionMode(standaloneActionMode, standaloneActionMode.getMenu())) {
                    standaloneActionMode.invalidate();
                    this.mActionModeView.initForMode(standaloneActionMode);
                    this.mActionMode = standaloneActionMode;
                    if (shouldAnimateActionModeView()) {
                        this.mActionModeView.setAlpha(0.0f);
                        this.mFadeAnim = android.support.v4.view.ViewCompat.animate(this.mActionModeView).alpha(1.0f);
                        this.mFadeAnim.setListener(new android.support.v4.view.ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.6
                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            public void onAnimationEnd(android.view.View view) {
                                android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.setAlpha(1.0f);
                                android.support.v7.app.AppCompatDelegateImplV9.this.mFadeAnim.setListener(null);
                                android.support.v7.app.AppCompatDelegateImplV9.this.mFadeAnim = null;
                            }

                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            public void onAnimationStart(android.view.View view) {
                                android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.setVisibility(0);
                                android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.sendAccessibilityEvent(32);
                                if (android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.getParent() instanceof android.view.View) {
                                    android.support.v4.view.ViewCompat.requestApplyInsets((android.view.View) android.support.v7.app.AppCompatDelegateImplV9.this.mActionModeView.getParent());
                                }
                            }
                        });
                    } else {
                        this.mActionModeView.setAlpha(1.0f);
                        this.mActionModeView.setVisibility(0);
                        this.mActionModeView.sendAccessibilityEvent(32);
                        if (this.mActionModeView.getParent() instanceof android.view.View) {
                            android.support.v4.view.ViewCompat.requestApplyInsets((android.view.View) this.mActionModeView.getParent());
                        }
                    }
                    if (this.mActionModePopup != null) {
                        this.mWindow.getDecorView().post(this.mShowActionModePopup);
                    }
                } else {
                    this.mActionMode = null;
                }
            }
        }
        if (this.mActionMode != null && this.mAppCompatCallback != null) {
            this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
    }

    int updateStatusGuard(int i) {
        boolean z;
        boolean z2;
        android.support.v7.widget.ActionBarContextView actionBarContextView = this.mActionModeView;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
            if (this.mActionModeView.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new android.graphics.Rect();
                    this.mTempRect2 = new android.graphics.Rect();
                }
                android.graphics.Rect rect = this.mTempRect1;
                android.graphics.Rect rect2 = this.mTempRect2;
                rect.set(0, i, 0, 0);
                android.support.v7.widget.ViewUtils.computeFitSystemWindows(this.mSubDecor, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    android.view.View view = this.mStatusGuard;
                    if (view == null) {
                        this.mStatusGuard = new android.view.View(this.mContext);
                        this.mStatusGuard.setBackgroundColor(this.mContext.getResources().getColor(android.support.v7.appcompat.R.color.abc_input_method_navigation_guard));
                        this.mSubDecor.addView(this.mStatusGuard, -1, new android.view.ViewGroup.LayoutParams(-1, i));
                    } else {
                        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.mStatusGuard.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.mStatusGuard != null;
                if (!this.mOverlayActionMode && z) {
                    i = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = true;
                z = false;
            } else {
                z2 = false;
                z = false;
            }
            if (z2) {
                this.mActionModeView.setLayoutParams(marginLayoutParams);
            }
        }
        android.view.View view2 = this.mStatusGuard;
        if (view2 != null) {
            view2.setVisibility(z ? 0 : 8);
        }
        return i;
    }
}
