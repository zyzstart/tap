package android.support.v4.app;

/* JADX INFO: compiled from: LoaderManager.java */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class LoaderManagerImpl extends android.support.v4.app.LoaderManager {
    static boolean DEBUG = false;
    static final java.lang.String TAG = "LoaderManager";
    boolean mCreatingLoader;
    android.support.v4.app.FragmentHostCallback mHost;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final java.lang.String mWho;
    final android.support.v4.util.SparseArrayCompat<android.support.v4.app.LoaderManagerImpl.LoaderInfo> mLoaders = new android.support.v4.util.SparseArrayCompat<>();
    final android.support.v4.util.SparseArrayCompat<android.support.v4.app.LoaderManagerImpl.LoaderInfo> mInactiveLoaders = new android.support.v4.util.SparseArrayCompat<>();

    /* JADX INFO: compiled from: LoaderManager.java */
    final class LoaderInfo implements android.support.v4.content.Loader.OnLoadCompleteListener<java.lang.Object>, android.support.v4.content.Loader.OnLoadCanceledListener<java.lang.Object> {
        final android.os.Bundle mArgs;
        android.support.v4.app.LoaderManager.LoaderCallbacks<java.lang.Object> mCallbacks;
        java.lang.Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        boolean mHaveData;
        final int mId;
        boolean mListenerRegistered;
        android.support.v4.content.Loader<java.lang.Object> mLoader;
        android.support.v4.app.LoaderManagerImpl.LoaderInfo mPendingLoader;
        boolean mReportNextStart;
        boolean mRetaining;
        boolean mRetainingStarted;
        boolean mStarted;

        public LoaderInfo(int i, android.os.Bundle bundle, android.support.v4.app.LoaderManager.LoaderCallbacks<java.lang.Object> loaderCallbacks) {
            this.mId = i;
            this.mArgs = bundle;
            this.mCallbacks = loaderCallbacks;
        }

        void callOnLoadFinished(android.support.v4.content.Loader<java.lang.Object> loader, java.lang.Object obj) {
            if (this.mCallbacks != null) {
                java.lang.String str = null;
                if (android.support.v4.app.LoaderManagerImpl.this.mHost != null) {
                    str = android.support.v4.app.LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause;
                    android.support.v4.app.LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
                }
                try {
                    if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                        android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  onLoadFinished in " + loader + ": " + loader.dataToString(obj));
                    }
                    this.mCallbacks.onLoadFinished(loader, obj);
                    if (android.support.v4.app.LoaderManagerImpl.this.mHost != null) {
                        android.support.v4.app.LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str;
                    }
                    this.mDeliveredData = true;
                } catch (java.lang.Throwable th) {
                    if (android.support.v4.app.LoaderManagerImpl.this.mHost != null) {
                        android.support.v4.app.LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str;
                    }
                    throw th;
                }
            }
        }

        boolean cancel() {
            android.support.v4.content.Loader<java.lang.Object> loader;
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Canceling: " + this);
            }
            if (!this.mStarted || (loader = this.mLoader) == null || !this.mListenerRegistered) {
                return false;
            }
            boolean zCancelLoad = loader.cancelLoad();
            if (!zCancelLoad) {
                onLoadCanceled(this.mLoader);
            }
            return zCancelLoad;
        }

        void destroy() {
            java.lang.String str;
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Destroying: " + this);
            }
            this.mDestroyed = true;
            boolean z = this.mDeliveredData;
            this.mDeliveredData = false;
            if (this.mCallbacks != null && this.mLoader != null && this.mHaveData && z) {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Resetting: " + this);
                }
                if (android.support.v4.app.LoaderManagerImpl.this.mHost != null) {
                    str = android.support.v4.app.LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause;
                    android.support.v4.app.LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
                } else {
                    str = null;
                }
                try {
                    this.mCallbacks.onLoaderReset(this.mLoader);
                    if (android.support.v4.app.LoaderManagerImpl.this.mHost != null) {
                        android.support.v4.app.LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str;
                    }
                } catch (java.lang.Throwable th) {
                    if (android.support.v4.app.LoaderManagerImpl.this.mHost != null) {
                        android.support.v4.app.LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str;
                    }
                    throw th;
                }
            }
            this.mCallbacks = null;
            this.mData = null;
            this.mHaveData = false;
            android.support.v4.content.Loader<java.lang.Object> loader = this.mLoader;
            if (loader != null) {
                if (this.mListenerRegistered) {
                    this.mListenerRegistered = false;
                    loader.unregisterListener(this);
                    this.mLoader.unregisterOnLoadCanceledListener(this);
                }
                this.mLoader.reset();
            }
            android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfo = this.mPendingLoader;
            if (loaderInfo != null) {
                loaderInfo.destroy();
            }
        }

        public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.mArgs);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.mCallbacks);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.mLoader);
            android.support.v4.content.Loader<java.lang.Object> loader = this.mLoader;
            if (loader != null) {
                loader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.mHaveData || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.mHaveData);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.mDeliveredData);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.mData);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.mReportNextStart);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.mRetainingStarted);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.mListenerRegistered);
            if (this.mPendingLoader != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.mPendingLoader);
                printWriter.println(":");
                this.mPendingLoader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }

        void finishRetain() {
            if (this.mRetaining) {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                boolean z = this.mStarted;
                if (z != this.mRetainingStarted && !z) {
                    stop();
                }
            }
            if (this.mStarted && this.mHaveData && !this.mReportNextStart) {
                callOnLoadFinished(this.mLoader, this.mData);
            }
        }

        @Override // android.support.v4.content.Loader.OnLoadCanceledListener
        public void onLoadCanceled(android.support.v4.content.Loader<java.lang.Object> loader) {
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "onLoadCanceled: " + this);
            }
            if (this.mDestroyed) {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Ignoring load canceled -- destroyed");
                    return;
                }
                return;
            }
            if (android.support.v4.app.LoaderManagerImpl.this.mLoaders.get(this.mId) != this) {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Ignoring load canceled -- not active");
                    return;
                }
                return;
            }
            android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfo = this.mPendingLoader;
            if (loaderInfo != null) {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Switching to pending loader: " + loaderInfo);
                }
                this.mPendingLoader = null;
                android.support.v4.app.LoaderManagerImpl.this.mLoaders.put(this.mId, null);
                destroy();
                android.support.v4.app.LoaderManagerImpl.this.installLoader(loaderInfo);
            }
        }

        @Override // android.support.v4.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(android.support.v4.content.Loader<java.lang.Object> loader, java.lang.Object obj) {
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "onLoadComplete: " + this);
            }
            if (this.mDestroyed) {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Ignoring load complete -- destroyed");
                    return;
                }
                return;
            }
            if (android.support.v4.app.LoaderManagerImpl.this.mLoaders.get(this.mId) != this) {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Ignoring load complete -- not active");
                    return;
                }
                return;
            }
            android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfo = this.mPendingLoader;
            if (loaderInfo != null) {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Switching to pending loader: " + loaderInfo);
                }
                this.mPendingLoader = null;
                android.support.v4.app.LoaderManagerImpl.this.mLoaders.put(this.mId, null);
                destroy();
                android.support.v4.app.LoaderManagerImpl.this.installLoader(loaderInfo);
                return;
            }
            if (this.mData != obj || !this.mHaveData) {
                this.mData = obj;
                this.mHaveData = true;
                if (this.mStarted) {
                    callOnLoadFinished(loader, obj);
                }
            }
            android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfo2 = android.support.v4.app.LoaderManagerImpl.this.mInactiveLoaders.get(this.mId);
            if (loaderInfo2 != null && loaderInfo2 != this) {
                loaderInfo2.mDeliveredData = false;
                loaderInfo2.destroy();
                android.support.v4.app.LoaderManagerImpl.this.mInactiveLoaders.remove(this.mId);
            }
            if (android.support.v4.app.LoaderManagerImpl.this.mHost == null || android.support.v4.app.LoaderManagerImpl.this.hasRunningLoaders()) {
                return;
            }
            android.support.v4.app.LoaderManagerImpl.this.mHost.mFragmentManager.startPendingDeferredFragments();
        }

        void reportStart() {
            if (this.mStarted && this.mReportNextStart) {
                this.mReportNextStart = false;
                if (!this.mHaveData || this.mRetaining) {
                    return;
                }
                callOnLoadFinished(this.mLoader, this.mData);
            }
        }

        void retain() {
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.mRetainingStarted = this.mStarted;
            this.mStarted = false;
            this.mCallbacks = null;
        }

        void start() {
            android.support.v4.app.LoaderManager.LoaderCallbacks<java.lang.Object> loaderCallbacks;
            if (this.mRetaining && this.mRetainingStarted) {
                this.mStarted = true;
                return;
            }
            if (this.mStarted) {
                return;
            }
            this.mStarted = true;
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Starting: " + this);
            }
            if (this.mLoader == null && (loaderCallbacks = this.mCallbacks) != null) {
                this.mLoader = loaderCallbacks.onCreateLoader(this.mId, this.mArgs);
            }
            android.support.v4.content.Loader<java.lang.Object> loader = this.mLoader;
            if (loader != null) {
                if (loader.getClass().isMemberClass() && !java.lang.reflect.Modifier.isStatic(this.mLoader.getClass().getModifiers())) {
                    throw new java.lang.IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader);
                }
                if (!this.mListenerRegistered) {
                    this.mLoader.registerListener(this.mId, this);
                    this.mLoader.registerOnLoadCanceledListener(this);
                    this.mListenerRegistered = true;
                }
                this.mLoader.startLoading();
            }
        }

        void stop() {
            android.support.v4.content.Loader<java.lang.Object> loader;
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v(android.support.v4.app.LoaderManagerImpl.TAG, "  Stopping: " + this);
            }
            this.mStarted = false;
            if (this.mRetaining || (loader = this.mLoader) == null || !this.mListenerRegistered) {
                return;
            }
            this.mListenerRegistered = false;
            loader.unregisterListener(this);
            this.mLoader.unregisterOnLoadCanceledListener(this);
            this.mLoader.stopLoading();
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            android.support.v4.util.DebugUtils.buildShortClassTag(this.mLoader, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    LoaderManagerImpl(java.lang.String str, android.support.v4.app.FragmentHostCallback fragmentHostCallback, boolean z) {
        this.mWho = str;
        this.mHost = fragmentHostCallback;
        this.mStarted = z;
    }

    private android.support.v4.app.LoaderManagerImpl.LoaderInfo createAndInstallLoader(int i, android.os.Bundle bundle, android.support.v4.app.LoaderManager.LoaderCallbacks<java.lang.Object> loaderCallbacks) {
        try {
            this.mCreatingLoader = true;
            android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfoCreateLoader = createLoader(i, bundle, loaderCallbacks);
            installLoader(loaderInfoCreateLoader);
            return loaderInfoCreateLoader;
        } finally {
            this.mCreatingLoader = false;
        }
    }

    private android.support.v4.app.LoaderManagerImpl.LoaderInfo createLoader(int i, android.os.Bundle bundle, android.support.v4.app.LoaderManager.LoaderCallbacks<java.lang.Object> loaderCallbacks) {
        android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfo = new android.support.v4.app.LoaderManagerImpl.LoaderInfo(i, bundle, loaderCallbacks);
        loaderInfo.mLoader = loaderCallbacks.onCreateLoader(i, bundle);
        return loaderInfo;
    }

    @Override // android.support.v4.app.LoaderManager
    public void destroyLoader(int i) {
        if (this.mCreatingLoader) {
            throw new java.lang.IllegalStateException("Called while creating a loader");
        }
        if (DEBUG) {
            android.util.Log.v(TAG, "destroyLoader in " + this + " of " + i);
        }
        int iIndexOfKey = this.mLoaders.indexOfKey(i);
        if (iIndexOfKey >= 0) {
            android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfoValueAt = this.mLoaders.valueAt(iIndexOfKey);
            this.mLoaders.removeAt(iIndexOfKey);
            loaderInfoValueAt.destroy();
        }
        int iIndexOfKey2 = this.mInactiveLoaders.indexOfKey(i);
        if (iIndexOfKey2 >= 0) {
            android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfoValueAt2 = this.mInactiveLoaders.valueAt(iIndexOfKey2);
            this.mInactiveLoaders.removeAt(iIndexOfKey2);
            loaderInfoValueAt2.destroy();
        }
        if (this.mHost == null || hasRunningLoaders()) {
            return;
        }
        this.mHost.mFragmentManager.startPendingDeferredFragments();
    }

    void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                android.util.Log.v(TAG, "Destroying Active in " + this);
            }
            for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
                this.mLoaders.valueAt(size).destroy();
            }
            this.mLoaders.clear();
        }
        if (DEBUG) {
            android.util.Log.v(TAG, "Destroying Inactive in " + this);
        }
        for (int size2 = this.mInactiveLoaders.size() - 1; size2 >= 0; size2--) {
            this.mInactiveLoaders.valueAt(size2).destroy();
        }
        this.mInactiveLoaders.clear();
        this.mHost = null;
    }

    void doReportNextStart() {
        for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
            this.mLoaders.valueAt(size).mReportNextStart = true;
        }
    }

    void doReportStart() {
        for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
            this.mLoaders.valueAt(size).reportStart();
        }
    }

    void doRetain() {
        if (DEBUG) {
            android.util.Log.v(TAG, "Retaining in " + this);
        }
        if (this.mStarted) {
            this.mRetaining = true;
            this.mStarted = false;
            for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
                this.mLoaders.valueAt(size).retain();
            }
            return;
        }
        java.lang.RuntimeException runtimeException = new java.lang.RuntimeException("here");
        runtimeException.fillInStackTrace();
        android.util.Log.w(TAG, "Called doRetain when not started: " + this, runtimeException);
    }

    void doStart() {
        if (DEBUG) {
            android.util.Log.v(TAG, "Starting in " + this);
        }
        if (!this.mStarted) {
            this.mStarted = true;
            for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
                this.mLoaders.valueAt(size).start();
            }
            return;
        }
        java.lang.RuntimeException runtimeException = new java.lang.RuntimeException("here");
        runtimeException.fillInStackTrace();
        android.util.Log.w(TAG, "Called doStart when already started: " + this, runtimeException);
    }

    void doStop() {
        if (DEBUG) {
            android.util.Log.v(TAG, "Stopping in " + this);
        }
        if (this.mStarted) {
            for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
                this.mLoaders.valueAt(size).stop();
            }
            this.mStarted = false;
            return;
        }
        java.lang.RuntimeException runtimeException = new java.lang.RuntimeException("here");
        runtimeException.fillInStackTrace();
        android.util.Log.w(TAG, "Called doStop when not started: " + this, runtimeException);
    }

    @Override // android.support.v4.app.LoaderManager
    public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        if (this.mLoaders.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            java.lang.String str2 = str + "    ";
            for (int i = 0; i < this.mLoaders.size(); i++) {
                android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfoValueAt = this.mLoaders.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.mLoaders.keyAt(i));
                printWriter.print(": ");
                printWriter.println(loaderInfoValueAt.toString());
                loaderInfoValueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.mInactiveLoaders.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            java.lang.String str3 = str + "    ";
            for (int i2 = 0; i2 < this.mInactiveLoaders.size(); i2++) {
                android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfoValueAt2 = this.mInactiveLoaders.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.mInactiveLoaders.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(loaderInfoValueAt2.toString());
                loaderInfoValueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    void finishRetain() {
        if (this.mRetaining) {
            if (DEBUG) {
                android.util.Log.v(TAG, "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
                this.mLoaders.valueAt(size).finishRetain();
            }
        }
    }

    @Override // android.support.v4.app.LoaderManager
    public <D> android.support.v4.content.Loader<D> getLoader(int i) {
        if (this.mCreatingLoader) {
            throw new java.lang.IllegalStateException("Called while creating a loader");
        }
        android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfo = this.mLoaders.get(i);
        if (loaderInfo != null) {
            return loaderInfo.mPendingLoader != null ? (android.support.v4.content.Loader<D>) loaderInfo.mPendingLoader.mLoader : (android.support.v4.content.Loader<D>) loaderInfo.mLoader;
        }
        return null;
    }

    @Override // android.support.v4.app.LoaderManager
    public boolean hasRunningLoaders() {
        int size = this.mLoaders.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfoValueAt = this.mLoaders.valueAt(i);
            z |= loaderInfoValueAt.mStarted && !loaderInfoValueAt.mDeliveredData;
        }
        return z;
    }

    @Override // android.support.v4.app.LoaderManager
    public <D> android.support.v4.content.Loader<D> initLoader(int i, android.os.Bundle bundle, android.support.v4.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.mCreatingLoader) {
            throw new java.lang.IllegalStateException("Called while creating a loader");
        }
        android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfoCreateAndInstallLoader = this.mLoaders.get(i);
        if (DEBUG) {
            android.util.Log.v(TAG, "initLoader in " + this + ": args=" + bundle);
        }
        if (loaderInfoCreateAndInstallLoader == null) {
            loaderInfoCreateAndInstallLoader = createAndInstallLoader(i, bundle, loaderCallbacks);
            if (DEBUG) {
                android.util.Log.v(TAG, "  Created new loader " + loaderInfoCreateAndInstallLoader);
            }
        } else {
            if (DEBUG) {
                android.util.Log.v(TAG, "  Re-using existing loader " + loaderInfoCreateAndInstallLoader);
            }
            loaderInfoCreateAndInstallLoader.mCallbacks = loaderCallbacks;
        }
        if (loaderInfoCreateAndInstallLoader.mHaveData && this.mStarted) {
            loaderInfoCreateAndInstallLoader.callOnLoadFinished(loaderInfoCreateAndInstallLoader.mLoader, loaderInfoCreateAndInstallLoader.mData);
        }
        return (android.support.v4.content.Loader<D>) loaderInfoCreateAndInstallLoader.mLoader;
    }

    void installLoader(android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfo) {
        this.mLoaders.put(loaderInfo.mId, loaderInfo);
        if (this.mStarted) {
            loaderInfo.start();
        }
    }

    @Override // android.support.v4.app.LoaderManager
    public <D> android.support.v4.content.Loader<D> restartLoader(int i, android.os.Bundle bundle, android.support.v4.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.mCreatingLoader) {
            throw new java.lang.IllegalStateException("Called while creating a loader");
        }
        android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfo = this.mLoaders.get(i);
        if (DEBUG) {
            android.util.Log.v(TAG, "restartLoader in " + this + ": args=" + bundle);
        }
        if (loaderInfo != null) {
            android.support.v4.app.LoaderManagerImpl.LoaderInfo loaderInfo2 = this.mInactiveLoaders.get(i);
            if (loaderInfo2 == null) {
                if (DEBUG) {
                    android.util.Log.v(TAG, "  Making last loader inactive: " + loaderInfo);
                }
                loaderInfo.mLoader.abandon();
                this.mInactiveLoaders.put(i, loaderInfo);
            } else if (loaderInfo.mHaveData) {
                if (DEBUG) {
                    android.util.Log.v(TAG, "  Removing last inactive loader: " + loaderInfo);
                }
                loaderInfo2.mDeliveredData = false;
                loaderInfo2.destroy();
                loaderInfo.mLoader.abandon();
                this.mInactiveLoaders.put(i, loaderInfo);
            } else {
                if (loaderInfo.cancel()) {
                    if (DEBUG) {
                        android.util.Log.v(TAG, "  Current loader is running; configuring pending loader");
                    }
                    if (loaderInfo.mPendingLoader != null) {
                        if (DEBUG) {
                            android.util.Log.v(TAG, "  Removing pending loader: " + loaderInfo.mPendingLoader);
                        }
                        loaderInfo.mPendingLoader.destroy();
                        loaderInfo.mPendingLoader = null;
                    }
                    if (DEBUG) {
                        android.util.Log.v(TAG, "  Enqueuing as new pending loader");
                    }
                    loaderInfo.mPendingLoader = createLoader(i, bundle, loaderCallbacks);
                    return (android.support.v4.content.Loader<D>) loaderInfo.mPendingLoader.mLoader;
                }
                if (DEBUG) {
                    android.util.Log.v(TAG, "  Current loader is stopped; replacing");
                }
                this.mLoaders.put(i, null);
                loaderInfo.destroy();
            }
        }
        return (android.support.v4.content.Loader<D>) createAndInstallLoader(i, bundle, loaderCallbacks).mLoader;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        sb.append(" in ");
        android.support.v4.util.DebugUtils.buildShortClassTag(this.mHost, sb);
        sb.append("}}");
        return sb.toString();
    }

    void updateHostController(android.support.v4.app.FragmentHostCallback fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }
}
