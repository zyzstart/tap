package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class e extends com.tencent.hlyyb.common.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f554a;
    public boolean b;
    public boolean c;
    public boolean d;
    public java.util.List e;
    private int f;
    private int g;
    private /* synthetic */ com.tencent.hlyyb.common.c.a h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(com.tencent.hlyyb.common.c.a aVar, boolean z, boolean z2) {
        super(aVar, (byte) 0);
        this.h = aVar;
        this.d = false;
        this.b = z;
        this.c = z2;
        this.f = 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f554a = false;
        java.util.List listB = null;
        if (this.b) {
            int size = this.h.g.size();
            if (size != 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                int i = 0;
                for (int i2 = 0; i < size && i2 < 10; i2++) {
                    java.lang.String str = (java.lang.String) this.h.g.get(i);
                    arrayList2.add(new com.tencent.hlyyb.common.c.o(0L, str));
                    arrayList.add(str);
                    i++;
                }
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    this.h.g.remove(arrayList.get(i3));
                }
                if (this.h.g.size() == 0) {
                    this.f554a = true;
                }
                listB = arrayList2;
            }
        } else {
            if (!com.tencent.hlyyb.common.c.n.a(this.h.c()).a(com.tencent.hlyyb.common.a.e.a("report_clear_db_num", 1, 10000, 1000))) {
                listB = com.tencent.hlyyb.common.c.n.a(this.h.c()).b(11);
                if (listB.size() <= 10) {
                    this.f554a = true;
                    this.h.m = true;
                } else {
                    listB.remove(listB.size() - 1);
                }
            }
        }
        this.e = listB;
        java.util.List list = this.e;
        if (list == null || list.size() == 0) {
            com.tencent.hlyyb.common.c.a.b(this.h, false);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i4 = 0; i4 < this.e.size(); i4++) {
            sb.append(((com.tencent.hlyyb.common.c.o) this.e.get(i4)).b);
            sb.append("\n");
        }
        java.lang.String string = sb.toString();
        if (this.b && string.contains("client_report_time")) {
            string = string.replace("client_report_time", com.tencent.hlyyb.common.f.c.a(java.lang.System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        }
        byte[] bytes = string.getBytes();
        int length = bytes.length;
        this.g = length;
        byte[] bArrA = com.tencent.hlyyb.common.a.e.a(bytes);
        com.tencent.hlyyb.common.c.a.a(this.h, bArrA.length);
        this.h.e.a(bArrA, length, this.b, this, this.h.n, this.f);
    }
}
