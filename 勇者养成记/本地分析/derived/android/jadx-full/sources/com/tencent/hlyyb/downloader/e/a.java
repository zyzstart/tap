package com.tencent.hlyyb.downloader.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    private com.tencent.hlyyb.downloader.e.h b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f613a = 0;
    private long c = 0;
    private long d = 0;
    private int e = 0;
    private long f = 0;
    private long g = 0;
    private int h = 0;
    private java.util.List i = new java.util.LinkedList();

    public a(com.tencent.hlyyb.downloader.e.h hVar) {
        this.b = hVar;
    }

    public final void a() {
        this.f613a = android.os.SystemClock.elapsedRealtime();
        this.c = 0L;
        this.d = 0L;
    }

    public final void a(int i, int i2) {
        this.e += i2;
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.f613a;
        this.f613a = jElapsedRealtime;
        this.b.j += j;
        boolean z = true;
        int i3 = 0;
        boolean z2 = i <= 0;
        long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
        int i4 = (int) (jElapsedRealtime2 - this.f);
        this.f = jElapsedRealtime2;
        if (this.i.size() != 0) {
            for (com.tencent.hlyyb.downloader.e.b bVar : this.i) {
                int i5 = bVar.b + i4;
                bVar.b = i5;
                if (!z2 && i5 > 2000) {
                    bVar.b = 0;
                    bVar.f617a = i;
                    z2 = true;
                }
            }
            if (!z2 && this.i.size() <= (2000 / com.tencent.hlyyb.downloader.a.a.d) + 1) {
                this.i.add(new com.tencent.hlyyb.downloader.e.b(i));
            }
            if (jElapsedRealtime2 - this.g <= 200) {
                z = false;
            }
        } else if (!z2) {
            this.i.add(new com.tencent.hlyyb.downloader.e.b(i));
        }
        if (z) {
            if (this.i.size() != 0) {
                long j2 = 0;
                for (com.tencent.hlyyb.downloader.e.b bVar2 : this.i) {
                    if (bVar2.b <= 2000) {
                        j2 += (long) bVar2.f617a;
                    }
                }
                i3 = (int) ((j2 * 1000) / com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY);
            }
            this.h = i3;
            this.g = jElapsedRealtime2;
        }
        this.b.q = this.h;
    }

    public final void b() {
        this.c = java.lang.System.currentTimeMillis();
    }

    public final void c() {
        this.d = java.lang.System.currentTimeMillis();
    }

    public final long d() {
        return this.d - this.c;
    }
}
