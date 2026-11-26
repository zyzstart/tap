package com.tencent.beacon.core.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f implements com.tencent.beacon.core.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.beacon.core.b.f f146a = null;
    private static boolean b = false;
    private com.tencent.beacon.core.network.volley.RequestQueue c;
    private android.content.Context d;

    private f() {
    }

    public static com.tencent.beacon.core.b.f a() {
        if (f146a == null) {
            synchronized (com.tencent.beacon.core.b.f.class) {
                if (f146a == null) {
                    f146a = new com.tencent.beacon.core.b.f();
                }
            }
        }
        return f146a;
    }

    public void a(android.content.Context context) {
        if (b) {
            return;
        }
        b = true;
        com.tencent.beacon.core.network.volley.RequestQueue requestQueueNewRequestQueue = com.tencent.beacon.core.network.volley.Volley.newRequestQueue(context.getApplicationContext());
        this.c = requestQueueNewRequestQueue;
        this.d = context;
        requestQueueNewRequestQueue.start();
    }

    @Override // com.tencent.beacon.core.b.a
    public void a(java.lang.String str, java.util.Map map, com.tencent.beacon.core.b.b bVar) {
        com.tencent.beacon.core.b.e eVar = new com.tencent.beacon.core.b.e(this, 1, str, new com.tencent.beacon.core.b.c(this, bVar), new com.tencent.beacon.core.b.d(this, bVar), map);
        com.tencent.beacon.core.e.d.a("[net] requestUrl: %s, params: %s", str, com.tencent.beacon.core.e.c.a(map));
        this.c.add(eVar);
    }
}
