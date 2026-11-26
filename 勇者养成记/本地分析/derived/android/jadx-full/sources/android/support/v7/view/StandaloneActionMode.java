package android.support.v7.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class StandaloneActionMode extends android.support.v7.view.ActionMode implements android.support.v7.view.menu.MenuBuilder.Callback {
    private android.support.v7.view.ActionMode.Callback mCallback;
    private android.content.Context mContext;
    private android.support.v7.widget.ActionBarContextView mContextView;
    private java.lang.ref.WeakReference<android.view.View> mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private android.support.v7.view.menu.MenuBuilder mMenu;

    public StandaloneActionMode(android.content.Context context, android.support.v7.widget.ActionBarContextView actionBarContextView, android.support.v7.view.ActionMode.Callback callback, boolean z) {
        this.mContext = context;
        this.mContextView = actionBarContextView;
        this.mCallback = callback;
        this.mMenu = new android.support.v7.view.menu.MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.mMenu.setCallback(this);
        this.mFocusable = z;
    }

    @Override // android.support.v7.view.ActionMode
    public void finish() {
        if (this.mFinished) {
            return;
        }
        this.mFinished = true;
        this.mContextView.sendAccessibilityEvent(32);
        this.mCallback.onDestroyActionMode(this);
    }

    @Override // android.support.v7.view.ActionMode
    public android.view.View getCustomView() {
        java.lang.ref.WeakReference<android.view.View> weakReference = this.mCustomView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.support.v7.view.ActionMode
    public android.view.Menu getMenu() {
        return this.mMenu;
    }

    @Override // android.support.v7.view.ActionMode
    public android.view.MenuInflater getMenuInflater() {
        return new android.support.v7.view.SupportMenuInflater(this.mContextView.getContext());
    }

    @Override // android.support.v7.view.ActionMode
    public java.lang.CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }

    @Override // android.support.v7.view.ActionMode
    public java.lang.CharSequence getTitle() {
        return this.mContextView.getTitle();
    }

    @Override // android.support.v7.view.ActionMode
    public void invalidate() {
        this.mCallback.onPrepareActionMode(this, this.mMenu);
    }

    @Override // android.support.v7.view.ActionMode
    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }

    @Override // android.support.v7.view.ActionMode
    public boolean isUiFocusable() {
        return this.mFocusable;
    }

    public void onCloseMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z) {
    }

    public void onCloseSubMenu(android.support.v7.view.menu.SubMenuBuilder subMenuBuilder) {
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(android.support.v7.view.menu.MenuBuilder menuBuilder, android.view.MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(this, menuItem);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(android.support.v7.view.menu.MenuBuilder menuBuilder) {
        invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(android.support.v7.view.menu.SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new android.support.v7.view.menu.MenuPopupHelper(this.mContextView.getContext(), subMenuBuilder).show();
        return true;
    }

    @Override // android.support.v7.view.ActionMode
    public void setCustomView(android.view.View view) {
        this.mContextView.setCustomView(view);
        this.mCustomView = view != null ? new java.lang.ref.WeakReference<>(view) : null;
    }

    @Override // android.support.v7.view.ActionMode
    public void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    @Override // android.support.v7.view.ActionMode
    public void setSubtitle(java.lang.CharSequence charSequence) {
        this.mContextView.setSubtitle(charSequence);
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitle(java.lang.CharSequence charSequence) {
        this.mContextView.setTitle(charSequence);
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.mContextView.setTitleOptional(z);
    }
}
