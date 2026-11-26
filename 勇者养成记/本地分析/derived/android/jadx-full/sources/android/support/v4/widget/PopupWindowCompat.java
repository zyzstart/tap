package android.support.v4.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class PopupWindowCompat {
    static final android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl IMPL;

    @android.support.annotation.RequiresApi(19)
    static class PopupWindowCompatApi19Impl extends android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl {
        PopupWindowCompatApi19Impl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public void showAsDropDown(android.widget.PopupWindow popupWindow, android.view.View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    @android.support.annotation.RequiresApi(21)
    static class PopupWindowCompatApi21Impl extends android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi19Impl {
        private static final java.lang.String TAG = "PopupWindowCompatApi21";
        private static java.lang.reflect.Field sOverlapAnchorField;

        static {
            try {
                sOverlapAnchorField = android.widget.PopupWindow.class.getDeclaredField("mOverlapAnchor");
                sOverlapAnchorField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e) {
                android.util.Log.i(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
        }

        PopupWindowCompatApi21Impl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public boolean getOverlapAnchor(android.widget.PopupWindow popupWindow) {
            java.lang.reflect.Field field = sOverlapAnchorField;
            if (field == null) {
                return false;
            }
            try {
                return ((java.lang.Boolean) field.get(popupWindow)).booleanValue();
            } catch (java.lang.IllegalAccessException e) {
                android.util.Log.i(TAG, "Could not get overlap anchor field in PopupWindow", e);
                return false;
            }
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public void setOverlapAnchor(android.widget.PopupWindow popupWindow, boolean z) {
            java.lang.reflect.Field field = sOverlapAnchorField;
            if (field != null) {
                try {
                    field.set(popupWindow, java.lang.Boolean.valueOf(z));
                } catch (java.lang.IllegalAccessException e) {
                    android.util.Log.i(TAG, "Could not set overlap anchor field in PopupWindow", e);
                }
            }
        }
    }

    @android.support.annotation.RequiresApi(23)
    static class PopupWindowCompatApi23Impl extends android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl {
        PopupWindowCompatApi23Impl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl, android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public boolean getOverlapAnchor(android.widget.PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public int getWindowLayoutType(android.widget.PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl, android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public void setOverlapAnchor(android.widget.PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public void setWindowLayoutType(android.widget.PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    static class PopupWindowCompatBaseImpl {
        private static java.lang.reflect.Method sGetWindowLayoutTypeMethod;
        private static boolean sGetWindowLayoutTypeMethodAttempted;
        private static java.lang.reflect.Method sSetWindowLayoutTypeMethod;
        private static boolean sSetWindowLayoutTypeMethodAttempted;

        PopupWindowCompatBaseImpl() {
        }

        public boolean getOverlapAnchor(android.widget.PopupWindow popupWindow) {
            return false;
        }

        public int getWindowLayoutType(android.widget.PopupWindow popupWindow) {
            if (!sGetWindowLayoutTypeMethodAttempted) {
                try {
                    sGetWindowLayoutTypeMethod = android.widget.PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new java.lang.Class[0]);
                    sGetWindowLayoutTypeMethod.setAccessible(true);
                } catch (java.lang.Exception unused) {
                }
                sGetWindowLayoutTypeMethodAttempted = true;
            }
            java.lang.reflect.Method method = sGetWindowLayoutTypeMethod;
            if (method != null) {
                try {
                    return ((java.lang.Integer) method.invoke(popupWindow, new java.lang.Object[0])).intValue();
                } catch (java.lang.Exception unused2) {
                }
            }
            return 0;
        }

        public void setOverlapAnchor(android.widget.PopupWindow popupWindow, boolean z) {
        }

        public void setWindowLayoutType(android.widget.PopupWindow popupWindow, int i) {
            if (!sSetWindowLayoutTypeMethodAttempted) {
                try {
                    sSetWindowLayoutTypeMethod = android.widget.PopupWindow.class.getDeclaredMethod("setWindowLayoutType", java.lang.Integer.TYPE);
                    sSetWindowLayoutTypeMethod.setAccessible(true);
                } catch (java.lang.Exception unused) {
                }
                sSetWindowLayoutTypeMethodAttempted = true;
            }
            java.lang.reflect.Method method = sSetWindowLayoutTypeMethod;
            if (method != null) {
                try {
                    method.invoke(popupWindow, java.lang.Integer.valueOf(i));
                } catch (java.lang.Exception unused2) {
                }
            }
        }

        public void showAsDropDown(android.widget.PopupWindow popupWindow, android.view.View view, int i, int i2, int i3) {
            if ((android.support.v4.view.GravityCompat.getAbsoluteGravity(i3, android.support.v4.view.ViewCompat.getLayoutDirection(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            IMPL = new android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi23Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 19) {
            IMPL = new android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi19Impl();
        } else {
            IMPL = new android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl();
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(android.widget.PopupWindow popupWindow) {
        return IMPL.getOverlapAnchor(popupWindow);
    }

    public static int getWindowLayoutType(android.widget.PopupWindow popupWindow) {
        return IMPL.getWindowLayoutType(popupWindow);
    }

    public static void setOverlapAnchor(android.widget.PopupWindow popupWindow, boolean z) {
        IMPL.setOverlapAnchor(popupWindow, z);
    }

    public static void setWindowLayoutType(android.widget.PopupWindow popupWindow, int i) {
        IMPL.setWindowLayoutType(popupWindow, i);
    }

    public static void showAsDropDown(android.widget.PopupWindow popupWindow, android.view.View view, int i, int i2, int i3) {
        IMPL.showAsDropDown(popupWindow, view, i, i2, i3);
    }
}
