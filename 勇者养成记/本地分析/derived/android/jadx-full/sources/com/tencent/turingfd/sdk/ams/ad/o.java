package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class o implements com.tencent.turingfd.sdk.ams.ad.InterfaceC0094j {
    public android.os.IBinder na;

    public o(android.os.IBinder iBinder) {
        this.na = iBinder;
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this.na;
    }

    public android.os.IBinder c(java.lang.String str) throws android.os.RemoteException {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        parcelObtain.writeInterfaceToken("[REDACTED]");
        parcelObtain.writeString(str);
        this.na.transact(1, parcelObtain, parcelObtain2, 0);
        android.os.IBinder strongBinder = parcelObtain2.readStrongBinder();
        parcelObtain2.recycle();
        parcelObtain.recycle();
        return strongBinder;
    }
}
