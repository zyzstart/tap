package com.tencent.yybsdk.apkpatch.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.Map f1407a = new java.util.HashMap();

    private int d(int i, int i2) {
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6) {
            com.tencent.yybsdk.apkpatch.f.a.d("TimerUtil", "no such mainEvent " + i);
            return -1;
        }
        if (i2 == -1 || i2 == 10003 || i2 == 10000 || i2 == 10002 || i2 == 10001 || i2 == 10005 || i2 == 10004 || i2 == 10006) {
            return 2;
        }
        com.tencent.yybsdk.apkpatch.f.a.d("TimerUtil", "no such subEvent " + i2);
        return 1;
    }

    public void a(int i) {
        a(i, -1);
    }

    public void a(int i, int i2) {
        int iD = d(i, i2);
        if (iD != 0 && iD != 2) {
            com.tencent.yybsdk.apkpatch.f.a.d("TimerUtil", "event validate result is " + iD);
            return;
        }
        com.tencent.yybsdk.apkpatch.d.d dVar = new com.tencent.yybsdk.apkpatch.d.d(i, i2);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.f1407a.containsKey(dVar)) {
            ((com.tencent.yybsdk.apkpatch.d.c) this.f1407a.get(dVar)).d(jCurrentTimeMillis);
            return;
        }
        com.tencent.yybsdk.apkpatch.d.c cVar = new com.tencent.yybsdk.apkpatch.d.c(dVar);
        cVar.a(jCurrentTimeMillis);
        cVar.d(jCurrentTimeMillis);
        this.f1407a.put(dVar, cVar);
    }

    public void b(int i) {
        b(i, -1);
    }

    public void b(int i, int i2) {
        java.lang.String str;
        int iD = d(i, i2);
        if (iD == 0 || iD == 2) {
            com.tencent.yybsdk.apkpatch.d.d dVar = new com.tencent.yybsdk.apkpatch.d.d(i, i2);
            if (this.f1407a.containsKey(dVar)) {
                com.tencent.yybsdk.apkpatch.d.c cVar = (com.tencent.yybsdk.apkpatch.d.c) this.f1407a.get(dVar);
                long jD = cVar.d();
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                cVar.b(jCurrentTimeMillis);
                cVar.c((jCurrentTimeMillis - jD) + cVar.c());
                return;
            }
            str = "no such event (" + i + "," + i2 + ") in the map";
        } else {
            str = "event validate result is " + iD;
        }
        com.tencent.yybsdk.apkpatch.f.a.d("TimerUtil", str);
    }

    public com.tencent.yybsdk.apkpatch.d.c c(int i) {
        return c(i, -1);
    }

    public com.tencent.yybsdk.apkpatch.d.c c(int i, int i2) {
        int iD = d(i, i2);
        if (iD == 0 || iD == 2) {
            com.tencent.yybsdk.apkpatch.d.d dVar = new com.tencent.yybsdk.apkpatch.d.d(i, i2);
            if (this.f1407a.containsKey(dVar)) {
                com.tencent.yybsdk.apkpatch.d.c cVar = (com.tencent.yybsdk.apkpatch.d.c) this.f1407a.get(dVar);
                if (!(cVar.b() < cVar.a())) {
                    return cVar;
                }
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                cVar.b(jCurrentTimeMillis);
                cVar.c(cVar.c() + (jCurrentTimeMillis - cVar.d()));
                return cVar;
            }
            if (i2 == -1) {
                com.tencent.yybsdk.apkpatch.d.c cVar2 = new com.tencent.yybsdk.apkpatch.d.c(dVar);
                long jMin = Long.MAX_VALUE;
                long jC = 0;
                long jMax = Long.MIN_VALUE;
                for (java.util.Map.Entry entry : this.f1407a.entrySet()) {
                    if (((com.tencent.yybsdk.apkpatch.d.d) entry.getKey()).a() == dVar.a()) {
                        jC += ((com.tencent.yybsdk.apkpatch.d.c) entry.getValue()).c();
                        jMin = java.lang.Math.min(jMin, ((com.tencent.yybsdk.apkpatch.d.c) entry.getValue()).a());
                        jMax = java.lang.Math.max(jMax, ((com.tencent.yybsdk.apkpatch.d.c) entry.getValue()).b());
                    }
                }
                cVar2.c(jC);
                cVar2.a(jMin);
                cVar2.b(jMax);
                return cVar2;
            }
        } else {
            com.tencent.yybsdk.apkpatch.f.a.d("TimerUtil", "event validate result is " + iD);
        }
        return null;
    }
}
