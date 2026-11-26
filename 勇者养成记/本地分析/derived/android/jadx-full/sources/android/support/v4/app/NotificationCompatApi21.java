package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(21)
class NotificationCompatApi21 {
    private static final java.lang.String KEY_AUTHOR = "author";
    private static final java.lang.String KEY_MESSAGES = "messages";
    private static final java.lang.String KEY_ON_READ = "on_read";
    private static final java.lang.String KEY_ON_REPLY = "on_reply";
    private static final java.lang.String KEY_PARTICIPANTS = "participants";
    private static final java.lang.String KEY_REMOTE_INPUT = "remote_input";
    private static final java.lang.String KEY_TEXT = "text";
    private static final java.lang.String KEY_TIMESTAMP = "timestamp";

    public static class Builder implements android.support.v4.app.NotificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationBuilderWithActions {
        private android.app.Notification.Builder b;
        private android.widget.RemoteViews mBigContentView;
        private android.widget.RemoteViews mContentView;
        private android.os.Bundle mExtras;
        private int mGroupAlertBehavior;
        private android.widget.RemoteViews mHeadsUpContentView;

        public Builder(android.content.Context context, android.app.Notification notification, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, android.widget.RemoteViews remoteViews, int i, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, android.graphics.Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, java.lang.CharSequence charSequence4, boolean z4, java.lang.String str, java.util.ArrayList<java.lang.String> arrayList, android.os.Bundle bundle, int i5, int i6, android.app.Notification notification2, java.lang.String str2, boolean z5, java.lang.String str3, android.widget.RemoteViews remoteViews2, android.widget.RemoteViews remoteViews3, android.widget.RemoteViews remoteViews4, int i7) {
            boolean z6 = true;
            android.app.Notification.Builder deleteIntent = new android.app.Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) == 0) {
                z6 = false;
            }
            this.b = deleteIntent.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
            this.mExtras = new android.os.Bundle();
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            java.util.Iterator<java.lang.String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.b.addPerson(it.next());
            }
            this.mContentView = remoteViews2;
            this.mBigContentView = remoteViews3;
            this.mHeadsUpContentView = remoteViews4;
            this.mGroupAlertBehavior = i7;
        }

        private void removeSoundAndVibration(android.app.Notification notification) {
            notification.sound = null;
            notification.vibrate = null;
            notification.defaults &= -2;
            notification.defaults &= -3;
        }

        @Override // android.support.v4.app.NotificationBuilderWithActions
        public void addAction(android.support.v4.app.NotificationCompatBase.Action action) {
            android.support.v4.app.NotificationCompatApi20.addAction(this.b, action);
        }

        @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
        public android.app.Notification build() {
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
            android.widget.RemoteViews remoteViews3 = this.mHeadsUpContentView;
            if (remoteViews3 != null) {
                notificationBuild.headsUpContentView = remoteViews3;
            }
            if (this.mGroupAlertBehavior != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                    removeSoundAndVibration(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                    removeSoundAndVibration(notificationBuild);
                }
            }
            return notificationBuild;
        }

        @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
        public android.app.Notification.Builder getBuilder() {
            return this.b;
        }
    }

    NotificationCompatApi21() {
    }

    private static android.app.RemoteInput fromCompatRemoteInput(android.support.v4.app.RemoteInputCompatBase.RemoteInput remoteInput) {
        return new android.app.RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
    }

    static android.os.Bundle getBundleForUnreadConversation(android.support.v4.app.NotificationCompatBase.UnreadConversation unreadConversation) {
        java.lang.String str = null;
        if (unreadConversation == null) {
            return null;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        if (unreadConversation.getParticipants() != null && unreadConversation.getParticipants().length > 1) {
            str = unreadConversation.getParticipants()[0];
        }
        android.os.Parcelable[] parcelableArr = new android.os.Parcelable[unreadConversation.getMessages().length];
        for (int i = 0; i < parcelableArr.length; i++) {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString("text", unreadConversation.getMessages()[i]);
            bundle2.putString(KEY_AUTHOR, str);
            parcelableArr[i] = bundle2;
        }
        bundle.putParcelableArray(KEY_MESSAGES, parcelableArr);
        android.support.v4.app.RemoteInputCompatBase.RemoteInput remoteInput = unreadConversation.getRemoteInput();
        if (remoteInput != null) {
            bundle.putParcelable(KEY_REMOTE_INPUT, fromCompatRemoteInput(remoteInput));
        }
        bundle.putParcelable(KEY_ON_REPLY, unreadConversation.getReplyPendingIntent());
        bundle.putParcelable(KEY_ON_READ, unreadConversation.getReadPendingIntent());
        bundle.putStringArray(KEY_PARTICIPANTS, unreadConversation.getParticipants());
        bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
        return bundle;
    }

    static android.support.v4.app.NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(android.os.Bundle bundle, android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2) {
        java.lang.String[] strArr;
        if (bundle == null) {
            return null;
        }
        android.os.Parcelable[] parcelableArray = bundle.getParcelableArray(KEY_MESSAGES);
        if (parcelableArray != null) {
            java.lang.String[] strArr2 = new java.lang.String[parcelableArray.length];
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= strArr2.length) {
                    z = true;
                    break;
                }
                if (!(parcelableArray[i] instanceof android.os.Bundle)) {
                    break;
                }
                strArr2[i] = ((android.os.Bundle) parcelableArray[i]).getString("text");
                if (strArr2[i] == null) {
                    break;
                }
                i++;
            }
            if (!z) {
                return null;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        android.app.PendingIntent pendingIntent = (android.app.PendingIntent) bundle.getParcelable(KEY_ON_READ);
        android.app.PendingIntent pendingIntent2 = (android.app.PendingIntent) bundle.getParcelable(KEY_ON_REPLY);
        android.app.RemoteInput remoteInput = (android.app.RemoteInput) bundle.getParcelable(KEY_REMOTE_INPUT);
        java.lang.String[] stringArray = bundle.getStringArray(KEY_PARTICIPANTS);
        if (stringArray == null || stringArray.length != 1) {
            return null;
        }
        return factory.build(strArr, remoteInput != null ? toCompatRemoteInput(remoteInput, factory2) : null, pendingIntent2, pendingIntent, stringArray, bundle.getLong("timestamp"));
    }

    private static android.support.v4.app.RemoteInputCompatBase.RemoteInput toCompatRemoteInput(android.app.RemoteInput remoteInput, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory) {
        return factory.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras(), null);
    }
}
