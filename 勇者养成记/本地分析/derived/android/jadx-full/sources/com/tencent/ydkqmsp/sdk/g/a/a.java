package com.tencent.ydkqmsp.sdk.g.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface a extends android.os.IInterface {

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0052a extends android.os.Binder implements com.tencent.ydkqmsp.sdk.g.a.a {

        /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.a.a$a$a, reason: collision with other inner class name */
        public static class C0053a implements com.tencent.ydkqmsp.sdk.g.a.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public android.os.IBinder f1350a;

            public C0053a(android.os.IBinder iBinder) {
                this.f1350a = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f1350a;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.a.a
            public java.lang.String c() {
                java.lang.String string = "";
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1350a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (java.lang.Throwable unused) {
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.a.a
            public boolean g() {
                boolean z;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1350a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    z = parcelObtain2.readInt() != 0;
                } catch (java.lang.Exception unused) {
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
                return z;
            }

            @Override // com.tencent.ydkqmsp.sdk.g.a.a
            public java.lang.String h() {
                java.lang.String string = "";
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    this.f1350a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (java.lang.Throwable unused) {
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            }
        }

        public static com.tencent.ydkqmsp.sdk.g.a.a a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.ydkqmsp.sdk.g.a.a)) ? new com.tencent.ydkqmsp.sdk.g.a.a.AbstractBinderC0052a.C0053a(iBinder) : (com.tencent.ydkqmsp.sdk.g.a.a) iInterfaceQueryLocalInterface;
        }
    }

    java.lang.String c();

    boolean g();

    java.lang.String h();
}
