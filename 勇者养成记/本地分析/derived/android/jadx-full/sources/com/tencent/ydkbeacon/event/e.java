package com.tencent.ydkbeacon.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e implements java.lang.Runnable, com.tencent.ydkbeacon.a.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1258a;
    private final java.lang.String b;
    private int c;
    private final int d;
    private final com.tencent.ydkbeacon.event.a.a e;
    private boolean f;
    private final java.util.Set g = new java.util.HashSet();
    private final java.util.Set h = new java.util.HashSet();
    private final java.lang.String i;
    private java.lang.String j;

    public e(int i, com.tencent.ydkbeacon.event.a.a aVar, boolean z) {
        this.d = i;
        this.e = aVar;
        this.f1258a = z;
        this.b = z ? "t_r_e" : "t_n_e";
        this.c = 48;
        this.i = "[EventReport (" + this.b + ")]";
    }

    private com.tencent.ydkbeacon.base.net.a.k a(java.util.List list) {
        return com.tencent.ydkbeacon.base.net.a.k.a().a(com.tencent.ydkbeacon.base.net.RequestType.EVENT).a(this.f1258a ? 2 : 1).a(com.tencent.ydkbeacon.base.net.c.b.a(true), 8081).a(com.tencent.ydkbeacon.a.c.c.d().f()).a(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, "v2").a(com.tencent.ydkbeacon.event.c.c.a(list)).a();
    }

    private java.util.List a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator it = this.g.iterator();
        while (it.hasNext()) {
            sb.append((java.lang.Long) it.next());
            sb.append(",");
        }
        return this.e.a(this.b, sb.length() > 0 ? sb.substring(0, sb.lastIndexOf(",")) : "", this.c);
    }

    private void a(java.util.List list, java.util.Set set) {
        com.tencent.ydkbeacon.base.net.a.k kVarA = a(list);
        com.tencent.ydkbeacon.a.e.c.a(this.i, 2, "event request entity: %s", kVarA.toString());
        com.tencent.ydkbeacon.base.net.d.c().a(kVarA).a(new com.tencent.ydkbeacon.event.d(this, this.b, this.e, set, this.j));
    }

    private void b() {
        com.tencent.ydkbeacon.a.a.b.a().a(2, this);
    }

    public void a(java.util.Set set) {
        synchronized (this.g) {
            this.g.removeAll(set);
            set.clear();
        }
    }

    @Override // com.tencent.ydkbeacon.a.a.d
    public void onEvent(com.tencent.ydkbeacon.a.a.c cVar) {
        java.util.Map map;
        if (cVar.f1177a != 2 || (map = (java.util.Map) cVar.b.get("d_m")) == null) {
            return;
        }
        this.c = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get(this.f1258a ? "realtimeUploadNum" : "normalUploadNum"), this.c, 24, 60);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f) {
            b();
            this.f = true;
        }
        if (!com.tencent.ydkbeacon.base.net.c.d.d() || com.tencent.ydkbeacon.base.net.d.c().d()) {
            com.tencent.ydkbeacon.a.b.a.a().a(this.d, false);
            return;
        }
        synchronized (this.g) {
            com.tencent.ydkbeacon.a.e.c.a(this.i, 0, "start read EventBean from DB.", new java.lang.Object[0]);
            java.util.List<com.tencent.ydkbeacon.event.EventBean> listA = a();
            if (listA != null && !listA.isEmpty()) {
                java.util.HashMap map = new java.util.HashMap();
                for (com.tencent.ydkbeacon.event.EventBean eventBean : listA) {
                    long cid = eventBean.getCid();
                    this.g.add(java.lang.Long.valueOf(cid));
                    this.h.add(java.lang.Long.valueOf(cid));
                    java.util.Map eventValue = eventBean.getEventValue();
                    if (eventValue != null) {
                        java.lang.String appKey = eventBean.getAppKey();
                        java.lang.String string = (java.lang.String) map.get(appKey);
                        if (string == null) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(appKey);
                            sb.append(": ");
                            string = sb.toString();
                        }
                        java.lang.String str = (java.lang.String) eventValue.get("A100");
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append(string);
                        sb2.append(str);
                        sb2.append(", ");
                        map.put(appKey, sb2.toString());
                    }
                }
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder("--logID: \n");
                java.util.Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    sb3.append((java.lang.String) ((java.util.Map.Entry) it.next()).getValue());
                    sb3.append("\n");
                }
                java.lang.String string2 = sb3.toString();
                this.j = string2;
                com.tencent.ydkbeacon.a.e.c.a(this.i, 1, "send LogID: %s", string2);
                a(listA, this.h);
                listA.clear();
                this.h.clear();
                return;
            }
            com.tencent.ydkbeacon.a.e.c.a(this.i, 1, "EventBean List == null. Task end!", new java.lang.Object[0]);
            com.tencent.ydkbeacon.a.b.a.a().a(this.d, false);
        }
    }
}
