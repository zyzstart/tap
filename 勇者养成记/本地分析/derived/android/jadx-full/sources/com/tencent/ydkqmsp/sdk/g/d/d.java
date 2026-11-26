package com.tencent.ydkqmsp.sdk.g.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d extends android.os.AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tencent.ydkqmsp.sdk.g.d.a f1366a;
    public com.tencent.ydkqmsp.sdk.g.d.c b;

    public d(com.tencent.ydkqmsp.sdk.g.d.a aVar, com.tencent.ydkqmsp.sdk.g.d.c cVar) {
        this.f1366a = aVar;
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Boolean doInBackground(java.lang.Void... voidArr) {
        boolean zC;
        com.tencent.ydkqmsp.sdk.g.d.c cVar;
        if (this.f1366a == null) {
            return java.lang.Boolean.FALSE;
        }
        int i = 0;
        while (true) {
            try {
                zC = this.f1366a.c();
                if (zC) {
                    break;
                }
                java.lang.Thread.sleep(10L);
                i++;
                if (i >= 30) {
                    break;
                }
            } catch (java.lang.InterruptedException unused) {
            }
        }
        if (zC && (cVar = this.b) != null) {
            cVar.a(true);
        }
        return java.lang.Boolean.valueOf(zC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(java.lang.Boolean bool) {
        super.onPostExecute(bool);
    }
}
