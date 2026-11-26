package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public final class KeyEventCompat {
    private KeyEventCompat() {
    }

    @java.lang.Deprecated
    public static boolean dispatch(android.view.KeyEvent keyEvent, android.view.KeyEvent.Callback callback, java.lang.Object obj, java.lang.Object obj2) {
        return keyEvent.dispatch(callback, (android.view.KeyEvent.DispatcherState) obj, obj2);
    }

    @java.lang.Deprecated
    public static java.lang.Object getKeyDispatcherState(android.view.View view) {
        return view.getKeyDispatcherState();
    }

    @java.lang.Deprecated
    public static boolean hasModifiers(android.view.KeyEvent keyEvent, int i) {
        return keyEvent.hasModifiers(i);
    }

    @java.lang.Deprecated
    public static boolean hasNoModifiers(android.view.KeyEvent keyEvent) {
        return keyEvent.hasNoModifiers();
    }

    @java.lang.Deprecated
    public static boolean isCtrlPressed(android.view.KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }

    @java.lang.Deprecated
    public static boolean isTracking(android.view.KeyEvent keyEvent) {
        return keyEvent.isTracking();
    }

    @java.lang.Deprecated
    public static boolean metaStateHasModifiers(int i, int i2) {
        return android.view.KeyEvent.metaStateHasModifiers(i, i2);
    }

    @java.lang.Deprecated
    public static boolean metaStateHasNoModifiers(int i) {
        return android.view.KeyEvent.metaStateHasNoModifiers(i);
    }

    @java.lang.Deprecated
    public static int normalizeMetaState(int i) {
        return android.view.KeyEvent.normalizeMetaState(i);
    }

    @java.lang.Deprecated
    public static void startTracking(android.view.KeyEvent keyEvent) {
        keyEvent.startTracking();
    }
}
