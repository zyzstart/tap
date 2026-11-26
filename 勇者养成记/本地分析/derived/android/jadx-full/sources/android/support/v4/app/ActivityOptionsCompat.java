package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ActivityOptionsCompat {
    public static final java.lang.String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final java.lang.String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    @android.support.annotation.RequiresApi(16)
    private static class ActivityOptionsCompatApi16Impl extends android.support.v4.app.ActivityOptionsCompat {
        protected final android.app.ActivityOptions mActivityOptions;

        ActivityOptionsCompatApi16Impl(android.app.ActivityOptions activityOptions) {
            this.mActivityOptions = activityOptions;
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public android.os.Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void update(android.support.v4.app.ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi16Impl) {
                this.mActivityOptions.update(((android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi16Impl) activityOptionsCompat).mActivityOptions);
            }
        }
    }

    @android.support.annotation.RequiresApi(23)
    private static class ActivityOptionsCompatApi23Impl extends android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi16Impl {
        ActivityOptionsCompatApi23Impl(android.app.ActivityOptions activityOptions) {
            super(activityOptions);
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void requestUsageTimeReport(android.app.PendingIntent pendingIntent) {
            this.mActivityOptions.requestUsageTimeReport(pendingIntent);
        }
    }

    @android.support.annotation.RequiresApi(24)
    private static class ActivityOptionsCompatApi24Impl extends android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi23Impl {
        ActivityOptionsCompatApi24Impl(android.app.ActivityOptions activityOptions) {
            super(activityOptions);
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public android.graphics.Rect getLaunchBounds() {
            return this.mActivityOptions.getLaunchBounds();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public android.support.v4.app.ActivityOptionsCompat setLaunchBounds(@android.support.annotation.Nullable android.graphics.Rect rect) {
            return new android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi24Impl(this.mActivityOptions.setLaunchBounds(rect));
        }
    }

    protected ActivityOptionsCompat() {
    }

    @android.support.annotation.RequiresApi(16)
    private static android.support.v4.app.ActivityOptionsCompat createImpl(android.app.ActivityOptions activityOptions) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return new android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi24Impl(activityOptions);
        }
        return android.os.Build.VERSION.SDK_INT >= 23 ? new android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi23Impl(activityOptions) : new android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi16Impl(activityOptions);
    }

    public static android.support.v4.app.ActivityOptionsCompat makeBasic() {
        return android.os.Build.VERSION.SDK_INT >= 23 ? createImpl(android.app.ActivityOptions.makeBasic()) : new android.support.v4.app.ActivityOptionsCompat();
    }

    public static android.support.v4.app.ActivityOptionsCompat makeClipRevealAnimation(android.view.View view, int i, int i2, int i3, int i4) {
        return android.os.Build.VERSION.SDK_INT >= 23 ? createImpl(android.app.ActivityOptions.makeClipRevealAnimation(view, i, i2, i3, i4)) : new android.support.v4.app.ActivityOptionsCompat();
    }

    public static android.support.v4.app.ActivityOptionsCompat makeCustomAnimation(android.content.Context context, int i, int i2) {
        return android.os.Build.VERSION.SDK_INT >= 16 ? createImpl(android.app.ActivityOptions.makeCustomAnimation(context, i, i2)) : new android.support.v4.app.ActivityOptionsCompat();
    }

    public static android.support.v4.app.ActivityOptionsCompat makeScaleUpAnimation(android.view.View view, int i, int i2, int i3, int i4) {
        return android.os.Build.VERSION.SDK_INT >= 16 ? createImpl(android.app.ActivityOptions.makeScaleUpAnimation(view, i, i2, i3, i4)) : new android.support.v4.app.ActivityOptionsCompat();
    }

    public static android.support.v4.app.ActivityOptionsCompat makeSceneTransitionAnimation(android.app.Activity activity, android.view.View view, java.lang.String str) {
        return android.os.Build.VERSION.SDK_INT >= 21 ? createImpl(android.app.ActivityOptions.makeSceneTransitionAnimation(activity, view, str)) : new android.support.v4.app.ActivityOptionsCompat();
    }

    public static android.support.v4.app.ActivityOptionsCompat makeSceneTransitionAnimation(android.app.Activity activity, android.support.v4.util.Pair<android.view.View, java.lang.String>... pairArr) {
        if (android.os.Build.VERSION.SDK_INT < 21) {
            return new android.support.v4.app.ActivityOptionsCompat();
        }
        android.util.Pair[] pairArr2 = null;
        if (pairArr != null) {
            pairArr2 = new android.util.Pair[pairArr.length];
            for (int i = 0; i < pairArr.length; i++) {
                pairArr2[i] = android.util.Pair.create(pairArr[i].first, pairArr[i].second);
            }
        }
        return createImpl(android.app.ActivityOptions.makeSceneTransitionAnimation(activity, pairArr2));
    }

    public static android.support.v4.app.ActivityOptionsCompat makeTaskLaunchBehind() {
        return android.os.Build.VERSION.SDK_INT >= 21 ? createImpl(android.app.ActivityOptions.makeTaskLaunchBehind()) : new android.support.v4.app.ActivityOptionsCompat();
    }

    public static android.support.v4.app.ActivityOptionsCompat makeThumbnailScaleUpAnimation(android.view.View view, android.graphics.Bitmap bitmap, int i, int i2) {
        return android.os.Build.VERSION.SDK_INT >= 16 ? createImpl(android.app.ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i, i2)) : new android.support.v4.app.ActivityOptionsCompat();
    }

    @android.support.annotation.Nullable
    public android.graphics.Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(android.app.PendingIntent pendingIntent) {
    }

    public android.support.v4.app.ActivityOptionsCompat setLaunchBounds(@android.support.annotation.Nullable android.graphics.Rect rect) {
        return null;
    }

    public android.os.Bundle toBundle() {
        return null;
    }

    public void update(android.support.v4.app.ActivityOptionsCompat activityOptionsCompat) {
    }
}
