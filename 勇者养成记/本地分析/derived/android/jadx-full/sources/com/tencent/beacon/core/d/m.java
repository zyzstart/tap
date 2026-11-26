package com.tencent.beacon.core.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class m {
    public static com.tencent.beacon.core.protocol.common.RequestPackage a(int i, com.tencent.beacon.core.info.b bVar, byte[] bArr, int i2, int i3, java.lang.String str) {
        if (bVar == null) {
            com.tencent.beacon.core.e.d.b("error no com info! ", new java.lang.Object[0]);
            return null;
        }
        try {
            com.tencent.beacon.core.protocol.common.RequestPackage requestPackage = new com.tencent.beacon.core.protocol.common.RequestPackage();
            requestPackage.model = bVar.e();
            requestPackage.osVersion = bVar.f();
            requestPackage.platformId = bVar.g();
            requestPackage.appkey = str;
            requestPackage.appVersion = bVar.a(str);
            requestPackage.sdkId = bVar.h();
            requestPackage.sdkVersion = com.tencent.beacon.core.info.b.i();
            requestPackage.reserved = "";
            requestPackage.cmd = i;
            requestPackage.encryType = (byte) i3;
            requestPackage.zipType = (byte) i2;
            if (bArr == null) {
                bArr = "".getBytes(java.nio.charset.Charset.forName("UTF-8"));
            }
            requestPackage.sBuffer = bArr;
            return requestPackage;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            return null;
        }
    }
}
