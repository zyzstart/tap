package com.tencent.beacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class Qimei {
    private java.util.Map qimeiMap;
    private java.lang.String qimeiNew;
    private java.lang.String qimeiOld;

    public Qimei() {
        this("", "", null);
    }

    public Qimei(java.lang.String str) {
        this(str, "", null);
    }

    public Qimei(java.lang.String str, java.lang.String str2, java.util.Map map) {
        this.qimeiOld = str == null ? "" : str;
        this.qimeiNew = str2 == null ? "" : str2;
        this.qimeiMap = map;
    }

    public java.util.Map getQimeiMap() {
        return this.qimeiMap;
    }

    public java.lang.String getQimeiNew() {
        return this.qimeiNew;
    }

    public java.lang.String getQimeiOld() {
        return this.qimeiOld;
    }

    void setQimeiMap(java.util.Map map) {
        this.qimeiMap = map;
    }

    void setQimeiNew(java.lang.String str) {
        this.qimeiNew = str;
    }

    void setQimeiOld(java.lang.String str) {
        this.qimeiOld = str;
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Qimei:");
        sb.append(this.qimeiOld);
        if (android.text.TextUtils.isEmpty(this.qimeiNew)) {
            str = "";
        } else {
            str = "\nQimei3:" + this.qimeiNew;
        }
        sb.append(str);
        return sb.toString();
    }
}
