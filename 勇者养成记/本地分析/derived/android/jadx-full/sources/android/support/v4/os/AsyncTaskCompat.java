package android.support.v4.os;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public final class AsyncTaskCompat {
    private AsyncTaskCompat() {
    }

    @java.lang.Deprecated
    public static <Params, Progress, Result> android.os.AsyncTask<Params, Progress, Result> executeParallel(android.os.AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new java.lang.IllegalArgumentException("task can not be null");
        }
        asyncTask.executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
        return asyncTask;
    }
}
