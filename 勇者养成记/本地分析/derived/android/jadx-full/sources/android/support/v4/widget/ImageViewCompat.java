package android.support.v4.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ImageViewCompat {
    static final android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl IMPL;

    static class BaseViewCompatImpl implements android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl {
        BaseViewCompatImpl() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        public android.content.res.ColorStateList getImageTintList(android.widget.ImageView imageView) {
            if (imageView instanceof android.support.v4.widget.TintableImageSourceView) {
                return ((android.support.v4.widget.TintableImageSourceView) imageView).getSupportImageTintList();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        public android.graphics.PorterDuff.Mode getImageTintMode(android.widget.ImageView imageView) {
            if (imageView instanceof android.support.v4.widget.TintableImageSourceView) {
                return ((android.support.v4.widget.TintableImageSourceView) imageView).getSupportImageTintMode();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        public void setImageTintList(android.widget.ImageView imageView, android.content.res.ColorStateList colorStateList) {
            if (imageView instanceof android.support.v4.widget.TintableImageSourceView) {
                ((android.support.v4.widget.TintableImageSourceView) imageView).setSupportImageTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        public void setImageTintMode(android.widget.ImageView imageView, android.graphics.PorterDuff.Mode mode) {
            if (imageView instanceof android.support.v4.widget.TintableImageSourceView) {
                ((android.support.v4.widget.TintableImageSourceView) imageView).setSupportImageTintMode(mode);
            }
        }
    }

    interface ImageViewCompatImpl {
        android.content.res.ColorStateList getImageTintList(android.widget.ImageView imageView);

        android.graphics.PorterDuff.Mode getImageTintMode(android.widget.ImageView imageView);

        void setImageTintList(android.widget.ImageView imageView, android.content.res.ColorStateList colorStateList);

        void setImageTintMode(android.widget.ImageView imageView, android.graphics.PorterDuff.Mode mode);
    }

    @android.support.annotation.RequiresApi(21)
    static class LollipopViewCompatImpl extends android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl {
        LollipopViewCompatImpl() {
        }

        @Override // android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl, android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        public android.content.res.ColorStateList getImageTintList(android.widget.ImageView imageView) {
            return imageView.getImageTintList();
        }

        @Override // android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl, android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        public android.graphics.PorterDuff.Mode getImageTintMode(android.widget.ImageView imageView) {
            return imageView.getImageTintMode();
        }

        @Override // android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl, android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        public void setImageTintList(android.widget.ImageView imageView, android.content.res.ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
            if (android.os.Build.VERSION.SDK_INT == 21) {
                android.graphics.drawable.Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable == null || !z) {
                    return;
                }
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        }

        @Override // android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl, android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        public void setImageTintMode(android.widget.ImageView imageView, android.graphics.PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
            if (android.os.Build.VERSION.SDK_INT == 21) {
                android.graphics.drawable.Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable == null || !z) {
                    return;
                }
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.widget.ImageViewCompat.LollipopViewCompatImpl();
        } else {
            IMPL = new android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl();
        }
    }

    private ImageViewCompat() {
    }

    public static android.content.res.ColorStateList getImageTintList(android.widget.ImageView imageView) {
        return IMPL.getImageTintList(imageView);
    }

    public static android.graphics.PorterDuff.Mode getImageTintMode(android.widget.ImageView imageView) {
        return IMPL.getImageTintMode(imageView);
    }

    public static void setImageTintList(android.widget.ImageView imageView, android.content.res.ColorStateList colorStateList) {
        IMPL.setImageTintList(imageView, colorStateList);
    }

    public static void setImageTintMode(android.widget.ImageView imageView, android.graphics.PorterDuff.Mode mode) {
        IMPL.setImageTintMode(imageView, mode);
    }
}
