package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface t extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements qfc.t {

        /* JADX INFO: renamed from: qfc.t$a$a, reason: collision with other inner class name */
        static class C0080a implements qfc.t {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private android.os.IBinder f1705a;

            C0080a(android.os.IBinder iBinder) {
                this.f1705a = iBinder;
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.f1705a;
            }

            @Override // qfc.t
            public final java.lang.String b(java.lang.String str) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    parcelObtain.writeString(str);
                    this.f1705a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                    return "";
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qfc.t
            public final java.lang.String c(java.lang.String str) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    parcelObtain.writeString(str);
                    this.f1705a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                    return "";
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qfc.t
            public final java.lang.String h() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1705a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                    return "";
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static qfc.t d(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof qfc.t)) ? new qfc.t.a.C0080a(iBinder) : (qfc.t) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            java.lang.String strH;
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                strH = h();
            } else {
                if (i != 2) {
                    if (i == 3) {
                        parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                        strH = c(parcel.readString());
                    } else {
                        if (i != 1598968902) {
                            try {
                                return super.onTransact(i, parcel, parcel2, i2);
                            } catch (android.os.RemoteException e) {
                                e.printStackTrace();
                                return false;
                            }
                        }
                        strH = "com.samsung.android.deviceidservice.IDeviceIdService";
                    }
                    parcel2.writeString(strH);
                    return true;
                }
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                strH = b(parcel.readString());
            }
            parcel2.writeNoException();
            parcel2.writeString(strH);
            return true;
        }
    }

    java.lang.String b(java.lang.String str);

    java.lang.String c(java.lang.String str);

    java.lang.String h();
}
