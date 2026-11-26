package com.tencent.beaconselfupdate.upload;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f272a;

    public e(android.content.Context context) {
        this.f272a = null;
        this.f272a = context;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0262  */
    /* JADX WARN: Code duplicated, block: B:74:0x018b  */
    public final void a(int i, byte[] bArr, boolean z) {
        boolean z2;
        boolean z3;
        com.tencent.beaconselfupdate.a.b.b bVarA;
        byte b;
        boolean z4;
        boolean z5 = false;
        int i2 = 1;
        if (i != 101) {
            com.tencent.beaconselfupdate.c.a.c("com strategy unmatch key: %d", java.lang.Integer.valueOf(i));
            return;
        }
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        com.tencent.beaconselfupdate.a.b.d dVarE = com.tencent.beaconselfupdate.a.b.b.a(this.f272a).e();
        if (dVarE == null) {
            com.tencent.beaconselfupdate.c.a.c("imposible! common strategy null!", new java.lang.Object[0]);
            return;
        }
        try {
            com.tencent.beaconselfupdate.b.c.a aVar = new com.tencent.beaconselfupdate.b.c.a();
            aVar.a(new com.tencent.beaconselfupdate.d.a(bArr));
            if (dVarE != null) {
                if (aVar.c.equals(dVarE.b())) {
                    z2 = false;
                } else {
                    com.tencent.beaconselfupdate.c.a.b("strategy url changed to: %s", aVar.c);
                    dVarE.a(aVar.c);
                    z2 = true;
                }
                if (aVar.b != dVarE.c()) {
                    com.tencent.beaconselfupdate.c.a.b("QueryPeriod changed to: %d", java.lang.Integer.valueOf(aVar.b));
                    dVarE.a(aVar.b);
                    z2 = true;
                }
                java.util.ArrayList<com.tencent.beaconselfupdate.b.c.b> arrayList = aVar.f245a;
                if (dVarE != null) {
                    if (arrayList != null) {
                        android.util.SparseArray sparseArrayE = dVarE.e();
                        if (sparseArrayE != null) {
                            int i3 = 0;
                            boolean z6 = false;
                            while (i3 < sparseArrayE.size()) {
                                com.tencent.beaconselfupdate.a.b.d.a aVar2 = (com.tencent.beaconselfupdate.a.b.d.a) sparseArrayE.valueAt(i3);
                                for (com.tencent.beaconselfupdate.b.c.b bVar : arrayList) {
                                    if (bVar.f246a == aVar2.e()) {
                                        java.lang.Object[] objArr = new java.lang.Object[i2];
                                        objArr[0] = java.lang.Byte.valueOf(bVar.f246a);
                                        com.tencent.beaconselfupdate.c.a.a("server module strategy mid: %d", objArr);
                                        boolean z7 = bVar.b == 1;
                                        if (aVar2.a() != z7) {
                                            com.tencent.beaconselfupdate.c.a.b("mid: %d , isUsable changed: %b ", java.lang.Byte.valueOf(bVar.f246a), java.lang.Boolean.valueOf(z7));
                                            aVar2.a(z7);
                                            z3 = true;
                                        } else {
                                            z3 = z6;
                                        }
                                        if (!aVar2.b().equals(bVar.c)) {
                                            com.tencent.beaconselfupdate.c.a.b("mid: %d , url changed: %s", java.lang.Byte.valueOf(bVar.f246a), bVar.c);
                                            aVar2.a(bVar.c);
                                            z3 = true;
                                        }
                                        if (bVar.f246a != 1 && bVar.f246a != 2) {
                                            z6 = z3;
                                        } else if (aVar2.c() == null || bVar.d == null) {
                                            if (bVar.d == null || aVar2.c() != null) {
                                                z6 = z3;
                                            } else {
                                                com.tencent.beaconselfupdate.c.a.b("mid: %d , detail changed...", java.lang.Byte.valueOf(bVar.f246a));
                                                aVar2.a(bVar.d);
                                                bVarA = com.tencent.beaconselfupdate.a.b.b.a(this.f272a);
                                                b = bVar.f246a;
                                                bVarA.a(b, bVar.d);
                                                z6 = true;
                                            }
                                        } else if (aVar2.c().equals(bVar.d)) {
                                            z6 = z3;
                                        } else {
                                            com.tencent.beaconselfupdate.c.a.b("mid: %d , detail changed...", java.lang.Byte.valueOf(bVar.f246a));
                                            aVar2.a(bVar.d);
                                            bVarA = com.tencent.beaconselfupdate.a.b.b.a(this.f272a);
                                            b = bVar.f246a;
                                            bVarA.a(b, bVar.d);
                                            z6 = true;
                                        }
                                        i2 = 1;
                                        if (bVar.f246a == 1) {
                                            if (aVar2.d() == null || bVar.e == null) {
                                                if (aVar2.d() != null || bVar.e != null) {
                                                    com.tencent.beaconselfupdate.c.a.b("mid: %d , PreventEventCode changed...", java.lang.Byte.valueOf(bVar.f246a));
                                                    aVar2.a(com.tencent.beaconselfupdate.a.e.a(bVar.e));
                                                    z6 = true;
                                                }
                                            } else if (!aVar2.d().equals(bVar.e)) {
                                                com.tencent.beaconselfupdate.c.a.b("mid: %d , PreventEventCode changed...", java.lang.Byte.valueOf(bVar.f246a));
                                                aVar2.a(com.tencent.beaconselfupdate.a.e.a(bVar.e));
                                                z6 = true;
                                            }
                                            if (aVar2.f() == null || bVar.f == null) {
                                                if (aVar2.f() == null && bVar.f == null) {
                                                    i2 = 1;
                                                } else {
                                                    com.tencent.beaconselfupdate.c.a.b("mid: %d , SampleEventSet changed...", java.lang.Byte.valueOf(bVar.f246a));
                                                    aVar2.b(com.tencent.beaconselfupdate.a.e.a(bVar.f));
                                                    i2 = 1;
                                                    z6 = true;
                                                }
                                            } else if (aVar2.f().equals(bVar.f)) {
                                                i2 = 1;
                                            } else {
                                                com.tencent.beaconselfupdate.c.a.b("mid: %d , SampleEventSet changed...", java.lang.Byte.valueOf(bVar.f246a));
                                                aVar2.b(com.tencent.beaconselfupdate.a.e.a(bVar.f));
                                                i2 = 1;
                                                z6 = true;
                                            }
                                        }
                                    }
                                }
                                i3++;
                                i2 = 1;
                            }
                            z5 = z6;
                        }
                    } else {
                        android.util.SparseArray sparseArrayE2 = dVarE.e();
                        if (sparseArrayE2 != null) {
                            int size = sparseArrayE2.size();
                            boolean z8 = false;
                            for (int i4 = 0; i4 < size; i4++) {
                                com.tencent.beaconselfupdate.a.b.d.a aVar3 = (com.tencent.beaconselfupdate.a.b.d.a) sparseArrayE2.valueAt(i4);
                                if (aVar3.a()) {
                                    com.tencent.beaconselfupdate.c.a.b("mid: %d , server not response strategy, sdk local close it!", java.lang.Integer.valueOf(aVar3.e()));
                                    aVar3.a(false);
                                    z8 = true;
                                }
                            }
                            z5 = z8;
                        }
                    }
                    z5 = false;
                }
                z5 = z5 ? true : z2;
                java.util.Map map = aVar.d;
                if (dVarE == null) {
                    z4 = false;
                } else if (map == null || dVarE.d() == null) {
                    if (map == null || dVarE.d() != null) {
                        z4 = false;
                    } else {
                        dVarE.a(map);
                        z4 = true;
                    }
                } else if (map.equals(dVarE.d())) {
                    z4 = false;
                } else {
                    dVarE.a(map);
                    z4 = true;
                }
                if (z4) {
                    z5 = true;
                }
            }
            if (z5) {
                if (z) {
                    com.tencent.beaconselfupdate.c.a.e("update common strategy should save ", new java.lang.Object[0]);
                    android.content.Context context = this.f272a;
                    if (bArr != null) {
                        com.tencent.beaconselfupdate.a.b.g gVar = new com.tencent.beaconselfupdate.a.b.g();
                        gVar.a(i);
                        gVar.a(bArr);
                        com.tencent.beaconselfupdate.a.e.a(context, gVar);
                    }
                }
                com.tencent.beaconselfupdate.c.a.e("com strategy changed notify! ", new java.lang.Object[0]);
                com.tencent.beaconselfupdate.a.b.b bVarA2 = com.tencent.beaconselfupdate.a.b.b.a(this.f272a);
                bVarA2.a(dVarE);
                if (z) {
                    bVarA2.b();
                }
            }
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            com.tencent.beaconselfupdate.c.a.d("error to common strategy!", new java.lang.Object[0]);
        }
    }
}
