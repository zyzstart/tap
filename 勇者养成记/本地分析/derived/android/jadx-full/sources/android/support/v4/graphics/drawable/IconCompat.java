package android.support.v4.graphics.drawable;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconCompat {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final int TYPE_ADAPTIVE_BITMAP = 5;
    private static final int TYPE_BITMAP = 1;
    private static final int TYPE_DATA = 3;
    private static final int TYPE_RESOURCE = 2;
    private static final int TYPE_URI = 4;
    private int mInt1;
    private int mInt2;
    private java.lang.Object mObj1;
    private final int mType;

    private IconCompat(int i) {
        this.mType = i;
    }

    @android.support.annotation.VisibleForTesting
    static android.graphics.Bitmap createLegacyIconFromAdaptiveIcon(android.graphics.Bitmap bitmap) {
        int iMin = (int) (java.lang.Math.min(bitmap.getWidth(), bitmap.getHeight()) * DEFAULT_VIEW_PORT_SCALE);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(iMin, iMin, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        android.graphics.Paint paint = new android.graphics.Paint(3);
        float f = iMin;
        float f2 = 0.5f * f;
        float f3 = ICON_DIAMETER_FACTOR * f2;
        float f4 = BLUR_FACTOR * f;
        paint.setColor(0);
        paint.setShadowLayer(f4, 0.0f, f * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
        canvas.drawCircle(f2, f2, f3, paint);
        paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
        canvas.drawCircle(f2, f2, f3, paint);
        paint.clearShadowLayer();
        paint.setColor(-16777216);
        android.graphics.BitmapShader bitmapShader = new android.graphics.BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2, (-(bitmap.getHeight() - iMin)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static android.support.v4.graphics.drawable.IconCompat createWithAdaptiveBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            throw new java.lang.IllegalArgumentException("Bitmap must not be null.");
        }
        android.support.v4.graphics.drawable.IconCompat iconCompat = new android.support.v4.graphics.drawable.IconCompat(5);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    public static android.support.v4.graphics.drawable.IconCompat createWithBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            throw new java.lang.IllegalArgumentException("Bitmap must not be null.");
        }
        android.support.v4.graphics.drawable.IconCompat iconCompat = new android.support.v4.graphics.drawable.IconCompat(1);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    public static android.support.v4.graphics.drawable.IconCompat createWithContentUri(android.net.Uri uri) {
        if (uri != null) {
            return createWithContentUri(uri.toString());
        }
        throw new java.lang.IllegalArgumentException("Uri must not be null.");
    }

    public static android.support.v4.graphics.drawable.IconCompat createWithContentUri(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("Uri must not be null.");
        }
        android.support.v4.graphics.drawable.IconCompat iconCompat = new android.support.v4.graphics.drawable.IconCompat(4);
        iconCompat.mObj1 = str;
        return iconCompat;
    }

    public static android.support.v4.graphics.drawable.IconCompat createWithData(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new java.lang.IllegalArgumentException("Data must not be null.");
        }
        android.support.v4.graphics.drawable.IconCompat iconCompat = new android.support.v4.graphics.drawable.IconCompat(3);
        iconCompat.mObj1 = bArr;
        iconCompat.mInt1 = i;
        iconCompat.mInt2 = i2;
        return iconCompat;
    }

    public static android.support.v4.graphics.drawable.IconCompat createWithResource(android.content.Context context, @android.support.annotation.DrawableRes int i) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Context must not be null.");
        }
        android.support.v4.graphics.drawable.IconCompat iconCompat = new android.support.v4.graphics.drawable.IconCompat(2);
        iconCompat.mInt1 = i;
        iconCompat.mObj1 = context;
        return iconCompat;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void addToShortcutIntent(android.content.Intent intent) {
        int i = this.mType;
        if (i == 5) {
            intent.putExtra("android.intent.extra.shortcut.ICON", createLegacyIconFromAdaptiveIcon((android.graphics.Bitmap) this.mObj1));
            return;
        }
        switch (i) {
            case 1:
                intent.putExtra("android.intent.extra.shortcut.ICON", (android.graphics.Bitmap) this.mObj1);
                return;
            case 2:
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", android.content.Intent.ShortcutIconResource.fromContext((android.content.Context) this.mObj1, this.mInt1));
                return;
            default:
                throw new java.lang.IllegalArgumentException("Icon type not supported for intent shortcuts");
        }
    }

    @android.annotation.TargetApi(26)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public android.graphics.drawable.Icon toIcon() {
        switch (this.mType) {
            case 1:
                return android.graphics.drawable.Icon.createWithBitmap((android.graphics.Bitmap) this.mObj1);
            case 2:
                return android.graphics.drawable.Icon.createWithResource((android.content.Context) this.mObj1, this.mInt1);
            case 3:
                return android.graphics.drawable.Icon.createWithData((byte[]) this.mObj1, this.mInt1, this.mInt2);
            case 4:
                return android.graphics.drawable.Icon.createWithContentUri((java.lang.String) this.mObj1);
            case 5:
                return android.os.Build.VERSION.SDK_INT >= 26 ? android.graphics.drawable.Icon.createWithAdaptiveBitmap((android.graphics.Bitmap) this.mObj1) : android.graphics.drawable.Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon((android.graphics.Bitmap) this.mObj1));
            default:
                throw new java.lang.IllegalArgumentException("Unknown type");
        }
    }
}
