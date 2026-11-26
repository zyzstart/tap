package android.support.v4.provider;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(19)
class SingleDocumentFile extends android.support.v4.provider.DocumentFile {
    private android.content.Context mContext;
    private android.net.Uri mUri;

    SingleDocumentFile(android.support.v4.provider.DocumentFile documentFile, android.content.Context context, android.net.Uri uri) {
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
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // android.support.v4.provider.DocumentFile
    public android.support.v4.provider.DocumentFile createFile(java.lang.String str, java.lang.String str2) {
        throw new java.lang.UnsupportedOperationException();
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
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean renameTo(java.lang.String str) {
        throw new java.lang.UnsupportedOperationException();
    }
}
