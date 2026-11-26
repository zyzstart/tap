package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f524a = "AccessIpMgr";
    private static java.lang.String b;
    private static com.tencent.hlyyb.common.d.b.a.e c = new com.tencent.hlyyb.common.d.b.a.e();
    private static java.util.Map d = new java.util.concurrent.ConcurrentHashMap();
    private static java.util.Map e = new java.util.concurrent.ConcurrentHashMap();
    private static com.tencent.hlyyb.common.a.g f = new com.tencent.hlyyb.common.a.e();

    /* JADX WARN: Code duplicated, block: B:12:0x0035  */
    /* JADX WARN: Code duplicated, block: B:14:0x0045  */
    public static com.tencent.hlyyb.common.a.c.b a(java.lang.String str) {
        com.tencent.hlyyb.common.a.c cVar;
        com.tencent.hlyyb.common.a.f.e();
        java.lang.String str2 = b;
        if (str2 == null || str2.equals(com.tencent.hlyyb.common.a.f.b())) {
            if (b == null) {
            }
            cVar = (com.tencent.hlyyb.common.a.c) e.get(str);
            if (cVar != null) {
                com.tencent.hlyyb.common.a.c.b bVar = new com.tencent.hlyyb.common.a.c.b(cVar.b, cVar.d);
                bVar.c = cVar.a();
                return bVar;
            }
            com.tencent.hlyyb.common.a.a aVar = new com.tencent.hlyyb.common.a.a(str, -1);
            aVar.a((byte) 3);
            com.tencent.hlyyb.common.a.c.b bVar2 = new com.tencent.hlyyb.common.a.c.b(str, "");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(aVar);
            bVar2.c = arrayList;
            return bVar2;
        }
        com.tencent.hlyyb.common.d.f.d().f();
        d();
        c.a();
        b = com.tencent.hlyyb.common.a.f.b();
        cVar = (com.tencent.hlyyb.common.a.c) e.get(str);
        if (cVar != null) {
            com.tencent.hlyyb.common.a.c.b bVar3 = new com.tencent.hlyyb.common.a.c.b(cVar.b, cVar.d);
            bVar3.c = cVar.a();
            return bVar3;
        }
        com.tencent.hlyyb.common.a.a aVar2 = new com.tencent.hlyyb.common.a.a(str, -1);
        aVar2.a((byte) 3);
        com.tencent.hlyyb.common.a.c.b bVar4 = new com.tencent.hlyyb.common.a.c.b(str, "");
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add(aVar2);
        bVar4.c = arrayList2;
        return bVar4;
    }

    public static void a() {
        com.tencent.hlyyb.common.a.k().post(new com.tencent.hlyyb.common.a.d());
    }

    public static void a(java.lang.String str, com.tencent.hlyyb.common.a.a aVar, int i) {
        com.tencent.hlyyb.common.a.c cVar = (com.tencent.hlyyb.common.a.c) e.get(str);
        if (cVar != null) {
            if (i != 0) {
                cVar.b(aVar);
            } else {
                c.a(com.tencent.hlyyb.common.a.f.b(), str, aVar);
            }
        }
    }

    public static void b() {
        com.tencent.hlyyb.common.d.f.d().f();
    }

    public static void c() {
        c.a();
    }

    public static void d() {
        java.util.List<com.tencent.hlyyb.common.a.c.b> listA = com.tencent.hlyyb.common.d.f.d().f().a();
        if (listA != null) {
            for (com.tencent.hlyyb.common.a.c.b bVar : listA) {
                com.tencent.hlyyb.common.a.c cVar = new com.tencent.hlyyb.common.a.c(com.tencent.hlyyb.common.a.f.b());
                cVar.b = bVar.f530a;
                cVar.d = bVar.b;
                java.util.Iterator it = bVar.c.iterator();
                while (it.hasNext()) {
                    cVar.a((com.tencent.hlyyb.common.a.a) it.next());
                }
                com.tencent.hlyyb.common.a.a aVarA = c.a(com.tencent.hlyyb.common.a.f.b(), bVar.f530a);
                if (aVarA != null) {
                    cVar.c(aVarA);
                }
                new com.tencent.hlyyb.common.a.a(bVar.f530a, -1).a((byte) 3);
                e.put(bVar.f530a, cVar);
            }
        }
    }

    static /* synthetic */ void e() {
        com.tencent.hlyyb.common.a.f.e();
        b = com.tencent.hlyyb.common.a.f.b();
        com.tencent.hlyyb.common.d.f.d().f();
        d();
    }
}
