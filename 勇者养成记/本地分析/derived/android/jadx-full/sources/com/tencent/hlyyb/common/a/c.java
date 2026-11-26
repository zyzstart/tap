package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.lang.Integer f528a;
    java.lang.String b;
    java.lang.String c;
    java.lang.String d;
    private java.lang.String e;
    private java.util.List f;
    private java.util.List g;
    private java.util.List h;
    private java.util.List i;

    public c(java.lang.String str) {
        this.e = str;
    }

    public final synchronized java.util.List a() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        java.util.List list = this.f;
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        java.util.List list2 = this.g;
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        java.util.List list3 = this.h;
        if (list3 != null && list3.size() > 0) {
            arrayList.addAll(list3);
        }
        java.util.List list4 = this.i;
        if (list4 != null && list4.size() > 0) {
            arrayList.addAll(list4);
        }
        return arrayList;
    }

    public final synchronized void a(com.tencent.hlyyb.common.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.b() == 1) {
            if (this.f == null) {
                this.f = new java.util.ArrayList();
            }
            this.f.add(aVar);
            return;
        }
        if (aVar.b() == 2) {
            if (this.g == null) {
                this.g = new java.util.ArrayList();
            }
            this.g.add(aVar);
        } else if (aVar.b() == 3) {
            if (this.h == null) {
                this.h = new java.util.ArrayList();
            }
            this.h.add(aVar);
        } else if (aVar.b() == 4) {
            if (this.i == null) {
                this.i = new java.util.ArrayList();
            }
            this.i.add(aVar);
        } else {
            if (this.f == null) {
                this.f = new java.util.ArrayList();
            }
            this.f.add(aVar);
        }
    }

    public final synchronized void b(com.tencent.hlyyb.common.a.a aVar) {
        java.util.List list;
        if (aVar == null) {
            return;
        }
        if (aVar.b() == 1) {
            java.util.List list2 = this.f;
            if (list2 != null && aVar.a((com.tencent.hlyyb.common.a.a) list2.get(0))) {
                java.util.List list3 = this.f;
                list3.add((com.tencent.hlyyb.common.a.a) list3.get(0));
                list3.remove(0);
            }
        } else if (aVar.b() == 2 && (list = this.g) != null && aVar.a((com.tencent.hlyyb.common.a.a) list.get(0))) {
            java.util.List list4 = this.g;
            list4.add((com.tencent.hlyyb.common.a.a) list4.get(0));
            list4.remove(0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void c(com.tencent.hlyyb.common.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.b() == 1) {
            if (this.f != null) {
                for (int i = 0; i < this.f.size(); i++) {
                    if (aVar.a((com.tencent.hlyyb.common.a.a) this.f.get(0))) {
                        return;
                    }
                    java.util.List list = this.f;
                    list.add((com.tencent.hlyyb.common.a.a) list.get(0));
                    list.remove(0);
                }
            }
        } else if (aVar.b() == 2 && this.g != null) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                if (aVar.a((com.tencent.hlyyb.common.a.a) this.g.get(0))) {
                    return;
                }
                java.util.List list2 = this.g;
                list2.add((com.tencent.hlyyb.common.a.a) list2.get(0));
                list2.remove(0);
            }
        }
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Appid：" + this.f528a + " domain：" + this.b + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE);
        sb.append("apn：" + this.e + " ckIP：" + this.c + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE);
        java.util.Iterator it = a().iterator();
        while (it.hasNext()) {
            sb.append("accessIP：" + ((com.tencent.hlyyb.common.a.a) it.next()).toString() + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE);
        }
        return sb.toString();
    }
}
