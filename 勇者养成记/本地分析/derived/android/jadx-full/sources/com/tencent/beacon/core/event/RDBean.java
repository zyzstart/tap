package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RDBean implements java.io.Serializable {
    public static final java.lang.String TP_DN = "DN";
    public static final java.lang.String TP_HO = "HO";
    public static final java.lang.String TP_IP = "IP";
    public static final java.lang.String TP_UA = "UA";
    private static final long serialVersionUID = 1;
    private long elapse;
    private java.util.Map emap;
    private java.lang.String en;
    private boolean immediatelyUpload;
    private long size;
    private long tm;
    private java.lang.String tp;
    private long cid = -1;
    private boolean eventResult = true;
    private java.lang.String srcIp = "";
    private java.lang.String apn = "";

    public java.lang.String getApn() {
        return this.apn;
    }

    public synchronized long getCid() {
        return this.cid;
    }

    public synchronized java.util.Map getEMap() {
        return this.emap;
    }

    public synchronized java.lang.String getEN() {
        return this.en;
    }

    public long getElapse() {
        return this.elapse;
    }

    public long getSize() {
        return this.size;
    }

    public java.lang.String getSrcIp() {
        return this.srcIp;
    }

    public synchronized long getTM() {
        return this.tm;
    }

    public synchronized java.lang.String getTP() {
        return this.tp;
    }

    public boolean isEventResult() {
        return this.eventResult;
    }

    public boolean isImmediatelyUpload() {
        return this.immediatelyUpload;
    }

    public void setApn(java.lang.String str) {
        this.apn = str;
    }

    public synchronized void setCid(long j) {
        this.cid = j;
    }

    public synchronized void setEMap(java.util.Map map) {
        this.emap = map;
    }

    public synchronized void setEN(java.lang.String str) {
        this.en = str;
    }

    public void setElapse(long j) {
        this.elapse = j;
    }

    public void setEventResult(boolean z) {
        this.eventResult = z;
    }

    public void setImmediatelyUpload(boolean z) {
        this.immediatelyUpload = z;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setSrcIp(java.lang.String str) {
        this.srcIp = str;
    }

    public synchronized void setTM(long j) {
        this.tm = j;
    }

    public synchronized void setTP(java.lang.String str) {
        this.tp = str;
    }
}
