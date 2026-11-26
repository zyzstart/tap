package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(14)
abstract class AppCompatDelegateImplBase extends android.support.v7.app.AppCompatDelegate {
    static final boolean DEBUG = false;
    static final java.lang.String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean SHOULD_INSTALL_EXCEPTION_HANDLER;
    private static boolean sInstalledExceptionHandler;
    private static final int[] sWindowBackgroundStyleable;
    android.support.v7.app.ActionBar mActionBar;
    final android.support.v7.app.AppCompatCallback mAppCompatCallback;
    final android.view.Window.Callback mAppCompatWindowCallback;
    final android.content.Context mContext;
    private boolean mEatKeyUpEvent;
    boolean mHasActionBar;
    private boolean mIsDestroyed;
    boolean mIsFloating;
    private boolean mIsStarted;
    android.view.MenuInflater mMenuInflater;
    final android.view.Window.Callback mOriginalWindowCallback;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private java.lang.CharSequence mTitle;
    final android.view.Window mWindow;
    boolean mWindowNoTitle;

    private class ActionBarDrawableToggleImpl implements android.support.v7.app.ActionBarDrawerToggle.Delegate {
        ActionBarDrawableToggleImpl() {
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.content.Context getActionBarThemedContext() {
            return android.support.v7.app.AppCompatDelegateImplBase.this.getActionBarThemedContext();
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.graphics.drawable.Drawable getThemeUpIndicator() {
            android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (android.util.AttributeSet) null, new int[]{android.support.v7.appcompat.R.attr.homeAsUpIndicator});
            android.graphics.drawable.Drawable drawable = tintTypedArrayObtainStyledAttributes.getDrawable(0);
            tintTypedArrayObtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.support.v7.app.ActionBar supportActionBar = android.support.v7.app.AppCompatDelegateImplBase.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            android.support.v7.app.ActionBar supportActionBar = android.support.v7.app.AppCompatDelegateImplBase.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, int i) {
            android.support.v7.app.ActionBar supportActionBar = android.support.v7.app.AppCompatDelegateImplBase.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    class AppCompatWindowCallbackBase extends android.support.v7.view.WindowCallbackWrapper {
        AppCompatWindowCallbackBase(android.view.Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
            return android.support.v7.app.AppCompatDelegateImplBase.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(android.view.KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || android.support.v7.app.AppCompatDelegateImplBase.this.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, android.view.Menu menu) {
            if (i != 0 || (menu instanceof android.support.v7.view.menu.MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, android.view.Menu menu) {
            super.onMenuOpened(i, menu);
            android.support.v7.app.AppCompatDelegateImplBase.this.onMenuOpened(i, menu);
            return true;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, android.view.Menu menu) {
            super.onPanelClosed(i, menu);
            android.support.v7.app.AppCompatDelegateImplBase.this.onPanelClosed(i, menu);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, android.view.View view, android.view.Menu menu) {
            android.support.v7.view.menu.MenuBuilder menuBuilder = menu instanceof android.support.v7.view.menu.MenuBuilder ? (android.support.v7.view.menu.MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return zOnPreparePanel;
        }
    }

    static {
        SHOULD_INSTALL_EXCEPTION_HANDLER = android.os.Build.VERSION.SDK_INT < 21;
        if (SHOULD_INSTALL_EXCEPTION_HANDLER && !sInstalledExceptionHandler) {
            final java.lang.Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
            java.lang.Thread.setDefaultUncaughtExceptionHandler(new java.lang.Thread.UncaughtExceptionHandler() { // from class: android.support.v7.app.AppCompatDelegateImplBase.1
                private boolean shouldWrapException(java.lang.Throwable th) {
                    java.lang.String message;
                    if (!(th instanceof android.content.res.Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains("drawable") || message.contains("Drawable");
                }

                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                    if (!shouldWrapException(th)) {
                        defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                        return;
                    }
                    android.content.res.Resources.NotFoundException notFoundException = new android.content.res.Resources.NotFoundException(th.getMessage() + android.support.v7.app.AppCompatDelegateImplBase.EXCEPTION_HANDLER_MESSAGE_SUFFIX);
                    notFoundException.initCause(th.getCause());
                    notFoundException.setStackTrace(th.getStackTrace());
                    defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                }
            });
            sInstalledExceptionHandler = true;
        }
        sWindowBackgroundStyleable = new int[]{android.R.attr.windowBackground};
    }

    AppCompatDelegateImplBase(android.content.Context context, android.view.Window window, android.support.v7.app.AppCompatCallback appCompatCallback) {
        this.mContext = context;
        this.mWindow = window;
        this.mAppCompatCallback = appCompatCallback;
        this.mOriginalWindowCallback = this.mWindow.getCallback();
        android.view.Window.Callback callback = this.mOriginalWindowCallback;
        if (callback instanceof android.support.v7.app.AppCompatDelegateImplBase.AppCompatWindowCallbackBase) {
            throw new java.lang.IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.mAppCompatWindowCallback = wrapWindowCallback(callback);
        this.mWindow.setCallback(this.mAppCompatWindowCallback);
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, (android.util.AttributeSet) null, sWindowBackgroundStyleable);
        android.graphics.drawable.Drawable drawableIfKnown = tintTypedArrayObtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            this.mWindow.setBackgroundDrawable(drawableIfKnown);
        }
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean applyDayNight() {
        return false;
    }

    abstract boolean dispatchKeyEvent(android.view.KeyEvent keyEvent);

    final android.content.Context getActionBarThemedContext() {
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        android.content.Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        return themedContext == null ? this.mContext : themedContext;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public final android.support.v7.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new android.support.v7.app.AppCompatDelegateImplBase.ActionBarDrawableToggleImpl();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public android.view.MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            initWindowDecorActionBar();
            android.support.v7.app.ActionBar actionBar = this.mActionBar;
            this.mMenuInflater = new android.support.v7.view.SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : this.mContext);
        }
        return this.mMenuInflater;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public android.support.v7.app.ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    final java.lang.CharSequence getTitle() {
        android.view.Window.Callback callback = this.mOriginalWindowCallback;
        return callback instanceof android.app.Activity ? ((android.app.Activity) callback).getTitle() : this.mTitle;
    }

    final android.view.Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    abstract void initWindowDecorActionBar();

    final boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return false;
    }

    final boolean isStarted() {
        return this.mIsStarted;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        this.mIsDestroyed = true;
    }

    abstract boolean onKeyShortcut(int i, android.view.KeyEvent keyEvent);

    abstract boolean onMenuOpened(int i, android.view.Menu menu);

    abstract void onPanelClosed(int i, android.view.Menu menu);

    @Override // android.support.v7.app.AppCompatDelegate
    public void onSaveInstanceState(android.os.Bundle bundle) {
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onStart() {
        this.mIsStarted = true;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onStop() {
        this.mIsStarted = false;
    }

    abstract void onTitleChanged(java.lang.CharSequence charSequence);

    final android.support.v7.app.ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z) {
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setLocalNightMode(int i) {
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public final void setTitle(java.lang.CharSequence charSequence) {
        this.mTitle = charSequence;
        onTitleChanged(charSequence);
    }

    abstract android.support.v7.view.ActionMode startSupportActionModeFromWindow(android.support.v7.view.ActionMode.Callback callback);

    android.view.Window.Callback wrapWindowCallback(android.view.Window.Callback callback) {
        return new android.support.v7.app.AppCompatDelegateImplBase.AppCompatWindowCallbackBase(callback);
    }
}
