package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class NotificationCompatSideChannelService extends android.app.Service {

    private class NotificationSideChannelStub extends android.support.v4.app.INotificationSideChannel.Stub {
        NotificationSideChannelStub() {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(java.lang.String str, int i, java.lang.String str2) throws android.os.RemoteException {
            android.support.v4.app.NotificationCompatSideChannelService.this.checkPermission(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                android.support.v4.app.NotificationCompatSideChannelService.this.cancel(str, i, str2);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(java.lang.String str) {
            android.support.v4.app.NotificationCompatSideChannelService.this.checkPermission(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                android.support.v4.app.NotificationCompatSideChannelService.this.cancelAll(str);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(java.lang.String str, int i, java.lang.String str2, android.app.Notification notification) throws android.os.RemoteException {
            android.support.v4.app.NotificationCompatSideChannelService.this.checkPermission(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                android.support.v4.app.NotificationCompatSideChannelService.this.notify(str, i, str2, notification);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    public abstract void cancel(java.lang.String str, int i, java.lang.String str2);

    public abstract void cancelAll(java.lang.String str);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void checkPermission(int i, java.lang.String str) {
        for (java.lang.String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return;
            }
        }
        throw new java.lang.SecurityException("NotificationSideChannelService: Uid " + i + " is not authorized for package " + str);
    }

    public abstract void notify(java.lang.String str, int i, java.lang.String str2, android.app.Notification notification);

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        if (!intent.getAction().equals(android.support.v4.app.NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL) || android.os.Build.VERSION.SDK_INT > 19) {
            return null;
        }
        return new android.support.v4.app.NotificationCompatSideChannelService.NotificationSideChannelStub();
    }
}
