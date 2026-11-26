package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface r extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements qfc.r {

        /* JADX INFO: renamed from: qfc.r$a$a, reason: collision with other inner class name */
        public static class C0079a implements qfc.r {
            public android.os.IBinder Z;

            public C0079a(android.os.IBinder iBinder) {
                this.Z = iBinder;
            }

            @Override // qfc.r
            public final java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                java.lang.String string = "com.heytap.openid.IOpenID";
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.Z.transact(1, parcelObtain, parcelObtain2, 0);
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
                    }
                }
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.Z;
            }
        }

        public static qfc.r c(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof qfc.r)) ? new qfc.r.a.C0079a(iBinder) : (qfc.r) iInterfaceQueryLocalInterface;
        }
    }

    java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3);
}
