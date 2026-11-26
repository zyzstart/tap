package android.support.v4.view.accessibility;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class AccessibilityEventCompat {
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    private static final android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatBaseImpl IMPL;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_ASSIST_READING_CONTEXT = 16777216;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;

    @java.lang.Deprecated
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;

    @java.lang.Deprecated
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
    public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_CONTEXT_CLICKED = 8388608;

    @java.lang.Deprecated
    public static final int TYPE_VIEW_HOVER_ENTER = 128;

    @java.lang.Deprecated
    public static final int TYPE_VIEW_HOVER_EXIT = 256;

    @java.lang.Deprecated
    public static final int TYPE_VIEW_SCROLLED = 4096;

    @java.lang.Deprecated
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOWS_CHANGED = 4194304;

    @java.lang.Deprecated
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;

    @android.support.annotation.RequiresApi(16)
    static class AccessibilityEventCompatApi16Impl extends android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatBaseImpl {
        AccessibilityEventCompatApi16Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatBaseImpl
        public int getAction(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getAction();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatBaseImpl
        public int getMovementGranularity(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getMovementGranularity();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatBaseImpl
        public void setAction(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setAction(i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatBaseImpl
        public void setMovementGranularity(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setMovementGranularity(i);
        }
    }

    @android.support.annotation.RequiresApi(19)
    static class AccessibilityEventCompatApi19Impl extends android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatApi16Impl {
        AccessibilityEventCompatApi19Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatBaseImpl
        public int getContentChangeTypes(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatBaseImpl
        public void setContentChangeTypes(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    static class AccessibilityEventCompatBaseImpl {
        AccessibilityEventCompatBaseImpl() {
        }

        public int getAction(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public int getContentChangeTypes(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public int getMovementGranularity(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public void setAction(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i) {
        }

        public void setContentChangeTypes(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i) {
        }

        public void setMovementGranularity(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i) {
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatApi19Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatApi16Impl();
        } else {
            IMPL = new android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventCompatBaseImpl();
        }
    }

    private AccessibilityEventCompat() {
    }

    @java.lang.Deprecated
    public static void appendRecord(android.view.accessibility.AccessibilityEvent accessibilityEvent, android.support.v4.view.accessibility.AccessibilityRecordCompat accessibilityRecordCompat) {
        accessibilityEvent.appendRecord((android.view.accessibility.AccessibilityRecord) accessibilityRecordCompat.getImpl());
    }

    @java.lang.Deprecated
    public static android.support.v4.view.accessibility.AccessibilityRecordCompat asRecord(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return new android.support.v4.view.accessibility.AccessibilityRecordCompat(accessibilityEvent);
    }

    public static int getContentChangeTypes(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return IMPL.getContentChangeTypes(accessibilityEvent);
    }

    @java.lang.Deprecated
    public static android.support.v4.view.accessibility.AccessibilityRecordCompat getRecord(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i) {
        return new android.support.v4.view.accessibility.AccessibilityRecordCompat(accessibilityEvent.getRecord(i));
    }

    @java.lang.Deprecated
    public static int getRecordCount(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getRecordCount();
    }

    public static void setContentChangeTypes(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i) {
        IMPL.setContentChangeTypes(accessibilityEvent, i);
    }

    public int getAction(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return IMPL.getAction(accessibilityEvent);
    }

    public int getMovementGranularity(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return IMPL.getMovementGranularity(accessibilityEvent);
    }

    public void setAction(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i) {
        IMPL.setAction(accessibilityEvent, i);
    }

    public void setMovementGranularity(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i) {
        IMPL.setMovementGranularity(accessibilityEvent, i);
    }
}
