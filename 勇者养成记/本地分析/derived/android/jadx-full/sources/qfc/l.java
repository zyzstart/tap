package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class l {
    public android.content.Context U;
    qfc.n V;
    public android.content.ServiceConnection X = new qfc.l.a();
    qfc.m ac;
    public boolean q;

    final class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                qfc.l.this.ac = qfc.m.a.b(iBinder);
                if (!qfc.l.this.q || qfc.l.this.ac == null) {
                    android.util.Log.d("TGPA_MID", "MSA Lenovo Service get oaid failed.");
                    return;
                }
                if (!qfc.l.this.ac.i()) {
                    android.util.Log.d("TGPA_MID", "MSA Lenovo not supported");
                    return;
                }
                android.util.Log.d("TGPA_MID", "MSA Lenovo supported oaid:" + qfc.l.this.ac.h());
                if (qfc.l.this.V != null) {
                    qfc.l.this.V.f(qfc.l.this.ac.h());
                }
            } catch (java.lang.Throwable th) {
                android.util.Log.d("TGPA_MID", "MSA Lenovo oaid get exception.");
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            android.util.Log.d("TGPA_MID", "Lenovo MSA onServiceDisconnected ");
        }
    }

    public l(android.content.Context context, qfc.n nVar) {
        this.U = context;
        this.V = nVar;
    }
}
