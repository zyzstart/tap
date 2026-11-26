package android.support.v7.view.menu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
abstract class BaseMenuWrapper<T> extends android.support.v7.view.menu.BaseWrapper<T> {
    final android.content.Context mContext;
    private java.util.Map<android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem> mMenuItems;
    private java.util.Map<android.support.v4.internal.view.SupportSubMenu, android.view.SubMenu> mSubMenus;

    BaseMenuWrapper(android.content.Context context, T t) {
        super(t);
        this.mContext = context;
    }

    final android.view.MenuItem getMenuItemWrapper(android.view.MenuItem menuItem) {
        if (!(menuItem instanceof android.support.v4.internal.view.SupportMenuItem)) {
            return menuItem;
        }
        android.support.v4.internal.view.SupportMenuItem supportMenuItem = (android.support.v4.internal.view.SupportMenuItem) menuItem;
        if (this.mMenuItems == null) {
            this.mMenuItems = new android.support.v4.util.ArrayMap();
        }
        android.view.MenuItem menuItem2 = this.mMenuItems.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        android.view.MenuItem menuItemWrapSupportMenuItem = android.support.v7.view.menu.MenuWrapperFactory.wrapSupportMenuItem(this.mContext, supportMenuItem);
        this.mMenuItems.put(supportMenuItem, menuItemWrapSupportMenuItem);
        return menuItemWrapSupportMenuItem;
    }

    final android.view.SubMenu getSubMenuWrapper(android.view.SubMenu subMenu) {
        if (!(subMenu instanceof android.support.v4.internal.view.SupportSubMenu)) {
            return subMenu;
        }
        android.support.v4.internal.view.SupportSubMenu supportSubMenu = (android.support.v4.internal.view.SupportSubMenu) subMenu;
        if (this.mSubMenus == null) {
            this.mSubMenus = new android.support.v4.util.ArrayMap();
        }
        android.view.SubMenu subMenu2 = this.mSubMenus.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        android.view.SubMenu subMenuWrapSupportSubMenu = android.support.v7.view.menu.MenuWrapperFactory.wrapSupportSubMenu(this.mContext, supportSubMenu);
        this.mSubMenus.put(supportSubMenu, subMenuWrapSupportSubMenu);
        return subMenuWrapSupportSubMenu;
    }

    final void internalClear() {
        java.util.Map<android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem> map = this.mMenuItems;
        if (map != null) {
            map.clear();
        }
        java.util.Map<android.support.v4.internal.view.SupportSubMenu, android.view.SubMenu> map2 = this.mSubMenus;
        if (map2 != null) {
            map2.clear();
        }
    }

    final void internalRemoveGroup(int i) {
        java.util.Map<android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem> map = this.mMenuItems;
        if (map == null) {
            return;
        }
        java.util.Iterator<android.support.v4.internal.view.SupportMenuItem> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    final void internalRemoveItem(int i) {
        java.util.Map<android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem> map = this.mMenuItems;
        if (map == null) {
            return;
        }
        java.util.Iterator<android.support.v4.internal.view.SupportMenuItem> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
