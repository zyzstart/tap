package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ViewGroupCompat {
    static final android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl IMPL;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    @android.support.annotation.RequiresApi(18)
    static class ViewGroupCompatApi18Impl extends android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl {
        ViewGroupCompatApi18Impl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl
        public int getLayoutMode(android.view.ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl
        public void setLayoutMode(android.view.ViewGroup viewGroup, int i) {
            viewGroup.setLayoutMode(i);
        }
    }

    @android.support.annotation.RequiresApi(21)
    static class ViewGroupCompatApi21Impl extends android.support.v4.view.ViewGroupCompat.ViewGroupCompatApi18Impl {
        ViewGroupCompatApi21Impl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl
        public int getNestedScrollAxes(android.view.ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl
        public boolean isTransitionGroup(android.view.ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl
        public void setTransitionGroup(android.view.ViewGroup viewGroup, boolean z) {
            viewGroup.setTransitionGroup(z);
        }
    }

    static class ViewGroupCompatBaseImpl {
        ViewGroupCompatBaseImpl() {
        }

        public int getLayoutMode(android.view.ViewGroup viewGroup) {
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int getNestedScrollAxes(android.view.ViewGroup viewGroup) {
            if (viewGroup instanceof android.support.v4.view.NestedScrollingParent) {
                return ((android.support.v4.view.NestedScrollingParent) viewGroup).getNestedScrollAxes();
            }
            return 0;
        }

        public boolean isTransitionGroup(android.view.ViewGroup viewGroup) {
            return false;
        }

        public void setLayoutMode(android.view.ViewGroup viewGroup, int i) {
        }

        public void setTransitionGroup(android.view.ViewGroup viewGroup, boolean z) {
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.view.ViewGroupCompat.ViewGroupCompatApi21Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 18) {
            IMPL = new android.support.v4.view.ViewGroupCompat.ViewGroupCompatApi18Impl();
        } else {
            IMPL = new android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl();
        }
    }

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(android.view.ViewGroup viewGroup) {
        return IMPL.getLayoutMode(viewGroup);
    }

    public static int getNestedScrollAxes(@android.support.annotation.NonNull android.view.ViewGroup viewGroup) {
        return IMPL.getNestedScrollAxes(viewGroup);
    }

    public static boolean isTransitionGroup(android.view.ViewGroup viewGroup) {
        return IMPL.isTransitionGroup(viewGroup);
    }

    @java.lang.Deprecated
    public static boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void setLayoutMode(android.view.ViewGroup viewGroup, int i) {
        IMPL.setLayoutMode(viewGroup, i);
    }

    @java.lang.Deprecated
    public static void setMotionEventSplittingEnabled(android.view.ViewGroup viewGroup, boolean z) {
        viewGroup.setMotionEventSplittingEnabled(z);
    }

    public static void setTransitionGroup(android.view.ViewGroup viewGroup, boolean z) {
        IMPL.setTransitionGroup(viewGroup, z);
    }
}
