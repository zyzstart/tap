package com.tencent.ysdk.shell.framework.channel;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public static <A, B> com.tencent.ysdk.shell.framework.channel.Pair<A, B> create(A a2, B b) {
        return new com.tencent.ysdk.shell.framework.channel.Pair<>(a2, b);
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.tencent.ysdk.shell.framework.channel.Pair)) {
            return false;
        }
        com.tencent.ysdk.shell.framework.channel.Pair pair = (com.tencent.ysdk.shell.framework.channel.Pair) obj;
        return java.util.Objects.equals(pair.first, this.first) && java.util.Objects.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f = this.first;
        int iHashCode = f == null ? 0 : f.hashCode();
        S s = this.second;
        return iHashCode ^ (s != null ? s.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
