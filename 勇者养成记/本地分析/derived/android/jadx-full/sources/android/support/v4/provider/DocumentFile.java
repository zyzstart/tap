package android.support.v4.provider;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class DocumentFile {
    static final java.lang.String TAG = "DocumentFile";
    private final android.support.v4.provider.DocumentFile mParent;

    DocumentFile(android.support.v4.provider.DocumentFile documentFile) {
        this.mParent = documentFile;
    }

    public static android.support.v4.provider.DocumentFile fromFile(java.io.File file) {
        return new android.support.v4.provider.RawDocumentFile(null, file);
    }

    public static android.support.v4.provider.DocumentFile fromSingleUri(android.content.Context context, android.net.Uri uri) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return new android.support.v4.provider.SingleDocumentFile(null, context, uri);
        }
        return null;
    }

    public static android.support.v4.provider.DocumentFile fromTreeUri(android.content.Context context, android.net.Uri uri) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return new android.support.v4.provider.TreeDocumentFile(null, context, android.support.v4.provider.DocumentsContractApi21.prepareTreeUri(uri));
        }
        return null;
    }

    public static boolean isDocumentUri(android.content.Context context, android.net.Uri uri) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return android.support.v4.provider.DocumentsContractApi19.isDocumentUri(context, uri);
        }
        return false;
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract android.support.v4.provider.DocumentFile createDirectory(java.lang.String str);

    public abstract android.support.v4.provider.DocumentFile createFile(java.lang.String str, java.lang.String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    public android.support.v4.provider.DocumentFile findFile(java.lang.String str) {
        for (android.support.v4.provider.DocumentFile documentFile : listFiles()) {
            if (str.equals(documentFile.getName())) {
                return documentFile;
            }
        }
        return null;
    }

    public abstract java.lang.String getName();

    public android.support.v4.provider.DocumentFile getParentFile() {
        return this.mParent;
    }

    public abstract java.lang.String getType();

    public abstract android.net.Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract android.support.v4.provider.DocumentFile[] listFiles();

    public abstract boolean renameTo(java.lang.String str);
}
