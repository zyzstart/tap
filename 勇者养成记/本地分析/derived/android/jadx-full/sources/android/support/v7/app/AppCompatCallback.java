package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface AppCompatCallback {
    void onSupportActionModeFinished(android.support.v7.view.ActionMode actionMode);

    void onSupportActionModeStarted(android.support.v7.view.ActionMode actionMode);

    @android.support.annotation.Nullable
    android.support.v7.view.ActionMode onWindowStartingSupportActionMode(android.support.v7.view.ActionMode.Callback callback);
}
