package com.tencent.beacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g extends com.tencent.beacon.core.d.a {
    protected android.content.Context h;
    protected com.tencent.beacon.core.protocol.common.RequestPackage i;

    public g(android.content.Context context, java.lang.String str, com.tencent.beacon.core.d.a.InterfaceC0018a interfaceC0018a) {
        super(context, 0, 102, str, interfaceC0018a);
        this.h = null;
        this.i = null;
        this.h = context;
    }

    @Override // com.tencent.beacon.core.d.a
    public void a(boolean z) {
        com.tencent.beacon.core.d.a.InterfaceC0018a interfaceC0018a = this.g;
        if (interfaceC0018a != null) {
            interfaceC0018a.a(z);
        }
    }

    @Override // com.tencent.beacon.core.d.a
    public com.tencent.beacon.core.protocol.common.RequestPackage f() {
        com.tencent.beacon.core.e.d.a("[qimei] start", new java.lang.Object[0]);
        com.tencent.beacon.core.protocol.common.RequestPackage requestPackage = this.i;
        if (requestPackage != null) {
            return requestPackage;
        }
        try {
            com.tencent.beacon.qimei.a aVarA = com.tencent.beacon.qimei.a.a(this.h);
            if (aVarA == null) {
                com.tencent.beacon.core.e.d.b("[qimei] qimeiInfo is null, return", new java.lang.Object[0]);
                return null;
            }
            byte[] byteArray = aVarA.d().toByteArray();
            com.tencent.beacon.core.info.b bVarB = com.tencent.beacon.core.info.b.b(this.c);
            this.i = com.tencent.beacon.core.d.m.a(this.f148a, bVarB, byteArray, 2, 3, this.f);
            if (c() == 102) {
                com.tencent.beacon.core.info.c cVarA = com.tencent.beacon.core.info.c.a(bVarB.c());
                java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
                linkedHashMap.put("A141", com.tencent.beacon.qimei.QimeiSDK.getInstance().getBeaconIdInfo(this.c));
                linkedHashMap.put("A142", cVarA.l());
                linkedHashMap.put("A143", cVarA.j());
                linkedHashMap.put("A144", cVarA.i());
                this.i.reserved = com.tencent.beacon.core.e.c.a(linkedHashMap);
            }
            com.tencent.beacon.core.e.d.a("[qimei] QIMEI upload data: %s", this.i);
            return this.i;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
        }
    }
}
