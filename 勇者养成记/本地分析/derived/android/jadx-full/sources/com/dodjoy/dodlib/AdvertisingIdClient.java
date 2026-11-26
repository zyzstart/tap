package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AdvertisingIdClient {

    private static final class AdvertisingConnection implements android.content.ServiceConnection {
        private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> queue;
        boolean retrieved;

        private AdvertisingConnection() {
            this.retrieved = false;
            this.queue = new java.util.concurrent.LinkedBlockingQueue<>(1);
        }

        public android.os.IBinder getBinder() throws java.lang.InterruptedException {
            if (this.retrieved) {
                throw new java.lang.IllegalStateException();
            }
            this.retrieved = true;
            return this.queue.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.queue.put(iBinder);
            } catch (java.lang.InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    private static final class AdvertisingInterface implements android.os.IInterface {
        private android.os.IBinder binder;

        public AdvertisingInterface(android.os.IBinder iBinder) {
            this.binder = iBinder;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.binder;
        }

        public java.lang.String getId() throws android.os.RemoteException {
            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
            android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("[REDACTED]");
                this.binder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean isLimitAdTrackingEnabled(boolean z) throws android.os.RemoteException {
            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
            android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("[REDACTED]");
                parcelObtain.writeInt(z ? 1 : 0);
                this.binder.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public static java.lang.String getGoogleAdId(android.content.Context context) throws java.lang.Exception {
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            return "Cannot call in the main thread, You must call in the other thread";
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        com.dodjoy.dodlib.AdvertisingIdClient.AdvertisingConnection advertisingConnection = new com.dodjoy.dodlib.AdvertisingIdClient.AdvertisingConnection();
        android.content.Intent intent = new android.content.Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, advertisingConnection, 1)) {
            return "";
        }
        try {
            return new com.dodjoy.dodlib.AdvertisingIdClient.AdvertisingInterface(advertisingConnection.getBinder()).getId();
        } finally {
            context.unbindService(advertisingConnection);
        }
    }
}
