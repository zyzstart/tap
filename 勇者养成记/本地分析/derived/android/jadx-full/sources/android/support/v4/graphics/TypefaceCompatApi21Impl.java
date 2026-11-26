package android.support.v4.graphics;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(21)
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class TypefaceCompatApi21Impl extends android.support.v4.graphics.TypefaceCompatBaseImpl {
    private static final java.lang.String TAG = "TypefaceCompatApi21Impl";

    TypefaceCompatApi21Impl() {
    }

    private java.io.File getFile(android.os.ParcelFileDescriptor parcelFileDescriptor) {
        try {
            java.lang.String str = android.system.Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (android.system.OsConstants.S_ISREG(android.system.Os.stat(str).st_mode)) {
                return new java.io.File(str);
            }
            return null;
        } catch (android.system.ErrnoException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0054 A[Catch: all -> 0x0058, Throwable -> 0x005b, TRY_ENTER, TryCatch #0 {Throwable -> 0x005b, blocks: (B:7:0x0018, B:9:0x001e, B:12:0x0025, B:16:0x002f, B:18:0x003c, B:31:0x0054, B:32:0x0057), top: B:48:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0069 A[Catch: IOException -> 0x006d, TRY_ENTER, TryCatch #6 {IOException -> 0x006d, blocks: (B:6:0x000e, B:14:0x002b, B:20:0x0041, B:41:0x0065, B:43:0x0069, B:44:0x006c), top: B:55:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:? A[Catch: IOException -> 0x006d, SYNTHETIC, TRY_LEAVE, TryCatch #6 {IOException -> 0x006d, blocks: (B:6:0x000e, B:14:0x002b, B:20:0x0041, B:41:0x0065, B:43:0x0069, B:44:0x006c), top: B:55:0x000e }] */
    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    public android.graphics.Typeface createFromFontInfo(android.content.Context context, android.os.CancellationSignal cancellationSignal, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.lang.Throwable th2;
        java.lang.Throwable th3;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo(fontInfoArr, i).getUri(), "r", cancellationSignal);
            try {
                try {
                    java.io.File file = getFile(parcelFileDescriptorOpenFileDescriptor);
                    if (file != null && file.canRead()) {
                        android.graphics.Typeface typefaceCreateFromFile = android.graphics.Typeface.createFromFile(file);
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        return typefaceCreateFromFile;
                    }
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        android.graphics.Typeface typefaceCreateFromInputStream = super.createFromInputStream(context, fileInputStream);
                        fileInputStream.close();
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        return typefaceCreateFromInputStream;
                    } catch (java.lang.Throwable th4) {
                        try {
                            throw th4;
                        } catch (java.lang.Throwable th5) {
                            th2 = th4;
                            th3 = th5;
                            if (th2 == null) {
                                fileInputStream.close();
                                throw th3;
                            }
                            fileInputStream.close();
                            throw th3;
                        }
                    }
                } catch (java.lang.Throwable th6) {
                    try {
                        throw th6;
                    } catch (java.lang.Throwable th7) {
                        th = th6;
                        th = th7;
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            throw th;
                        }
                        if (th == null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                            throw th;
                        }
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                            throw th;
                        } catch (java.lang.Throwable unused) {
                            throw th;
                        }
                    }
                }
            } catch (java.lang.Throwable th8) {
                th = th8;
                th = null;
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    throw th;
                }
                if (th == null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    throw th;
                }
                parcelFileDescriptorOpenFileDescriptor.close();
                throw th;
            }
        } catch (java.io.IOException unused2) {
            return null;
        }
    }
}
