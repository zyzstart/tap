package com.asus.msa.SupplementaryDID;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public interface IDidAidlInterface extends android.os.IInterface {

    @android.support.annotation.Keep
    public static abstract class Stub extends android.os.Binder implements com.asus.msa.SupplementaryDID.IDidAidlInterface {

        @android.support.annotation.Keep
        public static class Proxy implements com.asus.msa.SupplementaryDID.IDidAidlInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @android.support.annotation.Keep
            public android.os.IBinder f10a;

            @android.support.annotation.Keep
            public Proxy(android.os.IBinder iBinder) {
                this.f10a = iBinder;
            }

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            @android.support.annotation.Keep
            public native boolean a();

            @Override // android.os.IInterface
            @android.support.annotation.Keep
            public native android.os.IBinder asBinder();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            @android.support.annotation.Keep
            public native java.lang.String getAAID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            @android.support.annotation.Keep
            public native java.lang.String getOAID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            @android.support.annotation.Keep
            public native java.lang.String getUDID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            @android.support.annotation.Keep
            public native java.lang.String getVAID();
        }

        @android.support.annotation.Keep
        public Stub() {
            attachInterface(this, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
        }

        @android.support.annotation.Keep
        public static native com.asus.msa.SupplementaryDID.IDidAidlInterface a(android.os.IBinder iBinder);

        @Override // android.os.IInterface
        @android.support.annotation.Keep
        public native android.os.IBinder asBinder();

        @Override // android.os.Binder
        @android.support.annotation.Keep
        public native boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2);
    }

    @android.support.annotation.Keep
    boolean a();

    @android.support.annotation.Keep
    java.lang.String getAAID();

    @android.support.annotation.Keep
    java.lang.String getOAID();

    @android.support.annotation.Keep
    java.lang.String getUDID();

    @android.support.annotation.Keep
    java.lang.String getVAID();
}
