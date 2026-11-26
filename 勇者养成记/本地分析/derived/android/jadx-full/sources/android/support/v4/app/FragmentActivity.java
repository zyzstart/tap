package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FragmentActivity extends android.support.v4.app.BaseFragmentActivityApi16 implements android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback, android.support.v4.app.ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final java.lang.String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final java.lang.String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final java.lang.String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final java.lang.String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final java.lang.String TAG = "FragmentActivity";
    boolean mCreated;
    int mNextCandidateRequestIndex;
    android.support.v4.util.SparseArrayCompat<java.lang.String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    final android.os.Handler mHandler = new android.os.Handler() { // from class: android.support.v4.app.FragmentActivity.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            switch (message.what) {
                case 1:
                    if (android.support.v4.app.FragmentActivity.this.mStopped) {
                        android.support.v4.app.FragmentActivity.this.doReallyStop(false);
                    }
                    break;
                case 2:
                    android.support.v4.app.FragmentActivity.this.onResumeFragments();
                    android.support.v4.app.FragmentActivity.this.mFragments.execPendingActions();
                    break;
                default:
                    super.handleMessage(message);
                    break;
            }
        }
    };
    final android.support.v4.app.FragmentController mFragments = android.support.v4.app.FragmentController.createController(new android.support.v4.app.FragmentActivity.HostCallbacks());
    boolean mStopped = true;
    boolean mReallyStopped = true;

    class HostCallbacks extends android.support.v4.app.FragmentHostCallback<android.support.v4.app.FragmentActivity> {
        public HostCallbacks() {
            super(android.support.v4.app.FragmentActivity.this);
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public void onAttachFragment(android.support.v4.app.Fragment fragment) {
            android.support.v4.app.FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public void onDump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
            android.support.v4.app.FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // android.support.v4.app.FragmentHostCallback, android.support.v4.app.FragmentContainer
        @android.support.annotation.Nullable
        public android.view.View onFindViewById(int i) {
            return android.support.v4.app.FragmentActivity.this.findViewById(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.support.v4.app.FragmentHostCallback
        public android.support.v4.app.FragmentActivity onGetHost() {
            return android.support.v4.app.FragmentActivity.this;
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public android.view.LayoutInflater onGetLayoutInflater() {
            return android.support.v4.app.FragmentActivity.this.getLayoutInflater().cloneInContext(android.support.v4.app.FragmentActivity.this);
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public int onGetWindowAnimations() {
            android.view.Window window = android.support.v4.app.FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // android.support.v4.app.FragmentHostCallback, android.support.v4.app.FragmentContainer
        public boolean onHasView() {
            android.view.Window window = android.support.v4.app.FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public boolean onHasWindowAnimations() {
            return android.support.v4.app.FragmentActivity.this.getWindow() != null;
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public void onRequestPermissionsFromFragment(@android.support.annotation.NonNull android.support.v4.app.Fragment fragment, @android.support.annotation.NonNull java.lang.String[] strArr, int i) {
            android.support.v4.app.FragmentActivity.this.requestPermissionsFromFragment(fragment, strArr, i);
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public boolean onShouldSaveFragmentState(android.support.v4.app.Fragment fragment) {
            return !android.support.v4.app.FragmentActivity.this.isFinishing();
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public boolean onShouldShowRequestPermissionRationale(@android.support.annotation.NonNull java.lang.String str) {
            return android.support.v4.app.ActivityCompat.shouldShowRequestPermissionRationale(android.support.v4.app.FragmentActivity.this, str);
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public void onStartActivityFromFragment(android.support.v4.app.Fragment fragment, android.content.Intent intent, int i) {
            android.support.v4.app.FragmentActivity.this.startActivityFromFragment(fragment, intent, i);
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public void onStartActivityFromFragment(android.support.v4.app.Fragment fragment, android.content.Intent intent, int i, @android.support.annotation.Nullable android.os.Bundle bundle) {
            android.support.v4.app.FragmentActivity.this.startActivityFromFragment(fragment, intent, i, bundle);
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public void onStartIntentSenderFromFragment(android.support.v4.app.Fragment fragment, android.content.IntentSender intentSender, int i, @android.support.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
            android.support.v4.app.FragmentActivity.this.startIntentSenderFromFragment(fragment, intentSender, i, intent, i2, i3, i4, bundle);
        }

        @Override // android.support.v4.app.FragmentHostCallback
        public void onSupportInvalidateOptionsMenu() {
            android.support.v4.app.FragmentActivity.this.supportInvalidateOptionsMenu();
        }
    }

    static final class NonConfigurationInstances {
        java.lang.Object custom;
        android.support.v4.app.FragmentManagerNonConfig fragments;
        android.support.v4.util.SimpleArrayMap<java.lang.String, android.support.v4.app.LoaderManager> loaders;

        NonConfigurationInstances() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int allocateRequestIndex(android.support.v4.app.Fragment fragment) {
        if (this.mPendingFragmentActivityResults.size() >= MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            throw new java.lang.IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.mPendingFragmentActivityResults.indexOfKey(this.mNextCandidateRequestIndex) >= 0) {
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        }
        int i = this.mNextCandidateRequestIndex;
        this.mPendingFragmentActivityResults.put(i, fragment.mWho);
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        return i;
    }

    @Override // android.support.v4.app.BaseFragmentActivityApi14
    final android.view.View dispatchFragmentsOnCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return this.mFragments.onCreateView(view, str, context, attributeSet);
    }

    void doReallyStop(boolean z) {
        if (this.mReallyStopped) {
            if (z) {
                this.mFragments.doLoaderStart();
                this.mFragments.doLoaderStop(true);
                return;
            }
            return;
        }
        this.mReallyStopped = true;
        this.mRetaining = z;
        this.mHandler.removeMessages(1);
        onReallyStop();
    }

    @Override // android.app.Activity
    public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        printWriter.println(" State:");
        java.lang.String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        this.mFragments.dumpLoaders(str2, fileDescriptor, printWriter, strArr);
        this.mFragments.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
    }

    public java.lang.Object getLastCustomNonConfigurationInstance() {
        android.support.v4.app.FragmentActivity.NonConfigurationInstances nonConfigurationInstances = (android.support.v4.app.FragmentActivity.NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.custom;
        }
        return null;
    }

    public android.support.v4.app.FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    public android.support.v4.app.LoaderManager getSupportLoaderManager() {
        return this.mFragments.getSupportLoaderManager();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        this.mFragments.noteStateNotSaved();
        int i3 = i >> 16;
        if (i3 == 0) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        int i4 = i3 - 1;
        java.lang.String str = this.mPendingFragmentActivityResults.get(i4);
        this.mPendingFragmentActivityResults.remove(i4);
        if (str == null) {
            android.util.Log.w(TAG, "Activity result delivered for unknown Fragment.");
            return;
        }
        android.support.v4.app.Fragment fragmentFindFragmentByWho = this.mFragments.findFragmentByWho(str);
        if (fragmentFindFragmentByWho != null) {
            fragmentFindFragmentByWho.onActivityResult(i & android.support.v4.internal.view.SupportMenu.USER_MASK, i2, intent);
            return;
        }
        android.util.Log.w(TAG, "Activity result no fragment exists for who: " + str);
    }

    public void onAttachFragment(android.support.v4.app.Fragment fragment) {
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        android.support.v4.app.FragmentManager supportFragmentManager = this.mFragments.getSupportFragmentManager();
        boolean zIsStateSaved = supportFragmentManager.isStateSaved();
        if (!zIsStateSaved || android.os.Build.VERSION.SDK_INT > 25) {
            if (zIsStateSaved || !supportFragmentManager.popBackStackImmediate()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.dispatchConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(@android.support.annotation.Nullable android.os.Bundle bundle) {
        this.mFragments.attachHost(null);
        super.onCreate(bundle);
        android.support.v4.app.FragmentActivity.NonConfigurationInstances nonConfigurationInstances = (android.support.v4.app.FragmentActivity.NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            this.mFragments.restoreLoaderNonConfig(nonConfigurationInstances.loaders);
        }
        if (bundle != null) {
            this.mFragments.restoreAllState(bundle.getParcelable(FRAGMENTS_TAG), nonConfigurationInstances != null ? nonConfigurationInstances.fragments : null);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                java.lang.String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    android.util.Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new android.support.v4.util.SparseArrayCompat<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.put(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new android.support.v4.util.SparseArrayCompat<>();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.dispatchCreate();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, android.view.Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.support.v4.app.BaseFragmentActivityApi14, android.app.Activity, android.view.LayoutInflater.Factory2
    public /* bridge */ /* synthetic */ android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.support.v4.app.BaseFragmentActivityApi14, android.app.Activity, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.dispatchDestroy();
        this.mFragments.doLoaderDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, android.view.MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.dispatchOptionsItemSelected(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.dispatchContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    @android.support.annotation.CallSuper
    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.dispatchMultiWindowModeChanged(z);
    }

    @Override // android.app.Activity
    protected void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, android.view.Menu menu) {
        if (i == 0) {
            this.mFragments.dispatchOptionsMenuClosed(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.dispatchPause();
    }

    @Override // android.app.Activity
    @android.support.annotation.CallSuper
    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.dispatchPictureInPictureModeChanged(z);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.execPendingActions();
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean onPrepareOptionsPanel(android.view.View view, android.view.Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, android.view.View view, android.view.Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : onPrepareOptionsPanel(view, menu) | this.mFragments.dispatchPrepareOptionsMenu(menu);
    }

    void onReallyStop() {
        this.mFragments.doLoaderStop(this.mRetaining);
        this.mFragments.dispatchReallyStop();
    }

    @Override // android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @android.support.annotation.NonNull java.lang.String[] strArr, @android.support.annotation.NonNull int[] iArr) {
        int i2 = (i >> 16) & android.support.v4.internal.view.SupportMenu.USER_MASK;
        if (i2 != 0) {
            int i3 = i2 - 1;
            java.lang.String str = this.mPendingFragmentActivityResults.get(i3);
            this.mPendingFragmentActivityResults.remove(i3);
            if (str == null) {
                android.util.Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            android.support.v4.app.Fragment fragmentFindFragmentByWho = this.mFragments.findFragmentByWho(str);
            if (fragmentFindFragmentByWho != null) {
                fragmentFindFragmentByWho.onRequestPermissionsResult(i & android.support.v4.internal.view.SupportMenu.USER_MASK, strArr, iArr);
                return;
            }
            android.util.Log.w(TAG, "Activity result no fragment exists for who: " + str);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    protected void onResumeFragments() {
        this.mFragments.dispatchResume();
    }

    public java.lang.Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final java.lang.Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            doReallyStop(true);
        }
        java.lang.Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        android.support.v4.app.FragmentManagerNonConfig fragmentManagerNonConfigRetainNestedNonConfig = this.mFragments.retainNestedNonConfig();
        android.support.v4.util.SimpleArrayMap<java.lang.String, android.support.v4.app.LoaderManager> simpleArrayMapRetainLoaderNonConfig = this.mFragments.retainLoaderNonConfig();
        if (fragmentManagerNonConfigRetainNestedNonConfig == null && simpleArrayMapRetainLoaderNonConfig == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        android.support.v4.app.FragmentActivity.NonConfigurationInstances nonConfigurationInstances = new android.support.v4.app.FragmentActivity.NonConfigurationInstances();
        nonConfigurationInstances.custom = objOnRetainCustomNonConfigurationInstance;
        nonConfigurationInstances.fragments = fragmentManagerNonConfigRetainNestedNonConfig;
        nonConfigurationInstances.loaders = simpleArrayMapRetainLoaderNonConfig;
        return nonConfigurationInstances;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        android.os.Parcelable parcelableSaveAllState = this.mFragments.saveAllState();
        if (parcelableSaveAllState != null) {
            bundle.putParcelable(FRAGMENTS_TAG, parcelableSaveAllState);
        }
        if (this.mPendingFragmentActivityResults.size() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.size()];
            java.lang.String[] strArr = new java.lang.String[this.mPendingFragmentActivityResults.size()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.size(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.keyAt(i);
                strArr[i] = this.mPendingFragmentActivityResults.valueAt(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.dispatchActivityCreated();
        }
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        this.mFragments.doLoaderStart();
        this.mFragments.dispatchStart();
        this.mFragments.reportLoaderStart();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.dispatchStop();
    }

    void requestPermissionsFromFragment(android.support.v4.app.Fragment fragment, java.lang.String[] strArr, int i) {
        if (i == -1) {
            android.support.v4.app.ActivityCompat.requestPermissions(this, strArr, i);
            return;
        }
        checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            android.support.v4.app.ActivityCompat.requestPermissions(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (i & android.support.v4.internal.view.SupportMenu.USER_MASK));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    public void setEnterSharedElementCallback(android.support.v4.app.SharedElementCallback sharedElementCallback) {
        android.support.v4.app.ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(android.support.v4.app.SharedElementCallback sharedElementCallback) {
        android.support.v4.app.ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    @Override // android.app.Activity
    public void startActivityForResult(android.content.Intent intent, int i) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.support.v4.app.BaseFragmentActivityApi16, android.app.Activity
    @android.support.annotation.RequiresApi(16)
    public /* bridge */ /* synthetic */ void startActivityForResult(android.content.Intent intent, int i, @android.support.annotation.Nullable android.os.Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public void startActivityFromFragment(android.support.v4.app.Fragment fragment, android.content.Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (android.os.Bundle) null);
    }

    public void startActivityFromFragment(android.support.v4.app.Fragment fragment, android.content.Intent intent, int i, @android.support.annotation.Nullable android.os.Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        try {
            if (i == -1) {
                android.support.v4.app.ActivityCompat.startActivityForResult(this, intent, -1, bundle);
                this.mStartedActivityFromFragment = false;
            } else {
                checkForValidRequestCode(i);
                android.support.v4.app.ActivityCompat.startActivityForResult(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (i & android.support.v4.internal.view.SupportMenu.USER_MASK), bundle);
                this.mStartedActivityFromFragment = false;
            }
        } catch (java.lang.Throwable th) {
            this.mStartedActivityFromFragment = false;
            throw th;
        }
    }

    @Override // android.support.v4.app.BaseFragmentActivityApi14, android.app.Activity
    public /* bridge */ /* synthetic */ void startIntentSenderForResult(android.content.IntentSender intentSender, int i, @android.support.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4) throws android.content.IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.support.v4.app.BaseFragmentActivityApi16, android.app.Activity
    @android.support.annotation.RequiresApi(16)
    public /* bridge */ /* synthetic */ void startIntentSenderForResult(android.content.IntentSender intentSender, int i, @android.support.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void startIntentSenderFromFragment(android.support.v4.app.Fragment fragment, android.content.IntentSender intentSender, int i, @android.support.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        this.mStartedIntentSenderFromFragment = true;
        try {
            if (i == -1) {
                android.support.v4.app.ActivityCompat.startIntentSenderForResult(this, intentSender, i, intent, i2, i3, i4, bundle);
                this.mStartedIntentSenderFromFragment = false;
            } else {
                checkForValidRequestCode(i);
                android.support.v4.app.ActivityCompat.startIntentSenderForResult(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (i & android.support.v4.internal.view.SupportMenu.USER_MASK), intent, i2, i3, i4, bundle);
                this.mStartedIntentSenderFromFragment = false;
            }
        } catch (java.lang.Throwable th) {
            this.mStartedIntentSenderFromFragment = false;
            throw th;
        }
    }

    public void supportFinishAfterTransition() {
        android.support.v4.app.ActivityCompat.finishAfterTransition(this);
    }

    @java.lang.Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        android.support.v4.app.ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        android.support.v4.app.ActivityCompat.startPostponedEnterTransition(this);
    }

    @Override // android.support.v4.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    public final void validateRequestPermissionsRequestCode(int i) {
        if (this.mRequestedPermissionsFromFragment || i == -1) {
            return;
        }
        checkForValidRequestCode(i);
    }
}
