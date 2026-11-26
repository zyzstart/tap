package android.support.v4.view.accessibility;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final java.lang.String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final java.lang.String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final java.lang.String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final java.lang.String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final java.lang.String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final java.lang.String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final java.lang.String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final java.lang.String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final java.lang.String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl IMPL;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private final android.view.accessibility.AccessibilityNodeInfo mInfo;

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public int mParentVirtualDescendantId = -1;

    public static class AccessibilityActionCompat {
        final java.lang.Object mAction;
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_FOCUS = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(1, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_FOCUS = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(2, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SELECT = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(4, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_SELECTION = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(8, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLICK = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_LONG_CLICK = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(64, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(128, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(256, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(512, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(1024, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(2048, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_FORWARD = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(4096, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(8192, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_COPY = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PASTE = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CUT = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_SELECTION = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_EXPAND = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_COLLAPSE = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_DISMISS = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_TEXT = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, null);
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SHOW_ON_SCREEN = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getActionShowOnScreen());
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_TO_POSITION = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getActionScrollToPosition());
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_UP = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getActionScrollUp());
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_LEFT = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getActionScrollLeft());
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_DOWN = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getActionScrollDown());
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_RIGHT = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getActionScrollRight());
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CONTEXT_CLICK = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getActionContextClick());
        public static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_PROGRESS = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getActionSetProgress());

        public AccessibilityActionCompat(int i, java.lang.CharSequence charSequence) {
            this(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.newAccessibilityAction(i, charSequence));
        }

        AccessibilityActionCompat(java.lang.Object obj) {
            this.mAction = obj;
        }

        public int getId() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionId(this.mAction);
        }

        public java.lang.CharSequence getLabel() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionLabel(this.mAction);
        }
    }

    @android.support.annotation.RequiresApi(16)
    static class AccessibilityNodeInfoApi16Impl extends android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl {
        AccessibilityNodeInfoApi16Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void addChild(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
            accessibilityNodeInfo.addChild(view, i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object findFocus(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            return accessibilityNodeInfo.findFocus(i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object focusSearch(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            return accessibilityNodeInfo.focusSearch(i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getMovementGranularities(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMovementGranularities();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isAccessibilityFocused(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityFocused();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isVisibleToUser(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isVisibleToUser();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public android.view.accessibility.AccessibilityNodeInfo obtain(android.view.View view, int i) {
            return android.view.accessibility.AccessibilityNodeInfo.obtain(view, i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean performAction(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i, android.os.Bundle bundle) {
            return accessibilityNodeInfo.performAction(i, bundle);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setAccessibilityFocused(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setAccessibilityFocused(z);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setMovementGranularities(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            accessibilityNodeInfo.setMovementGranularities(i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setParent(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
            accessibilityNodeInfo.setParent(view, i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setSource(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
            accessibilityNodeInfo.setSource(view, i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setVisibleToUser(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setVisibleToUser(z);
        }
    }

    @android.support.annotation.RequiresApi(17)
    static class AccessibilityNodeInfoApi17Impl extends android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi16Impl {
        AccessibilityNodeInfoApi17Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getLabelFor(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getLabelFor();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getLabeledBy(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getLabeledBy();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setLabelFor(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view) {
            accessibilityNodeInfo.setLabelFor(view);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setLabelFor(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
            accessibilityNodeInfo.setLabelFor(view, i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setLabeledBy(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view) {
            accessibilityNodeInfo.setLabeledBy(view);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setLabeledBy(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
            accessibilityNodeInfo.setLabeledBy(view, i);
        }
    }

    @android.support.annotation.RequiresApi(18)
    static class AccessibilityNodeInfoApi18Impl extends android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi17Impl {
        AccessibilityNodeInfoApi18Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.util.List<android.view.accessibility.AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.String str) {
            return accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getTextSelectionEnd(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getTextSelectionEnd();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getTextSelectionStart(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getTextSelectionStart();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.String getViewIdResourceName(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getViewIdResourceName();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isEditable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isEditable();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean refresh(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.refresh();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setEditable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setEditable(z);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setTextSelection(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
            accessibilityNodeInfo.setTextSelection(i, i2);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setViewIdResourceName(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.String str) {
            accessibilityNodeInfo.setViewIdResourceName(str);
        }
    }

    @android.support.annotation.RequiresApi(19)
    static class AccessibilityNodeInfoApi19Impl extends android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi18Impl {
        private static final java.lang.String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";

        AccessibilityNodeInfoApi19Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean canOpenPopup(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.canOpenPopup();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getCollectionInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getCollectionInfo();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getCollectionInfoColumnCount(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) obj).getColumnCount();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getCollectionInfoRowCount(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) obj).getRowCount();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getCollectionItemColumnIndex(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnIndex();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getCollectionItemColumnSpan(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnSpan();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getCollectionItemInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getCollectionItemInfo();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getCollectionItemRowIndex(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).getRowIndex();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getCollectionItemRowSpan(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).getRowSpan();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public android.os.Bundle getExtras(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtras();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getInputType(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getInputType();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getLiveRegion(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getLiveRegion();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getRangeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getRangeInfo();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.CharSequence getRoleDescription(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return getExtras(accessibilityNodeInfo).getCharSequence(ROLE_DESCRIPTION_KEY);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isCollectionInfoHierarchical(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) obj).isHierarchical();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isCollectionItemHeading(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).isHeading();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isContentInvalid(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isContentInvalid();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isDismissable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isDismissable();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isMultiLine(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isMultiLine();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object obtainCollectionInfo(int i, int i2, boolean z) {
            return android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z) {
            return android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object obtainRangeInfo(int i, float f, float f2, float f3) {
            return android.view.accessibility.AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setCanOpenPopup(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setCanOpenPopup(z);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setCollectionInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.Object obj) {
            accessibilityNodeInfo.setCollectionInfo((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setCollectionItemInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.Object obj) {
            accessibilityNodeInfo.setCollectionItemInfo((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setContentInvalid(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setContentInvalid(z);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setDismissable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setDismissable(z);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setInputType(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            accessibilityNodeInfo.setInputType(i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setLiveRegion(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            accessibilityNodeInfo.setLiveRegion(i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setMultiLine(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setMultiLine(z);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setRangeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.Object obj) {
            accessibilityNodeInfo.setRangeInfo((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setRoleDescription(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.CharSequence charSequence) {
            getExtras(accessibilityNodeInfo).putCharSequence(ROLE_DESCRIPTION_KEY, charSequence);
        }
    }

    @android.support.annotation.RequiresApi(21)
    static class AccessibilityNodeInfoApi21Impl extends android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi19Impl {
        AccessibilityNodeInfoApi21Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void addAction(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.Object obj) {
            accessibilityNodeInfo.addAction((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getAccessibilityActionId(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) obj).getId();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.CharSequence getAccessibilityActionLabel(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) obj).getLabel();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.util.List<java.lang.Object> getActionList(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getActionList();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getCollectionInfoSelectionMode(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) obj).getSelectionMode();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.CharSequence getError(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getError();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getMaxTextLength(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMaxTextLength();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getWindow(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getWindow();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isCollectionItemSelected(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).isSelected();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object newAccessibilityAction(int i, java.lang.CharSequence charSequence) {
            return new android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi19Impl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi19Impl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean removeAction(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.Object obj) {
            return accessibilityNodeInfo.removeAction((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean removeChild(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view) {
            return accessibilityNodeInfo.removeChild(view);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean removeChild(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
            return accessibilityNodeInfo.removeChild(view, i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setError(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.CharSequence charSequence) {
            accessibilityNodeInfo.setError(charSequence);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setMaxTextLength(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            accessibilityNodeInfo.setMaxTextLength(i);
        }
    }

    @android.support.annotation.RequiresApi(22)
    static class AccessibilityNodeInfoApi22Impl extends android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl {
        AccessibilityNodeInfoApi22Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getTraversalAfter(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getTraversalAfter();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getTraversalBefore(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getTraversalBefore();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setTraversalAfter(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view) {
            accessibilityNodeInfo.setTraversalAfter(view);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setTraversalAfter(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
            accessibilityNodeInfo.setTraversalAfter(view, i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setTraversalBefore(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view) {
            accessibilityNodeInfo.setTraversalBefore(view);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setTraversalBefore(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
            accessibilityNodeInfo.setTraversalBefore(view, i);
        }
    }

    @android.support.annotation.RequiresApi(23)
    static class AccessibilityNodeInfoApi23Impl extends android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi22Impl {
        AccessibilityNodeInfoApi23Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getActionContextClick() {
            return android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getActionScrollDown() {
            return android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getActionScrollLeft() {
            return android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getActionScrollRight() {
            return android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getActionScrollToPosition() {
            return android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getActionScrollUp() {
            return android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getActionShowOnScreen() {
            return android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isContextClickable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isContextClickable();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setContextClickable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setContextClickable(z);
        }
    }

    @android.support.annotation.RequiresApi(24)
    static class AccessibilityNodeInfoApi24Impl extends android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi23Impl {
        AccessibilityNodeInfoApi24Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public java.lang.Object getActionSetProgress() {
            return android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public int getDrawingOrder(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getDrawingOrder();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public boolean isImportantForAccessibility(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isImportantForAccessibility();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setDrawingOrder(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            accessibilityNodeInfo.setDrawingOrder(i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl
        public void setImportantForAccessibility(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setImportantForAccessibility(z);
        }
    }

    static class AccessibilityNodeInfoBaseImpl {
        AccessibilityNodeInfoBaseImpl() {
        }

        public void addAction(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.Object obj) {
        }

        public void addChild(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
        }

        public boolean canOpenPopup(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return false;
        }

        public java.util.List<android.view.accessibility.AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.String str) {
            return java.util.Collections.emptyList();
        }

        public java.lang.Object findFocus(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            return null;
        }

        public java.lang.Object focusSearch(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            return null;
        }

        public int getAccessibilityActionId(java.lang.Object obj) {
            return 0;
        }

        public java.lang.CharSequence getAccessibilityActionLabel(java.lang.Object obj) {
            return null;
        }

        public java.lang.Object getActionContextClick() {
            return null;
        }

        public java.util.List<java.lang.Object> getActionList(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public java.lang.Object getActionScrollDown() {
            return null;
        }

        public java.lang.Object getActionScrollLeft() {
            return null;
        }

        public java.lang.Object getActionScrollRight() {
            return null;
        }

        public java.lang.Object getActionScrollToPosition() {
            return null;
        }

        public java.lang.Object getActionScrollUp() {
            return null;
        }

        public java.lang.Object getActionSetProgress() {
            return null;
        }

        public java.lang.Object getActionShowOnScreen() {
            return null;
        }

        public java.lang.Object getCollectionInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public int getCollectionInfoColumnCount(java.lang.Object obj) {
            return 0;
        }

        public int getCollectionInfoRowCount(java.lang.Object obj) {
            return 0;
        }

        public int getCollectionInfoSelectionMode(java.lang.Object obj) {
            return 0;
        }

        public int getCollectionItemColumnIndex(java.lang.Object obj) {
            return 0;
        }

        public int getCollectionItemColumnSpan(java.lang.Object obj) {
            return 0;
        }

        public java.lang.Object getCollectionItemInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public int getCollectionItemRowIndex(java.lang.Object obj) {
            return 0;
        }

        public int getCollectionItemRowSpan(java.lang.Object obj) {
            return 0;
        }

        public int getDrawingOrder(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return 0;
        }

        public java.lang.CharSequence getError(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public android.os.Bundle getExtras(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return new android.os.Bundle();
        }

        public int getInputType(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return 0;
        }

        public java.lang.Object getLabelFor(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public java.lang.Object getLabeledBy(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public int getLiveRegion(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return 0;
        }

        public int getMaxTextLength(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return -1;
        }

        public int getMovementGranularities(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return 0;
        }

        public java.lang.Object getRangeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public java.lang.CharSequence getRoleDescription(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public int getTextSelectionEnd(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return -1;
        }

        public int getTextSelectionStart(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return -1;
        }

        public java.lang.Object getTraversalAfter(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public java.lang.Object getTraversalBefore(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public java.lang.String getViewIdResourceName(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public java.lang.Object getWindow(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public boolean isAccessibilityFocused(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return false;
        }

        public boolean isCollectionInfoHierarchical(java.lang.Object obj) {
            return false;
        }

        public boolean isCollectionItemHeading(java.lang.Object obj) {
            return false;
        }

        public boolean isCollectionItemSelected(java.lang.Object obj) {
            return false;
        }

        public boolean isContentInvalid(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return false;
        }

        public boolean isContextClickable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return false;
        }

        public boolean isDismissable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return false;
        }

        public boolean isEditable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return false;
        }

        public boolean isImportantForAccessibility(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return true;
        }

        public boolean isMultiLine(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return false;
        }

        public boolean isVisibleToUser(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return false;
        }

        public java.lang.Object newAccessibilityAction(int i, java.lang.CharSequence charSequence) {
            return null;
        }

        public android.view.accessibility.AccessibilityNodeInfo obtain(android.view.View view, int i) {
            return null;
        }

        public java.lang.Object obtainCollectionInfo(int i, int i2, boolean z) {
            return null;
        }

        public java.lang.Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return null;
        }

        public java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z) {
            return null;
        }

        public java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public java.lang.Object obtainRangeInfo(int i, float f, float f2, float f3) {
            return null;
        }

        public boolean performAction(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i, android.os.Bundle bundle) {
            return false;
        }

        public boolean refresh(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            return false;
        }

        public boolean removeAction(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.Object obj) {
            return false;
        }

        public boolean removeChild(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view) {
            return false;
        }

        public boolean removeChild(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
            return false;
        }

        public void setAccessibilityFocused(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        }

        public void setCanOpenPopup(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        }

        public void setCollectionInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.Object obj) {
        }

        public void setCollectionItemInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.Object obj) {
        }

        public void setContentInvalid(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        }

        public void setContextClickable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        }

        public void setDismissable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        }

        public void setDrawingOrder(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        }

        public void setEditable(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        }

        public void setError(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.CharSequence charSequence) {
        }

        public void setImportantForAccessibility(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        }

        public void setInputType(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        }

        public void setLabelFor(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view) {
        }

        public void setLabelFor(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
        }

        public void setLabeledBy(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view) {
        }

        public void setLabeledBy(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
        }

        public void setLiveRegion(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        }

        public void setMaxTextLength(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        }

        public void setMovementGranularities(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        }

        public void setMultiLine(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        }

        public void setParent(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
        }

        public void setRangeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.Object obj) {
        }

        public void setRoleDescription(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.CharSequence charSequence) {
        }

        public void setSource(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
        }

        public void setTextSelection(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
        }

        public void setTraversalAfter(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view) {
        }

        public void setTraversalAfter(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
        }

        public void setTraversalBefore(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view) {
        }

        public void setTraversalBefore(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, android.view.View view, int i) {
        }

        public void setViewIdResourceName(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.String str) {
        }

        public void setVisibleToUser(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final java.lang.Object mInfo;

        CollectionInfoCompat(java.lang.Object obj) {
            this.mInfo = obj;
        }

        public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat obtain(int i, int i2, boolean z) {
            return new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(i, i2, z));
        }

        public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat obtain(int i, int i2, boolean z, int i3) {
            return new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(i, i2, z, i3));
        }

        public int getColumnCount() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(this.mInfo);
        }

        public int getRowCount() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(this.mInfo);
        }

        public int getSelectionMode() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionInfoSelectionMode(this.mInfo);
        }

        public boolean isHierarchical() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(this.mInfo);
        }
    }

    public static class CollectionItemInfoCompat {
        final java.lang.Object mInfo;

        CollectionItemInfoCompat(java.lang.Object obj) {
            this.mInfo = obj;
        }

        public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z) {
            return new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(i, i2, i3, i4, z));
        }

        public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(i, i2, i3, i4, z, z2));
        }

        public int getColumnIndex() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(this.mInfo);
        }

        public int getColumnSpan() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(this.mInfo);
        }

        public int getRowIndex() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(this.mInfo);
        }

        public int getRowSpan() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(this.mInfo);
        }

        public boolean isHeading() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(this.mInfo);
        }

        public boolean isSelected() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(this.mInfo);
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final java.lang.Object mInfo;

        RangeInfoCompat(java.lang.Object obj) {
            this.mInfo = obj;
        }

        public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat obtain(int i, float f, float f2, float f3) {
            return new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtainRangeInfo(i, f, f2, f3));
        }

        public float getCurrent() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.RangeInfo.getCurrent(this.mInfo);
        }

        public float getMax() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.RangeInfo.getMax(this.mInfo);
        }

        public float getMin() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.RangeInfo.getMin(this.mInfo);
        }

        public int getType() {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.RangeInfo.getType(this.mInfo);
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi24Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi23Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi22Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi19Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi18Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi17Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi16Impl();
        } else {
            IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoBaseImpl();
        }
    }

    private AccessibilityNodeInfoCompat(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mInfo = accessibilityNodeInfo;
    }

    @java.lang.Deprecated
    public AccessibilityNodeInfoCompat(java.lang.Object obj) {
        this.mInfo = (android.view.accessibility.AccessibilityNodeInfo) obj;
    }

    private static java.lang.String getActionSymbolicName(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat obtain() {
        return wrap(android.view.accessibility.AccessibilityNodeInfo.obtain());
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat obtain(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrap(android.view.accessibility.AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.mInfo));
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat obtain(android.view.View view) {
        return wrap(android.view.accessibility.AccessibilityNodeInfo.obtain(view));
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat obtain(android.view.View view, int i) {
        return wrapNonNullInstance(IMPL.obtain(view, i));
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat wrap(@android.support.annotation.NonNull android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        return new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat wrapNonNullInstance(java.lang.Object obj) {
        if (obj != null) {
            return new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public void addAction(int i) {
        this.mInfo.addAction(i);
    }

    public void addAction(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        IMPL.addAction(this.mInfo, accessibilityActionCompat.mAction);
    }

    public void addChild(android.view.View view) {
        this.mInfo.addChild(view);
    }

    public void addChild(android.view.View view, int i) {
        IMPL.addChild(this.mInfo, view, i);
    }

    public boolean canOpenPopup() {
        return IMPL.canOpenPopup(this.mInfo);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (android.support.v4.view.accessibility.AccessibilityNodeInfoCompat) obj;
        android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.mInfo)) {
            return false;
        }
        return true;
    }

    public java.util.List<android.support.v4.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<android.view.accessibility.AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = this.mInfo.findAccessibilityNodeInfosByText(str);
        int size = listFindAccessibilityNodeInfosByText.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(wrap(listFindAccessibilityNodeInfosByText.get(i)));
        }
        return arrayList;
    }

    public java.util.List<android.support.v4.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(java.lang.String str) {
        java.util.List<android.view.accessibility.AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = IMPL.findAccessibilityNodeInfosByViewId(this.mInfo, str);
        if (listFindAccessibilityNodeInfosByViewId == null) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<android.view.accessibility.AccessibilityNodeInfo> it = listFindAccessibilityNodeInfosByViewId.iterator();
        while (it.hasNext()) {
            arrayList.add(wrap(it.next()));
        }
        return arrayList;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat findFocus(int i) {
        return wrapNonNullInstance(IMPL.findFocus(this.mInfo, i));
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat focusSearch(int i) {
        return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, i));
    }

    public java.util.List<android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList() {
        java.util.List<java.lang.Object> actionList = IMPL.getActionList(this.mInfo);
        if (actionList == null) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionList.get(i)));
        }
        return arrayList;
    }

    public int getActions() {
        return this.mInfo.getActions();
    }

    public void getBoundsInParent(android.graphics.Rect rect) {
        this.mInfo.getBoundsInParent(rect);
    }

    public void getBoundsInScreen(android.graphics.Rect rect) {
        this.mInfo.getBoundsInScreen(rect);
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getChild(int i) {
        return wrapNonNullInstance(this.mInfo.getChild(i));
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public java.lang.CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat getCollectionInfo() {
        java.lang.Object collectionInfo = IMPL.getCollectionInfo(this.mInfo);
        if (collectionInfo == null) {
            return null;
        }
        return new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat(collectionInfo);
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat getCollectionItemInfo() {
        java.lang.Object collectionItemInfo = IMPL.getCollectionItemInfo(this.mInfo);
        if (collectionItemInfo == null) {
            return null;
        }
        return new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat(collectionItemInfo);
    }

    public java.lang.CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        return IMPL.getDrawingOrder(this.mInfo);
    }

    public java.lang.CharSequence getError() {
        return IMPL.getError(this.mInfo);
    }

    public android.os.Bundle getExtras() {
        return IMPL.getExtras(this.mInfo);
    }

    @java.lang.Deprecated
    public java.lang.Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return IMPL.getInputType(this.mInfo);
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(IMPL.getLabelFor(this.mInfo));
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(IMPL.getLabeledBy(this.mInfo));
    }

    public int getLiveRegion() {
        return IMPL.getLiveRegion(this.mInfo);
    }

    public int getMaxTextLength() {
        return IMPL.getMaxTextLength(this.mInfo);
    }

    public int getMovementGranularities() {
        return IMPL.getMovementGranularities(this.mInfo);
    }

    public java.lang.CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat getRangeInfo() {
        java.lang.Object rangeInfo = IMPL.getRangeInfo(this.mInfo);
        if (rangeInfo == null) {
            return null;
        }
        return new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat(rangeInfo);
    }

    @android.support.annotation.Nullable
    public java.lang.CharSequence getRoleDescription() {
        return IMPL.getRoleDescription(this.mInfo);
    }

    public java.lang.CharSequence getText() {
        return this.mInfo.getText();
    }

    public int getTextSelectionEnd() {
        return IMPL.getTextSelectionEnd(this.mInfo);
    }

    public int getTextSelectionStart() {
        return IMPL.getTextSelectionStart(this.mInfo);
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getTraversalAfter() {
        return wrapNonNullInstance(IMPL.getTraversalAfter(this.mInfo));
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getTraversalBefore() {
        return wrapNonNullInstance(IMPL.getTraversalBefore(this.mInfo));
    }

    public java.lang.String getViewIdResourceName() {
        return IMPL.getViewIdResourceName(this.mInfo);
    }

    public android.support.v4.view.accessibility.AccessibilityWindowInfoCompat getWindow() {
        return android.support.v4.view.accessibility.AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getWindow(this.mInfo));
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    public int hashCode() {
        android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return IMPL.isAccessibilityFocused(this.mInfo);
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        return IMPL.isContentInvalid(this.mInfo);
    }

    public boolean isContextClickable() {
        return IMPL.isContextClickable(this.mInfo);
    }

    public boolean isDismissable() {
        return IMPL.isDismissable(this.mInfo);
    }

    public boolean isEditable() {
        return IMPL.isEditable(this.mInfo);
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isImportantForAccessibility() {
        return IMPL.isImportantForAccessibility(this.mInfo);
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return IMPL.isMultiLine(this.mInfo);
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isVisibleToUser() {
        return IMPL.isVisibleToUser(this.mInfo);
    }

    public boolean performAction(int i) {
        return this.mInfo.performAction(i);
    }

    public boolean performAction(int i, android.os.Bundle bundle) {
        return IMPL.performAction(this.mInfo, i, bundle);
    }

    public void recycle() {
        this.mInfo.recycle();
    }

    public boolean refresh() {
        return IMPL.refresh(this.mInfo);
    }

    public boolean removeAction(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        return IMPL.removeAction(this.mInfo, accessibilityActionCompat.mAction);
    }

    public boolean removeChild(android.view.View view) {
        return IMPL.removeChild(this.mInfo, view);
    }

    public boolean removeChild(android.view.View view, int i) {
        return IMPL.removeChild(this.mInfo, view, i);
    }

    public void setAccessibilityFocused(boolean z) {
        IMPL.setAccessibilityFocused(this.mInfo, z);
    }

    public void setBoundsInParent(android.graphics.Rect rect) {
        this.mInfo.setBoundsInParent(rect);
    }

    public void setBoundsInScreen(android.graphics.Rect rect) {
        this.mInfo.setBoundsInScreen(rect);
    }

    public void setCanOpenPopup(boolean z) {
        IMPL.setCanOpenPopup(this.mInfo, z);
    }

    public void setCheckable(boolean z) {
        this.mInfo.setCheckable(z);
    }

    public void setChecked(boolean z) {
        this.mInfo.setChecked(z);
    }

    public void setClassName(java.lang.CharSequence charSequence) {
        this.mInfo.setClassName(charSequence);
    }

    public void setClickable(boolean z) {
        this.mInfo.setClickable(z);
    }

    public void setCollectionInfo(java.lang.Object obj) {
        IMPL.setCollectionInfo(this.mInfo, ((android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat) obj).mInfo);
    }

    public void setCollectionItemInfo(java.lang.Object obj) {
        IMPL.setCollectionItemInfo(this.mInfo, ((android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat) obj).mInfo);
    }

    public void setContentDescription(java.lang.CharSequence charSequence) {
        this.mInfo.setContentDescription(charSequence);
    }

    public void setContentInvalid(boolean z) {
        IMPL.setContentInvalid(this.mInfo, z);
    }

    public void setContextClickable(boolean z) {
        IMPL.setContextClickable(this.mInfo, z);
    }

    public void setDismissable(boolean z) {
        IMPL.setDismissable(this.mInfo, z);
    }

    public void setDrawingOrder(int i) {
        IMPL.setDrawingOrder(this.mInfo, i);
    }

    public void setEditable(boolean z) {
        IMPL.setEditable(this.mInfo, z);
    }

    public void setEnabled(boolean z) {
        this.mInfo.setEnabled(z);
    }

    public void setError(java.lang.CharSequence charSequence) {
        IMPL.setError(this.mInfo, charSequence);
    }

    public void setFocusable(boolean z) {
        this.mInfo.setFocusable(z);
    }

    public void setFocused(boolean z) {
        this.mInfo.setFocused(z);
    }

    public void setImportantForAccessibility(boolean z) {
        IMPL.setImportantForAccessibility(this.mInfo, z);
    }

    public void setInputType(int i) {
        IMPL.setInputType(this.mInfo, i);
    }

    public void setLabelFor(android.view.View view) {
        IMPL.setLabelFor(this.mInfo, view);
    }

    public void setLabelFor(android.view.View view, int i) {
        IMPL.setLabelFor(this.mInfo, view, i);
    }

    public void setLabeledBy(android.view.View view) {
        IMPL.setLabeledBy(this.mInfo, view);
    }

    public void setLabeledBy(android.view.View view, int i) {
        IMPL.setLabeledBy(this.mInfo, view, i);
    }

    public void setLiveRegion(int i) {
        IMPL.setLiveRegion(this.mInfo, i);
    }

    public void setLongClickable(boolean z) {
        this.mInfo.setLongClickable(z);
    }

    public void setMaxTextLength(int i) {
        IMPL.setMaxTextLength(this.mInfo, i);
    }

    public void setMovementGranularities(int i) {
        IMPL.setMovementGranularities(this.mInfo, i);
    }

    public void setMultiLine(boolean z) {
        IMPL.setMultiLine(this.mInfo, z);
    }

    public void setPackageName(java.lang.CharSequence charSequence) {
        this.mInfo.setPackageName(charSequence);
    }

    public void setParent(android.view.View view) {
        this.mInfo.setParent(view);
    }

    public void setParent(android.view.View view, int i) {
        this.mParentVirtualDescendantId = i;
        IMPL.setParent(this.mInfo, view, i);
    }

    public void setPassword(boolean z) {
        this.mInfo.setPassword(z);
    }

    public void setRangeInfo(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat rangeInfoCompat) {
        IMPL.setRangeInfo(this.mInfo, rangeInfoCompat.mInfo);
    }

    public void setRoleDescription(@android.support.annotation.Nullable java.lang.CharSequence charSequence) {
        IMPL.setRoleDescription(this.mInfo, charSequence);
    }

    public void setScrollable(boolean z) {
        this.mInfo.setScrollable(z);
    }

    public void setSelected(boolean z) {
        this.mInfo.setSelected(z);
    }

    public void setSource(android.view.View view) {
        this.mInfo.setSource(view);
    }

    public void setSource(android.view.View view, int i) {
        IMPL.setSource(this.mInfo, view, i);
    }

    public void setText(java.lang.CharSequence charSequence) {
        this.mInfo.setText(charSequence);
    }

    public void setTextSelection(int i, int i2) {
        IMPL.setTextSelection(this.mInfo, i, i2);
    }

    public void setTraversalAfter(android.view.View view) {
        IMPL.setTraversalAfter(this.mInfo, view);
    }

    public void setTraversalAfter(android.view.View view, int i) {
        IMPL.setTraversalAfter(this.mInfo, view, i);
    }

    public void setTraversalBefore(android.view.View view) {
        IMPL.setTraversalBefore(this.mInfo, view);
    }

    public void setTraversalBefore(android.view.View view, int i) {
        IMPL.setTraversalBefore(this.mInfo, view, i);
    }

    public void setViewIdResourceName(java.lang.String str) {
        IMPL.setViewIdResourceName(this.mInfo, str);
    }

    public void setVisibleToUser(boolean z) {
        IMPL.setVisibleToUser(this.mInfo, z);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(super.toString());
        android.graphics.Rect rect = new android.graphics.Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(getPackageName());
        sb.append("; className: ");
        sb.append(getClassName());
        sb.append("; text: ");
        sb.append(getText());
        sb.append("; contentDescription: ");
        sb.append(getContentDescription());
        sb.append("; viewId: ");
        sb.append(getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(isCheckable());
        sb.append("; checked: ");
        sb.append(isChecked());
        sb.append("; focusable: ");
        sb.append(isFocusable());
        sb.append("; focused: ");
        sb.append(isFocused());
        sb.append("; selected: ");
        sb.append(isSelected());
        sb.append("; clickable: ");
        sb.append(isClickable());
        sb.append("; longClickable: ");
        sb.append(isLongClickable());
        sb.append("; enabled: ");
        sb.append(isEnabled());
        sb.append("[REDACTED]");
        sb.append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; [");
        int actions = getActions();
        while (actions != 0) {
            int iNumberOfTrailingZeros = 1 << java.lang.Integer.numberOfTrailingZeros(actions);
            actions &= iNumberOfTrailingZeros ^ (-1);
            sb.append(getActionSymbolicName(iNumberOfTrailingZeros));
            if (actions != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public android.view.accessibility.AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }
}
