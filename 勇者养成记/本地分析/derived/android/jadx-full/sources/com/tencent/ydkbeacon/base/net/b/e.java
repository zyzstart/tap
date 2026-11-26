package com.tencent.ydkbeacon.base.net.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e implements com.tencent.ydkbeacon.base.net.b.c {
    @Override // com.tencent.ydkbeacon.base.net.b.c
    public com.tencent.ydkbeacon.pack.SocketResponsePackage a(byte[] bArr) {
        com.tencent.ydkbeacon.pack.SocketResponsePackage socketResponsePackage = new com.tencent.ydkbeacon.pack.SocketResponsePackage();
        socketResponsePackage.readFrom(new com.tencent.ydkbeacon.pack.a(bArr));
        com.tencent.ydkbeacon.base.net.c.d.c(socketResponsePackage.header);
        return socketResponsePackage;
    }
}
