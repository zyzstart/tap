package com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IconViewInterceptor {
    boolean correctLocation(android.view.View view, android.graphics.Point point, boolean z);

    android.graphics.Rect getScreenRect();
}
