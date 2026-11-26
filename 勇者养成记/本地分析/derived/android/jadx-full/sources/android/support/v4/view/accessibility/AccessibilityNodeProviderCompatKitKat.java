package android.support.v4.view.accessibility;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(19)
class AccessibilityNodeProviderCompatKitKat {

    interface AccessibilityNodeInfoBridge {
        java.lang.Object createAccessibilityNodeInfo(int i);

        java.util.List<java.lang.Object> findAccessibilityNodeInfosByText(java.lang.String str, int i);

        java.lang.Object findFocus(int i);

        boolean performAction(int i, int i2, android.os.Bundle bundle);
    }

    AccessibilityNodeProviderCompatKitKat() {
    }

    public static java.lang.Object newAccessibilityNodeProviderBridge(final android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new android.view.accessibility.AccessibilityNodeProvider() { // from class: android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.1
            @Override // android.view.accessibility.AccessibilityNodeProvider
            public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (android.view.accessibility.AccessibilityNodeInfo) accessibilityNodeInfoBridge.createAccessibilityNodeInfo(i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public java.util.List<android.view.accessibility.AccessibilityNodeInfo> findAccessibilityNodeInfosByText(java.lang.String str, int i) {
                return accessibilityNodeInfoBridge.findAccessibilityNodeInfosByText(str, i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public android.view.accessibility.AccessibilityNodeInfo findFocus(int i) {
                return (android.view.accessibility.AccessibilityNodeInfo) accessibilityNodeInfoBridge.findFocus(i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public boolean performAction(int i, int i2, android.os.Bundle bundle) {
                return accessibilityNodeInfoBridge.performAction(i, i2, bundle);
            }
        };
    }
}
