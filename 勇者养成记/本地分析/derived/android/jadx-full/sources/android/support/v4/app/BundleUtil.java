package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class BundleUtil {
    BundleUtil() {
    }

    public static android.os.Bundle[] getBundleArrayFromBundle(android.os.Bundle bundle, java.lang.String str) {
        android.os.Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof android.os.Bundle[]) || parcelableArray == null) {
            return (android.os.Bundle[]) parcelableArray;
        }
        android.os.Bundle[] bundleArr = (android.os.Bundle[]) java.util.Arrays.copyOf(parcelableArray, parcelableArray.length, android.os.Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }
}
