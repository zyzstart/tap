package com.tencent.ydkbeacon.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class d implements com.tencent.ydkbeacon.base.net.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.ydkbeacon.event.e f1257a;
    private java.lang.String b;
    private com.tencent.ydkbeacon.event.a.a c;
    private final java.util.Set d;
    private final java.lang.String e;
    private final java.lang.String f;

    d(com.tencent.ydkbeacon.event.e eVar, java.lang.String str, com.tencent.ydkbeacon.event.a.a aVar, java.util.Set set, java.lang.String str2) {
        this.f1257a = eVar;
        this.b = str;
        this.c = aVar;
        this.d = new java.util.HashSet(set);
        this.e = "[EventReport(" + str + ")]";
        this.f = str2;
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(com.tencent.ydkbeacon.base.net.e eVar) {
        com.tencent.ydkbeacon.a.e.c.a(this.e, 3, "send failure reason: %s. LogID: %s.", eVar.toString(), this.f);
        this.f1257a.a(this.d);
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(byte[] bArr) {
        com.tencent.ydkbeacon.a.e.c.a(this.e, 3, "report success! sendingID will delete this time's IDs. offer task: %s! ", java.lang.Boolean.valueOf(((com.tencent.ydkbeacon.module.EventModule) com.tencent.ydkbeacon.a.c.c.d().a(com.tencent.ydkbeacon.module.ModuleName.EVENT)).c().a(new com.tencent.ydkbeacon.event.c(this))));
        com.tencent.ydkbeacon.a.b.a.a().a(this.f1257a);
    }
}
