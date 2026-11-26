package com.tencent.ydkqmsp.sdk.g.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface a extends android.os.IInterface {

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.h.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0061a extends android.os.Binder implements com.tencent.ydkqmsp.sdk.g.h.a {

        /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.h.a$a$a, reason: collision with other inner class name */
        private static class C0062a implements com.tencent.ydkqmsp.sdk.g.h.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private android.os.IBinder f1380a;

            C0062a(android.os.IBinder iBinder) {
                this.f1380a = iBinder;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.h.a
            public java.lang.String a() {
                java.lang.String string;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    try {
                        parcelObtain.writeInterfaceToken("[REDACTED]");
                        this.f1380a.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (android.os.RemoteException e) {
                        e.printStackTrace();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        string = null;
                    }
                    return string;
                } catch (java.lang.Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.tencent.ydkqmsp.sdk.g.h.a
            public java.lang.String a(java.lang.String str) {
                java.lang.String string;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    try {
                        parcelObtain.writeInterfaceToken("[REDACTED]");
                        parcelObtain.writeString(str);
                        this.f1380a.transact(3, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (android.os.RemoteException e) {
                        e.printStackTrace();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        string = null;
                    }
                    return string;
                } catch (java.lang.Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f1380a;
            }
        }

        public static com.tencent.ydkqmsp.sdk.g.h.a a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.ydkqmsp.sdk.g.h.a)) ? new com.tencent.ydkqmsp.sdk.g.h.a.AbstractBinderC0061a.C0062a(iBinder) : (com.tencent.ydkqmsp.sdk.g.h.a) iInterfaceQueryLocalInterface;
        }
    }

    java.lang.String a();

    java.lang.String a(java.lang.String str);
}
