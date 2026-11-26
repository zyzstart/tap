package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e extends com.tencent.beacon.core.d.a {
    private static com.tencent.beacon.core.event.e.b h;
    private static com.tencent.beacon.core.event.e.b i = new com.tencent.beacon.core.event.e.a();
    protected android.content.Context j;
    protected java.lang.Long[] k;
    private java.util.List l;
    private byte[] m;
    private boolean n;

    private static class a implements com.tencent.beacon.core.event.e.b {
        private a() {
        }

        @Override // com.tencent.beacon.core.event.e.b
        public byte[] a(java.util.List list, java.util.List list2) {
            if (list != null && list.size() > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    try {
                        com.tencent.beacon.core.event.RDBean rDBean = (com.tencent.beacon.core.event.RDBean) list.get(i);
                        if (rDBean.getEMap() != null && com.tencent.beacon.core.event.RDBean.TP_UA.equals(rDBean.getTP())) {
                            com.tencent.beacon.core.e.d.f("[event] pack eName: %s", rDBean.getEN());
                            com.tencent.beacon.core.protocol.event.EventRecord eventRecordA = com.tencent.beacon.core.event.s.a(rDBean);
                            if (eventRecordA != null) {
                                arrayList.add(eventRecordA);
                            } else {
                                list2.add(java.lang.Long.valueOf(rDBean.getCid()));
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        com.tencent.beacon.core.e.d.b("[event] encode2MixPackage error.", new java.lang.Object[0]);
                        com.tencent.beacon.core.e.d.a(th);
                    }
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("[event] up erList:");
                sb.append(arrayList.size());
                com.tencent.beacon.core.e.d.a(sb.toString(), new java.lang.Object[0]);
                if (arrayList.size() > 0) {
                    com.tencent.beacon.core.protocol.event.EventRecordPackage eventRecordPackage = new com.tencent.beacon.core.protocol.event.EventRecordPackage();
                    eventRecordPackage.list = arrayList;
                    return eventRecordPackage.toByteArray();
                }
            }
            return null;
        }
    }

    public interface b {
        byte[] a(java.util.List list, java.util.List list2);
    }

    public e(android.content.Context context, java.lang.String str) {
        super(context, 1, 4, str);
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.j = context;
    }

    protected com.tencent.beacon.core.protocol.common.MixPackage a(java.util.List list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.l = arrayList;
        com.tencent.beacon.core.event.e.b bVar = h;
        byte[] bArrA = bVar != null ? bVar.a(list, arrayList) : null;
        com.tencent.beacon.core.event.e.b bVar2 = i;
        byte[] bArrA2 = bVar2 != null ? bVar2.a(list, this.l) : null;
        if (this.l.size() > 0) {
            android.content.Context context = this.j;
            java.lang.String str = this.f;
            java.util.List list2 = this.l;
            com.tencent.beacon.core.event.t.a(context, str, (java.lang.Long[]) list2.toArray(new java.lang.Long[list2.size()]));
        }
        if (bArrA == null && bArrA2 == null) {
            return null;
        }
        java.util.HashMap map = new java.util.HashMap();
        if (bArrA != null) {
            map.put(3, bArrA);
        }
        if (bArrA2 != null) {
            map.put(1, bArrA2);
        }
        com.tencent.beacon.core.protocol.common.MixPackage mixPackage = new com.tencent.beacon.core.protocol.common.MixPackage();
        mixPackage.mixMap = map;
        return mixPackage;
    }

    @Override // com.tencent.beacon.core.d.a
    public synchronized void a() {
        com.tencent.beacon.core.e.d.i("[event] encode failed, clear db data", new java.lang.Object[0]);
        java.lang.Long[] lArr = this.k;
        if (lArr != null && lArr.length > 0) {
            com.tencent.beacon.core.e.d.a("[event] remove num :" + com.tencent.beacon.core.event.t.a(this.j, this.f, lArr), new java.lang.Object[0]);
            this.k = null;
        }
    }

    @Override // com.tencent.beacon.core.d.a
    public synchronized void a(boolean z) {
        java.lang.Long[] lArr = this.k;
        int length = lArr != null ? lArr.length : 0;
        if (length > 0) {
            com.tencent.beacon.core.e.d.a("[event] t_event remove num :" + com.tencent.beacon.core.event.t.a(this.j, this.f, this.k), new java.lang.Object[0]);
        }
        this.k = null;
        if (z && g()) {
            com.tencent.beacon.core.a.a.b.a(this.j, this.f, this.d);
        } else if (!z && this.m != null) {
            com.tencent.beacon.core.e.d.a("[event] comm rid2:%s", this.d);
            com.tencent.beacon.core.a.a.b.a(this.j, this.f, this.m, this.d, length);
        }
        this.m = null;
    }

    public synchronized void b(boolean z) {
        this.n = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beacon.core.d.a
    public synchronized com.tencent.beacon.core.protocol.common.RequestPackage f() {
        byte[] bArr;
        com.tencent.beacon.core.protocol.common.MixPackage mixPackageA;
        com.tencent.beacon.qimei.Qimei qimei;
        java.util.List listA;
        com.tencent.beacon.core.event.TunnelModule tunnelModule = com.tencent.beacon.core.event.TunnelModule.getInstance(this.c);
        com.tencent.beacon.core.protocol.common.RequestPackage requestPackageA = null;
        if (tunnelModule != null && tunnelModule.isEnable) {
            com.tencent.beacon.core.event.EventStrategyBean eventStrategyBean = com.tencent.beacon.core.event.EventStrategyBean.getInstance();
            if (eventStrategyBean == null) {
                com.tencent.beacon.core.e.d.b("[event] strategy null!", new java.lang.Object[0]);
                return null;
            }
            try {
                if (!g() || (listA = com.tencent.beacon.core.a.a.b.a(this.j, this.f)) == null || listA.size() <= 0) {
                    bArr = null;
                } else {
                    bArr = (byte[]) listA.get(3);
                    this.d = java.lang.String.valueOf(listA.get(1));
                    this.e = ((java.lang.Integer) listA.get(4)).intValue();
                }
                if (bArr != null) {
                    return com.tencent.beacon.core.event.i.a(this.c, this.f148a, bArr, this.f);
                }
                int comNumUpload = eventStrategyBean.getComNumUpload();
                if (!com.tencent.beacon.core.e.e.d(this.j)) {
                    comNumUpload /= 2;
                }
                java.util.List listA2 = comNumUpload >= 0 ? com.tencent.beacon.core.event.t.a(this.j, this.f, null, comNumUpload) : null;
                if (listA2 != null && listA2.size() > 0) {
                    int size = listA2.size();
                    com.tencent.beacon.core.e.d.h("[event] %d events need upload.", java.lang.Integer.valueOf(size));
                    this.e = size;
                    java.util.Iterator it = listA2.iterator();
                    while (it.hasNext()) {
                        java.util.Map eMap = ((com.tencent.beacon.core.event.RDBean) it.next()).getEMap();
                        if (eMap != null && (qimei = com.tencent.beacon.qimei.QimeiSDK.getInstance().getQimei(this.c)) != null && qimei.getQimeiMap() != null) {
                            eMap.putAll(qimei.getQimeiMap());
                        }
                    }
                    try {
                        mixPackageA = a(listA2);
                    } catch (java.lang.Exception unused) {
                        a();
                        mixPackageA = null;
                    }
                    this.k = new java.lang.Long[size];
                    for (int i2 = 0; i2 < this.k.length; i2++) {
                        this.k[i2] = java.lang.Long.valueOf(((com.tencent.beacon.core.event.RDBean) listA2.get(i2)).getCid());
                    }
                    listA2.clear();
                    if (mixPackageA != null) {
                        byte[] byteArray = mixPackageA.toByteArray();
                        byte[] bArr2 = new byte[byteArray.length];
                        this.m = bArr2;
                        java.lang.System.arraycopy(byteArray, 0, bArr2, 0, byteArray.length);
                        java.lang.String strA = com.tencent.beacon.core.e.b.a(this.c, 4, this.f);
                        this.d = strA;
                        com.tencent.beacon.core.e.d.a("[event] comm rid:%s", strA);
                        try {
                            requestPackageA = com.tencent.beacon.core.event.i.a(this.c, this.f148a, byteArray, this.f);
                        } catch (java.lang.Exception unused2) {
                            a();
                        }
                        return requestPackageA;
                    }
                }
                com.tencent.beacon.core.e.d.h("[event] No event need upload.", new java.lang.Object[0]);
                return null;
            } catch (java.lang.Throwable th) {
                com.tencent.beacon.core.e.d.a(th);
                com.tencent.beacon.core.e.d.b("[event] get req data error: %s", th.toString());
            }
            return null;
        }
        com.tencent.beacon.core.e.d.b("[event] module null!", new java.lang.Object[0]);
        return null;
    }

    public synchronized boolean g() {
        return this.n;
    }
}
