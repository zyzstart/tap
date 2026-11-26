package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class j {
    public android.content.Context U;
    qfc.n V;
    public boolean q = false;
    qfc.k aa = null;
    public android.content.ServiceConnection X = new qfc.j.a();

    final class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                qfc.j.this.aa = new qfc.k.a.C0077a(iBinder);
                android.util.Log.d("TGPA_MID", "MSA HW oaid: " + qfc.j.this.aa.h());
                if (qfc.j.this.V != null) {
                    qfc.j.this.V.f(qfc.j.this.aa.h());
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                android.util.Log.d("TGPA_MID", "MSA HW oaid get exception. ");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            android.util.Log.d("TGPA_MID", "Huawei MSA onServiceDisconnected ");
        }
    }

    public j(android.content.Context context, qfc.n nVar) {
        this.U = context;
        this.V = nVar;
    }
}
