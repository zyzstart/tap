package android.support.v4.provider;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class RawDocumentFile extends android.support.v4.provider.DocumentFile {
    private java.io.File mFile;

    RawDocumentFile(android.support.v4.provider.DocumentFile documentFile, java.io.File file) {
        super(documentFile);
        this.mFile = file;
    }

    private static boolean deleteContents(java.io.File file) {
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return true;
        }
        boolean zDeleteContents = true;
        for (java.io.File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                zDeleteContents &= deleteContents(file2);
            }
            if (!file2.delete()) {
                android.util.Log.w("DocumentFile", "Failed to delete " + file2);
                zDeleteContents = false;
            }
        }
        return zDeleteContents;
    }

    private static java.lang.String getTypeForName(java.lang.String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        java.lang.String mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(iLastIndexOf + 1).toLowerCase());
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean canRead() {
        return this.mFile.canRead();
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    @Override // android.support.v4.provider.DocumentFile
    public android.support.v4.provider.DocumentFile createDirectory(java.lang.String str) {
        java.io.File file = new java.io.File(this.mFile, str);
        if (file.isDirectory() || file.mkdir()) {
            return new android.support.v4.provider.RawDocumentFile(this, file);
        }
        return null;
    }

    @Override // android.support.v4.provider.DocumentFile
    public android.support.v4.provider.DocumentFile createFile(java.lang.String str, java.lang.String str2) {
        java.lang.String extensionFromMimeType = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + "." + extensionFromMimeType;
        }
        java.io.File file = new java.io.File(this.mFile, str2);
        try {
            file.createNewFile();
            return new android.support.v4.provider.RawDocumentFile(this, file);
        } catch (java.io.IOException e) {
            android.util.Log.w("DocumentFile", "Failed to createFile: " + e);
            return null;
        }
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean delete() {
        deleteContents(this.mFile);
        return this.mFile.delete();
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean exists() {
        return this.mFile.exists();
    }

    @Override // android.support.v4.provider.DocumentFile
    public java.lang.String getName() {
        return this.mFile.getName();
    }

    @Override // android.support.v4.provider.DocumentFile
    public java.lang.String getType() {
        if (this.mFile.isDirectory()) {
            return null;
        }
        return getTypeForName(this.mFile.getName());
    }

    @Override // android.support.v4.provider.DocumentFile
    public android.net.Uri getUri() {
        return android.net.Uri.fromFile(this.mFile);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isFile() {
        return this.mFile.isFile();
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isVirtual() {
        return false;
    }

    @Override // android.support.v4.provider.DocumentFile
    public long lastModified() {
        return this.mFile.lastModified();
    }

    @Override // android.support.v4.provider.DocumentFile
    public long length() {
        return this.mFile.length();
    }

    @Override // android.support.v4.provider.DocumentFile
    public android.support.v4.provider.DocumentFile[] listFiles() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.File[] fileArrListFiles = this.mFile.listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file : fileArrListFiles) {
                arrayList.add(new android.support.v4.provider.RawDocumentFile(this, file));
            }
        }
        return (android.support.v4.provider.DocumentFile[]) arrayList.toArray(new android.support.v4.provider.DocumentFile[arrayList.size()]);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean renameTo(java.lang.String str) {
        java.io.File file = new java.io.File(this.mFile.getParentFile(), str);
        if (!this.mFile.renameTo(file)) {
            return false;
        }
        this.mFile = file;
        return true;
    }
}
