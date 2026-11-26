package android.support.v7.view.menu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public interface ShowableListMenu {
    void dismiss();

    android.widget.ListView getListView();

    boolean isShowing();

    void show();
}
