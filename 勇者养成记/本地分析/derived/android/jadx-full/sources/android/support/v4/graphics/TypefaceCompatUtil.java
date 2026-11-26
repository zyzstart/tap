package android.support.v4.graphics;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatUtil {
    private static final java.lang.String CACHE_FILE_PREFIX = ".font";
    private static final java.lang.String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    public static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    @android.support.annotation.RequiresApi(19)
    public static java.nio.ByteBuffer copyToDirectBuffer(android.content.Context context, android.content.res.Resources resources, int i) {
        java.io.File tempFile = getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (copyToFile(tempFile, resources, i)) {
                return mmap(tempFile);
            }
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public static boolean copyToFile(java.io.File file, android.content.res.Resources resources, int i) throws java.lang.Throwable {
        java.io.InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            try {
                boolean zCopyToFile = copyToFile(file, inputStreamOpenRawResource);
                closeQuietly(inputStreamOpenRawResource);
                return zCopyToFile;
            } catch (java.lang.Throwable th) {
                th = th;
                closeQuietly(inputStreamOpenRawResource);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean copyToFile(java.io.File file, java.io.InputStream inputStream) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            closeQuietly(fileOutputStream2);
                            return true;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                } catch (java.io.IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    android.util.Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e2) {
            e = e2;
        }
    }

    public static java.io.File getTempFile(android.content.Context context) {
        java.lang.String str = CACHE_FILE_PREFIX + android.os.Process.myPid() + "-" + android.os.Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            java.io.File file = new java.io.File(context.getCacheDir(), str + i);
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (java.io.IOException unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003c A[Catch: all -> 0x0040, Throwable -> 0x0043, TRY_ENTER, TryCatch #0 {all -> 0x0040, blocks: (B:4:0x000b, B:6:0x0024, B:17:0x0038, B:19:0x003c, B:20:0x003f), top: B:36:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:28:0x004b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0051 A[Catch: IOException -> 0x0055, TRY_ENTER, TryCatch #3 {IOException -> 0x0055, blocks: (B:3:0x0005, B:8:0x0029, B:29:0x004d, B:31:0x0051, B:32:0x0054), top: B:41:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:? A[Catch: IOException -> 0x0055, SYNTHETIC, TRY_LEAVE, TryCatch #3 {IOException -> 0x0055, blocks: (B:3:0x0005, B:8:0x0029, B:29:0x004d, B:31:0x0051, B:32:0x0054), top: B:41:0x0005 }] */
    @android.support.annotation.RequiresApi(19)
    public static java.nio.ByteBuffer mmap(android.content.Context context, android.os.CancellationSignal cancellationSignal, android.net.Uri uri) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.lang.Throwable th2;
        java.lang.Throwable th3;
        try {
            android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            try {
                try {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        java.nio.channels.FileChannel channel = fileInputStream.getChannel();
                        java.nio.MappedByteBuffer map = channel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                        fileInputStream.close();
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        return map;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        th3 = null;
                        if (th3 == null) {
                            fileInputStream.close();
                            throw th;
                        }
                        fileInputStream.close();
                        throw th;
                    }
                } catch (java.lang.Throwable th5) {
                    th2 = th5;
                    th = null;
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        throw th2;
                    }
                    if (th == null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        throw th2;
                    }
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        throw th2;
                    } catch (java.lang.Throwable unused) {
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th6) {
                try {
                    throw th6;
                } catch (java.lang.Throwable th7) {
                    th = th6;
                    th2 = th7;
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        throw th2;
                    }
                    if (th == null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        throw th2;
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                    throw th2;
                }
            }
        } catch (java.io.IOException unused2) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0029 A[Catch: IOException -> 0x002d, TRY_ENTER, TryCatch #3 {IOException -> 0x002d, blocks: (B:3:0x0001, B:5:0x0016, B:14:0x0025, B:16:0x0029, B:17:0x002c), top: B:22:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.support.annotation.RequiresApi(19)
    private static java.nio.ByteBuffer mmap(java.io.File file) throws java.lang.Throwable {
        java.lang.Throwable th;
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            try {
                java.nio.channels.FileChannel channel = fileInputStream.getChannel();
                java.nio.MappedByteBuffer map = channel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                return map;
            } catch (java.lang.Throwable th2) {
                th = th2;
                th = null;
                if (th == null) {
                    fileInputStream.close();
                    throw th;
                }
                fileInputStream.close();
                throw th;
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }
}
