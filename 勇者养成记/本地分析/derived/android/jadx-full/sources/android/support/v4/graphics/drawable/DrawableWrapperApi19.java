package android.support.v4.graphics.drawable;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(19)
class DrawableWrapperApi19 extends android.support.v4.graphics.drawable.DrawableWrapperApi14 {

    private static class DrawableWrapperStateKitKat extends android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState {
        DrawableWrapperStateKitKat(@android.support.annotation.Nullable android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState drawableWrapperState, @android.support.annotation.Nullable android.content.res.Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(@android.support.annotation.Nullable android.content.res.Resources resources) {
            return new android.support.v4.graphics.drawable.DrawableWrapperApi19(this, resources);
        }
    }

    DrawableWrapperApi19(android.graphics.drawable.Drawable drawable) {
        super(drawable);
    }

    DrawableWrapperApi19(android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState drawableWrapperState, android.content.res.Resources resources) {
        super(drawableWrapperState, resources);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperApi14
    @android.support.annotation.NonNull
    android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState mutateConstantState() {
        return new android.support.v4.graphics.drawable.DrawableWrapperApi19.DrawableWrapperStateKitKat(this.mState, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.mDrawable.setAutoMirrored(z);
    }
}
