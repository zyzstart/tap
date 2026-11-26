package com.qq.gdt.action.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h<T extends com.qq.gdt.action.c.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.List<com.qq.gdt.action.c.a> f78a;
    private final com.qq.gdt.action.c.f b;

    h(java.lang.String str, java.lang.Class<T> cls) throws java.io.IOException {
        this.b = new com.qq.gdt.action.c.f(str, cls);
        this.f78a = this.b.a();
    }

    public java.util.List<com.qq.gdt.action.c.a> a(int i) {
        int iMin = java.lang.Math.min(i, this.f78a.size());
        if (iMin <= 0) {
            return null;
        }
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.util.ListIterator<com.qq.gdt.action.c.a> listIterator = this.f78a.listIterator(0);
        while (listIterator.hasNext() && listIterator.nextIndex() < iMin) {
            linkedList.add(listIterator.next());
        }
        return linkedList;
    }

    public void a(com.qq.gdt.action.c.a aVar) {
        this.f78a.add(aVar);
        this.b.a(aVar);
    }

    public void a(java.util.Collection<T> collection) {
        for (T t : collection) {
            if (t != null && t.b() > 0) {
                this.f78a.remove(t);
                this.b.b(t);
            }
        }
    }
}
