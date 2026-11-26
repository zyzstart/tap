package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class AsyncLayoutInflater {
    private static final java.lang.String TAG = "AsyncLayoutInflater";
    android.view.LayoutInflater mInflater;
    private android.os.Handler.Callback mHandlerCallback = new android.os.Handler.Callback() { // from class: android.support.v4.view.AsyncLayoutInflater.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            android.support.v4.view.AsyncLayoutInflater.InflateRequest inflateRequest = (android.support.v4.view.AsyncLayoutInflater.InflateRequest) message.obj;
            if (inflateRequest.view == null) {
                inflateRequest.view = android.support.v4.view.AsyncLayoutInflater.this.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
            }
            inflateRequest.callback.onInflateFinished(inflateRequest.view, inflateRequest.resid, inflateRequest.parent);
            android.support.v4.view.AsyncLayoutInflater.this.mInflateThread.releaseRequest(inflateRequest);
            return true;
        }
    };
    android.os.Handler mHandler = new android.os.Handler(this.mHandlerCallback);
    android.support.v4.view.AsyncLayoutInflater.InflateThread mInflateThread = android.support.v4.view.AsyncLayoutInflater.InflateThread.getInstance();

    private static class BasicInflater extends android.view.LayoutInflater {
        private static final java.lang.String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app."};

        BasicInflater(android.content.Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public android.view.LayoutInflater cloneInContext(android.content.Context context) {
            return new android.support.v4.view.AsyncLayoutInflater.BasicInflater(context);
        }

        @Override // android.view.LayoutInflater
        protected android.view.View onCreateView(java.lang.String str, android.util.AttributeSet attributeSet) throws java.lang.ClassNotFoundException {
            for (java.lang.String str2 : sClassPrefixList) {
                try {
                    android.view.View viewCreateView = createView(str, str2, attributeSet);
                    if (viewCreateView != null) {
                        return viewCreateView;
                    }
                } catch (java.lang.ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    private static class InflateRequest {
        android.support.v4.view.AsyncLayoutInflater.OnInflateFinishedListener callback;
        android.support.v4.view.AsyncLayoutInflater inflater;
        android.view.ViewGroup parent;
        int resid;
        android.view.View view;

        InflateRequest() {
        }
    }

    private static class InflateThread extends java.lang.Thread {
        private static final android.support.v4.view.AsyncLayoutInflater.InflateThread sInstance = new android.support.v4.view.AsyncLayoutInflater.InflateThread();
        private java.util.concurrent.ArrayBlockingQueue<android.support.v4.view.AsyncLayoutInflater.InflateRequest> mQueue = new java.util.concurrent.ArrayBlockingQueue<>(10);
        private android.support.v4.util.Pools.SynchronizedPool<android.support.v4.view.AsyncLayoutInflater.InflateRequest> mRequestPool = new android.support.v4.util.Pools.SynchronizedPool<>(10);

        static {
            sInstance.start();
        }

        private InflateThread() {
        }

        public static android.support.v4.view.AsyncLayoutInflater.InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(android.support.v4.view.AsyncLayoutInflater.InflateRequest inflateRequest) {
            try {
                this.mQueue.put(inflateRequest);
            } catch (java.lang.InterruptedException e) {
                throw new java.lang.RuntimeException("Failed to enqueue async inflate request", e);
            }
        }

        public android.support.v4.view.AsyncLayoutInflater.InflateRequest obtainRequest() {
            android.support.v4.view.AsyncLayoutInflater.InflateRequest inflateRequestAcquire = this.mRequestPool.acquire();
            return inflateRequestAcquire == null ? new android.support.v4.view.AsyncLayoutInflater.InflateRequest() : inflateRequestAcquire;
        }

        public void releaseRequest(android.support.v4.view.AsyncLayoutInflater.InflateRequest inflateRequest) {
            inflateRequest.callback = null;
            inflateRequest.inflater = null;
            inflateRequest.parent = null;
            inflateRequest.resid = 0;
            inflateRequest.view = null;
            this.mRequestPool.release(inflateRequest);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                android.support.v4.view.AsyncLayoutInflater.InflateRequest inflateRequestTake = this.mQueue.take();
                try {
                    inflateRequestTake.view = inflateRequestTake.inflater.mInflater.inflate(inflateRequestTake.resid, inflateRequestTake.parent, false);
                } catch (java.lang.RuntimeException e) {
                    android.util.Log.w(android.support.v4.view.AsyncLayoutInflater.TAG, "Failed to inflate resource in the background! Retrying on the UI thread", e);
                }
                android.os.Message.obtain(inflateRequestTake.inflater.mHandler, 0, inflateRequestTake).sendToTarget();
            } catch (java.lang.InterruptedException e2) {
                android.util.Log.w(android.support.v4.view.AsyncLayoutInflater.TAG, e2);
            }
        }
    }

    public interface OnInflateFinishedListener {
        void onInflateFinished(android.view.View view, int i, android.view.ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(@android.support.annotation.NonNull android.content.Context context) {
        this.mInflater = new android.support.v4.view.AsyncLayoutInflater.BasicInflater(context);
    }

    @android.support.annotation.UiThread
    public void inflate(@android.support.annotation.LayoutRes int i, @android.support.annotation.Nullable android.view.ViewGroup viewGroup, @android.support.annotation.NonNull android.support.v4.view.AsyncLayoutInflater.OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener == null) {
            throw new java.lang.NullPointerException("callback argument may not be null!");
        }
        android.support.v4.view.AsyncLayoutInflater.InflateRequest inflateRequestObtainRequest = this.mInflateThread.obtainRequest();
        inflateRequestObtainRequest.inflater = this;
        inflateRequestObtainRequest.resid = i;
        inflateRequestObtainRequest.parent = viewGroup;
        inflateRequestObtainRequest.callback = onInflateFinishedListener;
        this.mInflateThread.enqueue(inflateRequestObtainRequest);
    }
}
