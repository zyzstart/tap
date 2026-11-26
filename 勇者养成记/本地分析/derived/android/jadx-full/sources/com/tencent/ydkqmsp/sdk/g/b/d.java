package com.tencent.ydkqmsp.sdk.g.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface d extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.tencent.ydkqmsp.sdk.g.b.d {

        /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.b.d$a$a, reason: collision with other inner class name */
        private static class C0055a implements com.tencent.ydkqmsp.sdk.g.b.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private android.os.IBinder f1358a;

            C0055a(android.os.IBinder iBinder) {
                this.f1358a = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f1358a;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.b.d
            public boolean f() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1358a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tencent.ydkqmsp.sdk.g.b.d
            public java.lang.String i() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1358a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.tencent.ydkqmsp.sdk.g.b.d a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.ydkqmsp.sdk.g.b.d)) ? new com.tencent.ydkqmsp.sdk.g.b.d.a.C0055a(iBinder) : (com.tencent.ydkqmsp.sdk.g.b.d) iInterfaceQueryLocalInterface;
        }
    }

    boolean f();

    java.lang.String i();
}
