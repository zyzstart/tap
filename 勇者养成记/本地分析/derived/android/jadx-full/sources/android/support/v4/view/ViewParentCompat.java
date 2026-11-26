package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ViewParentCompat {
    static final android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl IMPL;
    private static final java.lang.String TAG = "ViewParentCompat";

    @android.support.annotation.RequiresApi(19)
    static class ViewParentCompatApi19Impl extends android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl {
        ViewParentCompatApi19Impl() {
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        public void notifySubtreeAccessibilityStateChanged(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
        }
    }

    @android.support.annotation.RequiresApi(21)
    static class ViewParentCompatApi21Impl extends android.support.v4.view.ViewParentCompat.ViewParentCompatApi19Impl {
        ViewParentCompatApi21Impl() {
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        public boolean onNestedFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (java.lang.AbstractMethodError e) {
                android.util.Log.e(android.support.v4.view.ViewParentCompat.TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
                return false;
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        public boolean onNestedPreFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (java.lang.AbstractMethodError e) {
                android.util.Log.e(android.support.v4.view.ViewParentCompat.TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        public void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (java.lang.AbstractMethodError e) {
                android.util.Log.e(android.support.v4.view.ViewParentCompat.TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        public void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (java.lang.AbstractMethodError e) {
                android.util.Log.e(android.support.v4.view.ViewParentCompat.TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        public void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (java.lang.AbstractMethodError e) {
                android.util.Log.e(android.support.v4.view.ViewParentCompat.TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        public boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (java.lang.AbstractMethodError e) {
                android.util.Log.e(android.support.v4.view.ViewParentCompat.TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
                return false;
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        public void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (java.lang.AbstractMethodError e) {
                android.util.Log.e(android.support.v4.view.ViewParentCompat.TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
            }
        }
    }

    static class ViewParentCompatBaseImpl {
        ViewParentCompatBaseImpl() {
        }

        public void notifySubtreeAccessibilityStateChanged(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        }

        public boolean onNestedFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2, boolean z) {
            if (viewParent instanceof android.support.v4.view.NestedScrollingParent) {
                return ((android.support.v4.view.NestedScrollingParent) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean onNestedPreFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2) {
            if (viewParent instanceof android.support.v4.view.NestedScrollingParent) {
                return ((android.support.v4.view.NestedScrollingParent) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }

        public void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof android.support.v4.view.NestedScrollingParent) {
                ((android.support.v4.view.NestedScrollingParent) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof android.support.v4.view.NestedScrollingParent) {
                ((android.support.v4.view.NestedScrollingParent) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
            if (viewParent instanceof android.support.v4.view.NestedScrollingParent) {
                ((android.support.v4.view.NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
            if (viewParent instanceof android.support.v4.view.NestedScrollingParent) {
                return ((android.support.v4.view.NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view) {
            if (viewParent instanceof android.support.v4.view.NestedScrollingParent) {
                ((android.support.v4.view.NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.view.ViewParentCompat.ViewParentCompatApi21Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 19) {
            IMPL = new android.support.v4.view.ViewParentCompat.ViewParentCompatApi19Impl();
        } else {
            IMPL = new android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl();
        }
    }

    private ViewParentCompat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        IMPL.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, i);
    }

    public static boolean onNestedFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2, boolean z) {
        return IMPL.onNestedFling(viewParent, view, f, f2, z);
    }

    public static boolean onNestedPreFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2) {
        return IMPL.onNestedPreFling(viewParent, view, f, f2);
    }

    public static void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(viewParent, view, i, i2, iArr, 0);
    }

    public static void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof android.support.v4.view.NestedScrollingParent2) {
            ((android.support.v4.view.NestedScrollingParent2) viewParent).onNestedPreScroll(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            IMPL.onNestedPreScroll(viewParent, view, i, i2, iArr);
        }
    }

    public static void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4) {
        onNestedScroll(viewParent, view, i, i2, i3, i4, 0);
    }

    public static void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof android.support.v4.view.NestedScrollingParent2) {
            ((android.support.v4.view.NestedScrollingParent2) viewParent).onNestedScroll(view, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            IMPL.onNestedScroll(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        onNestedScrollAccepted(viewParent, view, view2, i, 0);
    }

    public static void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i, int i2) {
        if (viewParent instanceof android.support.v4.view.NestedScrollingParent2) {
            ((android.support.v4.view.NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i, i2);
        } else if (i2 == 0) {
            IMPL.onNestedScrollAccepted(viewParent, view, view2, i);
        }
    }

    public static boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        return onStartNestedScroll(viewParent, view, view2, i, 0);
    }

    public static boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i, int i2) {
        if (viewParent instanceof android.support.v4.view.NestedScrollingParent2) {
            return ((android.support.v4.view.NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i, i2);
        }
        if (i2 == 0) {
            return IMPL.onStartNestedScroll(viewParent, view, view2, i);
        }
        return false;
    }

    public static void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    public static void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i) {
        if (viewParent instanceof android.support.v4.view.NestedScrollingParent2) {
            ((android.support.v4.view.NestedScrollingParent2) viewParent).onStopNestedScroll(view, i);
        } else if (i == 0) {
            IMPL.onStopNestedScroll(viewParent, view);
        }
    }

    @java.lang.Deprecated
    public static boolean requestSendAccessibilityEvent(android.view.ViewParent viewParent, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
