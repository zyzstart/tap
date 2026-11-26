package com.tencent.ydkbeacon.event.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.ydkbeacon.event.b.c f1252a;

    abstract com.tencent.ydkbeacon.event.open.BeaconEvent a(com.tencent.ydkbeacon.event.open.BeaconEvent beaconEvent);

    public void a(com.tencent.ydkbeacon.event.b.c cVar) {
        this.f1252a = cVar;
    }

    @android.support.annotation.Nullable
    public final com.tencent.ydkbeacon.event.EventBean b(com.tencent.ydkbeacon.event.open.BeaconEvent beaconEvent) {
        com.tencent.ydkbeacon.event.open.BeaconEvent beaconEventA = a(beaconEvent);
        com.tencent.ydkbeacon.event.b.c cVar = this.f1252a;
        return cVar != null ? cVar.b(beaconEventA) : com.tencent.ydkbeacon.event.c.a.a(beaconEventA);
    }
}
