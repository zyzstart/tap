package com.asus.msa.sdid;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class SupplementaryDIDManager {

    @android.support.annotation.Keep
    public static boolean DEBUG = false;

    @android.support.annotation.Keep
    public static final java.lang.String TAG = "SupplementaryDIDManager";

    @android.support.annotation.Keep
    public android.content.Context mContext;

    @android.support.annotation.Keep
    public com.asus.msa.SupplementaryDID.IDidAidlInterface mDidService;

    @android.support.annotation.Keep
    public com.asus.msa.sdid.IDIDBinderStatusListener mListener;

    @android.support.annotation.Keep
    public boolean isBinded = false;

    @android.support.annotation.Keep
    public android.content.ServiceConnection mServiceConnection = new android.content.ServiceConnection() { // from class: com.asus.msa.sdid.SupplementaryDIDManager.1
        @Override // android.content.ServiceConnection
        @android.support.annotation.Keep
        public native void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        @Override // android.content.ServiceConnection
        @android.support.annotation.Keep
        public native void onServiceDisconnected(android.content.ComponentName componentName);
    };

    @android.support.annotation.Keep
    public SupplementaryDIDManager(android.content.Context context) {
        this.mContext = context;
    }

    @android.support.annotation.Keep
    public static native /* synthetic */ boolean access$000();

    @android.support.annotation.Keep
    public static native /* synthetic */ com.asus.msa.SupplementaryDID.IDidAidlInterface access$102(com.asus.msa.sdid.SupplementaryDIDManager supplementaryDIDManager, com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface);

    @android.support.annotation.Keep
    public static native /* synthetic */ void access$200(com.asus.msa.sdid.SupplementaryDIDManager supplementaryDIDManager, boolean z);

    @android.support.annotation.Keep
    private native void notifyAllListeners(boolean z);

    @android.support.annotation.Keep
    public native void deInit();

    @android.support.annotation.Keep
    public native void init(com.asus.msa.sdid.IDIDBinderStatusListener iDIDBinderStatusListener);

    @android.support.annotation.Keep
    public native void showLog(boolean z);
}
