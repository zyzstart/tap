package android.support.v4.provider;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private final int mDestructAfterMillisec;

    @android.support.annotation.GuardedBy("mLock")
    private android.os.Handler mHandler;
    private final int mPriority;

    @android.support.annotation.GuardedBy("mLock")
    private android.os.HandlerThread mThread;
    private final java.lang.String mThreadName;
    private final java.lang.Object mLock = new java.lang.Object();
    private android.os.Handler.Callback mCallback = new android.os.Handler.Callback() { // from class: android.support.v4.provider.SelfDestructiveThread.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            switch (message.what) {
                case 0:
                    android.support.v4.provider.SelfDestructiveThread.this.onDestruction();
                    break;
                case 1:
                    android.support.v4.provider.SelfDestructiveThread.this.onInvokeRunnable((java.lang.Runnable) message.obj);
                    break;
            }
            return true;
        }
    };

    @android.support.annotation.GuardedBy("mLock")
    private int mGeneration = 0;

    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public SelfDestructiveThread(java.lang.String str, int i, int i2) {
        this.mThreadName = str;
        this.mPriority = i;
        this.mDestructAfterMillisec = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestruction() {
        synchronized (this.mLock) {
            if (this.mHandler.hasMessages(1)) {
                return;
            }
            this.mThread.quit();
            this.mThread = null;
            this.mHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInvokeRunnable(java.lang.Runnable runnable) {
        runnable.run();
        synchronized (this.mLock) {
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), this.mDestructAfterMillisec);
        }
    }

    private void post(java.lang.Runnable runnable) {
        synchronized (this.mLock) {
            if (this.mThread == null) {
                this.mThread = new android.os.HandlerThread(this.mThreadName, this.mPriority);
                this.mThread.start();
                this.mHandler = new android.os.Handler(this.mThread.getLooper(), this.mCallback);
                this.mGeneration++;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, runnable));
        }
    }

    @android.support.annotation.VisibleForTesting
    public int getGeneration() {
        int i;
        synchronized (this.mLock) {
            i = this.mGeneration;
        }
        return i;
    }

    @android.support.annotation.VisibleForTesting
    public boolean isRunning() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mThread != null;
        }
        return z;
    }

    public <T> void postAndReply(final java.util.concurrent.Callable<T> callable, final android.support.v4.provider.SelfDestructiveThread.ReplyCallback<T> replyCallback) {
        final android.os.Handler handler = new android.os.Handler();
        post(new java.lang.Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.2
            @Override // java.lang.Runnable
            public void run() {
                final java.lang.Object objCall;
                try {
                    objCall = callable.call();
                } catch (java.lang.Exception unused) {
                    objCall = null;
                }
                handler.post(new java.lang.Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        replyCallback.onReply(objCall);
                    }
                });
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> T postAndWait(final java.util.concurrent.Callable<T> callable, int i) throws java.lang.InterruptedException {
        final java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        final java.util.concurrent.locks.Condition conditionNewCondition = reentrantLock.newCondition();
        final java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(true);
        post(new java.lang.Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (java.lang.Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    conditionNewCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                T t = (T) atomicReference.get();
                reentrantLock.unlock();
                return t;
            }
            long nanos = java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (java.lang.InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    T t2 = (T) atomicReference.get();
                    reentrantLock.unlock();
                    return t2;
                }
            } while (nanos > 0);
            throw new java.lang.InterruptedException("timeout");
        } catch (java.lang.Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
