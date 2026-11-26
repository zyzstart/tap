package android.support.v4.content;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    public static java.lang.String matches(@android.support.annotation.Nullable java.lang.String str, @android.support.annotation.NonNull java.lang.String[] strArr) {
        if (str == null) {
            return null;
        }
        java.lang.String[] strArrSplit = str.split("/");
        for (java.lang.String str2 : strArr) {
            if (mimeTypeAgainstFilter(strArrSplit, str2.split("/"))) {
                return str2;
            }
        }
        return null;
    }

    public static java.lang.String matches(@android.support.annotation.Nullable java.lang.String[] strArr, @android.support.annotation.NonNull java.lang.String str) {
        if (strArr == null) {
            return null;
        }
        java.lang.String[] strArrSplit = str.split("/");
        for (java.lang.String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split("/"), strArrSplit)) {
                return str2;
            }
        }
        return null;
    }

    public static boolean matches(@android.support.annotation.Nullable java.lang.String str, @android.support.annotation.NonNull java.lang.String str2) {
        if (str == null) {
            return false;
        }
        return mimeTypeAgainstFilter(str.split("/"), str2.split("/"));
    }

    public static java.lang.String[] matchesMany(@android.support.annotation.Nullable java.lang.String[] strArr, @android.support.annotation.NonNull java.lang.String str) {
        if (strArr == null) {
            return new java.lang.String[0];
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String[] strArrSplit = str.split("/");
        for (java.lang.String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split("/"), strArrSplit)) {
                arrayList.add(str2);
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    private static boolean mimeTypeAgainstFilter(@android.support.annotation.NonNull java.lang.String[] strArr, @android.support.annotation.NonNull java.lang.String[] strArr2) {
        if (strArr2.length != 2) {
            throw new java.lang.IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        }
        if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
            throw new java.lang.IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        }
        if (strArr.length != 2) {
            return false;
        }
        if ("*".equals(strArr2[0]) || strArr2[0].equals(strArr[0])) {
            return "*".equals(strArr2[1]) || strArr2[1].equals(strArr[1]);
        }
        return false;
    }
}
