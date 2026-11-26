package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TuringDIDConfig extends com.tencent.turingfd.sdk.ams.ad.C0087c {

    public static final class Builder {
        public android.content.Context j;
        public int k = 1;
        public java.lang.String l = "";
        public int m = com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING;
        public int n = 3;
        public java.lang.String o = "";

        public /* synthetic */ Builder(android.content.Context context, com.tencent.turingfd.sdk.ams.ad.C0089e c0089e) {
            this.j = context.getApplicationContext();
        }

        public final com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig.Builder appid(java.lang.String str) {
            this.o = str;
            return this;
        }

        public com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig build() {
            return new com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig(this, null);
        }

        public final com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig.Builder retryTime(int i) {
            this.n = i;
            return this;
        }

        public final com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig.Builder timeout(int i) {
            this.m = i;
            return this;
        }
    }

    public /* synthetic */ TuringDIDConfig(com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig.Builder builder, com.tencent.turingfd.sdk.ams.ad.C0089e c0089e) {
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
        this.o = builder.o;
    }

    public static com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig createDefault(android.content.Context context) {
        return new com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig.Builder(context, null).build();
    }

    public static com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig.Builder newBuilder(android.content.Context context) {
        return new com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig.Builder(context, null);
    }
}
