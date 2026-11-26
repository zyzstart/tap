package android.support.v4.media.session;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(24)
class MediaControllerCompatApi24 {

    public static class TransportControls extends android.support.v4.media.session.MediaControllerCompatApi23.TransportControls {
        public static void prepare(java.lang.Object obj) {
            ((android.media.session.MediaController.TransportControls) obj).prepare();
        }

        public static void prepareFromMediaId(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).prepareFromMediaId(str, bundle);
        }

        public static void prepareFromSearch(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).prepareFromSearch(str, bundle);
        }

        public static void prepareFromUri(java.lang.Object obj, android.net.Uri uri, android.os.Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).prepareFromUri(uri, bundle);
        }
    }

    MediaControllerCompatApi24() {
    }
}
