package com.tencent.beaconselfupdate.upload;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c extends com.tencent.beaconselfupdate.upload.a {
    public c(android.content.Context context) {
        super(context, 0, 100);
    }

    @Override // com.tencent.beaconselfupdate.upload.a
    public final com.tencent.beaconselfupdate.b.a.b a() {
        try {
            com.tencent.beaconselfupdate.b.a.b bVarA = com.tencent.beaconselfupdate.a.e.a(c(), com.tencent.beaconselfupdate.a.c.m(), "".getBytes(), -1, -1);
            if (bVarA != null) {
                return bVarA;
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            com.tencent.beaconselfupdate.c.a.d("encode2RequestPackage failed", new java.lang.Object[0]);
            return null;
        }
    }

    @Override // com.tencent.beaconselfupdate.upload.a
    public final void b(boolean z) {
    }
}
