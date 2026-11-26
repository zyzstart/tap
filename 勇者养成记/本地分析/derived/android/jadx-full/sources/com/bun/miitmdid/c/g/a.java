package com.bun.miitmdid.c.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class a {

    @android.support.annotation.Keep
    private static java.lang.String e = "OpenDeviceId library";

    @android.support.annotation.Keep
    private static boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    private android.content.Context f30a;

    @android.support.annotation.Keep
    private com.zui.deviceidservice.IDeviceidInterface b;

    @android.support.annotation.Keep
    private android.content.ServiceConnection c;

    @android.support.annotation.Keep
    private com.bun.miitmdid.c.e.a d;

    /* JADX INFO: renamed from: com.bun.miitmdid.c.g.a$a, reason: collision with other inner class name */
    @android.support.annotation.Keep
    class ServiceConnectionC0006a implements android.content.ServiceConnection {
        @android.support.annotation.Keep
        ServiceConnectionC0006a() {
        }

        @Override // android.content.ServiceConnection
        @android.support.annotation.Keep
        public native synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        @Override // android.content.ServiceConnection
        @android.support.annotation.Keep
        public native void onServiceDisconnected(android.content.ComponentName componentName);
    }

    @android.support.annotation.Keep
    public a(android.content.Context context, com.bun.miitmdid.c.e.a aVar) {
        this.f30a = null;
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.f30a = context;
        this.d = aVar;
        this.c = new com.bun.miitmdid.c.g.a.ServiceConnectionC0006a();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f30a.bindService(intent, this.c, 1)) {
            b("bindService Successful!");
            return;
        }
        b("bindService Failed!");
        com.bun.miitmdid.c.e.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @android.support.annotation.Keep
    static native /* synthetic */ com.bun.miitmdid.c.e.a a(com.bun.miitmdid.c.g.a aVar);

    @android.support.annotation.Keep
    static native /* synthetic */ com.zui.deviceidservice.IDeviceidInterface a(com.bun.miitmdid.c.g.a aVar, com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface);

    @android.support.annotation.Keep
    static native /* synthetic */ void a(com.bun.miitmdid.c.g.a aVar, java.lang.String str);

    @android.support.annotation.Keep
    private native void a(java.lang.String str);

    @android.support.annotation.Keep
    private native void b(java.lang.String str);

    @android.support.annotation.Keep
    public native java.lang.String a();

    @android.support.annotation.Keep
    public native java.lang.String b();

    @android.support.annotation.Keep
    public native java.lang.String c();

    @android.support.annotation.Keep
    public native java.lang.String d();

    @android.support.annotation.Keep
    public native boolean e();

    @android.support.annotation.Keep
    public native void f();
}
