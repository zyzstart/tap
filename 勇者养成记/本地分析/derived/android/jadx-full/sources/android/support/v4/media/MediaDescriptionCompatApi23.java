package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(23)
class MediaDescriptionCompatApi23 extends android.support.v4.media.MediaDescriptionCompatApi21 {

    static class Builder extends android.support.v4.media.MediaDescriptionCompatApi21.Builder {
        Builder() {
        }

        public static void setMediaUri(java.lang.Object obj, android.net.Uri uri) {
            ((android.media.MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    MediaDescriptionCompatApi23() {
    }

    public static android.net.Uri getMediaUri(java.lang.Object obj) {
        return ((android.media.MediaDescription) obj).getMediaUri();
    }
}
