package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(23)
class MediaBrowserServiceCompatApi23 {

    static class MediaBrowserServiceAdaptor extends android.support.v4.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(android.content.Context context, android.support.v4.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(java.lang.String str, android.service.media.MediaBrowserService.Result<android.media.browse.MediaBrowser.MediaItem> result) {
            ((android.support.v4.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy) this.mServiceProxy).onLoadItem(str, new android.support.v4.media.MediaBrowserServiceCompatApi21.ResultWrapper<>(result));
        }
    }

    public interface ServiceCompatProxy extends android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(java.lang.String str, android.support.v4.media.MediaBrowserServiceCompatApi21.ResultWrapper<android.os.Parcel> resultWrapper);
    }

    MediaBrowserServiceCompatApi23() {
    }

    public static java.lang.Object createService(android.content.Context context, android.support.v4.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy serviceCompatProxy) {
        return new android.support.v4.media.MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }
}
