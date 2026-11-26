package com.tencent.ydkqmsp.sdk.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.e.a$a, reason: collision with other inner class name */
    static class RunnableC0050a implements java.lang.Runnable {
        RunnableC0050a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.tencent.ydkqmsp.sdk.c.f.i().b().a(false);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a() {
        com.tencent.ydkqmsp.sdk.c.f.i().c().post(new com.tencent.ydkqmsp.sdk.e.a.RunnableC0050a());
    }
}
