package android.support.v4.view.accessibility;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private java.lang.Object mInfo;

    private AccessibilityWindowInfoCompat(java.lang.Object obj) {
        this.mInfo = obj;
    }

    public static android.support.v4.view.accessibility.AccessibilityWindowInfoCompat obtain() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return wrapNonNullInstance(android.view.accessibility.AccessibilityWindowInfo.obtain());
        }
        return null;
    }

    public static android.support.v4.view.accessibility.AccessibilityWindowInfoCompat obtain(android.support.v4.view.accessibility.AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        if (android.os.Build.VERSION.SDK_INT < 21 || accessibilityWindowInfoCompat == null) {
            return null;
        }
        return wrapNonNullInstance(android.view.accessibility.AccessibilityWindowInfo.obtain((android.view.accessibility.AccessibilityWindowInfo) accessibilityWindowInfoCompat.mInfo));
    }

    private static java.lang.String typeToString(int i) {
        switch (i) {
            case 1:
                return "TYPE_APPLICATION";
            case 2:
                return "TYPE_INPUT_METHOD";
            case 3:
                return "TYPE_SYSTEM";
            case 4:
                return "TYPE_ACCESSIBILITY_OVERLAY";
            default:
                return "<UNKNOWN>";
        }
    }

    static android.support.v4.view.accessibility.AccessibilityWindowInfoCompat wrapNonNullInstance(java.lang.Object obj) {
        if (obj != null) {
            return new android.support.v4.view.accessibility.AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        android.support.v4.view.accessibility.AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (android.support.v4.view.accessibility.AccessibilityWindowInfoCompat) obj;
        java.lang.Object obj2 = this.mInfo;
        if (obj2 == null) {
            if (accessibilityWindowInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!obj2.equals(accessibilityWindowInfoCompat.mInfo)) {
            return false;
        }
        return true;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getAnchor() {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getAnchor());
        }
        return null;
    }

    public void getBoundsInScreen(android.graphics.Rect rect) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getBoundsInScreen(rect);
        }
    }

    public android.support.v4.view.accessibility.AccessibilityWindowInfoCompat getChild(int i) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return wrapNonNullInstance(((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getChild(i));
        }
        return null;
    }

    public int getChildCount() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getChildCount();
        }
        return 0;
    }

    public int getId() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getId();
        }
        return -1;
    }

    public int getLayer() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getLayer();
        }
        return -1;
    }

    public android.support.v4.view.accessibility.AccessibilityWindowInfoCompat getParent() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return wrapNonNullInstance(((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getParent());
        }
        return null;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getRoot() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getRoot());
        }
        return null;
    }

    public java.lang.CharSequence getTitle() {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getTitle();
        }
        return null;
    }

    public int getType() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getType();
        }
        return -1;
    }

    public int hashCode() {
        java.lang.Object obj = this.mInfo;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isAccessibilityFocused() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).isAccessibilityFocused();
        }
        return true;
    }

    public boolean isActive() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).isActive();
        }
        return true;
    }

    public boolean isFocused() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).isFocused();
        }
        return true;
    }

    public void recycle() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).recycle();
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        android.graphics.Rect rect = new android.graphics.Rect();
        getBoundsInScreen(rect);
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=");
        sb.append(getId());
        sb.append(", type=");
        sb.append(typeToString(getType()));
        sb.append(", layer=");
        sb.append(getLayer());
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", focused=");
        sb.append(isFocused());
        sb.append(", active=");
        sb.append(isActive());
        sb.append(", hasParent=");
        sb.append(getParent() != null);
        sb.append(", hasChildren=");
        sb.append(getChildCount() > 0);
        sb.append(']');
        return sb.toString();
    }
}
