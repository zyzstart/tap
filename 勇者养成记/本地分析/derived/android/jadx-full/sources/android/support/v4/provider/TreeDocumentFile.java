package android.support.v4.provider;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(21)
class TreeDocumentFile extends android.support.v4.provider.DocumentFile {
    private android.content.Context mContext;
    private android.net.Uri mUri;

    TreeDocumentFile(android.support.v4.provider.DocumentFile documentFile, android.content.Context context, android.net.Uri uri) {
        super(documentFile);
        this.mContext = context;
        this.mUri = uri;
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean canRead() {
        return android.support.v4.provider.DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean canWrite() {
        return android.support.v4.provider.DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public android.support.v4.provider.DocumentFile createDirectory(java.lang.String str) {
        android.net.Uri uriCreateDirectory = android.support.v4.provider.DocumentsContractApi21.createDirectory(this.mContext, this.mUri, str);
        if (uriCreateDirectory != null) {
            return new android.support.v4.provider.TreeDocumentFile(this, this.mContext, uriCreateDirectory);
        }
        return null;
    }

    @Override // android.support.v4.provider.DocumentFile
    public android.support.v4.provider.DocumentFile createFile(java.lang.String str, java.lang.String str2) {
        android.net.Uri uriCreateFile = android.support.v4.provider.DocumentsContractApi21.createFile(this.mContext, this.mUri, str, str2);
        if (uriCreateFile != null) {
            return new android.support.v4.provider.TreeDocumentFile(this, this.mContext, uriCreateFile);
        }
        return null;
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean delete() {
        return android.support.v4.provider.DocumentsContractApi19.delete(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean exists() {
        return android.support.v4.provider.DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public java.lang.String getName() {
        return android.support.v4.provider.DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public java.lang.String getType() {
        return android.support.v4.provider.DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public android.net.Uri getUri() {
        return this.mUri;
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isDirectory() {
        return android.support.v4.provider.DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isFile() {
        return android.support.v4.provider.DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isVirtual() {
        return android.support.v4.provider.DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public long lastModified() {
        return android.support.v4.provider.DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public long length() {
        return android.support.v4.provider.DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public android.support.v4.provider.DocumentFile[] listFiles() {
        android.net.Uri[] uriArrListFiles = android.support.v4.provider.DocumentsContractApi21.listFiles(this.mContext, this.mUri);
        android.support.v4.provider.DocumentFile[] documentFileArr = new android.support.v4.provider.DocumentFile[uriArrListFiles.length];
        for (int i = 0; i < uriArrListFiles.length; i++) {
            documentFileArr[i] = new android.support.v4.provider.TreeDocumentFile(this, this.mContext, uriArrListFiles[i]);
        }
        return documentFileArr;
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean renameTo(java.lang.String str) {
        android.net.Uri uriRenameTo = android.support.v4.provider.DocumentsContractApi21.renameTo(this.mContext, this.mUri, str);
        if (uriRenameTo == null) {
            return false;
        }
        this.mUri = uriRenameTo;
        return true;
    }
}
