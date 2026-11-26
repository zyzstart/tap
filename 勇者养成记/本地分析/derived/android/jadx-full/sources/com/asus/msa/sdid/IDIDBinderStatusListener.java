package com.asus.msa.sdid;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public interface IDIDBinderStatusListener extends android.os.IInterface {

    @android.support.annotation.Keep
    public static abstract class Stub extends android.os.Binder implements com.asus.msa.sdid.IDIDBinderStatusListener {

        @android.support.annotation.Keep
        public static class Proxy implements com.asus.msa.sdid.IDIDBinderStatusListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @android.support.annotation.Keep
            public android.os.IBinder f11a;

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            @android.support.annotation.Keep
            public native void a(com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface);

            @Override // android.os.IInterface
            @android.support.annotation.Keep
            public native android.os.IBinder asBinder();

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            @android.support.annotation.Keep
            public native void b();
        }

        @android.support.annotation.Keep
        public Stub() {
            attachInterface(this, "com.asus.msa.sdid.IDIDBinderStatusListener");
        }

        @Override // android.os.IInterface
        @android.support.annotation.Keep
        public native android.os.IBinder asBinder();

        @Override // android.os.Binder
        @android.support.annotation.Keep
        public native boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2);
    }

    @android.support.annotation.Keep
    void a(com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface);

    @android.support.annotation.Keep
    void b();
}
