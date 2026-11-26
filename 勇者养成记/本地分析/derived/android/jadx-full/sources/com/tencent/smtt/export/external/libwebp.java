package com.tencent.smtt.export.external;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class libwebp {
    private static final int BITMAP_ALPHA_8 = 1;
    private static final int BITMAP_ARGB_4444 = 3;
    private static final int BITMAP_ARGB_8888 = 4;
    private static final int BITMAP_RGB_565 = 2;
    private static final java.lang.String LOGTAG = "[image]";
    private static boolean isMultiCore = false;
    private static com.tencent.smtt.export.external.libwebp mInstance = null;
    private static boolean mIsLoadLibSuccess = false;
    private int mBitmapType = 4;

    /* JADX INFO: renamed from: com.tencent.smtt.export.external.libwebp$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[android.graphics.Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static int checkIsHuaModel() {
        java.lang.String lowerCase = android.os.Build.BRAND.trim().toLowerCase();
        java.lang.String lowerCase2 = android.os.Build.MODEL.trim().toLowerCase();
        int i = (lowerCase == null || lowerCase.length() <= 0 || !lowerCase.contains("huawei")) ? 0 : 1;
        if (lowerCase2 == null || lowerCase2.length() <= 0 || !lowerCase2.contains("huawei")) {
            return i;
        }
        return 1;
    }

    private java.lang.String getCPUinfo() {
        java.lang.String str = "";
        try {
            java.io.InputStream inputStream = new java.lang.ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start().getInputStream();
            byte[] bArr = new byte[1024];
            while (inputStream.read(bArr) != -1) {
                str = str + new java.lang.String(bArr);
            }
            inputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static com.tencent.smtt.export.external.libwebp getInstance(android.content.Context context) {
        if (mInstance == null) {
            loadWepLibraryIfNeed(context);
            mInstance = new com.tencent.smtt.export.external.libwebp();
        }
        return mInstance;
    }

    private boolean isMultiCore() {
        return getCPUinfo().contains("processor");
    }

    public static void loadWepLibraryIfNeed(android.content.Context context) {
        if (mIsLoadLibSuccess) {
            return;
        }
        try {
            com.tencent.smtt.export.external.LibraryLoader.loadLibrary(context, "webp_base");
            mIsLoadLibSuccess = true;
        } catch (java.lang.UnsatisfiedLinkError unused) {
            android.util.Log.e(LOGTAG, "Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()");
        }
    }

    public static void loadWepLibraryIfNeed(android.content.Context context, java.lang.String str) {
        if (mIsLoadLibSuccess) {
            return;
        }
        try {
            java.lang.System.load(str + java.io.File.separator + "libwebp_base.so");
            mIsLoadLibSuccess = true;
        } catch (java.lang.UnsatisfiedLinkError unused) {
            android.util.Log.e(LOGTAG, "Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()");
        }
    }

    public int[] decodeBase(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeDecode(bArr, isMultiCore, iArr, iArr2);
        }
        android.util.Log.e(LOGTAG, "Load WebP Library Error...");
        return null;
    }

    public int[] decodeBase_16bit(byte[] bArr, android.graphics.Bitmap.Config config) {
        if (mIsLoadLibSuccess) {
            this.mBitmapType = com.tencent.smtt.export.external.libwebp.AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()] != 1 ? 2 : 3;
            return nativeDecode_16bit(bArr, isMultiCore, this.mBitmapType);
        }
        android.util.Log.e(LOGTAG, "Load WebP Library Error...");
        return null;
    }

    public int[] decodeInto(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeDecodeInto(bArr, isMultiCore, iArr, iArr2);
        }
        android.util.Log.e(LOGTAG, "Load WebP Library Error...");
        return null;
    }

    public int getInfo(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeGetInfo(bArr, iArr, iArr2);
        }
        return 0;
    }

    public int[] incDecode(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeIDecode(bArr, isMultiCore, iArr, iArr2);
        }
        android.util.Log.e(LOGTAG, "Load WebP Library Error...");
        return null;
    }

    public native int[] nativeDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecodeInto(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecode_16bit(byte[] bArr, boolean z, int i);

    public native int nativeGetInfo(byte[] bArr, int[] iArr, int[] iArr2);

    public native int[] nativeIDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);
}
