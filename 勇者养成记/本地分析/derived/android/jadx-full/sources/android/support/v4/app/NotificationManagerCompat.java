package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class NotificationManagerCompat {
    public static final java.lang.String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final java.lang.String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final java.lang.String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final java.lang.String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final java.lang.String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final java.lang.String TAG = "NotifManCompat";

    @android.support.annotation.GuardedBy("sEnabledNotificationListenersLock")
    private static java.lang.String sEnabledNotificationListeners;

    @android.support.annotation.GuardedBy("sLock")
    private static android.support.v4.app.NotificationManagerCompat.SideChannelManager sSideChannelManager;
    private final android.content.Context mContext;
    private final android.app.NotificationManager mNotificationManager;
    private static final java.lang.Object sEnabledNotificationListenersLock = new java.lang.Object();

    @android.support.annotation.GuardedBy("sEnabledNotificationListenersLock")
    private static java.util.Set<java.lang.String> sEnabledNotificationListenerPackages = new java.util.HashSet();
    private static final java.lang.Object sLock = new java.lang.Object();

    private static class CancelTask implements android.support.v4.app.NotificationManagerCompat.Task {
        final boolean all;
        final int id;
        final java.lang.String packageName;
        final java.lang.String tag;

        CancelTask(java.lang.String str) {
            this.packageName = str;
            this.id = 0;
            this.tag = null;
            this.all = true;
        }

        CancelTask(java.lang.String str, int i, java.lang.String str2) {
            this.packageName = str;
            this.id = i;
            this.tag = str2;
            this.all = false;
        }

        @Override // android.support.v4.app.NotificationManagerCompat.Task
        public void send(android.support.v4.app.INotificationSideChannel iNotificationSideChannel) throws android.os.RemoteException {
            if (this.all) {
                iNotificationSideChannel.cancelAll(this.packageName);
            } else {
                iNotificationSideChannel.cancel(this.packageName, this.id, this.tag);
            }
        }

        public java.lang.String toString() {
            return "CancelTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + ", all:" + this.all + "]";
        }
    }

    private static class NotifyTask implements android.support.v4.app.NotificationManagerCompat.Task {
        final int id;
        final android.app.Notification notif;
        final java.lang.String packageName;
        final java.lang.String tag;

        NotifyTask(java.lang.String str, int i, java.lang.String str2, android.app.Notification notification) {
            this.packageName = str;
            this.id = i;
            this.tag = str2;
            this.notif = notification;
        }

        @Override // android.support.v4.app.NotificationManagerCompat.Task
        public void send(android.support.v4.app.INotificationSideChannel iNotificationSideChannel) throws android.os.RemoteException {
            iNotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
        }

        public java.lang.String toString() {
            return "NotifyTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + "]";
        }
    }

    private static class ServiceConnectedEvent {
        final android.content.ComponentName componentName;
        final android.os.IBinder iBinder;

        ServiceConnectedEvent(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            this.componentName = componentName;
            this.iBinder = iBinder;
        }
    }

    private static class SideChannelManager implements android.os.Handler.Callback, android.content.ServiceConnection {
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private final android.content.Context mContext;
        private final android.os.Handler mHandler;
        private final java.util.Map<android.content.ComponentName, android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord> mRecordMap = new java.util.HashMap();
        private java.util.Set<java.lang.String> mCachedEnabledPackages = new java.util.HashSet();
        private final android.os.HandlerThread mHandlerThread = new android.os.HandlerThread("NotificationManagerCompat");

        private static class ListenerRecord {
            public final android.content.ComponentName componentName;
            public android.support.v4.app.INotificationSideChannel service;
            public boolean bound = false;
            public java.util.LinkedList<android.support.v4.app.NotificationManagerCompat.Task> taskQueue = new java.util.LinkedList<>();
            public int retryCount = 0;

            public ListenerRecord(android.content.ComponentName componentName) {
                this.componentName = componentName;
            }
        }

        public SideChannelManager(android.content.Context context) {
            this.mContext = context;
            this.mHandlerThread.start();
            this.mHandler = new android.os.Handler(this.mHandlerThread.getLooper(), this);
        }

        private boolean ensureServiceBound(android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                return true;
            }
            listenerRecord.bound = this.mContext.bindService(new android.content.Intent(android.support.v4.app.NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(listenerRecord.componentName), this, 33);
            if (listenerRecord.bound) {
                listenerRecord.retryCount = 0;
            } else {
                android.util.Log.w(android.support.v4.app.NotificationManagerCompat.TAG, "Unable to bind to listener " + listenerRecord.componentName);
                this.mContext.unbindService(this);
            }
            return listenerRecord.bound;
        }

        private void ensureServiceUnbound(android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                this.mContext.unbindService(this);
                listenerRecord.bound = false;
            }
            listenerRecord.service = null;
        }

        private void handleQueueTask(android.support.v4.app.NotificationManagerCompat.Task task) {
            updateListenerMap();
            for (android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord : this.mRecordMap.values()) {
                listenerRecord.taskQueue.add(task);
                processListenerQueue(listenerRecord);
            }
        }

        private void handleRetryListenerQueue(android.content.ComponentName componentName) {
            android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord = this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord = this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.service = android.support.v4.app.INotificationSideChannel.Stub.asInterface(iBinder);
                listenerRecord.retryCount = 0;
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceDisconnected(android.content.ComponentName componentName) {
            android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord = this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                ensureServiceUnbound(listenerRecord);
            }
        }

        private void processListenerQueue(android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord) {
            if (android.util.Log.isLoggable(android.support.v4.app.NotificationManagerCompat.TAG, 3)) {
                android.util.Log.d(android.support.v4.app.NotificationManagerCompat.TAG, "Processing component " + listenerRecord.componentName + ", " + listenerRecord.taskQueue.size() + " queued tasks");
            }
            if (listenerRecord.taskQueue.isEmpty()) {
                return;
            }
            if (!ensureServiceBound(listenerRecord) || listenerRecord.service == null) {
                scheduleListenerRetry(listenerRecord);
                return;
            }
            while (true) {
                android.support.v4.app.NotificationManagerCompat.Task taskPeek = listenerRecord.taskQueue.peek();
                if (taskPeek == null) {
                    break;
                }
                try {
                    if (android.util.Log.isLoggable(android.support.v4.app.NotificationManagerCompat.TAG, 3)) {
                        android.util.Log.d(android.support.v4.app.NotificationManagerCompat.TAG, "Sending task " + taskPeek);
                    }
                    taskPeek.send(listenerRecord.service);
                    listenerRecord.taskQueue.remove();
                } catch (android.os.DeadObjectException unused) {
                    if (android.util.Log.isLoggable(android.support.v4.app.NotificationManagerCompat.TAG, 3)) {
                        android.util.Log.d(android.support.v4.app.NotificationManagerCompat.TAG, "Remote service has died: " + listenerRecord.componentName);
                    }
                } catch (android.os.RemoteException e) {
                    android.util.Log.w(android.support.v4.app.NotificationManagerCompat.TAG, "RemoteException communicating with " + listenerRecord.componentName, e);
                }
            }
            if (listenerRecord.taskQueue.isEmpty()) {
                return;
            }
            scheduleListenerRetry(listenerRecord);
        }

        private void scheduleListenerRetry(android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord) {
            if (this.mHandler.hasMessages(3, listenerRecord.componentName)) {
                return;
            }
            listenerRecord.retryCount++;
            if (listenerRecord.retryCount <= 6) {
                int i = (1 << (listenerRecord.retryCount - 1)) * 1000;
                if (android.util.Log.isLoggable(android.support.v4.app.NotificationManagerCompat.TAG, 3)) {
                    android.util.Log.d(android.support.v4.app.NotificationManagerCompat.TAG, "Scheduling retry for " + i + " ms");
                }
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, listenerRecord.componentName), i);
                return;
            }
            android.util.Log.w(android.support.v4.app.NotificationManagerCompat.TAG, "Giving up on delivering " + listenerRecord.taskQueue.size() + " tasks to " + listenerRecord.componentName + " after " + listenerRecord.retryCount + " retries");
            listenerRecord.taskQueue.clear();
        }

        private void updateListenerMap() {
            java.util.Set<java.lang.String> enabledListenerPackages = android.support.v4.app.NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (enabledListenerPackages.equals(this.mCachedEnabledPackages)) {
                return;
            }
            this.mCachedEnabledPackages = enabledListenerPackages;
            java.util.List<android.content.pm.ResolveInfo> listQueryIntentServices = this.mContext.getPackageManager().queryIntentServices(new android.content.Intent().setAction(android.support.v4.app.NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            java.util.HashSet<android.content.ComponentName> hashSet = new java.util.HashSet();
            for (android.content.pm.ResolveInfo resolveInfo : listQueryIntentServices) {
                if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    android.content.ComponentName componentName = new android.content.ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        android.util.Log.w(android.support.v4.app.NotificationManagerCompat.TAG, "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (android.content.ComponentName componentName2 : hashSet) {
                if (!this.mRecordMap.containsKey(componentName2)) {
                    if (android.util.Log.isLoggable(android.support.v4.app.NotificationManagerCompat.TAG, 3)) {
                        android.util.Log.d(android.support.v4.app.NotificationManagerCompat.TAG, "Adding listener record for " + componentName2);
                    }
                    this.mRecordMap.put(componentName2, new android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord(componentName2));
                }
            }
            java.util.Iterator<java.util.Map.Entry<android.content.ComponentName, android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord>> it = this.mRecordMap.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<android.content.ComponentName, android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (android.util.Log.isLoggable(android.support.v4.app.NotificationManagerCompat.TAG, 3)) {
                        android.util.Log.d(android.support.v4.app.NotificationManagerCompat.TAG, "Removing listener record for " + next.getKey());
                    }
                    ensureServiceUnbound(next.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            switch (message.what) {
                case 0:
                    handleQueueTask((android.support.v4.app.NotificationManagerCompat.Task) message.obj);
                    return true;
                case 1:
                    android.support.v4.app.NotificationManagerCompat.ServiceConnectedEvent serviceConnectedEvent = (android.support.v4.app.NotificationManagerCompat.ServiceConnectedEvent) message.obj;
                    handleServiceConnected(serviceConnectedEvent.componentName, serviceConnectedEvent.iBinder);
                    return true;
                case 2:
                    handleServiceDisconnected((android.content.ComponentName) message.obj);
                    return true;
                case 3:
                    handleRetryListenerQueue((android.content.ComponentName) message.obj);
                    return true;
                default:
                    return false;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            if (android.util.Log.isLoggable(android.support.v4.app.NotificationManagerCompat.TAG, 3)) {
                android.util.Log.d(android.support.v4.app.NotificationManagerCompat.TAG, "Connected to service " + componentName);
            }
            this.mHandler.obtainMessage(1, new android.support.v4.app.NotificationManagerCompat.ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            if (android.util.Log.isLoggable(android.support.v4.app.NotificationManagerCompat.TAG, 3)) {
                android.util.Log.d(android.support.v4.app.NotificationManagerCompat.TAG, "Disconnected from service " + componentName);
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        public void queueTask(android.support.v4.app.NotificationManagerCompat.Task task) {
            this.mHandler.obtainMessage(0, task).sendToTarget();
        }
    }

    private interface Task {
        void send(android.support.v4.app.INotificationSideChannel iNotificationSideChannel) throws android.os.RemoteException;
    }

    private NotificationManagerCompat(android.content.Context context) {
        this.mContext = context;
        this.mNotificationManager = (android.app.NotificationManager) this.mContext.getSystemService("notification");
    }

    public static android.support.v4.app.NotificationManagerCompat from(android.content.Context context) {
        return new android.support.v4.app.NotificationManagerCompat(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.util.Set<java.lang.String> getEnabledListenerPackages(android.content.Context context) {
        java.util.Set<java.lang.String> set;
        java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        synchronized (sEnabledNotificationListenersLock) {
            if (string != null) {
                if (!string.equals(sEnabledNotificationListeners)) {
                    java.lang.String[] strArrSplit = string.split(":");
                    java.util.HashSet hashSet = new java.util.HashSet(strArrSplit.length);
                    for (java.lang.String str : strArrSplit) {
                        android.content.ComponentName componentNameUnflattenFromString = android.content.ComponentName.unflattenFromString(str);
                        if (componentNameUnflattenFromString != null) {
                            hashSet.add(componentNameUnflattenFromString.getPackageName());
                        }
                    }
                    sEnabledNotificationListenerPackages = hashSet;
                    sEnabledNotificationListeners = string;
                }
                set = sEnabledNotificationListenerPackages;
            } else {
                set = sEnabledNotificationListenerPackages;
            }
            throw th;
        }
        return set;
    }

    private void pushSideChannelQueue(android.support.v4.app.NotificationManagerCompat.Task task) {
        synchronized (sLock) {
            if (sSideChannelManager == null) {
                sSideChannelManager = new android.support.v4.app.NotificationManagerCompat.SideChannelManager(this.mContext.getApplicationContext());
            }
            sSideChannelManager.queueTask(task);
        }
    }

    private static boolean useSideChannelForNotification(android.app.Notification notification) {
        android.os.Bundle extras = android.support.v4.app.NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    public boolean areNotificationsEnabled() {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return this.mNotificationManager.areNotificationsEnabled();
        }
        if (android.os.Build.VERSION.SDK_INT < 19) {
            return true;
        }
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) this.mContext.getSystemService("appops");
        android.content.pm.ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        java.lang.String packageName = this.mContext.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
            return ((java.lang.Integer) cls.getMethod(CHECK_OP_NO_THROW, java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.String.class).invoke(appOpsManager, java.lang.Integer.valueOf(((java.lang.Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(java.lang.Integer.class)).intValue()), java.lang.Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException | java.lang.NoSuchMethodException | java.lang.RuntimeException | java.lang.reflect.InvocationTargetException unused) {
            return true;
        }
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancel(java.lang.String str, int i) {
        this.mNotificationManager.cancel(str, i);
        if (android.os.Build.VERSION.SDK_INT <= 19) {
            pushSideChannelQueue(new android.support.v4.app.NotificationManagerCompat.CancelTask(this.mContext.getPackageName(), i, str));
        }
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
        if (android.os.Build.VERSION.SDK_INT <= 19) {
            pushSideChannelQueue(new android.support.v4.app.NotificationManagerCompat.CancelTask(this.mContext.getPackageName()));
        }
    }

    public int getImportance() {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return this.mNotificationManager.getImportance();
        }
        return -1000;
    }

    public void notify(int i, android.app.Notification notification) {
        notify(null, i, notification);
    }

    public void notify(java.lang.String str, int i, android.app.Notification notification) {
        if (!useSideChannelForNotification(notification)) {
            this.mNotificationManager.notify(str, i, notification);
        } else {
            pushSideChannelQueue(new android.support.v4.app.NotificationManagerCompat.NotifyTask(this.mContext.getPackageName(), i, str, notification));
            this.mNotificationManager.cancel(str, i);
        }
    }
}
