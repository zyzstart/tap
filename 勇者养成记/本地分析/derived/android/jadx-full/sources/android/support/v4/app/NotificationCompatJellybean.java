package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(16)
class NotificationCompatJellybean {
    static final java.lang.String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    static final java.lang.String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    private static final java.lang.String KEY_ACTION_INTENT = "actionIntent";
    private static final java.lang.String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    private static final java.lang.String KEY_EXTRAS = "extras";
    private static final java.lang.String KEY_ICON = "icon";
    private static final java.lang.String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final java.lang.String KEY_TITLE = "title";
    public static final java.lang.String TAG = "NotificationCompat";
    private static java.lang.Class<?> sActionClass;
    private static java.lang.reflect.Field sActionIconField;
    private static java.lang.reflect.Field sActionIntentField;
    private static java.lang.reflect.Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static java.lang.reflect.Field sActionsField;
    private static java.lang.reflect.Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final java.lang.Object sExtrasLock = new java.lang.Object();
    private static final java.lang.Object sActionsLock = new java.lang.Object();

    public static class Builder implements android.support.v4.app.NotificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationBuilderWithActions {
        private android.app.Notification.Builder b;
        private java.util.List<android.os.Bundle> mActionExtrasList = new java.util.ArrayList();
        private android.widget.RemoteViews mBigContentView;
        private android.widget.RemoteViews mContentView;
        private final android.os.Bundle mExtras;

