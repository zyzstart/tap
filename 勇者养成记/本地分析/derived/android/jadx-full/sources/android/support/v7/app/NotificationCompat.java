package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public class NotificationCompat extends android.support.v4.app.NotificationCompat {

    @java.lang.Deprecated
    public static class Builder extends android.support.v4.app.NotificationCompat.Builder {
        @java.lang.Deprecated
        public Builder(android.content.Context context) {
            super(context);
        }
    }

    @java.lang.Deprecated
    public static class DecoratedCustomViewStyle extends android.support.v4.app.NotificationCompat.DecoratedCustomViewStyle {
        @java.lang.Deprecated
        public DecoratedCustomViewStyle() {
        }
    }

    @java.lang.Deprecated
    public static class DecoratedMediaCustomViewStyle extends android.support.v4.media.app.NotificationCompat.DecoratedMediaCustomViewStyle {
        @java.lang.Deprecated
        public DecoratedMediaCustomViewStyle() {
        }
    }

    @java.lang.Deprecated
    public static class MediaStyle extends android.support.v4.media.app.NotificationCompat.MediaStyle {
        @java.lang.Deprecated
        public MediaStyle() {
        }

        @java.lang.Deprecated
        public MediaStyle(android.support.v4.app.NotificationCompat.Builder builder) {
            super(builder);
        }

        @Override // android.support.v4.media.app.NotificationCompat.MediaStyle
        @java.lang.Deprecated
        public android.support.v7.app.NotificationCompat.MediaStyle setCancelButtonIntent(android.app.PendingIntent pendingIntent) {
            return (android.support.v7.app.NotificationCompat.MediaStyle) super.setCancelButtonIntent(pendingIntent);
        }

        @Override // android.support.v4.media.app.NotificationCompat.MediaStyle
        @java.lang.Deprecated
        public android.support.v7.app.NotificationCompat.MediaStyle setMediaSession(android.support.v4.media.session.MediaSessionCompat.Token token) {
            return (android.support.v7.app.NotificationCompat.MediaStyle) super.setMediaSession(token);
        }

        @Override // android.support.v4.media.app.NotificationCompat.MediaStyle
        @java.lang.Deprecated
        public android.support.v7.app.NotificationCompat.MediaStyle setShowActionsInCompactView(int... iArr) {
            return (android.support.v7.app.NotificationCompat.MediaStyle) super.setShowActionsInCompactView(iArr);
        }

        @Override // android.support.v4.media.app.NotificationCompat.MediaStyle
        @java.lang.Deprecated
        public android.support.v7.app.NotificationCompat.MediaStyle setShowCancelButton(boolean z) {
            return (android.support.v7.app.NotificationCompat.MediaStyle) super.setShowCancelButton(z);
        }
    }

    @java.lang.Deprecated
    public NotificationCompat() {
    }

    @java.lang.Deprecated
    public static android.support.v4.media.session.MediaSessionCompat.Token getMediaSession(android.app.Notification notification) {
        android.os.Bundle extras = getExtras(notification);
        if (extras == null) {
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            android.os.Parcelable parcelable = extras.getParcelable(android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (parcelable != null) {
                return android.support.v4.media.session.MediaSessionCompat.Token.fromToken(parcelable);
            }
            return null;
        }
        android.os.IBinder binder = android.support.v4.app.BundleCompat.getBinder(extras, android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
        if (binder == null) {
            return null;
        }
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        parcelObtain.writeStrongBinder(binder);
        parcelObtain.setDataPosition(0);
        android.support.v4.media.session.MediaSessionCompat.Token tokenCreateFromParcel = android.support.v4.media.session.MediaSessionCompat.Token.CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tokenCreateFromParcel;
    }
}
