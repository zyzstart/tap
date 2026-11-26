package android.support.v4.content;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public final class ParallelExecutorCompat {
    private ParallelExecutorCompat() {
    }

    @java.lang.Deprecated
    public static java.util.concurrent.Executor getParallelExecutor() {
        return android.os.AsyncTask.THREAD_POOL_EXECUTOR;
    }
}
