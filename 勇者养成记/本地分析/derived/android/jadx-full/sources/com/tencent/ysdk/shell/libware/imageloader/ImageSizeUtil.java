package com.tencent.ysdk.shell.libware.imageloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ImageSizeUtil {

    public static class ImageSize {
        int height;
        int width;
    }

    public static int caculateInSampleSize(android.graphics.BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 > i || i4 > i2) {
            return java.lang.Math.max(java.lang.Math.round((i3 * 1.0f) / i), java.lang.Math.round((i4 * 1.0f) / i2));
        }
        return 1;
    }

    private static int getImageViewFieldValue(java.lang.Object obj, java.lang.String str) {
        try {
            java.lang.reflect.Field declaredField = android.widget.ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(obj);
            if (i <= 0 || i >= Integer.MAX_VALUE) {
                return 0;
            }
            return i;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static com.tencent.ysdk.shell.libware.imageloader.ImageSizeUtil.ImageSize getImageViewSize(android.widget.ImageView imageView) {
        android.util.DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        android.view.ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = imageView.getWidth();
        if (width <= 0) {
            width = layoutParams.width;
        }
        if (width <= 0) {
            width = getImageViewFieldValue(imageView, "mMaxWidth");
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        int height = imageView.getHeight();
        if (height <= 0) {
            height = layoutParams.height;
        }
        if (height <= 0) {
            height = getImageViewFieldValue(imageView, "mMaxHeight");
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        com.tencent.ysdk.shell.libware.imageloader.ImageSizeUtil.ImageSize imageSize = new com.tencent.ysdk.shell.libware.imageloader.ImageSizeUtil.ImageSize();
        imageSize.width = width;
        imageSize.height = height;
        return imageSize;
    }
}