        public Builder(android.content.Context context, android.app.Notification notification, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, android.widget.RemoteViews remoteViews, int i, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, android.graphics.Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, java.lang.CharSequence charSequence4, boolean z3, android.os.Bundle bundle, java.lang.String str, boolean z4, java.lang.String str2, android.widget.RemoteViews remoteViews2, android.widget.RemoteViews remoteViews3) {
            boolean z5 = false;
            android.app.Notification.Builder deleteIntent = new android.app.Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z5 = true;
            }
            this.b = deleteIntent.setFullScreenIntent(pendingIntent2, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.mExtras = new android.os.Bundle();
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            if (z3) {
                this.mExtras.putBoolean(android.support.v4.app.NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            if (str != null) {
                this.mExtras.putString(android.support.v4.app.NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                if (z4) {
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
            android.app.Notification notificationBuild = this.b.build();
            android.os.Bundle extras = android.support.v4.app.NotificationCompatJellybean.getExtras(notificationBuild);
            android.os.Bundle bundle = new android.os.Bundle(this.mExtras);
            for (java.lang.String str : this.mExtras.keySet()) {
                if (extras.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            extras.putAll(bundle);
            android.util.SparseArray<android.os.Bundle> sparseArrayBuildActionExtrasMap = android.support.v4.app.NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (sparseArrayBuildActionExtrasMap != null) {
                android.support.v4.app.NotificationCompatJellybean.getExtras(notificationBuild).putSparseParcelableArray(android.support.v4.app.NotificationCompatExtras.EXTRA_ACTION_EXTRAS, sparseArrayBuildActionExtrasMap);
            }
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

    NotificationCompatJellybean() {
    }

    public static void addBigPictureStyle(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, java.lang.CharSequence charSequence, boolean z, java.lang.CharSequence charSequence2, android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2, boolean z2) {
        android.app.Notification.BigPictureStyle bigPictureStyleBigPicture = new android.app.Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPictureStyleBigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPictureStyleBigPicture.setSummaryText(charSequence2);
        }
    }

    public static void addBigTextStyle(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, java.lang.CharSequence charSequence, boolean z, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        android.app.Notification.BigTextStyle bigTextStyleBigText = new android.app.Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigTextStyleBigText.setSummaryText(charSequence2);
        }
    }

    public static void addInboxStyle(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, java.lang.CharSequence charSequence, boolean z, java.lang.CharSequence charSequence2, java.util.ArrayList<java.lang.CharSequence> arrayList) {
        android.app.Notification.InboxStyle bigContentTitle = new android.app.Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        java.util.Iterator<java.lang.CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }

    public static android.util.SparseArray<android.os.Bundle> buildActionExtrasMap(java.util.List<android.os.Bundle> list) {
        int size = list.size();
        android.util.SparseArray<android.os.Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            android.os.Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new android.util.SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    private static boolean ensureActionReflectionReadyLocked() {
        if (sActionsAccessFailed) {
            return false;
        }
        try {
            if (sActionsField == null) {
                sActionClass = java.lang.Class.forName("android.app.Notification$Action");
                sActionIconField = sActionClass.getDeclaredField("icon");
                sActionTitleField = sActionClass.getDeclaredField("title");
                sActionIntentField = sActionClass.getDeclaredField(KEY_ACTION_INTENT);
                sActionsField = android.app.Notification.class.getDeclaredField("actions");
                sActionsField.setAccessible(true);
            }
        } catch (java.lang.ClassNotFoundException e) {
            android.util.Log.e(TAG, "Unable to access notification actions", e);
            sActionsAccessFailed = true;
        } catch (java.lang.NoSuchFieldException e2) {
            android.util.Log.e(TAG, "Unable to access notification actions", e2);
            sActionsAccessFailed = true;
        }
        return true ^ sActionsAccessFailed;
    }

    public static android.support.v4.app.NotificationCompatBase.Action getAction(android.app.Notification notification, int i, android.support.v4.app.NotificationCompatBase.Action.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2) {
        android.util.SparseArray sparseParcelableArray;
        synchronized (sActionsLock) {
            try {
                try {
                    java.lang.Object[] actionObjectsLocked = getActionObjectsLocked(notification);
                    if (actionObjectsLocked != null) {
                        java.lang.Object obj = actionObjectsLocked[i];
                        android.os.Bundle extras = getExtras(notification);
                        return readAction(factory, factory2, sActionIconField.getInt(obj), (java.lang.CharSequence) sActionTitleField.get(obj), (android.app.PendingIntent) sActionIntentField.get(obj), (extras == null || (sparseParcelableArray = extras.getSparseParcelableArray(android.support.v4.app.NotificationCompatExtras.EXTRA_ACTION_EXTRAS)) == null) ? null : (android.os.Bundle) sparseParcelableArray.get(i));
                    }
                } catch (java.lang.IllegalAccessException e) {
                    android.util.Log.e(TAG, "Unable to access notification actions", e);
                    sActionsAccessFailed = true;
                }
                return null;
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    public static int getActionCount(android.app.Notification notification) {
        int length;
        synchronized (sActionsLock) {
            java.lang.Object[] actionObjectsLocked = getActionObjectsLocked(notification);
            length = actionObjectsLocked != null ? actionObjectsLocked.length : 0;
        }
        return length;
    }

    private static android.support.v4.app.NotificationCompatBase.Action getActionFromBundle(android.os.Bundle bundle, android.support.v4.app.NotificationCompatBase.Action.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2) {
        android.os.Bundle bundle2 = bundle.getBundle(KEY_EXTRAS);
        return factory.build(bundle.getInt("icon"), bundle.getCharSequence("title"), (android.app.PendingIntent) bundle.getParcelable(KEY_ACTION_INTENT), bundle.getBundle(KEY_EXTRAS), android.support.v4.app.RemoteInputCompatJellybean.fromBundleArray(android.support.v4.app.BundleUtil.getBundleArrayFromBundle(bundle, KEY_REMOTE_INPUTS), factory2), android.support.v4.app.RemoteInputCompatJellybean.fromBundleArray(android.support.v4.app.BundleUtil.getBundleArrayFromBundle(bundle, KEY_DATA_ONLY_REMOTE_INPUTS), factory2), bundle2 != null ? bundle2.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES, false) : false);
    }

    private static java.lang.Object[] getActionObjectsLocked(android.app.Notification notification) {
        synchronized (sActionsLock) {
            if (!ensureActionReflectionReadyLocked()) {
                return null;
            }
            try {
                return (java.lang.Object[]) sActionsField.get(notification);
            } catch (java.lang.IllegalAccessException e) {
                android.util.Log.e(TAG, "Unable to access notification actions", e);
                sActionsAccessFailed = true;
                return null;
            }
        }
    }

    public static android.support.v4.app.NotificationCompatBase.Action[] getActionsFromParcelableArrayList(java.util.ArrayList<android.os.Parcelable> arrayList, android.support.v4.app.NotificationCompatBase.Action.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2) {
        if (arrayList == null) {
            return null;
        }
        android.support.v4.app.NotificationCompatBase.Action[] actionArrNewArray = factory.newArray(arrayList.size());
        for (int i = 0; i < actionArrNewArray.length; i++) {
            actionArrNewArray[i] = getActionFromBundle((android.os.Bundle) arrayList.get(i), factory, factory2);
        }
        return actionArrNewArray;
    }

    private static android.os.Bundle getBundleForAction(android.support.v4.app.NotificationCompatBase.Action action) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("icon", action.getIcon());
        bundle.putCharSequence("title", action.getTitle());
        bundle.putParcelable(KEY_ACTION_INTENT, action.getActionIntent());
        android.os.Bundle bundle2 = action.getExtras() != null ? new android.os.Bundle(action.getExtras()) : new android.os.Bundle();
        bundle2.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
        bundle.putBundle(KEY_EXTRAS, bundle2);
        bundle.putParcelableArray(KEY_REMOTE_INPUTS, android.support.v4.app.RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        return bundle;
    }

    public static android.os.Bundle getExtras(android.app.Notification notification) {
        synchronized (sExtrasLock) {
            if (sExtrasFieldAccessFailed) {
                return null;
            }
            try {
                if (sExtrasField == null) {
                    java.lang.reflect.Field declaredField = android.app.Notification.class.getDeclaredField(KEY_EXTRAS);
                    if (!android.os.Bundle.class.isAssignableFrom(declaredField.getType())) {
                        android.util.Log.e(TAG, "Notification.extras field is not of type Bundle");
                        sExtrasFieldAccessFailed = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    sExtrasField = declaredField;
                }
                android.os.Bundle bundle = (android.os.Bundle) sExtrasField.get(notification);
                if (bundle == null) {
                    bundle = new android.os.Bundle();
                    sExtrasField.set(notification, bundle);
                }
                return bundle;
            } catch (java.lang.IllegalAccessException e) {
                android.util.Log.e(TAG, "Unable to access notification extras", e);
                sExtrasFieldAccessFailed = true;
                return null;
            } catch (java.lang.NoSuchFieldException e2) {
                android.util.Log.e(TAG, "Unable to access notification extras", e2);
                sExtrasFieldAccessFailed = true;
                return null;
            }
        }
    }

    public static java.util.ArrayList<android.os.Parcelable> getParcelableArrayListForActions(android.support.v4.app.NotificationCompatBase.Action[] actionArr) {
        if (actionArr == null) {
            return null;
        }
        java.util.ArrayList<android.os.Parcelable> arrayList = new java.util.ArrayList<>(actionArr.length);
        for (android.support.v4.app.NotificationCompatBase.Action action : actionArr) {
            arrayList.add(getBundleForAction(action));
        }
        return arrayList;
    }

    public static android.support.v4.app.NotificationCompatBase.Action readAction(android.support.v4.app.NotificationCompatBase.Action.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2, int i, java.lang.CharSequence charSequence, android.app.PendingIntent pendingIntent, android.os.Bundle bundle) {
        android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArr;
        android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArrFromBundleArray;
        boolean z;
        if (bundle != null) {
            android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArrFromBundleArray2 = android.support.v4.app.RemoteInputCompatJellybean.fromBundleArray(android.support.v4.app.BundleUtil.getBundleArrayFromBundle(bundle, android.support.v4.app.NotificationCompatExtras.EXTRA_REMOTE_INPUTS), factory2);
            remoteInputArrFromBundleArray = android.support.v4.app.RemoteInputCompatJellybean.fromBundleArray(android.support.v4.app.BundleUtil.getBundleArrayFromBundle(bundle, EXTRA_DATA_ONLY_REMOTE_INPUTS), factory2);
            remoteInputArr = remoteInputArrFromBundleArray2;
            z = bundle.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES);
        } else {
            remoteInputArr = null;
            remoteInputArrFromBundleArray = null;
            z = false;
        }
        return factory.build(i, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArrFromBundleArray, z);
    }

    public static android.os.Bundle writeActionAndGetExtras(android.app.Notification.Builder builder, android.support.v4.app.NotificationCompatBase.Action action) {
        builder.addAction(action.getIcon(), action.getTitle(), action.getActionIntent());
        android.os.Bundle bundle = new android.os.Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray(android.support.v4.app.NotificationCompatExtras.EXTRA_REMOTE_INPUTS, android.support.v4.app.RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        }
        if (action.getDataOnlyRemoteInputs() != null) {
            bundle.putParcelableArray(EXTRA_DATA_ONLY_REMOTE_INPUTS, android.support.v4.app.RemoteInputCompatJellybean.toBundleArray(action.getDataOnlyRemoteInputs()));
        }
        bundle.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
        return bundle;
    }
}
