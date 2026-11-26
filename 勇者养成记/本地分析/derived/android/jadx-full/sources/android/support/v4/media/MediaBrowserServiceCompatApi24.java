package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(24)
class MediaBrowserServiceCompatApi24 {
    private static final java.lang.String TAG = "MBSCompatApi24";
    private static java.lang.reflect.Field sResultFlags;

    static class MediaBrowserServiceAdaptor extends android.support.v4.media.MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(android.content.Context context, android.support.v4.media.MediaBrowserServiceCompatApi24.ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(java.lang.String str, android.service.media.MediaBrowserService.Result<java.util.List<android.media.browse.MediaBrowser.MediaItem>> result, android.os.Bundle bundle) {
            ((android.support.v4.media.MediaBrowserServiceCompatApi24.ServiceCompatProxy) this.mServiceProxy).onLoadChildren(str, new android.support.v4.media.MediaBrowserServiceCompatApi24.ResultWrapper(result), bundle);
        }
    }

    static class ResultWrapper {
        android.service.media.MediaBrowserService.Result mResultObj;

        ResultWrapper(android.service.media.MediaBrowserService.Result result) {
            this.mResultObj = result;
        }

        public void detach() {
            this.mResultObj.detach();
        }

        java.util.List<android.media.browse.MediaBrowser.MediaItem> parcelListToItemList(java.util.List<android.os.Parcel> list) {
            if (list == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (android.os.Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(android.media.browse.MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        public void sendResult(java.util.List<android.os.Parcel> list, int i) {
            try {
                android.support.v4.media.MediaBrowserServiceCompatApi24.sResultFlags.setInt(this.mResultObj, i);
            } catch (java.lang.IllegalAccessException e) {
                android.util.Log.w(android.support.v4.media.MediaBrowserServiceCompatApi24.TAG, e);
            }
            this.mResultObj.sendResult(parcelListToItemList(list));
        }
    }

    public interface ServiceCompatProxy extends android.support.v4.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(java.lang.String str, android.support.v4.media.MediaBrowserServiceCompatApi24.ResultWrapper resultWrapper, android.os.Bundle bundle);
    }

    static {
        try {
            sResultFlags = android.service.media.MediaBrowserService.Result.class.getDeclaredField("mFlags");
            sResultFlags.setAccessible(true);
        } catch (java.lang.NoSuchFieldException e) {
            android.util.Log.w(TAG, e);
        }
    }

    MediaBrowserServiceCompatApi24() {
    }

    public static java.lang.Object createService(android.content.Context context, android.support.v4.media.MediaBrowserServiceCompatApi24.ServiceCompatProxy serviceCompatProxy) {
        return new android.support.v4.media.MediaBrowserServiceCompatApi24.MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static android.os.Bundle getBrowserRootHints(java.lang.Object obj) {
        return ((android.service.media.MediaBrowserService) obj).getBrowserRootHints();
    }

    public static void notifyChildrenChanged(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle) {
        ((android.service.media.MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
    }
}
