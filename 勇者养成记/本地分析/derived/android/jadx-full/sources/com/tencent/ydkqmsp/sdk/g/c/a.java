package com.tencent.ydkqmsp.sdk.g.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface a extends android.os.IInterface {

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0056a extends android.os.Binder implements com.tencent.ydkqmsp.sdk.g.c.a {

        /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.c.a$a$a, reason: collision with other inner class name */
        private static class C0057a implements com.tencent.ydkqmsp.sdk.g.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private android.os.IBinder f1359a;

            C0057a(android.os.IBinder iBinder) {
                this.f1359a = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f1359a;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.c.a
            public java.lang.String b(java.lang.String str) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    parcelObtain.writeString(str);
                    this.f1359a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (android.os.RemoteException unused) {
                    return null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tencent.ydkqmsp.sdk.g.c.a
            public boolean c() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                boolean z = false;
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1359a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        z = true;
                    }
                } catch (android.os.RemoteException unused) {
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
                return z;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.c.a
            public java.lang.String g() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1359a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (android.os.RemoteException unused) {
                    return null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.tencent.ydkqmsp.sdk.g.c.a a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.ydkqmsp.sdk.g.c.a)) ? new com.tencent.ydkqmsp.sdk.g.c.a.AbstractBinderC0056a.C0057a(iBinder) : (com.tencent.ydkqmsp.sdk.g.c.a) iInterfaceQueryLocalInterface;
        }
    }

    java.lang.String b(java.lang.String str);

    boolean c();

    java.lang.String g();
}
