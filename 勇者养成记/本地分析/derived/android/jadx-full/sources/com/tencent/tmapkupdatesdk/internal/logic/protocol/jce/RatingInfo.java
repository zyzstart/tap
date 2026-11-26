package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class RatingInfo extends com.qq.taf.jce.JceStruct {
    static java.util.Map cache_ratingDistribution;
    public long ratingCount = 0;
    public double averageRating = 0.0d;
    public java.util.Map ratingDistribution = null;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.ratingCount = jceInputStream.read(this.ratingCount, 0, true);
        this.averageRating = jceInputStream.read(this.averageRating, 1, true);
        if (cache_ratingDistribution == null) {
            cache_ratingDistribution = new java.util.HashMap();
            cache_ratingDistribution.put(0, 0L);
        }
        this.ratingDistribution = (java.util.Map) jceInputStream.read((java.lang.Object) cache_ratingDistribution, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ratingCount, 0);
        jceOutputStream.write(this.averageRating, 1);
        jceOutputStream.write(this.ratingDistribution, 2);
    }
}
