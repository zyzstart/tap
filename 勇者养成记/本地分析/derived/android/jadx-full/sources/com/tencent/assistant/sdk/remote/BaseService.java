package com.tencent.assistant.sdk.remote;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface BaseService extends android.os.IInterface {

    public abstract class Stub extends android.os.Binder implements com.tencent.assistant.sdk.remote.BaseService {
        protected static final java.lang.String DESCRIPTOR = "com.tencent.assistant.sdk.remote.BaseService";

        class Proxy implements com.tencent.assistant.sdk.remote.BaseService {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.tencent.assistant.sdk.remote.BaseService.Stub.DESCRIPTOR;
            }

            @Override // com.tencent.assistant.sdk.remote.BaseService
            public int registerActionCallback(java.lang.String str, java.lang.String str2, com.tencent.assistant.sdk.remote.SDKActionCallback sDKActionCallback) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.tencent.assistant.sdk.remote.BaseService.Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(sDKActionCallback != null ? sDKActionCallback.asBinder() : null);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tencent.assistant.sdk.remote.BaseService
            public void sendAsyncData(java.lang.String str, byte[] bArr) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.tencent.assistant.sdk.remote.BaseService.Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeByteArray(bArr);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tencent.assistant.sdk.remote.BaseService
            public byte[] sendSyncData(java.lang.String str, byte[] bArr) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.tencent.assistant.sdk.remote.BaseService.Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeByteArray(bArr);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createByteArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tencent.assistant.sdk.remote.BaseService
            public int unregisterActionCallback(com.tencent.assistant.sdk.remote.SDKActionCallback sDKActionCallback) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.tencent.assistant.sdk.remote.BaseService.Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(sDKActionCallback != null ? sDKActionCallback.asBinder() : null);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.tencent.assistant.sdk.remote.BaseService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.assistant.sdk.remote.BaseService)) ? new com.tencent.assistant.sdk.remote.BaseService.Stub.Proxy(iBinder) : (com.tencent.assistant.sdk.remote.BaseService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iRegisterActionCallback = registerActionCallback(parcel.readString(), parcel.readString(), com.tencent.assistant.sdk.remote.SDKActionCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRegisterActionCallback);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iUnregisterActionCallback = unregisterActionCallback(com.tencent.assistant.sdk.remote.SDKActionCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iUnregisterActionCallback);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    byte[] bArrSendSyncData = sendSyncData(parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(bArrSendSyncData);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendAsyncData(parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int registerActionCallback(java.lang.String str, java.lang.String str2, com.tencent.assistant.sdk.remote.SDKActionCallback sDKActionCallback);

    void sendAsyncData(java.lang.String str, byte[] bArr);

    byte[] sendSyncData(java.lang.String str, byte[] bArr);

    int unregisterActionCallback(com.tencent.assistant.sdk.remote.SDKActionCallback sDKActionCallback);
}
