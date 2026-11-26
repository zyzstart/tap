package com.tencent.ydkqmsp.sdk.g.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface d extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.tencent.ydkqmsp.sdk.g.g.d {

        /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.g.d$a$a, reason: collision with other inner class name */
        public static class C0060a implements com.tencent.ydkqmsp.sdk.g.g.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public android.os.IBinder f1377a;

            public C0060a(android.os.IBinder iBinder) {
                this.f1377a = iBinder;
            }

            public java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                java.lang.String string = "";
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("[REDACTED]");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f1377a.transact(1, parcelObtain, parcelObtain2, 0);
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
            public android.os.IBinder asBinder() {
                return this.f1377a;
            }
        }

        public static com.tencent.ydkqmsp.sdk.g.g.d a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.ydkqmsp.sdk.g.g.d)) ? new com.tencent.ydkqmsp.sdk.g.g.d.a.C0060a(iBinder) : (com.tencent.ydkqmsp.sdk.g.g.d) iInterfaceQueryLocalInterface;
        }
    }
}
