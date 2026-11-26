package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class r implements com.tencent.turingfd.sdk.ams.ad.InterfaceC0085a {
    public static final byte[] ya = new byte[0];
    public final java.lang.String qa;
    public final long ra;
    public final int sa;
    public final byte[] ta;
    public final java.lang.String ua;
    public final java.lang.String va;
    public final java.lang.String wa;
    public final java.lang.String xa;

    public static final class a {
        public java.lang.String qa;
        public long ra;
        public int sa;
        public byte[] ta;
        public java.lang.String ua;
        public java.lang.String va;
        public java.lang.String wa;
        public java.lang.String xa;

        public /* synthetic */ a(int i, com.tencent.turingfd.sdk.ams.ad.q qVar) {
            this.sa = i;
        }

        public com.tencent.turingfd.sdk.ams.ad.r.a a(long j) {
            this.ra = j;
            return this;
        }

        public com.tencent.turingfd.sdk.ams.ad.r build() {
            return new com.tencent.turingfd.sdk.ams.ad.r(this);
        }

        public com.tencent.turingfd.sdk.ams.ad.r.a d(java.lang.String str) {
            this.ua = str;
            return this;
        }

        public com.tencent.turingfd.sdk.ams.ad.r.a e(java.lang.String str) {
            this.xa = str;
            return this;
        }

        public com.tencent.turingfd.sdk.ams.ad.r.a f(java.lang.String str) {
            this.qa = str;
            return this;
        }

        public com.tencent.turingfd.sdk.ams.ad.r.a g(java.lang.String str) {
            this.va = str;
            return this;
        }

        public com.tencent.turingfd.sdk.ams.ad.r.a h(java.lang.String str) {
            this.wa = str;
            return this;
        }
    }

    public r(int i, byte[] bArr) {
        this.qa = "";
        this.ra = 0L;
        this.sa = i;
        this.ta = bArr;
        this.ua = "";
        this.va = "";
        this.wa = "";
        this.xa = "";
    }

    public r(com.tencent.turingfd.sdk.ams.ad.r.a aVar) {
        this.qa = aVar.qa;
        this.ra = aVar.ra;
        this.sa = aVar.sa;
        this.ta = aVar.ta;
        this.ua = aVar.ua;
        this.va = aVar.va;
        this.wa = aVar.wa;
        this.xa = aVar.xa;
    }

    public static com.tencent.turingfd.sdk.ams.ad.r a(int i) {
        return new com.tencent.turingfd.sdk.ams.ad.r(i, ya);
    }

    public static com.tencent.turingfd.sdk.ams.ad.r.a create(int i) {
        return new com.tencent.turingfd.sdk.ams.ad.r.a(i, null);
    }

    public long g() {
        return this.ra;
    }
}
