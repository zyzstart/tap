package com.zui.deviceidservice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public interface IDeviceidInterface extends android.os.IInterface {

    @android.support.annotation.Keep
    public static abstract class Stub extends android.os.Binder implements com.zui.deviceidservice.IDeviceidInterface {

        @android.support.annotation.Keep
        private static class Proxy implements com.zui.deviceidservice.IDeviceidInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @android.support.annotation.Keep
            private android.os.IBinder f1652a;

            @android.support.annotation.Keep
            Proxy(android.os.IBinder iBinder) {
                this.f1652a = iBinder;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @android.support.annotation.Keep
            public native boolean a();

            @Override // android.os.IInterface
            @android.support.annotation.Keep
            public native android.os.IBinder asBinder();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @android.support.annotation.Keep
            public native java.lang.String getAAID(java.lang.String str);

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @android.support.annotation.Keep
            public native java.lang.String getOAID();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @android.support.annotation.Keep
            public native java.lang.String getUDID();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @android.support.annotation.Keep
            public native java.lang.String getVAID(java.lang.String str);
        }

        @android.support.annotation.Keep
        public Stub() {
            attachInterface(this, "com.zui.deviceidservice.IDeviceidInterface");
        }

        @android.support.annotation.Keep
        public static native com.zui.deviceidservice.IDeviceidInterface a(android.os.IBinder iBinder);

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
    java.lang.String getAAID(java.lang.String str);

    @android.support.annotation.Keep
    java.lang.String getOAID();

    @android.support.annotation.Keep
    java.lang.String getUDID();

    @android.support.annotation.Keep
    java.lang.String getVAID(java.lang.String str);
}
