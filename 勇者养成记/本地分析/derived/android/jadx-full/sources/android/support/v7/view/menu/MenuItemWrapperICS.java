package android.support.v7.view.menu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(14)
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MenuItemWrapperICS extends android.support.v7.view.menu.BaseMenuWrapper<android.support.v4.internal.view.SupportMenuItem> implements android.view.MenuItem {
    static final java.lang.String LOG_TAG = "MenuItemWrapper";
    private java.lang.reflect.Method mSetExclusiveCheckableMethod;

    class ActionProviderWrapper extends android.support.v4.view.ActionProvider {
        final android.view.ActionProvider mInner;

        public ActionProviderWrapper(android.content.Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.mInner = actionProvider;
        }

        @Override // android.support.v4.view.ActionProvider
        public boolean hasSubMenu() {
            return this.mInner.hasSubMenu();
        }

        @Override // android.support.v4.view.ActionProvider
        public android.view.View onCreateActionView() {
            return this.mInner.onCreateActionView();
        }

        @Override // android.support.v4.view.ActionProvider
        public boolean onPerformDefaultAction() {
            return this.mInner.onPerformDefaultAction();
        }

        @Override // android.support.v4.view.ActionProvider
        public void onPrepareSubMenu(android.view.SubMenu subMenu) {
            this.mInner.onPrepareSubMenu(android.support.v7.view.menu.MenuItemWrapperICS.this.getSubMenuWrapper(subMenu));
        }
    }

    static class CollapsibleActionViewWrapper extends android.widget.FrameLayout implements android.support.v7.view.CollapsibleActionView {
        final android.view.CollapsibleActionView mWrappedView;

        /* JADX WARN: Multi-variable type inference failed */
        CollapsibleActionViewWrapper(android.view.View view) {
            super(view.getContext());
            this.mWrappedView = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        android.view.View getWrappedView() {
            return (android.view.View) this.mWrappedView;
        }

        @Override // android.support.v7.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            this.mWrappedView.onActionViewCollapsed();
        }

        @Override // android.support.v7.view.CollapsibleActionView
        public void onActionViewExpanded() {
            this.mWrappedView.onActionViewExpanded();
        }
    }

    private class OnActionExpandListenerWrapper extends android.support.v7.view.menu.BaseWrapper<android.view.MenuItem.OnActionExpandListener> implements android.view.MenuItem.OnActionExpandListener {
        OnActionExpandListenerWrapper(android.view.MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(android.view.MenuItem menuItem) {
            return ((android.view.MenuItem.OnActionExpandListener) this.mWrappedObject).onMenuItemActionCollapse(android.support.v7.view.menu.MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(android.view.MenuItem menuItem) {
            return ((android.view.MenuItem.OnActionExpandListener) this.mWrappedObject).onMenuItemActionExpand(android.support.v7.view.menu.MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }
    }

    private class OnMenuItemClickListenerWrapper extends android.support.v7.view.menu.BaseWrapper<android.view.MenuItem.OnMenuItemClickListener> implements android.view.MenuItem.OnMenuItemClickListener {
        OnMenuItemClickListenerWrapper(android.view.MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(android.view.MenuItem menuItem) {
            return ((android.view.MenuItem.OnMenuItemClickListener) this.mWrappedObject).onMenuItemClick(android.support.v7.view.menu.MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }
    }

    MenuItemWrapperICS(android.content.Context context, android.support.v4.internal.view.SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).collapseActionView();
    }

    android.support.v7.view.menu.MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(android.view.ActionProvider actionProvider) {
        return new android.support.v7.view.menu.MenuItemWrapperICS.ActionProviderWrapper(this.mContext, actionProvider);
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).expandActionView();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        android.support.v4.view.ActionProvider supportActionProvider = ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getSupportActionProvider();
        if (supportActionProvider instanceof android.support.v7.view.menu.MenuItemWrapperICS.ActionProviderWrapper) {
            return ((android.support.v7.view.menu.MenuItemWrapperICS.ActionProviderWrapper) supportActionProvider).mInner;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public android.view.View getActionView() {
        android.view.View actionView = ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getActionView();
        return actionView instanceof android.support.v7.view.menu.MenuItemWrapperICS.CollapsibleActionViewWrapper ? ((android.support.v7.view.menu.MenuItemWrapperICS.CollapsibleActionViewWrapper) actionView).getWrappedView() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getContentDescription() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getGroupId();
    }

    @Override // android.view.MenuItem
    public android.graphics.drawable.Drawable getIcon() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getIcon();
    }

    @Override // android.view.MenuItem
    public android.content.res.ColorStateList getIconTintList() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getIconTintList();
    }

    @Override // android.view.MenuItem
    public android.graphics.PorterDuff.Mode getIconTintMode() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getIconTintMode();
    }

    @Override // android.view.MenuItem
    public android.content.Intent getIntent() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getItemId();
    }

    @Override // android.view.MenuItem
    public android.view.ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getOrder();
    }

    @Override // android.view.MenuItem
    public android.view.SubMenu getSubMenu() {
        return getSubMenuWrapper(((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getSubMenu());
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTitle() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getTitle();
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTitleCondensed() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTooltipText() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).isVisible();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setSupportActionProvider(actionProvider != null ? createActionProviderWrapper(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionView(int i) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setActionView(i);
        android.view.View actionView = ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setActionView(new android.support.v7.view.menu.MenuItemWrapperICS.CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionView(android.view.View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new android.support.v7.view.menu.MenuItemWrapperICS.CollapsibleActionViewWrapper(view);
        }
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setAlphabeticShortcut(char c) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setAlphabeticShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setAlphabeticShortcut(char c, int i) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setAlphabeticShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setCheckable(boolean z) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setChecked(boolean z) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setContentDescription(java.lang.CharSequence charSequence) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setEnabled(boolean z) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setEnabled(z);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        try {
            if (this.mSetExclusiveCheckableMethod == null) {
                this.mSetExclusiveCheckableMethod = ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", java.lang.Boolean.TYPE);
            }
            this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, java.lang.Boolean.valueOf(z));
        } catch (java.lang.Exception e) {
            android.util.Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e);
        }
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIcon(int i) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIcon(android.graphics.drawable.Drawable drawable) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIconTintList(android.content.res.ColorStateList colorStateList) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIconTintMode(android.graphics.PorterDuff.Mode mode) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIntent(android.content.Intent intent) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setNumericShortcut(char c) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setNumericShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setNumericShortcut(char c, int i) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setNumericShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onActionExpandListener) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setOnActionExpandListener(onActionExpandListener != null ? new android.support.v7.view.menu.MenuItemWrapperICS.OnActionExpandListenerWrapper(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setOnMenuItemClickListener(onMenuItemClickListener != null ? new android.support.v7.view.menu.MenuItemWrapperICS.OnMenuItemClickListenerWrapper(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setShortcut(char c, char c2) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setShortcut(c, c2);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setShortcut(char c, char c2, int i, int i2) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setShortcut(c, c2, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setShowAsActionFlags(int i) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitle(int i) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitle(java.lang.CharSequence charSequence) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitleCondensed(java.lang.CharSequence charSequence) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTooltipText(java.lang.CharSequence charSequence) {
        ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setVisible(boolean z) {
        return ((android.support.v4.internal.view.SupportMenuItem) this.mWrappedObject).setVisible(z);
    }
}
