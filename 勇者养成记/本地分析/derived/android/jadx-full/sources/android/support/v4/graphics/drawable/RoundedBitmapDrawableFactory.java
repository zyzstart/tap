package android.support.v4.graphics.drawable;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class RoundedBitmapDrawableFactory {
    private static final java.lang.String TAG = "RoundedBitmapDrawableFa";

    private static class DefaultRoundedBitmapDrawable extends android.support.v4.graphics.drawable.RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(android.content.res.Resources resources, android.graphics.Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // android.support.v4.graphics.drawable.RoundedBitmapDrawable
        void gravityCompatApply(int i, int i2, int i3, android.graphics.Rect rect, android.graphics.Rect rect2) {
            android.support.v4.view.GravityCompat.apply(i, i2, i3, rect, rect2, 0);
        }

        @Override // android.support.v4.graphics.drawable.RoundedBitmapDrawable
        public boolean hasMipMap() {
            return this.mBitmap != null && android.support.v4.graphics.BitmapCompat.hasMipMap(this.mBitmap);
        }

        @Override // android.support.v4.graphics.drawable.RoundedBitmapDrawable
        public void setMipMap(boolean z) {
            if (this.mBitmap != null) {
                android.support.v4.graphics.BitmapCompat.setHasMipMap(this.mBitmap, z);
                invalidateSelf();
            }
        }
    }

    private RoundedBitmapDrawableFactory() {
    }

    public static android.support.v4.graphics.drawable.RoundedBitmapDrawable create(android.content.res.Resources resources, android.graphics.Bitmap bitmap) {
        return android.os.Build.VERSION.SDK_INT >= 21 ? new android.support.v4.graphics.drawable.RoundedBitmapDrawable21(resources, bitmap) : new android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory.DefaultRoundedBitmapDrawable(resources, bitmap);
    }

    public static android.support.v4.graphics.drawable.RoundedBitmapDrawable create(android.content.res.Resources resources, java.io.InputStream inputStream) {
        android.support.v4.graphics.drawable.RoundedBitmapDrawable roundedBitmapDrawableCreate = create(resources, android.graphics.BitmapFactory.decodeStream(inputStream));
        if (roundedBitmapDrawableCreate.getBitmap() == null) {
            android.util.Log.w(TAG, "RoundedBitmapDrawable cannot decode " + inputStream);
        }
        return roundedBitmapDrawableCreate;
    }

    public static android.support.v4.graphics.drawable.RoundedBitmapDrawable create(android.content.res.Resources resources, java.lang.String str) {
        android.support.v4.graphics.drawable.RoundedBitmapDrawable roundedBitmapDrawableCreate = create(resources, android.graphics.BitmapFactory.decodeFile(str));
        if (roundedBitmapDrawableCreate.getBitmap() == null) {
            android.util.Log.w(TAG, "RoundedBitmapDrawable cannot decode " + str);
        }
        return roundedBitmapDrawableCreate;
    }
}
