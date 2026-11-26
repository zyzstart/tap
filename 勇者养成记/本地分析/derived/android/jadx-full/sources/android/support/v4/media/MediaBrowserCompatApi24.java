package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(24)
class MediaBrowserCompatApi24 {

    interface SubscriptionCallback extends android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback {
        void onChildrenLoaded(@android.support.annotation.NonNull java.lang.String str, java.util.List<?> list, @android.support.annotation.NonNull android.os.Bundle bundle);

        void onError(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.os.Bundle bundle);
    }

    static class SubscriptionCallbackProxy<T extends android.support.v4.media.MediaBrowserCompatApi24.SubscriptionCallback> extends android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
        public SubscriptionCallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@android.support.annotation.NonNull java.lang.String str, java.util.List<android.media.browse.MediaBrowser.MediaItem> list, @android.support.annotation.NonNull android.os.Bundle bundle) {
            ((android.support.v4.media.MediaBrowserCompatApi24.SubscriptionCallback) this.mSubscriptionCallback).onChildrenLoaded(str, list, bundle);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.os.Bundle bundle) {
            ((android.support.v4.media.MediaBrowserCompatApi24.SubscriptionCallback) this.mSubscriptionCallback).onError(str, bundle);
        }
    }

    MediaBrowserCompatApi24() {
    }

    public static java.lang.Object createSubscriptionCallback(android.support.v4.media.MediaBrowserCompatApi24.SubscriptionCallback subscriptionCallback) {
        return new android.support.v4.media.MediaBrowserCompatApi24.SubscriptionCallbackProxy(subscriptionCallback);
    }

    public static void subscribe(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle, java.lang.Object obj2) {
        ((android.media.browse.MediaBrowser) obj).subscribe(str, bundle, (android.media.browse.MediaBrowser.SubscriptionCallback) obj2);
    }

    public static void unsubscribe(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        ((android.media.browse.MediaBrowser) obj).unsubscribe(str, (android.media.browse.MediaBrowser.SubscriptionCallback) obj2);
    }
}
