package com.tencent.tmassistantbase.aidl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class e extends android.os.Binder implements com.tencent.tmassistantbase.aidl.d {
    public e() {
        attachInterface(this, "com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
    }

    public static com.tencent.tmassistantbase.aidl.d a(android.os.IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.tmassistantbase.aidl.d)) ? new com.tencent.tmassistantbase.aidl.f(iBinder) : (com.tencent.tmassistantbase.aidl.d) iInterfaceQueryLocalInterface;
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
        if (i == 1598968902) {
            parcel2.writeString("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
            return true;
        }
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                int iA = a();
                parcel2.writeNoException();
                parcel2.writeInt(iA);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                a(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                b(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                boolean zB = b();
                parcel2.writeNoException();
                parcel2.writeInt(zB ? 1 : 0);
                return true;
            case 6:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfoA = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (tMAssistantDownloadTaskInfoA != null) {
                    parcel2.writeInt(1);
                    tMAssistantDownloadTaskInfoA.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 7:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                int iA2 = a(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(iA2);
                return true;
            case 8:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                b(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                c(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                a(parcel.readString(), com.tencent.tmassistantbase.aidl.b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.tencent.tmassistantbase.aidl.ITMAssistantDownloadSDKServiceInterface");
                b(parcel.readString(), com.tencent.tmassistantbase.aidl.b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
