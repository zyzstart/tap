package com.tencent.msdk.dns.base.log;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.List f656a;

    static {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        f656a = arrayList;
        arrayList.add(new com.tencent.msdk.dns.base.log.a());
    }

    public static void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        java.util.Iterator it = f656a.iterator();
        while (it.hasNext()) {
            ((com.tencent.msdk.dns.base.log.ILogNode) it.next()).println(i, str, str2, th);
        }
    }

    public static void a(com.tencent.msdk.dns.base.log.ILogNode iLogNode) {
        if (iLogNode != null) {
            f656a.add(iLogNode);
        }
    }
}
