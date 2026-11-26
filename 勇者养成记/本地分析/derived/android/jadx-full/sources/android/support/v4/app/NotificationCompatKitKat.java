package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(19)
class NotificationCompatKitKat {

    public static class Builder implements android.support.v4.app.NotificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationBuilderWithActions {
        private android.app.Notification.Builder b;
        private java.util.List<android.os.Bundle> mActionExtrasList = new java.util.ArrayList();
        private android.widget.RemoteViews mBigContentView;
        private android.widget.RemoteViews mContentView;
        private android.os.Bundle mExtras;

        public Builder(android.content.Context context, android.app.Notification notification, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, android.widget.RemoteViews remoteViews, int i, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, android.graphics.Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, java.lang.CharSequence charSequence4, boolean z4, java.util.ArrayList<java.lang.String> arrayList, android.os.Bundle bundle, java.lang.String str, boolean z5, java.lang.String str2, android.widget.RemoteViews remoteViews2, android.widget.RemoteViews remoteViews3) {
            boolean z6 = false;
            android.app.Notification.Builder deleteIntent = new android.app.Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z6 = true;
            }
            this.b = deleteIntent.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.mExtras = new android.os.Bundle();
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.mExtras.putStringArray(android.support.v4.app.NotificationCompat.EXTRA_PEOPLE, (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
            }
            if (z4) {
                this.mExtras.putBoolean(android.support.v4.app.NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            if (str != null) {
                this.mExtras.putString(android.support.v4.app.NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                if (z5) {
                    this.mExtras.putBoolean(android.support.v4.app.NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                } else {
                    this.mExtras.putBoolean(android.support.v4.app.NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (str2 != null) {
                this.mExtras.putString(android.support.v4.app.NotificationCompatExtras.EXTRA_SORT_KEY, str2);
            }
            this.mContentView = remoteViews2;
            this.mBigContentView = remoteViews3;
        }

        @Override // android.support.v4.app.NotificationBuilderWithActions
        public void addAction(android.support.v4.app.NotificationCompatBase.Action action) {
            this.mActionExtrasList.add(android.support.v4.app.NotificationCompatJellybean.writeActionAndGetExtras(this.b, action));
        }

        @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
        public android.app.Notification build() {
            android.util.SparseArray<android.os.Bundle> sparseArrayBuildActionExtrasMap = android.support.v4.app.NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (sparseArrayBuildActionExtrasMap != null) {
                this.mExtras.putSparseParcelableArray(android.support.v4.app.NotificationCompatExtras.EXTRA_ACTION_EXTRAS, sparseArrayBuildActionExtrasMap);
            }
            this.b.setExtras(this.mExtras);
            android.app.Notification notificationBuild = this.b.build();
            android.widget.RemoteViews remoteViews = this.mContentView;
            if (remoteViews != null) {
                notificationBuild.contentView = remoteViews;
            }
            android.widget.RemoteViews remoteViews2 = this.mBigContentView;
            if (remoteViews2 != null) {
                notificationBuild.bigContentView = remoteViews2;
            }
            return notificationBuild;
        }

        @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
        public android.app.Notification.Builder getBuilder() {
            return this.b;
        }
    }

    NotificationCompatKitKat() {
    }

    public static android.support.v4.app.NotificationCompatBase.Action getAction(android.app.Notification notification, int i, android.support.v4.app.NotificationCompatBase.Action.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2) {
        android.app.Notification.Action action = notification.actions[i];
        android.util.SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray(android.support.v4.app.NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
        return android.support.v4.app.NotificationCompatJellybean.readAction(factory, factory2, action.icon, action.title, action.actionIntent, sparseParcelableArray != null ? (android.os.Bundle) sparseParcelableArray.get(i) : null);
    }
}
