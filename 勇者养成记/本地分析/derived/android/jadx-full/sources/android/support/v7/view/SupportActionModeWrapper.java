package android.support.v7.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SupportActionModeWrapper extends android.view.ActionMode {
    final android.content.Context mContext;
    final android.support.v7.view.ActionMode mWrappedObject;

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static class CallbackWrapper implements android.support.v7.view.ActionMode.Callback {
        final android.content.Context mContext;
        final android.view.ActionMode.Callback mWrappedCallback;
        final java.util.ArrayList<android.support.v7.view.SupportActionModeWrapper> mActionModes = new java.util.ArrayList<>();
        final android.support.v4.util.SimpleArrayMap<android.view.Menu, android.view.Menu> mMenus = new android.support.v4.util.SimpleArrayMap<>();

        public CallbackWrapper(android.content.Context context, android.view.ActionMode.Callback callback) {
            this.mContext = context;
            this.mWrappedCallback = callback;
        }

        private android.view.Menu getMenuWrapper(android.view.Menu menu) {
            android.view.Menu menu2 = this.mMenus.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            android.view.Menu menuWrapSupportMenu = android.support.v7.view.menu.MenuWrapperFactory.wrapSupportMenu(this.mContext, (android.support.v4.internal.view.SupportMenu) menu);
            this.mMenus.put(menu, menuWrapSupportMenu);
            return menuWrapSupportMenu;
        }

        public android.view.ActionMode getActionModeWrapper(android.support.v7.view.ActionMode actionMode) {
            int size = this.mActionModes.size();
            for (int i = 0; i < size; i++) {
                android.support.v7.view.SupportActionModeWrapper supportActionModeWrapper = this.mActionModes.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            android.support.v7.view.SupportActionModeWrapper supportActionModeWrapper2 = new android.support.v7.view.SupportActionModeWrapper(this.mContext, actionMode);
            this.mActionModes.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(android.support.v7.view.ActionMode actionMode, android.view.MenuItem menuItem) {
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(actionMode), android.support.v7.view.menu.MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (android.support.v4.internal.view.SupportMenuItem) menuItem));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(android.support.v7.view.ActionMode actionMode, android.view.Menu menu) {
            return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(android.support.v7.view.ActionMode actionMode) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(android.support.v7.view.ActionMode actionMode, android.view.Menu menu) {
            return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu));
        }
    }

    public SupportActionModeWrapper(android.content.Context context, android.support.v7.view.ActionMode actionMode) {
        this.mContext = context;
        this.mWrappedObject = actionMode;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.mWrappedObject.finish();
    }

    @Override // android.view.ActionMode
    public android.view.View getCustomView() {
        return this.mWrappedObject.getCustomView();
    }

    @Override // android.view.ActionMode
    public android.view.Menu getMenu() {
        return android.support.v7.view.menu.MenuWrapperFactory.wrapSupportMenu(this.mContext, (android.support.v4.internal.view.SupportMenu) this.mWrappedObject.getMenu());
    }

    @Override // android.view.ActionMode
    public android.view.MenuInflater getMenuInflater() {
        return this.mWrappedObject.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public java.lang.CharSequence getSubtitle() {
        return this.mWrappedObject.getSubtitle();
    }

    @Override // android.view.ActionMode
    public java.lang.Object getTag() {
        return this.mWrappedObject.getTag();
    }

    @Override // android.view.ActionMode
    public java.lang.CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.mWrappedObject.invalidate();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }

    @Override // android.view.ActionMode
    public void setCustomView(android.view.View view) {
        this.mWrappedObject.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.mWrappedObject.setSubtitle(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(java.lang.CharSequence charSequence) {
        this.mWrappedObject.setSubtitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(java.lang.Object obj) {
        this.mWrappedObject.setTag(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.mWrappedObject.setTitle(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(java.lang.CharSequence charSequence) {
        this.mWrappedObject.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.mWrappedObject.setTitleOptionalHint(z);
    }
}
