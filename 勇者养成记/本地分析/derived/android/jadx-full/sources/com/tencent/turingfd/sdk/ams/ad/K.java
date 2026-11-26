package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface K extends android.os.IInterface {

    public static abstract class a extends android.os.Binder {
        public static final java.lang.String i = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.aa);

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.K$a$a, reason: collision with other inner class name */
        static class C0040a implements com.tencent.turingfd.sdk.ams.ad.K {
            public android.os.IBinder na;

            public C0040a(android.os.IBinder iBinder) {
                this.na = iBinder;
            }

            public java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.tencent.turingfd.sdk.ams.ad.K.a.i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.na.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.na;
            }
        }

        public static com.tencent.turingfd.sdk.ams.ad.K a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(i);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.turingfd.sdk.ams.ad.K)) ? new com.tencent.turingfd.sdk.ams.ad.K.a.C0040a(iBinder) : (com.tencent.turingfd.sdk.ams.ad.K) iInterfaceQueryLocalInterface;
        }
    }
}
