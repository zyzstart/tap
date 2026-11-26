package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class s implements com.tencent.yybsdk.apkpatch.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String f1440a = "s";
    private static com.tencent.yybsdk.apkpatch.s i;
    private com.tencent.yybsdk.apkpatch.e.b.a e;
    private android.content.Context f;
    private com.tencent.yybsdk.apkpatch.r h;
    private final java.util.concurrent.ConcurrentHashMap b = new java.util.concurrent.ConcurrentHashMap();
    private final java.util.concurrent.ConcurrentHashMap c = new java.util.concurrent.ConcurrentHashMap();
    private com.tencent.yybsdk.apkpatch.w d = new com.tencent.yybsdk.apkpatch.w(3, 3, 30, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
    private com.tencent.yybsdk.apkpatch.p g = new com.tencent.yybsdk.apkpatch.p();

    private s() {
    }

    public static com.tencent.yybsdk.apkpatch.s a() {
        if (i == null) {
            i = new com.tencent.yybsdk.apkpatch.s();
            com.tencent.yybsdk.apkpatch.f.a.a(f1440a, "this: " + i);
        }
        return i;
    }

    public void a(android.content.Context context) {
        this.f = context;
    }

    public void a(com.tencent.yybsdk.apkpatch.r rVar) {
        this.h = rVar;
    }

    public void a(com.tencent.yybsdk.apkpatch.u uVar) {
        if (uVar == null) {
            com.tencent.yybsdk.apkpatch.f.a.d(f1440a, "startPatch param task == null");
        }
        com.tencent.yybsdk.apkpatch.f.a.a(f1440a, "startPatch called with param " + uVar.toString());
        com.tencent.yybsdk.apkpatch.a aVar = (com.tencent.yybsdk.apkpatch.a) this.c.get(uVar.a());
        boolean z = false;
        if (aVar == null) {
            com.tencent.yybsdk.apkpatch.a aVar2 = new com.tencent.yybsdk.apkpatch.a(new com.tencent.yybsdk.apkpatch.j(uVar, this, this.e));
            this.c.put(uVar.a(), aVar2);
            try {
                this.d.execute(aVar2);
                z = true;
            } catch (java.util.concurrent.RejectedExecutionException unused) {
                com.tencent.yybsdk.apkpatch.f.a.d(f1440a, "mApkPatchThreadPool is full.");
                this.c.remove(uVar.a());
                this.h.a(uVar, 8, -32, null);
            }
        } else if (aVar.b) {
            com.tencent.yybsdk.apkpatch.f.a.a(f1440a, "waiting last Task for stopping");
            c(uVar.a()).a();
            this.b.putIfAbsent(uVar.a(), uVar);
            z = true;
        } else {
            com.tencent.yybsdk.apkpatch.f.a.c(f1440a, "Task has existed1");
        }
        if (z) {
            return;
        }
        try {
            uVar.d.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.yybsdk.apkpatch.r
    public void a(com.tencent.yybsdk.apkpatch.u uVar, int i2, int i3) {
        com.tencent.yybsdk.apkpatch.r rVar = this.h;
        if (rVar != null) {
            rVar.a(uVar, i2, i3);
        }
    }

    @Override // com.tencent.yybsdk.apkpatch.r
    public void a(com.tencent.yybsdk.apkpatch.u uVar, int i2, int i3, java.lang.String str) {
        com.tencent.yybsdk.apkpatch.r rVar;
        com.tencent.yybsdk.apkpatch.f.a.a(f1440a, "onApkPatchState, state = " + i2 + " errorCode = " + i3 + " errorMsg = " + str + "\n task = " + uVar.toString());
        if (i2 == 7 || i2 == 8) {
            com.tencent.yybsdk.apkpatch.f.a.b(f1440a, "remove future task from mApkFutureTaskMap as the task end");
            this.c.remove(uVar.d.b());
            rVar = this.h;
            if (rVar == null) {
                return;
            }
        } else {
            if (i2 != 4 && i2 != 6) {
                return;
            }
            com.tencent.yybsdk.apkpatch.f.a.b(f1440a, "remove future task from mApkFutureTaskMap as the task pause|cancel");
            this.c.remove(uVar.d.b());
            com.tencent.yybsdk.apkpatch.u uVar2 = (com.tencent.yybsdk.apkpatch.u) this.b.get(uVar.d.b());
            if (uVar2 != null) {
                com.tencent.yybsdk.apkpatch.f.a.a(f1440a, "start a waiting task");
                this.b.remove(uVar2);
                a(uVar2);
                return;
            }
            rVar = this.h;
        }
        rVar.a(uVar, i2, i3, str);
    }

    public void a(java.lang.String str) {
        this.g.a(str);
    }

    public void a(boolean z, boolean z2) {
        com.tencent.yybsdk.apkpatch.f.a.b = z;
        com.tencent.yybsdk.apkpatch.f.a.f1415a = z2;
    }

    public android.content.Context b() {
        return this.f;
    }

    public void b(android.content.Context context) {
        a(context);
        this.g.a(this.f);
        com.tencent.yybsdk.apkpatch.e.b.a aVar = new com.tencent.yybsdk.apkpatch.e.b.a(this.f);
        this.e = aVar;
        boolean zE = aVar.e();
        com.tencent.yybsdk.apkpatch.f.a.a(f1440a, "delete finished or expired apk patch task, result = " + zE);
    }

    public void b(java.lang.String str) {
        this.g.b(str);
    }

    public com.tencent.yybsdk.apkpatch.b.a c(java.lang.String str) {
        com.tencent.yybsdk.apkpatch.a aVar;
        if (android.text.TextUtils.isEmpty(str) || (aVar = (com.tencent.yybsdk.apkpatch.a) this.c.get(str)) == null) {
            return null;
        }
        return aVar.f1390a.f1432a.d;
    }
}
