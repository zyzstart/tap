package android.support.v4.view.accessibility;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    private static final android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl IMPL;
    private final java.lang.Object mProvider;

    interface AccessibilityNodeProviderImpl {
        java.lang.Object newAccessibilityNodeProviderBridge(android.support.v4.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat);
    }

    @android.support.annotation.RequiresApi(16)
    private static class AccessibilityNodeProviderJellyBeanImpl extends android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderJellyBeanImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl, android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public java.lang.Object newAccessibilityNodeProviderBridge(final android.support.v4.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge() { // from class: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl.1
                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public java.lang.Object createAccessibilityNodeInfo(int i) {
                    android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateAccessibilityNodeInfo = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i);
                    if (accessibilityNodeInfoCompatCreateAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return accessibilityNodeInfoCompatCreateAccessibilityNodeInfo.unwrap();
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public java.util.List<java.lang.Object> findAccessibilityNodeInfosByText(java.lang.String str, int i) {
                    java.util.List<android.support.v4.view.accessibility.AccessibilityNodeInfoCompat> listFindAccessibilityNodeInfosByText = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i);
                    if (listFindAccessibilityNodeInfosByText == null) {
                        return null;
                    }
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    int size = listFindAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(listFindAccessibilityNodeInfosByText.get(i2).unwrap());
                    }
                    return arrayList;
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public boolean performAction(int i, int i2, android.os.Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i, i2, bundle);
                }
            });
        }
    }

    @android.support.annotation.RequiresApi(19)
    private static class AccessibilityNodeProviderKitKatImpl extends android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderKitKatImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl, android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public java.lang.Object newAccessibilityNodeProviderBridge(final android.support.v4.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge() { // from class: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl.1
                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public java.lang.Object createAccessibilityNodeInfo(int i) {
                    android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateAccessibilityNodeInfo = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i);
                    if (accessibilityNodeInfoCompatCreateAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return accessibilityNodeInfoCompatCreateAccessibilityNodeInfo.unwrap();
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public java.util.List<java.lang.Object> findAccessibilityNodeInfosByText(java.lang.String str, int i) {
                    java.util.List<android.support.v4.view.accessibility.AccessibilityNodeInfoCompat> listFindAccessibilityNodeInfosByText = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i);
                    if (listFindAccessibilityNodeInfosByText == null) {
                        return null;
                    }
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    int size = listFindAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(listFindAccessibilityNodeInfosByText.get(i2).unwrap());
                    }
                    return arrayList;
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public java.lang.Object findFocus(int i) {
                    android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompatFindFocus = accessibilityNodeProviderCompat.findFocus(i);
                    if (accessibilityNodeInfoCompatFindFocus == null) {
                        return null;
                    }
                    return accessibilityNodeInfoCompatFindFocus.unwrap();
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public boolean performAction(int i, int i2, android.os.Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i, i2, bundle);
                }
            });
        }
    }

    static class AccessibilityNodeProviderStubImpl implements android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl {
        AccessibilityNodeProviderStubImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public java.lang.Object newAccessibilityNodeProviderBridge(android.support.v4.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return null;
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl();
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl();
        } else {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl();
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
    }

    public AccessibilityNodeProviderCompat(java.lang.Object obj) {
        this.mProvider = obj;
    }

    @android.support.annotation.Nullable
    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return null;
    }

    @android.support.annotation.Nullable
    public java.util.List<android.support.v4.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(java.lang.String str, int i) {
        return null;
    }

    @android.support.annotation.Nullable
    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat findFocus(int i) {
        return null;
    }

    public java.lang.Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int i, int i2, android.os.Bundle bundle) {
        return false;
    }
}
