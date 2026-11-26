package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class h {
    public android.content.Context U;
    qfc.n V;
    qfc.i W;
    public android.content.ServiceConnection X = new qfc.h.a();
    public boolean q;

    final class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                qfc.h.this.W = qfc.i.a.a(iBinder);
                if (!qfc.h.this.q || qfc.h.this.W == null) {
                    android.util.Log.d("TGPA_MID", "MSA ASUS Service get oaid failed.");
                    return;
                }
                if (!qfc.h.this.W.c()) {
                    android.util.Log.d("TGPA_MID", "MSA ASUS not supported");
                    return;
                }
                android.util.Log.d("TGPA_MID", "MSA ASUS supported, oaid:" + qfc.h.this.W.e());
                if (qfc.h.this.V != null) {
                    qfc.h.this.V.f(qfc.h.this.W.e());
                }
            } catch (java.lang.Throwable th) {
                android.util.Log.d("TGPA_MID", "MSA ASUS oaid get exception.");
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            android.util.Log.d("TGPA_MID", "ASUS MSA onServiceDisconnected ");
        }
    }

    public h(android.content.Context context, qfc.n nVar) {
        this.U = context;
        this.V = nVar;
    }
}
