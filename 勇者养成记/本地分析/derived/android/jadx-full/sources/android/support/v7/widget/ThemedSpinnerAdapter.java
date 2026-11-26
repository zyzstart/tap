package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ThemedSpinnerAdapter extends android.widget.SpinnerAdapter {

    public static final class Helper {
        private final android.content.Context mContext;
        private android.view.LayoutInflater mDropDownInflater;
        private final android.view.LayoutInflater mInflater;

        public Helper(@android.support.annotation.NonNull android.content.Context context) {
            this.mContext = context;
            this.mInflater = android.view.LayoutInflater.from(context);
        }

        @android.support.annotation.NonNull
        public android.view.LayoutInflater getDropDownViewInflater() {
            android.view.LayoutInflater layoutInflater = this.mDropDownInflater;
            return layoutInflater != null ? layoutInflater : this.mInflater;
        }

        @android.support.annotation.Nullable
        public android.content.res.Resources.Theme getDropDownViewTheme() {
            android.view.LayoutInflater layoutInflater = this.mDropDownInflater;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void setDropDownViewTheme(@android.support.annotation.Nullable android.content.res.Resources.Theme theme) {
            if (theme == null) {
                this.mDropDownInflater = null;
            } else if (theme == this.mContext.getTheme()) {
                this.mDropDownInflater = this.mInflater;
            } else {
                this.mDropDownInflater = android.view.LayoutInflater.from(new android.support.v7.view.ContextThemeWrapper(this.mContext, theme));
            }
        }
    }

    @android.support.annotation.Nullable
    android.content.res.Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@android.support.annotation.Nullable android.content.res.Resources.Theme theme);
}
