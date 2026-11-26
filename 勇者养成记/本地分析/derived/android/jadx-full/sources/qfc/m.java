package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface m extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements qfc.m {

        /* JADX INFO: renamed from: qfc.m$a$a, reason: collision with other inner class name */
        static class C0078a implements qfc.m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private android.os.IBinder f1701a;

            C0078a(android.os.IBinder iBinder) {
                this.f1701a = iBinder;
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.f1701a;
            }

            @Override // qfc.m
            public final java.lang.String b(java.lang.String str) {
                java.lang.String string;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    parcelObtain.writeString(str);
                    this.f1701a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (java.lang.Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    try {
                        throw th;
                    } catch (android.os.RemoteException e) {
                        e.printStackTrace();
                        string = null;
                    }
                }
            }

            @Override // qfc.m
            public final java.lang.String c(java.lang.String str) {
                java.lang.String string;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    parcelObtain.writeString(str);
                    this.f1701a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (java.lang.Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    try {
                        throw th;
                    } catch (android.os.RemoteException e) {
                        e.printStackTrace();
                        string = null;
                    }
                }
            }

            @Override // qfc.m
            public final java.lang.String d() {
                java.lang.String string;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1701a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (java.lang.Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    try {
                        throw th;
                    } catch (android.os.RemoteException e) {
                        e.printStackTrace();
                        string = null;
                    }
                }
            }

            @Override // qfc.m
            public final java.lang.String h() {
                java.lang.String string;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1701a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (java.lang.Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    try {
                        throw th;
                    } catch (android.os.RemoteException e) {
                        e.printStackTrace();
                        string = null;
                    }
                }
            }

            @Override // qfc.m
            public final boolean i() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1701a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() == 0) {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return false;
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return true;
                } catch (java.lang.Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    try {
                        throw th;
                    } catch (android.os.RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static qfc.m b(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof qfc.m)) ? new qfc.m.a.C0078a(iBinder) : (qfc.m) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            java.lang.String strH;
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        strH = h();
                        parcel2.writeNoException();
                        parcel2.writeString(strH);
                        break;
                    case 2:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        strH = d();
                        parcel2.writeNoException();
                        parcel2.writeString(strH);
                        break;
                    case 3:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        boolean zI = i();
                        parcel2.writeNoException();
                        parcel2.writeInt(zI ? 1 : 0);
                        break;
                    case 4:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        strH = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(strH);
                        break;
                    case 5:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        strH = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(strH);
                        break;
                    default:
                        try {
                            return super.onTransact(i, parcel, parcel2, i2);
                        } catch (android.os.RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            } else {
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
            }
            return true;
        }
    }

    java.lang.String b(java.lang.String str);

    java.lang.String c(java.lang.String str);

    java.lang.String d();

    java.lang.String h();

    boolean i();
}
