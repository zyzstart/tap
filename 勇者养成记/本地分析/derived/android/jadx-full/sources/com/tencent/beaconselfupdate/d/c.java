package com.tencent.beaconselfupdate.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class c implements java.io.Serializable {
    public abstract void a(com.tencent.beaconselfupdate.d.a aVar);

    public abstract void a(com.tencent.beaconselfupdate.d.b bVar);

    public final byte[] a() {
        com.tencent.beaconselfupdate.d.b bVar = new com.tencent.beaconselfupdate.d.b();
        a(bVar);
        return bVar.b();
    }
}
