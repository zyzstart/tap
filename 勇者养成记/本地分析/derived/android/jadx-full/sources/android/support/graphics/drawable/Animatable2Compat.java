package android.support.graphics.drawable;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface Animatable2Compat extends android.graphics.drawable.Animatable {

    public static abstract class AnimationCallback {
        android.graphics.drawable.Animatable2.AnimationCallback mPlatformCallback;

        @android.support.annotation.RequiresApi(23)
        android.graphics.drawable.Animatable2.AnimationCallback getPlatformCallback() {
            if (this.mPlatformCallback == null) {
                this.mPlatformCallback = new android.graphics.drawable.Animatable2.AnimationCallback() { // from class: android.support.graphics.drawable.Animatable2Compat.AnimationCallback.1
                    @Override // android.graphics.drawable.Animatable2.AnimationCallback
                    public void onAnimationEnd(android.graphics.drawable.Drawable drawable) {
                        android.support.graphics.drawable.Animatable2Compat.AnimationCallback.this.onAnimationEnd(drawable);
                    }

                    @Override // android.graphics.drawable.Animatable2.AnimationCallback
                    public void onAnimationStart(android.graphics.drawable.Drawable drawable) {
                        android.support.graphics.drawable.Animatable2Compat.AnimationCallback.this.onAnimationStart(drawable);
                    }
                };
            }
            return this.mPlatformCallback;
        }

        public void onAnimationEnd(android.graphics.drawable.Drawable drawable) {
        }

        public void onAnimationStart(android.graphics.drawable.Drawable drawable) {
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(@android.support.annotation.NonNull android.support.graphics.drawable.Animatable2Compat.AnimationCallback animationCallback);

    boolean unregisterAnimationCallback(@android.support.annotation.NonNull android.support.graphics.drawable.Animatable2Compat.AnimationCallback animationCallback);
}
