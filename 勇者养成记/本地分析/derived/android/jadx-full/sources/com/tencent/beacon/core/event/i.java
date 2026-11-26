package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {
    public static com.tencent.beacon.core.protocol.common.RequestPackage a(android.content.Context context, int i, byte[] bArr, java.lang.String str) {
        com.tencent.beacon.core.e.d.a("[event] origin events byte size: %d", java.lang.Integer.valueOf(bArr.length));
        try {
            com.tencent.beacon.core.protocol.common.RequestPackage requestPackageA = com.tencent.beacon.core.d.m.a(i, com.tencent.beacon.core.info.g.b(context), bArr, 2, 3, str);
            if (requestPackageA != null) {
                requestPackageA.reserved = com.tencent.beacon.core.e.c.a(com.tencent.beacon.event.UserAction.getAdditionalInfo(str));
            }
            return requestPackageA;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.i("[event] encode request package error:%s", th.toString());
            com.tencent.beacon.core.e.d.a(th);
            return null;
        }
    }
}
