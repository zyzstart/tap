package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(19)
class RatingCompatKitkat {
    RatingCompatKitkat() {
    }

    public static float getPercentRating(java.lang.Object obj) {
        return ((android.media.Rating) obj).getPercentRating();
    }

    public static int getRatingStyle(java.lang.Object obj) {
        return ((android.media.Rating) obj).getRatingStyle();
    }

    public static float getStarRating(java.lang.Object obj) {
        return ((android.media.Rating) obj).getStarRating();
    }

    public static boolean hasHeart(java.lang.Object obj) {
        return ((android.media.Rating) obj).hasHeart();
    }

    public static boolean isRated(java.lang.Object obj) {
        return ((android.media.Rating) obj).isRated();
    }

    public static boolean isThumbUp(java.lang.Object obj) {
        return ((android.media.Rating) obj).isThumbUp();
    }

    public static java.lang.Object newHeartRating(boolean z) {
        return android.media.Rating.newHeartRating(z);
    }

    public static java.lang.Object newPercentageRating(float f) {
        return android.media.Rating.newPercentageRating(f);
    }

    public static java.lang.Object newStarRating(int i, float f) {
        return android.media.Rating.newStarRating(i, f);
    }

    public static java.lang.Object newThumbRating(boolean z) {
        return android.media.Rating.newThumbRating(z);
    }

    public static java.lang.Object newUnratedRating(int i) {
        return android.media.Rating.newUnratedRating(i);
    }
}
