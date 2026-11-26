package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface D extends android.os.IInterface {

    public static abstract class a extends android.os.Binder {
        public static final java.lang.String i = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.v);

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.D$a$a, reason: collision with other inner class name */
        static class C0039a implements com.tencent.turingfd.sdk.ams.ad.D {
            public android.os.IBinder na;

            public C0039a(android.os.IBinder iBinder) {
                this.na = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.na;
            }
        }

        public static com.tencent.turingfd.sdk.ams.ad.D a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(i);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.turingfd.sdk.ams.ad.D)) ? new com.tencent.turingfd.sdk.ams.ad.D.a.C0039a(iBinder) : (com.tencent.turingfd.sdk.ams.ad.D) iInterfaceQueryLocalInterface;
        }
    }
}
