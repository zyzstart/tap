package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NestedScrollingParentHelper {
    private int mNestedScrollAxes;
    private final android.view.ViewGroup mViewGroup;

    public NestedScrollingParentHelper(@android.support.annotation.NonNull android.view.ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxes;
    }

    public void onNestedScrollAccepted(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.NonNull android.view.View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.NonNull android.view.View view2, int i, int i2) {
        this.mNestedScrollAxes = i;
    }

    public void onStopNestedScroll(@android.support.annotation.NonNull android.view.View view) {
        onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(@android.support.annotation.NonNull android.view.View view, int i) {
        this.mNestedScrollAxes = 0;
    }
}
