package com.tencent.tmassistantbase.aidl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements com.tencent.tmassistantbase.aidl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.os.IBinder f1005a;

    c(android.os.IBinder iBinder) {
        this.f1005a = iBinder;
    }

    @Override // com.tencent.tmassistantbase.aidl.a
    public void a(java.lang.String str, java.lang.String str2, int i, int i2, java.lang.String str3) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeString(str3);
            this.f1005a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.a
    public void a(java.lang.String str, java.lang.String str2, long j, long j2) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeLong(j);
            parcelObtain.writeLong(j2);
            this.f1005a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this.f1005a;
    }
}
