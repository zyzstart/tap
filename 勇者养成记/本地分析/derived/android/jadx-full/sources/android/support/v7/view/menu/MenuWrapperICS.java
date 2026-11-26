package android.support.v7.view.menu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(14)
class MenuWrapperICS extends android.support.v7.view.menu.BaseMenuWrapper<android.support.v4.internal.view.SupportMenu> implements android.view.Menu {
    MenuWrapperICS(android.content.Context context, android.support.v4.internal.view.SupportMenu supportMenu) {
        super(context, supportMenu);
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(int i) {
        return getMenuItemWrapper(((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).add(i));
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(int i, int i2, int i3, int i4) {
        return getMenuItemWrapper(((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(int i, int i2, int i3, java.lang.CharSequence charSequence) {
        return getMenuItemWrapper(((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(java.lang.CharSequence charSequence) {
        return getMenuItemWrapper(((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, android.content.ComponentName componentName, android.content.Intent[] intentArr, android.content.Intent intent, int i4, android.view.MenuItem[] menuItemArr) {
        android.view.MenuItem[] menuItemArr2 = menuItemArr != null ? new android.view.MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = getMenuItemWrapper(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(int i) {
        return getSubMenuWrapper(((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).addSubMenu(i));
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return getSubMenuWrapper(((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).addSubMenu(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(int i, int i2, int i3, java.lang.CharSequence charSequence) {
        return getSubMenuWrapper(((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(java.lang.CharSequence charSequence) {
        return getSubMenuWrapper(((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        internalClear();
        ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).clear();
    }

    @Override // android.view.Menu
    public void close() {
        ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).close();
    }

    @Override // android.view.Menu
    public android.view.MenuItem findItem(int i) {
        return getMenuItemWrapper(((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).findItem(i));
    }

    @Override // android.view.Menu
    public android.view.MenuItem getItem(int i) {
        return getMenuItemWrapper(((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, android.view.KeyEvent keyEvent) {
        return ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, android.view.KeyEvent keyEvent, int i2) {
        return ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        internalRemoveGroup(i);
        ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        internalRemoveItem(i);
        ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return ((android.support.v4.internal.view.SupportMenu) this.mWrappedObject).size();
    }
}
