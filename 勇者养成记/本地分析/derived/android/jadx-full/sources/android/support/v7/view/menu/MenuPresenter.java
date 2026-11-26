package android.support.v7.view.menu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public interface MenuPresenter {

    public interface Callback {
        void onCloseMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z);

        boolean onOpenSubMenu(android.support.v7.view.menu.MenuBuilder menuBuilder);
    }

    boolean collapseItemActionView(android.support.v7.view.menu.MenuBuilder menuBuilder, android.support.v7.view.menu.MenuItemImpl menuItemImpl);

    boolean expandItemActionView(android.support.v7.view.menu.MenuBuilder menuBuilder, android.support.v7.view.menu.MenuItemImpl menuItemImpl);

    boolean flagActionItems();

    int getId();

    android.support.v7.view.menu.MenuView getMenuView(android.view.ViewGroup viewGroup);

    void initForMenu(android.content.Context context, android.support.v7.view.menu.MenuBuilder menuBuilder);

    void onCloseMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z);

    void onRestoreInstanceState(android.os.Parcelable parcelable);

    android.os.Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(android.support.v7.view.menu.SubMenuBuilder subMenuBuilder);

    void setCallback(android.support.v7.view.menu.MenuPresenter.Callback callback);

    void updateMenuView(boolean z);
}
