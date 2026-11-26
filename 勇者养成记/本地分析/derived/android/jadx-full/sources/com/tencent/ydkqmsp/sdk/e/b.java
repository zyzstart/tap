package com.tencent.ydkqmsp.sdk.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    static class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.tencent.ydkqmsp.sdk.app.a.getContext() != null) {
                    com.tencent.ydkqmsp.sdk.c.g.a(com.tencent.ydkqmsp.sdk.app.a.getContext());
                } else {
                    com.tencent.ydkqmsp.sdk.f.g.d("qmsp.cbid", 2, "Context is null!");
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a() {
        com.tencent.ydkqmsp.sdk.c.f.i().c().postDelayed(new com.tencent.ydkqmsp.sdk.e.b.a(), com.tencent.ydkqmsp.sdk.c.h.f);
    }
}
