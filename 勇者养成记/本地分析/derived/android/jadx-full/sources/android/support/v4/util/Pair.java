package android.support.v4.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public static <A, B> android.support.v4.util.Pair<A, B> create(A a2, B b) {
        return new android.support.v4.util.Pair<>(a2, b);
    }

    private static boolean objectsEqual(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof android.support.v4.util.Pair)) {
            return false;
        }
        android.support.v4.util.Pair pair = (android.support.v4.util.Pair) obj;
        return objectsEqual(pair.first, this.first) && objectsEqual(pair.second, this.second);
    }

    public int hashCode() {
        F f = this.first;
        int iHashCode = f == null ? 0 : f.hashCode();
        S s = this.second;
        return iHashCode ^ (s != null ? s.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "Pair{" + java.lang.String.valueOf(this.first) + " " + java.lang.String.valueOf(this.second) + "}";
    }
}
