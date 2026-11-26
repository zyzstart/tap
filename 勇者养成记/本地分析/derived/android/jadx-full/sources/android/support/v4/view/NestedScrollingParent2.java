package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface NestedScrollingParent2 extends android.support.v4.view.NestedScrollingParent {
    void onNestedPreScroll(@android.support.annotation.NonNull android.view.View view, int i, int i2, @android.support.annotation.Nullable int[] iArr, int i3);

    void onNestedScroll(@android.support.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4, int i5);

    void onNestedScrollAccepted(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.NonNull android.view.View view2, int i, int i2);

    boolean onStartNestedScroll(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.NonNull android.view.View view2, int i, int i2);

    void onStopNestedScroll(@android.support.annotation.NonNull android.view.View view, int i);
}
