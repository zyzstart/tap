package com.tencent.beacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class QimeiPackage extends com.tencent.beacon.core.wup.JceStruct implements java.lang.Cloneable {
    public java.lang.String qimei = "";
    public java.lang.String imei = "";
    public java.lang.String mac = "";
    public java.lang.String imsi = "";
    public java.lang.String androidId = "";
    public java.lang.String model = "";
    public java.lang.String brand = "";
    public java.lang.String osVersion = "";
    public boolean broot = false;
    public java.lang.String qq = "";
    public java.lang.String cid = "";

    protected java.lang.Object clone() {
        return super.clone();
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void readFrom(com.tencent.beacon.core.wup.a aVar) {
        this.qimei = aVar.a(0, false);
        this.imei = aVar.a(1, false);
        this.mac = aVar.a(2, false);
        this.imsi = aVar.a(3, false);
        this.androidId = aVar.a(4, false);
        this.model = aVar.a(5, false);
        this.brand = aVar.a(6, false);
        this.osVersion = aVar.a(7, false);
        this.broot = aVar.a(this.broot, 8, false);
        this.qq = aVar.a(9, false);
        this.cid = aVar.a(10, false);
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void writeTo(com.tencent.beacon.core.wup.b bVar) {
        java.lang.String str = this.qimei;
        if (str != null) {
            bVar.a(str, 0);
        }
        java.lang.String str2 = this.imei;
        if (str2 != null) {
            bVar.a(str2, 1);
        }
        java.lang.String str3 = this.mac;
        if (str3 != null) {
            bVar.a(str3, 2);
        }
        java.lang.String str4 = this.imsi;
        if (str4 != null) {
            bVar.a(str4, 3);
        }
        java.lang.String str5 = this.androidId;
        if (str5 != null) {
            bVar.a(str5, 4);
        }
        java.lang.String str6 = this.model;
        if (str6 != null) {
            bVar.a(str6, 5);
        }
        java.lang.String str7 = this.brand;
        if (str7 != null) {
            bVar.a(str7, 6);
        }
        java.lang.String str8 = this.osVersion;
        if (str8 != null) {
            bVar.a(str8, 7);
        }
        bVar.a(this.broot, 8);
        java.lang.String str9 = this.qq;
        if (str9 != null) {
            bVar.a(str9, 9);
        }
        java.lang.String str10 = this.cid;
        if (str10 != null) {
            bVar.a(str10, 10);
        }
    }
}
