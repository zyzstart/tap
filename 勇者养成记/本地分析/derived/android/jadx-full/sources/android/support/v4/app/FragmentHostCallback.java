package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class FragmentHostCallback<E> extends android.support.v4.app.FragmentContainer {
    private final android.app.Activity mActivity;
    private android.support.v4.util.SimpleArrayMap<java.lang.String, android.support.v4.app.LoaderManager> mAllLoaderManagers;
    private boolean mCheckedForLoaderManager;
    final android.content.Context mContext;
    final android.support.v4.app.FragmentManagerImpl mFragmentManager;
    private final android.os.Handler mHandler;
    private android.support.v4.app.LoaderManagerImpl mLoaderManager;
    private boolean mLoadersStarted;
    private boolean mRetainLoaders;
    final int mWindowAnimations;

    FragmentHostCallback(android.app.Activity activity, android.content.Context context, android.os.Handler handler, int i) {
        this.mFragmentManager = new android.support.v4.app.FragmentManagerImpl();
        this.mActivity = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.mWindowAnimations = i;
    }

    public FragmentHostCallback(android.content.Context context, android.os.Handler handler, int i) {
        this(context instanceof android.app.Activity ? (android.app.Activity) context : null, context, handler, i);
    }

    FragmentHostCallback(android.support.v4.app.FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    void doLoaderDestroy() {
        android.support.v4.app.LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
        if (loaderManagerImpl == null) {
            return;
        }
        loaderManagerImpl.doDestroy();
    }

    void doLoaderRetain() {
        android.support.v4.app.LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
        if (loaderManagerImpl == null) {
            return;
        }
        loaderManagerImpl.doRetain();
    }

    void doLoaderStart() {
        if (this.mLoadersStarted) {
            return;
        }
        this.mLoadersStarted = true;
        android.support.v4.app.LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
        if (loaderManagerImpl != null) {
            loaderManagerImpl.doStart();
        } else if (!this.mCheckedForLoaderManager) {
            this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, false);
            android.support.v4.app.LoaderManagerImpl loaderManagerImpl2 = this.mLoaderManager;
            if (loaderManagerImpl2 != null && !loaderManagerImpl2.mStarted) {
                this.mLoaderManager.doStart();
            }
        }
        this.mCheckedForLoaderManager = true;
    }

    void doLoaderStop(boolean z) {
        this.mRetainLoaders = z;
        android.support.v4.app.LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
        if (loaderManagerImpl != null && this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (z) {
                loaderManagerImpl.doRetain();
            } else {
                loaderManagerImpl.doStop();
            }
        }
    }

    void dumpLoaders(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.mLoadersStarted);
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this.mLoaderManager)));
            printWriter.println(":");
            this.mLoaderManager.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    android.app.Activity getActivity() {
        return this.mActivity;
    }

    android.content.Context getContext() {
        return this.mContext;
    }

    android.support.v4.app.FragmentManagerImpl getFragmentManagerImpl() {
        return this.mFragmentManager;
    }

    android.os.Handler getHandler() {
        return this.mHandler;
    }

    android.support.v4.app.LoaderManagerImpl getLoaderManager(java.lang.String str, boolean z, boolean z2) {
        if (this.mAllLoaderManagers == null) {
            this.mAllLoaderManagers = new android.support.v4.util.SimpleArrayMap<>();
        }
        android.support.v4.app.LoaderManagerImpl loaderManagerImpl = (android.support.v4.app.LoaderManagerImpl) this.mAllLoaderManagers.get(str);
        if (loaderManagerImpl == null && z2) {
            android.support.v4.app.LoaderManagerImpl loaderManagerImpl2 = new android.support.v4.app.LoaderManagerImpl(str, this, z);
            this.mAllLoaderManagers.put(str, loaderManagerImpl2);
            return loaderManagerImpl2;
        }
        if (!z || loaderManagerImpl == null || loaderManagerImpl.mStarted) {
            return loaderManagerImpl;
        }
        loaderManagerImpl.doStart();
        return loaderManagerImpl;
    }

    android.support.v4.app.LoaderManagerImpl getLoaderManagerImpl() {
        android.support.v4.app.LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
        if (loaderManagerImpl != null) {
            return loaderManagerImpl;
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    boolean getRetainLoaders() {
        return this.mRetainLoaders;
    }

    void inactivateFragment(java.lang.String str) {
        android.support.v4.app.LoaderManagerImpl loaderManagerImpl;
        android.support.v4.util.SimpleArrayMap<java.lang.String, android.support.v4.app.LoaderManager> simpleArrayMap = this.mAllLoaderManagers;
        if (simpleArrayMap == null || (loaderManagerImpl = (android.support.v4.app.LoaderManagerImpl) simpleArrayMap.get(str)) == null || loaderManagerImpl.mRetaining) {
            return;
        }
        loaderManagerImpl.doDestroy();
        this.mAllLoaderManagers.remove(str);
    }

    void onAttachFragment(android.support.v4.app.Fragment fragment) {
    }

    public void onDump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
    }

    @Override // android.support.v4.app.FragmentContainer
    @android.support.annotation.Nullable
    public android.view.View onFindViewById(int i) {
        return null;
    }

    @android.support.annotation.Nullable
    public abstract E onGetHost();

    public android.view.LayoutInflater onGetLayoutInflater() {
        return (android.view.LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    @Override // android.support.v4.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public void onRequestPermissionsFromFragment(@android.support.annotation.NonNull android.support.v4.app.Fragment fragment, @android.support.annotation.NonNull java.lang.String[] strArr, int i) {
    }

    public boolean onShouldSaveFragmentState(android.support.v4.app.Fragment fragment) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(@android.support.annotation.NonNull java.lang.String str) {
        return false;
    }

    public void onStartActivityFromFragment(android.support.v4.app.Fragment fragment, android.content.Intent intent, int i) {
        onStartActivityFromFragment(fragment, intent, i, null);
    }

    public void onStartActivityFromFragment(android.support.v4.app.Fragment fragment, android.content.Intent intent, int i, @android.support.annotation.Nullable android.os.Bundle bundle) {
        if (i != -1) {
            throw new java.lang.IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.mContext.startActivity(intent);
    }

    public void onStartIntentSenderFromFragment(android.support.v4.app.Fragment fragment, android.content.IntentSender intentSender, int i, @android.support.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        if (i != -1) {
            throw new java.lang.IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        android.support.v4.app.ActivityCompat.startIntentSenderForResult(this.mActivity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    void reportLoaderStart() {
        android.support.v4.util.SimpleArrayMap<java.lang.String, android.support.v4.app.LoaderManager> simpleArrayMap = this.mAllLoaderManagers;
        if (simpleArrayMap != null) {
            int size = simpleArrayMap.size();
            android.support.v4.app.LoaderManagerImpl[] loaderManagerImplArr = new android.support.v4.app.LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; i--) {
                loaderManagerImplArr[i] = (android.support.v4.app.LoaderManagerImpl) this.mAllLoaderManagers.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                android.support.v4.app.LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i2];
                loaderManagerImpl.finishRetain();
                loaderManagerImpl.doReportStart();
            }
        }
    }

    void restoreLoaderNonConfig(android.support.v4.util.SimpleArrayMap<java.lang.String, android.support.v4.app.LoaderManager> simpleArrayMap) {
        if (simpleArrayMap != null) {
            int size = simpleArrayMap.size();
            for (int i = 0; i < size; i++) {
                ((android.support.v4.app.LoaderManagerImpl) simpleArrayMap.valueAt(i)).updateHostController(this);
            }
        }
        this.mAllLoaderManagers = simpleArrayMap;
    }

    android.support.v4.util.SimpleArrayMap<java.lang.String, android.support.v4.app.LoaderManager> retainLoaderNonConfig() {
        android.support.v4.util.SimpleArrayMap<java.lang.String, android.support.v4.app.LoaderManager> simpleArrayMap = this.mAllLoaderManagers;
        int i = 0;
        if (simpleArrayMap != null) {
            int size = simpleArrayMap.size();
            android.support.v4.app.LoaderManagerImpl[] loaderManagerImplArr = new android.support.v4.app.LoaderManagerImpl[size];
            for (int i2 = size - 1; i2 >= 0; i2--) {
                loaderManagerImplArr[i2] = (android.support.v4.app.LoaderManagerImpl) this.mAllLoaderManagers.valueAt(i2);
            }
            boolean retainLoaders = getRetainLoaders();
            int i3 = 0;
            while (i < size) {
                android.support.v4.app.LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i];
                if (!loaderManagerImpl.mRetaining && retainLoaders) {
                    if (!loaderManagerImpl.mStarted) {
                        loaderManagerImpl.doStart();
                    }
                    loaderManagerImpl.doRetain();
                }
                if (loaderManagerImpl.mRetaining) {
                    i3 = 1;
                } else {
                    loaderManagerImpl.doDestroy();
                    this.mAllLoaderManagers.remove(loaderManagerImpl.mWho);
                }
                i++;
            }
            i = i3;
        }
        if (i != 0) {
            return this.mAllLoaderManagers;
        }
        return null;
    }
}
