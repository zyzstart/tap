package com.tencent.beaconselfupdate.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends com.tencent.beaconselfupdate.upload.a {
    private android.content.Context e;
    private java.lang.Long[] f;
    private java.util.List g;
    private byte[] h;
    private boolean i;

    public b(android.content.Context context) {
        super(context, 1, 4);
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = false;
        this.e = context;
    }

    private com.tencent.beaconselfupdate.b.a.a a(java.util.List list) {
        com.tencent.beaconselfupdate.b.b.b bVar;
        if (list != null && list.size() > 0) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int size = list.size();
            this.g = new java.util.ArrayList();
            for (int i = 0; i < size; i++) {
                try {
                    com.tencent.beaconselfupdate.event.h hVar = (com.tencent.beaconselfupdate.event.h) list.get(i);
                    java.util.Map mapE = hVar.e();
                    com.tencent.beaconselfupdate.c.a.a(" bean.getTP: " + hVar.b(), new java.lang.Object[0]);
                    if (mapE != null && com.tencent.beacon.core.event.RDBean.TP_UA.equals(hVar.b())) {
                        com.tencent.beaconselfupdate.c.a.f(" Pack2Upload eventName:}%s ", hVar.d());
                        com.tencent.beaconselfupdate.b.b.a aVarA = com.tencent.beaconselfupdate.a.e.a(hVar);
                        if (aVarA != null) {
                            arrayList.add(aVarA);
                        } else {
                            this.g.add(java.lang.Long.valueOf(hVar.a()));
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.tencent.beaconselfupdate.c.a.a(th);
                    com.tencent.beaconselfupdate.c.a.d(" CommonRecordUploadDatas.encode2MixPackage() error1", new java.lang.Object[0]);
                }
            }
            if (this.g.size() > 0) {
                com.tencent.beaconselfupdate.a.e.a(this.e, (java.lang.Long[]) this.g.toArray(new java.lang.Long[this.g.size()]));
            }
            com.tencent.beaconselfupdate.c.a.b(" up erList:" + arrayList.size(), new java.lang.Object[0]);
            try {
                if (arrayList.size() > 0) {
                    bVar = new com.tencent.beaconselfupdate.b.b.b();
                    bVar.f244a = arrayList;
                } else {
                    bVar = null;
                }
                if (bVar == null) {
                    return null;
                }
                java.util.HashMap map = new java.util.HashMap();
                map.put(1, bVar.a());
                com.tencent.beaconselfupdate.b.a.a aVar = new com.tencent.beaconselfupdate.b.a.a();
                aVar.f240a = map;
                return aVar;
            } catch (java.lang.Exception e) {
                com.tencent.beaconselfupdate.c.a.a(e);
                com.tencent.beaconselfupdate.c.a.d(" CommonRecordUploadDatas.encode2MixPackage() error2", new java.lang.Object[0]);
                b();
            }
        }
        return null;
    }

    private synchronized boolean f() {
        return this.i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beaconselfupdate.upload.a
    public final synchronized com.tencent.beaconselfupdate.b.a.b a() {
        byte[] bArrA;
        com.tencent.beaconselfupdate.b.a.a aVarA;
        java.util.List listA;
        com.tencent.beaconselfupdate.event.j jVarD = com.tencent.beaconselfupdate.event.j.d();
        com.tencent.beaconselfupdate.b.a.b bVarA = null;
        if (jVarD != null && jVarD.e()) {
            com.tencent.beaconselfupdate.event.e eVarG = jVarD.g();
            if (eVarG == null) {
                com.tencent.beaconselfupdate.c.a.c(" imposiable! ua S not ready!", new java.lang.Object[0]);
                return null;
            }
            try {
                if (!f() || (listA = com.tencent.beaconselfupdate.a.a.a.a(this.e)) == null || listA.size() <= 0) {
                    bArrA = null;
                } else {
                    bArrA = (byte[]) listA.get(3);
                    this.d = java.lang.String.valueOf(listA.get(1));
                    ((java.lang.Integer) listA.get(4)).intValue();
                }
                if (bArrA != null) {
                    return com.tencent.beaconselfupdate.upload.a.a(this.f268a, bArrA);
                }
                int iE = eVarG.e();
                if (!com.tencent.beaconselfupdate.a.e.l(this.e)) {
                    iE /= 2;
                }
                java.util.List listA2 = iE >= 0 ? com.tencent.beaconselfupdate.a.e.a(this.e, iE) : null;
                if (listA2 != null && listA2.size() > 0) {
                    int size = listA2.size();
                    com.tencent.beaconselfupdate.c.a.h(" size:%d", java.lang.Integer.valueOf(size));
                    try {
                        aVarA = a(listA2);
                    } catch (java.lang.Exception unused) {
                        b();
                        aVarA = null;
                    }
                    this.f = new java.lang.Long[size];
                    for (int i = 0; i < this.f.length; i++) {
                        this.f[i] = java.lang.Long.valueOf(((com.tencent.beaconselfupdate.event.h) listA2.get(i)).a());
                    }
                    listA2.clear();
                    if (aVarA != null) {
                        bArrA = aVarA.a();
                    }
                    byte[] bArr = new byte[bArrA.length];
                    this.h = bArr;
                    java.lang.System.arraycopy(bArrA, 0, bArr, 0, bArrA.length);
                    java.lang.String strB = com.tencent.beaconselfupdate.a.e.b(this.c, 4);
                    this.d = strB;
                    com.tencent.beaconselfupdate.c.a.a("comm rid:%s", strB);
                    try {
                        bVarA = com.tencent.beaconselfupdate.upload.a.a(this.f268a, bArrA);
                    } catch (java.lang.Exception unused2) {
                        b();
                    }
                    return bVarA;
                }
                com.tencent.beaconselfupdate.c.a.h(" no up datas", new java.lang.Object[0]);
                return null;
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.a(th);
                com.tencent.beaconselfupdate.c.a.d(" get req datas error: %s", th.toString());
                return null;
            }
        }
        com.tencent.beaconselfupdate.c.a.c(" imposiable! ua not ready!", new java.lang.Object[0]);
        return null;
    }

    public final synchronized void a(boolean z) {
        this.i = z;
    }

    @Override // com.tencent.beaconselfupdate.upload.a
    public final synchronized void b() {
        com.tencent.beaconselfupdate.c.a.c(" encode failed, clear db data", new java.lang.Object[0]);
        java.lang.Long[] lArr = this.f;
        if (lArr != null && lArr.length > 0) {
            com.tencent.beaconselfupdate.c.a.b(" remove num :" + com.tencent.beaconselfupdate.a.e.a(this.e, lArr), new java.lang.Object[0]);
            this.f = null;
        }
    }

    @Override // com.tencent.beaconselfupdate.upload.a
    public final synchronized void b(boolean z) {
        java.lang.Long[] lArr = this.f;
        int length = lArr != null ? lArr.length : 0;
        if (length > 0) {
            com.tencent.beaconselfupdate.c.a.b(" t_event remove num :" + com.tencent.beaconselfupdate.a.e.a(this.e, this.f), new java.lang.Object[0]);
        }
        this.f = null;
        if (z && f()) {
            com.tencent.beaconselfupdate.a.a.a.a(this.e, this.d);
        } else if (!z && this.h != null) {
            com.tencent.beaconselfupdate.c.a.a("comm rid2:%s", this.d);
            com.tencent.beaconselfupdate.a.a.a.a(this.e, this.h, this.d, length);
        }
        this.h = null;
    }
}
