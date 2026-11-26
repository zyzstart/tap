package com.tencent.ydkbeacon.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.ydkbeacon.a.a.b f1176a;
    private final java.lang.Object c = new java.lang.Object();
    private java.util.concurrent.atomic.AtomicBoolean f = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final android.util.SparseArray b = new android.util.SparseArray();
    private final android.util.SparseArray d = new android.util.SparseArray();
    private final android.util.SparseArray e = new android.util.SparseArray();

    private b() {
    }

    public static com.tencent.ydkbeacon.a.a.b a() {
        if (f1176a == null) {
            synchronized (com.tencent.ydkbeacon.a.a.b.class) {
                if (f1176a == null) {
                    f1176a = new com.tencent.ydkbeacon.a.a.b();
                }
            }
        }
        return f1176a;
    }

    private java.lang.Object a(int i) {
        java.lang.Object obj;
        synchronized (this.c) {
            obj = this.e.get(i);
            if (obj == null) {
                obj = new java.lang.Object();
                this.e.put(i, obj);
            }
        }
        return obj;
    }

    private java.util.List b(int i) {
        java.util.List list = (java.util.List) this.b.get(i);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void c(com.tencent.ydkbeacon.a.a.c cVar) {
        d(cVar);
        synchronized (a(cVar.f1177a)) {
            try {
                java.util.List listB = b(cVar.f1177a);
                if (listB == null) {
                    return;
                }
                java.util.Iterator it = listB.iterator();
                while (it.hasNext()) {
                    try {
                        ((com.tencent.ydkbeacon.a.a.d) it.next()).onEvent(cVar);
                    } catch (java.lang.Throwable th) {
                        com.tencent.ydkbeacon.a.e.c.a(th);
                        if (this.f.compareAndSet(false, true)) {
                            com.tencent.ydkbeacon.a.b.d.b().a("512", "dispatchEvent error", th);
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
    }

    private void d(com.tencent.ydkbeacon.a.a.c cVar) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(int i, com.tencent.ydkbeacon.a.a.d dVar) {
        synchronized (a(i)) {
            java.util.List arrayList = (java.util.List) this.b.get(i);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList();
                this.b.put(i, arrayList);
            }
            arrayList.add(dVar);
            java.util.List list = (java.util.List) this.d.get(i);
            if (list != null) {
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        dVar.onEvent((com.tencent.ydkbeacon.a.a.c) it.next());
                    } catch (java.lang.Throwable th) {
                        com.tencent.ydkbeacon.a.e.c.a(th);
                    }
                }
            }
        }
    }

    public void a(@android.support.annotation.NonNull com.tencent.ydkbeacon.a.a.c cVar) {
        com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.a.a.a(this, cVar));
    }

    public void b(@android.support.annotation.NonNull com.tencent.ydkbeacon.a.a.c cVar) {
        synchronized (a(cVar.f1177a)) {
            com.tencent.ydkbeacon.a.a.c cVar2 = new com.tencent.ydkbeacon.a.a.c(cVar.f1177a, cVar.b);
            java.util.List arrayList = (java.util.List) this.d.get(cVar2.f1177a);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList();
                this.d.put(cVar2.f1177a, arrayList);
            }
            arrayList.add(cVar2);
            c(cVar);
        }
    }
}
