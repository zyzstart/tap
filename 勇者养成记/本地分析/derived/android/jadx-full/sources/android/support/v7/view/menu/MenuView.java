package android.support.v7.view.menu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public interface MenuView {

    public interface ItemView {
        android.support.v7.view.menu.MenuItemImpl getItemData();

        void initialize(android.support.v7.view.menu.MenuItemImpl menuItemImpl, int i);

        boolean prefersCondensedTitle();

        void setCheckable(boolean z);

        void setChecked(boolean z);

        void setEnabled(boolean z);

        void setIcon(android.graphics.drawable.Drawable drawable);

        void setShortcut(boolean z, char c);

        void setTitle(java.lang.CharSequence charSequence);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(android.support.v7.view.menu.MenuBuilder menuBuilder);
}
