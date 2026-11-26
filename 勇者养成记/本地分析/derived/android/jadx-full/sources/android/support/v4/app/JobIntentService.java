package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class JobIntentService extends android.app.Service {
    static final boolean DEBUG = false;
    static final java.lang.String TAG = "JobIntentService";
    final java.util.ArrayList<android.support.v4.app.JobIntentService.CompatWorkItem> mCompatQueue;
    android.support.v4.app.JobIntentService.WorkEnqueuer mCompatWorkEnqueuer;
    android.support.v4.app.JobIntentService.CommandProcessor mCurProcessor;
    android.support.v4.app.JobIntentService.CompatJobEngine mJobImpl;
    static final java.lang.Object sLock = new java.lang.Object();
    static final java.util.HashMap<android.content.ComponentName, android.support.v4.app.JobIntentService.WorkEnqueuer> sClassWorkEnqueuer = new java.util.HashMap<>();
    boolean mInterruptIfStopped = false;
    boolean mStopped = false;
    boolean mDestroyed = false;

    final class CommandProcessor extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {
        CommandProcessor() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public java.lang.Void doInBackground(java.lang.Void... voidArr) {
            while (true) {
                android.support.v4.app.JobIntentService.GenericWorkItem genericWorkItemDequeueWork = android.support.v4.app.JobIntentService.this.dequeueWork();
                if (genericWorkItemDequeueWork == null) {
                    return null;
                }
                android.support.v4.app.JobIntentService.this.onHandleWork(genericWorkItemDequeueWork.getIntent());
                genericWorkItemDequeueWork.complete();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled(java.lang.Void r1) {
            android.support.v4.app.JobIntentService.this.processorFinished();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.Void r1) {
            android.support.v4.app.JobIntentService.this.processorFinished();
        }
    }

    interface CompatJobEngine {
        android.os.IBinder compatGetBinder();

        android.support.v4.app.JobIntentService.GenericWorkItem dequeueWork();
    }

    static final class CompatWorkEnqueuer extends android.support.v4.app.JobIntentService.WorkEnqueuer {
        private final android.content.Context mContext;
        private final android.os.PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final android.os.PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        CompatWorkEnqueuer(android.content.Context context, android.content.ComponentName componentName) {
            super(context, componentName);
            this.mContext = context.getApplicationContext();
            android.os.PowerManager powerManager = (android.os.PowerManager) context.getSystemService("power");
            this.mLaunchWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.mLaunchWakeLock.setReferenceCounted(false);
            this.mRunWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.mRunWakeLock.setReferenceCounted(false);
        }

        @Override // android.support.v4.app.JobIntentService.WorkEnqueuer
        void enqueueWork(android.content.Intent intent) {
            android.content.Intent intent2 = new android.content.Intent(intent);
            intent2.setComponent(this.mComponentName);
            if (this.mContext.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.mLaunchingService) {
                        this.mLaunchingService = true;
                        if (!this.mServiceProcessing) {
                            this.mLaunchWakeLock.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // android.support.v4.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            synchronized (this) {
                if (this.mServiceProcessing) {
                    if (this.mLaunchingService) {
                        this.mLaunchWakeLock.acquire(60000L);
                    }
                    this.mServiceProcessing = false;
                    this.mRunWakeLock.release();
                }
            }
        }

        @Override // android.support.v4.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            synchronized (this) {
                if (!this.mServiceProcessing) {
                    this.mServiceProcessing = true;
                    this.mRunWakeLock.acquire(600000L);
                    this.mLaunchWakeLock.release();
                }
            }
        }

        @Override // android.support.v4.app.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            synchronized (this) {
                this.mLaunchingService = false;
            }
        }
    }

    final class CompatWorkItem implements android.support.v4.app.JobIntentService.GenericWorkItem {
        final android.content.Intent mIntent;
        final int mStartId;

        CompatWorkItem(android.content.Intent intent, int i) {
            this.mIntent = intent;
            this.mStartId = i;
        }

        @Override // android.support.v4.app.JobIntentService.GenericWorkItem
        public void complete() {
            android.support.v4.app.JobIntentService.this.stopSelf(this.mStartId);
        }

        @Override // android.support.v4.app.JobIntentService.GenericWorkItem
        public android.content.Intent getIntent() {
            return this.mIntent;
        }
    }

    interface GenericWorkItem {
        void complete();

        android.content.Intent getIntent();
    }

    @android.support.annotation.RequiresApi(26)
    static final class JobServiceEngineImpl extends android.app.job.JobServiceEngine implements android.support.v4.app.JobIntentService.CompatJobEngine {
        static final boolean DEBUG = false;
        static final java.lang.String TAG = "JobServiceEngineImpl";
        final java.lang.Object mLock;
        android.app.job.JobParameters mParams;
        final android.support.v4.app.JobIntentService mService;

        final class WrapperWorkItem implements android.support.v4.app.JobIntentService.GenericWorkItem {
            final android.app.job.JobWorkItem mJobWork;

            WrapperWorkItem(android.app.job.JobWorkItem jobWorkItem) {
                this.mJobWork = jobWorkItem;
            }

            @Override // android.support.v4.app.JobIntentService.GenericWorkItem
            public void complete() {
                synchronized (android.support.v4.app.JobIntentService.JobServiceEngineImpl.this.mLock) {
                    if (android.support.v4.app.JobIntentService.JobServiceEngineImpl.this.mParams != null) {
                        android.support.v4.app.JobIntentService.JobServiceEngineImpl.this.mParams.completeWork(this.mJobWork);
                    }
                }
            }

            @Override // android.support.v4.app.JobIntentService.GenericWorkItem
            public android.content.Intent getIntent() {
                return this.mJobWork.getIntent();
            }
        }

        JobServiceEngineImpl(android.support.v4.app.JobIntentService jobIntentService) {
            super(jobIntentService);
            this.mLock = new java.lang.Object();
            this.mService = jobIntentService;
        }

        @Override // android.support.v4.app.JobIntentService.CompatJobEngine
        public android.os.IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // android.support.v4.app.JobIntentService.CompatJobEngine
        public android.support.v4.app.JobIntentService.GenericWorkItem dequeueWork() {
            synchronized (this.mLock) {
                if (this.mParams == null) {
                    return null;
                }
                android.app.job.JobWorkItem jobWorkItemDequeueWork = this.mParams.dequeueWork();
                if (jobWorkItemDequeueWork == null) {
                    return null;
                }
                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
                return new android.support.v4.app.JobIntentService.JobServiceEngineImpl.WrapperWorkItem(jobWorkItemDequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(android.app.job.JobParameters jobParameters) {
            this.mParams = jobParameters;
            this.mService.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(android.app.job.JobParameters jobParameters) {
            boolean zDoStopCurrentWork = this.mService.doStopCurrentWork();
            synchronized (this.mLock) {
                this.mParams = null;
            }
            return zDoStopCurrentWork;
        }
    }

    @android.support.annotation.RequiresApi(26)
    static final class JobWorkEnqueuer extends android.support.v4.app.JobIntentService.WorkEnqueuer {
        private final android.app.job.JobInfo mJobInfo;
        private final android.app.job.JobScheduler mJobScheduler;

        JobWorkEnqueuer(android.content.Context context, android.content.ComponentName componentName, int i) {
            super(context, componentName);
            ensureJobId(i);
            this.mJobInfo = new android.app.job.JobInfo.Builder(i, this.mComponentName).setOverrideDeadline(0L).build();
            this.mJobScheduler = (android.app.job.JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // android.support.v4.app.JobIntentService.WorkEnqueuer
        void enqueueWork(android.content.Intent intent) {
            this.mJobScheduler.enqueue(this.mJobInfo, new android.app.job.JobWorkItem(intent));
        }
    }

    static abstract class WorkEnqueuer {
        final android.content.ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        WorkEnqueuer(android.content.Context context, android.content.ComponentName componentName) {
            this.mComponentName = componentName;
        }

        abstract void enqueueWork(android.content.Intent intent);

        void ensureJobId(int i) {
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = i;
            } else {
                if (this.mJobId == i) {
                    return;
                }
                throw new java.lang.IllegalArgumentException("Given job ID " + i + " is different than previous " + this.mJobId);
            }
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    public JobIntentService() {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new java.util.ArrayList<>();
        }
    }

    public static void enqueueWork(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.content.ComponentName componentName, int i, @android.support.annotation.NonNull android.content.Intent intent) {
        if (intent == null) {
            throw new java.lang.IllegalArgumentException("work must not be null");
        }
        synchronized (sLock) {
            android.support.v4.app.JobIntentService.WorkEnqueuer workEnqueuer = getWorkEnqueuer(context, componentName, true, i);
            workEnqueuer.ensureJobId(i);
            workEnqueuer.enqueueWork(intent);
        }
    }

    public static void enqueueWork(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.Class cls, int i, @android.support.annotation.NonNull android.content.Intent intent) {
        enqueueWork(context, new android.content.ComponentName(context, (java.lang.Class<?>) cls), i, intent);
    }

    static android.support.v4.app.JobIntentService.WorkEnqueuer getWorkEnqueuer(android.content.Context context, android.content.ComponentName componentName, boolean z, int i) {
        android.support.v4.app.JobIntentService.WorkEnqueuer compatWorkEnqueuer = sClassWorkEnqueuer.get(componentName);
        if (compatWorkEnqueuer == null) {
            if (android.os.Build.VERSION.SDK_INT < 26) {
                compatWorkEnqueuer = new android.support.v4.app.JobIntentService.CompatWorkEnqueuer(context, componentName);
            } else {
                if (!z) {
                    throw new java.lang.IllegalArgumentException("Can't be here without a job id");
                }
                compatWorkEnqueuer = new android.support.v4.app.JobIntentService.JobWorkEnqueuer(context, componentName, i);
            }
            sClassWorkEnqueuer.put(componentName, compatWorkEnqueuer);
        }
        return compatWorkEnqueuer;
    }

    android.support.v4.app.JobIntentService.GenericWorkItem dequeueWork() {
        android.support.v4.app.JobIntentService.CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null) {
            return compatJobEngine.dequeueWork();
        }
        synchronized (this.mCompatQueue) {
            if (this.mCompatQueue.size() <= 0) {
                return null;
            }
            return this.mCompatQueue.remove(0);
        }
    }

    boolean doStopCurrentWork() {
        android.support.v4.app.JobIntentService.CommandProcessor commandProcessor = this.mCurProcessor;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.mInterruptIfStopped);
        }
        this.mStopped = true;
        return onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean z) {
        if (this.mCurProcessor == null) {
            this.mCurProcessor = new android.support.v4.app.JobIntentService.CommandProcessor();
            android.support.v4.app.JobIntentService.WorkEnqueuer workEnqueuer = this.mCompatWorkEnqueuer;
            if (workEnqueuer != null && z) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.mCurProcessor.executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
        }
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(@android.support.annotation.NonNull android.content.Intent intent) {
        android.support.v4.app.JobIntentService.CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mJobImpl = new android.support.v4.app.JobIntentService.JobServiceEngineImpl(this);
            this.mCompatWorkEnqueuer = null;
        } else {
            this.mJobImpl = null;
            this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new android.content.ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        java.util.ArrayList<android.support.v4.app.JobIntentService.CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mDestroyed = true;
                this.mCompatWorkEnqueuer.serviceProcessingFinished();
            }
        }
    }

    protected abstract void onHandleWork(@android.support.annotation.NonNull android.content.Intent intent);

    @Override // android.app.Service
    public int onStartCommand(@android.support.annotation.Nullable android.content.Intent intent, int i, int i2) {
        if (this.mCompatQueue == null) {
            return 2;
        }
        this.mCompatWorkEnqueuer.serviceStartReceived();
        synchronized (this.mCompatQueue) {
            java.util.ArrayList<android.support.v4.app.JobIntentService.CompatWorkItem> arrayList = this.mCompatQueue;
            if (intent == null) {
                intent = new android.content.Intent();
            }
            arrayList.add(new android.support.v4.app.JobIntentService.CompatWorkItem(intent, i2));
            ensureProcessorRunningLocked(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    void processorFinished() {
        java.util.ArrayList<android.support.v4.app.JobIntentService.CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mCurProcessor = null;
                if (this.mCompatQueue != null && this.mCompatQueue.size() > 0) {
                    ensureProcessorRunningLocked(false);
                } else if (!this.mDestroyed) {
                    this.mCompatWorkEnqueuer.serviceProcessingFinished();
                }
            }
        }
    }

    public void setInterruptIfStopped(boolean z) {
        this.mInterruptIfStopped = z;
    }
}
