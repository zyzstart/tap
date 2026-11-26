package com.tencent.ysdk.shell.libware.ui.animation;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Rotate3dAnimation extends android.view.animation.Animation {
    private android.graphics.Camera mCamera;
    private final float mCenterX;
    private final float mCenterY;
    private final float mDepthZ;
    private final float mFromDegrees;
    private final boolean mReverse;
    private com.tencent.ysdk.shell.libware.ui.animation.Rotate3dAnimation.RotateAxis mRotateAxis = com.tencent.ysdk.shell.libware.ui.animation.Rotate3dAnimation.RotateAxis.X;
    private final float mToDegrees;

    public enum RotateAxis {
        X,
        Y
    }

    public Rotate3dAnimation(float f, float f2, float f3, float f4, float f5, boolean z) {
        this.mFromDegrees = f;
        this.mToDegrees = f2;
        this.mCenterX = f3;
        this.mCenterY = f4;
        this.mDepthZ = f5;
        this.mReverse = z;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, android.view.animation.Transformation transformation) {
        float f2 = this.mFromDegrees;
        float f3 = f2 + ((this.mToDegrees - f2) * f);
        float f4 = this.mCenterX;
        float f5 = this.mCenterY;
        android.graphics.Camera camera = this.mCamera;
        android.graphics.Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.mReverse) {
            camera.translate(0.0f, 0.0f, this.mDepthZ * f);
        } else {
            camera.translate(0.0f, 0.0f, this.mDepthZ * (1.0f - f));
        }
        if (this.mRotateAxis == com.tencent.ysdk.shell.libware.ui.animation.Rotate3dAnimation.RotateAxis.X) {
            camera.rotateX(f3);
        } else {
            camera.rotateY(f3);
        }
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
        super.applyTransformation(f, transformation);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.mCamera = new android.graphics.Camera();
    }

    public void setRotateAxis(com.tencent.ysdk.shell.libware.ui.animation.Rotate3dAnimation.RotateAxis rotateAxis) {
        this.mRotateAxis = rotateAxis;
    }
}
