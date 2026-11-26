package com.heytap.openid;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public interface a extends android.os.IInterface {

    /* JADX INFO: renamed from: com.heytap.openid.a$a, reason: collision with other inner class name */
    @android.support.annotation.Keep
    public static abstract class AbstractBinderC0014a extends android.os.Binder implements com.heytap.openid.a {

        /* JADX INFO: renamed from: com.heytap.openid.a$a$a, reason: collision with other inner class name */
        @android.support.annotation.Keep
        private static class C0015a implements com.heytap.openid.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @android.support.annotation.Keep
            public android.os.IBinder f52a;

            @android.support.annotation.Keep
            public C0015a(android.os.IBinder iBinder) {
                this.f52a = iBinder;
            }

            @android.support.annotation.Keep
            public native java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3);

            @Override // android.os.IInterface
            @android.support.annotation.Keep
            public native android.os.IBinder asBinder();
        }

        @android.support.annotation.Keep
        public static native com.heytap.openid.a a(android.os.IBinder iBinder);
    }
}
