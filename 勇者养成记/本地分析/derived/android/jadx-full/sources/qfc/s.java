package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class s {
    public android.content.Context U;
    qfc.n V;
    public boolean q = false;
    qfc.t al = null;
    public android.content.ServiceConnection X = new qfc.s.a();

    final class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public final synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            android.util.Log.d("TGPA_MID", "Sumsung Service onServiceConnected");
            try {
                qfc.s.this.al = qfc.t.a.d(iBinder);
                if (!qfc.s.this.q || qfc.s.this.al == null) {
                    android.util.Log.d("TGPA_MID", "MSA Sumsung not supported");
                } else {
                    android.util.Log.d("TGPA_MID", "MSA Sumsung supported, oaid:" + qfc.s.this.al.h());
                    if (qfc.s.this.V != null) {
                        qfc.s.this.V.f(qfc.s.this.al.h());
                    }
                }
            } catch (java.lang.Throwable th) {
                android.util.Log.d("TGPA_MID", "MSA Sumsung oaid get exception.");
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            qfc.s.this.al = null;
            android.util.Log.d("TGPA_MID", "Sumsung Service onServiceDisconnected");
        }
    }

    public s(android.content.Context context, qfc.n nVar) {
        this.U = context;
        this.V = nVar;
    }
}
