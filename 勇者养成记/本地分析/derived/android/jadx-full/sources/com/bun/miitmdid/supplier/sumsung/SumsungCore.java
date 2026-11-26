package com.bun.miitmdid.supplier.sumsung;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class SumsungCore {

    @android.support.annotation.Keep
    private static boolean DBG = false;

    @android.support.annotation.Keep
    private static java.lang.String SAMSUNGTAG = "Samsung_DeviceIdService";

    @android.support.annotation.Keep
    private static java.lang.String TAG = "SumsungCore library";

    @android.support.annotation.Keep
    private com.bun.miitmdid.c.e.a mCallerCallBack;

    @android.support.annotation.Keep
    private android.content.ServiceConnection mConnection;

    @android.support.annotation.Keep
    private android.content.Context mContext;

    @android.support.annotation.Keep
    private com.samsung.android.deviceidservice.IDeviceIdService mDeviceidInterface;

    @android.support.annotation.Keep
    class a implements android.content.ServiceConnection {
        @android.support.annotation.Keep
        a() {
        }

        @Override // android.content.ServiceConnection
        @android.support.annotation.Keep
        public native synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        @Override // android.content.ServiceConnection
        @android.support.annotation.Keep
        public native void onServiceDisconnected(android.content.ComponentName componentName);
    }

    @android.support.annotation.Keep
    public SumsungCore(android.content.Context context, com.bun.miitmdid.c.e.a aVar) {
        this.mContext = null;
        this.mCallerCallBack = null;
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this.mCallerCallBack = aVar;
        this.mConnection = new com.bun.miitmdid.supplier.sumsung.SumsungCore.a();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.mContext.bindService(intent, this.mConnection, 1)) {
            com.bun.lib.a.b(TAG, "bindService Successful!");
            return;
        }
        this.mContext.unbindService(this.mConnection);
        com.bun.lib.a.b(TAG, "bindService Failed!");
        com.bun.miitmdid.c.e.a aVar2 = this.mCallerCallBack;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @android.support.annotation.Keep
    static native /* synthetic */ com.samsung.android.deviceidservice.IDeviceIdService access$002(com.bun.miitmdid.supplier.sumsung.SumsungCore sumsungCore, com.samsung.android.deviceidservice.IDeviceIdService iDeviceIdService);

    @android.support.annotation.Keep
    static native /* synthetic */ com.bun.miitmdid.c.e.a access$100(com.bun.miitmdid.supplier.sumsung.SumsungCore sumsungCore);

    @android.support.annotation.Keep
    static native /* synthetic */ java.lang.String access$200();

    @android.support.annotation.Keep
    public native java.lang.String getAAID();

    @android.support.annotation.Keep
    public native java.lang.String getOAID();

    @android.support.annotation.Keep
    public native java.lang.String getUDID();

    @android.support.annotation.Keep
    public native java.lang.String getVAID();

    @android.support.annotation.Keep
    public native boolean isSupported();

    @android.support.annotation.Keep
    public native void shutdown();
}
