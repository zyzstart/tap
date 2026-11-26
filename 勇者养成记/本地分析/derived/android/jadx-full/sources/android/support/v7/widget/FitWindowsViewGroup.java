package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public interface FitWindowsViewGroup {

    public interface OnFitSystemWindowsListener {
        void onFitSystemWindows(android.graphics.Rect rect);
    }

    void setOnFitSystemWindowsListener(android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener onFitSystemWindowsListener);
}
