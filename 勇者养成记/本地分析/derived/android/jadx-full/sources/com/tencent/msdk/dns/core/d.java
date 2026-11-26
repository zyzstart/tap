package com.tencent.msdk.dns.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.Map f669a = new java.util.concurrent.ConcurrentHashMap();
    private static final java.util.Map b = new java.util.concurrent.ConcurrentHashMap();
    private static final java.util.List c = new java.util.ArrayList();

    private static class a implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final java.lang.String f671a;
        private final boolean b;

        public a(java.lang.String str) {
            this(str, false);
        }

        public a(java.lang.String str, boolean z) {
            this.f671a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.Map map;
            if (!android.text.TextUtils.isEmpty(this.f671a)) {
                if (this.b) {
                    com.tencent.msdk.dns.base.log.DnsLog.d("Remove cache of %s(Inet6) which is expired.", this.f671a);
                    map = com.tencent.msdk.dns.core.d.b;
                } else {
                    com.tencent.msdk.dns.base.log.DnsLog.d("Remove cache of %s which is expired.", this.f671a);
                    map = com.tencent.msdk.dns.core.d.f669a;
                }
                map.remove(this.f671a);
            }
            com.tencent.msdk.dns.core.d.c.remove(this);
        }
    }

    private static long a(long j) {
        double d = j;
        java.lang.Double.isNaN(d);
        return (long) (d * 0.75d * 1000.0d);
    }

    public static com.tencent.msdk.dns.core.a.a.b a(java.lang.String str) {
        return (com.tencent.msdk.dns.core.a.a.b) f669a.get(str);
    }

    public static void a() {
        com.tencent.msdk.dns.base.log.DnsLog.d("Cache clean.", new java.lang.Object[0]);
        f669a.clear();
        b.clear();
        com.tencent.msdk.dns.base.a.a.f645a.execute(new java.lang.Runnable() { // from class: com.tencent.msdk.dns.core.d.2
            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator it = com.tencent.msdk.dns.core.d.c.iterator();
                while (it.hasNext()) {
                    com.tencent.msdk.dns.base.a.a.f645a.a((java.lang.Runnable) it.next());
                }
            }
        });
    }

    public static boolean a(java.lang.String str, com.tencent.msdk.dns.core.a.a.b bVar) {
        final com.tencent.msdk.dns.core.d.a aVar;
        if (android.text.TextUtils.isEmpty(str) || !com.tencent.msdk.dns.core.a.a.b.a(bVar)) {
            return false;
        }
        if (bVar.g()) {
            com.tencent.msdk.dns.base.log.DnsLog.d("Cache for %s(Inet6).", str);
            b.put(str, bVar);
            aVar = new com.tencent.msdk.dns.core.d.a(str, true);
        } else {
            com.tencent.msdk.dns.base.log.DnsLog.d("Cache for %s.", str);
            f669a.put(str, bVar);
            aVar = new com.tencent.msdk.dns.core.d.a(str);
        }
        com.tencent.msdk.dns.base.a.a.f645a.execute(new java.lang.Runnable() { // from class: com.tencent.msdk.dns.core.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.msdk.dns.core.d.c.add(aVar);
            }
        });
        com.tencent.msdk.dns.base.a.a.f645a.a(aVar, a(bVar.b()));
        return true;
    }

    public static com.tencent.msdk.dns.core.a.a.b b(java.lang.String str) {
        return (com.tencent.msdk.dns.core.a.a.b) b.get(str);
    }
}
