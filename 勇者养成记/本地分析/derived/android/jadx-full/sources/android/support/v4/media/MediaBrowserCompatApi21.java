package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(21)
class MediaBrowserCompatApi21 {
    static final java.lang.String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    static class ConnectionCallbackProxy<T extends android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback> extends android.media.browse.MediaBrowser.ConnectionCallback {
        protected final T mConnectionCallback;

        public ConnectionCallbackProxy(T t) {
            this.mConnectionCallback = t;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }
    }

    static class MediaItem {
        MediaItem() {
        }

        public static java.lang.Object getDescription(java.lang.Object obj) {
            return ((android.media.browse.MediaBrowser.MediaItem) obj).getDescription();
        }

        public static int getFlags(java.lang.Object obj) {
            return ((android.media.browse.MediaBrowser.MediaItem) obj).getFlags();
        }
    }

    interface SubscriptionCallback {
        void onChildrenLoaded(@android.support.annotation.NonNull java.lang.String str, java.util.List<?> list);

        void onError(@android.support.annotation.NonNull java.lang.String str);
    }

    static class SubscriptionCallbackProxy<T extends android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback> extends android.media.browse.MediaBrowser.SubscriptionCallback {
        protected final T mSubscriptionCallback;

        public SubscriptionCallbackProxy(T t) {
            this.mSubscriptionCallback = t;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@android.support.annotation.NonNull java.lang.String str, java.util.List<android.media.browse.MediaBrowser.MediaItem> list) {
            this.mSubscriptionCallback.onChildrenLoaded(str, list);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@android.support.annotation.NonNull java.lang.String str) {
            this.mSubscriptionCallback.onError(str);
        }
    }

    MediaBrowserCompatApi21() {
    }

    public static void connect(java.lang.Object obj) {
        ((android.media.browse.MediaBrowser) obj).connect();
    }

    public static java.lang.Object createBrowser(android.content.Context context, android.content.ComponentName componentName, java.lang.Object obj, android.os.Bundle bundle) {
        return new android.media.browse.MediaBrowser(context, componentName, (android.media.browse.MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static java.lang.Object createConnectionCallback(android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback connectionCallback) {
        return new android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallbackProxy(connectionCallback);
    }

    public static java.lang.Object createSubscriptionCallback(android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback subscriptionCallback) {
        return new android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallbackProxy(subscriptionCallback);
    }

    public static void disconnect(java.lang.Object obj) {
        ((android.media.browse.MediaBrowser) obj).disconnect();
    }

    public static android.os.Bundle getExtras(java.lang.Object obj) {
        return ((android.media.browse.MediaBrowser) obj).getExtras();
    }

    public static java.lang.String getRoot(java.lang.Object obj) {
        return ((android.media.browse.MediaBrowser) obj).getRoot();
    }

    public static android.content.ComponentName getServiceComponent(java.lang.Object obj) {
        return ((android.media.browse.MediaBrowser) obj).getServiceComponent();
    }

    public static java.lang.Object getSessionToken(java.lang.Object obj) {
        return ((android.media.browse.MediaBrowser) obj).getSessionToken();
    }

    public static boolean isConnected(java.lang.Object obj) {
        return ((android.media.browse.MediaBrowser) obj).isConnected();
    }

    public static void subscribe(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        ((android.media.browse.MediaBrowser) obj).subscribe(str, (android.media.browse.MediaBrowser.SubscriptionCallback) obj2);
    }

    public static void unsubscribe(java.lang.Object obj, java.lang.String str) {
        ((android.media.browse.MediaBrowser) obj).unsubscribe(str);
    }
}
