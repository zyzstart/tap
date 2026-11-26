package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(24)
class NotificationCompatApi24 {

    public static class Builder implements android.support.v4.app.NotificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationBuilderWithActions {
        private android.app.Notification.Builder b;
        private int mGroupAlertBehavior;

        public Builder(android.content.Context context, android.app.Notification notification, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, android.widget.RemoteViews remoteViews, int i, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, android.graphics.Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, java.lang.CharSequence charSequence4, boolean z4, java.lang.String str, java.util.ArrayList<java.lang.String> arrayList, android.os.Bundle bundle, int i5, int i6, android.app.Notification notification2, java.lang.String str2, boolean z5, java.lang.String str3, java.lang.CharSequence[] charSequenceArr, android.widget.RemoteViews remoteViews2, android.widget.RemoteViews remoteViews3, android.widget.RemoteViews remoteViews4, int i7) {
            boolean z6 = true;
            android.app.Notification.Builder deleteIntent = new android.app.Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) == 0) {
                z6 = false;
            }
            this.b = deleteIntent.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr);
            if (remoteViews2 != null) {
                this.b.setCustomContentView(remoteViews2);
            }
            if (remoteViews3 != null) {
                this.b.setCustomBigContentView(remoteViews3);
            }
            if (remoteViews4 != null) {
                this.b.setCustomHeadsUpContentView(remoteViews4);
            }
            java.util.Iterator<java.lang.String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.b.addPerson(it.next());
            }
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
            android.support.v4.app.NotificationCompatApi24.addAction(this.b, action);
        }

        @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
        public android.app.Notification build() {
            android.app.Notification notificationBuild = this.b.build();
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

    NotificationCompatApi24() {
    }

    public static void addAction(android.app.Notification.Builder builder, android.support.v4.app.NotificationCompatBase.Action action) {
        android.app.Notification.Action.Builder builder2 = new android.app.Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (android.app.RemoteInput remoteInput : android.support.v4.app.RemoteInputCompatApi20.fromCompat(action.getRemoteInputs())) {
                builder2.addRemoteInput(remoteInput);
            }
        }
        android.os.Bundle bundle = action.getExtras() != null ? new android.os.Bundle(action.getExtras()) : new android.os.Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        builder2.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }

    public static void addMessagingStyle(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.util.List<java.lang.CharSequence> list, java.util.List<java.lang.Long> list2, java.util.List<java.lang.CharSequence> list3, java.util.List<java.lang.String> list4, java.util.List<android.net.Uri> list5) {
        android.app.Notification.MessagingStyle conversationTitle = new android.app.Notification.MessagingStyle(charSequence).setConversationTitle(charSequence2);
        for (int i = 0; i < list.size(); i++) {
            android.app.Notification.MessagingStyle.Message message = new android.app.Notification.MessagingStyle.Message(list.get(i), list2.get(i).longValue(), list3.get(i));
            if (list4.get(i) != null) {
                message.setData(list4.get(i), list5.get(i));
            }
            conversationTitle.addMessage(message);
        }
        conversationTitle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
    }

    public static android.support.v4.app.NotificationCompatBase.Action getAction(android.app.Notification notification, int i, android.support.v4.app.NotificationCompatBase.Action.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return getActionCompatFromAction(notification.actions[i], factory, factory2);
    }

    private static android.support.v4.app.NotificationCompatBase.Action getActionCompatFromAction(android.app.Notification.Action action, android.support.v4.app.NotificationCompatBase.Action.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return factory.build(action.icon, action.title, action.actionIntent, action.getExtras(), android.support.v4.app.RemoteInputCompatApi20.toCompat(action.getRemoteInputs(), factory2), null, action.getExtras().getBoolean("android.support.allowGeneratedReplies") || action.getAllowGeneratedReplies());
    }

    private static android.app.Notification.Action getActionFromActionCompat(android.support.v4.app.NotificationCompatBase.Action action) {
        android.app.Notification.Action.Builder builder = new android.app.Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
        android.os.Bundle bundle = action.getExtras() != null ? new android.os.Bundle(action.getExtras()) : new android.os.Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
        builder.addExtras(bundle);
        android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputs = action.getRemoteInputs();
        if (remoteInputs != null) {
            for (android.app.RemoteInput remoteInput : android.support.v4.app.RemoteInputCompatApi20.fromCompat(remoteInputs)) {
                builder.addRemoteInput(remoteInput);
            }
        }
        return builder.build();
    }

    public static android.support.v4.app.NotificationCompatBase.Action[] getActionsFromParcelableArrayList(java.util.ArrayList<android.os.Parcelable> arrayList, android.support.v4.app.NotificationCompatBase.Action.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2) {
        if (arrayList == null) {
            return null;
        }
        android.support.v4.app.NotificationCompatBase.Action[] actionArrNewArray = factory.newArray(arrayList.size());
        for (int i = 0; i < actionArrNewArray.length; i++) {
            actionArrNewArray[i] = getActionCompatFromAction((android.app.Notification.Action) arrayList.get(i), factory, factory2);
        }
        return actionArrNewArray;
    }

    public static java.util.ArrayList<android.os.Parcelable> getParcelableArrayListForActions(android.support.v4.app.NotificationCompatBase.Action[] actionArr) {
        if (actionArr == null) {
            return null;
        }
        java.util.ArrayList<android.os.Parcelable> arrayList = new java.util.ArrayList<>(actionArr.length);
        for (android.support.v4.app.NotificationCompatBase.Action action : actionArr) {
            arrayList.add(getActionFromActionCompat(action));
        }
        return arrayList;
    }
}
