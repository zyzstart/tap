package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(24)
class AppCompatDelegateImplN extends android.support.v7.app.AppCompatDelegateImplV23 {

    class AppCompatWindowCallbackN extends android.support.v7.app.AppCompatDelegateImplV23.AppCompatWindowCallbackV23 {
        AppCompatWindowCallbackN(android.view.Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(java.util.List<android.view.KeyboardShortcutGroup> list, android.view.Menu menu, int i) {
            android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState panelState = android.support.v7.app.AppCompatDelegateImplN.this.getPanelState(0, true);
            if (panelState == null || panelState.menu == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, panelState.menu, i);
            }
        }
    }

    AppCompatDelegateImplN(android.content.Context context, android.view.Window window, android.support.v7.app.AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV23, android.support.v7.app.AppCompatDelegateImplV14, android.support.v7.app.AppCompatDelegateImplBase
    android.view.Window.Callback wrapWindowCallback(android.view.Window.Callback callback) {
        return new android.support.v7.app.AppCompatDelegateImplN.AppCompatWindowCallbackN(callback);
    }
}
