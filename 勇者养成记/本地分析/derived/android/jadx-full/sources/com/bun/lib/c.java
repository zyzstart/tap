package com.bun.lib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public interface c extends android.os.IInterface {

    @android.support.annotation.Keep
    public static abstract class a extends android.os.Binder implements com.bun.lib.c {

        /* JADX INFO: renamed from: com.bun.lib.c$a$a, reason: collision with other inner class name */
        @android.support.annotation.Keep
        private static class C0002a implements com.bun.lib.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @android.support.annotation.Keep
            private android.os.IBinder f15a;

            @android.support.annotation.Keep
            C0002a(android.os.IBinder iBinder) {
                this.f15a = iBinder;
            }

            @Override // android.os.IInterface
            @android.support.annotation.Keep
            public native android.os.IBinder asBinder();

            @Override // com.bun.lib.c
            @android.support.annotation.Keep
            public native boolean c();

            @Override // com.bun.lib.c
            @android.support.annotation.Keep
            public native java.lang.String getAAID();

            @Override // com.bun.lib.c
            @android.support.annotation.Keep
            public native java.lang.String getOAID();

            @Override // com.bun.lib.c
            @android.support.annotation.Keep
            public native java.lang.String getVAID();

            @Override // com.bun.lib.c
            @android.support.annotation.Keep
            public native boolean isSupported();

            @Override // com.bun.lib.c
            @android.support.annotation.Keep
            public native void shutDown();
        }

        @android.support.annotation.Keep
        public static native com.bun.lib.c a(android.os.IBinder iBinder);
    }

    @android.support.annotation.Keep
    boolean c();

    @android.support.annotation.Keep
    java.lang.String getAAID();

    @android.support.annotation.Keep
    java.lang.String getOAID();

    @android.support.annotation.Keep
    java.lang.String getVAID();

    @android.support.annotation.Keep
    boolean isSupported();

    @android.support.annotation.Keep
    void shutDown();
}
