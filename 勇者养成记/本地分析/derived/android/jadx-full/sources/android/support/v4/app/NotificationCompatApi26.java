package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(26)
class NotificationCompatApi26 {

    public static class Builder implements android.support.v4.app.NotificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationBuilderWithActions {
        private android.app.Notification.Builder mB;

        Builder(android.content.Context context, android.app.Notification notification, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, android.widget.RemoteViews remoteViews, int i, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, android.graphics.Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, java.lang.CharSequence charSequence4, boolean z4, java.lang.String str, java.util.ArrayList<java.lang.String> arrayList, android.os.Bundle bundle, int i5, int i6, android.app.Notification notification2, java.lang.String str2, boolean z5, java.lang.String str3, java.lang.CharSequence[] charSequenceArr, android.widget.RemoteViews remoteViews2, android.widget.RemoteViews remoteViews3, android.widget.RemoteViews remoteViews4, java.lang.String str4, int i7, java.lang.String str5, long j, boolean z6, boolean z7, int i8) {
            boolean z8 = true;
            android.app.Notification.Builder deleteIntent = new android.app.Notification.Builder(context, str4).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) == 0) {
                z8 = false;
            }
            this.mB = deleteIntent.setFullScreenIntent(pendingIntent2, z8).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr).setChannelId(str4).setBadgeIconType(i7).setShortcutId(str5).setTimeoutAfter(j).setGroupAlertBehavior(i8);
            if (z7) {
                this.mB.setColorized(z6);
            }
            if (remoteViews2 != null) {
                this.mB.setCustomContentView(remoteViews2);
            }
            if (remoteViews3 != null) {
                this.mB.setCustomBigContentView(remoteViews3);
            }
            if (remoteViews4 != null) {
                this.mB.setCustomHeadsUpContentView(remoteViews4);
            }
            java.util.Iterator<java.lang.String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.mB.addPerson(it.next());
            }
        }

        @Override // android.support.v4.app.NotificationBuilderWithActions
        public void addAction(android.support.v4.app.NotificationCompatBase.Action action) {
            android.support.v4.app.NotificationCompatApi24.addAction(this.mB, action);
        }

        @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
        public android.app.Notification build() {
            return this.mB.build();
        }

        @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
        public android.app.Notification.Builder getBuilder() {
            return this.mB;
        }
    }

    NotificationCompatApi26() {
    }
}
