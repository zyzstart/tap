package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        android.support.v4.content.Loader<D> onCreateLoader(int i, android.os.Bundle bundle);

        void onLoadFinished(android.support.v4.content.Loader<D> loader, D d);

        void onLoaderReset(android.support.v4.content.Loader<D> loader);
    }

    public static void enableDebugLogging(boolean z) {
        android.support.v4.app.LoaderManagerImpl.DEBUG = z;
    }

    public abstract void destroyLoader(int i);

    public abstract void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr);

    public abstract <D> android.support.v4.content.Loader<D> getLoader(int i);

    public boolean hasRunningLoaders() {
        return false;
    }

    public abstract <D> android.support.v4.content.Loader<D> initLoader(int i, android.os.Bundle bundle, android.support.v4.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks);

    public abstract <D> android.support.v4.content.Loader<D> restartLoader(int i, android.os.Bundle bundle, android.support.v4.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks);
}
