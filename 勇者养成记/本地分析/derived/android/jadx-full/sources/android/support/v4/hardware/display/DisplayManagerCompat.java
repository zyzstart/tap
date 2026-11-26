package android.support.v4.hardware.display;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class DisplayManagerCompat {
    public static final java.lang.String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final java.util.WeakHashMap<android.content.Context, android.support.v4.hardware.display.DisplayManagerCompat> sInstances = new java.util.WeakHashMap<>();

    private static class DisplayManagerCompatApi14Impl extends android.support.v4.hardware.display.DisplayManagerCompat {
        private final android.view.WindowManager mWindowManager;

        DisplayManagerCompatApi14Impl(android.content.Context context) {
            this.mWindowManager = (android.view.WindowManager) context.getSystemService("window");
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public android.view.Display getDisplay(int i) {
            android.view.Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
            if (defaultDisplay.getDisplayId() == i) {
                return defaultDisplay;
            }
            return null;
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public android.view.Display[] getDisplays() {
            return new android.view.Display[]{this.mWindowManager.getDefaultDisplay()};
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public android.view.Display[] getDisplays(java.lang.String str) {
            return str == null ? getDisplays() : new android.view.Display[0];
        }
    }

    @android.support.annotation.RequiresApi(17)
    private static class DisplayManagerCompatApi17Impl extends android.support.v4.hardware.display.DisplayManagerCompat {
        private final android.hardware.display.DisplayManager mDisplayManager;

        DisplayManagerCompatApi17Impl(android.content.Context context) {
            this.mDisplayManager = (android.hardware.display.DisplayManager) context.getSystemService("display");
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public android.view.Display getDisplay(int i) {
            return this.mDisplayManager.getDisplay(i);
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public android.view.Display[] getDisplays() {
            return this.mDisplayManager.getDisplays();
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public android.view.Display[] getDisplays(java.lang.String str) {
            return this.mDisplayManager.getDisplays(str);
        }
    }

    DisplayManagerCompat() {
    }

    public static android.support.v4.hardware.display.DisplayManagerCompat getInstance(android.content.Context context) {
        android.support.v4.hardware.display.DisplayManagerCompat displayManagerCompatApi17Impl;
        synchronized (sInstances) {
            displayManagerCompatApi17Impl = sInstances.get(context);
            if (displayManagerCompatApi17Impl == null) {
                displayManagerCompatApi17Impl = android.os.Build.VERSION.SDK_INT >= 17 ? new android.support.v4.hardware.display.DisplayManagerCompat.DisplayManagerCompatApi17Impl(context) : new android.support.v4.hardware.display.DisplayManagerCompat.DisplayManagerCompatApi14Impl(context);
                sInstances.put(context, displayManagerCompatApi17Impl);
            }
        }
        return displayManagerCompatApi17Impl;
    }

    public abstract android.view.Display getDisplay(int i);

    public abstract android.view.Display[] getDisplays();

    public abstract android.view.Display[] getDisplays(java.lang.String str);
}
