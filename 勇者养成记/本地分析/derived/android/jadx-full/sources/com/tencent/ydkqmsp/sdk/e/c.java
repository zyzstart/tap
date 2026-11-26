package com.tencent.ydkqmsp.sdk.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    static class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.tencent.ydkqmsp.sdk.app.a.getContext() != null) {
                    com.tencent.ydkqmsp.sdk.d.c cVar = new com.tencent.ydkqmsp.sdk.d.c(com.tencent.ydkqmsp.sdk.app.a.getContext());
                    com.tencent.ydkqmsp.sdk.c.f.i().a(cVar);
                    cVar.a();
                } else {
                    com.tencent.ydkqmsp.sdk.f.g.d("qp.updTask", 2, "Context is null!");
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a() {
        com.tencent.ydkqmsp.sdk.c.f.i().c().postDelayed(new com.tencent.ydkqmsp.sdk.e.c.a(), com.tencent.ydkqmsp.sdk.c.h.e);
    }
}
