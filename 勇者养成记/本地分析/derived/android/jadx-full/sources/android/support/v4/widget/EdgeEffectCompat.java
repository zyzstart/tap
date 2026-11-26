package android.support.v4.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class EdgeEffectCompat {
    private static final android.support.v4.widget.EdgeEffectCompat.EdgeEffectBaseImpl IMPL;
    private android.widget.EdgeEffect mEdgeEffect;

    @android.support.annotation.RequiresApi(21)
    static class EdgeEffectApi21Impl extends android.support.v4.widget.EdgeEffectCompat.EdgeEffectBaseImpl {
        EdgeEffectApi21Impl() {
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectBaseImpl
        public void onPull(android.widget.EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    static class EdgeEffectBaseImpl {
        EdgeEffectBaseImpl() {
        }

        public void onPull(android.widget.EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.widget.EdgeEffectCompat.EdgeEffectApi21Impl();
        } else {
            IMPL = new android.support.v4.widget.EdgeEffectCompat.EdgeEffectBaseImpl();
        }
    }

    @java.lang.Deprecated
    public EdgeEffectCompat(android.content.Context context) {
        this.mEdgeEffect = new android.widget.EdgeEffect(context);
    }

    public static void onPull(android.widget.EdgeEffect edgeEffect, float f, float f2) {
        IMPL.onPull(edgeEffect, f, f2);
    }

    @java.lang.Deprecated
    public boolean draw(android.graphics.Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @java.lang.Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @java.lang.Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @java.lang.Deprecated
    public boolean onAbsorb(int i) {
        this.mEdgeEffect.onAbsorb(i);
        return true;
    }

    @java.lang.Deprecated
    public boolean onPull(float f) {
        this.mEdgeEffect.onPull(f);
        return true;
    }

    @java.lang.Deprecated
    public boolean onPull(float f, float f2) {
        IMPL.onPull(this.mEdgeEffect, f, f2);
        return true;
    }

    @java.lang.Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @java.lang.Deprecated
    public void setSize(int i, int i2) {
        this.mEdgeEffect.setSize(i, i2);
    }
}
