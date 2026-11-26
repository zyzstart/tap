package android.support.v4.graphics;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class BitmapCompat {
    static final android.support.v4.graphics.BitmapCompat.BitmapCompatBaseImpl IMPL;

    @android.support.annotation.RequiresApi(18)
    static class BitmapCompatApi18Impl extends android.support.v4.graphics.BitmapCompat.BitmapCompatBaseImpl {
        BitmapCompatApi18Impl() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.BitmapCompatBaseImpl
        public boolean hasMipMap(android.graphics.Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        @Override // android.support.v4.graphics.BitmapCompat.BitmapCompatBaseImpl
        public void setHasMipMap(android.graphics.Bitmap bitmap, boolean z) {
            bitmap.setHasMipMap(z);
        }
    }

    @android.support.annotation.RequiresApi(19)
    static class BitmapCompatApi19Impl extends android.support.v4.graphics.BitmapCompat.BitmapCompatApi18Impl {
        BitmapCompatApi19Impl() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.BitmapCompatBaseImpl
        public int getAllocationByteCount(android.graphics.Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    static class BitmapCompatBaseImpl {
        BitmapCompatBaseImpl() {
        }

        public int getAllocationByteCount(android.graphics.Bitmap bitmap) {
            return bitmap.getByteCount();
        }

        public boolean hasMipMap(android.graphics.Bitmap bitmap) {
            return false;
        }

        public void setHasMipMap(android.graphics.Bitmap bitmap, boolean z) {
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            IMPL = new android.support.v4.graphics.BitmapCompat.BitmapCompatApi19Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 18) {
            IMPL = new android.support.v4.graphics.BitmapCompat.BitmapCompatApi18Impl();
        } else {
            IMPL = new android.support.v4.graphics.BitmapCompat.BitmapCompatBaseImpl();
        }
    }

    private BitmapCompat() {
    }

    public static int getAllocationByteCount(android.graphics.Bitmap bitmap) {
        return IMPL.getAllocationByteCount(bitmap);
    }

    public static boolean hasMipMap(android.graphics.Bitmap bitmap) {
        return IMPL.hasMipMap(bitmap);
    }

    public static void setHasMipMap(android.graphics.Bitmap bitmap, boolean z) {
        IMPL.setHasMipMap(bitmap, z);
    }
}
