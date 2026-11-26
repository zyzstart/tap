package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class MenuItemCompat {
    static final android.support.v4.view.MenuItemCompat.MenuVersionImpl IMPL;

    @java.lang.Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    @java.lang.Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    @java.lang.Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;

    @java.lang.Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;

    @java.lang.Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final java.lang.String TAG = "MenuItemCompat";

    @android.support.annotation.RequiresApi(26)
    static class MenuItemCompatApi26Impl extends android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl {
        MenuItemCompatApi26Impl() {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public int getAlphabeticModifiers(android.view.MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public java.lang.CharSequence getContentDescription(android.view.MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public android.content.res.ColorStateList getIconTintList(android.view.MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public android.graphics.PorterDuff.Mode getIconTintMode(android.view.MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public int getNumericModifiers(android.view.MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public java.lang.CharSequence getTooltipText(android.view.MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setAlphabeticShortcut(android.view.MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setContentDescription(android.view.MenuItem menuItem, java.lang.CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintList(android.view.MenuItem menuItem, android.content.res.ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintMode(android.view.MenuItem menuItem, android.graphics.PorterDuff.Mode mode) {
            menuItem.setIconTintMode(mode);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setNumericShortcut(android.view.MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setShortcut(android.view.MenuItem menuItem, char c, char c2, int i, int i2) {
            menuItem.setShortcut(c, c2, i, i2);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setTooltipText(android.view.MenuItem menuItem, java.lang.CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }
    }

    static class MenuItemCompatBaseImpl implements android.support.v4.view.MenuItemCompat.MenuVersionImpl {
        MenuItemCompatBaseImpl() {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public int getAlphabeticModifiers(android.view.MenuItem menuItem) {
            return 0;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public java.lang.CharSequence getContentDescription(android.view.MenuItem menuItem) {
            return null;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public android.content.res.ColorStateList getIconTintList(android.view.MenuItem menuItem) {
            return null;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public android.graphics.PorterDuff.Mode getIconTintMode(android.view.MenuItem menuItem) {
            return null;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public int getNumericModifiers(android.view.MenuItem menuItem) {
            return 0;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public java.lang.CharSequence getTooltipText(android.view.MenuItem menuItem) {
            return null;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setAlphabeticShortcut(android.view.MenuItem menuItem, char c, int i) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setContentDescription(android.view.MenuItem menuItem, java.lang.CharSequence charSequence) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintList(android.view.MenuItem menuItem, android.content.res.ColorStateList colorStateList) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintMode(android.view.MenuItem menuItem, android.graphics.PorterDuff.Mode mode) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setNumericShortcut(android.view.MenuItem menuItem, char c, int i) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setShortcut(android.view.MenuItem menuItem, char c, char c2, int i, int i2) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setTooltipText(android.view.MenuItem menuItem, java.lang.CharSequence charSequence) {
        }
    }

    interface MenuVersionImpl {
        int getAlphabeticModifiers(android.view.MenuItem menuItem);

        java.lang.CharSequence getContentDescription(android.view.MenuItem menuItem);

        android.content.res.ColorStateList getIconTintList(android.view.MenuItem menuItem);

        android.graphics.PorterDuff.Mode getIconTintMode(android.view.MenuItem menuItem);

        int getNumericModifiers(android.view.MenuItem menuItem);

        java.lang.CharSequence getTooltipText(android.view.MenuItem menuItem);

        void setAlphabeticShortcut(android.view.MenuItem menuItem, char c, int i);

        void setContentDescription(android.view.MenuItem menuItem, java.lang.CharSequence charSequence);

        void setIconTintList(android.view.MenuItem menuItem, android.content.res.ColorStateList colorStateList);

        void setIconTintMode(android.view.MenuItem menuItem, android.graphics.PorterDuff.Mode mode);

        void setNumericShortcut(android.view.MenuItem menuItem, char c, int i);

        void setShortcut(android.view.MenuItem menuItem, char c, char c2, int i, int i2);

        void setTooltipText(android.view.MenuItem menuItem, java.lang.CharSequence charSequence);
    }

    @java.lang.Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(android.view.MenuItem menuItem);

        boolean onMenuItemActionExpand(android.view.MenuItem menuItem);
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            IMPL = new android.support.v4.view.MenuItemCompat.MenuItemCompatApi26Impl();
        } else {
            IMPL = new android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl();
        }
    }

    private MenuItemCompat() {
    }

    @java.lang.Deprecated
    public static boolean collapseActionView(android.view.MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @java.lang.Deprecated
    public static boolean expandActionView(android.view.MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static android.support.v4.view.ActionProvider getActionProvider(android.view.MenuItem menuItem) {
        if (menuItem instanceof android.support.v4.internal.view.SupportMenuItem) {
            return ((android.support.v4.internal.view.SupportMenuItem) menuItem).getSupportActionProvider();
        }
        android.util.Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @java.lang.Deprecated
    public static android.view.View getActionView(android.view.MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int getAlphabeticModifiers(android.view.MenuItem menuItem) {
        return menuItem instanceof android.support.v4.internal.view.SupportMenuItem ? ((android.support.v4.internal.view.SupportMenuItem) menuItem).getAlphabeticModifiers() : IMPL.getAlphabeticModifiers(menuItem);
    }

    public static java.lang.CharSequence getContentDescription(android.view.MenuItem menuItem) {
        return menuItem instanceof android.support.v4.internal.view.SupportMenuItem ? ((android.support.v4.internal.view.SupportMenuItem) menuItem).getContentDescription() : IMPL.getContentDescription(menuItem);
    }

    public static android.content.res.ColorStateList getIconTintList(android.view.MenuItem menuItem) {
        return menuItem instanceof android.support.v4.internal.view.SupportMenuItem ? ((android.support.v4.internal.view.SupportMenuItem) menuItem).getIconTintList() : IMPL.getIconTintList(menuItem);
    }

    public static android.graphics.PorterDuff.Mode getIconTintMode(android.view.MenuItem menuItem) {
        return menuItem instanceof android.support.v4.internal.view.SupportMenuItem ? ((android.support.v4.internal.view.SupportMenuItem) menuItem).getIconTintMode() : IMPL.getIconTintMode(menuItem);
    }

    public static int getNumericModifiers(android.view.MenuItem menuItem) {
        return menuItem instanceof android.support.v4.internal.view.SupportMenuItem ? ((android.support.v4.internal.view.SupportMenuItem) menuItem).getNumericModifiers() : IMPL.getNumericModifiers(menuItem);
    }

    public static java.lang.CharSequence getTooltipText(android.view.MenuItem menuItem) {
        return menuItem instanceof android.support.v4.internal.view.SupportMenuItem ? ((android.support.v4.internal.view.SupportMenuItem) menuItem).getTooltipText() : IMPL.getTooltipText(menuItem);
    }

    @java.lang.Deprecated
    public static boolean isActionViewExpanded(android.view.MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    public static android.view.MenuItem setActionProvider(android.view.MenuItem menuItem, android.support.v4.view.ActionProvider actionProvider) {
        if (menuItem instanceof android.support.v4.internal.view.SupportMenuItem) {
            return ((android.support.v4.internal.view.SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
        }
        android.util.Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @java.lang.Deprecated
    public static android.view.MenuItem setActionView(android.view.MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    @java.lang.Deprecated
    public static android.view.MenuItem setActionView(android.view.MenuItem menuItem, android.view.View view) {
        return menuItem.setActionView(view);
    }

    public static void setAlphabeticShortcut(android.view.MenuItem menuItem, char c, int i) {
        if (menuItem instanceof android.support.v4.internal.view.SupportMenuItem) {
            ((android.support.v4.internal.view.SupportMenuItem) menuItem).setAlphabeticShortcut(c, i);
        } else {
            IMPL.setAlphabeticShortcut(menuItem, c, i);
        }
    }

    public static void setContentDescription(android.view.MenuItem menuItem, java.lang.CharSequence charSequence) {
        if (menuItem instanceof android.support.v4.internal.view.SupportMenuItem) {
            ((android.support.v4.internal.view.SupportMenuItem) menuItem).setContentDescription(charSequence);
        } else {
            IMPL.setContentDescription(menuItem, charSequence);
        }
    }

    public static void setIconTintList(android.view.MenuItem menuItem, android.content.res.ColorStateList colorStateList) {
        if (menuItem instanceof android.support.v4.internal.view.SupportMenuItem) {
            ((android.support.v4.internal.view.SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else {
            IMPL.setIconTintList(menuItem, colorStateList);
        }
    }

    public static void setIconTintMode(android.view.MenuItem menuItem, android.graphics.PorterDuff.Mode mode) {
        if (menuItem instanceof android.support.v4.internal.view.SupportMenuItem) {
            ((android.support.v4.internal.view.SupportMenuItem) menuItem).setIconTintMode(mode);
        } else {
            IMPL.setIconTintMode(menuItem, mode);
        }
    }

    public static void setNumericShortcut(android.view.MenuItem menuItem, char c, int i) {
        if (menuItem instanceof android.support.v4.internal.view.SupportMenuItem) {
            ((android.support.v4.internal.view.SupportMenuItem) menuItem).setNumericShortcut(c, i);
        } else {
            IMPL.setNumericShortcut(menuItem, c, i);
        }
    }

    @java.lang.Deprecated
    public static android.view.MenuItem setOnActionExpandListener(android.view.MenuItem menuItem, final android.support.v4.view.MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        return menuItem.setOnActionExpandListener(new android.view.MenuItem.OnActionExpandListener() { // from class: android.support.v4.view.MenuItemCompat.1
            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionCollapse(android.view.MenuItem menuItem2) {
                return onActionExpandListener.onMenuItemActionCollapse(menuItem2);
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionExpand(android.view.MenuItem menuItem2) {
                return onActionExpandListener.onMenuItemActionExpand(menuItem2);
            }
        });
    }

    public static void setShortcut(android.view.MenuItem menuItem, char c, char c2, int i, int i2) {
        if (menuItem instanceof android.support.v4.internal.view.SupportMenuItem) {
            ((android.support.v4.internal.view.SupportMenuItem) menuItem).setShortcut(c, c2, i, i2);
        } else {
            IMPL.setShortcut(menuItem, c, c2, i, i2);
        }
    }

    @java.lang.Deprecated
    public static void setShowAsAction(android.view.MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static void setTooltipText(android.view.MenuItem menuItem, java.lang.CharSequence charSequence) {
        if (menuItem instanceof android.support.v4.internal.view.SupportMenuItem) {
            ((android.support.v4.internal.view.SupportMenuItem) menuItem).setTooltipText(charSequence);
        } else {
            IMPL.setTooltipText(menuItem, charSequence);
        }
    }
}
