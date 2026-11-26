package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class MediaBrowserCompat {
    public static final java.lang.String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final java.lang.String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final java.lang.String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final java.lang.String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final java.lang.String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final java.lang.String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    private final android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl mImpl;
    static final java.lang.String TAG = "MediaBrowserCompat";
    static final boolean DEBUG = android.util.Log.isLoggable(TAG, 3);

    private static class CallbackHandler extends android.os.Handler {
        private final java.lang.ref.WeakReference<android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private java.lang.ref.WeakReference<android.os.Messenger> mCallbacksMessengerRef;

        CallbackHandler(android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.mCallbackImplRef = new java.lang.ref.WeakReference<>(mediaBrowserServiceCallbackImpl);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            java.lang.ref.WeakReference<android.os.Messenger> weakReference = this.mCallbacksMessengerRef;
            if (weakReference == null || weakReference.get() == null || this.mCallbackImplRef.get() == null) {
                return;
            }
            android.os.Bundle data = message.getData();
            data.setClassLoader(android.support.v4.media.session.MediaSessionCompat.class.getClassLoader());
            android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.mCallbackImplRef.get();
            android.os.Messenger messenger = this.mCallbacksMessengerRef.get();
            try {
                switch (message.what) {
                    case 1:
                        mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (android.support.v4.media.session.MediaSessionCompat.Token) data.getParcelable(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), data.getBundle(android.support.v4.media.MediaBrowserProtocol.DATA_ROOT_HINTS));
                        break;
                    case 2:
                        mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                        break;
                    case 3:
                        mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), data.getBundle(android.support.v4.media.MediaBrowserProtocol.DATA_OPTIONS));
                        break;
                    default:
                        android.util.Log.w(android.support.v4.media.MediaBrowserCompat.TAG, "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                        break;
                }
            } catch (android.os.BadParcelableException unused) {
                android.util.Log.e(android.support.v4.media.MediaBrowserCompat.TAG, "Could not unparcel the data.");
                if (message.what == 1) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                }
            }
        }

        void setCallbacksMessenger(android.os.Messenger messenger) {
            this.mCallbacksMessengerRef = new java.lang.ref.WeakReference<>(messenger);
        }
    }

    public static class ConnectionCallback {
        android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal mConnectionCallbackInternal;
        final java.lang.Object mConnectionCallbackObj;

        interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        private class StubApi21 implements android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback {
            StubApi21() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnected() {
                if (android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnected();
                }
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.onConnected();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionFailed() {
                if (android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnectionFailed();
                }
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.onConnectionFailed();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionSuspended() {
                if (android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnectionSuspended();
                }
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.onConnectionSuspended();
            }
        }

        public ConnectionCallback() {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                this.mConnectionCallbackObj = android.support.v4.media.MediaBrowserCompatApi21.createConnectionCallback(new android.support.v4.media.MediaBrowserCompat.ConnectionCallback.StubApi21());
            } else {
                this.mConnectionCallbackObj = null;
            }
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        void setInternalConnectionCallback(android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }
    }

    public static abstract class CustomActionCallback {
        public void onError(java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
        }

        public void onProgressUpdate(java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
        }

        public void onResult(java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
        }
    }

    private static class CustomActionResultReceiver extends android.support.v4.os.ResultReceiver {
        private final java.lang.String mAction;
        private final android.support.v4.media.MediaBrowserCompat.CustomActionCallback mCallback;
        private final android.os.Bundle mExtras;

        CustomActionResultReceiver(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback, android.os.Handler handler) {
            super(handler);
            this.mAction = str;
            this.mExtras = bundle;
            this.mCallback = customActionCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i, android.os.Bundle bundle) {
            android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback = this.mCallback;
            if (customActionCallback == null) {
            }
            switch (i) {
                case -1:
                    customActionCallback.onError(this.mAction, this.mExtras, bundle);
                    break;
                case 0:
                    customActionCallback.onResult(this.mAction, this.mExtras, bundle);
                    break;
                case 1:
                    customActionCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
                    break;
                default:
                    android.util.Log.w(android.support.v4.media.MediaBrowserCompat.TAG, "Unknown result code: " + i + " (extras=" + this.mExtras + ", resultData=" + bundle + ")");
                    break;
            }
        }
    }

    public static abstract class ItemCallback {
        final java.lang.Object mItemCallbackObj;

        private class StubApi23 implements android.support.v4.media.MediaBrowserCompatApi23.ItemCallback {
            StubApi23() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onError(@android.support.annotation.NonNull java.lang.String str) {
                android.support.v4.media.MediaBrowserCompat.ItemCallback.this.onError(str);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onItemLoaded(android.os.Parcel parcel) {
                if (parcel == null) {
                    android.support.v4.media.MediaBrowserCompat.ItemCallback.this.onItemLoaded(null);
                    return;
                }
                parcel.setDataPosition(0);
                android.support.v4.media.MediaBrowserCompat.MediaItem mediaItemCreateFromParcel = android.support.v4.media.MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(parcel);
                parcel.recycle();
                android.support.v4.media.MediaBrowserCompat.ItemCallback.this.onItemLoaded(mediaItemCreateFromParcel);
            }
        }

        public ItemCallback() {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                this.mItemCallbackObj = android.support.v4.media.MediaBrowserCompatApi23.createItemCallback(new android.support.v4.media.MediaBrowserCompat.ItemCallback.StubApi23());
            } else {
                this.mItemCallbackObj = null;
            }
        }

        public void onError(@android.support.annotation.NonNull java.lang.String str) {
        }

        public void onItemLoaded(android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem) {
        }
    }

    private static class ItemReceiver extends android.support.v4.os.ResultReceiver {
        private final android.support.v4.media.MediaBrowserCompat.ItemCallback mCallback;
        private final java.lang.String mMediaId;

        ItemReceiver(java.lang.String str, android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback, android.os.Handler handler) {
            super(handler);
            this.mMediaId = str;
            this.mCallback = itemCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i, android.os.Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(android.support.v4.media.MediaBrowserCompat.class.getClassLoader());
            }
            if (i != 0 || bundle == null || !bundle.containsKey(android.support.v4.media.MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                this.mCallback.onError(this.mMediaId);
                return;
            }
            android.os.Parcelable parcelable = bundle.getParcelable(android.support.v4.media.MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof android.support.v4.media.MediaBrowserCompat.MediaItem)) {
                this.mCallback.onItemLoaded((android.support.v4.media.MediaBrowserCompat.MediaItem) parcelable);
            } else {
                this.mCallback.onError(this.mMediaId);
            }
        }
    }

    interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @android.support.annotation.Nullable
        android.os.Bundle getExtras();

        void getItem(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback);

        @android.support.annotation.NonNull
        java.lang.String getRoot();

        android.content.ComponentName getServiceComponent();

        @android.support.annotation.NonNull
        android.support.v4.media.session.MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback);

        void sendCustomAction(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @android.support.annotation.Nullable android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback);

        void subscribe(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback);

        void unsubscribe(@android.support.annotation.NonNull java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback);
    }

    @android.support.annotation.RequiresApi(21)
    static class MediaBrowserImplApi21 implements android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl, android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl, android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal {
        protected final java.lang.Object mBrowserObj;
        protected android.os.Messenger mCallbacksMessenger;
        final android.content.Context mContext;
        private android.support.v4.media.session.MediaSessionCompat.Token mMediaSessionToken;
        protected final android.os.Bundle mRootHints;
        protected android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
        protected final android.support.v4.media.MediaBrowserCompat.CallbackHandler mHandler = new android.support.v4.media.MediaBrowserCompat.CallbackHandler(this);
        private final android.support.v4.util.ArrayMap<java.lang.String, android.support.v4.media.MediaBrowserCompat.Subscription> mSubscriptions = new android.support.v4.util.ArrayMap<>();

        public MediaBrowserImplApi21(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            this.mContext = context;
            bundle = bundle == null ? new android.os.Bundle() : bundle;
            bundle.putInt(android.support.v4.media.MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            this.mRootHints = new android.os.Bundle(bundle);
            connectionCallback.setInternalConnectionCallback(this);
            this.mBrowserObj = android.support.v4.media.MediaBrowserCompatApi21.createBrowser(context, componentName, connectionCallback.mConnectionCallbackObj, this.mRootHints);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            android.support.v4.media.MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            android.os.Messenger messenger;
            android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null && (messenger = this.mCallbacksMessenger) != null) {
                try {
                    serviceBinderWrapper.unregisterCallbackMessenger(messenger);
                } catch (android.os.RemoteException unused) {
                    android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error unregistering client messenger.");
                }
            }
            android.support.v4.media.MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @android.support.annotation.Nullable
        public android.os.Bundle getExtras() {
            return android.support.v4.media.MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@android.support.annotation.NonNull final java.lang.String str, @android.support.annotation.NonNull final android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new java.lang.IllegalArgumentException("cb is null");
            }
            if (!android.support.v4.media.MediaBrowserCompatApi21.isConnected(this.mBrowserObj)) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            if (this.mServiceBinderWrapper == null) {
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.2
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(str, new android.support.v4.media.MediaBrowserCompat.ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error getting media item: " + str);
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.3
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @android.support.annotation.NonNull
        public java.lang.String getRoot() {
            return android.support.v4.media.MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.content.ComponentName getServiceComponent() {
            return android.support.v4.media.MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @android.support.annotation.NonNull
        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = android.support.v4.media.session.MediaSessionCompat.Token.fromToken(android.support.v4.media.MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
            }
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return android.support.v4.media.MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            android.os.Bundle extras = android.support.v4.media.MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
            if (extras == null) {
                return;
            }
            android.os.IBinder binder = android.support.v4.app.BundleCompat.getBinder(extras, android.support.v4.media.MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
            if (binder != null) {
                this.mServiceBinderWrapper = new android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper(binder, this.mRootHints);
                this.mCallbacksMessenger = new android.os.Messenger(this.mHandler);
                this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);
                try {
                    this.mServiceBinderWrapper.registerCallbackMessenger(this.mCallbacksMessenger);
                } catch (android.os.RemoteException unused) {
                    android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error registering client messenger.");
                }
            }
            android.support.v4.media.session.IMediaSession iMediaSessionAsInterface = android.support.v4.media.session.IMediaSession.Stub.asInterface(android.support.v4.app.BundleCompat.getBinder(extras, android.support.v4.media.MediaBrowserProtocol.EXTRA_SESSION_BINDER));
            if (iMediaSessionAsInterface != null) {
                this.mMediaSessionToken = android.support.v4.media.session.MediaSessionCompat.Token.fromToken(android.support.v4.media.MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj), iMediaSessionAsInterface);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(android.os.Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(android.os.Messenger messenger, java.lang.String str, java.util.List list, android.os.Bundle bundle) {
            if (this.mCallbacksMessenger != messenger) {
                return;
            }
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                    android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            android.support.v4.media.MediaBrowserCompat.SubscriptionCallback callback = subscription.getCallback(this.mContext, bundle);
            if (callback != null) {
                if (bundle == null) {
                    if (list == null) {
                        callback.onError(str);
                        return;
                    } else {
                        callback.onChildrenLoaded(str, list);
                        return;
                    }
                }
                if (list == null) {
                    callback.onError(str, bundle);
                } else {
                    callback.onChildrenLoaded(str, list, bundle);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(android.os.Messenger messenger, java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@android.support.annotation.NonNull final java.lang.String str, final android.os.Bundle bundle, @android.support.annotation.NonNull final android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("search() called while not connected");
            }
            if (this.mServiceBinderWrapper == null) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "The connected service doesn't support search.");
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.4
                    @Override // java.lang.Runnable
                    public void run() {
                        searchCallback.onError(str, bundle);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.search(str, bundle, new android.support.v4.media.MediaBrowserCompat.SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException e) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error searching items with query: " + str, e);
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.5
                    @Override // java.lang.Runnable
                    public void run() {
                        searchCallback.onError(str, bundle);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@android.support.annotation.NonNull final java.lang.String str, final android.os.Bundle bundle, @android.support.annotation.Nullable final android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            if (this.mServiceBinderWrapper == null) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "The connected service doesn't support sendCustomAction.");
                if (customActionCallback != null) {
                    this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.6
                        @Override // java.lang.Runnable
                        public void run() {
                            customActionCallback.onError(str, bundle, null);
                        }
                    });
                }
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new android.support.v4.media.MediaBrowserCompat.CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException e) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                if (customActionCallback != null) {
                    this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.7
                        @Override // java.lang.Runnable
                        public void run() {
                            customActionCallback.onError(str, bundle, null);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new android.support.v4.media.MediaBrowserCompat.Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            subscriptionCallback.setSubscription(subscription);
            android.os.Bundle bundle2 = bundle == null ? null : new android.os.Bundle(bundle);
            subscription.putCallback(this.mContext, bundle2, subscriptionCallback);
            android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper == null) {
                android.support.v4.media.MediaBrowserCompatApi21.subscribe(this.mBrowserObj, str, subscriptionCallback.mSubscriptionCallbackObj);
                return;
            }
            try {
                serviceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error subscribing media item: " + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@android.support.annotation.NonNull java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null) {
                try {
                    if (subscriptionCallback == null) {
                        serviceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                    } else {
                        java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = subscription.getCallbacks();
                        java.util.List<android.os.Bundle> optionsList = subscription.getOptionsList();
                        for (int size = callbacks.size() - 1; size >= 0; size--) {
                            if (callbacks.get(size) == subscriptionCallback) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                                callbacks.remove(size);
                                optionsList.remove(size);
                            }
                        }
                    }
                } catch (android.os.RemoteException unused) {
                    android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + str);
                }
            } else if (subscriptionCallback == null) {
                android.support.v4.media.MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, str);
            } else {
                java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks2 = subscription.getCallbacks();
                java.util.List<android.os.Bundle> optionsList2 = subscription.getOptionsList();
                for (int size2 = callbacks2.size() - 1; size2 >= 0; size2--) {
                    if (callbacks2.get(size2) == subscriptionCallback) {
                        callbacks2.remove(size2);
                        optionsList2.remove(size2);
                    }
                }
                if (callbacks2.size() == 0) {
                    android.support.v4.media.MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, str);
                }
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }
    }

    @android.support.annotation.RequiresApi(23)
    static class MediaBrowserImplApi23 extends android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
            if (this.mServiceBinderWrapper == null) {
                android.support.v4.media.MediaBrowserCompatApi23.getItem(this.mBrowserObj, str, itemCallback.mItemCallbackObj);
            } else {
                super.getItem(str, itemCallback);
            }
        }
    }

    @android.support.annotation.RequiresApi(26)
    static class MediaBrowserImplApi24 extends android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi23 {
        public MediaBrowserImplApi24(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.os.Bundle bundle, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            if (bundle == null) {
                android.support.v4.media.MediaBrowserCompatApi21.subscribe(this.mBrowserObj, str, subscriptionCallback.mSubscriptionCallbackObj);
            } else {
                android.support.v4.media.MediaBrowserCompatApi24.subscribe(this.mBrowserObj, str, bundle, subscriptionCallback.mSubscriptionCallbackObj);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@android.support.annotation.NonNull java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            if (subscriptionCallback == null) {
                android.support.v4.media.MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, str);
            } else {
                android.support.v4.media.MediaBrowserCompatApi24.unsubscribe(this.mBrowserObj, str, subscriptionCallback.mSubscriptionCallbackObj);
            }
        }
    }

    static class MediaBrowserImplBase implements android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl, android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final android.support.v4.media.MediaBrowserCompat.ConnectionCallback mCallback;
        android.os.Messenger mCallbacksMessenger;
        final android.content.Context mContext;
        private android.os.Bundle mExtras;
        private android.support.v4.media.session.MediaSessionCompat.Token mMediaSessionToken;
        final android.os.Bundle mRootHints;
        private java.lang.String mRootId;
        android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
        final android.content.ComponentName mServiceComponent;
        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection mServiceConnection;
        final android.support.v4.media.MediaBrowserCompat.CallbackHandler mHandler = new android.support.v4.media.MediaBrowserCompat.CallbackHandler(this);
        private final android.support.v4.util.ArrayMap<java.lang.String, android.support.v4.media.MediaBrowserCompat.Subscription> mSubscriptions = new android.support.v4.util.ArrayMap<>();
        int mState = 1;

        private class MediaServiceConnection implements android.content.ServiceConnection {
            MediaServiceConnection() {
            }

            private void postOrRun(java.lang.Runnable runnable) {
                if (java.lang.Thread.currentThread() == android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    runnable.run();
                } else {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.post(runnable);
                }
            }

            boolean isCurrent(java.lang.String str) {
                if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection == this && android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState != 0 && android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState != 1) {
                    return true;
                }
                if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState == 0 || android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState == 1) {
                    return false;
                }
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, str + " for " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final android.content.ComponentName componentName, final android.os.IBinder iBinder) {
                postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                        }
                        if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper = new android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper(iBinder, android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mRootHints);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = new android.os.Messenger(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState = 2;
                            try {
                                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                                    android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                                }
                                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper.connect(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mContext, android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                            } catch (android.os.RemoteException unused) {
                                android.util.Log.w(android.support.v4.media.MediaBrowserCompat.TAG, "RemoteException during connect for " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                                    android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                                }
                            }
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final android.content.ComponentName componentName) {
                postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                        }
                        if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper = null;
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = null;
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(null);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState = 4;
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
                        }
                    }
                });
            }
        }

        public MediaBrowserImplBase(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            if (context == null) {
                throw new java.lang.IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new java.lang.IllegalArgumentException("service component must not be null");
            }
            if (connectionCallback == null) {
                throw new java.lang.IllegalArgumentException("connection callback must not be null");
            }
            this.mContext = context;
            this.mServiceComponent = componentName;
            this.mCallback = connectionCallback;
            this.mRootHints = bundle == null ? null : new android.os.Bundle(bundle);
        }

        private static java.lang.String getStateLabel(int i) {
            switch (i) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTING";
                case 1:
                    return "CONNECT_STATE_DISCONNECTED";
                case 2:
                    return "CONNECT_STATE_CONNECTING";
                case 3:
                    return "CONNECT_STATE_CONNECTED";
                case 4:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    return "UNKNOWN/" + i;
            }
        }

        private boolean isCurrent(android.os.Messenger messenger, java.lang.String str) {
            int i;
            if (this.mCallbacksMessenger == messenger && (i = this.mState) != 0 && i != 1) {
                return true;
            }
            int i2 = this.mState;
            if (i2 == 0 || i2 == 1) {
                return false;
            }
            android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, str + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int i = this.mState;
            if (i == 0 || i == 1) {
                this.mState = 2;
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState == 0) {
                            return;
                        }
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState = 2;
                        if (android.support.v4.media.MediaBrowserCompat.DEBUG && android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection != null) {
                            throw new java.lang.RuntimeException("mServiceConnection should be null. Instead it is " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
                        }
                        if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper != null) {
                            throw new java.lang.RuntimeException("mServiceBinderWrapper should be null. Instead it is " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper);
                        }
                        if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger != null) {
                            throw new java.lang.RuntimeException("mCallbacksMessenger should be null. Instead it is " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                        }
                        android.content.Intent intent = new android.content.Intent(android.support.v4.media.MediaBrowserServiceCompat.SERVICE_INTERFACE);
                        intent.setComponent(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        mediaBrowserImplBase.mServiceConnection = mediaBrowserImplBase.new MediaServiceConnection();
                        boolean zBindService = false;
                        try {
                            zBindService = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mContext.bindService(intent, android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection, 1);
                        } catch (java.lang.Exception unused) {
                            android.util.Log.e(android.support.v4.media.MediaBrowserCompat.TAG, "Failed binding to service " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                        }
                        if (!zBindService) {
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.forceCloseConnection();
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                        }
                        if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "connect...");
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                        }
                    }
                });
            } else {
                throw new java.lang.IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger != null) {
                        try {
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper.disconnect(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                        } catch (android.os.RemoteException unused) {
                            android.util.Log.w(android.support.v4.media.MediaBrowserCompat.TAG, "RemoteException during connect for " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                        }
                    }
                    int i = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState;
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.forceCloseConnection();
                    if (i != 0) {
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState = i;
                    }
                    if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                        android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "disconnect...");
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                    }
                }
            });
        }

        void dump() {
            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "MediaBrowserCompat...");
            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "  mServiceComponent=" + this.mServiceComponent);
            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "  mCallback=" + this.mCallback);
            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "  mRootHints=" + this.mRootHints);
            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "  mState=" + getStateLabel(this.mState));
            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "  mServiceConnection=" + this.mServiceConnection);
            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "  mRootId=" + this.mRootId);
            android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "[REDACTED]" + this.mMediaSessionToken);
        }

        void forceCloseConnection() {
            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
            if (mediaServiceConnection != null) {
                this.mContext.unbindService(mediaServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @android.support.annotation.Nullable
        public android.os.Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            throw new java.lang.IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@android.support.annotation.NonNull final java.lang.String str, @android.support.annotation.NonNull final android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new java.lang.IllegalArgumentException("cb is null");
            }
            if (!isConnected()) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.3
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(str, new android.support.v4.media.MediaBrowserCompat.ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error getting media item: " + str);
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.4
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @android.support.annotation.NonNull
        public java.lang.String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            throw new java.lang.IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @android.support.annotation.NonNull
        public android.content.ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            throw new java.lang.IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @android.support.annotation.NonNull
        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            throw new java.lang.IllegalStateException("[REDACTED]" + this.mState + "[REDACTED]");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mState == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(android.os.Messenger messenger) {
            android.util.Log.e(android.support.v4.media.MediaBrowserCompat.TAG, "onConnectFailed for " + this.mServiceComponent);
            if (isCurrent(messenger, "onConnectFailed")) {
                if (this.mState == 2) {
                    forceCloseConnection();
                    this.mCallback.onConnectionFailed();
                    return;
                }
                android.util.Log.w(android.support.v4.media.MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(android.os.Messenger messenger, java.lang.String str, java.util.List list, android.os.Bundle bundle) {
            if (isCurrent(messenger, "onLoadChildren")) {
                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                    android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "onLoadChildren for " + this.mServiceComponent + " id=" + str);
                }
                android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
                if (subscription == null) {
                    if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                        android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback callback = subscription.getCallback(this.mContext, bundle);
                if (callback != null) {
                    if (bundle == null) {
                        if (list == null) {
                            callback.onError(str);
                            return;
                        } else {
                            callback.onChildrenLoaded(str, list);
                            return;
                        }
                    }
                    if (list == null) {
                        callback.onError(str, bundle);
                    } else {
                        callback.onChildrenLoaded(str, list, bundle);
                    }
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(android.os.Messenger messenger, java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle) {
            if (isCurrent(messenger, "onConnect")) {
                if (this.mState != 2) {
                    android.util.Log.w(android.support.v4.media.MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
                    return;
                }
                this.mRootId = str;
                this.mMediaSessionToken = token;
                this.mExtras = bundle;
                this.mState = 3;
                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                    android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                    dump();
                }
                this.mCallback.onConnected();
                try {
                    for (java.util.Map.Entry<java.lang.String, android.support.v4.media.MediaBrowserCompat.Subscription> entry : this.mSubscriptions.entrySet()) {
                        java.lang.String key = entry.getKey();
                        android.support.v4.media.MediaBrowserCompat.Subscription value = entry.getValue();
                        java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = value.getCallbacks();
                        java.util.List<android.os.Bundle> optionsList = value.getOptionsList();
                        for (int i = 0; i < callbacks.size(); i++) {
                            this.mServiceBinderWrapper.addSubscription(key, callbacks.get(i).mToken, optionsList.get(i), this.mCallbacksMessenger);
                        }
                    }
                } catch (android.os.RemoteException unused) {
                    android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "addSubscription failed with RemoteException.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@android.support.annotation.NonNull final java.lang.String str, final android.os.Bundle bundle, @android.support.annotation.NonNull final android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
            }
            try {
                this.mServiceBinderWrapper.search(str, bundle, new android.support.v4.media.MediaBrowserCompat.SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException e) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error searching items with query: " + str, e);
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        searchCallback.onError(str, bundle);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@android.support.annotation.NonNull final java.lang.String str, final android.os.Bundle bundle, @android.support.annotation.Nullable final android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new android.support.v4.media.MediaBrowserCompat.CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException e) {
                android.util.Log.i(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                if (customActionCallback != null) {
                    this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.6
                        @Override // java.lang.Runnable
                        public void run() {
                            customActionCallback.onError(str, bundle, null);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new android.support.v4.media.MediaBrowserCompat.Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            android.os.Bundle bundle2 = bundle == null ? null : new android.os.Bundle(bundle);
            subscription.putCallback(this.mContext, bundle2, subscriptionCallback);
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
                } catch (android.os.RemoteException unused) {
                    android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "addSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@android.support.annotation.NonNull java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            try {
                if (subscriptionCallback != null) {
                    java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = subscription.getCallbacks();
                    java.util.List<android.os.Bundle> optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == subscriptionCallback) {
                            if (isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                            }
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                } else if (isConnected()) {
                    this.mServiceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                }
            } catch (android.os.RemoteException unused) {
                android.util.Log.d(android.support.v4.media.MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + str);
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }
    }

    interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(android.os.Messenger messenger);

        void onLoadChildren(android.os.Messenger messenger, java.lang.String str, java.util.List list, android.os.Bundle bundle);

        void onServiceConnected(android.os.Messenger messenger, java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle);
    }

    public static class MediaItem implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v4.media.MediaBrowserCompat.MediaItem> CREATOR = new android.os.Parcelable.Creator<android.support.v4.media.MediaBrowserCompat.MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.MediaBrowserCompat.MediaItem createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.media.MediaBrowserCompat.MediaItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.MediaBrowserCompat.MediaItem[] newArray(int i) {
                return new android.support.v4.media.MediaBrowserCompat.MediaItem[i];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final android.support.v4.media.MediaDescriptionCompat mDescription;
        private final int mFlags;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public @interface Flags {
        }

        MediaItem(android.os.Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = android.support.v4.media.MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public MediaItem(@android.support.annotation.NonNull android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new java.lang.IllegalArgumentException("description cannot be null");
            }
            if (android.text.TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new java.lang.IllegalArgumentException("description must have a non-empty media id");
            }
            this.mFlags = i;
            this.mDescription = mediaDescriptionCompat;
        }

        public static android.support.v4.media.MediaBrowserCompat.MediaItem fromMediaItem(java.lang.Object obj) {
            if (obj == null || android.os.Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new android.support.v4.media.MediaBrowserCompat.MediaItem(android.support.v4.media.MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.MediaBrowserCompatApi21.MediaItem.getDescription(obj)), android.support.v4.media.MediaBrowserCompatApi21.MediaItem.getFlags(obj));
        }

        public static java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> fromMediaItemList(java.util.List<?> list) {
            if (list == null || android.os.Build.VERSION.SDK_INT < 21) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
            java.util.Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromMediaItem(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @android.support.annotation.NonNull
        public android.support.v4.media.MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @android.support.annotation.Nullable
        public java.lang.String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        public java.lang.String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i);
        }
    }

    public static abstract class SearchCallback {
        public void onError(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle) {
        }

        public void onSearchResult(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @android.support.annotation.NonNull java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
        }
    }

    private static class SearchResultReceiver extends android.support.v4.os.ResultReceiver {
        private final android.support.v4.media.MediaBrowserCompat.SearchCallback mCallback;
        private final android.os.Bundle mExtras;
        private final java.lang.String mQuery;

        SearchResultReceiver(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback, android.os.Handler handler) {
            super(handler);
            this.mQuery = str;
            this.mExtras = bundle;
            this.mCallback = searchCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i, android.os.Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(android.support.v4.media.MediaBrowserCompat.class.getClassLoader());
            }
            if (i != 0 || bundle == null || !bundle.containsKey(android.support.v4.media.MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            android.os.Parcelable[] parcelableArray = bundle.getParcelableArray(android.support.v4.media.MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            java.util.ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new java.util.ArrayList();
                for (android.os.Parcelable parcelable : parcelableArray) {
                    arrayList.add((android.support.v4.media.MediaBrowserCompat.MediaItem) parcelable);
                }
            }
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, arrayList);
        }
    }

    private static class ServiceBinderWrapper {
        private android.os.Messenger mMessenger;
        private android.os.Bundle mRootHints;

        public ServiceBinderWrapper(android.os.IBinder iBinder, android.os.Bundle bundle) {
            this.mMessenger = new android.os.Messenger(iBinder);
            this.mRootHints = bundle;
        }

        private void sendRequest(int i, android.os.Bundle bundle, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.mMessenger.send(messageObtain);
        }

        void addSubscription(java.lang.String str, android.os.IBinder iBinder, android.os.Bundle bundle, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            android.support.v4.app.BundleCompat.putBinder(bundle2, android.support.v4.media.MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            bundle2.putBundle(android.support.v4.media.MediaBrowserProtocol.DATA_OPTIONS, bundle);
            sendRequest(3, bundle2, messenger);
        }

        void connect(android.content.Context context, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(android.support.v4.media.MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(android.support.v4.media.MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(1, bundle, messenger);
        }

        void disconnect(android.os.Messenger messenger) throws android.os.RemoteException {
            sendRequest(2, null, messenger);
        }

        void getMediaItem(java.lang.String str, android.support.v4.os.ResultReceiver resultReceiver, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle.putParcelable(android.support.v4.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(5, bundle, messenger);
        }

        void registerCallbackMessenger(android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putBundle(android.support.v4.media.MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(6, bundle, messenger);
        }

        void removeSubscription(java.lang.String str, android.os.IBinder iBinder, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(android.support.v4.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            android.support.v4.app.BundleCompat.putBinder(bundle, android.support.v4.media.MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            sendRequest(4, bundle, messenger);
        }

        void search(java.lang.String str, android.os.Bundle bundle, android.support.v4.os.ResultReceiver resultReceiver, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(android.support.v4.media.MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
            bundle2.putBundle(android.support.v4.media.MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
            bundle2.putParcelable(android.support.v4.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(8, bundle2, messenger);
        }

        void sendCustomAction(java.lang.String str, android.os.Bundle bundle, android.support.v4.os.ResultReceiver resultReceiver, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(android.support.v4.media.MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
            bundle2.putBundle(android.support.v4.media.MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
            bundle2.putParcelable(android.support.v4.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(9, bundle2, messenger);
        }

        void unregisterCallbackMessenger(android.os.Messenger messenger) throws android.os.RemoteException {
            sendRequest(7, null, messenger);
        }
    }

    private static class Subscription {
        private final java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> mCallbacks = new java.util.ArrayList();
        private final java.util.List<android.os.Bundle> mOptionsList = new java.util.ArrayList();

        public android.support.v4.media.MediaBrowserCompat.SubscriptionCallback getCallback(android.content.Context context, android.os.Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (android.support.v4.media.MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), bundle)) {
                    return this.mCallbacks.get(i);
                }
            }
            return null;
        }

        public java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public java.util.List<android.os.Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(android.content.Context context, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (android.support.v4.media.MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), bundle)) {
                    this.mCallbacks.set(i, subscriptionCallback);
                    return;
                }
            }
            this.mCallbacks.add(subscriptionCallback);
            this.mOptionsList.add(bundle);
        }
    }

    public static abstract class SubscriptionCallback {
        private final java.lang.Object mSubscriptionCallbackObj;
        java.lang.ref.WeakReference<android.support.v4.media.MediaBrowserCompat.Subscription> mSubscriptionRef;
        private final android.os.IBinder mToken;

        private class StubApi21 implements android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback {
            StubApi21() {
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

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onChildrenLoaded(@android.support.annotation.NonNull java.lang.String str, java.util.List<?> list) {
                android.support.v4.media.MediaBrowserCompat.Subscription subscription = android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.mSubscriptionRef == null ? null : android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.mSubscriptionRef.get();
                if (subscription == null) {
                    android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, android.support.v4.media.MediaBrowserCompat.MediaItem.fromMediaItemList(list));
                    return;
                }
                java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> listFromMediaItemList = android.support.v4.media.MediaBrowserCompat.MediaItem.fromMediaItemList(list);
                java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = subscription.getCallbacks();
                java.util.List<android.os.Bundle> optionsList = subscription.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    android.os.Bundle bundle = optionsList.get(i);
                    if (bundle == null) {
                        android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, listFromMediaItemList);
                    } else {
                        android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, applyOptions(listFromMediaItemList, bundle), bundle);
                    }
                }
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onError(@android.support.annotation.NonNull java.lang.String str) {
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onError(str);
            }
        }

        private class StubApi24 extends android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.StubApi21 implements android.support.v4.media.MediaBrowserCompatApi24.SubscriptionCallback {
            StubApi24() {
                super();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi24.SubscriptionCallback
            public void onChildrenLoaded(@android.support.annotation.NonNull java.lang.String str, java.util.List<?> list, @android.support.annotation.NonNull android.os.Bundle bundle) {
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, android.support.v4.media.MediaBrowserCompat.MediaItem.fromMediaItemList(list), bundle);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi24.SubscriptionCallback
            public void onError(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.os.Bundle bundle) {
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onError(str, bundle);
            }
        }

        public SubscriptionCallback() {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                this.mSubscriptionCallbackObj = android.support.v4.media.MediaBrowserCompatApi24.createSubscriptionCallback(new android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.StubApi24());
                this.mToken = null;
            } else if (android.os.Build.VERSION.SDK_INT >= 21) {
                this.mSubscriptionCallbackObj = android.support.v4.media.MediaBrowserCompatApi21.createSubscriptionCallback(new android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.StubApi21());
                this.mToken = new android.os.Binder();
            } else {
                this.mSubscriptionCallbackObj = null;
                this.mToken = new android.os.Binder();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubscription(android.support.v4.media.MediaBrowserCompat.Subscription subscription) {
            this.mSubscriptionRef = new java.lang.ref.WeakReference<>(subscription);
        }

        public void onChildrenLoaded(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
        }

        public void onChildrenLoaded(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list, @android.support.annotation.NonNull android.os.Bundle bundle) {
        }

        public void onError(@android.support.annotation.NonNull java.lang.String str) {
        }

        public void onError(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.os.Bundle bundle) {
        }
    }

    public MediaBrowserCompat(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi24(context, componentName, connectionCallback, bundle);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi23(context, componentName, connectionCallback, bundle);
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
        } else {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase(context, componentName, connectionCallback, bundle);
        }
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    @android.support.annotation.Nullable
    public android.os.Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
        this.mImpl.getItem(str, itemCallback);
    }

    @android.support.annotation.NonNull
    public java.lang.String getRoot() {
        return this.mImpl.getRoot();
    }

    @android.support.annotation.NonNull
    public android.content.ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @android.support.annotation.NonNull
    public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("query cannot be empty");
        }
        if (searchCallback == null) {
            throw new java.lang.IllegalArgumentException("callback cannot be null");
        }
        this.mImpl.search(str, bundle, searchCallback);
    }

    public void sendCustomAction(@android.support.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @android.support.annotation.Nullable android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("action cannot be empty");
        }
        this.mImpl.sendCustomAction(str, bundle, customActionCallback);
    }

    public void subscribe(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.os.Bundle bundle, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new java.lang.IllegalArgumentException("callback is null");
        }
        if (bundle == null) {
            throw new java.lang.IllegalArgumentException("options are null");
        }
        this.mImpl.subscribe(str, bundle, subscriptionCallback);
    }

    public void subscribe(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new java.lang.IllegalArgumentException("callback is null");
        }
        this.mImpl.subscribe(str, null, subscriptionCallback);
    }

    public void unsubscribe(@android.support.annotation.NonNull java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is empty");
        }
        this.mImpl.unsubscribe(str, null);
    }

    public void unsubscribe(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new java.lang.IllegalArgumentException("callback is null");
        }
        this.mImpl.unsubscribe(str, subscriptionCallback);
    }
}
