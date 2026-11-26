package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    static final android.support.v4.view.ViewCompat.ViewCompatBaseImpl IMPL;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;

    @java.lang.Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;

    @java.lang.Deprecated
    public static final int LAYER_TYPE_NONE = 0;

    @java.lang.Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;

    @java.lang.Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;

    @java.lang.Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;

    @java.lang.Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;

    @java.lang.Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;

    @java.lang.Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;

    @java.lang.Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;

    @java.lang.Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final java.lang.String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface AccessibilityLiveRegion {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FocusDirection {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FocusRealDirection {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FocusRelativeDirection {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface ImportantForAccessibility {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface LayerType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface LayoutDirectionMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface NestedScrollType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface OverScroll {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    private @interface ResolvedLayoutDirectionMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ScrollAxis {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ScrollIndicators {
    }

    @android.support.annotation.RequiresApi(15)
    static class ViewCompatApi15Impl extends android.support.v4.view.ViewCompat.ViewCompatBaseImpl {
        ViewCompatApi15Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean hasOnClickListeners(android.view.View view) {
            return view.hasOnClickListeners();
        }
    }

    @android.support.annotation.RequiresApi(16)
    static class ViewCompatApi16Impl extends android.support.v4.view.ViewCompat.ViewCompatApi15Impl {
        ViewCompatApi16Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public android.support.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View view) {
            android.view.accessibility.AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
            if (accessibilityNodeProvider != null) {
                return new android.support.v4.view.accessibility.AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean getFitsSystemWindows(android.view.View view) {
            return view.getFitsSystemWindows();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getImportantForAccessibility(android.view.View view) {
            return view.getImportantForAccessibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getMinimumHeight(android.view.View view) {
            return view.getMinimumHeight();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getMinimumWidth(android.view.View view) {
            return view.getMinimumWidth();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public android.view.ViewParent getParentForAccessibility(android.view.View view) {
            return view.getParentForAccessibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean hasOverlappingRendering(android.view.View view) {
            return view.hasOverlappingRendering();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean hasTransientState(android.view.View view) {
            return view.hasTransientState();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
            return view.performAccessibilityAction(i, bundle);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void postInvalidateOnAnimation(android.view.View view) {
            view.postInvalidateOnAnimation();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void postInvalidateOnAnimation(android.view.View view, int i, int i2, int i3, int i4) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void postOnAnimation(android.view.View view, java.lang.Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void postOnAnimationDelayed(android.view.View view, java.lang.Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void requestApplyInsets(android.view.View view) {
            view.requestFitSystemWindows();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setBackground(android.view.View view, android.graphics.drawable.Drawable drawable) {
            view.setBackground(drawable);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setHasTransientState(android.view.View view, boolean z) {
            view.setHasTransientState(z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setImportantForAccessibility(android.view.View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }
    }

    @android.support.annotation.RequiresApi(17)
    static class ViewCompatApi17Impl extends android.support.v4.view.ViewCompat.ViewCompatApi16Impl {
        ViewCompatApi17Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public android.view.Display getDisplay(android.view.View view) {
            return view.getDisplay();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getLabelFor(android.view.View view) {
            return view.getLabelFor();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getLayoutDirection(android.view.View view) {
            return view.getLayoutDirection();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getPaddingEnd(android.view.View view) {
            return view.getPaddingEnd();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getPaddingStart(android.view.View view) {
            return view.getPaddingStart();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getWindowSystemUiVisibility(android.view.View view) {
            return view.getWindowSystemUiVisibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isPaddingRelative(android.view.View view) {
            return view.isPaddingRelative();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setLabelFor(android.view.View view, int i) {
            view.setLabelFor(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setLayerPaint(android.view.View view, android.graphics.Paint paint) {
            view.setLayerPaint(paint);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setLayoutDirection(android.view.View view, int i) {
            view.setLayoutDirection(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setPaddingRelative(android.view.View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }
    }

    @android.support.annotation.RequiresApi(18)
    static class ViewCompatApi18Impl extends android.support.v4.view.ViewCompat.ViewCompatApi17Impl {
        ViewCompatApi18Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public android.graphics.Rect getClipBounds(android.view.View view) {
            return view.getClipBounds();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isInLayout(android.view.View view) {
            return view.isInLayout();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setClipBounds(android.view.View view, android.graphics.Rect rect) {
            view.setClipBounds(rect);
        }
    }

    @android.support.annotation.RequiresApi(19)
    static class ViewCompatApi19Impl extends android.support.v4.view.ViewCompat.ViewCompatApi18Impl {
        ViewCompatApi19Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getAccessibilityLiveRegion(android.view.View view) {
            return view.getAccessibilityLiveRegion();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isAttachedToWindow(android.view.View view) {
            return view.isAttachedToWindow();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isLaidOut(android.view.View view) {
            return view.isLaidOut();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isLayoutDirectionResolved(android.view.View view) {
            return view.isLayoutDirectionResolved();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setAccessibilityLiveRegion(android.view.View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi16Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setImportantForAccessibility(android.view.View view, int i) {
            view.setImportantForAccessibility(i);
        }
    }

    @android.support.annotation.RequiresApi(21)
    static class ViewCompatApi21Impl extends android.support.v4.view.ViewCompat.ViewCompatApi19Impl {
        private static java.lang.ThreadLocal<android.graphics.Rect> sThreadLocalRect;

        ViewCompatApi21Impl() {
        }

        private static android.graphics.Rect getEmptyTempRect() {
            if (sThreadLocalRect == null) {
                sThreadLocalRect = new java.lang.ThreadLocal<>();
            }
            android.graphics.Rect rect = sThreadLocalRect.get();
            if (rect == null) {
                rect = new android.graphics.Rect();
                sThreadLocalRect.set(rect);
            }
            rect.setEmpty();
            return rect;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public android.support.v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View view, android.support.v4.view.WindowInsetsCompat windowInsetsCompat) {
            android.view.WindowInsets windowInsets = (android.view.WindowInsets) android.support.v4.view.WindowInsetsCompat.unwrap(windowInsetsCompat);
            android.view.WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (windowInsetsDispatchApplyWindowInsets != windowInsets) {
                windowInsets = new android.view.WindowInsets(windowInsetsDispatchApplyWindowInsets);
            }
            return android.support.v4.view.WindowInsetsCompat.wrap(windowInsets);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean dispatchNestedFling(android.view.View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean dispatchNestedPreFling(android.view.View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean dispatchNestedPreScroll(android.view.View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean dispatchNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public android.content.res.ColorStateList getBackgroundTintList(android.view.View view) {
            return view.getBackgroundTintList();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public android.graphics.PorterDuff.Mode getBackgroundTintMode(android.view.View view) {
            return view.getBackgroundTintMode();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public float getElevation(android.view.View view) {
            return view.getElevation();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public java.lang.String getTransitionName(android.view.View view) {
            return view.getTransitionName();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public float getTranslationZ(android.view.View view) {
            return view.getTranslationZ();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public float getZ(android.view.View view) {
            return view.getZ();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean hasNestedScrollingParent(android.view.View view) {
            return view.hasNestedScrollingParent();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isImportantForAccessibility(android.view.View view) {
            return view.isImportantForAccessibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isNestedScrollingEnabled(android.view.View view) {
            return view.isNestedScrollingEnabled();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void offsetLeftAndRight(android.view.View view, int i) {
            boolean z;
            android.graphics.Rect emptyTempRect = getEmptyTempRect();
            java.lang.Object parent = view.getParent();
            if (parent instanceof android.view.View) {
                android.view.View view2 = (android.view.View) parent;
                emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.offsetLeftAndRight(view, i);
            if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((android.view.View) parent).invalidate(emptyTempRect);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void offsetTopAndBottom(android.view.View view, int i) {
            boolean z;
            android.graphics.Rect emptyTempRect = getEmptyTempRect();
            java.lang.Object parent = view.getParent();
            if (parent instanceof android.view.View) {
                android.view.View view2 = (android.view.View) parent;
                emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.offsetTopAndBottom(view, i);
            if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((android.view.View) parent).invalidate(emptyTempRect);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public android.support.v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, android.support.v4.view.WindowInsetsCompat windowInsetsCompat) {
            android.view.WindowInsets windowInsets = (android.view.WindowInsets) android.support.v4.view.WindowInsetsCompat.unwrap(windowInsetsCompat);
            android.view.WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (windowInsetsOnApplyWindowInsets != windowInsets) {
                windowInsets = new android.view.WindowInsets(windowInsetsOnApplyWindowInsets);
            }
            return android.support.v4.view.WindowInsetsCompat.wrap(windowInsets);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi16Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void requestApplyInsets(android.view.View view) {
            view.requestApplyInsets();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setBackgroundTintList(android.view.View view, android.content.res.ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (android.os.Build.VERSION.SDK_INT == 21) {
                android.graphics.drawable.Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setBackgroundTintMode(android.view.View view, android.graphics.PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
            if (android.os.Build.VERSION.SDK_INT == 21) {
                android.graphics.drawable.Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setElevation(android.view.View view, float f) {
            view.setElevation(f);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setNestedScrollingEnabled(android.view.View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setOnApplyWindowInsetsListener(android.view.View view, final android.support.v4.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new android.view.View.OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ViewCompat.ViewCompatApi21Impl.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public android.view.WindowInsets onApplyWindowInsets(android.view.View view2, android.view.WindowInsets windowInsets) {
                        return (android.view.WindowInsets) android.support.v4.view.WindowInsetsCompat.unwrap(onApplyWindowInsetsListener.onApplyWindowInsets(view2, android.support.v4.view.WindowInsetsCompat.wrap(windowInsets)));
                    }
                });
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setTransitionName(android.view.View view, java.lang.String str) {
            view.setTransitionName(str);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setTranslationZ(android.view.View view, float f) {
            view.setTranslationZ(f);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setZ(android.view.View view, float f) {
            view.setZ(f);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean startNestedScroll(android.view.View view, int i) {
            return view.startNestedScroll(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void stopNestedScroll(android.view.View view) {
            view.stopNestedScroll();
        }
    }

    @android.support.annotation.RequiresApi(23)
    static class ViewCompatApi23Impl extends android.support.v4.view.ViewCompat.ViewCompatApi21Impl {
        ViewCompatApi23Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getScrollIndicators(android.view.View view) {
            return view.getScrollIndicators();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi21Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void offsetLeftAndRight(android.view.View view, int i) {
            view.offsetLeftAndRight(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi21Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void offsetTopAndBottom(android.view.View view, int i) {
            view.offsetTopAndBottom(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setScrollIndicators(android.view.View view, int i) {
            view.setScrollIndicators(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setScrollIndicators(android.view.View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    @android.support.annotation.RequiresApi(24)
    static class ViewCompatApi24Impl extends android.support.v4.view.ViewCompat.ViewCompatApi23Impl {
        ViewCompatApi24Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void cancelDragAndDrop(android.view.View view) {
            view.cancelDragAndDrop();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void dispatchFinishTemporaryDetach(android.view.View view) {
            view.dispatchFinishTemporaryDetach();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void dispatchStartTemporaryDetach(android.view.View view) {
            view.dispatchStartTemporaryDetach();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setPointerIcon(android.view.View view, android.support.v4.view.PointerIconCompat pointerIconCompat) {
            view.setPointerIcon((android.view.PointerIcon) (pointerIconCompat != null ? pointerIconCompat.getPointerIcon() : null));
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean startDragAndDrop(android.view.View view, android.content.ClipData clipData, android.view.View.DragShadowBuilder dragShadowBuilder, java.lang.Object obj, int i) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void updateDragShadow(android.view.View view, android.view.View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    @android.support.annotation.RequiresApi(26)
    static class ViewCompatApi26Impl extends android.support.v4.view.ViewCompat.ViewCompatApi24Impl {
        ViewCompatApi26Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void addKeyboardNavigationClusters(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.NonNull java.util.Collection<android.view.View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getNextClusterForwardId(@android.support.annotation.NonNull android.view.View view) {
            return view.getNextClusterForwardId();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean hasExplicitFocusable(@android.support.annotation.NonNull android.view.View view) {
            return view.hasExplicitFocusable();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isFocusedByDefault(@android.support.annotation.NonNull android.view.View view) {
            return view.isFocusedByDefault();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isKeyboardNavigationCluster(@android.support.annotation.NonNull android.view.View view) {
            return view.isKeyboardNavigationCluster();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public android.view.View keyboardNavigationClusterSearch(@android.support.annotation.NonNull android.view.View view, android.view.View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean restoreDefaultFocus(@android.support.annotation.NonNull android.view.View view) {
            return view.restoreDefaultFocus();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setFocusedByDefault(@android.support.annotation.NonNull android.view.View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setKeyboardNavigationCluster(@android.support.annotation.NonNull android.view.View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setNextClusterForwardId(@android.support.annotation.NonNull android.view.View view, int i) {
            view.setNextClusterForwardId(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setTooltipText(android.view.View view, java.lang.CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class ViewCompatBaseImpl {
        static boolean sAccessibilityDelegateCheckFailed = false;
        static java.lang.reflect.Field sAccessibilityDelegateField;
        private static java.lang.reflect.Method sChildrenDrawingOrderMethod;
        private static java.lang.reflect.Field sMinHeightField;
        private static boolean sMinHeightFieldFetched;
        private static java.lang.reflect.Field sMinWidthField;
        private static boolean sMinWidthFieldFetched;
        private static java.util.WeakHashMap<android.view.View, java.lang.String> sTransitionNameMap;
        private java.lang.reflect.Method mDispatchFinishTemporaryDetach;
        private java.lang.reflect.Method mDispatchStartTemporaryDetach;
        private boolean mTempDetachBound;
        java.util.WeakHashMap<android.view.View, android.support.v4.view.ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;

        ViewCompatBaseImpl() {
        }

        private void bindTempDetach() {
            try {
                this.mDispatchStartTemporaryDetach = android.view.View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new java.lang.Class[0]);
                this.mDispatchFinishTemporaryDetach = android.view.View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new java.lang.Class[0]);
            } catch (java.lang.NoSuchMethodException e) {
                android.util.Log.e(android.support.v4.view.ViewCompat.TAG, "Couldn't find method", e);
            }
            this.mTempDetachBound = true;
        }

        private static void tickleInvalidationFlag(android.view.View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        public void addKeyboardNavigationClusters(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.NonNull java.util.Collection<android.view.View> collection, int i) {
        }

        public android.support.v4.view.ViewPropertyAnimatorCompat animate(android.view.View view) {
            if (this.mViewPropertyAnimatorCompatMap == null) {
                this.mViewPropertyAnimatorCompatMap = new java.util.WeakHashMap<>();
            }
            android.support.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mViewPropertyAnimatorCompatMap.get(view);
            if (viewPropertyAnimatorCompat != null) {
                return viewPropertyAnimatorCompat;
            }
            android.support.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new android.support.v4.view.ViewPropertyAnimatorCompat(view);
            this.mViewPropertyAnimatorCompatMap.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }

        public void cancelDragAndDrop(android.view.View view) {
        }

        public android.support.v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View view, android.support.v4.view.WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void dispatchFinishTemporaryDetach(android.view.View view) {
            if (!this.mTempDetachBound) {
                bindTempDetach();
            }
            java.lang.reflect.Method method = this.mDispatchFinishTemporaryDetach;
            if (method == null) {
                view.onFinishTemporaryDetach();
                return;
            }
            try {
                method.invoke(view, new java.lang.Object[0]);
            } catch (java.lang.Exception e) {
                android.util.Log.d(android.support.v4.view.ViewCompat.TAG, "Error calling dispatchFinishTemporaryDetach", e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean dispatchNestedFling(android.view.View view, float f, float f2, boolean z) {
            if (view instanceof android.support.v4.view.NestedScrollingChild) {
                return ((android.support.v4.view.NestedScrollingChild) view).dispatchNestedFling(f, f2, z);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean dispatchNestedPreFling(android.view.View view, float f, float f2) {
            if (view instanceof android.support.v4.view.NestedScrollingChild) {
                return ((android.support.v4.view.NestedScrollingChild) view).dispatchNestedPreFling(f, f2);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean dispatchNestedPreScroll(android.view.View view, int i, int i2, int[] iArr, int[] iArr2) {
            if (view instanceof android.support.v4.view.NestedScrollingChild) {
                return ((android.support.v4.view.NestedScrollingChild) view).dispatchNestedPreScroll(i, i2, iArr, iArr2);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean dispatchNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int[] iArr) {
            if (view instanceof android.support.v4.view.NestedScrollingChild) {
                return ((android.support.v4.view.NestedScrollingChild) view).dispatchNestedScroll(i, i2, i3, i4, iArr);
            }
            return false;
        }

        public void dispatchStartTemporaryDetach(android.view.View view) {
            if (!this.mTempDetachBound) {
                bindTempDetach();
            }
            java.lang.reflect.Method method = this.mDispatchStartTemporaryDetach;
            if (method == null) {
                view.onStartTemporaryDetach();
                return;
            }
            try {
                method.invoke(view, new java.lang.Object[0]);
            } catch (java.lang.Exception e) {
                android.util.Log.d(android.support.v4.view.ViewCompat.TAG, "Error calling dispatchStartTemporaryDetach", e);
            }
        }

        public int getAccessibilityLiveRegion(android.view.View view) {
            return 0;
        }

        public android.support.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View view) {
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public android.content.res.ColorStateList getBackgroundTintList(android.view.View view) {
            if (view instanceof android.support.v4.view.TintableBackgroundView) {
                return ((android.support.v4.view.TintableBackgroundView) view).getSupportBackgroundTintList();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public android.graphics.PorterDuff.Mode getBackgroundTintMode(android.view.View view) {
            if (view instanceof android.support.v4.view.TintableBackgroundView) {
                return ((android.support.v4.view.TintableBackgroundView) view).getSupportBackgroundTintMode();
            }
            return null;
        }

        public android.graphics.Rect getClipBounds(android.view.View view) {
            return null;
        }

        public android.view.Display getDisplay(android.view.View view) {
            if (isAttachedToWindow(view)) {
                return ((android.view.WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }

        public float getElevation(android.view.View view) {
            return 0.0f;
        }

        public boolean getFitsSystemWindows(android.view.View view) {
            return false;
        }

        long getFrameTime() {
            return android.animation.ValueAnimator.getFrameDelay();
        }

        public int getImportantForAccessibility(android.view.View view) {
            return 0;
        }

        public int getLabelFor(android.view.View view) {
            return 0;
        }

        public int getLayoutDirection(android.view.View view) {
            return 0;
        }

        public int getMinimumHeight(android.view.View view) {
            if (!sMinHeightFieldFetched) {
                try {
                    sMinHeightField = android.view.View.class.getDeclaredField("mMinHeight");
                    sMinHeightField.setAccessible(true);
                } catch (java.lang.NoSuchFieldException unused) {
                }
                sMinHeightFieldFetched = true;
            }
            java.lang.reflect.Field field = sMinHeightField;
            if (field == null) {
                return 0;
            }
            try {
                return ((java.lang.Integer) field.get(view)).intValue();
            } catch (java.lang.Exception unused2) {
                return 0;
            }
        }

        public int getMinimumWidth(android.view.View view) {
            if (!sMinWidthFieldFetched) {
                try {
                    sMinWidthField = android.view.View.class.getDeclaredField("mMinWidth");
                    sMinWidthField.setAccessible(true);
                } catch (java.lang.NoSuchFieldException unused) {
                }
                sMinWidthFieldFetched = true;
            }
            java.lang.reflect.Field field = sMinWidthField;
            if (field == null) {
                return 0;
            }
            try {
                return ((java.lang.Integer) field.get(view)).intValue();
            } catch (java.lang.Exception unused2) {
                return 0;
            }
        }

        public int getNextClusterForwardId(@android.support.annotation.NonNull android.view.View view) {
            return -1;
        }

        public int getPaddingEnd(android.view.View view) {
            return view.getPaddingRight();
        }

        public int getPaddingStart(android.view.View view) {
            return view.getPaddingLeft();
        }

        public android.view.ViewParent getParentForAccessibility(android.view.View view) {
            return view.getParent();
        }

        public int getScrollIndicators(android.view.View view) {
            return 0;
        }

        public java.lang.String getTransitionName(android.view.View view) {
            java.util.WeakHashMap<android.view.View, java.lang.String> weakHashMap = sTransitionNameMap;
            if (weakHashMap == null) {
                return null;
            }
            return weakHashMap.get(view);
        }

        public float getTranslationZ(android.view.View view) {
            return 0.0f;
        }

        public int getWindowSystemUiVisibility(android.view.View view) {
            return 0;
        }

        public float getZ(android.view.View view) {
            return getTranslationZ(view) + getElevation(view);
        }

        public boolean hasAccessibilityDelegate(android.view.View view) {
            if (sAccessibilityDelegateCheckFailed) {
                return false;
            }
            if (sAccessibilityDelegateField == null) {
                try {
                    sAccessibilityDelegateField = android.view.View.class.getDeclaredField("mAccessibilityDelegate");
                    sAccessibilityDelegateField.setAccessible(true);
                } catch (java.lang.Throwable unused) {
                    sAccessibilityDelegateCheckFailed = true;
                    return false;
                }
            }
            try {
                return sAccessibilityDelegateField.get(view) != null;
            } catch (java.lang.Throwable unused2) {
                sAccessibilityDelegateCheckFailed = true;
                return false;
            }
        }

        public boolean hasExplicitFocusable(@android.support.annotation.NonNull android.view.View view) {
            return view.hasFocusable();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean hasNestedScrollingParent(android.view.View view) {
            if (view instanceof android.support.v4.view.NestedScrollingChild) {
                return ((android.support.v4.view.NestedScrollingChild) view).hasNestedScrollingParent();
            }
            return false;
        }

        public boolean hasOnClickListeners(android.view.View view) {
            return false;
        }

        public boolean hasOverlappingRendering(android.view.View view) {
            return true;
        }

        public boolean hasTransientState(android.view.View view) {
            return false;
        }

        public boolean isAttachedToWindow(android.view.View view) {
            return view.getWindowToken() != null;
        }

        public boolean isFocusedByDefault(@android.support.annotation.NonNull android.view.View view) {
            return false;
        }

        public boolean isImportantForAccessibility(android.view.View view) {
            return true;
        }

        public boolean isInLayout(android.view.View view) {
            return false;
        }

        public boolean isKeyboardNavigationCluster(@android.support.annotation.NonNull android.view.View view) {
            return false;
        }

        public boolean isLaidOut(android.view.View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public boolean isLayoutDirectionResolved(android.view.View view) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean isNestedScrollingEnabled(android.view.View view) {
            if (view instanceof android.support.v4.view.NestedScrollingChild) {
                return ((android.support.v4.view.NestedScrollingChild) view).isNestedScrollingEnabled();
            }
            return false;
        }

        public boolean isPaddingRelative(android.view.View view) {
            return false;
        }

        public android.view.View keyboardNavigationClusterSearch(@android.support.annotation.NonNull android.view.View view, android.view.View view2, int i) {
            return null;
        }

        public void offsetLeftAndRight(android.view.View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                tickleInvalidationFlag(view);
                java.lang.Object parent = view.getParent();
                if (parent instanceof android.view.View) {
                    tickleInvalidationFlag((android.view.View) parent);
                }
            }
        }

        public void offsetTopAndBottom(android.view.View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                tickleInvalidationFlag(view);
                java.lang.Object parent = view.getParent();
                if (parent instanceof android.view.View) {
                    tickleInvalidationFlag((android.view.View) parent);
                }
            }
        }

        public android.support.v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, android.support.v4.view.WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onInitializeAccessibilityNodeInfo(android.view.View view, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
        }

        public boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
            return false;
        }

        public void postInvalidateOnAnimation(android.view.View view) {
            view.postInvalidate();
        }

        public void postInvalidateOnAnimation(android.view.View view, int i, int i2, int i3, int i4) {
            view.postInvalidate(i, i2, i3, i4);
        }

        public void postOnAnimation(android.view.View view, java.lang.Runnable runnable) {
            view.postDelayed(runnable, getFrameTime());
        }

        public void postOnAnimationDelayed(android.view.View view, java.lang.Runnable runnable, long j) {
            view.postDelayed(runnable, getFrameTime() + j);
        }

        public void requestApplyInsets(android.view.View view) {
        }

        public boolean restoreDefaultFocus(@android.support.annotation.NonNull android.view.View view) {
            return view.requestFocus();
        }

        public void setAccessibilityDelegate(android.view.View view, @android.support.annotation.Nullable android.support.v4.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
            view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
        }

        public void setAccessibilityLiveRegion(android.view.View view, int i) {
        }

        public void setBackground(android.view.View view, android.graphics.drawable.Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setBackgroundTintList(android.view.View view, android.content.res.ColorStateList colorStateList) {
            if (view instanceof android.support.v4.view.TintableBackgroundView) {
                ((android.support.v4.view.TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setBackgroundTintMode(android.view.View view, android.graphics.PorterDuff.Mode mode) {
            if (view instanceof android.support.v4.view.TintableBackgroundView) {
                ((android.support.v4.view.TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
            }
        }

        public void setChildrenDrawingOrderEnabled(android.view.ViewGroup viewGroup, boolean z) {
            if (sChildrenDrawingOrderMethod == null) {
                try {
                    sChildrenDrawingOrderMethod = android.view.ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", java.lang.Boolean.TYPE);
                } catch (java.lang.NoSuchMethodException e) {
                    android.util.Log.e(android.support.v4.view.ViewCompat.TAG, "Unable to find childrenDrawingOrderEnabled", e);
                }
                sChildrenDrawingOrderMethod.setAccessible(true);
            }
            try {
                sChildrenDrawingOrderMethod.invoke(viewGroup, java.lang.Boolean.valueOf(z));
            } catch (java.lang.IllegalAccessException e2) {
                android.util.Log.e(android.support.v4.view.ViewCompat.TAG, "Unable to invoke childrenDrawingOrderEnabled", e2);
            } catch (java.lang.IllegalArgumentException e3) {
                android.util.Log.e(android.support.v4.view.ViewCompat.TAG, "Unable to invoke childrenDrawingOrderEnabled", e3);
            } catch (java.lang.reflect.InvocationTargetException e4) {
                android.util.Log.e(android.support.v4.view.ViewCompat.TAG, "Unable to invoke childrenDrawingOrderEnabled", e4);
            }
        }

        public void setClipBounds(android.view.View view, android.graphics.Rect rect) {
        }

        public void setElevation(android.view.View view, float f) {
        }

        public void setFocusedByDefault(@android.support.annotation.NonNull android.view.View view, boolean z) {
        }

        public void setHasTransientState(android.view.View view, boolean z) {
        }

        public void setImportantForAccessibility(android.view.View view, int i) {
        }

        public void setKeyboardNavigationCluster(@android.support.annotation.NonNull android.view.View view, boolean z) {
        }

        public void setLabelFor(android.view.View view, int i) {
        }

        public void setLayerPaint(android.view.View view, android.graphics.Paint paint) {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }

        public void setLayoutDirection(android.view.View view, int i) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setNestedScrollingEnabled(android.view.View view, boolean z) {
            if (view instanceof android.support.v4.view.NestedScrollingChild) {
                ((android.support.v4.view.NestedScrollingChild) view).setNestedScrollingEnabled(z);
            }
        }

        public void setNextClusterForwardId(@android.support.annotation.NonNull android.view.View view, int i) {
        }

        public void setOnApplyWindowInsetsListener(android.view.View view, android.support.v4.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        public void setPaddingRelative(android.view.View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public void setPointerIcon(android.view.View view, android.support.v4.view.PointerIconCompat pointerIconCompat) {
        }

        public void setScrollIndicators(android.view.View view, int i) {
        }

        public void setScrollIndicators(android.view.View view, int i, int i2) {
        }

        public void setTooltipText(android.view.View view, java.lang.CharSequence charSequence) {
        }

        public void setTransitionName(android.view.View view, java.lang.String str) {
            if (sTransitionNameMap == null) {
                sTransitionNameMap = new java.util.WeakHashMap<>();
            }
            sTransitionNameMap.put(view, str);
        }

        public void setTranslationZ(android.view.View view, float f) {
        }

        public void setZ(android.view.View view, float f) {
        }

        public boolean startDragAndDrop(android.view.View view, android.content.ClipData clipData, android.view.View.DragShadowBuilder dragShadowBuilder, java.lang.Object obj, int i) {
            return view.startDrag(clipData, dragShadowBuilder, obj, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean startNestedScroll(android.view.View view, int i) {
            if (view instanceof android.support.v4.view.NestedScrollingChild) {
                return ((android.support.v4.view.NestedScrollingChild) view).startNestedScroll(i);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void stopNestedScroll(android.view.View view) {
            if (view instanceof android.support.v4.view.NestedScrollingChild) {
                ((android.support.v4.view.NestedScrollingChild) view).stopNestedScroll();
            }
        }

        public void updateDragShadow(android.view.View view, android.view.View.DragShadowBuilder dragShadowBuilder) {
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            IMPL = new android.support.v4.view.ViewCompat.ViewCompatApi26Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            IMPL = new android.support.v4.view.ViewCompat.ViewCompatApi24Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            IMPL = new android.support.v4.view.ViewCompat.ViewCompatApi23Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.view.ViewCompat.ViewCompatApi21Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            IMPL = new android.support.v4.view.ViewCompat.ViewCompatApi19Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            IMPL = new android.support.v4.view.ViewCompat.ViewCompatApi18Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            IMPL = new android.support.v4.view.ViewCompat.ViewCompatApi17Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            IMPL = new android.support.v4.view.ViewCompat.ViewCompatApi16Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 15) {
            IMPL = new android.support.v4.view.ViewCompat.ViewCompatApi15Impl();
        } else {
            IMPL = new android.support.v4.view.ViewCompat.ViewCompatBaseImpl();
        }
    }

    protected ViewCompat() {
    }

    public static void addKeyboardNavigationClusters(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.NonNull java.util.Collection<android.view.View> collection, int i) {
        IMPL.addKeyboardNavigationClusters(view, collection, i);
    }

    public static android.support.v4.view.ViewPropertyAnimatorCompat animate(android.view.View view) {
        return IMPL.animate(view);
    }

    @java.lang.Deprecated
    public static boolean canScrollHorizontally(android.view.View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @java.lang.Deprecated
    public static boolean canScrollVertically(android.view.View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void cancelDragAndDrop(android.view.View view) {
        IMPL.cancelDragAndDrop(view);
    }

    @java.lang.Deprecated
    public static int combineMeasuredStates(int i, int i2) {
        return android.view.View.combineMeasuredStates(i, i2);
    }

    public static android.support.v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View view, android.support.v4.view.WindowInsetsCompat windowInsetsCompat) {
        return IMPL.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    public static void dispatchFinishTemporaryDetach(android.view.View view) {
        IMPL.dispatchFinishTemporaryDetach(view);
    }

    public static boolean dispatchNestedFling(@android.support.annotation.NonNull android.view.View view, float f, float f2, boolean z) {
        return IMPL.dispatchNestedFling(view, f, f2, z);
    }

    public static boolean dispatchNestedPreFling(@android.support.annotation.NonNull android.view.View view, float f, float f2) {
        return IMPL.dispatchNestedPreFling(view, f, f2);
    }

    public static boolean dispatchNestedPreScroll(@android.support.annotation.NonNull android.view.View view, int i, int i2, @android.support.annotation.Nullable int[] iArr, @android.support.annotation.Nullable int[] iArr2) {
        return IMPL.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(@android.support.annotation.NonNull android.view.View view, int i, int i2, @android.support.annotation.Nullable int[] iArr, @android.support.annotation.Nullable int[] iArr2, int i3) {
        if (view instanceof android.support.v4.view.NestedScrollingChild2) {
            return ((android.support.v4.view.NestedScrollingChild2) view).dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        if (i3 == 0) {
            return IMPL.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
        }
        return false;
    }

    public static boolean dispatchNestedScroll(@android.support.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4, @android.support.annotation.Nullable int[] iArr) {
        return IMPL.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(@android.support.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4, @android.support.annotation.Nullable int[] iArr, int i5) {
        if (view instanceof android.support.v4.view.NestedScrollingChild2) {
            return ((android.support.v4.view.NestedScrollingChild2) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        if (i5 == 0) {
            return IMPL.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
        }
        return false;
    }

    public static void dispatchStartTemporaryDetach(android.view.View view) {
        IMPL.dispatchStartTemporaryDetach(view);
    }

    public static int getAccessibilityLiveRegion(android.view.View view) {
        return IMPL.getAccessibilityLiveRegion(view);
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View view) {
        return IMPL.getAccessibilityNodeProvider(view);
    }

    @java.lang.Deprecated
    public static float getAlpha(android.view.View view) {
        return view.getAlpha();
    }

    public static android.content.res.ColorStateList getBackgroundTintList(android.view.View view) {
        return IMPL.getBackgroundTintList(view);
    }

    public static android.graphics.PorterDuff.Mode getBackgroundTintMode(android.view.View view) {
        return IMPL.getBackgroundTintMode(view);
    }

    public static android.graphics.Rect getClipBounds(android.view.View view) {
        return IMPL.getClipBounds(view);
    }

    public static android.view.Display getDisplay(@android.support.annotation.NonNull android.view.View view) {
        return IMPL.getDisplay(view);
    }

    public static float getElevation(android.view.View view) {
        return IMPL.getElevation(view);
    }

    public static boolean getFitsSystemWindows(android.view.View view) {
        return IMPL.getFitsSystemWindows(view);
    }

    public static int getImportantForAccessibility(android.view.View view) {
        return IMPL.getImportantForAccessibility(view);
    }

    public static int getLabelFor(android.view.View view) {
        return IMPL.getLabelFor(view);
    }

    @java.lang.Deprecated
    public static int getLayerType(android.view.View view) {
        return view.getLayerType();
    }

    public static int getLayoutDirection(android.view.View view) {
        return IMPL.getLayoutDirection(view);
    }

    @android.support.annotation.Nullable
    @java.lang.Deprecated
    public static android.graphics.Matrix getMatrix(android.view.View view) {
        return view.getMatrix();
    }

    @java.lang.Deprecated
    public static int getMeasuredHeightAndState(android.view.View view) {
        return view.getMeasuredHeightAndState();
    }

    @java.lang.Deprecated
    public static int getMeasuredState(android.view.View view) {
        return view.getMeasuredState();
    }

    @java.lang.Deprecated
    public static int getMeasuredWidthAndState(android.view.View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(android.view.View view) {
        return IMPL.getMinimumHeight(view);
    }

    public static int getMinimumWidth(android.view.View view) {
        return IMPL.getMinimumWidth(view);
    }

    public static int getNextClusterForwardId(@android.support.annotation.NonNull android.view.View view) {
        return IMPL.getNextClusterForwardId(view);
    }

    @java.lang.Deprecated
    public static int getOverScrollMode(android.view.View view) {
        return view.getOverScrollMode();
    }

    public static int getPaddingEnd(android.view.View view) {
        return IMPL.getPaddingEnd(view);
    }

    public static int getPaddingStart(android.view.View view) {
        return IMPL.getPaddingStart(view);
    }

    public static android.view.ViewParent getParentForAccessibility(android.view.View view) {
        return IMPL.getParentForAccessibility(view);
    }

    @java.lang.Deprecated
    public static float getPivotX(android.view.View view) {
        return view.getPivotX();
    }

    @java.lang.Deprecated
    public static float getPivotY(android.view.View view) {
        return view.getPivotY();
    }

    @java.lang.Deprecated
    public static float getRotation(android.view.View view) {
        return view.getRotation();
    }

    @java.lang.Deprecated
    public static float getRotationX(android.view.View view) {
        return view.getRotationX();
    }

    @java.lang.Deprecated
    public static float getRotationY(android.view.View view) {
        return view.getRotationY();
    }

    @java.lang.Deprecated
    public static float getScaleX(android.view.View view) {
        return view.getScaleX();
    }

    @java.lang.Deprecated
    public static float getScaleY(android.view.View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(@android.support.annotation.NonNull android.view.View view) {
        return IMPL.getScrollIndicators(view);
    }

    public static java.lang.String getTransitionName(android.view.View view) {
        return IMPL.getTransitionName(view);
    }

    @java.lang.Deprecated
    public static float getTranslationX(android.view.View view) {
        return view.getTranslationX();
    }

    @java.lang.Deprecated
    public static float getTranslationY(android.view.View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(android.view.View view) {
        return IMPL.getTranslationZ(view);
    }

    public static int getWindowSystemUiVisibility(android.view.View view) {
        return IMPL.getWindowSystemUiVisibility(view);
    }

    @java.lang.Deprecated
    public static float getX(android.view.View view) {
        return view.getX();
    }

    @java.lang.Deprecated
    public static float getY(android.view.View view) {
        return view.getY();
    }

    public static float getZ(android.view.View view) {
        return IMPL.getZ(view);
    }

    public static boolean hasAccessibilityDelegate(android.view.View view) {
        return IMPL.hasAccessibilityDelegate(view);
    }

    public static boolean hasExplicitFocusable(@android.support.annotation.NonNull android.view.View view) {
        return IMPL.hasExplicitFocusable(view);
    }

    public static boolean hasNestedScrollingParent(@android.support.annotation.NonNull android.view.View view) {
        return IMPL.hasNestedScrollingParent(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(@android.support.annotation.NonNull android.view.View view, int i) {
        if (view instanceof android.support.v4.view.NestedScrollingChild2) {
            ((android.support.v4.view.NestedScrollingChild2) view).hasNestedScrollingParent(i);
            return false;
        }
        if (i == 0) {
            return IMPL.hasNestedScrollingParent(view);
        }
        return false;
    }

    public static boolean hasOnClickListeners(android.view.View view) {
        return IMPL.hasOnClickListeners(view);
    }

    public static boolean hasOverlappingRendering(android.view.View view) {
        return IMPL.hasOverlappingRendering(view);
    }

    public static boolean hasTransientState(android.view.View view) {
        return IMPL.hasTransientState(view);
    }

    public static boolean isAttachedToWindow(android.view.View view) {
        return IMPL.isAttachedToWindow(view);
    }

    public static boolean isFocusedByDefault(@android.support.annotation.NonNull android.view.View view) {
        return IMPL.isFocusedByDefault(view);
    }

    public static boolean isImportantForAccessibility(android.view.View view) {
        return IMPL.isImportantForAccessibility(view);
    }

    public static boolean isInLayout(android.view.View view) {
        return IMPL.isInLayout(view);
    }

    public static boolean isKeyboardNavigationCluster(@android.support.annotation.NonNull android.view.View view) {
        return IMPL.isKeyboardNavigationCluster(view);
    }

    public static boolean isLaidOut(android.view.View view) {
        return IMPL.isLaidOut(view);
    }

    public static boolean isLayoutDirectionResolved(android.view.View view) {
        return IMPL.isLayoutDirectionResolved(view);
    }

    public static boolean isNestedScrollingEnabled(@android.support.annotation.NonNull android.view.View view) {
        return IMPL.isNestedScrollingEnabled(view);
    }

    @java.lang.Deprecated
    public static boolean isOpaque(android.view.View view) {
        return view.isOpaque();
    }

    public static boolean isPaddingRelative(android.view.View view) {
        return IMPL.isPaddingRelative(view);
    }

    @java.lang.Deprecated
    public static void jumpDrawablesToCurrentState(android.view.View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static android.view.View keyboardNavigationClusterSearch(@android.support.annotation.NonNull android.view.View view, android.view.View view2, int i) {
        return IMPL.keyboardNavigationClusterSearch(view, view2, i);
    }

    public static void offsetLeftAndRight(android.view.View view, int i) {
        IMPL.offsetLeftAndRight(view, i);
    }

    public static void offsetTopAndBottom(android.view.View view, int i) {
        IMPL.offsetTopAndBottom(view, i);
    }

    public static android.support.v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, android.support.v4.view.WindowInsetsCompat windowInsetsCompat) {
        return IMPL.onApplyWindowInsets(view, windowInsetsCompat);
    }

    @java.lang.Deprecated
    public static void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(android.view.View view, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        IMPL.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
    }

    @java.lang.Deprecated
    public static void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public static boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
        return IMPL.performAccessibilityAction(view, i, bundle);
    }

    public static void postInvalidateOnAnimation(android.view.View view) {
        IMPL.postInvalidateOnAnimation(view);
    }

    public static void postInvalidateOnAnimation(android.view.View view, int i, int i2, int i3, int i4) {
        IMPL.postInvalidateOnAnimation(view, i, i2, i3, i4);
    }

    public static void postOnAnimation(android.view.View view, java.lang.Runnable runnable) {
        IMPL.postOnAnimation(view, runnable);
    }

    public static void postOnAnimationDelayed(android.view.View view, java.lang.Runnable runnable, long j) {
        IMPL.postOnAnimationDelayed(view, runnable, j);
    }

    public static void requestApplyInsets(android.view.View view) {
        IMPL.requestApplyInsets(view);
    }

    @java.lang.Deprecated
    public static int resolveSizeAndState(int i, int i2, int i3) {
        return android.view.View.resolveSizeAndState(i, i2, i3);
    }

    public static boolean restoreDefaultFocus(@android.support.annotation.NonNull android.view.View view) {
        return IMPL.restoreDefaultFocus(view);
    }

    public static void setAccessibilityDelegate(android.view.View view, android.support.v4.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
        IMPL.setAccessibilityDelegate(view, accessibilityDelegateCompat);
    }

    public static void setAccessibilityLiveRegion(android.view.View view, int i) {
        IMPL.setAccessibilityLiveRegion(view, i);
    }

    @java.lang.Deprecated
    public static void setActivated(android.view.View view, boolean z) {
        view.setActivated(z);
    }

    @java.lang.Deprecated
    public static void setAlpha(android.view.View view, @android.support.annotation.FloatRange(from = 0.0d, to = com.unisound.sdk.cu.f1558a) float f) {
        view.setAlpha(f);
    }

    public static void setBackground(android.view.View view, android.graphics.drawable.Drawable drawable) {
        IMPL.setBackground(view, drawable);
    }

    public static void setBackgroundTintList(android.view.View view, android.content.res.ColorStateList colorStateList) {
        IMPL.setBackgroundTintList(view, colorStateList);
    }

    public static void setBackgroundTintMode(android.view.View view, android.graphics.PorterDuff.Mode mode) {
        IMPL.setBackgroundTintMode(view, mode);
    }

    public static void setChildrenDrawingOrderEnabled(android.view.ViewGroup viewGroup, boolean z) {
        IMPL.setChildrenDrawingOrderEnabled(viewGroup, z);
    }

    public static void setClipBounds(android.view.View view, android.graphics.Rect rect) {
        IMPL.setClipBounds(view, rect);
    }

    public static void setElevation(android.view.View view, float f) {
        IMPL.setElevation(view, f);
    }

    @java.lang.Deprecated
    public static void setFitsSystemWindows(android.view.View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void setFocusedByDefault(@android.support.annotation.NonNull android.view.View view, boolean z) {
        IMPL.setFocusedByDefault(view, z);
    }

    public static void setHasTransientState(android.view.View view, boolean z) {
        IMPL.setHasTransientState(view, z);
    }

    public static void setImportantForAccessibility(android.view.View view, int i) {
        IMPL.setImportantForAccessibility(view, i);
    }

    public static void setKeyboardNavigationCluster(@android.support.annotation.NonNull android.view.View view, boolean z) {
        IMPL.setKeyboardNavigationCluster(view, z);
    }

    public static void setLabelFor(android.view.View view, @android.support.annotation.IdRes int i) {
        IMPL.setLabelFor(view, i);
    }

    public static void setLayerPaint(android.view.View view, android.graphics.Paint paint) {
        IMPL.setLayerPaint(view, paint);
    }

    @java.lang.Deprecated
    public static void setLayerType(android.view.View view, int i, android.graphics.Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void setLayoutDirection(android.view.View view, int i) {
        IMPL.setLayoutDirection(view, i);
    }

    public static void setNestedScrollingEnabled(@android.support.annotation.NonNull android.view.View view, boolean z) {
        IMPL.setNestedScrollingEnabled(view, z);
    }

    public static void setNextClusterForwardId(@android.support.annotation.NonNull android.view.View view, int i) {
        IMPL.setNextClusterForwardId(view, i);
    }

    public static void setOnApplyWindowInsetsListener(android.view.View view, android.support.v4.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        IMPL.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    @java.lang.Deprecated
    public static void setOverScrollMode(android.view.View view, int i) {
        view.setOverScrollMode(i);
    }

    public static void setPaddingRelative(android.view.View view, int i, int i2, int i3, int i4) {
        IMPL.setPaddingRelative(view, i, i2, i3, i4);
    }

    @java.lang.Deprecated
    public static void setPivotX(android.view.View view, float f) {
        view.setPivotX(f);
    }

    @java.lang.Deprecated
    public static void setPivotY(android.view.View view, float f) {
        view.setPivotY(f);
    }

    public static void setPointerIcon(@android.support.annotation.NonNull android.view.View view, android.support.v4.view.PointerIconCompat pointerIconCompat) {
        IMPL.setPointerIcon(view, pointerIconCompat);
    }

    @java.lang.Deprecated
    public static void setRotation(android.view.View view, float f) {
        view.setRotation(f);
    }

    @java.lang.Deprecated
    public static void setRotationX(android.view.View view, float f) {
        view.setRotationX(f);
    }

    @java.lang.Deprecated
    public static void setRotationY(android.view.View view, float f) {
        view.setRotationY(f);
    }

    @java.lang.Deprecated
    public static void setSaveFromParentEnabled(android.view.View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    @java.lang.Deprecated
    public static void setScaleX(android.view.View view, float f) {
        view.setScaleX(f);
    }

    @java.lang.Deprecated
    public static void setScaleY(android.view.View view, float f) {
        view.setScaleY(f);
    }

    public static void setScrollIndicators(@android.support.annotation.NonNull android.view.View view, int i) {
        IMPL.setScrollIndicators(view, i);
    }

    public static void setScrollIndicators(@android.support.annotation.NonNull android.view.View view, int i, int i2) {
        IMPL.setScrollIndicators(view, i, i2);
    }

    public static void setTooltipText(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.Nullable java.lang.CharSequence charSequence) {
        IMPL.setTooltipText(view, charSequence);
    }

    public static void setTransitionName(android.view.View view, java.lang.String str) {
        IMPL.setTransitionName(view, str);
    }

    @java.lang.Deprecated
    public static void setTranslationX(android.view.View view, float f) {
        view.setTranslationX(f);
    }

    @java.lang.Deprecated
    public static void setTranslationY(android.view.View view, float f) {
        view.setTranslationY(f);
    }

    public static void setTranslationZ(android.view.View view, float f) {
        IMPL.setTranslationZ(view, f);
    }

    @java.lang.Deprecated
    public static void setX(android.view.View view, float f) {
        view.setX(f);
    }

    @java.lang.Deprecated
    public static void setY(android.view.View view, float f) {
        view.setY(f);
    }

    public static void setZ(android.view.View view, float f) {
        IMPL.setZ(view, f);
    }

    public static boolean startDragAndDrop(android.view.View view, android.content.ClipData clipData, android.view.View.DragShadowBuilder dragShadowBuilder, java.lang.Object obj, int i) {
        return IMPL.startDragAndDrop(view, clipData, dragShadowBuilder, obj, i);
    }

    public static boolean startNestedScroll(@android.support.annotation.NonNull android.view.View view, int i) {
        return IMPL.startNestedScroll(view, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(@android.support.annotation.NonNull android.view.View view, int i, int i2) {
        if (view instanceof android.support.v4.view.NestedScrollingChild2) {
            return ((android.support.v4.view.NestedScrollingChild2) view).startNestedScroll(i, i2);
        }
        if (i2 == 0) {
            return IMPL.startNestedScroll(view, i);
        }
        return false;
    }

    public static void stopNestedScroll(@android.support.annotation.NonNull android.view.View view) {
        IMPL.stopNestedScroll(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(@android.support.annotation.NonNull android.view.View view, int i) {
        if (view instanceof android.support.v4.view.NestedScrollingChild2) {
            ((android.support.v4.view.NestedScrollingChild2) view).stopNestedScroll(i);
        } else if (i == 0) {
            IMPL.stopNestedScroll(view);
        }
    }

    public static void updateDragShadow(android.view.View view, android.view.View.DragShadowBuilder dragShadowBuilder) {
        IMPL.updateDragShadow(view, dragShadowBuilder);
    }
}
