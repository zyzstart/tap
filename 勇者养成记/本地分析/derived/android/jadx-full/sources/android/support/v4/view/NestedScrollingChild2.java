package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface NestedScrollingChild2 extends android.support.v4.view.NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i, int i2, @android.support.annotation.Nullable int[] iArr, @android.support.annotation.Nullable int[] iArr2, int i3);

    boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @android.support.annotation.Nullable int[] iArr, int i5);

    boolean hasNestedScrollingParent(int i);

    boolean startNestedScroll(int i, int i2);

    void stopNestedScroll(int i);
}
