package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Camera2Wrapper implements com.unity3d.player.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1577a;
    private com.unity3d.player.a b = null;
    private final int c = 100;

    public Camera2Wrapper(android.content.Context context) {
        this.f1577a = context;
        initCamera2Jni();
    }

    private static int a(float f) {
        return (int) java.lang.Math.min(java.lang.Math.max((f * 2000.0f) - 1000.0f, -900.0f), 900.0f);
    }

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(java.lang.Object obj);

    public final void a() {
        closeCamera2();
    }

    @Override // com.unity3d.player.d
    public final void a(java.lang.Object obj) {
        nativeSurfaceTextureReady(obj);
    }

    @Override // com.unity3d.player.d
    public final void a(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, int i, int i2, int i3) {
        nativeFrameReady(obj, obj2, obj3, i, i2, i3);
    }

    protected void closeCamera2() {
        com.unity3d.player.a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
        this.b = null;
    }

    protected int getCamera2Count() {
        if (com.unity3d.player.j.b) {
            return com.unity3d.player.a.a(this.f1577a);
        }
        return 0;
    }

    protected int[] getCamera2Resolutions(int i) {
        if (com.unity3d.player.j.b) {
            return com.unity3d.player.a.d(this.f1577a, i);
        }
        return null;
    }

    protected int getCamera2SensorOrientation(int i) {
        if (com.unity3d.player.j.b) {
            return com.unity3d.player.a.a(this.f1577a, i);
        }
        return 0;
    }

    protected java.lang.Object getCameraFocusArea(float f, float f2) {
        int iA = a(f);
        int iA2 = a(1.0f - f2);
        return new android.hardware.Camera.Area(new android.graphics.Rect(iA - 100, iA2 - 100, iA + 100, iA2 + 100), 1000);
    }

    protected android.graphics.Rect getFrameSizeCamera2() {
        com.unity3d.player.a aVar = this.b;
        return aVar != null ? aVar.a() : new android.graphics.Rect();
    }

    protected boolean initializeCamera2(int i, int i2, int i3, int i4, int i5) {
        if (!com.unity3d.player.j.b || this.b != null || com.unity3d.player.UnityPlayer.currentActivity == null) {
            return false;
        }
        this.b = new com.unity3d.player.a(this);
        return this.b.a(this.f1577a, i, i2, i3, i4, i5);
    }

    protected boolean isCamera2AutoFocusPointSupported(int i) {
        if (com.unity3d.player.j.b) {
            return com.unity3d.player.a.c(this.f1577a, i);
        }
        return false;
    }

    protected boolean isCamera2FrontFacing(int i) {
        if (com.unity3d.player.j.b) {
            return com.unity3d.player.a.b(this.f1577a, i);
        }
        return false;
    }

    protected void pauseCamera2() {
        com.unity3d.player.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    protected boolean setAutoFocusPoint(float f, float f2) {
        com.unity3d.player.a aVar;
        if (!com.unity3d.player.j.b || (aVar = this.b) == null) {
            return false;
        }
        return aVar.a(f, f2);
    }

    protected void startCamera2() {
        com.unity3d.player.a aVar = this.b;
        if (aVar != null) {
            aVar.c();
        }
    }

    protected void stopCamera2() {
        com.unity3d.player.a aVar = this.b;
        if (aVar != null) {
            aVar.e();
        }
    }
}
