package com.tencent.beaconselfupdate.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f231a;
    private android.content.Context b;

    public c(android.content.Context context) {
        this.b = null;
        this.b = context;
    }

    private static synchronized long a() {
        return f231a;
    }

    public static synchronized void a(long j) {
        f231a = j;
    }

    private static boolean a(android.content.Context context) {
        boolean z = true;
        try {
            int i = java.lang.Integer.parseInt(com.tencent.beaconselfupdate.a.a.b(context, "querytimes", "0"));
            if (!com.tencent.beaconselfupdate.a.e.g().equals(com.tencent.beaconselfupdate.a.a.b(context, "initsdkdate", ""))) {
                com.tencent.beaconselfupdate.a.a.b(context, com.tencent.beaconselfupdate.a.e.g());
                i = 0;
            }
            if (i <= com.tencent.beaconselfupdate.a.b.d.a().f()) {
                com.tencent.beaconselfupdate.a.a.a(context, java.lang.String.valueOf(i + 1));
                return false;
            }
            try {
                com.tencent.beaconselfupdate.c.a.e(" sdk init max times", new java.lang.Object[0]);
                return true;
            } catch (java.lang.Exception unused) {
            }
        } catch (java.lang.Exception unused2) {
            z = false;
        }
        com.tencent.beaconselfupdate.c.a.c(" set init times failed! ", new java.lang.Object[0]);
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        com.tencent.beaconselfupdate.a.b.a[] aVarArrI;
        com.tencent.beaconselfupdate.a.b.a[] aVarArrI2;
        com.tencent.beaconselfupdate.a.b.a[] aVarArrI3;
        com.tencent.beaconselfupdate.a.b.g gVarH = com.tencent.beaconselfupdate.a.e.h(this.b);
        if (gVarH != null && gVarH.b() == 101 && gVarH.c() != null) {
            try {
                com.tencent.beaconselfupdate.upload.e eVarF = com.tencent.beaconselfupdate.a.b.b.a(this.b).f();
                if (eVarF != null) {
                    eVarF.a(101, gVarH.c(), false);
                    com.tencent.beaconselfupdate.c.a.e("common strategy setted by local db", new java.lang.Object[0]);
                }
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.a(th);
            }
        }
        com.tencent.beaconselfupdate.a.b.b bVarA = com.tencent.beaconselfupdate.a.b.b.a(this.b);
        if (bVarA.j() == 0) {
            com.tencent.beaconselfupdate.c.a.e("stepCheckApp", new java.lang.Object[0]);
            bVarA.a(1);
            boolean zC = com.tencent.beaconselfupdate.a.a.c(this.b);
            com.tencent.beaconselfupdate.c.a.e("isAppFirstRun : %b", java.lang.Boolean.valueOf(zC));
            if (zC) {
                com.tencent.beaconselfupdate.c.a.e("clear all ao: %d", java.lang.Integer.valueOf(com.tencent.beaconselfupdate.a.a.a.a(this.b, (int[]) null)));
                synchronized (bVarA) {
                    com.tencent.beaconselfupdate.c.a.e("appfirstRun", new java.lang.Object[0]);
                    aVarArrI3 = bVarA.i();
                    bVarA.h();
                }
                if (aVarArrI3 != null) {
                    com.tencent.beaconselfupdate.c.a.e("notify listener first run", new java.lang.Object[0]);
                    for (com.tencent.beaconselfupdate.a.b.a aVar : aVarArrI3) {
                        aVar.c();
                    }
                }
            } else {
                long jA = a();
                if (jA > 0) {
                    com.tencent.beaconselfupdate.c.a.e("sleep: %d", java.lang.Long.valueOf(jA));
                    try {
                        java.lang.Thread.sleep(jA);
                    } catch (java.lang.InterruptedException e) {
                        com.tencent.beaconselfupdate.c.a.a(e);
                    }
                }
            }
        }
        synchronized (bVarA) {
            com.tencent.beaconselfupdate.c.a.e("stepStartQuery", new java.lang.Object[0]);
            aVarArrI = bVarA.i();
            bVarA.a(2);
        }
        if (aVarArrI != null) {
            com.tencent.beaconselfupdate.c.a.e("notify listener query start", new java.lang.Object[0]);
            for (com.tencent.beaconselfupdate.a.b.a aVar2 : aVarArrI) {
                aVar2.a();
            }
        }
        if (!com.tencent.beaconselfupdate.a.b.d.a().g()) {
            com.tencent.beaconselfupdate.upload.f fVarC = com.tencent.beaconselfupdate.a.b.b.c();
            int i = 0;
            while (fVarC == null) {
                i++;
                if (i >= 5) {
                    break;
                }
                try {
                    java.lang.Thread.sleep(200L);
                } catch (java.lang.InterruptedException e2) {
                    com.tencent.beaconselfupdate.c.a.a(e2);
                }
                fVarC = com.tencent.beaconselfupdate.a.b.b.c();
            }
            if (fVarC == null) {
                com.tencent.beaconselfupdate.c.a.h("no uphandler ,no upload!", new java.lang.Object[0]);
            } else if (a(this.b)) {
                com.tencent.beaconselfupdate.c.a.c("startQuery: query times arrive max, return!", new java.lang.Object[0]);
                com.tencent.beaconselfupdate.a.b.b.a(this.b).b();
            } else {
                fVarC.a(new com.tencent.beaconselfupdate.upload.c(this.b));
            }
        }
        com.tencent.beaconselfupdate.c.a.h("common query end!", new java.lang.Object[0]);
        synchronized (bVarA) {
            aVarArrI2 = bVarA.i();
            bVarA.a(3);
        }
        if (aVarArrI2 != null) {
            com.tencent.beaconselfupdate.c.a.e("notify listener query end", new java.lang.Object[0]);
            for (com.tencent.beaconselfupdate.a.b.a aVar3 : aVarArrI2) {
                aVar3.b();
            }
        }
        com.tencent.beaconselfupdate.a.b.d dVarE = com.tencent.beaconselfupdate.a.b.b.a(this.b).e();
        if (dVarE == null) {
            com.tencent.beaconselfupdate.c.a.d("magic should never null ? comStrategy", new java.lang.Object[0]);
            return;
        }
        long jC = dVarE.c() * com.youme.im.CommonConst.SPEECH_DURATION_MAX;
        if (jC <= 0) {
            com.tencent.beaconselfupdate.c.a.h("stop loop query", new java.lang.Object[0]);
            return;
        }
        com.tencent.beaconselfupdate.a.b.a().a(this, jC);
        com.tencent.beaconselfupdate.c.a.h("next time: %d", java.lang.Long.valueOf(jC));
        com.tencent.beaconselfupdate.a.b.b.a(this.b).a(4);
    }
}
