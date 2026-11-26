package com.tencent.beacon.core.protocol.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class RequestPackage extends com.tencent.beacon.core.wup.JceStruct {
    static byte[] cache_sBuffer;
    public java.lang.String appVersion;
    public java.lang.String appkey;
    public int cmd;
    public byte encryType;
    public java.lang.String model;
    public java.lang.String osVersion;
    public byte platformId;
    public java.lang.String reserved;
    public byte[] sBuffer;
    public java.lang.String sdkId;
    public java.lang.String sdkVersion;
    public byte zipType;

    public RequestPackage() {
        this.platformId = (byte) 0;
        this.appkey = "[REDACTED]";
        this.appVersion = "";
        this.sdkId = "";
        this.sdkVersion = "";
        this.cmd = 0;
        this.sBuffer = null;
        this.encryType = (byte) 0;
        this.zipType = (byte) 0;
        this.model = "";
        this.osVersion = "";
        this.reserved = "";
    }

    public RequestPackage(byte b, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, byte[] bArr, byte b2, byte b3, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        this.platformId = (byte) 0;
        this.appkey = "[REDACTED]";
        this.appVersion = "";
        this.sdkId = "";
        this.sdkVersion = "";
        this.cmd = 0;
        this.sBuffer = null;
        this.encryType = (byte) 0;
        this.zipType = (byte) 0;
        this.model = "";
        this.osVersion = "";
        this.reserved = "";
        this.platformId = b;
        this.appkey = str;
        this.appVersion = str2;
        this.sdkId = str3;
        this.sdkVersion = str4;
        this.cmd = i;
        this.sBuffer = bArr;
        this.encryType = b2;
        this.zipType = b3;
        this.model = str5;
        this.osVersion = str6;
        this.reserved = str7;
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void readFrom(com.tencent.beacon.core.wup.a aVar) {
        this.platformId = aVar.a(this.platformId, 0, true);
        this.appkey = aVar.a(1, true);
        this.appVersion = aVar.a(2, true);
        this.sdkId = aVar.a(3, true);
        this.sdkVersion = aVar.a(4, true);
        this.cmd = aVar.a(this.cmd, 5, true);
        if (cache_sBuffer == null) {
            cache_sBuffer = new byte[]{0};
        }
        this.sBuffer = aVar.a(cache_sBuffer, 6, true);
        this.encryType = aVar.a(this.encryType, 7, true);
        this.zipType = aVar.a(this.zipType, 8, true);
        this.model = aVar.a(9, false);
        this.osVersion = aVar.a(10, false);
        this.reserved = aVar.a(11, false);
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void writeTo(com.tencent.beacon.core.wup.b bVar) {
        bVar.a(this.platformId, 0);
        bVar.a(this.appkey, 1);
        bVar.a(this.appVersion, 2);
        bVar.a(this.sdkId, 3);
        bVar.a(this.sdkVersion, 4);
        bVar.a(this.cmd, 5);
        bVar.a(this.sBuffer, 6);
        bVar.a(this.encryType, 7);
        bVar.a(this.zipType, 8);
        java.lang.String str = this.model;
        if (str != null) {
            bVar.a(str, 9);
        }
        java.lang.String str2 = this.osVersion;
        if (str2 != null) {
            bVar.a(str2, 10);
        }
        java.lang.String str3 = this.reserved;
        if (str3 != null) {
            bVar.a(str3, 11);
        }
    }
}
