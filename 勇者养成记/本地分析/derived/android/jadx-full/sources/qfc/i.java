package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface i extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements qfc.i {

        /* JADX INFO: renamed from: qfc.i$a$a, reason: collision with other inner class name */
        public static class C0076a implements qfc.i {
            public android.os.IBinder Z;

            public C0076a(android.os.IBinder iBinder) {
                this.Z = iBinder;
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.Z;
            }

            @Override // qfc.i
            public final boolean c() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.Z.transact(1, parcelObtain, parcelObtain2, 0);
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
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return false;
                    }
                }
            }

            @Override // qfc.i
            public final java.lang.String d() {
                java.lang.String string;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.Z.transact(2, parcelObtain, parcelObtain2, 0);
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

            @Override // qfc.i
            public final java.lang.String e() {
                java.lang.String string;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.Z.transact(3, parcelObtain, parcelObtain2, 0);
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

            @Override // qfc.i
            public final java.lang.String f() {
                java.lang.String string;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.Z.transact(4, parcelObtain, parcelObtain2, 0);
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

            @Override // qfc.i
            public final java.lang.String g() {
                java.lang.String string;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.Z.transact(5, parcelObtain, parcelObtain2, 0);
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
        }

        public static qfc.i a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof qfc.i)) ? new qfc.i.a.C0076a(iBinder) : (qfc.i) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        boolean zC = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(zC ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        java.lang.String strD = d();
                        parcel2.writeNoException();
                        parcel2.writeString(strD);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        java.lang.String strE = e();
                        parcel2.writeNoException();
                        parcel2.writeString(strE);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        java.lang.String strF = f();
                        parcel2.writeNoException();
                        parcel2.writeString(strF);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        java.lang.String strG = g();
                        parcel2.writeNoException();
                        parcel2.writeString(strG);
                        return true;
                    default:
                        try {
                            return super.onTransact(i, parcel, parcel2, i2);
                        } catch (android.os.RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            } else {
                parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            }
            return true;
        }
    }

    boolean c();

    java.lang.String d();

    java.lang.String e();

    java.lang.String f();

    java.lang.String g();
}
