package android.support.v4.media.session;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(23)
class MediaSessionCompatApi23 {

    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi21.Callback {
        void onPlayFromUri(android.net.Uri uri, android.os.Bundle bundle);
    }

    static class CallbackProxy<T extends android.support.v4.media.session.MediaSessionCompatApi23.Callback> extends android.support.v4.media.session.MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(android.net.Uri uri, android.os.Bundle bundle) {
            ((android.support.v4.media.session.MediaSessionCompatApi23.Callback) this.mCallback).onPlayFromUri(uri, bundle);
        }
    }

    MediaSessionCompatApi23() {
    }

    public static java.lang.Object createCallback(android.support.v4.media.session.MediaSessionCompatApi23.Callback callback) {
        return new android.support.v4.media.session.MediaSessionCompatApi23.CallbackProxy(callback);
    }
}
