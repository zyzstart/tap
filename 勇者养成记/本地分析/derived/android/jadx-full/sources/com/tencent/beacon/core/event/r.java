package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class r extends com.tencent.beacon.core.d.a {
    protected java.util.List h;
    protected android.content.Context i;
    protected java.lang.Long[] j;
    protected boolean k;

    public r(android.content.Context context, java.lang.String str, java.util.List list) {
        super(context, 1, 2, str);
        this.h = null;
        this.j = null;
        this.k = false;
        this.h = list;
        this.i = context;
        this.e = list.size();
        if (this.h.size() == 1 && "rqd_heartbeat".equals(((com.tencent.beacon.core.event.RDBean) this.h.get(0)).getEN())) {
            this.k = true;
        }
        java.lang.String strA = com.tencent.beacon.core.e.b.a(context, 2, str);
        this.d = strA;
        com.tencent.beacon.core.e.d.a("[event] request id:%s", strA);
    }

    public com.tencent.beacon.core.protocol.common.RequestPackage a(android.content.Context context, int i, java.util.List list) {
        byte[] byteArray;
        if (list != null && list.size() > 0) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("[event] encode rd size:");
                sb.append(list.size());
                com.tencent.beacon.core.e.d.a(sb.toString(), new java.lang.Object[0]);
                com.tencent.beacon.core.protocol.event.EventRecordPackage eventRecordPackageA = a(list);
                if (eventRecordPackageA == null || (byteArray = eventRecordPackageA.toByteArray()) == null) {
                    return null;
                }
                return com.tencent.beacon.core.event.i.a(context, i, byteArray, this.f);
            } catch (java.lang.Throwable th) {
                com.tencent.beacon.core.e.d.a(th);
                com.tencent.beacon.core.e.d.b("[event] encode2EventRecordPackage error}", new java.lang.Object[0]);
            }
        }
        return null;
    }

    protected com.tencent.beacon.core.protocol.event.EventRecordPackage a(java.util.List list) {
        if (list != null && list.size() > 0) {
            try {
                com.tencent.beacon.core.protocol.event.EventRecordPackage eventRecordPackage = new com.tencent.beacon.core.protocol.event.EventRecordPackage();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    com.tencent.beacon.core.protocol.event.EventRecord eventRecordA = com.tencent.beacon.core.event.s.a((com.tencent.beacon.core.event.RDBean) it.next());
                    if (eventRecordA != null) {
                        arrayList.add(eventRecordA);
                    }
                }
                eventRecordPackage.list = arrayList;
                com.tencent.beacon.core.e.d.a("[event] encode end", new java.lang.Object[0]);
                return eventRecordPackage;
            } catch (java.lang.Throwable th) {
                com.tencent.beacon.core.e.d.a(th);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beacon.core.d.a
    public synchronized void a(boolean z) {
        if (this.h != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Iterator it = this.h.iterator();
            while (it.hasNext()) {
                sb.append((java.lang.String) ((com.tencent.beacon.core.event.RDBean) it.next()).getEMap().get("A100"));
                sb.append(",");
            }
            com.tencent.beacon.core.e.d.a("[event] upload result: %1$s. logid: %2$s. rid: %3$s. hashcode: %4$s", java.lang.Boolean.valueOf(z), sb.toString(), this.d, java.lang.Integer.valueOf(hashCode()));
        }
        if (this.h != null && !z) {
            com.tencent.beacon.core.e.d.f("[event] upload failed, save to db", new java.lang.Object[0]);
            if (!this.k) {
                java.lang.Long[] lArrA = com.tencent.beacon.core.event.t.a(this.i, this.f, this.h);
                this.j = lArrA;
                if (lArrA != null) {
                    java.util.Iterator it2 = com.tencent.beacon.core.d.k.a(this.i).d().iterator();
                    while (it2.hasNext()) {
                        ((com.tencent.beacon.core.d.l) it2.next()).incRealTimeEventWriteSucc(this.j.length);
                    }
                }
                this.h = null;
            }
        }
        if (z && this.k) {
            com.tencent.beacon.core.event.m.a(this.i);
        }
        if (z && this.h != null) {
            java.util.Iterator it3 = com.tencent.beacon.core.d.k.a(this.i).d().iterator();
            while (it3.hasNext()) {
                ((com.tencent.beacon.core.d.l) it3.next()).incRealTimeEventUploadSucc(this.h.size());
            }
        }
        if (z && this.j == null && this.h != null) {
            this.h = null;
        }
    }

    @Override // com.tencent.beacon.core.d.a
    public synchronized com.tencent.beacon.core.protocol.common.RequestPackage f() {
        try {
            com.tencent.beacon.core.e.d.a("[event] Start encode record", new java.lang.Object[0]);
            java.util.List list = this.h;
            if (list == null || list.size() <= 0) {
                return null;
            }
            try {
                com.tencent.beacon.core.protocol.common.RequestPackage requestPackageA = a(this.i, this.f148a, this.h);
                if (requestPackageA != null) {
                    com.tencent.beacon.core.e.d.a("[event] End encode record", new java.lang.Object[0]);
                    return requestPackageA;
                }
            } catch (java.lang.Throwable th) {
                com.tencent.beacon.core.e.d.a(th);
                com.tencent.beacon.core.e.d.b("[event] TUUD.GetUD start error", new java.lang.Object[0]);
            }
            return null;
        } catch (java.lang.Throwable th2) {
            throw th2;
        }
    }
}
