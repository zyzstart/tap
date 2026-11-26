package com.tencent.tmassistantbase.aidl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class b extends android.os.Binder implements com.tencent.tmassistantbase.aidl.a {
    public b() {
        attachInterface(this, "com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceCallback");
    }

    public static com.tencent.tmassistantbase.aidl.a a(android.os.IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceCallback");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.tmassistantbase.aidl.a)) ? new com.tencent.tmassistantbase.aidl.c(iBinder) : (com.tencent.tmassistantbase.aidl.a) iInterfaceQueryLocalInterface;
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceCallback");
            a(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
        if (i != 2) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceCallback");
            return true;
        }
        parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceCallback");
        a(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong());
        parcel2.writeNoException();
        return true;
    }
}
