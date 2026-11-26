package com.tencent.ydkbeacon.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class EventBean implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    private java.lang.String apn;
    private java.lang.String appKey;
    private byte[] byteValue;
    private java.lang.String eventCode;
    private long eventTime;
    private int eventType;
    private java.util.Map eventValue;
    private java.lang.String reserved;
    private java.lang.String srcIp;
    private int valueType;
    private long cid = -1;
    private boolean eventResult = true;

    public java.lang.String getApn() {
        return this.apn;
    }

    public java.lang.String getAppKey() {
        return this.appKey;
    }

    public byte[] getByteValue() {
        return this.byteValue;
    }

    public long getCid() {
        return this.cid;
    }

    public java.lang.String getEventCode() {
        return this.eventCode;
    }

    public boolean getEventResult() {
        return this.eventResult;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public int getEventType() {
        return this.eventType;
    }

    public java.util.Map getEventValue() {
        return this.eventValue;
    }

    public java.lang.String getReserved() {
        return this.reserved;
    }

    public java.lang.String getSrcIp() {
        return this.srcIp;
    }

    public int getValueType() {
        return this.valueType;
    }

    public void setApn(java.lang.String str) {
        this.apn = str;
    }

    public void setAppKey(java.lang.String str) {
        this.appKey = str;
    }

    public void setByteValue(byte[] bArr) {
        this.byteValue = bArr;
    }

    public void setCid(long j) {
        this.cid = j;
    }

    public void setEventCode(java.lang.String str) {
        this.eventCode = str;
    }

    public void setEventResult(boolean z) {
        this.eventResult = z;
    }

    public void setEventTime(long j) {
        this.eventTime = j;
    }

    public void setEventType(int i) {
        this.eventType = i;
    }

    public void setEventValue(java.util.Map map) {
        this.eventValue = map;
    }

    public void setReserved(java.lang.String str) {
        this.reserved = str;
    }

    public void setSrcIp(java.lang.String str) {
        this.srcIp = str;
    }

    public void setValueType(int i) {
        this.valueType = i;
    }
}
