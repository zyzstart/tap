package android.support.v4.content;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final java.lang.String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static android.support.v4.content.ModernAsyncTask.InternalHandler sHandler;
    private static final java.util.concurrent.ThreadFactory sThreadFactory = new java.util.concurrent.ThreadFactory() { // from class: android.support.v4.content.ModernAsyncTask.1
        private final java.util.concurrent.atomic.AtomicInteger mCount = new java.util.concurrent.atomic.AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
        }
    };
    private static final java.util.concurrent.BlockingQueue<java.lang.Runnable> sPoolWorkQueue = new java.util.concurrent.LinkedBlockingQueue(10);
    public static final java.util.concurrent.Executor THREAD_POOL_EXECUTOR = new java.util.concurrent.ThreadPoolExecutor(5, 128, 1, java.util.concurrent.TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    private static volatile java.util.concurrent.Executor sDefaultExecutor = THREAD_POOL_EXECUTOR;
    private volatile android.support.v4.content.ModernAsyncTask.Status mStatus = android.support.v4.content.ModernAsyncTask.Status.PENDING;
    private final java.util.concurrent.atomic.AtomicBoolean mCancelled = new java.util.concurrent.atomic.AtomicBoolean();
    private final java.util.concurrent.atomic.AtomicBoolean mTaskInvoked = new java.util.concurrent.atomic.AtomicBoolean();
    private final android.support.v4.content.ModernAsyncTask.WorkerRunnable<Params, Result> mWorker = new android.support.v4.content.ModernAsyncTask.WorkerRunnable<Params, Result>() { // from class: android.support.v4.content.ModernAsyncTask.2
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.concurrent.Callable
        public Result call() throws java.lang.Exception {
            android.support.v4.content.ModernAsyncTask.this.mTaskInvoked.set(true);
            Result result = null;
            try {
                try {
                    android.os.Process.setThreadPriority(10);
                    result = (Result) android.support.v4.content.ModernAsyncTask.this.doInBackground(this.mParams);
                    android.os.Binder.flushPendingCommands();
                    android.support.v4.content.ModernAsyncTask.this.postResult(result);
                    return result;
                } catch (java.lang.Throwable th) {
                    android.support.v4.content.ModernAsyncTask.this.mCancelled.set(true);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                android.support.v4.content.ModernAsyncTask.this.postResult(result);
                throw th2;
            }
        }
    };
    private final java.util.concurrent.FutureTask<Result> mFuture = new java.util.concurrent.FutureTask<Result>(this.mWorker) { // from class: android.support.v4.content.ModernAsyncTask.3
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                android.support.v4.content.ModernAsyncTask.this.postResultIfNotInvoked(get());
            } catch (java.lang.InterruptedException e) {
                android.util.Log.w(android.support.v4.content.ModernAsyncTask.LOG_TAG, e);
            } catch (java.util.concurrent.CancellationException unused) {
                android.support.v4.content.ModernAsyncTask.this.postResultIfNotInvoked(null);
            } catch (java.util.concurrent.ExecutionException e2) {
                throw new java.lang.RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (java.lang.Throwable th) {
                throw new java.lang.RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    private static class AsyncTaskResult<Data> {
        final Data[] mData;
        final android.support.v4.content.ModernAsyncTask mTask;

        AsyncTaskResult(android.support.v4.content.ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.mTask = modernAsyncTask;
            this.mData = dataArr;
        }
    }

    private static class InternalHandler extends android.os.Handler {
        public InternalHandler() {
            super(android.os.Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            android.support.v4.content.ModernAsyncTask.AsyncTaskResult asyncTaskResult = (android.support.v4.content.ModernAsyncTask.AsyncTaskResult) message.obj;
            switch (message.what) {
                case 1:
                    asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
                    break;
                case 2:
                    asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
                    break;
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class WorkerRunnable<Params, Result> implements java.util.concurrent.Callable<Result> {
        Params[] mParams;

        WorkerRunnable() {
        }
    }

    public static void execute(java.lang.Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    private static android.os.Handler getHandler() {
        android.support.v4.content.ModernAsyncTask.InternalHandler internalHandler;
        synchronized (android.support.v4.content.ModernAsyncTask.class) {
            if (sHandler == null) {
                sHandler = new android.support.v4.content.ModernAsyncTask.InternalHandler();
            }
            internalHandler = sHandler;
        }
        return internalHandler;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDefaultExecutor(java.util.concurrent.Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    protected abstract Result doInBackground(Params... paramsArr);

    public final android.support.v4.content.ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final android.support.v4.content.ModernAsyncTask<Params, Progress, Result> executeOnExecutor(java.util.concurrent.Executor executor, Params... paramsArr) {
        if (this.mStatus != android.support.v4.content.ModernAsyncTask.Status.PENDING) {
            switch (this.mStatus) {
                case RUNNING:
                    throw new java.lang.IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new java.lang.IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                default:
                    throw new java.lang.IllegalStateException("We should never reach this state");
            }
        }
        this.mStatus = android.support.v4.content.ModernAsyncTask.Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = android.support.v4.content.ModernAsyncTask.Status.FINISHED;
    }

    public final Result get() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        return this.mFuture.get();
    }

    public final Result get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }

    public final android.support.v4.content.ModernAsyncTask.Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    protected void onCancelled() {
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    protected void onPostExecute(Result result) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Progress... progressArr) {
    }

    Result postResult(Result result) {
        getHandler().obtainMessage(1, new android.support.v4.content.ModernAsyncTask.AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    void postResultIfNotInvoked(Result result) {
        if (this.mTaskInvoked.get()) {
            return;
        }
        postResult(result);
    }

    protected final void publishProgress(Progress... progressArr) {
        if (isCancelled()) {
            return;
        }
        getHandler().obtainMessage(2, new android.support.v4.content.ModernAsyncTask.AsyncTaskResult(this, progressArr)).sendToTarget();
    }
}
