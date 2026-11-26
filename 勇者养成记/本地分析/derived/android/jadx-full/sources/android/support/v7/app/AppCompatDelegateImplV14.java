package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(14)
class AppCompatDelegateImplV14 extends android.support.v7.app.AppCompatDelegateImplV11 {
    private static final java.lang.String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
    private boolean mApplyDayNightCalled;
    private android.support.v7.app.AppCompatDelegateImplV14.AutoNightModeManager mAutoNightModeManager;
    private boolean mHandleNativeActionModes;
    private int mLocalNightMode;

    class AppCompatWindowCallbackV14 extends android.support.v7.app.AppCompatDelegateImplBase.AppCompatWindowCallbackBase {
        AppCompatWindowCallbackV14(android.view.Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
            return android.support.v7.app.AppCompatDelegateImplV14.this.isHandleNativeActionModesEnabled() ? startAsSupportActionMode(callback) : super.onWindowStartingActionMode(callback);
        }

        final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback callback) {
            android.support.v7.view.SupportActionModeWrapper.CallbackWrapper callbackWrapper = new android.support.v7.view.SupportActionModeWrapper.CallbackWrapper(android.support.v7.app.AppCompatDelegateImplV14.this.mContext, callback);
            android.support.v7.view.ActionMode actionModeStartSupportActionMode = android.support.v7.app.AppCompatDelegateImplV14.this.startSupportActionMode(callbackWrapper);
            if (actionModeStartSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(actionModeStartSupportActionMode);
            }
            return null;
        }
    }

    @android.support.annotation.VisibleForTesting
    final class AutoNightModeManager {
        private android.content.BroadcastReceiver mAutoTimeChangeReceiver;
        private android.content.IntentFilter mAutoTimeChangeReceiverFilter;
        private boolean mIsNight;
        private android.support.v7.app.TwilightManager mTwilightManager;

        AutoNightModeManager(android.support.v7.app.TwilightManager twilightManager) {
            this.mTwilightManager = twilightManager;
            this.mIsNight = twilightManager.isNight();
        }

        final void cleanup() {
            if (this.mAutoTimeChangeReceiver != null) {
                android.support.v7.app.AppCompatDelegateImplV14.this.mContext.unregisterReceiver(this.mAutoTimeChangeReceiver);
                this.mAutoTimeChangeReceiver = null;
            }
        }

        final void dispatchTimeChanged() {
            boolean zIsNight = this.mTwilightManager.isNight();
            if (zIsNight != this.mIsNight) {
                this.mIsNight = zIsNight;
                android.support.v7.app.AppCompatDelegateImplV14.this.applyDayNight();
            }
        }

        final int getApplyableNightMode() {
            this.mIsNight = this.mTwilightManager.isNight();
            return this.mIsNight ? 2 : 1;
        }

        final void setup() {
            cleanup();
            if (this.mAutoTimeChangeReceiver == null) {
                this.mAutoTimeChangeReceiver = new android.content.BroadcastReceiver() { // from class: android.support.v7.app.AppCompatDelegateImplV14.AutoNightModeManager.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(android.content.Context context, android.content.Intent intent) {
                        android.support.v7.app.AppCompatDelegateImplV14.AutoNightModeManager.this.dispatchTimeChanged();
                    }
                };
            }
            if (this.mAutoTimeChangeReceiverFilter == null) {
                this.mAutoTimeChangeReceiverFilter = new android.content.IntentFilter();
                this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_SET");
                this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_TICK");
            }
            android.support.v7.app.AppCompatDelegateImplV14.this.mContext.registerReceiver(this.mAutoTimeChangeReceiver, this.mAutoTimeChangeReceiverFilter);
        }
    }

    AppCompatDelegateImplV14(android.content.Context context, android.view.Window window, android.support.v7.app.AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.mLocalNightMode = -100;
        this.mHandleNativeActionModes = true;
    }

    private void ensureAutoNightModeManager() {
        if (this.mAutoNightModeManager == null) {
            this.mAutoNightModeManager = new android.support.v7.app.AppCompatDelegateImplV14.AutoNightModeManager(android.support.v7.app.TwilightManager.getInstance(this.mContext));
        }
    }

    private int getNightMode() {
        int i = this.mLocalNightMode;
        return i != -100 ? i : getDefaultNightMode();
    }

    private boolean shouldRecreateOnNightModeChange() {
        if (!this.mApplyDayNightCalled || !(this.mContext instanceof android.app.Activity)) {
            return false;
        }
        try {
            return (this.mContext.getPackageManager().getActivityInfo(new android.content.ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges & 512) == 0;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            android.util.Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    private boolean updateForNightMode(int i) {
        android.content.res.Resources resources = this.mContext.getResources();
        android.content.res.Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (shouldRecreateOnNightModeChange()) {
            ((android.app.Activity) this.mContext).recreate();
            return true;
        }
        android.content.res.Configuration configuration2 = new android.content.res.Configuration(configuration);
        android.util.DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, displayMetrics);
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        android.support.v7.app.ResourcesFlusher.flush(resources);
        return true;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public boolean applyDayNight() {
        int nightMode = getNightMode();
        int iMapNightMode = mapNightMode(nightMode);
        boolean zUpdateForNightMode = iMapNightMode != -1 ? updateForNightMode(iMapNightMode) : false;
        if (nightMode == 0) {
            ensureAutoNightModeManager();
            this.mAutoNightModeManager.setup();
        }
        this.mApplyDayNightCalled = true;
        return zUpdateForNightMode;
    }

    @android.support.annotation.VisibleForTesting
    final android.support.v7.app.AppCompatDelegateImplV14.AutoNightModeManager getAutoNightModeManager() {
        ensureAutoNightModeManager();
        return this.mAutoNightModeManager;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    int mapNightMode(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        ensureAutoNightModeManager();
        return this.mAutoNightModeManager.getApplyableNightMode();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegate
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null || this.mLocalNightMode != -100) {
            return;
        }
        this.mLocalNightMode = bundle.getInt(KEY_LOCAL_NIGHT_MODE, -100);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        super.onDestroy();
        android.support.v7.app.AppCompatDelegateImplV14.AutoNightModeManager autoNightModeManager = this.mAutoNightModeManager;
        if (autoNightModeManager != null) {
            autoNightModeManager.cleanup();
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = this.mLocalNightMode;
        if (i != -100) {
            bundle.putInt(KEY_LOCAL_NIGHT_MODE, i);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onStart() {
        super.onStart();
        applyDayNight();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onStop() {
        super.onStop();
        android.support.v7.app.AppCompatDelegateImplV14.AutoNightModeManager autoNightModeManager = this.mAutoNightModeManager;
        if (autoNightModeManager != null) {
            autoNightModeManager.cleanup();
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z) {
        this.mHandleNativeActionModes = z;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void setLocalNightMode(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
                if (this.mLocalNightMode != i) {
                    this.mLocalNightMode = i;
                    if (this.mApplyDayNightCalled) {
                        applyDayNight();
                    }
                }
                break;
            default:
                android.util.Log.i("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
                break;
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    android.view.Window.Callback wrapWindowCallback(android.view.Window.Callback callback) {
        return new android.support.v7.app.AppCompatDelegateImplV14.AppCompatWindowCallbackV14(callback);
    }
}
