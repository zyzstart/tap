package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class MediaBrowserServiceCompat extends android.app.Service {
    private static final float EPSILON = 1.0E-5f;

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final java.lang.String KEY_MEDIA_ITEM = "media_item";

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final java.lang.String KEY_SEARCH_RESULTS = "search_results";
    static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    static final int RESULT_OK = 0;
    static final int RESULT_PROGRESS_UPDATE = 1;
    public static final java.lang.String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord mCurConnection;
    private android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl mImpl;
    android.support.v4.media.session.MediaSessionCompat.Token mSession;
    static final java.lang.String TAG = "MBServiceCompat";
    static final boolean DEBUG = android.util.Log.isLoggable(TAG, 3);
    final android.support.v4.util.ArrayMap<android.os.IBinder, android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord> mConnections = new android.support.v4.util.ArrayMap<>();
    final android.support.v4.media.MediaBrowserServiceCompat.ServiceHandler mHandler = new android.support.v4.media.MediaBrowserServiceCompat.ServiceHandler();

    public static final class BrowserRoot {
        public static final java.lang.String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final java.lang.String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final java.lang.String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";

        @java.lang.Deprecated
        public static final java.lang.String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final android.os.Bundle mExtras;
        private final java.lang.String mRootId;

        public BrowserRoot(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.Nullable android.os.Bundle bundle) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.mRootId = str;
            this.mExtras = bundle;
        }

        public android.os.Bundle getExtras() {
            return this.mExtras;
        }

        public java.lang.String getRootId() {
            return this.mRootId;
        }
    }

    private static class ConnectionRecord {
        android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks callbacks;
        java.lang.String pkg;
        android.support.v4.media.MediaBrowserServiceCompat.BrowserRoot root;
        android.os.Bundle rootHints;
        java.util.HashMap<java.lang.String, java.util.List<android.support.v4.util.Pair<android.os.IBinder, android.os.Bundle>>> subscriptions = new java.util.HashMap<>();

        ConnectionRecord() {
        }
    }

    interface MediaBrowserServiceImpl {
        android.os.Bundle getBrowserRootHints();

        void notifyChildrenChanged(java.lang.String str, android.os.Bundle bundle);

        android.os.IBinder onBind(android.content.Intent intent);

        void onCreate();

        void setSessionToken(android.support.v4.media.session.MediaSessionCompat.Token token);
    }

    @android.support.annotation.RequiresApi(21)
    class MediaBrowserServiceImplApi21 implements android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl, android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        android.os.Messenger mMessenger;
        final java.util.List<android.os.Bundle> mRootExtrasList = new java.util.ArrayList();
        java.lang.Object mServiceObj;

        MediaBrowserServiceImplApi21() {
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public android.os.Bundle getBrowserRootHints() {
            if (this.mMessenger == null) {
                return null;
            }
            if (android.support.v4.media.MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new java.lang.IllegalStateException("This should be called inside of onLoadChildren, onLoadItem or onSearch methods");
            }
            if (android.support.v4.media.MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                return null;
            }
            return new android.os.Bundle(android.support.v4.media.MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(final java.lang.String str, final android.os.Bundle bundle) {
            if (this.mMessenger == null) {
                android.support.v4.media.MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
            } else {
                android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2
                    @Override // java.lang.Runnable
                    public void run() {
                        java.util.Iterator<android.os.IBinder> it = android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
                        while (it.hasNext()) {
                            android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.get(it.next());
                            java.util.List<android.support.v4.util.Pair<android.os.IBinder, android.os.Bundle>> list = connectionRecord.subscriptions.get(str);
                            if (list != null) {
                                for (android.support.v4.util.Pair<android.os.IBinder, android.os.Bundle> pair : list) {
                                    if (android.support.v4.media.MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                                        android.support.v4.media.MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, pair.second);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public android.os.IBinder onBind(android.content.Intent intent) {
            return android.support.v4.media.MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = android.support.v4.media.MediaBrowserServiceCompatApi21.createService(android.support.v4.media.MediaBrowserServiceCompat.this, this);
            android.support.v4.media.MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public android.support.v4.media.MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(java.lang.String str, int i, android.os.Bundle bundle) {
            android.os.Bundle extras;
            if (bundle == null || bundle.getInt(android.support.v4.media.MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                extras = null;
            } else {
                bundle.remove(android.support.v4.media.MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.mMessenger = new android.os.Messenger(android.support.v4.media.MediaBrowserServiceCompat.this.mHandler);
                extras = new android.os.Bundle();
                extras.putInt(android.support.v4.media.MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 1);
                android.support.v4.app.BundleCompat.putBinder(extras, android.support.v4.media.MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
                if (android.support.v4.media.MediaBrowserServiceCompat.this.mSession != null) {
                    android.support.v4.media.session.IMediaSession extraBinder = android.support.v4.media.MediaBrowserServiceCompat.this.mSession.getExtraBinder();
                    android.support.v4.app.BundleCompat.putBinder(extras, android.support.v4.media.MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.mRootExtrasList.add(extras);
                }
            }
            android.support.v4.media.MediaBrowserServiceCompat.BrowserRoot browserRootOnGetRoot = android.support.v4.media.MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            if (browserRootOnGetRoot == null) {
                return null;
            }
            if (extras == null) {
                extras = browserRootOnGetRoot.getExtras();
            } else if (browserRootOnGetRoot.getExtras() != null) {
                extras.putAll(browserRootOnGetRoot.getExtras());
            }
            return new android.support.v4.media.MediaBrowserServiceCompatApi21.BrowserRoot(browserRootOnGetRoot.getRootId(), extras);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(java.lang.String str, final android.support.v4.media.MediaBrowserServiceCompatApi21.ResultWrapper<java.util.List<android.os.Parcel>> resultWrapper) {
            android.support.v4.media.MediaBrowserServiceCompat.this.onLoadChildren(str, new android.support.v4.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.3
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    resultWrapper.detach();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void onResultSent(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
                    java.util.ArrayList arrayList;
                    if (list != null) {
                        arrayList = new java.util.ArrayList();
                        for (android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem : list) {
                            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                            mediaItem.writeToParcel(parcelObtain, 0);
                            arrayList.add(parcelObtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList);
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final android.support.v4.media.session.MediaSessionCompat.Token token) {
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty()) {
                        android.support.v4.media.session.IMediaSession extraBinder = token.getExtraBinder();
                        if (extraBinder != null) {
                            java.util.Iterator<android.os.Bundle> it = android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.iterator();
                            while (it.hasNext()) {
                                android.support.v4.app.BundleCompat.putBinder(it.next(), android.support.v4.media.MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                            }
                        }
                        android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
                    }
                    android.support.v4.media.MediaBrowserServiceCompatApi21.setSessionToken(android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mServiceObj, token.getToken());
                }
            });
        }
    }

    @android.support.annotation.RequiresApi(23)
    class MediaBrowserServiceImplApi23 extends android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 implements android.support.v4.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        MediaBrowserServiceImplApi23() {
            super();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = android.support.v4.media.MediaBrowserServiceCompatApi23.createService(android.support.v4.media.MediaBrowserServiceCompat.this, this);
            android.support.v4.media.MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(java.lang.String str, final android.support.v4.media.MediaBrowserServiceCompatApi21.ResultWrapper<android.os.Parcel> resultWrapper) {
            android.support.v4.media.MediaBrowserServiceCompat.this.onLoadItem(str, new android.support.v4.media.MediaBrowserServiceCompat.Result<android.support.v4.media.MediaBrowserCompat.MediaItem>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    resultWrapper.detach();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void onResultSent(android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem) {
                    if (mediaItem == null) {
                        resultWrapper.sendResult(null);
                        return;
                    }
                    android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                    mediaItem.writeToParcel(parcelObtain, 0);
                    resultWrapper.sendResult(parcelObtain);
                }
            });
        }
    }

    @android.support.annotation.RequiresApi(26)
    class MediaBrowserServiceImplApi24 extends android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23 implements android.support.v4.media.MediaBrowserServiceCompatApi24.ServiceCompatProxy {
        MediaBrowserServiceImplApi24() {
            super();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public android.os.Bundle getBrowserRootHints() {
            if (android.support.v4.media.MediaBrowserServiceCompat.this.mCurConnection == null) {
                return android.support.v4.media.MediaBrowserServiceCompatApi24.getBrowserRootHints(this.mServiceObj);
            }
            if (android.support.v4.media.MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                return null;
            }
            return new android.os.Bundle(android.support.v4.media.MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(java.lang.String str, android.os.Bundle bundle) {
            if (bundle == null) {
                android.support.v4.media.MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
            } else {
                android.support.v4.media.MediaBrowserServiceCompatApi24.notifyChildrenChanged(this.mServiceObj, str, bundle);
            }
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = android.support.v4.media.MediaBrowserServiceCompatApi24.createService(android.support.v4.media.MediaBrowserServiceCompat.this, this);
            android.support.v4.media.MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi24.ServiceCompatProxy
        public void onLoadChildren(java.lang.String str, final android.support.v4.media.MediaBrowserServiceCompatApi24.ResultWrapper resultWrapper, android.os.Bundle bundle) {
            android.support.v4.media.MediaBrowserServiceCompat.this.onLoadChildren(str, new android.support.v4.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi24.1
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    resultWrapper.detach();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void onResultSent(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
                    java.util.ArrayList arrayList;
                    if (list != null) {
                        arrayList = new java.util.ArrayList();
                        for (android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem : list) {
                            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                            mediaItem.writeToParcel(parcelObtain, 0);
                            arrayList.add(parcelObtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList, getFlags());
                }
            }, bundle);
        }
    }

    class MediaBrowserServiceImplBase implements android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl {
        private android.os.Messenger mMessenger;

        MediaBrowserServiceImplBase() {
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public android.os.Bundle getBrowserRootHints() {
            if (android.support.v4.media.MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new java.lang.IllegalStateException("This should be called inside of onLoadChildren, onLoadItem or onSearch methods");
            }
            if (android.support.v4.media.MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                return null;
            }
            return new android.os.Bundle(android.support.v4.media.MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@android.support.annotation.NonNull final java.lang.String str, final android.os.Bundle bundle) {
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    java.util.Iterator<android.os.IBinder> it = android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
                    while (it.hasNext()) {
                        android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.get(it.next());
                        java.util.List<android.support.v4.util.Pair<android.os.IBinder, android.os.Bundle>> list = connectionRecord.subscriptions.get(str);
                        if (list != null) {
                            for (android.support.v4.util.Pair<android.os.IBinder, android.os.Bundle> pair : list) {
                                if (android.support.v4.media.MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                                    android.support.v4.media.MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, pair.second);
                                }
                            }
                        }
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public android.os.IBinder onBind(android.content.Intent intent) {
            if (android.support.v4.media.MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.mMessenger.getBinder();
            }
            return null;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mMessenger = new android.os.Messenger(android.support.v4.media.MediaBrowserServiceCompat.this.mHandler);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final android.support.v4.media.session.MediaSessionCompat.Token token) {
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1
                @Override // java.lang.Runnable
                public void run() {
                    java.util.Iterator<android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord> it = android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.values().iterator();
                    while (it.hasNext()) {
                        android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord next = it.next();
                        try {
                            next.callbacks.onConnect(next.root.getRootId(), token, next.root.getExtras());
                        } catch (android.os.RemoteException unused) {
                            android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "Connection for " + next.pkg + " is no longer valid.");
                            it.remove();
                        }
                    }
                }
            });
        }
    }

    public static class Result<T> {
        private final java.lang.Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        Result(java.lang.Object obj) {
            this.mDebug = obj;
        }

        private void checkExtraFields(android.os.Bundle bundle) {
            if (bundle != null && bundle.containsKey(android.support.v4.media.MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                float f = bundle.getFloat(android.support.v4.media.MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                if (f < -1.0E-5f || f > 1.00001f) {
                    throw new java.lang.IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }

        public void detach() {
            if (this.mDetachCalled) {
                throw new java.lang.IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            }
            if (this.mSendResultCalled) {
                throw new java.lang.IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            }
            if (!this.mSendErrorCalled) {
                this.mDetachCalled = true;
                return;
            }
            throw new java.lang.IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
        }

        int getFlags() {
            return this.mFlags;
        }

        boolean isDone() {
            return this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
        }

        void onErrorSent(android.os.Bundle bundle) {
            throw new java.lang.UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        void onProgressUpdateSent(android.os.Bundle bundle) {
            throw new java.lang.UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        void onResultSent(T t) {
        }

        public void sendError(android.os.Bundle bundle) {
            if (!this.mSendResultCalled && !this.mSendErrorCalled) {
                this.mSendErrorCalled = true;
                onErrorSent(bundle);
            } else {
                throw new java.lang.IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
        }

        public void sendProgressUpdate(android.os.Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new java.lang.IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            checkExtraFields(bundle);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(bundle);
        }

        public void sendResult(T t) {
            if (!this.mSendResultCalled && !this.mSendErrorCalled) {
                this.mSendResultCalled = true;
                onResultSent(t);
            } else {
                throw new java.lang.IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
        }

        void setFlags(int i) {
            this.mFlags = i;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    private @interface ResultFlags {
    }

    private class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        public void addSubscription(final java.lang.String str, final android.os.IBinder iBinder, final android.os.Bundle bundle, final android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        android.support.v4.media.MediaBrowserServiceCompat.this.addSubscription(str, connectionRecord, iBinder, bundle);
                        return;
                    }
                    android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "addSubscription for callback that isn't registered id=" + str);
                }
            });
        }

        public void connect(final java.lang.String str, final int i, final android.os.Bundle bundle, final android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            if (android.support.v4.media.MediaBrowserServiceCompat.this.isValidPackage(str, i)) {
                android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.os.IBinder iBinderAsBinder = serviceCallbacks.asBinder();
                        android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.remove(iBinderAsBinder);
                        android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = new android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord();
                        connectionRecord.pkg = str;
                        connectionRecord.rootHints = bundle;
                        connectionRecord.callbacks = serviceCallbacks;
                        connectionRecord.root = android.support.v4.media.MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
                        if (connectionRecord.root != null) {
                            try {
                                android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.put(iBinderAsBinder, connectionRecord);
                                if (android.support.v4.media.MediaBrowserServiceCompat.this.mSession != null) {
                                    serviceCallbacks.onConnect(connectionRecord.root.getRootId(), android.support.v4.media.MediaBrowserServiceCompat.this.mSession, connectionRecord.root.getExtras());
                                    return;
                                }
                                return;
                            } catch (android.os.RemoteException unused) {
                                android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "Calling onConnect() failed. Dropping client. pkg=" + str);
                                android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.remove(iBinderAsBinder);
                                return;
                            }
                        }
                        android.util.Log.i(android.support.v4.media.MediaBrowserServiceCompat.TAG, "No root for client " + str + " from service " + getClass().getName());
                        try {
                            serviceCallbacks.onConnectFailed();
                        } catch (android.os.RemoteException unused2) {
                            android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                        }
                    }
                });
                return;
            }
            throw new java.lang.IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + str);
        }

        public void disconnect(final android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.remove(serviceCallbacks.asBinder());
                }
            });
        }

        public void getMediaItem(final java.lang.String str, final android.support.v4.os.ResultReceiver resultReceiver, final android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            if (android.text.TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        android.support.v4.media.MediaBrowserServiceCompat.this.performLoadItem(str, connectionRecord, resultReceiver);
                        return;
                    }
                    android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "getMediaItem for callback that isn't registered id=" + str);
                }
            });
        }

        public void registerCallbacks(final android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, final android.os.Bundle bundle) {
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    android.os.IBinder iBinderAsBinder = serviceCallbacks.asBinder();
                    android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.remove(iBinderAsBinder);
                    android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = new android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord();
                    connectionRecord.callbacks = serviceCallbacks;
                    connectionRecord.rootHints = bundle;
                    android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.put(iBinderAsBinder, connectionRecord);
                }
            });
        }

        public void removeSubscription(final java.lang.String str, final android.os.IBinder iBinder, final android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "removeSubscription for callback that isn't registered id=" + str);
                        return;
                    }
                    if (android.support.v4.media.MediaBrowserServiceCompat.this.removeSubscription(str, connectionRecord, iBinder)) {
                        return;
                    }
                    android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "removeSubscription called for " + str + " which is not subscribed");
                }
            });
        }

        public void search(final java.lang.String str, final android.os.Bundle bundle, final android.support.v4.os.ResultReceiver resultReceiver, final android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            if (android.text.TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        android.support.v4.media.MediaBrowserServiceCompat.this.performSearch(str, bundle, connectionRecord, resultReceiver);
                        return;
                    }
                    android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "search for callback that isn't registered query=" + str);
                }
            });
        }

        public void sendCustomAction(final java.lang.String str, final android.os.Bundle bundle, final android.support.v4.os.ResultReceiver resultReceiver, final android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            if (android.text.TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        android.support.v4.media.MediaBrowserServiceCompat.this.performCustomAction(str, bundle, connectionRecord, resultReceiver);
                        return;
                    }
                    android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle);
                }
            });
        }

        public void unregisterCallbacks(final android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            android.support.v4.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.remove(serviceCallbacks.asBinder());
                }
            });
        }
    }

    private interface ServiceCallbacks {
        android.os.IBinder asBinder();

        void onConnect(java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle) throws android.os.RemoteException;

        void onConnectFailed() throws android.os.RemoteException;

        void onLoadChildren(java.lang.String str, java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list, android.os.Bundle bundle) throws android.os.RemoteException;
    }

    private static class ServiceCallbacksCompat implements android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks {
        final android.os.Messenger mCallbacks;

        ServiceCallbacksCompat(android.os.Messenger messenger) {
            this.mCallbacks = messenger;
        }

        private void sendRequest(int i, android.os.Bundle bundle) throws android.os.RemoteException {
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            this.mCallbacks.send(messageObtain);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        public android.os.IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle) throws android.os.RemoteException {
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            bundle.putInt(android.support.v4.media.MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 1);
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(android.support.v4.media.MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            sendRequest(1, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() throws android.os.RemoteException {
            sendRequest(2, null);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(java.lang.String str, java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list, android.os.Bundle bundle) throws android.os.RemoteException {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putBundle(android.support.v4.media.MediaBrowserProtocol.DATA_OPTIONS, bundle);
            if (list != null) {
                bundle2.putParcelableArrayList(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof java.util.ArrayList ? (java.util.ArrayList) list : new java.util.ArrayList<>(list));
            }
            sendRequest(3, bundle2);
        }
    }

    private final class ServiceHandler extends android.os.Handler {
        private final android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl mServiceBinderImpl;

        ServiceHandler() {
            this.mServiceBinderImpl = android.support.v4.media.MediaBrowserServiceCompat.this.new ServiceBinderImpl();
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            android.os.Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    this.mServiceBinderImpl.connect(data.getString(android.support.v4.media.MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(android.support.v4.media.MediaBrowserProtocol.DATA_CALLING_UID), data.getBundle(android.support.v4.media.MediaBrowserProtocol.DATA_ROOT_HINTS), new android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 2:
                    this.mServiceBinderImpl.disconnect(new android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 3:
                    this.mServiceBinderImpl.addSubscription(data.getString(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), android.support.v4.app.BundleCompat.getBinder(data, android.support.v4.media.MediaBrowserProtocol.DATA_CALLBACK_TOKEN), data.getBundle(android.support.v4.media.MediaBrowserProtocol.DATA_OPTIONS), new android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 4:
                    this.mServiceBinderImpl.removeSubscription(data.getString(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), android.support.v4.app.BundleCompat.getBinder(data, android.support.v4.media.MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 5:
                    this.mServiceBinderImpl.getMediaItem(data.getString(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (android.support.v4.os.ResultReceiver) data.getParcelable(android.support.v4.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER), new android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 6:
                    this.mServiceBinderImpl.registerCallbacks(new android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo), data.getBundle(android.support.v4.media.MediaBrowserProtocol.DATA_ROOT_HINTS));
                    break;
                case 7:
                    this.mServiceBinderImpl.unregisterCallbacks(new android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 8:
                    this.mServiceBinderImpl.search(data.getString(android.support.v4.media.MediaBrowserProtocol.DATA_SEARCH_QUERY), data.getBundle(android.support.v4.media.MediaBrowserProtocol.DATA_SEARCH_EXTRAS), (android.support.v4.os.ResultReceiver) data.getParcelable(android.support.v4.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER), new android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 9:
                    this.mServiceBinderImpl.sendCustomAction(data.getString(android.support.v4.media.MediaBrowserProtocol.DATA_CUSTOM_ACTION), data.getBundle(android.support.v4.media.MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS), (android.support.v4.os.ResultReceiver) data.getParcelable(android.support.v4.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER), new android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                default:
                    android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "Unhandled message: " + message + "\n  Service version: 1\n  Client version: " + message.arg1);
                    break;
            }
        }

        public void postOrRun(java.lang.Runnable runnable) {
            if (java.lang.Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(android.os.Message message, long j) {
            android.os.Bundle data = message.getData();
            data.setClassLoader(android.support.v4.media.MediaBrowserCompat.class.getClassLoader());
            data.putInt(android.support.v4.media.MediaBrowserProtocol.DATA_CALLING_UID, android.os.Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }
    }

    void addSubscription(java.lang.String str, android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, android.os.IBinder iBinder, android.os.Bundle bundle) {
        java.util.List<android.support.v4.util.Pair<android.os.IBinder, android.os.Bundle>> arrayList = connectionRecord.subscriptions.get(str);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
        }
        for (android.support.v4.util.Pair<android.os.IBinder, android.os.Bundle> pair : arrayList) {
            if (iBinder == pair.first && android.support.v4.media.MediaBrowserCompatUtils.areSameOptions(bundle, pair.second)) {
                return;
            }
        }
        arrayList.add(new android.support.v4.util.Pair<>(iBinder, bundle));
        connectionRecord.subscriptions.put(str, arrayList);
        performLoadChildren(str, connectionRecord, bundle);
    }

    java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> applyOptions(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list, android.os.Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1);
        int i2 = bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int size = i3 + i2;
        if (i < 0 || i2 < 1 || i3 >= list.size()) {
            return java.util.Collections.EMPTY_LIST;
        }
        if (size > list.size()) {
            size = list.size();
        }
        return list.subList(i3, size);
    }

    @Override // android.app.Service
    public void dump(java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
    }

    public final android.os.Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    @android.support.annotation.Nullable
    public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    boolean isValidPackage(java.lang.String str, int i) {
        if (str == null) {
            return false;
        }
        for (java.lang.String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void notifyChildrenChanged(@android.support.annotation.NonNull java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, null);
    }

    public void notifyChildrenChanged(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.os.Bundle bundle) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new java.lang.IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, bundle);
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.mImpl.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mImpl = new android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi24();
        } else if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23();
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21();
        } else {
            this.mImpl = new android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase();
        }
        this.mImpl.onCreate();
    }

    public void onCustomAction(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserServiceCompat.Result<android.os.Bundle> result) {
        result.sendError(null);
    }

    @android.support.annotation.Nullable
    public abstract android.support.v4.media.MediaBrowserServiceCompat.BrowserRoot onGetRoot(@android.support.annotation.NonNull java.lang.String str, int i, @android.support.annotation.Nullable android.os.Bundle bundle);

    public abstract void onLoadChildren(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result);

    public void onLoadChildren(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result, @android.support.annotation.NonNull android.os.Bundle bundle) {
        result.setFlags(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(java.lang.String str, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserServiceCompat.Result<android.support.v4.media.MediaBrowserCompat.MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void onSearch(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result) {
        result.setFlags(4);
        result.sendResult(null);
    }

    void performCustomAction(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, final android.support.v4.os.ResultReceiver resultReceiver) {
        android.support.v4.media.MediaBrowserServiceCompat.Result<android.os.Bundle> result = new android.support.v4.media.MediaBrowserServiceCompat.Result<android.os.Bundle>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.4
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            void onErrorSent(android.os.Bundle bundle2) {
                resultReceiver.send(-1, bundle2);
            }

            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            void onProgressUpdateSent(android.os.Bundle bundle2) {
                resultReceiver.send(1, bundle2);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            public void onResultSent(android.os.Bundle bundle2) {
                resultReceiver.send(0, bundle2);
            }
        };
        this.mCurConnection = connectionRecord;
        onCustomAction(str, bundle, result);
        this.mCurConnection = null;
        if (result.isDone()) {
            return;
        }
        throw new java.lang.IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    void performLoadChildren(final java.lang.String str, final android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, final android.os.Bundle bundle) {
        android.support.v4.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result = new android.support.v4.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            public void onResultSent(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
                if (android.support.v4.media.MediaBrowserServiceCompat.this.mConnections.get(connectionRecord.callbacks.asBinder()) != connectionRecord) {
                    if (android.support.v4.media.MediaBrowserServiceCompat.DEBUG) {
                        android.util.Log.d(android.support.v4.media.MediaBrowserServiceCompat.TAG, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + connectionRecord.pkg + " id=" + str);
                        return;
                    }
                    return;
                }
                if ((getFlags() & 1) != 0) {
                    list = android.support.v4.media.MediaBrowserServiceCompat.this.applyOptions(list, bundle);
                }
                try {
                    connectionRecord.callbacks.onLoadChildren(str, list, bundle);
                } catch (android.os.RemoteException unused) {
                    android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompat.TAG, "Calling onLoadChildren() failed for id=" + str + " package=" + connectionRecord.pkg);
                }
            }
        };
        this.mCurConnection = connectionRecord;
        if (bundle == null) {
            onLoadChildren(str, result);
        } else {
            onLoadChildren(str, result, bundle);
        }
        this.mCurConnection = null;
        if (result.isDone()) {
            return;
        }
        throw new java.lang.IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.pkg + " id=" + str);
    }

    void performLoadItem(java.lang.String str, android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, final android.support.v4.os.ResultReceiver resultReceiver) {
        android.support.v4.media.MediaBrowserServiceCompat.Result<android.support.v4.media.MediaBrowserCompat.MediaItem> result = new android.support.v4.media.MediaBrowserServiceCompat.Result<android.support.v4.media.MediaBrowserCompat.MediaItem>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            public void onResultSent(android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem) {
                if ((getFlags() & 2) != 0) {
                    resultReceiver.send(-1, null);
                    return;
                }
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putParcelable(android.support.v4.media.MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
                resultReceiver.send(0, bundle);
            }
        };
        this.mCurConnection = connectionRecord;
        onLoadItem(str, result);
        this.mCurConnection = null;
        if (result.isDone()) {
            return;
        }
        throw new java.lang.IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    void performSearch(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, final android.support.v4.os.ResultReceiver resultReceiver) {
        android.support.v4.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result = new android.support.v4.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            public void onResultSent(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
                if ((getFlags() & 4) != 0 || list == null) {
                    resultReceiver.send(-1, null);
                    return;
                }
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putParcelableArray(android.support.v4.media.MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (android.os.Parcelable[]) list.toArray(new android.support.v4.media.MediaBrowserCompat.MediaItem[0]));
                resultReceiver.send(0, bundle2);
            }
        };
        this.mCurConnection = connectionRecord;
        onSearch(str, bundle, result);
        this.mCurConnection = null;
        if (result.isDone()) {
            return;
        }
        throw new java.lang.IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    boolean removeSubscription(java.lang.String str, android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, android.os.IBinder iBinder) {
        boolean z = false;
        if (iBinder == null) {
            return connectionRecord.subscriptions.remove(str) != null;
        }
        java.util.List<android.support.v4.util.Pair<android.os.IBinder, android.os.Bundle>> list = connectionRecord.subscriptions.get(str);
        if (list != null) {
            java.util.Iterator<android.support.v4.util.Pair<android.os.IBinder, android.os.Bundle>> it = list.iterator();
            while (it.hasNext()) {
                if (iBinder == it.next().first) {
                    it.remove();
                    z = true;
                }
            }
            if (list.size() == 0) {
                connectionRecord.subscriptions.remove(str);
            }
        }
        return z;
    }

    public void setSessionToken(android.support.v4.media.session.MediaSessionCompat.Token token) {
        if (token == null) {
            throw new java.lang.IllegalArgumentException("[REDACTED]");
        }
        if (this.mSession != null) {
            throw new java.lang.IllegalStateException("[REDACTED]");
        }
        this.mSession = token;
        this.mImpl.setSessionToken(token);
    }
}
