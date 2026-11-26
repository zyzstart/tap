package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class StatItem extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static java.util.ArrayList f1038a;
    public java.util.ArrayList records;
    public int type;

    static {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        f1038a = arrayList;
        arrayList.add("");
    }

    public StatItem() {
        this.type = 0;
        this.records = null;
    }

    public StatItem(int i, java.util.ArrayList arrayList) {
        this.type = 0;
        this.records = null;
        this.type = i;
        this.records = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.records = (java.util.ArrayList) jceInputStream.read((java.lang.Object) f1038a, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write((java.util.Collection) this.records, 1);
    }
}
