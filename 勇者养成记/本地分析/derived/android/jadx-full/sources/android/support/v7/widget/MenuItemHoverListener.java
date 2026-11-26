package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public interface MenuItemHoverListener {
    void onItemHoverEnter(@android.support.annotation.NonNull android.support.v7.view.menu.MenuBuilder menuBuilder, @android.support.annotation.NonNull android.view.MenuItem menuItem);

    void onItemHoverExit(@android.support.annotation.NonNull android.support.v7.view.menu.MenuBuilder menuBuilder, @android.support.annotation.NonNull android.view.MenuItem menuItem);
}
