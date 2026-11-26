package com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class AbstractIconViewInterceptor implements com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.IconViewInterceptor {
    private static final java.lang.String TAG = "AbstractIconViewInterceptor";
    private android.graphics.Rect mScreenRect = new android.graphics.Rect();
    private com.tencent.ysdk.shell.framework.YSDKSystem mSystem;

    public AbstractIconViewInterceptor(@androidx.annotation.NonNull com.tencent.ysdk.shell.framework.YSDKSystem ySDKSystem) {
        this.mSystem = ySDKSystem;
    }

    private void correctLocationByOrientation(android.view.View view, int i, com.tencent.ysdk.shell.libware.device.notch.NotchInfo notchInfo, android.graphics.Point point, boolean z) {
        android.graphics.Rect rect = notchInfo.getRect();
        int screenWindowWidth = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWindowWidth(this.mSystem.getActivity());
        int screenWindowHeight = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWindowHeight(this.mSystem.getActivity());
        if (i == 2) {
            correctLocationOnLandscape(screenWindowWidth, screenWindowHeight, rect, view, point, z);
        } else if (i == 1) {
            correctLocationOnPortrait(screenWindowWidth, screenWindowHeight, rect, view, point, z);
        }
    }

    private void correctLocationOnLandscape(int i, int i2, android.graphics.Rect rect, android.view.View view, android.graphics.Point point, boolean z) {
        int i3 = rect.right - rect.left;
        android.graphics.Rect rect2 = this.mScreenRect;
        rect2.left = 0;
        rect2.top = 0;
        rect2.right = i - i3;
        rect2.bottom = i2;
        if (!isAroundNotch() || z) {
            modifyLocationX(i, view, point, i3);
        } else if (rect.left == 0) {
            modifyLocationXAroundLeftNotch(i, rect, view, point, i3);
        } else {
            modifyLocationXAroundRightNotch(rect, view, point);
        }
    }

    private void correctLocationOnPortrait(int i, int i2, android.graphics.Rect rect, android.view.View view, android.graphics.Point point, boolean z) {
        android.graphics.Rect rect2 = this.mScreenRect;
        rect2.left = 0;
        rect2.top = 0;
        rect2.right = i;
        int i3 = rect.bottom - rect.top;
        this.mScreenRect.bottom = i2 - i3;
        if (!isAroundNotch() || z) {
            modifyLocationY(i2, view, point, i3);
        } else if (isXInNotchArea(point, rect, view)) {
            modifyLocationY(i2, view, point, i3);
        } else if (point.y > i2 - view.getHeight()) {
            point.y = i2 - view.getHeight();
        }
    }

    private boolean isXInNotchArea(android.graphics.Point point, android.graphics.Rect rect, android.view.View view) {
        return point.x > rect.left - view.getMeasuredWidth() && point.x < rect.right;
    }

    private boolean isYInNotchArea(android.graphics.Point point, android.graphics.Rect rect, android.view.View view) {
        return point.y > rect.top - view.getHeight() && point.y < rect.bottom;
    }

    private void modifyLocationX(int i, android.view.View view, android.graphics.Point point, int i2) {
        if (point.x <= i2) {
            point.x = i2;
            return;
        }
        int i3 = i - i2;
        if (point.x > i3 - view.getWidth()) {
            point.x = i3 - view.getWidth();
        }
    }

    private void modifyLocationXAroundLeftNotch(int i, android.graphics.Rect rect, android.view.View view, android.graphics.Point point, int i2) {
        if (!isYInNotchArea(point, rect, view)) {
            if (point.x > i - view.getWidth()) {
                point.x = i - view.getWidth();
            }
        } else if (point.x < i2) {
            point.x = i2;
        } else if (point.x > i - view.getWidth()) {
            point.x = i - view.getWidth();
        }
    }

    private void modifyLocationXAroundRightNotch(android.graphics.Rect rect, android.view.View view, android.graphics.Point point) {
        if (!isYInNotchArea(point, rect, view)) {
            if (point.x <= view.getWidth()) {
                point.x = view.getWidth();
            }
        } else if (point.x > rect.left - view.getWidth()) {
            point.x = rect.left - view.getWidth();
        } else if (point.x <= view.getWidth()) {
            point.x = view.getWidth();
        }
    }

    private void modifyLocationY(int i, android.view.View view, android.graphics.Point point, int i2) {
        if (point.y <= i2) {
            point.y = i2;
        } else if (point.y > i - view.getHeight()) {
            point.y = i - view.getHeight();
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.IconViewInterceptor
    public boolean correctLocation(android.view.View view, android.graphics.Point point, boolean z) {
        com.tencent.ysdk.shell.libware.device.notch.INotch iNotch = getINotch();
        if (iNotch == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "iNotch null");
            return false;
        }
        com.tencent.ysdk.shell.libware.device.notch.NotchInfo notchInfo = iNotch.getNotchInfo(this.mSystem.getActivity());
        if (!notchInfo.hasNotch()) {
            return false;
        }
        if (view == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "target null");
            return false;
        }
        if (point == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "location null");
            return false;
        }
        correctLocationByOrientation(view, com.tencent.ysdk.shell.libware.device.DeviceUtils.getOrientation(this.mSystem.getActivity()), notchInfo, point, z);
        return true;
    }

    protected abstract com.tencent.ysdk.shell.libware.device.notch.INotch getINotch();

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.IconViewInterceptor
    public android.graphics.Rect getScreenRect() {
        return this.mScreenRect;
    }

    protected boolean isAroundNotch() {
        return false;
    }
}
