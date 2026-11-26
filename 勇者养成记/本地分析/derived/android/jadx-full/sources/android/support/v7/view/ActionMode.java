package android.support.v7.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class ActionMode {
    private java.lang.Object mTag;
    private boolean mTitleOptionalHint;

    public interface Callback {
        boolean onActionItemClicked(android.support.v7.view.ActionMode actionMode, android.view.MenuItem menuItem);

        boolean onCreateActionMode(android.support.v7.view.ActionMode actionMode, android.view.Menu menu);

        void onDestroyActionMode(android.support.v7.view.ActionMode actionMode);

        boolean onPrepareActionMode(android.support.v7.view.ActionMode actionMode, android.view.Menu menu);
    }

    public abstract void finish();

    public abstract android.view.View getCustomView();

    public abstract android.view.Menu getMenu();

    public abstract android.view.MenuInflater getMenuInflater();

    public abstract java.lang.CharSequence getSubtitle();

    public java.lang.Object getTag() {
        return this.mTag;
    }

    public abstract java.lang.CharSequence getTitle();

    public boolean getTitleOptionalHint() {
        return this.mTitleOptionalHint;
    }

    public abstract void invalidate();

    public boolean isTitleOptional() {
        return false;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isUiFocusable() {
        return true;
    }

    public abstract void setCustomView(android.view.View view);

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(java.lang.CharSequence charSequence);

    public void setTag(java.lang.Object obj) {
        this.mTag = obj;
    }

    public abstract void setTitle(int i);

    public abstract void setTitle(java.lang.CharSequence charSequence);

    public void setTitleOptionalHint(boolean z) {
        this.mTitleOptionalHint = z;
    }
}
