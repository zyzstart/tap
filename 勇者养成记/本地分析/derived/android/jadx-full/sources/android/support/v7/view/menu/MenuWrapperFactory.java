package android.support.v7.view.menu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class MenuWrapperFactory {
    private MenuWrapperFactory() {
    }

    public static android.view.Menu wrapSupportMenu(android.content.Context context, android.support.v4.internal.view.SupportMenu supportMenu) {
        return new android.support.v7.view.menu.MenuWrapperICS(context, supportMenu);
    }

    public static android.view.MenuItem wrapSupportMenuItem(android.content.Context context, android.support.v4.internal.view.SupportMenuItem supportMenuItem) {
        return android.os.Build.VERSION.SDK_INT >= 16 ? new android.support.v7.view.menu.MenuItemWrapperJB(context, supportMenuItem) : new android.support.v7.view.menu.MenuItemWrapperICS(context, supportMenuItem);
    }

    public static android.view.SubMenu wrapSupportSubMenu(android.content.Context context, android.support.v4.internal.view.SupportSubMenu supportSubMenu) {
        return new android.support.v7.view.menu.SubMenuWrapperICS(context, supportSubMenu);
    }
}
