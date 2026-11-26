package com.tencent.ydkbeacon.base.net.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d implements com.tencent.ydkbeacon.base.net.b.c {
    private java.util.Map b(com.tencent.ydkbeacon.base.net.a.k kVar) {
        java.util.Map mapD = kVar.d();
        if (!mapD.containsKey("sid")) {
            java.lang.String strC = com.tencent.ydkbeacon.d.g.b().c();
            if (!android.text.TextUtils.isEmpty(strC)) {
                mapD.put("sid", strC);
            }
        }
        return mapD;
    }

    @Override // com.tencent.ydkbeacon.base.net.b.c
    public com.tencent.ydkbeacon.pack.SocketRequestPackage a(com.tencent.ydkbeacon.base.net.a.k kVar) {
        return new com.tencent.ydkbeacon.pack.SocketRequestPackage(b(kVar), kVar.b());
    }
}
