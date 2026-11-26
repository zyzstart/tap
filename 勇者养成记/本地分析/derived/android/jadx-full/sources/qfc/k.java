package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface k extends android.os.IInterface {

    public static abstract class a {

        /* JADX INFO: renamed from: qfc.k$a$a, reason: collision with other inner class name */
        public static final class C0077a implements qfc.k {
            private android.os.IBinder Z;

            public C0077a(android.os.IBinder iBinder) {
                this.Z = iBinder;
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.Z;
            }

            @Override // qfc.k
            public final java.lang.String h() {
                java.lang.String string = "";
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
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
        }
    }

    java.lang.String h();
}
