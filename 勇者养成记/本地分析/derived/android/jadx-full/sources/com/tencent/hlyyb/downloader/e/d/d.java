package com.tencent.hlyyb.downloader.e.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.util.List f629a;
    java.util.List b;
    com.tencent.hlyyb.downloader.e.d.a c;
    com.tencent.hlyyb.downloader.e.d.a d;
    boolean e = false;
    boolean f = false;
    private java.lang.String g;
    private java.util.List h;
    private java.util.List i;
    private java.util.List j;
    private /* synthetic */ com.tencent.hlyyb.downloader.e.d.c k;

    public d(com.tencent.hlyyb.downloader.e.d.c cVar, java.lang.String str) {
        this.k = cVar;
        this.g = str;
    }

    private static void a(java.lang.StringBuilder sb, java.util.List list) {
        if (list != null) {
            synchronized (list) {
                if (list != null) {
                    if (list.size() > 0) {
                        java.util.Iterator it = list.iterator();
                        while (it.hasNext()) {
                            com.tencent.hlyyb.downloader.e.d.a aVar = (com.tencent.hlyyb.downloader.e.d.a) it.next();
                            if (aVar != null) {
                                sb.append(aVar);
                                sb.append(",");
                            }
                        }
                    }
                }
            }
        }
    }

    private java.util.List b(int i) {
        if (i == com.tencent.hlyyb.downloader.e.d.b.c) {
            return this.h;
        }
        if (i == com.tencent.hlyyb.downloader.e.d.b.e) {
            return this.i;
        }
        if (i == com.tencent.hlyyb.downloader.e.d.b.f) {
            return this.f629a;
        }
        if (i == com.tencent.hlyyb.downloader.e.d.b.j) {
            return this.b;
        }
        if (i == com.tencent.hlyyb.downloader.e.d.b.h) {
            return this.j;
        }
        return null;
    }

    public final synchronized com.tencent.hlyyb.downloader.e.d.a a(int i) {
        java.util.List listB;
        if (i == com.tencent.hlyyb.downloader.e.d.b.d) {
            return this.c;
        }
        if (i == com.tencent.hlyyb.downloader.e.d.b.i) {
            return this.d;
        }
        if (!com.tencent.hlyyb.downloader.e.d.a.b(i) || (listB = b(i)) == null) {
            return null;
        }
        return (com.tencent.hlyyb.downloader.e.d.a) listB.get(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized com.tencent.hlyyb.downloader.e.d.a a(com.tencent.hlyyb.downloader.e.d.a aVar) {
        if (aVar == null) {
            return null;
        }
        java.util.List listB = b(aVar.b);
        if (listB != null) {
            for (int i = 0; i < listB.size(); i++) {
                if (aVar == listB.get(i)) {
                    if (i == listB.size() - 1) {
                        return null;
                    }
                    return (com.tencent.hlyyb.downloader.e.d.a) listB.get(i + 1);
                }
            }
        }
        return null;
    }

    public final synchronized java.util.List a() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        arrayList.add(this.k.f628a);
        java.util.List list = this.h;
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        java.util.List list2 = this.i;
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        java.util.List list3 = this.f629a;
        if (list3 != null && list3.size() > 0) {
            arrayList.addAll(list3);
        }
        java.util.List list4 = this.b;
        if (list4 != null && list4.size() > 0) {
            arrayList.addAll(list4);
        }
        com.tencent.hlyyb.downloader.e.d.a aVar = this.c;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        java.util.List list5 = this.j;
        if (list5 != null && list5.size() > 0) {
            arrayList.addAll(list5);
        }
        com.tencent.hlyyb.downloader.e.d.a aVar2 = this.d;
        if (aVar2 != null) {
            arrayList.add(aVar2);
        }
        com.tencent.hlyyb.downloader.e.d.a aVar3 = this.k.b;
        if (aVar3 != null) {
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public final synchronized void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (this.c == null) {
            com.tencent.hlyyb.downloader.e.d.a aVar = new com.tencent.hlyyb.downloader.e.d.a(str, com.tencent.hlyyb.downloader.e.d.b.d);
            this.c = aVar;
            aVar.c = this.k.f.getAndIncrement();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a(java.lang.String str, int i) {
        java.util.List list;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (i == com.tencent.hlyyb.downloader.e.d.b.c) {
            if (this.h == null) {
                this.h = new java.util.ArrayList();
            }
            list = this.h;
        } else if (i == com.tencent.hlyyb.downloader.e.d.b.e) {
            if (this.i == null) {
                this.i = new java.util.ArrayList();
            }
            list = this.i;
        } else if (i == com.tencent.hlyyb.downloader.e.d.b.f) {
            if (this.f629a == null) {
                this.f629a = new java.util.ArrayList();
            }
            list = this.f629a;
        } else if (i == com.tencent.hlyyb.downloader.e.d.b.j) {
            if (this.b == null) {
                this.b = new java.util.ArrayList();
            }
            list = this.b;
        } else {
            if (i != com.tencent.hlyyb.downloader.e.d.b.h) {
                return;
            }
            if (this.j == null) {
                this.j = new java.util.ArrayList();
            }
            list = this.j;
        }
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(((com.tencent.hlyyb.downloader.e.d.a) it.next()).f626a)) {
                return;
            }
        }
        com.tencent.hlyyb.downloader.e.d.a aVar = new com.tencent.hlyyb.downloader.e.d.a(str, i);
        aVar.c = this.k.f.getAndIncrement();
        list.add(aVar);
    }

    public final synchronized void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (this.d == null) {
            com.tencent.hlyyb.downloader.e.d.a aVar = new com.tencent.hlyyb.downloader.e.d.a(str, com.tencent.hlyyb.downloader.e.d.b.i);
            this.d = aVar;
            aVar.c = this.k.f.getAndIncrement();
        }
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.tencent.hlyyb.common.f.c.b(this.g));
        sb.append(",");
        a(sb, this.h);
        a(sb, this.i);
        a(sb, this.f629a);
        a(sb, this.b);
        com.tencent.hlyyb.downloader.e.d.a aVar = this.c;
        if (aVar != null) {
            sb.append(aVar);
            sb.append(",");
        }
        a(sb, this.j);
        com.tencent.hlyyb.downloader.e.d.a aVar2 = this.d;
        if (aVar2 != null) {
            sb.append(aVar2);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
