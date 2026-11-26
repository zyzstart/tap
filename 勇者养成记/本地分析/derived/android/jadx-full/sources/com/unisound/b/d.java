package com.unisound.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.b.b f1452a;
    private int b;

    public d(com.unisound.b.b bVar, int i) {
        this.f1452a = bVar;
        this.b = 0;
        this.b = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws java.lang.Throwable {
        com.unisound.b.i.d("ActivatorInterface HttpThreadSn start jsonStr= " + com.unisound.b.b.z);
        this.f1452a.y();
        com.unisound.b.b bVar = this.f1452a;
        bVar.n(com.unisound.a.a.a(bVar.A, this.f1452a.f));
        com.unisound.b.i.c("ActivatorInterface$HttpThreadSn init over");
        com.unisound.b.j.b(this.f1452a.A);
        if (com.unisound.b.j.a()) {
            try {
                java.lang.String str = "";
                java.util.Map mapB = null;
                if (this.b == 0) {
                    str = this.f1452a.f1450a;
                    mapB = this.f1452a.A();
                } else if (this.b == 1) {
                    str = this.f1452a.b;
                    mapB = this.f1452a.B();
                }
                com.unisound.b.i.d("ActivatorInterface", "url = " + str);
                com.unisound.b.l lVarA = com.unisound.b.f.a(str, (java.util.Map<java.lang.String, java.lang.String>) mapB, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
                java.lang.String strA = lVarA.a();
                if (lVarA.b() != 0) {
                    this.f1452a.a(lVarA.b() - lVarA.d());
                }
                com.unisound.b.i.d("result = " + strA);
                if (strA.equals("") || strA.equals("{}")) {
                    this.f1452a.B.sendEmptyMessage(106);
                    com.unisound.b.i.d("activate HttpResponse result is null");
                } else {
                    android.os.Message message = new android.os.Message();
                    message.obj = strA;
                    message.what = 102;
                    this.f1452a.B.sendMessage(message);
                }
            } catch (java.lang.Exception e) {
                this.f1452a.D = com.unisound.b.c.FINISH;
                e.printStackTrace();
                this.f1452a.B.sendEmptyMessage(107);
                com.unisound.b.i.a("activate Exception exception :" + e.getMessage());
                return;
            }
        } else {
            this.f1452a.B.sendEmptyMessage(109);
            com.unisound.b.i.a("activate No Network");
        }
        this.f1452a.D = com.unisound.b.c.FINISH;
    }
}
