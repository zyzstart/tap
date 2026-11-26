package com.tencent.assistant.sdk.remote;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface SDKActionCallback extends android.os.IInterface {

    public abstract class Stub extends android.os.Binder implements com.tencent.assistant.sdk.remote.SDKActionCallback {
        protected static final java.lang.String DESCRIPTOR = "com.tencent.assistant.sdk.remote.SDKActionCallback";

        class Proxy implements com.tencent.assistant.sdk.remote.SDKActionCallback {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.tencent.assistant.sdk.remote.SDKActionCallback.Stub.DESCRIPTOR;
            }

            @Override // com.tencent.assistant.sdk.remote.SDKActionCallback
            public void onActionResult(byte[] bArr) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.tencent.assistant.sdk.remote.SDKActionCallback.Stub.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.tencent.assistant.sdk.remote.SDKActionCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.assistant.sdk.remote.SDKActionCallback)) ? new com.tencent.assistant.sdk.remote.SDKActionCallback.Stub.Proxy(iBinder) : (com.tencent.assistant.sdk.remote.SDKActionCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onActionResult(parcel.createByteArray());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onActionResult(byte[] bArr);
}
