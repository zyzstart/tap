package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class FragmentContainer {
    public android.support.v4.app.Fragment instantiate(android.content.Context context, java.lang.String str, android.os.Bundle bundle) {
        return android.support.v4.app.Fragment.instantiate(context, str, bundle);
    }

    @android.support.annotation.Nullable
    public abstract android.view.View onFindViewById(@android.support.annotation.IdRes int i);

    public abstract boolean onHasView();
}
