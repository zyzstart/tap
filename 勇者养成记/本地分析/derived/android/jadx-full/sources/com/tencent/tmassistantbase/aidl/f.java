package com.tencent.tmassistantbase.aidl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements com.tencent.tmassistantbase.aidl.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.os.IBinder f1006a;

    f(android.os.IBinder iBinder) {
        this.f1006a = iBinder;
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public int a() {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            this.f1006a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public int a(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4, java.util.Map map, android.os.Bundle bundle) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str3);
            parcelObtain.writeString(str4);
            parcelObtain.writeMap(map);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f1006a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo a(java.lang.String str, java.lang.String str2) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f1006a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0 ? (com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo) com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo.CREATOR.createFromParcel(parcelObtain2) : null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void a(int i) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeInt(i);
            this.f1006a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void a(java.lang.String str, com.tencent.tmassistantbase.aidl.a aVar) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            this.f1006a.transact(10, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void a(boolean z) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeInt(z ? 1 : 0);
            this.f1006a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this.f1006a;
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void b(java.lang.String str, com.tencent.tmassistantbase.aidl.a aVar) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            this.f1006a.transact(11, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void b(java.lang.String str, java.lang.String str2) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f1006a.transact(8, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void b(boolean z) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeInt(z ? 1 : 0);
            this.f1006a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public boolean b() {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            this.f1006a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void c(java.lang.String str, java.lang.String str2) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("[REDACTED]");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f1006a.transact(9, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
