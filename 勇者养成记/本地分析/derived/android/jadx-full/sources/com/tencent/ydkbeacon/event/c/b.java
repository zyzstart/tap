package com.tencent.ydkbeacon.event.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends com.tencent.ydkbeacon.base.net.b.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tencent.ydkbeacon.event.c.b.C0044b f1254a = new com.tencent.ydkbeacon.event.c.b.C0044b();
    private final com.tencent.ydkbeacon.event.c.b.a b = new com.tencent.ydkbeacon.event.c.b.a();

    static final class a implements com.tencent.ydkbeacon.base.net.b.c {
        a() {
        }

        @Override // com.tencent.ydkbeacon.base.net.b.c
        public com.tencent.ydkbeacon.event.a.b a(com.tencent.ydkbeacon.event.EventBean eventBean) {
            com.tencent.ydkbeacon.event.a.b bVar = new com.tencent.ydkbeacon.event.a.b();
            bVar.b = eventBean.getEventTime();
            bVar.d = eventBean.getAppKey();
            byte[] bArrA = com.tencent.ydkbeacon.a.e.b.a(eventBean);
            bVar.e = bArrA;
            if (bArrA != null) {
                bVar.c = bArrA.length;
            }
            return bVar;
        }
    }

    /* JADX INFO: renamed from: com.tencent.ydkbeacon.event.c.b$b, reason: collision with other inner class name */
    static final class C0044b implements com.tencent.ydkbeacon.base.net.b.c {
        C0044b() {
        }

        @Override // com.tencent.ydkbeacon.base.net.b.c
        public com.tencent.ydkbeacon.event.EventBean a(com.tencent.ydkbeacon.event.a.b bVar) {
            java.lang.Object objA = com.tencent.ydkbeacon.a.e.b.a(bVar.e);
            if (objA == null || !(objA instanceof com.tencent.ydkbeacon.event.EventBean)) {
                return null;
            }
            com.tencent.ydkbeacon.event.EventBean eventBean = (com.tencent.ydkbeacon.event.EventBean) objA;
            eventBean.setCid(bVar.f1250a);
            return eventBean;
        }
    }

    private b() {
    }

    public static com.tencent.ydkbeacon.event.c.b a() {
        return new com.tencent.ydkbeacon.event.c.b();
    }

    public com.tencent.ydkbeacon.base.net.b.c b() {
        return this.b;
    }

    public com.tencent.ydkbeacon.base.net.b.c c() {
        return this.f1254a;
    }
}
