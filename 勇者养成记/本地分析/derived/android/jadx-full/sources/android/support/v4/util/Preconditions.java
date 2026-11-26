package android.support.v4.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class Preconditions {
    public static void checkArgument(boolean z) {
        if (!z) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }

    public static float checkArgumentFinite(float f, java.lang.String str) {
        if (java.lang.Float.isNaN(f)) {
            throw new java.lang.IllegalArgumentException(str + " must not be NaN");
        }
        if (!java.lang.Float.isInfinite(f)) {
            return f;
        }
        throw new java.lang.IllegalArgumentException(str + " must not be infinite");
    }

    public static float checkArgumentInRange(float f, float f2, float f3, java.lang.String str) {
        if (java.lang.Float.isNaN(f)) {
            throw new java.lang.IllegalArgumentException(str + " must not be NaN");
        }
        if (f < f2) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "%s is out of range of [%f, %f] (too low)", str, java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3)));
        }
        if (f <= f3) {
            return f;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "%s is out of range of [%f, %f] (too high)", str, java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3)));
    }

    public static int checkArgumentInRange(int i, int i2, int i3, java.lang.String str) {
        if (i < i2) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "%s is out of range of [%d, %d] (too low)", str, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)));
        }
        if (i <= i3) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "%s is out of range of [%d, %d] (too high)", str, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)));
    }

    public static long checkArgumentInRange(long j, long j2, long j3, java.lang.String str) {
        if (j < j2) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "%s is out of range of [%d, %d] (too low)", str, java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3)));
        }
        if (j <= j3) {
            return j;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "%s is out of range of [%d, %d] (too high)", str, java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3)));
    }

    @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED)
    public static int checkArgumentNonnegative(int i) {
        if (i >= 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException();
    }

    @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED)
    public static int checkArgumentNonnegative(int i, java.lang.String str) {
        if (i >= 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(str);
    }

    public static long checkArgumentNonnegative(long j) {
        if (j >= 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException();
    }

    public static long checkArgumentNonnegative(long j, java.lang.String str) {
        if (j >= 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException(str);
    }

    public static int checkArgumentPositive(int i, java.lang.String str) {
        if (i > 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(str);
    }

    public static float[] checkArrayElementsInRange(float[] fArr, float f, float f2, java.lang.String str) {
        checkNotNull(fArr, str + " must not be null");
        for (int i = 0; i < fArr.length; i++) {
            float f3 = fArr[i];
            if (java.lang.Float.isNaN(f3)) {
                throw new java.lang.IllegalArgumentException(str + "[" + i + "] must not be NaN");
            }
            if (f3 < f) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "%s[%d] is out of range of [%f, %f] (too low)", str, java.lang.Integer.valueOf(i), java.lang.Float.valueOf(f), java.lang.Float.valueOf(f2)));
            }
            if (f3 > f2) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "%s[%d] is out of range of [%f, %f] (too high)", str, java.lang.Integer.valueOf(i), java.lang.Float.valueOf(f), java.lang.Float.valueOf(f2)));
            }
        }
        return fArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T[] checkArrayElementsNotNull(T[] tArr, java.lang.String str) {
        if (tArr == null) {
            throw new java.lang.NullPointerException(str + " must not be null");
        }
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] == null) {
                throw new java.lang.NullPointerException(java.lang.String.format(java.util.Locale.US, "%s[%d] must not be null", str, java.lang.Integer.valueOf(i)));
            }
        }
        return tArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.support.annotation.NonNull
    public static <C extends java.util.Collection<T>, T> C checkCollectionElementsNotNull(C c, java.lang.String str) {
        if (c == null) {
            throw new java.lang.NullPointerException(str + " must not be null");
        }
        long j = 0;
        java.util.Iterator it = c.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new java.lang.NullPointerException(java.lang.String.format(java.util.Locale.US, "%s[%d] must not be null", str, java.lang.Long.valueOf(j)));
            }
            j++;
        }
        return c;
    }

    public static <T> java.util.Collection<T> checkCollectionNotEmpty(java.util.Collection<T> collection, java.lang.String str) {
        if (collection == null) {
            throw new java.lang.NullPointerException(str + " must not be null");
        }
        if (!collection.isEmpty()) {
            return collection;
        }
        throw new java.lang.IllegalArgumentException(str + " is empty");
    }

    public static int checkFlagsArgument(int i, int i2) {
        if ((i & i2) == i) {
            return i;
        }
        throw new java.lang.IllegalArgumentException("Requested flags 0x" + java.lang.Integer.toHexString(i) + ", but only 0x" + java.lang.Integer.toHexString(i2) + " are allowed");
    }

    @android.support.annotation.NonNull
    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException();
    }

    @android.support.annotation.NonNull
    public static <T> T checkNotNull(T t, java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    public static void checkState(boolean z) {
        checkState(z, null);
    }

    public static void checkState(boolean z, java.lang.String str) {
        if (!z) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    @android.support.annotation.NonNull
    public static <T extends java.lang.CharSequence> T checkStringNotEmpty(T t) {
        if (android.text.TextUtils.isEmpty(t)) {
            throw new java.lang.IllegalArgumentException();
        }
        return t;
    }

    @android.support.annotation.NonNull
    public static <T extends java.lang.CharSequence> T checkStringNotEmpty(T t, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(t)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
        return t;
    }
}
