package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@android.support.annotation.NonNull android.view.View view, float f, float f2, boolean z);

    boolean onNestedPreFling(@android.support.annotation.NonNull android.view.View view, float f, float f2);

    void onNestedPreScroll(@android.support.annotation.NonNull android.view.View view, int i, int i2, @android.support.annotation.NonNull int[] iArr);

    void onNestedScroll(@android.support.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4);

    void onNestedScrollAccepted(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.NonNull android.view.View view2, int i);

    boolean onStartNestedScroll(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.NonNull android.view.View view2, int i);

    void onStopNestedScroll(@android.support.annotation.NonNull android.view.View view);
}
