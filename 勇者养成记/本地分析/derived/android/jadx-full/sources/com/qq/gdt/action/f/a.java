package com.qq.gdt.action.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.qq.gdt.action.f.a f110a;
    private final com.qq.gdt.action.f.b b;

    private a() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("recorder");
        handlerThread.start();
        this.b = new com.qq.gdt.action.f.b(handlerThread.getLooper());
    }

    public static com.qq.gdt.action.f.a a() {
        if (f110a == null) {
            synchronized (com.qq.gdt.action.f.a.class) {
                if (f110a == null) {
                    f110a = new com.qq.gdt.action.f.a();
                }
            }
        }
        return f110a;
    }

    public void a(int i, org.json.JSONObject jSONObject) {
        if (com.qq.gdt.action.f.c.a(i, jSONObject)) {
            android.os.Message messageObtainMessage = this.b.obtainMessage(3);
            messageObtainMessage.obj = new com.qq.gdt.action.f.a.b(i, jSONObject);
            this.b.sendMessage(messageObtainMessage);
        }
    }

    public void a(com.qq.gdt.action.a.a aVar) {
        if (com.qq.gdt.action.f.c.a(aVar)) {
            android.os.Message messageObtainMessage = this.b.obtainMessage(2);
            messageObtainMessage.obj = new com.qq.gdt.action.f.a.a(aVar.f(), aVar.a(), aVar.b());
            this.b.sendMessage(messageObtainMessage);
        }
    }

    void b() {
        this.b.sendEmptyMessage(4);
    }

    void c() {
        this.b.sendEmptyMessage(5);
    }
}
