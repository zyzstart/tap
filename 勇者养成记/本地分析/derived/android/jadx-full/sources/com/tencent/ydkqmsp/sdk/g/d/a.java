package com.tencent.ydkqmsp.sdk.g.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface a extends android.os.IInterface {

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.d.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0058a extends android.os.Binder implements com.tencent.ydkqmsp.sdk.g.d.a {

        /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.d.a$a$a, reason: collision with other inner class name */
        private static class C0059a implements com.tencent.ydkqmsp.sdk.g.d.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private android.os.IBinder f1363a;

            C0059a(android.os.IBinder iBinder) {
                this.f1363a = iBinder;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.d.a
            public java.lang.String a() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                java.lang.String string = "";
                try {
                    try {
                        parcelObtain.writeInterfaceToken("[REDACTED]");
                        this.f1363a.transact(3, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } catch (android.os.RemoteException e) {
                        e.printStackTrace();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f1363a;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.d.a
            public java.lang.String b() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                java.lang.String string = "";
                try {
                    try {
                        parcelObtain.writeInterfaceToken("[REDACTED]");
                        this.f1363a.transact(5, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } catch (android.os.RemoteException e) {
                        e.printStackTrace();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tencent.ydkqmsp.sdk.g.d.a
            public boolean c() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                boolean z = false;
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1363a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        z = true;
                    }
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
                return z;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.d.a
            public boolean d() {
                boolean z;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1363a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    z = parcelObtain2.readInt() != 0;
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
                return z;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.d.a
            public void e() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    try {
                        parcelObtain.writeInterfaceToken("[REDACTED]");
                        this.f1363a.transact(6, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                    } catch (android.os.RemoteException e) {
                        e.printStackTrace();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.tencent.ydkqmsp.sdk.g.d.a a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.ydkqmsp.sdk.g.d.a)) ? new com.tencent.ydkqmsp.sdk.g.d.a.AbstractBinderC0058a.C0059a(iBinder) : (com.tencent.ydkqmsp.sdk.g.d.a) iInterfaceQueryLocalInterface;
        }
    }

    java.lang.String a();

    java.lang.String b();

    boolean c();

    boolean d();

    void e();
}
