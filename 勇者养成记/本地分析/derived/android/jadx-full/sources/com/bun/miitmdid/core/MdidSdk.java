package com.bun.miitmdid.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class MdidSdk implements com.bun.supplier.SupplierListener {

    @android.support.annotation.Keep
    private com.bun.supplier.IIdentifierListener _InnerListener;

    @android.support.annotation.Keep
    private com.bun.miitmdid.a.b _setting;

    @android.support.annotation.Keep
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @android.support.annotation.Keep
        static final /* synthetic */ int[] f45a = new int[com.bun.miitmdid.c.a.values().length];

        static {
            try {
                f45a[com.bun.miitmdid.c.a.XIAOMI.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.BLACKSHARK.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.VIVO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.HUA_WEI.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.OPPO.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.ONEPLUS.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.MOTO.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.LENOVO.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.ASUS.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.SAMSUNG.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.MEIZU.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.NUBIA.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.ZTE.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.FREEMEOS.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                f45a[com.bun.miitmdid.c.a.SSUIOS.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
        }
    }

    @android.support.annotation.Keep
    public MdidSdk() {
        try {
            com.bun.lib.a.a(true);
        } catch (java.lang.Exception e) {
            com.bun.lib.a.b("mdidsdk", "extractor exception!", e);
        }
    }

    @android.support.annotation.Keep
    public MdidSdk(boolean z) {
        try {
            com.bun.lib.a.a(z);
        } catch (java.lang.Exception e) {
            com.bun.lib.a.b("mdidsdk", "extractor exception!", e);
        }
    }

    @android.support.annotation.Keep
    private native int _InnerFailed(int i, com.bun.supplier.IdSupplier idSupplier);

    @android.support.annotation.Keep
    public native int InitSdk(android.content.Context context, com.bun.supplier.IIdentifierListener iIdentifierListener);

    @Override // com.bun.supplier.SupplierListener
    @android.support.annotation.Keep
    public native void OnSupport(boolean z, com.bun.supplier.IdSupplier idSupplier);

    @android.support.annotation.Keep
    public native void UnInitSdk();
}
