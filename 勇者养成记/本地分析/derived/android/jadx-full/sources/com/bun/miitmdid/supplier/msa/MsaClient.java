package com.bun.miitmdid.supplier.msa;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class MsaClient {

    @android.support.annotation.Keep
    private static java.lang.String TAG = "MSA Client library";

    @android.support.annotation.Keep
    private static java.lang.String TARGET_PACKAGE = "com.mdid.msa";

    @android.support.annotation.Keep
    private com.bun.miitmdid.c.e.a _BindService;

    @android.support.annotation.Keep
    private android.content.ServiceConnection mConnection;

    @android.support.annotation.Keep
    private android.content.Context mContext;

    @android.support.annotation.Keep
    private com.bun.lib.c mDeviceidInterface;

    @android.support.annotation.Keep
    class a implements android.content.ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @android.support.annotation.Keep
        final /* synthetic */ com.bun.miitmdid.c.e.a f47a;

        @android.support.annotation.Keep
        a(com.bun.miitmdid.c.e.a aVar) {
            this.f47a = aVar;
        }

        @Override // android.content.ServiceConnection
        @android.support.annotation.Keep
        public native synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        @Override // android.content.ServiceConnection
        @android.support.annotation.Keep
        public native void onServiceDisconnected(android.content.ComponentName componentName);
    }

    @android.support.annotation.Keep
    public MsaClient(android.content.Context context, com.bun.miitmdid.c.e.a aVar) {
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this._BindService = aVar;
        this.mConnection = new com.bun.miitmdid.supplier.msa.MsaClient.a(aVar);
    }

    @android.support.annotation.Keep
    public static native boolean CheckService(android.content.Context context);

    @android.support.annotation.Keep
    public static native void StartMsaKlService(android.content.Context context, java.lang.String str);

    @android.support.annotation.Keep
    static native /* synthetic */ com.bun.lib.c access$000(com.bun.miitmdid.supplier.msa.MsaClient msaClient);

    @android.support.annotation.Keep
    static native /* synthetic */ com.bun.lib.c access$002(com.bun.miitmdid.supplier.msa.MsaClient msaClient, com.bun.lib.c cVar);

    @android.support.annotation.Keep
    static native /* synthetic */ java.lang.String access$100();

    @android.support.annotation.Keep
    public native void BindService(java.lang.String str);

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
